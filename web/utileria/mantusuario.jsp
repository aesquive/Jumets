<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.List"%>
<%@page import="com.urbi.utilerias.dao.UsuariosImpl"%>
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
	Usuarios usuario = (Usuarios) request.getSession().getAttribute("usuario");
	String agregar = (String)request.getSession().getAttribute("agregar");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Utiler&iacute;as del Sistema</title>
<!-- InstanceEndEditable -->
<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/funciones.js"></script>
<script language="javascript" src="../js/catalogos.js"></script>
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
</head>
<body
	onload="activarCamposUsu(<%=("0".equals(agregar))?true:false%>,<%=usuarioUrbi.isSupervisor()%>);MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_mod.png','../images/acceso/activos_sup.png','../images/acceso/activo-calc.png','../images/acceso/activos_exit.png','../images/acceso/activo-cal.png','../images/acceso/activos_salir.png','../images/acceso/aceptar-2_08.png')">
<center>
<div id="contenedor">
<div id="encabezado">
<div id="borde_iz"></div>
<div id="logo"></div>
<div id="relleno">
<div id="capa_enc"><!-- InstanceBeginEditable name="region1" -->
<table width="321" border="0" align="right" cellpadding="0"
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
		<td width="33" align="center"><a tabindex="9"
			href="javascript:activarCamposUsu(false,<%=usuarioUrbi.isSupervisor()%>);"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img
			src="../images/acceso/inactivos_add.png" name="add" width="33"
			height="33" border="0" class="textarea" id="add" /></a></td>
		<td width="15">&nbsp;</td>
		<td width="35" align="center"><a 
			href="#"
			onclick="eliminarUsuario();"
			onmouseout="MM_swapImgRestore()" tabindex="10"
			onmouseover="MM_swapImage('delete','','../images/acceso/activos_sup.png',1)"><img
			src="../images/acceso/inactivos_sup.png" name="delete" width="33"
			height="33" border="0" class="textarea" id="delete" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('mod','','../images/acceso/activos_mod.png',1)"></a></td>
		<td width="15">&nbsp;</td>
		<td width="33" align="center"><a 
			href="#"
			onclick="guardar();" tabindex="8"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image5','','../images/acceso/aceptar-2_08.png',1)"><img
			src="../images/acceso/aceptar_08.png" name="Image5" width="31"
			height="30" border="0" id="Image5" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('delete','','../images/acceso/activos_sup.png',1)"></a></td>
		<td width="15">&nbsp;</td>
		<td width="32" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()" tabindex="11"
			onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"><img
			src="../images/acceso/inactivos_exit.png" name="exit" width="33"
			height="33" border="0" class="blueText" id="exit" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"></a></td>
		<td width="15">&nbsp;</td>
		<td width="33">
		<div align="center"><a href="indexutileria.jsp"
			onmouseout="MM_swapImgRestore()" tabindex="12"
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
<form action="../UsuariosAction" id="usuarioForm" name="usuarioForm" method="post">
<input type="hidden" id="id" name="id" value="${usuario.id}"/>
<input type="hidden" id="accion" name="accion" value=""/>
<div id="contenido">
<%@include file="../ErrorTag.jsp"%>
<table width="1012" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="207" rowspan="13" align="center" valign="top">
			<select name="listaU" id="listaU" multiple="multiple" class="lista_200"
					size="20" onchange="SelUsuIndex();">
				<%
				UsuariosImpl usuI = new UsuariosImpl();
				List lista = usuI.mostrarRegistros(usuarioUrbi.isSupervisor());
				for(int i=0;i<lista.size();i++){
					Usuarios usu = (Usuarios)lista.get(i);
				%>
				<option value="<%=usu.getId()%>"><%=usu.getNombre()%></option>
				<%}%>
			</select>
		</td>
		<td width="24" rowspan="13">&nbsp;</td>
		<td colspan="4" valign="top">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4" valign="top" align="left" class="blackText1">Clave</td>
	</tr>
	<tr>
		<td colspan="4" valign="top" align="left" class="blackText1">
			<input 	id="clave" name="clave" 
					type="text" size="15" 
					maxlength="20" tabindex="1"
					value="${usuario.clave}"/>
		</td>
	</tr>
	<tr>
		<td colspan="4" valign="top" class="blackSubtitle" align="left">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4" valign="top" align="left" class="blackText1">Nombre</td>
	</tr>

	<tr>
		<td colspan="4" align="left" valign="top" class="blackText1">
			<input 	type="text" id="nombre" name="nombre" 
					style="width: 250px" maxlength="20"
					tabindex="2" value="${usuario.nombre}"/>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="left" valign="top">&nbsp;</td>
	</tr>
	<tr>
		<td width="119" align="left" valign="middle" class="blackText1">Contrase&ntilde;a</td>
		<td width="4" align="left" valign="middle" class="blackText1">&nbsp;</td>
		<td colspan="2" align="left" valign="middle" class="blackText1">Verificar
		Contrase&ntilde;a</td>
	</tr>
	<tr>
		<td align="left" valign="top">
			<input 	id="password" name="password" type="password" size="15" 
					tabindex="3" maxlength="15"
					value="${usuario.password}"/>
		</td>
		<td align="left" valign="top">&nbsp;</td>
		<td width="205" align="left" valign="top">
			<input 	id="passwordV" name="passwordV" type="password" size="15" 
					tabindex="4" maxlength="15"
					value="${usuario.password}"/>
		</td>
		<td align="left" valign="top">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4" align="left" valign="middle" class="blackText1">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3" align="left" valign="top">
		<fieldset><legend class="blackText1"
			style="font-weight: bold">Perfil de Usuario</legend>
		<table width="207" border="0" cellspacing="0" cellpadding="0" id="perfilTD">
			<tr>
				<td width="27" valign="middle" align="right" class="blackText1">
					<input 	id="sup" name="perfil" type="radio" value="0" tabindex="5"
							<%=("0".equals(usuario.getPerfil()))?"checked":""%>/>
				</td>
				<td width="180" align="left" valign="top" class="blackText1">
					<label for="sup">Supervisor</label>
				</td>
			</tr>

			<tr>
				<td valign="middle" align="right" class="blackText1">
					<input 	id="admon" name="perfil" type="radio" value="1" tabindex="6"
							<%=("1".equals(usuario.getPerfil()))?"checked":""%>/>
				</td>
				<td><span class="blackText1"><label for="admon">Administrador</label></span></td>
			</tr>
			<tr>
				<td valign="middle" align="right" class="blackText1">
					<input 	id="ven" name="perfil" type="radio" value="2" tabindex="7"
							<%=("2".equals(usuario.getPerfil()))?"checked":""%>/>
				</td>
				<td><span class="blackText1"><label for="ven">Vendedor</label></span></td>
			</tr>
		</table>
		</fieldset>
		 </td>
		<td align="left" valign="top">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="3" align="left" valign="top">&nbsp;</td>
		<td width="285" valign="top">
		<div align="right"></div>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="left" valign="top">&nbsp;</td>
		<td valign="top" class="blueSubtitle">&nbsp;</td>
	</tr>
</table>
</div>
</form>
<div id="pie_pag"></div>
</div>
</div>
</center>
</body>
<!-- InstanceEnd -->
</html>
