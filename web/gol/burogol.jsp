<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml">
<!-- InstanceBegin template="/Templates/plantilla3.dwt" codeOutsideHTMLIsLocked="false" -->
<%@page import="java.util.*"%>
<%@page import="objetos.*"%>
<%@page import="org.hibernate.*"%>
<%@page import="gol.beans.*"%>
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
	GolBean goal = (GolBean) request.getSession().getAttribute("gol");
	String accion = (String) request.getSession()
			.getAttribute("accion");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Originaci&oacute;n de Cliente</title>
<!-- InstanceEndEditable -->
<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/funciones.js"></script>
<script language="javascript" src="../js/gol.js"></script>
<script language="javascript" src="../js/golVal.js"></script>
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
</head>
<body onload="<%if((goal.getBuroCredito() == 1)){%>selBuroReg();<%}else{%>cargaBuroReg();<%}%>MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_exit.png','../images/acceso/activos_guardar.png','../images/buscar_activo.png','../images/acceso/activos_salir.png','../images/acceso/inactivo-blanco_salir.png','../images/acceso/activos_left.png','../images/acceso/activos_right.png','../images/accesos_down/aplicacion-2_36.png','../images/accesos_down/aplicacion-2_34.png','../images/accesos_down/aplicacion-2_30.png','../images/accesos_down/aplicacion-2_28.png')">
<form name="buro" id="buro" method="post" action="../GolServlet" onsubmit="return validate_form(this)">
<input type="hidden" id="command" name="command" value="test" />
<input type="hidden" id="accion" name="accion" value="<%=accion%>" />
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
		<td colspan="18" align="center" class="blueSubtitle">Originaci&oacute;n del Cliente		</td>
	</tr>
	<tr>
		<td colspan="18" align="center" class="whiteSubtitle">Mantenimiento
		a Personas</td>
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
		<td width="41" align="center"><a onclick="nuevoAgregar()"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img
			src="../images/acceso/inactivos_add.png" name="add" width="33"
			height="33" border="0" class="button" id="add" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"></a></td>
		<td width="10">&nbsp;</td>
		<td width="39" align="center"><a onclick="BorrarControles()"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"><img
			src="../images/acceso/inactivos_exit.png" name="exit" width="33"
			height="33" border="0" class="button" id="exit" /></a><a
			href="#" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"></a></td>
		<td width="10">&nbsp;</td>
		<td width="34" align="center"><a
			href="#"
			onclick="valPagina7('<%=(goal.getIdGol()==-1)?"guardar7":"modificar"%>', 'buro',1);"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('guardar','','../images/acceso/activos_guardar.png',1)"><img
			src="../images/acceso/inactivos_guardar.png" name="guardar"
			width="34" height="33" border="0" class="button" id="guardar" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('buscar','','../images/buscar_activo.png',1)"></a></td>
		<td width="10">&nbsp;</td>
		<td width="35" align="center"><a href="#"
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
		<td height="19" class="whiteText">
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
		<div align="center">Agregar</div>		</td>
		<td class="whiteText">
		<div align="center"></div>		</td>
		<td class="whiteText">
		<div align="center">Cancelar</div>		</td>
		<td class="whiteText">
		<div align="center"></div>		</td>
		<td class="whiteText">
		<div align="center">Guardar</div>		</td>
		<td class="whiteText">
		<div align="center"></div>		</td>
		<td class="whiteText">
		<div align="center">Salir</div>		</td>
		<td class="whiteText">
		<div align="center"></div>		</td>
	</tr>
</table>
<!-- InstanceEndEditable --></div>
</div>
<div id="borde_der"></div>
<div id="contenido">
<%@include file="../ErrorTag.jsp"%>
<table width="760" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="7" colspan="13" valign="top" align="center"
			class="blackText1">
		<fieldset>
		<table width="709" height="346" border="0" cellpadding="00"
			cellspacing="0">
			<tr>
				<td height="18" colspan="3" valign="top" align="left"
					class="blackText1">&nbsp;</td>
			</tr>
			<tr>
				<td height="40" colspan="3" valign="top" align="left"
					class="blackText1">
				<fieldset>
				<table width="551" border="0" cellpadding="00" cellspacing="0">
					<tr>
						<td colspan="5" valign="top" align="left" class="blackText1">&iquest;Se
						encontr&oacute; el registro del cliente en el Bur&oacute; Nacional
						de Cr&eacute;dito?</td>
					</tr>
					<tr>
						<td width="13" valign="middle" align="left" class="blackText1">&nbsp;</td>
						<td width="20" valign="middle" align="right" class="blackText1">
							<input 	name="buroCredito" id="buroCredito1" 
									type="radio" value="1"
									onclick="selBuroReg();"
									<%=(goal.getBuroCredito() == 1) ? "checked" : ""%> />
						</td>
						<td width="54" valign="bottom" align="left" class="blackText1">Si</td>
						<td width="21" valign="middle" align="right" class="blackText1">
							<input 	name="buroCredito" id="buroCredito2" type="radio" value="0"
									<%=(goal.getBuroCredito() == 0)? "checked":""%>
									onclick="selBuroReg();"/>
							
						</td>
						<td width="443" valign="bottom" align="left" class="blackText1">No</td>
					</tr>
				</table>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td height="18" colspan="3" valign="top" align="left"
					class="blackText1">&nbsp;</td>
			</tr>
			<tr>
				<td width="319" height="126" align="left" valign="top">
				<fieldset>
				<table width="450" height="108" border="0" cellpadding="00"
					cellspacing="0" class="blackText1">
					<tr>
						<td colspan="3" align="center" valign="top" class="blackText1">&nbsp;</td>
					</tr>
					<tr>
						<td width="150" align="left" valign="top" class="blackText1">ANT</td>
						<td width="150" align="left" valign="top" class="blackText1">ACT</td>
						<td width="150" align="left" valign="top" class="blackText1">HIST</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1"><select
							name="ant" id="ant">
							<option value="-1">-Seleccione-</option>
							<option value="1" <%=((goal.getAnt()==1)?"selected":"")%>>(0 - 36)</option>
							<option value="2" <%=((goal.getAnt()==2)?"selected":"")%>>(37 - 100)</option>
						</select></td>
						<td valign="top" align="left" class="blackText1"><select
							name="act" id="act" class="combo_100">
							<option value="-1">-Seleccione-</option>
							<option value=" 7" <%=((goal.getAct()==7)?"selected":"")%>>0</option>
							<option value="8" <%=((goal.getAct()==8)?"selected":"")%>>1</option>
							<option value="9" <%=((goal.getAct()==9)?"selected":"")%>>2</option>
							<option value="10" <%=((goal.getAct()==10)?"selected":"")%>>(3 - 7)</option>
							<option value="11" <%=((goal.getAct()==11)?"selected":"")%>>(8 -10)</option>
							<option value="12" <%=((goal.getAct()==12)?"selected":"")%>>MAYOR A 10</option>
						</select></td>
						<td valign="top" align="left" class="blackText1"><select
							name="hist" id="hist" class="combo_100">
							<option value="-1">-Seleccione-</option>
							<option value="1" <%=((goal.getHist()==1)?"selected":"")%>>(0 - 2)</option>
							<option value="2" <%=((goal.getHist()==2)?"selected":"")%>>(3 - 7)</option>
							<option value="3" <%=((goal.getHist()==3)?"selected":"")%>>(8 - 10)</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">USO</td>
						<td valign="top" align="left" class="blackText1">PAGO</td>
						<td valign="top" align="left" class="blackText1">MOP</td>
					</tr>
					<tr>
						<td align="left"><select name="uso" id="uso" class="combo_140">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getBurUsu(String.valueOf(goal.getUso()))%>
						</select></td>
						<td valign="top" align="left" class="blackText1"><select
							name="pago" id="pago">
							<option value="-1">-Seleccione-</option>
							<option value="1" <%=((goal.getPago()==1)?"selected":"")%>>(0 - 39.0%)</option>
							<option value="2" <%=((goal.getPago()==2)?"selected":"")%>>MAS DE 39.1%</option>
						</select></td>
						<td valign="top" align="left" class="blackText1"><input
							name="mop" id="mop" type="text" size="8" value="<%=goal.getMop()%>" 
							onblur="buroRangos('mop');"
							onkeypress="AceptaNumerico();"/></td>
					</tr>

					<tr>
						<td colspan="3">&nbsp;</td>
					</tr>
				</table>
				</fieldset>
				</td>
				<td width="57" valign="top" align="left" class="blackText1">&nbsp;</td>
				<td width="407" height="126" align="left" valign="top" class="blackText1">
				<fieldset>
					<legend class="blackText1" style="font-weight: bold">Cuentas abiertas</legend>
					<table width="400" height="108" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td valign="top" align="left" class="blackText1" width="150">Cuentas
						abiertas</td>
						<td valign="top" align="left" class="blackText1" width="150">M&aacute;ximo
						abiertas</td>
						<td valign="top" align="left" class="blackText1" width="100">Monto
						abiertas</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1"><select
							name="cuentasA" id="cuentasA" class="combo_140">
							<option value="-1">-Seleccione-</option>
							<option value="1" <%=("1".equals(goal.getCuentasA())?"selected":"")%> title="(0 - 1)">(0 - 1)</option>
							<option value="2" <%=("2".equals(goal.getCuentasA())?"selected":"")%> title="(2 - 3)">(2 - 3)</option>
							<option value="5" <%=("3".equals(goal.getCuentasA())?"selected":"")%> title="TODAS LAS CUENTAS TIENEN FECHA DE CIERRE">TODAS LAS CUENTAS TIENEN FECHA DE CIERRE</option>
						</select></td>
						<td valign="top" align="left" class="blackText1"><input
							name="maximaA" id="maximaA" type="text" size="8" value="${gol.maximaA}" 
							onblur="buroRangos('maximaA');"
							onkeypress="AceptaNumerico();"/></td>
						<td valign="top" align="left" class="blackText1"><input
							name="montoA" id="montoA" type="text" size="8" value="${gol.montoA}"
							onkeypress="AceptaNumerico();"/></td>
					</tr>
					<tr>
						<td height="18" colspan="3">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td align="left" valign="top" class="blackText1">L&iacute;mite
						abiertas</td>
						<td valign="top" align="left" class="blackText1">Saldo
						actual abiertas</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="left" valign="top" class="blackText1"><input
							name="limiteA" id="limiteA" type="text" size="8" value="${gol.limiteA}" 
							onkeypress="AceptaNumerico();"/></td>
						<td valign="top" align="left" class="blackText1"><input
							name="saldoA" id="saldoA" type="text" size="8" value="${gol.saldoA}" 
							onkeypress="AceptaNumerico();"/></td>
					</tr>
				</table>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td height="18" colspan="2" align="left" valign="top"
					class="blackText1">&nbsp;</td>
				<td valign="top" align="left" class="blackText1">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1">
				<fieldset><legend class="blackText1"
					style="font-weight: bold">Cuentas cerradas</legend>
				<table width="345" height="108" border="0" cellpadding="00"
					cellspacing="0">
					<tr>
						<td valign="top" align="center" class="blackText1">Cuentas
						cerradas</td>
						<td valign="top" align="center" class="blackText1">M&aacute;ximo
						cerradas</td>
						<td valign="top" align="center" class="blackText1">Monto
						cerradas</td>
					</tr>
					<tr>
						<td valign="top" align="center" class="blackText1"><input
							name="cuentasC" id="cuentasC" type="text" size="8" value="${gol.cuentasC}" 
							onblur="buroRangos('cuentasC');"
							onkeypress="AceptaNumerico();"/></td>
						<td valign="top" align="center" class="blackText1"><input
							name="maximaC" id="maximaC" type="text" size="8" value="${gol.maximaC}" 
							onblur="buroRangos('maximaC');"
							onkeypress="AceptaNumerico();"/></td>
						<td valign="top" align="center" class="blackText1"><input
							name="montoC" id="montoC" type="text" size="8" value="${gol.montoC}" 
							onkeypress="AceptaNumerico();"/></td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
					</tr>
					<tr>
						<td align="center" valign="top" class="blackText1">&nbsp;</td>
						<td align="center" valign="top" class="blackText1">L&iacute;mite
						cerradas</td>
						<td valign="top" align="center" class="blackText1">Saldo
						actual cerradas</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center" valign="top" class="blackText1"><input
							name="limiteC" id="limiteC" type="text" size="8" value="${gol.limiteC}" 
							onkeypress="AceptaNumerico();"/></td>
						<td valign="top" align="center" class="blackText1"><input
							name="saldoC" id="saldoC" type="text" size="8" value="${gol.saldoC}" 
							onkeypress="AceptaNumerico();"/></td>
					</tr>
				</table>
				</fieldset>
				</td>
				<td valign="top" align="left" class="blackText1">&nbsp;</td>
				<td valign="bottom" align="left" class="blackText1">
				<fieldset>
				<table width="345" height="118" border="0" cellpadding="00"
					cellspacing="0">
					<tr>
						<td height="10" colspan="3" align="center" valign="top"
							class="blackText1">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" align="center" class="blackText1">Importe
						del MOP</td>
						<td valign="top" align="center" class="blackText1">Tipo de
						cr&eacute;dito</td>
						<td valign="top" align="center" class="blackText1">Pago a
						realizar</td>
					</tr>
					<tr>
						<td valign="top" align="center" class="blackText1"><input
							name="importeMop" id="importeMop" type="text" size="8" value="${gol.importeMop}" 
							onkeypress="AceptaNumerico();"/></td>
						<td valign="top" align="center" class="blackText1"><input
							name="tipoCreditoMop" id="tipoCreditoMop" type="text" size="8"
							value="${gol.tipoCreditoMop}" /></td>
						<td valign="top" align="center" class="blackText1"><input
							name="pagoRealizar" id="pagoRealizar" type="text" size="8"
							value="${gol.pagoRealizar}" 
							onkeypress="AceptaNumerico();"/></td>
					</tr>
					<tr>
						<td height="18" colspan="3">&nbsp;</td>
					</tr>
					<tr>
						<td align="center" valign="top" class="blackText1">&nbsp;</td>
						<td align="center" valign="top" class="blackText1">Mensualidad*</td>
						<td valign="top" align="center" class="blackText1">Valor de
						vivienda*</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center" valign="top" class="blackText1"><input
							name="mensualidad" id="mensualidad" type="text" size="8"
							value="${gol.mensualidad}" 
							onkeypress="AceptaNumerico();"
							onblur="valMensu()"/></td>
						<td valign="top" align="center" class="blackText1"><input
							name="valorVivienda" id="valorVivienda" type="text" size="8"
							value="${gol.valorVivienda}" 
							onkeypress="AceptaNumerico();"
							onblur="valVivienda();"/></td>
					</tr>

				</table>
				</fieldset>
				</td>
			</tr>
		</table>
		</fieldset>
		</td>
	</tr>

	<tr>
		<td colspan="4">&nbsp;</td>
		<td width="57" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image10','','../images/accesos_down/aplicacion-2_28.png',1)"><img
			src="../images/accesos_down/aplicacion-23_28.png" name="Image10"
			width="33" height="32" border="0" id="Image10" /></a></td>
		<td width="8">&nbsp;</td>
		<td width="48" align="center"><a
			href="#"
			onclick="valPagina7('<%=(goal.getIdGol()==-1)?"guardar7":"modificar"%>', 'buro',1);"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image9','','../images/accesos_down/aplicacion-2_30.png',1)"><img
			src="../images/accesos_down/aplicacion-23_30.png" name="Image9"
			width="33" height="32" border="0" id="Image9" /></a></td>
		<td width="7">&nbsp;</td>
		<td width="45" align="center"><a href="#"
			onclick="salirGol();"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image8','','../images/accesos_down/aplicacion-2_34.png',1)"><img
			src="../images/accesos_down/aplicacion-23_34.png" name="Image8"
			width="32" height="32" border="0" id="Image8" /></a></td>
		<td width="7">&nbsp;</td>
		<td width="97" align="center"><a 
			href="#"
			onclick="valPagina7('pagina7PB', 'buro',2)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image61','','../images/accesos_down/aplicacion-2_36.png',1)"><img
			src="../images/accesos_down/aplicacion-23_36.png" name="Image61"
			width="32" height="32" border="0" id="Image61" /></a></td>
		<td width="10">&nbsp;</td>
		<td align="center"><a 
			href="#"
			onclick="valPagina7('pagina7AB', 'buro',2)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image6', '', '../images/accesos_down/aplicacion-2_36.png', 1);"><img
			src="../images/accesos_down/aplicacion-23_36.png" name="Image6"
			width="32" height="32" border="0" id="Image6" /></a></td>
	</tr>
	<tr>
		<td width="314">&nbsp;</td>
		<td width="9">&nbsp;</td>
		<td width="9">&nbsp;</td>
		<td width="67">&nbsp;</td>
		<td align="center" class="blueText" valign="top">Cancelar</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText" valign="top">Guardar</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText" valign="top">Salir</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText" valign="top">Primera Pantalla</td>
		<td>&nbsp;</td>
		<td align="center" valign="top" class="blueText">Anterior</td>
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
