package com.urbi.gol;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urbi.prima.PrimaSql;

/**
 * Servlet implementation class GolAjax
 */
public class GolAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GolAjax() {
		super();
		// TODO Auto-generated constructor stub
	}

    @Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[][] dato = new String[0][0];
		String tipo = request.getParameter("tipo");
		String idCal = request.getParameter("idCal");
		String id1 = request.getParameter("id1");
		String id2 = request.getParameter("id2");

                System.out.println("entre a gol ajax");
                System.out.println("el tipo es "+tipo);
                
		if ("1".equals(tipo))// sector
			dato = PrimaSql.getSector(idCal, "", id1);
		else if ("2".equals(tipo))// subsector
			dato = PrimaSql.getSubsector(idCal, "", id2);
		else if ("3".equals(tipo))// codigo postal
			dato = PrimaSql.getEdoMunCP(idCal);

		response.setContentType("text/xml");
		PrintWriter pw = response.getWriter();
		pw.write("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
		
                pw.write("\n<catalogo>\n");
		for (int i = 0; i < dato.length; i++) {
			pw.write("\t<gol id=\"" + dato[i][0] + "\"    mun=\""+dato[i][1]+"\">" + dato[i][1]
					+ "</gol>\n");
                        System.out.println("\t<gol id=\"" + dato[i][0] + "\">" + dato[i][1]
					+ "</gol>\n");
                }
		pw.write("</catalogo>\n");
                
		pw.flush();
		pw.close();
	}

    @Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
