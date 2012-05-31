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
    String load = "";
    if(goal.getConyuge()==1)
    	load+="checkIng('conyuge','imc','ac');";
    if(goal.getHijos()==2)
    	load+="checkIng('hijos','imh','ah');";
    if(goal.getPadres()==3)
    	load+="checkIng('padres','imp','ap');";
    if(goal.getOtros()==4)
    	load+="checkIng('otros','imo','ao');";
    if(goal.getOtroGastos()!=null)
    	load+="activarCuantoGasta();";
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
	onload="<%=load%>MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_exit.png','../images/acceso/activos_guardar.png','../images/buscar_activo.png','../images/acceso/activos_salir.png','../images/acceso/inactivo-blanco_salir.png','../images/accesos_down/aplicacion-2_41.png','../images/accesos_down/aplicacion-2_36.png','../images/accesos_down/aplicacion-2_34.png','../images/accesos_down/aplicacion-2_30.png','../images/accesos_down/aplicacion-2_28.png')">
<form id="Ingresogol" name="Ingresogol" method="post" action="../GolServlet"
	onsubmit="return validate_form(this)">
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
			onclick="valPagina3('Guardar3', 'Ingresogol',0)"
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
		<div align="center"></div>
	</tr>
</table>
<!-- InstanceEndEditable --></div>
</div>
<div id="borde_der"></div>
<div id="contenido">
<%@include file="../ErrorTag.jsp"%>
<table width="851" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="7" colspan="14">
		<fieldset>
		<table width="834" height="554" border="0" align="left"
			cellpadding="0" cellspacing="0">
			<tr>
				<td height="14" colspan="6"> </td>
			</tr>

			<tr>
				<td colspan="5" valign="top"></td>
				<td width="358" rowspan="11" valign="top">
				<fieldset>
				<table width="354" height="132" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="226" align="left" class="blackText1">&iquest;Qu&eacute;
						gasto importante tiene<br />
						planeado para el pr&oacute;ximo a&ntilde;o?*</td>
						<td width="206" align="left" class="blackText1">&iquest;Con
						qui&eacute;n vive actualmente?*</td>
					</tr>
					<tr>
						<td align="left" class="blackText1"><select tabindex="3"
							name="gastoPlaneado" class="combo_140" id="gastoPlaneado">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getGastoPlaneado(goal.getGastoPlaneado())%>
						</select></td>
						<td align="left" class="blackText1"><select name="viveActual"
							class="combo_140" id="viveActual"
							tabindex="4">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getViveActual(goal.getViveActual())%>
						</select></td>
					</tr>
					<tr>
						<td height="18" align="left" class="blackText1">&nbsp;</td>
						<td align="left" class="blackText1">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" align="center" class="blackText1">&iquest;Cu&aacute;ntas
						personas son sus dependientes econ&oacute;micos?</td>
					</tr>
					<tr>
						<td colspan="2" align="center" valign="top" class="blackText1">
						<%System.out.println("goal.getPersonasDep()="+goal.getPersonasDep());%>
						<input name="personasDep" id="personasDep" type="text" size="5"
							value="${gol.personasDep}" onkeypress="AceptaNumerico();"
							onblur="validaDendientes();"
							tabindex="5"
							maxlength="2" /></td>
					</tr>
				</table>
				</fieldset>
				 </td>
			</tr>
			<tr>
				<td colspan="5" valign="top"></td>
			</tr>
			<tr>
				<td colspan="5" valign="top"></td>
			</tr>
			<tr>
				<td colspan="5" valign="top"></td>
			</tr>
			<tr>
				<td width="451" height="147" colspan="3" align="center" valign="top">
				<table width="447" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
						<td width="831" align="left" valign="top">
						<fieldset>
						<table width="447" height="132" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="250" height="34">&nbsp;</td>
								<td width="24">&nbsp;</td>
								<td width="173" align="center" valign="top">&nbsp;</td>
							</tr>
							<tr>
								<td height="37" align="center" valign="top"><span
									class="blackText1">&iquest;Qui&eacute;n o qui&eacute;nes
								considera que son<br />
								responsables de la crisis econ&oacute;mica?*</span></td>
								<td>&nbsp;</td>
								<td align="center" valign="top"><span class="blackText1">En
								los &uacute;ltimos 5 a&ntilde;os<br />
								ha vivido en:*</span></td>
							</tr>
							<tr>
								<td align="center" valign="top"><span class="blackText1">
									<input 	type="text" name="respCrisis" id="respCrisis"  
											value="${gol.respCrisis}" 
											tabindex="1"
											onkeyup="conMayusculas('respCrisis')"//>
								</span>
								</td>
								<td>&nbsp;</td>
								<td align="center" valign="top"><span class="blackText1">
								<select name="lugarVivienda" id="lugarVivienda" tabindex="2">
									<option value="-1">-Seleccione-</option>
									<%=GolSql.getLugarVivienda(goal.getLugarVivienda())%>
								</select> </span></td>
							</tr>
						</table>
						</fieldset>
						 </td>
					</tr>
				</table>
				</td>
				<td width="4" colspan="2" align="left" valign="top"
					class="blackText1">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="5" valign="top"></td>
			</tr>
			<tr>
				<td colspan="5" valign="top"></td>
			</tr>
			<tr>
				<td colspan="5" valign="top"></td>
			</tr>

			<tr>
				<td colspan="5" valign="top"></td>
			</tr>
			<tr>
				<td colspan="5" valign="top"></td>
			</tr>
			<tr>
				<td height="2" colspan="5" valign="top"></td>
			</tr>


			<tr>
				<td height="16" colspan="3" align="left" valign="top"
					class="blackText1">
				<fieldset><legend class="blackText1"
					style="font-weight: bold">Ingresos</legend>
				<table width="445" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
				<table width="444" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td colspan="5" align="left" valign="top" class="blackText1">&iquest;A
						cu&aacute;nto asciende su<br />
						ingreso mensual?*</td>
						<td width="154" align="left" valign="top" class="blackText1">&iquest;Qui&eacute;n
						decide el destino<br />
						del ingreso familiar?*</td>
					</tr>
					<tr>
						<td colspan="5" align="left" valign="top" class="blackText1">
							<input 	type="text" name="ingresoMensual" id="ingresoMensual" 
									value="${gol.ingresoMensual}"
									onkeypress="AceptaNumerico();" 
									onblur="ingMensual('ingresoMensual');"
									tabindex="6"/>
						</td>
						<td align="left" valign="top" class="blackText1">
							<input 	type="text" name="ingresoDestino" id="ingresoDestino" 
									value="${gol.ingresoDestino}" 
									onkeyup="conMayusculas('ingresoDestino')"
									tabindex="7"/>
						</td>
					</tr>
					<tr>
						<td colspan="6">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" align="center" valign="top" class="blackText1">Adem&aacute;s
						de usted,<br />
						&iquest;qui&eacute;n recibe un ingreso<br />
						en su familia?</td>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td width="93" align="left" valign="middle" class="blackText1">Ingreso
						mensual</td>
						<td width="20" align="left" valign="top" class="blackText1">&nbsp;</td>
						<td align="center" valign="middle" class="blackText1">&iquest;Cu&aacute;nto
						aportan<br />
						al gasto familiar?</td>
					</tr>

					<tr>
						<td valign="middle" align="right" class="blackText1">&nbsp;</td>
						<td valign="middle" align="left" class="blackText1">&nbsp;</td>
						<td valign="middle" align="left" class="blackText1">&nbsp;</td>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td valign="top" align="left" class="blackText1">&nbsp;</td>
					</tr>
					<tr>
						<td width="46" valign="middle" align="right" class="blackText1">
							<input 	type="checkbox" name="conyuge" id="conyuge" value="1"
									<%=(goal.getConyuge()==1)?"checked":""%>
									onclick="checkIng('conyuge','imc','ac');"
									tabindex="8"/>
						</td>
						<td width="108" valign="middle" align="left" class="blackText1">C&oacute;nyuge</td>
						<td width="23" valign="middle" align="left" class="blackText1">&nbsp;</td>
						<td align="left" valign="top" class="blackText1">
							<input 	name="imc" id="imc" type="text" size="12" 
									value="${gol.imc}" disabled="disabled"
									onkeypress="AceptaNumerico();"
									onblur="ingMensual('imc');"/>
						</td>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td valign="top" align="center" class="blackText1">
							<select name="ac" id="ac" disabled="disabled">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getApo1(goal.getAc())%>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td valign="middle" align="right" class="blackText1">
							<input 	type="checkbox" name="hijos" id="hijos" value="2" 
									<%=(goal.getHijos()==2)?"checked":""%>
									onclick="checkIng('hijos','imh','ah');"
									tabindex="9"/>
						</td>
						<td valign="middle" align="left" class="blackText1">Hijos</td>
						<td valign="middle" align="left" class="blackText1">&nbsp;</td>
						<td align="left" valign="top" class="blackText1">
							<input 	name="imh" id="imh" type="text" size="12" 
									value="${gol.imh}" disabled="disabled"
									onkeypress="AceptaNumerico();"
									onblur="ingMensual('imh');"/></td>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td valign="top" align="center" class="blackText1">
							<select name="ah" id="ah" disabled="disabled">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getApo2(goal.getAh())%>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td valign="middle" align="right" class="blackText1">
							<input 	type="checkbox" name="padres" id="padres" value="3"
									<%=(goal.getPadres()==3)?"checked":""%> 
									onclick="checkIng('padres','imp','ap');"
									tabindex="10"/></td>
						<td valign="middle" align="left" class="blackText1">Padres</td>
						<td valign="middle" align="left" class="blackText1">&nbsp;</td>
						<td align="left" valign="top" class="blackText1">
							<input 	name="imp" id="imp" type="text" size="12" 
									value="${gol.imp}" disabled="disabled"
									onkeypress="AceptaNumerico();"
									onblur="ingMensual('imp');"/>
						</td>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td valign="top" align="center" class="blackText1">
							<select name="ap" id="ap" disabled="disabled">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getApo3(goal.getAp())%>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td valign="middle" align="right" class="blackText1">
							<input 	type="checkbox" name="otros" id="otros" value="4"
									<%=(goal.getOtros()==4)?"checked":""%>
									onclick="checkIng('otros','imo','ao');"
									tabindex="11"/>
						</td>
						<td valign="middle" align="left" class="blackText1">Otros</td>
						<td valign="middle" align="left" class="blackText1">&nbsp;</td>
						<td align="left" valign="top" class="blackText1">
							<input 	name="imo" id="imo" type="text" size="12" 
									value="${gol.imo}" disabled="disabled"
									onkeypress="AceptaNumerico();"
									onblur="ingMensual('imo');"/>
						</td>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td valign="top" align="center" class="blackText1">
							 <select name="ao" id="ao" disabled="disabled">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getApo3(goal.getAo())%>
						</select></td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
				</fieldset>
				 </td>
				<td width="21" align="left" valign="top" class="blackText1">&nbsp;</td>
				<td height="16" colspan="2" align="left" valign="top"
					class="blackText1">
				<fieldset><legend class="blackText1"
					style="font-weight: bold">Cuánto dinero gasta mensualmente
				en:</legend>
				<table width="372" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="5">&nbsp;</td>
					</tr>
				</table>
				<table width="373" height="336" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="174" valign="top" align="left" class="blackText1">&nbsp;<strong>1.</strong>
						Alimentos y bebidas*</td>
						<td width="190" valign="top" align="left" class="blackText1"><strong>7.</strong>
						Educaci&oacute;n*</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&nbsp; <select
							name="alimentos" id="alimentos"
							tabindex="12">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getAlimentos()))?"selected":""%>>0%</option>
							<option value="2"
								<%=("2".equals(goal.getAlimentos()))?"selected":""%>>DEL
							1% AL 10%</option>
							<option value="3"
								<%=("3".equals(goal.getAlimentos()))?"selected":""%>>DEL
							11% AL 20%</option>
							<option value="4"
								<%=("4".equals(goal.getAlimentos()))?"selected":""%>>DEL
							21% AL 30%</option>
							<option value="5"
								<%=("5".equals(goal.getAlimentos()))?"selected":""%>>DEL
							31% AL 40%</option>
							<option value="6"
								<%=("6".equals(goal.getAlimentos()))?"selected":""%>>DEL
							41% AL 50%</option>
							<option value="7"
								<%=("7".equals(goal.getAlimentos()))?"selected":""%>>DEL
							51% AL 60%</option>
							<option value="8"
								<%=("8".equals(goal.getAlimentos()))?"selected":""%>>DEL
							61% AL 70%</option>
							<option value="9"
								<%=("9".equals(goal.getAlimentos()))?"selected":""%>>DEL
							71% AL 80%</option>
							<option value="10"
								<%=("10".equals(goal.getAlimentos()))?"selected":""%>>DEL
							81% AL 90%</option>
							<option value="11"
								<%=("11".equals(goal.getAlimentos()))?"selected":""%>>DEL
							91% AL 100%</option>
							<option value="12"
								<%=("12".equals(goal.getAlimentos()))?"selected":""%>>MÁS
							DEL 100%</option>
						</select></td>
						<td valign="top" align="left" class="blackText1"><select
							name="educacion" id="educacion"
							tabindex="18">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getEducacion()))?"selected":""%>>0%</option>
							<option value="2"
								<%=("2".equals(goal.getEducacion()))?"selected":""%>>DEL
							1% AL 10%</option>
							<option value="3"
								<%=("3".equals(goal.getEducacion()))?"selected":""%>>DEL
							11% AL 20%</option>
							<option value="4"
								<%=("4".equals(goal.getEducacion()))?"selected":""%>>DEL
							21% AL 30%</option>
							<option value="5"
								<%=("5".equals(goal.getEducacion()))?"selected":""%>>DEL
							31% AL 40%</option>
							<option value="6"
								<%=("6".equals(goal.getEducacion()))?"selected":""%>>DEL
							41% AL 50%</option>
							<option value="7"
								<%=("7".equals(goal.getEducacion()))?"selected":""%>>DEL
							51% AL 60%</option>
							<option value="8"
								<%=("8".equals(goal.getEducacion()))?"selected":""%>>DEL
							61% AL 70%</option>
							<option value="9"
								<%=("9".equals(goal.getEducacion()))?"selected":""%>>DEL
							71% AL 80%</option>
							<option value="10"
								<%=("10".equals(goal.getEducacion()))?"selected":""%>>DEL
							81% AL 90%</option>
							<option value="11"
								<%=("11".equals(goal.getEducacion()))?"selected":""%>>DEL
							91% AL 100%</option>
							<option value="12"
								<%=("12".equals(goal.getEducacion()))?"selected":""%>>MÁS
							DEL 100%</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&nbsp;<strong>2.</strong>
						Vestido*</td>
						<td valign="top" align="left" class="blackText1"><strong>8.</strong>
						Diversiones*</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&nbsp; <select
							name="vestido" id="vestido"
							tabindex="13">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getVestido(goal.getVestido())%>
						</select></td>
						<td><select name="diversiones" id="diversiones" tabindex="19">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getDiversiones()))?"selected":""%>>0%</option>
							<option value="2"
								<%=("2".equals(goal.getDiversiones()))?"selected":""%>>DEL
							1% AL 10%</option>
							<option value="3"
								<%=("3".equals(goal.getDiversiones()))?"selected":""%>>DEL
							11% AL 20%</option>
							<option value="4"
								<%=("4".equals(goal.getDiversiones()))?"selected":""%>>DEL
							21% AL 30%</option>
							<option value="5"
								<%=("5".equals(goal.getDiversiones()))?"selected":""%>>DEL
							31% AL 40%</option>
							<option value="6"
								<%=("6".equals(goal.getDiversiones()))?"selected":""%>>DEL
							41% AL 50%</option>
							<option value="7"
								<%=("7".equals(goal.getDiversiones()))?"selected":""%>>DEL
							51% AL 60%</option>
							<option value="8"
								<%=("8".equals(goal.getDiversiones()))?"selected":""%>>DEL
							61% AL 70%</option>
							<option value="9"
								<%=("9".equals(goal.getDiversiones()))?"selected":""%>>DEL
							71% AL 80%</option>
							<option value="10"
								<%=("10".equals(goal.getDiversiones()))?"selected":""%>>DEL
							81% AL 90%</option>
							<option value="11"
								<%=("11".equals(goal.getDiversiones()))?"selected":""%>>DEL
							91% AL 100%</option>
							<option value="12"
								<%=("12".equals(goal.getDiversiones()))?"selected":""%>>MÁS
							DEL 100%</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&nbsp;<strong>3.</strong>
						Servicios para la vivienda*</td>
						<td valign="top" align="left" class="blackText1"><strong>9.</strong>
						Pago de deudas o cr&eacute;ditos*</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&nbsp; <select
							name="serviciosV" id="serviciosV"
							tabindex="14">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getServiciosV()))?"selected":""%>>0%</option>
							<option value="2"
								<%=("2".equals(goal.getServiciosV()))?"selected":""%>>DEL
							1% AL 10%</option>
							<option value="3"
								<%=("3".equals(goal.getServiciosV()))?"selected":""%>>DEL
							11% AL 20%</option>
							<option value="4"
								<%=("4".equals(goal.getServiciosV()))?"selected":""%>>DEL
							21% AL 30%</option>
							<option value="5"
								<%=("5".equals(goal.getServiciosV()))?"selected":""%>>DEL
							31% AL 40%</option>
							<option value="6"
								<%=("6".equals(goal.getServiciosV()))?"selected":""%>>DEL
							41% AL 50%</option>
							<option value="7"
								<%=("7".equals(goal.getServiciosV()))?"selected":""%>>DEL
							51% AL 60%</option>
							<option value="8"
								<%=("8".equals(goal.getServiciosV()))?"selected":""%>>DEL
							61% AL 70%</option>
							<option value="9"
								<%=("9".equals(goal.getServiciosV()))?"selected":""%>>DEL
							71% AL 80%</option>
							<option value="10"
								<%=("10".equals(goal.getServiciosV()))?"selected":""%>>DEL
							81% AL 90%</option>
							<option value="11"
								<%=("11".equals(goal.getServiciosV()))?"selected":""%>>DEL
							91% AL 100%</option>
							<option value="12"
								<%=("12".equals(goal.getServiciosV()))?"selected":""%>>MÁS
							DEL 100%</option>
						</select></td>
						<td><select name="pagoDeudas" id="pagoDeudas" tabindex="20">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getPagoDeudas()))?"selected":""%>>0%</option>
							<option value="2"
								<%=("2".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							1% AL 10%</option>
							<option value="3"
								<%=("3".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							11% AL 20%</option>
							<option value="4"
								<%=("4".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							21% AL 30%</option>
							<option value="5"
								<%=("5".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							31% AL 40%</option>
							<option value="6"
								<%=("6".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							41% AL 50%</option>
							<option value="7"
								<%=("7".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							51% AL 60%</option>
							<option value="8"
								<%=("8".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							61% AL 70%</option>
							<option value="9"
								<%=("9".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							71% AL 80%</option>
							<option value="10"
								<%=("10".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							81% AL 90%</option>
							<option value="11"
								<%=("11".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							91% AL 100%</option>
							<option value="12"
								<%=("12".equals(goal.getPagoDeudas()))?"selected":""%>>MÁS
							DEL 100%</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&nbsp;<strong>4.</strong>
						Limpieza y enseres*</td>
						<td valign="top" align="left" class="blackText1"><strong>10.</strong>
						Renta*</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&nbsp; <select
							name="limpieza" id="limpieza" tabindex="15">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getLimpieza()))?"selected":""%>>0%</option>
							<option value="2"
								<%=("2".equals(goal.getLimpieza()))?"selected":""%>>DEL
							1 AL 10%</option>
							<option value="3"
								<%=("3".equals(goal.getLimpieza()))?"selected":""%>>DEL
							11 AL 20%</option>
							<option value="4"
								<%=("4".equals(goal.getLimpieza()))?"selected":""%>>DEL
							21 AL 30%</option>
							<option value="5"
								<%=("5".equals(goal.getLimpieza()))?"selected":""%>>DEL
							31 AL 40%</option>
							<option value="6"
								<%=("6".equals(goal.getLimpieza()))?"selected":""%>>DEL
							41 AL 50%</option>
							<option value="7"
								<%=("7".equals(goal.getLimpieza()))?"selected":""%>>DEL
							51 AL 60%</option>
							<option value="8"
								<%=("8".equals(goal.getLimpieza()))?"selected":""%>>DEL
							61 AL 70%</option>
							<option value="9"
								<%=("9".equals(goal.getLimpieza()))?"selected":""%>>DEL
							71 AL 80%</option>
							<option value="10"
								<%=("10".equals(goal.getLimpieza()))?"selected":""%>>DEL
							81 AL 90%</option>
							<option value="11"
								<%=("11".equals(goal.getLimpieza()))?"selected":""%>>DEL
							91 AL 100%</option>
							<option value="12"
								<%=("12".equals(goal.getLimpieza()))?"selected":""%>>MÁS
							DEL 100%</option>
						</select></td>
						<td><select name="renta" id="renta" tabindex="21">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getRenta()))?"selected":""%>>0%</option>
							<option value="2"
								<%=("2".equals(goal.getRenta()))?"selected":""%>>DEL 1%
							AL 10%</option>
							<option value="3"
								<%=("3".equals(goal.getRenta()))?"selected":""%>>DEL
							11% AL 20%</option>
							<option value="4"
								<%=("4".equals(goal.getRenta()))?"selected":""%>>DEL
							21% AL 30%</option>
							<option value="5"
								<%=("5".equals(goal.getRenta()))?"selected":""%>>DEL
							31% AL 40%</option>
							<option value="6"
								<%=("6".equals(goal.getRenta()))?"selected":""%>>DEL
							41% AL 50%</option>
							<option value="7"
								<%=("7".equals(goal.getRenta()))?"selected":""%>>DEL
							51% AL 60%</option>
							<option value="8"
								<%=("8".equals(goal.getRenta()))?"selected":""%>>DEL
							61% AL 70%</option>
							<option value="9"
								<%=("9".equals(goal.getRenta()))?"selected":""%>>DEL
							71% AL 80%</option>
							<option value="10"
								<%=("10".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							81% AL 90%</option>
							<option value="11"
								<%=("11".equals(goal.getPagoDeudas()))?"selected":""%>>DEL
							91% AL 100%</option>
							<option value="12"
								<%=("12".equals(goal.getPagoDeudas()))?"selected":""%>>MÁS
							DEL 100%</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&nbsp;<strong>5.</strong>
						Salud*</td>
						<td valign="top" align="left" class="blackText1"><strong>11.</strong>
						Otros</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&nbsp; <select
							name="salud" id="salud" tabindex="16">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getSalud()))?"selected":""%>>0%</option>
							<option value="2"
								<%=("2".equals(goal.getSalud()))?"selected":""%>>DEL 1%
							AL 10%</option>
							<option value="3"
								<%=("3".equals(goal.getSalud()))?"selected":""%>>DEL
							11% AL 20%</option>
							<option value="4"
								<%=("4".equals(goal.getSalud()))?"selected":""%>>DEL
							21% AL 30%</option>
							<option value="5"
								<%=("5".equals(goal.getSalud()))?"selected":""%>>DEL
							31% AL 40%</option>
							<option value="6"
								<%=("6".equals(goal.getSalud()))?"selected":""%>>DEL
							41% AL 50%</option>
							<option value="7"
								<%=("7".equals(goal.getSalud()))?"selected":""%>>DEL
							51% AL 60%</option>
							<option value="8"
								<%=("8".equals(goal.getSalud()))?"selected":""%>>DEL
							61% AL 70%</option>
							<option value="9"
								<%=("9".equals(goal.getSalud()))?"selected":""%>>DEL
							71% AL 80%</option>
							<option value="10"
								<%=("10".equals(goal.getSalud()))?"selected":""%>>DEL
							81% AL 90%</option>
							<option value="11"
								<%=("11".equals(goal.getSalud()))?"selected":""%>>DEL
							91% AL 100%</option>
							<option value="12"
								<%=("12".equals(goal.getSalud()))?"selected":""%>>MÁS
							DEL 100%</option>
						</select></td>
						<td><input 	name="otroGastos" type="text" id="otroGastos" tabindex="22"
									onblur=""
									onkeypress="conMayusculasOtros('otroGastos');"
									value="${gol.otroGastos}" size="10"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&nbsp;<strong>6.</strong>
						Transporte*</td>
						<td valign="top" align="left" class="blackText1">&iquest;Cu&aacute;nto
						gasta?</td>
					</tr>
					<tr>
						<td height="23" align="left" valign="top" class="blackText1">&nbsp;
						<select name="transporte" id="transporte" tabindex="17">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getTransporte()))?"selected":""%>>0%</option>
							<option value="2"
								<%=("2".equals(goal.getTransporte()))?"selected":""%>>DEL
							1% AL 10%</option>
							<option value="3"
								<%=("3".equals(goal.getTransporte()))?"selected":""%>>DEL
							11% AL 20%</option>
							<option value="4"
								<%=("4".equals(goal.getTransporte()))?"selected":""%>>DEL
							21% AL 30%</option>
							<option value="5"
								<%=("5".equals(goal.getTransporte()))?"selected":""%>>DEL
							31% AL 40%</option>
							<option value="6"
								<%=("6".equals(goal.getTransporte()))?"selected":""%>>DEL
							41% AL 50%</option>
							<option value="7"
								<%=("7".equals(goal.getTransporte()))?"selected":""%>>DEL
							51% AL 60%</option>
							<option value="8"
								<%=("8".equals(goal.getTransporte()))?"selected":""%>>DEL
							61% AL 70%</option>
							<option value="9"
								<%=("9".equals(goal.getTransporte()))?"selected":""%>>DEL
							71% AL 80%</option>
							<option value="10"
								<%=("10".equals(goal.getTransporte()))?"selected":""%>>DEL
							81% AL 90%</option>
							<option value="11"
								<%=("11".equals(goal.getTransporte()))?"selected":""%>>DEL
							91% AL 100%</option>
							<option value="12"
								<%=("12".equals(goal.getTransporte()))?"selected":""%>>MÁS
							DEL 100%</option>
						</select></td>
						<td valign="top"><select name="cuantogasta" disabled="disabled" id="cuantogasta" tabindex="23">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getCuantogasta()))?"selected":""%>>0%</option>
							<option value="2"
								<%=("2".equals(goal.getCuantogasta()))?"selected":""%>>DEL
							1% AL 10%</option>
							<option value="3"
								<%=("3".equals(goal.getCuantogasta()))?"selected":""%>>DEL
							11% AL 20%</option>
							<option value="4"
								<%=("4".equals(goal.getCuantogasta()))?"selected":""%>>DEL
							21% AL 30%</option>
							<option value="5"
								<%=("5".equals(goal.getCuantogasta()))?"selected":""%>>DEL
							31% AL 40%</option>
							<option value="6"
								<%=("6".equals(goal.getCuantogasta()))?"selected":""%>>DEL
							41% AL 50%</option>
							<option value="7"
								<%=("7".equals(goal.getCuantogasta()))?"selected":""%>>DEL
							51% AL 60%</option>
							<option value="8"
								<%=("8".equals(goal.getCuantogasta()))?"selected":""%>>DEL
							61% AL 70%</option>
							<option value="9"
								<%=("9".equals(goal.getCuantogasta()))?"selected":""%>>DEL
							71% AL 80%</option>
							<option value="10"
								<%=("10".equals(goal.getCuantogasta()))?"selected":""%>>DEL
							81% AL 90%</option>
							<option value="11"
								<%=("11".equals(goal.getCuantogasta()))?"selected":""%>>DEL
							91% AL 100%</option>
							<option value="12"
								<%=("12".equals(goal.getCuantogasta()))?"selected":""%>>MÁS
							DEL 100%</option>
						</select></td>
					</tr>
				</table>
				</fieldset>
				 </td>
			</tr>
			<tr>
				<td height="2" colspan="6"></td>
			</tr>
		</table>
		</fieldset>
		</td>
	</tr>

	<tr>
		<td colspan="3">&nbsp;</td>
		<td width="55" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image10','','../images/accesos_down/aplicacion-2_28.png',1)"><img
			src="../images/accesos_down/aplicacion-23_28.png" name="Image10"
			width="33" height="32" border="0" id="Image10" /></a></td>
		<td width="9">&nbsp;</td>
		<td width="44" align="center"><a 
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image9','','../images/accesos_down/aplicacion-2_30.png',1)"><img
			src="../images/accesos_down/aplicacion-23_30.png" name="Image9"
			width="33" height="32" border="0" id="Image9" /></a></td>
		<td width="9">&nbsp;</td>
		<td width="47" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image8','','../images/accesos_down/aplicacion-2_34.png',1)"><img
			src="../images/accesos_down/aplicacion-23_34.png" name="Image8"
			width="32" height="32" border="0" id="Image8" /></a></td>
		<td width="9">&nbsp;</td>
		<td width="97" align="center"><a href="infogol.jsp"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image61','','../images/accesos_down/aplicacion-2_36.png',1)"><img
			src="../images/accesos_down/aplicacion-23_36.png" name="Image61"
			width="32" height="32" border="0" id="Image61" /></a></td>
		<td width="12">&nbsp;</td>
		<td width="47" align="center"><a 
			href="#"
			onclick="valPagina3('pagina2A', 'Ingresogol',2)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image6','','../images/accesos_down/aplicacion-2_36.png',1)"><img
			src="../images/accesos_down/aplicacion-23_36.png" name="Image6"
			width="32" height="32" border="0" id="Image6" /></a></td>
		<td width="9">&nbsp;</td>
		<td width="66" align="center"><a
			href="#"
			onclick="valPagina3('pagina4', 'Ingresogol',1)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image12','','../images/accesos_down/aplicacion-2_41.png',1)"><img
			src="../images/accesos_down/aplicacion-23_41.png" name="Image12"
			width="31" height="32" border="0" id="Image12" /></a></td>
	</tr>
	<tr>
		<td width="8">&nbsp;</td>
		<td width="8">&nbsp;</td>
		<td width="433">&nbsp;</td>
		<td align="center" class="blueText" valign="top">Cancelar</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText" valign="top">Guardar</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText" valign="top">Salir</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText" valign="top">Primera Pantalla</td>
		<td>&nbsp;</td>
		<td align="center" valign="top" class="blueText">Anterior</td>
		<td>&nbsp;</td>
		<td class="blueText" align="center">Siguiente</td>
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
