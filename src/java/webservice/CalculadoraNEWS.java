
package webservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
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
public class CalculadoraNEWS {
    static String xmlVacioExpt = "Estructura de Xml Vacia";
    static String xmlExpt = "Estructura de Xml  con Error";
    static String tabNoEncontradoExpt = "Tab No encontrado: ";
    static String tabVacioExpt = "Valor Tab Vacio: ";
    static String accesoDatosExpt = "Ocurrio un error en acceso a Datos";
    static String datosErrorExpt = "Valor Tab debe ser superior a 0:";

    static double E9 = 1.241;
    static double E10 = 0.3547;
    static double E11 =0.1967;
    /**
     * Web service operation
     */
    @WebMethod(operationName = "CalculaNE")
    public String CalculaNE(@WebParam(name = "xml")
    String xml) {try
      {
        if(xml == null)
          return xmlVacioExpt;

        System.out.println("->>> STRING XML RECIBIDO <<<-");
        System.out.println(xml);

        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
        DocumentBuilderFactory dbfacIN = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilderIN = dbfacIN.newDocumentBuilder();
        Document docIN = docBuilderIN.parse(bais);

        if(docIN.getDocumentElement().getNodeName().equals("EntradaCalculadoraNE"))
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
            String codPosId = GetValue(docIN,"CLI_POS_ID");

            double ingreso = GetValueDouble(docIN,"INGRESO");
            double tasa = GetValueDouble(docIN,"TASA");
            double cupon = GetValueDouble(docIN,"CUPON");


            double NE_10_I = CalculaNE(ingreso,tasa,cupon,10,0);
            double NE_10_II = CalculaNE(ingreso,tasa,cupon,10,0.03);
            double NE_10_III = CalculaNE(ingreso,tasa,cupon,10,0.05);
            double NE_10_IV = CalculaNE(ingreso,tasa,cupon,10,0.07);
            double End_Max_Esp_10 = NE_10_I*0.3 + NE_10_II*0.3+ NE_10_III*0.2+NE_10_IV*0.2;
            double Por_End_Max_10 = End_Max_Esp_10/ingreso;

            double NE_15_I = CalculaNE(ingreso,tasa,cupon,15,0);
            double NE_15_II = CalculaNE(ingreso,tasa,cupon,15,0.03);
            double NE_15_III = CalculaNE(ingreso,tasa,cupon,15,0.05);
            double NE_15_IV = CalculaNE(ingreso,tasa,cupon,15,0.07);
            double End_Max_Esp_15 = NE_15_I*0.3 + NE_15_II*0.3+ NE_15_III*0.2+NE_15_IV*0.2;
            double Por_End_Max_15 = End_Max_Esp_15/ingreso;

            double NE_20_I = CalculaNE(ingreso,tasa,cupon,20,0);
            double NE_20_II = CalculaNE(ingreso,tasa,cupon,20,0.03);
            double NE_20_III = CalculaNE(ingreso,tasa,cupon,20,0.05);
            double NE_20_IV = CalculaNE(ingreso,tasa,cupon,20,0.07);
            double End_Max_Esp_20 = NE_20_I*0.3 + NE_20_II*0.3+ NE_20_III*0.2+NE_20_IV*0.2;
            double Por_End_Max_20 = End_Max_Esp_20/ingreso;

            //Crear un XML vacio
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            //Crear el Arbol XML

            //Añadir la raiz
            Element raiz = doc.createElement("SalidaCalculadoraNE");
            doc.appendChild(raiz);

            //Valores Salida
            AgregarNodo(raiz,doc,"CLI_ID",String.valueOf(cliId));
            AgregarNodo(raiz,doc,"CLI_SAP",String.valueOf(cliSap));
            AgregarNodo(raiz,doc,"NE_ESPERADO_0y10",Double.toString(NE_10_I));
            AgregarNodo(raiz,doc,"NE_ESPERADO_1y10",Double.toString(NE_10_II));
            AgregarNodo(raiz,doc,"NE_ESPERADO_2y10",Double.toString(NE_10_III));
            AgregarNodo(raiz,doc,"NE_ESPERADO_3y10",Double.toString(NE_10_IV));
            AgregarNodo(raiz,doc,"E_MAX_ESP_10",Double.toString(End_Max_Esp_10));
            AgregarNodo(raiz,doc,"PC_MAX_10",Double.toString(Por_End_Max_10));
            AgregarNodo(raiz,doc,"NE_ESPERADO_0y15",Double.toString(NE_15_I));
            AgregarNodo(raiz,doc,"NE_ESPERADO_1y15",Double.toString(NE_15_II));
            AgregarNodo(raiz,doc,"NE_ESPERADO_2y15",Double.toString(NE_15_III));
            AgregarNodo(raiz,doc,"NE_ESPERADO_3y15",Double.toString(NE_15_IV));
            AgregarNodo(raiz,doc,"E_MAX_ESP_15",Double.toString(End_Max_Esp_15));
            AgregarNodo(raiz,doc,"PC_MAX_15",Double.toString(Por_End_Max_15));
            AgregarNodo(raiz,doc,"NE_ESPERADO_0y20",Double.toString(NE_20_I));
            AgregarNodo(raiz,doc,"NE_ESPERADO_1y20",Double.toString(NE_20_II));
            AgregarNodo(raiz,doc,"NE_ESPERADO_2y20",Double.toString(NE_20_III));
            AgregarNodo(raiz,doc,"NE_ESPERADO_3y20",Double.toString(NE_20_IV));
            AgregarNodo(raiz,doc,"E_MAX_ESP_20",Double.toString(End_Max_Esp_20));
            AgregarNodo(raiz,doc,"PC_MAX_20",Double.toString(Por_End_Max_20));


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
            return tabNoEncontradoExpt+"EntradaCalculadoraNE";
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

    private int GetValueInt(Document doc,String nodo) throws Exception
    {
       NodeList listaNodos = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < listaNodos.getLength(); i++) {

            System.out.println("->>"+listaNodos.item(i));

            if(listaNodos.item(i).getNodeName().equals(nodo))
                if(!listaNodos.item(i).getTextContent().equals(""))
                    return Integer.parseInt(listaNodos.item(i).getTextContent());
                  else
                    throw new Exception(tabVacioExpt + nodo); 
        }
       throw new Exception(tabNoEncontradoExpt + nodo);
    }

    private double GetValueDouble(Document doc,String nodo) throws Exception
    {
       NodeList listaNodos = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < listaNodos.getLength(); i++) {
            if(listaNodos.item(i).getNodeName().equals(nodo))
                if(!listaNodos.item(i).getTextContent().equals(""))
                    return Double.parseDouble(listaNodos.item(i).getTextContent());
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

    private double CalculaNE(double ingreso, double tasa, double cupon, int anos, double inflacion) {
        double C3 = ingreso;
            double C6 = E9;
            double C7 = E10;
            double C8 = E11;
            double C4 = (C6*C8)*C3;
            double C5 = (C7*C6)*C3;
            double C9 = anos;
            double C10 = tasa;
            double C11 = cupon;
            double C12 = C10/36000*C11;
            double C13 = 1/(1+C12);
            double C14 = inflacion;
            double suma = 0;
            for(int i=1;i<=anos;i++)
            {
                double F7 = i;  //i en el ciclo
                double A_i_12 = (1-Math.pow(C13,(F7*12)))/C12;
                double A_i_minus_1_12 = (1-Math.pow(C13,((F7-1)*12)))/C12;
                double factor_i = Math.pow((1+C14),(F7-1));
                double flujoLibreEsperado_i = (A_i_12-A_i_minus_1_12)*factor_i;
                suma+=flujoLibreEsperado_i;
            }
            double J17 = suma*C7*C6;
            double C17 = J17;
            double C18 = (1-Math.pow(C13,(C9*12)))/C12;
            double C19 = ((C17/(C7*C18))-1)*C6;
            double C20 = C19*C3;
            return C20;
    }

}