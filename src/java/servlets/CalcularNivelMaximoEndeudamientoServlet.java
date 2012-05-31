/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.CalculadoraNEWS;

/**
 *
 * @author Errol
 */
public class CalcularNivelMaximoEndeudamientoServlet extends HttpServlet {
   
    


private String CliId = "0";
private String CliSap = "0";

private String apellidoPaterno ="";
private String apellidoMaterno ="";
private String nombre ="";

private String fechaNac="";




private String DineroExt ;
private String anno  ;
private String calle ;
private String codigoPostal	 ;
private String colonia	 ;
private String delegacion ;
private String dia  ;
private String edad ;
private String estado ;
private String estadoCivil ;
private String gastoImp  ;
private String habitaViviendaActual	 ;
private String ingreso	 ;
private String laboraEmpleoActual	 ;
private String mes  ;
private String noExterior	 ;
private String noInterior	 ;
private String periodoPago	 ;
private String sexo  ;
private String tasa ;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       // response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalcularNivelMaximoEndeudamientoServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalcularNivelMaximoEndeudamientoServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
           // out.close();
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

        
 
       //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

       String command = null;
       String form = null;
      try {
           command = request.getParameter("command");
           form = request.getParameter("form");

       } finally {
          if(command.equalsIgnoreCase("NivelEndeudamiento") &&
form.equalsIgnoreCase("entradaDeuda")){

              request.getSession().setAttribute("accion", "calcular");

        this.setNombre(request.getParameter("nombre"));
        this.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        this.setApellidoMaterno(request.getParameter("apellidoMaterno"));

        this.setFechaNac(request.getParameter("anio")+"-"+request.getParameter("mes")+"-"+request.getParameter("dia"));

        this.setDineroExt(request.getParameter("DineroExt"));

        //EAAR: Se actualiza nombre parametro de anno a anio
        this.setAnno(request.getParameter("anio"));

        this.setCalle(request.getParameter("calle"));
        this.setCodigoPostal(request.getParameter("codigoPostal"));
        this.setColonia(request.getParameter("colonia"));
        this.setDelegacion(request.getParameter("delegacion"));
        this.setDia(request.getParameter("dia"));
        this.setEdad(request.getParameter("edad"));
        this.setEstado(request.getParameter("estado"));
        this.setEstadoCivil(request.getParameter("estadoCivil"));
        this.setGastoImp(request.getParameter("gastoImp"));
        this.setHabitaViviendaActual(request.getParameter("habitaViviendaActual"));
        this.setIngreso(request.getParameter("ingreso"));
        this.setLaboraEmpleoActual(request.getParameter("laboraEmpleoActual"));
        this.setMes(request.getParameter("mes"));
        this.setNoExterior(request.getParameter("noExterior"));
        this.setNoInterior(request.getParameter("noInterior"));
        this.setPeriodoPago(request.getParameter("periodoPago"));
        this.setSexo(request.getParameter("sexo"));
        this.setTasa(request.getParameter("tasa"));

        System.out.println(" ->>>>> "+request.getParameter("ingreso") +" "+
                            request.getParameter("tasa")+" "+
                            request.getParameter("periodoPago"));

        //String valorArchivoBehavior = new String(archivoData);

String xmlInputNE = "<?xml version='1.0' encoding='UTF-8' standalone='no'?>"+
"<EntradaCalculadoraNE>"+
    "<CLI_ID>"+ this.getCliId() +"</CLI_ID>"+
    "<CLI_SAP>"+ this.getCliSap() +"</CLI_SAP>"+
    "<CLI_APE_PAT>"+ this.getApellidoPaterno() +"</CLI_APE_PAT>"+
    "<CLI_APE_MAT>"+ this.getApellidoMaterno() + "</CLI_APE_MAT>"+
    "<CLI_NOM>"+this.getNombre() +"</CLI_NOM>"+
    "<CLI_FEC_NAC>"+ this.getFechaNac() +"</CLI_FEC_NAC>"+
    "<CLI_DOM_CAL>" + this.getCalle() +"</CLI_DOM_CAL>"+
    "<CLI_DOM_NUM_EXT>" + this.getNoExterior() +"</CLI_DOM_NUM_EXT>"+
    "<CLI_DOM_NUM_INT>"+ this.getNoInterior()+"</CLI_DOM_NUM_INT>"+
    "<CLI_DOM_COL>"+ this.getColonia()+"</CLI_DOM_COL>"+
    "<CLI_POS_ID>"+ this.getCodigoPostal()+"</CLI_POS_ID>"+
    "<INGRESO>"+ this.getIngreso()+"</INGRESO>"+
    "<TASA>" +this.getTasa()+"</TASA>"+
    "<CUPON>"+this.getPeriodoPago()+"</CUPON>"+
"</EntradaCalculadoraNE>";

        CalculadoraNEWS ne = new CalculadoraNEWS ();


        System.out.println("-->> XML FORMADO EN EL SERVLET");
        System.out.println("--"+ ne.CalculaNE(xmlInputNE)+"-->");

        PrintWriter out = response.getWriter();

        out.print("<PRE>");
        out.print(ne.CalculaNE(xmlInputNE));
        out.print("</PRE>");
	out.flush();
	out.close();
         

         //request.getSession().setAttribute("strXMLCalculaNE", "<PRE>"+ne.CalculaNE(xmlInputNE)+"</PRE>");

      //  request.getSession().setAttribute("strXMLCalculaNE", ne.CalculaNE(xmlInputNE));

        String str = new String (ne.CalculaNE(xmlInputNE));
        str = str.trim();
        str = str.toLowerCase();
        String newStr = str.replace("\n", "");

        newStr = str.replace("\"", "\'");

        newStr = str.replaceAll("[\"]","\'");



        System.out.println("-->>>><newStr ---- <<<<<<---");
        System.out.println(newStr);
        System.out.println ("-->>>>newStr< ---- <<<<<<---");

                request.getSession().setAttribute("jsonParams", newStr.replaceAll("[\r\n]", "")  );

       /*  PrintWriter out = response.getWriter();

        out.print("{'resultado':'1'}");
        //out.print(ne.CalculaNE(xmlInputNE));
        out.print("}");
	out.flush();
	out.close();
*/
               //response.sendRedirect("/URBI_PP/endeudamiento/salidadeuda.jsp");

     //
         /*String destination = "/URBI_PP/endeudamiento/salidadeuda.jsp";

		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
return;*/


//return;


           }else
               if(command.equalsIgnoreCase("Siguiente") &&
form.equalsIgnoreCase("ClienteMeta")){
                   //request.getSession().setAttribute("accion", "Agregar");
                   request.getSession().setAttribute("accion", "agregar");
                   response.sendRedirect("./endeudamiento/entradadeuda.jsp");
           }
       }


       //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * @return the DineroExt
     */
    public String getDineroExt() {
        return DineroExt;
    }

    /**
     * @param DineroExt the DineroExt to set
     */
    public void setDineroExt(String DineroExt) {
        this.DineroExt = DineroExt;
    }

    /**
     * @return the anno
     */
    public String getAnno() {
        return anno;
    }

    /**
     * @param anno the anno to set
     */
    public void setAnno(String anno) {
        this.anno = anno;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the delegacion
     */
    public String getDelegacion() {
        return delegacion;
    }

    /**
     * @param delegacion the delegacion to set
     */
    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * @return the edad
     */
    public String getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the gastoImp
     */
    public String getGastoImp() {
        return gastoImp;
    }

    /**
     * @param gastoImp the gastoImp to set
     */
    public void setGastoImp(String gastoImp) {
        this.gastoImp = gastoImp;
    }

    /**
     * @return the habitaViviendaActual
     */
    public String getHabitaViviendaActual() {
        return habitaViviendaActual;
    }

    /**
     * @param habitaViviendaActual the habitaViviendaActual to set
     */
    public void setHabitaViviendaActual(String habitaViviendaActual) {
        this.habitaViviendaActual = habitaViviendaActual;
    }

    /**
     * @return the ingreso
     */
    public String getIngreso() {
        return ingreso;
    }

    /**
     * @param ingreso the ingreso to set
     */
    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * @return the laboraEmpleoActual
     */
    public String getLaboraEmpleoActual() {
        return laboraEmpleoActual;
    }

    /**
     * @param laboraEmpleoActual the laboraEmpleoActual to set
     */
    public void setLaboraEmpleoActual(String laboraEmpleoActual) {
        this.laboraEmpleoActual = laboraEmpleoActual;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the noExterior
     */
    public String getNoExterior() {
        return noExterior;
    }

    /**
     * @param noExterior the noExterior to set
     */
    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    /**
     * @return the noInterior
     */
    public String getNoInterior() {
        return noInterior;
    }

    /**
     * @param noInterior the noInterior to set
     */
    public void setNoInterior(String noInterior) {
        this.noInterior = noInterior;
    }

    /**
     * @return the periodoPago
     */
    public String getPeriodoPago() {
        return periodoPago;
    }

    /**
     * @param periodoPago the periodoPago to set
     */
    public void setPeriodoPago(String periodoPago) {
        this.periodoPago = periodoPago;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the tasa
     */
    public String getTasa() {
        return tasa;
    }

    /**
     * @param tasa the tasa to set
     */
    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    /**
     * @return the CliId
     */
    public String getCliId() {
        return CliId;
    }

    /**
     * @param CliId the CliId to set
     */
    public void setCliId(String CliId) {
        this.CliId = CliId;
    }

    /**
     * @return the CliSap
     */
    public String getCliSap() {
        return CliSap;
    }

    /**
     * @param CliSap the CliSap to set
     */
    public void setCliSap(String CliSap) {
        this.CliSap = CliSap;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaNac
     */
    public String getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

}
