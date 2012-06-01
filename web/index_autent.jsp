<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%>
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/plantilla_index.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
    <%
	Usuarios usuarioUrbi = (Usuarios)session.getAttribute("usuarioUrbi");
        System.out.println(usuarioUrbi.getClave());
	if(usuarioUrbi==null){
		try{
			response.sendRedirect("../index.jsp");
		}catch(IOException io){
			System.out.println("ERROR:"+io.getMessage());
		}
	}
        int tipoPerfil=Integer.parseInt(usuarioUrbi.getPerfil());
%>

    
    
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Men&uacute; Principal</title>
<!-- InstanceEndEditable -->
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/textos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="js/funciones.js"></script>
<!-- InstanceBeginEditable name="head" --><!-- InstanceEndEditable -->
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
<body onload="MM_preloadImages('images/activo_meta.png','images/activo_cliente.png','images/activo_riesgo.png','images/activo_comportamiento.png','images/activo_deuda.png','images/activo_utileria.png','images/activo_salir.png','images/activo_entrar.png','images/wizar_activo.png')">
<center>
<div id="contenedor">
  <div id="encabezado">
    <div id="borde_iz"></div>
	<div id="logo"></div>
	<div id="relleno">
	<div id="login">
	  <!-- InstanceBeginEditable name="edit1" -->
	  
	  <!-- InstanceEndEditable --></div>
	</div>
	<div id="borde_der"></div>
	<div id="centro">
	<div id="botones">
	<table width="100%" height="34%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="110"  height="60"><div align="center"><a href="meta/metaindex.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('cliente','','images/activo_cliente.png',1)"><img src="images/inactivo_cliente.png" name="cliente" width="59" height="60" border="0" id="cliente" /></a></div></td>
    <td width="110"><div align="center"><a href="gol/golindex.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('meta','','images/activo_meta.png',1)"><img src="images/inactivo_meta.png" name="meta" width="58" height="60" border="0" id="meta" /></a></div></td>
    <td width="110"><div align="center"><a href="http://50.112.124.249:8080/NuevoGol" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('infonavit','','images/inactivo_infonavit.png',1)"><img src="images/inactivo_infonavit.png" name="info" width="58" height="60" border="0" id="info" /></a></div></td>
    <%
    if(tipoPerfil==1){
    %>
                <td width="109"><div align="center"><a href="prima/primaindex.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('riesgo','','images/activo_riesgo.png',1)"><img src="images/inactivo_riesgo.png" name="riesgo" width="58" height="60" border="0" id="riesgo" /></a></div></td>
    <td width="116"><div align="center"><a href="behaivor/behaivorindex.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('comportamiento','','images/activo_comportamiento.png',1)"><img src="images/inactivo_comportamiento.png" name="comportamiento" width="61" height="60" border="0" id="comportamiento" /></a></div></td>
    <td width="123"><div align="center"><a href="endeudamiento/entradadeuda.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('deuda','','images/activo_deuda.png',1)"><img src="images/inactivo_deuda.png" name="deuda" width="60" height="60" border="0" id="deuda" /></a></div></td>
    <td width="111"><div align="center"><a href="utileria/indexutileria.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('utilerias','','images/activo_utileria.png',1)"><img src="images/inactivo_utileria.png" name="utilerias" width="60" height="60" border="0" id="utilerias" /></a></div></td>
    <td width="114"><div align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('wizard','','images/wizar_activo.png',1)"><img src="images/wizar-inactivo.png" name="wizard" width="59" height="60" border="0" id="wizard" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('salir','','images/activo_salir.png',1)"></a></div></td>
  <%
   }
   %>
  </tr>
  <tr height="35">
    <td width="110"><div align="center" class="blueText"><a href="meta/metaindex.jsp" class="blueText">Cliente<br />Meta</a></p></div></td>
    <td width="110"><div align="center"><p class="blueText"><a href="gol/golindex.jsp" class="blueText">Cliente<br />Gol</a> </p></div></td>
    <td width="110"><div align="center"><p class="blueText"><a href="http://50.112.124.249:8080/NuevoGol" class="blueText">Infonavit<br />Gol</a> </p></div></td>
    <%
    if(tipoPerfil==1){
    %>
    <td width="110"><div align="center" class="blueText"><a href="prima/primaindex.jsp" class="blueText">Prima Pura<br />de Riesgo</a></div></td>
    <td width="110"><div align="center" class="blueText"><a href="behaivor/behaivorindex.jsp" class="blueText">Behavior</a><br />&nbsp;</div></td>
    <td width="110"><div align="center" class="blueText"><p><a href="endeudamiento/entradadeuda.jsp" class="blueText">Nivel M&aacute;ximo <br />de Endeudamiento</a></p></div></td>
    <td width="110"><div align="center" class="blueText"><p><a href="utileria/indexutileria.jsp" class="blueText">Utiler&iacute;as</a><br />&nbsp;</p></div></td>
    <td width="110"><div align="center" class="blueText"><p>Wizard<br />&nbsp;</p></div></td>
    <%
    }
    %>
  </tr>
</table>
	</div>
  </div>
</div>
</body>
<!-- InstanceEnd --></html>
