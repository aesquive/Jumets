/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import arbitreadores.objetos.ArbGolAu;

import arbitreadores.verificador.VerificadorArbitrajeGol;
import com.urbi.dao.impl.Dao;
import com.urbi.prima.PrimaBean;
import com.urbi.prima.PrimaSql;
import com.urbi.utilerias.dao.Usuarios;
import gol.beans.GolBean;
import gol.beans.GolSql;
import gol.beans.GolWs;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Cli;
import objetos.CliGol;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rodrigo Soto Chavarria
 */
public class GolServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String command = null;
        try {
            command = request.getParameter("command");

        } finally {

            if (command.equalsIgnoreCase("reporta")) {
                reporta();
            }

            if (command.equalsIgnoreCase("Agregar")) {
                GolBean gol = new GolBean();
                gol.setIdGol(-1);
                gol.setIdPrima(-1);
                request.getSession().setAttribute("accion", "Agregar");
                request.getSession().setAttribute("gol", gol);
                response.sendRedirect("./gol/infogol.jsp");
            } else if (command.equalsIgnoreCase("guardar")) {// pagina1g
                getpagina1(request);
                response.sendRedirect("./gol/infogol.jsp");
            } else if (command.equalsIgnoreCase("pagina2")) {// pagina1S
                getpagina1(request);
                response.sendRedirect("./gol/infogol_2.jsp");
            } else if (command.equalsIgnoreCase("guardar2")) {// pagina2g
                getpagina2(request);
                response.sendRedirect("./gol/infogol_2.jsp");
            } else if (command.equalsIgnoreCase("pagina3")) {// pagina2S
                getpagina2(request);
                response.sendRedirect("./gol/ingresosgol.jsp");
            } else if (command.equalsIgnoreCase("pagina1")) {// pagina2A
                getpagina2(request);
                response.sendRedirect("./gol/infogol.jsp");
            } else if (command.equalsIgnoreCase("guardar3")) {// pagina3g
                getpagina3(request);
                response.sendRedirect("./gol/ingresosgol.jsp");
            } else if (command.equalsIgnoreCase("pagina4")) {// pagina3S
                getpagina3(request);
                response.sendRedirect("./gol/historiagol.jsp");
            } else if (command.equalsIgnoreCase("pagina2A")) {// pagina3A
                getpagina3(request);
                response.sendRedirect("./gol/infogol_2.jsp");
            } else if (command.equalsIgnoreCase("guardar4")) {// pagina4g
                getpagina4(request);
                response.sendRedirect("./gol/historiagol.jsp");
            } else if (command.equalsIgnoreCase("pagina5")) {// pagina4s
                getpagina4(request);
                response.sendRedirect("./gol/psicogol.jsp");
            } else if (command.equalsIgnoreCase("pagina3a")) {// pagina4A
                getpagina4(request);
                response.sendRedirect("./gol/ingresosgol.jsp");
            } else if (command.equalsIgnoreCase("guardar5")) {// pagina5G
                getpagina5(request);
                response.sendRedirect("./gol/psicogol.jsp");
            } else if (command.equalsIgnoreCase("pagina6")) {// pagina5S
                getpagina5(request);
                response.sendRedirect("./gol/psicogol_2.jsp");
            } else if (command.equalsIgnoreCase("pagina6A")) {// pagina5A
                getpagina5(request);
                response.sendRedirect("./gol/historiagol.jsp");
            } else if (command.equalsIgnoreCase("pagina6P")) {// pagina5P
                getpagina5(request);
                response.sendRedirect("./gol/infogol.jsp");
            } else if (command.equalsIgnoreCase("guardar6")) {// pagina6G
                getpagina6(request);
                response.sendRedirect("./gol/psicogol_2.jsp");
            } else if (command.equalsIgnoreCase("pagina7")) {// pagina6S
                getpagina6(request);
                response.sendRedirect("./gol/burogol.jsp");
            } else if (command.equalsIgnoreCase("pagina7A")) {// pagina6A
                getpagina6(request);
                response.sendRedirect("./gol/psicogol.jsp");
            } else if (command.equalsIgnoreCase("pagina7P")) {// pagina6P
                getpagina6(request);
                response.sendRedirect("./gol/infogol.jsp");
            } else if (command.equalsIgnoreCase("pagina7AB")) {// p7 a p6
                getpagina7(request);
                response.sendRedirect("./gol/psicogol_2.jsp");
            } else if (command.equalsIgnoreCase("pagina7PB")) {// pagina7P
                getpagina7(request);
                response.sendRedirect("./gol/infogol.jsp");
            } else if (command.equalsIgnoreCase("guardar7")) {// pagina7G
                getpagina7(request);
                GolBean gol = (GolBean) request.getSession().getAttribute("gol");

                PrimaBean p = new PrimaBean();
                p.setApellidoPaterno(gol.getApellidoPaterno());
                p.setApellidoMaterno(gol.getApellidoMaterno());
                p.setNombre(gol.getNombre());
                p.setDia(String.valueOf(gol.getDia()));
                p.setMes(gol.getMes());
                p.setAnio(gol.getAnio());
                p.setEdad(String.valueOf(gol.getEdad()));
                p.setCalle(gol.getCalle());
                p.setNoExterior(gol.getNoExterior());
                p.setNoInterior(gol.getNoInterior());
                p.setColonia(gol.getColonia());
                p.setCp(gol.getCp());
                p.setEdoCivil(gol.getEdoCivil());

                String tipoActividad = gol.getTipoActividad();
                p.setTipoActividad(tipoActividad);
                if ("3".equals(tipoActividad)) {
                    p.setSubSector("300");
                } else if ("4".equals(tipoActividad)) {
                    p.setSubSector("400");
                } else {
                    p.setSubSector(gol.getSubsector());
                }
                p.setSector(gol.getSector());
                p.setRol(gol.getRol());
                p.setDescripcionOcupacion(gol.getDescripcionOcupacion());
                p.setUbicacionVivienda("");
                p.setDesarrollo("");
                p.setValorVivienda(gol.getValorVivienda());
                p.setMensualidad(gol.getMensualidad());
                p.setIngresoMensual(gol.getIngresoMensual());
                p.setDependientes(gol.getPersonasDep());

                int idPrima = GolSql.insertaPrima(p);
                GolSql.insertaGol(gol, idPrima);
                if (gol.getBuroCredito() == 1) {// SI
                    GolSql.insertaBuro(gol, idPrima);
                }
                String clave = p.getApellidoPaterno().substring(0, 1) + p.getApellidoMaterno().substring(0, 1) + p.getNombre().substring(0, 1) + p.getDia() + p.getMes().replace("0", "") + p.getAnio();
                guardarArbitraje(idPrima, ((Usuarios) request.getSession().getAttribute("usuarioUrbi")).getId(), clave);
                request.getSession().setAttribute("gol", null);
                response.sendRedirect("./gol/golindex.jsp");
            } else if (command.equalsIgnoreCase("BUSCAR")) {
                String nombre = (request.getParameter("persona") == null) ? ""
                        : request.getParameter("persona");
                String lista = obtenerLista(nombre);
                request.getSession().setAttribute("listaGol", lista);
                response.sendRedirect("./gol/golindex.jsp");
            } else if (command.equalsIgnoreCase("buscart")) {
                String lista = GolSql.getListaGol("", "", 0);
                request.getSession().setAttribute("listaGol", lista);
                response.sendRedirect("./gol/golindex.jsp");
            } else if (command.equalsIgnoreCase("ver")) {
                Dao dao = new Dao();
                String idG = request.getParameter("idG");
                String idP = request.getParameter("idP");
                GolBean gol = GolSql.getVer(idG);
                PrimaBean p = PrimaSql.getVer(idP, 1);
                System.out.println("el id de prima " + idP);
                Cli cli = (Cli) dao.getCriteria(Cli.class, Restrictions.eq("cliId", Integer.parseInt(idP)));
                gol = getCargaPrima(p, gol);
                gol.setPrima(p);
                if (gol.getBuroCredito() == 1) {
                    GolSql.getBuro(gol, Integer.parseInt(p.getIdPrima()));
                }
                gol.setControl("1");
                gol.setIdPrima(Integer.parseInt(idP));
                Date cliFecNac = cli.getCliFecNac();
                Calendar c = Calendar.getInstance();
                c.setTime(cliFecNac);
                gol.setDia(String.valueOf(c.get(Calendar.DAY_OF_MONTH)));
                gol.setMes(String.valueOf(c.get(Calendar.MONTH) + 1));
                gol.setAnio(String.valueOf(c.get(Calendar.YEAR)));
                gol.setEdad(Integer.parseInt(cli.getCliEdad()));
                request.getSession().setAttribute("gol", gol);
                response.sendRedirect("./gol/infogol.jsp");
            } else if (command.equalsIgnoreCase("ircalcular")) {
                request.getSession().setAttribute("valoresCalculo", null);
                response.sendRedirect("./gol/calcgol.jsp");
            } else if (command.equalsIgnoreCase("calcular")) {
                String idG = request.getParameter("idG");
                String idP = request.getParameter("idP");

                // llena el bean de gol
                GolBean gol = GolSql.getVer(idG);
                // llenba el bean de prima
                PrimaBean p = PrimaSql.getVer(idP, 1);
                // carga os detos del objeto prima all onjeto gol
                gol = getCargaPrima(p, gol);
                gol.setPrima(p);
                if (gol.getBuroCredito() == 1) {
                    GolSql.getBuro(gol, Integer.parseInt(p.getIdPrima()));
                }
                GolWs ws = new GolWs(gol);
                ws.golWs();
                List<String> valoresCalculo = ws.getValoresCalc();
                valoresCalculo.add(p.getNombre() + " " + p.getApellidoPaterno()
                        + " " + p.getApellidoMaterno());
                request.getSession().setAttribute("valoresCalculo",
                        valoresCalculo);
                response.sendRedirect("./gol/calcgol.jsp");
            } else if (command.equalsIgnoreCase("modificar")) {
                System.out.println("*************ENTRA MODIFICAR*******");
                getpagina7(request);
                GolBean gol = (GolBean) request.getSession().getAttribute("gol");

                PrimaBean p = new PrimaBean();
                p.setApellidoPaterno(gol.getApellidoPaterno());
                p.setApellidoMaterno(gol.getApellidoMaterno());
                p.setNombre(gol.getNombre());
                p.setDia(String.valueOf(gol.getDia()));
                p.setMes(gol.getMes());
                p.setAnio(gol.getAnio());
                p.setEdad(String.valueOf(gol.getEdad()));
                p.setCalle(gol.getCalle());
                p.setNoExterior(gol.getNoExterior());
                p.setNoInterior(gol.getNoInterior());
                p.setColonia(gol.getColonia());
                p.setCp(gol.getCp());
                p.setEdoCivil(gol.getEdoCivil());

                String tipoActividad = gol.getTipoActividad();
                p.setTipoActividad(tipoActividad);
                if ("3".equals(tipoActividad)) {
                    p.setSubSector("300");
                } else if ("4".equals(tipoActividad)) {
                    p.setSubSector("400");
                } else {
                    p.setSubSector(gol.getSubsector());
                }
                p.setSector(gol.getSector());
                p.setRol(gol.getRol());
                p.setDescripcionOcupacion(gol.getDescripcionOcupacion());
                p.setUbicacionVivienda("");
                p.setDesarrollo("");
                p.setValorVivienda(gol.getValorVivienda());
                p.setMensualidad(gol.getMensualidad());
                p.setIngresoMensual(gol.getIngresoMensual());
                p.setDependientes(gol.getPersonasDep());
                p.setIdPrima(String.valueOf(gol.getIdPrima()));

                // ACTUALIZA PRIMA DE GOL
                PrimaSql.updatePrima(p);
                GolSql.updateGol(gol);
                if (gol.getBuroCredito() == 1) {// SI
                    //	GolSql.updateBuro(gol);

                    boolean bExiste = GolSql.getExisteBuroUI(gol.getIdPrima());
                    if (bExiste) {
                        GolSql.updateBuro(gol);
                    } else {
                        GolSql.insertaBuro(gol, gol.getIdPrima());
                    }




                }
                String clave = p.getApellidoPaterno().substring(0, 1) + p.getApellidoMaterno().substring(0, 1) + p.getNombre().substring(0, 1) + p.getDia() + p.getMes().replace("0", "") + p.getAnio();
                guardarArbitraje(gol.getIdPrima(), ((Usuarios) request.getSession().getAttribute("usuarioUrbi")).getId(), clave);

                request.getSession().setAttribute("gol", null);
                response.sendRedirect("./gol/golindex.jsp");
            } else if (command.equalsIgnoreCase("salir")) {
                request.getSession().setAttribute("gol", null);
                response.sendRedirect("./gol/golindex.jsp");
            }
        }
    }

    public static void getpagina1(HttpServletRequest request) {
        GolBean gol = (GolBean) request.getSession().getAttribute("gol");
        gol.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        gol.setApellidoMaterno(request.getParameter("apellidoMaterno"));
        gol.setNombre(request.getParameter("nombre"));
        gol.setEdad(Integer.parseInt(request.getParameter("edad")));
        gol.setAnio(request.getParameter("anio"));
        gol.setMes(request.getParameter("mes"));
        gol.setDia(request.getParameter("dia"));
        gol.setCalle(request.getParameter("calle"));
        gol.setNoExterior(request.getParameter("noExterior"));
        gol.setNoInterior(request.getParameter("noInterior"));
        gol.setColonia(request.getParameter("colonia"));
        gol.setCp(request.getParameter("cp"));
        gol.setEdo(request.getParameter("edo"));
        gol.setMun(request.getParameter("mun"));
        gol.setSexo(request.getParameter("sexo"));
        gol.setEdoCivil(request.getParameter("edoCivil"));
        gol.setComercioIndispensable(request.getParameter("comercioIndispensable"));
        gol.setProblemaHoy(request.getParameter("problemaHoy"));
        gol.setSituacionActual(request.getParameter("situacionActual"));
        gol.setSituacionPAnio(request.getParameter("situacionPAnio"));
        gol.setPqSituacionPAnio(request.getParameter("pqSituacionPAnio"));
        gol.setDeudaPreocupa(request.getParameter("deudaPreocupa"));
        gol.setApoyoInstitucion(request.getParameter("apoyoInstitucion"));
        gol.setDineroExtra(request.getParameter("dineroExtra"));

        gol.setGastosAlimentos(request.getParameter("gastosAlimentos"));
        gol.setGastosPersonales(request.getParameter("gastosPersonales"));
        gol.setGastosDeudas(request.getParameter("gastosDeudas"));
        gol.setGastosOtros((request.getParameter("gastosOtros") == null) ? ""
                : request.getParameter("gastosOtros"));
        gol.setGastosOtroCual(request.getParameter("gastosOtroCual"));
        gol.setControl("1");
        gol.setIdGol(Integer.parseInt(request.getParameter("idGol")));
        gol.setIdPrima(Integer.parseInt(request.getParameter("idPrima")));

        System.out.println(ToStringBuilder.reflectionToString(gol));
        request.getSession().setAttribute("gol", gol);
    }

    public static void getpagina2(HttpServletRequest request) {
        GolBean gol = (GolBean) request.getSession().getAttribute("gol");
        gol.setReligionFamilia(request.getParameter("religionFamilia"));
        gol.setReligioOtra(request.getParameter("religioOtra"));
        gol.setReligionFrecuencia(request.getParameter("religionFrecuencia"));
        gol.setReligionMia(request.getParameter("religionMia"));
        gol.setReligionMiaOtra(request.getParameter("religionMiaOtra"));
        gol.setReligionDecision(request.getParameter("religionDecision"));
        gol.setRazoncambio(request.getParameter("razoncambio"));
        gol.setMotivacion(request.getParameter("motivacion"));
        gol.setTipoActividad(request.getParameter("tipoActividad"));
        gol.setDescripcionOcupacion(request.getParameter("descripcionOcupacion"));
        gol.setSector(request.getParameter("sector"));
        gol.setRol(request.getParameter("rol"));
        gol.setSubsector(request.getParameter("subSector"));
        gol.setTiempoLaborando(request.getParameter("tiempoLaborando"));
        gol.setEstudiaActual(request.getParameter("estudiaActual"));
        gol.setGradoE(request.getParameter("gradoE"));
        gol.setGradoEAnio(request.getParameter("gradoEAnio"));
        gol.setGradoEPapa(request.getParameter("gradoEPapa"));
        gol.setGradoEPAnio(request.getParameter("gradoEPAnio"));
        gol.setGradoEMama(request.getParameter("gradoEMama"));
        gol.setGradoEMAnio(request.getParameter("gradoEMAnio"));
        gol.setTiempoViviendo(Integer.parseInt(request.getParameter("tiempoViviendo")));
        gol.setActividadPrincipal(request.getParameter("actividadPrincipal"));
        gol.setNoTrabaja(request.getParameter("noTrabaja"));
        System.out.println(ToStringBuilder.reflectionToString(gol));
        request.getSession().setAttribute("gol", gol);
    }

    public static void getpagina3(HttpServletRequest request) {
        GolBean gol = (GolBean) request.getSession().getAttribute("gol");

        gol.setRespCrisis(request.getParameter("respCrisis"));
        gol.setLugarVivienda(request.getParameter("lugarVivienda"));
        gol.setGastoPlaneado(request.getParameter("gastoPlaneado"));
        gol.setViveActual(request.getParameter("viveActual"));
        gol.setPersonasDep(request.getParameter("personasDep"));
        gol.setIngresoMensual(request.getParameter("ingresoMensual"));
        gol.setIngresoDestino(request.getParameter("ingresoDestino"));
        gol.setConyuge(Integer.parseInt((request.getParameter("conyuge") == null || "null".equals(request.getParameter("conyuge"))) ? "0"
                : request.getParameter("conyuge")));
        gol.setHijos(Integer.parseInt((request.getParameter("hijos") == null || "null".equals(request.getParameter("hijos"))) ? "0" : request.getParameter("hijos")));
        gol.setPadres(Integer.parseInt((request.getParameter("padres") == null || "null".equals(request.getParameter("padres"))) ? "0"
                : request.getParameter("padres")));
        gol.setOtros(Integer.parseInt((request.getParameter("otros") == null || "null".equals(request.getParameter("otros"))) ? "0" : request.getParameter("otros")));

        System.out.println(request.getParameter("imc"));
        System.out.println(request.getParameter("imh"));
        System.out.println(request.getParameter("imp"));
        System.out.println(request.getParameter("imo"));
        System.out.println(request.getParameter("ac"));
        System.out.println(request.getParameter("ah"));
        System.out.println(request.getParameter("ap"));
        System.out.println(request.getParameter("ao"));

        gol.setImc(request.getParameter("imc"));
        gol.setImh(request.getParameter("imh"));
        gol.setImp(request.getParameter("imp"));
        gol.setImo(request.getParameter("imo"));
        gol.setAc(request.getParameter("ac"));
        gol.setAh(request.getParameter("ah"));
        gol.setAp(request.getParameter("ap"));
        gol.setAo(request.getParameter("ao"));

        gol.setAlimentos(request.getParameter("alimentos"));
        gol.setVestido(request.getParameter("vestido"));
        gol.setServiciosV(request.getParameter("serviciosV"));
        gol.setLimpieza(request.getParameter("limpieza"));
        gol.setSalud(request.getParameter("salud"));
        gol.setTransporte(request.getParameter("transporte"));
        gol.setEducacion(request.getParameter("educacion"));
        gol.setDiversiones(request.getParameter("diversiones"));
        gol.setPagoDeudas(request.getParameter("pagoDeudas"));
        gol.setRenta(request.getParameter("renta"));
        gol.setOtroGastos((request.getParameter("otroGastos") == null) ? ""
                : request.getParameter("otroGastos"));
        gol.setCuantogasta(request.getParameter("cuantogasta"));
        System.out.println(ToStringBuilder.reflectionToString(gol));
        request.getSession().setAttribute("gol", gol);
    }

    public static void getpagina4(HttpServletRequest request) {
        GolBean gol = (GolBean) request.getSession().getAttribute("gol");

        gol.setActividadAdicional(request.getParameter("actividadAdicional"));
        gol.setSolicitudCredito(request.getParameter("solicitudCredito"));
        System.out.println("gol.getSolicitudCredito()Pagina4="
                + gol.getSolicitudCredito());
        gol.setDineroExtraR(request.getParameter("dineroExtraR"));
        gol.setDineroECuanto(request.getParameter("dineroECuanto"));
        gol.setDineroConcepto(request.getParameter("dineroConcepto"));
        gol.setDineroFrec(request.getParameter("dineroFrec"));
        gol.setPagaRenta(request.getParameter("pagaRenta"));
        gol.setPagaRCuanto(request.getParameter("pagaRCuanto"));
        gol.setSolicitadoCredito(request.getParameter("solicitadoCredito"));
        gol.setTipoCredito(request.getParameter("tipoCredito"));
        gol.setCreditoAnio(request.getParameter("creditoAnio"));
        gol.setCreditoMes(request.getParameter("creditoMes"));
        gol.setTardoAnio(request.getParameter("tardoAnio"));
        gol.setTardoMes(request.getParameter("tardoMes"));
        gol.setCualCredito(request.getParameter("cualCredito"));

        gol.setTarjetaC(request.getParameterValues("tarjetaC")[0]);
        gol.setTotalTarjetas(request.getParameter("totalTarjetas"));
        gol.setTarjetaD(request.getParameterValues("tarjetaD")[0]);
        gol.setCuentaCheque(request.getParameterValues("cuentaCheque")[0]);
        gol.setCreditoPersonal(request.getParameterValues("creditoPersonal")[0]);
        gol.setCreditoAuto(request.getParameterValues("creditoAuto")[0]);
        gol.setCreditoHipo(request.getParameterValues("creditoHipo")[0]);
        gol.setSeguroVida(request.getParameterValues("seguroVida")[0]);
        gol.setSeguroMedico(request.getParameterValues("seguroMedico")[0]);
        gol.setOtroCredito(request.getParameterValues("otroCredito")[0]);

        System.out.println(ToStringBuilder.reflectionToString(gol));
        request.getSession().setAttribute("gol", gol);
    }

    public static void getpagina5(HttpServletRequest request) {
        GolBean gol = (GolBean) request.getSession().getAttribute("gol");
        String pregunta1[] = request.getParameterValues("pregunta1");
        String pregunta2[] = request.getParameterValues("pregunta2");
        String pregunta3[] = request.getParameterValues("pregunta3");
        String pregunta4[] = request.getParameterValues("pregunta4");
        String pregunta5[] = request.getParameterValues("pregunta5");
        String pregunta6[] = request.getParameterValues("pregunta6");
        String pregunta7[] = request.getParameterValues("pregunta7");
        String pregunta8[] = request.getParameterValues("pregunta8");
        String pregunta9[] = request.getParameterValues("pregunta9");
        String pregunta10[] = request.getParameterValues("pregunta10");
        String pregunta11[] = request.getParameterValues("pregunta11");
        String pregunta12[] = request.getParameterValues("pregunta12");

        gol.setPregunta1(pregunta1 == null ? "" : pregunta1[0]);
        gol.setPregunta2(pregunta2 == null ? "" : pregunta2[0]);
        gol.setPregunta3(pregunta3 == null ? "" : pregunta3[0]);
        gol.setPregunta4(pregunta4 == null ? "" : pregunta4[0]);
        gol.setPregunta5(pregunta5 == null ? "" : pregunta5[0]);
        gol.setPregunta6(pregunta6 == null ? "" : pregunta6[0]);
        gol.setPregunta7(pregunta7 == null ? "" : pregunta7[0]);
        gol.setPregunta8(pregunta8 == null ? "" : pregunta8[0]);
        gol.setPregunta9(pregunta9 == null ? "" : pregunta9[0]);
        gol.setPregunta10(pregunta10 == null ? "" : pregunta10[0]);
        gol.setPregunta11(pregunta11 == null ? "" : pregunta11[0]);
        gol.setPregunta12(pregunta12 == null ? "" : pregunta12[0]);
        System.out.println(ToStringBuilder.reflectionToString(gol));
        request.getSession().setAttribute("gol", gol);
    }

    public static void getpagina6(HttpServletRequest request) {
        GolBean gol = (GolBean) request.getSession().getAttribute("gol");
        String pregunta13[] = request.getParameterValues("pregunta13");
        String pregunta14[] = request.getParameterValues("pregunta14");
        String pregunta15[] = request.getParameterValues("pregunta15");
        String pregunta16[] = request.getParameterValues("pregunta16");
        String pregunta17[] = request.getParameterValues("pregunta17");
        String pregunta18[] = request.getParameterValues("pregunta18");
        String pregunta19[] = request.getParameterValues("pregunta19");
        String pregunta20[] = request.getParameterValues("pregunta20");
        String pregunta21[] = request.getParameterValues("pregunta21");
        String pregunta22[] = request.getParameterValues("pregunta22");
        String pregunta23[] = request.getParameterValues("pregunta23");
        String pregunta24[] = request.getParameterValues("pregunta24");
        String pregunta25[] = request.getParameterValues("pregunta25");
        gol.setPregunta13(pregunta13 == null ? "" : pregunta13[0]);
        gol.setPregunta14(pregunta14 == null ? "" : pregunta14[0]);
        gol.setPregunta15(pregunta15 == null ? "" : pregunta15[0]);
        gol.setPregunta16(pregunta16 == null ? "" : pregunta16[0]);
        gol.setPregunta17(pregunta17 == null ? "" : pregunta17[0]);
        gol.setPregunta18(pregunta18 == null ? "" : pregunta18[0]);
        gol.setPregunta19(pregunta19 == null ? "" : pregunta19[0]);
        gol.setPregunta20(pregunta20 == null ? "" : pregunta20[0]);
        gol.setPregunta21(pregunta21 == null ? "" : pregunta21[0]);
        gol.setPregunta22(pregunta22 == null ? "" : pregunta22[0]);
        gol.setPregunta23(pregunta23 == null ? "" : pregunta23[0]);
        gol.setPregunta24(pregunta24 == null ? "" : pregunta24[0]);
        gol.setPregunta25(pregunta25 == null ? "" : pregunta25[0]);
        System.out.println(ToStringBuilder.reflectionToString(gol));
        request.getSession().setAttribute("gol", gol);
    }

    public static void getpagina7(HttpServletRequest request) {
        GolBean gol = (GolBean) request.getSession().getAttribute("gol");
        gol.setBuroCredito(Integer.parseInt(request.getParameter("buroCredito")));
        if (gol.getBuroCredito() == 1) {
            gol.setAnt(Integer.parseInt(request.getParameter("ant")));
            gol.setAct(Integer.parseInt(request.getParameter("act")));
            gol.setHist(Integer.parseInt(request.getParameter("hist")));
            gol.setUso(Integer.parseInt(request.getParameter("uso")));
            gol.setPago(Integer.parseInt(request.getParameter("pago")));
            gol.setMop(Integer.parseInt(request.getParameter("mop")));
            gol.setCuentasA(request.getParameter("cuentasA"));
            gol.setMaximaA(request.getParameter("maximaA"));
            gol.setMontoA(request.getParameter("montoA"));
            gol.setLimiteA(request.getParameter("limiteA"));
            gol.setSaldoA(request.getParameter("saldoA"));
            gol.setCuentasC(request.getParameter("cuentasC"));
            gol.setMaximaC(request.getParameter("maximaC"));
            gol.setMontoC(request.getParameter("montoC"));
            gol.setLimiteC(request.getParameter("limiteC"));
            gol.setSaldoC(request.getParameter("saldoC"));
            gol.setImporteMop(request.getParameter("importeMop"));
            gol.setTipoCreditoMop(request.getParameter("tipoCreditoMop"));
            gol.setPagoRealizar(request.getParameter("pagoRealizar"));
        }
        gol.setMensualidad(request.getParameter("mensualidad"));
        gol.setValorVivienda(request.getParameter("valorVivienda"));
        System.out.println(ToStringBuilder.reflectionToString(gol));
        request.getSession().setAttribute("gol", gol);
    }

    /**
     *
     * @param prima
     * @param gol
     */
    public static GolBean getCargaPrima(PrimaBean prima, GolBean gol) {
        gol.setApellidoPaterno(prima.getApellidoPaterno());
        gol.setApellidoMaterno(prima.getApellidoMaterno());
        gol.setNombre(prima.getNombre());
        gol.setEdad(Integer.parseInt(prima.getEdad()));
        gol.setAnio(prima.getAnio());
        gol.setMes(prima.getMes());
        gol.setDia(prima.getDia());
        gol.setCalle(prima.getCalle());
        gol.setNoExterior(prima.getNoExterior());
        gol.setNoInterior(prima.getNoInterior());
        gol.setColonia(prima.getColonia());
        gol.setCp(prima.getCp());
        gol.setEdo("");
        gol.setMun("");
        gol.setEdoCivil(prima.getEdoCivil());
        gol.setTipoActividad(prima.getTipoActividad());
        gol.setSector(prima.getSector());
        gol.setSubsector(prima.getSubSector());
        gol.setRol(prima.getRol());
        gol.setDescripcionOcupacion(prima.getDescripcionOcupacion());
        gol.setValorVivienda(prima.getValorVivienda());
        gol.setMensualidad(prima.getMensualidad());
        // gol.setPersonasDep(prima.getDependientes());
        return gol;
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public void reporta() {

        Reportador r = new Reportador();
        r.calculaTodos();
    }

    private void guardarArbitraje(int idPrima, String idUsu, String clave) {
        ArbGolAu arb = new ArbGolAu(Integer.parseInt(idUsu), idPrima, clave.toUpperCase(), Calendar.getInstance().getTime());
        VerificadorArbitrajeGol verificador = new VerificadorArbitrajeGol(arb);
        verificador.guardarVerificar();
    }

    private String obtenerLista(String nombre) {
        System.out.println("obtiene la lista");
        StringBuilder builder=new StringBuilder();
        Dao dao=new Dao();
        List<CliGol> tabla = dao.getTabla(CliGol.class);
        for(CliGol gol:tabla){
            Cli usu = (Cli) dao.getCriteria(Cli.class, Restrictions.eq("cliId", gol.getCliMta().getCliMtaId()));
            if(usu.getCliNom().toUpperCase().contains(nombre.toUpperCase()) || usu.getCliApePat().toUpperCase().contains(nombre.toUpperCase())||
                    usu.getCliApeMat().toUpperCase().contains(nombre.toUpperCase())){
                
                builder.append("<option title='" + usu.getCliNom() + " "
								+ usu.getCliApePat() + " " + usu.getCliApeMat()
								+ "' value=\"" + usu.getCliId() + "|"
								+ gol.getCliGolId().intValue() + "\">" + usu.getCliApePat()
								+ " " + usu.getCliApeMat() + " " + usu.getCliNom()
								+ "</option>");
            }
            
        }
        
        return builder.toString();
    }
}
