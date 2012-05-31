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
</script><!-- InstanceBeginEditable name="head" --><!-- InstanceEndEditable -->
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
<body onload="MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_exit.png','../images/acceso/activos_guardar.png','../images/buscar_activo.png','../images/acceso/activos_salir.png','../images/acceso/inactivo-blanco_salir.png','../images/acceso/activos_left.png','../images/acceso/activos_right.png','../images/accesos_down/aplicacion-2_41.png','../images/accesos_down/aplicacion-2_36.png','../images/accesos_down/aplicacion-2_34.png','../images/accesos_down/aplicacion-2_30.png','../images/accesos_down/aplicacion-2_28.png')" >
<form id="sico2" name="sico2" method="post" action="../GolServlet" onsubmit="return validate_form(this)">
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
                                        <td width="41" align="center"><a href="#" onclick="" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img src="../images/acceso/inactivos_add.png" name="add" width="33" height="33" border="0" class="button" id="add" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"></a></td>
                                        <td width="10">&nbsp;</td>
                                        <td width="39" align="center"><a href="#" onclick="" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"><img src="../images/acceso/inactivos_exit.png" name="exit" width="33" height="33" border="0" class="button" id="exit" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"></a></td>
                                      <td width="10">&nbsp;</td>
                                        <td width="34" align="center"><a href="#" onclick="pagina6Val('Guardar6', 'sico2',0);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('guardar','','../images/acceso/activos_guardar.png',1)"><img src="../images/acceso/inactivos_guardar.png" name="guardar" width="34" height="33" border="0" class="button" id="guardar" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('buscar','','../images/buscar_activo.png',1)"></a></td>
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
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
	<table width="851" border="0" align="center" cellpadding="0" cellspacing="0">  
  <tr>
    <td height="7" colspan="14" align="left" valign="middle"><fieldset>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="831" align="left" valign="top"><fieldset>
        <table width="841" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td colspan="8" align="left" valign="middle" id="tdP13"><span class="blackText1"><strong>13.</strong> Cuando se recibe m&aacute;s cambio del que corresponde, debemos qued&aacute;rnoslo </span></td>
          </tr>
          <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta13" type="radio" value="1" <%=("1".equals(goal.getPregunta13()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta13" type="radio" value="2" <%=("2".equals(goal.getPregunta13()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta13" type="radio" value="3" <%=("3".equals(goal.getPregunta13()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta13" type="radio" value="4" <%=("4".equals(goal.getPregunta13()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
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
            <td colspan="8" align="left" valign="middle" id="tdP14"><span class="blackText1"><strong>14.</strong> Se ayuda a cualquier persona que lo necesite</span></td>
          </tr>
          <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta14" type="radio" value="1" <%=("1".equals(goal.getPregunta14()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta14" type="radio" value="2" <%=("2".equals(goal.getPregunta14()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta14" type="radio" value="3" <%=("3".equals(goal.getPregunta14()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta14" type="radio" value="4" <%=("4".equals(goal.getPregunta14()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
        </table>
        </fieldset> </td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td width="831" align="left" valign="middle"><fieldset>
         <table width="841" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td colspan="8" align="left" valign="middle" id="tdP15"><span class="blackText1"><strong>15.</strong> El robo se castiga, sin importar lo que robe</span></td>
           </tr>
           <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta15" type="radio" value="1" <%=("1".equals(goal.getPregunta15()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta15" type="radio" value="2" <%=("2".equals(goal.getPregunta15()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta15" type="radio" value="3" <%=("3".equals(goal.getPregunta15()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta15" type="radio" value="4" <%=("4".equals(goal.getPregunta15()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
         </table>
         </fieldset> </td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td width="831" align="left" valign="middle"><fieldset>
         <table width="841" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td colspan="8" align="left" valign="middle" id="tdP16"><span class="blackText1"><strong>16.</strong> Cuando alquien hace da&ntilde;o, debe haber venganza </span></td>
           </tr>
           <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta16" type="radio" value="1" <%=("1".equals(goal.getPregunta16()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta16" type="radio" value="2" <%=("2".equals(goal.getPregunta16()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta16" type="radio" value="3" <%=("3".equals(goal.getPregunta16()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta16" type="radio" value="4" <%=("4".equals(goal.getPregunta16()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
         </table>
         </fieldset> </td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="831" align="left" valign="middle"><fieldset>
        <table width="841" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td colspan="8" align="left" valign="middle" id="tdP17"><span class="blackText1"><strong>17.</strong> Creo que deber&iacute;a ganar mucho m&aacute;s por lo que hago</span></td>
          </tr>
          <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta17" type="radio" value="1" <%=("1".equals(goal.getPregunta17()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta17" type="radio" value="2" <%=("2".equals(goal.getPregunta17()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta17" type="radio" value="3" <%=("3".equals(goal.getPregunta17()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta17" type="radio" value="4" <%=("4".equals(goal.getPregunta17()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
        </table>
        </fieldset> </td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td width="831" align="left" valign="middle"><fieldset>
         <table width="841" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td colspan="8" align="left" valign="middle" id="tdP18"><span class="blackText1"><strong>18.</strong> Le ayudo a mis hijos con las tareas</span></td>
           </tr>
           <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta18" type="radio" value="1" <%=("1".equals(goal.getPregunta18()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta18" type="radio" value="2" <%=("2".equals(goal.getPregunta18()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta18" type="radio" value="3" <%=("3".equals(goal.getPregunta18()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta18" type="radio" value="4" <%=("4".equals(goal.getPregunta18()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
         </table>
         </fieldset> </td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td width="831" align="left" valign="middle"><fieldset>
         <table width="841" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td colspan="8" align="left" valign="middle" id="tdP19"><span class="blackText1"><strong>19.</strong>Creo con frecuencia que he sido castigado injustamente</span></td>
           </tr>
           <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta19" type="radio" value="1" <%=("1".equals(goal.getPregunta19()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta19" type="radio" value="2" <%=("2".equals(goal.getPregunta19()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta19" type="radio" value="3" <%=("3".equals(goal.getPregunta19()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta19" type="radio" value="4" <%=("4".equals(goal.getPregunta19()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
         </table>
         </fieldset> </td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td width="831" align="left" valign="middle"><fieldset>
         <table width="841" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td colspan="8" align="left" valign="middle" id="tdP20"><span class="blackText1"><strong>20.</strong> Creo que la religi&oacute;n es importante</span></td>
           </tr>
           <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta20" type="radio" value="1" <%=("1".equals(goal.getPregunta20()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta20" type="radio" value="2" <%=("2".equals(goal.getPregunta20()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta20" type="radio" value="3" <%=("3".equals(goal.getPregunta20()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta20" type="radio" value="4" <%=("4".equals(goal.getPregunta20()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
         </table>
         </fieldset> </td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td width="831" align="left" valign="middle"><fieldset>
         <table width="841" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td colspan="8" align="left" valign="middle" id="tdP21"><span class="blackText1"><strong>21. </strong>Me gustar&iacute;a vivir en Estados Unidos</span></td>
           </tr>
           <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta21" type="radio" value="1" <%=("1".equals(goal.getPregunta21()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta21" type="radio" value="2" <%=("2".equals(goal.getPregunta21()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta21" type="radio" value="3" <%=("3".equals(goal.getPregunta21()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta21" type="radio" value="4" <%=("4".equals(goal.getPregunta21()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
         </table>
         </fieldset> </td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td width="831" align="left" valign="middle"><fieldset>
         <table width="841" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td colspan="8" align="left" valign="middle" id="tdP22"><span class="blackText1"><strong>22.</strong> Haciendo un esfuerzo ahorro parte de mi sueldo</span></td>
           </tr>
           <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta22" type="radio" value="1" <%=("1".equals(goal.getPregunta22()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta22" type="radio" value="2" <%=("2".equals(goal.getPregunta22()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta22" type="radio" value="3" <%=("3".equals(goal.getPregunta22()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta22" type="radio" value="4" <%=("4".equals(goal.getPregunta22()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
         </table>
         </fieldset> </td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td width="831" align="left" valign="middle"><fieldset>
         <table width="841" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td colspan="8" align="left" valign="middle" id="tdP23"><span class="blackText1"><strong>23.</strong> Creo que pagar intereses por un pr&eacute;stamo es justo</span></td>
           </tr>
           <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta23" type="radio" value="1" <%=("1".equals(goal.getPregunta23()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta23" type="radio" value="2" <%=("2".equals(goal.getPregunta23()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta23" type="radio" value="3" <%=("3".equals(goal.getPregunta23()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta23" type="radio" value="4" <%=("4".equals(goal.getPregunta23()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
         </table>
         </fieldset> </td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td width="831" align="left" valign="middle"><fieldset>
         <table width="841" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td colspan="8" align="left" valign="middle" id="tdP24"><span class="blackText1"><strong>24.</strong> Participo en las mejoras que quieren hacer en la escuela de mis hijos</span></td>
           </tr>
           <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta24" type="radio" value="1" <%=("1".equals(goal.getPregunta24()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta24" type="radio" value="2" <%=("2".equals(goal.getPregunta24()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta24" type="radio" value="3" <%=("3".equals(goal.getPregunta24()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta24" type="radio" value="4" <%=("4".equals(goal.getPregunta24()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
         </table>
         </fieldset> </td>
      </tr>
    </table>
	<table width="841" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td width="831" align="left" valign="middle"><fieldset>
         <table width="841" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td colspan="8" align="left" valign="middle" id="tdP25"><span class="blackText1"><strong>25.</strong> Creo que decir la verdad es muy importante </span></td>
           </tr>
           <tr>
            <td width="29" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta25" type="radio" value="1" <%=("1".equals(goal.getPregunta25()))?"checked":""%>/>
            </span></td>
            <td width="154" align="left" valign="bottom"><span class="blackText1">Muy de acuerdo </span></td>
            <td width="28" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta25" type="radio" value="2" <%=("2".equals(goal.getPregunta25()))?"checked":""%>/>
            </span></td>
            <td width="143" align="left" valign="bottom"><span class="blackText1">De acuerdo </span></td>
            <td width="26" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta25" type="radio" value="3" <%=("3".equals(goal.getPregunta25()))?"checked":""%>/>
            </span></td>
            <td width="153" align="left" valign="bottom"><span class="blackText1">En desacuerdo</span></td>
            <td width="30" align="right" valign="middle"><span class="blackText1">
              <input name="pregunta25" type="radio" value="4" <%=("4".equals(goal.getPregunta25()))?"checked":""%>/>
            </span></td>
            <td width="276" align="left" valign="bottom"><span class="blackText1">Muy en desacuerdo</span></td>
          </tr>
         </table>
         </fieldset> </td>
      </tr>
    </table>	
    </fieldset></td>
    </tr>
  <tr>
    <td height="7" colspan="3">&nbsp;</td>
    <td align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image10','','../images/accesos_down/aplicacion-2_28.png',1)"><img src="../images/accesos_down/aplicacion-23_28.png" name="Image10" width="33" height="32" border="0" id="Image10" /></a></td>
    <td height="7">&nbsp;</td>
    <td align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image9','','../images/accesos_down/aplicacion-2_30.png',1)"><img src="../images/accesos_down/aplicacion-23_30.png" name="Image9" width="33" height="32" border="0" id="Image9" /></a></td>
    <td height="7">&nbsp;</td>
    <td align="center"><a href="#" onclick="pagina6Val('Guardar6', 'sico2',0);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image8','','../images/accesos_down/aplicacion-2_34.png',1)"><img src="../images/accesos_down/aplicacion-23_34.png" name="Image8" width="32" height="32" border="0" id="Image8" /></a></td>
    <td height="7">&nbsp;</td>
    <td align="center"><a href="#" onclick="pagina6Val('pagina7P', 'sico2',2);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image61','','../images/accesos_down/aplicacion-2_36.png',1)"><img src="../images/accesos_down/aplicacion-23_36.png" name="Image61" width="32" height="32" border="0" id="Image61" /></a></td>
    <td height="7">&nbsp;</td>
    <td align="center"><a href="#" onclick="pagina6Val('pagina7A', 'sico2',2);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image6','','../images/accesos_down/aplicacion-2_36.png',1)"><img src="../images/accesos_down/aplicacion-23_36.png" name="Image6" width="32" height="32" border="0" id="Image6" /></a></td>
    <td height="7">&nbsp;</td>
    <td align="center"><a href="#" onclick="pagina6Val('pagina7', 'sico2',1);"  onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image12','','../images/accesos_down/aplicacion-2_41.png',1)"><img src="../images/accesos_down/aplicacion-23_41.png" name="Image12" width="31" height="32" border="0" id="Image12" /></a></td>
  </tr>
  <tr>
    <td width="14" height="7" align="left" valign="middle">&nbsp;</td>
    <td width="14" height="7" align="left" valign="middle">&nbsp;</td>
    <td width="426" height="7" align="left" valign="middle">&nbsp;</td>
    <td width="55" align="center" valign="top" class="blueText">Cancelar</td>
    <td width="10" height="7" align="left" valign="middle">&nbsp;</td>
    <td width="44" align="center" valign="top" class="blueText">Guardar</td>
    <td width="9" height="7" align="left" valign="middle">&nbsp;</td>
    <td width="47" align="center" valign="top" class="blueText">Salir</td>
    <td width="10" height="7" align="left" valign="middle">&nbsp;</td>
    <td width="97" align="center" valign="top" class="blueText">Primera Pantalla</td>
    <td width="12" height="7" align="left" valign="middle">&nbsp;</td>
    <td width="47" align="center" valign="top" class="blueText">Anterior</td>
    <td width="8" height="7" align="left" valign="middle">&nbsp;</td>
    <td width="66" align="center" class="blueText">Siguiente</td>
  </tr>
</table>
	<!-- InstanceEndEditable -->	</div>
	<div id="pie_pag"></div>
</div>
</div>
</center>
</form>
</body>
<!-- InstanceEnd --></html>
