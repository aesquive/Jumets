package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urbi.utilerias.dao.Usuarios;
import com.urbi.utilerias.dao.UsuariosImpl;

public class UsuariosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuariosAction() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");

		Usuarios usuarioUrbi = (Usuarios) request.getSession().getAttribute(
				"usuarioUrbi");

		if (!usuarioUrbi.isVendedor()) {

			if ("entra".equals(accion)) {
				Usuarios usuario = new Usuarios();
				request.getSession().setAttribute("usuario", usuario);
				request.getSession().setAttribute("agregar", "0");
				response.sendRedirect("./utileria/mantusuario.jsp");
			} else if ("guardar".equals(accion)) {
				Usuarios usuario = new Usuarios();
				UsuariosImpl usu = new UsuariosImpl();

				String id = (request.getParameter("id") == null) ? "" : request
						.getParameter("id");
				String clave = request.getParameter("clave");
				String nombre = request.getParameter("nombre");
				String password = request.getParameter("password");
				String perfil[] = request.getParameterValues("perfil");

				usuario.setId(id);
				usuario.setClave(clave);
				usuario.setNombre(nombre);
				usuario.setPassword(password);
				usuario.setPerfil(perfil == null ? "-1" : perfil[0]);

				if (id.length() > 0) {// actualiza
					usu.actualizaRegistro(usuario);
				} else {// inserta
					usu.insertaRegistro(usuario);
				}
				request.getSession().setAttribute("agregar", "0");
				request.getSession().setAttribute("usuario", new Usuarios());
				response.sendRedirect("./utileria/mantusuario.jsp");
			} else if ("modificar".equals(accion)) {
				UsuariosImpl usu = new UsuariosImpl();
				String id = request.getParameter("id");

				Usuarios usuario = usu
						.getRegistroConsulta(Integer.parseInt(id));
				request.getSession().setAttribute("usuario", usuario);
				request.getSession().setAttribute("agregar", "1");
				response.sendRedirect("./utileria/mantusuario.jsp");
			} else if ("eliminar".equals(accion)) {
				UsuariosImpl usu = new UsuariosImpl();
				String id = request.getParameter("id");
				usu.eliminarRegistro(id);
				request.getSession().setAttribute("agregar", "0");
				request.getSession().setAttribute("usuario", new Usuarios());
				response.sendRedirect("./utileria/mantusuario.jsp");
			}
		} else
			response.sendRedirect("./utileria/indexutileria.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
