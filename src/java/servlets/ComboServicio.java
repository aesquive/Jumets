/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import com.urbi.dao.impl.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlets.util.JsonConversor;

/**
 *
 * @author Albert
 */
public class ComboServicio extends HttpServlet {

    private Dao dao=new Dao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {


          response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        try{

            if(request.getParameter("nom").equals("sector")){

                         int limInf=Integer.parseInt(request.getParameter("limInf"));

                    int limSup=Integer.parseInt(request.getParameter("limSup"));

                   Object[][] combos = dao.obtenListaSrv(limInf,limSup);

                   String json = JsonConversor.toJson(combos[0], combos[1]);

                   out.print( json);
            }else {

                    int limInf=Integer.parseInt(request.getParameter("limInf"));

                    int limSup=Integer.parseInt(request.getParameter("limSup"));

                   Object[][] combos = dao.obtenListaOcp(limInf,limSup);

                   String json = JsonConversor.toJson(combos[0], combos[1]);

                   out.print( json);

            }



        } finally {
            out.close();
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
