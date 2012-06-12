/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import com.urbi.business.impl.CustomerImpl;
import com.urbi.business.interfaces.Customer;
import com.urbi.dao.impl.Dao;
import com.urbi.utils.valueobject.ProcessValueObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Cli;


/**
 *
 * @author alvarerr
 */
public class BuscarMetaServlet extends HttpServlet {


    private int porNumero = 0;
    private int porPersona = 0;
    private int porUsuario = 0;
    private int porFecha = 0;
    private String numero = "";
    private String persona;
    private String usuario;
    private Date fecha = new Date();


    public int getPorFecha() {
        return porFecha;
    }

    public void setPorFecha(int porFecha) {
        this.porFecha = porFecha;
    }

    public int getPorNumero() {
        return porNumero;
    }

    public void setPorNumero(int porNumero) {
        this.porNumero = porNumero;
    }

    public int getPorPersona() {
        return porPersona;
    }

    public void setPorPersona(int porPersona) {
        this.porPersona = porPersona;
    }

    public int getPorUsuario() {
        return porUsuario;
    }

    public void setPorUsuario(int porUsuario) {
        this.porUsuario = porUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }








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
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuscarMetaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuscarMetaServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
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
        //processRequest(request, response);

        int banderaWhere = 0;
        String clausulaWhere = "";
        List<Cli> cust = new ArrayList<Cli>();

        if(request.getParameter("porPersona")==null){
            request.getSession().removeAttribute("clientes");
            response.sendRedirect("./meta/metaindex.jsp");
            return;
        }
        

        //filtro por persona
        if(request.getParameter("porPersona") != null){

            this.setPorPersona(Integer.parseInt(request.getParameter("porPersona")));

            if (request.getParameter("persona") != null){

                this.setPersona(request.getParameter("persona"));
            }
            //si no existe un where previo
            System.out.println("Bandeda wher en persona: " + banderaWhere);
            if(banderaWhere == 0){
                clausulaWhere = "where c.cliNom like '%" + this.getPersona() + 
                        "%' or c.cliApePat like '%"+this.getPersona()+"%' or c.cliApeMat like '%"+this.getPersona()+"%'";
            }else{
                clausulaWhere = clausulaWhere + " and c.cliNom like '%" + this.getPersona() + "%'";
            }
        }



        System.out.println("cadena where: " + clausulaWhere);

        Customer customerService = new CustomerImpl();
        ProcessValueObject processValueObject = customerService.filtarMeta(clausulaWhere);

        cust = (List) processValueObject.getInfoResult().get("clientes");

        if(cust == null){

            cust = new ArrayList<Cli>();
        }
        
        System.out.println("numero de registos encontrados: " + cust.size());
        request.getSession().setAttribute("clientes", cust);
        response.sendRedirect("./meta/metaindex.jsp");


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
