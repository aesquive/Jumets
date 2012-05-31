<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml">
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
    <head>
        <jsp:include page="JSIncludeEndeudamiento.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

        <title>Nivel M&aacute;ximo de Endeudamiento</title>

        <link href="../css/main2.css" rel="stylesheet" type="text/css" />
        <link href="../css/textos.css" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../js/funciones.js"></script>


        <link href="../css/formulario.css" rel="stylesheet" type="text/css" />
        ç
        <%
                    System.out.println(">>>>>> INICIO <<<<<< ");
                    //System.out.println(request.getSession().getAttribute("strXMLCalculaNE"));
                    System.out.println(">>>>>> FIN <<<<<< ");
        %>
        <script language="javascript"  >

            <%

                        //   String strJson = (String)request.getSession().getAttribute("jsonParams").toString().replaceAll("\r\n", "");
                        String strJson = "";

            %>


                function loadDataToTableCalculo(){

                    var jsonXmlStringParsed = "<%=strJson%>";



                    jsonResultadosCalcularNivelMaximoEndeudamiento=xml2json.parser(jsonXmlStringParsed);
 
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_0y10",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_0y10);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_1y10",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_1y10);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_2y10",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_2y10);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_3y10",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_3y10);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("E_MAX_ESP_10",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.e_max_esp_10);

                    //PC %
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamientoPorcentaje("PC_MAX_10",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.pc_max_10);

                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_0y15",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_0y15);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_1y15",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_1y15);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_2y15",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_2y15);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_3y15",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_3y15);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("E_MAX_ESP_15",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.e_max_esp_15);

                    //PC %
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamientoPorcentaje("PC_MAX_15" ,jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.pc_max_15);

                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_0y20",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_0y20);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_1y20",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_1y20);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_2y20",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_2y20);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("NE_ESPERADO_3y20",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.ne_esperado_3y20);
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamiento("E_MAX_ESP_20",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.e_max_esp_20);

                    //PC %
                    Endeudamiento.definirValorTDResultadosCalcularNivelMaximoEndeudamientoPorcentaje("PC_MAX_20",jsonResultadosCalcularNivelMaximoEndeudamiento.salidacalculadorane.pc_max_20);
 
                }
 
        </script>

    </head>
    <body onload="loadDataToTableCalculo();MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_mod.png','../images/acceso/activos_sup.png','../images/acceso/activo-calc.png','../images/acceso/activos_exit.png','../images/acceso/activo-cal.png','../images/acceso/activos_salir.png');" >



        <center>
            <div id="contenedor">
                <div id="encabezado">
                    <div id="borde_iz"></div>
                    <div id="logo"></div>
                    <div id="relleno">
                        <div id="capa_enc">

                            <table width="321" border="0" valign="right" cellpadding="0" cellspacing="0" class="whiteSubtitle">
                                <tr>
                                    <td colspan="9" align="center" class="blueSubtitle">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td colspan="9" align="center" class="blueSubtitle">Nivel M&aacute;ximo de Endeudamiento</td>
                                </tr>
                                <tr>
                                    <td colspan="9" align="center" class="whiteSubtitle">Calcular Nivel M&aacute;ximo Endeudamiento </td>
                                </tr>
                                <tr>
                                    <td colspan="9" align="center" class="whiteSubtitle">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td width="43" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"></a></td>
                                    <td width="19">&nbsp;</td>
                                    <td width="46" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('delete','','../images/acceso/activos_sup.png',1)"></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('mod','','../images/acceso/activos_mod.png',1)"></a></td>
                                    <td width="19">&nbsp;</td>
                                    <td width="58" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('delete','','../images/acceso/activos_sup.png',1)"></a></td>
                                    <td width="12">&nbsp;</td>
                                    <td width="54" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"></a></td>
                                    <td width="19">&nbsp;</td>
                                    <td width="51" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image1','','../images/acceso/activos_salir.png',1)"><img src="../images/acceso/inactivos_salir.png" name="Image1" width="32" height="33" border="0" id="Image1" onclick="window.location='/URBI/'" /></a><a href="../index_autent.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"></a></td>
                                </tr>
                                <tr>
                                    <td class="whiteText" align="center">&nbsp;</td>
                                    <td class="whiteTitle"></td>
                                    <td class="whiteText" align="center">&nbsp;</td>
                                    <td class="whiteTitle"></td>
                                    <td class="whiteText" align="center">&nbsp;</td>
                                    <td class="whiteTitle"></td>
                                    <td class="whiteText" align="center">&nbsp;</td>
                                    <td class="whiteTitle"></td>
                                    <td class="whiteText" align="center">Salir</td>
                                </tr>
                            </table>
                            <p><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('calc','','../images/acceso/activo-cal.png',1)"></a>     	</div>
                    </div>
                    <div id="borde_der"></div>
                    <div id="contenido">

                        <p>
                            <table width="900" border="0" align="center" cellpadding="0" cellspacing="0">

                                <tr>
                                    <td width="36" align="left" valign="top">&nbsp;</td>
                                    <td colspan="2" rowspan="2" align="left" valign="top" class="blackText1">
                                        <table width="792" height="80" border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <td height="10" colspan="3" valign="top" align="left" class="blackText1">
                                            </tr>
                                            <tr>
                                                <td align="center" valign="top"><fieldset class="blackTitle">
                                                        Resultados
                                                    </fieldset> </td>
                                            </tr>
                                            <tr>
                                                <td height="20" colspan="2" valign="top" align="center" class="blackText1"><fieldset>
                                                        <table width="880" border="1" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td width="150" rowspan="2" valign="middle" align="center" class="blackText1">Tiempo de Hipoteca<br />
                                                                    (A&ntilde;os) </td>
                                                                <td colspan="4" valign="middle" align="center" class="blackText1">Escenarios</td>
                                                                <td width="157" rowspan="2" valign="middle" align="center" class="blackText1"><p>Endeudamiento m&aacute;ximo esperado </p>                  </td>
                                                                <td width="157" rowspan="2" valign="middle" align="center" class="blackText1"><p>%<br />
                                                                        Endeudamiento m&aacute;ximo</p>                  </td>
                                                            </tr>
                                                            <tr>
                                                                <td width="100" bgcolor="#0C41A5" class="whiteTitle" align="center" valign="top">0</td>
                                                                <td width="100" bgcolor="#0D42A6" class="whiteTitle" align="center" valign="top">I</td>
                                                                <td width="100" bgcolor="#0D44A8" class="whiteTitle" align="center" valign="top">II</td>
                                                                <td width="100" bgcolor="#0B3EA3" class="whiteTitle" align="center" valign="top">III</td>
                                                            </tr>
                                                            <tr>
                                                                <td bgcolor="#0B3BA2" class="whiteTitle" align="center" valign="top">10</td>
                                                                <td	id ="NE_ESPERADO_0y10">&nbsp;</td>
                                                                <td	id ="NE_ESPERADO_1y10" >&nbsp;</td>
                                                                <td	id ="NE_ESPERADO_2y10" >&nbsp;</td>
                                                                <td	id ="NE_ESPERADO_3y10" >&nbsp;</td>
                                                                <td	id ="E_MAX_ESP_10" >&nbsp;</td>
                                                                <td	id ="PC_MAX_10"    >&nbsp;</td>
                                                            </tr>
                                                            <tr>
                                                                <td bgcolor="#0B40A5" class="whiteTitle" align="center" valign="top">15</td>
                                                                <td	id ="NE_ESPERADO_0y15">&nbsp;</td>
                                                                <td	id ="NE_ESPERADO_1y15">&nbsp;</td>
                                                                <td	id ="NE_ESPERADO_2y15">&nbsp;</td>
                                                                <td	id ="NE_ESPERADO_3y15">&nbsp;</td>
                                                                <td	id ="E_MAX_ESP_15">&nbsp;</td>
                                                                <td	id ="PC_MAX_15" >&nbsp;</td>
                                                            </tr>
                                                            <tr>
                                                                <td bgcolor="#0C3EA4" class="whiteTitle" align="center" valign="top">20</td>
                                                                <td	id ="NE_ESPERADO_0y20" >&nbsp;</td>
                                                                <td	id ="NE_ESPERADO_1y20" >&nbsp;</td>
                                                                <td	id ="NE_ESPERADO_2y20">&nbsp;</td>
                                                                <td	id ="NE_ESPERADO_3y20" >&nbsp;</td>
                                                                <td	id ="E_MAX_ESP_20" >&nbsp;</td>
                                                                <td	id ="PC_MAX_20" >&nbsp;</td>
                                                            </tr>
                                                        </table>
                                                    </fieldset></td>
                                                <td width="24" height="20" align="left" valign="top" class="blackText1">&nbsp;</td>
                                            </tr>
                                        </table>        </td>
                                </tr>
                                <tr>
                                    <td width="36" align="left" valign="top">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td width="36" rowspan="2" align="left" valign="top">&nbsp;</td>
                                    <td width="12" rowspan="2" align="left" valign="top" class="blackText1">&nbsp;</td>
                                    <td width="780" height="10" align="left" valign="middle" class="blackText1">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td height="10" align="left" valign="middle" class="blackText1">Escenario 0 - Sin crecimiento salarial en el tiempo, el individuo sufre una p&eacute;rdida real en su ingreso<br />
                                        Escenario I - Crecimiento moderado, el individuo apenas alcanza a mantener su nivel actual<br />
                                        Escenario II - Crecimiento estabilizado, el individuo consigue una mejora en su nivel con respecto al resto de la econom&iacute;a<br />
                                        Escenario III - Escenario optimista, se da una mejor&iacute;a que representa movilidad en la escala social</td>
                                </tr>
                                <tr>
                                    <td width="36" rowspan="2" align="left" valign="top">&nbsp;</td>
                                    <td width="12" rowspan="2" align="left" valign="top" class="blackText1">&nbsp;</td>
                                    <td width="780" height="10" align="left" valign="middle" class="blackText1">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td height="20" colspan="2" valign="top" align="center" class="blackText1">
                                        <fieldset>
                                            <table width="880" border="1" cellspacing="0" cellpadding="0">
                                                <tr>
                                                    <td width="150" rowspan="2" valign="middle" align="center" class="blackText1">Tiempo de Hipoteca<br />
                                                        (A&ntilde;os) </td>
                                                    <td colspan="4" valign="middle" align="center" class="blackText1">Escenarios</td>
                                                    <td width="157" rowspan="2" valign="middle" align="center" class="blackText1"><p>Endeudamiento m&aacute;ximo esperado </p>                  </td>
                                                    <td width="157" rowspan="2" valign="middle" align="center" class="blackText1"><p>%<br />
                                                            Endeudamiento m&aacute;ximo</p>                  </td>
                                                </tr>
                                                <tr>
                                                    <td width="100" bgcolor="#0C41A5" class="whiteTitle" align="center" valign="top">0</td>
                                                    <td width="100" bgcolor="#0D42A6" class="whiteTitle" align="center" valign="top">I</td>
                                                    <td width="100" bgcolor="#0D44A8" class="whiteTitle" align="center" valign="top">II</td>
                                                    <td width="100" bgcolor="#0B3EA3" class="whiteTitle" align="center" valign="top">III</td>
                                                </tr>
                                                <tr>
                                                    <td bgcolor="#0B3BA2" class="whiteTitle" align="center" valign="top">10</td>
                                                    <td	id ="NE_ESPERADO_0y10">&nbsp;</td>
                                                    <td	id ="NE_ESPERADO_1y10" >&nbsp;</td>
                                                    <td	id ="NE_ESPERADO_2y10" >&nbsp;</td>
                                                    <td	id ="NE_ESPERADO_3y10" >&nbsp;</td>
                                                    <td	id ="E_MAX_ESP_10" >&nbsp;</td>
                                                    <td	id ="PC_MAX_10"    >&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td bgcolor="#0B40A5" class="whiteTitle" align="center" valign="top">15</td>
                                                    <td	id ="NE_ESPERADO_0y15">&nbsp;</td>
                                                    <td	id ="NE_ESPERADO_1y15">&nbsp;</td>
                                                    <td	id ="NE_ESPERADO_2y15">&nbsp;</td>
                                                    <td	id ="NE_ESPERADO_3y15">&nbsp;</td>
                                                    <td	id ="E_MAX_ESP_15">&nbsp;</td>
                                                    <td	id ="PC_MAX_15" >&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td bgcolor="#0C3EA4" class="whiteTitle" align="center" valign="top">20</td>
                                                    <td	id ="NE_ESPERADO_0y20" >&nbsp;</td>
                                                    <td	id ="NE_ESPERADO_1y20" >&nbsp;</td>
                                                    <td	id ="NE_ESPERADO_2y20">&nbsp;</td>
                                                    <td	id ="NE_ESPERADO_3y20" >&nbsp;</td>
                                                    <td	id ="E_MAX_ESP_20" >&nbsp;</td>
                                                    <td	id ="PC_MAX_20" >&nbsp;</td>
                                                </tr>
                                            </table>
                                        </fieldset></td>
                                    <td width="24" height="20" align="left" valign="top" class="blackText1">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td width="36" rowspan="2" align="left" valign="top">&nbsp;</td>
                                    <td width="12" rowspan="2" align="left" valign="top" class="blackText1">&nbsp;</td>
                                    <td width="780" height="10" align="left" valign="middle" class="blackText1">&nbsp;</td>
                                </tr>

                            </table>
                        </p>
                    </div>
                    <div id="pie_pag"></div>
                </div>
                </body>
                </html>
