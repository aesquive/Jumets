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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Utiler&iacute;as del Sistema</title>
<!-- InstanceEndEditable -->
<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/funciones.js"></script>
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
</head>
<body
	onload="MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_mod.png','../images/acceso/activos_sup.png','../images/acceso/activo-calc.png','../images/acceso/activos_exit.png','../images/acceso/activo-cal.png','../images/acceso/activos_salir.png','../images/acceso/aceptar-2_08.png')">
<center>
<div id="contenedor">
<div id="encabezado">
<div id="borde_iz"></div>
<div id="logo"></div>
<div id="relleno">
<div id="capa_enc"><!-- InstanceBeginEditable name="region1" -->
<table width="321" border="0" valign="right" cellpadding="0"
	cellspacing="0" class="whiteSubtitle">
	<tr>
		<td colspan="9" align="center" class="blueSubtitle">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="blueSubtitle">Utiler&iacute;as</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="whiteSubtitle">Mantenimiento
		a Usuarios</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="whiteSubtitle">&nbsp;</td>
	</tr>
	<tr>
		<td width="33" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img
			src="../images/acceso/inactivos_add.png" name="add" width="33"
			height="33" border="0" class="textarea" id="add" /></a></td>
		<td width="15">&nbsp;</td>
		<td width="35" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('delete','','../images/acceso/activos_sup.png',1)"><img
			src="../images/acceso/inactivos_sup.png" name="delete" width="33"
			height="33" border="0" class="textarea" id="delete" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('mod','','../images/acceso/activos_mod.png',1)"></a></td>
		<td width="15">&nbsp;</td>
		<td width="33" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image5','','../images/acceso/aceptar-2_08.png',1)"><img
			src="../images/acceso/aceptar_08.png" name="Image5" width="31"
			height="30" border="0" id="Image5" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('delete','','../images/acceso/activos_sup.png',1)"></a></td>
		<td width="15">&nbsp;</td>
		<td width="32" align="center"><a href="../index_autent.html"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"><img
			src="../images/acceso/inactivos_exit.png" name="exit" width="33"
			height="33" border="0" class="blueText" id="exit" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"></a></td>
		<td width="15">&nbsp;</td>
		<td width="33">
		<div align="center"><a href="indexutileria.html"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image6','','../images/acceso/activos_salir.png',1)"><img
			src="../images/acceso/inactivos_salir.png" name="Image6" width="32"
			height="33" border="0" id="Image6" /></a></div>
		</td>
	</tr>
	<tr>
		<td class="whiteText" align="center">Agregar</td>
		<td class="whiteTitle"></td>
		<td class="whiteText" align="center">Eliminar</td>
		<td class="whiteTitle"></td>
		<td class="whiteText" align="center">Aceptar</td>
		<td class="whiteTitle"></td>
		<td class="whiteText" align="center">Cancelar</td>
		<td class="whiteTitle"></td>
		<td class="whiteText" align="center">Salir</td>
	</tr>
</table>
<a href="#" onmouseout="MM_swapImgRestore()"
	onmouseover="MM_swapImage('calc','','../images/acceso/activo-cal.png',1)"></a><!-- InstanceEndEditable -->
</div>
</div>
<div id="borde_der"></div>
<div id="contenido"><!-- InstanceBeginEditable name="Region2" -->
<table width="893" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="207" rowspan="9" align="left" valign="top"><textarea
			name="textarea" cols="30" rows="15" class="textarea"></textarea></td>
		<td width="25" rowspan="9">&nbsp;</td>
		<td colspan="4" valign="top">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4" valign="top" align="left" class="blackText1">Nombre</td>
	</tr>
	<tr>
		<td colspan="4" valign="top" align="left" class="blackText1"><input
			name="textfield" type="text" size="25" /></td>
	</tr>
	<tr>
		<td colspan="4" valign="top" class="blackSubtitle" align="left">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4" valign="top" align="left" class="blackText1">Estado</td>
	</tr>

	<tr>
		<td colspan="4" align="left" valign="top" class="blackText1"><select
			name="select">
			<option>-Seleccione-</option>
		</select></td>
	</tr>
	<tr>
		<td colspan="4" align="left" valign="top">&nbsp;</td>
	</tr>

	<tr>
		<td width="195" colspan="2" align="left" valign="top"></td>
		<td colspan="2" align="left" valign="top">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="2" align="left" valign="top">&nbsp;</td>
		<td width="173" align="left" valign="top">&nbsp;</td>
		<td width="293" valign="top">&nbsp;</td>
	</tr>
</table>
</p>
<!-- InstanceEndEditable --></div>
<div id="pie_pag"></div>
</div>
</div>
</center>
</body>
<!-- InstanceEnd -->
</html>
