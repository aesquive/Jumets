/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.db;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * 
 * @author Rodrigo
 */
public class DateFormatter {
	public final static int FORMATO_DDMMYYYY = 0;

	public final static int FORMATO_YYYYMMDD = 1;

	public final static int FORMATO_DDMMYYYYHHMMSS = 2;

	public final static int FORMATO_HH = 3;

	public final static int FORMATO_MM = 4;

	public final static int FORMATO_YMDHMS = 5;

	public final static int FORMATO_HHMM = 6;

	public final static int FORMATO_YYYY = 7;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private static SimpleDateFormat sdfYyyyMMdd = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static SimpleDateFormat sdfYMDHMS = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss");

	private static SimpleDateFormat sdfHH = new SimpleDateFormat("H");

	private static SimpleDateFormat sdfMM = new SimpleDateFormat("mm");

	private static SimpleDateFormat sdfHHMM = new SimpleDateFormat("H:mm");

	private static SimpleDateFormat sdfDMYHMS = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm:ss");

	private static SimpleDateFormat sdfYYYY = new SimpleDateFormat("yyyy");

	private static DateFormat df = DateFormat.getDateTimeInstance(
			DateFormat.SHORT, DateFormat.MEDIUM);

	public static String getFechaActual() {
		return sdf.format(new Date());
	}

	public static String getFechaHoraActual() {
		return df.format(new Date());
	}

	public static String getFecha(long timeStamp) {
		if (timeStamp <= 0)
			return "";
		return sdf.format(new Date(timeStamp));
	}

	public static String getFechaPasada(long timeStamp) {
		if (timeStamp <= 0)
			return "";
		return sdf.format(new Date(timeStamp));
	}

	public static String getFecha(java.sql.Date fecha) {
		if (fecha == null)
			return "N/A";
		return sdf.format(new Date(fecha.getTime()));
	}

	public static String getFecha(long fecha, int formato) {
		if (formato == FORMATO_YYYYMMDD)
			return sdfYyyyMMdd.format(new Date(fecha));
		else if (formato == FORMATO_DDMMYYYYHHMMSS)
			return sdfDMYHMS.format(new Date(fecha));
		else if (formato == FORMATO_HH)
			return sdfHH.format(new Date(fecha));
		else if (formato == FORMATO_MM)
			return sdfMM.format(new Date(fecha));
		else if (formato == FORMATO_YMDHMS)
			return sdfYMDHMS.format(new Date(fecha));
		else if (formato == FORMATO_HHMM)
			return sdfHHMM.format(new Date(fecha));
		else if (formato == FORMATO_YYYY)
			return sdfYYYY.format(new Date(fecha));
		else
			return sdf.format(new Date(fecha));
	}

	public static String getFecha(java.sql.Date fecha, int formato) {
		if (fecha == null)
			return "N/A";
		return getFecha(fecha.getTime(), formato);
	}

	public static String getFecha(java.sql.Timestamp fecha, int formato) {
		if (fecha == null)
			return "N/A";
		return getFecha(fecha.getTime(), formato);
	}

	public static long getTimeStamp(java.sql.Date fecha) {
		if (fecha == null)
			return -1L;
		return fecha.getTime();
	}

	public static Date getFecha(String fecha) {
		return new Date(getTimeStamp(fecha));
	}

	public static long getTimeStamp(String fecha) {
		if (fecha == null || fecha.trim().length() < 10
				|| fecha.trim().length() > 19)
			return -1L;
		Calendar cal = Calendar.getInstance();
		if (fecha != null && fecha.trim().length() == 10) {
			cal.set(Integer.parseInt(fecha.substring(6, 10)), Integer
					.parseInt(fecha.substring(3, 5)) - 1, Integer
					.parseInt(fecha.substring(0, 2)));
		} else if (fecha != null && fecha.trim().length() == 16) {
			cal.set(Integer.parseInt(fecha.substring(6, 10)), Integer
					.parseInt(fecha.substring(3, 5)) - 1, Integer
					.parseInt(fecha.substring(0, 2)), Integer.parseInt(fecha
					.substring(11, 13)), Integer.parseInt(fecha.substring(14,
					16)));
		} else if (fecha != null && fecha.trim().length() == 19) {
			cal.set(Integer.parseInt(fecha.substring(6, 10)), Integer
					.parseInt(fecha.substring(3, 5)) - 1, Integer
					.parseInt(fecha.substring(0, 2)), Integer.parseInt(fecha
					.substring(11, 13)), Integer.parseInt(fecha.substring(14,
					16)), Integer.parseInt(fecha.substring(17, 19)));
		}
		return cal.getTime().getTime();
	}

	public static java.sql.Timestamp getFechaSQLTimestamp(String fecha) {
		return new java.sql.Timestamp(getTimeStamp(fecha));
	}

	public static java.sql.Timestamp getFechaSQLTimestamp(String fecha,
			int formato) {
		Calendar cal = Calendar.getInstance();
		if (fecha != null && formato == FORMATO_YYYYMMDD) {
			if (fecha != null && fecha.trim().length() == 10) {
				cal.set(Integer.parseInt(fecha.substring(0, 4)), Integer
						.parseInt(fecha.substring(5, 7)) - 1, Integer
						.parseInt(fecha.substring(8, 10)));
			} else {
				cal.set(Integer.parseInt(fecha.substring(0, 4)), Integer
						.parseInt(fecha.substring(5, 7)) - 1, Integer
						.parseInt(fecha.substring(8, 10)), Integer
						.parseInt(fecha.substring(11, 13)), Integer
						.parseInt(fecha.substring(14, 16)));
			}
		} else {
			return getFechaSQLTimestamp(fecha);
		}
		return new java.sql.Timestamp(cal.getTime().getTime());
	}

	public static java.sql.Date getFechaSQL(String fecha) {
		return new java.sql.Date(getTimeStamp(fecha));
	}

	public static java.sql.Date getFechaSQL(String fecha, int formato) {
		Calendar cal = Calendar.getInstance();
		if (fecha != null && formato == FORMATO_DDMMYYYY) {
			if (fecha != null && fecha.trim().length() == 10) {
				cal.set(Integer.parseInt(fecha.substring(6, 10)), Integer
						.parseInt(fecha.substring(3, 5)) - 1, Integer
						.parseInt(fecha.substring(0, 2)));
			} else {
				cal.set(Integer.parseInt(fecha.substring(0, 4)), Integer
						.parseInt(fecha.substring(5, 7)) - 1, Integer
						.parseInt(fecha.substring(8, 10)), Integer
						.parseInt(fecha.substring(11, 13)), Integer
						.parseInt(fecha.substring(14, 16)));
			}
		} else {
			return getFechaSQL(fecha);
		}
		return new java.sql.Date(cal.getTime().getTime());
	}

	public static long getFechaPlazo(String fecha) {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(getFecha(fecha));
		cal2.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
		cal2.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
		cal2.set(Calendar.SECOND, cal.get(Calendar.SECOND));
		return cal2.getTime().getTime();
	}

	public static long getFechaConHoras(String fecha, String hora, String minuto) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getFecha(fecha));
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora));
		cal.set(Calendar.MINUTE, Integer.parseInt(minuto));
		return cal.getTimeInMillis();
	}

	public static long getPlazoAnio(String anio, boolean inicio) {
		Calendar cal = Calendar.getInstance();
		if (inicio) {
			cal.set(Calendar.YEAR, Integer.parseInt(anio));
			cal.set(Calendar.MONTH, Calendar.JANUARY);
			cal.set(Calendar.DAY_OF_MONTH, 1);
		} else {
			cal.set(Calendar.YEAR, Integer.parseInt(anio));
			cal.set(Calendar.MONTH, Calendar.DECEMBER);
			cal.set(Calendar.DAY_OF_MONTH, 31);
		}
		return cal.getTimeInMillis();
	}

	public static Calendar getCalendar(String fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(getTimeStamp(fecha));
		return cal;
	}

	public static String getFechaQuery(String fechaConsulta) {
		// Formato dd/MM/yyyy
		String fechaSQL = null;
		fechaConsulta = fechaConsulta.substring(0, 10);
		StringTokenizer tokens = new StringTokenizer(fechaConsulta, "-");
		int nDatos = tokens.countTokens();
		String[] datos = new String[nDatos];
		int i = 0;
		while (tokens.hasMoreTokens()) {
			String str = tokens.nextToken();
			datos[i] = str;
			i++;
		}
		fechaSQL = datos[0] + "-" + datos[1] + "-" + datos[2];
		return fechaSQL;
	}

	public static long normalizaDiaInicio(long fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(fecha);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime().getTime();
	}

	public static long normalizaDiaFinal(long fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(fecha);
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime().getTime();
	}
}
