
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

   <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
   <title>Men&uacute; Principal</title>
   <!-- InstanceEndEditable -->
   <link href="css/main.css" rel="stylesheet" type="text/css" />
   <link href="css/textos.css" rel="stylesheet" type="text/css" />
   <script language="javascript" src="js/funciones.js"></script>
   <script language="javascript" src="js/catalogos.js"></script>
</head>

<body onload="document.getElementById('user').focus();msgLogin('');MM_preloadImages('images/activo_meta.png','images/activo_cliente.png','images/activo_riesgo.png','images/activo_comportamiento.png','images/activo_deuda.png','images/activo_utileria.png','images/activo_salir.png','images/activo_entrar.png','images/wizar_activo.png')">
<center>
<div id="contenedor">
<div id="encabezado">
<div id="borde_iz"></div>
<div id="logo"></div>
<div id="relleno">
<div id="login">
   <!-- InstanceBeginEditable name="edit1" -->
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
   <tr>
       <td height="32" class="whiteTitle" align="left">Registro de Usuario:</td>
   </tr>
   <tr>
       <td align="left" valign="bottom">
           <form id="form1" name="form1" method="post" action="Login">
               <input type="hidden" id="accion" name="accion" value=""/>
               <input id="user" name="user" type="text"
class="blackText2" size="18"
                    maxlength="20" onkeypress="enabledEnterKeyLogin(event);"/>
               <input id="pass" name="pass" type="password" class="blackText2"
                   maxlength="15"
                   onkeypress="enabledEnterKeyLogin(event);"/>
               <a href="#" onclick="loginUrbi();"
onmouseout="MM_swapImgRestore()"

onmouseover="MM_swapImage('entrar','','images/activo_entrar.png',1)">
                   <img src="images/inactivo_entrar.png"
name="entrar" width="114"
                   height="22" border="0" align="absbottom" id="entrar" />
               </a>
           </form>
       </td>
   </tr>
</table>
<!-- InstanceEndEditable -->
</div>
</div>
<div id="borde_der"></div>
<div id="centro">
<div id="botones">
<table width="825" height="34%" border="0" cellpadding="0" cellspacing="0">
   <tr>
       <td width="100" height="60">
           <div align="center">
               <a href="#" onmouseout="MM_swapImgRestore()"
onmouseover="MM_swapImage('cliente','','images/activo_cliente.png',1)">
                   <img src="images/inactivo_cliente.png"
name="cliente" width="59" height="60" border="0" id="cliente" />
               </a>
           </div>
       </td>
       <td width="100">
           <div align="center">
               <a href="#" onmouseout="MM_swapImgRestore()"
onmouseover="MM_swapImage('meta','','images/activo_meta.png',1)">
                   <img src="images/inactivo_meta.png" name="meta"
width="58" height="60" border="0" id="meta" />
               </a>
           </div>
       </td>
       <td width="99">
           <div align="center">
               <a href="#" onmouseout="MM_swapImgRestore()"
onmouseover="MM_swapImage('infonavit','','images/inactivo_infonavit.png',1)">
                   <img src="images/inactivo_infonavit.png"
name="infonavit" width="58" height="60" border="0" id="infonavit" />
               </a>
           </div>
       </td>
       <td width="99">
           <div align="center">
               <a href="#" onmouseout="MM_swapImgRestore()"
onmouseover="MM_swapImage('riesgo','','images/activo_riesgo.png',1)">
                   <img src="images/inactivo_riesgo.png"
name="riesgo" width="58" height="60" border="0" id="riesgo" />
               </a>
           </div>
       </td>
       <td width="105">
           <div align="center">
               <a href="#"
onmouseout="MM_swapImgRestore()"onmouseover="MM_swapImage('comportamiento','','images/activo_comportamiento.png',1)">
                   <img src="images/inactivo_comportamiento.png"
name="comportamiento" width="61" height="60" border="0"
id="comportamiento" />
               </a>
           </div>
       </td>
       <td width="115">
           <div align="center">
               <a href="#" onmouseout="MM_swapImgRestore()"
onmouseover="MM_swapImage('deuda','','images/activo_deuda.png',1)">
                   <img src="images/inactivo_deuda.png" name="deuda"
width="60" height="60" border="0" id="deuda" />
               </a>
           </div>
       </td>
       <td width="101">
               <div align="center">
                   <a href="#" onmouseout="MM_swapImgRestore()"
onmouseover="MM_swapImage('utilerias','','images/activo_utileria.png',1)">
                       <img src="images/inactivo_utileria.png"
name="utilerias" width="60" height="60" border="0" id="utilerias" />
                   </a>
               </div>
       </td>
       <td width="106">
           <div align="center">
               <a href="#"
onmouseout="MM_swapImgRestore()"onmouseover="MM_swapImage('wizard','','images/wizar_activo.png',1)">
                   <img src="images/wizar-inactivo.png" name="wizard"
width="59" height="60" border="0" id="wizard" />
               </a>
               <a href="#" onmouseout="MM_swapImgRestore()"
onmouseover="MM_swapImage('salir', '', 'images/activo_salir.png',
1);">

               </a>
           </div>
       </td>
   </tr>
   <tr height="35">
       <td>
           <div align="center" class="blueText">
               <a href="#" class="blueText">Cliente<br />Meta</a>
           </div>
       </td>
       <td>
           <div align="center">
               <p class="blueText">
                   <a href="#" class="blueText">Cliente<br />Gol</a>
               </p>
           </div>
       </td>
       <td>
           <div align="center" class="blueText">
               <a href="#" class="blueText">Infonavit</a>
               <br/>&nbsp;
           </div>
       </td>
       <td>
           <div align="center" class="blueText">
               <a href="#" class="blueText">Prima Pura<br />de Riesgo</a>
           </div>
       </td>
       <td>
           <div align="center" class="blueText">
               <a href="#" class="blueText">Behavior</a>
               <br/>&nbsp;
           </div>
       </td>
       <td>
           <div align="center" class="blueText">
               <p>
                   <a href="#" class="blueText">Nivel M&aacute;ximo
<br />de Endeudamiento</a>
               </p>
           </div>
       </td>
       <td>
           <div align="center" class="blueText">
               <p>
                   <a href="#" class="blueText">Utiler&iacute;as</a>
                   <br />&nbsp;
               </p>
           </div>
       </td>
       <td>
           <div align="center" class="blueText">
               <p>Wizard<br />
               &nbsp;
               </p>
           </div>
       </td>
   </tr>
</table>
</div>
</div>
</div>
</div>
</center>

</body>
<!-- InstanceEnd -->
</html>