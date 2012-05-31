/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.urbi.util.HibernateUtil2;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import objetos.ActExt;
import objetos.BanCmp;
import objetos.BanPorPag;
import objetos.BanPorUso;
import objetos.BurAct;
import objetos.BurAnt;
import objetos.BurHis;
import objetos.BurPag;
import objetos.BurUso;
import objetos.DepEco;
import objetos.DinExt;
import objetos.RngEda;
import objetos.EdoCvl;
import objetos.ProAnoGto;
import objetos.Ing;
import objetos.Mig;
import objetos.NivEst;
import objetos.OpnBar;
import objetos.ParPlt;
import objetos.Ptm;
import objetos.Rel;
import objetos.Rld;
import objetos.RngAntEmp;
import objetos.RngResAct;
import objetos.Sex;
import objetos.TipRes;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.w3c.dom.NodeList;

import org.w3c.dom.DocumentFragment;
import org.xml.sax.SAXException;
//gacc

import objetos.RngResAnt;
import objetos.RngAntOcp;
import objetos.Ocp;
import objetos.Edo;
import objetos.IntPi;
import objetos.FtrPpr;
import objetos.AsoPar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.ParserConfigurationException;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Yandy
 */
@WebService()
public class CalculadoraCMWS {

    static String xmlVacioExpt = "Estructura de Xml Vacia";
    static String xmlExpt = "Estructura de Xml con Error";
    static String tabNoEncontradoExpt = "Tab No encontrado: ";
    static String tabVacioExpt = "Valor Tab Vacio: ";
    static String accesoDatosExpt = "Ocurrio un error en acceso a Datos";
    static String datosErrorExpt = "Valor Tab debe ser superior a 0:";
    static String datosErrorAnt = "El tiempo de ocupación es mayor a la edad ";
    double DINERO_EXTRA_FACTOR = 0;
    double DINERO_EXTRA_WOE = 0;
    String DINERO_EXTRA_TEXTO = "";
    double GASTOS_FACTOR = 0;
    double GASTOS_WOE = 0;
    String GASTOS_TEXTO = "";
    double ESCOLARIDAD_FACTOR = 0;
    double ESCOLARIDAD_WOE = 0;
    String ESCOLARIDAD_TEXTO = "";
    double ACTIVIDAD_ADICIONAL_FACTOR = 0;
    double ACTIVIDAD_ADICIONAL_WOE = 0;
    String ACTIVIDAD_ADICIONAL_TEXTO = "";
    double PRESTAMO_FACTO = 0;
    double PRESTAMO_WOE = 0;
    String PRESTAMO_TEXTO = "";
    double RELIGION_FACTOR = 0;
    double RELIGION_WOE = 0;
    String RELIGION_TEXTO = "";
    double IMPORTANCIA_RELIGION_FACTOR = 0;
    double IMPORTANCIA_RELIGION_WOE = 0;
    String IMPORTANCIA_RELIGION_TEXTO = "";
    double PARTIDOS_ASOCIACIONES_FACTOR = 0;
    double PARTIDOS_ASOCIACIONES_WOE = 0;
    String PARTIDOS_ASOCIACIONES_TEXTO = "";
    double PARTIDOS_POLITICOS_FACTOR = 0;
    double PARTIDOS_POLITICOS_WOE = 0;
    String PARTIDOS_POLITICOS_TEXTO = "";
    double ASOCIACIONES_FACTOR = 0;
    double ASOCIACIONES_WOE = 0;
    String ASOCIACIONES_TEXTO = "";
    double MOVILIDAD_FACTOR = 0;
    double MOVILIDAD_WOE = 0;
    String MOVILIDAD_TEXTO = "";
    double TIEMPO_RAO_FACTOR = 0;
    double TIEMPO_RAO_WOE = 0;
    String TIEMPO_RAO_TEXTO = "";
    double TIEMPO_RRA_FACTOR = 0;
    double TIEMPO_RRA_WOE = 0;
    String TIEMPO_RRA_TEXTO = "";
    double SCORE_CUALITATIVO = 0;
    double SCORE_CUALITATIVO_DOS = 0;
    double SCORE_SOCIODEMOGRAFICO = 0;
    double EDAD_FACTOR = 0;
    double EDAD_WOE = 0;
    String EDAD_TEXTO = "";
    double GENERO_FACTOR = 0;
    double GENERO_WOE = 0;
    String GENERO_TEXTO = "";
    double ESTADO_CIVIL_FACTOR = 0;
    double ESTADO_CIVIL_WOE = 0;
    String ESTADO_CIVIL_TEXTO = "";
    double TIPO_DE_RESIDENCIA_FACTOR = 0;
    double TIPO_DE_RESIDENCIA_WOE = 0;
    String TIPO_DE_RESIDENCIA_TEXTO = "";
    double TIEMPO_RES_FACTOR = 0;
    double TIEMPO_RES_WOE = 0;
    String TIEMPO_RES_TEXTO = "";
    double TIEMPO_TRAB_FACTOR = 0;
    double TIEMPO_TRAB_WOE = 0;
    String TIEMPO_TRAB_TEXTO = "";
    double NUMERO_DE_DEPENDIENTES_FACTOR = 0;
    double NUMERO_DE_DEPENDIENTES_WOE = 0;
    String NUMERO_DE_DEPENDIENTES_TEXTO = "";
    double INGRESOS_FACTOR = 0;
    double INGRESOS_WOE = 0;
    String INGRESOS_TEXTO = "";
    double ACT_FACTOR = 0;
    double HIST_FACTOR = 0;
    double ANT_FACTOR = 0;
    double USO_FACTOR = 0;
    double PAGO_FACTOR = 0;
    String PAGO_TEXTO = "";
    String USO_TEXTO = "";
    double ACT_WOE = 0;
    double PAGO_WOE = 0;
    double USO_WOE = 0;
    double ANT_WOE = 0;
    double HIST_WOE = 0;
    String ACT_TEXTO = "";
    String HIST_TEXTO = "";
    String ANT_TEXTO = "";
    double MES_VENCIDO_FACTOR = 0;
    double MES_VENCIDO_WOE = 0;
    String MES_VENCIDO_TEXTO = "";
    double POR_PAGO_FACTOR = 0;
    double POR_USO_FACTOR = 0;
    double POR_PAGO_WOE = 0;
    String POR_PAGO_TEXTO = "";
    double POR_USO_WOE = 0;
    String POR_USO_TEXTO = "";
    double SCORE_COMPORTAMIENTO_DE_PAGO = 0;
    double SCORE_BURO = 0;
    double cuota_pprr = 0;
    double ppr_cuota = 0;
    double ppr = 0;
    double pprr = 0;
    List clientes = new ArrayList();

    /**
     * Web service Calculadora Cliente Meta
     */
    @WebMethod(operationName = "CalculaCM")
    public String CalculaCM(@WebParam(name = "xml") String xml) {
        
        try {
            System.out.println("entrando a metra");
            
            if (xml == null) {
                return xmlVacioExpt;
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
            DocumentBuilderFactory dbfacIN = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilderIN = dbfacIN.newDocumentBuilder();
            Document docIN = docBuilderIN.parse(bais);
            if (docIN.getDocumentElement().getNodeName().equals("EntradaCalculadoraCM")) {
                
                int cliId = GetValueInt(docIN, "CLI_ID");
                int cliSap = GetValueInt(docIN, "CLI_SAP");
                String cliApePat = GetValue(docIN, "CLI_APE_PAT");
                String cliApeMat = GetValue(docIN, "CLI_APE_MAT");
                String cliNom = GetValue(docIN, "CLI_NOM");
                
                // gacc
                String cliFecNac = GetValue(docIN, "CLI_FEC_NAC");
                String cliDomCal = GetValue(docIN, "CLI_DOM_CAL");
                String cliDomNumExt = GetValue(docIN, "CLI_DOM_NUM_EXT");
                String cliDomNumInt = GetValue(docIN, "CLI_DOM_NUM_INT");
                String cliDomCol = GetValue(docIN, "CLI_DOM_COL");
                String codPosId = GetValue(docIN, "CLI_POS_ID");
                int genero = GetValueInt(docIN, "GENERO");
                int estadoCivil = GetValueInt(docIN, "ESTADO_CIVIL");
                int tipoResidencia = GetValueInt(docIN, "TIPO_RESIDENCIA");
                int dependientes = GetValueInt(docIN, "DEPENDIENTES");
                int ingresos = GetValueInt(docIN, "INGRESO");
                int edad = GetValueInt(docIN, "EDAD");
                int tiempoResidencia = GetValueInt(docIN, "TIEMPO_RESIDENCIA");
                int antiguedad = GetValueInt(docIN, "ANTIGUEDAD");
                int dineroExtra = GetValueInt(docIN, "DINERO_EXTRA");
                int gastoProximo = GetValueInt(docIN, "GASTO_PROXIMO");
                int nivelEscolar = GetValueInt(docIN, "NIVEL_ESCOLAR");
                int actExtra = GetValueInt(docIN, "ACT_EXTRA");
                int prestamo = GetValueInt(docIN, "PRESTAMO");
                int religion = GetValueInt(docIN, "RELIGION");
                int influenciaReligion = GetValueInt(docIN, "INFLUENCIA_RELIGION");
                int asociacionPartido = GetValueInt(docIN, "ASOCIACION_PARTIDO");
                int partidoPol = GetValueInt(docIN, "PARTIDO_POL");
                int indOpinionBarzon = GetValueInt(docIN, "IND_OPINION_BARZON");
                int migracion = GetValueInt(docIN, "MIGRACION");
                /*         if(genero<1 || estadoCivil<1 || tiempoResidencia<1 || dependientes<1 || ingresos<1 || edad<1 || tiempoResidencia<1 ||
                antiguedad<1 || dineroExtra<1|| gastoProximo<1 || nivelEscolar<1 || actExtra<1 || prestamo<1 || religion<1 ||
                religion<1 || influenciaReligion<1 || asociacionPartido<1 || partidoPol<1 || indOpinionBarzon<1 ||migracion<1)
                return datosErrorExpt + "GENERO,ESATDO_CIVIL,TIPO_RESIDENCIA,DEPENDIENTES,INGRESO,EDAD,TIEMPO_RESIDENCIA,ANTIGUEDAD," +
                "DINERO_EXTRA,GASTO_PROXIMO,NIVEL_ESCOLAR,ACT_EXTRA,PRESTAMO,RELIGION,INFLUENCIA_RELIGION,ASOCIACION_PARTIDO," +
                "PARTDO_POR,IND_OPINION_BARZON,MIGRACION";*/
                int tieneBuro = GetValueInt(docIN, "COMPORTAMIENTO_CREDITO");
                int act = GetValueInt(docIN, "ACT");
                int hist = GetValueInt(docIN, "HIST");
                int ant = GetValueInt(docIN, "ANT");
                int uso = GetValueInt(docIN, "USO");
                int pago = GetValueInt(docIN, "PAGO");
                int tieneCredito = GetValueInt(docIN, "CREDITO");
                int mesVencido = GetValueInt(docIN, "MES_VENCIDO");
                int pcPago = GetValueInt(docIN, "PC_PAGO");
                int pcUso = GetValueInt(docIN, "PC_USO");
                if (tiempoResidencia >= edad && tiempoResidencia >= antiguedad) {
                    return datosErrorAnt;
                }
                Session s = HibernateUtil2.currentSession();
                Transaction tx = s.beginTransaction();
                sociodemografico(s, genero, estadoCivil, tipoResidencia, dependientes, ingresos, edad, tiempoResidencia, antiguedad, 4);
                cualitativo(s, tiempoResidencia, antiguedad, dineroExtra, gastoProximo, nivelEscolar, actExtra, prestamo, religion, influenciaReligion, asociacionPartido, partidoPol, indOpinionBarzon, migracion, 4);
                if (tieneCredito == 1) {
                    comportamientoPago(s, mesVencido, pcPago, pcUso, 4);
                }
                double GENERO_CLASE = GENERO_WOE + ESTADO_CIVIL_WOE + TIPO_DE_RESIDENCIA_WOE + EDAD_WOE + ESCOLARIDAD_WOE + RELIGION_WOE;
                double ARRAIGO = ((TIEMPO_RES_WOE > TIEMPO_RRA_WOE) ? TIEMPO_RES_WOE : TIEMPO_RRA_WOE) + ((TIEMPO_TRAB_WOE > TIEMPO_RAO_WOE) ? TIEMPO_TRAB_WOE : TIEMPO_RAO_WOE) + MOVILIDAD_WOE;
                double COMPORTAMIENTO_PAGO = INGRESOS_WOE + NUMERO_DE_DEPENDIENTES_WOE + DINERO_EXTRA_WOE + GASTOS_WOE + ACTIVIDAD_ADICIONAL_WOE + ACT_WOE + HIST_WOE + ANT_WOE + USO_WOE + PAGO_WOE + MES_VENCIDO_WOE + POR_PAGO_WOE + POR_USO_WOE;
                double ASPECTOS_DIFERENCIADORES = IMPORTANCIA_RELIGION_WOE + PARTIDOS_ASOCIACIONES_WOE + PARTIDOS_POLITICOS_WOE + ASOCIACIONES_WOE + PRESTAMO_WOE;
                //-GENERO
                GENERO_FACTOR = ABSOLUTO(GENERO_FACTOR);
                ESTADO_CIVIL_FACTOR = ABSOLUTO(ESTADO_CIVIL_FACTOR);
                TIPO_DE_RESIDENCIA_FACTOR = ABSOLUTO(TIPO_DE_RESIDENCIA_FACTOR);
                EDAD_FACTOR = ABSOLUTO(EDAD_FACTOR);
                ESCOLARIDAD_FACTOR = ABSOLUTO(ESCOLARIDAD_FACTOR);
                RELIGION_FACTOR = ABSOLUTO(RELIGION_FACTOR);
                double SUMA_GENERO_CLASE = GENERO_FACTOR + ESTADO_CIVIL_FACTOR + TIPO_DE_RESIDENCIA_FACTOR + EDAD_FACTOR + ESCOLARIDAD_FACTOR + RELIGION_FACTOR;
                double GENERO_PESO = GENERO_FACTOR / SUMA_GENERO_CLASE;
                double ESTADO_CIVIL_PESO = ESTADO_CIVIL_FACTOR / SUMA_GENERO_CLASE;
                double TIPO_DE_RESIDENCIA_PESO = TIPO_DE_RESIDENCIA_FACTOR / SUMA_GENERO_CLASE;
                double EDAD_PESO = EDAD_FACTOR / SUMA_GENERO_CLASE;
                double ESCOLARIDAD_PESO = ESCOLARIDAD_FACTOR / SUMA_GENERO_CLASE;
                double RELIGION_PESO = RELIGION_FACTOR / SUMA_GENERO_CLASE;
                String[] arregloTex = {GENERO_TEXTO, ESTADO_CIVIL_TEXTO, TIPO_DE_RESIDENCIA_TEXTO, EDAD_TEXTO, ESCOLARIDAD_TEXTO};
                double[] arregloDes = {GENERO_PESO, ESTADO_CIVIL_PESO, TIPO_DE_RESIDENCIA_PESO, EDAD_PESO, ESCOLARIDAD_PESO};
                ordena(arregloDes, arregloTex);
                double PRIMER_PESO_GENERO = arregloDes[0];
                String PRIMER_TEXTO_GENERO = arregloTex[0];
                double SEGUNDO_PESO_GENERO = arregloDes[1];
                String SEGUNDO_TEXTO_GENERO = arregloTex[1];
                //-COMPORTAMIENTO
                NUMERO_DE_DEPENDIENTES_FACTOR = ABSOLUTO(NUMERO_DE_DEPENDIENTES_FACTOR);
                INGRESOS_FACTOR = ABSOLUTO(INGRESOS_FACTOR);
                DINERO_EXTRA_FACTOR = ABSOLUTO(DINERO_EXTRA_FACTOR);
                GASTOS_FACTOR = ABSOLUTO(GASTOS_FACTOR);
                ACTIVIDAD_ADICIONAL_FACTOR = ABSOLUTO(ACTIVIDAD_ADICIONAL_FACTOR);
                ACT_FACTOR = ABSOLUTO(ACT_FACTOR);
                HIST_FACTOR = ABSOLUTO(HIST_FACTOR);
                ANT_FACTOR = ABSOLUTO(ANT_FACTOR);
                USO_FACTOR = ABSOLUTO(USO_FACTOR);
                PAGO_FACTOR = ABSOLUTO(PAGO_FACTOR);
                MES_VENCIDO_FACTOR = ABSOLUTO(MES_VENCIDO_FACTOR);
                POR_PAGO_FACTOR = ABSOLUTO(POR_PAGO_FACTOR);
                POR_USO_FACTOR = ABSOLUTO(POR_USO_FACTOR);
                double SUMA_COMPORTAMIENTO_PAGO = NUMERO_DE_DEPENDIENTES_FACTOR + INGRESOS_FACTOR + DINERO_EXTRA_FACTOR + GASTOS_FACTOR + ACTIVIDAD_ADICIONAL_FACTOR + ACT_FACTOR + HIST_FACTOR + ANT_FACTOR + USO_FACTOR + PAGO_FACTOR + MES_VENCIDO_FACTOR + POR_PAGO_FACTOR + POR_USO_FACTOR;
                double NUMERO_DE_DEPENDIENTES_PESO = NUMERO_DE_DEPENDIENTES_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double INGRESOS_PESO = INGRESOS_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double DINERO_EXTRA_PESO = DINERO_EXTRA_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double GASTOS_PESO = GASTOS_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double ACTIVIDAD_ADICIONAL_PESO = ACTIVIDAD_ADICIONAL_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double ACT_PESO = ACT_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double HIST_PESO = HIST_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double ANT_PESO = ANT_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double USO_PESO = USO_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double PAGO_PESO = PAGO_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double MES_VENCIDO_PESO = MES_VENCIDO_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double POR_PAGO_PESO = POR_PAGO_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                double POR_USO_PESO = POR_USO_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
                String[] arregloTexComp = {NUMERO_DE_DEPENDIENTES_TEXTO, INGRESOS_TEXTO, DINERO_EXTRA_TEXTO, GASTOS_TEXTO, ACTIVIDAD_ADICIONAL_TEXTO, MES_VENCIDO_TEXTO, POR_PAGO_TEXTO, POR_USO_TEXTO};
                double[] arregloDesComp = {NUMERO_DE_DEPENDIENTES_PESO, INGRESOS_PESO, DINERO_EXTRA_PESO, GASTOS_PESO, ACTIVIDAD_ADICIONAL_PESO, MES_VENCIDO_PESO, POR_PAGO_PESO, POR_USO_PESO};
                ordena(arregloDesComp, arregloTexComp);
                double PRIMER_PESO_COMPORTAMIENTO = arregloDesComp[0];
                String PRIMER_TEXTO_COMPORTAMIENTO = arregloTexComp[0];
                double SEGUNDO_PESO_COMPORTAMIENTO = arregloDesComp[1];
                String SEGUNDO_TEXTO_COMPORTAMIENTO = arregloTexComp[1];
                //-ARRAIGO
                TIEMPO_RES_FACTOR = ABSOLUTO(TIEMPO_RES_FACTOR);
                TIEMPO_TRAB_FACTOR = ABSOLUTO(TIEMPO_TRAB_FACTOR);
                MOVILIDAD_FACTOR = ABSOLUTO(TIEMPO_TRAB_FACTOR);
                double SUMA_ARRAIGO = TIEMPO_RES_FACTOR + TIEMPO_TRAB_FACTOR + MOVILIDAD_FACTOR;
                double TIEMPO_RES_PESO = TIEMPO_RES_FACTOR / SUMA_ARRAIGO;
                double TIEMPO_TRAB_PESO = TIEMPO_TRAB_FACTOR / SUMA_ARRAIGO;
                double MOVILIDAD_PESO = MOVILIDAD_FACTOR / SUMA_ARRAIGO;
                String[] arregloTexAra = {TIEMPO_RES_TEXTO, TIEMPO_TRAB_TEXTO, MOVILIDAD_TEXTO};
                double[] arregloDesAra = {TIEMPO_RES_PESO, TIEMPO_TRAB_PESO, MOVILIDAD_PESO};
                ordena(arregloDesAra, arregloTexAra);
                double PRIMER_PESO_ARRAIGO = arregloDesAra[0];
                String PRIMER_TEXTO_ARRAIGO = arregloTexAra[0];
                double SEGUNDO_PESO_ARRAIGO = arregloDesAra[1];
                String SEGUNDO_TEXTO_ARRAIGO = arregloTexAra[1];
                //-Diferenciadores
                IMPORTANCIA_RELIGION_FACTOR = ABSOLUTO(IMPORTANCIA_RELIGION_FACTOR);
                PARTIDOS_ASOCIACIONES_FACTOR = ABSOLUTO(PARTIDOS_ASOCIACIONES_FACTOR);
                PARTIDOS_POLITICOS_FACTOR = ABSOLUTO(PARTIDOS_POLITICOS_FACTOR);
                ASOCIACIONES_FACTOR = ABSOLUTO(ASOCIACIONES_FACTOR);
                PRESTAMO_FACTO = ABSOLUTO(PRESTAMO_FACTO);
                double SUMA_ASPECTOS_DIFERENCIALES = IMPORTANCIA_RELIGION_FACTOR + PARTIDOS_ASOCIACIONES_FACTOR + PARTIDOS_POLITICOS_FACTOR + ASOCIACIONES_FACTOR + PRESTAMO_FACTO;
                double IMPORTANCIA_RELIGION_PESO = IMPORTANCIA_RELIGION_FACTOR / SUMA_ASPECTOS_DIFERENCIALES;
                double PARTIDOS_ASOCIACIONES_PESO = PARTIDOS_ASOCIACIONES_FACTOR / SUMA_ASPECTOS_DIFERENCIALES;
                double PARTIDOS_POLITICOS_PESO = PARTIDOS_POLITICOS_FACTOR / SUMA_ASPECTOS_DIFERENCIALES;
                double ASOCIACIONES_PESO = ASOCIACIONES_FACTOR / SUMA_ASPECTOS_DIFERENCIALES;
                double PRESTAMO_PESO = PRESTAMO_FACTO / SUMA_ASPECTOS_DIFERENCIALES;
                //  calculo_CPR(s, ocupacion, estado, edad, valor_vivienda, fecha,6);
                String[] arregloTexDif = {IMPORTANCIA_RELIGION_TEXTO, PARTIDOS_ASOCIACIONES_TEXTO, PARTIDOS_POLITICOS_TEXTO, ASOCIACIONES_TEXTO, PRESTAMO_TEXTO};
                double[] arregloDesDif = {IMPORTANCIA_RELIGION_PESO, PARTIDOS_ASOCIACIONES_PESO, PARTIDOS_POLITICOS_PESO, ASOCIACIONES_PESO, PRESTAMO_PESO};
                ordena(arregloDesDif, arregloTexDif);
                double PRIMER_PESO_DIFERENCIADORES = arregloDesDif[0];
                String PRIMER_TEXTO_DIFERENCIADORES = arregloTexDif[0];
                double SEGUNDO_PESO_DIFERENCIADORES = arregloDesDif[1];
                String SEGUNDO_TEXTO_DIFERENCIADORES = arregloTexDif[1];
                String resultado = "";
                if (tieneCredito == 1) {
                    if (SCORE_COMPORTAMIENTO_DE_PAGO >= 800) {
                        resultado = "CLIENTE META ANTES DE BURO";
                    } else {
                        if (SCORE_COMPORTAMIENTO_DE_PAGO < 616) {
                            cualitativo2(s, genero, estadoCivil, tipoResidencia, dependientes, ingresos, edad, antiguedad, dineroExtra, gastoProximo, nivelEscolar, actExtra, prestamo, religion, influenciaReligion, asociacionPartido, partidoPol, indOpinionBarzon, migracion, 12);
                            //calcular
                            if (SCORE_CUALITATIVO >= 800) {
                                resultado = "CLIENTE META ANTES DE BURO";
                            } else {
                                resultado = "CLIENTE DECLINADO";
                            }
                        } else if (SCORE_COMPORTAMIENTO_DE_PAGO >= 616 && SCORE_COMPORTAMIENTO_DE_PAGO < 800 && SCORE_CUALITATIVO >= 800) {
                            resultado = "CLIENTE META ANTES DE BURO";
                        } else if (SCORE_COMPORTAMIENTO_DE_PAGO >= 616 && SCORE_COMPORTAMIENTO_DE_PAGO < 800 && SCORE_CUALITATIVO < 800) {
                            resultado = "CLIENTE DECLINADO";
                            //calcular
                            cualitativo2(s, genero, estadoCivil, tipoResidencia, dependientes, ingresos, edad, antiguedad, dineroExtra, gastoProximo, nivelEscolar, actExtra, prestamo, religion, influenciaReligion, asociacionPartido, partidoPol, indOpinionBarzon, migracion, 12);
                            if (SCORE_CUALITATIVO >= 800) {
                                resultado = "CLIENTE META ANTES DE BURO";
                            } else {
                                resultado = "CLIENTE DECLINADO";
                            }
                        }
                    }
                } else {
                    if (SCORE_SOCIODEMOGRAFICO >= 800) {
                        resultado = "CLIENTE META ANTES DE BURO";
                    } else if (SCORE_SOCIODEMOGRAFICO < 500) {
                        if (SCORE_CUALITATIVO >= 800) {
                            resultado = "CLIENTE META ANTES DE BURO";
                        } else {
                            resultado = "CLIENTE DECLINADO";
                        }
                    } else if (SCORE_SOCIODEMOGRAFICO >= 500 && SCORE_SOCIODEMOGRAFICO < 800 && SCORE_CUALITATIVO >= 800) {
                        resultado = "CLIENTE META ANTES DE BURO";
                    } else if (SCORE_SOCIODEMOGRAFICO >= 500 && SCORE_SOCIODEMOGRAFICO < 800 && SCORE_CUALITATIVO < 750) {
                        //calcular
                        cualitativo2(s, genero, estadoCivil, tipoResidencia, dependientes, ingresos, edad, antiguedad, dineroExtra, gastoProximo, nivelEscolar, actExtra, prestamo, religion, influenciaReligion, asociacionPartido, partidoPol, indOpinionBarzon, migracion, 12);
                        if (SCORE_CUALITATIVO >= 800) {
                            resultado = "CLIENTE META ANTES DE BURO";
                        } else {
                            resultado = "CLIENTE DECLINADO";
                        }
                    } else if (SCORE_SOCIODEMOGRAFICO >= 500 && SCORE_SOCIODEMOGRAFICO < 800 && SCORE_CUALITATIVO > 750 && SCORE_CUALITATIVO < 800) {
                        cualitativo2(s, genero, estadoCivil, tipoResidencia, dependientes, ingresos, edad, antiguedad, dineroExtra, gastoProximo, nivelEscolar, actExtra, prestamo, religion, influenciaReligion, asociacionPartido, partidoPol, indOpinionBarzon, migracion, 12);
                        if (SCORE_CUALITATIVO >= 800) {
                            resultado = "CLIENTE META ANTES DE BURO";
                        } else {
                            resultado = "CLIENTE DECLINADO";
                        }
                    }
                }
                //Crear el Arbol XML
                //gacc
                //Crear un XML vacio
                DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
                Document doc = docBuilder.newDocument();
                //Añadir la raiz
                Element raiz = doc.createElement("SalidaCalculadoraCM");
                doc.appendChild(raiz);
                //Crear hijs y adicionarlos a la raiz
                AgregarNodo(raiz, doc, "CLI_ID", Integer.toString(cliId));
                AgregarNodo(raiz, doc, "CLI_SAP", Integer.toString(cliSap));
                AgregarNodo(raiz, doc, "Suma_Genero_Clase", Double.toString(GENERO_CLASE));
                AgregarNodo(raiz, doc, "Suma_Comportamiento_Pago", Double.toString(COMPORTAMIENTO_PAGO));
                AgregarNodo(raiz, doc, "Suma_Arraigo", Double.toString(ARRAIGO));
                AgregarNodo(raiz, doc, "Suma_Aspectos_Diferenciadores", Double.toString(ASPECTOS_DIFERENCIADORES));
                AgregarNodo(raiz, doc, "Genero_Clase_Texto1", (PRIMER_TEXTO_GENERO == null) ? "" : PRIMER_TEXTO_GENERO);
                AgregarNodo(raiz, doc, "Genero_Clase_Texto2", (SEGUNDO_TEXTO_GENERO == null) ? "" : SEGUNDO_TEXTO_GENERO);
                AgregarNodo(raiz, doc, "Comportamiento_Pago_Texto1", (PRIMER_TEXTO_COMPORTAMIENTO == null) ? "" : PRIMER_TEXTO_COMPORTAMIENTO);
                AgregarNodo(raiz, doc, "Comportamiento_Pago_Texto2", (SEGUNDO_TEXTO_COMPORTAMIENTO == null) ? "" : SEGUNDO_TEXTO_COMPORTAMIENTO);
                AgregarNodo(raiz, doc, "Arraigo_Texto1", (PRIMER_TEXTO_ARRAIGO == null) ? "" : PRIMER_TEXTO_ARRAIGO);
                AgregarNodo(raiz, doc, "Arraigo_Texto2", (SEGUNDO_TEXTO_ARRAIGO == null) ? "" : SEGUNDO_TEXTO_ARRAIGO);
                AgregarNodo(raiz, doc, "Aspectos_Diferenciadores_Texto1", (PRIMER_TEXTO_DIFERENCIADORES == null) ? "" : PRIMER_TEXTO_DIFERENCIADORES);
                AgregarNodo(raiz, doc, "Aspectos_Diferenciadores_Texto2", (SEGUNDO_TEXTO_DIFERENCIADORES == null) ? "" : SEGUNDO_TEXTO_DIFERENCIADORES);
                AgregarNodo(raiz, doc, "Resultado", resultado);
                //Salida del XML
              return xmlString(doc);
            } else {
                return tabNoEncontradoExpt + "EntradaCalculadoraCM";
            }

        } catch (SAXException ex) {
            Logger.getLogger(CalculadoraCMWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CalculadoraCMWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CalculadoraCMWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CalculadoraCMWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    private void ordena(double[] arregloDes, String[] arregloTex) {
        for (int i = 0; i < arregloDes.length - 1; i++) {
            for (int j = i + 1; j < arregloDes.length; j++) {
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
    }

    private void AgregarNodo(Element raiz, Document doc, String tab, String valor) {
        Element child = doc.createElement(tab);
        Text text = doc.createTextNode(String.valueOf(valor));
        child.appendChild(text);
        raiz.appendChild(child);
    }

    private double ABSOLUTO(double variable) {
        return Math.abs(variable);
    }

    private void cualitativo(Session s,
            int tiempoResidencia,
            int antiguedad,
            int dineroExtra,
            int gastoProximo,
            int nivelEscolar,
            int actExtra,
            int prestamo,
            int religion,
            int influenciaReligion,
            int asociacionPartido,
            int partidoPol,
            int indOpinionBarzon,
            int migracion,
            int calculadora) {


        if (calculadora == 12) {
            dineroExtra = dineroExtra + 7;
            gastoProximo = gastoProximo + 6;
            nivelEscolar = nivelEscolar + 18;
            actExtra = actExtra + 6;
            prestamo = prestamo + 14;
            religion = religion + 14;
            influenciaReligion = influenciaReligion + 4;
            asociacionPartido = asociacionPartido + 4;
            partidoPol = partidoPol + 5;
            indOpinionBarzon = indOpinionBarzon + 5;
            migracion = migracion + 2;
        }



        DinExt din = (DinExt) s.createQuery("from DinExt as de where de.cal.calId='" + calculadora + "' and de.dinExtId=" + dineroExtra).uniqueResult();
        DINERO_EXTRA_FACTOR = 0.0;
        DINERO_EXTRA_WOE = 0.0;
        DINERO_EXTRA_TEXTO = "";

        if (din != null) {

            DINERO_EXTRA_FACTOR = din.getDinExtPto();
            DINERO_EXTRA_WOE = din.getDinExtWoe();
            DINERO_EXTRA_TEXTO = din.getDinExtDesLar();
        }

        ProAnoGto pgt = (ProAnoGto) s.createQuery("from ProAnoGto as pgt where pgt.calId='" + calculadora + "' and pgt.proAnoGtoId=" + gastoProximo).uniqueResult();
        GASTOS_FACTOR = 0.0;
        GASTOS_WOE = 0.0;
        GASTOS_TEXTO = "";

        if (pgt != null) {

            GASTOS_FACTOR = pgt.getProAnoGtoPto();
            GASTOS_WOE = pgt.getProAnoGtoWoe();
            GASTOS_TEXTO = pgt.getProAnoGtoDesLar();
        }

        NivEst niv = (NivEst) s.createQuery("from NivEst as tr where tr.cal='" + calculadora + "'and tr.nivEstId=" + nivelEscolar).uniqueResult();
        ESCOLARIDAD_FACTOR = 0.0;
        ESCOLARIDAD_WOE = 0.0;
        ESCOLARIDAD_TEXTO = "";

        if (niv != null) {

            ESCOLARIDAD_FACTOR = niv.getNivEstPto();
            ESCOLARIDAD_WOE = niv.getNivEstWoe();
            ESCOLARIDAD_TEXTO = niv.getNivEstDesLar();
        }

        ActExt actext = (ActExt) s.createQuery("from ActExt as ae where ae.cal='" + calculadora + "' and ae.actExtId=" + actExtra).uniqueResult();
        ACTIVIDAD_ADICIONAL_FACTOR = 0.0;
        ACTIVIDAD_ADICIONAL_WOE = 0.0;
        ACTIVIDAD_ADICIONAL_TEXTO = "";

        if (actext != null) {

            ACTIVIDAD_ADICIONAL_FACTOR = actext.getActExtPto();
            ACTIVIDAD_ADICIONAL_WOE = actext.getActExtWoe();
            ACTIVIDAD_ADICIONAL_TEXTO = actext.getActExtDesLar();
        }

        Ptm ptm = (Ptm) s.createQuery("from Ptm as pt where pt.calId='" + calculadora + "' and pt.ptmId=" + prestamo).uniqueResult();
        PRESTAMO_FACTO = 0.0;
        PRESTAMO_WOE = 0.0;
        PRESTAMO_TEXTO = "";

        if (ptm != null) {

            PRESTAMO_FACTO = ptm.getPtmPto();
            PRESTAMO_WOE = ptm.getPtmWoe();
            PRESTAMO_TEXTO = ptm.getPtmDesLar();
        }

        Rel rel = (Rel) s.createQuery("from Rel as r where r.calId='" + calculadora + "' and r.relId=" + religion).uniqueResult();
        RELIGION_FACTOR = 0.0;
        RELIGION_WOE = 0.0;
        RELIGION_TEXTO = "";

        if (rel != null) {

            RELIGION_FACTOR = rel.getRelPto();
            RELIGION_WOE = rel.getRelWoe();
            RELIGION_TEXTO = rel.getRelDesLar();
        }

        Rld rld = (Rld) s.createQuery("from Rld as rld where rld.calId='" + calculadora + "' and rld.rldId=" + influenciaReligion).uniqueResult();
        IMPORTANCIA_RELIGION_FACTOR = 0.0;
        IMPORTANCIA_RELIGION_WOE = 0.0;
        IMPORTANCIA_RELIGION_TEXTO = "";

        if (rld != null) {

            IMPORTANCIA_RELIGION_FACTOR = rld.getRldPto();
            IMPORTANCIA_RELIGION_WOE = rld.getRldWoe();
            IMPORTANCIA_RELIGION_TEXTO = rld.getRldDesLar();
        }

        AsoPar aso = (AsoPar) s.createQuery("from AsoPar as pa where pa.cal='" + calculadora + "' and pa.asoParId=" + asociacionPartido).uniqueResult();
        PARTIDOS_ASOCIACIONES_FACTOR = 0.0;
        PARTIDOS_ASOCIACIONES_WOE = 0.0;
        PARTIDOS_ASOCIACIONES_TEXTO = "";

        if (aso != null) {

            PARTIDOS_ASOCIACIONES_FACTOR = aso.getAsoParPto();
            PARTIDOS_ASOCIACIONES_WOE = aso.getAsoParWoe();
            PARTIDOS_ASOCIACIONES_TEXTO = aso.getAsoParDesLar();
        }

        ParPlt parPlt = (ParPlt) s.createQuery("from ParPlt as pp where pp.calId='" + calculadora + "' and pp.parPltId=" + partidoPol).uniqueResult();
        PARTIDOS_POLITICOS_FACTOR = 0.0;
        PARTIDOS_POLITICOS_WOE = 0.0;
        PARTIDOS_POLITICOS_TEXTO = "";

        if (parPlt != null) {

            PARTIDOS_POLITICOS_FACTOR = parPlt.getParPltPto();
            PARTIDOS_POLITICOS_WOE = parPlt.getParPltWoe();
            PARTIDOS_POLITICOS_TEXTO = parPlt.getParPltDesLar();
        }

        OpnBar opnBar = (OpnBar) s.createQuery("from OpnBar as ob where ob.cal='" + calculadora + "' and ob.opnBarId=" + indOpinionBarzon).uniqueResult();
        ASOCIACIONES_FACTOR = 0.0;
        ASOCIACIONES_WOE = 0.0;
        ASOCIACIONES_TEXTO = "";

        if (opnBar != null) {

            ASOCIACIONES_FACTOR = opnBar.getOpnBarPto();
            ASOCIACIONES_WOE = opnBar.getOpnBarWoe();
            ASOCIACIONES_TEXTO = opnBar.getOpnBarDesLar();
        }

        Mig mig = (Mig) s.createQuery("from Mig as m where m.cal='" + calculadora + "' and m.migId=" + migracion).uniqueResult();
        MOVILIDAD_FACTOR = 0.0;
        MOVILIDAD_WOE = 0.0;
        MOVILIDAD_TEXTO = "";

        if (mig != null) {

            MOVILIDAD_FACTOR = mig.getMigPto();
            MOVILIDAD_WOE = mig.getMigWoe();
            MOVILIDAD_TEXTO = mig.getMigDesLar();
        }

        if (calculadora != 12) {
            Query q = s.createQuery("from RngAntOcp as rao where rao.calId='" + calculadora + "' and rngAntOcpLimInf <=" + antiguedad + " and rngAntOcpLimSup >= " + antiguedad);
            List lista = (List) q.list();
            TIEMPO_RAO_FACTOR = ((RngAntOcp) lista.get(0)).getRngAntOcpPto();
            TIEMPO_RAO_WOE = ((RngAntOcp) lista.get(0)).getRngAntOcpWoe();
            TIEMPO_RAO_TEXTO = ((RngAntOcp) lista.get(0)).getRngAntOcpDesLar();

            q = s.createQuery("from RngResAnt where calId = '" + calculadora + "' and rngResAntLimInf <=" + tiempoResidencia + " and rngResAntLimSup >= " + tiempoResidencia);
            lista = (List) q.list();
            TIEMPO_RRA_FACTOR = ((RngResAnt) lista.get(0)).getRngResAntPto();
            TIEMPO_RRA_WOE = ((RngResAnt) lista.get(0)).getRngResAntWoe();
            TIEMPO_RRA_TEXTO = ((RngResAnt) lista.get(0)).getRngResAntDesLar();
        }
        SCORE_CUALITATIVO = 0;

        SCORE_CUALITATIVO = DINERO_EXTRA_FACTOR + GASTOS_FACTOR
                + ESCOLARIDAD_FACTOR + ACTIVIDAD_ADICIONAL_FACTOR + PRESTAMO_FACTO
                + RELIGION_FACTOR + IMPORTANCIA_RELIGION_FACTOR
                + PARTIDOS_ASOCIACIONES_FACTOR + PARTIDOS_POLITICOS_FACTOR
                + ASOCIACIONES_FACTOR + MOVILIDAD_FACTOR + TIEMPO_RAO_FACTOR + TIEMPO_RRA_FACTOR;

    }

    private void sociodemografico(Session s,
            int genero,
            int estadoCivil,
            int tipoResidencia,
            int dependientes,
            int ingresos,
            int edad,
            int tiempoResidencia,
            int antiguedad,
            int calculadora) {

        Sex sex = (Sex) s.createQuery("from Sex as sex where sex.calId = '" + calculadora + "' and sex.sexId=" + genero).uniqueResult();
        GENERO_FACTOR = 0.0;
        GENERO_WOE = 0.0;
        GENERO_TEXTO = "";

        if (sex != null) {
            GENERO_FACTOR = sex.getSexPto();
            GENERO_WOE = sex.getSexWoe();
            GENERO_TEXTO = sex.getSexDesLar();
        }

        EdoCvl edoCvl = (EdoCvl) s.createQuery("from EdoCvl as ec where ec.cal.calId='" + calculadora + "' and ec.edoCvlId=" + estadoCivil).uniqueResult();
        ESTADO_CIVIL_FACTOR = 0.0;
        ESTADO_CIVIL_WOE = 0.0;
        ESTADO_CIVIL_TEXTO = "";

        if (edoCvl != null) {
            ESTADO_CIVIL_FACTOR = edoCvl.getEdoCvlPto();
            ESTADO_CIVIL_WOE = edoCvl.getEdoCvlWoe();
            ESTADO_CIVIL_TEXTO = edoCvl.getEdoCvlDesLar();
        }

        TipRes res = (TipRes) s.createQuery("from TipRes as tr where tr.calId='" + calculadora + "' and tr.tipResId=" + tipoResidencia).uniqueResult();
        TIPO_DE_RESIDENCIA_FACTOR = 0.0;
        TIPO_DE_RESIDENCIA_WOE = 0.0;
        TIPO_DE_RESIDENCIA_TEXTO = "";

        if (res != null) {
            TIPO_DE_RESIDENCIA_FACTOR = res.getTipResPto();
            TIPO_DE_RESIDENCIA_WOE = res.getTipResWoe();
            TIPO_DE_RESIDENCIA_TEXTO = res.getTipResDesLar();

        }

        DepEco de = (DepEco) s.createQuery("from DepEco as de where de.cal.calId='" + calculadora + "' and de.depEcoId=" + dependientes).uniqueResult();
        NUMERO_DE_DEPENDIENTES_FACTOR = 0.0;
        NUMERO_DE_DEPENDIENTES_WOE = 0.0;
        NUMERO_DE_DEPENDIENTES_TEXTO = "";

        if (de != null) {

            NUMERO_DE_DEPENDIENTES_FACTOR = de.getDepEcoPto();
            NUMERO_DE_DEPENDIENTES_WOE = de.getDepEcoWoe();
            NUMERO_DE_DEPENDIENTES_TEXTO = de.getDepEcoDesLar();
        }

        Ing ing = (Ing) s.createQuery("from Ing as ing where ing.cal.calId='" + calculadora + "' and ing.ingId=" + ingresos).uniqueResult();
        INGRESOS_FACTOR = 0.0;
        INGRESOS_WOE = 0.0;
        INGRESOS_TEXTO = "";

        if (ing != null) {

            INGRESOS_FACTOR = ing.getIngPto();
            INGRESOS_WOE = ing.getIngWoe();
            INGRESOS_TEXTO = ing.getIngDesLar();
        }
//gacc
        Query q = s.createQuery("from RngEda as rngeda where rngeda.calId='" + calculadora + "' and rngeda.rngEdaLimInf<=" + edad + " and rngeda.rngEdaLimSup>=" + edad);
        List lista = (List) q.list();
        EDAD_FACTOR = ((RngEda) lista.get(0)).getRngEdaPto();
        EDAD_WOE = ((RngEda) lista.get(0)).getRngEdaWoe();
        EDAD_TEXTO = ((RngEda) lista.get(0)).getRngEdaDesLar();

        q = s.createQuery("from RngResAct as rra where rra.calId='" + calculadora + "' and rngResActLimInf <=" + tiempoResidencia + " and rngResActLimSup >= " + tiempoResidencia);
        lista = (List) q.list();
        TIEMPO_RES_FACTOR = ((RngResAct) lista.get(0)).getRngResActPto();
        TIEMPO_RES_WOE = ((RngResAct) lista.get(0)).getRngResActWoe();
        TIEMPO_RES_TEXTO = ((RngResAct) lista.get(0)).getRngResActDesLar();

        q = s.createQuery("from RngAntEmp as rae where rae.calId='" + calculadora + "' and rngAntEmpLimInf <=" + antiguedad + " and rngAntEmpLimSup >= " + antiguedad);
        lista = (List) q.list();
        TIEMPO_TRAB_FACTOR = ((RngAntEmp) lista.get(0)).getRngAntEmpPto();
        TIEMPO_TRAB_WOE = ((RngAntEmp) lista.get(0)).getRngAntEmpWoe();
        TIEMPO_TRAB_TEXTO = ((RngAntEmp) lista.get(0)).getRngAntEmpDesLar();

        SCORE_SOCIODEMOGRAFICO = GENERO_FACTOR + ESTADO_CIVIL_FACTOR + TIPO_DE_RESIDENCIA_FACTOR
                + NUMERO_DE_DEPENDIENTES_FACTOR + INGRESOS_FACTOR + EDAD_FACTOR
                + TIEMPO_RES_FACTOR + TIEMPO_TRAB_FACTOR;



    }

    private void buro(Session s,
            int act,
            int hist,
            int ant,
            int uso,
            int pago,
            int calculadora) {
        Query q = s.createQuery("from BurAct as ba where ba.cal='" + calculadora + "'");
        List lista = (List) q.list();
        ACT_FACTOR = ((BurAct) lista.get(act - 1)).getBurActPto();
        ACT_WOE = ((BurAct) lista.get(act - 1)).getBurActWoe();
        ACT_TEXTO = ((BurAct) lista.get(act - 1)).getBurActDes();

        q = s.createQuery("from BurHis as bh where bh.cal='" + calculadora + "'");
        lista = (List) q.list();
        HIST_FACTOR = ((BurHis) lista.get(hist - 1)).getBurHisPto();
        HIST_WOE = ((BurHis) lista.get(hist - 1)).getBurHisWoe();
        HIST_TEXTO = ((BurHis) lista.get(hist - 1)).getBurHisDes();

        q = s.createQuery("from BurAnt as ba where ba.cal='" + calculadora + "'");
        lista = (List) q.list();
        ANT_FACTOR = ((BurAnt) lista.get(ant - 1)).getBurAntPto();
        ANT_WOE = ((BurAnt) lista.get(ant - 1)).getBurAntWoe();
        ANT_TEXTO = ((BurAnt) lista.get(ant - 1)).getBurAntDes();

        q = s.createQuery("from BurUso as bu where bu.cal='" + calculadora + "'");
        lista = (List) q.list();
        USO_FACTOR = ((BurUso) lista.get(uso - 1)).getBurUsoPto();
        USO_WOE = ((BurUso) lista.get(uso - 1)).getBurUsoWoe();
        USO_TEXTO = ((BurUso) lista.get(uso - 1)).getBurUsoDes();

        q = s.createQuery("from BurPag as bp where bp.cal='" + calculadora + "'");
        lista = (List) q.list();
        PAGO_FACTOR = ((BurPag) lista.get(pago - 1)).getBurPagPto();
        PAGO_WOE = ((BurPag) lista.get(pago - 1)).getBurPagWoe();
        PAGO_TEXTO = ((BurPag) lista.get(pago - 1)).getBurPagDes();

        SCORE_BURO = ACT_FACTOR + HIST_FACTOR + ANT_FACTOR + USO_FACTOR + PAGO_FACTOR;


        System.out.println("SCORE_BURO");
        System.out.println(SCORE_BURO);
        System.out.println(ACT_FACTOR);
        System.out.println(HIST_FACTOR);
        System.out.println(ANT_FACTOR);
        System.out.println(USO_FACTOR);
        System.out.println(PAGO_FACTOR);







    }

    private void comportamientoPago(Session s, int mesVencido, int pcPago, int pcUso, int calculadora) {
        BanCmp banCmp = (BanCmp) s.createQuery("from BanCmp as ba where ba.cal='" + calculadora + "' and ba.banCmpId=" + mesVencido).uniqueResult();
        if (banCmp != null) {
            MES_VENCIDO_FACTOR = banCmp.getBanCmpPto();
            MES_VENCIDO_WOE = banCmp.getBanCmpWoe();
            MES_VENCIDO_TEXTO = banCmp.getBanCmpDesLar();
        }

        BanPorPag banPorPag = (BanPorPag) s.createQuery("from BanPorPag as bu where bu.cal='" + calculadora + "' and bu.banPorPagId=" + pcPago).uniqueResult();
        if (banPorPag != null) {

            POR_PAGO_FACTOR = banPorPag.getBanPorPagPto();
            POR_PAGO_WOE = banPorPag.getBanPorPagWoe();
            POR_PAGO_TEXTO = banPorPag.getBanPorPagDesLar();

        }

        BanPorUso banPorUso = (BanPorUso) s.createQuery("from BanPorUso as bp where bp.cal='" + calculadora + "' and bp.banPorUsoId=" + pcUso).uniqueResult();
        if (banPorUso != null) {
            POR_USO_FACTOR = banPorUso.getBanPorUsoPto();
            POR_USO_WOE = banPorUso.getBanPorUsoWoe();
            POR_USO_TEXTO = banPorUso.getBanPorUsoDesLar();
        }

        SCORE_COMPORTAMIENTO_DE_PAGO = MES_VENCIDO_FACTOR + POR_PAGO_FACTOR + POR_USO_FACTOR;

    }

    private void calculo_CPR(Session s, int ocupacion, int estado, int edad, double valor_vivienda, int fecha, int calculadora) {
        //gacc
        //prima pura meta

        Query q = s.createQuery("from Ocp as ocp where ocp.cal.calId = '" + calculadora + "' and ocp.ocpOrdPre=" + ocupacion);
        List lista = (List) q.list();
        double ocupacion_woe = 0.0;
        if (!lista.isEmpty()) {
            ocupacion_woe = ((Ocp) lista.get(0)).getOcpWoe();
        }
        Edo est = (Edo) s.createQuery("from Edo as edo where edo.cal.calId = '" + calculadora + "' and edo.edoId=" + estado).uniqueResult();
        double estado_woe = 0.0;
        double recargo = 0.0;

        if (est != null) {
            estado_woe = est.getEdoWoe();
            recargo = est.getEdoRcg();

        }

        q = s.createQuery("from RngEda as rngeda where rngeda.calId='" + calculadora + "' and rngeda.rngEdaLimInf<=" + edad + " and rngeda.rngEdaLimSup>=" + edad);
        lista = (List) q.list();
        double ppr_edad_factor = 0.0;
        double ppr_edad_woe = 0.0;
        String ppr_edad_des = "";

        if (!lista.isEmpty()) {

            ppr_edad_factor = ((RngEda) lista.get(0)).getRngEdaPto();
            ppr_edad_woe = ((RngEda) lista.get(0)).getRngEdaWoe();
            ppr_edad_des = ((RngEda) lista.get(0)).getRngEdaDes();
        }

        double zeta = 0.018146691102274 - (0.00993013369427481) * estado_woe - (0.017366941566975) * ppr_edad_woe - (0.00838465419451784) * ocupacion_woe;
        double pi = Math.exp(zeta) / (1 + Math.exp(zeta));

        q = s.createQuery("from IntPi as intPi where intPi.cal='6' and intPi.intPiLimInf<=" + pi + " and intPi.intPiLimSup>=" + pi);
        lista = (List) q.list();
        String clasificacion = "";

        if (!lista.isEmpty()) {
            clasificacion = ((IntPi) lista.get(0)).getIntPiDes();

        }
        q = s.createQuery("from FtrPpr as fp where fp.ftrPprCls='" + clasificacion + "' and fp.ftrPprMes=" + fecha);
        lista = (List) q.list();
        ppr_cuota = 0.0;

        if (!lista.isEmpty()) {

            ppr_cuota = ((FtrPpr) lista.get(0)).getFtrPprFtr();
        }


        ppr = valor_vivienda * ppr_cuota;
        cuota_pprr = ppr_cuota * (1 + recargo);
        pprr = valor_vivienda * cuota_pprr;



    }

    private void cualitativo2(Session s,
            int genero,
            int estadoCivil,
            int tipoResidencia,
            int dependientes,
            int ingresos,
            int edad,
            int antiguedad,
            int dineroExtra,
            int gastoProximo,
            int nivelEscolar,
            int actExtra,
            int prestamo,
            int religion,
            int influenciaReligion,
            int asociacionPartido,
            int partidoPol,
            int indOpinionBarzon,
            int migracion,
            int calculadora) {


        if (calculadora == 12) {

            if (genero == 2) {
                genero = 5;
            } else {
                genero = 6;
            }
            estadoCivil = estadoCivil + 5;
            tipoResidencia = tipoResidencia + 4;
            dependientes = dependientes + 4;
            ingresos = ingresos + 20;

            dineroExtra = dineroExtra + 7;
            gastoProximo = gastoProximo + 6;
            nivelEscolar = nivelEscolar + 18;
            actExtra = actExtra + 6;
            prestamo = prestamo + 14;
            religion = religion + 14;
            influenciaReligion = influenciaReligion + 4;
            asociacionPartido = asociacionPartido + 4;
            partidoPol = partidoPol + 5;
            indOpinionBarzon = indOpinionBarzon + 5;
            migracion = migracion + 2;
        }


        Sex sex = (Sex) s.createQuery("from Sex as sex where sex.calId = '" + calculadora + "' and sex.sexId=" + genero).uniqueResult();
        GENERO_FACTOR = 0.0;
        GENERO_WOE = 0.0;
        GENERO_TEXTO = "";

        if (sex != null) {
            GENERO_FACTOR = sex.getSexPto();
            GENERO_WOE = sex.getSexWoe();
            GENERO_TEXTO = sex.getSexDesLar();
        }

        EdoCvl edoCvl = (EdoCvl) s.createQuery("from EdoCvl as ec where ec.cal.calId='" + calculadora + "' and ec.edoCvlId=" + estadoCivil).uniqueResult();
        ESTADO_CIVIL_FACTOR = 0.0;
        ESTADO_CIVIL_WOE = 0.0;
        ESTADO_CIVIL_TEXTO = "";

        if (edoCvl != null) {
            ESTADO_CIVIL_FACTOR = edoCvl.getEdoCvlPto();
            ESTADO_CIVIL_WOE = edoCvl.getEdoCvlWoe();
            ESTADO_CIVIL_TEXTO = edoCvl.getEdoCvlDesLar();
        }

        TipRes res = (TipRes) s.createQuery("from TipRes as tr where tr.calId='" + calculadora + "' and tr.tipResId=" + tipoResidencia).uniqueResult();
        TIPO_DE_RESIDENCIA_FACTOR = 0.0;
        TIPO_DE_RESIDENCIA_WOE = 0.0;
        TIPO_DE_RESIDENCIA_TEXTO = "";

        if (res != null) {
            TIPO_DE_RESIDENCIA_FACTOR = res.getTipResPto();
            TIPO_DE_RESIDENCIA_WOE = res.getTipResWoe();
            TIPO_DE_RESIDENCIA_TEXTO = res.getTipResDesLar();

        }

        DepEco de = (DepEco) s.createQuery("from DepEco as de where de.cal.calId='" + calculadora + "' and de.depEcoId=" + dependientes).uniqueResult();
        NUMERO_DE_DEPENDIENTES_FACTOR = 0.0;
        NUMERO_DE_DEPENDIENTES_WOE = 0.0;
        NUMERO_DE_DEPENDIENTES_TEXTO = "";

        if (de != null) {

            NUMERO_DE_DEPENDIENTES_FACTOR = de.getDepEcoPto();
            NUMERO_DE_DEPENDIENTES_WOE = de.getDepEcoWoe();
            NUMERO_DE_DEPENDIENTES_TEXTO = de.getDepEcoDesLar();
        }

        Ing ing = (Ing) s.createQuery("from Ing as ing where ing.cal.calId='" + calculadora + "' and ing.ingId=" + ingresos).uniqueResult();
        INGRESOS_FACTOR = 0.0;
        INGRESOS_WOE = 0.0;
        INGRESOS_TEXTO = "";

        if (ing != null) {

            INGRESOS_FACTOR = ing.getIngPto();
            INGRESOS_WOE = ing.getIngWoe();
            INGRESOS_TEXTO = ing.getIngDesLar();
        }
//gacc
        Query q = s.createQuery("from RngEda as rngeda where rngeda.calId='" + calculadora + "' and rngeda.rngEdaLimInf<=" + edad + " and rngeda.rngEdaLimSup>=" + edad);
        List lista = (List) q.list();
        EDAD_FACTOR = ((RngEda) lista.get(0)).getRngEdaPto();
        EDAD_WOE = ((RngEda) lista.get(0)).getRngEdaWoe();
        EDAD_TEXTO = ((RngEda) lista.get(0)).getRngEdaDesLar();


        DinExt din = (DinExt) s.createQuery("from DinExt as de where de.cal.calId='" + calculadora + "' and de.dinExtId=" + dineroExtra).uniqueResult();
        DINERO_EXTRA_FACTOR = 0.0;
        DINERO_EXTRA_WOE = 0.0;
        DINERO_EXTRA_TEXTO = "";

        if (din != null) {

            DINERO_EXTRA_FACTOR = din.getDinExtPto();
            DINERO_EXTRA_WOE = din.getDinExtWoe();
            DINERO_EXTRA_TEXTO = din.getDinExtDesLar();
        }

        ProAnoGto pgt = (ProAnoGto) s.createQuery("from ProAnoGto as pgt where pgt.calId='" + calculadora + "' and pgt.proAnoGtoId=" + gastoProximo).uniqueResult();
        GASTOS_FACTOR = 0.0;
        GASTOS_WOE = 0.0;
        GASTOS_TEXTO = "";

        if (pgt != null) {

            GASTOS_FACTOR = pgt.getProAnoGtoPto();
            GASTOS_WOE = pgt.getProAnoGtoWoe();
            GASTOS_TEXTO = pgt.getProAnoGtoDesLar();
        }

        NivEst niv = (NivEst) s.createQuery("from NivEst as tr where tr.cal='" + calculadora + "'and tr.nivEstId=" + nivelEscolar).uniqueResult();
        ESCOLARIDAD_FACTOR = 0.0;
        ESCOLARIDAD_WOE = 0.0;
        ESCOLARIDAD_TEXTO = "";

        if (niv != null) {

            ESCOLARIDAD_FACTOR = niv.getNivEstPto();
            ESCOLARIDAD_WOE = niv.getNivEstWoe();
            ESCOLARIDAD_TEXTO = niv.getNivEstDesLar();
        }

        ActExt actext = (ActExt) s.createQuery("from ActExt as ae where ae.cal='" + calculadora + "' and ae.actExtId=" + actExtra).uniqueResult();
        ACTIVIDAD_ADICIONAL_FACTOR = 0.0;
        ACTIVIDAD_ADICIONAL_WOE = 0.0;
        ACTIVIDAD_ADICIONAL_TEXTO = "";

        if (actext != null) {

            ACTIVIDAD_ADICIONAL_FACTOR = actext.getActExtPto();
            ACTIVIDAD_ADICIONAL_WOE = actext.getActExtWoe();
            ACTIVIDAD_ADICIONAL_TEXTO = actext.getActExtDesLar();
        }

        Ptm ptm = (Ptm) s.createQuery("from Ptm as pt where pt.calId='" + calculadora + "' and pt.ptmId=" + prestamo).uniqueResult();
        PRESTAMO_FACTO = 0.0;
        PRESTAMO_WOE = 0.0;
        PRESTAMO_TEXTO = "";

        if (ptm != null) {

            PRESTAMO_FACTO = ptm.getPtmPto();
            PRESTAMO_WOE = ptm.getPtmWoe();
            PRESTAMO_TEXTO = ptm.getPtmDesLar();
        }

        Rel rel = (Rel) s.createQuery("from Rel as r where r.calId='" + calculadora + "' and r.relId=" + religion).uniqueResult();
        RELIGION_FACTOR = 0.0;
        RELIGION_WOE = 0.0;
        RELIGION_TEXTO = "";

        if (rel != null) {

            RELIGION_FACTOR = rel.getRelPto();
            RELIGION_WOE = rel.getRelWoe();
            RELIGION_TEXTO = rel.getRelDesLar();
        }

        Rld rld = (Rld) s.createQuery("from Rld as rld where rld.calId='" + calculadora + "' and rld.rldId=" + influenciaReligion).uniqueResult();
        IMPORTANCIA_RELIGION_FACTOR = 0.0;
        IMPORTANCIA_RELIGION_WOE = 0.0;
        IMPORTANCIA_RELIGION_TEXTO = "";

        if (rld != null) {

            IMPORTANCIA_RELIGION_FACTOR = rld.getRldPto();
            IMPORTANCIA_RELIGION_WOE = rld.getRldWoe();
            IMPORTANCIA_RELIGION_TEXTO = rld.getRldDesLar();
        }

        AsoPar aso = (AsoPar) s.createQuery("from AsoPar as pa where pa.cal='" + calculadora + "' and pa.asoParId=" + asociacionPartido).uniqueResult();
        PARTIDOS_ASOCIACIONES_FACTOR = 0.0;
        PARTIDOS_ASOCIACIONES_WOE = 0.0;
        PARTIDOS_ASOCIACIONES_TEXTO = "";

        if (aso != null) {

            PARTIDOS_ASOCIACIONES_FACTOR = aso.getAsoParPto();
            PARTIDOS_ASOCIACIONES_WOE = aso.getAsoParWoe();
            PARTIDOS_ASOCIACIONES_TEXTO = aso.getAsoParDesLar();
        }

        ParPlt parPlt = (ParPlt) s.createQuery("from ParPlt as pp where pp.calId='" + calculadora + "' and pp.parPltId=" + partidoPol).uniqueResult();
        PARTIDOS_POLITICOS_FACTOR = 0.0;
        PARTIDOS_POLITICOS_WOE = 0.0;
        PARTIDOS_POLITICOS_TEXTO = "";

        if (parPlt != null) {

            PARTIDOS_POLITICOS_FACTOR = parPlt.getParPltPto();
            PARTIDOS_POLITICOS_WOE = parPlt.getParPltWoe();
            PARTIDOS_POLITICOS_TEXTO = parPlt.getParPltDesLar();
        }

        OpnBar opnBar = (OpnBar) s.createQuery("from OpnBar as ob where ob.cal='" + calculadora + "' and ob.opnBarId=" + indOpinionBarzon).uniqueResult();
        ASOCIACIONES_FACTOR = 0.0;
        ASOCIACIONES_WOE = 0.0;
        ASOCIACIONES_TEXTO = "";

        if (opnBar != null) {

            ASOCIACIONES_FACTOR = opnBar.getOpnBarPto();
            ASOCIACIONES_WOE = opnBar.getOpnBarWoe();
            ASOCIACIONES_TEXTO = opnBar.getOpnBarDesLar();
        }

        Mig mig = (Mig) s.createQuery("from Mig as m where m.cal='" + calculadora + "' and m.migId=" + migracion).uniqueResult();
        MOVILIDAD_FACTOR = 0.0;
        MOVILIDAD_WOE = 0.0;
        MOVILIDAD_TEXTO = "";

        if (mig != null) {

            MOVILIDAD_FACTOR = mig.getMigPto();
            MOVILIDAD_WOE = mig.getMigWoe();
            MOVILIDAD_TEXTO = mig.getMigDesLar();
        }


        q = s.createQuery("from RngAntOcp as rao where rao.calId='" + calculadora + "' and rngAntOcpLimInf <=" + antiguedad + " and rngAntOcpLimSup >= " + antiguedad);
        lista = (List) q.list();
        TIEMPO_RAO_FACTOR = ((RngAntOcp) lista.get(0)).getRngAntOcpPto();
        TIEMPO_RAO_WOE = ((RngAntOcp) lista.get(0)).getRngAntOcpWoe();
        TIEMPO_RAO_TEXTO = ((RngAntOcp) lista.get(0)).getRngAntOcpDesLar();




        SCORE_CUALITATIVO = GENERO_FACTOR + ESTADO_CIVIL_FACTOR + TIPO_DE_RESIDENCIA_FACTOR + NUMERO_DE_DEPENDIENTES_FACTOR
                + INGRESOS_FACTOR + EDAD_FACTOR + DINERO_EXTRA_FACTOR + GASTOS_FACTOR + ESCOLARIDAD_FACTOR
                + ACTIVIDAD_ADICIONAL_FACTOR + PRESTAMO_FACTO + RELIGION_FACTOR + IMPORTANCIA_RELIGION_FACTOR
                + PARTIDOS_ASOCIACIONES_FACTOR + PARTIDOS_POLITICOS_FACTOR + ASOCIACIONES_FACTOR + MOVILIDAD_FACTOR
                + TIEMPO_RAO_FACTOR;




    }

    /**
     * Web service Calculadora Cliente Meta
     */
    @WebMethod(operationName = "CalculaMasivaCM")
    public String CalculaMasivaCM(@WebParam(name = "arch") String arch) {


        leeArchivo(arch);
        Session s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.beginTransaction();

        for (int i = 0; i < clientes.size(); i++) {

            ClienteMasivo cliMas = new ClienteMasivo();
            cliMas = ((ClienteMasivo) clientes.get(i));



            if (cliMas.getTiempoResidencia() >= cliMas.getEdad() && cliMas.getTiempoResidencia() >= cliMas.getAntiguedad()) {
                return datosErrorAnt;
            }



            sociodemografico(s,
                    cliMas.getGenero(),
                    cliMas.getEstadoCivil(),
                    cliMas.getTipoResidencia(),
                    cliMas.getDependientes(),
                    cliMas.getIngresos(),
                    cliMas.getEdad(),
                    cliMas.getTiempoResidencia(),
                    cliMas.getAntiguedad(),
                    4);



            cualitativo(s,
                    cliMas.getTiempoResidencia(),
                    cliMas.getAntiguedad(),
                    cliMas.getDineroExtra(),
                    cliMas.getGastoProximo(),
                    cliMas.getNivelEscolar(),
                    cliMas.getActExtra(),
                    cliMas.getPrestamo(),
                    cliMas.getReligion(),
                    cliMas.getInfluenciaReligion(),
                    cliMas.getAsociacionPartido(),
                    cliMas.getPartidoPol(),
                    cliMas.getIndOpinionBarzon(),
                    cliMas.getMigracion(),
                    4);





            if (cliMas.getTieneCredito() == 1) {
                comportamientoPago(s, cliMas.getMesVencido(), cliMas.getPcPago(), cliMas.getPcUso(), 4);

            }



            cliMas.setGeneroClase(GENERO_WOE + ESTADO_CIVIL_WOE + TIPO_DE_RESIDENCIA_WOE + EDAD_WOE + ESCOLARIDAD_WOE + RELIGION_WOE);
            cliMas.setArraigo(((TIEMPO_RES_WOE > TIEMPO_RRA_WOE) ? TIEMPO_RES_WOE : TIEMPO_RRA_WOE) + ((TIEMPO_TRAB_WOE > TIEMPO_RAO_WOE) ? TIEMPO_TRAB_WOE : TIEMPO_RAO_WOE) + MOVILIDAD_WOE);
            cliMas.setComportamientoPago(INGRESOS_WOE + NUMERO_DE_DEPENDIENTES_WOE
                    + DINERO_EXTRA_WOE + GASTOS_WOE + ACTIVIDAD_ADICIONAL_WOE + ACT_WOE + HIST_WOE
                    + ANT_WOE + USO_WOE + PAGO_WOE + MES_VENCIDO_WOE + POR_PAGO_WOE + POR_USO_WOE);
            cliMas.setAspectosDiferenciadores(IMPORTANCIA_RELIGION_WOE
                    + PARTIDOS_ASOCIACIONES_WOE + PARTIDOS_POLITICOS_WOE + ASOCIACIONES_WOE + PRESTAMO_WOE);


            ObtenerGenero(cliMas);

            ObtenerComportamiento(cliMas);
            ObtenerArraigo(cliMas);
            ObtenerDiferenciadores(cliMas);


            String resultado = "";
            if (cliMas.getTieneCredito() == 1) {
                if (SCORE_COMPORTAMIENTO_DE_PAGO >= 800) {
                    resultado = "CLIENTE META ANTES DE BURO";
                } else {
                    if (SCORE_COMPORTAMIENTO_DE_PAGO < 616) {
                        cualitativo2(s,
                                cliMas.getGenero(),
                                cliMas.getEstadoCivil(),
                                cliMas.getTipoResidencia(),
                                cliMas.getDependientes(),
                                cliMas.getIngresos(),
                                cliMas.getEdad(),
                                cliMas.getAntiguedad(),
                                cliMas.getDineroExtra(),
                                cliMas.getGastoProximo(),
                                cliMas.getNivelEscolar(),
                                cliMas.getActExtra(),
                                cliMas.getPrestamo(),
                                cliMas.getReligion(),
                                cliMas.getInfluenciaReligion(),
                                cliMas.getAsociacionPartido(),
                                cliMas.getPartidoPol(),
                                cliMas.getIndOpinionBarzon(),
                                cliMas.getMigracion(),
                                12);

                        //calcular
                        if (SCORE_CUALITATIVO >= 800) {
                            resultado = "CLIENTE META ANTES DE BURO";
                        } else {
                            resultado = "CLIENTE DECLINADO";
                        }
                    } else if (SCORE_COMPORTAMIENTO_DE_PAGO >= 616 && SCORE_COMPORTAMIENTO_DE_PAGO < 800 && SCORE_CUALITATIVO >= 800) {
                        resultado = "CLIENTE META ANTES DE BURO";
                    } else if (SCORE_COMPORTAMIENTO_DE_PAGO >= 616 && SCORE_COMPORTAMIENTO_DE_PAGO < 800 && SCORE_CUALITATIVO < 800) {
                        resultado = "CLIENTE DECLINADO";

                        //calcular
                        cualitativo2(s,
                                cliMas.getGenero(),
                                cliMas.getEstadoCivil(),
                                cliMas.getTipoResidencia(),
                                cliMas.getDependientes(),
                                cliMas.getIngresos(),
                                cliMas.getEdad(),
                                cliMas.getAntiguedad(),
                                cliMas.getDineroExtra(),
                                cliMas.getGastoProximo(),
                                cliMas.getNivelEscolar(),
                                cliMas.getActExtra(),
                                cliMas.getPrestamo(),
                                cliMas.getReligion(),
                                cliMas.getInfluenciaReligion(),
                                cliMas.getAsociacionPartido(),
                                cliMas.getPartidoPol(),
                                cliMas.getIndOpinionBarzon(),
                                cliMas.getMigracion(),
                                12);

                        if (SCORE_CUALITATIVO >= 800) {
                            resultado = "CLIENTE META ANTES DE BURO";
                        } else {
                            resultado = "CLIENTE DECLINADO";
                        }
                    }
                }
            } else {

                if (SCORE_SOCIODEMOGRAFICO >= 800) {
                    resultado = "CLIENTE META ANTES DE BURO";
                } else if (SCORE_SOCIODEMOGRAFICO < 500) {
                    if (SCORE_CUALITATIVO >= 800) {
                        resultado = "CLIENTE META ANTES DE BURO";
                    } else {
                        resultado = "CLIENTE DECLINADO";
                    }
                } else if (SCORE_SOCIODEMOGRAFICO >= 500 && SCORE_SOCIODEMOGRAFICO < 800 && SCORE_CUALITATIVO >= 800) {
                    resultado = "CLIENTE META ANTES DE BURO";
                } else if (SCORE_SOCIODEMOGRAFICO >= 500 && SCORE_SOCIODEMOGRAFICO < 800 && SCORE_CUALITATIVO < 750) {//calcular
                    cualitativo2(s,
                            cliMas.getGenero(),
                            cliMas.getEstadoCivil(),
                            cliMas.getTipoResidencia(),
                            cliMas.getDependientes(),
                            cliMas.getIngresos(),
                            cliMas.getEdad(),
                            cliMas.getAntiguedad(),
                            cliMas.getDineroExtra(),
                            cliMas.getGastoProximo(),
                            cliMas.getNivelEscolar(),
                            cliMas.getActExtra(),
                            cliMas.getPrestamo(),
                            cliMas.getReligion(),
                            cliMas.getInfluenciaReligion(),
                            cliMas.getAsociacionPartido(),
                            cliMas.getPartidoPol(),
                            cliMas.getIndOpinionBarzon(),
                            cliMas.getMigracion(),
                            12);

                    if (SCORE_CUALITATIVO >= 800) {
                        resultado = "CLIENTE META ANTES DE BURO";
                    } else {
                        resultado = "CLIENTE DECLINADO";
                    }
                } else if (SCORE_SOCIODEMOGRAFICO >= 500 && SCORE_SOCIODEMOGRAFICO < 800 && SCORE_CUALITATIVO > 750 && SCORE_CUALITATIVO < 800) //calcular
                {
                    cualitativo2(s,
                            cliMas.getGenero(),
                            cliMas.getEstadoCivil(),
                            cliMas.getTipoResidencia(),
                            cliMas.getDependientes(),
                            cliMas.getIngresos(),
                            cliMas.getEdad(),
                            cliMas.getAntiguedad(),
                            cliMas.getDineroExtra(),
                            cliMas.getGastoProximo(),
                            cliMas.getNivelEscolar(),
                            cliMas.getActExtra(),
                            cliMas.getPrestamo(),
                            cliMas.getReligion(),
                            cliMas.getInfluenciaReligion(),
                            cliMas.getAsociacionPartido(),
                            cliMas.getPartidoPol(),
                            cliMas.getIndOpinionBarzon(),
                            cliMas.getMigracion(),
                            12);

                    if (SCORE_CUALITATIVO >= 800) {
                        resultado = "CLIENTE META ANTES DE BURO";
                    } else {
                        resultado = "CLIENTE DECLINADO";
                    }
                }


            }
            cliMas.setResultado(resultado);


        }


        //   imprimeReporte(clientes);






        //TODO write your implementation code here:
        return imprimeReporte();
    }

    private void leeArchivo(String xml) {

        try {

            Matcher junkMatcher = (Pattern.compile("^([\\W]+)<")).matcher(xml.trim());
            xml = junkMatcher.replaceFirst("<");
            if (xml.startsWith("<")) {
                junkMatcher = (Pattern.compile("(?:\\r?\\n|\\r)")).matcher(xml.trim());
                xml = junkMatcher.replaceAll("");
            }

            if (xml.startsWith("<")) {
                leeXml(xml);

            } else {
                leePlano(xml);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void ObtenerGenero(ClienteMasivo cliMas) {

        GENERO_FACTOR = ABSOLUTO(GENERO_FACTOR);
        ESTADO_CIVIL_FACTOR = ABSOLUTO(ESTADO_CIVIL_FACTOR);
        TIPO_DE_RESIDENCIA_FACTOR = ABSOLUTO(TIPO_DE_RESIDENCIA_FACTOR);
        EDAD_FACTOR = ABSOLUTO(EDAD_FACTOR);
        ESCOLARIDAD_FACTOR = ABSOLUTO(ESCOLARIDAD_FACTOR);
        RELIGION_FACTOR = ABSOLUTO(RELIGION_FACTOR);

        double SUMA_GENERO_CLASE = GENERO_FACTOR + ESTADO_CIVIL_FACTOR + TIPO_DE_RESIDENCIA_FACTOR
                + EDAD_FACTOR + ESCOLARIDAD_FACTOR + RELIGION_FACTOR;
        double GENERO_PESO = GENERO_FACTOR / SUMA_GENERO_CLASE;
        double ESTADO_CIVIL_PESO = ESTADO_CIVIL_FACTOR / SUMA_GENERO_CLASE;
        double TIPO_DE_RESIDENCIA_PESO = TIPO_DE_RESIDENCIA_FACTOR / SUMA_GENERO_CLASE;
        double EDAD_PESO = EDAD_FACTOR / SUMA_GENERO_CLASE;
        double ESCOLARIDAD_PESO = ESCOLARIDAD_FACTOR / SUMA_GENERO_CLASE;
        double RELIGION_PESO = RELIGION_FACTOR / SUMA_GENERO_CLASE;

        String arregloTex[] = {GENERO_TEXTO, ESTADO_CIVIL_TEXTO, TIPO_DE_RESIDENCIA_TEXTO, EDAD_TEXTO, ESCOLARIDAD_TEXTO};
        double arregloDes[] = {GENERO_PESO, ESTADO_CIVIL_PESO, TIPO_DE_RESIDENCIA_PESO, EDAD_PESO, ESCOLARIDAD_PESO};
        ordena(arregloDes, arregloTex);
        double PRIMER_PESO_GENERO = arregloDes[0];
        double SEGUNDO_PESO_GENERO = arregloDes[1];
        ;
        cliMas.setPrimerTextoGenero(arregloTex[0]);
        cliMas.setSegundoTextoGenero(arregloTex[1]);



    }

    private void ObtenerComportamiento(ClienteMasivo cliMas) {
        NUMERO_DE_DEPENDIENTES_FACTOR = ABSOLUTO(NUMERO_DE_DEPENDIENTES_FACTOR);
        INGRESOS_FACTOR = ABSOLUTO(INGRESOS_FACTOR);
        DINERO_EXTRA_FACTOR = ABSOLUTO(DINERO_EXTRA_FACTOR);
        GASTOS_FACTOR = ABSOLUTO(GASTOS_FACTOR);
        ACTIVIDAD_ADICIONAL_FACTOR = ABSOLUTO(ACTIVIDAD_ADICIONAL_FACTOR);
        MES_VENCIDO_FACTOR = ABSOLUTO(MES_VENCIDO_FACTOR);
        POR_PAGO_FACTOR = ABSOLUTO(POR_PAGO_FACTOR);
        POR_USO_FACTOR = ABSOLUTO(POR_USO_FACTOR);

        double SUMA_COMPORTAMIENTO_PAGO = NUMERO_DE_DEPENDIENTES_FACTOR
                + INGRESOS_FACTOR + DINERO_EXTRA_FACTOR + GASTOS_FACTOR
                + ACTIVIDAD_ADICIONAL_FACTOR + ACT_FACTOR + HIST_FACTOR + ANT_FACTOR
                + USO_FACTOR + PAGO_FACTOR + MES_VENCIDO_FACTOR + POR_PAGO_FACTOR + POR_USO_FACTOR;

        double NUMERO_DE_DEPENDIENTES_PESO = NUMERO_DE_DEPENDIENTES_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
        double INGRESOS_PESO = INGRESOS_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
        double DINERO_EXTRA_PESO = DINERO_EXTRA_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
        double GASTOS_PESO = GASTOS_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
        double ACTIVIDAD_ADICIONAL_PESO = ACTIVIDAD_ADICIONAL_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
        double MES_VENCIDO_PESO = MES_VENCIDO_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
        double POR_PAGO_PESO = POR_PAGO_FACTOR / SUMA_COMPORTAMIENTO_PAGO;
        double POR_USO_PESO = POR_USO_FACTOR / SUMA_COMPORTAMIENTO_PAGO;

        String arregloTexComp[] = {NUMERO_DE_DEPENDIENTES_TEXTO, INGRESOS_TEXTO, DINERO_EXTRA_TEXTO, GASTOS_TEXTO, ACTIVIDAD_ADICIONAL_TEXTO, MES_VENCIDO_TEXTO, POR_PAGO_TEXTO, POR_USO_TEXTO};
        double arregloDesComp[] = {NUMERO_DE_DEPENDIENTES_PESO, INGRESOS_PESO, DINERO_EXTRA_PESO, GASTOS_PESO, ACTIVIDAD_ADICIONAL_PESO, MES_VENCIDO_PESO, POR_PAGO_PESO, POR_USO_PESO};
        ordena(arregloDesComp, arregloTexComp);
        double PRIMER_PESO_COMPORTAMIENTO = arregloDesComp[0];
        double SEGUNDO_PESO_COMPORTAMIENTO = arregloDesComp[1];
        cliMas.setPrimerTextoComportamiento(arregloTexComp[0]);
        cliMas.setSegundoTextoComportamiento(arregloTexComp[1]);


    }

    private void ObtenerArraigo(ClienteMasivo cliMas) {

        TIEMPO_RES_FACTOR = ABSOLUTO(TIEMPO_RES_FACTOR);
        TIEMPO_TRAB_FACTOR = ABSOLUTO(TIEMPO_TRAB_FACTOR);
        MOVILIDAD_FACTOR = ABSOLUTO(TIEMPO_TRAB_FACTOR);

        double SUMA_ARRAIGO = TIEMPO_RES_FACTOR + TIEMPO_TRAB_FACTOR + MOVILIDAD_FACTOR;

        double TIEMPO_RES_PESO = TIEMPO_RES_FACTOR / SUMA_ARRAIGO;
        double TIEMPO_TRAB_PESO = TIEMPO_TRAB_FACTOR / SUMA_ARRAIGO;
        double MOVILIDAD_PESO = MOVILIDAD_FACTOR / SUMA_ARRAIGO;

        String arregloTexAra[] = {TIEMPO_RES_TEXTO, TIEMPO_TRAB_TEXTO, MOVILIDAD_TEXTO};
        double arregloDesAra[] = {TIEMPO_RES_PESO, TIEMPO_TRAB_PESO, MOVILIDAD_PESO};
        ordena(arregloDesAra, arregloTexAra);
        double PRIMER_PESO_ARRAIGO = arregloDesAra[0];
        double SEGUNDO_PESO_ARRAIGO = arregloDesAra[1];
        cliMas.setPrimerTextoArraigo(arregloTexAra[0]);
        cliMas.setSegundoTextoArraigo(arregloTexAra[1]);


    }

    private void ObtenerDiferenciadores(ClienteMasivo cliMas) {
        IMPORTANCIA_RELIGION_FACTOR = ABSOLUTO(IMPORTANCIA_RELIGION_FACTOR);
        PARTIDOS_ASOCIACIONES_FACTOR = ABSOLUTO(PARTIDOS_ASOCIACIONES_FACTOR);
        PARTIDOS_POLITICOS_FACTOR = ABSOLUTO(PARTIDOS_POLITICOS_FACTOR);
        ASOCIACIONES_FACTOR = ABSOLUTO(ASOCIACIONES_FACTOR);
        PRESTAMO_FACTO = ABSOLUTO(PRESTAMO_FACTO);

        double SUMA_ASPECTOS_DIFERENCIALES = IMPORTANCIA_RELIGION_FACTOR + PARTIDOS_ASOCIACIONES_FACTOR
                + PARTIDOS_POLITICOS_FACTOR + ASOCIACIONES_FACTOR + PRESTAMO_FACTO;

        double IMPORTANCIA_RELIGION_PESO = IMPORTANCIA_RELIGION_FACTOR / SUMA_ASPECTOS_DIFERENCIALES;
        double PARTIDOS_ASOCIACIONES_PESO = PARTIDOS_ASOCIACIONES_FACTOR / SUMA_ASPECTOS_DIFERENCIALES;
        double PARTIDOS_POLITICOS_PESO = PARTIDOS_POLITICOS_FACTOR / SUMA_ASPECTOS_DIFERENCIALES;
        double ASOCIACIONES_PESO = ASOCIACIONES_FACTOR / SUMA_ASPECTOS_DIFERENCIALES;
        double PRESTAMO_PESO = PRESTAMO_FACTO / SUMA_ASPECTOS_DIFERENCIALES;

        String arregloTexDif[] = {IMPORTANCIA_RELIGION_TEXTO, PARTIDOS_ASOCIACIONES_TEXTO, PARTIDOS_POLITICOS_TEXTO, ASOCIACIONES_TEXTO, PRESTAMO_TEXTO};
        double arregloDesDif[] = {IMPORTANCIA_RELIGION_PESO, PARTIDOS_ASOCIACIONES_PESO, PARTIDOS_POLITICOS_PESO, ASOCIACIONES_PESO, PRESTAMO_PESO};
        ordena(arregloDesDif, arregloTexDif);
        double PRIMER_PESO_DIFERENCIADORES = arregloDesDif[0];
        double SEGUNDO_PESO_DIFERENCIADORES = arregloDesDif[1];
        cliMas.setPrimerTextoDiferenciadores(arregloTexDif[0]);
        cliMas.setSegundoTextoDiferenciadores(arregloTexDif[1]);


    }

    private String imprimeReporte() {

        String xmlString = "";
        try {
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            Document docOUT = docBuilder.newDocument();


            Element raiz = docOUT.createElement("SalidaCalculadoraCM");
            docOUT.appendChild(raiz);
            DocumentFragment fragment = docOUT.createDocumentFragment();


            for (int i = 0; i < clientes.size(); i++) {

                ClienteMasivo cliMas = new ClienteMasivo();
                cliMas = ((ClienteMasivo) clientes.get(i));
                Element person = Fragmenttree(
                        docOUT,
                        Integer.toString(cliMas.getCliId()),
                        Integer.toString(cliMas.getCliSap()),
                        Double.toString(cliMas.getGenero()),
                        Double.toString(cliMas.getComportamientoPago()),
                        Double.toString(cliMas.getArraigo()),
                        Double.toString(cliMas.getAspectosDiferenciadores()),
                        cliMas.getPrimerTextoGenero(),
                        cliMas.getSegundoTextoGenero(),
                        cliMas.getPrimerTextoComportamiento(),
                        cliMas.getSegundoTextoComportamiento(),
                        cliMas.getPrimerTextoArraigo(),
                        cliMas.getSegundoTextoArraigo(),
                        cliMas.getPrimerTextoDiferenciadores(),
                        cliMas.getSegundoTextoDiferenciadores(),
                        cliMas.getResultado());
                fragment.appendChild(person);
                raiz.appendChild(fragment);


            }
            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(docOUT);
            trans.transform(source, result);
            xmlString = sw.toString();
            return xmlString;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }



    }

    private Element Fragmenttree(
            Document doc,
            String acliID,
            String acliSAP,
            String aGenero,
            String aComportamientoPago,
            String aArraigo,
            String aAspectosDiferenciadores,
            String aPTGenero,
            String aSTGenero,
            String aPTComportamiento,
            String aSTComportamiento,
            String aPTArraigo,
            String aSTArraigo,
            String aPTDiferenciadores,
            String aSTDiferenciadores,
            String aResultado) {
        Element cliID = doc.createElement("CLI_ID");
        Text text = doc.createTextNode(acliID == null ? "" : acliID);
        cliID.appendChild(text);

        Element cliSAP = doc.createElement("CLI_SAP");
        text = doc.createTextNode(acliSAP == null ? "" : acliSAP);
        cliSAP.appendChild(text);


        Element genero = doc.createElement("Suma_Genero_Clase");
        text = doc.createTextNode(aGenero == null ? "" : aGenero);
        genero.appendChild(text);

        Element comportamiento = doc.createElement("Suma_Comportamiento_Pago");
        text = doc.createTextNode(aComportamientoPago == null ? "" : aComportamientoPago);
        comportamiento.appendChild(text);

        Element arraigo = doc.createElement("Suma_Arraigo");
        text = doc.createTextNode(aArraigo == null ? "" : aArraigo);
        arraigo.appendChild(text);

        Element diferenciadores = doc.createElement("Suma_Aspectos_Diferenciadores");
        text = doc.createTextNode(aAspectosDiferenciadores == null ? "" : aAspectosDiferenciadores);
        diferenciadores.appendChild(text);

        Element ptg = doc.createElement("Genero_Clase_Texto1");
        text = doc.createTextNode(aPTGenero == null ? "" : aPTGenero);
        ptg.appendChild(text);

        Element stg = doc.createElement("Genero_Clase_Texto2");
        text = doc.createTextNode(aSTGenero == null ? "" : aSTGenero);
        stg.appendChild(text);

        Element ptc = doc.createElement("Comportamiento_Pago_Texto1");
        text = doc.createTextNode(aPTComportamiento == null ? "" : aPTComportamiento);
        ptc.appendChild(text);

        Element stc = doc.createElement("Comportamiento_Pago_Texto2");
        text = doc.createTextNode(aSTComportamiento == null ? "" : aSTComportamiento);
        stc.appendChild(text);

        Element pta = doc.createElement("Arraigo_Texto1");
        text = doc.createTextNode(aPTArraigo == null ? "" : aPTArraigo);
        pta.appendChild(text);

        Element sta = doc.createElement("Arraigo_Texto2");
        text = doc.createTextNode(aSTArraigo == null ? "" : aSTArraigo);
        sta.appendChild(text);

        Element ptd = doc.createElement("Aspectos_Diferenciadores_Texto1");
        text = doc.createTextNode(aPTDiferenciadores == null ? "" : aPTDiferenciadores);
        ptd.appendChild(text);

        Element std = doc.createElement("Aspectos_Diferenciadores_Texto2");
        text = doc.createTextNode(aSTDiferenciadores == null ? "" : aSTDiferenciadores);
        std.appendChild(text);

        Element res = doc.createElement("Resultado");
        text = doc.createTextNode(aResultado == null ? "" : aResultado);
        res.appendChild(text);


        Element cliente = doc.createElement("CLIENTE");
        cliente.appendChild(genero);
        cliente.appendChild(comportamiento);
        cliente.appendChild(arraigo);
        cliente.appendChild(diferenciadores);
        cliente.appendChild(ptg);
        cliente.appendChild(stg);
        cliente.appendChild(ptc);
        cliente.appendChild(stc);
        cliente.appendChild(pta);
        cliente.appendChild(sta);
        cliente.appendChild(ptd);
        cliente.appendChild(std);
        cliente.appendChild(res);
        return (cliente);

    }

    private void leeXml(String xml) {

        try {



            ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
            DocumentBuilderFactory dbfacIN = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilderIN = dbfacIN.newDocumentBuilder();
            Document docIN = docBuilderIN.parse(bais);

            if (docIN.getDocumentElement().getNodeName().equals("EntradaCalculadoraCM")) {
                NodeList listaNodos = docIN.getDocumentElement().getChildNodes();

                for (int i = 0; i < listaNodos.getLength(); i++) {
                    System.out.println(i);
                    NodeList nodoCliente = listaNodos.item(i).getChildNodes();

                    int cliId = GetValueInt(nodoCliente, "CLI_ID");
                    int cliSap = GetValueInt(nodoCliente, "CLI_SAP");
                    int genero = GetValueInt(nodoCliente, "GENERO");
                    int estadoCivil = GetValueInt(nodoCliente, "ESTADO_CIVIL");
                    int tipoResidencia = GetValueInt(nodoCliente, "TIPO_RESIDENCIA");
                    int dependientes = GetValueInt(nodoCliente, "DEPENDIENTES");
                    int ingresos = GetValueInt(nodoCliente, "INGRESO");
                    int edad = GetValueInt(nodoCliente, "EDAD");
                    int tiempoResidencia = GetValueInt(nodoCliente, "TIEMPO_RESIDENCIA");
                    int antiguedad = GetValueInt(nodoCliente, "ANTIGUEDAD");
                    int dineroExtra = GetValueInt(nodoCliente, "DINERO_EXTRA");
                    int gastoProximo = GetValueInt(nodoCliente, "GASTO_PROXIMO");
                    int nivelEscolar = GetValueInt(nodoCliente, "NIVEL_ESCOLAR");
                    int actExtra = GetValueInt(nodoCliente, "ACT_EXTRA");
                    int prestamo = GetValueInt(nodoCliente, "PRESTAMO");
                    int religion = GetValueInt(nodoCliente, "RELIGION");
                    int influenciaReligion = GetValueInt(nodoCliente, "INFLUENCIA_RELIGION");
                    int asociacionPartido = GetValueInt(nodoCliente, "ASOCIACION_PARTIDO");
                    int partidoPol = GetValueInt(nodoCliente, "PARTIDO_POL");
                    int indOpinionBarzon = GetValueInt(nodoCliente, "IND_OPINION_BARZON");
                    int migracion = GetValueInt(nodoCliente, "MIGRACION");
                    int tieneBuro = GetValueInt(nodoCliente, "COMPORTAMIENTO_CREDITO");
                    int tieneCredito = GetValueInt(nodoCliente, "CREDITO");
                    int mesVencido = GetValueInt(nodoCliente, "MES_VENCIDO");
                    int pcPago = GetValueInt(nodoCliente, "PC_PAGO");
                    int pcUso = GetValueInt(nodoCliente, "PC_USO");


                    clientes.add(new ClienteMasivo(cliId, cliSap, genero, estadoCivil, tipoResidencia,
                            dependientes, ingresos, edad, tiempoResidencia, antiguedad, dineroExtra,
                            gastoProximo, nivelEscolar, actExtra, prestamo, religion, influenciaReligion, asociacionPartido,
                            partidoPol, indOpinionBarzon, migracion, tieneCredito, mesVencido, pcPago, pcUso));
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void leePlano(String xml) {

        try {


            String[] arreglo = xml.split("\n");
            for (int i = 0; i < arreglo.length; i++) {
                String[] s = arreglo[i].split(",");

                int cliId = Integer.parseInt(s[0]);
                int cliSap = Integer.parseInt(s[1]);
                int genero = Integer.parseInt(s[2]);
                int estadoCivil = Integer.parseInt(s[3]);
                int tipoResidencia = Integer.parseInt(s[4]);
                int dependientes = Integer.parseInt(s[5]);
                int ingresos = Integer.parseInt(s[6]);
                int edad = Integer.parseInt(s[7]);
                int tiempoResidencia = Integer.parseInt(s[8]);
                int antiguedad = Integer.parseInt(s[9]);
                int dineroExtra = Integer.parseInt(s[10]);
                int gastoProximo = Integer.parseInt(s[11]);
                int nivelEscolar = Integer.parseInt(s[12]);
                int actExtra = Integer.parseInt(s[13]);
                int prestamo = Integer.parseInt(s[14]);
                int religion = Integer.parseInt(s[15]);
                int influenciaReligion = Integer.parseInt(s[16]);
                int asociacionPartido = Integer.parseInt(s[17]);
                int partidoPol = Integer.parseInt(s[18]);
                int indOpinionBarzon = Integer.parseInt(s[19]);
                int migracion = Integer.parseInt(s[20]);
                int tieneBuro = Integer.parseInt(s[21]);
                int tieneCredito = Integer.parseInt(s[22]);
                int mesVencido = Integer.parseInt(s[23]);
                int pcPago = Integer.parseInt(s[24]);
                int pcUso = Integer.parseInt(s[25]);

                clientes.add(new ClienteMasivo(cliId, cliSap, genero, estadoCivil, tipoResidencia,
                        dependientes, ingresos, edad, tiempoResidencia, antiguedad, dineroExtra,
                        gastoProximo, nivelEscolar, actExtra, prestamo, religion, influenciaReligion, asociacionPartido,
                        partidoPol, indOpinionBarzon, migracion, tieneCredito, mesVencido, pcPago, pcUso));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {

        CalculadoraCMWS meta = new CalculadoraCMWS();
        String res = meta.CalculaCM("<?xml version='1.0' encoding='UTF-8' standalone='no'?><EntradaCalculadoraCM><CLI_ID>405</CLI_ID><CLI_SAP>0</CLI_SAP><CLI_APE_PAT>INTENTO</CLI_APE_PAT><CLI_APE_MAT>UNO</CLI_APE_MAT><CLI_NOM>MIO</CLI_NOM><CLI_FEC_NAC>1948-02-03</CLI_FEC_NAC><CLI_DOM_CAL>CALLE</CLI_DOM_CAL><CLI_DOM_NUM_EXT>NUM</CLI_DOM_NUM_EXT><CLI_DOM_NUM_INT>NUM</CLI_DOM_NUM_INT><CLI_DOM_COL>COL</CLI_DOM_COL><COD_POS_ID>55040</COD_POS_ID><GENERO>2</GENERO><ESTADO_CIVIL>6</ESTADO_CIVIL><TIPO_RESIDENCIA>1</TIPO_RESIDENCIA><DEPENDIENTES>5</DEPENDIENTES><INGRESO>1</INGRESO><EDAD>62</EDAD><TIEMPO_RESIDENCIA>1</TIEMPO_RESIDENCIA><ANTIGUEDAD>1</ANTIGUEDAD><DINERO_EXTRA>15</DINERO_EXTRA><GASTO_PROXIMO>1</GASTO_PROXIMO><NIVEL_ESCOLAR>1</NIVEL_ESCOLAR><ACT_EXTRA>6</ACT_EXTRA><PRESTAMO>1</PRESTAMO><RELIGION>1</RELIGION><INFLUENCIA_RELIGION>1</INFLUENCIA_RELIGION><ASOCIACION_PARTIDO>1</ASOCIACION_PARTIDO><PARTIDO_POL>1</PARTIDO_POL><IND_OPINION_BARZON>1</IND_OPINION_BARZON><MIGRACION>1</MIGRACION><COMPORTAMIENTO_CREDITO>0</COMPORTAMIENTO_CREDITO><ACT>0</ACT><HIST>0</HIST><ANT>0</ANT><USO>0</USO><PAGO>0</PAGO><CREDITO>1</CREDITO><MES_VENCIDO>1</MES_VENCIDO><PC_PAGO>1</PC_PAGO><PC_USO>1</PC_USO><OCUPACION>0</OCUPACION><ESTADO>47</ESTADO><VALOR_VIVIENDA>100000</VALOR_VIVIENDA><CUOTA>1000</CUOTA><FECHA>1</FECHA></EntradaCalculadoraCM>");

        System.out.println(res);
    }

    private int getValorVersionCorta(Document doc, String nodo) {      

      NodeList list = doc.getElementsByTagName(nodo);
        
      if(list.getLength() != 0){

          System.out.println("nombre del");
          return Integer.parseInt(list.item(0).getFirstChild().getNodeValue());
      }return -1;

    }


    private int getValoresVersionGabrielEx(Document doc, String nodo) throws Exception{


        NodeList listaNodos = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < listaNodos.getLength(); i++) {
            if (listaNodos.item(i).getNodeName().equals(nodo)) {
                if (!listaNodos.item(i).getTextContent().equals("")) {
                    return Integer.parseInt(listaNodos.item(i).getTextContent());
                } else {
                    throw new Exception(tabVacioExpt + nodo);
                }
            }
        }
        throw new Exception(tabNoEncontradoExpt + nodo);
    }



   private Object getValue(Document doc, String nodo, Boolean valInt){

       NodeList list = doc.getElementsByTagName(nodo);

      if(list.getLength() != 0){

          Object val =  list.item(0).getFirstChild().getNodeValue();
          return valInt? Integer.parseInt(String.valueOf(val)): val;
      }
      return null;
    }

  private String GetValue(Document doc, String nodo){
         return (String) getValue(doc, nodo, Boolean.FALSE);
     }

  private int GetValueInt(Document doc, String nodo) throws Exception{
      return (Integer) getValue(doc, nodo, Boolean.TRUE);
  }

  private void AgregarNodo(Element raiz, Document doc, String tab, Object valor)  {
    Element child = doc.createElement(tab);
    Text text = doc.createTextNode(String.valueOf(valor));
    child.appendChild(text);
    raiz.appendChild(child);
  }

  private String xmlString(Document doc) {

  
        try {


           StringWriter stw = new StringWriter();
           Transformer serializer = TransformerFactory.newInstance().newTransformer();
           serializer.transform(new DOMSource(doc), new StreamResult(stw));
           return stw.toString();

        } catch (TransformerException ex) {
            Logger.getLogger(CalculadoraCMWS.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }

  private Document creaXml(String root) {

        try {

            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element raiz = doc.createElement(root);
            doc.appendChild(raiz);
            return doc;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CalculadoraCMWS.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }

   private int GetValueInt(NodeList listaNodos, String nodo) throws Exception {
        for (int i = 0; i < listaNodos.getLength(); i++) {
            if (listaNodos.item(i).getNodeName().equals(nodo)) {
                if (!listaNodos.item(i).getTextContent().equals("")) {
                    return Integer.parseInt(listaNodos.item(i).getTextContent());
                } else {
                    return 0;
                }
            }
            //   throw new Exception(tabVacioExpt + nodo);
        }
        throw new Exception(tabNoEncontradoExpt + nodo);
    }

}
