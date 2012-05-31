/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.listener;

import com.meve.util.db.ConnectionManager;

import javax.servlet.ServletContextEvent;

/**
 * 
 * @author Rodrigo Soto Chavarria Clase que carga de variables de inicio para la
 *         conexion a la base de datos
 */
public class Listener implements javax.servlet.ServletContextListener {

	private static final long serialVersionUID = 5365748112161017943L;

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("****** INICIO CARGA DATOS BASE ******");

		String tipoBD = sce.getServletContext().getInitParameter(
				"tipoJdbcDriver");
		String user = sce.getServletContext().getInitParameter("userBD");
		String password = sce.getServletContext()
				.getInitParameter("passwordBD");
		String driverType = sce.getServletContext().getInitParameter(
				"TipoDriverBD");
		String databaseName = sce.getServletContext()
				.getInitParameter("NameBD");
		String host = sce.getServletContext().getInitParameter("ServerDB");
		String port = sce.getServletContext().getInitParameter("PortBD");
		String serverName = sce.getServletContext().getInitParameter(
				"NombreServidorBD");

		ConnectionManager.setJdbcVariables(Integer.parseInt(tipoBD), user,
				password, driverType, databaseName, host, port, serverName);
		ConnectionManager.debug = true;
		System.out.println("****** FIN CARGA DATOS BASE ******");
	}
}
