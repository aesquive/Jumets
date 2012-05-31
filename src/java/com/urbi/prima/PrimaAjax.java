package com.urbi.prima;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimaAjax
 */
public class PrimaAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrimaAjax() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[][] dato = new String[0][0];
		String tipo = request.getParameter("tipo");
		String idCal = request.getParameter("idCal");
		String id1 = request.getParameter("id1");
		String id2 = request.getParameter("id2");

		if ("1".equals(tipo))
			dato = PrimaSql.getSector(idCal, "", id1);
		else if ("2".equals(tipo))
			dato = PrimaSql.getSubsector(idCal, "", id2);
		else if ("3".equals(tipo))
			dato = PrimaSql.getEdoMunCP(idCal);
		else if ("4".equals(tipo))
			dato = PrimaSql.getDesarollo(idCal, id1);

		response.setContentType("text/xml");
		PrintWriter pw = response.getWriter();
		pw.write("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
		pw.write("\n<catalogo>\n");
		for (int i = 0; i < dato.length; i++) {
			pw.write("\t<prima id=\"" + dato[i][0] + "\">" + dato[i][1]
					+ "</prima>\n");
		}
		pw.write("</catalogo>\n");
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
