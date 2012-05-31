/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import com.urbi.business.impl.CustomerImpl;
import com.urbi.business.interfaces.Customer;
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

        //se valida cada uno de los filtros
        //filtro por numero
        if(request.getParameter("porNumero") != null){

            this.setPorNumero(Integer.parseInt(request.getParameter("porNumero")));

            if (request.getParameter("numero") != null){

                this.setNumero(request.getParameter("numero"));
            }
            //si no existe un where previo
            //ahora se busca por rfc
            System.out.println("bandera where en numero: " + banderaWhere);
            if(banderaWhere == 0){
                clausulaWhere = "where c.cliRFC='" + this.getNumero() + "'";
            }else{
                clausulaWhere = clausulaWhere + " and c.cliRFC='" + this.getNumero() + "'";
            }
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
                clausulaWhere = "where c.cliNom like '%" + this.getPersona() + "%'";
            }else{
                clausulaWhere = clausulaWhere + " and c.cliNom like '%" + this.getPersona() + "%'";
            }
        }

      //filtro por usuario
      /* no se va a ocupar
        if(request.getParameter("porUsuario") != null){

            this.setPorUsuario(Integer.parseInt(request.getParameter("porUsuario")));
            if (request.getParameter("porUsuario") != null){

                this.setUsuario(request.getParameter("porUsuario"));
            }
            //si no existe un where previo
            //todo: validar como se relaciona el usuario con el cliente para agregar filtro
            System.out.println("Bandeda wher en usuario: " + banderaWhere);
            if(banderaWhere == 0){
                clausulaWhere = "where c.nombre like%'=" + persona + "'";
            }else{
                clausulaWhere = clausulaWhere + " and c.nombre like%'=" + persona + "'";
            }
        }*/

        //filtro por fecha
        if(request.getParameter("porFecha") != null){

            this.setPorFecha(Integer.parseInt(request.getParameter("porFecha")));
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

            if (request.getParameter("ano") != null
                    && request.getParameter("mes") != null){

                try {

                    String cadenaFecha = "01/" +
                            request.getParameter("mes") + "/" + request.getParameter("ano");
                    System.out.println("cadenaFecha: " + cadenaFecha);
                    this.setFecha(formater.parse(cadenaFecha));
                } catch (ParseException ex) {

                    System.out.print("error al parsear la fecha del filtro: " + ex.getMessage());
                }


            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(this.getFecha());
            cal.add(Calendar.DAY_OF_MONTH, 30);
            //si no existe un where previo
            System.out.println("Bandeda wher en fecha: " + banderaWhere);
            if(banderaWhere == 0){
                clausulaWhere = "where c.cliFecNac between STR_TO_DATE('"
                        + formater.format(this.getFecha()) + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + formater.format(cal.getTime()) + "', '%d/%m/%Y')";
            }else{
                clausulaWhere = clausulaWhere + " and c.cliFecNac between STR_TO_DATE('"
                        + formater.format(this.getFecha()) + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + formater.format(cal.getTime()) + "', '%d/%m/%Y')";
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
