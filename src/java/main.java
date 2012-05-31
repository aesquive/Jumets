


import java.io.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gcasillascos
 */
public class main {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{

        // CalculadoraCGWS cal = new CalculadoraCGWS();

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CalculadoraAUHI><RelFam>1</RelFam><NivEst>2</NivEst><ActUlt>2</ActUlt><DinExt>25</DinExt><GtoImp>3</GtoImp><GtoAlm>2</GtoAlm><GtoVes>15</GtoVes><GtoSerViv>4</GtoSerViv><Srv>20</Srv><Pbm>6</Pbm><Ptm>10</Ptm><Rol>4</Rol><FreRel>14</FreRel><EdoCvl>3</EdoCvl><VivAct>4</VivAct><SitPrxAn>7</SitPrxAn><CliGolBurCre>1</CliGolBurCre><CliGolIng>7500.0</CliGolIng><CliGolImpRen>1500.0</CliGolImpRen><CliGolRvc>450000.0</CliGolRvc><ActUlt>2</ActUlt><CliGolBimCon>15.0</CliGolBimCon><CliGolResAct>10</CliGolResAct><BurAct>1</BurAct><BurHis>1</BurHis><BurAbt>1</BurAbt><BurAnt>1</BurAnt><BurUso>1</BurUso><BurPag>1</BurPag><CliBurValr>100000</CliBurValr><CliBurMens>1000</CliBurMens><CliEdad>30</CliEdad><Sex>5</Sex><CliGolP1>1</CliGolP1><CliGolP2>1</CliGolP2><CliGolP3>1</CliGolP3><CliGolP4>1</CliGolP4><CliGolP5>1</CliGolP5><CliGolP6>1</CliGolP6><CliGolP7>1</CliGolP7><CliGolP8>1</CliGolP8><CliGolP9>1</CliGolP9><CliGolP10>1</CliGolP10><CliGolP11>1</CliGolP11><CliGolP12>1</CliGolP12><CliGolP13>1</CliGolP13><CliGolP14>1</CliGolP14><CliGolP15>1</CliGolP15><CliGolP16>1</CliGolP16><CliGolP17>1</CliGolP17><CliGolP18>1</CliGolP18><CliGolP19>1</CliGolP19><CliGolP20>1</CliGolP20><CliGolP21>1</CliGolP21><CliGolP22>1</CliGolP22><CliGolP23>1</CliGolP23><CliGolP24>1</CliGolP24><CliGolP25>1</CliGolP25><CliGolCtaChe>2</CliGolCtaChe><CliGolCrePer>2</CliGolCrePer><CliGolCreAut>2</CliGolCreAut><CliGolCreHip>2</CliGolCreHip><CliGolOtrCre>2</CliGolOtrCre></CalculadoraAUHI>";
        String xml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><EntradaCalculadoraCG><CLI_ID>1</CLI_ID><CLI_SAP>1</CLI_SAP><CLI_APE_PAT>A</CLI_APE_PAT><CLI_APE_MAT>B</CLI_APE_MAT><CLI_NOM>C</CLI_NOM><CLI_FEC_NAC>1</CLI_FEC_NAC><CLI_DOM_CAL>UNO</CLI_DOM_CAL><CLI_DOM_NUM_EXT>1</CLI_DOM_NUM_EXT><CLI_DOM_NUM_INT>1</CLI_DOM_NUM_INT><CLI_DOM_COL>DOS</CLI_DOM_COL><CLI_POS_ID>54961</CLI_POS_ID><GENERO>2</GENERO><RELIGION>1</RELIGION><FRECUENCIA_RELIGION>2</FRECUENCIA_RELIGION><ESCOLARIDAD>4</ESCOLARIDAD><TRABAJO_ANTERIOR>1</TRABAJO_ANTERIOR><AGRESION_1>3</AGRESION_1><AGRESION_4>3</AGRESION_4><ADHESION_GRUPO3>3</ADHESION_GRUPO3><RESENTIMIENTO_SOCIAL3>3</RESENTIMIENTO_SOCIAL3><CONDUCTA_DELICTIVA2>4</CONDUCTA_DELICTIVA2><RESENTIMIENTO_SOCIAL4>3</RESENTIMIENTO_SOCIAL4><RESPONSABILIDAD4>3</RESPONSABILIDAD4><CONDUCTA_DELICTIVA5>3</CONDUCTA_DELICTIVA5><DINERO_EXTRA>6</DINERO_EXTRA><VIVIENDA_ACTUAL>4</VIVIENDA_ACTUAL><SERVICIO_HOGAR>9</SERVICIO_HOGAR><ACT>2</ACT><HIST>1</HIST><ANT>1</ANT><PAGO>1</PAGO><USO>6</USO><CUEN_ABIER_CAT>1</CUEN_ABIER_CAT><VALOR_VIVIENDA>150000</VALOR_VIVIENDA><NO_CREDITOS>7</NO_CREDITOS><I_PSICO>2</I_PSICO><INGRESO_TOTAL>1200</INGRESO_TOTAL><GASTOS>1</GASTOS><CUBRIR_ALIMETOS>1</CUBRIR_ALIMETOS><VESTIDO>1</VESTIDO><SERVICIOS_VIVIENDA>1</SERVICIOS_VIVIENDA><RENTA>1</RENTA><PRINCIPAL_PROBLEMA>1</PRINCIPAL_PROBLEMA><SOLICITAR_PRESTAMO>1</SOLICITAR_PRESTAMO><VCS_VIV>1</VCS_VIV><I_RENTA>1</I_RENTA><SITUACION_PROX_ANO>1</SITUACION_PROX_ANO><TARJETA_CREDITO>1</TARJETA_CREDITO><CUENTA_CHEQUES>1</CUENTA_CHEQUES><CREDITO_PERSONAL>2</CREDITO_PERSONAL><CREDITO_AUTO>1</CREDITO_AUTO><CREDITO_HIPO>2</CREDITO_HIPO><CREDITO_OTROS>1</CREDITO_OTROS><REG_BURO>1</REG_BURO></EntradaCalculadoraCG>";
        String xml3 = "<hola><RelFam>lalala</RelFam></hola>";

        //cal.CalcularCG(xml);
    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        InputSource is = new InputSource(new StringReader(xml3));
        Document doc = db.parse(is);

        NodeList var = doc.getElementsByTagName("RelFam");
        System.out.println(var.item(0).getFirstChild().getNodeValue());

       
        //System.out.println(list.item(0).getFirstChild().getTextContent());


    }

}
