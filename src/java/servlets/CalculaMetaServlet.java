/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import com.urbi.business.impl.CustomerImpl;
import com.urbi.business.impl.CustomerMetaImpl;
import com.urbi.business.interfaces.Customer;
import com.urbi.business.interfaces.CustomerMeta;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Cli;
import objetos.CliMta2;
import webservice.CalculadoraCMWS;
import webservice.CalculadoraNEWS;

/**
 *
 * @author alvarerr
 */
public class CalculaMetaServlet extends HttpServlet {

        private String apellidoPaterno;
    private String apellidoMaterno;
    private String Nombre;
    private String anno;
    private String mes;
    private String dia;
    private String edad;
    private String  calle;
    private String noExterior;
    private String noInterior;
    private String colonia;
    private String codigoPostal;
    private String estado;
    private String delegacionMunicipio;
    private String religion;
    private String sex;
    private String estadoCivil;
    private String nEstdio;
    private String tipoRes;
    private String tiempoVivienda;
    private String tiempoEmpleo;
    private String mov;
    private String prestamo;
    private String mejorPartido;
    private String relAfe;
    private String opinionApoDe;
    private String partAsoc;
    private String dependenciaEco;
    private String actividadExt;
    private String DineroExt;
    private String gastoImp;
    private String ingMens;
    private String rdgTC;
    private String rdgProblemaB;

    // arrRdgTC
    private String mesVencido;
    private String pcuso;
    private String pcPago;

    // arrRdgProblemaB
    private String buroAct;
    private String buroUso;
    private String buroHist;
    private String buroPago;
    private String buroAnt;
    private String RFC;


   //datos de la pantalla 3
   private int desarrollo;
   private int cliValViv;
   private int cliValMen;
   private int rol;
   private int tipoActividad;
   private int sector;
   private int subsector;

   //id para la modificacion
   private int idcli;

   private int cliMtaId;

    public String getDineroExt() {
        return DineroExt;
    }

    public void setDineroExt(String DineroExt) {
        this.DineroExt = DineroExt;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getActividadExt() {
        return actividadExt;
    }

    public void setActividadExt(String actividadExt) {
        this.actividadExt = actividadExt;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getBuroAct() {
        return buroAct;
    }

    public void setBuroAct(String buroAct) {
        this.buroAct = buroAct;
    }

    public String getBuroAnt() {
        return buroAnt;
    }

    public void setBuroAnt(String buroAnt) {
        this.buroAnt = buroAnt;
    }

    public String getBuroHist() {
        return buroHist;
    }

    public void setBuroHist(String buroHist) {
        this.buroHist = buroHist;
    }

    public String getBuroPago() {
        return buroPago;
    }

    public void setBuroPago(String buroPago) {
        this.buroPago = buroPago;
    }

    public String getBuroUso() {
        return buroUso;
    }

    public void setBuroUso(String buroUso) {
        this.buroUso = buroUso;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getCliMtaId() {
        return cliMtaId;
    }

    public void setCliMtaId(int cliMtaId) {
        this.cliMtaId = cliMtaId;
    }

    public int getCliValMen() {
        return cliValMen;
    }

    public void setCliValMen(int cliValMen) {
        this.cliValMen = cliValMen;
    }

    public int getCliValViv() {
        return cliValViv;
    }

    public void setCliValViv(int cliValViv) {
        this.cliValViv = cliValViv;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getDelegacionMunicipio() {
        return delegacionMunicipio;
    }

    public void setDelegacionMunicipio(String delegacionMunicipio) {
        this.delegacionMunicipio = delegacionMunicipio;
    }

    public String getDependenciaEco() {
        return dependenciaEco;
    }

    public void setDependenciaEco(String dependenciaEco) {
        this.dependenciaEco = dependenciaEco;
    }

    public int getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(int desarrollo) {
        this.desarrollo = desarrollo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getGastoImp() {
        return gastoImp;
    }

    public void setGastoImp(String gastoImp) {
        this.gastoImp = gastoImp;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getIngMens() {
        return ingMens;
    }

    public void setIngMens(String ingMens) {
        this.ingMens = ingMens;
    }

    public String getMejorPartido() {
        return mejorPartido;
    }

    public void setMejorPartido(String mejorPartido) {
        this.mejorPartido = mejorPartido;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getMesVencido() {
        return mesVencido;
    }

    public void setMesVencido(String mesVencido) {
        this.mesVencido = mesVencido;
    }

    public String getMov() {
        return mov;
    }

    public void setMov(String mov) {
        this.mov = mov;
    }

    public String getnEstdio() {
        return nEstdio;
    }

    public void setnEstdio(String nEstdio) {
        this.nEstdio = nEstdio;
    }

    public String getNoExterior() {
        return noExterior;
    }

    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    public String getNoInterior() {
        return noInterior;
    }

    public void setNoInterior(String noInterior) {
        this.noInterior = noInterior;
    }

    public String getOpinionApoDe() {
        return opinionApoDe;
    }

    public void setOpinionApoDe(String opinionApoDe) {
        this.opinionApoDe = opinionApoDe;
    }

    public String getPartAsoc() {
        return partAsoc;
    }

    public void setPartAsoc(String partAsoc) {
        this.partAsoc = partAsoc;
    }

    public String getPcPago() {
        return pcPago;
    }

    public void setPcPago(String pcPago) {
        this.pcPago = pcPago;
    }

    public String getPcuso() {
        return pcuso;
    }

    public void setPcuso(String pcuso) {
        this.pcuso = pcuso;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

    public String getRdgProblemaB() {
        return rdgProblemaB;
    }

    public void setRdgProblemaB(String rdgProblemaB) {
        this.rdgProblemaB = rdgProblemaB;
    }

    public String getRdgTC() {
        return rdgTC;
    }

    public void setRdgTC(String rdgTC) {
        this.rdgTC = rdgTC;
    }

    public String getRelAfe() {
        return relAfe;
    }

    public void setRelAfe(String relAfe) {
        this.relAfe = relAfe;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSubsector() {
        return subsector;
    }

    public void setSubsector(int subsector) {
        this.subsector = subsector;
    }

    public String getTiempoEmpleo() {
        return tiempoEmpleo;
    }

    public void setTiempoEmpleo(String tiempoEmpleo) {
        this.tiempoEmpleo = tiempoEmpleo;
    }

    public String getTiempoVivienda() {
        return tiempoVivienda;
    }

    public void setTiempoVivienda(String tiempoVivienda) {
        this.tiempoVivienda = tiempoVivienda;
    }

    public int getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(int tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getTipoRes() {
        return tipoRes;
    }

    public void setTipoRes(String tipoRes) {
        this.tipoRes = tipoRes;
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
            out.println("<title>Servlet CalculaMetaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculaMetaServlet at " + request.getContextPath () + "</h1>");
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
        doPost(request, response);
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
           command = request.getParameter("idCliente");
           //form = request.getParameter("form");

       } finally {

           if(command != null){

               CustomerMeta metaService = new CustomerMetaImpl();
               Customer cliService = new CustomerImpl();
               Cli cli = cliService.getCustomerByID(Integer.parseInt(command));
               CliMta2 cliMta2 = metaService.getCustomerMeta(Integer.parseInt(command));
               int banderaCredito = 0;

               if(cliMta2.getBanCmpId() != 0)
                   banderaCredito = 1;

               SimpleDateFormat formater = new SimpleDateFormat("dd/mm/yyyy");
               Date fecha = new Date();
               System.out.println(fecha);
               String[] arrayFecha = formater.format(fecha).split("/");
          
             String xmlInputNE="<?xml version='1.0' encoding='UTF-8' standalone='no'?>" +
                     "<EntradaCalculadoraCM>" +
                     "<CLI_ID>"+ cli.getCliId() +"</CLI_ID>" +
                     "<CLI_SAP>0</CLI_SAP>" +

                     //"<CAL_ID>"+ cli.getCalId() +"</CAL_ID>" +
                     "<CLI_APE_PAT>"+ cli.getCliApePat() +"</CLI_APE_PAT>" +
                     "<CLI_APE_MAT>"+ cli.getCliApeMat() + "</CLI_APE_MAT>" +
                     "<CLI_NOM>"+ cli.getCliNom() +"</CLI_NOM>" +
                     "<CLI_FEC_NAC>"+ cli.getCliFecNac() +"</CLI_FEC_NAC>" +
                     //"<CLI_FEC_NAC>23/06/1989</CLI_FEC_NAC>"+
                     "<CLI_DOM_CAL>" + cli.getCliDomCal() +"</CLI_DOM_CAL>" +
                     "<CLI_DOM_NUM_EXT>" + cli.getCliDomNumExt() +"</CLI_DOM_NUM_EXT>" +
                     "<CLI_DOM_NUM_INT>"+ cli.getCliDomNumInt() +"</CLI_DOM_NUM_INT>" +
                     "<CLI_DOM_COL>"+ cli.getCliDomCol() +"</CLI_DOM_COL>" +
                     "<COD_POS_ID>"+ cli.getCodPosId() +"</COD_POS_ID>" +
                     "<GENERO>"+ cliMta2.getSexId() +"</GENERO>" +
                     "<ESTADO_CIVIL>" +cliMta2.getEdoCvlId()+"</ESTADO_CIVIL>" +
                     "<TIPO_RESIDENCIA>"+ cliMta2.getTipResId() +"</TIPO_RESIDENCIA>" +
                     "<DEPENDIENTES>"+ cliMta2.getDepEcoId() +"</DEPENDIENTES>" +
                     "<INGRESO>"+ cliMta2.getIngId() +"</INGRESO>" +
                     "<EDAD>"+ cli.getCliEdad() +"</EDAD>" +
                     "<TIEMPO_RESIDENCIA>"+ cliMta2.getTipResId() +"</TIEMPO_RESIDENCIA>" +
                     "<ANTIGUEDAD>"+ cliMta2.getTipEmpId() +"</ANTIGUEDAD>" +
                     "<DINERO_EXTRA>"+ cliMta2.getDinExtId() +"</DINERO_EXTRA>" +
                     "<GASTO_PROXIMO>"+ cliMta2.getProAnoGtoId() +"</GASTO_PROXIMO>" +
                     "<NIVEL_ESCOLAR>"+ cliMta2.getNivEstId() +"</NIVEL_ESCOLAR>" +
                     "<ACT_EXTRA>"+ cliMta2.getActExtId() +"</ACT_EXTRA>" +
                     "<PRESTAMO>"+ cliMta2.getPtmId() +"</PRESTAMO>" +
                     "<RELIGION>"+ cliMta2.getRelId() +"</RELIGION>" +
                     "<INFLUENCIA_RELIGION>"+ cliMta2.getRldId() +"</INFLUENCIA_RELIGION>" +
                     "<ASOCIACION_PARTIDO>"+ cliMta2.getAsoParId() +"</ASOCIACION_PARTIDO>" +
                     "<PARTIDO_POL>"+ cliMta2.getParPltId() +"</PARTIDO_POL>" +
                     "<IND_OPINION_BARZON>"+ cliMta2.getOpnBarId() +"</IND_OPINION_BARZON>" +
                     "<MIGRACION>"+ cliMta2.getMigId() +"</MIGRACION>" +
                     "<COMPORTAMIENTO_CREDITO>0</COMPORTAMIENTO_CREDITO>" +
                     "<ACT>0</ACT>" +
                     "<HIST>0</HIST>" +
                     "<ANT>0</ANT>" +
                     "<USO>0</USO>" +
                     "<PAGO>0</PAGO>" +
                     "<CREDITO>"+ banderaCredito +"</CREDITO>" +
                     "<MES_VENCIDO>"+ cliMta2.getBanCmpId() +"</MES_VENCIDO>" +
                     "<PC_PAGO>"+ cliMta2.getBanPorPagId() +"</PC_PAGO>" +
                     "<PC_USO>"+ cliMta2.getBanPorUsoId() +"</PC_USO>" +
                     "<OCUPACION>"+ cliMta2.getOcpId() +"</OCUPACION>" +
                     "<ESTADO>"+ cliMta2.getEdoId() +"</ESTADO>" +
                     "<VALOR_VIVIENDA>"+ cliMta2.getCliValViv() +"</VALOR_VIVIENDA>" +
                     "<CUOTA>"+ cliMta2.getCliValMen() +"</CUOTA>" +
                     "<FECHA>1</FECHA>" +
                     "</EntradaCalculadoraCM>";

            /* String xmlInputNE="<?xml version='1.0' encoding='UTF-8' standalone='no'?>" +
                     "<EntradaCalculadoraCM>" +
                     "<CLI_ID>1</CLI_ID>" +
                     "<CLI_SAP>1</CLI_SAP>" +
                     "<CAL_ID>1</CAL_ID>" +
                     "<CLI_APE_PAT>A</CLI_APE_PAT>" +
                     "<CLI_APE_MAT>AA</CLI_APE_MAT>" +
                     "<CLI_NOM>BETOAA</CLI_NOM>" +
                     "<CLI_FEC_NAC>23/06/1989</CLI_FEC_NAC>" +
                     "<CLI_DOM_CAL>AABBCC</CLI_DOM_CAL>" +
                     "<CLI_DOM_NUM_EXT>11</CLI_DOM_NUM_EXT>" +
                     "<CLI_DOM_NUM_INT>111</CLI_DOM_NUM_INT>" +
                     "<CLI_DOM_COL>AA</CLI_DOM_COL>" +
                     "<COD_POS_ID>55000</COD_POS_ID>" +
                     "<GENERO>2</GENERO>" +
                     "<ESTADO_CIVIL>2</ESTADO_CIVIL>" +
                     "<TIPO_RESIDENCIA>3</TIPO_RESIDENCIA>" +
                     "<DEPENDIENTES>3</DEPENDIENTES>" +
                     "<INGRESO>3</INGRESO>" +
                     "<EDAD>20</EDAD>" +
                     "<TIEMPO_RESIDENCIA>2</TIEMPO_RESIDENCIA>" +
                     "<ANTIGUEDAD>2</ANTIGUEDAD>" +
                     "<DINERO_EXTRA>3</DINERO_EXTRA>" +
                     "<GASTO_PROXIMO>3</GASTO_PROXIMO>" +
                     "<NIVEL_ESCOLAR>2</NIVEL_ESCOLAR>" +
                     "<ACT_EXTRA>3</ACT_EXTRA>" +
                     "<PRESTAMO>3</PRESTAMO>" +
                     "<RELIGION>2</RELIGION>" +
                     "<INFLUENCIA_RELIGION>3</INFLUENCIA_RELIGION>" +
                     "<ASOCIACION_PARTIDO>3</ASOCIACION_PARTIDO>" +
                     "<PARTIDO_POL>3</PARTIDO_POL>" +
                     "<IND_OPINION_BARZON>3</IND_OPINION_BARZON>" +
                     "<MIGRACION>2</MIGRACION>" +
                     "<COMPORTAMIENTO_CREDITO>1</COMPORTAMIENTO_CREDITO>" +
                     "<ACT>1</ACT>" +
                     "<HIST>1</HIST>" +
                     "<ANT>1</ANT>" +
                     "<USO>3</USO>" +
                     "<PAGO>2</PAGO>" +
                     "<CREDITO>1</CREDITO>" +
                     "<MES_VENCIDO>1</MES_VENCIDO>" +
                     "<PC_PAGO>2</PC_PAGO>" +
                     "<PC_USO>1</PC_USO>" +
                     "<OCUPACION>122</OCUPACION>" +
                     "<ESTADO>2</ESTADO>" +
                     "<VALOR_VIVIENDA>100000</VALOR_VIVIENDA>" +
                     "<CUOTA>1000</CUOTA>" +
                     "<FECHA>1</FECHA>" +
                     "</EntradaCalculadoraCM>";*/


            CalculadoraCMWS ne = new CalculadoraCMWS();


            System.out.println("-->> XML FORMADO EN EL SERVLET");
            System.out.println("--"+ xmlInputNE +"-->");

            /*PrintWriter out = response.getWriter();

            out.print("<PRE>");
            out.print(ne.CalculaCM(xmlInputNE));
            out.print("</PRE>");
            out.flush();
            out.close();*/

            String str = new String (ne.CalculaCM(xmlInputNE));
            str = str.trim();
            str = str.toLowerCase();

            System.out.println("cadena xml: " + str);
            try{
            String genero = str.substring(str.indexOf("<suma_genero_clase>") + 19,str.indexOf("</suma_genero_clase>"));
            String comportamiento = str.substring(str.indexOf("<suma_comportamiento_pago>") + 26, str.indexOf("</suma_comportamiento_pago>"));
            String arraigo = str.substring(str.indexOf("<suma_arraigo>") + 14,str.indexOf("</suma_arraigo>"));
            String aspDif = str.substring(str.indexOf("<suma_aspectos_diferenciadores>") + 31, str.indexOf("</suma_aspectos_diferenciadores>"));

            String generoTexto1 = "";
            if (str.indexOf("<genero_clase_texto1/>")==-1 )
                generoTexto1 =generoTexto1 = str.substring(str.indexOf("<genero_clase_texto1>") + 21,str.indexOf("</genero_clase_texto1>"));
            else
                generoTexto1 = "";

            String generoTexto2 = "";
            if (str.indexOf("<genero_clase_texto2/>")==-1 )
                generoTexto2 = str.substring(str.indexOf("<genero_clase_texto2>") + 21, str.indexOf("</genero_clase_texto2>"));
            else
                generoTexto2 = "";


            String compTexto1 = "";
            if (str.indexOf("<comportamiento_pago_texto1/>")==-1 )
                compTexto1 = str.substring(str.indexOf("<comportamiento_pago_texto1>") + 28, str.indexOf("</comportamiento_pago_texto1>"));
            else
                compTexto1 = "";

            String compTexto2 = "";
            if (str.indexOf("<comportamiento_pago_texto2/>")==-1 )
                compTexto2 = str.substring(str.indexOf("<comportamiento_pago_texto2>") + 28, str.indexOf("</comportamiento_pago_texto2>"));
            else
                compTexto2 = "";

            String arraigoTexto1 = "";
            if (str.indexOf("<arraigo_texto1/>")==-1 )
                arraigoTexto1 = str.substring(str.indexOf("<arraigo_texto1>") + 16, str.indexOf("</arraigo_texto1>"));
            else
                arraigoTexto1 = "";

            String arraigoTexto2 = "";
            if (str.indexOf("<arraigo_texto2/>")==-1 )
                arraigoTexto2 = str.substring(str.indexOf("<arraigo_texto2>") + 16, str.indexOf("</arraigo_texto2>"));
            else
                arraigoTexto2 = "";

            String aspDifTexto1 = "";
            if (str.indexOf("<aspectos_diferenciadores_texto1/>")==-1 )
                aspDifTexto1 = str.substring(str.indexOf("<aspectos_diferenciadores_texto1>") + 33, str.indexOf("</aspectos_diferenciadores_texto1>"));
            else
                aspDifTexto1 = "";

            String aspDifTexto2 = "";
            if (str.indexOf("<aspectos_diferenciadores_texto2/>")==-1 )
                aspDifTexto2 = str.substring(str.indexOf("<aspectos_diferenciadores_texto2>") + 33, str.indexOf("</aspectos_diferenciadores_texto2>"));
            else
                aspDifTexto2 = "";

    //       String cuotaPura = str.substring(str.indexOf("<cuota_pura_riesgo>") + 19, str.indexOf("</cuota_pura_riesgo>"));
     //       String cuotaRecar = str.substring(str.indexOf("<cuota_recargadad>") + 18, str.indexOf("</cuota_recargadad>"));
     //       String primaPura = str.substring(str.indexOf("<prima_pura_riesgo>") + 19, str.indexOf("</prima_pura_riesgo>"));
     //       String primaPuraRec = str.substring(str.indexOf("<prima_pura_rieso_recargada>") + 28, str.indexOf("</prima_pura_rieso_recargada>"));
            String resultado = str.substring(str.indexOf("<resultado>") + 11, str.indexOf("</resultado>"));

       //     cuotaPura = (Double.parseDouble(cuotaPura) * 100 ) + "%";
       //     request.getSession().getAttribute("cuotaPura") != nullcuotaRecar = (Double.parseDouble(cuotaRecar) * 100 ) + "%";
            System.out.println("comparacion de genero: " + Double.compare(Double.parseDouble(genero.trim()), 150.0));
            if(genero != ""){
                if(Double.compare(Double.parseDouble(genero.trim()), 150.0) > 0){

                    genero = "150";

                }else if(Double.compare(Double.parseDouble(genero.trim()), -150.0) < 0){
                    genero = "-150";
                }
            }

            if(comportamiento != ""){
                if(Double.compare(Double.parseDouble(comportamiento.trim()), 150.0) > 0){

                    comportamiento = "150";
                }else if(Double.compare(Double.parseDouble(comportamiento.trim()), -150.0) < 0){
                    comportamiento = "-150";
                }
            }


            if(arraigo != ""){
                if(Double.compare(Double.parseDouble(arraigo.trim()),150.0) > 0 ){

                    arraigo = "150";
                }else if(Double.compare(Double.parseDouble(arraigo.trim()), -150) < 0){
                    arraigo = "-150";
                }
            }

            if(aspDif != ""){
                if(Double.compare(Double.parseDouble(aspDif.trim()), 150.0) > 0){

                    aspDif = "150";
                }else if(Double.compare(Double.parseDouble(aspDif.trim()), -150.0) < 0){
                    aspDif = "-150";
                }
            }


            System.out.print("genero: " + genero);
            System.out.print("comportamiento: " + comportamiento);
            System.out.print("arraigo: " + arraigo);
            System.out.print("aspDif: " + aspDif);
            System.out.print("generoTexto1: " + generoTexto1);
            System.out.print("generoTexto2: " + generoTexto2);
            System.out.print("compTexto1: " + compTexto1);
            System.out.print("compTexto2: " + compTexto2);
            System.out.print("arraigoTexto1: " + arraigoTexto1);
            System.out.print("arraigoTexto2: " + arraigoTexto2);
            System.out.print("aspDifTexto1: " + aspDifTexto1);
            System.out.print("aspDifTexto2: " + aspDifTexto2);
     //       System.out.print("cuotaPura: " + cuotaPura);
     //       System.out.print("cuotaRecar: " + cuotaRecar);
     //       System.out.print("primaPura: " + primaPura);
     //       System.out.print("primaPuraRec: " + primaPuraRec);
           
            System.out.println("-->>>><newStr ---- <<<<<<---");
            System.out.println(str);
            System.out.println ("-->>>>newStr< ---- <<<<<<---");

            if(request.getSession().getAttribute("genero") != null)
                request.getSession().removeAttribute("genero");

            if(request.getSession().getAttribute("comportamiento") != null)
                request.getSession().removeAttribute("comportamiento");

            if(request.getSession().getAttribute("arraigo") != null)
                request.getSession().removeAttribute("arraigo");

            if(request.getSession().getAttribute("aspDif") != null)
                request.getSession().removeAttribute("aspDif");

            if(request.getSession().getAttribute("generoTexto1") != null)
                request.getSession().removeAttribute("generoTexto1");

            if(request.getSession().getAttribute("generoTexto2") != null)
                request.getSession().removeAttribute("generoTexto2");

            if(request.getSession().getAttribute("compTexto1") != null)
                request.getSession().removeAttribute("compTexto1");

            if(request.getSession().getAttribute("compTexto2") != null)
                request.getSession().removeAttribute("compTexto2");

            if(request.getSession().getAttribute("arraigoTexto1") != null)
                request.getSession().removeAttribute("arraigoTexto1");

            if(request.getSession().getAttribute("arraigoTexto2") != null)
                request.getSession().removeAttribute("arraigoTexto2");

            if(request.getSession().getAttribute("aspDifTexto1") != null)
                request.getSession().removeAttribute("aspDifTexto1");

            if(request.getSession().getAttribute("aspDifTexto2") != null)
                request.getSession().removeAttribute("aspDifTexto2");

            if(request.getSession().getAttribute("cuotaPura") != null)
                request.getSession().removeAttribute("cuotaPura");

            if(request.getSession().getAttribute("cuotaRecar") != null)
                request.getSession().removeAttribute("cuotaRecar");

            if(request.getSession().getAttribute("primaPura") != null)
                request.getSession().removeAttribute("primaPura");

            if(request.getSession().getAttribute("primaPuraRec") != null)
                request.getSession().removeAttribute("primaPuraRec");

            if(request.getSession().getAttribute("idCli") != null)
                request.getSession().removeAttribute("idcli");

             if(request.getSession().getAttribute("resultado") != null)
                request.getSession().removeAttribute("resultado");


            request.getSession().setAttribute("genero", genero.toUpperCase());
            request.getSession().setAttribute("comportamiento", comportamiento.toUpperCase());
            request.getSession().setAttribute("arraigo", arraigo.toUpperCase());
            request.getSession().setAttribute("aspDif", aspDif.toUpperCase());
            request.getSession().setAttribute("generoTexto1", generoTexto1.toUpperCase());
            request.getSession().setAttribute("generoTexto2", generoTexto2.toUpperCase());
            request.getSession().setAttribute("compTexto1", compTexto1.toUpperCase());
            request.getSession().setAttribute("compTexto2", compTexto2.toUpperCase());
            request.getSession().setAttribute("arraigoTexto1", arraigoTexto1.toUpperCase());
            request.getSession().setAttribute("arraigoTexto2", arraigoTexto2.toUpperCase());
            request.getSession().setAttribute("aspDifTexto1", aspDifTexto1.toUpperCase());
            request.getSession().setAttribute("aspDifTexto2", aspDifTexto2.toUpperCase());
   //         request.getSession().setAttribute("cuotaPura", cuotaPura);
   //         request.getSession().setAttribute("cuotaRecar", cuotaRecar);
   //         request.getSession().setAttribute("primaPura", primaPura);
   //         request.getSession().setAttribute("primaPuraRec", primaPuraRec);

            request.getSession().setAttribute("idCli", command.toUpperCase());
            request.getSession().setAttribute("resultado", resultado.toUpperCase());


            response.sendRedirect("./meta/calcmeta.jsp");
            }catch(Exception e){
                e.printStackTrace();
            }

            
            
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

}
