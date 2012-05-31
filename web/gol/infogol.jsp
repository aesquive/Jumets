<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml">
<!-- InstanceBegin template="/Templates/plantilla3.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
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
String accion = (String) request.getSession().getAttribute("accion");
String control = (goal.getControl().length()==0)?"0":goal.getControl();
String load = "";
if("0".equals(control))
	load +="activacionControl(true);";
else
	load +="activacionControl(false);";
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Originaci&oacute;n de Cliente</title>
<!-- InstanceEndEditable -->
<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/funciones.js"></script>
<script language="JavaScript" src="../js/ajax.js"></script>
<script language="JavaScript" src="../js/gol.js"></script>
<script language="JavaScript" src="../js/golVal.js"></script>
<!-- InstanceEndEditable -->
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
</head>



<body onload="<%if(goal.getCp()!=null){%>cargaCP();<%}%><%=load%><%if(goal.getGastosOtros().length()>0){%>activarCuantoGasta1();<%}%>;MM_preloadImages('../images/acceso/activos_guardar.png','../images/acceso/activos_exit.png','../images/acceso/activos_add.png','../images/accesos_down/aplicacion-2_34.png','../images/accesos_down/aplicacion-2_30.png','../images/accesos_down/aplicacion-2_28.png','../images/accesos_down/aplicacion-2_22.png')">
<form id="Infogol" name="Infogol" method="post" action="../GolServlet"
	onsubmit="return validate_form(this)">
<input type="hidden" id="command" name="command" value="test" />
<input type="hidden" id="accion" name="accion" value="<%=accion%>" />
<input type="hidden" id="control" name="control" value="1" />
<input type="hidden" id="idGol" name="idGol" value="<%=goal.getIdGol()%>" />
<input type="hidden" id="idPrima" name="idPrima" value="<%=goal.getIdPrima()%>" />
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
			onclick="activacionControl(false);"
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
			onclick="valPagina1('Guardar', 'Infogol',0)"
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
		<td class="whiteText">
		<div align="center"></div>		</td>
	</tr>
</table>
<!-- InstanceEndEditable --></div>
</div>
<div id="borde_der"></div>
<div id="contenido"><!-- InstanceBeginEditable name="Region2" -->
<%@include file="../ErrorTag.jsp"%>
<table width="910" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="7" colspan="19">
		<fieldset>
		<table width="855" height="416" border="0" align="left"
			cellpadding="0" cellspacing="0">
			<tr>
				<td colspan="5"> </td>
			</tr>
			<tr>
				<td colspan="4" valign="top">
				<fieldset><legend class="blackText1"
					style="font-weight: bold">Nombre</legend>
				<table width="468" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="149" align="left" class="blackText1">Apellido
						Paterno</td>
						<td width="15">&nbsp;</td>
						<td width="144" align="left" class="blackText1">Apellido
						Materno</td>
						<td width="16">&nbsp;</td>
						<td width="144" align="left" class="blackText1">Nombre</td>
					</tr>
					<tr>
						<td class="blackText1" align="left"><input type="text"
							id="apellidoPaterno" name="apellidoPaterno" value="${gol.apellidoPaterno}"
							onkeypress="AceptaAlfanumericoYPunto()"
							class="mayus"
							tabindex="1"/></td>
						<td class="blackText1">&nbsp;</td>
						<td class="blackText1" align="left"><input type="text"
							id="apellidoMaterno" name="apellidoMaterno" value="${gol.apellidoMaterno}"
							onkeypress="AceptaAlfanumericoYPunto()" 
							class="mayus"
							tabindex="2"/></td>
						<td class="blackText1">&nbsp;</td>
						<td class="blackText1" align="left"><input type="text"
							id="nombre" name="nombre" value="${gol.nombre}"
							onkeypress="AceptaAlfanumericoYPunto()" 
							class="mayus"
							tabindex="3"/></td>
					</tr>
				</table>
				</fieldset>				</td>
				<td width="300" valign="top">
				<fieldset><legend class="blackText1"
					style="font-weight: bold">Fecha de Nacimiento</legend>
				<table width="300" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="blackText1" align="left">A&ntilde;o</td>
						<td class="blackText1" align="left">Mes</td>
						<td class="blackText1" align="left">D&iacute;a*</td>
						<td class="blackText1" align="left">Edad</td>
					</tr>
					<tr>
						<td class="blackText1" align="left">
							<select id="anio"
									name="anio" onchange="calcular_edad();"
									class="combo_60" tabindex="4">
								<option value="-1">-A&ntilde;o-</option>
								<%
								for (int i = 1; i < 50; i++) {
									int ano = 1945 + i;
								%>
								<option value="<%=ano%>" <%=(String.valueOf(ano).equals(goal.getAnio()))?"selected":""%>><%=ano%></option>
								<%
									}
								%>
							</select>						</td>
						<td class="blackText1" align="left"><select id="mes"
							name="mes" onchange="calcular_edad();"
							class="combo_80" tabindex="5">
							<option value="-1">-Mes-</option>
							<option value="01" <%=("01".equals(goal.getMes())) ? "selected" : ""%>>Enero</option>
							<option value="02" <%=("02".equals(goal.getMes())) ? "selected" : ""%>>Febrero</option>
							<option value="03" <%=("03".equals(goal.getMes())) ? "selected" : ""%>>Marzo</option>
							<option value="04" <%=("04".equals(goal.getMes())) ? "selected" : ""%>>Abril</option>
							<option value="05" <%=("05".equals(goal.getMes())) ? "selected" : ""%>>Mayo</option>
							<option value="06" <%=("06".equals(goal.getMes())) ? "selected" : ""%>>Junio</option>
							<option value="07" <%=("07".equals(goal.getMes())) ? "selected" : ""%>>Julio</option>
							<option value="08" <%=("08".equals(goal.getMes())) ? "selected" : ""%>>Agosto</option>
							<option value="09" <%=("09".equals(goal.getMes())) ? "selected" : ""%>>Septiembre</option>
							<option value="10"
								<%=("10".equals(goal.getMes())) ? "selected" : ""%>>Octubre</option>
							<option value="11"
								<%=("11".equals(goal.getMes())) ? "selected" : ""%>>Noviembre</option>
							<option value="12"
								<%=("12".equals(goal.getMes())) ? "selected" : ""%>>Diciembre</option>
						</select></td>
						<td class="blackText1" align="left"><select id="dia"
							name="dia" onchange="calcular_edad();"
							class="combo_60" tabindex="6">
							<option value="-1">-D&iacute;a-</option>
							<%
								for (int i = 1; i <= 31; i++) {
									int dia = i;
									String diat = (String.valueOf(dia).length()==1)?"0"+dia:String.valueOf(dia);
							%>
							<option value="<%=diat%>" <%=(diat.equals(goal.getDia()))?"selected":""%>><%=diat%></option>
							<%
								}
							%>
						</select></td>
						<td class="blackText1" align="left"><input id="edad" class="combo_20"
							name="edad" type="text" value="${gol.edad}" readonly />						</td>
					</tr>
				</table>
				</fieldset>
				 </td>
			</tr>
			<tr>
				<td colspan="5">
				<fieldset><legend class="blackText1"
					style="font-weight: bold">Domicilio</legend>
				<table width="834" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="148" align="left" class="blackText1">Calle</td>
						<td width="64" align="left" class="blackText1">No.Exterior</td>
						<td width="4" rowspan="2" align="left" class="blackText1">&nbsp;</td>
						<td width="73" align="left" class="blackText1">No.Interior</td>
						<td width="144" align="left" class="blackText1">Colonia</td>
						<td colspan="2" rowspan="2" align="left" class="blackText1">&nbsp;</td>
						<td width="90" align="left" class="blackText1">C&oacute;digo
						Postal</td>
						<td colspan="2" rowspan="2" align="left" class="blackText1">&nbsp;</td>
						<td width="148" align="left" class="blackText1">Estado</td>
						<td width="163" align="left" class="blackText1">Delegaci&oacute;n/
						Municipio</td>
					</tr>
					<tr>
						<td align="left" class="blackText1"><input type="text"
							id="calle" name="calle" value="${gol.calle}" 
							class="mayus"
							tabindex="7"/></td>
						<td align="left" class="blackText1"><input name="noExterior"
							id="noExterior" value="${gol.noExterior}" type="text" size="8" 
							tabindex="8"/></td>
						<td align="left" class="blackText1"><input name="noInterior"
							id="noInterior" type="text" value="${gol.noInterior}" size="8" 
							tabindex="9"/></td>
						<td align="left" class="blackText1"><input name="colonia"
							id="colonia" type="text" value="${gol.colonia}" id="colonia"
							class="mayus"
							tabindex="10"/></td>
						<td align="left" class="blackText1"><input name="cp" id="cp"
							type="text" size="15" value="${gol.cp}" 
							onblur="cargaCP();cpValidacion()"
							maxlength="5"
							onkeypress="AceptaNumerico();"
							tabindex="11"/></td>
						<td align="left" class="blackText1"><input type="text"
							id="edo" name="edo" value="${gol.edo}" readonly="readonly"/></td>
						<td align="left" class="blackText1"><input type="text"
							id="mun" name="mun" value="${gol.mun}" readonly="readonly"/></td>
					</tr>
				</table>
				</fieldset>				</td>
			</tr>
			<tr>
				<td colspan="5">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="5"></td>
			</tr>
			<tr>
				<td width="276" rowspan="2">
					<fieldset>
					<table width="274" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="120" class="blackText1" align="left" valign="top">&iquest;Cu&aacute;l
								es su sexo?</td>
							<td width="154" class="blackText1" align="left" valign="top">&iquest;Cu&aacute;l
								es su estado civil?</td>
						</tr>
						<tr>
							<td align="left" class="blackText1" valign="top">
								<select id="sexo" name="sexo" class="combo_100" tabindex="12">
									<option value="-1">-Seleccione-</option>
									<%=GolSql.getSexo(goal.getSexo())%>
								</select>							</td>
							<td valign="top" class="blackText1" align="left">
								<select name="edoCivil" id="edoCivil" class="combo_100"
										tabindex="13">
										<option value="-1">-Seleccione-</option>
										<%=GolSql.getEdoCivil(goal.getEdoCivil())%>
								</select>							</td>
						</tr>
					</table>
					</fieldset>				</td>
				<td width="11" rowspan="2" align="center" valign="top"
					class="blackText1">&nbsp;</td>
				<td width="250" height="36" align="left" valign="top"
					class="blackText1">&iquest;Qu&eacute; comercio o servicio cree
				que es<br/>
				indispensable tener cerca de su hogar?</td>
				<td width="4" align="center" valign="top" class="blackText1">&nbsp;</td>
				<td width="314" align="left" valign="top" class="blackText1">&iquest;Cu&aacute;l
				es el principal problema que<br />
				tiene hoy en d&iacute;a?</td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"><select
					name="comercioIndispensable" id="comercioIndispensable" class="combo_140"
					tabindex="14">
					<option value="-1">-Seleccione-</option>
					<%=GolSql.getServicios(goal
									.getComercioIndispensable())%>
				</select></td>
				<td colspan="2" align="left" valign="top" class="blackText1"><select
					name="problemaHoy" id="problemaHoy" class="combo_140"
					tabindex="15">
					<option value="-1">-Seleccione-</option>
					<%=GolSql.getProblemas(goal.getProblemaHoy())%>
				</select></td>
			</tr>
			<tr>
				<td height="19" colspan="5" valign="top"></td>
			</tr>
			<tr>
				<td height="58" colspan="4" valign="top">
					<table width="550" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<fieldset>
							<table width="550" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="33%" valign="top" align="left" class="blackText1">Comparado
										con el a&ntilde;o anterior,<br />
										¿c&oacute;mo es su situaci&oacute;n econ&oacute;mica actual?</td>
									<td width="2%" rowspan="2" align="left" valign="top"
										class="blackText1">&nbsp;</td>
									<td width="33%" valign="top" align="left" class="blackText1">&iquest;C&oacute;mo
										considera que ser&aacute; su situaci&oacute;n econ&oacute;mica el
										pr&oacute;ximo a&ntilde;o?</td>
									<td width="2%" rowspan="2" align="left" valign="top"
										class="blackText1">&nbsp;</td>
									<td width="30%" rowspan="2" align="left" valign="bottom"
										class="blackText1">&iquest;Por qu&eacute; ?<br />
									<textarea 	name="pqSituacionPAnio" id="pqSituacionPAnio"
												class="mayus"
												tabindex="18">${gol.pqSituacionPAnio}</textarea></td>
								</tr>
								<tr>
									<td align="left" valign="top" class="blackText1"><select
										name="situacionActual" id="situacionActual" class="combo_140"
										tabindex="16">
										<option value="-1">-Seleccione-</option>
										<%=GolSql.getSituacionActual(goal
											.getSituacionActual())%>
										</select>									</td>
									<td align="left" valign="top" class="blackText1"><select
										name="situacionPAnio" id="situacionPAnio"
										tabindex="17">
										<option value="-1">-Seleccione-</option>
										<%=GolSql.getSituacionProx(goal.getSituacionPAnio())%>
										</select>									</td>
								</tr>
							</table>
							</fieldset>						</td>
					</tr>
					</table>				</td>
				<td	rowspan="4" valign="top">
					<fieldset>
						<legend class="blackText1" align="top">Que tanto le ha afectado la crisis econ&oacute;mica en:</legend>
						<table width="300" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td colspan="2" align="left" class="blackText1">
									1. Cubrir los gastos de alimentos de su familia								</td>
							</tr>
							<tr>
								<td colspan="2" align="left">
									<select id="gastosAlimentos" name="gastosAlimentos" class="combo_100"
											tabindex="22">
										<option value="-1">-Seleccione-</option>
										<%=GolSql.getGastosAlimentos(goal.getGastosAlimentos())%>
									</select>								</td>
							</tr>
							<tr><td colspan="2">&nbsp;</td></tr>
							<tr>
								<td colspan="2" align="left" class="blackText1">
									2. Cubrir los gastos personales b&aacute;sicos								</td>
							</tr>
							<tr>
								<td colspan="2" align="left">
									<select id="gastosPersonales" name="gastosPersonales" class="combo_100"
											tabindex="23">
										<option value="-1">-Seleccione-</option>
										<%=GolSql.getGastosPersonales(goal.getGastosPersonales())%>
									</select>								</td>
							</tr>
							<tr><td colspan="2">&nbsp;</td></tr>
							<tr>
								<td colspan="2" align="left" class="blackText1">
									3. Pagar deudas								</td>
							</tr>
							<tr>
								<td colspan="2" align="left">
									<select id="gastosDeudas" name="gastosDeudas" class="combo_100"
											tabindex="24">
										<option value="-1">-Seleccione-</option>
										<%=GolSql.getGastosDeuda(goal.getGastosDeudas())%>
									</select>								</td>
							</tr>
							<tr><td colspan="2">&nbsp;</td></tr>
							<tr>
								<td colspan="2" align="left" class="blackText1">
									4. Otros,&iquest;Cu&aacute;l?								</td>
							</tr>
							<tr>
								<td align="left">
									<input
										type="text" name="gastosOtros" id="gastosOtros" 
										value="${gol.gastosOtros}" 
										class="mayus"
										onkeyup="conMayusculasGastosOtros(this.value)"
										tabindex="25"/>								</td>
								<td align="left">
									<select id="gastosOtroCual" name="gastosOtroCual" class="combo_100" 
											disabled="disabled" tabindex="26">
										<option value="-1">-Seleccione-</option>
										<%=GolSql.getGastosOtros(goal.getGastosOtroCual())%>
									</select>								</td>
							</tr>
						</table>
					</fieldset>				</td>
			</tr>
			<tr>
				<td height="14" colspan="4" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td height="39" width="550" colspan="5" valign="top">
					<table width="550" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<fieldset>
								<table width="550" border="0" cellspacing="0" cellpadding="0">
			 						<tr>
										<td width="33%" valign="bottom" align="left" class="blackText1">¿Cu&aacute;l
											es la deuda que<br />
											m&aacute;s le preocupa?</td>
										<td width="2%" rowspan="2" align="left" valign="top"
											class="blackText1">&nbsp;</td>
										<td width="33%" valign="top" align="left" class="blackText1">&iquest;Alguna
											vez ha solicitado apoyo econ&oacute;mico a alguna
											instituci&oacute;n para tratar de solucionar sus problemas ?</td>
										<td width="2%" rowspan="2" align="left" valign="top"
											class="blackText1">&nbsp;</td>
										<td width="30%" align="left" valign="bottom" class="blackText1">&iquest;Qu&eacute;
											har&iacute;a si tuviera dinero extra?</td>
									</tr>
									<tr>
										<td align="left" valign="top" class="blackText1"><input
										type="text" name="deudaPreocupa" id="deudaPreocupa" 
										value="${gol.deudaPreocupa}" 
										onkeypress="conMayusculas('deudaPreocupa')"
										tabindex="19"/>										</td>
										<td align="left" valign="top" class="blackText1"><select
										name="apoyoInstitucion" id="apoyoInstitucion"
										tabindex="20">
										<option value="-1">-Seleccione-</option>
										<option value="1" <%=("1".equals(goal.getApoyoInstitucion()))? "selected": ""%>>SI</option>
										<option value="2" <%=("2".equals(goal.getApoyoInstitucion()))? "selected": ""%>>NO</option>
										</select></td>
										<td width="217" align="left" valign="bottom" class="blackText1">
										<select id="dineroExtra" name="dineroExtra" class="combo_140"
												tabindex="21">
											<option value="-1">-Seleccione-</option>
											<%=GolSql.getDineroExtra(goal.getDineroExtra())%>
											</select>										</td>
									</tr>
								</table>
								</fieldset>							</td>
						</tr>
					</table>				</td>
			</tr>
		</table>
		<p>&nbsp;</p>
		</fieldset>		</td>
	</tr>

	<tr>
		<td width="331">&nbsp;</td>
		<td width="42" align="center">&nbsp;</td>
		<td width="8">&nbsp;</td>
		<td width="51" align="center">&nbsp;</td>
		<td width="7">&nbsp;</td>
		<td width="47" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image20','','../images/accesos_down/aplicacion-2_22.png',1)"></a></td>
		<td width="8" align="center">&nbsp;</td>
		<td width="48" align="center">&nbsp;</td>
		<td width="7" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image19','','../images/accesos_down/aplicacion-2_24.png',1)"></a></td>
		<td width="44" align="center"><a href="#"
			onclick="activacionControl(false);"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image20','','../images/accesos_down/aplicacion-2_22.png',1)"><img
			src="../images/accesos_down/aplicacion-23_22.png" name="Image20"
			width="32" height="32" border="0" id="Image20" /></a></td>
		<td width="8">&nbsp;</td>
		<td width="36" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image17','','../images/accesos_down/aplicacion-2_28.png',1)"><img
			src="../images/accesos_down/aplicacion-23_28.png" name="Image17"
			width="33" height="32" border="0" id="Image17" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image18','','../images/accesos_down/aplicacion-2_26.png',1)"></a></td>
		<td width="11">&nbsp;</td>
		<td width="34" align="center"><a 
			href="#"
			onclick="valPagina1('Guardar', 'Infogol',0)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image16','','../images/accesos_down/aplicacion-2_30.png',1)"><img
			src="../images/accesos_down/aplicacion-23_30.png" name="Image16"
			width="33" height="32" border="0" id="Image16" /></a></td>
	  <td width="16" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image16','','../images/accesos_down/aplicacion-2_30.png',1)"></a></td>
		
		<td width="15" align="right" valign="middle"><a 
			href="#"
			onclick="salirGol();"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('salir2','','../images/accesos_down/aplicacion-2_34.png',1)"><img
			src="../images/accesos_down/aplicacion-23_34.png" name="salir2"
			width="32" height="32" border="0" id="salir2" /></a></td>
	  <td width="74" align="center"><a
			href="#"
			onclick="valPagina1('pagina2', 'Infogol',1)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('siguiente', '', '../images/accesos_down/aplicacion-2_41.png',1);"><img
			src="../images/accesos_down/aplicacion-23_41.png" name="siguiente"
			width="31" height="32" border="0" id="siguiente" /></a></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td align="center" class="blueText">&nbsp;</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText">&nbsp;</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText">&nbsp;</td>
		<td align="center" class="blueText">&nbsp;</td>
		<td align="center" class="blueText">&nbsp;</td>
		<td align="center" class="blueText">&nbsp;</td>
		<td align="center" class="blueText">Agregar</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText">Cancelar</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText">Guardar</td>
		<td align="center" class="blueText">&nbsp;</td>
		<td><span class="blueText">Salir</span></td>
		<td align="center" class="blueText">
			Siguiente</td>
	</tr>
</table>
</div>
<div id="pie_pag"></div>
</div>
</div>
</center>
</form>
</body>
</html>