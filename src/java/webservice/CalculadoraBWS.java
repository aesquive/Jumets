/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webservice;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import objetos.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.DocumentFragment;

/**
 *
 * @author Hades
 */
@WebService()
public class CalculadoraBWS {
    static String xmlVacioExpt = "Estructura de Xml Vacia";
    static String xmlExpt = "Estructura de Xml con Error";
    static String tabNoEncontradoExpt = "Tab No encontrado: ";
    static String tabVacioExpt = "Valor Tab Vacio: ";
    static String accesoDatosExpt = "Ocurrio un error en acceso a Datos";
    static String datosErrorExpt = "Valor Tab debe ser superior a 0:";
    static String meses[] = {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OBTUBRE","NOBIEMBRE","DICIEMBRE"};
    static String ErrorEdadExpt = "Edad Invalida";
    static String ErrorFechaExpt = "Fecha Invalida";
    String clasificacion1 = "";
    String clasificacion2= "";
    String clasificacion3= "";
    String clasificacion4= "";
    String ACCION = "";
    String ACCION2= "";
    String SCORE_CONDICIONADO_DE_RIESGO_BAJO;
    String SCORE_CONDICIONADO_DE_RIESGO_MEDIO;
    String SCORE_CONDICIONADO_DE_RIESGO_ALTO;
    List clientes = new  ArrayList();
    List<Double> med_ingresos = new  ArrayList();
    List<Double> med_valviv = new  ArrayList();
    List<Double> med_mensualidad = new  ArrayList();
    List por_calcular = new ArrayList();
    List bien_calcular = new ArrayList();
    List cppr_rec_arr = new ArrayList();
    double PI2 = 0;
    // calcula medianas
    double m_ingreso = 0;
    double m_mensualidad = 0;
    double m_val_viv = 0;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CalculaB")


    public String CalculaB(@WebParam(name = "xml")String xml) {

        String xmlString = "";
      try
      {

        if(xml == null)
          return xmlVacioExpt;
         //   System.out.println(xml);

        leeArchivo(xml);
        //Datos de salida
        bienformados(clientes);

        iniciacalculo();
        aplicamedianas(clientes);

        Session s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.beginTransaction();

        calculacompletos(s, clientes);

        calculaincompleta(s, clientes);

        xmlString = imprimereporte();



        return xmlString;
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return e.getMessage();
    }

        }


     private String GetValue(NodeList listaNodos,String nodo) throws Exception
    {
        for (int i = 0; i < listaNodos.getLength(); i++) {
            if(listaNodos.item(i).getNodeName().equals(nodo))
                if(listaNodos.item(i).getTextContent()!= null)
                    return listaNodos.item(i).getTextContent();
                else
                    throw new Exception(tabVacioExpt + nodo);
        }
       throw new Exception(tabNoEncontradoExpt + nodo);
    }

    private void ordena(double[] arregloDes, String[] arregloTex){
        for(int i=0;i< arregloDes.length-1;i++)
          for(int j=i+1;j< arregloDes.length;j++)
            if (arregloDes[i]<arregloDes[j]){
              double tempD = arregloDes[i];
              arregloDes[i] = arregloDes[j];
              arregloDes[j] = tempD;
              String tempS = arregloTex[i];
              arregloTex[i] = arregloTex[j];
              arregloTex[j] = tempS;
            }
      }


    private int GetValueInt(NodeList listaNodos,String nodo) throws Exception
    {
        for (int i = 0; i < listaNodos.getLength(); i++) {
            if(listaNodos.item(i).getNodeName().equals(nodo))
                if(!listaNodos.item(i).getTextContent().equals(""))
                    return Integer.parseInt(listaNodos.item(i).getTextContent());
                 else
                    return 0;
                 //   throw new Exception(tabVacioExpt + nodo);
        }
       throw new Exception(tabNoEncontradoExpt + nodo);
    }

    private void AgregarNodo(Element raiz, Document doc, String tab, String valor) {
        Element child = doc.createElement(tab);
        Text text = doc.createTextNode(String.valueOf(valor));
        child.appendChild(text);
        raiz.appendChild(child);
    }

   private boolean validaFecha(String fecha) {
        for(int i=0;i<12;i++)
            if(meses[i].equals(fecha))
                return true;
        return false;
    }

    private int posFecha(String fecha) {
        for(int i=0;i<12;i++)
            if(meses[i].equals(fecha))
                return i+1;
        return -1;
    }

    private double GetValueDouble(NodeList listaNodos,String nodo) throws Exception
    {
         for (int i = 0; i < listaNodos.getLength(); i++) {
            if(listaNodos.item(i).getNodeName().equals(nodo))
                if(!listaNodos.item(i).getTextContent().equals(""))
                    return Double.parseDouble(listaNodos.item(i).getTextContent());
                 else
                    throw new Exception(tabVacioExpt + nodo);
        }
       throw new Exception(tabNoEncontradoExpt + nodo);
    }

    private Vector GetValueNumero(NodeList listaNodos, String campo) throws Exception {
        Vector arreglo = new Vector();
        for (int i = 0; i < listaNodos.getLength(); i++) {
            if(listaNodos.item(i).getNodeName().equals("PAGOS")){
                NodeList subNodos = listaNodos.item(i).getChildNodes();
                for (int j = 0; j < subNodos.getLength(); j++)
                    if(subNodos.item(j).getNodeName().equals("PAGO_ID")){
                        NodeList subNodos1 = subNodos.item(j).getChildNodes();
                        if(subNodos1.item(0).getNodeName().equals("NUMERO"))
                             arreglo.add(subNodos1.item(0).getTextContent());
                        else
                            throw new Exception(tabVacioExpt + campo);
                    }
            }
        }
        return arreglo;
    }

    private Vector GetValuePago(NodeList listaNodos, String campo) throws Exception {
        Vector arreglo  = new Vector();
        for (int i = 0; i < listaNodos.getLength(); i++) {
            if(listaNodos.item(i).getNodeName().equals("PAGOS")){
                NodeList subNodos = listaNodos.item(i).getChildNodes();
                for (int j = 0; j < subNodos.getLength(); j++){

                      if(subNodos.item(j).getNodeName().equals("PAGO_ID")){



                        NodeList subNodos1 = subNodos.item(j).getChildNodes();

                        if(subNodos1.item(1).getNodeName().equals("MONTO")){


                             arreglo.add(Double.parseDouble(subNodos1.item(1).getTextContent()));
                        } else
                            throw new Exception(tabVacioExpt + campo);
                    }
                }
            }
        }
        return arreglo;
    }

      private Element Fragmenttree(
                                  Document doc,
                                  String acliID,
                                  String acliSAP,
                                  String aclas1,
                                  String aclas2,
                                  String aclas3,
                                  String aaac1,
                                  String aaac2) {
    Element cliID = doc.createElement("CLI_ID");
    Text text = doc.createTextNode(acliID);
    cliID.appendChild(text);

    Element cliSAP = doc.createElement("CLI_SAP");
    text = doc.createTextNode(acliSAP);
    cliSAP.appendChild(text);

    Element clas1 = doc.createElement("CLASIFICACION_1");
    text = doc.createTextNode(aclas1);
    clas1.appendChild(text);

    Element clas2 = doc.createElement("CLASIFICACION_2");
    text = doc.createTextNode(aclas2);
    clas2.appendChild(text);

    Element clas3 = doc.createElement("CLASIFICACION_3");
    text = doc.createTextNode(aclas3);
    clas3.appendChild(text);

    Element acc1 = doc.createElement("ACCION_1");
    text = doc.createTextNode(aaac1);
    acc1.appendChild(text);

    Element acc2 = doc.createElement("ACCION_2");
    text = doc.createTextNode(aaac2);
    acc2.appendChild(text);


    Element cliente = doc.createElement("CLIENTE");
    cliente.appendChild(cliID);
    cliente.appendChild(cliSAP);
    cliente.appendChild(clas1);
    cliente.appendChild(clas2);
    cliente.appendChild(clas3);
    cliente.appendChild(acc1);
    cliente.appendChild(acc2);
    return (cliente);

    }

    public static double median(double[] m) {
    int middle = m.length/2;  // subscript of middle element
    if (m.length%2 == 1) {
        // Odd number of elements -- return the middle one.
        return m[middle];
    } else {
       // Even number -- return average of middle two
       // Must cast the numbers to double before dividing.
       return (m[middle-1] + m[middle]) / 2.0;
    }
}//end method median



    private void calculacompletos(Session s, List clientes)
    {
           for( int k =0; k < bien_calcular.size(); k++)
           {

            int i =Integer.parseInt(bien_calcular.get(k).toString());
                                        double cpr_rec = calculo_CPR(s,
                                                ((Cliente)clientes.get(i)).getEstado(),
                                                ((Cliente)clientes.get(i)).getEdad(),
                                                ((Cliente)clientes.get(i)).getOcupacion(),
                                                ((Cliente)clientes.get(i)).getFecha());

/*
                                       calculaPromedios(
                                               ((Cliente)clientes.get(i)).getEstado(),
                                               cpr_rec);
*/

                                       double mens_ing = ((Cliente)clientes.get(i)).getMensualidad()/ ((Cliente)clientes.get(i)).getIngresos() ;

                                       double ingreso_Viv = ((Cliente)clientes.get(i)).getIngresos() /  ((Cliente)clientes.get(i)).getValorVienda();

                                       double eficiencia = obtenerEficiencia(((Cliente)clientes.get(i)).getPago(),((Cliente)clientes.get(i)).getMensualidad());

  


                                       int pagos_bien = pagos_bien(((Cliente)clientes.get(i)).getMensualidad(), ((Cliente)clientes.get(i)).getPago());

                                       int pagos_mal = pagos_mal(((Cliente)clientes.get(i)).getMensualidad(), ((Cliente)clientes.get(i)).getPago());



                                      double PI1 = calculaBhr1(s,
                                                cpr_rec,
                                                mens_ing,
                                                ingreso_Viv,
                                                eficiencia,
                                                ((Cliente)clientes.get(i)).getPago(),
                                                ((Cliente)clientes.get(i)).getMensualidad(),
                                                pagos_bien,
                                                pagos_mal);


                                        if (PI1 <= .5)
                                        {

                                            calculaBhr2(s,
                                                    cpr_rec,
                                                    mens_ing,
                                                    ingreso_Viv,
                                                    eficiencia,
                                                    pagos_bien,
                                                    pagos_mal );



                                        } else if(PI1 > .5 && PI1 <= .75)
                                        {


                                            calculaBhr3(s,
                                                    cpr_rec,
                                                    mens_ing,
                                                    ingreso_Viv,
                                                    eficiencia,
                                                    pagos_bien,
                                                    pagos_mal );



                                       } else if(  PI1 > .75 && PI1 <= 1)

                                       {

                                           calculaBhr4(s,
                                                    cpr_rec,
                                                    mens_ing,
                                                    ingreso_Viv,
                                                    eficiencia,
                                                    pagos_bien,
                                                    pagos_mal );

                                       }




                                        ACCION= "";
                                        if(pagos_bien == 0 ){
                                            if( PI1 <= .25)
                                                ACCION = "SIN GESTION";
                                            else if(PI1 > .25 && PI1 <= .5)
                                                ACCION = "LLAMADA AMIGABLE";
                                            else if(PI1 > .5 && PI1 <= 1)
                                                ACCION = "VISITA DE COBRO";
                                        }
                                        else if (pagos_bien > 0 && pagos_bien <= 1){
                                            if( PI1 <= .25)
                                                ACCION = "VISITA DE COBRO";
                                            else if(PI1 > .25 && PI1 <= .5)
                                                ACCION = "COBRANZA INTESIVA";
                                            else if(PI1 > .5 && PI1 <= .75)
                                                ACCION = "COBRANZA AGRESIVA";
                                            else if(PI1 > .75 && PI1 <= 1)
                                                ACCION = "DESALOJO";
                                        }else if (pagos_bien > 1){
                                            if( PI1 <= .25)
                                                ACCION = "COBRANZA INTENSIVA";
                                            else if(PI1 > .25 && PI1 <= .5)
                                                ACCION = "COBRANZA AGRESIVA";
                                            else if(PI1 > .5 && PI1 <= 1)
                                                ACCION = "DESALOJO";
                                        }


                                                ((Cliente)clientes.get(i)).setClasificacion1(clasificacion1);
                                                ((Cliente)clientes.get(i)).setClasificacion2(clasificacion2);
                                                ((Cliente)clientes.get(i)).setClasificacion3(clasificacion3);
                                                ((Cliente)clientes.get(i)).setAccion(ACCION);
                                                ((Cliente)clientes.get(i)).setAccion2(ACCION2);



                                            System.out.println(Integer.toString(((Cliente)clientes.get(i)).getcliId()));
                                            System.out.println(Integer.toString(((Cliente)clientes.get(i)).getcliSap()));
                                            System.out.println(clasificacion1);
                                            System.out.println(clasificacion2);
                                            System.out.println(clasificacion3);
                                            System.out.println(ACCION);
                                            System.out.println(ACCION2);



            } //fin del for




    }




    private void calculaincompleta(Session s, List clientes)
    {

        try {
    //No calculados falta de ppr
            for (int k=0; k < por_calcular.size() ; k++ )
            {
                       int  i = Integer.parseInt(por_calcular.get(k).toString());
                       int  estado = ((Cliente)clientes.get(i)).getEstado();
                       int  fecha = ((Cliente)clientes.get(i)).getFecha();
                       double cpr_rec = 0;
                       double PI = 0;

                        for (int j =0; j < cppr_rec_arr.size() ; j++)
                        {
                            if (((Prom_estado)cppr_rec_arr.get(j)).getEstado() == estado)
                            {
                                PI  = ((Prom_estado)cppr_rec_arr.get(j)).getPromedio();
                                break;
                            }
                        }

                        Query q = s.createQuery("from Edo as edo where edo.cal = '1'");
                        List lista = (List) q.list();
                        double recargo = ((Edo)lista.get(estado-1)).getEdoRcg();

                        q = s.createQuery("from IntPi as ip where ip.cal = '6' and ip.intPiLimInf<="+PI+" and ip.intPiLimSup>="+PI);
                        lista = (List) q.list();
                        String clasificacion = ((IntPi)lista.get(0)).getIntPiDes();

                        q = s.createQuery("from FtrPpr as fp where fp.ftrPprCls='"+clasificacion+"' and fp.ftrPprMes="+fecha);
                        lista = (List) q.list();
                        double CPR = ((FtrPpr)lista.get(0)).getFtrPprFtr();

                        cpr_rec = CPR * (1 + recargo);



                       double mens_ing = ((Cliente)clientes.get(i)).getMensualidad()/ ((Cliente)clientes.get(i)).getValorVienda();

                       double ingreso_Viv = ((Cliente)clientes.get(i)).getIngresos() /  ((Cliente)clientes.get(i)).getValorVienda();

                       double eficiencia = obtenerEficiencia(((Cliente)clientes.get(i)).getPago(),((Cliente)clientes.get(i)).getMensualidad());

                       int pagos_bien = pagos_bien(((Cliente)clientes.get(i)).getMensualidad(), ((Cliente)clientes.get(i)).getPago());

                       int pagos_mal = pagos_mal(((Cliente)clientes.get(i)).getMensualidad(), ((Cliente)clientes.get(i)).getPago());


                       double PI1 = calculaBhr1(s,
                                cpr_rec,
                                mens_ing,
                                ingreso_Viv,
                                eficiencia,
                                ((Cliente)clientes.get(i)).getPago(),
                                ((Cliente)clientes.get(i)).getMensualidad(),
                                pagos_bien,
                                pagos_mal);


                        if (PI1 <= .5)
                        {

                            calculaBhr2(s,
                                    cpr_rec,
                                    mens_ing,
                                    ingreso_Viv,
                                    eficiencia,
                                    pagos_bien,
                                    pagos_mal );



                        } else if(PI1 > .5 && PI1 <= .75)
                        {


                            calculaBhr3(s,
                                    cpr_rec,
                                    mens_ing,
                                    ingreso_Viv,
                                    eficiencia,
                                    pagos_bien,
                                    pagos_mal );



                       } else if(  PI1 > .75 && PI1 <= 1)

                       {

                           calculaBhr4(s,
                                    cpr_rec,
                                    mens_ing,
                                    ingreso_Viv,
                                    eficiencia,
                                    pagos_bien,
                                    pagos_mal );

                       }







                                        ACCION= "";
                                        if(pagos_bien == 0 ){
                                            if( PI1 <= .25)
                                                ACCION = "SIN GESTION";
                                            else if(PI1 > .25 && PI1 <= .5)
                                                ACCION = "LLAMADA AMIGABLE";
                                            else if(PI1 > .5 && PI1 <= 1)
                                                ACCION = "VISITA DE COBRO";
                                        }
                                        else if (pagos_bien > 0 && pagos_bien <= 1){
                                            if( PI1 <= .25)
                                                ACCION = "VISITA DE COBRO";
                                            else if(PI1 > .25 && PI1 <= .5)
                                                ACCION = "COBRANZA INTESIVA";
                                            else if(PI1 > .5 && PI1 <= .75)
                                                ACCION = "COBRANZA AGRESIVA";
                                            else if(PI1 > .75 && PI1 <= 1)
                                                ACCION = "DESALOJO";
                                        }else if (pagos_bien > 1){
                                            if( PI1 <= .25)
                                                ACCION = "COBRANZA INTENSIVA";
                                            else if(PI1 > .25 && PI1 <= .5)
                                                ACCION = "COBRANZA AGRESIVA";
                                            else if(PI1 > .5 && PI1 <= 1)
                                                ACCION = "DESALOJO";
                                        }


                                                ((Cliente)clientes.get(i)).setClasificacion1(clasificacion1);
                                                ((Cliente)clientes.get(i)).setClasificacion2(clasificacion2);
                                                ((Cliente)clientes.get(i)).setClasificacion3(clasificacion3);
                                                ((Cliente)clientes.get(i)).setAccion(ACCION);
                                                ((Cliente)clientes.get(i)).setAccion2(ACCION2);
                                            System.out.println(Integer.toString(((Cliente)clientes.get(i)).getcliId()));
                                            System.out.println(Integer.toString(((Cliente)clientes.get(i)).getcliSap()));
                                            System.out.println(clasificacion1);
                                            System.out.println(clasificacion2);
                                            System.out.println(clasificacion3);
                                            System.out.println(ACCION);
                                            System.out.println(ACCION2);


            }


        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }



    }


    private String imprimereporte()
    {

        String xmlString = "";
        try{
                DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
                Document doc = docBuilder.newDocument();
                DocumentFragment fragment = doc.createDocumentFragment();
                Element raiz = doc.createElement("SalidaCalculadoraB");
                doc.appendChild(raiz);
                       for( int i =0; i < clientes.size(); i++)
                       {


                          Element person = Fragmenttree(
                                  doc,
                                    Integer.toString(((Cliente)clientes.get(i)).getcliId()),
                                    Integer.toString(((Cliente)clientes.get(i)).getcliSap()),
                                    ((Cliente)clientes.get(i)).getClasificacion1(),
                                    ((Cliente)clientes.get(i)).getClasificacion2(),
                                    ((Cliente)clientes.get(i)).getClasificacion3(),
                                    ((Cliente)clientes.get(i)).getAccion(),
                                    ((Cliente)clientes.get(i)).getAccion2());
                          fragment.appendChild(person);
                          raiz.appendChild(fragment);


                       }
                TransformerFactory transfac = TransformerFactory.newInstance();
                Transformer trans = transfac.newTransformer();
                trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                trans.setOutputProperty(OutputKeys.INDENT, "yes");

                StringWriter sw = new StringWriter();
                StreamResult result = new StreamResult(sw);
                DOMSource source = new DOMSource(doc);
                trans.transform(source, result);
                xmlString = sw.toString();


        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    return xmlString;

    }


    private void iniciacalculo()
    {



            Collections.sort(med_ingresos);
                Double[] d = med_ingresos.toArray(new Double[med_ingresos.size()]);
                double[] array_ingresos=new double [d.length];
                for (int i=0;i<d.length;i++) {
                    array_ingresos[i]=d[i];
                }
            Collections.sort(med_valviv);
                 d = med_valviv.toArray(new Double[med_valviv.size()]);
                 double[] array_valviv=new double [d.length];
                for (int i=0;i<d.length;i++) {
                    array_valviv[i]=d[i];
                }
            Collections.sort(med_mensualidad);
                 d = med_mensualidad.toArray(new Double[med_mensualidad.size()]);
                 double[] array_mensualidad=new double [d.length];
                for (int i=0;i<d.length;i++) {
                    array_mensualidad[i]=d[i];
                }

            if(array_ingresos.length > 0)
            {
            m_ingreso = median(array_ingresos);
            }
            if(array_mensualidad.length > 0)
            {
            m_mensualidad = median(array_mensualidad);
            }
            if(array_mensualidad.length > 0)
            {
            m_val_viv = median(array_valviv);
            }

    }


    private  void leeArchivo(String xml)
    {

        try {


            DateFormat df = new SimpleDateFormat ("MM");

            Matcher junkMatcher = (Pattern.compile("^([\\W]+)<"))
                              .matcher( xml.trim() );
            xml = junkMatcher.replaceFirst("<");
    //        junkMatcher = (Pattern.compile("(?:\r?\n|\r)")).matcher(xml.trim());
    //        xml = junkMatcher.replaceAll("");



            ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
            DocumentBuilderFactory dbfacIN = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilderIN = dbfacIN.newDocumentBuilder();
            Document docIN = docBuilderIN.parse(bais);

            if(docIN.getDocumentElement().getNodeName().equals("EntradaCalculadoraBHR"))
            {
                NodeList listaNodos = docIN.getDocumentElement().getChildNodes();

                for(int i=0; i<listaNodos.getLength(); i++)
                {
                    NodeList nodoCliente = listaNodos.item(i).getChildNodes();
                    int cliId = GetValueInt(nodoCliente, "CLI_ID");
                    int cliSap = GetValueInt(nodoCliente, "CLI_SAP");
                    int edad = GetValueInt(nodoCliente,"EDA_ID");
                    int estado = GetValueInt(nodoCliente,"EDO_ID");
                    int ocupacion = GetValueInt(nodoCliente,"OCP_ID");

                    int fecha = Integer.valueOf(GetValue(nodoCliente, "MES_ENTREGA_VIVIENDA"));

                    double ingresos = GetValueDouble(nodoCliente,"INGRESOS");
                    double mensualidad = GetValueDouble(nodoCliente,"MENSUALIDAD");
                    double valor_vivienda = GetValueDouble(nodoCliente,"VALOR_VIVIENDA");
                    List numero= GetValueNumero(nodoCliente, "NUMERO");
                    List pago = GetValuePago(nodoCliente, "PAGO");


                    if (ingresos != 0)
                    {
                        med_ingresos.add(ingresos);
                    }
                    if (valor_vivienda != 0)
                    {
                        med_valviv.add(valor_vivienda);
                    }
                    if (mensualidad != 0)
                    {
                        med_mensualidad.add(mensualidad);
                    }

                    clientes.add(new Cliente(cliId, cliSap,edad,estado,ocupacion,fecha,ingresos,mensualidad,valor_vivienda,numero,pago));
                   // System.out.println(i);
                }
            }



        } catch (Exception e) {

            String[] arreglo = xml.split("\n");

            for(int i = 0; i < arreglo.length; i++ )
            {
                String[] s = arreglo[i].split(",");

                    int cliId = 0;
                    int cliSap = Integer.parseInt(s[0]);
                    int edad = Integer.parseInt(s[2]);
                    int estado = Integer.parseInt(s[1]);
                    int ocupacion = Integer.parseInt(s[3]);
                    int fecha = Integer.valueOf((s[5].trim()).substring(3, 5));
                    double ingresos = Double.valueOf(s[4]);
                    double mensualidad = Double.valueOf(s[8]);
                    double valor_vivienda = Double.valueOf(s[7]);
                    List pago = new ArrayList();
                    List numero = new ArrayList();
                    for(int j=10; j < 22; j++)
                        {
                            int h = 22 - j ;
                            pago.add( (s[j]==null)?0:Double.valueOf(s[j]) );
                            numero.add(Double.valueOf(h));

                        }



                    if (ingresos != 0)
                    {
                        med_ingresos.add(ingresos);
                    }
                    if (valor_vivienda != 0)
                    {
                        med_valviv.add(valor_vivienda);
                    }
                    if (mensualidad != 0)
                    {
                        med_mensualidad.add(mensualidad);
                    }

                    clientes.add(new Cliente(cliId, cliSap,edad,estado,ocupacion,fecha,ingresos,mensualidad,valor_vivienda,numero,pago));
            }


            System.out.println(e.getMessage());

        }




    }


    private void aplicamedianas(List clientes)
    {
           for( int i =0; i < clientes.size(); i++)
           {
                        //aplica medianas
                     if  (((Cliente)clientes.get(i)).getIngresos() == 0)
                     {
                        ((Cliente)clientes.get(i)).setIngresos(m_ingreso) ;
                     }
                     if  (((Cliente)clientes.get(i)).getMensualidad() == 0)
                     {
                        ((Cliente)clientes.get(i)).setMensualidad(m_mensualidad);
                     }
                     if  (((Cliente)clientes.get(i)).getValorVienda() == 0)
                     {
                        ((Cliente)clientes.get(i)).setValor_vivienda(m_val_viv) ;
                     }

            }

    }


    private void bienformados(List clientes)
    {

         for( int i =0; i < clientes.size(); i++)
            {

                 if ( ((Cliente)clientes.get(i)).getEdad() == 0 || ((Cliente)clientes.get(i)).getOcupacion() == 0)
                    por_calcular.add(i);
                 else
                    bien_calcular.add(i);
            }

    }



    private double calculo_CPR(Session s, int edos, int edad, int ocup, int fecha )
    {

        System.out.println("");
        Query q = s.createQuery("from Edo as edo where edo.cal.calId = '1'");
        List lista = (List) q.list();
        double ESTADO_WoE = ((Edo)lista.get(edos-1)).getEdoWoe();
        double recargo = ((Edo)lista.get(edos-1)).getEdoRcg();

        q = s.createQuery("from RngEda as eda where eda.calId='1' and eda.rngEdaLimInf<="+edad+" and eda.rngEdaLimSup>="+edad);
        lista = (List) q.list();
        double EDAD_WoE = ((RngEda)lista.get(0)).getRngEdaWoe();

       

        q = s.createQuery("from Ocp as ocp where ocp.cal.calId = '1' and ocp.ocpOrdPre ="+ocup);
        lista = (List) q.list();
        double OCUPACION_WoE = ((Ocp)lista.get(0)).getOcpWoe();


        

        double β_CPR_0 = 0.0180000000;
        double β_CPR_ESTADO = 0.0100000000;
        double β_CPR_EDAD = 0.0170000000;
        double β_CPR_OCUPACION = 0.0080000000;
        double ZETA = β_CPR_0;
        ZETA = ZETA - (β_CPR_ESTADO * ESTADO_WoE);
        ZETA = ZETA - (β_CPR_EDAD * EDAD_WoE);
        ZETA = ZETA - (β_CPR_OCUPACION * OCUPACION_WoE);
        double PI = Math.exp(ZETA) / (1+(Math.exp(ZETA)));

        calculaPromedios(edos,PI);

        q = s.createQuery("from IntPi as ip where ip.cal.calId = '6' and ip.intPiLimInf<="+PI+" and ip.intPiLimSup>="+PI);
        lista = (List) q.list();
        String clasificacion = ((IntPi)lista.get(0)).getIntPiDes();

        q = s.createQuery("from FtrPpr as fp where fp.ftrPprCls='"+clasificacion+"' and fp.ftrPprMes="+fecha);
        lista = (List) q.list();
        double CPR = ((FtrPpr)lista.get(0)).getFtrPprFtr();

        double CPR_REC = CPR * (1 + recargo);

      
        return CPR_REC;

    }



    private void calculaPromedios(int estado, double cpr_rec)
    {

                //calculo de promedios
                if (cppr_rec_arr.size() == 0)
                    cppr_rec_arr.add( new Prom_estado(estado, cpr_rec,1));
                else
                {
                    int entro = 0;
                    for (int i=0; i < cppr_rec_arr.size(); i++)
                    {
                        if (((Prom_estado)cppr_rec_arr.get(i)).getEstado() == estado)
                        {

                            ((Prom_estado)cppr_rec_arr.get(i)).setCantidad(((Prom_estado)cppr_rec_arr.get(i)).getCantidad()  +  cpr_rec);
                            ((Prom_estado)cppr_rec_arr.get(i)).setOcurrencia(((Prom_estado)cppr_rec_arr.get(i)).getOcurrencia()  +  1);
                            entro = 1;
                        }

                    }


                    if (entro==0)
                        cppr_rec_arr.add( new Prom_estado(estado, cpr_rec,1));
                }
    }




    private double obtenerEficiencia(List pagos, double mensualidad)
    {
                     double suma_pagos = 0;
              //      List pagos = ((Cliente)clientes.get(i)).getPago();


                        for (int j=0; j<= pagos.size()-1; j++)
                        {
                            suma_pagos = suma_pagos + Double.valueOf(pagos.get(j).toString());
                        }

                        double eficiencia = suma_pagos/(pagos.size() * mensualidad);

                    return eficiencia;
    }


private int pagos_bien(double mensualidad, List pagos) //act
{

                int pagos_bien = 0;

                for (int i =pagos.size()-1; i >= 0; i--)
                {
                    if (mensualidad > Double.valueOf(pagos.get(i).toString()))
                    {
                        pagos_bien++;
                    }
                    else
                    {
                      break;
                    }

                }


    return pagos_bien;
}


private int pagos_mal(double mensualidad, List pagos) //ppc
{
                int pagos_mal = 0;
                for (int i =pagos.size()-1; i >= 0; i--)
                {
                    if (mensualidad <= Double.valueOf(pagos.get(i).toString()))
                    {
                        pagos_mal++;

                    }
                    else
                    {
                        break;
                    }

                }

           return pagos_mal;
}

private double calculaBhr1(Session s, double cpr_rec, double mens_ing, double ingreso_Viv, double eficiencia, List pagos, double mensualidad, int pagos_bien, int pagos_mal)
{

            Query q = s.createQuery("from BhrCtaPurRie as bcpr where bcpr.calId = '8' and bcpr.bhrCtaPurRieLimInf <=" + cpr_rec + " and bcpr.bhrCtaPurRieLimSup >= "+ cpr_rec);
             List lista = (List) q.list();
            double CPR_1_WoE = ((BhrCtaPurRie)lista.get(0)).getBhrCtaPurRieWoe();


            q = s.createQuery("from BhrMenIng as bmi where bmi.calId = '8' and bmi.bhrMenIngLimInf  <=" + mens_ing + "and bhrMenIngLimSup >=" + mens_ing);
            lista = (List) q.list();
            double MENS_ING_1_WoE = ((BhrMenIng)lista.get(0)).getBhrMenIngWoe();



            q = s.createQuery("from BhrEfi as bi where bi.calId = '8' and bi.bhrEfiLimInf <=" + eficiencia + " and bi.bhrEfiLimSup >=" + eficiencia);
            lista = (List) q.list();
            double EFICIENCIA_1_WoE = ((BhrEfi)lista.get(0)).getBhrEfiWoe();



            q = s.createQuery("from BhrPagPtlCnt as bppc where bppc.calId = '8' and bppc.bhrPagPtlCntLimInf <=" + pagos_mal + " and  bppc.bhrPagPtlCntLimSup >=" +  pagos_mal);
            lista = (List) q.list();
            double PPC_1_WoE = ((BhrPagPtlCnt)lista.get(0)).getBhrPagPtlCntWoe();


            q = s.createQuery("from BhrIngViv as biv where biv.calId = '8' and biv.bhrIngVivLimInf <= " + ingreso_Viv + "and biv.bhrIngVivLimSup >= " + ingreso_Viv );
            lista = (List) q.list();
            double ING_VIV_1_WoE = ((BhrIngViv)lista.get(0)).getBhrIngVivWoe();


            q = s.createQuery("from BhrAct as ba where ba.calId = '8' and ba.bhrActLimInf <=" + pagos_bien + " and ba.bhrActLimSup >=" + pagos_bien);
            lista = (List) q.list();
            double ACT_1_WoE = ((BhrAct)lista.get(0)).getBhrActWoe();


            double β_CP_CPR_1 = -0.00485814675056730000;
            double β_CP_ING_VIV_1 = -0.00274482964749100000;
            double β_CP_MENS_ING_1 = -0.01480188332080010000;
            double β_CP_EFICIENCIA_1 = -0.00645225032328390000;
            double β_CP_PPC_1 = -0.00201118436015531000;
            double β_CP_ACT_1 = -0.00404718407947272000;
            double ZETA1 = (β_CP_CPR_1 * CPR_1_WoE);
            ZETA1 = ZETA1 + (β_CP_ING_VIV_1 * ING_VIV_1_WoE);
            ZETA1 = ZETA1 + (β_CP_MENS_ING_1 * MENS_ING_1_WoE);
            ZETA1 = ZETA1 + (β_CP_EFICIENCIA_1 * EFICIENCIA_1_WoE);
            ZETA1 = ZETA1 + (β_CP_PPC_1 * PPC_1_WoE);
            ZETA1 = ZETA1 + (β_CP_ACT_1 * ACT_1_WoE);
            double PI1 = Math.exp(ZETA1)/(1+Math.exp(ZETA1));

            q = s.createQuery("from IntPi as ip where ip.cal.calId = '6' and ip.intPiLimInf<="+PI1+" and ip.intPiLimSup>="+PI1);
            lista = (List) q.list();
            clasificacion1 = ((IntPi)lista.get(0)).getIntPiDes();

             String SCORE_COMPORTAMIENTO_DE_PAGO_NO_CONDICIONADO = clasificacion1.substring(0,1);



             return PI1;


}


private void calculaBhr2(Session s, double cpr_rec, double mens_ing, double ingreso_Viv, double eficiencia, int pagos_bien, int pagos_mal )
{
                                                Query  q = s.createQuery("from BhrCtaPurRie as bcpr where bcpr.calId = '9' and bcpr.bhrCtaPurRieLimInf <=" + cpr_rec + " and bcpr.bhrCtaPurRieLimSup >= "+ cpr_rec);
                                                List lista = (List) q.list();
                                                double CPR_2_WoE = ((BhrCtaPurRie)lista.get(0)).getBhrCtaPurRieWoe();



                                                q = s.createQuery("from BhrMenIng as bmi where bmi.calId = '9' and bmi.bhrMenIngLimInf  <=" + mens_ing + "and bhrMenIngLimSup >=" + mens_ing);
                                                lista = (List) q.list();
                                                double MENS_ING_2_WoE = ((BhrMenIng)lista.get(0)).getBhrMenIngWoe();


                                                q = s.createQuery("from BhrEfi as bi where bi.calId = '9' and bi.bhrEfiLimInf <=" + eficiencia + " and bi.bhrEfiLimSup >=" + eficiencia);
                                                lista = (List) q.list();
                                                double EFICIENCIA_2_WoE = ((BhrEfi)lista.get(0)).getBhrEfiWoe();



                                                q = s.createQuery("from BhrPagPtlCnt as bppc where bppc.calId = '9' and bppc.bhrPagPtlCntLimInf <=" +pagos_mal+ " and  bppc.bhrPagPtlCntLimSup >=" + pagos_mal);
                                                lista = (List) q.list();
                                                double PPC_2_WoE = ((BhrPagPtlCnt)lista.get(0)).getBhrPagPtlCntWoe();


                                                q = s.createQuery("from BhrIngViv as biv where biv.calId = '9' and biv.bhrIngVivLimInf <= " + ingreso_Viv + "and biv.bhrIngVivLimSup >= " + ingreso_Viv );
                                                lista = (List) q.list();
                                                double ING_VIV_2_WoE = ((BhrIngViv)lista.get(0)).getBhrIngVivWoe();


                                                q = s.createQuery("from BhrAct as ba where ba.calId = '9' and ba.bhrActLimInf <=" + pagos_bien + " and ba.bhrActLimSup >=" + pagos_bien);
                                                lista = (List) q.list();
                                                double ACT_2_WoE = ((BhrAct)lista.get(0)).getBhrActWoe();



                                                double β_IB_CPR_2 = -0.00994963608185360000;
                                                double β_IB_MENS_ING_2 = -0.00737290519294762000;
                                                double β_IB_EFICIENCIA_2 = -0.00859701413689464000;
                                                double β_IB_PPC_2 = -0.00662801341179144000;
                                                double β_IB_ING_VIV_2 = -0.01351715962007380000;
                                                double β_IB_ACT_2 = -0.00719176519930210000;
                                                double ZETA2 = (β_IB_CPR_2 * CPR_2_WoE);
                                                ZETA2 = ZETA2 + (β_IB_MENS_ING_2 * MENS_ING_2_WoE);
                                                ZETA2 = ZETA2 + (β_IB_EFICIENCIA_2 * EFICIENCIA_2_WoE);
                                                ZETA2 = ZETA2 + (β_IB_PPC_2 * PPC_2_WoE);
                                                ZETA2 = ZETA2 + (β_IB_ING_VIV_2 * ING_VIV_2_WoE);
                                                ZETA2 = ZETA2 + (β_IB_ACT_2 * ACT_2_WoE);
                                                PI2 = Math.exp(ZETA2)/(1+Math.exp(ZETA2));

                                                    q = s.createQuery("from IntPi as ip where ip.cal.calId = '1' and ip.intPiLimInf<="+PI2+" and ip.intPiLimSup>="+PI2);
                                                    lista = (List) q.list();
                                                    clasificacion2 = ((IntPi)lista.get(0)).getIntPiDes();
                                                    ACCION2= "";
                                                    if(pagos_bien == 0 ){
                                                        if( PI2 <= .125)
                                                            ACCION2 = "SIN GESTION";
                                                        else if(PI2 > .125 && PI2 <= .25)
                                                            ACCION2 = "LLAMADA AMIGABLE";
                                                        else if(PI2 > .25 && PI2 <= 1)
                                                            ACCION2 = "VISITA DE COBRO";
                                                    }
                                                    else if (pagos_bien > 0 && pagos_bien <= 1){
                                                        if( PI2 <= .125)
                                                            ACCION2 = "VISITA DE COBRO";
                                                        else if(PI2 > .125 && PI2 <= .25)
                                                            ACCION2 = "COBRANZA INTENSIVA";
                                                        else if(PI2 > .25 && PI2 <= .375)
                                                            ACCION2 = "COBRANZA AGRESIVA";
                                                        else if(PI2 > .375 && PI2 <= 1)
                                                            ACCION2 = "DESALOJO";
                                                    }else if (pagos_bien > 1){
                                                        if( PI2 <= .125)
                                                            ACCION2 = "COBRANZA INTENSIVA";
                                                        else if(PI2 > .125 && PI2 <= .25)
                                                            ACCION2 = "COBRANZA AGRESIVA";
                                                        else if(PI2 > .25 && PI2 <= 1)
                                                            ACCION2 = "DESALOJO";
                                                    }
}



private void calculaBhr3(Session s, double cpr_rec, double mens_ing, double ingreso_Viv, double eficiencia, int pagos_bien, int pagos_mal)
{
    Query q = s.createQuery("from BhrCtaPurRie as bcpr where bcpr.calId = '10' and bcpr.bhrCtaPurRieLimInf <=" + cpr_rec+ " and bcpr.bhrCtaPurRieLimSup >= "+ cpr_rec);
    List lista = (List) q.list();
    double CPR_3_WoE = ((BhrCtaPurRie)lista.get(0)).getBhrCtaPurRieWoe();



    q = s.createQuery("from BhrMenIng as bmi where bmi.calId = '10' and bmi.bhrMenIngLimInf  <=" + mens_ing + "and bhrMenIngLimSup >=" + mens_ing);
    lista = (List) q.list();
    double MENS_ING_3_WoE = ((BhrMenIng)lista.get(0)).getBhrMenIngWoe();


    q = s.createQuery("from BhrEfi as bi where bi.calId = '10' and bi.bhrEfiLimInf <=" + eficiencia + " and bi.bhrEfiLimSup >=" + eficiencia);
    lista = (List) q.list();
    double EFICIENCIA_3_WoE = ((BhrEfi)lista.get(0)).getBhrEfiWoe();



    q = s.createQuery("from BhrPagPtlCnt as bppc where bppc.calId = '10' and bppc.bhrPagPtlCntLimInf <=" +pagos_mal + " and  bppc.bhrPagPtlCntLimSup >=" + pagos_mal);
    lista = (List) q.list();
    double PPC_3_WoE = ((BhrPagPtlCnt)lista.get(0)).getBhrPagPtlCntWoe();


    q = s.createQuery("from BhrIngViv as biv where biv.calId = '10' and biv.bhrIngVivLimInf <= " + ingreso_Viv + "and biv.bhrIngVivLimSup >= " + ingreso_Viv );
    lista = (List) q.list();
    double ING_VIV_3_WoE = ((BhrIngViv)lista.get(0)).getBhrIngVivWoe();


    q = s.createQuery("from BhrAct as ba where ba.calId = '10' and ba.bhrActLimInf <=" + pagos_bien + " and ba.bhrActLimSup >=" + pagos_bien);
    lista = (List) q.list();
    double ACT_3_WoE = ((BhrAct)lista.get(0)).getBhrActWoe();




    double β_IM_EFICIENCIA_3 = -0.00918017532362146000;
    double β_IM_PPC_3 = -0.01240938693928980000;
    double β_IM_ACT_3 = -0.02816379755151060000;
    double ZETA3 = (β_IM_EFICIENCIA_3 * EFICIENCIA_3_WoE);
    ZETA3 = ZETA3 + (β_IM_PPC_3 * PPC_3_WoE);
    ZETA3 = ZETA3 + (β_IM_ACT_3 * ACT_3_WoE);
     PI2 = Math.exp(ZETA3)/(1+Math.exp(ZETA3));

        q = s.createQuery("from IntPi as ip where ip.cal.calId = '1' and ip.intPiLimInf<="+PI2+" and ip.intPiLimSup>="+PI2);
        lista = (List) q.list();
        clasificacion3 = ((IntPi)lista.get(0)).getIntPiDes();
        ACCION2= "";
        if(pagos_bien == 0 ){
            if( PI2 <= .125)
                ACCION2 = "LLAMADA AMIGABLE";
            else if(PI2 > .125 && PI2 <= .25)
                ACCION2 = "VISITA DE COBRO";
            else if(PI2 > .25 && PI2 <= 1)
                ACCION2 = "COBRANZA INTENSIVA";
        }
        else if (pagos_bien > 0 && pagos_bien <= 1){
            if( PI2 <= .125)
                ACCION2 = "COBRANZA INTENSIVA";
            else if(PI2 > .125 && PI2 <= .25)
                ACCION2 = "COBRANZA AGRESIVA";
            else if(PI2 > .25 && PI2 <= 1)
                ACCION2 = "DESALOJO";
        }else if (pagos_bien > 1){
            if( PI2 <= .125)
                ACCION2 = "COBRANZA AGRESIVA";
            else if(PI2 > .125 && PI2 <= 1)
                ACCION2 = "DESALOJO";
        }

}



private void calculaBhr4(Session s, double cpr_rec, double mens_ing, double ingreso_Viv, double eficiencia, int pagos_bien, int pagos_mal)
{
        Query q = s.createQuery("from BhrCtaPurRie as bcpr where bcpr.calId = '11' and bcpr.bhrCtaPurRieLimInf <=" + cpr_rec + " and bcpr.bhrCtaPurRieLimSup >= "+ cpr_rec);
        List lista = (List) q.list();
        double CPR_4_WoE = ((BhrCtaPurRie)lista.get(0)).getBhrCtaPurRieWoe();



  /**      q = s.createQuery("from BhrMenIng as bmi where bmi.calId = '11' and bmi.bhrMenIngLimInf  <=" + mens_ing + "and bhrMenIngLimSup >=" + mens_ing);
        lista = (List) q.list();
        double MENS_ING_4_WoE = ((BhrMenIng)lista.get(0)).getBhrMenIngWoe();
*/

        q = s.createQuery("from BhrEfi as bi where bi.calId = '11' and bi.bhrEfiLimInf <=" + eficiencia + " and bi.bhrEfiLimSup >=" + eficiencia);
        lista = (List) q.list();
        double EFICIENCIA_4_WoE = ((BhrEfi)lista.get(0)).getBhrEfiWoe();

/*
        q = s.createQuery("from BhrPagPtlCnt as bppc where bppc.calId = '11' and bppc.bhrPagPtlCntLimInf <=" +pagos_bien+ " and  bppc.bhrPagPtlCntLimSup >=" + pagos_bien);
        lista = (List) q.list();
        double PPC_4_WoE = ((BhrPagPtlCnt)lista.get(0)).getBhrPagPtlCntWoe();
*/

        q = s.createQuery("from BhrIngViv as biv where biv.calId = '11' and biv.bhrIngVivLimInf <= " + ingreso_Viv + "and biv.bhrIngVivLimSup >= " + ingreso_Viv );
        lista = (List) q.list();
        double ING_VIV_4_WoE = ((BhrIngViv)lista.get(0)).getBhrIngVivWoe();


        q = s.createQuery("from BhrAct as ba where ba.calId = '11' and ba.bhrActLimInf <=" + pagos_bien + " and ba.bhrActLimSup >=" + pagos_bien);
        lista = (List) q.list();
        double ACT_4_WoE = ((BhrAct)lista.get(0)).getBhrActWoe();


        double β_IA_CPR_4 = -0.01099487110674070000;
        double β_IA_EFICIENCIA_4 = -0.01746771935759450000;
        double β_IA_ING_VIV_4 = -0.00840351207766000000;
        double β_IA_ACT_4 = 0.01797370783159030000;
        double ZETA4 = (β_IA_CPR_4 * CPR_4_WoE);
        ZETA4 = ZETA4 + (β_IA_EFICIENCIA_4 * EFICIENCIA_4_WoE);
        ZETA4 = ZETA4 + (β_IA_ING_VIV_4 * ING_VIV_4_WoE);
        ZETA4 = ZETA4 + (β_IA_ACT_4 * ACT_4_WoE);
        PI2 = Math.exp(ZETA4)/(1+Math.exp(ZETA4));

            q = s.createQuery("from IntPi as ip where ip.cal = '1' and ip.intPiLimInf<="+PI2+" and ip.intPiLimSup>="+PI2);
            lista = (List) q.list();
            clasificacion4 = ((IntPi)lista.get(0)).getIntPiDes();

            ACCION2= "";
            if(pagos_bien == 0 ){
                if( PI2 <= .125)
                    ACCION2 = "VISITA DE COBRO";
                else if(PI2 > .125 && PI2 <= .25)
                    ACCION2 = "COBRANZA INTENSIVA";
                else if(PI2 > .25 && PI2 <= 1)
                    ACCION2 = "COBRANZA AGRESIVA";
            }
            else if (pagos_bien > 0 && pagos_bien <= 1){
                if( PI2 <= .125)
                    ACCION2 = "COBRANZA AGRESIVA";
                else if(PI2 > .125 && PI2 <= 1)
                    ACCION2 = "DESALOJO";
            }else if (pagos_bien > 1){
                if(PI2 > 0 && PI2 <= 1)
                    ACCION2 = "DESALOJO";
            }
}



    public static void main(String[] args) {
        CalculadoraBWS bw=new CalculadoraBWS();

        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><EntradaCalculadoraBHR><CLIENTE><CLI_ID>1</CLI_ID><CLI_SAP>001</CLI_SAP><EDA_ID>21</EDA_ID><EDO_ID>15</EDO_ID><OCP_ID>121</OCP_ID><INGRESOS>6500</INGRESOS><MES_ENTREGA_VIVIENDA>05</MES_ENTREGA_VIVIENDA><MENSUALIDAD>3714</MENSUALIDAD><VALOR_VIVIENDA>360000</VALOR_VIVIENDA><PAGOS><PAGO_ID><NUMERO>1</NUMERO><MONTO>500</MONTO></PAGO_ID><PAGO_ID><NUMERO>2</NUMERO><MONTO>500</MONTO></PAGO_ID><PAGO_ID><NUMERO>3</NUMERO><MONTO>1000</MONTO></PAGO_ID></PAGOS></CLIENTE></EntradaCalculadoraBHR>";

        
        String calculo=bw.CalculaB(xml);

        System.out.println("entrada");
        System.out.println(xml);

        System.out.println("salida");
        System.out.println(calculo);
    }



}
