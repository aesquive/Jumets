<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml">
<%
Usuarios usuarioUrbi = (Usuarios)session.getAttribute("usuarioUrbi");
if(usuarioUrbi==null){
	try{
		response.sendRedirect("../index.jsp");
	}catch(IOException io){
		System.out.println("ERROR:"+io.getMessage());
	}
}

%>
<!-- InstanceBegin template="/Templates/plantilla_utileria.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Utiler&iacute;as del Sistema</title>
<!-- InstanceEndEditable -->
<link href="../css/main.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.Estilo1 {
	font-size: 16px
}

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
</style>
<script language="javascript" src="../js/funciones.js"></script>
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
</head>
<body
	onload="MM_preloadImages('../images/activo_meta.png','../images/activo_cliente.png','../images/activo_riesgo.png','../images/activo_entrar.png','../images/util_16.png','../images/util_14.png','../images/util_12.png')">
<center>
<div id="contenedor">
<div id="encabezado">
<div id="borde_iz"></div>
<div id="logo"></div>
<div id="relleno">
<div id="login"><!-- InstanceBeginEditable name="edit1" -->
<table width="414" border="0" align="right" cellpadding="0"
	cellspacing="0" class="whiteSubtitle">
	<tr>
		<td width="226" colspan="9" align="center" class="blueSubtitle">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="blueSubtitle">Utiler&iacute;as</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="whiteSubtitle">Utiler&iacute;as
		del Sistema</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="whiteSubtitle">&nbsp;</td>
	</tr>
</table>
<!-- InstanceEndEditable --></div>
</div>
<div id="borde_der"></div>
<div id="centro">
<div id="botones">
<table width="67%" height="34%" border="0" cellpadding="0"
	cellspacing="0" align="center">
	<tr>
		<td width="187" height="60">
		<div align="center"><a href="../UsuariosAction?accion=entra" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image5','','../images/util_12.png',1)"><img
			src="../images/util2_12.png" name="Image5" width="57" height="60"
			border="0" id="Image5" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('cliente','','../images/activo_cliente.png',1)"></a></div>
		</td>
		<td width="188">
		<div align="center"><a href="#" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('cliente','','../images/activo_cliente.png',1)"></a><a
			href="#" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image4','','../images/util_14.png',1)"><img
			src="../images/util2_14.png" name="Image4" width="56" height="61"
			border="0" id="Image4" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('meta','','../images/activo_meta.png',1)"></a></div>
		</td>
		<td width="178">
		<div align="center"><a href="" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('riesgo','','../images/activo_riesgo.png',1)"></a><a
			href="../index_autent.jsp" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image3','','../images/util_16.png',1)"><img
			src="../images/util2_16.png" name="Image3" width="56" height="61"
			border="0" id="Image3" /></a></div>
		</td>
	</tr>
	<tr>
		<td width="187" height="35">
		<div align="center" class="blueText"><a href="../UsuariosAction?accion=entra">Mantenimiento<br />
		a Usuarios
		</a></div>
		</td>
		<td width="188">
		<div align="center">
		<p class="blueText"><a href="#"
			class="blueText">Mantenimiento <br />
		a Desarrollos </a></p>
		</div>
		</td>
		<td>
		<div align="center"><span class="blueText"><a
			href="../index_autent.jsp" class="blueText">Regresar<br />
		Men&uacute; Inicio </a></span></div>
		</td>
	</tr>
</table>
</div>
</div>
</div>
</div>
</center>
</body>
<!-- InstanceEnd -->
</html>
