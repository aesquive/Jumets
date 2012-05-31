/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
//gacc
import objetos.RngEda;
import objetos.Edo;
import objetos.FtrPpr;
import objetos.IntPi;
import objetos.Ocp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;



/**
 *
 * @author ydt
 */
@WebService()
public class CalculadoraPPWS {
    static String xmlVacioExpt = "Estructura de Xml Vacia";
    static String xmlExpt = "Estructura de Xml con Error";
    static String tabNoEncontradoExpt = "Tab No encontrado: ";
    static String tabVacioExpt = "Valor Tab Vacio: ";
    static String accesoDatosExpt = "Ocurrio un error en acceso a Datos";
    static String datosErrorExpt = "Valor Tab debe ser superior a 0:";
    static String ErrorEdadExpt = "Edad Invalida";
    static String ErrorFechaExpt = "Fecha Invalida";



    static String meses[] = {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OBTUBRE","NOBIEMBRE","DICIEMBRE"};




    /**
     * Web service Calculadora Prima Pura
     */
    @WebMethod(operationName = "CalcularPP")
    public String CalcularPP(@WebParam(name = "xml")String xml)
    {
      try
      {
        if(xml == null)
          return xmlVacioExpt;
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
        DocumentBuilderFactory dbfacIN = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilderIN = dbfacIN.newDocumentBuilder();
        Document docIN = docBuilderIN.parse(bais);
        if( docIN.getDocumentElement().getNodeName().equals("EntradaCalculadoraPP"))
        {
            int cliId = GetValueInt(docIN, "CLI_ID");
            int cliSap = GetValueInt(docIN, "CLI_SAP");
            String cliApePat = GetValue(docIN, "CLI_APE_PAT");
            String cliApeMat = GetValue(docIN, "CLI_APE_MAT");
            String cliNom = GetValue(docIN, "CLI_NOM");
            String cliFecNac = GetValue(docIN, "CLI_FEC_NAC");
            String cliDomCal = GetValue(docIN,"CLI_DOM_CAL");
            String cliDomNumExt = GetValue(docIN,"CLI_DOM_NUM_EXT");
            String cliDomNumInt = GetValue(docIN,"CLI_DOM_NUM_INT");
            String cliDomCol = GetValue(docIN,"CLI_DOM_COL");
            String codPosId = GetValue(docIN,"COD_POS_ID");

            int estado = GetValueInt(docIN, "ESTADO");
            int edad = GetValueInt(docIN, "EDAD");
            int ocupacion = GetValueInt(docIN, "OCUPACION");
            String fecha = GetValue(docIN, "FECHA");
            float mensualidad = GetValueInt(docIN, "CUOTA");
            float valor_vivienda = GetValueInt(docIN, "VALOR_VIVIENDA");

             if(estado<1 || ocupacion<1)
                return datosErrorExpt+"ESTADO,OCUPACION";
            if(edad<18  && edad>65)
                return ErrorEdadExpt;



            //Crear un XML vacio
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            //Crear el Arbol XML

            //Añadir la raiz
            Element raiz = doc.createElement("SalidaCalculadoraPP");
            doc.appendChild(raiz);

            //Crear hijs y adicionarlos a la raiz
            AgregarNodo(raiz,doc,"CLI_ID",Integer.toString(cliId));
            AgregarNodo(raiz,doc,"CLI_SAP",Integer.toString(cliSap));

            Session s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
            
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("from Edo as edo where edo.cal.calId = '6'");
            List lista = (List) q.list();
            double estado_woe = ((Edo)lista.get(estado-1)).getEdoWoe();
            double recargo = ((Edo)lista.get(estado-1)).getEdoRcg();

            q = s.createQuery("from RngEda as eda where eda.calId='6' and eda.rngEdaLimInf<="+edad+" and eda.rngEdaLimSup>="+edad);
            lista = (List) q.list();
            double edad_woe = ((RngEda)lista.get(0)).getRngEdaWoe();

            q = s.createQuery("from Ocp as ocp where ocp.cal.calId = '6' and ocp.ocpOrdPre="+ocupacion);
            lista = (List) q.list();
            double ocupacion_woe = ((Ocp)lista.get(0)).getOcpWoe();

          //  double  zeta = 0.018-(0.01)*estado_woe-(0.017)*edad_woe-(0.008)*ocupacion_woe;
            double zeta = 0.018146691102274-(0.00993013369427481)* estado_woe -(0.017366941566975)* edad_woe -(0.00838465419451784)* ocupacion_woe;
            double pi = Math.exp(zeta)/(1+Math.exp(zeta));

            q = s.createQuery("from IntPi as intPi where intPi.cal.calId='6' and intPi.intPiLimInf<="+pi+" and intPi.intPiLimSup>="+pi);
            lista = (List) q.list();
            String clasificacion = ((IntPi)lista.get(0)).getIntPiDes();

            q = s.createQuery("from FtrPpr as fp where fp.ftrPprCls='"+clasificacion+"' and fp.ftrPprMes="+fecha);
            lista = (List) q.list();
            double cuota = ((FtrPpr)lista.get(0)).getFtrPprFtr();

            double ppr = valor_vivienda*cuota;
            double cuota_pprr = cuota * (1 + recargo);
            double pprr = valor_vivienda *cuota_pprr;


            System.out.println(estado_woe);
            System.out.println(recargo);
            System.out.println(edad_woe);
            System.out.println(ocupacion_woe);
            System.out.println(zeta);
            System.out.println(pi);
            System.out.println(clasificacion);
            System.out.println(cuota);
            System.out.println(ppr);
            System.out.println(cuota_pprr);
            System.out.println(pprr);


            AgregarNodo(raiz,doc,"CUOTA_PURA_RIESGO",Double.toString(cuota*100)+"%");
            AgregarNodo(raiz,doc,"CUOTA_RECARGADAD",Double.toString(cuota_pprr*100)+"%");
            AgregarNodo(raiz,doc,"PRIMA_PURA_RIESGO","$"+Double.toString(ppr));
            AgregarNodo(raiz,doc,"PRIMA_PURA_RIESO_RECARGADA","$"+Double.toString(pprr));
            //Salida del XML
            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            String xmlString = sw.toString();

            return xmlString;
        }else
            return tabNoEncontradoExpt+"EntradaCalculadoraPP";
    } catch (ParserConfigurationException parE) {
         return xmlExpt;
    } catch (SAXException saxE) {
        return xmlExpt;
    } catch (IOException ioE) {
         return xmlExpt;
    } catch (Exception e) {
        return e.getMessage();
    }
    }

    private int GetValueInt(Document doc,String nodo) throws Exception
    {
       NodeList listaNodos = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < listaNodos.getLength(); i++) {
            if(listaNodos.item(i).getNodeName().equals(nodo))
                if(!listaNodos.item(i).getTextContent().equals(""))
                    return Integer.parseInt(listaNodos.item(i).getTextContent());
                else
                    throw new Exception(tabVacioExpt + nodo);
        }
       throw new Exception(tabNoEncontradoExpt + nodo);
    }

    private void AgregarNodo(Element raiz, Document doc, String tab, String valor) {
        Element child = doc.createElement(tab);
        Text text = doc.createTextNode(String.valueOf(valor));
        child.appendChild(text);
        raiz.appendChild(child);
   }

      private String GetValue(Document doc,String nodo) throws Exception
    {
       NodeList listaNodos = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < listaNodos.getLength(); i++) {
            if(listaNodos.item(i).getNodeName().equals(nodo))
                if(listaNodos.item(i).getTextContent()!= null)
                    return listaNodos.item(i).getTextContent();
                else
                    throw new Exception(tabVacioExpt + nodo);
        }
       throw new Exception(tabNoEncontradoExpt + nodo);
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

}
