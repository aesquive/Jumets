package webservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import objetos.ActUlt;
import objetos.BurAct;
import objetos.BurAnt;
import objetos.BurHis;
import objetos.BurPag;
import objetos.BurUso;
import objetos.CueAbr;
import objetos.DinExt;
import objetos.FreRel;
import objetos.GtoAlm;
import objetos.GtoImp;
import objetos.GtoRen;
import objetos.GtoSerViv;
import objetos.GtoVes;
import objetos.HibernateUtil;
import objetos.IPsi;
import objetos.IRnt;
import objetos.Ing;
import objetos.NivEst;
import objetos.NumCre;
import objetos.Pbm;
import objetos.Ptm;
import objetos.RelFam;
import objetos.RelPsiSoc;
import objetos.RngResAnt;
import objetos.Sex;
import objetos.SitPrxAn;
import objetos.Srv;
import objetos.VcsViv;
import objetos.VlrViv;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@WebService
public class CalculadoraCGWS
{
  static String xmlVacioExpt = "Estructura de Xml Vacia";
  static String xmlExpt = "Estructura de Xml  con Error";
  static String tabNoEncontradoExpt = "Tab No encontrado: ";
  static String tabVacioExpt = "Valor Tab Vacio: ";
  static String accesoDatosExpt = "Ocurrio un error en acceso a Datos";
  static String datosErrorExpt = "Valor Tab debe ser superior a 0:";

  double GENERO_FACTOR = 0.0D;
  double GENERO_WOE = 0.0D;
  String GENERO_DES = "";
  double FRECUENCIA_RELIGION_FACTOR = 0.0D;
  double FRECUENCIA_RELIGION_WOE = 0.0D;
  String FRECUENCIA_RELIGION_DES = "";
  double SITUACION_PROXIMO_ANO_FACTOR = 0.0D;
  double SITUACION_PROXIMO_ANO_WOE = 0.0D;
  String SITUACION_PROXIMO_ANO_DES = "";
  double DINERO_EXTRA_FACTOR = 0.0D;
  double DINERO_EXTRA_WOE = 0.0D;
  String DINERO_EXTRA_DES = "";
  double VIVIENDA_ACTUAL_FACTOR = 0.0D;
  double VIVIENDA_ACTUAL_WOE = 0.0D;
  String VIVIENDA_ACTUAL_DES = "";
  double SERVICIO_HOGAR_FACTOR = 0.0D;
  double SERVICIO_HOGAR_WOE = 0.0D;
  double ACT_FACTOR = 0.0D;
  double ACT_WOE = 0.0D;
  String ACT_TEXTO = "";
  double USO_FACTOR = 0.0D;
  double USO_WOE = 0.0D;
  double CUEN_ABIER_CAT_FACTOR = 0.0D;
  double CUEN_ABIER_CAT_WOE = 0.0D;
  String CUEN_ABIER_CAT_DES = "";
  double VALOR_VIVIENDA_FACTOR = 0.0D;
  double VALOR_VIVIENDA_WOE = 0.0D;
  double NO_CREDITOS_FACTOR = 0.0D;
  double NO_CREDITOS_WOE = 0.0D;
  String NO_CREDITOS_DES = "";
  double I_PSICO_FACTOR = 0.0D;
  double I_PSICO_WOE = 0.0D;
  String I_PSICO_DES = "";

  double RELIGION_FACTOR = 0.0D;
  double RELIGION_WOE = 0.0D;
  double ESCOLARIDAD_FACTOR = 0.0D;
  double ESCOLARIDAD_WOE = 0.0D;
  String ESCOLARIDAD_DES = "";
  double TRABAJO_ANTERIOR_FACTOR = 0.0D;
  double TRABAJO_ANTERIOR_WOE = 0.0D;
  String TRABAJO_ANTERIOR_DES = "";

  double INGRESO_TOTAL_FACTOR = 0.0D;
  double INGRESO_TOTAL_WOE = 0.0D;
  String INGRESO_TOTAL_DES = "";
  double GASTOS_FACTOR = 0.0D;
  double GASTOS_WOE = 0.0D;
  String GASTOS_DES = "";
  double CUBRIR_ALIMETOS_FACTOR = 0.0D;
  double CUBRIR_ALIMETOS_WOE = 0.0D;
  String CUBRIR_ALIMETOS_DES = "";
  double VESTIDO_FACTOR = 0.0D;
  double VESTIDO_WOE = 0.0D;
  String VESTIDO_DES = "";
  double PRINCIPAL_PROBLEMA_FACTOR = 0.0D;
  double PRINCIPAL_PROBLEMA_WOE = 0.0D;
  String PRINCIPAL_PROBLEMA_DES = "";
  double SOLICITAR_PRESTAMO_FACTOR = 0.0D;
  double SOLICITAR_PRESTAMO_WOE = 0.0D;
  double VCS_VIV_FACTOR = 0.0D;
  double VCS_VIV_WOE = 0.0D;
  double I_RENTA_FACTOR = 0.0D;
  double I_RENTA_WOE = 0.0D;
  double SERVICIOS_VIVIENDA_FACTOR = 0.0D;
  double SERVICIOS_VIVIENDA_WOE = 0.0D;
  String SERVICIOS_VIVIENDA_DES = "";
  double RENTA_FACTOR = 0.0D;
  double RENTA_WOE = 0.0D;
  String RENTA_DES = "";

  String SERVICIO_HOGAR_DES = "";

  String VALOR_VIVIENDA_DES = "";

  double HIST_FACTOR = 0.0D;
  double HIST_WOE = 0.0D;
  String HIST_TEXTO = "";

  double ANT_FACTOR = 0.0D;
  double ANT_WOE = 0.0D;
  String ANT_TEXTO = "";

  String USO_TEXTO = "";

  double PAGO_FACTOR = 0.0D;
  double PAGO_WOE = 0.0D;
  String PAGO_TEXTO = "";

  double AGRESION_1_FACTOR = 0.0D;
  double AGRESION_1_WOE = 0.0D;
  double AGRESION_4_FACTOR = 0.0D;
  double AGRESION_4_WOE = 0.0D;
  double ADHESION_GRUPO3_FACTOR = 0.0D;
  double ADHESION_GRUPO3_WOE = 0.0D;
  double RESENTIMIENTO_SOCIAL3_FACTOR = 0.0D;
  double RESENTIMIENTO_SOCIAL3_WOE = 0.0D;
  double CONDUCTA_DELICTIVA2_FACTOR = 0.0D;
  double CONDUCTA_DELICTIVA2_WOE = 0.0D;
  double RESENTIMIENTO_SOCIAL4_FACTOR = 0.0D;
  double RESENTIMIENTO_SOCIAL4_WOE = 0.0D;
  double RESPONSABILIDAD4_FACTOR = 0.0D;
  double RESPONSABILIDAD4_WOE = 0.0D;
  double CONDUCTA_DELICTIVA5_FACTOR = 0.0D;
  double CONDUCTA_DELICTIVA5_WOE = 0.0D;

  double PRIMER_PESO_COMPORTAMIENTO = 0.0D;
  String PRIMER_TEXTO_COMPORTAMIENTO = "";
  double SEGUNDO_PESO_COMPORTAMIENTO = 0.0D;
  String SEGUNDO_TEXTO_COMPORTAMIENTO = "";
  double PRIMER_PESO_COMPORTAMIENTO_NH = 0.0D;
  String PRIMER_TEXTO_COMPORTAMIENTO_NH = "";
  double SEGUNDO_PESO_COMPORTAMIENTO_NH = 0.0D;
  String SEGUNDO_TEXTO_COMPORTAMIENTO_NH = "";
  double SCORE_ARRAIGO = 0.0D;
  double SCORE_GENERO = 0.0D;
  double SCORE_COMPORTAMIENTO = 0.0D;
  double SCORE_ASPECTOS = 0.0D;

  double SCORE_ARRAIGO_NH = 0.0D;
  double SCORE_COMPORTAMIENTO_NH = 0.0D;

  double PRIMER_PESO_ARRAIGO = 0.0D;
  String PRIMER_TEXTO_ARRAIGO = "";
  double SEGUNDO_PESO_ARRAIGO = 0.0D;
  String SEGUNDO_TEXTO_ARRAIGO = "";

  double SCORE_IPSICO_FACTOR = 0.0D;
  double SCORE_IPSICO_WOE = 0.0D;

  String I_RENTA_DES = "";

  @WebMethod(operationName="CalcularCG")
  public String CalcularCG(@WebParam(name="xml") String xml)
  {
    try
    {
      if (xml == null)
        return xmlVacioExpt;
      InputSource is = new InputSource(new StringReader(xml));
      //ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
      DocumentBuilderFactory dbfacIN = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilderIN = dbfacIN.newDocumentBuilder();
      Document docIN = docBuilderIN.parse(is);

      if (docIN.getDocumentElement().getNodeName().equals("EntradaCalculadoraCG"))
      {
        int cliId = GetValueInt(docIN, "CLI_ID");
        int cliSap = GetValueInt(docIN, "CLI_SAP");
        String cliApePat = GetValue(docIN, "CLI_APE_PAT");
        String cliApeMat = GetValue(docIN, "CLI_APE_MAT");
        String cliNom = GetValue(docIN, "CLI_NOM");
        String cliFecNac = GetValue(docIN, "CLI_FEC_NAC");
        String cliDomCal = GetValue(docIN, "CLI_DOM_CAL");
        String cliDomNumExt = GetValue(docIN, "CLI_DOM_NUM_EXT");
        String cliDomNumInt = GetValue(docIN, "CLI_DOM_NUM_INT");
        String cliDomCol = GetValue(docIN, "CLI_DOM_COL");
        String codPosId = GetValue(docIN, "CLI_POS_ID");

        int GENERO = GetValueInt(docIN, "GENERO");
        int RELIGION = GetValueInt(docIN, "RELIGION");
        int FRECUENCIA_RELIGION = GetValueInt(docIN, "FRECUENCIA_RELIGION");
        int ESCOLARIDAD = GetValueInt(docIN, "ESCOLARIDAD");
        int TRABAJO_ANTERIOR = GetValueInt(docIN, "TRABAJO_ANTERIOR");
        int AGRESION_1 = GetValueInt(docIN, "AGRESION_1");
        int AGRESION_4 = GetValueInt(docIN, "AGRESION_4");
        int ADHESION_GRUPO3 = GetValueInt(docIN, "ADHESION_GRUPO3");
        int RESENTIMIENTO_SOCIAL3 = GetValueInt(docIN, "RESENTIMIENTO_SOCIAL3");
        int CONDUCTA_DELICTIVA2 = GetValueInt(docIN, "CONDUCTA_DELICTIVA2");
        int RESENTIMIENTO_SOCIAL4 = GetValueInt(docIN, "RESENTIMIENTO_SOCIAL4");
        int RESPONSABILIDAD4 = GetValueInt(docIN, "RESPONSABILIDAD4");
        int CONDUCTA_DELICTIVA5 = GetValueInt(docIN, "CONDUCTA_DELICTIVA5");
        int DINERO_EXTRA = GetValueInt(docIN, "DINERO_EXTRA");
        int VIVIENDA_ACTUAL = GetValueInt(docIN, "VIVIENDA_ACTUAL");
        int SERVICIO_HOGAR = GetValueInt(docIN, "SERVICIO_HOGAR");
        int ACT = GetValueInt(docIN, "ACT");
        int HIST = GetValueInt(docIN, "HIST");
        int ANT = GetValueInt(docIN, "ANT");
        int PAGO = GetValueInt(docIN, "PAGO");
        int USO = GetValueInt(docIN, "USO");
        int CUEN_ABIER_CAT = GetValueInt(docIN, "CUEN_ABIER_CAT");
        int VALOR_VIVIENDA = GetValueInt(docIN, "VALOR_VIVIENDA");
        int NO_CREDITOS = GetValueInt(docIN, "NO_CREDITOS");
        int I_PSICO = GetValueInt(docIN, "I_PSICO");
        int INGRESO_TOTAL = GetValueInt(docIN, "INGRESO_TOTAL");
        int GASTOS = GetValueInt(docIN, "GASTOS");
        int CUBRIR_ALIMETOS = GetValueInt(docIN, "CUBRIR_ALIMETOS");
        int VESTIDO = GetValueInt(docIN, "VESTIDO");
        int SERVICIOS_VIVIENDA = GetValueInt(docIN, "SERVICIOS_VIVIENDA");
        int RENTA = GetValueInt(docIN, "RENTA");

        int PRINCIPAL_PROBLEMA = GetValueInt(docIN, "PRINCIPAL_PROBLEMA");
        int SOLICITAR_PRESTAMO = GetValueInt(docIN, "SOLICITAR_PRESTAMO");
        int VCS_VIV = GetValueInt(docIN, "VCS_VIV");
        int I_RENTA = GetValueInt(docIN, "I_RENTA");

        int SITUACION_PROX_ANO = GetValueInt(docIN, "SITUACION_PROX_ANO");

        int TARJETA_CREDITO = GetValueInt(docIN, "TARJETA_CREDITO");
        int CUENTA_CHEQUES = GetValueInt(docIN, "CUENTA_CHEQUES");
        int CREDITO_PERSONAL = GetValueInt(docIN, "CREDITO_PERSONAL");
        int CREDITO_AUTO = GetValueInt(docIN, "CREDITO_AUTO");
        int CREDITO_HIPO = GetValueInt(docIN, "CREDITO_HIPO");
        int CREDITO_OTROS = GetValueInt(docIN, "CREDITO_OTROS");

        int REG_BURO = GetValueInt(docIN, "REG_BURO");

        Session s = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction tx = s.beginTransaction();

        double SCORE_CREDITOS = TARJETA_CREDITO + CUENTA_CHEQUES + CREDITO_PERSONAL + CREDITO_AUTO + CREDITO_HIPO + CREDITO_OTROS;
        double VECES_VIVIENDA = VALOR_VIVIENDA / INGRESO_TOTAL;

          
        PsicoSocial(s, AGRESION_1, AGRESION_4, ADHESION_GRUPO3, RESENTIMIENTO_SOCIAL3, CONDUCTA_DELICTIVA2, RESENTIMIENTO_SOCIAL4, RESPONSABILIDAD4, CONDUCTA_DELICTIVA5);
          
        String resultado = "";

        if (REG_BURO == 1)
        {
            System.out.println("antes d hit ");
          double SCORE_HIT_FACTOR = EsHit(s, GENERO, FRECUENCIA_RELIGION, SITUACION_PROX_ANO, DINERO_EXTRA, VIVIENDA_ACTUAL, SERVICIO_HOGAR, ACT, USO, CUEN_ABIER_CAT, VALOR_VIVIENDA, NO_CREDITOS, I_PSICO);
            System.out.println(" despues d hit ");

          if (SCORE_HIT_FACTOR >= 800.0D) {
            resultado = "CLIENTE ALTERNATIVA URBI";
          }
          else {
            double SCORE_NO_HIT = EsNoHit(s, RELIGION, ESCOLARIDAD, TRABAJO_ANTERIOR, DINERO_EXTRA, INGRESO_TOTAL, GASTOS, CUBRIR_ALIMETOS, VESTIDO, PRINCIPAL_PROBLEMA, SOLICITAR_PRESTAMO, VCS_VIV, I_RENTA, SERVICIOS_VIVIENDA, RENTA, SERVICIO_HOGAR, VALOR_VIVIENDA, NO_CREDITOS, I_PSICO);

            if (SCORE_NO_HIT >= 800.0D)
            {
              double SCORE_BURO = CalculoBuroMeta(s, ACT, HIST, ANT, USO, PAGO);
              if (SCORE_BURO >= 800.0D)
                resultado = "CLIENTE DECLINADO PARA REPARADORA DE BURO";
              else
                resultado = "CLIENTE DECLINADO POR BARRERA DE BURO";
            }
            else {
              resultado = "CLIENTE GOL";
            }
          }

         
        }
        else {
          double SCORE_NO_HIT = EsNoHit(s, RELIGION, ESCOLARIDAD, TRABAJO_ANTERIOR, DINERO_EXTRA, INGRESO_TOTAL, GASTOS, CUBRIR_ALIMETOS, VESTIDO, PRINCIPAL_PROBLEMA, SOLICITAR_PRESTAMO, VCS_VIV, I_RENTA, SERVICIOS_VIVIENDA, RENTA, SERVICIO_HOGAR, VALOR_VIVIENDA, NO_CREDITOS, I_PSICO);

          if (SCORE_NO_HIT >= 800.0D)
            resultado = "CLIENTE ALTERNATIVO URBI";
          else {
            resultado = "CLIENTE GOL";
          }
        }

         
        obtenerDescripcion();
        obtenerDescripcion_NH();
        obtenerArraigo();

        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element raiz = doc.createElement("SalidaCalculadoraCG");
        doc.appendChild(raiz);

        AgregarNodo(raiz, doc, "CLI_ID", String.valueOf(cliId));
       // AgregarNodo(raiz, doc, "CLI_SAP", String.valueOf(cliSap));
        //AgregarNodo(raiz, doc, "GENERO", Double.toString(this.SCORE_GENERO));
        //AgregarNodo(raiz, doc, "COMPORTAMIENTO_PAGO", Double.toString(this.SCORE_COMPORTAMIENTO));
       // AgregarNodo(raiz, doc, "ARRAIGO", Double.toString(this.SCORE_ARRAIGO));
       // AgregarNodo(raiz, doc, "ASPECTOS_DIF", Double.toString(this.SCORE_ASPECTOS));

        if (REG_BURO == 1)
        {
        //  AgregarNodo(raiz, doc, "GENERO_CLASE_TEXTO_1", this.GENERO_DES == null ? "" : this.GENERO_DES);
        //  AgregarNodo(raiz, doc, "GENERO_CLASE_TEXTO_2", this.FRECUENCIA_RELIGION_DES == null ? "" : this.FRECUENCIA_RELIGION_DES);
        //  AgregarNodo(raiz, doc, "COMPORTAMIENTO_DE_PAGO_TEXTO_1", this.PRIMER_TEXTO_COMPORTAMIENTO == null ? "" : this.PRIMER_TEXTO_COMPORTAMIENTO);
        //  AgregarNodo(raiz, doc, "COMPORTAMIENTO_DE_PAGO_TEXTO_2", this.SEGUNDO_TEXTO_COMPORTAMIENTO == null ? "" : this.SEGUNDO_TEXTO_COMPORTAMIENTO);
       //   AgregarNodo(raiz, doc, "ARRAIGO_TEXTO_1", this.VIVIENDA_ACTUAL_DES == null ? "" : this.VIVIENDA_ACTUAL_DES);
       //   AgregarNodo(raiz, doc, "ARRAIGO_TEXTO_2", this.SITUACION_PROXIMO_ANO_DES == null ? "" : this.SITUACION_PROXIMO_ANO_DES);
       //   AgregarNodo(raiz, doc, "ASPECTOS_TEXTO_1", this.I_PSICO_DES == null ? "" : this.I_PSICO_DES);
      //    AgregarNodo(raiz, doc, "ASPECTOS_TEXTO_2", "");
        }
        else
        {
        //  AgregarNodo(raiz, doc, "GENERO_CLASE_TEXTO_1", this.GENERO_DES == null ? "" : this.GENERO_DES);
        //  AgregarNodo(raiz, doc, "GENERO_CLASE_TEXTO_2", this.ESCOLARIDAD_DES == null ? "" : this.ESCOLARIDAD_DES);
        //  AgregarNodo(raiz, doc, "COMPORTAMIENTO_DE_PAGO_TEXTO_1", this.PRIMER_TEXTO_COMPORTAMIENTO == null ? "" : this.PRIMER_TEXTO_COMPORTAMIENTO);
        //  AgregarNodo(raiz, doc, "COMPORTAMIENTO_DE_PAGO_TEXTO_2", this.SEGUNDO_TEXTO_COMPORTAMIENTO == null ? "" : this.SEGUNDO_TEXTO_COMPORTAMIENTO);
        //  AgregarNodo(raiz, doc, "ARRAIGO_TEXTO_1", this.PRIMER_TEXTO_ARRAIGO == null ? "" : this.PRIMER_TEXTO_ARRAIGO);
        //  AgregarNodo(raiz, doc, "ARRAIGO_TEXTO_2", this.SEGUNDO_TEXTO_ARRAIGO == null ? "" : this.SEGUNDO_TEXTO_ARRAIGO);
        //  AgregarNodo(raiz, doc, "ASPECTOS_TEXTO_1", this.I_PSICO_DES == null ? "" : this.I_PSICO_DES);
        //  AgregarNodo(raiz, doc, "ASPECTOS_TEXTO_2", "");
        }

      //  AgregarNodo(raiz, doc, "RESULTADO", resultado == null ? "" : resultado);

        /*TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans = transfac.newTransformer();
        trans.setOutputProperty("omit-xml-declaration", "no");
        trans.setOutputProperty("indent", "yes");

        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        DOMSource source = new DOMSource(doc);
        trans.transform(source, result);
        String xmlString = sw.toString();

          System.out.println("si llego ");
        return xmlString;*/
        return xmlString(doc);
      }

      return tabNoEncontradoExpt + "EntradaCalculadoraCG";
    }
    catch (ParserConfigurationException parE)
    {
      return xmlExpt;
    } catch (SAXException saxE) {
      return xmlExpt;
    } catch (IOException ioE) {
      return xmlExpt; } catch (Exception e) {
    }
    return null;//e.getMessage();
  }

  private String GetValue(Document doc, String nodo)
    throws Exception
  {

      System.out.println("nombre nodo :" + nodo);
      NodeList list = doc.getElementsByTagName(nodo);
      if(list.getLength() != 0){

          return list.item(0).getFirstChild().getNodeValue();
      }
      return "";

   /* NodeList listaNodos = doc.getDocumentElement().getChildNodes();
    for (int i = 0; i < listaNodos.getLength(); i++) {
      if (!listaNodos.item(i).getNodeName().equals(nodo))
        continue;
      if (listaNodos.item(i).getTextContent() != null) {
        return listaNodos.item(i).getTextContent();
      }
      throw new Exception(tabVacioExpt + nodo);
    }

    throw new Exception(tabNoEncontradoExpt + nodo);*/
  }

  private int GetValueInt(Document doc, String nodo) throws Exception
  {
      System.out.println("nombre nodo :" + nodo);
      NodeList list = doc.getElementsByTagName(nodo);
      if(list.getLength() != 0){

          return Integer.parseInt(list.item(0).getFirstChild().getNodeValue());
      }
      return -1000000000;
  /*  NodeList listaNodos = doc.getDocumentElement().getChildNodes();
    for (int i = 0; i < listaNodos.getLength(); i++)

        if (listaNodos.item(i).getNodeName().equals(nodo)) {
        //if (!listaNodos.item(i).getTextContent().equals("")) {
          
            //return Integer.parseInt(listaNodos.item(i).getTextContent());

            System.out.println(nodo);
            //String hijo = listaNodos.item(i).getFirstChild().getTextContent();
            return 1;//Integer.parseInt(hijo);

        
        //throw new Exception(tabVacioExpt + nodo);
      }
    throw new Exception(tabNoEncontradoExpt + nodo);*/
  }

  private void AgregarNodo(Element raiz, Document doc, String tab, String valor)
  {
    Element child = doc.createElement(tab);
    Text text = doc.createTextNode(String.valueOf(valor));
    child.appendChild(text);
    raiz.appendChild(child);
  }

  private double EsHit(Session s, int GENERO, int FRECUENCIA_RELIGION, int SITUACION_PROX_ANO, int DINERO_EXTRA, int VIVIENDA_ACTUAL, int SERVICIO_HOGAR, int ACT, int USO, int CUEN_ABIER_CAT, int VALOR_VIVIENDA, int NO_CREDITOS, int I_PSICO)
  {
    Query q = s.createQuery("from Sex as sex where sex.calId = '3'");
    List lista = q.list();
    this.GENERO_FACTOR = ((Sex)lista.get(GENERO - 1)).getSexPto().doubleValue();
    this.GENERO_WOE = ((Sex)lista.get(GENERO - 1)).getSexWoe().doubleValue();
    this.GENERO_DES = ((Sex)lista.get(GENERO - 1)).getSexDes();

      System.out.println(GENERO_FACTOR);
    q = s.createQuery("from FreRel as frerel where frerel.cal = '3'");
    lista = q.list();
    this.FRECUENCIA_RELIGION_FACTOR = ((FreRel)lista.get(FRECUENCIA_RELIGION - 1)).getFreRelPto().doubleValue();
    this.FRECUENCIA_RELIGION_WOE = ((FreRel)lista.get(FRECUENCIA_RELIGION - 1)).getFreRelWoe().doubleValue();
    this.FRECUENCIA_RELIGION_DES = ((FreRel)lista.get(FRECUENCIA_RELIGION - 1)).getFreRelDes();


    System.out.println(FRECUENCIA_RELIGION_FACTOR);

    q = s.createQuery("from SitPrxAn as sex where sex.calId = '3'");
    lista = q.list();
    this.SITUACION_PROXIMO_ANO_FACTOR = ((SitPrxAn)lista.get(SITUACION_PROX_ANO - 1)).getSitPrxAnPto().doubleValue();
    this.SITUACION_PROXIMO_ANO_WOE = ((SitPrxAn)lista.get(SITUACION_PROX_ANO - 1)).getSitPrxAnWoe().doubleValue();
    this.SITUACION_PROXIMO_ANO_DES = ((SitPrxAn)lista.get(SITUACION_PROX_ANO - 1)).getSitPrxAnDes();

      System.out.println(SITUACION_PROXIMO_ANO_FACTOR);

    q = s.createQuery("from DinExt as dinext where dinext.cal= '3'");
    lista = q.list();
    this.DINERO_EXTRA_FACTOR = ((DinExt)lista.get(DINERO_EXTRA - 1)).getDinExtPto().doubleValue();
    this.DINERO_EXTRA_WOE = ((DinExt)lista.get(DINERO_EXTRA - 1)).getDinExtWoe().doubleValue();
    this.DINERO_EXTRA_DES = ((DinExt)lista.get(DINERO_EXTRA - 1)).getDinExtDes();

    System.out.println("dinero extra " + DINERO_EXTRA_FACTOR);

    q = s.createQuery("from RngResAnt as sex where sex.calId = '3'");
    lista = q.list();
    this.VIVIENDA_ACTUAL_FACTOR = ((RngResAnt)lista.get(VIVIENDA_ACTUAL - 1)).getRngResAntPto().doubleValue();
    this.VIVIENDA_ACTUAL_WOE = ((RngResAnt)lista.get(VIVIENDA_ACTUAL - 1)).getRngResAntWoe().doubleValue();
    this.VIVIENDA_ACTUAL_DES = ((RngResAnt)lista.get(VIVIENDA_ACTUAL - 1)).getRngResAntDes();

      System.out.println("vivienda actual " + VIVIENDA_ACTUAL_FACTOR);


    q = s.createQuery("from Srv as sex where sex.calId = '3'");
    lista = q.list();
    this.SERVICIO_HOGAR_FACTOR = ((Srv)lista.get(SERVICIO_HOGAR - 1)).getSrvPto().doubleValue();
    this.SERVICIO_HOGAR_WOE = ((Srv)lista.get(SERVICIO_HOGAR - 1)).getSrvWoe().doubleValue();
    this.SERVICIO_HOGAR_DES = ((Srv)lista.get(SERVICIO_HOGAR - 1)).getSrvDesLar();

    System.out.println("srv " + SERVICIOS_VIVIENDA_FACTOR);

    q = s.createQuery("from BurAct as ba where ba.cal ='3'");
    lista = q.list();
    this.ACT_FACTOR = ((BurAct)lista.get(ACT - 1)).getBurActPto().doubleValue();
    this.ACT_WOE = ((BurAct)lista.get(ACT - 1)).getBurActWoe().doubleValue();
    this.ACT_TEXTO = ((BurAct)lista.get(ACT - 1)).getBurActDes();

    System.out.println("act factor " + ACT_FACTOR);

    q = s.createQuery("from BurUso as bu where bu.cal='3'");
    lista = q.list();
    this.USO_FACTOR = ((BurUso)lista.get(USO - 1)).getBurUsoPto().doubleValue();
    this.USO_WOE = ((BurUso)lista.get(USO - 1)).getBurUsoWoe().doubleValue();


      System.out.println("buruso " + USO_FACTOR);


    q = s.createQuery("from CueAbr as sex where sex.cal = '3'");
    lista = q.list();
    this.CUEN_ABIER_CAT_FACTOR = ((CueAbr)lista.get(CUEN_ABIER_CAT - 1)).getCueAbrPto().doubleValue();
    this.CUEN_ABIER_CAT_WOE = ((CueAbr)lista.get(CUEN_ABIER_CAT - 1)).getCueAbrWoe().doubleValue();
    this.CUEN_ABIER_CAT_DES = ((CueAbr)lista.get(CUEN_ABIER_CAT - 1)).getCueAbrDesLar();

    System.out.println("antes d  val con "+ VALOR_VIVIENDA);
    q = s.createQuery("from VlrViv as sex where sex.calId = '3'");
    lista = q.list();
    this.VALOR_VIVIENDA_FACTOR = ((VlrViv)lista.get(VALOR_VIVIENDA - 1)).getVlrVivPto().doubleValue();
    this.VALOR_VIVIENDA_WOE = ((VlrViv)lista.get(VALOR_VIVIENDA - 1)).getVlrVivWoe().doubleValue();
    this.VALOR_VIVIENDA_DES = ((VlrViv)lista.get(VALOR_VIVIENDA - 1)).getVlrVivDes();
    System.out.println("despues de  d  valv");
    
    q = s.createQuery("from NumCre as sex where sex.cal = '3'");
    lista = q.list();
    this.NO_CREDITOS_FACTOR = ((NumCre)lista.get(NO_CREDITOS - 1)).getNumCrePto().doubleValue();
    this.NO_CREDITOS_WOE = ((NumCre)lista.get(NO_CREDITOS - 1)).getNumCreWoe().doubleValue();
    this.NO_CREDITOS_DES = ((NumCre)lista.get(NO_CREDITOS - 1)).getNumCreDesLar();

    


    q = s.createQuery("from IPsi as ips where ips.cal = '3'and ips.IPsiLimInf<=" + this.SCORE_IPSICO_FACTOR + " and ips.IPsiLimSup>=" + this.SCORE_IPSICO_FACTOR);
    lista = q.list();
    this.I_PSICO_FACTOR = ((IPsi)lista.get(0)).getIPsiPto().doubleValue();
    this.I_PSICO_WOE = ((IPsi)lista.get(0)).getIPsiWoe().doubleValue();
    this.I_PSICO_DES = ((IPsi)lista.get(0)).getIPsiDes();

      System.out.println("hasta ipsi");

    double SCORE_HIT_FACTOR = this.GENERO_FACTOR + this.FRECUENCIA_RELIGION_FACTOR + this.SITUACION_PROXIMO_ANO_FACTOR + this.DINERO_EXTRA_FACTOR + this.VIVIENDA_ACTUAL_FACTOR + this.SERVICIO_HOGAR_FACTOR + this.ACT_FACTOR + this.USO_FACTOR + this.CUEN_ABIER_CAT_FACTOR + this.VALOR_VIVIENDA_FACTOR + this.NO_CREDITOS_FACTOR + this.I_PSICO_FACTOR;

    this.SCORE_GENERO = (this.GENERO_WOE + this.FRECUENCIA_RELIGION_WOE);

    this.SCORE_COMPORTAMIENTO = (this.DINERO_EXTRA_WOE + this.SERVICIO_HOGAR_WOE + this.ACT_WOE + this.USO_WOE + this.CUEN_ABIER_CAT_WOE + this.VALOR_VIVIENDA_WOE + this.NO_CREDITOS_WOE);

    this.SCORE_ARRAIGO = (this.VIVIENDA_ACTUAL_WOE + this.SITUACION_PROXIMO_ANO_WOE);

    this.SCORE_ASPECTOS = this.I_PSICO_WOE;

    System.out.println("VARIABLES HIT");
    System.out.println(this.GENERO_FACTOR);
    System.out.println(this.GENERO_WOE);
    System.out.println(this.GENERO_DES);
    System.out.println(this.FRECUENCIA_RELIGION_FACTOR);
    System.out.println(this.FRECUENCIA_RELIGION_WOE);
    System.out.println(this.FRECUENCIA_RELIGION_DES);
    System.out.println(this.SITUACION_PROXIMO_ANO_FACTOR);
    System.out.println(this.SITUACION_PROXIMO_ANO_WOE);
    System.out.println(this.SITUACION_PROXIMO_ANO_DES);
    System.out.println(this.DINERO_EXTRA_FACTOR);
    System.out.println(this.DINERO_EXTRA_WOE);
    System.out.println(this.DINERO_EXTRA_DES);
    System.out.println(this.VIVIENDA_ACTUAL_FACTOR);
    System.out.println(this.VIVIENDA_ACTUAL_WOE);
    System.out.println(this.VIVIENDA_ACTUAL_DES);
    System.out.println(this.SERVICIO_HOGAR_FACTOR);
    System.out.println(this.SERVICIO_HOGAR_WOE);
    System.out.println(this.SERVICIO_HOGAR_DES);
    System.out.println(this.ACT_FACTOR);
    System.out.println(this.ACT_WOE);
    System.out.println(this.ACT_TEXTO);
    System.out.println(this.USO_FACTOR);
    System.out.println(this.USO_WOE);
    System.out.println(this.CUEN_ABIER_CAT_FACTOR);
    System.out.println(this.CUEN_ABIER_CAT_WOE);
    System.out.println(this.CUEN_ABIER_CAT_DES);
    System.out.println(this.VALOR_VIVIENDA_FACTOR);
    System.out.println(this.VALOR_VIVIENDA_WOE);
    System.out.println(this.VALOR_VIVIENDA_DES);
    System.out.println(this.NO_CREDITOS_FACTOR);
    System.out.println(this.NO_CREDITOS_WOE);
    System.out.println(this.NO_CREDITOS_DES);
    System.out.println(this.I_PSICO_FACTOR);
    System.out.println(this.I_PSICO_WOE);
    System.out.println(this.I_PSICO_DES);
    System.out.println(this.SCORE_GENERO);
    System.out.println(this.SCORE_COMPORTAMIENTO);
    System.out.println(this.SCORE_ARRAIGO);
    System.out.println(this.SCORE_ASPECTOS);

    return SCORE_HIT_FACTOR;
  }

  private double EsNoHit(Session s, int RELIGION, int ESCOLARIDAD, int TRABAJO_ANTERIOR, int DINERO_EXTRA, int INGRESO_TOTAL, int GASTOS, int CUBRIR_ALIMETOS, int VESTIDO, int PRINCIPAL_PROBLEMA, int SOLICITAR_PRESTAMO, int VCS_VIV, int I_RENTA, int SERVICIOS_VIVIENDA, int RENTA, int SERVICIO_HOGAR, int VALOR_VIVIENDA, int NO_CREDITOS, int I_PSICO)
  {
    Query q = s.createQuery("from RelFam as sex where sex.calId = '5'");
    List lista = q.list();
    this.RELIGION_FACTOR = ((RelFam)lista.get(RELIGION - 1)).getRelFamPto().doubleValue();
    this.RELIGION_WOE = ((RelFam)lista.get(RELIGION - 1)).getRelFamWoe().doubleValue();

    q = s.createQuery("from NivEst as sex where sex.cal = '5'");
    lista = q.list();
    this.ESCOLARIDAD_FACTOR = ((NivEst)lista.get(ESCOLARIDAD - 1)).getNivEstPto().doubleValue();
    this.ESCOLARIDAD_WOE = ((NivEst)lista.get(ESCOLARIDAD - 1)).getNivEstWoe().doubleValue();
    this.ESCOLARIDAD_DES = ((NivEst)lista.get(ESCOLARIDAD - 1)).getNivEstDesLar();

    q = s.createQuery("from ActUlt as sex where sex.cal = '5'");
    lista = q.list();
    this.TRABAJO_ANTERIOR_FACTOR = ((ActUlt)lista.get(NO_CREDITOS - 1)).getActUltPto().doubleValue();
    this.TRABAJO_ANTERIOR_WOE = ((ActUlt)lista.get(NO_CREDITOS - 1)).getActUltWoe().doubleValue();
    this.TRABAJO_ANTERIOR_DES = ((ActUlt)lista.get(NO_CREDITOS - 1)).getActUltDesLar();

    q = s.createQuery("from DinExt as dinext where dinext.cal= '5'");
    lista = q.list();
    this.DINERO_EXTRA_FACTOR = ((DinExt)lista.get(DINERO_EXTRA - 1)).getDinExtPto().doubleValue();
    this.DINERO_EXTRA_WOE = ((DinExt)lista.get(DINERO_EXTRA - 1)).getDinExtWoe().doubleValue();
    this.DINERO_EXTRA_DES = ((DinExt)lista.get(DINERO_EXTRA - 1)).getDinExtDesLar();

    q = s.createQuery("from Ing as sex where sex.cal = '5'");
    lista = q.list();
    this.INGRESO_TOTAL_FACTOR = ((Ing)lista.get(INGRESO_TOTAL - 1)).getIngPto().doubleValue();
    this.INGRESO_TOTAL_WOE = ((Ing)lista.get(INGRESO_TOTAL - 1)).getIngWoe().doubleValue();
    this.INGRESO_TOTAL_DES = ((Ing)lista.get(INGRESO_TOTAL - 1)).getIngDesLar();

    q = s.createQuery("from GtoImp as sex where sex.cal = '5'");
    lista = q.list();
    this.GASTOS_FACTOR = ((GtoImp)lista.get(GASTOS - 1)).getGtoImpPto().doubleValue();
    this.GASTOS_WOE = ((GtoImp)lista.get(GASTOS - 1)).getGtoImpWoe().doubleValue();

    q = s.createQuery("from GtoAlm as sex where sex.cal = '5'");
    lista = q.list();
    this.CUBRIR_ALIMETOS_FACTOR = ((GtoAlm)lista.get(CUBRIR_ALIMETOS - 1)).getGtoAlmPto().doubleValue();
    this.CUBRIR_ALIMETOS_WOE = ((GtoAlm)lista.get(CUBRIR_ALIMETOS - 1)).getGtoAlmWoe().doubleValue();

    q = s.createQuery("from GtoVes as sex where sex.cal = '5'");
    lista = q.list();
    this.VESTIDO_FACTOR = ((GtoVes)lista.get(VESTIDO - 1)).getGtoVesPto().doubleValue();
    this.VESTIDO_WOE = ((GtoVes)lista.get(VESTIDO - 1)).getGtoVesWoe().doubleValue();
    this.VESTIDO_DES = ((GtoVes)lista.get(VESTIDO - 1)).getGtoVesDesLar();

    q = s.createQuery("from Pbm as sex where sex.calId = '5'");
    lista = q.list();
    this.PRINCIPAL_PROBLEMA_FACTOR = ((Pbm)lista.get(PRINCIPAL_PROBLEMA - 1)).getPbmPto().doubleValue();
    this.PRINCIPAL_PROBLEMA_WOE = ((Pbm)lista.get(PRINCIPAL_PROBLEMA - 1)).getPbmWoe().doubleValue();

    q = s.createQuery("from Ptm as sex where sex.calId = '5'");
    lista = q.list();
    this.SOLICITAR_PRESTAMO_FACTOR = ((Ptm)lista.get(SOLICITAR_PRESTAMO - 1)).getPtmPto().doubleValue();
    this.SOLICITAR_PRESTAMO_WOE = ((Ptm)lista.get(SOLICITAR_PRESTAMO - 1)).getPtmWoe().doubleValue();

    q = s.createQuery("from VcsViv as sex where sex.calId = '5'");
    lista = q.list();
    this.VCS_VIV_FACTOR = ((VcsViv)lista.get(VCS_VIV - 1)).getVcsVivPto().doubleValue();
    this.VCS_VIV_WOE = ((VcsViv)lista.get(VCS_VIV - 1)).getVcsVivWoe().doubleValue();

    q = s.createQuery("from IRnt as sex where sex.calId = '5'");
    lista = q.list();
    this.I_RENTA_FACTOR = ((IRnt)lista.get(I_RENTA - 1)).getIRntPto().doubleValue();
    this.I_RENTA_WOE = ((IRnt)lista.get(I_RENTA - 1)).getIRntWoe().doubleValue();
    this.I_RENTA_DES = ((IRnt)lista.get(I_RENTA - 1)).getIRntDesLar();

    q = s.createQuery("from GtoSerViv as sex where sex.cal.calId = '5'");
    lista = q.list();
    this.SERVICIOS_VIVIENDA_FACTOR = ((GtoSerViv)lista.get(SERVICIOS_VIVIENDA - 1)).getGtoSerVivPto().doubleValue();
    this.SERVICIOS_VIVIENDA_WOE = ((GtoSerViv)lista.get(SERVICIOS_VIVIENDA - 1)).getGtoSerVivWoe().doubleValue();
    this.SERVICIOS_VIVIENDA_DES = ((GtoSerViv)lista.get(SERVICIOS_VIVIENDA - 1)).getGtoSerVivDesLar();

    q = s.createQuery("from GtoRen as sex where sex.cal.calId = '5'");
    lista = q.list();
    this.RENTA_FACTOR = ((GtoRen)lista.get(RENTA - 1)).getGtoRenPto().doubleValue();
    this.RENTA_WOE = ((GtoRen)lista.get(RENTA - 1)).getGtoRenWoe().doubleValue();
    this.RENTA_DES = ((GtoRen)lista.get(RENTA - 1)).getGtoRenDesLar();

    q = s.createQuery("from Srv as sex where sex.calId = '5'");
    lista = q.list();
    this.SERVICIO_HOGAR_FACTOR = ((Srv)lista.get(SERVICIO_HOGAR - 1)).getSrvPto().doubleValue();
    this.SERVICIO_HOGAR_WOE = ((Srv)lista.get(SERVICIO_HOGAR - 1)).getSrvWoe().doubleValue();
    this.SERVICIO_HOGAR_DES = ((Srv)lista.get(SERVICIO_HOGAR - 1)).getSrvDesLar();

    q = s.createQuery("from VlrViv as sex where sex.calId = '5'");
    lista = q.list();
    this.VALOR_VIVIENDA_FACTOR = ((VlrViv)lista.get(VALOR_VIVIENDA - 1)).getVlrVivPto().doubleValue();
    this.VALOR_VIVIENDA_WOE = ((VlrViv)lista.get(VALOR_VIVIENDA - 1)).getVlrVivWoe().doubleValue();
    this.VALOR_VIVIENDA_DES = ((VlrViv)lista.get(VALOR_VIVIENDA - 1)).getVlrVivDesLar();

    q = s.createQuery("from NumCre as sex where sex.cal.calId = '5'");
    lista = q.list();
    this.NO_CREDITOS_FACTOR = ((NumCre)lista.get(NO_CREDITOS - 1)).getNumCrePto().doubleValue();
    this.NO_CREDITOS_WOE = ((NumCre)lista.get(NO_CREDITOS - 1)).getNumCreWoe().doubleValue();
    this.NO_CREDITOS_DES = ((NumCre)lista.get(NO_CREDITOS - 1)).getNumCreDesLar();

    q = s.createQuery("from IPsi as sex where sex.cal.calId = '5'");
    lista = q.list();
    this.I_PSICO_FACTOR = ((IPsi)lista.get(I_PSICO - 1)).getIPsiPto().doubleValue();
    this.I_PSICO_WOE = ((IPsi)lista.get(I_PSICO - 1)).getIPsiWoe().doubleValue();

    double SCORE_NO_HIT = this.RELIGION_FACTOR + this.ESCOLARIDAD_FACTOR + this.TRABAJO_ANTERIOR_FACTOR + this.DINERO_EXTRA_FACTOR + this.INGRESO_TOTAL_FACTOR + this.GASTOS_FACTOR + this.CUBRIR_ALIMETOS_FACTOR + this.VESTIDO_FACTOR + this.SERVICIOS_VIVIENDA_FACTOR + this.RENTA_FACTOR + this.SERVICIO_HOGAR_FACTOR + this.PRINCIPAL_PROBLEMA_FACTOR + this.SOLICITAR_PRESTAMO_FACTOR + this.VCS_VIV_FACTOR + this.I_RENTA_FACTOR + this.VALOR_VIVIENDA_FACTOR + this.NO_CREDITOS_FACTOR + this.I_PSICO_FACTOR;

    double SCORE_NO_HIT_WOE = this.SOLICITAR_PRESTAMO_WOE + this.VCS_VIV_WOE + this.I_RENTA_WOE + this.VALOR_VIVIENDA_WOE + this.I_PSICO_WOE;

    this.SCORE_ARRAIGO_NH = (this.TRABAJO_ANTERIOR_WOE + this.PRINCIPAL_PROBLEMA_WOE + this.NO_CREDITOS_WOE);
    this.SCORE_GENERO = (this.RELIGION_WOE + this.ESCOLARIDAD_WOE);
    this.SCORE_COMPORTAMIENTO_NH = (this.DINERO_EXTRA_WOE + this.INGRESO_TOTAL_WOE + this.GASTOS_WOE + this.CUBRIR_ALIMETOS_WOE + this.VESTIDO_WOE + this.SERVICIOS_VIVIENDA_WOE + this.RENTA_WOE + this.SERVICIO_HOGAR_WOE);

    this.SCORE_ASPECTOS = this.I_PSICO_WOE;

    System.out.println("NO HIT");
    System.out.println(this.RELIGION_FACTOR);
    System.out.println(this.RELIGION_WOE);
    System.out.println(this.ESCOLARIDAD_FACTOR);
    System.out.println(this.ESCOLARIDAD_WOE);
    System.out.println(this.ESCOLARIDAD_DES);
    System.out.println(this.TRABAJO_ANTERIOR_FACTOR);
    System.out.println(this.TRABAJO_ANTERIOR_WOE);
    System.out.println(this.TRABAJO_ANTERIOR_DES);
    System.out.println(this.DINERO_EXTRA_FACTOR);
    System.out.println(this.DINERO_EXTRA_WOE);
    System.out.println(this.DINERO_EXTRA_DES);
    System.out.println(this.INGRESO_TOTAL_FACTOR);
    System.out.println(this.INGRESO_TOTAL_WOE);
    System.out.println(this.INGRESO_TOTAL_DES);
    System.out.println(this.GASTOS_FACTOR);
    System.out.println(this.GASTOS_WOE);
    System.out.println(this.GASTOS_DES);
    System.out.println(this.CUBRIR_ALIMETOS_FACTOR);
    System.out.println(this.CUBRIR_ALIMETOS_WOE);
    System.out.println(this.CUBRIR_ALIMETOS_DES);
    System.out.println(this.VESTIDO_FACTOR);
    System.out.println(this.VESTIDO_WOE);
    System.out.println(this.VESTIDO_DES);
    System.out.println(this.PRINCIPAL_PROBLEMA_FACTOR);
    System.out.println(this.PRINCIPAL_PROBLEMA_WOE);
    System.out.println(this.PRINCIPAL_PROBLEMA_DES);
    System.out.println(this.SOLICITAR_PRESTAMO_FACTOR);
    System.out.println(this.SOLICITAR_PRESTAMO_WOE);
    System.out.println(this.VCS_VIV_FACTOR);
    System.out.println(this.VCS_VIV_WOE);
    System.out.println(this.I_RENTA_FACTOR);
    System.out.println(this.I_RENTA_WOE);
    System.out.println(this.SERVICIOS_VIVIENDA_FACTOR);
    System.out.println(this.SERVICIOS_VIVIENDA_WOE);
    System.out.println(this.SERVICIOS_VIVIENDA_DES);
    System.out.println(this.RENTA_FACTOR);
    System.out.println(this.RENTA_WOE);
    System.out.println(this.RENTA_DES);
    System.out.println(this.SERVICIO_HOGAR_FACTOR);
    System.out.println(this.SERVICIO_HOGAR_WOE);
    System.out.println(this.SERVICIO_HOGAR_DES);
    System.out.println(this.VALOR_VIVIENDA_FACTOR);
    System.out.println(this.VALOR_VIVIENDA_WOE);
    System.out.println(this.VALOR_VIVIENDA_DES);
    System.out.println(this.NO_CREDITOS_FACTOR);
    System.out.println(this.NO_CREDITOS_WOE);
    System.out.println(this.I_PSICO_FACTOR);
    System.out.println(this.I_PSICO_WOE);
    System.out.println(SCORE_NO_HIT);
    System.out.println(SCORE_NO_HIT_WOE);
    System.out.println(this.SCORE_ARRAIGO_NH);
    System.out.println(this.SCORE_GENERO);
    System.out.println(this.SCORE_COMPORTAMIENTO_NH);
    System.out.println(CUBRIR_ALIMETOS);
    System.out.println(this.SCORE_ASPECTOS);

    return SCORE_NO_HIT;
  }

  private double CalculoBuroMeta(Session s, int ACT, int HIST, int ANT, int USO, int PAGO)
  {
    Query q = s.createQuery("from BurAct as ba where ba.cal='4'");
    List lista = q.list();
    this.ACT_FACTOR = ((BurAct)lista.get(ACT - 1)).getBurActPto().doubleValue();
    this.ACT_WOE = ((BurAct)lista.get(ACT - 1)).getBurActWoe().doubleValue();
    this.ACT_TEXTO = ((BurAct)lista.get(ACT - 1)).getBurActDes();

    q = s.createQuery("from BurHis as bh where bh.cal='4'");
    lista = q.list();
    this.HIST_FACTOR = ((BurHis)lista.get(HIST - 1)).getBurHisPto().doubleValue();
    this.HIST_WOE = ((BurHis)lista.get(HIST - 1)).getBurHisWoe().doubleValue();
    this.HIST_TEXTO = ((BurHis)lista.get(HIST - 1)).getBurHisDes();

    q = s.createQuery("from BurAnt as ba where ba.cal='4'");
    lista = q.list();
    this.ANT_FACTOR = ((BurAnt)lista.get(ANT - 1)).getBurAntPto().doubleValue();
    this.ANT_WOE = ((BurAnt)lista.get(ANT - 1)).getBurAntWoe().doubleValue();
    this.ANT_TEXTO = ((BurAnt)lista.get(ANT - 1)).getBurAntDes();

    q = s.createQuery("from BurUso as bu where bu.cal='4'");
    lista = q.list();
    this.USO_FACTOR = ((BurUso)lista.get(USO - 1)).getBurUsoPto().doubleValue();
    this.USO_WOE = ((BurUso)lista.get(USO - 1)).getBurUsoWoe().doubleValue();
    this.USO_TEXTO = ((BurUso)lista.get(USO - 1)).getBurUsoDes();

    q = s.createQuery("from BurPag as bp where bp.cal='4'");
    lista = q.list();
    this.PAGO_FACTOR = ((BurPag)lista.get(PAGO - 1)).getBurPagPto().doubleValue();
    this.PAGO_WOE = ((BurPag)lista.get(PAGO - 1)).getBurPagWoe().doubleValue();
    this.PAGO_TEXTO = ((BurPag)lista.get(PAGO - 1)).getBurPagDes();

    double SCORE_BURO = this.ACT_FACTOR + this.HIST_FACTOR + this.ANT_FACTOR + this.USO_FACTOR + this.PAGO_FACTOR;

    return SCORE_BURO;
  }

  private void PsicoSocial(Session s, int AGRESION_1, int AGRESION_4, int ADHESION_GRUPO3, int RESENTIMIENTO_SOCIAL3, int CONDUCTA_DELICTIVA2, int RESENTIMIENTO_SOCIAL4, int RESPONSABILIDAD4, int CONDUCTA_DELICTIVA5)
  {
    Query q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '1'");
    List lista = q.list();
    this.AGRESION_1_FACTOR = ((RelPsiSoc)lista.get(AGRESION_1 - 1)).getRelPsiSocPto().doubleValue();
    this.AGRESION_1_WOE = ((RelPsiSoc)lista.get(AGRESION_1 - 1)).getRelPsiSocWoe().doubleValue();

    q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '8'");
    lista = q.list();
    this.AGRESION_4_FACTOR = ((RelPsiSoc)lista.get(AGRESION_4 - 1)).getRelPsiSocPto().doubleValue();
    this.AGRESION_4_WOE = ((RelPsiSoc)lista.get(AGRESION_4 - 1)).getRelPsiSocWoe().doubleValue();

    q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '10'");
    lista = q.list();
    this.ADHESION_GRUPO3_FACTOR = ((RelPsiSoc)lista.get(ADHESION_GRUPO3 - 1)).getRelPsiSocPto().doubleValue();
    this.ADHESION_GRUPO3_WOE = ((RelPsiSoc)lista.get(ADHESION_GRUPO3 - 1)).getRelPsiSocWoe().doubleValue();

    q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '11'");
    lista = q.list();
    this.RESENTIMIENTO_SOCIAL3_FACTOR = ((RelPsiSoc)lista.get(RESENTIMIENTO_SOCIAL3 - 1)).getRelPsiSocPto().doubleValue();
    this.RESENTIMIENTO_SOCIAL3_WOE = ((RelPsiSoc)lista.get(RESENTIMIENTO_SOCIAL3 - 1)).getRelPsiSocWoe().doubleValue();

    q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '15'");
    lista = q.list();
    this.CONDUCTA_DELICTIVA2_FACTOR = ((RelPsiSoc)lista.get(CONDUCTA_DELICTIVA2 - 1)).getRelPsiSocPto().doubleValue();
    this.CONDUCTA_DELICTIVA2_WOE = ((RelPsiSoc)lista.get(CONDUCTA_DELICTIVA2 - 1)).getRelPsiSocWoe().doubleValue();

    q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '17'");
    lista = q.list();
    this.RESENTIMIENTO_SOCIAL4_FACTOR = ((RelPsiSoc)lista.get(RESENTIMIENTO_SOCIAL4 - 1)).getRelPsiSocPto().doubleValue();
    this.RESENTIMIENTO_SOCIAL4_WOE = ((RelPsiSoc)lista.get(RESENTIMIENTO_SOCIAL4 - 1)).getRelPsiSocWoe().doubleValue();

    q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '18'");
    lista = q.list();
    this.RESPONSABILIDAD4_FACTOR = ((RelPsiSoc)lista.get(RESPONSABILIDAD4 - 1)).getRelPsiSocPto().doubleValue();
    this.RESPONSABILIDAD4_WOE = ((RelPsiSoc)lista.get(RESPONSABILIDAD4 - 1)).getRelPsiSocWoe().doubleValue();

    q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '25'");
    lista = q.list();
    this.CONDUCTA_DELICTIVA5_FACTOR = ((RelPsiSoc)lista.get(CONDUCTA_DELICTIVA5 - 1)).getRelPsiSocPto().doubleValue();
    this.CONDUCTA_DELICTIVA5_WOE = ((RelPsiSoc)lista.get(CONDUCTA_DELICTIVA5 - 1)).getRelPsiSocWoe().doubleValue();

    this.SCORE_IPSICO_FACTOR = (this.AGRESION_1_FACTOR + this.AGRESION_4_FACTOR + this.ADHESION_GRUPO3_FACTOR + this.RESENTIMIENTO_SOCIAL3_FACTOR + this.CONDUCTA_DELICTIVA2_FACTOR + this.RESENTIMIENTO_SOCIAL4_FACTOR + this.RESPONSABILIDAD4_FACTOR + this.CONDUCTA_DELICTIVA5_FACTOR);

    this.SCORE_IPSICO_WOE = (this.AGRESION_1_WOE + this.AGRESION_4_WOE + this.ADHESION_GRUPO3_WOE + this.RESENTIMIENTO_SOCIAL3_WOE + this.CONDUCTA_DELICTIVA2_WOE + this.RESENTIMIENTO_SOCIAL4_WOE + this.RESPONSABILIDAD4_WOE + this.CONDUCTA_DELICTIVA5_WOE);

    System.out.println("PSICO");
    System.out.println(this.AGRESION_1_FACTOR);
    System.out.println(this.AGRESION_1_WOE);
    System.out.println(this.AGRESION_4_FACTOR);
    System.out.println(this.AGRESION_4_WOE);
    System.out.println(this.ADHESION_GRUPO3_FACTOR);
    System.out.println(this.ADHESION_GRUPO3_WOE);
    System.out.println(this.RESENTIMIENTO_SOCIAL3_FACTOR);
    System.out.println(this.RESENTIMIENTO_SOCIAL3_WOE);
    System.out.println(this.CONDUCTA_DELICTIVA2_FACTOR);
    System.out.println(this.CONDUCTA_DELICTIVA2_WOE);
    System.out.println(this.RESENTIMIENTO_SOCIAL4_FACTOR);
    System.out.println(this.RESENTIMIENTO_SOCIAL4_WOE);
    System.out.println(this.RESPONSABILIDAD4_FACTOR);
    System.out.println(this.RESPONSABILIDAD4_WOE);
    System.out.println(this.CONDUCTA_DELICTIVA5_FACTOR);
    System.out.println(this.CONDUCTA_DELICTIVA5_WOE);
    System.out.println(this.SCORE_IPSICO_FACTOR);
    System.out.println(this.SCORE_IPSICO_WOE);
  }

  private void obtenerDescripcion_NH()
  {
    this.DINERO_EXTRA_FACTOR = ABSOLUTO(this.DINERO_EXTRA_FACTOR);
    this.INGRESO_TOTAL_FACTOR = ABSOLUTO(this.DINERO_EXTRA_FACTOR);
    this.GASTOS_FACTOR = ABSOLUTO(this.DINERO_EXTRA_FACTOR);
    this.CUBRIR_ALIMETOS_FACTOR = ABSOLUTO(this.DINERO_EXTRA_FACTOR);
    this.VESTIDO_FACTOR = ABSOLUTO(this.DINERO_EXTRA_FACTOR);
    this.SERVICIOS_VIVIENDA_FACTOR = ABSOLUTO(this.DINERO_EXTRA_FACTOR);
    this.RENTA_FACTOR = ABSOLUTO(this.RENTA_FACTOR);
    this.SERVICIO_HOGAR_FACTOR = ABSOLUTO(this.DINERO_EXTRA_FACTOR);

    String[] arregloTex = { this.DINERO_EXTRA_DES, this.INGRESO_TOTAL_DES, this.GASTOS_DES, this.CUBRIR_ALIMETOS_DES, this.VESTIDO_DES, this.SERVICIOS_VIVIENDA_DES, this.RENTA_DES, this.SERVICIO_HOGAR_DES };

    double[] arregloDes = { this.DINERO_EXTRA_FACTOR, this.INGRESO_TOTAL_FACTOR, this.GASTOS_FACTOR, this.CUBRIR_ALIMETOS_FACTOR, this.VESTIDO_FACTOR, this.SERVICIOS_VIVIENDA_FACTOR, this.RENTA_FACTOR, this.SERVICIO_HOGAR_FACTOR };

    ordena(arregloDes, arregloTex);
    this.PRIMER_PESO_COMPORTAMIENTO_NH = arregloDes[0];
    this.PRIMER_TEXTO_COMPORTAMIENTO_NH = arregloTex[0];
    this.SEGUNDO_PESO_COMPORTAMIENTO_NH = arregloDes[1];
    this.SEGUNDO_TEXTO_COMPORTAMIENTO_NH = arregloTex[1];

    System.out.println("COMPORTAMIENTO_NH");
    System.out.println(this.PRIMER_PESO_COMPORTAMIENTO_NH);
    System.out.println(this.PRIMER_TEXTO_COMPORTAMIENTO_NH);
    System.out.println(this.SEGUNDO_PESO_COMPORTAMIENTO_NH);
    System.out.println(this.SEGUNDO_TEXTO_COMPORTAMIENTO_NH);
  }

  private void obtenerDescripcion()
  {
    this.DINERO_EXTRA_FACTOR = ABSOLUTO(this.DINERO_EXTRA_FACTOR);
    this.SERVICIO_HOGAR_FACTOR = ABSOLUTO(this.SERVICIO_HOGAR_FACTOR);
    this.ACT_FACTOR = ABSOLUTO(this.ACT_FACTOR);
    this.USO_FACTOR = ABSOLUTO(this.USO_FACTOR);
    this.CUEN_ABIER_CAT_FACTOR = ABSOLUTO(this.CUEN_ABIER_CAT_FACTOR);
    this.VALOR_VIVIENDA_FACTOR = ABSOLUTO(this.VALOR_VIVIENDA_FACTOR);
    this.NO_CREDITOS_FACTOR = ABSOLUTO(this.NO_CREDITOS_FACTOR);

    String[] arregloTex = { this.DINERO_EXTRA_DES, this.SERVICIO_HOGAR_DES, this.ACT_TEXTO, this.USO_TEXTO, this.CUEN_ABIER_CAT_DES, this.VALOR_VIVIENDA_DES, this.NO_CREDITOS_DES };

    double[] arregloDes = { this.DINERO_EXTRA_FACTOR, this.SERVICIO_HOGAR_FACTOR, this.ACT_FACTOR, this.USO_FACTOR, this.CUEN_ABIER_CAT_FACTOR, this.VALOR_VIVIENDA_FACTOR, this.NO_CREDITOS_FACTOR };

    ordena(arregloDes, arregloTex);
    this.PRIMER_PESO_COMPORTAMIENTO = arregloDes[0];
    this.PRIMER_TEXTO_COMPORTAMIENTO = arregloTex[0];
    this.SEGUNDO_PESO_COMPORTAMIENTO = arregloDes[1];
    this.SEGUNDO_TEXTO_COMPORTAMIENTO = arregloTex[1];

    System.out.println("COMPORTAMIENTO");
    System.out.println(this.PRIMER_PESO_COMPORTAMIENTO);
    System.out.println(this.PRIMER_TEXTO_COMPORTAMIENTO);
    System.out.println(this.SEGUNDO_PESO_COMPORTAMIENTO);
    System.out.println(this.SEGUNDO_TEXTO_COMPORTAMIENTO);
  }

  private void obtenerArraigo()
  {
    this.TRABAJO_ANTERIOR_FACTOR = ABSOLUTO(this.TRABAJO_ANTERIOR_FACTOR);
    this.PRINCIPAL_PROBLEMA_FACTOR = ABSOLUTO(this.PRINCIPAL_PROBLEMA_FACTOR);
    this.NO_CREDITOS_FACTOR = ABSOLUTO(this.NO_CREDITOS_FACTOR);

    String[] arregloTex = { this.TRABAJO_ANTERIOR_DES, this.PRINCIPAL_PROBLEMA_DES, this.NO_CREDITOS_DES };

    double[] arregloDes = { this.TRABAJO_ANTERIOR_FACTOR, this.PRINCIPAL_PROBLEMA_FACTOR, this.NO_CREDITOS_FACTOR };

    ordena(arregloDes, arregloTex);
    this.PRIMER_PESO_ARRAIGO = arregloDes[0];
    this.PRIMER_TEXTO_ARRAIGO = arregloTex[0];
    this.SEGUNDO_PESO_ARRAIGO = arregloDes[1];
    this.SEGUNDO_TEXTO_ARRAIGO = arregloTex[1];

    System.out.println("ARRAIGO");
    System.out.println(this.PRIMER_PESO_ARRAIGO);
    System.out.println(this.PRIMER_TEXTO_ARRAIGO);
    System.out.println(this.SEGUNDO_PESO_ARRAIGO);
    System.out.println(this.SEGUNDO_TEXTO_ARRAIGO);
  }

  private double ABSOLUTO(double variable)
  {
    return Math.abs(variable);
  }

  private void ordena(double[] arregloDes, String[] arregloTex)
  {
    for (int i = 0; i < arregloDes.length - 1; i++)
      for (int j = i + 1; j < arregloDes.length; j++)
        if (arregloDes[i] < arregloDes[j]) {
          double tempD = arregloDes[i];
          arregloDes[i] = arregloDes[j];
          arregloDes[j] = tempD;
          String tempS = arregloTex[i];
          arregloTex[i] = arregloTex[j];
          arregloTex[j] = tempS;
        }
  }




    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        CalculadoraCGWS cal = new CalculadoraCGWS();
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><EntradaCalculadoraCG><CLI_ID>1</CLI_ID><CLI_SAP>1</CLI_SAP><CLI_APE_PAT>A</CLI_APE_PAT><CLI_APE_MAT>B</CLI_APE_MAT><CLI_NOM>C</CLI_NOM><CLI_FEC_NAC>1</CLI_FEC_NAC><CLI_DOM_CAL>UNO</CLI_DOM_CAL><CLI_DOM_NUM_EXT>1</CLI_DOM_NUM_EXT><CLI_DOM_NUM_INT>1</CLI_DOM_NUM_INT><CLI_DOM_COL>DOS</CLI_DOM_COL><CLI_POS_ID>54961</CLI_POS_ID><GENERO>2</GENERO><RELIGION>1</RELIGION><FRECUENCIA_RELIGION>2</FRECUENCIA_RELIGION><ESCOLARIDAD>4</ESCOLARIDAD><TRABAJO_ANTERIOR>1</TRABAJO_ANTERIOR><AGRESION_1>3</AGRESION_1><AGRESION_4>3</AGRESION_4><ADHESION_GRUPO3>3</ADHESION_GRUPO3><RESENTIMIENTO_SOCIAL3>3</RESENTIMIENTO_SOCIAL3><CONDUCTA_DELICTIVA2>4</CONDUCTA_DELICTIVA2><RESENTIMIENTO_SOCIAL4>3</RESENTIMIENTO_SOCIAL4><RESPONSABILIDAD4>3</RESPONSABILIDAD4><CONDUCTA_DELICTIVA5>3</CONDUCTA_DELICTIVA5><DINERO_EXTRA>6</DINERO_EXTRA><VIVIENDA_ACTUAL>4</VIVIENDA_ACTUAL><SERVICIO_HOGAR>9</SERVICIO_HOGAR><ACT>2</ACT><HIST>1</HIST><ANT>1</ANT><PAGO>1</PAGO><USO>6</USO><CUEN_ABIER_CAT>1</CUEN_ABIER_CAT><VALOR_VIVIENDA>1</VALOR_VIVIENDA><NO_CREDITOS>7</NO_CREDITOS><I_PSICO>2</I_PSICO><INGRESO_TOTAL>1200</INGRESO_TOTAL><GASTOS>1</GASTOS><CUBRIR_ALIMETOS>1</CUBRIR_ALIMETOS><VESTIDO>1</VESTIDO><SERVICIOS_VIVIENDA>1</SERVICIOS_VIVIENDA><RENTA>1</RENTA><PRINCIPAL_PROBLEMA>1</PRINCIPAL_PROBLEMA><SOLICITAR_PRESTAMO>1</SOLICITAR_PRESTAMO><VCS_VIV>1</VCS_VIV><I_RENTA>1</I_RENTA><SITUACION_PROX_ANO>1</SITUACION_PROX_ANO><TARJETA_CREDITO>1</TARJETA_CREDITO><CUENTA_CHEQUES>1</CUENTA_CHEQUES><CREDITO_PERSONAL>2</CREDITO_PERSONAL><CREDITO_AUTO>1</CREDITO_AUTO><CREDITO_HIPO>2</CREDITO_HIPO><CREDITO_OTROS>1</CREDITO_OTROS><REG_BURO>1</REG_BURO></EntradaCalculadoraCG>";

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();


        InputSource is = new InputSource(new StringReader(xml));
        Document doc = db.parse(is);
        System.out.println(doc.getElementsByTagName("CLI_ID").item(0).getClass());
      //  doc.setXmlStandalone(false);

        cal.xmlString(doc);

        //cal.CalcularCG(xml);

    }
    
     private String xmlString(Document doc) {

        try {


           StringWriter stw = new StringWriter();
           Transformer serializer = TransformerFactory.newInstance().newTransformer();
           serializer.transform(new DOMSource(doc), new StreamResult(stw));
           return stw.toString();

        } catch (TransformerException ex) {
            Logger.getLogger(CalculadoraCGWS.class.getName()).log(Level.SEVERE, null, ex);         
        } return null;
    }




}