 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml">
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
<head>
     <jsp:include page="JSIncludeClienteMeta.jsp" />
         <%@page import="java.util.*" %>
     <%@page import="objetos.*" %>
     <%@page import="org.hibernate.*" %>
     <%@page import="java.math.BigDecimal" %>
     <%@page import="com.urbi.util.HibernateUtil2" %>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Cliente Meta</title>

<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script type="javascript" language="javascript" src="../js/funciones.js"></script>

<script type="text/javascript" language="javascript" src="../js/srv.js"></script>
<script type="text/javascript" language="javascript" src="../js/jquery-1.4.2.js"></script>

<script type="text/javascript" language="javascript">

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

            function nuevoAgregar()
            {
                activarControles(false);
                ResetearControles();
            }

            function guardar(){
                //alert("Los datos han sido guardados exitosamente!");
                document.forms[1].submit();
            }

            function validaCampos(){
                forma=document.forms[1];

                if(forma.subSector.selectedIndex == -1 || forma.subSector[forma.subSector.selectedIndex].value =="-Seleccione-"){

                       //alert(forma.subSector[forma.subSector.selectedIndex].value );
                    if(forma.tipoActividad[forma.tipoActividad.selectedIndex].value != 0 || forma.tipoActividad[forma.tipoActividad.selectedIndex].value != "-Seleccione-"){
                        if(forma.tipoActividad[forma.tipoActividad.selectedIndex].value != 3){

                           if(forma.tipoActividad[forma.tipoActividad.selectedIndex].value != 4){
                               return alert("Se debe concluir la selección de valores para el campo Ocupación Principal.");
                           }

                        }

                    }else{
                        return alert("Se debe concluir la selección de valores para el campo Ocupación Principal.");
                    }

                }

                if(forma.rol[forma.rol.selectedIndex].value == 0){

                    return alert("El campo rol no puede quedar vacio");
                }

                if(forma.estado[forma.estado.selectedIndex].value == 0){

                    return alert("El campo estado no puede quedar vacio");
                }

                if(forma.desarrollo[forma.desarrollo.selectedIndex].value == 0){

                    return alert("El campo desarrollo no puede quedar vacio");
                }

                if(forma.valorVivienda.value == ""){

                    return alert("El campo valor vivienda no puede quedar vacio");
                }

                if(forma.valorViviendaMen.value == ""){

                    return alert("El campo valor mensual vivienda no puede quedar vacio");
                }

                guardar();

            }

            function cargaDesarrollos(){

                valor=document.guardaClienteMeta2.estado[document.guardaClienteMeta2.estado.selectedIndex].value;
                Proxy.obtenerDesarollos(valor,function(data){
                    dwr.util.removeAllOptions("desarrollo");
                    dwr.util.addOptions("desarrollo", ["-Seleccione-"]);
                    dwr.util.addOptions("desarrollo",data,"desId","desDes");
                });
            }

            function validarValorVivienda(obj){
                try{
                var valorMayor=parseFloat(3000000);
                var valorMenor= parseFloat(50000);
                if(parseFloat(obj.value)>valorMayor || parseFloat(obj.value)<valorMenor){
                   alert("El valor de la vivienda no puede ser Mayor a $ 3,000,000.00 o menor a $50,000");
                   //obj.focus();
                }
                } catch (e){

                }

            }

            function validarValorMensualidad(obj){

                try{
                var valorMayor=parseFloat(50000);
                var valorMenor= parseFloat(500);
                if(parseFloat(obj.value)>valorMayor || parseFloat(obj.value)<valorMenor){
                    alert("El valor de la mensualidad no puede ser Mayor a $ 50,000.00 o menor a $500.00");
                    //obj.focus();
                }
                } catch (e){

                }

            }




        </script>
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
</style>
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
</style>
</head>
    <%
            String accion =""; //(String)request.getSession().getAttribute("accion");
            CliMta2 oldCliMta = (CliMta2)request.getSession().getAttribute("clienteMetaOld");
            //System.out.println("ocp viejo: "+ oldCliMta.getOcpId());
            request.getSession().removeAttribute("clienteMetaOld");
            String id = null;//((Integer)request.getSession().getAttribute("idCliente")).toString();
            String load;
            CliMta2 cliMta =null;
            if(accion.equals("Agregar") || accion.equals("Modificar"))
                load = "activarControles(true)";
            else
                load = "activarControles(false)";

            if(request.getSession().getAttribute("idCliMta") != null){
                int idCliente = ((Integer)request.getSession().getAttribute("idCliMta")).intValue();
                request.getSession().removeAttribute("idCliMta");
                 Session ses = null;
              //  Transaction t = null;
                try{

                    ses = HibernateUtil2.currentSession();
                   // t = ses.beginTransaction();
                    cliMta = (CliMta2) ses.createQuery("from CliMta2 mta where mta.cliMta2Id=" + idCliente).uniqueResult();

                    System.out.println("cliente meta: " + cliMta.getCliMta2Id());
               }catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    HibernateUtil2.closeSession();
                }

            }

  %>
<body onload="MM_preloadImages('../images/acceso/activos_guardar.png','../images/acceso/activos_exit.png','../images/acceso/activos_salir.png','../images/acceso/inactivo-blanco_salir.png','../images/acceso/activos_left.png')" >

        <form name="ClienteMeta2" method="post" action="../MetaClienteServlet" >
            <input type="hidden" name="command" value=""></input>
            <input type="hidden" name="form" value="ClienteMeta2"></input>
	</form>
    <form name="guardaClienteMeta2" method="post" target="_self" onsubmit="return AIM.submit(this, {'onStart' : startCallback, 'onComplete' : completeCallback})" action = "../AgregarMetaServlet">
            <input type="hidden" name="accion" value="<%=accion%>"/>
            <input type="hidden" name="pantalla" value="pantalla2"></input>
            <input type="hidden" name="idCliente" value="<%=id%>"/>
<center>
<div id="contenedor">
  <div id="encabezado">
    <div id="borde_iz"></div>
	<div id="logo">
	<div id="data">
            <p class="bodystyle"></p>
	        <!--form id="form1" name="form1" method="post" action=""-->
	        <input name="textfield3" type="text" class="bodystyle" size="15" />
            <input name="textfield4" type="text" class="bodystyle" value="Persona No.6" size="19" />
	        <!--/form-->
	  	</div>
	</div>
	<div id="relleno">
	<div id="capa_enc">

	  <table width="552" border="0" valign="right" cellpadding="0" cellspacing="0" class="textarea">
	    <tr>
	      <td colspan="8" align="center" class="blackSubtitle">&nbsp;</td>
         </tr>
	    <tr>
	      <td colspan="8" align="center" class="blueSubtitle">Cliente Meta</td>
         </tr>
	    <tr>
	      <td colspan="8" align="center" class="whiteSubtitle">Mantenimiento a Personas</td>
          </tr>
	    <tr>
	      <td colspan="8" align="center" class="whiteSubtitle">&nbsp;</td>
          </tr>
	    <tr>
	      <td width="299" rowspan="2" align="center"><div align="center"></div>
             <div align="center"></div>
             <div align="center"></div>
            <div align="center"></div>           <div align="center"></div></td>
                <td width="39" align="center"><a href="javascript:validaCampos();" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('guardar','','../images/acceso/activos_guardar.png',1)"><img src="../images/acceso/inactivos_guardar.png" name="guardar" width="34" height="33" border="0" class="button" id="guardar" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"></a></td>
           <td width="12" align="center">&nbsp;</td>
           <td width="41" align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('buscar','','../images/buscar_activo.png',1)"></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"><img src="../images/acceso/inactivos_exit.png" name="exit" width="33" height="33" border="0" class="button" id="exit" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('buscar','','../images/acceso/activos_buscar.png',1)"></a></td>
           <td width="12" align="center">&nbsp;</td>
           <td width="35" align="center"><a onclick="ejecutar('Salir','ClienteMeta2')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('salir','','../images/acceso/activos_salir.png',1)"><img src="../images/acceso/inactivos_salir.png" name="salir" width="32" height="33" border="0" class="button" id="salir" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('salir','','../images/acceso/inactivo-blanco_salir.png',1)"></a></td>
           <td width="27">&nbsp;</td>
           <td width="88" align="center"><div align="center"><a href="javascript:history.back();" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('left1','','../images/acceso/activos_left.png',1)"><img src="../images/acceso/inactivos_left.png" name="left1" width="34" height="33" border="0" class="button" id="left1" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('next','','../images/acceso/activos_right.png',1)"></a></div></td>
          </tr>
	    <tr>
	      <td height="19" class="whiteText"><div align="center">Guardar</div></td>
           <td class="whiteText">&nbsp;</td>
           <td class="whiteText"><div align="center">Cancelar</div></td>
           <td class="whiteText">&nbsp;</td>
           <td class="whiteText"><div align="center">Salir</div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center">Anterior</div></td>
          </tr>
	     </table>
	</div>
	</div>
	<div id="borde_der"></div>
	<div id="contenido">
	  <table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
	    <tr>
	      <td colspan="19"><fieldset><legend class="blueSubtitle">Datos personales</legend>
            <table width="885" height="237" border="0" align="left" cellpadding="0" cellspacing="5">
              <tr>
                <td colspan="7">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="4" valign="top">
								<fieldset>
                  <legend class="blackText1" style="font-weight:bold">Ocupación Principal</legend>
                  <table width="450" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="200" height="18" align="left" class="blackText1">Tipo de actividad </td>
                      <td width="20" rowspan="8">&nbsp;</td>
                      <td width="200" align="left" class="blackText1">Descripci&oacute;n de la ocupaci&oacute;n</td>
											<td width="20" rowspan="8">&nbsp;</td>
                    </tr>
                    <tr>
                        <td height="18" align="left" class="blackText1"><select name="tipoActividad" id="tipoActividad" onchange="filtrarSector(this)" class="anchoEstandardSelect">
                        >
                                <option value="0">-Seleccione-</option>
                        <%
                        Session s = null;
                            Iterator it = null;
                            //Transaction tx = null;
                            Query q = null;
                            BigDecimal tipEmpId=null;
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                           // tx = s.beginTransaction();

                            q = s.createQuery("from TipEmp as tip where tip.calId=6");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                TipEmp emp = (TipEmp) it.next();
                                if(oldCliMta != null){
                                    System.out.println("si hya cliente se busca el inicial");
                                    TipEmp tmp = (TipEmp) s.createQuery("from TipEmp as te, Srv as s, Ocp as o where te.calId=6 " +
                                        "and s.tipEmpId=te.tipEmpId and o.srvId=s.srvId and o.ocpId=" + oldCliMta.getOcpId()).uniqueResult();

                                    tipEmpId=tmp.getTipEmpId();
                                    
                                    System.out.println("tipEmp guardado: " + tipEmpId +" tipEmp del ciclo: " + emp.getTipEmpId());
                                    if(tipEmpId != null){
                                        if(emp.getTipEmpId().intValue() == tipEmpId.intValue()){
                        %>

                        <option value="<%=emp.getTipEmpId()%>" selected><%=emp.getTipEmpDes()%></option>
                        <%}else{%>
                        <option value="<%=emp.getTipEmpId()%>"><%=emp.getTipEmpDes()%></option>

                        <%}}else{%>
                        <option value="<%=emp.getTipEmpId()%>"><%=emp.getTipEmpDes()%></option>
                        <%}}else{%>
                        <option value="<%=emp.getTipEmpId()%>"><%=emp.getTipEmpDes()%></option>
                        <%}}}catch(Exception ex){
                            ex.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                                              </select>                      </td>

                      <td rowspan="4" align="left" class="blackText1" valign="top">
                        <textarea name="textfield" cols="30" rows="6"></textarea>
											</td>
                    </tr>

                    <tr>
                      <td height="18" align="left" class="blackText1">Sector</td>
                    </tr>
                    <tr>
                        <td height="18" align="left" valign="middle" class="blackText1"><select name="sector" id="sector" onchange="filtrarSector(this)" class="anchoEstandardSelect">
                                <option value="0">-Seleccione-</option>

                      </select>
											</td>
                    </tr>
                    <tr>
                      <td height="18" align="left" class="blackText1">Subsector</td>
                    </tr>
                    <tr>
                      <td height="18" align="left" class="blackText1"><select name="subSector" id="subSector" class="anchoEstandardSelect">
                              <option value="0">-Seleccione-</option>

                      </select></td>
                      </tr>
                    <tr>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1" valign="top">En el trabajo que desempe&ntilde;a,<br/>
&iquest;cu&aacute;l es su rol en la organizaci&oacute;n? </td>
                    </tr>
                    <tr>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"><select name="rol" id="rol">
                              <option value="0">-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                           // tx = s.beginTransaction();
                            q = s.createQuery("from Rol as r where r.calId=2");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                Rol r = (Rol) it.next();
                                if(oldCliMta != null){
                                    if(r.getRolId().intValue() == oldCliMta.getRolId()){
                        %>
                        <option title="<%=r.getRolDes()%>" value="<%=r.getRolId()%>" selected><%=r.getRolDes()%></option>
                        <%}else{%>
                        <option  title="<%=r.getRolDes()%>" value="<%=r.getRolId()%>"><%=r.getRolDes()%></option>
                        <%}}else{%>
                        <option  title="<%=r.getRolDes()%>" value="<%=r.getRolId()%>"><%=r.getRolDes()%></option>
                        <%}}}catch(Exception ex){
                            ex.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                      </select></td>
                    </tr>
                    </table>
                </fieldset></td>
                <td valign="top">
				<table width="270" height="174" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>&nbsp;</td>
						</tr>

                  <tr>
                    <td height="74" colspan="2" valign="top"><fieldset>
                      <table width="310" height="63" border="0" cellpadding="0" cellspacing="0" valign="top">
                        <tr>
                          <td width="150" align="left" valign="top" class="blackText1">&iquest;En qu&eacute; estado est&aacute; ubicada la vivienda que quiere adquirir?</td>
                          <td width="10" rowspan="2"></td>
													<td width="110" valign="bottom" class="blackText1" align="left">Desarrollo</td>
                        </tr>
                        <tr>
                          <td valign="top" align="left" class="blackText1">
                              <select name="estado" id="estado" onchange="cargaDesarrollos();" class="anchoEstandardSelect">
                                <option value="0">-Seleccione-</option>
                              <%
                              try{
                                s = HibernateUtil2.currentSession();
                                it = null;
                               // tx = s.beginTransaction();
                                q = s.createQuery("from Edo as e where e.cal.calId=6");
                                it = (Iterator) q.iterate();
                                while (it.hasNext()) {
                                    Edo e = (Edo) it.next();
                                    if(oldCliMta != null){
                                        if(e.getEdoId().intValue() == oldCliMta.getEdoId()){
                        %>
                        <option title="<%=e.getEdoDes()%>" value="<%=e.getEdoId()%>" selected><%=e.getEdoDes()%></option>
                              <%}else{%>
                              <option title="<%=e.getEdoDes()%>" value="<%=e.getEdoId()%>"><%=e.getEdoDes()%></option>
                              <%}}else{%>
                              <option title="<%=e.getEdoDes()%>" value="<%=e.getEdoId()%>"><%=e.getEdoDes()%></option>
                              <%}}}catch(Exception ex){
                            ex.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                              </select></td>

                          <td valign="top" align="left" class="blackText1">
                            <select name="desarrollo" id="desarrollo" class="anchoEstandardSelect">
                                <option value="0">-Seleccione-</option>
                              <%
                              try{

                                s = HibernateUtil2.currentSession();
                                it = null;
                               // tx = s.beginTransaction();
                                q = s.createQuery("from Des as d where d.cal.calId=2");
                                it = (Iterator) q.iterate();
                                while (it.hasNext()) {
                                    Des d = (Des) it.next();
                                    if(oldCliMta != null){
                                        if(d.getDesId().intValue() == oldCliMta.getDesId()){
                        %>
                            <option title="<%=d.getDesDes()%>" value="<%=d.getDesId()%>" selected><%=d.getDesDes()%></option>
                            <%}else{%>
                            <option title="<%=d.getDesDes()%>" value="<%=d.getDesId()%>"><%=d.getDesDes()%></option>
                            <%}}else{%>
                            <option title="<%=d.getDesDes()%>" value="<%=d.getDesId()%>"><%=d.getDesDes()%></option>
                            <%}}}catch(Exception ex){
                            ex.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                          </select></td>
                        </tr>
                        </table>
					            </fieldset>                    </td>
                    </tr>

                  <tr>
                    <td valign="top"><fieldset>
                    <table width="140" height="59" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td valign="bottom" class="blackText1" align="left">Valor de la vivienda</td>
                      </tr>
                      <tr>
                        <%if(oldCliMta != null){%>
                        <td valign="top" class="blackText1" align="left"><input type="text" name="valorVivienda" id="valorVivienda" onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)" onblur="validarValorVivienda(this)" value="<%=oldCliMta.getCliValViv()%>"/>                        </td>
                        <%}else{%>
                        <td valign="top" class="blackText1" align="left"><input type="text" name="valorVivienda" id="valorVivienda" onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)" onblur="validarValorVivienda(this)" />                        </td>
                        <%}%>
                      </tr>
                    </table>
                    </fieldset></td>
                    <td valign="top"><fieldset>
                      <table width="10" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td align="left" valign="bottom" class="blackText1">&iquest;Qu&eacute; mensualidad puede pagar para la vivienda que quiere adquirir?</td>
                          </tr>
                        <tr>
                            <%if(oldCliMta != null){%>
                          <td valign="top" align="left" class="blackText1">
                              <input type="text" name="valorViviendaMen" id="valorViviendaMen" onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event);" onblur="validarValorMensualidad(this)" value="<%=oldCliMta.getCliValMen()%>"/>                        </td>
                        <%}else{%>
                        <td valign="top" align="left" class="blackText1">
                            <input type="text" name="valorViviendaMen" id="valorViviendaMen"  onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event);" onblur="validarValorMensualidad(this)"/>                        </td>
                            <%}%>
                        </tr>
                        </table>
                    </fieldset> </td>
                  </tr>
                  </table></td>
              </tr>



              <tr>
                <td height="2" colspan="7"></td>
              </tr><tr><td width="380" height="1"></td><td></td><td></td><td></td><td width="460"></td>

                <td></td></tr>
              </table>
            <p>&nbsp;</p>
      </fieldset></td>
      </tr>
      </table>
	</div>
	<div id="pie_pag"></div>
</div>
</div></center></form>
    </body>

</html>
