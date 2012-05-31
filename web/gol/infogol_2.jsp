<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.prima.PrimaSql"%>
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
    GolBean goal = (GolBean)request.getSession().getAttribute("gol");
    String accion = (String)request.getSession().getAttribute("accion");
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Originaci&oacute;n de Cliente</title>
<!-- InstanceEndEditable -->
<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/funciones.js"></script>
<script language="JavaScript" src="../js/gol.js"></script>
<script language="JavaScript" src="../js/golVal.js"></script>
<script language="JavaScript" type="text/javascript" src="../js/ajax.js"></script>
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
</head>
<body
	onload="habilitaNT('actividadPrincipal','noTrabaja');MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_exit.png','../images/acceso/activos_guardar.png','../images/buscar_activo.png','../images/acceso/activos_salir.png','../images/acceso/inactivo-blanco_salir.png','../images/acceso/activos_left.png','../images/acceso/activos_right.png','../images/accesos_down/aplicacion-2_41.png','../images/accesos_down/aplicacion-2_38.png','../images/accesos_down/aplicacion-2_36.png','../images/accesos_down/aplicacion-2_34.png','../images/accesos_down/aplicacion-2_30.png','../images/accesos_down/aplicacion-2_28.png','../images/accesos_down/aplicacion-2_26.png','../images/accesos_down/aplicacion-2_24.png','../images/accesos_down/aplicacion-2_22.png')">
<form id="Infogol_2" name="Infogol_2" method="post" action="../GolServlet" onsubmit="return validate_form(this)">
<input type="hidden" id="command" name="command" value="" />
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
			onclick="valPagina2('Guardar2', 'Infogol_2',0)"
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
<div id="contenido"><!-- InstanceBeginEditable name="Region2" -->
<%@include file="../ErrorTag.jsp"%>
<table width="851" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="7" colspan="10">
		<fieldset>
		<table width="844" height="432" border="0" align="left"
			cellpadding="0" cellspacing="0">
			<tr>
				<td colspan="6"> </td>
			</tr>
			<tr>
				<td colspan="4" rowspan="2" valign="top">
				<fieldset><legend class="blackText1"
					style="font-weight: bold">Religi&oacute;n</legend>
				<table width="487" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="113" align="left" class="blackText1">&iquest;Cu&aacute;l
						es la religi&oacute;n<br />
						de su familia? *</td>
						<td width="33" rowspan="5">&nbsp;</td>
						<td width="144" align="left" class="blackText1">Si otra,
						&iquest;cu&aacute;l?</td>
						<td width="24" rowspan="5">&nbsp;</td>
						<td width="221" align="left" class="blackText1">&iquest;Con
						qu&eacute; frecuencia acude a<br />
						celebraciones religiosas?*</td>
					</tr>
					<tr>
						<td class="blackText1" align="left"><select
							name="religionFamilia" id="religionFamilia" onchange="activarOtra('religionFamilia','religioOtra');">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getReligion(goal.getReligionFamilia())%>
						</select></td>
						<td class="blackText1" align="left"><input type="text" 
							id="religioOtra" name="religioOtra" value="${gol.religioOtra}"
							onkeypress="AceptaAlfanumericoYPunto()" 
							class="mayus"/></td>
						<td class="blackText1" align="left"><select
							id="religionFrecuencia" name="religionFrecuencia">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getFreReligion(goal.getReligionFrecuencia())%>
						</select></td>
					</tr>
					<tr>
						<td class="blackText1" align="left">&nbsp;</td>
						<td class="blackText1" align="left">&nbsp;</td>
						<td class="blackText1" align="left">&nbsp;</td>
					</tr>
					<tr>
						<td class="blackText1" align="left">&iquest;Cu&aacute;l es su
						religi&oacute;n?*</td>
						<td class="blackText1" align="left">Si otra,
						&iquest;cu&aacute;l?</td>
						<td class="blackText1" align="left">&iquest;C&oacute;mo
						afecta su religi&oacute;n en<br />
						la toma de decisiones?*</td>
					</tr>
					<tr>
						<td class="blackText1" align="left">
							<select name="religionMia" id="religionMia" 
									onchange="activarOtra('religionMia','religionMiaOtra');">
								<option value="-1">-Seleccione-</option>
								<%=GolSql.getReligion(goal.getReligionMia())%>
							</select>
						</td>
						<td class="blackText1" align="left"><input type="text"
							id="religionMiaOtra" name="religionMiaOtra" value="${gol.religionMiaOtra}"
							onkeypress="AceptaAlfanumericoYPunto();" 
							class="mayus"/></td>
						<td class="blackText1" align="left"><input type="text"
							id="religionDecision" name="religionDecision" value="${gol.religionDecision}"
							onkeypress="AceptaAlfanumericoYPunto();" 
							class="mayus"/></td>
					</tr>
				</table>
				</fieldset>
				</td>
				<td width="4" rowspan="2" valign="top">&nbsp;</td>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td width="318" valign="top">
				<fieldset>
				<table width="306" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="306" align="left" class="blackText1">&iquest;Por
						qu&eacute; raz&oacute;n quiere cambiarse de casa?*</td>
					</tr>
					<tr>
						<td align="left" class="blackText1"><input name="razoncambio" id="razoncambio"
							class="mayus"
							type="text" size="50" value="${gol.razoncambio}" /></td>
					</tr>
					<tr>
						<td align="left" class="blackText1">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="blackText1">&iquest;Cu&aacute;l es la
						principal motivaci&oacute;n para cambiarse a este
						fraccionamiento?*</td>
					</tr>
					<tr>
						<td align="left" class="blackText1"><input name="motivacion" id="motivacion"
							class="mayus"
							type="text" size="50" value="${gol.motivacion}" /></td>
					</tr>
				</table>
				</fieldset>
				 </td>
			</tr>
			<tr>
				<td colspan="6"></td>
			</tr>
			<tr>
				<td colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="6"></td>
			</tr>

			<tr>
				<td width="179" align="left" valign="top" class="blackText1"></td>
				<td width="3" align="left" valign="top" class="blackText1"></td>
				<td width="336" rowspan="38" align="left" valign="top"
					class="blackText1">
				<fieldset><legend class="blackText1"
					style="font-weight: bold">Ocupación</legend>
				<table width="317" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="114" valign="top" align="left" class="blackText1">Tipo
						de Actividad*</td>
						<td width="9">&nbsp;</td>
						<td width="168" valign="top" align="center" class="blackText1">Descripci&oacute;n
						de la ocupaci&oacute;n*</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">
							<select id="tipoActividad" name="tipoActividad"
									onchange="carga('tipoActividad', 'sector', 1, 6,-1)">
								<option value="-1">-Seleccione-</option>
								<%=PrimaSql.getTipoActividad("6", (goal.getTipoActividad()==null)?"":goal.getTipoActividad())%>
							</select>
						</td>
						<td>&nbsp;</td>
						<td valign="top" align="left" class="blackText1"><textarea
							name="descripcionOcupacion" id="descripcionOcupacion"
							class="mayus">${gol.descripcionOcupacion}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">Sector*</td>
						<td rowspan="2">&nbsp;</td>
						<td rowspan="2" align="center" valign="top" class="blackText1">En
						el trabajo que desempe&ntilde;a, &iquest;cu&aacute;l es su rol en
						la organizaci&oacute;n?*</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">
							<select class="combo_140" id="sector"
									name="sector" onchange="carga('sector', 'subSector', 2, 6,-1)">
								<option value="-1">-Seleccione-</option>
							</select>
						</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&nbsp;</td>
						<td>&nbsp;</td>
						<td valign="top" align="center" class="blackText1">
							<select
							name="rol" id="rol" disabled>
							<option value="-1">-Seleccione-</option>
							<%
							Session s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
							Iterator it = null;
							Transaction tx = s.beginTransaction();
							Query q = s.createQuery("from Rol  as rol where rol.calId = '2'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                            	Rol rol = (Rol) it.next();
                            %>
							<option value="<%=rol.getRolId()%>"
								<%=(String.valueOf(rol.getRolId()).equals(goal.getRol()))?"selected":""%>><%=rol.getRolDes()%></option>
							<%}%>
						</select></td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">Subsector*</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2">
							<select class="combo_140" id="subSector" name="subSector">
								<option value="-1">-Seleccione-</option>
							</select>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" valign="top" align="left" class="blackText1">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="3" valign="top" align="center" class="blackText1">&iquest;Hace
						cu&aacute;nto labora en su empleo actual? *</td>
					</tr>
					<tr>
						<td colspan="3" valign="top" align="center" class="blackText1">
						<input type="text" name="tiempoLaborando" id="tiempoLaborando"
							value="${gol.tiempoLaborando}" 
							onkeypress="AceptaNumerico();"
							onblur="validEdad('tiempoLaborando',<%=goal.getEdad()%>);"
							maxlength="2"/> A&ntilde;os</td>
					</tr>
				</table>
				</fieldset>
				 </td>
				<td width="4" rowspan="38" align="left" valign="top"
					class="blackText1">&nbsp;</td>
				<td colspan="2" rowspan="38" align="center" valign="top"
					class="blackText1">
				<fieldset>
				<div align="left"><legend class="blackText1"
					style="font-weight: bold">Escolaridad</legend></div>
				<table width="284" border="0" cellspacing="0" cellpadding="0">

					<tr align="left" valign="top" class="blackText1">
						<td colspan="3" align="left" valign="top" class="blackText1">&iquest;Estudia
						actualmente?*</td>
					</tr>
					<tr align="left" valign="top" class="blackText1">
						<td colspan="3" align="left" valign="top" class="blackText1">
						<select name="estudiaActual" id="estudiaActual">
							<option value="-1">-Seleccione-</option>
							<option value="1"
								<%=("1".equals(goal.getEstudiaActual()))?"selected":""%>>SI</option>
							<option value="2"
								<%=("2".equals(goal.getEstudiaActual()))?"selected":""%>>NO</option>
						</select></td>
					</tr>
					<tr>
						<td width="176" align="left" valign="top" class="blackText1">&nbsp;</td>
						<td width="22" align="left" valign="top" class="blackText1">&nbsp;</td>
						<td width="116" align="left" valign="top" class="blackText1">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top" class="blackText1">&iquest;Hasta
						qu&eacute; grado estudi&oacute;?*</td>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td align="left" valign="top" class="blackText1">A&ntilde;os
						aprobados*</td>
					</tr>
					<tr>
						<td align="left"><select name="gradoE" id="gradoE">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getNE(goal.getGradoE())%>
						</select></td>
						<td>&nbsp;</td>
						<td align="left"><input name="gradoEAnio" id="gradoEAnio" type="text"
							size="8" value="${gol.gradoEAnio}" onkeypress="AceptaNumerico();"
							maxlength="2" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&iquest;Hasta
						qu&eacute; grado<br />
						estudi&oacute; su pap&aacute;?*</td>
						<td>&nbsp;</td>
						<td valign="middle" align="left" class="blackText1">A&ntilde;os
						aprobados*</td>
					</tr>
					<tr>
						<td align="left"><select name="gradoEPapa" id="gradoEPapa">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getNEP(goal.getGradoEPapa())%>
						</select></td>
						<td>&nbsp;</td>
						<td align="left"><input name="gradoEPAnio" id="gradoEPAnio" type="text"
							size="8" value="${gol.gradoEPAnio}"
							onkeypress="AceptaNumerico();" maxlength="2" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" align="left" class="blackText1">&iquest;Hasta
						qu&eacute; grado<br />
						estudi&oacute; su mam&aacute;?*</td>
						<td>&nbsp;</td>
						<td valign="middle" align="left" class="blackText1">A&ntilde;os
						aprobados*</td>
					</tr>
					<tr>
						<td align="left"><select name="gradoEMama" id="gradoEMama">
							<option value="-1">-Seleccione-</option>
							<%=GolSql.getNEM(goal.getGradoEMama())%>
						</select></td>
						<td>&nbsp;</td>
						<td align="left"><input name="gradoEMAnio" id="gradoEMAnio" type="text"
							size="8" value="${gol.gradoEMAnio}"
							onkeypress="AceptaNumerico();" maxlength="2" /></td>
					</tr>
				</table>
				</fieldset>
				 </td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1">&iquest;Hace
				cu&aacute;nto habita<br />
				en su vivienda actual?*</td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"><input
					name="tiempoViviendo" type="text" size="8" id="tiempoViviendo"
					value="${gol.tiempoViviendo}" onkeypress="AceptaNumerico();"
					onblur="validEdad('tiempoViviendo',<%=goal.getEdad()%>);"
					maxlength="2" /> A&ntilde;os</td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1">&iquest;Cu&aacute;l
				fue su actividad principal<br />
				durante el &uacute;ltimo mes?*</td>
			</tr>
			<tr>
				<td valign="top" align="left" class="blackText1"><select
					class="combo_140" name="actividadPrincipal" id="actividadPrincipal" onchange="habilitaNT('actividadPrincipal','noTrabaja');">
					<option value="-1">-Seleccione-</option>
					<%=GolSql.getActUlt(goal.getActividadPrincipal())%>
				</select></td>
			</tr>

			<tr>
				<td valign="top" align="left" class="blackText1">&nbsp;</td>
			</tr>
			<tr>
				<td height="19" align="left" valign="top" class="blackText1">Si
				no trabaj&oacute;, &iquest;por qu&eacute;?</td>
			</tr>
			<tr>
				<td height="90" align="left" valign="top" class="blackText1"><textarea
					name="noTrabaja" id="noTrabaja" disabled
					class="mayus">${gol.noTrabaja}</textarea></td>
			</tr>

			<tr>
				<td colspan="6" valign="top"></td>
			</tr>
		</table>
		</fieldset>
		</td>
	</tr>

	<tr>
		<td width="555"><a href="#" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image20','','../images/accesos_down/aplicacion-2_22.png',1)"></a><a
			href="#" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image19','','../images/accesos_down/aplicacion-2_24.png',1)"></a><a
			href="#" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image18','','../images/accesos_down/aplicacion-2_26.png',1)"></a></td>
		<td width="48" align="center"><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image17','','../images/accesos_down/aplicacion-2_28.png',1)"><img
			src="../images/accesos_down/aplicacion-23_28.png" name="Image17"
			width="33" height="32" border="0" id="Image17" /></a></td>
		<td width="22">&nbsp;</td>
		<td width="44" align="center"><a 
			href="#"
			onclick="valPagina2('Guardar2', 'Infogol_2',0)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image16','','../images/accesos_down/aplicacion-2_30.png',1)"><img
			src="../images/accesos_down/aplicacion-23_30.png" name="Image16"
			width="33" height="32" border="0" id="Image16" /></a></td>
		<td width="18">&nbsp;</td>
		<td width="45" align="center"><a
			href="#"
			onclick="salirGol();"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('salir2','','../images/accesos_down/aplicacion-2_34.png',1)"><img
			src="../images/accesos_down/aplicacion-23_34.png" name="salir2"
			width="32" height="32" border="0" id="salir2" /></a></td>
		<td width="26">&nbsp;</td>
		<td width="46" align="center"><a 
			href="#"
			onclick="valPagina2('pagina1', 'Infogol_2',2)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('Image14','','../images/accesos_down/aplicacion-2_36.png',1)"><img
			src="../images/accesos_down/aplicacion-23_36.png" name="Image14"
			width="32" height="32" border="0" id="Image14" /></a><a href="#"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('derecha','','../images/accesos_down/aplicacion-2_38.png',1)"></a></td>
		<td width="9">&nbsp;</td>
		<td width="52" align="center"><a
			href="#"
			onclick="valPagina2('pagina3', 'Infogol_2',1)"
			onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('siguiente','','../images/accesos_down/aplicacion-2_41.png',1)"><img
			src="../images/accesos_down/aplicacion-23_41.png" name="siguiente"
			width="31" height="32" border="0" id="siguiente" /></a></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class="blueText" align="center">Cancelar</td>
		<td>&nbsp;</td>
		<td class="blueText" align="center">Guardar</td>
		<td>&nbsp;</td>
		<td class="blueText" align="center">Salir</td>
		<td>&nbsp;</td>
		<td align="center" class="blueText">Anterior</td>
		<td>&nbsp;</td>
		<td class="blueText" align="center">Siguiente</td>
	</tr>
</table>
<!-- InstanceEndEditable --></div>
<div id="pie_pag"></div>
</div>
</div>
</center>
<%System.out.println(goal.getIdGol());%>
<%System.out.println(goal.getTipoActividad());%>
<%if(goal.getTipoActividad()!=null){%>
<script type="text/javascript">
self.setTimeout("carga('tipoActividad', 'sector', 1, 6, <%=goal.getSector()%>);", 1000);
self.setTimeout("carga('sector', 'subSector', 2, 6, <%=goal.getSubsector()%>);", 2000);
</script>
<%}%>
</form>
</body>
<!-- InstanceEnd -->
</html>
