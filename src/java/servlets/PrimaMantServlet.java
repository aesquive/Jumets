/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import com.urbi.prima.PrimaBean;

import com.urbi.prima.PrimaSql;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Rodrigo Soto chavarria
 * @mail rodrigo.soto.ch@gmail.com
 */
public class PrimaMantServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String command = null;
		String pagina = "";
		try {
			command = request.getParameter("command");
			if (command.equalsIgnoreCase("Guardar")) {
				PrimaBean p = new PrimaBean();
				p.setApellidoPaterno(request.getParameter("apellidoPaterno"));
				p.setApellidoMaterno(request.getParameter("apellidoMaterno"));
				p.setNombre(request.getParameter("nombre"));
				p.setDia(request.getParameter("dia"));
				p.setMes(request.getParameter("mes"));
				p.setAnio(request.getParameter("anio"));
				p.setEdad(request.getParameter("edad"));
				p.setCalle(request.getParameter("calle"));
				p.setNoExterior(request.getParameter("noExterior"));
				p.setNoInterior(request.getParameter("noInterior"));
				p.setColonia(request.getParameter("colonia"));
				p.setCp(request.getParameter("cp"));
				p.setEdo(request.getParameter("edo"));
				p.setMunicipio(request.getParameter("mun"));
				p.setEdoCivil(request.getParameter("edoCivil"));

				String tipoActividad = request.getParameter("tipoActividad");
				p.setTipoActividad(tipoActividad);
				if ("3".equals(tipoActividad))
					p.setSubSector("300");
				else if ("4".equals(tipoActividad))
					p.setSubSector("400");
				else
					p.setSubSector(request.getParameter("subSector"));
				p.setSector(request.getParameter("sector"));
				p.setRol(request.getParameter("rol"));
				p.setDescripcionOcupacion(request
						.getParameter("descripcionOcupacion"));
				p.setUbicacionVivienda(request
						.getParameter("ubicacionVivienda"));
				p.setDesarrollo(request.getParameter("desarrollo"));
				p.setValorVivienda(request.getParameter("valorVivienda"));
				p.setMensualidad(request.getParameter("mensualidad"));
				p.setIngresoMensual(request.getParameter("ingresoMensual"));
				p.setDependientes(request.getParameter("dependientes"));

				int idPrima = PrimaSql.insertaPrima(p);

				p.setIdPrima(String.valueOf(idPrima));

				PrimaSql.insertaPrimaPPR(p);

				String lista = PrimaSql.getListaPrima("", "", 0);
				request.getSession().setAttribute("lista", lista);

				pagina = "./prima/primaindex.jsp";
			} else if (command.equalsIgnoreCase("ver")) {
				String id = request.getParameter("id");
				request.getSession().setAttribute("idPrimaV", id);
				if (Integer.parseInt(id) == 0)
					pagina = "./prima/primaindex.jsp";
				else
					pagina = "./prima/modPrima.jsp";
				request.getSession().setAttribute("accion", "Modificar");
			} else if (command.equalsIgnoreCase("calcular")) {
				String id = request.getParameter("id");
				PrimaBean p = PrimaSql.getVer(id, 0);
				calcular(request, response, p);
				pagina = "./prima/calcprima.jsp";
			} else if (command.equalsIgnoreCase("calcularinicio")) {
				request.getSession().setAttribute("NOMBRE_PRIMA", "");
				request.getSession().setAttribute("CUOTA_PURA_RIESGO", "");
				request.getSession().setAttribute("CUOTA_RECARGADAD", "");
				request.getSession().setAttribute("PRIMA_PURA_RIESGO", "");
				request.getSession().setAttribute("PRIMA_PURA_RIESO_RECARGADA",
						"");
				pagina = "./prima/calcprima.jsp";
			} else if (command.equalsIgnoreCase("agregar")) {
				request.getSession().setAttribute("NOMBRE_PRIMA", "");
				request.getSession().setAttribute("CUOTA_PURA_RIESGO", "");
				request.getSession().setAttribute("CUOTA_RECARGADAD", "");
				request.getSession().setAttribute("PRIMA_PURA_RIESGO", "");
				request.getSession().setAttribute("PRIMA_PURA_RIESO_RECARGADA",
						"");
				request.getSession().setAttribute("banderaC", null);
				request.getSession().setAttribute("accion", "Agregar");
				pagina = "./prima/mantprima.jsp";
			} else if (command.equalsIgnoreCase("buscar")) {
				String rfc = (request.getParameter("rfc") == null) ? ""
						: request.getParameter("rfc");
				String nombre = (request.getParameter("persona") == null) ? ""
						: request.getParameter("persona");
				String lista = PrimaSql.getListaPrima(rfc, nombre, 1);
				request.getSession().setAttribute("lista", lista);
				pagina = "./prima/primaindex.jsp";
			} else if (command.equalsIgnoreCase("buscart")) {
				String lista = PrimaSql.getListaPrima("", "", 0);
				request.getSession().setAttribute("lista", lista);
				pagina = "./prima/primaindex.jsp";
			} else if (command.equalsIgnoreCase("eliminar")) {
				String id = request.getParameter("id");
				PrimaSql.eliminarPrima(id);
				String lista = PrimaSql.getListaPrima("", "", 0);
				request.getSession().setAttribute("lista", lista);
				pagina = "./prima/primaindex.jsp";
			} else if (command.equalsIgnoreCase("modificar")) {
				PrimaBean p = new PrimaBean();
				p.setApellidoPaterno(request.getParameter("apellidoPaterno"));
				p.setApellidoMaterno(request.getParameter("apellidoMaterno"));
				p.setNombre(request.getParameter("nombre"));
				p.setDia(request.getParameter("dia"));
				p.setMes(request.getParameter("mes"));
				p.setAnio(request.getParameter("anio"));
				p.setEdad(request.getParameter("edad"));
				p.setCalle(request.getParameter("calle"));
				p.setNoExterior(request.getParameter("noExterior"));
				p.setNoInterior(request.getParameter("noInterior"));
				p.setColonia(request.getParameter("colonia"));
				p.setCp(request.getParameter("cp"));
				p.setEdo(request.getParameter("edo"));
				p.setMunicipio(request.getParameter("mun"));
				p.setEdoCivil(request.getParameter("edoCivil"));
				p.setTipoActividad(request.getParameter("tipoActividad"));

				String tipoActividad = request.getParameter("tipoActividad");
				p.setTipoActividad(tipoActividad);
				if ("3".equals(tipoActividad))
					p.setSubSector("300");
				else if ("4".equals(tipoActividad))
					p.setSubSector("400");
				else
					p.setSubSector(request.getParameter("subSector"));

				p.setSector(request.getParameter("sector"));
				p.setRol(request.getParameter("rol"));
				p.setDescripcionOcupacion(request
						.getParameter("descripcionOcupacion"));
				p.setUbicacionVivienda(request
						.getParameter("ubicacionVivienda"));
				p.setDesarrollo(request.getParameter("desarrollo"));
				p.setValorVivienda(request.getParameter("valorVivienda"));
				p.setMensualidad(request.getParameter("mensualidad"));
				p.setIngresoMensual(request.getParameter("ingresoMensual"));
				p.setDependientes(request.getParameter("dependientes"));
				p.setIdPrima(request.getParameter("idPrima"));
				PrimaSql.updatePrima(p);

				String lista = PrimaSql.getListaPrima("", "", 0);
				request.getSession().setAttribute("lista", lista);

				pagina = "./prima/primaindex.jsp";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			response.sendRedirect(pagina);
		}
	}

	// <editor-fold defaultstate="collapsed"
	// desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * 
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}

	public void calcular(HttpServletRequest request,
			HttpServletResponse response, PrimaBean p) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		java.util.Date f = new java.util.Date();
		String mes = sdf.format(f);
		// HIBERNATE
		Session s = objetos.HibernateUtil.getSessionFactory()
				.getCurrentSession();

		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from Edo as edo where edo.cal.calId = '6'");
		List lista = (List) q.list();
		double estado_woe = ((Edo) lista.get((Integer.parseInt(p
				.getUbicacionVivienda())) - 1)).getEdoWoe();
		double recargo = ((Edo) lista.get((Integer.parseInt(p
				.getUbicacionVivienda())) - 1)).getEdoRcg();

		q = s
				.createQuery("from RngEda as eda where eda.calId='6' and eda.rngEdaLimInf<="
						+ p.getEdad() + " and eda.rngEdaLimSup>=" + p.getEdad());
		lista = (List) q.list();
		double edad_woe = ((RngEda) lista.get(0)).getRngEdaWoe();

		String queryOcp = "";
		if (p.getSubSector().equals("300") || p.getSubSector().equals("400"))
			queryOcp = "from Ocp as ocp where ocp.cal.calId = '6' and ocp.ocpOrdPre="
					+ p.getSubSector();
		else
			queryOcp = "from Ocp as ocp where ocp.cal.calId = '6' and ocp.ocpId="
					+ p.getSubSector();
		q = s.createQuery(queryOcp);
		lista = (List) q.list();
		double ocupacion_woe = ((Ocp) lista.get(0)).getOcpWoe();

		double zeta = 0.018146691102274 - (0.00993013369427481) * estado_woe
				- (0.017366941566975) * edad_woe - (0.00838465419451784)
				* ocupacion_woe;
		double pi = Math.exp(zeta) / (1 + Math.exp(zeta));

		q = s
				.createQuery("from IntPi as intPi where intPi.cal.calId='6' and intPi.intPiLimInf<="
						+ pi + " and intPi.intPiLimSup>=" + pi);
		lista = (List) q.list();
		String clasificacion = ((IntPi) lista.get(0)).getIntPiDes();

		q = s.createQuery("from FtrPpr as fp where fp.ftrPprCls='"
				+ clasificacion + "' and fp.ftrPprMes=" + mes);
		lista = (List) q.list();

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		double cuota = ((FtrPpr) lista.get(0)).getFtrPprFtr();
		double ppr = Double.parseDouble(p.getValorVivienda()) * cuota;
		double cuota_pprr = cuota * (1 + recargo);
		double pprr = Double.parseDouble(p.getValorVivienda()) * cuota_pprr;

		String CUOTA_PURA_RIESGO = nf.format(cuota * 100) + "%";
		String CUOTA_RECARGADAD = nf.format(cuota_pprr * 100) + "%";
		String PRIMA_PURA_RIESGO = "$" + nf.format(ppr);
		String PRIMA_PURA_RIESO_RECARGADA = "$" + nf.format(pprr);

		request.getSession().setAttribute(
				"NOMBRE_PRIMA",
				p.getNombre() + " " + p.getApellidoPaterno() + " "
						+ p.getApellidoMaterno());
		request.getSession().setAttribute("CUOTA_PURA_RIESGO",
				CUOTA_PURA_RIESGO);
		request.getSession().setAttribute("CUOTA_RECARGADAD", CUOTA_RECARGADAD);
		request.getSession().setAttribute("PRIMA_PURA_RIESGO",
				PRIMA_PURA_RIESGO);
		request.getSession().setAttribute("PRIMA_PURA_RIESO_RECARGADA",
				PRIMA_PURA_RIESO_RECARGADA);
	}

}
