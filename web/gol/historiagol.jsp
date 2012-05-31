<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml">
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
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
</head>
<body

            onload="MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_exit.png','../images/acceso/activos_guardar.png','../images/buscar_activo.png','../images/acceso/activos_salir.png','../images/acceso/inactivo-blanco_salir.png','../images/acceso/activos_left.png','../images/acceso/activos_right.png','../images/accesos_down/aplicacion-2_28.png','../images/accesos_down/aplicacion-2_30.png','../images/accesos_down/aplicacion-2_34.png','../images/accesos_down/aplicacion-2_36.png','../images/accesos_down/aplicacion-2_41.png')">
<form id="Historialgol" name="Historialgol" method="post"
	action="../GolServlet" onsubmit="return validate_form(this)"><input
	type="hidden" id="command" name="command" value="test" /> <input
	type="hidden" id="accion" name="accion" value="<%=accion%>" />
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
		<td width="41" align="center"><a 
			href="#"
			onclick=""
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img
			src="../images/acceso/inactivos_add.png" name="add" width="33"
			height="33" border="0" class="button" id="add" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"></a></td>
		<td width="10">&nbsp;</td>
		<td width="39" align="center"><a
			href="#" 
			onclick=""
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"><img
			src="../images/acceso/inactivos_exit.png" name="exit" width="33"
			height="33" border="0" class="button" id="exit" /></a><a
			href="#" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"></a></td>
		<td width="10">&nbsp;</td>
		<td width="34" align="center"><a
			href="#"
			onclick="valPagina4('Guardar4', 'Historialgol',0)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('guardar','','../images/acceso/activos_guardar.png',1)"><img
			src="../images/acceso/inactivos_guardar.png" name="guardar"
			width="34" height="33" border="0" class="button" id="guardar" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('buscar','','../images/buscar_activo.png',1)"></a></td>
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
<table width="785" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td colspan="15" align="center">
		<fieldset>
		<table width="779" height="438" border="0" align="left"
			cellpadding="0" cellspacing="0">
			<tr>
				<td height="14" colspan="5"> </td>
			</tr>
			<tr>
				<td width="180" valign="top"></td>
				<td width="193" valign="top"></td>
			</tr>
			<tr>
				<td valign="top"></td>
				<td valign="top"></td>
			</tr>
			<tr>
				<td valign="top"></td>
				<td valign="top"></td>
			</tr>
			<tr>
				<td valign="top"></td>
				<td valign="top"></td>
			</tr>
			<tr>
				<td height="30" align="left" valign="top" class="blackText1">&iquest;Tiene
				alguna actividad<br />
				adicional remunerada?*</td>
				<td colspan="4" rowspan="5" valign="top">
				<table width="559" height="88" border="0" cellpadding="00"
					cellspacing="0">
					<tr>
						<td width="341" valign="top">
						<fieldset>
						<table width="339" height="87" border="0" cellpadding="00"
							cellspacing="0">
							<tr>
								<td width="194" align="left" valign="top" class="blackText1">&nbsp;&iquest;Recibe
								alg&uacute;n dinero extra?*</td>
								<td width="152" align="left" valign="top" class="blackText1">Concepto*</td>
							</tr>
							<tr>
								<td align="left" valign="top" class="blackText1">&nbsp;
									<select name="dineroExtraR" id="dineroExtraR" tabindex="1" onchange="dineroExtraChange();">
								    <option value="1"
										<%=("1".equals(goal.getDineroExtraR()))?"selected":""%>>SI</option>
										<option value="2"
										<%=("2".equals(goal.getDineroExtraR()))?"selected":""%>>NO</option>
									</select>
								</td>
								<td align="left" valign="top" class="blackText1">
									<input name="dineroConcepto" 	type="text" id="dineroConcepto" tabindex="2"
											class="mayus"
											value="${gol.dineroConcepto}"
											maxlength="20"/></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="left" valign="top" class="blackText1">&nbsp;&iquest;Cu&aacute;nto?*</td>
								<td align="left" valign="top" class="blackText1">Frecuencia*</td>
							</tr>
							<tr>
								<td align="left" valign="top" class="blackText1">&nbsp;<input
									name="dineroECuanto" type="text" id="dineroECuanto" tabindex="3" 
									onkeypress="AceptaNumerico();"
									value="${gol.dineroECuanto}" size="8"
									maxlength="8"/>
								</td>
								<td align="left" valign="top" class="blackText1"><select
									name="dineroFrec" class="combo_140" id="dineroFrec" tabindex="4">
									<option value="-1">-Seleccione-</option>
									<option value="1"
										<%=("1".equals(goal.getDineroFrec()))?"selected":""%>>DIARIO</option>
									<option value="2"
										<%=("2".equals(goal.getDineroFrec()))?"selected":""%>>SEMANALMENTE</option>
									<option value="3"
										<%=("3".equals(goal.getDineroFrec()))?"selected":""%>>QUINCENALMENTE</option>
									<option value="4"
										<%=("4".equals(goal.getDineroFrec()))?"selected":""%>>MENSUALMENTE</option>
									<option value="5"
										<%=("5".equals(goal.getDineroFrec()))?"selected":""%>>ANUALMENTE</option>
									<option value="6"
										<%=("6".equals(goal.getDineroFrec()))?"selected":""%>>OCASIONALMENTE</option>
								</select></td>
							</tr>
						</table>
						</fieldset>
						 </td>
						<td width="15" valign="top">&nbsp;</td>
						<td width="203" valign="top">
						<fieldset>
						<table width="174" border="0" cellpadding="00" cellspacing="0">
							<tr>
								<td align="left" valign="top" class="blackText1">&iquest;Paga
								renta actualmente?*</td>
							</tr>
							<tr>
								<td align="left" valign="top" class="blackText1"><select
									name="pagaRenta" id="pagaRenta" tabindex="5" onchange="pagaRent();">
									<option value="1"
										<%=("1".equals(goal.getPagaRenta()))?"selected":""%>>SI</option>
									<option value="2"
										<%=("2".equals(goal.getPagaRenta()))?"selected":""%>>NO</option>
								</select></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="left" valign="top" class="blackText1">&iquest;Cu&aacute;nto?*</td>
							</tr>
							<tr>
								<td align="left" valign="top" class="blackText1"><input
									name="pagaRCuanto" type="text" id="pagaRCuanto" tabindex="6"
									onkeypress="AceptaNumerico();"
									value="${gol.pagaRCuanto}" size="8"
									onblur="rentaGto('pagaRCuanto');"
									maxlength="8" /></td>
							</tr>
						</table>
						</fieldset>
						 </td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="24" align="left" valign="top" class="blackText1"><input name="actividadAdicional"
					type="text" id="actividadAdicional" tabindex="7" 
					class="mayus"
					value="${gol.actividadAdicional}"/></td>
			</tr>
			<tr>
				<td height="12" valign="top"></td>
			</tr>
			<tr>
				<td height="6" align="left" valign="top" class="blackText1">Si
				lo necesita,<br />
				&iquest;a qui&eacute;n solicita un pr&eacute;stamo?*</td>
			</tr>
			<tr>
				<td height="17" align="left" valign="top" class="blackText1"><select
					name="solicitudCredito" class="combo_140" id="solicitudCredito" tabindex="8">
					<option value="-1">-Seleccione-</option>
					<%=GolSql.getSolicitudCredito(goal.getSolicitudCredito())%>
				</select></td>
			</tr>
			<tr>
				<td height="14" align="right" valign="top"></td>
				<td height="14" align="right" valign="top"></td>
				<td height="14" align="right" valign="top"></td>
				<td width="400" colspan="2" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" valign="top">
				<fieldset><legend class="blackText1"
					style="font-weight: bold">Créditos</legend>
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
				<table width="355" border="0" cellpadding="00" cellspacing="0">
					<tr>
						<td width="165" valign="top" align="left" class="blackText1">&iquest;Alguna
						vez ha solicitado<br />
						alg&uacute;n tipo de cr&eacute;dito?*</td>
						<td width="206" colspan="2" rowspan="3" align="left" valign="top"
							class="blackText1">
						<fieldset><legend class="blackText1"
							style="font-weight: bold">¿Cuándo?</legend>
						<table width="151" border="0" cellpadding="00" cellspacing="0">
							<tr>
								<td width="89" align="left" valign="top" class="blackText1">&nbsp;A&ntilde;o*</td>
								<td width="62" align="left" valign="top" class="blackText1">Mes*</td>
							</tr>
							<tr>
								<td valign="top" align="left" class="blackText1">
									<select id="creditoAnio"
											name="creditoAnio"
											class="combo_60" tabindex="10">
										<option value="-1">-A&ntilde;o-</option>
										<%
										for (int i = 1; i < 66; i++) {
											int ano = 1945 + i;
										%>
										<option value="<%=ano%>" <%=(String.valueOf(ano).equals(goal.getCreditoAnio()))?"selected":""%>><%=ano%></option>
										<%
										}
										%>
									</select>
								</td>
								<td valign="top" align="left" class="blackText1">
									<select name="creditoMes"  id="creditoMes" tabindex="11">
								    <option value="-1">-Mes-</option>
										<option value="01" <%=("1".equals(goal.getCreditoMes()))?"selected":""%>>Enero</option>
										<option value="02" <%=("2".equals(goal.getCreditoMes()))?"selected":""%>>Febrero</option>
										<option value="03" <%=("3".equals(goal.getCreditoMes()))?"selected":""%>>Marzo</option>
										<option value="04" <%=("4".equals(goal.getCreditoMes()))?"selected":""%>>Abril</option>
										<option value="05" <%=("5".equals(goal.getCreditoMes()))?"selected":""%>>Mayo</option>
										<option value="06" <%=("6".equals(goal.getCreditoMes()))?"selected":""%>>Junio</option>
										<option value="07" <%=("7".equals(goal.getCreditoMes()))?"selected":""%>>Julio</option>
										<option value="08" <%=("8".equals(goal.getCreditoMes()))?"selected":""%>>Agosto</option>
										<option value="09" <%=("9".equals(goal.getCreditoMes()))?"selected":""%>>Septiembre</option>
										<option value="10" <%=("10".equals(goal.getCreditoMes()))?"selected":""%>>Octubre</option>
										<option value="11" <%=("11".equals(goal.getCreditoMes()))?"selected":""%>>Noviembre</option>
										<option value="12" <%=("12".equals(goal.getCreditoMes()))?"selected":""%>>Diciembre</option>
									</select>
								</td>
							</tr>
						</table>
						</fieldset>
						 </td>
					</tr>
					<tr>
						<td height="24" align="left" valign="top" class="blackText1">
						<select name="solicitadoCredito" id="solicitadoCredito" tabindex="9"
								onchange="solicitudCred();">
							<option value="-1" selected="selected">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getSolicitadoCredito()))?"selected":""%>>SI</option>
							<option value="2"
								<%=("2".equals(goal.getSolicitadoCredito()))?"selected":""%>>NO</option>
						</select></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&iquest;Qu&eacute;
						tipo de<br />
						cr&eacute;dito solict&oacute;?*</td>
						<td colspan="2" valign="top" align="left" class="blackText1">&iquest;Cu&aacute;nto
						tiempo tard&oacute; en pagar<br />
						el &uacute;ltimo cr&eacute;dito que solicit&oacute;?*</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">
                                                    <select name="tipoCredito" id="tipoCredito" tabindex="12">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getTipoCredito()))?"selected":""%>>HIPOTECARIA</option>
							<option value="2"
								<%=("2".equals(goal.getTipoCredito()))?"selected":""%>>AUTOMOTRIZ</option>
							<option value="3"
								<%=("3".equals(goal.getTipoCredito()))?"selected":""%>>PERSONAL</option>
							<option value="4"
								<%=("4".equals(goal.getTipoCredito()))?"selected":""%>>COMERCIAL</option>
							<option value="5"
								<%=("5".equals(goal.getTipoCredito()))?"selected":""%>>BANCARIO</option>
							<option value="6"
								<%=("6".equals(goal.getTipoCredito()))?"selected":""%>>HACENDARIO</option>
							<option value="7"
								<%=("7".equals(goal.getTipoCredito()))?"selected":""%>>OTROS</option>
						</select></td>
						<td valign="top" align="left" class="blackText1"><input
							name="tardoAnio" type="text" id="tardoAnio" tabindex="13"
							onblur="valida3('tardoAnio');"
							onkeypress="AceptaNumerico();" value="${gol.tardoAnio}" size="5"
							maxlength="2"/>
						A&ntilde;os</td>
						<td valign="top" align="left" class="blackText1"><input
							name="tardoMes" type="text" id="tardoMes" tabindex="14"
							onblur="valida4('tardoMes');" 
							onkeypress="AceptaNumerico();" value="${gol.tardoMes}" size="5"
							maxlength="2"/>
						Meses</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td colspan="2">&nbsp;</td>
					</tr>
				</table>
				</fieldset>
				</td>
				<td width="6" colspan="-1" valign="top"></td>
				<td colspan="2" align="center" valign="bottom">
				<fieldset><legend class="blackText1"
					style="font-weight: bold">Actualmente utiliza alguno de
				los siguientes servicios bancarios</legend>
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
				<table width="375" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
						<table width="375" border="0" cellpadding="00" cellspacing="0">
							<tr>
								<td colspan="5" valign="top" align="left" class="blackText1"><strong>1.</strong>
								Tarjeta de cr&eacute;dito, &iquest;Cu&aacute;ntas?</td>
								<td colspan="4" valign="top" align="left" class="blackText1"><strong>6.</strong>
								Cr&eacute;dito hipotecario</td>
							</tr>
							<tr>
								<td width="20" valign="middle" align="right" class="blackText1">
								<input name="tarjetaC" type="radio" 	id="tc1" tabindex="15"
										 value="1"
                                                                                 onclick="activarTD('tc1')"
										<%=("1".equals(goal.getTarjetaC()))?"checked":""%>/>
								</td>
								<td width="25" valign="bottom" align="left" class="blackText1">Si</td>
								<td width="20" valign="middle" align="right" class="blackText1">
								<input name="tarjetaC" type="radio" value="2" id="tc2"
									onclick="activarTD('tc2')"
									<%=("2".equals(goal.getTarjetaC()))?"checked":""%> /></td>
								<td width="48" valign="bottom" align="left" class="blackText1">No</td>
								<td width="61" valign="middle" align="left" class="blackText1">
									<input 	name="totalTarjetas" type="text"
											disabled="disabled"
											id="totalTarjetas" tabindex="16"
											onblur="valida5('totalTarjetas');" 
											onkeypress="AceptaNumerico();"
											value="${gol.totalTarjetas}" size="5"
											maxlength="2"/>
								</td>
								<td width="20" valign="middle" align="right" class="blackText1">
								<input name="creditoHipo" type="radio" tabindex="21" value="1"
									<%=("1".equals(goal.getCreditoHipo()))?"checked":""%> />
								</td>
								<td width="25" valign="bottom" align="left" class="blackText1">Si</td>
								<td width="20" valign="middle" align="right" class="blackText1">
								<input name="creditoHipo" type="radio" value="2"
									<%=("2".equals(goal.getCreditoHipo()))?"checked":""%> /></td>
								<td width="102" valign="bottom" align="left" class="blackText1">No</td>
							</tr>
							<tr>
								<td colspan="5">&nbsp;</td>
								<td colspan="4">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="5" valign="top" align="left" class="blackText1"><strong>2.</strong>
								Tarjeta de d&eacute;bito</td>
								<td colspan="4" valign="top" align="left" class="blackText1"><strong>7.</strong>
								Seguro de vida</td>
							</tr>
							<tr>
								<td width="20" align="right" valign="middle" class="blackText1">
								<input name="tarjetaD" type="radio" tabindex="17" value="1"
									<%=("1".equals(goal.getTarjetaD()))?"checked":""%> /></td>
								<td valign="bottom" align="left" class="blackText1">Si</td>
								<td width="20" align="right" valign="middle" class="blackText1">
								<input name="tarjetaD" type="radio" value="2"
									<%=("2".equals(goal.getTarjetaD()))?"checked":""%> /></td>
								<td colspan="2" valign="bottom" align="left" class="blackText1">No</td>
								<td valign="middle" align="right" class="blackText1"><input
									name="seguroVida" type="radio" tabindex="22" value="1"
									<%=("1".equals(goal.getSeguroVida()))?"checked":""%> />
								</td>
								<td valign="bottom" align="left" class="blackText1">Si</td>
								<td valign="middle" align="right" class="blackText1"><input
									name="seguroVida" type="radio" value="2"
									<%=("2".equals(goal.getSeguroVida()))?"checked":""%> /></td>
								<td valign="bottom" align="left" class="blackText1">No</td>
							</tr>
							<tr>
								<td colspan="5">&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="5" valign="top" align="left" class="blackText1"><strong>3.</strong>
								Cuenta de cheques</td>
								<td colspan="4" valign="top" align="left" class="blackText1"><strong>8.</strong>
								Seguro de gastos m&eacute;dicos</td>
							</tr>
							<tr>
								<td align="right" valign="middle"><span class="blackText1">
								<input name="cuentaCheque" type="radio" tabindex="18" value="1"
									<%=("1".equals(goal.getCuentaCheque()))?"checked":""%> />
								</span></td>
								<td align="left" valign="bottom"><span class="blackText1">Si</span></td>
								<td align="right" valign="middle"><span class="blackText1">
								<input name="cuentaCheque" type="radio" value="2"
									<%=("2".equals(goal.getCuentaCheque()))?"checked":""%> /> </span></td>
								<td colspan="2" align="left" valign="bottom"><span
									class="blackText1">No</span></td>
								<td valign="middle" align="right" class="blackText1"><input
									name="seguroMedico" type="radio" tabindex="23" value="1"
									<%=("1".equals(goal.getSeguroMedico()))?"checked":""%> />
								</td>
								<td valign="bottom" align="left" class="blackText1">Si</td>
								<td valign="middle" align="right" class="blackText1"><input
									name="seguroMedico" type="radio" value="2"
									<%=("2".equals(goal.getSeguroMedico()))?"checked":""%> /></td>
								<td valign="bottom" align="left" class="blackText1">No</td>
							</tr>
							<tr>
								<td colspan="5">&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="5" valign="top" align="left" class="blackText1"><strong>4.</strong>
								Cr&eacute;dito personal</td>
								<td colspan="4" valign="top" align="left" class="blackText1"><strong>9.</strong>
								Otros</td>
							</tr>
							<tr>
								<td width="20" align="right" valign="middle" class="blackText1">
								<input name="creditoPersonal" type="radio" tabindex="19" value="1"
									<%=("1".equals(goal.getCreditoPersonal()))?"checked":""%> />
								</td>
								<td valign="bottom" align="left" class="blackText1">Si</td>
								<td width="20" align="right" valign="middle" class="blackText1">
								<input name="creditoPersonal" type="radio" value="2"
									<%=("2".equals(goal.getCreditoPersonal()))?"checked":""%> /></td>
								<td colspan="2" valign="bottom" align="left" class="blackText1">No</td>
								<td valign="middle" align="right" class="blackText1">
                                                                    <input     name="otroCredito" type="radio" id="otro1" tabindex="24"
									onclick="activarO('otro1')" value="1"
									<%=("1".equals(goal.getOtroCredito()))?"checked":""%> />
								</td>
								<td valign="bottom" align="left" class="blackText1">Si</td>
								<td valign="middle" align="right" class="blackText1">
                                                                    <input 	name="otroCredito" type="radio" value="2"
                                                                        id="otro2" onclick="activarO('otro2')"
                                                                        <%=("2".equals(goal.getOtroCredito()))?"checked":""%> />
								</td>
								<td valign="bottom" align="left" class="blackText1">No</td>
							</tr>
							<tr>
								<td colspan="5">&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="5" valign="top" align="left" class="blackText1"><strong>5.</strong>
								Cr&eacute;dito automotriz</td>
								<td colspan="4" valign="top" align="left" class="blackText1">&iquest;Cu&aacute;l?</td>
							</tr>
							<tr>
								<td width="20" align="right" valign="middle" class="blackText1">
								<input name="creditoAuto" type="radio" id="creditoAuto" tabindex="20" value="1"
									<%=("1".equals(goal.getCreditoAuto()))?"checked":""%> />
								</td>
								<td valign="bottom" align="left" class="blackText1">Si</td>
								<td width="20" align="right" valign="middle" class="blackText1">
								<input id="creditoAuto" name="creditoAuto" type="radio" value="2"
									<%=("2".equals(goal.getCreditoAuto()))?"checked":""%> /></td>
								<td colspan="2" valign="bottom" align="left" class="blackText1">No</td>
								<td colspan="4" valign="top" align="left" class="blackText1">
								<input name="cualCredito" type="text" disabled="disabled"
									id="cualCredito" tabindex="25"
									class="mayus"
									value="${gol.cualCredito}" size="20" maxlength="15"/></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</fieldset>
				 </td>
			</tr>
			<tr>
				<td valign="top"></td>
				<td valign="top"></td>
			</tr>
			<tr>
				<td valign="top"></td>
				<td valign="top"></td>
			</tr>
			<tr>
				<td valign="top"></td>
				<td valign="top"></td>
			</tr>
		</table>
		</fieldset>
		</td>
	</tr>

	<tr>
		<td colspan="4">&nbsp;</td>
		<td width="48" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image10','','../images/accesos_down/aplicacion-2_28.png',1)"><img
			src="../images/accesos_down/aplicacion-23_28.png" name="Image10"
			width="33" height="32" border="0" id="Image10" /></a></td>
		<td width="9">&nbsp;</td>
		<td width="51" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image9','','../images/accesos_down/aplicacion-2_30.png',1)"><img
			src="../images/accesos_down/aplicacion-23_30.png" name="Image9"
			width="33" height="32" border="0" id="Image9" /></a></td>
		<td width="9">&nbsp;</td>
		<td width="52" align="center"><a 
			href="#"
			onclick="salirGol();"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image8','','../images/accesos_down/aplicacion-2_34.png',1)"><img
			src="../images/accesos_down/aplicacion-23_34.png" name="Image8"
			width="32" height="32" border="0" id="Image8" /></a></td>
		<td width="9">&nbsp;</td>
		<td width="98" align="center"><a href="infogol.jsp"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image61','','../images/accesos_down/aplicacion-2_36.png',1)"><img
			src="../images/accesos_down/aplicacion-23_36.png" name="Image61"
			width="32" height="32" border="0" id="Image61" /></a></td>
		<td width="12">&nbsp;</td>
		<td width="47" align="center"><a 
			href="#"
			onclick="valPagina4('pagina3A', 'Historialgol',2)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image6','','../images/accesos_down/aplicacion-2_36.png',1)"><img
			src="../images/accesos_down/aplicacion-23_36.png" name="Image6"
			width="32" height="32" border="0" id="Image6" /></a></td>
		<td width="9" align="center">&nbsp;</td>
		<td width="64" align="center"><a
			href="#"
			onclick="valPagina4('pagina5', 'Historialgol',1)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image12','','../images/accesos_down/aplicacion-2_41.png',1)"><img
			src="../images/accesos_down/aplicacion-23_41.png" name="Image12"
			width="31" height="32" border="0" id="Image12" /></a></td>
	</tr>
	<tr>
		<td width="76">&nbsp;</td>
		<td width="9">&nbsp;</td>
		<td width="9">&nbsp;</td>
		<td width="292">&nbsp;</td>
		<td align="center" class="blueText" valign="top">Cancelar</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText" valign="top">Guardar</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText" valign="top">Salir</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText" valign="top">Primera Pantalla</td>
		<td>&nbsp;</td>
		<td align="center" valign="top" class="blueText">Anterior</td>
		<td align="center" valign="top" class="blueText">&nbsp;</td>
		<td class="blueText" align="center">Siguiente</td>
	</tr>
</table>
<!-- InstanceEndEditable --></div>
<div id="pie_pag"></div>
</div>
</div>
</center>
<%if("2".equals(goal.getDineroExtraR())){%>
<script type="text/javascript">
self.setTimeout("dineroExtraChange();", 1000);
</script>
<%}%>
<%if("2".equals(goal.getPagaRenta())){%>
<script type="text/javascript">
self.setTimeout("pagaRent();", 1000);
</script>
<%}%>
</form>
</body>
<!-- InstanceEnd -->
</html>
