<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml">
<!-- InstanceBegin template="/Templates/plantilla2.dwt" codeOutsideHTMLIsLocked="false" -->
<%@taglib uri="cewolf" prefix="cewolf"%>
<%@page import="com.urbi.prima.*"%>
<head>
<%
	Usuarios usuarioUrbi = (Usuarios)session.getAttribute("usuarioUrbi");
	if(usuarioUrbi==null){
		try{
			response.sendRedirect("../index.jsp");
		}catch(IOException io){
			System.out.println("ERROR:"+io.getMessage());
		}
	}
	String nombre = (String) request.getSession().getAttribute("NOMBRE_PRIMA");
	String CUOTA_PURA_RIESGO = (String) request.getSession()
			.getAttribute("CUOTA_PURA_RIESGO");
	String CUOTA_RECARGADAD = (String) request.getSession()
			.getAttribute("CUOTA_RECARGADAD");
	String PRIMA_PURA_RIESGO = (String) request.getSession()
			.getAttribute("PRIMA_PURA_RIESGO");
	String PRIMA_PURA_RIESO_RECARGADA = (String) request.getSession()
			.getAttribute("PRIMA_PURA_RIESO_RECARGADA");
        
        
            String lista = (String) request.getSession().getAttribute("lista");
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Prima Pura</title>
<script language="javascript" src="js/funciones.js"></script>
<!-- InstanceEndEditable -->
<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/funciones.js"></script>
<script language="javascript" src="../js/prima.js"></script>
<!-- InstanceBeginEditable name="head" -->
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
</script>
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
</head>
<body
	onload="MM_preloadImages('../images/acceso/activo-blanco_salir.png')">
<center>
<div id="contenedor">
<div id="encabezado">
<div id="borde_iz"></div>
<div id="logo"></div>
<div id="relleno">
<div id="capa_enc">
<table width="321" border="0" valign="right" cellpadding="0"
	cellspacing="0" class="whiteSubtitle">
	<tr>
		<td width="226" colspan="9" align="center" class="blueSubtitle">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="blueSubtitle">Prima Pura de
		Riesgo</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="whiteSubtitle">Calcular
		Prima Pura de Riesgo</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="whiteSubtitle">&nbsp;</td>
	</tr>
</table>
</div>
</div>
<div id="borde_der"></div>
<div id="contenido"><!-- InstanceBeginEditable name="Region2" -->
<table width="822" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td align="left" valign="top">&nbsp;</td>
	</tr>
	<tr>
		<td width="207" rowspan="3" align="left" valign="top">
			<form id="calcIndex" name="calcIndex" method="post" action="../PrimaMantServlet" onsubmit="return validate_form(this)">
			<input type="hidden" id="command" name="command" value=""></input>
			<input type="hidden" id="idPrima" name="idPrima" value=""></input>
			<select name="listaP" id="listaP" multiple="multiple" class="lista_200"
					onclick="SelPrima();"
					size="20">
				<%=(lista == null) ? PrimaSql.getListaPrima("", "", 0) : lista%>
			</select>
			</form>
		</td>
	</tr>

	<tr>
		<td width="32" height="27" align="left" valign="top"></td>
		<td height="27" colspan="6" align="left" valign="top">
		<fieldset>
		<table width="443" height="277" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="15" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td height="16" valign="top" align="center" class="blackText2"><%=nombre%></td>
			</tr>
			<tr>
				<td height="2" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
				<fieldset>
				<table width="435" height="221" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td colspan="4" align="right" valign="top" class="blackText1">&nbsp;</td>
					</tr>
					<tr>
						<td width="12" valign="top" class="blackText1" align="left">&nbsp;</td>
						<td width="144" valign="top" class="blackText1" align="left">Cuota
						pura de riesgo:</td>
						<td width="4" valign="top" class="blackText1" align="right">&nbsp;</td>
						<td width="275" class="blackText1" style="font-weight: bold"
							align="left">
						<form id="form1" name="form1" method="post" action=""><input
							type="text" name="textfield2" value="<%=CUOTA_PURA_RIESGO%>" /></form>
						</td>
					</tr>
					<tr>
						<td colspan="4" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td align="left" valign="top" class="blackText1">Prima pura
						de riesgo:</td>
						<td align="right" valign="top" class="blackText1">&nbsp;</td>
						<td align="left" class="blackSmallText"><input type="text"
							name="textfield3" value="<%=PRIMA_PURA_RIESGO%>" /></td>
					</tr>
					<tr>
						<td colspan="4" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td align="left" valign="top" class="blackText1">Cuota pura
						de riesgo<br />
						con recargo por estado:</td>
						<td align="right" valign="top" class="blackText1">&nbsp;</td>
						<td align="left" class="blackSmallText" valign="bottom"><input
							type="text" name="textfield4" value="<%=CUOTA_RECARGADAD%>" />
						</td>
					</tr>
					<tr>
						<td colspan="4" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top" class="blackText1">&nbsp;</td>
						<td align="left" valign="top" class="blackText1">Prima pura
						de riesgo<br />
						con recargo por estado:</td>
						<td align="right" valign="top" class="blackText1">&nbsp;</td>
						<td align="left" valign="bottom" class="blackText1"><input
							type="text" name="textfield5"
							value="<%=PRIMA_PURA_RIESO_RECARGADA%>" /></td>
					</tr>
					<tr>
						<td colspan="3" valign="top">&nbsp;</td>
						<td align="justify" class="blackSmallText">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4" valign="top">&nbsp;</td>
					</tr>
				</table>
				</fieldset>
				 </td>
			</tr>
		</table>
		</fieldset>
		</td>
		<td width="166" align="right" valign="bottom"><a
			href="primaindex.jsp" onmouseout="MM_swapImgRestore()"
			onmouseover="MM_swapImage('salir', '', '../images/acceso/activo-blanco_salir.png', 1);"><img
			src="../images/acceso/inactivo-blanco_salir.png" name="salir"
			width="30" height="30" border="0" id="salir" /></a><br />
		<span class="blueSubtitle">Salir</span></td>
	</tr>

	<tr>
		<td colspan="8" align="center" valign="top">
		<div align="right"></div>
		</td>
	</tr>
</table>
</div>
<div id="pie_pag"></div>
</div>
</div>
</center>
</body>
</html>
