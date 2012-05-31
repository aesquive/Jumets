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

<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml">
    <SCRIPT src='/URBI/js/UtileriasUrbi.js'></SCRIPT>
    <jsp:include page="JSIncludeEndeudamiento.jsp" />
    <script language="javascript">
        function validarFormaNE(){
            // alert("validando");
            //UtileriasUrbi.ejecutarValidacionFormaEndeudamiento();
            var boolValida = true;
            /*   'estado',
   'delegacion',*/
            var arrCampos =  ['apellidoPaterno',
                'apellidoMaterno',
                'nombre',
                'anio',
                'mes',
                'dia',
                'edad',
                'calle',
                'noExterior',
                'noInterior',
                'colonia',
                'codigoPostal',
                'sexo',
                'estadoCivil',
                'ingreso',
                'tasa',
                'periodoPago',
                'habitaViviendaActual',
                'laboraEmpleoActual',
                'gastoImp',
                'DineroExt',
                'conoceMtoBuro',
                'cuantoBuro',
                'cuantoMensualidad'];
            var arrInvalidos = [];
            var strVal="";
            for (var contador = 0; contador<arrCampos.length; contador++){
                //alert(arrCampos[contador]);
                try{
                    strVal = document.getElementById(''+arrCampos[contador]+'').value
                    if(
                    (strVal  == "" ) ||
                        (strVal  == - 1 ) ||
                        (strVal  == - 1 ) == null)
                    {
                        arrInvalidos.push(''+document.getElementById(arrCampos[contador])+'');
                        boolValida = false
                    }
                } catch(e){
                }
            }
            if(arrInvalidos.length > 0){
                alert("Favor de capturar todos los campos de la pantalla");
                boolValida = false;
            }
            if (boolValida == true){
        
                document.getElementById("sbmtBtnFrmEntradaDeuda").click();
                //document.getElementById("frmEntradaDeuda").onsubmit();
            } else {
                return;
            }
        }


    </script>
    <head>

        <%@page import="java.util.*" %>
        <%@page import="objetos.*" %>
        <%@page import="org.hibernate.*" %>

        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

        <title>Nivel Máximo de Endeudamiento</title>

        <link href="../css/main2.css" rel="stylesheet" type="text/css" />
        <link href="../css/textos.css" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../js/funciones.js"></script>
        <style type="text/css">
            <!--
            a:link {
                text-decoration: none;
            }
            a:visited {
                text-decoration: none;
            }
            a:hover {
                text-decoration: none;
            }
            a:active {
                text-decoration: none;
            }
            -->
        </style>
        <link href="../css/formulario.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
            <!--
            a:link {
                text-decoration: none;
            }
            a:visited {
                text-decoration: none;
            }
            a:hover {
                text-decoration: none;
            }
            a:active {
                text-decoration: none;
            }
            -->
        </style>
    </head>
    <%

                /* String accion = (String)request.getSession().getAttribute("accion");
                String id = (String)request.getSession().getAttribute("idCliente");
                String load;
                if(accion.equals("Agregar") || accion.equals("Modificar"))
                load = "activarControles(true)";
                else
                load = "activarControles(false)";
                 */



    %>
    <body onload="Endeudamiento.init(); UtileriasUrbi.init(); MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_exit.png','../images/acceso/activos_salir.png','../images/accesos_down/aplicacion-2_34.png','../images/accesos_down/aplicacion-2_28.png','../images/accesos_down/aplicacion-2_22.png','../images/acceso/activo-calc.png','../images/accesos_down/calc-2_28.png')" >
        <center>
            <div id="contenedor">
                <div id="encabezado">
                    <div id="borde_iz"></div>
                    <div id="logo">
                        <div id="data">
                            <div class="bodystyle">
                                <!--
					<form id="form1" name="form1" method="post" action="">
                                     <input name="textfield3" type="text" class="bodystyle" size="15" />
                                     <input name="textfield4" type="text" class="bodystyle" value="persona No. 5" size="19" />
                                 </form>
									-->

                            </div>
                        </div>
                    </div>
                    <div id="relleno">
                        <div id="capa_enc">
                            <table width="552" border="0" valign="right" cellpadding="0" cellspacing="0" class="textarea">
                                <tr>
                                    <td colspan="18" align="center" class="blackSubtitle">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td colspan="18" align="center" class="blueSubtitle">Nivel Máximo de Endeudamiento</td>
                                </tr>
                                <tr>
                                    <td colspan="18" align="center" class="whiteSubtitle">Mantenimiento a Personas</td>
                                </tr>
                                <tr>
                                    <td colspan="18" align="center" class="whiteSubtitle">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td rowspan="2" width="300">&nbsp;</td>
                                    <td width="39" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img src="../images/acceso/inactivos_add.png" name="add" width="33" height="33" border="0" class="button" id="add" onclick="Endeudamiento.onClickOnBtnAgregar()" /></a></td>
                                    <td width="10">&nbsp;</td>


                                    <td width="41" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"><img src="../images/acceso/inactivos_exit.png" name="exit" width="33" height="33" border="0" class="button" id="exit" onclick="Endeudamiento.onClickOnBtnCancelar()" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)" onclick="UtileriasUrbi.redireccionarInicioURBI()"></a></td>
                                    <td width="10">&nbsp;</td>
                                    <td width="39" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('salir','','../images/acceso/activos_salir.png',1)"><img src="../images/acceso/inactivos_salir.png" name="salir" width="32" height="33" border="0" class="button" id="salir" onclick="UtileriasUrbi.redireccionarInicioURBI()" /></a></td>
                                    <td width="10">&nbsp;</td>
                                    <td width="34" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image21','','../images/acceso/activo-calc.png',1)"><img src="../images/acceso/inactivo-calc.png" name="Image21" width="32" height="32" border="0" id="Image21" onclick="validarFormaNE()" /></a></td>
                                </tr>
                                <tr>
                                    <td height="19" class="whiteText"><div align="center">Agregar</div></td>
                                    <td class="whiteText"><div align="center"></div></td>


                                    <td class="whiteText"><div align="center">Cancelar</div></td>
                                    <td class="whiteText"><div align="center"></div></td>
                                    <td class="whiteText">Salir</td>
                                    <td class="whiteText"><div align="center"></div></td>
                                    <td class="whiteText"><a href="#" class="whiteText">Calcular</a></td>
                                    <td class="whiteText"><div align="center"></div></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div id="borde_der"></div>
                    <div id="contenido">
                        <div id="divContenedorTablaError" style="display:none">

                            <table border=0 cellpadding=0 cellspacing=0 id='tblError' />
                            <tr class="form_separator"><td ></td></tr>
                            <tr>
                                <td>
                                    <table border=1 cellpadding=0 cellspacing=0 bordercolor="#FF0000">
                                        <tr>
                                            <td bgcolor="#FFE6E6"><font id=errorMessage color="#FF0000"></font></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr class="form_separator"><td ></td></tr>
                            </table></div>

                        <!-- onsubmit=" return AIM.submit(this, {'onStart' : startCallback, 'onComplete' : completeCallback})"    -->
                        <form name="frmEntradaDeuda" id="frmEntradaDeuda" method="post" target="_blank" onsubmit=" return AIM.submit(this, {'onStart' : startCallback, 'onComplete' : completeCallback})" action = "../CalcularNivelMaximoEndeudamientoServlet">
                            <input type="hidden" id="command" name="command" value="NivelEndeudamiento" />
                            <input type="hidden" id="form" name="form" value="entradaDeuda" /><br />
                            <input type="submit" id="sbmtBtnFrmEntradaDeuda" name="sbmtBtnFrmEntradaDeuda" value="" width="0" height="0" tabindex="-1" style="border-collapse:collapse; background-color:#FFFFFF; width:0; height:0; display:none"  />
                            <br />
                            <br />
                            <table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td colspan="19">
                                        <fieldset>
                                            <legend class="blueSubtitle">Datos personales</legend>
                                            <table width="880" border="0" align="left" cellpadding="0" cellspacing="0">
                                                <tr>
                                                    <td colspan="7">&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" valign="top">
                                                        <fieldset>
                                                            <legend class="blackText1" style="font-weight:bold">Nombre</legend>
                                                            <table width="468" border="0" cellspacing="0" cellpadding="0" align="left">
                                                                <tr>
                                                                    <td width="149" align="left" class="blackText1">Apellido Paterno  </td>
                                                                    <td width="15">&nbsp;</td>
                                                                    <td width="144" align="left" class="blackText1">Apellido Materno  </td>
                                                                    <td width="15">&nbsp;</td>
                                                                    <td width="144" align="left" class="blackText1">Nombre  </td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="blackText1" align="left"><input type="text" name="apellidoPaterno" id="apellidoPaterno" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)" /></td>
                                                                    <td class="blackText1">&nbsp;</td>
                                                                    <td class="blackText1" align="left"><input type="text" name="apellidoMaterno" id="apellidoMaterno" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)" /></td>
                                                                    <td class="blackText1">&nbsp;</td>
                                                                    <td class="blackText1" align="left"><input type="text" name="nombre" id="nombre" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)" /></td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>                                                    </td>
                                                    <td width="336" valign="top">
                                                        <fieldset>
                                                            <legend class="blackText1" style="font-weight:bold">Fecha de Nacimiento</legend>
                                                            <table width="312" border="0" cellspacing="0" cellpadding="0" align="left">
                                                                <tr>
                                                                    <td class="blackText1" align="left">A&ntilde;o  </td>
                                                                    <td class="blackText1" align="left">&nbsp;</td>
                                                                    <td class="blackText1" align="left">Mes</td>
                                                                    <td class="blackText1" align="left">&nbsp;</td>
                                                                    <td class="blackText1" align="left">D&iacute;a</td>
                                                                    <td class="blackText1" align="left">&nbsp;</td>
                                                                    <td class="blackText1" align="left">Edad</td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="blackText1" align="right">
                                                                        <select id="anio" name="anio"   onchange="calcular_edad();" style="width:80px">
                                                                            <option value="-1">-A&ntilde;o-</option>
                                                                            <% for (int i = 1; i < 50; i++) {
                                                                                            int ano = 1945 + i;
                                                                            %>
                                                                            <option value="<%=ano%>"><%=ano%></option><%}%>
                                                                        </select>                                                                    </td>
                                                                    <td class="blackText1" align="left">&nbsp;</td>
                                                                    <td class="blackText1" align="left">
                                                                        <select id="mes" name="mes"   onchange="calcular_edad();">
                                                                            <option value="-1">-Mes-</option>
                                                                            <OPTION VALUE="1">Enero</OPTION>
                                                                            <OPTION VALUE="2">Febrero</OPTION>
                                                                            <OPTION VALUE="3">Marzo</OPTION>
                                                                            <OPTION VALUE="4">Abril</OPTION>
                                                                            <OPTION VALUE="5">Mayo</OPTION>
                                                                            <OPTION VALUE="6">Junio</OPTION>
                                                                            <OPTION VALUE="7">Julio</OPTION>
                                                                            <OPTION VALUE="8">Agosto</OPTION>
                                                                            <OPTION VALUE="9">Septiembre</OPTION>
                                                                            <OPTION VALUE="10">Octubre</OPTION>
                                                                            <OPTION VALUE="11">Noviembre</OPTION>
                                                                            <OPTION VALUE="12">Diciembre</OPTION>
                                                                        </select>                                                                    </td>
                                                                    <td class="blackText1" align="left">&nbsp;</td>
                                                                    <td class="blackText1" align="left"><select id="dia" name="dia"   onchange="calcular_edad();">
                                                                            <option value="-1">-D&iacute;a-</option>
                                                                            <%
                                                                                        for (int i = 1; i <= 31; i++) {
                                                                                            int dia = i;
                                                                            %>
                                                                            <option value="<%=dia%>"><%=dia%></option>
                                                                            <%}%>
                                                                        </select></td>
                                                                    <td class="blackText1" align="left">&nbsp;</td>
                                                                    <td class="blackText1" align="left">
                                                                        <input id="edad" name="edad" type="text" size="5" readonly/>                      																							</td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="7">
                                                        <fieldset>
                                                            <legend class="blackText1" style="font-weight:bold">Domicilio</legend>
                                                            <table width="880" border="0" cellspacing="0" cellpadding="0">
                                                                <tr>
                                                                    <td width="153" align="left" class="blackText1">Calle  </td>
                                                                    <td width="15" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="72" align="left" class="blackText1">No.Exterior  </td>
                                                                    <td width="15" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="72" align="left" class="blackText1">No.Interior</td>
                                                                    <td width="15" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="144" align="left" class="blackText1">Colonia</td>
                                                                    <td width="15" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="90" align="left" class="blackText1">C&oacute;digo Postal</td>
                                                                    <td width="15" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="147" align="left" class="blackText1">Estado</td>
                                                                    <td width="15" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="165" align="left" class="blackText1">Delegaci&oacute;n / Municipio</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" class="blackText1"><input type="text" name="calle" id="calle" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)" />                    </td>
                                                                    <td align="left" class="blackText1"><input name="noExterior" id="noExterior" type="text" size="7" onkeypress="return UtileriasUrbi.capturarSoloNumerosTextoConvertirMayusculas(event)" maxlength="5" /></td>
                                                                    <td align="left" class="blackText1"><input name="noInterior" id="noInterior" type="text" size="7" onkeypress="return UtileriasUrbi.capturarSoloNumerosTextoConvertirMayusculas(event)" /></td>
                                                                    <td align="left" class="blackText1"><input name="colonia" id="colonia" type="text" onkeypress="return UtileriasUrbi.capturarSoloNumerosTextoConvertirMayusculas(event)" />                    </td>
                                                                    <td align="left" class="blackText1"><input name="codigoPostal" id="codigoPostal" type="text" size="6" onkeypress="return UtileriasUrbi.capturarSoloNumerosTextoConvertirMayusculas(event)"
                                                                                                               onblur="UtileriasUrbi.cargarCodigoPostal('codigoPostal'); UtileriasUrbi.validarDigitosCodigoPostal('codigoPostal')" maxlength="5" />                    </td>
                                                                    <td align="left" class="blackText1"><input type="text" id="estado" name="estado" disabled="disabled" /></td>
                                                                    <td align="left" class="blackText1"><input type="text" id="delegacion" name="delegacion" disabled="disabled" /></td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td colspan="7">
                                                        <fieldset>
                                                            <table width="880" border="0" cellspacing="0" cellpadding="0" align="left">
                                                                <tr>
                                                                    <td width="10" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="210" class="blackText1" align="left">&iquest;Cu&aacute;l es su sexo? </td>
                                                                    <td width="210" class="blackText1" align="left">&iquest;Cu&aacute;l es su estado civil? </td>
                                                                    <td width="210" align="left" valign="middle" class="blackText1">&iquest;Qu&eacute; har&iacute;a si tuviera dinero extra?</td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="blackText1" align="left">
                                                                        <select name="sexo" id="sexo" >
                                                                            <option value="" selected="selected" >-Seleccione-</option>
                                                                            <option value="F">FEMENINO</option>
                                                                            <option value="M">MASCULINO</option>
                                                                        </select>
                                                                    </td>
                                                                    <td class="blackText1" align="left">
                                                                        <select name="estadoCivil" id="estadoCivil" class="anchoEstandardSelect">
                                                                            <option>-Seleccione-</option>
                                                                            <%
                                                                                        Session s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                                                                        Iterator it = null;
                                                                                        Transaction tx = s.beginTransaction();
                                                                                        Query q = s.createQuery("from EdoCvl as ec where ec.cal.calId = '4'");
                                                                                        it = (Iterator) q.iterate();
                                                                                        while (it.hasNext()) {
                                                                                            EdoCvl ec = (EdoCvl) it.next();
                                                                            %>
                                                                            <option title="<%=ec.getEdoCvlDes()%>" value="<%=ec.getEdoCvlId()%>"><%=ec.getEdoCvlDes()%></option>
                                                                            <%}%>
                                                                        </select>                                                                    
                                                                    </td>
                                                                    <td class="blackText1" align="left" valign="top">
                                                                        <select name="DineroExt" id="DineroExt" class="anchoEstandardSelect" >
                                                                            <option>-Seleccione-</option>
                                                                            <%
                                                                                        s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                                                                        it = null;
                                                                                        tx = s.beginTransaction();
                                                                                        q = s.createQuery("from DinExt as de where de.cal = '4'");
                                                                                        it = (Iterator) q.iterate();
                                                                                        while (it.hasNext()) {
                                                                                            DinExt de = (DinExt) it.next();
                                                                            %>
                                                                            <option title="<%=de.getDinExtDes()%>" value="<%=de.getDinExtId()%>"><%=de.getDinExtDes()%></option>
                                                                            <%}%>
                                                                        </select>
                                                                    </td>

                                                                </tr>
                                                            </table>
                                                        </fieldset>
                                                    </td>
                                                    <td width="10">&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td colspan="7"></td>
                                                </tr>
                                                <tr>
                                                    <td colspan="7">
                                                        <fieldset>
                                                            <table width="880" border="0" cellspacing="0" cellpadding="0">
                                                                <tr>
                                                                    <td width="10" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="210" align="left" class="blackText1" >&iquest;Hace cu&aacute;nto habita <br />en su vivienda actual?</td>
                                                                    <td width="210" align="left" class="blackText1">&iquest;Hace cu&aacute;nto labora <br />en su empleo actual?</td>
                                                                    <td width="210" align="left" valign="top" class="blackText1">&iquest;Qu&eacute; gasto  importante tiene <br />planeado para el pr&oacute;ximo a&ntilde;o?</td>

                                                                </tr>
                                                                <tr>
                                                                    <td class="blackText1" align="left">
                                                                        <input name="habitaViviendaActual" id="habitaViviendaActual" type="text" size="8" maxlength="2" onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)" />&nbsp;A&ntilde;os                                                                    </td>
                                                                    <td class="blackText1" align="left">
                                                                        <input name="laboraEmpleoActual" id="laboraEmpleoActual" type="text" size="8" maxlength="2"onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)" />&nbsp;A&ntilde;os                                                                    </td>
                                                                    <td class="blackText1" align="left" valign="top">
                                                                        <select name="gastoImp" id="gastoImp" class="anchoEstandardSelect" >
                                                                            <option>-Seleccione-</option>
                                                                            <%
                                                                                        s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                                                                        it = null;
                                                                                        tx = s.beginTransaction();
                                                                                        q = s.createQuery("from GtoImp as gi where gi.cal = '5'");
                                                                                        it = (Iterator) q.iterate();
                                                                                        while (it.hasNext()) {
                                                                                            GtoImp gi = (GtoImp) it.next();
                                                                            %>
                                                                            <option title="<%=gi.getGtoImpDes()%>" value="<%=gi.getGtoImpId()%>"><%=gi.getGtoImpDes()%></option>
                                                                            <%}%>
                                                                        </select>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td colspan="7"></td>
                                                </tr>
                                                <tr>
                                                    <td colspan="7">
                                                        <fieldset>
                                                            <table width="880" align="right" border="0" cellspacing="0" cellpadding="0">
                                                                <tr>
                                                                    <td width="10" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="210" class="blackText1" align="left">&iquest;Se requiere estimar <br />el ingreso?</td>
                                                                    <td width="210" align="left" class="blackText1">Ingreso</td>
                                                                    <td width="210" align="left" class="blackText1">Tasa</td>
                                                                    <td width="210" align="left" class="blackText1">Per&iacute;odo de pago </td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="blackText1" align="left" valign="top">

                                                                        <input name="rdgIn" id ="rdgIn" type="radio" valueTC="true" onclick="activaCombos();"/>
                                                                        <label> Si   </label>
                                                                        <br />
                                                                        <input name="rdgIn" type="radio" id ="rdgIn" value="false" checked="checked" onclick="activaCombos();" />
                                                                        <label> No   </label>
                                                                    </td>
                                                                    <td align="left" class="blackText1">$ &nbsp;<input type="text" name="ingreso" id="ingreso" disabled="disabled" onkeypress="return UtileriasUrbi.capturarSoloNumerosDecimalesIngreso(event)" size="12" maxlength="10" onblur="UtileriasUrbi.validarValorIngreso(this)" />
                                                                    </td>
                                                                    <td align="left" class="blackText1">
                                                                        <input name="tasa" id="tasa" type="text" size="5" maxlength="5" onkeypress="return UtileriasUrbi.capturarSoloNumerosEnterosTasa(event)" onblur="UtileriasUrbi.validarValorTasa(this)" onfocus="UtileriasUrbi.asignarFocoPrevioTasaNivelIngreso(this,'ingreso')"   />%
                                                                    </td>
                                                                    <td align="left" class="blackText1">
                                                                        <input name="periodoPago"id="periodoPago" type="text" size="5" maxlength="3" onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)" onblur="UtileriasUrbi.validarPeriodoPago(this)" />d&iacute;as
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                </tr>
                                                <tr>                     
                                                    <td colspan="7">
                                                        <fieldset>
                                                            <table width="880" border="0" cellspacing="0" cellpadding="0">
                                                                <tr>
                                                                    <td width="10" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                                                                    <td width="210" align="left" class="blackText1" >&iquest;Conoce su deuda en el <br />Buro nacional de Cr&eacute;dito?</td>
                                                                    <td width="210" align="left" valign="top" class="blackText1">&iquest;Cuanto?<br /> </td>
                                                                    <td width="210" align="left" valign="top" class="blackText1">Mensualidad a pagar</td>
                                                                </tr>
                                                                <tr>
                                                                    <td class="blackText1" align="left" valign="top">
                                                                        <input name="rdgBr" id ="rdgBr" type="radio" value="true" onclick="activarCombosBr();" />
                                                                        <label> Si   </label>
                                                                        <br />
                                                                        <input name="rdgBr" id ="rdgBr" type="radio" value="false" checked="checked" onclick="activarCombosBr();" />
                                                                        <label> No   </label>
                                                                    </td>
                                                                    <td class="blackText1" align="left">
                                                                        $ &nbsp;
                                                                        <input name="cuantoBuro" id="cuantoBuro" type="text" size="12" maxlength="10" disabled="disabled" onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)" />&nbsp;
                                                                    </td>
                                                                    <td class="blackText1" align="left">
                                                                        $ &nbsp;
                                                                        <input name="cuantoMensualidad" id="cuantoMensualidad" type="text" size="12" maxlength="10" disabled="disabled" onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)" />&nbsp;
                                                                    </td>
                                                                    <td class="blackText1" align="left" valign="top">
                                                                        &nbsp;
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </fieldset>
                                                    </td>
                                                </tr>
                                            </table>                                         
                                            <p>&nbsp;</p>           
                                        </fieldset>                                    </td>
                                </tr>
                                <tr><td height="30">&nbsp;</td></tr>
                                <tr>
                                    <td width="780">&nbsp;</td>
                                    <td width="42" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image20','','../images/accesos_down/aplicacion-2_22.png',1)"><img src="../images/accesos_down/aplicacion-23_22.png" name="Image20" width="32" height="32" border="0" id="Image20" onclick="Endeudamiento.onClickOnBtnAgregar()" /></a></td>
                                    <td width="8">&nbsp;</td>
                                    <td width="48" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image17','','../images/accesos_down/aplicacion-2_28.png',1)"><img src="../images/accesos_down/aplicacion-23_28.png" name="Image17" width="33" height="32" border="0" id="Image17" onclick="Endeudamiento.onClickOnBtnCancelar()" /></a></td>
                                    <td width="9">&nbsp;</td>
                                    <td width="44" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('salir2','','../images/accesos_down/aplicacion-2_34.png',1)"><img src="../images/accesos_down/aplicacion-23_34.png" name="salir2" width="32" height="32" border="0" id="salir2" onclick="UtileriasUrbi.redireccionarInicioURBI()" /></a></td>
                                    <td width="8">&nbsp;</td>
                                    <td width="36" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image22','','../images/accesos_down/calc-2_28.png',1)"><img src="../images/accesos_down/calc_28.png" name="Image22" width="32" height="33" border="0" id="Image22" onclick="validarFormaNE()" /></a></td>
                                    <td width="10">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td align="center" class="blueText">Agregar</td>
                                    <td>&nbsp;</td>
                                    <td align="center" class="blueText">Cancelar</td>
                                    <td>&nbsp;</td>
                                    <td align="center" class="blueText">Salir</td>
                                    <td>&nbsp;</td>
                                    <td align="center" class="blueText">Calcular</td>
                                </tr>
                                <tr>
                                    <td colspan="19">&nbsp;</td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div id="pie_pag"></div>
                </div>
            </div>
        </center>
    </body>
</html>
