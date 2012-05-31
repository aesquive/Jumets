package servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import com.meve.util.db.ConnectionManager;
import com.meve.util.db.ConnectionUtil;
import com.urbi.dao.impl.Dao;
import com.urbi.db.ConexionDS;
import com.urbi.prima.PrimaBean;
import com.urbi.prima.PrimaSql;
import com.urbi.prima.PrimaUtil;
import gol.beans.GolBean;
import gol.beans.GolSql;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import objetos.ActUlt;
import objetos.BurAct;
import objetos.BurAnt;
import objetos.BurHis;
import objetos.BurPag;
import objetos.BurUso;
import objetos.Cli;
import objetos.CliGol;
import objetos.CueAbr;
import objetos.DinExt;
import objetos.FreRel;
import objetos.GtoAlm;
import objetos.GtoImp;
import objetos.GtoRen;
import objetos.GtoSerViv;
import objetos.GtoVes;
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
import org.hibernate.Transaction;



/**
 * @author Rodrigo
 */
public class NuevoReportador {


	List<String> valoresCalc = new ArrayList<String>();

       
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
	String I_RENTA_DES = "";
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
	String SERVICIO_HOGAR_DES = "";
	String VALOR_VIVIENDA_DES = "";
	double SCORE_IPSICO_FACTOR = 0;
	double SCORE_IPSICO_WOE = 0;

	double HIST_FACTOR = 0;
	double HIST_WOE = 0;
	String HIST_TEXTO = "";

	double ANT_FACTOR = 0;
	double ANT_WOE = 0;
	String ANT_TEXTO = "";

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

        String estado="";

        static List<String> faltantes=new ArrayList<String>();

	private GolBean gol = new GolBean();

	public NuevoReportador() {
	}

	public NuevoReportador(GolBean gol) {

            this.gol = gol;
	}

	public void golWs(List<String> chit , List<String> cnohit ,List<String> cburo) {
		Session s = objetos.HibernateUtil.getSessionFactory()
				.getCurrentSession();



		Transaction tx = s.beginTransaction();
                //sacamos el estado
                 estado= this.obtenEstado(gol.getCp())==null ? "" :this.obtenEstado(gol.getCp());

                if(estado.equals("")){
                    
                    faltantes.add(gol.getCp());
                }


                int I_PSICO = 0;
		int GENERO = Integer.parseInt(gol.getSexo());
		int RELIGION = Integer.parseInt(gol.getReligionFamilia());
		int FRECUENCIA_RELIGION = Integer.parseInt(gol.getReligionFrecuencia());
		int ESCOLARIDAD = Integer.parseInt(gol.getGradoE());
		int TRABAJO_ANTERIOR = Integer.parseInt(gol.getActividadPrincipal());

		// Pregunta 1
		int AGRESION_1 = 0;
		if (Integer.parseInt(gol.getPregunta1()) == 1
				|| Integer.parseInt(gol.getPregunta1()) == 2)
			AGRESION_1 = 1;
		else
			AGRESION_1 = 2;

		// Pregunta8
		int AGRESION_4 = 0;
		if (Integer.parseInt(gol.getPregunta8()) == 1
				|| Integer.parseInt(gol.getPregunta8()) == 2)
			AGRESION_4 = 1;
		else
			AGRESION_4 = 2;

		// Pregunta10
		int ADHESION_GRUPO3 = 0;
		if (Integer.parseInt(gol.getPregunta10()) == 1
				|| Integer.parseInt(gol.getPregunta10()) == 2)
			ADHESION_GRUPO3 = 1;
		else
			ADHESION_GRUPO3 = 2;

		int RESENTIMIENTO_SOCIAL3 = 0;
		if (Integer.parseInt(gol.getPregunta11()) == 1
				|| Integer.parseInt(gol.getPregunta11()) == 2)
			RESENTIMIENTO_SOCIAL3 = 1;
		else
			RESENTIMIENTO_SOCIAL3 = 2;

		int CONDUCTA_DELICTIVA2 = 1;
		if (Integer.parseInt(gol.getPregunta15()) == 1
				|| Integer.parseInt(gol.getPregunta15()) == 2)
			CONDUCTA_DELICTIVA2 = 1;
		else
			CONDUCTA_DELICTIVA2 = 2;

		int RESENTIMIENTO_SOCIAL4 = 1;
		if (Integer.parseInt(gol.getPregunta17()) == 1
				|| Integer.parseInt(gol.getPregunta17()) == 2)
			RESENTIMIENTO_SOCIAL4 = 1;
		else
			RESENTIMIENTO_SOCIAL4 = 2;

		int RESPONSABILIDAD4 = 1;
		if (Integer.parseInt(gol.getPregunta18()) == 1
				|| Integer.parseInt(gol.getPregunta18()) == 2)
			RESPONSABILIDAD4 = 1;
		else
			RESPONSABILIDAD4 = 2;

		int CONDUCTA_DELICTIVA5 = 1;
		if (Integer.parseInt(gol.getPregunta25()) == 1
				|| Integer.parseInt(gol.getPregunta25()) == 2)
			CONDUCTA_DELICTIVA5 = 1;
		else
			CONDUCTA_DELICTIVA5 = 2;

		int DINERO_EXTRA = Integer.parseInt(gol.getDineroExtra());
		int VIVIENDA_ACTUAL = gol.getTiempoViviendo();
		int SERVICIO_HOGAR = Integer.parseInt(gol.getComercioIndispensable());

		int ACT = gol.getAct();
		int HIST = gol.getHist();
		int ANT = gol.getAnt();
		int PAGO = gol.getPago();
		int USO = gol.getUso();

		int cuentaA = 0;
		if (gol.getCuentasA() != null)
			cuentaA = Integer.parseInt(gol.getCuentasA());
		int CUEN_ABIER_CAT = cuentaA;

		int valorViv = 0;
		if (gol.getValorVivienda() != null
				&& gol.getValorVivienda().length() > 0)
			valorViv = Integer.parseInt(gol.getValorVivienda());
		int VALOR_VIVIENDA = valorViv;

		int suma = 0;
		suma = suma
				+ Integer.parseInt((gol.getTotalTarjetas() == null) ? "0" : gol
						.getTotalTarjetas());
		if ("1".equals(gol.getCuentaCheque()))
			suma++;
		if ("1".equals(gol.getCreditoPersonal()))
			suma++;
		if ("1".equals(gol.getCreditoAuto()))
			suma++;
		if ("1".equals(gol.getCreditoHipo()))
			suma++;
		if ("1".equals(gol.getOtroCredito()))
			suma++;
		int NO_CREDITOS = 0;

		if (suma == 0)
			NO_CREDITOS = 0;
		else if (suma == 1)
			NO_CREDITOS = 1;
		else if (suma == 2)
			NO_CREDITOS = 2;
		else if (suma == 3)
			NO_CREDITOS = 3;
		else if (suma == 4)
			NO_CREDITOS = 4;
		else if (suma == 5)
			NO_CREDITOS = 5;
		else if (suma > 6)
			NO_CREDITOS = 6;

		int INGRESO_TOTAL = Integer.parseInt(gol.getIngresoMensual());
		int GASTOS = Integer.parseInt(gol.getGastoPlaneado());
		int CUBRIR_ALIMETOS = Integer.parseInt(gol.getGastosAlimentos());
		int VESTIDO = Integer.parseInt(gol.getVestido());
		int SERVICIOS_VIVIENDA = Integer.parseInt(gol.getServiciosV());
		int RENTA = Integer.parseInt(gol.getRenta());

		int PRINCIPAL_PROBLEMA = Integer.parseInt(gol.getProblemaHoy());
		int SOLICITAR_PRESTAMO = Integer.parseInt(gol.getSolicitudCredito());
		double VCS_VIV = Double.valueOf(gol.getValorVivienda())/ Double.valueOf(gol.getIngresoMensual());

		int I_RENTA = 0;
		if ("1".equals(gol.getPagaRenta()))
			I_RENTA = Integer.parseInt(gol.getPagaRCuanto());

		int SITUACION_PROX_ANO = Integer.parseInt(gol.getSituacionPAnio());

		int TARJETA_CREDITO = Integer.parseInt(gol.getTarjetaC());
		int CUENTA_CHEQUES = Integer.parseInt(gol.getCuentaCheque());
		int CREDITO_PERSONAL = Integer.parseInt(gol.getCreditoPersonal());
		int CREDITO_AUTO = Integer.parseInt(gol.getCreditoAuto());
		int CREDITO_HIPO = Integer.parseInt(gol.getCreditoHipo());

		int otroCred = 0;
		if (gol.getOtroCredito() != null)
			otroCred = Integer.parseInt(gol.getOtroCredito());
		int CREDITO_OTROS = otroCred;

		int REG_BURO = gol.getBuroCredito();

		double SCORE_CREDITOS = TARJETA_CREDITO + CUENTA_CHEQUES
				+ CREDITO_PERSONAL + CREDITO_AUTO + CREDITO_HIPO
				+ CREDITO_OTROS;
		double VECES_VIVIENDA = VALOR_VIVIENDA / INGRESO_TOTAL;

		PsicoSocial(s, AGRESION_1, AGRESION_4, ADHESION_GRUPO3,
				RESENTIMIENTO_SOCIAL3, CONDUCTA_DELICTIVA2,
				RESENTIMIENTO_SOCIAL4, RESPONSABILIDAD4, CONDUCTA_DELICTIVA5);

		String resultado = "";

		if (REG_BURO == 1) { // SI ES UNO ES HIT



			double SCORE_HIT_FACTOR = EsHit(chit,s, GENERO, FRECUENCIA_RELIGION,
					SITUACION_PROX_ANO, DINERO_EXTRA, VIVIENDA_ACTUAL,
					SERVICIO_HOGAR, ACT, USO, CUEN_ABIER_CAT, VALOR_VIVIENDA,
					NO_CREDITOS, I_PSICO , estado);
			if (SCORE_HIT_FACTOR >= 800){

				resultado = "CLIENTE ALTERNATIVA URBI";}
			else {
				double SCORE_NO_HIT = EsNoHit(cnohit,s, RELIGION, ESCOLARIDAD,
						TRABAJO_ANTERIOR, DINERO_EXTRA, INGRESO_TOTAL, GASTOS,
						CUBRIR_ALIMETOS, VESTIDO, PRINCIPAL_PROBLEMA,
						SOLICITAR_PRESTAMO, VCS_VIV, I_RENTA,
						SERVICIOS_VIVIENDA, RENTA, SERVICIO_HOGAR,
						VALOR_VIVIENDA, NO_CREDITOS, I_PSICO,estado);
				if (SCORE_NO_HIT >= 800) {// SCORE BURO META

                                   
                                    double SCORE_BURO = CalculoBuroMeta(cburo,s, ACT, HIST, ANT, USO,
							PAGO,estado);
					if (SCORE_BURO >= 800)
						resultado = "CLIENTE DECLINADO PARA REPARADORA DE BURO";
					else
						resultado = "CLIENTE DECLINADO POR BARRERA DE BURO";
				}
                                else
					resultado = "CLIENTE GOL";
			}
		}
                else { // NO HIT
			double SCORE_NO_HIT = EsNoHit(cnohit,s, RELIGION, ESCOLARIDAD,
					TRABAJO_ANTERIOR, DINERO_EXTRA, INGRESO_TOTAL, GASTOS,
					CUBRIR_ALIMETOS, VESTIDO, PRINCIPAL_PROBLEMA,
					SOLICITAR_PRESTAMO, VCS_VIV, I_RENTA, SERVICIOS_VIVIENDA,
					RENTA, SERVICIO_HOGAR, VALOR_VIVIENDA, NO_CREDITOS, I_PSICO,estado);
			if (SCORE_NO_HIT >= 800)
				resultado = "CLIENTE ALTERNATIVO URBI";
			else
				resultado = "CLIENTE GOL";
  
		}

		obtenerDescripcion();
		obtenerDescripcion_NH();
		obtenerArraigo();

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(0);

		if (SCORE_GENERO < 0) {
			if (SCORE_GENERO < -150.0)
				SCORE_GENERO = 150.0;
		} else {
			if (SCORE_GENERO > 150.0)
				SCORE_GENERO = 150.0;
		}

		if (SCORE_COMPORTAMIENTO < 0) {
			if (SCORE_COMPORTAMIENTO < -150.0)
				SCORE_COMPORTAMIENTO = 150.0;
		} else {
			if (SCORE_COMPORTAMIENTO > 150.0)
				SCORE_COMPORTAMIENTO = 150.0;
		}

		if (SCORE_ARRAIGO < 0) {
			if (SCORE_ARRAIGO < -150.0)
				SCORE_ARRAIGO = 150.0;
		} else {
			if (SCORE_ARRAIGO > 150.0)
				SCORE_ARRAIGO = 150.0;
		}

		if (SCORE_ASPECTOS < 0) {
			if (SCORE_ASPECTOS < -150.0)
				SCORE_ASPECTOS = 150.0;
		} else {
			if (SCORE_ASPECTOS > 150.0)
				SCORE_ASPECTOS = 150.0;
		}

                valoresCalc.add(this.estado);

		valoresCalc.add("-1");
		valoresCalc.add("-1");
		valoresCalc.add(nf.format(SCORE_GENERO));// GENERO
		valoresCalc.add(nf.format(SCORE_COMPORTAMIENTO));// COMPORTAMIENTO_PAGO
		valoresCalc.add(nf.format(SCORE_ARRAIGO));// ARRAIGO
		valoresCalc.add(nf.format(SCORE_ASPECTOS));// ASPECTOS_DIF

		if (REG_BURO == 1) {// SI ES UNO ES HIT
			valoresCalc.add(((GENERO_DES == null) ? "" : GENERO_DES));// GENERO_CLASE_TEXTO_1
			valoresCalc.add(((FRECUENCIA_RELIGION_DES == null) ? ""
					: FRECUENCIA_RELIGION_DES));// GENERO_CLASE_TEXTO_2

			valoresCalc.add(((PRIMER_TEXTO_COMPORTAMIENTO == null) ? ""
					: PRIMER_TEXTO_COMPORTAMIENTO));// COMPORTAMIENTO_DE_PAGO_TEXTO_1

			valoresCalc.add(((SEGUNDO_TEXTO_COMPORTAMIENTO == null) ? ""
					: SEGUNDO_TEXTO_COMPORTAMIENTO));// COMPORTAMIENTO_DE_PAGO_TEXTO_2

			valoresCalc.add(((VIVIENDA_ACTUAL_DES == null) ? ""
					: VIVIENDA_ACTUAL_DES));// ARRAIGO_TEXTO_1

			valoresCalc.add(((SITUACION_PROXIMO_ANO_DES == null) ? ""
					: SITUACION_PROXIMO_ANO_DES));// ARRAIGO_TEXTO_2

			valoresCalc.add(((I_PSICO_DES == null) ? "" : I_PSICO_DES));// ASPECTOS_TEXTO_1

			valoresCalc.add("");// ASPECTOS_TEXTO_2

		} else {// NO HIT
			valoresCalc.add(((GENERO_DES == null) ? "" : GENERO_DES));// GENERO_CLASE_TEXTO_1

			valoresCalc.add(((ESCOLARIDAD_DES == null) ? "" : ESCOLARIDAD_DES));// GENERO_CLASE_TEXTO_2

			valoresCalc.add(((PRIMER_TEXTO_COMPORTAMIENTO == null) ? ""
					: PRIMER_TEXTO_COMPORTAMIENTO));// COMPORTAMIENTO_DE_PAGO_TEXTO_1

			valoresCalc.add(((SEGUNDO_TEXTO_COMPORTAMIENTO == null) ? ""
					: SEGUNDO_TEXTO_COMPORTAMIENTO));// COMPORTAMIENTO_DE_PAGO_TEXTO_2

			valoresCalc.add(((PRIMER_TEXTO_ARRAIGO == null) ? ""
					: PRIMER_TEXTO_ARRAIGO));// ARRAIGO_TEXTO_1

			valoresCalc.add(((SEGUNDO_TEXTO_ARRAIGO == null) ? ""
					: SEGUNDO_TEXTO_ARRAIGO));// ARRAIGO_TEXTO_2

			valoresCalc.add(((I_PSICO_DES == null) ? "" : I_PSICO_DES));// ASPECTOS_TEXTO_1

			valoresCalc.add("");// ASPECTOS_TEXTO_2
		}
		valoresCalc.add(((resultado == null) ? "" : resultado));// RESULTADO
	}

	private double EsHit(List<String> chit,Session s, int GENERO, int FRECUENCIA_RELIGION,
			int SITUACION_PROX_ANO, int DINERO_EXTRA, int VIVIENDA_ACTUAL,
			int SERVICIO_HOGAR, int ACT, int USO, int CUEN_ABIER_CAT,
			int VALOR_VIVIENDA, int NO_CREDITOS, int I_PSICO , String estado) {

		Query q = s
				.createQuery("from Sex as sex where sex.calId = '3' and sex.sexId="
						+ GENERO);
		List lista = (List) q.list();
		GENERO_FACTOR = ((Sex) lista.get(0)).getSexPto();
		GENERO_WOE = ((Sex) lista.get(0)).getSexWoe();
		GENERO_DES = ((Sex) lista.get(0)).getSexDes();

		q = s
				.createQuery("from FreRel as frerel where frerel.cal = '3' and frerel.freRelId="
						+ FRECUENCIA_RELIGION);
		lista = (List) q.list();
		FRECUENCIA_RELIGION_FACTOR = ((FreRel) lista.get(0)).getFreRelPto();
		FRECUENCIA_RELIGION_WOE = ((FreRel) lista.get(0)).getFreRelWoe();
		FRECUENCIA_RELIGION_DES = ((FreRel) lista.get(0)).getFreRelDes();

		q = s
				.createQuery("from SitPrxAn as sex where sex.calId = '3' and sex.sitPrxAnId="
						+ SITUACION_PROX_ANO);
		lista = (List) q.list();
		SITUACION_PROXIMO_ANO_FACTOR = ((SitPrxAn) lista.get(0))
				.getSitPrxAnPto();
		SITUACION_PROXIMO_ANO_WOE = ((SitPrxAn) lista.get(0)).getSitPrxAnWoe();
		SITUACION_PROXIMO_ANO_DES = ((SitPrxAn) lista.get(0)).getSitPrxAnDes();

		if (DINERO_EXTRA == 8)
			DINERO_EXTRA = 1;
		if (DINERO_EXTRA == 9)
			DINERO_EXTRA = 2;
		if (DINERO_EXTRA == 10)
			DINERO_EXTRA = 3;
		if (DINERO_EXTRA == 11)
			DINERO_EXTRA = 4;
		if (DINERO_EXTRA == 12)
			DINERO_EXTRA = 5;
		if (DINERO_EXTRA == 13)
			DINERO_EXTRA = 6;
		if (DINERO_EXTRA == 14)
			DINERO_EXTRA = 7;
		q = s
				.createQuery("from DinExt as dinext where dinext.cal= '3' and dinext.dinExtId="
						+ DINERO_EXTRA);
		lista = (List) q.list();
		DINERO_EXTRA_FACTOR = ((DinExt) lista.get(0)).getDinExtPto();
		DINERO_EXTRA_WOE = ((DinExt) lista.get(0)).getDinExtWoe();
		DINERO_EXTRA_DES = ((DinExt) lista.get(0)).getDinExtDes();

		// duda
		// sacar el id de vivienda de la tabla rng_res_ant por medio de los
		// limites o rangos
		q = s
				.createQuery("from RngResAnt as sex where sex.calId = '3' and (sex.rngResAntLimInf<"
						+ VIVIENDA_ACTUAL
						+ " and sex.rngResAntLimSup>="
						+ VIVIENDA_ACTUAL + ")");
		lista = (List) q.list();
		VIVIENDA_ACTUAL_FACTOR = ((RngResAnt) lista.get(0)).getRngResAntPto();
		VIVIENDA_ACTUAL_WOE = ((RngResAnt) lista.get(0)).getRngResAntWoe();
		VIVIENDA_ACTUAL_DES = ((RngResAnt) lista.get(0)).getRngResAntDes();

             
                
		q = s
				.createQuery("from Srv as sex where sex.srvId="
						+ (SERVICIO_HOGAR - 11));
		lista = (List) q.list();
		SERVICIO_HOGAR_FACTOR = ((Srv) lista.get(0)).getSrvPto();
		String SERVICIO_HOGAR_DES = ((Srv) lista.get(0)).getSrvDes();
		SERVICIO_HOGAR_WOE = ((Srv) lista.get(0)).getSrvWoe();

		q = s
				.createQuery("from BurAct as ba where ba.cal.calId='3' and ba.burActId="
						+ ACT);
		lista = (List) q.list();
		ACT_FACTOR = ((BurAct) lista.get(0)).getBurActPto();
		ACT_WOE = ((BurAct) lista.get(0)).getBurActWoe();
		ACT_TEXTO = ((BurAct) lista.get(0)).getBurActDes();

		q = s
				.createQuery("from BurUso as bu where bu.cal.calId='3' and bu.burUsoId="
						+ USO);
		lista = (List) q.list();
		USO_FACTOR = ((BurUso) lista.get(0)).getBurUsoPto();
		USO_WOE = ((BurUso) lista.get(0)).getBurUsoWoe();
		String BUR_USO_DES = ((BurUso) lista.get(0)).getBurUsoDes();

		q = s
				.createQuery("from CueAbr as sex where sex.cal.calId = '3' and sex.cueAbrId="
						+ CUEN_ABIER_CAT);
		lista = (List) q.list();
		CUEN_ABIER_CAT_FACTOR = ((CueAbr) lista.get(0)).getCueAbrPto();
		CUEN_ABIER_CAT_WOE = ((CueAbr) lista.get(0)).getCueAbrWoe();
		CUEN_ABIER_CAT_DES = ((CueAbr) lista.get(0)).getCueAbrDes();


                double valorViv = VALOR_VIVIENDA;

		if (VALOR_VIVIENDA < 310000)
			VALOR_VIVIENDA = 1;
		else
			VALOR_VIVIENDA = 2;
		q = s
				.createQuery("from VlrViv as sex where sex.calId = '3' and sex.vlrVivId="
						+ VALOR_VIVIENDA);
		lista = (List) q.list();
		VALOR_VIVIENDA_FACTOR = ((VlrViv) lista.get(0)).getVlrVivPto();
		VALOR_VIVIENDA_WOE = ((VlrViv) lista.get(0)).getVlrVivWoe();
		String VALOR_VIVIENDA_DESC = ((VlrViv) lista.get(0)).getVlrVivDes();

	q = s.createQuery("from NumCre as sex where sex.cal.calId = '3'");
		lista = (List) q.list();
		NO_CREDITOS_FACTOR = ((NumCre) lista.get(NO_CREDITOS)).getNumCrePto();
		NO_CREDITOS_WOE = ((NumCre) lista.get(NO_CREDITOS)).getNumCreWoe();
		NO_CREDITOS_DES = ((NumCre) lista.get(NO_CREDITOS)).getNumCreDes();

		q = s
				.createQuery("from IPsi as ips where ips.cal = '3' and ips.IPsiLimInf<="
						+ SCORE_IPSICO_FACTOR
						+ " and ips.IPsiLimSup>="
						+ SCORE_IPSICO_FACTOR);
		lista = (List) q.list();
		I_PSICO_FACTOR = ((IPsi) lista.get(0)).getIPsiPto();
		I_PSICO_WOE = ((IPsi) lista.get(0)).getIPsiWoe();
		I_PSICO_DES = ((IPsi) lista.get(0)).getIPsiDesLar();

		double SCORE_HIT_FACTOR = GENERO_FACTOR + FRECUENCIA_RELIGION_FACTOR
				+ SITUACION_PROXIMO_ANO_FACTOR + DINERO_EXTRA_FACTOR
				+ VIVIENDA_ACTUAL_FACTOR + SERVICIO_HOGAR_FACTOR + ACT_FACTOR
				+ USO_FACTOR + CUEN_ABIER_CAT_FACTOR + VALOR_VIVIENDA_FACTOR
				+ NO_CREDITOS_FACTOR +I_PSICO_FACTOR;



String chorizote = gol.getApellidoPaterno() + " " + gol.getApellidoMaterno() + " " + gol.getNombre() + ","+

                                 GENERO_DES+","+ GENERO_FACTOR +","+ FRECUENCIA_RELIGION_DES    +","+FRECUENCIA_RELIGION_FACTOR+
				 ","+SITUACION_PROXIMO_ANO_DES+","+SITUACION_PROXIMO_ANO_FACTOR +
                                 ","+DINERO_EXTRA_DES+","+DINERO_EXTRA_FACTOR+
                                 ","+VIVIENDA_ACTUAL +","+ VIVIENDA_ACTUAL_FACTOR +
                                 ","+SERVICIO_HOGAR_DES+","+SERVICIO_HOGAR_FACTOR +
                                 ","+ ACT_TEXTO+","+ACT_FACTOR+
				 ","+BUR_USO_DES+","+USO_FACTOR +
                                 ","+ CUEN_ABIER_CAT_DES+","+CUEN_ABIER_CAT_FACTOR+
                                 "," +valorViv+","+VALOR_VIVIENDA_FACTOR
				+ ","+NO_CREDITOS_DES+","+NO_CREDITOS_FACTOR +
                                 ","+SCORE_IPSICO_FACTOR+","+I_PSICO_FACTOR + "," + SCORE_HIT_FACTOR+","+estado;


                              

              //System.out.println(chorizote);






		SCORE_GENERO = GENERO_WOE + FRECUENCIA_RELIGION_WOE;

		SCORE_COMPORTAMIENTO = DINERO_EXTRA_WOE + SERVICIO_HOGAR_WOE + ACT_WOE
				+ USO_WOE + CUEN_ABIER_CAT_WOE + VALOR_VIVIENDA_WOE
				+ NO_CREDITOS_WOE;

		SCORE_ARRAIGO = VIVIENDA_ACTUAL_WOE + SITUACION_PROXIMO_ANO_WOE;
		SCORE_ASPECTOS = I_PSICO_WOE;


                chit.add(chorizote);

		return SCORE_HIT_FACTOR;
	}

	private double EsNoHit(List<String> cnohit,Session s, int RELIGION, int ESCOLARIDAD,
			int TRABAJO_ANTERIOR, int DINERO_EXTRA, int INGRESO_TOTAL,
			int GASTOS, int CUBRIR_ALIMETOS, int VESTIDO,
			int PRINCIPAL_PROBLEMA, int SOLICITAR_PRESTAMO, double VCS_VIV,
			int I_RENTA, int SERVICIOS_VIVIENDA, int RENTA, int SERVICIO_HOGAR,
			int VALOR_VIVIENDA, int NO_CREDITOS, int I_PSICO,String estado) {

		Query q = s
				.createQuery("from RelFam as sex where sex.calId = '5' and sex.relFamId="
						+ RELIGION);
		List lista = (List) q.list();
		RELIGION_FACTOR = ((RelFam) lista.get(0)).getRelFamPto();
		String RELIGION_DESC = ((RelFam) lista.get(0)).getRelFamDes();
		RELIGION_WOE = ((RelFam) lista.get(0)).getRelFamWoe();

		q = s
				.createQuery("from NivEst as sex where sex.cal = '5' and sex.nivEstId="
						+ ESCOLARIDAD);
		lista = (List) q.list();
		ESCOLARIDAD_FACTOR = ((NivEst) lista.get(0)).getNivEstPto();
		ESCOLARIDAD_WOE = ((NivEst) lista.get(0)).getNivEstWoe();
		ESCOLARIDAD_DES = ((NivEst) lista.get(0)).getNivEstDes();

		q = s
				.createQuery("from ActUlt as sex where sex.cal = '5' and sex.actUltId="
						+ TRABAJO_ANTERIOR);
		lista = (List) q.list();
		TRABAJO_ANTERIOR_FACTOR = ((ActUlt) lista.get(0)).getActUltPto();
		TRABAJO_ANTERIOR_WOE = ((ActUlt) lista.get(0)).getActUltWoe();
		TRABAJO_ANTERIOR_DES = ((ActUlt) lista.get(0)).getActUltDes();

		q = s
				.createQuery("from DinExt as dinext where dinext.cal= '5' and dinext.dinExtId="
						+ DINERO_EXTRA);
		lista = (List) q.list();
		DINERO_EXTRA_FACTOR = ((DinExt) lista.get(0)).getDinExtPto();
		DINERO_EXTRA_WOE = ((DinExt) lista.get(0)).getDinExtWoe();
		DINERO_EXTRA_DES = ((DinExt) lista.get(0)).getDinExtDes();

		// duda
		q = s
				.createQuery("from Ing as sex where sex.cal = '5' and (sex.ingLimInf<"
						+ INGRESO_TOTAL
						+ " and sex.ingLimSup>"
						+ INGRESO_TOTAL
						+ ")");
		lista = (List) q.list();
		INGRESO_TOTAL_FACTOR = ((Ing) lista.get(0)).getIngPto();
		INGRESO_TOTAL_WOE = ((Ing) lista.get(0)).getIngWoe();
		INGRESO_TOTAL_DES = ((Ing) lista.get(0)).getIngDes();

		q = s
				.createQuery("from GtoImp as sex where sex.cal = '5' and sex.gtoImpId="
						+ GASTOS);
		lista = (List) q.list();
		GASTOS_FACTOR = ((GtoImp) lista.get(0)).getGtoImpPto();
		String GASTOS_DESC = ((GtoImp) lista.get(0)).getGtoImpDes();
		GASTOS_WOE = ((GtoImp) lista.get(0)).getGtoImpWoe();

		q = s
				.createQuery("from GtoAlm as sex where sex.cal = '5' and sex.gtoAlmId="
						+ CUBRIR_ALIMETOS);
		lista = (List) q.list();
		CUBRIR_ALIMETOS_FACTOR = ((GtoAlm) lista.get(0)).getGtoAlmPto();
		String CUBRIR_ALIMETOS_DESC = ((GtoAlm) lista.get(0)).getGtoAlmDes();
		CUBRIR_ALIMETOS_WOE = ((GtoAlm) lista.get(0)).getGtoAlmWoe();

		q = s
				.createQuery("from GtoVes as sex where sex.cal = '5' and sex.gtoVesId="
						+ VESTIDO);
		lista = (List) q.list();
		VESTIDO_FACTOR = ((GtoVes) lista.get(0)).getGtoVesPto();
		VESTIDO_WOE = ((GtoVes) lista.get(0)).getGtoVesWoe();
		VESTIDO_DES = ((GtoVes) lista.get(0)).getGtoVesDes();

		q = s
				.createQuery("from Pbm as sex where sex.calId = '5' and sex.pbmId="
						+ PRINCIPAL_PROBLEMA);
		lista = (List) q.list();
		PRINCIPAL_PROBLEMA_FACTOR = ((Pbm) lista.get(0)).getPbmPto();
		String PRINCIPAL_PROBLEMA_DESC = ((Pbm) lista.get(0)).getPbmDes();
		PRINCIPAL_PROBLEMA_WOE = ((Pbm) lista.get(0)).getPbmWoe();
		q = s
				.createQuery("from Ptm as sex where sex.calId = '5' and sex.ptmId="
						+ SOLICITAR_PRESTAMO);
		lista = (List) q.list();
		SOLICITAR_PRESTAMO_FACTOR = ((Ptm) lista.get(0)).getPtmPto();
		String SOLICITAR_PRESTAMO_DESC = ((Ptm) lista.get(0)).getPtmDes();
		SOLICITAR_PRESTAMO_WOE = ((Ptm) lista.get(0)).getPtmWoe();

		// duda
		q = s
				.createQuery("from VcsViv as sex where sex.calId = '5' and (sex.vcsVivLimInf<"
						+ VCS_VIV + " and sex.vcsVivLimSup>" + VCS_VIV + ")");
		lista = (List) q.list();
		VCS_VIV_FACTOR = ((VcsViv) lista.get(0)).getVcsVivPto();
		VCS_VIV_WOE = ((VcsViv) lista.get(0)).getVcsVivWoe();

		// duda
		if ("2".equals(gol.getPagaRenta()))
			I_RENTA = 3;
		else if ("1".equals(gol.getPagaRenta())) {
			int renta = Integer.parseInt(gol.getPagaRCuanto());
			int mensualidad = Integer.parseInt(gol.getMensualidad());
			if (renta > mensualidad)
				I_RENTA = 1;
			else
				I_RENTA = 2;
		}

		q = s
				.createQuery("from IRnt as sex where sex.calId = '5' and sex.IRntId="
						+ I_RENTA);
		lista = (List) q.list();
		I_RENTA_FACTOR = ((IRnt) lista.get(0)).getIRntPto();
		I_RENTA_WOE = ((IRnt) lista.get(0)).getIRntWoe();
		I_RENTA_DES = ((IRnt) lista.get(0)).getIRntDes();

		q = s
				.createQuery("from GtoSerViv as sex where sex.cal.calId = '5' and sex.gtoSerVivId="
						+ SERVICIOS_VIVIENDA);
		lista = (List) q.list();
		SERVICIOS_VIVIENDA_FACTOR = ((GtoSerViv) lista.get(0))
				.getGtoSerVivPto();
		SERVICIOS_VIVIENDA_WOE = ((GtoSerViv) lista.get(0)).getGtoSerVivWoe();
		SERVICIOS_VIVIENDA_DES = ((GtoSerViv) lista.get(0))
				.getGtoSerVivDes();

                 //R.G.g -> cambio de la obtencion de la renta
                double mensualidad = Double.valueOf(gol.getMensualidad()) ;
                double ingreso = Double.valueOf(gol.getIngresoMensual()) ;

                double renta = mensualidad/ingreso;

		q = s
				.createQuery("from GtoRen as sex where sex.cal.calId = '5' and (" +
                                "sex.gtoRenLimInf < " + renta + " and " +
                                "sex.gtoRenLimSup >= " + renta + ")");
		/*q = s
				.createQuery("from GtoRen as sex where sex.cal.calId = '5' and sex.gtoRenId="
						+ RENTA);*/
                // -> Termina cambio

                System.out.println("ingreso "+ingreso);
                System.out.println("mensualidad "+mensualidad);
                System.out.println("renta "+ renta);

		lista = (List) q.list();

		RENTA_FACTOR = ((GtoRen) lista.get(0)).getGtoRenPto();
		RENTA_WOE = ((GtoRen) lista.get(0)).getGtoRenWoe();
		RENTA_DES = ((GtoRen) lista.get(0)).getGtoRenDes();

               // System.out.println("punto renta : " + RENTA_FACTOR +" de " + gol.getApellidoPaterno() + " " + gol.getApellidoMaterno() + " " + gol.getNombre());

		q = s
				.createQuery("from Srv as sex where sex.calId = '5' and sex.srvId="
						+ SERVICIO_HOGAR);
		lista = (List) q.list();
		SERVICIO_HOGAR_FACTOR = ((Srv) lista.get(0)).getSrvPto();
		SERVICIO_HOGAR_WOE = ((Srv) lista.get(0)).getSrvWoe();
		SERVICIO_HOGAR_DES = ((Srv) lista.get(0)).getSrvDes();

                double vivienda = VALOR_VIVIENDA;

		if (VALOR_VIVIENDA < 310000)
			VALOR_VIVIENDA = 3;
		else
			VALOR_VIVIENDA = 4;

		q = s
				.createQuery("from VlrViv as sex where sex.calId = '5' and sex.vlrVivId="
						+ VALOR_VIVIENDA);
		lista = (List) q.list();
		VALOR_VIVIENDA_FACTOR = ((VlrViv) lista.get(0)).getVlrVivPto();
		VALOR_VIVIENDA_WOE = ((VlrViv) lista.get(0)).getVlrVivWoe();
		VALOR_VIVIENDA_DES = ((VlrViv) lista.get(0)).getVlrVivDes();

		q = s.createQuery("from NumCre as sex where sex.cal.calId = '5'");
		lista = (List) q.list();
		NO_CREDITOS_FACTOR = ((NumCre) lista.get(NO_CREDITOS)).getNumCrePto();
		NO_CREDITOS_WOE = ((NumCre) lista.get(NO_CREDITOS)).getNumCreWoe();
		NO_CREDITOS_DES = ((NumCre) lista.get(NO_CREDITOS)).getNumCreDes();

		q = s
				.createQuery("from IPsi as ips where ips.cal = '5' and ips.IPsiLimInf<="
						+ SCORE_IPSICO_FACTOR
						+ " and ips.IPsiLimSup>="
						+ SCORE_IPSICO_FACTOR);
		lista = (List) q.list();
		I_PSICO_FACTOR = ((IPsi) lista.get(0)).getIPsiPto();
		I_PSICO_WOE = ((IPsi) lista.get(0)).getIPsiWoe();

		double SCORE_NO_HIT = RELIGION_FACTOR + ESCOLARIDAD_FACTOR
				+ TRABAJO_ANTERIOR_FACTOR + DINERO_EXTRA_FACTOR
				+ INGRESO_TOTAL_FACTOR + GASTOS_FACTOR + CUBRIR_ALIMETOS_FACTOR
				+ VESTIDO_FACTOR + SERVICIOS_VIVIENDA_FACTOR + RENTA_FACTOR
				+ SERVICIO_HOGAR_FACTOR + PRINCIPAL_PROBLEMA_FACTOR
				+ SOLICITAR_PRESTAMO_FACTOR + VCS_VIV_FACTOR + I_RENTA_FACTOR
				+ VALOR_VIVIENDA_FACTOR + NO_CREDITOS_FACTOR + I_PSICO_FACTOR;



              String calc = gol.getApellidoPaterno() + " " + gol.getApellidoMaterno() + " " + gol.getNombre() +




                        ","+ RELIGION_DESC+","+RELIGION_FACTOR +", " +ESCOLARIDAD_DES+","+ESCOLARIDAD_FACTOR+
			 ","+TRABAJO_ANTERIOR_DES+", "+TRABAJO_ANTERIOR_FACTOR +", " +DINERO_EXTRA_DES+","+ DINERO_EXTRA_FACTOR +
		         ","+INGRESO_TOTAL+","+INGRESO_TOTAL_FACTOR + ","+GASTOS_DESC+","+GASTOS_FACTOR +
                         ","+CUBRIR_ALIMETOS_DESC+","+CUBRIR_ALIMETOS_FACTOR+", " + VESTIDO_DES + ","+ VESTIDO_FACTOR +
                         ", "+SERVICIOS_VIVIENDA_DES+","+SERVICIOS_VIVIENDA_FACTOR+","+RENTA_DES +", "+RENTA_FACTOR+
                         ", "+ SERVICIO_HOGAR_DES+","+SERVICIO_HOGAR_FACTOR + ","+PRINCIPAL_PROBLEMA_DESC+", "+PRINCIPAL_PROBLEMA_FACTOR+
                         ", "+ 	SOLICITAR_PRESTAMO_DESC+","+ SOLICITAR_PRESTAMO_FACTOR+", " + VCS_VIV_FACTOR +
                         ","+I_RENTA_DES+", "+I_RENTA_FACTOR+", "+vivienda+","+ VALOR_VIVIENDA_FACTOR +
                         ", "+ NO_CREDITOS_DES+","+NO_CREDITOS_FACTOR+", " + SCORE_IPSICO_FACTOR+"," +I_PSICO_FACTOR +","+SCORE_NO_HIT+","+estado;



                        ;
              System.out.println(calc);
                        if(cnohit!=null){
                            cnohit.add(calc);
                        }
              


                     //   System.out.println(calc);




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

	private double CalculoBuroMeta(List<String> cburo,Session s, int ACT, int HIST, int ANT,
			int USO, int PAGO,String estado) {

		if (ACT == 7)
			ACT = 1;
		if (ACT == 8)
			ACT = 2;
		if (ACT == 9)
			ACT = 3;
		if (ACT == 10)
			ACT = 4;
		if (ACT == 11)
			ACT = 5;
		if (ACT == 12)
			ACT = 6;

		if (USO == 12)
			USO = 1;
		if (USO == 13)
			USO = 2;
		if (USO == 14)
			USO = 3;
		if (USO == 15)
			USO = 4;
		if (USO == 16)
			USO = 5;
		if (USO == 17)
			USO = 6;
		if (USO == 18)
			USO = 7;
		if (USO == 19)
			USO = 8;
		if (USO == 20)
			USO = 9;
		if (USO == 21)
			USO = 10;
		if (USO == 22)
			USO = 11;

		Query q = s
				.createQuery("from BurAct as ba where ba.cal='4' and ba.burActId="
						+ ACT);
		List lista = (List) q.list();
		ACT_FACTOR = ((BurAct) lista.get(0)).getBurActPto();
		ACT_WOE = ((BurAct) lista.get(0)).getBurActWoe();
		ACT_TEXTO = ((BurAct) lista.get(0)).getBurActDes();

		q = s.createQuery("from BurHis as bh where bh.cal='4' and bh.burHisId="
				+ HIST);
		lista = (List) q.list();
		HIST_FACTOR = ((BurHis) lista.get(0)).getBurHisPto();
		HIST_WOE = ((BurHis) lista.get(0)).getBurHisWoe();
		HIST_TEXTO = ((BurHis) lista.get(0)).getBurHisDes();

		q = s.createQuery("from BurAnt as ba where ba.cal='4' and ba.burAntId="
				+ ANT);
		lista = (List) q.list();
		ANT_FACTOR = ((BurAnt) lista.get(0)).getBurAntPto();
		ANT_WOE = ((BurAnt) lista.get(0)).getBurAntWoe();
		ANT_TEXTO = ((BurAnt) lista.get(0)).getBurAntDes();

		q = s.createQuery("from BurUso as bu where bu.cal='4' and bu.burUsoId="
				+ USO);
		lista = (List) q.list();
		USO_FACTOR = ((BurUso) lista.get(0)).getBurUsoPto();
		USO_WOE = ((BurUso) lista.get(0)).getBurUsoWoe();
		USO_TEXTO = ((BurUso) lista.get(0)).getBurUsoDes();

		q = s.createQuery("from BurPag as bp where bp.cal='4' and bp.burPagId="
				+ PAGO);
		lista = (List) q.list();
		PAGO_FACTOR = ((BurPag) lista.get(0)).getBurPagPto();
		PAGO_WOE = ((BurPag) lista.get(0)).getBurPagWoe();
		PAGO_TEXTO = ((BurPag) lista.get(0)).getBurPagDes();

		double SCORE_BURO = ACT_FACTOR + HIST_FACTOR + ANT_FACTOR + USO_FACTOR
				+ PAGO_FACTOR;


                String sentencia_buro=gol.getApellidoPaterno() + " " + gol.getApellidoMaterno() + " " + gol.getNombre() + ","+
                        ACT_TEXTO+","+ACT_FACTOR+","+HIST_TEXTO+"," + HIST_FACTOR+
                        ","+ANT_TEXTO+"," + ANT_FACTOR+"," + USO_TEXTO+","+USO_FACTOR+
			","+PAGO_TEXTO+	","+ PAGO_FACTOR+","+SCORE_BURO+","+estado;


                cburo.add(sentencia_buro);

		return SCORE_BURO;
	}

	/**
	 *
	 * @param valor
	 * @return
	 */
	public String getValorPsico(int valor) {
		String cadena = "";
		if (valor == 1)
			cadena = "and (relPsiSocNumRes=1 or relPsiSocNumRes=2)";
		else
			cadena = "and (relPsiSocNumRes=3 or relPsiSocNumRes=4)";
		return cadena;
	}

	private void PsicoSocial(Session s, int AGRESION_1, int AGRESION_4,
			int ADHESION_GRUPO3, int RESENTIMIENTO_SOCIAL3,
			int CONDUCTA_DELICTIVA2, int RESENTIMIENTO_SOCIAL4,
			int RESPONSABILIDAD4, int CONDUCTA_DELICTIVA5) {

		Query q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '1' "
				+ getValorPsico(AGRESION_1));
		List lista = (List) q.list();
		AGRESION_1_FACTOR = ((RelPsiSoc) lista.get(0)).getRelPsiSocPto();
		AGRESION_1_WOE = ((RelPsiSoc) lista.get(0)).getRelPsiSocWoe();

		q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '8' "
				+ getValorPsico(AGRESION_4));
		lista = (List) q.list();
		AGRESION_4_FACTOR = ((RelPsiSoc) lista.get(0)).getRelPsiSocPto();
		AGRESION_4_WOE = ((RelPsiSoc) lista.get(0)).getRelPsiSocWoe();

		q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '10' "
				+ getValorPsico(ADHESION_GRUPO3));
		lista = (List) q.list();
		ADHESION_GRUPO3_FACTOR = ((RelPsiSoc) lista.get(0)).getRelPsiSocPto();
		ADHESION_GRUPO3_WOE = ((RelPsiSoc) lista.get(0)).getRelPsiSocWoe();

		q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '11' "
				+ getValorPsico(RESENTIMIENTO_SOCIAL3));
		lista = (List) q.list();
		RESENTIMIENTO_SOCIAL3_FACTOR = ((RelPsiSoc) lista.get(0))
				.getRelPsiSocPto();
		RESENTIMIENTO_SOCIAL3_WOE = ((RelPsiSoc) lista.get(0))
				.getRelPsiSocWoe();

		q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '15' "
				+ getValorPsico(CONDUCTA_DELICTIVA2));
		lista = (List) q.list();
		CONDUCTA_DELICTIVA2_FACTOR = ((RelPsiSoc) lista.get(0))
				.getRelPsiSocPto();
		CONDUCTA_DELICTIVA2_WOE = ((RelPsiSoc) lista.get(0)).getRelPsiSocWoe();

		q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '17' "
				+ getValorPsico(RESENTIMIENTO_SOCIAL4));
		lista = (List) q.list();
		RESENTIMIENTO_SOCIAL4_FACTOR = ((RelPsiSoc) lista.get(0))
				.getRelPsiSocPto();
		RESENTIMIENTO_SOCIAL4_WOE = ((RelPsiSoc) lista.get(0))
				.getRelPsiSocWoe();

		q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '18' "
				+ getValorPsico(RESPONSABILIDAD4));
		lista = (List) q.list();
		RESPONSABILIDAD4_FACTOR = ((RelPsiSoc) lista.get(0)).getRelPsiSocPto();
		RESPONSABILIDAD4_WOE = ((RelPsiSoc) lista.get(0)).getRelPsiSocWoe();

		q = s.createQuery("from RelPsiSoc as rps where rps.catPsi = '25'"
				+ getValorPsico(CONDUCTA_DELICTIVA5));
		lista = (List) q.list();
		CONDUCTA_DELICTIVA5_FACTOR = ((RelPsiSoc) lista.get(0))
				.getRelPsiSocPto();
		CONDUCTA_DELICTIVA5_WOE = ((RelPsiSoc) lista.get(0)).getRelPsiSocWoe();

		// IPSICO
		SCORE_IPSICO_FACTOR = AGRESION_1_FACTOR + AGRESION_4_FACTOR
				+ ADHESION_GRUPO3_FACTOR + RESENTIMIENTO_SOCIAL3_FACTOR
				+ CONDUCTA_DELICTIVA2_FACTOR + RESENTIMIENTO_SOCIAL4_FACTOR
				+ RESPONSABILIDAD4_FACTOR + CONDUCTA_DELICTIVA5_FACTOR;
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

	public List<String> getValoresCalc() {
		return valoresCalc;
	}


        public static GolBean getCargaPrima(PrimaBean prima, GolBean gol) {
		gol.setApellidoPaterno(prima.getApellidoPaterno());
		gol.setApellidoMaterno(prima.getApellidoMaterno());
		gol.setNombre(prima.getNombre());
                System.out.println(prima.getEdad());
		gol.setEdad(Integer.parseInt(prima.getEdad()));
		gol.setAnio(prima.getAnio());
		gol.setMes(prima.getMes());
		gol.setDia(prima.getDia());
		gol.setCalle(prima.getCalle());
		gol.setNoExterior(prima.getNoExterior());
		gol.setNoInterior(prima.getNoInterior());
		gol.setColonia(prima.getColonia());
		gol.setCp(prima.getCp());
		gol.setEdo("");
		gol.setMun("");
		gol.setEdoCivil(prima.getEdoCivil());
		gol.setTipoActividad(prima.getTipoActividad());
		gol.setSector(prima.getSector());
		gol.setSubsector(prima.getSubSector());
		gol.setRol(prima.getRol());
		gol.setDescripcionOcupacion(prima.getDescripcionOcupacion());
		gol.setValorVivienda(prima.getValorVivienda());
		gol.setMensualidad(prima.getMensualidad());
		// gol.setPersonasDep(prima.getDependientes());
		return gol;
	}




      


        public List[] calculaTodos(){
           
                List[] array=new List[3];

            try {
                ArrayList<Point> cliGols = ConexionCliGols.getClis();
                List<String> chit=new ArrayList<String>();
              List<String> cnohit=new ArrayList<String>();
                List<String> cburo=new ArrayList<String>();
                int cuenta = 0;
                
               
                for (int t=cliGols.size()-100;t<cliGols.size();t++){


                    System.out.println("cligol:" + cliGols.get(t).x);
                    System.out.println("cli:" + cliGols.get(t).y);
                    if(cliGols.get(t).y!=316 ){
                        
                        if(cliGols.get(t).y!=265){
                            if(cliGols.get(t).y!=315){

                                System.out.println("el id de cli " + cliGols.get(t).y);
                                calcula(String.valueOf(cliGols.get(t).x), String.valueOf(cliGols.get(t).y),chit,cnohit,cburo);
                            }

                            
                        }
                       

                    }
                   
                }

                     array[0]=chit;
                     array[1]=cnohit;
                     array[2]=cburo;
               

                     System.out.println("codigos postales faltantes");

                        for(String s:faltantes){
                            System.out.println(s);
                        }

                
            }
            catch (Exception ex) {
                Logger.getLogger(Reportador.class.getName()).log(Level.SEVERE, null, ex);
            }


            return array;
        }

      public void calcula(String cliGolId, String cliId,List<String> chit , List<String> cnohit ,List<String> cburo){

          System.out.println("IDGOL="+cliGolId);


          String idG = cliGolId;
          String idP = cliId;

            // llena el bean de gol
            GolBean gol = GolSql.getVer(idG);
            // llenba el bean de prima
            PrimaBean p = PrimaSql.getVer(idP, 1);
            // carga os detos del objeto prima all onjeto gol
System.out.println("nombre " + gol.getNombre());


            gol = getCargaPrima(p, gol);
            gol.setPrima(p);
            if (gol.getBuroCredito() == 1)
                    GolSql.getBuro(gol, Integer.parseInt(p.getIdPrima()));
            NuevoReportador ws = new NuevoReportador(gol);
            ws.golWs(chit , cnohit , cburo);

            
      }

        public static void main(String[] args) throws Exception {


            NuevoReportador r = new NuevoReportador();


            r.calculaTodos();
            /*

            // llena el bean de gol
            GolBean gol = GolSql.getVer(idG);
            // llenba el bean de prima
            PrimaBean p = PrimaSql.getVer(idP, 1);
            // carga os detos del objeto prima all onjeto gol
            gol = getCargaPrima(p, gol);
            gol.setPrima(p);
            if (gol.getBuroCredito() == 1)
                    GolSql.getBuro(gol, Integer.parseInt(p.getIdPrima()));
            Reportador ws = new Reportador(gol);
            ws.golWs();
            List<String> valoresCalculo = ws.getValoresCalc();
            valoresCalculo.add(p.getNombre() + " " + p.getApellidoPaterno()
                            + " " + p.getApellidoMaterno());

            */
        }

    private void GenerarDocumentos(List<String> chit , List<String> cnohit ,List<String> cburo  ) {

        Date date=new Date();

        try{
            BufferedWriter eschit=new BufferedWriter(new FileWriter("hit.csv"));
            BufferedWriter escno=new BufferedWriter(new FileWriter("nohit.csv"));
            BufferedWriter escbur=new BufferedWriter(new FileWriter("buro.csv"));


            for(String s:chit){
                eschit.write(s);
                eschit.newLine();
            }

            for(String s:cnohit){
                escno.write(s);
                escno.newLine();
            }

            for(String s:cburo){
                escbur.write(s);
                escbur.newLine();
            }

            eschit.close();
            escno.close();
            escbur.close();

            System.out.println("he terminado de escribir los archivos");
        }
        catch(IOException io){
            System.out.println("error al escribir");
        }



    }

    private String obtenEstado(String cp) {

        Session s = objetos.HibernateUtil.getSessionFactory()
				.openSession();

        List codPos = s.createQuery("select edo.edoDes from CodPos where codPosId = " + cp).list();
        return !codPos.isEmpty()? String.valueOf(codPos.get(0)):null;
    }

    
}
