/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import arbitreadores.objetos.ArbMta;
import arbitreadores.verificador.VerificadorArbitrajeMeta;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// -->>>>>>>> ClienteMeta
import com.urbi.service.dispatchService.*;
import com.urbi.utilerias.dao.Usuarios;

import com.urbi.utils.valueobject.CustomerValueObject.*;


import com.urbi.utils.valueobject.ProcessValueObject.*;

import com.urbi.utils.valueobject.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import objetos.Cli;
import objetos.CliMta2;

/**
 *
 * @author ydt
 */
public class AgregarMetaServlet extends HttpServlet {

    private String apellidoPaterno;
    private String apellidoMaterno;
    private String Nombre;
    private String anno;
    private String mes;
    private String dia;
    private String edad;
    private String calle;
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

    public String getRFC() {

        return RFC;

    }

    public int getCliMtaId() {
        return cliMtaId;
    }

    public void setCliMtaId(int cliMtaId) {
        this.cliMtaId = cliMtaId;
    }

    public void setRFC(String rfc) {

        RFC = rfc;

    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
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

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDelegacionMunicipio() {
        return delegacionMunicipio;
    }

    public void setDelegacionMunicipio(String delegacionMunicipio) {
        this.delegacionMunicipio = delegacionMunicipio;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNEstdio() {
        return nEstdio;
    }

    public void setNEstdio(String estdio) {
        nEstdio = estdio;
    }

    public String getTipoRes() {
        return tipoRes;
    }

    public void setTipoRes(String tipoRes) {
        this.tipoRes = tipoRes;
    }

    public String getTiempoVivienda() {
        return tiempoVivienda;
    }

    public void setTiempoVivienda(String tiempoVivienda) {
        this.tiempoVivienda = tiempoVivienda;
    }

    public String getTiempoEmpleo() {
        return tiempoEmpleo;
    }

    public void setTiempoEmpleo(String tiempoEmpleo) {
        this.tiempoEmpleo = tiempoEmpleo;
    }

    public String getMov() {
        return mov;
    }

    public void setMov(String mov) {
        this.mov = mov;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

    public String getMejorPartido() {
        return mejorPartido;
    }

    public void setMejorPartido(String mejorPartido) {
        this.mejorPartido = mejorPartido;
    }

    public String getRelAfe() {
        return relAfe;
    }

    public void setRelAfe(String relAfe) {
        this.relAfe = relAfe;
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

    public String getDependenciaEco() {
        return dependenciaEco;
    }

    public void setDependenciaEco(String dependenciaEco) {
        this.dependenciaEco = dependenciaEco;
    }

    public String getActividadExt() {
        return actividadExt;
    }

    public void setActividadExt(String actividadExt) {
        this.actividadExt = actividadExt;
    }

    public String getDineroExt() {
        return DineroExt;
    }

    public void setDineroExt(String dineroExt) {
        DineroExt = dineroExt;
    }

    public String getGastoImp() {
        return gastoImp;
    }

    public void setGastoImp(String gastoImp) {
        this.gastoImp = gastoImp;
    }

    public String getIngMens() {
        return ingMens;
    }

    public void setIngMens(String ingMens) {
        this.ingMens = ingMens;
    }

    public String getRdgTC() {
        return rdgTC;
    }

    public void setRdgTC(String rdgTC) {
        this.rdgTC = rdgTC;
    }

    public String getRdgProblemaB() {
        return rdgProblemaB;
    }

    public void setRdgProblemaB(String rdgProblemaB) {
        this.rdgProblemaB = rdgProblemaB;
    }

    public String getMesVencido() {
        return mesVencido;
    }

    public void setMesVencido(String mesVencido) {
        this.mesVencido = mesVencido;
    }

    public String getPcuso() {
        return pcuso;
    }

    public void setPcuso(String pcuso) {
        this.pcuso = pcuso;
    }

    public String getPcPago() {
        return pcPago;
    }

    public void setPcPago(String pcPago) {
        this.pcPago = pcPago;
    }

    public String getBuroAct() {
        return buroAct;
    }

    public void setBuroAct(String buroAct) {
        this.buroAct = buroAct;
    }

    public String getBuroUso() {
        return buroUso;
    }

    public void setBuroUso(String buroUso) {
        this.buroUso = buroUso;
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

    public String getBuroAnt() {
        return buroAnt;
    }

    public void setBuroAnt(String buroAnt) {
        this.buroAnt = buroAnt;
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

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(int desarrollo) {
        this.desarrollo = desarrollo;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public int getSubsector() {
        return subsector;
    }

    public void setSubsector(int subsector) {
        this.subsector = subsector;
    }

    public int getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(int tipoEmpleo) {
        this.tipoActividad = tipoEmpleo;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public void definirClienteMeta() {
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
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
            /*
             * TODO output your page here out.println("<html>");
             * out.println("<head>"); out.println("<title>Servlet
             * AgregarMetaServlet</title>"); out.println("</head>");
             * out.println("<body>"); out.println("<h1>Servlet
             * AgregarMetaServlet at " + request.getContextPath () + "</h1>");
             * out.println("</body>"); out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        System.out.println("->>>>>> doGet");
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CalculatorLocatorService ml = CalculatorLocatorService.getInstance();

        if (request.getParameter("pantalla").equals("pantalla1")) {

            System.out.println("->>>>>> doPost " + request.getParameter("pantalla"));
            Enumeration<String> parameterNames = request.getParameterNames();
            Map<String,String> mapeo=new HashMap<String, String>();
            while(parameterNames.hasMoreElements()){
                String llave=parameterNames.nextElement();
                String valor=request.getParameter(llave)==null ? null :request.getParameter(llave).toUpperCase();
                mapeo.put(llave, valor);
            }
            
            this.setApellidoPaterno(mapeo.get("apellidoPaterno"));
            this.setApellidoMaterno(mapeo.get("apellidoMaterno"));
            this.setNombre(mapeo.get("Nombre"));
            this.setAnno(mapeo.get("anio"));
            this.setMes(mapeo.get("mes"));
            this.setDia(mapeo.get("dia"));
            this.setEdad(mapeo.get("edad"));
            this.setCalle(mapeo.get("calle"));
            this.setNoExterior(mapeo.get("noExterior"));
            this.setNoInterior(mapeo.get("noInterior"));
            this.setColonia(mapeo.get("colonia"));
            this.setCodigoPostal(mapeo.get("codigoPostal"));
            this.setEstado(mapeo.get("estado"));
            this.setDelegacionMunicipio(mapeo.get("delegacionMunicipio"));;
            this.setReligion(mapeo.get("religion"));
            this.setSex(mapeo.get("sex"));
            this.setEstadoCivil(mapeo.get("estadoCivil"));
            this.setNEstdio(mapeo.get("nEstdio"));
            this.setTipoRes(mapeo.get("tipoRes"));
            this.setTiempoVivienda(mapeo.get("tiempoVivienda"));
            this.setTiempoEmpleo(mapeo.get("tiempoEmpleo"));
            this.setMov(mapeo.get("mov"));
            this.setPrestamo(mapeo.get("prestamo"));
            this.setMejorPartido(mapeo.get("mejorPartido"));
            this.setRelAfe(mapeo.get("relAfe"));
            this.setOpinionApoDe(mapeo.get("opinionApoDe"));
            this.setPartAsoc(mapeo.get("partAsoc"));
            this.setDependenciaEco(mapeo.get("dependenciaEco"));
            this.setActividadExt(mapeo.get("actividadExt"));
            this.setDineroExt(mapeo.get("DineroExt"));
            this.setGastoImp(mapeo.get("gastoImp"));
            this.setIngMens(mapeo.get("ingMens"));
            this.setRdgTC(mapeo.get("rdgTC"));
            this.setRdgProblemaB(mapeo.get("rdgProblemaB"));
            this.setRFC(mapeo.get("rfc"));

            //arrRdgTC
            this.setMesVencido(mapeo.get("mesVencido"));
            this.setPcuso(mapeo.get("pcuso"));
            this.setPcPago(mapeo.get("pcPago"));

            //arrRdgProblemaB
            this.setBuroAct(mapeo.get("buroAct"));
            this.setBuroUso(mapeo.get("buroUso"));
            this.setBuroHist(mapeo.get("buroHist"));
            this.setBuroPago(mapeo.get("buroPago"));
            this.setBuroAnt(mapeo.get("buroAnt"));



            //cliente
            CustomerValueObject dataCustomerMetaVO = new CustomerValueObject();

            //clienteMeta
            CustomerMetaValueObject metaVO = new CustomerMetaValueObject();

            dataCustomerMetaVO.setCliApeMat(this.getApellidoMaterno());

            dataCustomerMetaVO.setCliApePat(this.getApellidoPaterno());

            dataCustomerMetaVO.setCliDomCal(this.getCalle());

            dataCustomerMetaVO.setCliDomCol(this.getColonia());

            dataCustomerMetaVO.setCliDomNumExt(this.getNoExterior());

            dataCustomerMetaVO.setCliDomNumInt(this.getNoInterior());

            System.out.println("rfc: " + this.getRFC());
            dataCustomerMetaVO.setCliRFC(this.getRFC());

            if (request.getParameter("idCli") == null ? "" != null : !request.getParameter("idCli").equals("")) {

                System.out.println("el id: " + request.getParameter("idCli"));

                this.setIdcli(Integer.parseInt(request.getParameter("idCli")));
                dataCustomerMetaVO.setCliId(this.getIdcli());


            }

            DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            try {

                dataCustomerMetaVO.setCliFecNac(formater.parse(this.getDia() + "/" + this.getMes() + "/" + this.getAnno()));
            } catch (ParseException ex) {
                System.out.println("error al parsear la fecha: " + ex.toString());
            }

            Calendar cal = Calendar.getInstance();
            //YYYY-MM--DD
           /*
             * dataCustomerMetaVO.setCliFecNac( // cal.set(this.getAnno(),
             * this.getMes(), this.getDia()) );
             */
            dataCustomerMetaVO.setCliNom(this.getNombre());

            //RFC
            dataCustomerMetaVO.setCliRFC(this.getRFC());

            dataCustomerMetaVO.setCodPosId(this.getCodigoPostal());

            //se maneja por default para garantizar que sean clientes meta
            dataCustomerMetaVO.setCalId(4);

            if (this.getEdad() != null && !this.getEdad().equals("")) {
                dataCustomerMetaVO.setCliEdad(this.getEdad().trim());
            }

            metaVO.setACT_EXT_ID(Integer.parseInt(this.getActividadExt()));
            //metaVO.setBURO_USO_ID(Integer.parseInt(this.getBuroUso()));
            //metaVO.setBUR_ACT_ID(Integer.parseInt(this.getBuroAct()));
            //metaVO.setBUR_HIS_ID(Integer.parseInt(this.getBuroHist()));
            //metaVO.setBUR_PAG_ID(Integer.parseInt(this.getBuroPago()));
            metaVO.setCOD_POS_ID(this.getCodigoPostal());
            metaVO.setDEP_ECO_ID(Integer.parseInt(this.getDependenciaEco()));
            metaVO.setEDO_CVL_ID(Integer.parseInt(this.getEstadoCivil()));
            //metaVO.setEDO_ID(Integer.parseInt(this.getEstado()));
            metaVO.setING_ID(Integer.parseInt(this.getIngMens()));
            metaVO.setNIV_EST_ID(Integer.parseInt(this.getNEstdio()));
            //metaVO.setOPN_BAR_ID(this.getOpinionApoDe())
            metaVO.setPTM_ID(Integer.parseInt(this.getPrestamo()));
            metaVO.setREL_ID(Integer.parseInt(this.getReligion()));
            metaVO.setSEX_ID(Integer.parseInt(this.getSex()));
            metaVO.setTIP_EMP_ID(Integer.parseInt(this.getTiempoEmpleo()));
            metaVO.setTIP_RES_ID(Integer.parseInt(this.getTipoRes()));
            if (this.getTiempoVivienda().indexOf(".") != -1) {

                metaVO.setCLI_ANT_RES((int) Double.parseDouble(this.getTiempoVivienda()));
            } else {
                metaVO.setCLI_ANT_RES(Integer.parseInt(this.getTiempoVivienda()));
            }

            metaVO.setCLI_ANT_EMP(Double.parseDouble(this.getTiempoEmpleo()));
            metaVO.setASO_PAR_ID(Integer.parseInt(this.getPartAsoc()));
            metaVO.setCLI_FEC_NAC(this.getDia() + "/" + this.getMes() + "/" + this.getAnno());

            if (this.getMesVencido() != null && !this.getMesVencido().equals("")) {
                metaVO.setBAN_CMP_ID(Integer.parseInt(this.getMesVencido()));
            }

            if (this.getPcuso() != null && !this.getPcuso().equals("")) {
                metaVO.setBAR_POR_USO_ID(Integer.parseInt(this.getPcuso()));
            }

            if (this.getPcPago() != null && !this.getPcPago().equals("")) {
                metaVO.setBAN_POR_PAG_ID(Integer.parseInt(this.getPcPago()));
            }

            //metaVO.setOCP_ID(Integer.parseInt(this.getTiempoEmpleo()));
            metaVO.setMIG_ID(Integer.parseInt(this.getMov()));
            metaVO.setOPN_BAR_ID(Integer.parseInt(this.getOpinionApoDe()));
            metaVO.setPAR_PLT_ID(Integer.parseInt(this.getMejorPartido()));
            metaVO.setRLD_ID(Integer.parseInt(this.getRelAfe()));
            metaVO.setDIN_EXT_ID(Integer.parseInt(this.getDineroExt()));
            metaVO.setPRO_ANO_GTO_ID(Integer.parseInt(this.getGastoImp()));
            //metaVO.setBUR_ANT_ID(Integer.parseInt(this.getBuroAnt()));


            if (request.getParameter("idCliMta") == null ? "" != null : !request.getParameter("idCliMta").equals("")) {

                this.setCliMtaId(Integer.parseInt(request.getParameter("idCliMta")));
                metaVO.setCLI_MTA_ID(this.getCliMtaId());
                request.getSession().setAttribute("idCliMta", this.getCliMtaId());
            }

            //>>>>>>>>>>>>><
            System.out.println(">>>> " + dataCustomerMetaVO.getCliApePat()
                    + "\n" + dataCustomerMetaVO.getCliApeMat() + "  \n "
                    + dataCustomerMetaVO.getCliNom() + "  \n "
                    + this.getAnno() + "  \n "
                    + this.getMes() + "  \n "
                    + this.getDia() + "  \n "
                    + this.getEdad() + "  \n "
                    + this.getCalle() + "  \n "
                    + this.getNoExterior() + "  \n "
                    + this.getNoInterior() + "  \n "
                    + this.getColonia() + "  \n "
                    + this.getCodigoPostal() + "  \n "
                    + this.getEstado() + "  \n "
                    + this.getDelegacionMunicipio() + "  \n " + "  \n "
                    + this.getReligion() + "  \n "
                    + this.getSex() + "  \n "
                    + this.getEstado() + "  \n "
                    + this.getNEstdio() + "  \n "
                    + this.getTipoRes() + "  \n "
                    + this.getTiempoVivienda() + "  \n "
                    + this.getTiempoEmpleo() + "  \n "
                    + this.getMov() + "  \n "
                    + this.getPrestamo() + "  \n "
                    + this.getMejorPartido() + "  \n "
                    + this.getRelAfe() + "  \n "
                    + this.getOpinionApoDe() + "  \n "
                    + this.getPartAsoc() + "  \n "
                    + this.getDependenciaEco() + "  \n "
                    + this.getActividadExt() + "  \n "
                    + this.getDineroExt() + "  \n "
                    + this.getGastoImp() + "  \n "
                    + this.getIngMens() + "  \n "
                    + this.getRdgTC() + "  \n "
                    + this.getRdgProblemaB() + "  \n " /*
                     * +
                     *
                     * //arrRdgTC this.getMesVencido( )+" \n "+ this.getPcuso(
                     * )+" \n "+ this.getPcPago( )+" \n "+
                     *
                     * //arrRdgProblemaB this.getBuroAct( )+" \n "+
                     * this.getBuroUso( )+" \n "+ this.getBuroHist( )+" \n "+
                     * this.getBuroPago( )+" \n "+ this.getBuroAnt( )+" \n "
                     */);

            //<<<<<<<<<<<<<<<<<


            //cuestionario
            //CustomerMetaValueObject customerMetaVO
            CliMta2 cliMta2 = null;

            try {
                //    System.out.println(">>>>>"+ request.toString()   +">>>>>><<");
                ProcessValueObject processValueObject = ml.addCustomerMeta(dataCustomerMetaVO, metaVO);
                cliMta2 = (CliMta2) processValueObject.getInfoResult().get("Object");

                if (request.getSession().getAttribute("clienteMeta") != null) {

                    System.out.println("ya existia el cliente meta en session, se remueve para subir el nuevo");
                    request.getSession().removeAttribute("clienteMeta");
                    if (request.getSession().getAttribute("accion") != null) {

                        request.getSession().removeAttribute("accion");
                    }
                }
                String mensaje = "";

                if (!processValueObject.isError()) {

                    mensaje = "se agrego el cliente con id " + cliMta2.getCli().getCliId() + " correctamente";
                } else {
                    mensaje = "error: " + processValueObject.getAddError().get("HibernateError");
                }

                if (request.getSession().getAttribute("mensaje") != null) {

                    request.getSession().removeAttribute("mensaje");
                }

                request.getSession().setAttribute("mensaje", mensaje);
                request.getSession().setAttribute("clienteMeta", cliMta2);
                request.getSession().setAttribute("accion", "Agregar");

                //response.sendRedirect("./meta/clientemeta_2.jsp");

                response.sendRedirect("./meta/clientemeta_2.jsp");

            } catch (Exception ex) {
                System.out.println("error al guardar " + ex);
            }


        } else {

            CliMta2 clienteSession = (CliMta2) request.getSession().getAttribute("clienteMeta");


            System.out.println("cliente de session: " + clienteSession);

            //this.setTipoActividad(Integer.parseInt(request.getParameter("tipoActividad")));
            this.setDesarrollo(Integer.parseInt(request.getParameter("desarrollo").toUpperCase()));
            this.setCliValMen(Integer.parseInt(request.getParameter("valorViviendaMen").toUpperCase()));
            this.setCliValViv(Integer.parseInt(request.getParameter("valorVivienda").toUpperCase()));

            if (request.getParameter("subSector") == null || ((String) request.getParameter("subSector")).trim().equals("-Seleccione-")) {
                if (request.getParameter("tipoActividad") != null || ((String) request.getParameter("tipoActividad")).trim().equals("-Seleccione-")) {

                    this.setSubsector(Integer.parseInt(request.getParameter("tipoActividad")));
                }
            } else {
                this.setSubsector(Integer.parseInt(request.getParameter("subSector")));
            }
            //this.setSector(Integer.parseInt(request.getParameter("sector")));

            this.setEstado(request.getParameter("estado").toUpperCase());
            this.setRol(Integer.parseInt(request.getParameter("rol").toUpperCase()));

            System.out.println(request.getParameter("textfield") + " descripcion ");

            clienteSession.setCliDesOcu(request.getParameter("textfield").toUpperCase());

            //String ocp_id = Integer.toString(this.getTipoActividad()) + Integer.toString(this.getSector()) + Integer.toString(this.getSubsector());

            //llenando el pojo para persistirlo
            clienteSession.setEdoId(Integer.parseInt(this.getEstado()));
            clienteSession.setOcpId(this.getSubsector());


            clienteSession.setCliValMen(this.getCliValMen());
            clienteSession.setCliValViv(this.getCliValViv());
            clienteSession.setDesId(this.getDesarrollo());
            clienteSession.setRolId(this.getRol());

            ProcessValueObject objRespuesta = ml.actualizarMeta(clienteSession);
            String mensaje = "";
            if (!objRespuesta.isError()) {

                System.out.println("se sube de nuevo a la session el cliente mta");
                mensaje = "se actualizo el cliente con id " + clienteSession.getCli().getCliId() + " correctamente";
                request.getSession().removeAttribute("clienteMeta");
                //request.getSession().setAttribute("clienteMeta",clienteSession);

            }

            if (request.getSession().getAttribute("mensaje") != null) {

                request.getSession().removeAttribute("mensaje");
            }


            request.getSession().setAttribute("mensaje", mensaje);
            
            Cli cli = clienteSession.getCli();
            String clave = cli.getCliApePat().substring(0, 1) + cli.getCliApeMat().substring(0, 1)+ cli.getCliNom().substring(0, 1) + 
                    cli.getCliFecNac().getDate() + cli.getCliFecNac().getMonth() + cli.getCliFecNac().getYear();
            guardarArbitraje(clienteSession.getCli().getCliId(), ((Usuarios) request.getSession().getAttribute("usuarioUrbi")).getId(), clave);

            response.sendRedirect("./meta/metaindex.jsp");

        }





    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void guardarArbitraje(int idPrima, String idUsu, String clave) {
        ArbMta arb = new ArbMta(Integer.parseInt(idUsu), idPrima, clave.toUpperCase(), Calendar.getInstance().getTime());
        VerificadorArbitrajeMeta verificador = new VerificadorArbitrajeMeta(arb);
        verificador.guardarVerificar();
    }
}
