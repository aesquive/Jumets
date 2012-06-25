<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
    Usuarios usuarioUrbi = (Usuarios) session.getAttribute("usuarioUrbi");
    if (usuarioUrbi == null) {
        try {
            response.sendRedirect("../index.jsp");
        } catch (IOException io) {
            System.out.println("ERROR:" + io.getMessage());
        }
    }

%>
<%@page import="com.urbi.prima.PrimaSql"%>
<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html
    xmlns="http://www.w3.org/1999/xhtml">
    <!-- InstanceBegin template="/Templates/plantilla3.dwt" codeOutsideHTMLIsLocked="false" -->
    <head>
        <%@page import="java.util.*"%>
        <%@page import="objetos.*"%>
        <%@page import="org.hibernate.*"%>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Prima Pura</title>
        <link href="../css/main2.css" rel="stylesheet" type="text/css" />
        <link href="../css/textos.css" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../js/funciones.js"></script>
        <script language="javascript" src="../js/gol.js"></script>
        <script>
            function activarControles(estado) {
                MM_preloadImages('../images/acceso/activos_add.png',
                '../images/acceso/activos_mod.png',
                '../images/acceso/activos_sup.png',
                '../images/acceso/activos_exit.png',
                '../images/acceso/activos_guardar.png',
                '../images/buscar_activo.png',
                '../images/acceso/activos_buscar.png',
                '../images/acceso/activos_salir.png',
                '../images/acceso/inactivo-blanco_salir.png',
                '../images/acceso/activos_left.png',
                '../images/acceso/activos_right.png');
                var frm = document.forms["PrimaMant"];
                frm.elements["apellidoMaterno"].disabled = estado;
                frm.elements["apellidoPaterno"].disabled = estado;
                frm.elements["nombre"].disabled = estado;
                frm.elements["anio"].disabled = estado;
                frm.elements["mes"].disabled = estado;
                frm.elements["dia"].disabled = estado;
                frm.elements["calle"].disabled = estado;
                frm.elements["noExterior"].disabled = estado;
                frm.elements["noInterior"].disabled = estado;
                frm.elements["colonia"].disabled = estado;
                frm.elements["cp"].disabled = estado;
                frm.elements["edoCivil"].disabled = estado;
                frm.elements["dependientes"].disabled = estado;
                frm.elements["ingresoMensual"].disabled = estado;
                frm.elements["tipoActividad"].disabled = estado;
                if (estado == false) {
                    frm.elements["sector"].disabled = true;
                    frm.elements["subSector"].disabled = true;
                    frm.elements["rol"].disabled = true;
                    frm.elements["descripcionOcupacion"].disabled = true;
                } else {
                    frm.elements["sector"].disabled = estado;
                    frm.elements["subSector"].disabled = estado;
                    frm.elements["rol"].disabled = estado;
                    frm.elements["descripcionOcupacion"].disabled = estado;
                }
                // frm.elements["descripcion"].disabled = estado;
                frm.elements["ubicacionVivienda"].disabled = estado;
                if (estado == false)
                    frm.elements["desarrollo"].disabled = true;
                else
                    frm.elements["desarrollo"].disabled = estado;
                frm.elements["valorVivienda"].disabled = estado;
                frm.elements["mensualidad"].disabled = estado;
            }
            
            
            function nuevoAgregar() {
                activarControles(false);
                ResetearControles();
            }


            function ResetearControles() {
                var frm = document.forms["PrimaMant"];
                frm.elements["apellidoMaterno"].value = "";
                frm.elements["apellidoPaterno"].value = "";
                frm.elements["nombre"].value = "";
                frm.elements["anio"].selectedIndex = 0;
                frm.elements["mes"].selectedIndex = 0;
                frm.elements["dia"].selectedIndex = 0;
                frm.elements["calle"].value = "";
                frm.elements["noExterior"].value = "";
                frm.elements["noInterior"].value = "";
                frm.elements["colonia"].value = "";
                frm.elements["cp"].value = "";
                frm.elements["edo"].value = "";
                frm.elements["mun"].value = "";
                frm.elements["edoCivil"].selectedIndex = 0;
                frm.elements["dependientes"].selectedIndex = 0;
                frm.elements["ingresoMensual"].selectedIndex = 0;
                frm.elements["tipoActividad"].selectedIndex = 0;
                frm.elements["sector"].selectedIndex = 0;
                frm.elements["subSector"].selectedIndex = 0;
                frm.elements["descripcionOcupacion"].value = "";
                frm.elements["rol"].selectedIndex = 0;
                frm.elements["ubicacionVivienda"].selectedIndex = 0;
                frm.elements["desarrollo"].selectedIndex = 0;
                frm.elements["valorVivienda"].value = "";
                frm.elements["mensualidad"].value = "";
            }

        </script>
        <script language="JavaScript" type="text/javascript" src="../js/ajax.js"></script>

        <link href="../css/formulario.css" rel="stylesheet" type="text/css" />
    </head>
    <%
        String accion = (String) request.getSession().getAttribute("accion");
        String id = (String) request.getSession().getAttribute("idCliente");
        String load;
        if (accion.equals("Agregar") || accion.equals("Modificar")) {
            load = "activarControles(true)";
        } else {
            load = "activarControles(false)";
        }
    %>
    <body onload="<%=load%>">
        <form name="PrimaMant" method="post" action="../PrimaMantServlet"
              onsubmit="return validate_form(this)">
            <input type="hidden" name="command" value="test" />
            <input type="hidden" name="accion" value="<%=accion%>" />
            <input type="hidden" name="idCliente" value="<%=id%>" />
            <input type="hidden" id="idPrima" name="idPrima" value="" />
            <center>
                <div id="contenedor">
                    <div id="encabezado">
                        <div id="borde_iz"></div>
                        <div id="logo"></div>
                        <div id="relleno">
                            <div id="capa_enc"><!-- InstanceBeginEditable name="region1" -->
                                <table width="552" border="0" valign="right" cellpadding="0"
                                       cellspacing="0" class="textarea">
                                    <tr>
                                        <td colspan="18" align="center" class="blackSubtitle">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td colspan="18" align="center" class="blueSubtitle">Prima Pura
                                            de Riesgo</td>
                                    </tr>
                                    <tr>
                                        <td colspan="18" align="center" class="whiteSubtitle">Mantenimiento
                                            a Personas</td>
                                    </tr>
                                    <tr>
                                        <td colspan="18" align="center" class="whiteSubtitle">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td width="47" align="center">&nbsp;</td>
                                        <td width="12"></td>
                                        <td width="63" align="center">&nbsp;</td>
                                        <td width="12"></td>
                                        <td width="51" align="center">&nbsp;</td>
                                        <td width="12"></td>
                                        <td width="49" align="center"><a href="#"
                                                                         onmouseout="MM_swapImgRestore()"
                                                                         onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"></a></td>
                                        <td width="12"></td>
                                        <td width="36" align="center"><a
                                                href="#" onmouseout="MM_swapImgRestore()"
                                                onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"></a></td>
                                        <td width="48" align="center"><a 
                                                href="#"
                                                onclick="nuevoAgregar();"
                                                onmouseout="MM_swapImgRestore()"
                                                onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img
                                                    src="../images/acceso/inactivos_add.png" name="add" width="33"
                                                    height="33" border="0" align="middle" class="button" id="add" /></a></td>
                                        <td width="16" align="center">&nbsp;</td>
                                        <td width="45" align="center" valign="middle"><a href="#"
                                                                                         onclick="BorrarControles();"
                                                                                         onmouseout="MM_swapImgRestore()"
                                                                                         onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"><img
                                                    src="../images/acceso/inactivos_exit.png" name="exit" width="33"
                                                    height="33" border="0" align="middle" class="button" id="exit" /></a></td>
                                        <td width="21" align="center"><a href="#"
                                                                         onmouseout="MM_swapImgRestore()"
                                                                         onmouseover="MM_swapImage('salir','','../images/acceso/inactivo-blanco_salir.png',1)"></a></td>
                                        <td width="42" align="center"><a
                                                href="#"
                                                onclick="ejecutar('Guardar', 'PrimaMant');"
                                                onmouseout="MM_swapImgRestore()"
                                                onmouseover="MM_swapImage('guardar','','../images/acceso/activos_guardar.png',1)"><img
                                                    src="../images/acceso/inactivos_guardar.png" name="guardar"
                                                    width="34" height="33" border="0" align="middle" class="button" id="guardar" /></a></td>
                                        <td width="12" align="center"></td>
                                        <td width="49" align="center"><a 
                                                href="#"
                                                onclick="salirPrima();"
                                                onmouseout="MM_swapImgRestore()"
                                                onmouseover="MM_swapImage('salir','','../images/acceso/activos_salir.png',1)"><img
                                                    src="../images/acceso/inactivos_salir.png" name="salir" width="32"
                                                    height="33" border="0" align="middle" class="button" id="salir" /></a></td>
                                        <td width="25"></td>
                                    </tr>
                                    <tr>
                                        <td height="19" class="whiteText">
                                            <div align="center">&nbsp;</div>		</td>
                                        <td class="whiteText">
                                            <div align="center"></div>		</td>
                                        <td class="whiteText">
                                            <div align="center"></div>		</td>
                                        <td class="whiteText">
                                            <div align="center"></div>		</td>
                                        <td class="whiteText">
                                            <div align="center"></div>		</td>
                                        <td class="whiteText">
                                            <div align="center"></div>		</td>
                                        <td class="whiteText">
                                            <div align="center"></div>		</td>
                                        <td class="whiteText">
                                            <div align="center"></div>		</td>
                                        <td class="whiteText">
                                            <div align="center"></div>		</td>
                                        <td align="center" valign="middle" class="whiteText">
                                            <div align="center">Agregar</div>		</td>
                                        <td class="whiteText">
                                            <div align="center"></div>		</td>
                                        <td align="center" valign="middle" class="whiteText">
                                            <div align="center">Cancelar</div>		</td>
                                        <td class="whiteText">
                                            <div align="center"></div>		</td>
                                        <td align="center" valign="middle" class="whiteText">
                                            <div align="center">Guardar</div>		</td>
                                        <td class="whiteText">
                                            <div align="center"></div>		</td>
                                        <td align="center" valign="middle" class="whiteText">
                                            <div align="center">Salir</div>		</td>
                                    </tr>
                                </table>
                                <!-- InstanceEndEditable --></div>
                        </div>
                        <div id="borde_der"></div>
                        <div id="contenido"><!-- InstanceBeginEditable name="Region2" -->
                            <%@include file="../ErrorTag.jsp"%>
                            <table width="867" border="0" align="center" cellpadding="0"
                                   cellspacing="0">
                                <tr>
                                    <td width="867" height="7" colspan="17">
                                        <fieldset>
                                            <table width="841" height="266" border="0" align="center"
                                                   cellpadding="0" cellspacing="0">
                                                <tr>
                                                    <td colspan="7"> </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" valign="top">
                                                        <fieldset><legend class="blackText1"
                                                                          style="font-weight: bold">Nombre</legend>
                                                            <table width="468" border="0" cellspacing="0" cellpadding="0"
                                                                   align="left">
                                                                <tr>
                                                                    <td width="149" align="left" class="blackText1">Apellido
                                                                        Paterno</td>
                                                                    <td width="15">&nbsp;</td>
                                                                    <td width="144" align="left" class="blackText1">Apellido
                                                                        Materno</td>
                                                                    <td width="16">&nbsp;</td>
                                                                    <td width="144" align="left" class="blackText1">Nombre</td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="blackText1" align="left"><input type="text"
                                                                                                               name="apellidoPaterno" onkeypress="AceptaAlfanumericoYPunto()"
                                                                                                               id="apellidoPaterno"
                                                                                                               class="mayus"
                                                                                                               disabled /></td>
                                                                    <td class="blackText1">&nbsp;</td>
                                                                    <td class="blackText1" align="left"><input type="text"
                                                                                                               name="apellidoMaterno" onkeypress="AceptaAlfanumericoYPunto()"
                                                                                                               id="apellidoMaterno"
                                                                                                               class="mayus"
                                                                                                               disabled /></td>
                                                                    <td class="blackText1">&nbsp;</td>
                                                                    <td class="blackText1" align="left"><input type="text"
                                                                                                               class="mayus"
                                                                                                               id="nombre"
                                                                                                               name="nombre" onkeypress="AceptaAlfanumericoYPunto()" disabled /></td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>
                                                    </td>
                                                    <td width="338" valign="top">
                                                        <fieldset><legend class="blackText1"
                                                                          style="font-weight: bold">Fecha de Nacimiento</legend>
                                                            <table width="308" border="0" cellspacing="0" cellpadding="0">
                                                                <tr>
                                                                    <td width="92" align="left" class="blackText1">A&ntilde;o</td>
                                                                    <td width="87" align="left" class="blackText1">Mes</td>
                                                                    <td width="87" align="left" class="blackText1">&nbsp;&nbsp;&nbsp;D&iacute;a</td>
                                                                    <td width="42" align="left" class="blackText1">Edad</td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="blackText1" align="left"><select id="anio"
                                                                                                                name="anio" disabled onchange="calcular_edad();">
                                                                            <option value="-1">-A&ntilde;o-</option>
                                                                            <%
                                                                                for (int i = 1; i < 50; i++) {
                                                                                    int ano = 1945 + i;
                                                                            %>
                                                                            <option value="<%=ano%>"><%=ano%></option>
                                                                            <%
                                                                                }
                                                                            %>
                                                                        </select></td>
                                                                    <td class="blackText1" align="left"><select id="mes"
                                                                                                                name="mes" disabled onchange="calcular_edad();">
                                                                            <option value="-1">-Mes-</option>
                                                                            <option value="01">Enero</option>
                                                                            <option value="02">Febrero</option>
                                                                            <option value="03">Marzo</option>
                                                                            <option value="04">Abril</option>
                                                                            <option value="05">Mayo</option>
                                                                            <option value="06">Junio</option>
                                                                            <option value="07">Julio</option>
                                                                            <option value="08">Agosto</option>
                                                                            <option value="09">Septiembre</option>
                                                                            <option value="10">Octubre</option>
                                                                            <option value="11">Noviembre</option>
                                                                            <option value="12">Diciembre</option>
                                                                        </select></td>
                                                                    <td class="blackText1" align="left">&nbsp;&nbsp; <select
                                                                            id="dia" name="dia" disabled onchange="calcular_edad();">
                                                                            <option value="-1">-D&iacute;a-</option>
                                                                            <%
                                                                                for (int i = 1; i <= 31; i++) {
                                                                                    int dia = i;
                                                                            %>
                                                                            <option value="<%=(String.valueOf(dia).length() == 1) ? "0" + dia : dia%>"><%=dia%></option>
                                                                            <%
                                                                                }
                                                                            %>
                                                                        </select></td>
                                                                    <td class="blackText1" align="left"><input id="edad"
                                                                                                               name="edad" type="text" size="5" readonly /></td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="7">
                                                        <fieldset><legend class="blackText1"
                                                                          style="font-weight: bold">Domicilio</legend>
                                                            <table width="835" border="0" cellspacing="0" cellpadding="0">
                                                                <tr>
                                                                    <td width="147" align="left" class="blackText1">Calle</td>
                                                                    <td width="63" align="left" class="blackText1">No.Exterior</td>
                                                                    <td width="4" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="69" align="left" class="blackText1">No.Interior</td>
                                                                    <td width="152" align="left" class="blackText1">Colonia</td>
                                                                    <td colspan="2" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="90" align="left" class="blackText1">C&oacute;digo
                                                                        Postal</td>
                                                                    <td colspan="2" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="147" align="left" class="blackText1">Estado</td>
                                                                    <td width="163" align="left" class="blackText1">Delegaci&oacute;n/
                                                                        Municipio</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" class="blackText1"><input type="text"
                                                                                                               id="calle" name="calle" class="mayus" disabled /></td>
                                                                    <td align="left" class="blackText1"><input name="noExterior"
                                                                                                               type="text" size="8" disabled /></td>
                                                                    <td align="left" class="blackText1"><input name="noInterior"
                                                                                                               type="text" size="8" disabled /></td>
                                                                    <td align="left" class="blackText1"><input name="colonia" id="colonia" 
                                                                                                               class="mayus"
                                                                                                               type="text" disabled /></td>
                                                                    <td align="left" class="blackText1"><input id="cp" name="cp"
                                                                                                               maxlength="5" type="text" size="15" onkeypress="AceptaNumerico();"
                                                                                                               onblur="cargaCP();cpValidacion()" /></td>
                                                                    <td align="left" class="blackText1">
                                                                        <div id="estadoDiv"><input type="text" id="edo" name="edo" readonly /></div>
                                                                    </td>
                                                                    <td align="left" class="blackText1">
                                                                        <div id="municipioDiv"><input type="text" id="mun" name="mun"
                                                                                                      readonly /></div>
                                                                    </td>

                                                                </tr>
                                                            </table>
                                                        </fieldset>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="7">&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td width="174" height="54" valign="top">
                                                        <fieldset>
                                                            <table width="172" border="0" cellspacing="0" cellpadding="0"
                                                                   align="left">
                                                                <tr>
                                                                    <td width="145" class="blackText1" align="left">&iquest;Cu&aacute;l
                                                                        es su estado civil?</td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="blackText1" align="left"><select id="edoCivil" name="edoCivil"
                                                                                                                disabled>
                                                                            <option value="-1">-Seleccione-</option>
                                                                            <%
                                                                                Session s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                                                                Iterator it = null;
                                                                                Transaction tx = s.beginTransaction();
                                                                                Query q = s.createQuery("from EdoCvl as ec where ec.cal.calId = '4'");
                                                                                it = (Iterator) q.iterate();
                                                                                while (it.hasNext()) {
                                                                                    EdoCvl ec = (EdoCvl) it.next();
                                                                            %>
                                                                            <option value="<%=ec.getEdoCvlId()%>"><%=ec.getEdoCvlDes()%></option>
                                                                            <%
                                                                                }
                                                                            %>
                                                                        </select></td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>
                                                    </td>
                                                    <td width="20">&nbsp;</td>
                                                    <td colspan="2" valign="top">
                                                        <fieldset>
                                                            <table width="298" border="0" cellspacing="0" cellpadding="0">
                                                                <tr>
                                                                    <td align="left" class="blackText1">&iquest;Cu&aacute;ntas
                                                                        personas son sus dependientes econ&oacute;micos?</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" class="blackText1"><select
                                                                            name="dependientes" disabled>
                                                                            <option value="-1">-Seleccione-</option>
                                                                            <%
                                                                                s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                                                                it = null;
                                                                                tx = s.beginTransaction();
                                                                                q = s.createQuery("from DepEco as de where de.cal.calId = '4'");
                                                                                it = (Iterator) q.iterate();
                                                                                while (it.hasNext()) {
                                                                                    DepEco de = (DepEco) it.next();
                                                                            %>
                                                                            <option value="<%=de.getDepEcoId()%>"><%=de.getDepEcoDes()%></option>
                                                                            <%
                                                                                }
                                                                            %>
                                                                        </select></td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>
                                                         </td>
                                                    <td valign="top" class="blackText1" align="left"></td>
                                                    <td colspan="2" valign="top">
                                                        <fieldset>
                                                            <table width="314" border="0" cellspacing="0" cellpadding="0"
                                                                   align="left">
                                                                <tr>
                                                                    <td width="337" class="blackText1" align="left">&iquest;De
                                                                        cu&aacute;nto es su ingreso mensual?</td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="blackText1" align="left">
                                                                        <div align="left"><select name="ingresoMensual" disabled>
                                                                                <option value="-1">-Seleccione-</option>
                                                                                <%
                                                                                    s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                                                                    it = null;
                                                                                    tx = s.beginTransaction();
                                                                                    q = s.createQuery("from Ing as ing where ing.cal.calId = '4'");
                                                                                    it = (Iterator) q.iterate();
                                                                                    while (it.hasNext()) {
                                                                                        Ing ing = (Ing) it.next();
                                                                                %>
                                                                                <option value="<%=ing.getIngId()%>"><%=ing.getIngDes()%></option>
                                                                                <%
                                                                                    }
                                                                                %>
                                                                            </select></div>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="7"></td>
                                                </tr>
                                                <tr>
                                                    <td colspan="3" valign="top">
                                                        <fieldset><legend class="blackText1"
                                                                          style="font-weight: bold">Ocupación Principal</legend>
                                                            <table width="404" height="206" border="0" cellpadding="0"
                                                                   cellspacing="0">
                                                                <tr>
                                                                    <td width="149" height="10" align="left" class="blackText1">Tipo
                                                                        de actividad</td>
                                                                    <td width="32">&nbsp;</td>
                                                                    <td width="223" colspan="3" align="center" class="blackText1">Descripci&oacute;n
                                                                        de la ocupaci&oacute;n</td>
                                                                </tr>
                                                                <tr>
                                                                    <td height="20" align="left" class="blackText1">
                                                                        <select id="tipoActividad" name="tipoActividad" disabled
                                                                                onchange="carga('tipoActividad', 'sector', 1, 6,-1)">
                                                                            <option value="-1">-Seleccione-</option>
                                                                            <%=PrimaSql.getTipoActividad("6", "")%>
                                                                        </select>
                                                                    </td>
                                                                    <td rowspan="7">&nbsp;</td>
                                                                    <td colspan="3" rowspan="4" align="center" valign="top"
                                                                        class="blackText1"><textarea id="descripcionOcupacion" name="descripcionOcupacion"
                                                                                                 class="mayus"
                                                                                                 cols="30" rows="5" disabled></textarea></td>
                                                                </tr>
                                                                <tr>
                                                                    <td height="10" align="left" class="blackText1">&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td height="10" align="left" class="blackText1">Sector</td>
                                                                </tr>
                                                                <tr>
                                                                    <td height="20" align="left" class="blackText1">
                                                                        <div id="sectorDiv">
                                                                            <select class="combo_140" id="sector"
                                                                                    name="sector" onchange="carga('sector', 'subSector', 2, 6,-1)">
                                                                                <option value="-1">-Seleccione-</option>
                                                                            </select>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td height="10" align="left" class="blackText1">&nbsp;</td>
                                                                    <td height="10" colspan="3" align="center" valign="top"
                                                                        class="blackText1">&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td height="36" align="left" class="blackText1">Subsector</td>
                                                                    <td colspan="3" align="center" class="blackText1" valign="top">En
                                                                        el trabajo que desempe&ntilde;a,<br />
                                                                        &iquest;cu&aacute;l es su rol en la organizaci&oacute;n?</td>
                                                                </tr>
                                                                <tr>
                                                                    <td height="20" align="left" class="blackText1">
                                                                        <div id="subsectorDiv">
                                                                            <select class="combo_140" id="subSector" name="subSector">
                                                                                <option value="-1">-Seleccione-</option>
                                                                            </select>
                                                                        </div>
                                                                    </td>
                                                                    <td colspan="3" align="center" class="blackText1" valign="middle">
                                                                        <select name="rol" id="rol" disabled>
                                                                            <option value="-1">-Seleccione-</option>
                                                                            <%
                                                                                s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                                                                it = null;
                                                                                tx = s.beginTransaction();
                                                                                q = s.createQuery("from Rol  as rol where rol.calId = '2'");
                                                                                it = (Iterator) q.iterate();
                                                                                while (it.hasNext()) {
                                                                                    Rol rol = (Rol) it.next();
                                                                            %>
                                                                            <option value="<%=rol.getRolId()%>"><%=rol.getRolDes()%></option>
                                                                            <%
                                                                                }
                                                                            %>
                                                                        </select></td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>
                                                    </td>
                                                    <td colspan="4" valign="top">
                                                        <table width="437" height="174" border="0" cellpadding="0"
                                                               cellspacing="0">
                                                            <tr>
                                                                <td height="2" colspan="2" valign="top">&nbsp;</td>
                                                            </tr>
                                                            <tr>
                                                                <td height="74" colspan="2" valign="top">
                                                                    <fieldset>
                                                                        <table width="431" height="63" border="0" cellpadding="0"
                                                                               cellspacing="0">
                                                                            <tr>
                                                                                <td width="194" align="left" valign="top" class="blackText1">&iquest;En
                                                                                    qu&eacute; estado est&aacute; ubicada<br />
                                                                                    la vivienda que quiere?</td>
                                                                                <td width="121" valign="middle" class="blackText1" align="left">Desarrollo</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td valign="top" align="left" class="blackText1">
                                                                                    <select class="combo_200" id="ubicacionVivienda" name="ubicacionVivienda" disabled
                                                                                            onchange="cargaDesarrollo('ubicacionVivienda', 'desarrollo', 4, 6,-1)">
                                                                                        <option value="-1">-Seleccione-</option>
                                                                                        <%=PrimaSql.getEdoVivienda("1", "")%>
                                                                                    </select>
                                                                                </td>
                                                                                <td valign="top" align="left" class="blackText1">
                                                                                    <div id="desarrolloDiv">
                                                                                        <select class="combo_200" id="desarrollo" name="desarrollo" disabled>
                                                                                            <option value="-1">-Seleccione-</option>
                                                                                        </select>
                                                                                    </div>
                                                                                </td>
                                                                                <%
                                                                                    s.close();
                                                                                %>
                                                                            </tr>
                                                                        </table>
                                                                    </fieldset>
                                                                     </td>
                                                            </tr>
                                                            <tr>
                                                                <td width="189" height="86" valign="top">
                                                                    <fieldset>
                                                                        <table width="168" height="55" border="0" cellpadding="0"
                                                                               cellspacing="0">
                                                                            <tr>
                                                                                <td valign="bottom" class="blackText1" align="left">Valor
                                                                                    de la vivienda</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td valign="bottom" class="blackText1" align="left"><input
                                                                                        type="text" id="valorVivienda" name="valorVivienda" disabled
                                                                                        onkeypress="AceptaNumerico();"
                                                                                        onblur="valVivienda();"/></td>
                                                                            </tr>
                                                                        </table>
                                                                    </fieldset>
                                                                     </td>
                                                                <td width="219" valign="top">
                                                                    <fieldset>
                                                                        <table width="244" height="53" border="0" cellpadding="0"
                                                                               cellspacing="0">
                                                                            <tr>
                                                                                <td height="36" align="left" valign="top" class="blackText1">&iquest;Qu&eacute;
                                                                                    mensualidad puede pagar<br />
                                                                                    para la vivienda que quiere adquirir?</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td valign="top" align="left" class="blackText1"><input
                                                                                        type="text" id="mensualidad" name="mensualidad" disabled
                                                                                        onkeypress="AceptaNumerico();" 
                                                                                        onblur="valMensu();"/></td>
                                                                            </tr>
                                                                        </table>
                                                                    </fieldset>
                                                                     </td>
                                                            </tr>
                                                        </table>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td colspan="2" align="left" valign="top" class="blackText1"></td>
                                                    <td width="217" valign="top"></td>
                                                    <td width="92" valign="top"></td>
                                                    <td width="10" class="blackText1" align="left" valign="top"></td>
                                                    <td width="2" align="left" valign="top" class="blackText1"></td>
                                                </tr>
                                                <tr>
                                                    <td colspan="7"></td>
                                                </tr>
                                            </table>
                                            <p>&nbsp;</p>
                                        </fieldset>
                                    </td>
                                </tr>

                                <tr>
                                    <td width="401" height="7">&nbsp;</td>
                                    <td width="50" align="center">&nbsp;</td>
                                    <td width="4">&nbsp;</td>
                                    <td width="57" align="center">&nbsp;</td>
                                    <td width="5" height="7">&nbsp;</td>
                                    <td width="51" height="7" align="center">&nbsp;</td>
                                    <td width="4" height="7">&nbsp;</td>
                                    <td width="52" height="7" align="center">&nbsp;</td>
                                    <td width="4" height="7">&nbsp;</td>
                                    <td width="51" height="7" align="center"><a
                                            href="#" 
                                            onclick="nuevoAgregar()"
                                            onmouseout="MM_swapImgRestore()"
                                            onmouseover="MM_swapImage('Image18','','../images/accesos_down/aplicacion-2_22.png',1)"><img
                                                src="../images/accesos_down/aplicacion-23_22.png" name="Image18"
                                                width="32" height="32" border="0" id="Image18" /></a></td>
                                    <td width="6" height="7">&nbsp;</td>
                                    <td width="48" height="7" align="center"><a href="#"
                                                                                onclick="BorrarControles()" onmouseout="MM_swapImgRestore()"
                                                                                onmouseover="MM_swapImage('Image15','','../images/accesos_down/aplicacion-2_28.png',1)"><img
                                                src="../images/accesos_down/aplicacion-23_28.png" name="Image15"
                                                width="33" height="32" border="0" id="Image15" /></a></td>
                                    <td width="6" height="7">&nbsp;</td>
                                    <td width="47" height="7" align="center"><a
                                            href="#"
                                            onclick="ejecutar('Guardar', 'PrimaMant')"
                                            onmouseout="MM_swapImgRestore()"
                                            onmouseover="MM_swapImage('Image14','','../images/accesos_down/aplicacion-2_30.png',1)"><img
                                                src="../images/accesos_down/aplicacion-23_30.png" name="Image14"
                                                width="33" height="32" border="0" id="Image14" /></a></td>
                                    <td width="7" height="7">&nbsp;</td>
                                    <td width="39" height="7" align="center" colspan="2"><a
                                            href="#"
                                            onclick="salirPrima();"
                                            onmouseout="MM_swapImgRestore()"
                                            onmouseover="MM_swapImage('Image12','','../images/accesos_down/aplicacion-2_34.png',1)"><img
                                                src="../images/accesos_down/aplicacion-23_34.png" name="Image12"
                                                width="32" height="32" border="0" id="Image12" /></a></td>
                                </tr>
                                <tr>
                                    <td height="7">&nbsp;</td>
                                    <td height="7" class="blueText" align="center">&nbsp;</td>
                                    <td height="7">&nbsp;</td>
                                    <td height="7" class="blueText" align="center">&nbsp;</td>
                                    <td height="7">&nbsp;</td>
                                    <td height="7" class="blueText" align="center">&nbsp;</td>
                                    <td height="7">&nbsp;</td>
                                    <td height="7" class="blueText" align="center">&nbsp;</td>
                                    <td height="7">&nbsp;</td>
                                    <td height="7" class="blueText" align="center">Agregar</td>
                                    <td height="7">&nbsp;</td>
                                    <td height="7" class="blueText" align="center">Cancelar</td>
                                    <td height="7">&nbsp;</td>
                                    <td height="7" class="blueText" align="center">Guardar</td>
                                    <td height="7">&nbsp;</td>
                                    <td height="7" colspan="2" class="blueText" align="center">Salir</td>
                                </tr>
                            </table>
                            <!-- InstanceEndEditable --></div>
                        <div id="pie_pag"></div>
                    </div>
                </div>
            </center>
        </form>
    </body>
    <!-- InstanceEnd -->
</html>