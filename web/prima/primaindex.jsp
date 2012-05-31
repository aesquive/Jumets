<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.prima.PrimaSql"%>
<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html
	xmlns="http://www.w3.org/1999/xhtml">
<!-- InstanceBegin template="/Templates/plantilla2.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<%@page import="java.util.*"%>
<%@page import="objetos.*"%>
<%
	Usuarios usuarioUrbi = (Usuarios)session.getAttribute("usuarioUrbi");
	if(usuarioUrbi==null){
		try{
			response.sendRedirect("../index.jsp");
		}catch(IOException io){
			System.out.println("ERROR:"+io.getMessage());
		}
	}
	String lista = (String)request.getSession().getAttribute("lista");
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Prima Pura</title>
<!-- InstanceEndEditable -->
<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/prima.js"></script>
<script language="javascript" src="../js/funciones.js"></script>
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
</head>
<body
	onload="MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_mod.png','../images/acceso/activos_sup.png','../images/acceso/activo-calc.png','../images/acceso/activos_exit.png','../images/acceso/activo-cal.png','../images/buscar_activo.png','../images/todo_activo.png')">
<form id="PrimaIndex" name="PrimaIndex" method="post" action="../PrimaMantServlet" onsubmit="return validate_form(this)">
<input type="hidden" id="command" name="command" value=""></input>
<input type="hidden" id="idPrima" name="idPrima" value=""></input>
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
		<td colspan="9" align="center" class="blueSubtitle">Prima Pura de
		Riesgo</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="whiteSubtitle">Mantenimiento
		a Personas</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="whiteSubtitle">&nbsp;</td>
	</tr>
	<tr>
		<td width="33" align="center"><a
			href="javascript:ejecutar('Agregar', 'PrimaIndex');"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img
			src="../images/acceso/inactivos_add.png" name="add" width="33"
			height="33" border="0" class="textarea" id="add" /></a></td>
		<td width="15">&nbsp;</td>
		<td width="35" align="center"><a
			href="javascript:modificarPrima();"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('mod','','../images/acceso/activos_mod.png',1)"><img
			src="../images/acceso/inactivos_mod.png" name="mod" width="35"
			height="33" border="0" class="textarea" id="mod" /></a></td>
		<td width="15">&nbsp;</td>
		<td width="33" align="center"><a
			href="javascript:eliminarPrima();"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('delete','','../images/acceso/activos_sup.png',1)"><img
			src="../images/acceso/inactivos_sup.png" name="delete" width="33"
			height="33" border="0" class="textarea" id="delete" /></a></td>
		<td width="15">&nbsp;</td>
		<td width="32" align="center"><a
			href="#"
			onclick="calcularPrimaInicio();"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"><img
			src="../images/acceso/inactivo-calc.png" name="calc" width="32"
			height="32" border="0" class="textarea" id="calc" /></a></td>
		<td width="15">&nbsp;</td>
		<td width="33">
		<div align="center"><a href="../index_autent.jsp"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)">
		<img src="../images/acceso/inactivos_exit.png" name="exit" width="33"
			height="33" border="0" class="blueText" id="exit" /></a></div>
		</td>
	</tr>
	<tr>
		<td class="whiteText" align="center">Agregar</td>
		<td class="whiteTitle"></td>
		<td class="whiteText" align="center">Modificar</td>
		<td class="whiteTitle"></td>
		<td class="whiteText" align="center">Eliminar</td>
		<td class="whiteTitle"></td>
		<td class="whiteText" align="center">Calcular</td>
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
<p><%@include file="../ErrorTag.jsp"%>
<table width="888" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="207" rowspan="14" align="left" valign="top"><!-- Mostrara las lista de todos los registros -->
		<select name="listaP" id="listaP" multiple="multiple" class="lista_200"
			size="20" onchange="SelPrimaIndex();">
			<%=(lista==null)?PrimaSql.getListaPrima("","",0):lista%>
		</select></td>
		<td width="17" rowspan="14">&nbsp;</td>
		<td colspan="6" valign="top">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="6" valign="top">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="6" valign="top" class="blackSubtitle" align="left">Criterios
		de b&uacute;squeda para Persona</td>
	</tr>
	<tr>
		<td colspan="6" valign="top">&nbsp;</td>
	</tr>

	<tr>
		<td width="20" align="left" valign="middle" class="blackText1">
			<input 	type="checkbox" id="cRfc" name="cRfc" value="0" 
					onclick="if(document.getElementById('cRfc').checked == true){document.getElementById('rfc').disabled=false;document.getElementById('rfc').focus();}else{document.getElementById('rfc').disabled=true;}"/>
		</td>
		<td width="131" align="left" valign="middle" class="blackText1">por
		RFC</td>
		<td colspan="4" align="" valign="top">
		<div align="justify">
			<input id="rfc" name="rfc" type="text" size="50" disabled="disabled" maxlength="15"/>
		</div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="left" valign="top">&nbsp;</td>
		<td colspan="4" align="" valign="top">&nbsp;</td>
	</tr>
	<tr>
		<td align="left" valign="middle" class="blackText1">
			<input 	type="checkbox" id="cPersona" name="cPersona" value="1" 
					onclick="if(document.getElementById('cPersona').checked == true){document.getElementById('persona').disabled=false;document.getElementById('persona').focus();}else{document.getElementById('persona').disabled=true;}"/>
		</td>
		<td align="left" valign="middle" class="blackText1">por Persona</td>
		<td colspan="4" align="" valign="top">
		<div align="justify">
			<input id="persona" name="persona" type="text" size="65" maxlength="30" disabled="disabled"/></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="left" valign="top">&nbsp;</td>
		<td colspan="4" align="" valign="top">&nbsp;</td>
	</tr>
	<tr>
		<td align="left" valign="middle" class="blackText1">
			&nbsp;
		</td>
		<td align="left" valign="middle" class="blackText1">&nbsp;</td>
		<td align="" valign="middle">
		
		</td>
		<td align="" valign="top">
		<div align="center"><a href="javascript:buscar();" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('buscar','','../images/buscar_activo.png',1)"><img
			src="../images/buscar_inactivo.png" name="buscar" width="32"
			height="32" border="0" class="textarea" id="buscar" /></a></div>
		</td>
		<td align="" valign="top">&nbsp;</td>
		<td align="" valign="top">
		<div align="center"><a
			href="javascript:buscarTodos();"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('todo','','../images/todo_activo.png',1)"><img
			src="../images/todo_inactivo.png" name="todo" width="32" height="32"
			border="0" class="textarea" id="todo" /></a></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="left" valign="top">&nbsp;</td>
		<td width="368" valign="top">&nbsp;</td>
		<td width="59" valign="top">
		<div align="right"><span class="blueSubtitle">Buscar</span></div>
		</td>
		<td width="15" valign="top">&nbsp;</td>
		<td width="71" valign="top">
		<div align="right"><span class="blueSubtitle">Ver Todos</span></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="left" valign="top">&nbsp;</td>
		<td valign="top" class="blueSubtitle">&nbsp;</td>
		<td valign="top" class="blueSubtitle">&nbsp;</td>
		<td valign="top" class="blueSubtitle">&nbsp;</td>
		<td valign="top" class="blueSubtitle">&nbsp;</td>
	</tr>
</table>
</p>
<!-- InstanceEndEditable --></div>
<div id="pie_pag"></div>
</div>
</div>
</center>
</form>
</body>
<!-- InstanceEnd -->
</html>
