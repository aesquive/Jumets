/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.gol;

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
import objetos.*;
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
public class GolWs {
	static String xmlVacioExpt = "Estructura de Xml Vacia";
	static String xmlExpt = "Estructura de Xml  con Error";
	static String tabNoEncontradoExpt = "Tab No encontrado: ";
	static String tabVacioExpt = "Valor Tab Vacio: ";
	static String accesoDatosExpt = "Ocurrio un error en acceso a Datos";
	static String datosErrorExpt = "Valor Tab debe ser superior a 0:";

	// VALORES HIT
	double GENERO_FACTOR = 0;
	double GENERO_WOE = 0;
	String GENERO_DES = "";
	double FRECUENCIA_RELIGION_FACTOR = 0;
	double FRECUENCIA_RELIGION_WOE = 0;
	String FRECUENCIA_RELIGION_DES = "";
	double SITUACION_PROXIMO_ANO_FACTOR = 0;
	double SITUACION_PROXIMO_ANO_WOE = 0;
	String SITUACION_PROXIMO_ANO_DES = "";
	double DINERO_EXTRA_FACTOR = 0;
	double DINERO_EXTRA_WOE = 0;
	String DINERO_EXTRA_DES = "";
	double VIVIENDA_ACTUAL_FACTOR = 0;
	double VIVIENDA_ACTUAL_WOE = 0;
	String VIVIENDA_ACTUAL_DES = "";
	double SERVICIO_HOGAR_FACTOR = 0;
	double SERVICIO_HOGAR_WOE = 0;
	double ACT_FACTOR = 0;
	double ACT_WOE = 0;
	String ACT_TEXTO = "";
	double USO_FACTOR = 0;
	double USO_WOE = 0;
	double CUEN_ABIER_CAT_FACTOR = 0;
	double CUEN_ABIER_CAT_WOE = 0;
	String CUEN_ABIER_CAT_DES = "";
	double VALOR_VIVIENDA_FACTOR = 0;
	double VALOR_VIVIENDA_WOE = 0;
	double NO_CREDITOS_FACTOR = 0;
	double NO_CREDITOS_WOE = 0;
	String NO_CREDITOS_DES = "";
	double I_PSICO_FACTOR = 0;
	double I_PSICO_WOE = 0;
	String I_PSICO_DES = "";

	// VALORES NO HIT
	double RELIGION_FACTOR = 0;
	double RELIGION_WOE = 0;
	double ESCOLARIDAD_FACTOR = 0;
	double ESCOLARIDAD_WOE = 0;
	String ESCOLARIDAD_DES = "";
	double TRABAJO_ANTERIOR_FACTOR = 0;
	double TRABAJO_ANTERIOR_WOE = 0;
	String TRABAJO_ANTERIOR_DES = "";
	// double DINERO_EXTRA_FACTOR = 0;
	// double DINERO_EXTRA_WOE = 0;
	// double DINERO_EXTRA_DES = "";
	double INGRESO_TOTAL_FACTOR = 0;
	double INGRESO_TOTAL_WOE = 0;
	String INGRESO_TOTAL_DES = "";
	double GASTOS_FACTOR = 0;
	double GASTOS_WOE = 0;
	String GASTOS_DES = "";
	double CUBRIR_ALIMETOS_FACTOR = 0;
	double CUBRIR_ALIMETOS_WOE = 0;
	String CUBRIR_ALIMETOS_DES = "";
	double VESTIDO_FACTOR = 0;
	double VESTIDO_WOE = 0;
	String VESTIDO_DES = "";
	double PRINCIPAL_PROBLEMA_FACTOR = 0;
	double PRINCIPAL_PROBLEMA_WOE = 0;
	String PRINCIPAL_PROBLEMA_DES = "";
	double SOLICITAR_PRESTAMO_FACTOR = 0;
	double SOLICITAR_PRESTAMO_WOE = 0;
	double VCS_VIV_FACTOR = 0;
	double VCS_VIV_WOE = 0;
	double I_RENTA_FACTOR = 0;
	double I_RENTA_WOE = 0;
	double SERVICIOS_VIVIENDA_FACTOR = 0;
	double SERVICIOS_VIVIENDA_WOE = 0;
	String SERVICIOS_VIVIENDA_DES = "";
	double RENTA_FACTOR = 0;
	double RENTA_WOE = 0;
	String RENTA_DES = "";
	// double SERVICIO_HOGAR_FACTOR = 0;
	// double SERVICIO_HOGAR_WOE = 0;
	String SERVICIO_HOGAR_DES = "";
	// double VALOR_VIVIENDA_FACTOR = 0;
	// double VALOR_VIVIENDA_WOE = 0;
	String VALOR_VIVIENDA_DES = "";
	// double NO_CREDITOS_FACTOR = 0;
	// double NO_CREDITOS_WOE = 0;
	// double I_PSICO_FACTOR = 0;
	// double I_PSICO_WOE = 0;

	// VALORES BURO
	// double ACT_FACTOR = 0;
	// double ACT_WOE = 0;
	// String ACT_TEXTO = "";

	double HIST_FACTOR = 0;
	double HIST_WOE = 0;
	String HIST_TEXTO = "";

	double ANT_FACTOR = 0;
	double ANT_WOE = 0;
	String ANT_TEXTO = "";

	// double USO_FACTOR = 0;
	// double USO_WOE = 0;
	String USO_TEXTO = "";

	double PAGO_FACTOR = 0;
	double PAGO_WOE = 0;
	String PAGO_TEXTO = "";

	// PSICO_SOCIAL
	double AGRESION_1_FACTOR = 0;
	double AGRESION_1_WOE = 0;
	double AGRESION_4_FACTOR = 0;
	double AGRESION_4_WOE = 0;
	double ADHESION_GRUPO3_FACTOR = 0;
	double ADHESION_GRUPO3_WOE = 0;
	double RESENTIMIENTO_SOCIAL3_FACTOR = 0;
	double RESENTIMIENTO_SOCIAL3_WOE = 0;
	double CONDUCTA_DELICTIVA2_FACTOR = 0;
	double CONDUCTA_DELICTIVA2_WOE = 0;
	double RESENTIMIENTO_SOCIAL4_FACTOR = 0;
	double RESENTIMIENTO_SOCIAL4_WOE = 0;
	double RESPONSABILIDAD4_FACTOR = 0;
	double RESPONSABILIDAD4_WOE = 0;
	double CONDUCTA_DELICTIVA5_FACTOR = 0;
	double CONDUCTA_DELICTIVA5_WOE = 0;

	double PRIMER_PESO_COMPORTAMIENTO = 0;
	String PRIMER_TEXTO_COMPORTAMIENTO = "";
	double SEGUNDO_PESO_COMPORTAMIENTO = 0;
	String SEGUNDO_TEXTO_COMPORTAMIENTO = "";
	double PRIMER_PESO_COMPORTAMIENTO_NH = 0;
	String PRIMER_TEXTO_COMPORTAMIENTO_NH = "";
	double SEGUNDO_PESO_COMPORTAMIENTO_NH = 0;
	String SEGUNDO_TEXTO_COMPORTAMIENTO_NH = "";
	double SCORE_ARRAIGO = 0;
	double SCORE_GENERO = 0;
	double SCORE_COMPORTAMIENTO = 0;
	double SCORE_ASPECTOS = 0;

	double SCORE_ARRAIGO_NH = 0;
	double SCORE_COMPORTAMIENTO_NH = 0;

	double PRIMER_PESO_ARRAIGO = 0;
	String PRIMER_TEXTO_ARRAIGO = "";
	double SEGUNDO_PESO_ARRAIGO = 0;
	String SEGUNDO_TEXTO_ARRAIGO = "";

	/**
	 * Web service operation
	 */
	@WebMethod(operationName = "CalcularCG")
	public String CalcularCG(@WebParam(name = "xml") String xml) {

		try {
			if (xml == null)
				return xmlVacioExpt;
			ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
			DocumentBuilderFactory dbfacIN = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilderIN = dbfacIN.newDocumentBuilder();
			Document docIN = docBuilderIN.parse(bais);

			if (docIN.getDocumentElement().getNodeName().equals(
					"EntradaCalculadoraCG")) {
				int cliId = this.GetValueInt(docIN, "CLI_ID");
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
				int FRECUENCIA_RELIGION = GetValueInt(docIN,
						"FRECUENCIA_RELIGION");
				int ESCOLARIDAD = GetValueInt(docIN, "ESCOLARIDAD");
				int TRABAJO_ANTERIOR = GetValueInt(docIN, "TRABAJO_ANTERIOR");
				int AGRESION_1 = GetValueInt(docIN, "AGRESION_1");
				int AGRESION_4 = GetValueInt(docIN, "AGRESION_4");
				int ADHESION_GRUPO3 = GetValueInt(docIN, "ADHESION_GRUPO3");
				int RESENTIMIENTO_SOCIAL3 = GetValueInt(docIN,
						"RESENTIMIENTO_SOCIAL3");
				int CONDUCTA_DELICTIVA2 = GetValueInt(docIN,
						"CONDUCTA_DELICTIVA2");
				int RESENTIMIENTO_SOCIAL4 = GetValueInt(docIN,
						"RESENTIMIENTO_SOCIAL4");
				int RESPONSABILIDAD4 = GetValueInt(docIN, "RESPONSABILIDAD4");
				int CONDUCTA_DELICTIVA5 = GetValueInt(docIN,
						"CONDUCTA_DELICTIVA5");
				int DINERO_EXTRA = GetValueInt(docIN, "DINERO_EXTRA");
				int VIVIENDA_ACTUAL = GetValueInt(docIN, "VIVIENDA_ACTUAL");
				int SERVICIO_HOGAR = GetValueInt(docIN, "SERVICIO_HOGAR");
				int ACT = GetValueInt(docIN, "ACT");
				int HIST = GetValueInt(docIN, "HIST");
				int ANT = GetValueInt(docIN, "ANT");
				int PAGO = GetValueInt(docIN, "PAGO");
				int USO = GetValueInt(docIN, "USO");
				int CUEN_ABIER_CAT = GetValueInt(docIN, "CUEN_ABIER_CAT");
				int VALOR_VIVIENDA = GetValueInt(docIN, "VALOR VIVIENDA");
				int NO_CREDITOS = GetValueInt(docIN, "NO_CREDITOS");
				int I_PSICO = GetValueInt(docIN, "I_PSICO");
				int INGRESO_TOTAL = GetValueInt(docIN, "INGRESO_TOTAL");
				int GASTOS = GetValueInt(docIN, "GASTOS");
				int CUBRIR_ALIMETOS = GetValueInt(docIN, "CUBRIR_ALIMETOS");
				int VESTIDO = GetValueInt(docIN, "VESTIDO");
				int SERVICIOS_VIVIENDA = GetValueInt(docIN,
						"SERVICIOS_VIVIENDA");
				int RENTA = GetValueInt(docIN, "RENTA");

				int PRINCIPAL_PROBLEMA = GetValueInt(docIN,
						"PRINCIPAL_PROBLEMA");
				int SOLICITAR_PRESTAMO = GetValueInt(docIN,
						"SOLICITAR_PRESTAMO");
				int VCS_VIV = GetValueInt(docIN, "VCS_VIV");
				int I_RENTA = GetValueInt(docIN, "I_RENTA");

				int I_PSICO_NO_HIT = GetValueInt(docIN, "I_PSICO_NO_HIT");

				int SITUACION_PROX_ANO = GetValueInt(docIN,
						"SITUACION_PROX_ANO");

				int TARJETA_CREDITO = GetValueInt(docIN, "TARJETA_CREDITO");
				int CUENTA_CHEQUES = GetValueInt(docIN, "CUENTA_CHEQUES");
				int CREDITO_PERSONAL = GetValueInt(docIN, "CREDITO_PERSONAL");
				int CREDITO_AUTO = GetValueInt(docIN, "CREDITO_AUTO");
				int CREDITO_HIPO = GetValueInt(docIN, "CREDITO_HIPO");
				int CREDITO_OTROS = GetValueInt(docIN, "CREDITO_OTROS");

				int REG_BURO = GetValueInt(docIN, "REG_BURO");

				Session s = objetos.HibernateUtil.getSessionFactory()
						.getCurrentSession();

				Transaction tx = s.beginTransaction();

				double SCORE_CREDITOS = TARJETA_CREDITO + CUENTA_CHEQUES
						+ CREDITO_PERSONAL + CREDITO_AUTO + CREDITO_HIPO
						+ CREDITO_OTROS;
				double VECES_VIVIENDA = VALOR_VIVIENDA / INGRESO_TOTAL;

				PsicoSocial(s, AGRESION_1, AGRESION_4, ADHESION_GRUPO3,
						RESENTIMIENTO_SOCIAL3, CONDUCTA_DELICTIVA2,
						RESENTIMIENTO_SOCIAL4, RESPONSABILIDAD4,
						CONDUCTA_DELICTIVA5);

				String resultado = "";

				if (REG_BURO == 1) // SI ES UNO ES HIT
				{
					double SCORE_HIT_FACTOR = EsHit(s, GENERO,
							FRECUENCIA_RELIGION, SITUACION_PROX_ANO,
							DINERO_EXTRA, VIVIENDA_ACTUAL, SERVICIO_HOGAR, ACT,
							USO, CUEN_ABIER_CAT, VALOR_VIVIENDA, NO_CREDITOS,
							I_PSICO);

					if (SCORE_HIT_FACTOR >= 800)
						resultado = "CLIENTE ALTERNATIVA URBI";
					else {
						double SCORE_NO_HIT = EsNoHit(s, RELIGION, ESCOLARIDAD,
								TRABAJO_ANTERIOR, DINERO_EXTRA, INGRESO_TOTAL,
								GASTOS, CUBRIR_ALIMETOS, VESTIDO,
								PRINCIPAL_PROBLEMA, SOLICITAR_PRESTAMO,
								VCS_VIV, I_RENTA, SERVICIOS_VIVIENDA, RENTA,
								SERVICIO_HOGAR, VALOR_VIVIENDA, NO_CREDITOS,
								I_PSICO);
						if (SCORE_NO_HIT >= 800) // SCORE BURO META
						{
							double SCORE_BURO = CalculoBuroMeta(s, ACT, HIST,
									ANT, USO, PAGO);
							if (SCORE_BURO >= 800)
								resultado = "CLIENTE DECLINADO PARA REPARADORA DE BURO";
							else
								resultado = "CLIENTE DECLINADO POR BARRERA DE BURO";
						} else
							resultado = "CLIENTE GOL";
					}
				} else // NO HIT
				{
					double SCORE_NO_HIT = EsNoHit(s, RELIGION, ESCOLARIDAD,
							TRABAJO_ANTERIOR, DINERO_EXTRA, INGRESO_TOTAL,
							GASTOS, CUBRIR_ALIMETOS, VESTIDO,
							PRINCIPAL_PROBLEMA, SOLICITAR_PRESTAMO, VCS_VIV,
							I_RENTA, SERVICIOS_VIVIENDA, RENTA, SERVICIO_HOGAR,
							VALOR_VIVIENDA, NO_CREDITOS, I_PSICO);
					if (SCORE_NO_HIT >= 800)
						resultado = "CLIENTE ALTERNATIVO URBI";
					else
						resultado = "CLIENTE GOL";
				}

				obtenerDescripcion();
				obtenerDescripcion();
				obtenerArraigo();

				// Crear un XML vacio
				DocumentBuilderFactory dbfac = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
				Document doc = docBuilder.newDocument();

				// Crear el Arbol XML

				// Añair la raiz
				Element raiz = doc.createElement("SalidaCalculadoraCG");
				doc.appendChild(raiz);

				AgregarNodo(raiz, doc, "CLI_ID", String.valueOf(cliId));
				AgregarNodo(raiz, doc, "CLI_SAP", String.valueOf(cliSap));
				AgregarNodo(raiz, doc, "GENERO", Double.toString(SCORE_GENERO));
				AgregarNodo(raiz, doc, "COMPORTAMIENTO_PAGO", Double
						.toString(SCORE_COMPORTAMIENTO));
				AgregarNodo(raiz, doc, "ARRAIGO", Double
						.toString(SCORE_ARRAIGO));
				AgregarNodo(raiz, doc, "ASPECTOS_DIF", Double
						.toString(SCORE_ASPECTOS));
				// Valores Salida

				if (REG_BURO == 1) // SI ES UNO ES HIT
				{
					AgregarNodo(raiz, doc, "GENERO_CLASE_TEXTO_1",
							((GENERO_DES == null) ? "" : GENERO_DES));
					AgregarNodo(raiz, doc, "GENERO_CLASE_TEXTO_2",
							((FRECUENCIA_RELIGION_DES == null) ? ""
									: FRECUENCIA_RELIGION_DES));
					AgregarNodo(raiz, doc, "COMPORTAMIENTO_DE_PAGO_TEXTO_1",
							((PRIMER_TEXTO_COMPORTAMIENTO == null) ? ""
									: PRIMER_TEXTO_COMPORTAMIENTO));
					AgregarNodo(raiz, doc, "COMPORTAMIENTO_DE_PAGO_TEXTO_2",
							((SEGUNDO_TEXTO_COMPORTAMIENTO == null) ? ""
									: SEGUNDO_TEXTO_COMPORTAMIENTO));
					AgregarNodo(raiz, doc, "ARRAIGO_TEXTO_1",
							((VIVIENDA_ACTUAL_DES == null) ? ""
									: VIVIENDA_ACTUAL_DES));
					AgregarNodo(raiz, doc, "ARRAIGO_TEXTO_2",
							((SITUACION_PROXIMO_ANO_DES == null) ? ""
									: SITUACION_PROXIMO_ANO_DES));
					AgregarNodo(raiz, doc, "ASPECTOS_TEXTO_1",
							((I_PSICO_DES == null) ? "" : I_PSICO_DES));
					AgregarNodo(raiz, doc, "ASPECTOS_TEXTO_2", (""));

				} else // NO HIT
				{
					AgregarNodo(raiz, doc, "GENERO_CLASE_TEXTO_1",
							((GENERO_DES == null) ? "" : GENERO_DES));
					AgregarNodo(raiz, doc, "GENERO_CLASE_TEXTO_2",
							((ESCOLARIDAD_DES == null) ? "" : ESCOLARIDAD_DES));
					AgregarNodo(raiz, doc, "COMPORTAMIENTO_DE_PAGO_TEXTO_1",
							((PRIMER_TEXTO_COMPORTAMIENTO == null) ? ""
									: PRIMER_TEXTO_COMPORTAMIENTO));
					AgregarNodo(raiz, doc, "COMPORTAMIENTO_DE_PAGO_TEXTO_2",
							((PRIMER_TEXTO_COMPORTAMIENTO == null) ? ""
									: PRIMER_TEXTO_COMPORTAMIENTO));
					AgregarNodo(raiz, doc, "ARRAIGO_TEXTO_1",
							((PRIMER_TEXTO_ARRAIGO == null) ? ""
									: PRIMER_TEXTO_ARRAIGO));
					AgregarNodo(raiz, doc, "ARRAIGO_TEXTO_2",
							((PRIMER_TEXTO_ARRAIGO == null) ? ""
									: PRIMER_TEXTO_ARRAIGO));
					AgregarNodo(raiz, doc, "ASPECTOS_TEXTO_1",
							((I_PSICO_DES == null) ? "" : I_PSICO_DES));
					AgregarNodo(raiz, doc, "ASPECTOS_TEXTO_2", (""));
				}

				AgregarNodo(raiz, doc, "RESULTADO", ((resultado == null) ? ""
						: resultado));

				// Salida del XML
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

			} else {
				return tabNoEncontradoExpt + "EntradaCalculadoraCM";
			}

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

	private String GetValue(Document doc, String nodo) throws Exception {
		NodeList listaNodos = doc.getDocumentElement().getChildNodes();
		for (int i = 0; i < listaNodos.getLength(); i++) {
			if (listaNodos.item(i).getNodeName().equals(nodo)) {
				if (listaNodos.item(i).getTextContent() != null)
					return listaNodos.item(i).getTextContent();
				else
					throw new Exception(tabVacioExpt + nodo);
			}
		}
		throw new Exception(tabNoEncontradoExpt + nodo);
	}

	private int GetValueInt(Document doc, String nodo) throws Exception {
		NodeList listaNodos = doc.getDocumentElement().getChildNodes();
		for (int i = 0; i < listaNodos.getLength(); i++) {
			if (listaNodos.item(i).getNodeName().equals(nodo))
				if (!listaNodos.item(i).getTextContent().equals(""))
					return Integer
							.parseInt(listaNodos.item(i).getTextContent());
				else
					throw new Exception(tabVacioExpt + nodo);
		}
		throw new Exception(tabNoEncontradoExpt + nodo);
	}

	private void AgregarNodo(Element raiz, Document doc, String tab,
			String valor) {
		Element child = doc.createElement(tab);
		Text text = doc.createTextNode(String.valueOf(valor));
		child.appendChild(text);
		raiz.appendChild(child);
	}

	private double EsHit(Session s, int GENERO, int FRECUENCIA_RELIGION,
			int SITUACION_PROX_ANO, int DINERO_EXTRA, int VIVIENDA_ACTUAL,
			int SERVICIO_HOGAR, int ACT, int USO, int CUEN_ABIER_CAT,
			int VALOR_VIVIENDA, int NO_CREDITOS, int I_PSICO) {

		Query q = s.createQuery("from Sex as sex where sex.calId = '3'");
		List lista = (List) q.list();
		GENERO_FACTOR = ((Sex) lista.get(GENERO - 1)).getSexPto();
		GENERO_WOE = ((Sex) lista.get(GENERO - 1)).getSexWoe();
		GENERO_DES = ((Sex) lista.get(GENERO - 1)).getSexDes();

		q = s.createQuery("from FreRel as frerel where frerel.cal = '3'");
		lista = (List) q.list();
		FRECUENCIA_RELIGION_FACTOR = ((FreRel) lista
				.get(FRECUENCIA_RELIGION - 1)).getFreRelPto();
		FRECUENCIA_RELIGION_WOE = ((FreRel) lista.get(FRECUENCIA_RELIGION - 1))
				.getFreRelWoe();
		FRECUENCIA_RELIGION_DES = ((FreRel) lista.get(FRECUENCIA_RELIGION - 1))
				.getFreRelDes();

		q = s.createQuery("from SitPrxAn as sex where sex.cal.calId = '3'");
		lista = (List) q.list();
		SITUACION_PROXIMO_ANO_FACTOR = ((SitPrxAn) lista
				.get(SITUACION_PROX_ANO - 1)).getSitPrxAnPto();
		SITUACION_PROXIMO_ANO_WOE = ((SitPrxAn) lista
				.get(SITUACION_PROX_ANO - 1)).getSitPrxAnWoe();
		SITUACION_PROXIMO_ANO_DES = ((SitPrxAn) lista
				.get(SITUACION_PROX_ANO - 1)).getSitPrxAnDes();

		q = s.createQuery("from DinExt as dinext where dinext.cal= '3'");
		lista = (List) q.list();
		DINERO_EXTRA_FACTOR = ((DinExt) lista.get(DINERO_EXTRA - 1))
				.getDinExtPto();
		DINERO_EXTRA_WOE = ((DinExt) lista.get(DINERO_EXTRA - 1))
				.getDinExtWoe();
		DINERO_EXTRA_DES = ((DinExt) lista.get(DINERO_EXTRA - 1))
				.getDinExtDes();

		q = s.createQuery("from RngResAnt as sex where sex.calId = '3'");
		lista = (List) q.list();
		VIVIENDA_ACTUAL_FACTOR = ((FreRel) lista.get(VIVIENDA_ACTUAL - 1))
				.getFreRelPto();
		VIVIENDA_ACTUAL_WOE = ((FreRel) lista.get(VIVIENDA_ACTUAL - 1))
				.getFreRelWoe();
		VIVIENDA_ACTUAL_DES = ((FreRel) lista.get(VIVIENDA_ACTUAL - 1))
				.getFreRelDes();

		q = s.createQuery("from Srv as sex where sex.calId = '3'");
		lista = (List) q.list();
		SERVICIO_HOGAR_FACTOR = ((Srv) lista.get(SERVICIO_HOGAR - 1))
				.getSrvPto();
		SERVICIO_HOGAR_WOE = ((Srv) lista.get(SERVICIO_HOGAR - 1)).getSrvWoe();

		q = s.createQuery("from BurAct as ba where ba.cal.calId='3'");
		lista = (List) q.list();
		ACT_FACTOR = ((BurAct) lista.get(ACT - 1)).getBurActPto();
		ACT_WOE = ((BurAct) lista.get(ACT - 1)).getBurActWoe();
		ACT_TEXTO = ((BurAct) lista.get(ACT - 1)).getBurActDes();

		q = s.createQuery("from BurUso as bu where bu.cal.calId='3'");
		lista = (List) q.list();
		USO_FACTOR = ((BurUso) lista.get(USO - 1)).getBurUsoPto();
		USO_WOE = ((BurUso) lista.get(USO - 1)).getBurUsoWoe();

		q = s.createQuery("from CueAbr as sex where sex.cal.calId = '3'");
		lista = (List) q.list();
		CUEN_ABIER_CAT_FACTOR = ((CueAbr) lista.get(CUEN_ABIER_CAT - 1))
				.getCueAbrPto();
		CUEN_ABIER_CAT_WOE = ((CueAbr) lista.get(CUEN_ABIER_CAT - 1))
				.getCueAbrWoe();
		CUEN_ABIER_CAT_DES = ((CueAbr) lista.get(CUEN_ABIER_CAT - 1))
				.getCueAbrDes();

		q = s.createQuery("from VlrViv as sex where sex.calId = '3'");
		lista = (List) q.list();
		VALOR_VIVIENDA_FACTOR = ((VlrViv) lista.get(VALOR_VIVIENDA - 1))
				.getVlrVivPto();
		VALOR_VIVIENDA_WOE = ((VlrViv) lista.get(VALOR_VIVIENDA - 1))
				.getVlrVivWoe();

		q = s.createQuery("from NumCre as sex where sex.cal.calId = '3'");
		lista = (List) q.list();
		NO_CREDITOS_FACTOR = ((NumCre) lista.get(NO_CREDITOS - 1))
				.getNumCrePto();
		NO_CREDITOS_WOE = ((NumCre) lista.get(NO_CREDITOS - 1)).getNumCreWoe();
		NO_CREDITOS_DES = ((NumCre) lista.get(NO_CREDITOS - 1)).getNumCreDes();

		q = s.createQuery("from IPsi as sex where sex.cal.calId = '3'");
		lista = (List) q.list();
		I_PSICO_FACTOR = ((IPsi) lista.get(I_PSICO - 1)).getIPsiPto();
		I_PSICO_WOE = ((IPsi) lista.get(I_PSICO - 1)).getIPsiWoe();
		I_PSICO_DES = ((IPsi) lista.get(I_PSICO - 1)).getIPsiDes();

		double SCORE_HIT_FACTOR = GENERO_FACTOR + FRECUENCIA_RELIGION_FACTOR
				+ SITUACION_PROXIMO_ANO_FACTOR + DINERO_EXTRA_FACTOR
				+ VIVIENDA_ACTUAL_FACTOR + SERVICIO_HOGAR_FACTOR + ACT_FACTOR
				+ USO_FACTOR + CUEN_ABIER_CAT_FACTOR + VALOR_VIVIENDA_FACTOR
				+ NO_CREDITOS_FACTOR + I_PSICO_FACTOR;

		double SCORE_GENERO = GENERO_WOE + FRECUENCIA_RELIGION_WOE;

		double SCORE_COMPORTAMIENTO = DINERO_EXTRA_WOE + SERVICIO_HOGAR_WOE
				+ ACT_WOE + USO_WOE + CUEN_ABIER_CAT_WOE + VALOR_VIVIENDA_WOE
				+ NO_CREDITOS_WOE;

		double SCORE_ARRAIGO = VIVIENDA_ACTUAL_WOE + SITUACION_PROXIMO_ANO_WOE;

		double SCORE_ASPECTOS = I_PSICO_WOE;

		return SCORE_HIT_FACTOR;
	}

	private double EsNoHit(Session s, int RELIGION, int ESCOLARIDAD,
			int TRABAJO_ANTERIOR, int DINERO_EXTRA, int INGRESO_TOTAL,
			int GASTOS, int CUBRIR_ALIMETOS, int VESTIDO,
			int PRINCIPAL_PROBLEMA, int SOLICITAR_PRESTAMO, int VCS_VIV,
			int I_RENTA, int SERVICIOS_VIVIENDA, int RENTA, int SERVICIO_HOGAR,
			int VALOR_VIVIENDA, int NO_CREDITOS, int I_PSICO)

	{

		Query q = s.createQuery("from RelFam as sex where sex.calId = '5'");
		List lista = (List) q.list();
		RELIGION_FACTOR = ((RelFam) lista.get(RELIGION - 1)).getRelFamPto();
		RELIGION_WOE = ((RelFam) lista.get(RELIGION - 1)).getRelFamWoe();

		q = s.createQuery("from NivEst as sex where sex.cal.calId = '5'");
		lista = (List) q.list();
		ESCOLARIDAD_FACTOR = ((NivEst) lista.get(ESCOLARIDAD - 1))
				.getNivEstPto();
		ESCOLARIDAD_WOE = ((NivEst) lista.get(ESCOLARIDAD - 1)).getNivEstWoe();
		ESCOLARIDAD_DES = ((NivEst) lista.get(ESCOLARIDAD - 1)).getNivEstDes();

		q = s.createQuery("from ActUlt as sex where sex.calId = '5'");
		lista = (List) q.list();
		TRABAJO_ANTERIOR_FACTOR = ((NumCre) lista.get(NO_CREDITOS - 1))
				.getNumCrePto();
		TRABAJO_ANTERIOR_WOE = ((NumCre) lista.get(NO_CREDITOS - 1))
				.getNumCreWoe();
		TRABAJO_ANTERIOR_DES = ((NumCre) lista.get(NO_CREDITOS - 1))
				.getNumCreDes();

		q = s.createQuery("from DinExt as dinext where dinext.cal= '5'");
		lista = (List) q.list();
		DINERO_EXTRA_FACTOR = ((DinExt) lista.get(DINERO_EXTRA - 1))
				.getDinExtPto();
		DINERO_EXTRA_WOE = ((DinExt) lista.get(DINERO_EXTRA - 1))
				.getDinExtWoe();
		DINERO_EXTRA_DES = ((DinExt) lista.get(DINERO_EXTRA - 1))
				.getDinExtDes();

		q = s.createQuery("from Ing as sex where sex.cal.calId = '5'");
		lista = (List) q.list();
		INGRESO_TOTAL_FACTOR = ((Ing) lista.get(INGRESO_TOTAL - 1)).getIngPto();
		INGRESO_TOTAL_WOE = ((Ing) lista.get(INGRESO_TOTAL - 1)).getIngWoe();
		INGRESO_TOTAL_DES = ((Ing) lista.get(INGRESO_TOTAL - 1)).getIngDes();

		q = s.createQuery("from GtoImp as sex where sex.cal.calId = '5'");
		lista = (List) q.list();
		GASTOS_FACTOR = ((GtoImp) lista.get(GASTOS - 1)).getGtoImpPto();
		GASTOS_WOE = ((GtoImp) lista.get(GASTOS - 1)).getGtoImpWoe();
		GASTOS_DES = ((GtoImp) lista.get(GASTOS - 1)).getGtoImpDes();

		q = s.createQuery("from GtoAlm as sex where sex.cal.calId = '5'");
		lista = (List) q.list();
		CUBRIR_ALIMETOS_FACTOR = ((GtoAlm) lista.get(CUBRIR_ALIMETOS - 1))
				.getGtoAlmPto();
		CUBRIR_ALIMETOS_WOE = ((GtoAlm) lista.get(CUBRIR_ALIMETOS - 1))
				.getGtoAlmWoe();
		CUBRIR_ALIMETOS_DES = ((GtoAlm) lista.get(CUBRIR_ALIMETOS - 1))
				.getGtoAlmDes();

		q = s.createQuery("from GtoVes as sex where sex.cal.calId = '5'");
		lista = (List) q.list();
		VESTIDO_FACTOR = ((GtoVes) lista.get(VESTIDO - 1)).getGtoVesPto();
		VESTIDO_WOE = ((GtoVes) lista.get(VESTIDO - 1)).getGtoVesWoe();
		VESTIDO_DES = ((GtoVes) lista.get(VESTIDO - 1)).getGtoVesDes();

		q = s.createQuery("from Pbm as sex where sex.calId = '5'");
		lista = (List) q.list();
		PRINCIPAL_PROBLEMA_FACTOR = ((Pbm) lista.get(PRINCIPAL_PROBLEMA - 1))
				.getPbmPto();
		PRINCIPAL_PROBLEMA_WOE = ((Pbm) lista.get(PRINCIPAL_PROBLEMA - 1))
				.getPbmWoe();
		PRINCIPAL_PROBLEMA_DES = ((Pbm) lista.get(PRINCIPAL_PROBLEMA - 1))
				.getPbmDes();

		q = s.createQuery("from Ptm as sex where sex.calId = '5'");
		lista = (List) q.list();
		SOLICITAR_PRESTAMO_FACTOR = ((Ptm) lista.get(SOLICITAR_PRESTAMO - 1))
				.getPtmPto();
		SOLICITAR_PRESTAMO_WOE = ((Ptm) lista.get(SOLICITAR_PRESTAMO - 1))
				.getPtmWoe();

		q = s.createQuery("from VcsViv as sex where sex.calId = '5'");
		lista = (List) q.list();
		VCS_VIV_FACTOR = ((VcsViv) lista.get(VCS_VIV - 1)).getVcsVivPto();
		VCS_VIV_WOE = ((VcsViv) lista.get(VCS_VIV - 1)).getVcsVivWoe();

		q = s.createQuery("from IRnt as sex where sex.cal.calId = '5'");
		lista = (List) q.list();
		I_RENTA_FACTOR = ((IRnt) lista.get(I_RENTA - 1)).getIRntPto();
		I_RENTA_WOE = ((IRnt) lista.get(I_RENTA - 1)).getIRntWoe();

		q = s.createQuery("from GtoSerViv as sex where sex.cal.calId = '5'");
		lista = (List) q.list();
		SERVICIOS_VIVIENDA_FACTOR = ((GtoSerViv) lista
				.get(SERVICIOS_VIVIENDA - 1)).getGtoSerVivPto();
		SERVICIOS_VIVIENDA_WOE = ((GtoSerViv) lista.get(SERVICIOS_VIVIENDA - 1))
				.getGtoSerVivWoe();
		SERVICIOS_VIVIENDA_DES = ((GtoSerViv) lista.get(SERVICIOS_VIVIENDA - 1))
				.getGtoSerVivDes();

		q = s.createQuery("from GtoRen as sex where sex.cal.calId = '5'");
		lista = (List) q.list();
		RENTA_FACTOR = ((GtoRen) lista.get(RENTA - 1)).getGtoRenPto();
		RENTA_WOE = ((GtoRen) lista.get(RENTA - 1)).getGtoRenWoe();
		RENTA_DES = ((GtoRen) lista.get(RENTA - 1)).getGtoRenDes();

		q = s.createQuery("from Srv as sex where sex.calId = '5'");
		lista = (List) q.list();
		SERVICIO_HOGAR_FACTOR = ((Srv) lista.get(SERVICIO_HOGAR - 1))
				.getSrvPto();
		SERVICIO_HOGAR_WOE = ((Srv) lista.get(SERVICIO_HOGAR - 1)).getSrvWoe();
		SERVICIO_HOGAR_DES = ((Srv) lista.get(SERVICIO_HOGAR - 1)).getSrvDes();

		q = s.createQuery("from VlrViv as sex where sex.calId = '5'");
		lista = (List) q.list();
		VALOR_VIVIENDA_FACTOR = ((VlrViv) lista.get(VALOR_VIVIENDA - 1))
				.getVlrVivPto();
		VALOR_VIVIENDA_WOE = ((VlrViv) lista.get(VALOR_VIVIENDA - 1))
				.getVlrVivWoe();
		VALOR_VIVIENDA_DES = ((VlrViv) lista.get(VALOR_VIVIENDA - 1))
				.getVlrVivDes();

		q = s.createQuery("from NumCre as sex where sex.cal.calId = '5'");
		lista = (List) q.list();
		NO_CREDITOS_FACTOR = ((NumCre) lista.get(NO_CREDITOS - 1))
				.getNumCrePto();
		NO_CREDITOS_WOE = ((NumCre) lista.get(NO_CREDITOS - 1)).getNumCreWoe();

		q = s.createQuery("from IPsi as sex where sex.cal.calId = '5'");
		lista = (List) q.list();
		I_PSICO_FACTOR = ((IPsi) lista.get(I_PSICO - 1)).getIPsiPto();
		I_PSICO_WOE = ((IPsi) lista.get(I_PSICO - 1)).getIPsiWoe();

		double SCORE_NO_HIT = RELIGION_FACTOR + ESCOLARIDAD_FACTOR
				+ TRABAJO_ANTERIOR_FACTOR + DINERO_EXTRA_FACTOR
				+ INGRESO_TOTAL_FACTOR + GASTOS_FACTOR + CUBRIR_ALIMETOS_FACTOR
				+ VESTIDO_FACTOR + SERVICIOS_VIVIENDA_FACTOR + RENTA_FACTOR
				+ SERVICIO_HOGAR_FACTOR + PRINCIPAL_PROBLEMA_FACTOR
				+ SOLICITAR_PRESTAMO_FACTOR + VCS_VIV_FACTOR + I_RENTA_FACTOR
				+ VALOR_VIVIENDA_FACTOR + NO_CREDITOS_FACTOR + I_PSICO_FACTOR;

		double SCORE_NO_HIT_WOE = SOLICITAR_PRESTAMO_WOE + VCS_VIV_WOE
				+ I_RENTA_WOE + VALOR_VIVIENDA_WOE + I_PSICO_WOE;

		SCORE_ARRAIGO_NH = TRABAJO_ANTERIOR_WOE + PRINCIPAL_PROBLEMA_WOE
				+ NO_CREDITOS_WOE;
		SCORE_GENERO = RELIGION_WOE + ESCOLARIDAD_WOE;
		SCORE_COMPORTAMIENTO_NH = DINERO_EXTRA_WOE + INGRESO_TOTAL_WOE
				+ GASTOS_WOE + CUBRIR_ALIMETOS_WOE + VESTIDO_WOE
				+ SERVICIOS_VIVIENDA_WOE + RENTA_WOE + SERVICIO_HOGAR_WOE;
		SCORE_ASPECTOS = I_PSICO_WOE;

		return SCORE_NO_HIT;
	}

	private double CalculoBuroMeta(Session s, int ACT, int HIST, int ANT,
			int USO, int PAGO) {
		Query q = s.createQuery("from BurAct as ba where ba.cal='4'");
		List lista = (List) q.list();
		ACT_FACTOR = ((BurAct) lista.get(ACT - 1)).getBurActPto();
		ACT_WOE = ((BurAct) lista.get(ACT - 1)).getBurActWoe();
		ACT_TEXTO = ((BurAct) lista.get(ACT - 1)).getBurActDes();

		q = s.createQuery("from BurHis as bh where bh.cal='4'");
		lista = (List) q.list();
		HIST_FACTOR = ((BurHis) lista.get(HIST - 1)).getBurHisPto();
		HIST_WOE = ((BurHis) lista.get(HIST - 1)).getBurHisWoe();
		HIST_TEXTO = ((BurHis) lista.get(HIST - 1)).getBurHisDes();

		q = s.createQuery("from BurAnt as ba where ba.cal='4'");
		lista = (List) q.list();
		ANT_FACTOR = ((BurAnt) lista.get(ANT - 1)).getBurAntPto();
		ANT_WOE = ((BurAnt) lista.get(ANT - 1)).getBurAntWoe();
		ANT_TEXTO = ((BurAnt) lista.get(ANT - 1)).getBurAntDes();

		q = s.createQuery("from BurUso as bu where bu.cal='4'");
		lista = (List) q.list();
		USO_FACTOR = ((BurUso) lista.get(USO - 1)).getBurUsoPto();
		USO_WOE = ((BurUso) lista.get(USO - 1)).getBurUsoWoe();
		USO_TEXTO = ((BurUso) lista.get(USO - 1)).getBurUsoDes();

		q = s.createQuery("from BurPag as bp where bp.cal='4'");
		lista = (List) q.list();
		PAGO_FACTOR = ((BurPag) lista.get(PAGO - 1)).getBurPagPto();
		PAGO_WOE = ((BurPag) lista.get(PAGO - 1)).getBurPagWoe();
		PAGO_TEXTO = ((BurPag) lista.get(PAGO - 1)).getBurPagDes();

		double SCORE_BURO = ACT_FACTOR + HIST_FACTOR + ANT_FACTOR + USO_FACTOR
				+ PAGO_FACTOR;

		return SCORE_BURO;
	}

	private void PsicoSocial(Session s, int AGRESION_1, int AGRESION_4,
			int ADHESION_GRUPO3, int RESENTIMIENTO_SOCIAL3,
			int CONDUCTA_DELICTIVA2, int RESENTIMIENTO_SOCIAL4,
			int RESPONSABILIDAD4, int CONDUCTA_DELICTIVA5) {

		Query q = s
				.createQuery("from RelPsiSoc as rps where rps.cat.catPsiId = '1'");
		List lista = (List) q.list();
		AGRESION_1_FACTOR = ((RelPsiSoc) lista.get(AGRESION_1 - 1))
				.getRelPsiSocPto();
		AGRESION_1_WOE = ((RelPsiSoc) lista.get(AGRESION_1 - 1))
				.getRelPsiSocWoe();

		q = s.createQuery("from RelPsiSoc as rps where rps.cat.catPsiId = '8'");
		lista = (List) q.list();
		AGRESION_4_FACTOR = ((RelPsiSoc) lista.get(AGRESION_4 - 1))
				.getRelPsiSocPto();
		AGRESION_4_WOE = ((RelPsiSoc) lista.get(AGRESION_4 - 1))
				.getRelPsiSocWoe();

		q = s
				.createQuery("from RelPsiSoc as rps where rps.cat.catPsiId = '10'");
		lista = (List) q.list();
		ADHESION_GRUPO3_FACTOR = ((RelPsiSoc) lista.get(ADHESION_GRUPO3 - 1))
				.getRelPsiSocPto();
		ADHESION_GRUPO3_WOE = ((RelPsiSoc) lista.get(ADHESION_GRUPO3 - 1))
				.getRelPsiSocWoe();

		q = s
				.createQuery("from RelPsiSoc as rps where rps.cat.catPsiId = '11'");
		lista = (List) q.list();
		RESENTIMIENTO_SOCIAL3_FACTOR = ((RelPsiSoc) lista
				.get(RESENTIMIENTO_SOCIAL3 - 1)).getRelPsiSocPto();
		RESENTIMIENTO_SOCIAL3_WOE = ((RelPsiSoc) lista
				.get(RESENTIMIENTO_SOCIAL3 - 1)).getRelPsiSocWoe();

		q = s
				.createQuery("from RelPsiSoc as rps where rps.cat.catPsiId = '15'");
		lista = (List) q.list();
		CONDUCTA_DELICTIVA2_FACTOR = ((RelPsiSoc) lista
				.get(CONDUCTA_DELICTIVA2 - 1)).getRelPsiSocPto();
		CONDUCTA_DELICTIVA2_WOE = ((RelPsiSoc) lista
				.get(CONDUCTA_DELICTIVA2 - 1)).getRelPsiSocWoe();

		q = s
				.createQuery("from RelPsiSoc as rps where rps.cat.catPsiId = '17'");
		lista = (List) q.list();
		RESENTIMIENTO_SOCIAL4_FACTOR = ((RelPsiSoc) lista
				.get(RESENTIMIENTO_SOCIAL4 - 1)).getRelPsiSocPto();
		RESENTIMIENTO_SOCIAL4_WOE = ((RelPsiSoc) lista
				.get(RESENTIMIENTO_SOCIAL4 - 1)).getRelPsiSocWoe();

		q = s
				.createQuery("from RelPsiSoc as rps where rps.cat.catPsiId = '18'");
		lista = (List) q.list();
		RESPONSABILIDAD4_FACTOR = ((RelPsiSoc) lista.get(RESPONSABILIDAD4 - 1))
				.getRelPsiSocPto();
		RESPONSABILIDAD4_WOE = ((RelPsiSoc) lista.get(RESPONSABILIDAD4 - 1))
				.getRelPsiSocWoe();

		q = s.createQuery("from RelPsiSoc as rps where rps.cat.catPsiId = '1'");
		lista = (List) q.list();
		CONDUCTA_DELICTIVA5_FACTOR = ((RelPsiSoc) lista
				.get(CONDUCTA_DELICTIVA5 - 1)).getRelPsiSocPto();
		CONDUCTA_DELICTIVA5_WOE = ((RelPsiSoc) lista
				.get(CONDUCTA_DELICTIVA5 - 1)).getRelPsiSocWoe();

		// IPSICO
		double SCORE_IPSICO_FACTOR = AGRESION_1_FACTOR + AGRESION_4_FACTOR
				+ ADHESION_GRUPO3_FACTOR + RESENTIMIENTO_SOCIAL3_FACTOR
				+ CONDUCTA_DELICTIVA2_FACTOR + RESENTIMIENTO_SOCIAL4_FACTOR
				+ RESPONSABILIDAD4_FACTOR + CONDUCTA_DELICTIVA5_FACTOR;

		double SCORE_IPSICO_WOE = AGRESION_1_WOE + AGRESION_4_WOE
				+ ADHESION_GRUPO3_WOE + RESENTIMIENTO_SOCIAL3_WOE
				+ CONDUCTA_DELICTIVA2_WOE + RESENTIMIENTO_SOCIAL4_WOE
				+ RESPONSABILIDAD4_WOE + CONDUCTA_DELICTIVA5_WOE;
		// CREDITO

	}

	private void obtenerDescripcion_NH() {
		DINERO_EXTRA_FACTOR = ABSOLUTO(DINERO_EXTRA_FACTOR);
		INGRESO_TOTAL_FACTOR = ABSOLUTO(DINERO_EXTRA_FACTOR);
		GASTOS_FACTOR = ABSOLUTO(DINERO_EXTRA_FACTOR);
		CUBRIR_ALIMETOS_FACTOR = ABSOLUTO(DINERO_EXTRA_FACTOR);
		VESTIDO_FACTOR = ABSOLUTO(DINERO_EXTRA_FACTOR);
		SERVICIOS_VIVIENDA_FACTOR = ABSOLUTO(DINERO_EXTRA_FACTOR);
		RENTA_FACTOR = ABSOLUTO(RENTA_FACTOR);
		SERVICIO_HOGAR_FACTOR = ABSOLUTO(DINERO_EXTRA_FACTOR);

		String arregloTex[] = { DINERO_EXTRA_DES, INGRESO_TOTAL_DES,
				GASTOS_DES, CUBRIR_ALIMETOS_DES, VESTIDO_DES,
				SERVICIOS_VIVIENDA_DES, RENTA_DES, SERVICIO_HOGAR_DES };
		double arregloDes[] = { DINERO_EXTRA_FACTOR, INGRESO_TOTAL_FACTOR,
				GASTOS_FACTOR, CUBRIR_ALIMETOS_FACTOR, VESTIDO_FACTOR,
				SERVICIOS_VIVIENDA_FACTOR, RENTA_FACTOR, SERVICIO_HOGAR_FACTOR };

		ordena(arregloDes, arregloTex);
		PRIMER_PESO_COMPORTAMIENTO_NH = arregloDes[0];
		PRIMER_TEXTO_COMPORTAMIENTO_NH = arregloTex[0];
		SEGUNDO_PESO_COMPORTAMIENTO_NH = arregloDes[1];
		SEGUNDO_TEXTO_COMPORTAMIENTO_NH = arregloTex[1];

	}

	private void obtenerDescripcion() {

		DINERO_EXTRA_FACTOR = ABSOLUTO(DINERO_EXTRA_FACTOR);
		SERVICIO_HOGAR_FACTOR = ABSOLUTO(SERVICIO_HOGAR_FACTOR);
		ACT_FACTOR = ABSOLUTO(ACT_FACTOR);
		USO_FACTOR = ABSOLUTO(USO_FACTOR);
		CUEN_ABIER_CAT_FACTOR = ABSOLUTO(CUEN_ABIER_CAT_FACTOR);
		VALOR_VIVIENDA_FACTOR = ABSOLUTO(VALOR_VIVIENDA_FACTOR);
		NO_CREDITOS_FACTOR = ABSOLUTO(NO_CREDITOS_FACTOR);

		String arregloTex[] = { DINERO_EXTRA_DES, SERVICIO_HOGAR_DES,
				ACT_TEXTO, USO_TEXTO, CUEN_ABIER_CAT_DES, VALOR_VIVIENDA_DES,
				NO_CREDITOS_DES, };
		double arregloDes[] = { DINERO_EXTRA_FACTOR, SERVICIO_HOGAR_FACTOR,
				ACT_FACTOR, USO_FACTOR, CUEN_ABIER_CAT_FACTOR,
				VALOR_VIVIENDA_FACTOR, NO_CREDITOS_FACTOR };
		ordena(arregloDes, arregloTex);
		PRIMER_PESO_COMPORTAMIENTO = arregloDes[0];
		PRIMER_TEXTO_COMPORTAMIENTO = arregloTex[0];
		SEGUNDO_PESO_COMPORTAMIENTO = arregloDes[1];
		SEGUNDO_TEXTO_COMPORTAMIENTO = arregloTex[1];

	}

	private void obtenerArraigo() {

		TRABAJO_ANTERIOR_FACTOR = ABSOLUTO(TRABAJO_ANTERIOR_FACTOR);
		PRINCIPAL_PROBLEMA_FACTOR = ABSOLUTO(PRINCIPAL_PROBLEMA_FACTOR);
		NO_CREDITOS_FACTOR = ABSOLUTO(NO_CREDITOS_FACTOR);

		String arregloTex[] = { TRABAJO_ANTERIOR_DES, PRINCIPAL_PROBLEMA_DES,
				NO_CREDITOS_DES };

		double arregloDes[] = { TRABAJO_ANTERIOR_FACTOR,
				PRINCIPAL_PROBLEMA_FACTOR, NO_CREDITOS_FACTOR };

		ordena(arregloDes, arregloTex);
		PRIMER_PESO_ARRAIGO = arregloDes[0];
		PRIMER_TEXTO_ARRAIGO = arregloTex[0];
		SEGUNDO_PESO_ARRAIGO = arregloDes[1];
		SEGUNDO_TEXTO_ARRAIGO = arregloTex[1];

	}

	private double ABSOLUTO(double variable) {
		return Math.abs(variable);
	}

	private void ordena(double[] arregloDes, String[] arregloTex) {
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
}
