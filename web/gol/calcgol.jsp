<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.prima.Bean3dChart"%>
<%@page import="de.laures.cewolf.DatasetProducer"%>
<%@page import="gol.beans.GolSql"%>
<%@page import="java.util.List"%>
<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml">
    <%@taglib uri="cewolf" prefix="cewolf"%>
<!-- InstanceBegin template="/Templates/plantilla2.dwt" codeOutsideHTMLIsLocked="false" -->
<%
	Usuarios usuarioUrbi = (Usuarios)session.getAttribute("usuarioUrbi");
	if(usuarioUrbi==null){
		try{
			response.sendRedirect("../index.jsp");
		}catch(IOException io){
			System.out.println("ERROR:"+io.getMessage());
		}
	}

	List valoresCalculo = (List)request.getSession().getAttribute("valoresCalculo");
	String COMPORTAMIENTO_PAGO = "";
	String GENERO = "";
	String ARRAIGO = "";
	String ASPECTOS_DIF = "";
	String GENERO_CLASE_TEXTO_1 = "";
	String GENERO_CLASE_TEXTO_2 = "";
	String COMPORTAMIENTO_DE_PAGO_TEXTO_1 = "";
	String COMPORTAMIENTO_DE_PAGO_TEXTO_2 = "";
	String ARRAIGO_TEXTO_1 = "";
	String ARRAIGO_TEXTO_2 = "";
	String ASPECTOS_TEXTO_1 = "";
	String resultado = "";
	String nombre = "";
	if (pageContext.getAttribute("initFlag") == null && valoresCalculo!=null) {
		//System.out.println("entra");
		COMPORTAMIENTO_PAGO = (String)valoresCalculo.get(3);
		GENERO = (String)valoresCalculo.get(2);
		ARRAIGO = (String)valoresCalculo.get(4);
		ASPECTOS_DIF = (String)valoresCalculo.get(5);
		
		GENERO_CLASE_TEXTO_1 = (String)valoresCalculo.get(6);
		GENERO_CLASE_TEXTO_2 = (String)valoresCalculo.get(7);
		COMPORTAMIENTO_DE_PAGO_TEXTO_1 = (String)valoresCalculo.get(8);
		COMPORTAMIENTO_DE_PAGO_TEXTO_2 = (String)valoresCalculo.get(9);
		ARRAIGO_TEXTO_1 = (String)valoresCalculo.get(10);
		ARRAIGO_TEXTO_2 = (String)valoresCalculo.get(11);
		ASPECTOS_TEXTO_1 = (String)valoresCalculo.get(12);
		resultado = (String)valoresCalculo.get(14);
		nombre = (String)valoresCalculo.get(15);
		DatasetProducer categoryData = new Bean3dChart(	Double.parseDouble(COMPORTAMIENTO_PAGO),
														Double.parseDouble(GENERO),
														Double.parseDouble(ARRAIGO),
														Double.parseDouble(ASPECTOS_DIF), "Tipos de Documentos");
		pageContext.setAttribute("categoryDataChar", categoryData);
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Originaci&oacute;n de Cliente</title>
<script language="javascript" src="js/funciones.js"></script>
<!-- InstanceEndEditable -->
<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/funciones.js"></script>
<script language="javascript" src="../js/gol.js"></script>
<!-- InstanceBeginEditable name="head" -->
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">
<!--



function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->
</script>
<!-- InstanceEndEditable -->
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
<div id="capa_enc"><!-- InstanceBeginEditable name="region1" -->
<table width="321" border="0" valign="right" cellpadding="0"
	cellspacing="0" class="whiteSubtitle">
	<tr>
		<td width="226" colspan="9" align="center" class="blueSubtitle">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="blueSubtitle">Originaci&oacute;n
		de Cliente</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="whiteSubtitle">Calcular
		Originaci&oacute;n de Cliente</td>
	</tr>
	<tr>
		<td colspan="9" align="center" class="whiteSubtitle">&nbsp;</td>
	</tr>
</table>
<!-- InstanceEndEditable --></div>
</div>
<div id="borde_der"></div>
<div id="contenido"><!-- InstanceBeginEditable name="Region2" -->
<table width="822" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td align="left" valign="top">&nbsp;</td>
	</tr>
	<tr>
		<td width="207" rowspan="18" align="left" valign="top">
			<form id="calcIndex" name="calcIndex" method="post" action="../GolServlet" onsubmit="return validate_form(this)">
			<input type="hidden" id="command" name="command" value=""></input>
			<input type="hidden" id="idPrima" name="idPrima" value=""></input>
			<input type="hidden" id="idGol" name="idGol" value=""></input>
			<select name="listaG" id="listaG" multiple="multiple" class="lista_200"
					onclick="SelGol();"
					size="20">
				<%=GolSql.getListaGol("","",0)%>
			</select>
			</form>
			<br>
			<br>
			<%=resultado%>
		</td>
	</tr>
	<tr>
		<td width="3" height="27" rowspan="18" align="left" valign="top"></td>
		<td height="27" colspan="6" rowspan="18" align="left" valign="top">
		<fieldset>
		<table width="443" height="277" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="15" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td height="16" valign="top" class="blackText2" align="center">
					<%=nombre%>
				</td>
			</tr>
			<tr>
				<td height="2" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
				<fieldset>
				<table width="460" height="221" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="293" rowspan="13" valign="top">
							<!-- GRAFICA -->
							<%if(valoresCalculo!=null){%>
							<cewolf:chart 	id="horizontalBarChart3D"
											title="Gráfica Gol" type="horizontalBar3D"
											xaxislabel="Datos" yaxislabel="Rango">
								<cewolf:gradientpaint>
									<cewolf:point x="0" y="0" color="#FFFFFF" />
									<cewolf:point x="300" y="0" color="#DDDDFF" />
								</cewolf:gradientpaint>
								<cewolf:data>
									<cewolf:producer id="categoryDataChar" />
								</cewolf:data>
							</cewolf:chart>
							<cewolf:img chartid="horizontalBarChart3D" renderer="/cewolf" width="300" height="300"/>
							<!-- GRAFICA -->
							<%}%>
						</td>
						<td width="149" class="blackText1" style="font-weight: bold"
							align="left">Composici&oacute;n</td>
					</tr>
					<tr>
						<td align="left" class="blackSmallText">Comportamiento de
						Pago:</td>
					</tr>
					<tr>
						<td align="left" class="blackSmallText">
							
							<input 	name="comportamientoPago" type="text" class="textarea1" size="20" value="<%=COMPORTAMIENTO_PAGO%>"
									readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="blackSmallText">G&eacute;nero y
						Clase:</td>
					</tr>
					<tr>
						<td align="left" class="blackSmallText">
							
							<input 	name="generoClase" type="text" class="textarea1" size="20" value="<%=GENERO%>"
									readonly="readonly"/>
							
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="blackSmallText">Arraigo:</td>
					</tr>
					<tr>
						<td align="left" class="blackSmallText">
							<input 	name="arraigo" type="text" class="textarea1" size="20" value="<%=ARRAIGO%>"
									readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="blackSmallText">Aspectos
						Diferenciadores:</td>
					</tr>
					<tr>
						<td align="left" class="blackSmallText">
							
							<input 	name="aspectos" type="text" class="textarea1" size="20" value="<%=ASPECTOS_DIF%>"
									readonly="readonly"/></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
				</fieldset>
				 </td>
			</tr>
		</table>
		</fieldset>
		</td>
		<td width="166" align="justify" valign="top">&nbsp;</td>
	</tr>
	<tr>
      <td align="left" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td align="left" valign="top"><input name="textfield52" value="<%=GENERO_CLASE_TEXTO_1%>" type="text" class="textarea1" size="35" readonly="readonly"/></td>
    </tr>
    <tr>
      <td align="left" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td align="left" valign="top"><input name="textfield58" value="<%=GENERO_CLASE_TEXTO_2%>" type="text" class="textarea1" size="35" readonly="readonly"/></td>
    </tr>
    <tr>
      <td align="left" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td align="justify" valign="top"><input name="textfield53" value="<%=COMPORTAMIENTO_DE_PAGO_TEXTO_1%>" type="text" class="textarea1" size="35" readonly="readonly"/></td>
    </tr>
    <tr>
      <td align="justify" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td align="justify" valign="top"><input name="textfield54" value="<%=COMPORTAMIENTO_DE_PAGO_TEXTO_2%>" type="text" class="textarea1" size="35" readonly="readonly"/></td>
    </tr>
    <tr>
      <td align="justify" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td align="justify" valign="top"><input name="textfield55" value="<%=ARRAIGO_TEXTO_1%>" type="text" class="textarea1" size="35" readonly="readonly"/></td>
    </tr>
    <tr>
      <td align="justify" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td align="justify" valign="top"><input name="textfield56" value="<%=ARRAIGO_TEXTO_2%>" type="text" class="textarea1" size="35" readonly="readonly"/></td>
    </tr>
    <tr>
      <td align="justify" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td align="justify" valign="top"><input name="textfield57" value="<%=ASPECTOS_TEXTO_1%>" type="text" class="textarea1" size="35" readonly="readonly"/></td>
    </tr>
    <tr>
      <td align="justify" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td align="justify" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td height="14" align="justify" valign="top">&nbsp;</td>
    </tr>
    <tr>
    <td height="14" colspan="8" valign="top" align="center">&nbsp;</td>
    </tr>
	<tr>
		<td colspan="8" align="left" valign="top" class="blackSmallText">
		<div align="right">
			<a 	href="golindex.jsp"
				onmouseout="MM_swapImgRestore()"
				onmouseover="MM_swapImage('salir', '', '../images/acceso/activo-blanco_salir.png', 1);">
				<img 	src="../images/acceso/inactivo-blanco_salir.png" name="salir"
						width="30" height="30" border="0" id="salir" />
			</a><br/>
			<span class="blueSubtitle">Salir</span>
		</div>
		</td>
	</tr>
</table>
<!-- InstanceEndEditable --></div>
<div id="pie_pag"></div>
</div>
</div>
</center>
</body>
<!-- InstanceEnd -->
</html>
