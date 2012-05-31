/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.math.BigDecimal;
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
 * @author ydt
 */
public class PuraPrimaServlet extends HttpServlet {
   
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
        try {
            command = request.getParameter("command");

        } finally {
           if(command.equalsIgnoreCase("Agregar")){
                request.getSession().setAttribute("accion", "Agregar");
                response.sendRedirect("./prima/mantprima.jsp");
            }else if(command.equalsIgnoreCase("Calcular")){
            String cliId = request.getParameter("cliId");

            Session s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();

            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("from CliPpr as clippr where clippr.cli.cliId="+cliId);
            List lista = (List) q.list();
            CliPpr clippr = (CliPpr)lista.get(0);


            int estado = clippr.getEdoId();
            int edad = clippr.getCliEdaId();
            int ocupacion =clippr.getOcpId();
            String fecha = clippr.getCliPprMes();
            //TODO 
            String mensualidad = "";
            float valor_vivienda =-444444;

            tx = s.beginTransaction();
            q = s.createQuery("from Edo as edo where edo.edoId ="+estado);
            lista = (List) q.list();
            double estado_woe = ((Edo)lista.get(0)).getEdoWoe();
            double recargo = ((Edo)lista.get(0)).getEdoRcg();

            q = s.createQuery("from RngEda as eda where eda.edaId"+edad);
            lista = (List) q.list();
            double edad_woe = ((RngEda)lista.get(0)).getRngEdaWoe();

            q = s.createQuery("from Ocp as ocp where ocp.ocpId ="+ocupacion);
            lista = (List) q.list();
            double ocupacion_woe = ((Ocp)lista.get(0)).getOcpWoe();

          //  double  zeta = 0.018-(0.01)*estado_woe-(0.017)*edad_woe-(0.008)*ocupacion_woe;
            double zeta = 0.018146691102274-(0.00993013369427481)* estado_woe -(0.017366941566975)* edad_woe -(0.00838465419451784)* ocupacion_woe;
            double pi = Math.exp(zeta)/(1+Math.exp(zeta));

            q = s.createQuery("from IntPi as intPi where intPi.cal.calId='6' and intPi.intPiLimInf<="+pi+" and intPi.intPiLimSup>="+pi);
            lista = (List) q.list();
            String clasificacion = ((IntPi)lista.get(0)).getIntPiDes();

            q = s.createQuery("from FtrPpr as fp where fp.ftrPprCls='"+clasificacion+"' and fp.ftrPprMes="+fecha);
            lista = (List) q.list();
            double cuota = ((FtrPpr)lista.get(0)).getFtrPprFtr();

            double ppr = valor_vivienda*cuota;
            double cuota_pprr = cuota * (1 + recargo);
            double pprr = valor_vivienda *cuota_pprr;


         /*   AgregarNodo(raiz,doc,"CUOTA_PURA_RIESGO",Double.toString(cuota*100)+"%");
            AgregarNodo(raiz,doc,"CUOTA_RECARGADAD",Double.toString(cuota_pprr*100)+"%");
            AgregarNodo(raiz,doc,"PRIMA_PURA_RIESGO","$"+Double.toString(ppr));
            AgregarNodo(raiz,doc,"PRIMA_PURA_RIESO_RECARGADA","$"+Double.toString(pprr));*/


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
