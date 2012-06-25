package com.urbi.prima;

import com.urbi.dao.impl.Dao;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Des;

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
		else if ("4".equals(tipo)){
                        dato=sacarDesarrollos(id1);
                }

		response.setContentType("text/xml");
		PrintWriter pw = response.getWriter();
		pw.write("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
		pw.write("\n<catalogo>\n");
		for (int i = 0; i < dato.length; i++) {
			pw.write("\t<gol id=\"" + dato[i][0] + "\""+" mun=\"" + dato[i][1] + "\""+">" + dato[i][1]
					+ "</gol>\n");
		}
		pw.write("</catalogo>\n");
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    private String[][] sacarDesarrollos(String id1) {
        SacadorDesarrollos sacador=new SacadorDesarrollos();
        List<Des> desarrollos = sacador.obtenerDesarrollos(Integer.parseInt(id1));
        String[][] respuesta=new String[desarrollos.size()][2];
        for(int t=0;t<desarrollos.size();t++){
            respuesta[t][0]=desarrollos.get(t).getDesId().toString();
            respuesta[t][1]=desarrollos.get(t).getDesDes();
        }
        return respuesta;
    }

}
