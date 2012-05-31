package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urbi.utilerias.dao.Usuarios;
import com.urbi.utilerias.dao.UsuariosImpl;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");
		if ("autentificar".equals(accion)) {
			HttpSession session = request.getSession();
			session = request.getSession(true);
			session.setMaxInactiveInterval(1800);

			String user = request.getParameter("user");
			String pass = request.getParameter("pass");

			int login = UsuariosImpl.autentificacion(user, pass);
			if (login == 1) {
				Usuarios usuarioUrbi = UsuariosImpl.usuarioUrbi(user);
				session.setAttribute("usuarioUrbi", usuarioUrbi);
				session.setAttribute("msjLogin", null);
				response.sendRedirect("index_autent.jsp");
			} else {
				session.setAttribute("UsuarioBean", null);
				session
						.setAttribute("msjLogin",
								"El usuario o password no es correcto, favor de verificar!");
				response.sendRedirect("index.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
