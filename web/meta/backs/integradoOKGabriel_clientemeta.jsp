<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/plantilla3.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
     <%@page import="java.util.*" %>
     <%@page import="objetos.*" %>
     <%@page import="org.hibernate.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Cliente Meta</title>
<!-- InstanceEndEditable -->
<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script type="javascript" language="javascript" src="../js/funciones.js"></script>
<script type="javascript" language="javascript">

            function validate_form(thisform){
                //if (validate_required(instanceName)==false){
                if(false){
                    SetErrorMessage(1,"Hola Yandy, esto es un error");
                    return false;
                }
                return true;
            }

          function ejecutar(boton, thisform){
                var frm = document.forms[thisform];
                frm.elements["command"].value = boton;
                document.forms[thisform].submit();
	 }

          /*  function activarControles(estado)
            {
                MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_mod.png','../images/acceso/activos_sup.png','../images/acceso/activos_exit.png','../images/acceso/activos_guardar.png','../images/buscar_activo.png','../images/acceso/activos_buscar.png','../images/acceso/activos_salir.png','../images/acceso/inactivo-blanco_salir.png','../images/acceso/activos_left.png','../images/acceso/activos_right.png');
                var frm = document.forms["PrimaMant"];
                frm.elements["apellidoMaterno"].disabled = estado;
                frm.elements["apellidoPaterno"].disabled = estado;
                frm.elements["nombre"].disabled = estado;
                frm.elements["anno"].disabled = estado;
                frm.elements["mes"].disabled = estado;
                frm.elements["dia"].disabled = estado;
                frm.elements["calle"].disabled = estado;
                frm.elements["noExterior"].disabled = estado;
                frm.elements["noInterior"].disabled = estado;
                frm.elements["colonia"].disabled = estado;
                frm.elements["codigoPostal"].disabled = estado;
                frm.elements["estadoCivil"].disabled = estado;
                frm.elements["depEco"].disabled = estado;
                frm.elements["ingMen"].disabled = estado;
                frm.elements["tipoActividad"].disabled = estado;
                frm.elements["sector"].disabled = estado;
                frm.elements["subsector"].disabled = estado;
                frm.elements["descripcion"].disabled = estado;
                frm.elements["rol"].disabled = estado;
                frm.elements["estadoVivienda"].disabled = estado;
                frm.elements["desarrollo"].disabled = estado;
                frm.elements["valorVivienda"].disabled = estado;
                frm.elements["mensualidad"].disabled = estado;
            }

            function BorrarControles()
            {
                 if(confirm("Seguro de cancelar los Datos entrados."))
                     {
                        ResetearControles();
                        activarControles(true);
                     }

            }

            function ResetearControles()
            {
                var frm = document.forms["PrimaMant"];
                frm.elements["apellidoMaterno"].value = "";
                frm.elements["apellidoPaterno"].value = "";
                frm.elements["nombre"].value = "";
                frm.elements["anno"].selectedIndex = 0;
                frm.elements["mes"].selectedIndex = 0;
                frm.elements["dia"].selectedIndex = 0;
                frm.elements["calle"].value = "";
                frm.elements["noExterior"].value = "";
                frm.elements["noInterior"].value = "";
                frm.elements["colonia"].value = "";
                frm.elements["codigoPostal"].value = "";
                frm.elements["estadoCivil"].selectedIndex = 0;
                frm.elements["depEco"].selectedIndex = 0;
                frm.elements["ingMen"].selectedIndex = 0;
                frm.elements["tipoActividad"].selectedIndex = 0;
                frm.elements["sector"].selectedIndex = 0;
                frm.elements["subsector"].selectedIndex = 0;
                frm.elements["descripcion"].value = "";
                frm.elements["rol"].selectedIndex = 0;
                frm.elements["estadoVivienda"].selectedIndex = 0;
                frm.elements["desarrollo"].selectedIndex = 0;
                frm.elements["valorVivienda"].value = "";
                frm.elements["mensualidad"].value = "";
            }*/

            function nuevoAgregar()
            {
                activarControles(false);
                ResetearControles();
            }

        </script>
<!-- InstanceBeginEditable name="head" --><style type="text/css">
<!--
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
-->
</style><!-- InstanceEndEditable -->
<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
-->
</style></head>
 <% 
            String accion = (String)request.getSession().getAttribute("accion");
            String id = (String)request.getSession().getAttribute("idCliente");
            String load;
            if(accion.equals("Agregar") || accion.equals("Modificar"))
                load = "activarControles(true)";
            else
                load = "activarControles(false)";

  %>
<body onload="MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_mod.png','../images/acceso/activos_sup.png','../images/acceso/activos_exit.png','../images/acceso/activos_guardar.png','../images/buscar_activo.png','../images/acceso/activos_buscar.png','../images/acceso/activos_salir.png','../images/acceso/inactivo-blanco_salir.png','../images/acceso/activos_left.png','../images/acceso/activos_right.png','../images/accesos_down/aplicacion-2_41.png','../images/accesos_down/aplicacion-2_38.png','../images/accesos_down/aplicacion-2_36.png','../images/accesos_down/aplicacion-2_34.png','../images/accesos_down/aplicacion-2_32.png','../images/accesos_down/aplicacion-2_30.png','../images/accesos_down/aplicacion-2_28.png','../images/accesos_down/aplicacion-2_26.png','../images/accesos_down/aplicacion-2_24.png','../images/accesos_down/aplicacion-2_22.png')" >
<form name="ClienteMeta" method="post" action="../AgregarMetaServlet" onsubmit="return validate_form(this)">
    <center>
<div id="contenedor">
  <div id="encabezado">
    <div id="borde_iz"></div>
	<div id="logo">
	<div id="data"><!-- InstanceBeginEditable name="Region3" -->
	  <p class="bodystyle"/> <br/>
	    <input name="textfield3" type="text" class="bodystyle" size="15" />
            <input name="textfield4" type="text" class="bodystyle" value="persona No. 5" size="19" />
	  <!-- InstanceEndEditable -->	</div>
	</div>
	<div id="relleno">
	<div id="capa_enc">
	<!-- InstanceBeginEditable name="region1" -->	
	<table width="552" border="0" valign="right" cellpadding="0" cellspacing="0" class="textarea">
       <tr>
         <td colspan="18" align="center" class="blackSubtitle">&nbsp;</td>
       </tr>
       <tr>
         <td colspan="18" align="center" class="blueSubtitle">Cliente Meta</td>
       </tr>
       <tr>
         <td colspan="18" align="center" class="whiteSubtitle">Mantenimiento a Personas</td>
        </tr>
       <tr>
         <td colspan="18" align="center" class="whiteSubtitle">&nbsp;</td>
        </tr>
       <tr>
         <td width="39" align="center"><a onclick="nuevoAgregar()" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img src="../images/acceso/inactivos_add.png" name="add" width="33" height="33" border="0" class="button" id="add" /></a></td>
         <td width="10">&nbsp;</td>
         <td width="52" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('mod','','../images/acceso/activos_mod.png',1)"><img src="../images/acceso/inactivos_mod.png" name="mod" width="35" height="33" border="0" class="button" id="mod" /></a></td>
         <td width="10">&nbsp;</td>
         <td width="42" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('delete','','../images/acceso/activos_sup.png',1)"><img src="../images/acceso/inactivos_sup.png" name="delete" width="33" height="33" border="0" class="button" id="delete" /></a></td>
         <td width="10">&nbsp;</td>
         <td width="41" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"><img src="../images/acceso/inactivos_exit.png" name="exit" width="33" height="33" border="0" class="button" id="exit" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"></a></td>
         <td width="10">&nbsp;</td>
         <td width="39" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('guardar','','../images/acceso/activos_guardar.png',1)"><img src="../images/acceso/inactivos_guardar.png" name="guardar" width="34" height="33" border="0" class="button" id="guardar" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"></a></td>
         <td width="10">&nbsp;</td>
         <td width="34" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('buscar','','../images/buscar_activo.png',1)"></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('buscar','','../images/acceso/activos_buscar.png',1)"><img src="../images/acceso/inactivos_buscar.png" name="buscar" width="33" height="33" border="0" class="button" id="buscar" /></a></td>
         <td width="10">&nbsp;</td>
         <td width="35" align="center"><a href="metaindex.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('salir','','../images/acceso/activos_salir.png',1)"><img src="../images/acceso/inactivos_salir.png" name="salir" width="32" height="33" border="0" class="button" id="salir" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('salir','','../images/acceso/inactivo-blanco_salir.png',1)"></a></td>
         <td width="21">&nbsp;</td>
         <td width="34" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('left','','../images/acceso/activos_left.png',1)"><img src="../images/acceso/inactivos_left.png" name="left" width="34" height="33" border="0" class="button" id="left" /></a></td>
         <td width="41" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('right','','../images/acceso/activos_right.png',1)"><img src="../images/acceso/inactivos_right.png" name="right" width="34" height="33" border="0" class="button" id="right" /></a></td>
         <td width="15">&nbsp;</td>
         <td width="94" align="center"><a href="historiameta.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('next','','../images/acceso/activos_right.png',1)"><img src="../images/acceso/inactivos_right.png" name="next" width="34" height="33" border="0" class="button" id="next" /></a></td>
        </tr>
       <tr>
         <td height="19" class="whiteText"><div align="center">Agregar</div></td>
         <td class="whiteText"><div align="center"></div></td>
         <td class="whiteText"><div align="center">Modificar</div></td>
         <td class="whiteText"><div align="center"></div></td>
         <td class="whiteText"><div align="center">Eliminar</div></td>
         <td class="whiteText"><div align="center"></div></td>
         <td class="whiteText"><div align="center">Cancelar</div></td>
         <td class="whiteText"><div align="center"></div></td>
         <td class="whiteText"> <div align="center">Guardar</div></td>
         <td class="whiteText"><div align="center"></div></td>
         <td class="whiteText"><div align="center">Buscar</div></td>
         <td class="whiteText"><div align="center"></div></td>
         <td class="whiteText"><div align="center">Salir</div></td>
         <td class="whiteText"><div align="center"></div></td>
         <td colspan="2" class="whiteText" align="center">Registros</td>
         <td class="whiteText"><div align="center"></div></td>
         <td class="whiteText" align="center"><a href="clientemeta_2.html" class="whiteText">Siguiente </a></td>
        </tr>
     </table>
	 <!-- InstanceEndEditable -->
	</div>
	</div>	
	<div id="borde_der"></div>
	<div id="contenido">
	<!-- InstanceBeginEditable name="Region2" -->
	<table width="867" border="0" align="center" cellpadding="0" cellspacing="0">  
  <tr>
    <td colspan="19"><fieldset><legend class="blueSubtitle">Datos personales</legend>
          <table width="852" height="581" border="0" align="left" cellpadding="0" cellspacing="0">
            <tr>
              <td colspan="7">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="6" valign="top"><fieldset>
                <legend class="blackText1" style="font-weight:bold">Nombre</legend>
                <table width="468" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="149" align="left" class="blackText1">Apellido Paterno</td>
                    <td width="15">&nbsp;</td>
                    <td width="144" align="left" class="blackText1">Apellido Materno</td>
                    <td width="16">&nbsp;</td>
                    <td width="144" align="left" class="blackText1">Nombre</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><input type="text" name="apellidoPaterno" /></td>
                    <td class="blackText1">&nbsp;</td>
                    <td class="blackText1" align="left"><input type="text" name="apellidoMaterno" /></td>
                    <td class="blackText1">&nbsp;</td>
                    <td class="blackText1" align="left"><input type="text" name="Nombre" /></td>
                  </tr>
                </table>
              </fieldset></td>
              <td width="345" valign="top"><fieldset>
                <legend class="blackText1" style="font-weight:bold">Fecha de Nacimiento</legend>
                <table width="312" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td class="blackText1" align="left">A&ntilde;o</td>
                    <td class="blackText1" align="left">Mes</td>
                    <td class="blackText1" align="left">D&iacute;a</td>
                    <td class="blackText1" align="left">Edad</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><select name="anno">
                        <option>-A&ntilde;o-</option>
                      </select>
                    </td>
                    <td class="blackText1" align="left"><select name="mes">
                        <option>-Mes-</option>
                      </select>
                    </td>
                    <td class="blackText1" align="left"><select name="dia">
                        <option>-D&iacute;a-</option>
                      </select>
                    </td>
                    <td class="blackText1" align="left"><input name="edad" type="text" size="5" />
                    </td>
                  </tr>
                </table>
                </fieldset>
               </td>
            </tr>
            <tr>
              <td colspan="7"><fieldset>
                <legend class="blackText1" style="font-weight:bold">Domicilio</legend>
                <table width="854" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="153" align="left" class="blackText1">Calle</td>
                    <td width="71" align="left" class="blackText1">No.Exterior  </td>
                    <td width="10" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                    <td width="72" align="left" class="blackText1">No.Interior</td>
                    <td width="144" align="left" class="blackText1">Colonia</td>
                    <td colspan="2" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                    <td width="90" align="left" class="blackText1">C&oacute;digo Postal</td>
                    <td colspan="2" rowspan="2" align="left" class="blackText1">&nbsp;</td>
                    <td width="147" align="left" class="blackText1">Estado</td>
                    <td width="165" align="left" class="blackText1">Delegaci&oacute;n/ Municipio</td>
                  </tr>
                  <tr>
                    <td align="left" class="blackText1"><input type="text" name="calle" />
                    </td>
                    <td align="left" class="blackText1"><input name="noExterior" type="text" size="8" />
                    </td>
                    <td align="left" class="blackText1"><input name="noInterior" type="text" size="8" />
                    </td>
                    <td align="left" class="blackText1"><input name="colonia" type="text" />
                    </td>
                    <td align="left" class="blackText1"><input name="codigoPostal" type="text" size="15" />
                    </td>
                    <td align="left" class="blackText1"><input type="text" name="estado" />
                    </td>
                    <td align="left" class="blackText1"><input type="text" name="delegacionMunicipio" />
                    </td>
                  </tr>
                </table>
              </fieldset></td>
            </tr>
            <tr>
              <td colspan="7">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="7"><fieldset>
                <table width="824" border="0" cellspacing="0" cellpadding="0" align="left">
                  <tr>
                    <td width="149" class="blackText1" align="left">&iquest;Cu&aacute;l es su religi&oacute;n?</td>
                    <td width="101" class="blackText1" align="left">&iquest;Cu&aacute;l es su sexo? </td>
                    <td width="157" class="blackText1" align="left">&iquest;Cu&aacute;l es su estado civil? </td>
                    <td width="178" class="blackText1" align="left">&iquest;Hasta qu&eacute; grado estudi&oacute;?</td>
                    <td width="239" class="blackText1" align="left">La casa donde vive actualmente es:</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><select name="religion">
                        <option>-Seleccione-</option>
                        <%
                            Session s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            Iterator it = null;
                            Transaction tx = s.beginTransaction();
                            Query q = s.createQuery("from Rel as rel where rel.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                Rel r = (Rel) it.next();
                        %>
                        <option value="<%=r.getRelId()%>"><%=r.getRelDes()%></option>
                          <%}%>
                    </select></td>
                    <td class="blackText1" align="left"><select name="sex">
			<option>-Seleccione-</option>
                         <% 
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from Sex as sex where sex.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                Sex sex = (Sex) it.next();
                        %>
                        <option value="<%=sex.getSexId()%>"><%=sex.getSexDes()%></option>
                          <%}%>
                      </select>
                    </td>
                    <td class="blackText1" align="left"><select name="estadoCivil">
                        <option>-Seleccione-</option>
                        <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from EdoCvl as ec where ec.cal.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                EdoCvl ec = (EdoCvl) it.next();
                        %>
                        <option value="<%=ec.getEdoCvlId()%>"><%=ec.getEdoCvlDes()%></option>
                          <%}%>
                      </select>
                    </td>
                    <td class="blackText1" align="left"><select name="nEstdio">
                        <option>-Seleccione-</option>
                        <% 
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from NivEst as ne where ne.cal.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                NivEst ne = (NivEst) it.next();
                        %>
                        <option value="<%=ne.getNivEstId()%>"><%=ne.getNivEstDes()%></option>
                          <%}%>
                      </select>
                    </td>
                    <td class="blackText1" align="left"><select name="tipoRes">
                        <option>-Seleccione-</option>
                         <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from TipRes as tr where tr.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                TipRes tr = (TipRes) it.next();
                        %>
                        <option value="<%=tr.getTipResId()%>"><%=tr.getTipResDes()%></option>
                          <%}%>
                      </select>
                    </td>
                  </tr>
                </table>
              </fieldset></td>
            </tr>
            <tr>
              <td colspan="7">&nbsp;</td>
            </tr>
            <tr>
              <td width="147" height="383" valign="top"><fieldset>
                <legend class="blackText1" style="font-weight:bold">Arraigo</legend>
                <table border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                </table>
                <table width="145" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="133" class="blackText1" align="left">&iquest;Hace cu&aacute;nto habita<br />
                      en su vivienda actual?</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><input name="tiempoVivienda" type="text" size="8" />
                      &nbsp;A&ntilde;os </td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left">&iquest;Hace cu&aacute;nto labora <br />
                      en su empleo actual?</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><input name="tiempoEmpleo" type="text" size="8" />
                      &nbsp;A&ntilde;os </td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left">En los  &uacute;ltimos 5 a&ntilde;os<br />
                      ha vivido en </td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><select name="mov">
                        <option>-Seleccione-</option>
                          <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from Mov as mov where mov.cal.calId = '2'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                Mov mov = (Mov) it.next();
                        %>
                        <option value="<%=mov.getMovId()%>"><%=mov.getMovDes()%></option>
                          <%}%>
                      </select>
                    </td>
                  </tr>
                </table>
                </fieldset>
               </td>
              <td width="4" valign="top">&nbsp;</td>
              <td width="243" valign="top"><fieldset>
                <legend class="blackText1" style="font-weight:bold">Aspectos Diferenciadores</legend>
                <table border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                </table>
                <table width="240" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="240" class="blackText1" align="left">Si lo necesita,<br />
                      &iquest;a qui&eacute;n le solicita un pr&eacute;stamo?</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><select name="prestamo">
                        <option>-Seleccione-</option>
                         <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from Ptm as ptm where ptm.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                Ptm ptm = (Ptm) it.next();
                        %>
                        <option value="<%=ptm.getPtmId()%>"><%=ptm.getPtmDes()%></option>
                          <%}%>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left">&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left">De los  partidos pol&iacute;ticos, <br />
                      &iquest;cu&aacute;l cree que sea el mejor?</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><select name="mejorPartido">
                        <option>-Seleccione-</option>
                        <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from MejPar as mp where mp.cal = '2'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                MejPar mp = (MejPar) it.next();
                        %>
                        <option value="<%=mp.getMejParId()%>"><%=mp.getMejParDes()%></option>
                          <%}%>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left">&iquest;C&oacute;mo afecta su religi&oacute;n<br />
                      en su toma de decisiones?</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><select name="relAfe">
                        <option>-Seleccione-</option>
                           <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from RelAfe as ra where ra.calId = '2'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                RelAfe ra = (RelAfe) it.next();
                        %>
                        <option value="<%=ra.getRelAfeId()%>"><%=ra.getRelAfeDes()%></option>
                          <%}%>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left">&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left">&iquest;Qu&eacute; opina de las asociaciones <br />
                      que apoyan a deudores?</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><select name="opinionApoDe">
                        <option>-Seleccione-</option>
                        <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from OpnBar as ob where ob.cal.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                OpnBar ob = (OpnBar) it.next();
                        %>
                        <option value="<%=ob.getOpnBarId()%>"><%=ob.getOpnBarDes()%></option>
                          <%}%>
                    </select></td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left">Mayor credibilidad,<br />
                      &iquest;partidos pol&iacute;ticos o asociaciones?</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><select name="partAsoc">
                        <option>-Seleccione-</option>
                        <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from ParAso as pa where pa.calId = '2'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                ParAso pa = (ParAso) it.next();
                        %>
                        <option value="<%=pa.getParAsoId()%>"><%=pa.getParAsoDes()%></option>
                          <%}%>
                      </select>
                    </td>
                  </tr>
                </table>
                </fieldset>
               </td>
              <td width="4" valign="top">&nbsp;</td>
              <td colspan="3" valign="top"><fieldset>
                <legend class="blackText1" style="font-weight:bold">Comportamiento de Pago</legend>
                <table border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                </table>
                <table width="436" height="350" border="0" align="left" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="199" height="36" align="left" valign="top" class="blackText1">&iquest;Cu&aacute;ntas personas son sus <br />
                      dependientes econ&oacute;micos?</td>
                    <td width="237" rowspan="14" valign="top"><table width="233" height="181" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="233" valign="top"><fieldset>
                            <table width="239" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="170" align="left" class="blackText1"><div align="right">&iquest;Cuenta con 
                                  tarjeta de cr&eacute;dito
                                  o cr&eacute;dito comercial?</div></td>
                                <td width="60" valign="middle" class="blackText1" align="right"><table width="51" border="0" align="right" cellpadding="0" cellspacing="0">
                                    <tr>
                                      <td align="left"><label>
                                        <input name="radiobutton1" type="radio" value="radiobutton" />
                                        Si <br/>
                                        <input name="radiobutton1" type="radio" value="radiobutton" />
                                        No</label></td>
                                    </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td class="blackText1" align="left"><div align="right">&iquest;Tiene alg&uacute;n<br />
                                  mes vencido?</div></td>
                                <td valign="middle" class="blackText1" align="left"><div align="right">
                                    <select name="mesVencido">
                                      <option selected="selected"></option>
                                       <%
                                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                            it = null;
                                            tx = s.beginTransaction();
                                            q = s.createQuery("from BanCmp as bc where bc.cal.calId = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BanCmp bc = (BanCmp) it.next();
                                        %>
                                        <option value="<%=bc.getBanCmpId()%>"><%=bc.getBanCmpDes()%></option>
                                          <%}%>
                                    </select>
                                </div></td>
                              </tr>
                              <tr>
                                <td class="blackText1">&nbsp;</td>
                                <td class="blackText1">&nbsp;</td>
                              </tr>
                              <tr>
                                <td class="blackText1"><div align="center">% de uso:</div></td>
                                <td class="blackText1">% de pago:</td>
                              </tr>
                              <tr>
                                <td class="blackText1" align="center"><select name="pcuso">
                                    <option>-%-</option>
                                     <%
                                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                            it = null;
                                            tx = s.beginTransaction();
                                            q = s.createQuery("from BanPorUso as bp where bp.cal.calId = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BanPorUso bp = (BanPorUso) it.next();
                                        %>
                                        <option value="<%=bp.getBanPorUsoId()%>"><%=bp.getBanPorUsoDes()%></option>
                                          <%}%>
                                </select></td>
                                <td class="blackText1" align="left"><select name="pcPago">
                                    <option>-%-</option>
                                    <%
                                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                            it = null;
                                            tx = s.beginTransaction();
                                            q = s.createQuery("from BanPorPag as bpp where bpp.cal.calId = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BanPorPag bpp = (BanPorPag) it.next();
                                        %>
                                        <option value="<%=bpp.getBanPorPagId()%>"><%=bpp.getBanPorPagDes()%></option>
                                          <%}%>
                                  </select>
                                </td>
                              </tr>
                              <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                              </tr>
                            </table>
                            </fieldset>
                           </td>
                        </tr>
                        <tr>
                          <td valign="top"><fieldset>
                            <table width="245" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td colspan="2" align="left" valign="top" class="blackText1"><div align="right">En su historial crediticio,<br />
                                  &iquest;sabe si ha existido problema con
                                  el bur&oacute; de cr&eacute;dito?</div></td>
                                <td width="51" align="left" valign="middle"class="blackText1" ><table width="51" border="0" align="right" cellpadding="0" cellspacing="0">
                                    <tr>
                                      <td><input name="problemaB" type="radio" value="si" />
                                          <label>Si</label>
                                          <br/>
                                          <input name="problemaB" type="radio" value="no" />
                                          <label>No</label></td>
                                    </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td colspan="3">&nbsp;</td>
                              </tr>
                              <tr>
                                <td width="76" align="left" valign="middle" class="blackText1"><label>Act:</label>
                                    <select name="buroAct">
                                        <%
                                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                            it = null;
                                            tx = s.beginTransaction();
                                            q = s.createQuery("from BurAct as ba where ba.cal = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BurAct ba = (BurAct) it.next();
                                        %>
                                        <option value="<%=ba.getBurActId()%>"><%=ba.getBurActDes()%></option>
                                          <%}%>
                                    </select>
                                </td>
                                <td colspan="2" class="blackText1" align="left" valign="middle"><label>% de uso:</label>
                                    <select name="buroUso">
                                      <option>-%-</option>
                                      <%
                                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                            it = null;
                                            tx = s.beginTransaction();
                                            q = s.createQuery("from BurUso as bu where bu.cal = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BurUso bu = (BurUso) it.next();
                                        %>
                                        <option value="<%=bu.getBurUsoId()%>"><%=bu.getBurUsoDes()%></option>
                                          <%}%>
                                    </select>
                                </td>
                              </tr>
                              <tr>
                                <td colspan="3">&nbsp;</td>
                              </tr>
                              <tr>
                                <td class="blackText1" align="left" valign="middle"><label>Hist:</label>
                                    <select name="buroHist">
                                        <%
                                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                            it = null;
                                            tx = s.beginTransaction();
                                            q = s.createQuery("from BurHis as bh where bh.cal.calId = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BurHis bh = (BurHis) it.next();
                                        %>
                                        <option value="<%=bh.getBurHisId()%>"><%=bh.getBurHisDes()%></option>
                                          <%}%>
                                    </select>
                                </td>
                                <td colspan="2" class="blackText1" align="left" valign="middle"><label>% de pago:</label>
                                    <select name="buroPago">
                                      <option>-%-</option>
                                      <%
                                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                            it = null;
                                            tx = s.beginTransaction();
                                            q = s.createQuery("from BurPag as bp where bp.cal = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BurPag bp = (BurPag) it.next();
                                        %>
                                        <option value="<%=bp.getBurPagId()%>"><%=bp.getBurPagDes()%></option>
                                          <%}%>
                                  </select></td>
                              </tr>
                              <tr>
                                <td class="blackText1" align="center" valign="middle">&nbsp;</td>
                              </tr>
                              <tr>
                                <td class="blackText1" align="left" valign="middle"><label>Ant:</label>
                                    <select name="buroAnt">
                                        <%
                                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                                            it = null;
                                            tx = s.beginTransaction();
                                            q = s.createQuery("from BurAnt as ba where ba.cal = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BurAnt ba = (BurAnt) it.next();
                                        %>
                                        <option value="<%=ba.getBurAntId()%>"><%=ba.getBurAntDes()%></option>
                                          <%}%>
                                    </select>
                                </td>
                              </tr>
                              <tr>
                                <td></td>
                              </tr>
                            </table>
                          </fieldset></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left" valign="top"><select name="dependenciaEco">
                        <option>-Seleccione-</option>
                        <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from DepEco as de where de.cal = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                DepEco de = (DepEco) it.next();
                        %>
                        <option value="<%=de.getDepEcoId()%>"><%=de.getDepEcoDes()%></option>
                          <%}%>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left" valign="top">&iquest;Tiene alguna actividad <br />
                      adicional remunerada?</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left" valign="top"><select name="actividadExt">
                        <option>-Seleccione-</option>
                             <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from ActExt as ae where ae.cal = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                ActExt ae = (ActExt) it.next();
                        %>
                        <option value="<%=ae.getActExtId()%>"><%=ae.getActExtDes()%></option>
                          <%}%>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left" valign="top">&iquest;Qu&eacute; har&iacute;a si tuviera <br/>
                      dinero extra?</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left" valign="top"><select name="DineroExt">
                        <option>-Seleccione-</option>
                         <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from DinExt as de where de.cal = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                DinExt de = (DinExt) it.next();
                        %>
                        <option value="<%=de.getDinExtId()%>"><%=de.getDinExtDes()%></option>
                          <%}%>
                    </select></td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left" valign="top">&iquest;Qu&eacute; gasto  importante tiene <br />
                      planeado para el pr&oacute;ximo a&ntilde;o?</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left" valign="top"><select name="gastoImp">
                        <option>-Seleccione-</option>
                         <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from GtoImp as gi where gi.cal = '5'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                GtoImp gi = (GtoImp) it.next();
                        %>
                        <option value="<%=gi.getGtoImpId()%>"><%=gi.getGtoImpDes()%></option>
                          <%}%>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left" valign="top">&iquest;A cu&aacute;nto asciende<br />
                      su ingreso mensual?</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left" valign="top"><select name="ingMens">
                        <option>-Seleccione-</option>
                         <%
                            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
                            it = null;
                            tx = s.beginTransaction();
                            q = s.createQuery("from Ing as ing where ing.cal = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                Ing ing = (Ing) it.next();
                        %>
                        <option value="<%=ing.getIngId()%>"><%=ing.getIngDes()%></option>
                          <%}%>
                      </select>
                    </td>
                  </tr>
                </table>
              </fieldset>
               </td>
            </tr>
            <tr>
              <td colspan="2" align="left" valign="top" class="blackText1"></td>
              <td valign="top"></td>
              <td valign="top"></td>
              <td width="108" class="blackText1" align="left" valign="top"></td>
              <td width="1" align="left" valign="top" class="blackText1"></td>
            </tr>
            <tr>
              <td height="2" colspan="7"></td>
            </tr>
          </table>
          <p>&nbsp;</p>
    </fieldset></td>
    </tr>
  
  <tr>
    <td width="325">&nbsp;</td>
    <td width="42" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image20','','../images/accesos_down/aplicacion-2_22.png',1)"><img src="../images/accesos_down/aplicacion-23_22.png" name="Image20" width="32" height="32" border="0" id="Image20" /></a></td>
    <td width="8">&nbsp;</td>
    <td width="51" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image19','','../images/accesos_down/aplicacion-2_24.png',1)"><img src="../images/accesos_down/aplicacion-23_24.png" name="Image19" width="32" height="32" border="0" id="Image19" /></a></td>
    <td width="8">&nbsp;</td>
    <td width="47" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image18','','../images/accesos_down/aplicacion-2_26.png',1)"><img src="../images/accesos_down/aplicacion-23_26.png" name="Image18" width="31" height="32" border="0" id="Image18" /></a></td>
    <td width="8">&nbsp;</td>
    <td width="48" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image17','','../images/accesos_down/aplicacion-2_28.png',1)"><img src="../images/accesos_down/aplicacion-23_28.png" name="Image17" width="33" height="32" border="0" id="Image17" /></a></td>
    <td width="9">&nbsp;</td>
    <td width="44" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image16','','../images/accesos_down/aplicacion-2_30.png',1)"><img src="../images/accesos_down/aplicacion-23_30.png" name="Image16" width="33" height="32" border="0" id="Image16" /></a></td>
    <td width="8">&nbsp;</td>
    <td width="36" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image15','','../images/accesos_down/aplicacion-2_32.png',1)"><img src="../images/accesos_down/aplicacion-23_32.png" name="Image15" width="33" height="32" border="0" id="Image15" /></a></td>
    <td width="10">&nbsp;</td>
    <td width="35" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('salir2','','../images/accesos_down/aplicacion-2_34.png',1)"><img src="../images/accesos_down/aplicacion-23_34.png" name="salir2" width="32" height="32" border="0" id="salir2" /></a></td>
    <td width="20">&nbsp;</td>
    <td width="35"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('izq','','../images/accesos_down/aplicacion-2_36.png',1)"><img src="../images/accesos_down/aplicacion-23_36.png" name="izq" width="32" height="32" border="0" id="izq" /></a></td>
    <td width="41"><div align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('derecha','','../images/accesos_down/aplicacion-2_38.png',1)"><img src="../images/accesos_down/aplicacion-23_38.png" name="derecha" width="32" height="32" border="0" id="derecha" /></a></div></td>
    <td width="15">&nbsp;</td>
    <td width="77" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('siguiente','','../images/accesos_down/aplicacion-2_41.png',1)"><img src="../images/accesos_down/aplicacion-23_41.png" name="siguiente" width="31" height="32" border="0" id="siguiente" /></a></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="center" class="blueText">Agregar</td>
    <td>&nbsp;</td>
    <td align="center" class="blueText">Modificar</td>
    <td>&nbsp;</td>
    <td align="center" class="blueText">Eliminar</td>
    <td>&nbsp;</td>
    <td align="center" class="blueText">Cancelar</td>
    <td>&nbsp;</td>
    <td align="center" class="blueText">Guardar</td>
    <td>&nbsp;</td>
    <td align="center" class="blueText">Buscar</td>
    <td>&nbsp;</td>
    <td align="center" class="blueText">Salir</td>
    <td>&nbsp;</td>
    <td colspan="2" class="blueText" align="center">Registros</td>
    <td>&nbsp;</td>
    <td align="center" class="blueText">Siguiente</td>
  </tr>
  <tr>
    <td colspan="19">&nbsp;</td>
  </tr>
</table>
	<!-- InstanceEndEditable -->    
	</div>
	<div id="pie_pag"></div>
</div>
</div>
</center>
    </form>
</body>
<!-- InstanceEnd --></html>
