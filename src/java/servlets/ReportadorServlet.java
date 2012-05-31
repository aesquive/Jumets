/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import com.urbi.dao.impl.Dao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Cli;
import objetos.CliGol;

/**
 *
 * @author msi
 */
public class ReportadorServlet extends HttpServlet {


    private void escribeVars(String cabecera, List vars, String archivo) throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
        writer.write(cabecera);
        writer.newLine();

        for(Object var: vars){

            writer.write(String.valueOf(var));
            writer.newLine();
        }
        writer.close();

    }


    private void imprime(List list, HttpServletResponse response){

        for(Object s:list){
            try {
                response.getWriter().print(String.valueOf(s));
                response.getWriter().print("<br>");
            } catch (IOException ex) {
                Logger.getLogger(ReportadorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
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


            List[] reporte = reporta();

/**    String ruta = "/home/modelo/appservers/apache-tomcat-6x/webapps/AU_repor/reportes/";


    escribeVars("NOMBRE,GENERO_DES,GENERO_FACTOR , FRECUENCIA_RELIGION_DES,FRECUENCIA_RELIGION_FACTOR,SITUACION_PROXIMO_ANO_DES,SITUACION_PROXIMO_ANO_FACTOR ,DINERO_EXTRA_DES,DINERO_EXTRA_FACTOR, VIVIENDA_ACTUAL_DES,VIVIENDA_ACTUAL_FACTOR ,SERVICIO_HOGAR_DES,SERVICIO_HOGAR_FACTOR,ACT_DES,ACT_FACTOR,BUR_USO_DES,BUR_USO_FACTOR,CUEN_ABIER_CAT_DES,CUEN_ABIER_CAT_FACTOR,VALOR_VIVIENDA_DES,VALOR_VIVIENDA_FACTOR,NO_CREDITOS_DES,NO_CREDITOS_FACTOR,SCORE_IPSICO_FACTOR,I_PSICO_FACTOR,SCORE_HIT_FACTOR, ESTADO",
            reporte[0], ruta + "Hit.csv");
    response.getWriter().print("<a href='./reportes/Hit.csv'>Hit</a>");
    response.getWriter().print("<br>");


    escribeVars("NOMBRE,RELIGION_DESCRIPCION,RELIGION_FACTOR, ESCOLARIDAD_DESCRIPCION, ESCOLARIDAD_FACTOR,TRABAJO_ANTERIOR_DESCRIPCION,TRABAJO_ANTERIOR_FACTOR, DINERO_EXTRA_DESCRIPCION, DINERO_EXTRA_FACTOR, INGRESO_TOTAL_DESCRIPCION, INGRESO_TOTAL_FACTOR ,GASTOS_DESCRIPCION,GASTOS_FACTOR ,CUBRIR_ALIMETOS_DESCRIPCION,CUBRIR_ALIMETOS_FACTOR,VESTIDO_DESCRIPCION,VESTIDO_FACTOR,SERVICIOS_VIVIENDA_DESCRIPCION,SERVICIOS_VIVIENDA_FACTOR,RENTA_DESCRIPCION,RENTA_FACTOR, SERVICIO_HOGAR_DESCRIPCION, SERVICIO_HOGAR_FACTOR,PRINCIPAL_PROBLEMA_DESCRIPCION,PRINCIPAL_PROBLEMA_FACTOR, SOLICITAR_PRESTAMO_DESCRIPCION, SOLICITAR_PRESTAMO_FACTOR,VCS_VIV_FACTOR,I_RENTA_DESCRIPCION,I_RENTA_FACTOR, VALOR_VIVIENDA_DESCRIPCION, VALOR_VIVIENDA_FACTOR,NO_CREDITOS_DESCRIPCION, NO_CREDITOS_FACTOR,I_PSICO_SUMA,I_PSICO_FACTOR, SCORE FINAL, ESTADO",
            reporte[1], ruta + "NoHit.csv");
    response.getWriter().print("<a href='./reportes/NoHit.csv'>No Hit</a>");
    response.getWriter().print("<br>");

    escribeVars("Nombre,ACT_TEXTO,ACT_DES,HIST_TEXTO,HIST_DES,ANT_TEXTO,ANT_DES,USO_TEXTO,USO_DES,PAGO_TEXTO,PAGO_DES,SCORE_BURO, ESTADO",
            reporte[2], ruta + "Buro.csv");
    response.getWriter().print("<a href='./reportes/Buro.csv'>Buro</a>");


*/
            imprimirLista(reporte);
        // Impresion en consola
//         List[] reporte=reporta();
  //      imprimirLista(reporte);
        
        
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


    public List[] reporta(){

            NuevoReportador r = new NuevoReportador();

            List[] calculo=r.calculaTodos();


            return calculo;
        }   

    private void imprimirLista(List[] reporte) {

        System.out.println("hit");

        for(Object var :reporte[0]){
            System.out.println(var);
        }

        System.out.println("no hit");

        for(Object var :reporte[1]){
            System.out.println(var);
        }


        System.out.println("buro");
        for(Object var :reporte[2]){
            System.out.println(var);
        }
    }



    private static CliGol obtenerClienteGol(int i) {
        Dao dao=new Dao();

        CliGol gol=(CliGol)dao.get("CliGol", "cliGolId="+String.valueOf(i));

        return gol;
    }

    private static Cli obtenerCli(int i) {

        Dao dao=new Dao();

        Cli gol=(Cli)dao.get("CliGol", "cliGolId="+String.valueOf(i));

        return gol;
    }

    private void imprimirLista(List[] reporte, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();

            out.print("hit");
            for (Object var : reporte[0]) {
               out.print(var);
            }
            out.print("no hit");
            for (Object var : reporte[1]) {
                out.print(var);
            }
            out.print("buro");
            for (Object var : reporte[2]) {
                out.print(var);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportadorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }

}
