<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/plantilla2.dwt" codeOutsideHTMLIsLocked="false" -->
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

%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Nivel M&aacute;ximo de Endeudamiento</title>
<!-- InstanceEndEditable -->
<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/funciones.js"></script>
<!-- InstanceBeginEditable name="head" -->
<script type="text/JavaScript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>
<!-- InstanceEndEditable -->
</head>
<body onload="MM_preloadImages('../images/acceso/activos_exit.png')" >
<center>
<div id="contenedor">
  <div id="encabezado">
    <div id="borde_iz"></div>
	<div id="logo"></div>
	<div id="relleno">
	<div id="capa_enc">
	<!-- InstanceBeginEditable name="region1" -->	
	<table width="321" border="0" valign="right" cellpadding="0" cellspacing="0" class="whiteSubtitle">
       <tr>
         <td colspan="9" align="center" class="blueSubtitle">&nbsp;</td>
       </tr>
       <tr>
         <td colspan="9" align="center" class="blueSubtitle">Comportamiento y Gesti&oacute;n</td>
        </tr>
       <tr>
         <td colspan="9">&nbsp;</td>
        </tr>
       <tr>
         <td colspan="10">&nbsp;</td>
       </tr>
       <tr>
         <td width="42" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"></a></td>
         <td width="10">&nbsp;</td>
         <td width="42" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('delete','','../images/acceso/activos_sup.png',1)"></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('mod','','../images/acceso/activos_mod.png',1)"></a></td>
         <td width="10">&nbsp;</td>
         <td width="42" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('delete','','../images/acceso/activos_sup.png',1)"></a></td>
         <td width="10">&nbsp;</td>
         <td width="42" align="center"></td>
         <td width="10">&nbsp;</td>
         <td width="42" align="center"><a href="../index_autent.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"><img src="../images/acceso/inactivos_exit.png" name="exit" width="33" height="33" border="0" class="blueText" id="exit" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"></a></td>
       </tr>
       <tr>
         <td class="whiteText" align="center">&nbsp;</td>
         <td class="whiteTitle"></td>
         <td class="whiteText" align="center">&nbsp;</td>
         <td class="whiteTitle"></td>
         <td class="whiteText" align="center">&nbsp;</td>
         <td class="whiteTitle"></td>
         <td class="whiteText" align="center">&nbsp;</td>
         <td class="whiteTitle"></td>
         <td class="whiteText" align="center">Salir</td>
       </tr>
     </table>
	 <p><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('calc','','../images/acceso/activo-cal.png',1)"></a><!-- InstanceEndEditable -->
	</div>
	</div>	
	<div id="borde_der"></div>
	<div id="contenido">
	<!-- InstanceBeginEditable name="Region2" -->
	<p>    
	<p>
	
	<table width="828" border="0" align="center" cellpadding="0" cellspacing="0">
      
      <tr>
        <td width="36" align="left" valign="top">&nbsp;</td>
        <td colspan="2" rowspan="2" align="left" valign="top" class="blackText1"><table width="792" height="80" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="10" colspan="3" valign="top" align="left" class="blackText1">        </tr>
          <tr>
           <td width="831" align="center" valign="top"><fieldset class="blackTitle">
             Archivos
           </fieldset> </td>
      </tr>
          <tr>
            <td height="20" colspan="2" valign="top" align="center" class="blackText1"><fieldset>
            <table width="746" border="0" cellpadding="0" cellspacing="0" bordercolor="#000000">
              
              <tr>
                <td width="131" align="center" valign="top" bgcolor="#0B3BA2" class="whiteTitle">Nombre del archivo </td>
                <td width="151" align="center" valign="top" bgcolor="#0B3BA2" class="whiteTitle">Fecha</td>
                <td width="149" align="center" valign="top" bgcolor="#0B3BA2" class="whiteTitle">Extensi&oacute;n</td>
                <td width="149" align="center" valign="top" bgcolor="#FBFBFB" class="whiteTitle">&nbsp;</td>
              </tr>
              <tr>
                <td class="blackText1" align="center" valign="top">juan_23_02_03</td>
                <td class="blackText1" align="center" valign="top">26_03_10</td>
                <td class="blackText1" align="center" valign="top">.zip</td>
                <td align="center" valign="top" class="blackText1"><strong>Descargar</strong></td>
              </tr>
              <tr>
                <td class="blackText1" align="center" valign="top">juan_23_02_03</td>
                <td class="blackText1" align="center" valign="top">26_03_10</td>
                <td class="blackText1" align="center" valign="top">.zip</td>
                <td align="center" valign="top" class="blackText1"><strong>Descargar</strong></td>
              </tr>
              <tr>
                <td bgcolor="#FBFBFB" class="whiteTitle" align="center" valign="top">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table>
              </fieldset></td>
            <td width="24" height="20" align="left" valign="top" class="blackText1">&nbsp;</td>
          </tr>
        </table>        </td>
      </tr>
      <tr>
        <td width="36" align="left" valign="top">&nbsp;</td>
      </tr>
      
      <tr>
        <td width="36" align="left" valign="top">&nbsp;</td>
        <td width="12" align="left" valign="top" class="blackText1">&nbsp;</td>
        <td width="780" height="10" align="left" valign="middle" class="blackText1">&nbsp;</td>
      </tr>
    </table>
	</p>
	<!-- InstanceEndEditable -->    
	</div>
	<div id="pie_pag"></div>
</div>
</div>
</center>
</body>
<!-- InstanceEnd --></html>
