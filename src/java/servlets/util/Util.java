/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;


/**
 *
 * @author alvarerr
 */
public class Util {

    public static Document stringToDom(String xmlSource)
            throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xmlSource)));
    }

    /**
	 * Regresa el MimeType del archivo
	 * @param f
	 * @return
	 */
	public static String getMimeType(byte[] f) {
		try{
			Magic parser = new Magic() ;
			MagicMatch match = parser.getMagicMatch(f,true);
			String mimeType = match.getMimeType();
			String[] cast = mimeType.split("/");
			mimeType = cast[cast.length-1];
			System.out.println("Funciona mimeType : " + mimeType ) ;

			return mimeType;
		}catch(Exception e){
			System.out.println("Error con el archivo"+f);
			return null;
		}
	}

	public boolean isNumber(String cadena){
		String validChars = "0123456789";
		char c;
		boolean res = true;
		if (cadena == null) return false;
		if (cadena.equals("")) return false;
		if (cadena.length() == 0) return false;
		for (int i = 0; i < cadena.length() && res; i++){
			c = cadena.charAt(i) ;
			if (validChars.indexOf(c) == -1)
				res = false;
		}
		return res;
	}

}
