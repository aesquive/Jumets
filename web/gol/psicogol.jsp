<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/plantilla3.dwt" codeOutsideHTMLIsLocked="false" -->
    <%@page import="java.util.*" %>
<%@page import="objetos.*" %>
<%@page import="org.hibernate.*" %>
<%@page import="gol.beans.*" %>
<jsp:useBean id="gol" scope="session" type="gol.beans.GolBean" />
<%
	Usuarios usuarioUrbi = (Usuarios)session.getAttribute("usuarioUrbi");
	if(usuarioUrbi==null){
		try{
			response.sendRedirect("../index.jsp");
		}catch(IOException io){
			System.out.println("ERROR:"+io.getMessage());
		}
	}
    GolBean goal = (GolBean)request.getSession().getAttribute("gol");
    String accion = (String)request.getSession().getAttribute("accion");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Originaci&oacute;n de Cliente</title>
<!-- InstanceEndEditable -->
<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/funciones.js"></script>
<script language="JavaScript" type="text/javascript" src="../js/ajax.js"></script>
<script language="JavaScript" src="../js/gol.js"></script>
<script language="JavaScript" src="../js/golVal.js"></script>
<script language="javascript">
function validate_form(thisform){
    //if (validate_required(instanceName)==false){
    if(false){
        SetErrorMessage(1,"Hola Yandy, esto es un error");
        return false;
    }
    return true;
}

function ejecutar(boton, thisform){
    var frm = document.forms[thisform];
    frm.elements["command"].value = boton;
    document.forms[thisform].submit();
}
</script>
<!-- InstanceBeginEditable name="head" --><!-- InstanceEndEditable -->
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
</style></head>
<body onload="MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_exit.png','../images/acceso/activos_guardar.png','../images/buscar_activo.png','../images/acceso/activos_salir.png','../images/acceso/inactivo-blanco_salir.png','../images/accesos_down/aplicacion-2_41.png','../images/accesos_down/aplicacion-2_36.png','../images/accesos_down/aplicacion-2_34.png','../images/accesos_down/aplicacion-2_30.png','../images/accesos_down/aplicacion-2_28.png')" >
<form id="sico" name="sico" method="post" action="../GolServlet" onsubmit="return validate_form(this)">
<input type="hidden" id="command" name="command" value="test"/>
<input type="hidden" name="accion" value="<%=accion%>"/>
<center>
<div id="contenedor">
                    <div id="encabezado">
                        <div id="borde_iz"></div>
                        <div id="logo">
                        </div>
                        <div id="relleno">
                            <div id="capa_enc">
                                <!-- InstanceBeginEditable name="region1" -->
                                <table width="552" border="0" valign="right" cellpadding="0" cellspacing="0" class="textarea">
                                    <tr>
                                        <td colspan="18" align="center" class="blackSubtitle">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td colspan="18" align="center" class="blueSubtitle">Originaci&oacute;n del Cliente</td>
                                    </tr>
                                    <tr>
                                        <td colspan="18" align="center" class="whiteSubtitle">Mantenimiento a Personas </td>
                                    </tr>
                                    <tr>
                                        <td colspan="18" align="center" class="whiteSubtitle">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td width="39" align="center">&nbsp;</td>
                                        <td width="10">&nbsp;</td>
                                        <td width="52" align="center">&nbsp;</td>
                                        <td width="10">&nbsp;</td>
                                        <td width="42" align="center">&nbsp;</td>
                                        <td width="10">&nbsp;</td>
                                        <td width="41" align="center"><a 
                                                href="#"
                                                onclick="salirGol();"
                                                onmouseout="MM_swapImgRestore()"
                                                onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img
                                                    src="../images/acceso/inactivos_add.png" name="add" width="33"
                                                    height="33" border="0" class="button" id="add" /></a><a href="#"
                                                      onmouseout="MM_swapImgRestore()"
                                                      onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"></a></td>
                                        <td width="10">&nbsp;</td>
                                        <td width="39" align="center"><a href="#" onclick="" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"><img src="../images/acceso/inactivos_exit.png" name="exit" width="33" height="33" border="0" class="button" id="exit" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"></a></td>
                                      <td width="10">&nbsp;</td>
                                        <td width="34" align="center"><a href="#" onclick="pagina5Val('Guardar5', 'sico',0)" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('guardar','','../images/acceso/activos_guardar.png',1)"><img src="../images/acceso/inactivos_guardar.png" name="guardar" width="34" height="33" border="0" class="button" id="guardar" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('buscar','','../images/buscar_activo.png',1)"></a></td>
                                      <td width="10">&nbsp;</td>
                                      <td width="35" align="center"><a
                                        href="#"
                                        onclick="salirGol();"
                                        onmouseout="MM_swapImgRestore()"
                                        onmouseover="MM_swapImage('salir','','../images/acceso/activos_salir.png',1)"><img
                                        src="../images/acceso/inactivos_salir.png" name="salir" width="32"
                                        height="33" border="0" class="button" id="salir" /></a><a href="#"
                                        onmouseout="MM_swapImgRestore()"
                                        onmouseover="MM_swapImage('salir','','../images/acceso/inactivo-blanco_salir.png',1)"></a></td>
                                      <td width="21">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td height="19" class="whiteText"><div align="center"></div></td>
                                        <td class="whiteText"><div align="center"></div></td>
                                        <td class="whiteText"><div align="center"></div></td>
                                        <td class="whiteText"><div align="center"></div></td>
                                        <td class="whiteText"><div align="center"></div></td>
                                        <td class="whiteText"><div align="center"></div></td>
                                        <td class="whiteText"><div align="center">Agregar</div></td>
                                        <td class="whiteText"><div align="center"></div></td>
                                        <td class="whiteText"> <div align="center">Cancelar</div></td>
                                        <td class="whiteText"><div align="center"></div></td>
                                        <td class="whiteText"><div align="center">Guardar</div></td>
                                        <td class="whiteText"><div align="center"></div></td>
                                        <td class="whiteText"><div align="center">Salir</div></td>
                                        <td class="whiteText"><div align="center"></div></td>
                                    </tr>
                                </table>
                              <!-- InstanceEndEditable -->
                            </div>
                        </div>
	<div id="borde_der"></div>
	<div id="contenido">
	<%@include file="../ErrorTag.jsp"%>
	<!-- InstanceBeginEditable name="Region2" -->
	<table width="851" border="0" align="center" cellpadding="0" cellspacing="0">  
  <tr>
    <td height="7" colspan="14">
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
	<fieldset><table width="838" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="841"><fieldset><legend class="blackText1" style="font-weight:bold">Qué tan de acuerdo está con las siguientes afirmaciones</legend>
        <table width="841" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
        </table>
        <table width="841" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="833" colspan="8" align="left" valign="top" class="blackText1"><table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" id="tdP1"><span class="blackText1"><strong>1.</strong> Cuando no le ponen atenci&oacute;n, se debe gritar para que le   oigan</span> </td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta1" type="radio" value="1" <%=("1".equals(goal.getPregunta1()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta1" type="radio" value="2" <%=("2".equals(goal.getPregunta1()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta1" type="radio" value="3" <%=("3".equals(goal.getPregunta1()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta1" type="radio" value="4" <%=("4".equals(goal.getPregunta1()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table>
            <table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" class="blackText1" id="tdP2"><strong>2.</strong>Me gusta participar en las fiestas que organizan mis amigos</td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta2" type="radio" value="1"  <%=("1".equals(goal.getPregunta2()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta2" type="radio" value="2"  <%=("2".equals(goal.getPregunta2()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta2" type="radio" value="3"  <%=("3".equals(goal.getPregunta2()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta2" type="radio" value="4"  <%=("4".equals(goal.getPregunta2()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table>
            <table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" class="blackText1" id="tdP3"><strong>3.</strong> Es molesto trabajar horas extras</td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta3" type="radio" value="1"  <%=("1".equals(goal.getPregunta3()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta3" type="radio" value="2"  <%=("2".equals(goal.getPregunta3()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta3" type="radio" value="3"  <%=("3".equals(goal.getPregunta3()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta3" type="radio" value="4"  <%=("4".equals(goal.getPregunta3()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table>
            <table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" class="blackText1" id="tdP4"><strong>4.</strong> Se debe ayudar a una persona honrada que tiene un problema</td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta4" type="radio" value="1"  <%=("0".equals(goal.getPregunta4()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta4" type="radio" value="2"  <%=("2".equals(goal.getPregunta4()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta4" type="radio" value="3"  <%=("3".equals(goal.getPregunta4()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta4" type="radio" value="4"  <%=("4".equals(goal.getPregunta4()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table>
            <table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" class="blackText1" id="tdP5"><strong>5.</strong> Cuando voy de pasajero en un microb&uacute;s, y el microbusero se le cierra a un coche y le grita, yo tambi&eacute;n le grito al del coche</td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta5" type="radio" value="1"  <%=("1".equals(goal.getPregunta5()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta5" type="radio" value="2"  <%=("2".equals(goal.getPregunta5()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta5" type="radio" value="3"  <%=("3".equals(goal.getPregunta5()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta5" type="radio" value="4"  <%=("4".equals(goal.getPregunta5()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table>
            <table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" class="blackText1" id="tdP6"><strong>6.</strong> Es natural reclamar a una persona que dice su opini&oacute;n sobre 
algo sucedido en la comunidad</td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta6" type="radio" value="1"  <%=("1".equals(goal.getPregunta6()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta6" type="radio" value="2"  <%=("2".equals(goal.getPregunta6()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta6" type="radio" value="3"  <%=("3".equals(goal.getPregunta6()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta6" type="radio" value="4"  <%=("4".equals(goal.getPregunta6()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table>
            <table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" class="blackText1" id="tdP7"><strong>7.</strong> Cada quien tiene lo que merece</td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta7" type="radio" value="1"  <%=("1".equals(goal.getPregunta7()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta7" type="radio" value="2"  <%=("2".equals(goal.getPregunta7()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta7" type="radio" value="3"  <%=("3".equals(goal.getPregunta7()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta7" type="radio" value="4"  <%=("4".equals(goal.getPregunta7()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table>
            <table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" class="blackText1" id="tdP8"><strong>8.</strong> Es normal darle una nalgada a un ni&ntilde;o cuando hace algo mal </td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta8" type="radio" value="1"  <%=("1".equals(goal.getPregunta8()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta8" type="radio" value="2"  <%=("2".equals(goal.getPregunta8()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta8" type="radio" value="3"  <%=("3".equals(goal.getPregunta8()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta8" type="radio" value="4"  <%=("4".equals(goal.getPregunta8()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table>
            <table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" class="blackText1" id="tdP9"><strong>9.</strong> Yo deber&iacute;a tener mejores oportunidades de trabajo</td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta9" type="radio" value="1"  <%=("1".equals(goal.getPregunta9()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta9" type="radio" value="2"  <%=("2".equals(goal.getPregunta9()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta9" type="radio" value="3"  <%=("3".equals(goal.getPregunta9()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta9" type="radio" value="4"  <%=("4".equals(goal.getPregunta9()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table>
            <table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" class="blackText1" id="tdP10"><strong>10.</strong> En la comunidad, se ayudan entre todos cuando tienen alg&uacute;n problema</td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta10" type="radio" value="1"  <%=("1".equals(goal.getPregunta10()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta10" type="radio" value="2"  <%=("2".equals(goal.getPregunta10()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta10" type="radio" value="3"  <%=("3".equals(goal.getPregunta10()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta10" type="radio" value="4"  <%=("4".equals(goal.getPregunta10()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table>
            <table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" class="blackText1" id="tdP11"><strong>11.</strong> Si alguien pierde su fortuna, se lo merece</td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta11" type="radio" value="1"  <%=("1".equals(goal.getPregunta11()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta11" type="radio" value="2"  <%=("2".equals(goal.getPregunta11()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta11" type="radio" value="3"  <%=("3".equals(goal.getPregunta11()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta11" type="radio" value="4"  <%=("4".equals(goal.getPregunta11()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table>
            <table width="841" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="831" align="left" valign="top"><fieldset>
                <table width="841" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td colspan="8" align="left" valign="middle" class="blackText1" id="tdP12"><strong>12.</strong> Se obedecen las leyes porque son justas</td>
                  </tr>
                  <tr>
                    <td width="28" align="right" valign="middle"><input name="pregunta12" type="radio" value="1"  <%=("1".equals(goal.getPregunta12()))?"checked":""%>/></td>
                    <td width="154" align="left" valign="bottom" class="blackText1">Muy de acuerdo</td>
                    <td width="29" align="right" valign="middle"><input name="pregunta12" type="radio" value="2"  <%=("2".equals(goal.getPregunta12()))?"checked":""%>/></td>
                    <td width="142" align="left" valign="bottom" class="blackText1">De acuerdo </td>
                    <td width="26" align="right" valign="middle"><input name="pregunta12" type="radio" value="3"  <%=("3".equals(goal.getPregunta12()))?"checked":""%>/></td>
                    <td width="153" align="left" valign="bottom" class="blackText1">En desacuerdo</td>
                    <td width="33" align="right" valign="middle"><input name="pregunta12" type="radio" value="4"  <%=("4".equals(goal.getPregunta12()))?"checked":""%>/></td>
                    <td width="276" align="left" valign="bottom" class="blackText1">Muy en desacuerdo</td>
                  </tr>
                </table>
                </fieldset> </td>
      </tr>
            </table></td>
          </tr>
      </table>
    </fieldset> </td>
    </tr>
  
  
</table>
	</fieldset></td>
    </tr>
  <tr>
    <td height="7" colspan="3">&nbsp;</td>
    <td width="55" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image10','','../images/accesos_down/aplicacion-2_28.png',1)"><img src="../images/accesos_down/aplicacion-23_28.png" name="Image10" width="33" height="32" border="0" id="Image10" /></a></td>
    <td width="12" height="7">&nbsp;</td>
    <td width="44" align="center"><a href="#" onclick="pagina5Val('pagina6P', 'sico',0);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image9','','../images/accesos_down/aplicacion-2_30.png',1)"><img src="../images/accesos_down/aplicacion-23_30.png" name="Image9" width="33" height="32" border="0" id="Image9" /></a></td>
    <td width="8" height="7">&nbsp;</td>
    <td width="47" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image8','','../images/accesos_down/aplicacion-2_34.png',1)"><img src="../images/accesos_down/aplicacion-23_34.png" name="Image8" width="32" height="32" border="0" id="Image8" /></a></td>
    <td width="6" height="7">&nbsp;</td>
    <td width="97" align="center"><a href="#" onclick="pagina5Val('pagina6P', 'sico',2);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image61','','../images/accesos_down/aplicacion-2_36.png',1)"><img src="../images/accesos_down/aplicacion-23_36.png" name="Image61" width="32" height="32" border="0" id="Image61" /></a></td>
    <td width="10" height="7">&nbsp;</td>
    <td width="47" align="center"><a href="#" onclick="pagina5Val('pagina6A', 'sico',2);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image6','','../images/accesos_down/aplicacion-2_36.png',1)"><img src="../images/accesos_down/aplicacion-23_36.png" name="Image6" width="32" height="32" border="0" id="Image6" /></a></td>
    <td width="5" height="7">&nbsp;</td>
    <td width="66" align="center"><a href="#" onclick="pagina5Val('pagina6', 'sico',1);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image12','','../images/accesos_down/aplicacion-2_41.png',1)"><img src="../images/accesos_down/aplicacion-23_41.png" name="Image12" width="31" height="32" border="0" id="Image12" /></a></td>
  </tr>
  <tr>
    <td width="18" height="7">&nbsp;</td>
    <td width="11" height="7">&nbsp;</td>
    <td width="458" height="7">&nbsp;</td>
    <td align="center" class="blueText" valign="top">Cancelar</td>
    <td height="7">&nbsp;</td>
    <td align="center" class="blueText" valign="top">Guardar</td>
    <td height="7">&nbsp;</td>
    <td align="center" class="blueText" valign="top">Salir</td>
    <td height="7">&nbsp;</td>
    <td align="center" class="blueText" valign="top">Primera Pantalla</td>
    <td height="7">&nbsp;</td>
    <td align="center" valign="top" class="blueText">Anterior</td>
    <td height="7">&nbsp;</td>
    <td class="blueText" align="center" valign="top">Siguiente</td>
  </tr>
</table>
	<!-- InstanceEndEditable -->    
	</div>
	<div id="pie_pag"></div>
</div>
</div>
</center>
</form>
</body>
<!-- InstanceEnd --></html>
