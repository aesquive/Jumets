/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;






import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;

import servlets.util.*;

import webservice.*;

/**
 *
 * @author alvarerr
 */
public class MasivoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       /* response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BehaivorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BehaivorServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		//INICIO >>>



                System.out.println(request.getRequestURL());
		System.out.println("Inicia META MASIVO SERVLET SOLICITUD");

		//EAAR 17/09/2009: bloque try exclusivamente para parametros
		try{
			String strJBFormPrefix = "RegistrarDevolucionIndebida_JForm";
 			String strJBFormSeparator = "_";

			String nombreArchivo = "";
			byte[] archivoData = null;
			long longitudArchivo = 0;
			String mimeType = "";
			String extencion = "";
			String cadenaError = "";
			boolean permitido = true;
			Util util = new Util();

			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart){

				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List items = upload.parseRequest(request);

				Iterator iter = items.iterator();
				while (iter.hasNext()) {
				    FileItem item = (FileItem) iter.next();

//				    System.out.println("datos archivo:\nfileName="+item.getFieldName()+":\nName="+item.getName()+":\n");



					if(item.getFieldName().equals("filSubmit")){

                                                System.out.println("manejando archivo***********");
						nombreArchivo = item.getName();

						System.out.println("nombre de archivo inicial="+nombreArchivo+":");
						if(nombreArchivo.contains("\\"))
							nombreArchivo = nombreArchivo.substring(nombreArchivo.lastIndexOf("\\")+1,nombreArchivo.length());
						System.out.println("nombre de archivo final="+nombreArchivo+":");

						String strArchivo  = nombreArchivo;

						archivoData = item.get();

						longitudArchivo = item.getSize();
						System.out.println("tamaño del archivo="+item.getSize()+":\ntamaño del arreglo="+archivoData.length+":");
						extencion = nombreArchivo.substring(nombreArchivo.length()-3, nombreArchivo.length());
						System.out.println("extencion:"+extencion+":");
						if(extencion.trim().toLowerCase().equals("zip"))
							mimeType = util.getMimeType(item.get());
						else
							mimeType = "null";
					}
				}
			} //fin multipart

        String valorArchivoMeta = new String(archivoData);

        CalculadoraCMWS bws = new CalculadoraCMWS();

        System.out.println("-------------->");
    //    System.out.println(bws.CalculaB(valorArchivoBehavior));

        String strXMLStringToByteArray =  bws.CalculaMasivaCM(valorArchivoMeta);

            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            ByteArrayInputStream bais = new ByteArrayInputStream(strXMLStringToByteArray.getBytes());
            DocumentBuilderFactory dbfacIN = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilderIN = dbfacIN.newDocumentBuilder();
            Document docIN = docBuilderIN.parse(bais);
            DOMSource source = new DOMSource(docIN);
            URL foourl = this.getClass().getResource("/transf2.xsl");
            Source fooxsl = new StreamSource(foourl.toExternalForm());
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(fooxsl);
            transformer.transform(source, result);

            String xmlString = sw.toString();
            xmlString = "CLI_ID,CLI_SAP,CLASIFICACION_1,CLASIFICACION_2,CLASIFICACION_3,ACCION_1,ACCION_2\n" +xmlString.substring(39);
            System.out.println(xmlString);


                 byte[] byteArrayToXML= xmlString.getBytes();
    //    byte[] byteArrayToXML= strXMLStringToByteArray.getBytes();

        response.setContentType("application/xml");
			response.setContentLength(byteArrayToXML.length);

                        Date dt = new Date();

                        String strDate = dt.getYear()+"-"+dt.getMonth()+"-"+dt.getDate();

                        String nombreArchivoRespuestaXML= "resultadoProcesar_"+strDate+".csv";

			response.setHeader("Content-Disposition", "attachment; filename="+nombreArchivoRespuestaXML+"");
			//res.ContentType = "pdf";0
			OutputStream ouputStream = response.getOutputStream();
			ouputStream.write(byteArrayToXML, 0, byteArrayToXML.length);
			ouputStream.flush();
			ouputStream.close();

		}catch (Exception e) {

			//out.println("{'resultado':'-1'}");
			//out.flush();
			//out.close();
			e.printStackTrace();
		}
		System.out.println("---- TERMINA ENVIAR XML -----");

    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
