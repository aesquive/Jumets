/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ydt
 */
public class MetaClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String command = null;
        String form = null;
       try {

           System.out.println("entra aqui en el servlet");
            command = request.getParameter("command");
            form = request.getParameter("form");

        } finally {
           if(command.equalsIgnoreCase("Agregar") && form.equalsIgnoreCase("MetaIndex")){
               if(request.getSession().getAttribute("accion") != null)
                   request.getSession().removeAttribute("accion");
               
               request.getSession().setAttribute("accion", "Agregar");
                response.sendRedirect("./meta/clientemeta.jsp");
            }else
               if(command.equalsIgnoreCase("Modificar") && form.equalsIgnoreCase("MetaIndex")){
                   if(request.getSession().getAttribute("accion") != null)
                       request.getSession().removeAttribute("accion");

                   int id = 0;


                   if(request.getSession().getAttribute("idCliente") != null){

                       request.getSession().removeAttribute("idCliente");
                   }

                   if(request.getParameter("id") != null){

                       id = Integer.parseInt(request.getParameter("id"));
                   }


                   request.getSession().setAttribute("accion", "Modificar");
                   request.getSession().setAttribute("idCliente", id);
                   response.sendRedirect("./meta/clientemeta.jsp");
            }else
                if(command.equalsIgnoreCase("Siguiente") && form.equalsIgnoreCase("ClienteMeta")){
                    request.getSession().setAttribute("accion", "Agregar");
                    response.sendRedirect("./meta/clientemeta_2.jsp");
            }else
                if(command.equalsIgnoreCase("Siguiente") && form.equalsIgnoreCase("HistoriaMeta")){
                    request.getSession().setAttribute("accion", "Agregar");
                    response.sendRedirect("./meta/clientemeta_2.jsp");
            }else
                if(command.equalsIgnoreCase("Anterior") && form.equalsIgnoreCase("HistoriaMeta")){
                    //request.getSession().setAttribute("accion", "Agregar");
                    response.sendRedirect("./meta/clientemeta.jsp");
            }else
                if(command.equalsIgnoreCase("Anterior") && form.equalsIgnoreCase("ClienteMeta2")){
                    //request.getSession().setAttribute("accion", "Agregar");
                    response.sendRedirect("./meta/clientemeta.jsp");
            }else
                if(command.equalsIgnoreCase("Salir") && form.equalsIgnoreCase("ClienteMeta2")){
                    //request.getSession().setAttribute("accion", "Agregar");
                    response.sendRedirect("./meta/metaindex.jsp");
            }else
                if(command.equalsIgnoreCase("Calcular") && form.equalsIgnoreCase("MetaIndex")){
                    //request.getSession().setAttribute("accion", "Agregar");
                    response.sendRedirect("./meta/calcmeta.jsp");
            }
        }
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
        processRequest(request, response);
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
