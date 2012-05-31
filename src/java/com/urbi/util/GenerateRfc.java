/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbi.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 ' Derechos Reservados (c), 2004 Ing. Salvador Garcia Velazquez
 '
 ' Reglas de uso:
 '
 ' Puedes usar este algoritmo en tu aplicacion personal,
 ' educacional, empresarial o comercial, siempre y cuando
 ' este mensaje de derechos reservados este presente. Su
 ' uso es libre de regalias y su autor es libre de cualquier
 ' fallo debido al codigo o logica.
 '
 ' Por ningun motivo se da permiso de distribuir este codigo.
 ' Este codigo sigue siendo propiedad exclusiva del autor.
 ' Las rutinas afectadas por los derechos reservados son:
 '
 ' GeneraRFC, RFCApellidoCorto, RFCArmalo, RFCUnApellido,
 ' RFCDigitoVerificador, RFCFiltraAcentos, RFCFiltraNombres
 ' RFCHomoclave y RFCQuitaProhibidas
 '
 ' Cualquier rutina se puede emplear independientemente, siempre
 ' y cuando incluya este mensaje. Para cualquier correcion, omision
 ' o modificacion, favor de dirigirse a sal_garcia at bigfoot punto com.


 'Esta rutina genera el RFC. Datos de entrada:

 'strNombre: Tipo String Nombre de pila Dato valido requerido.
 'strPaterno: Tipo String Apellido paterno Por lo menos un
 'strMaterno: Tipo String Apellido materno apellido es requerido.
 'dteFechaNacimiento: Tipo Date

 */
/**
 * 
 * @author daniel.martinez
 */
public class GenerateRfc {

	private String nombreCompleto;
	private java.util.List listRFC = new java.util.ArrayList();
	public final String yyMMdd = "yyMMdd";
	public final String yyyyMMdd = "yyyyMMdd";
	public final String dd_MM_yyyy = "dd/MM/yyyy";
	public final String MM_dd_yyyy = "MM/dd/yyyy";
	public final String dd_MM_yy = "dd/MM/yy";
	private String customFormatDate = "";

	// Enum that contains valid date formats
	public enum DateFormat {
		yyMMdd("yyMMdd"), yyyyMMdd("yyyyMMdd"), dd_MM_yyyy("dd/MM/yyyy"), MM_dd_yyyy(
				"MM/dd/yyyy"), dd_MM_yy("dd/MM/yy");
		private final String format;

		DateFormat(String format) {
			this.format = format;
		}

		public String format() {
			return format;
		}
	}

	private final Map<String, String> cValorHC; // Valores de sustitución para
												// Homo Clave
	private final Map<String, Integer> cValorDV; // Valores de sustitución para
													// Dígito Verificador
	private final String strCharsHc = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZ"; // Caracteres
																			// para
																			// Homo
																			// Clave
	private final String[] palabrasFiltro = { ".", ",", "DE ", "DEL ", "LA ",
			"LOS ", "LAS ", "Y ", "MC ", "MAC ", "VON ", "VAN ", " " }; // Palas
																		// filtro
																		// para
																		// nombres
																		// y
																		// apellidos
	private final String[] filtroNombres = { "JOSE ", "MARIA ", "J ", "MA " }; // Nombres
																				// a
																				// descartar
	private final Map<String, String> charSust; // Mapa con caracteres a
												// sustituir en nombres y
												// apellidos

	public static void main(String args[]) {
		GenerateRfc rfc = new GenerateRfc();

		System.out.println(rfc.generaRFC("Joaquín", "Rodulfo", "Rodríguez",
				"05/05/1979"));
	}

	public GenerateRfc() { // Inicializa mapas
		this.customFormatDate = this.dd_MM_yyyy;
		cValorHC = new HashMap<String, String>();
		cValorDV = new HashMap<String, Integer>();
		cValorHC.put("A", "11");
		cValorHC.put("B", "12");
		cValorHC.put("C", "13");
		cValorHC.put("D", "14");
		cValorHC.put("E", "15");
		cValorHC.put("F", "16");
		cValorHC.put("G", "17");
		cValorHC.put("H", "18");
		cValorHC.put("I", "19");
		cValorHC.put("J", "21");
		cValorHC.put("K", "22");
		cValorHC.put("L", "23");
		cValorHC.put("M", "24");
		cValorHC.put("N", "25");
		cValorHC.put("O", "26");
		cValorHC.put("P", "27");
		cValorHC.put("Q", "28");
		cValorHC.put("R", "29");
		cValorHC.put("S", "32");
		cValorHC.put("T", "33");
		cValorHC.put("U", "34");
		cValorHC.put("V", "35");
		cValorHC.put("W", "36");
		cValorHC.put("X", "37");
		cValorHC.put("Y", "38");
		cValorHC.put("Z", "39");
		cValorHC.put(" ", "0");
		cValorHC.put("-", "0");
		cValorHC.put("Ñ", "10");
		cValorHC.put("Ü", "10");

		cValorDV.put("0", 0);
		cValorDV.put("1", 1);
		cValorDV.put("2", 2);
		cValorDV.put("3", 3);
		cValorDV.put("4", 4);
		cValorDV.put("5", 5);
		cValorDV.put("6", 6);
		cValorDV.put("7", 7);
		cValorDV.put("8", 8);
		cValorDV.put("9", 9);
		cValorDV.put("A", 10);
		cValorDV.put("B", 11);
		cValorDV.put("C", 12);
		cValorDV.put("D", 13);
		cValorDV.put("E", 14);
		cValorDV.put("F", 15);
		cValorDV.put("G", 16);
		cValorDV.put("H", 17);
		cValorDV.put("I", 18);
		cValorDV.put("J", 19);
		cValorDV.put("K", 20);
		cValorDV.put("L", 21);
		cValorDV.put("M", 22);
		cValorDV.put("N", 23);
		cValorDV.put("&", 24);
		cValorDV.put("O", 25);
		cValorDV.put("P", 26);
		cValorDV.put("Q", 27);
		cValorDV.put("R", 28);
		cValorDV.put("S", 29);
		cValorDV.put("T", 30);
		cValorDV.put("U", 31);
		cValorDV.put("V", 32);
		cValorDV.put("W", 33);
		cValorDV.put("X", 34);
		cValorDV.put("Y", 35);
		cValorDV.put("Z", 36);
		cValorDV.put("*", 37);

		charSust = new HashMap<String, String>();
		charSust.put("Á", "A");
		charSust.put("É", "E");
		charSust.put("Í", "I");
		charSust.put("Ó", "O");
		charSust.put("Ú", "U");
		charSust.put("á", "a");
		charSust.put("é", "e");
		charSust.put("í", "i");
		charSust.put("ó", "o");
		charSust.put("ú", "u");
	}

	/* Esta rutina elimina los acentos y convierte el nombre a mayusculas */
	private String RFCFiltraCaracteres(String strTexto) {
		strTexto = strTexto.toUpperCase();

		for (String str : charSust.keySet()) {
			strTexto = strTexto.replace(str, charSust.get(str));
		}

		return strTexto;
	}

	/*
	 * Esta rutina calcula el RFC tomando en cuenta un apelliedo paterno de tres
	 * o menos letras
	 */
	private String RFCApellidoCorto(String strNombre, String strPaterno,
			String strMaterno, String strFecha) {
		String retVal = "";
		retVal = strPaterno.substring(0, 1) + strMaterno.substring(0, 1)
				+ strNombre.substring(0, 2) + strFecha;
		return retVal;
	}

	/*
	 * Esta rutina toma en cuenta casos cuando solo se da un apellido, ya sea el
	 * paterno o materno
	 */
	private String RFCUnApellido(String strNombre, String strPaterno,
			String strMaterno, String strFecha) {
		String strApellido = "";

		if (strPaterno.length() > 0 && strMaterno.length() == 0) {
			strApellido = strPaterno.substring(0, 2);
		} else if (strPaterno.length() == 0 && strMaterno.length() > 0) {
			strApellido = strMaterno.substring(0, 2);
		} else {
			strApellido = strNombre.substring(0, 2);
		}
		String retVal = strApellido + strNombre.substring(0, 2) + strFecha;
		return retVal;
	}

	private String RFCFiltraNombre(String strNombre) {
		// Busca cada palabra en los tres nombres y elimina si se encuentra
		for (String no : palabrasFiltro) {
			strNombre = strNombre.replace(no, "");
		}
		// Has esto solo si el nombre de pila tiene algun espacio
		if (strNombre.startsWith(" ")) {
			for (String no : filtroNombres) {
				strNombre = strNombre.replace(no, "");
			}
		}
		// Por ultimo, elimina doble consonanstes de los nombres cuando estas
		// cocurren en las primeras dos letras del nombre.
		char nombre = (char) (strNombre.charAt(0) + strNombre.charAt(1));
		switch (nombre) {
		case (char) ('C' + 'H'):
			strNombre = strNombre.replace("CH", "C");
			break;
		case (char) ('L' + 'L'):
			strNombre = strNombre.replace("LL", "L");
			break;
		}
		return strNombre;
	}

	private String RFCFiltraApellido(String apellido) {
		// Busca cada palabra en los tres nombres y elimina si se encuentra
		for (String no : palabrasFiltro) {
			apellido = apellido.replace(no, "");
		}

		if (apellido != null && apellido.trim().length() > 1) {
			// Por ultimo, elimina doble consonanstes de los nombres cuando
			// estas cocurren en las primeras dos letras del nombre.
			char ap = (char) (apellido.charAt(0) + apellido.charAt(1));
			switch (ap) {
			case (char) ('C' + 'H'):
				apellido = apellido.replace("CH", "C");
				break;
			case (char) ('L' + 'L'):
				apellido = apellido.replace("LL", "L");
				break;
			}
		}
		return apellido;
	}

	/*
	 * Esta rutina quita cualquiera de las palabras prohibidas, cambiando el
	 * ultimo caracter de dicha palabara a X
	 */
	private String RFCQuitaProhibidas(String strRFC) {
		String strPalabras;
		strPalabras = "BUEI*BUEY*CACA*CACO*CAGA*CAGO*CAKA*CAKO*COGE*COJA*";
		strPalabras = strPalabras + "KOGE*KOJO*KAKA*KULO*MAME*MAMO*MEAR*";
		strPalabras = strPalabras + "MEAS*MEON*MION*COJE*COJI*COJO*CULO*";
		strPalabras = strPalabras + "FETO*GUEY*JOTO*KACA*KACO*KAGA*KAGO*";
		strPalabras = strPalabras + "MOCO*MULA*PEDA*PEDO*PENE*PUTA*PUTO*";
		strPalabras = strPalabras + "QULO*RATA*RUIN*"; // 41 palabras

		// Si alguna de estas se encuentra, cambiala.
		if (strPalabras.indexOf(strRFC.substring(0, 4)) != -1) {
			// Reemplaza el cuarto caracter del RFC para eliminar
			// l apalabra prohibida.
			strRFC = strRFC.substring(0, 3) + "X"
					+ strRFC.substring(4, strRFC.length());
		}
		return strRFC;
	}

	/*
	 * Esta rutina calcula la homoclave, que es de dos caracteres. El proceso
	 * solo toma en cuenta los nombres de la persona.
	 */
	private String RFCHomoclave(String strNombre, String strPaterno,
			String strMaterno) {
		String retVal = "";
		String strNombreComp = "";
		char strChr = 0;
		int i = 0;
		String strCadena = "";
		int intNum1 = 0;
		int intNum2 = 0;
		int intSum = 0;
		int int3 = 0;
		int intQuo = 0;
		int intRem = 0;

		// consigue el nombre de la persona completa, eliminando acentos y en
		// mayúsculas
		strNombreComp = this.RFCFiltraCaracteres(strPaterno + " " + strMaterno
				+ " " + strNombre);
		this.nombreCompleto = strNombreComp + ": ";
		// Inicializa la cadena de caracteres que contiene los caracteres
		// permitidos para la homoclave.
		// Notese la ausencia del numero 0 y la letra o.
		// 'Inicializa la cadena con 0 para desplazar todo a la derecha.
		strCadena = "0";

		for (char chr : strNombreComp.toUpperCase().toCharArray()) {
			strCadena = strCadena + cValorHC.get(String.valueOf(chr));
		}
		/*
		 * 'Borra toda la cadena y realiza una operacion matematica 'en cada uno
		 * de los digitos. ' 'Por cada digitos se toman dos a la vez y se
		 * multiplica 'este numero por el digito de unidades del mismo numero.
		 * 'Ejemplo: ' ' Si la cadena es 01245 ' ' Se comienza con el primer
		 * digito, se toman dos y luego ' se multiplica por la unidad de ese
		 * mismo numero: ' ' Primer digito = 0, los dos: 01 ' Se multiplica "01"
		 * (1) por "1" ' Se acumula. ' ' Segundo digito = 1, los dos: 12 ' Se
		 * multiplica "12" (12) por "2" ' ' Tercer digito = 2, los dos: 24 ' Se
		 * multiplica "24" (24) por "4" ' --etc.
		 */
		for (i = 0; i < strCadena.length() - 1; i++) {
			intNum1 = Integer.parseInt(strCadena.substring(i, i + 2));
			intNum2 = Integer.parseInt(strCadena.substring(i + 1, i + 2));
			intSum = intSum + (intNum1 * intNum2);
		}

		/*
		 * De la suma, solo necesito los ultimos tres digitos. La forma mas
		 * facil de hacer esto en convirtiendo el numero a cadena, luego tomando
		 * los tres digitos de la derecha. strSum = CStr(intSum) strSum =
		 * Right$(strSum, 3)
		 */
		String tempSum = String.valueOf(intSum);
		int3 = Integer.valueOf(
				tempSum.substring(tempSum.length() - 3, tempSum.length()))
				.intValue();
		intQuo = (int3 / 34);
		intRem = int3 % 34;
		/*
		 * La homoclave se consigue usando el cociente y el residuo. Se usa el
		 * cociente y residio para buscar las letras del homoclave dentro de la
		 * tabla de caracteres permitidos.
		 */
		String strQuo = strCharsHc.substring(intQuo, intQuo + 1);
		String strRem = strCharsHc.substring(intRem, intRem + 1);
		retVal = strQuo + strRem;
		// Usando el cociente, se arma una cadena de dos digitos. str2Digitos =
		// Format$(intQuo, "00")
		return retVal;
	}

	/*
	 * Esta rutina calcula el digito verificador. El RFC consta de las
	 * iniciales, los digitos de la fecha de nacimiento y los dos caracteres de
	 * la homoclave.
	 */
	private String RFCDigitoVerificador(String strRFC) {
		String retVal = "";
		int i = 0, intIdx = 0;
		String strDV = "";
		int intSumas = 0;
		int intDV = 0;

		/*
		 * 'Inicializa el contador .intContador = 13 El RFC tiene 12 caracteres:
		 * 4 Letras, 6 digitos y 2 caracteres (homoclave) Barre los 12
		 * caracteres del RFC.
		 */

		// int position=14;
		for (char chr : strRFC.toCharArray()) {
			if (chr == ' ') {
				chr = '*';
			}
			intIdx = cValorDV.get(String.valueOf(chr));
			// intSumas=intSumas+(intIdx*(--position));
			intSumas = intSumas + (intIdx * (13 - strRFC.indexOf(chr)));
		}

		if ((intSumas % 11) == 0) {
			strDV = "0";
		} else {
			intDV = 11 - (intSumas % 11);
		}
		if (intDV > 9) {
			strDV = "A";
		} else {
			strDV = String.valueOf(intDV);
		}
		retVal = strDV;
		return retVal;
	}

	/*
	 * Esta rutina arma el RFC basandose en los tres nombres y la fecha de
	 * nacimiento.
	 */
	private String RFCArmalo(String strNombre, String strPaterno,
			String strMaterno, String strFecha) {
		String retVal = "";
		String strVocales = "";
		String strPrimeroVocal = "";
		int i = 0;

		strVocales = "AEIOU";
		// Primero consigo la primera vocal del nombre comenzando con la segunda
		// letra.
		for (i = 1; i < strPaterno.length(); i++) {
			if (strVocales.indexOf(strPaterno.substring(i, i + 1)) >= 0) {
				strPrimeroVocal = strPaterno.substring(i, i + 1);
				break;
			}
		}
		retVal = strPaterno.substring(0, 1) + strPrimeroVocal
				+ strMaterno.substring(0, 1) + strNombre.substring(0, 1)
				+ strFecha;
		return retVal;
	}

	public String generaRFC(String strNombre, String strPaterno,
			String strMaterno, String dteFechaNacimiento,
			GenerateRfc.DateFormat tipoFecha) {
		customFormatDate = tipoFecha.format();
		return generaRFC(strNombre, strPaterno, strMaterno, dteFechaNacimiento);
	}

	/*
	 * Esta rutina genera el RFC. Datos de entrada: strNombre: Tipo String
	 * Nombre de pila Dato valido requerido. strPaterno: Tipo String Apellido
	 * paterno Por lo menos un strMaterno: Tipo String Apellido materno apellido
	 * es requerido. dteFechaNacimiento: Tipo Date
	 */
	

	/*
	 * Esta rutina genera el RFC. Datos de entrada: strNombre: Tipo String
	 * Nombre de pila Dato valido requerido. strPaterno: Tipo String Apellido
	 * paterno Por lo menos un strMaterno: Tipo String Apellido materno apellido
	 * es requerido. dteFechaNacimiento: Tipo String
	 */
	public String generaRFC(String strNombre, String strPaterno,
			String strMaterno, String dteFechaNacimiento) {
		String retVal = "";
		String strFecha = "";
		String strRFC = "";
		String strNombreOriginal = "";
		String strPaternoOriginal = "";
		String strMaternoOriginal = "";

		strNombre = strNombre == null ? "" : strNombre;
		strPaterno = strPaterno == null ? "" : strPaterno.trim();
		strMaterno = strMaterno == null ? "X"
				: strMaterno.trim().length() == 0 ? "X" : strMaterno.trim();

		// Consigue la fecha.
		strFecha = formatDate(dteFechaNacimiento);// twoDec.format(dteFechaNacimiento);
		// strFecha = DateUtil.getDateAsString(dteFechaNacimiento,
		// DateUtil.Format.ddmmyyyy, "/");

		if (strNombre.length() > 0) {
			// 'Guarda el nombre original para calcular la homoclave.
			strNombreOriginal = strNombre;
			strPaternoOriginal = strPaterno;
			strMaternoOriginal = strMaterno;
			/*
			 * El RFC se calcula a base de letras vocales sin acento, elimina
			 * cualquier acento dentro el nombre.
			 */
			strNombre = RFCFiltraCaracteres(strNombre);
			strPaterno = RFCFiltraCaracteres(strPaterno);
			strMaterno = RFCFiltraCaracteres(strMaterno);
			// Elimina palabras sobrantes dentro de los nombres.
			strNombre = RFCFiltraNombre(strNombre);
			strPaterno = RFCFiltraApellido(strPaterno);
			strMaterno = RFCFiltraApellido(strMaterno);
			/*
			 * Toma en cuenta el nombre de pila cuando este se compone de un
			 * nombre mas Jose o Maria RFCFiltraNombrePila strNombre Ahora toma
			 * en cuenta nombre que comiencen con una doble consonante.
			 * RFCFiltraDobleConsonantes strNombre, strPaterno, strMaterno.
			 * Ahora el siguiente paso es determinar como se va a calcular el
			 * RFC. Existen reglas: 1. Se dan los tres nombres. 2. Se da solo un
			 * nombre. 3. El apellido dado solo tiene 3 o menos letras.
			 */
			if (strPaterno.length() > 0 && strMaterno.length() > 0) {
				if (strPaterno.length() < 3) {
					// Calcula el RFC tomando en cuenta un apellido corto.
					strRFC = RFCApellidoCorto(strNombre, strPaterno,
							strMaterno, strFecha);
				} else {
					// Calcula el RFC.
					strRFC = RFCArmalo(strNombre, strPaterno, strMaterno,
							strFecha);
				}
			} else if (strPaterno.length() == 0 || strMaterno.length() == 0) {
				// Uno de ellos esta vacio
				strRFC = RFCUnApellido(strNombre, strPaterno, strMaterno,
						strFecha);
			}
			strRFC = RFCQuitaProhibidas(strRFC);// verificar si se encuentra
												// alguna palabra ofensiva
			// Ya tengo el RFC, ahora solo falta la homoclave
			strRFC = strRFC
					+ RFCHomoclave(strNombreOriginal, strPaternoOriginal,
							strMaternoOriginal);
			// Por ultimo, calcula el digito verificador.
			retVal = strRFC + RFCDigitoVerificador(strRFC);
		}
		return retVal == null ? "" : retVal.replaceAll(" ", "");
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto
	 *            the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/* Formatear Fecha al tipo personalizado inicialmente */

	private String formatDate(String date) {
		String retDate = null;
		try {
			java.text.DateFormat df = new java.text.SimpleDateFormat(
					this.customFormatDate);
			java.util.Date toParse = df.parse(date);
			String DATE_FORMAT = this.yyMMdd;
			java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat(
					DATE_FORMAT);
			retDate = sf.format(toParse);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return retDate;
	}

	/* Formatear fecha al tipo enviado */
	private String formatDate(String date, String format) {
		String retDate = null;
		try {
			java.text.DateFormat df = new java.text.SimpleDateFormat(format);
			java.util.Date toParse = df.parse(date);
			String DATE_FORMAT = this.yyMMdd;
			java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat(
					DATE_FORMAT);
			retDate = sf.format(toParse);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return retDate;
	}

	/**
	 * @return the customFormatDate
	 */
	public String getCustomFormatDate() {
		return customFormatDate;
	}

	/**
	 * @param customFormatDate
	 *            the customFormatDate to set
	 */
	public void setCustomFormatDate(String customFormatDate) {
		this.customFormatDate = customFormatDate;
	}

	/**
	 * @return the listRFC
	 */
	public java.util.List getListRFC() {
		return listRFC;
	}

	/**
	 * @param listRFC
	 *            the listRFC to set
	 */
	public void setListRFC(java.util.List listRFC) {
		this.listRFC = listRFC;
	}

	/*
	 * Agrega a la lista los datos de la persona a calcular , se envia como
	 * parametro el formato por cada uno
	 */
	public void addListRFC(String nombre, String paterno, String materno,
			String fecha, String format) {
		RfcDO rfc = new RfcDO();
		rfc.setNombre(nombre);
		rfc.setApellidoPaterno(paterno);
		rfc.setApellidoMaterno(materno);
		rfc.setNombreCompleto(paterno + " " + materno + " " + nombre);
		rfc.setFecha(fecha);
		rfc.setFormat(format);
		this.listRFC.add(rfc);
	}

	/*
	 * Agrega a la lista los datos de la persona a calcular , se envia como
	 * parametro el formato por cada uno
	 */
	public void addListRFC(String nombre, String paterno, String materno,
			Date fecha) {
		RfcDO rfc = new RfcDO();
		rfc.setNombre(nombre);
		rfc.setApellidoPaterno(paterno);
		rfc.setApellidoMaterno(materno);
		rfc.setNombreCompleto(paterno + " " + materno + " " + nombre);
		rfc.setDFecha(fecha);
		rfc.setFormat(dd_MM_yyyy);
		this.listRFC.add(rfc);
	}

	/*
	 * Agrega a la lista los datos de la persona a calcular ,el formato se
	 * captura antes
	 */
	public void addListRFC(String nombre, String paterno, String materno,
			String fecha) {
		RfcDO rfc = new RfcDO();
		rfc.setNombre(nombre);
		rfc.setApellidoPaterno(paterno);
		rfc.setApellidoMaterno(materno);
		rfc.setNombreCompleto(paterno + " " + materno + " " + nombre);
		rfc.setFecha(fecha);
		rfc.setFormat(this.customFormatDate);
		this.listRFC.add(rfc);
	}

	/*
	 * Genera la lista de RFC de las personas que se hayan agregado a la lista.
	 * En La lista se almacenara el RFC que se haya generado.
	 */
	public void generateRFCList() {
		System.out.println("From list-->");
		for (int i = 0; i < this.listRFC.size(); i++) {
			RfcDO rfc = (RfcDO) listRFC.get(i);
			setCustomFormatDate(rfc.getFormat());
			String retVal = generaRFC(rfc.getNombre(),
					rfc.getApellidoPaterno(), rfc.getApellidoMaterno(), rfc
							.getFecha());
			rfc.setRfc(retVal);
			this.listRFC.set(i, rfc);
			System.out.println(getNombreCompleto() + retVal + "  "
					+ getCustomFormatDate());
		}
	}

	/*
	 * Genera la lista de RFC de las personas que se hayan agregado a la lista.
	 * En La lista se almacenara el RFC que se haya generado.
	 */
	

	public void clearList() {
		this.listRFC.clear();
	}

	// Inner class RfcDO
	public class RfcDO {

		public RfcDO() {
		}

		private String nombre;
		private String apellidoPaterno;
		private String apellidoMaterno;
		private String nombreCompleto;
		private String fecha;
		private String format;
		private String rfc;
		private Date dFecha;

		/**
		 * @return the nombre
		 */
		public String getNombre() {
			return nombre;
		}

		/**
		 * @param nombre
		 *            the nombre to set
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		/**
		 * @return the apellidoPaterno
		 */
		public String getApellidoPaterno() {
			return apellidoPaterno;
		}

		/**
		 * @param apellidoPaterno
		 *            the apellidoPaterno to set
		 */
		public void setApellidoPaterno(String apellidoPaterno) {
			this.apellidoPaterno = apellidoPaterno;
		}

		/**
		 * @return the apellidoMaterno
		 */
		public String getApellidoMaterno() {
			return apellidoMaterno;
		}

		/**
		 * @param apellidoMaterno
		 *            the apellidoMaterno to set
		 */
		public void setApellidoMaterno(String apellidoMaterno) {
			this.apellidoMaterno = apellidoMaterno;
		}

		/**
		 * @return the nombreCompleto
		 */
		public String getNombreCompleto() {
			return nombreCompleto;
		}

		/**
		 * @param nombreCompleto
		 *            the nombreCompleto to set
		 */
		public void setNombreCompleto(String nombreCompleto) {
			this.nombreCompleto = nombreCompleto;
		}

		/**
		 * @return the fecha
		 */
		public String getFecha() {
			return fecha;
		}

		/**
		 * @param fecha
		 *            the fecha to set
		 */
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		/**
		 * @return the format
		 */
		public String getFormat() {
			return format;
		}

		/**
		 * @param format
		 *            the format to set
		 */
		public void setFormat(String format) {
			this.format = format;
		}

		/**
		 * @return the rfc
		 */
		public String getRfc() {
			return rfc;
		}

		/**
		 * @param rfc
		 *            the rfc to set
		 */
		public void setRfc(String rfc) {
			this.rfc = rfc;
		}

		/**
		 * @return the dFecha
		 */
		public Date getDFecha() {
			return dFecha;
		}

		/**
		 * @param dFecha
		 *            the dFecha to set
		 */
		public void setDFecha(Date dFecha) {
			this.dFecha = dFecha;
		}
	}
}