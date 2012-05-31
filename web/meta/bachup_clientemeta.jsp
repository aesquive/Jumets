<!--Archivo modificado por josue-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.urbi.utilerias.dao.Usuarios"%>
<%@page import="java.io.IOException"%><html xmlns="http://www.w3.org/1999/xhtml">
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
 <jsp:include page="JSIncludeClienteMeta.jsp" />      

     <%@page import="java.util.*" %>
     <%@page import="objetos.*" %>
     <%@page import="org.hibernate.*" %>
      <%@page import="com.urbi.util.HibernateUtil2" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%
            String accion = (String)request.getSession().getAttribute("accion");
            request.getSession().removeAttribute("accion");
            int id = 0;
            Cli cli = null;
            CliMta2 cliMta = null;
            boolean activar = true;
            //Edo edo = null;
            CodPos codPos = null;
            String[] fecha = new String[3];
            String load;

            System.out.println("accion: " + accion);
            if(request.getSession().getAttribute("idCliente") != null){

                id = ((Integer)request.getSession().getAttribute("idCliente")).intValue();
            }

            System.out.println("id del cliente: " + id);
            if(accion.equals("Agregar") || accion.equals("Modificar"))
                load = "activarControles(true)";
            else
                load = "activarControles(false)";

            if(accion.equals("Modificar")){

                Session ses = null;
                //Transaction t = null;

                try{

                    ses = HibernateUtil2.currentSession();
                    //t = ses.beginTransaction();
                    cli = (Cli) ses.createQuery("from Cli c where  c.cliId=" + id).uniqueResult();
                    cliMta = (CliMta2) ses.createQuery("from CliMta2 mta where mta.cli.cliId=" + id).uniqueResult();
                }catch(Exception e){
                   e.printStackTrace();
                }finally{
                    HibernateUtil2.closeSession();
                }
                
                if(cliMta != null){
                    if(request.getSession().getAttribute("clienteMetaOld") != null){
                        request.getSession().removeAttribute("clienteMetaOld");
                    }

                    request.getSession().setAttribute("clienteMetaOld", cliMta);
                }
                //edo = (Edo) ses.createQuery("from Edo e where e.edoId=" + cliMta.getEdoId()).uniqueResult();
                //codPos = (CodPos) ses.createQuery("from CodPos cod where cod.codPosId=0" +  cli.getCodPosId());
                //SimpleDateFormat formater = new SimpleDateFormat("dd/mm/yyyy");
                fecha = cli.getCliFecNac().toString().split("-");
                System.out.println("fecha :" + fecha);
                System.out.println("cliente: " + cli);
                System.out.println("cliente meta: " + cliMta);
            }
 if(cli != null)
         activar = false;
 %>
<title>Cliente Meta</title>

<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" /><br />
<link href="../js/funciones.js"  type="text/javascript" />

<script type="javascript" language="javascript" src="<%=request.getContextPath()%>/js/funciones.js"></script>

<script type="text/javascript" language="javascript">



    function generarRfc(){

        nombre=document.forms[1].Nombre.value;
        aPaterno=document.forms[1].apellidoPaterno.value;
        aMaterno=document.forms[1].apellidoMaterno.value;
        dia=document.forms[1].dia.value;
        mes=document.forms[1].mes.value;
        anio=document.forms[1].anio.value;

        if(nombre == ""){
            return alert("El campo nombre debe llenarse para calcuar el rfc");
        }

        if(aPaterno == ""){
            return alert("El campo apellido paterno debe llenarse para calcuar el rfc");
        }

        if(aMaterno == ""){
            return alert("El campo apellido materno debe llenarse para calcuar el rfc");
        }

        if(mes == ""){
            return alert("Se debe seleccionar un mes para calcuar el rfc");
        }

        if(anio == ""){
            return alert("Se debe seleccionar un ani para calcuar el rfc");
        }

        if(dia == ""){
            return alert("Se debe seleccionar un día para calcuar el rfc");
        }
        fecha = dia +"/" + mes +"/" + anio;
        
       superGeneracionRfc(dia,mes,anio,nombre,aPaterno,aMaterno);
        

    }

    function   superGeneracionRfc(dia,mes,anio,nombre,aPaterno,aMaterno){
 
  var vocales=['A','E','I','O','U'];




    var anio=anio.substring(2,4);

    var apepat=aPaterno;

    var prim_pat=apepat.substring(0,1);

    var prim_mat=aMaterno.substring(0,1);

    var prim_nom=nombre.substring(0,1);

    var voc_pat=apepat.substring(1,2);

    for(var t=1;t<apepat.length;t++){

        for(var z=0;z<vocales.length;z++){

            if(apepat.charAt(t)==vocales[z]){

                voc_pat=vocales[z];

                document.getElementById("rfc").value=prim_pat+voc_pat+prim_mat+prim_nom+anio+mes+dia;


                return;
            }

        }

    }



    }



   
    function obtieneDias(){

        
    var dias=["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23","24","25","26","27","28","29","30","31"];

        var dia=document.getElementById("dia");
        
        var longitud=dia.options.length;
        
        for(var t=0;t<dias.length;t++){
            dia.options[dia.options.length]=new Option(dias[t],dias[t]);
        }

    }


    function disableForm(activar) {
        theform = document.forms[1];
        <%
        int baderaActivaCombos = 0;
        if(cliMta!= null){
            if(cliMta.getBanCmpId() != 0)
                baderaActivaCombos = 1;
            }
        %>
        datoTarjeta = <%=baderaActivaCombos%>;
        if (document.all || document.getElementById) {
            for (i = 0; i < theform.length; i++) {
            var formElement = theform.elements[i];
                //alert(formElement.id);
                if (true) {
                    if(formElement.id == "mesVencido" || formElement.id == "pcuso" || formElement.id == "pcPago"){

                        if(datoTarjeta == 0){
                            formElement.disabled = true;
                        }else{
                            formElement.disabled = activar;
                        }
                    }else if(formElement.id == "rdgProblemaB" ||formElement.id == "buroAct"
                            || formElement.id == "buroUso" || formElement.id == "buroHist"
                            || formElement.id == "buroPago" ||formElement.id == "buroAnt"
                            ){
                                formElement.disabled = true;
                     }else{
                        formElement.disabled = activar;
                    }
                    
                }
            }
        }
    }

    function validarArraigoViviendaActual(obj){

		 


		var str="El valor de la vivienda actual no puede ser mayor a la edad";

		var strMsgDefault = "Para validar el valor del Arraigo de la vivienda es necesario capturar la edad";

		var valEdad = parseInt(document.getElementById("edad").value);

		if(!isNaN(valEdad)){

			if(valEdad<obj.value ){

				alert(str);

				obj.focus();

				return false;

			}

		} else {
			alert(strMsgDefault);
                        obj.value=0;
                      //  document.getElementById("edad").focus();
			return false;
		}

		return true;

	/*	if ( parseInt(obj.value)> ){

		}*/


	}

	function validarArraigoEmpleoActual(obj){


		var str="El valor del empleo actual no puede ser mayor a la edad";

		var strMsgDefault = "Para validar el valor del Arraigo del Empleo es necesario capturar la edad";

		var valEdad = parseInt(document.getElementById("edad").value);

		if(!isNaN(valEdad)){

			if(valEdad<obj.value ){

				alert(str);
                                obj.focus();
                                return;
                                
//obj.focus();
				

				return false;

			}

		} else {
			alert(strMsgDefault);
                        obj.value=0;
                        //document.getElementById('anio').focus();
			//document.getElementById("edad").focus();
			return false;
		}

		return true;
		 

	/*	if ( parseInt(obj.value)> ){

		}*/



	}


        function cancelar(){

            var conf = confirm("Se cancelará la captura, ¿Desaea Continuar?");

            if(conf){
                document.forms[0].command.value="Agregar";
                document.forms[0].form.value="MetaIndex";
                document.forms[0].submit();
            }else{
                return;
            }
        }


        function salir(){

            var conf = confirm("¿Está seguro que desea salir sin guardar el registro?");

            if(conf){
                location.replace("metaindex.jsp");
            }else{
                return;
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

    if(cli != null){
    %>
    <body onload="ClienteMeta.init(); disableForm(<%=activar%>); UtileriasUrbi.cargarCodigoPostal('codigoPostal'); UtileriasUrbi.validarDigitosCodigoPostal('codigoPostal')">

    <%}else{%>
    <body onload="ClienteMeta.init(); disableForm(<%=activar%>);">
    <%}%>
    <form name="ClienteMeta" method="post" action="../MetaClienteServlet" onsubmit="return validate_form(this)">
   <input type="hidden" name="command" value="" />
   <input type="hidden" name="form" value="ClienteMeta" />
</form>
<form name="frmClienteMeta" id="frmClienteMeta"
    	method="post" target="_self"
			onsubmit=" return AIM.submit(this, {'onStart' : startCallback, 'onComplete' : completeCallback})"
			action = "../AgregarMetaServlet" >
	<input type="hidden" name="pantalla" value="pantalla1" />
    <%if(cli != null){%>
  <input type="hidden" name="idCli" value="<%=cli.getCliId()%>" />
    <%}else{%>
  <input type="hidden" name="idCli" />
    <%}%>
    <%
    if(cliMta != null){
    %>
  <input type="hidden" name="idCliMta" value="<%=cliMta.getCliMta2Id()%>" />
    <%}else{%>
  <input type="hidden" name="idCliMta" />
    <%}%>
<center>
<div id="contenedor">
  <div id="encabezado">
    <div id="borde_iz"></div>
		<div id="logo">
			<div id="data">
				<p class="bodystyle"></p>
	  	</div>
		</div>
		<div id="relleno">
			<div id="capa_enc">
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
	      	 <td width="10" align="center">&nbsp;</td>
           <td width="42" align="center">&nbsp;</td>
           <td width="10" align="center">&nbsp;</td>
           <td width="42" align="center">&nbsp;</td>
           <td width="10" align="center">&nbsp;</td>
           <td width="42" align="center">&nbsp;</td>
           <td width="10" align="center">&nbsp;</td>
           <td width="42" align="center">&nbsp;</td>
           <td width="10" align="center">&nbsp;</td>
           <td width="42" align="center">&nbsp;</td>
           <td width="10" align="center">&nbsp;</td>
           <td width="42" align="center"><a onclick="disableForm(false);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img src="../images/acceso/inactivos_add.png" name="add" width="33" height="33" border="0" class="button" id="add" /></a></td>
           <td width="10" align="center"></td>
           <td width="42"align="center"><a href="javascript:cancelar();" ><img src="../images/acceso/inactivos_exit.png" name="exit" width="33" height="33" border="0" class="button" id="exit" /></a><!--a href="#"><img src= "../images/acceso/inactivos_guardar.png" name="guardar"  id = "imgGuardarArriba" width="34" height="33" border="0" class="button" /></a--></td>
           <td width="10" align="center"></td>
           <td width="42" align="center"><a href="javascript:salir();" ><img src="../images/acceso/inactivos_salir.png" name="salir" width="32" height="33" border="0" class="button" id="salir" /></a></td>
           <td width="10" align="center">&nbsp;</td>
           <td width="84" align="center"><a href="javascript:ClienteMeta.validarCapturaGeneral();" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('guardar','','../images/acceso/activos_guardar.png',1)"><img src="../images/acceso/inactivos_guardar.png" name="guardar" width="34" height="33" border="0" class="button" id="guardar" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"></a></td>
          </tr>
	    <tr>
	      <td height="19" class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"> <div align="center"></div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center">Agregar</div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center">Cancelar</div></td>
           <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText"><div align="center">Salir</div></td>
					 <td class="whiteText"><div align="center"></div></td>
           <td class="whiteText" align="center">Guardar</td>
          </tr>
	     </table>
	</div>
	</div>	
	<div id="borde_der"></div>
	<div id="contenido">
	
	<div id="divContenedorTablaError" style="display:none">
					
					<table border=0 cellpadding=0 cellspacing=0 id='tblError' >	
	<tr class="form_separator"><td ></td></tr>
	<tr>
		<td>
			<table border=1 cellpadding=0 cellspacing=0 bordercolor="#FF0000">
				<tr>
				   <td bgcolor="#FFE6E6"><font id=errorMessage color="#FF0000"></font></td>
  				</tr>
			</table>
		</td>
	</tr>
	<tr class="form_separator"><td ></td></tr>
</table></div>
	
	<!-- EAAR: UPDATE ERROL/MIKE ISLAS --> 
	
	
	  <table width="900" border="0" align="center" cellpadding="0" cellspacing="0">  
	    <tr>
	      <td colspan="19"><fieldset><legend class="blueSubtitle">Datos personales</legend>
            <table width="885" height="581" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
                <td colspan="8">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="6" valign="top"><fieldset>
                 <legend class="blackText1" style="font-weight:bold">Nombre</legend>
                  <table border="0" cellspacing="0" cellpadding="0" align="left">
                    <tr>
                      <td align="left" class="blackText1">Apellido Paterno</td>
                      <td>&nbsp;</td>
                      <td align="left" class="blackText1">Apellido Materno</td>
                      <td>&nbsp;</td>
                      <td align="left" class="blackText1">Nombre</td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"></td>
                    </tr>
                    <tr>
                        <%
                        if(cli != null){
                        %>
                      <td class="blackText1" align="left"><input type="text" name="apellidoPaterno" id ="apellidoPaterno" value="<%=cli.getCliApePat()%>" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)" tabindex="1" /></td>
                      <td class="blackText1" width="10">&nbsp;</td>
                      <td class="blackText1" align="left"><input type="text" name="apellidoMaterno" id="apellidoMaterno" value="<%=cli.getCliApeMat()%>" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)" tabindex="1" /></td>
                      <td class="blackText1" width="10">&nbsp;</td>
                      <td class="blackText1" align="left"><input type="text" name="Nombre" id="Nombre" value="<%=cli.getCliNom()%>" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)" tabindex="2" /></td>
                      <td class="blackText1" width="10">&nbsp;</td>
                      <td class="blackText1" align="left"><input name="rfc" type="hidden" id="rfc" size="10" value="<%=cli.getCliRFC()%>" readonly tabindex="-1" /></td>
                      <%
                      } else{
                      %>
                      <td class="blackText1" align="left"><input type="text" name="apellidoPaterno" id ="apellidoPaterno" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)" tabindex="1" /></td>
                      <td class="blackText1" width="10">&nbsp;</td>
                      <td class="blackText1" align="left"><input type="text" name="apellidoMaterno" id="apellidoMaterno" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)" tabindex="1" /></td>
                      <td class="blackText1" width="10">&nbsp;</td>
                      <td class="blackText1" align="left"><input type="text" name="Nombre" id="Nombre" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)" tabindex="2" /></td>
                      <td class="blackText1" align="left" width="10">&nbsp;</td>

                      <td class="blackText1" align="left"><input name="rfc" type="hidden" id="rfc" size="10" readonly tabindex="-2" /></td>

                      <%}%>
                    </tr>
                    </table>
                </fieldset></td>
                <td width="20">&nbsp;</td>
                <td width="336" valign="top"><fieldset>
                  <legend class="blackText1" style="font-weight:bold">Fecha de Nacimiento</legend>
                  <table border="0" align="left" cellpadding="0" cellspacing="0">
                    <tr>
                      <td align="left" class="blackText1">A&ntilde;o</td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1">Mes</td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1">D&iacute;a</td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1">Edad</td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left"><select id="anio" name="anio"   onchange="calcular_edad();" style="width:80px" tabindex="3">
                              <option value="-1">-A&ntilde;o-</option>
                                                                            <%
                                                                            for(int i=1;i<50;i++){
                                                                               int ano = 1945 +i;
                                                                               if(cli != null){
                                                                                   if(fecha[0] != ""){
                                                                                      if(ano == Integer.parseInt(fecha[0].trim())){

                                                                            %>
                                                                            <option value="<%=ano%>" selected><%=ano%></option>
                                                                            <%}else{%>
                                                                            <option value="<%=ano%>"><%=ano%></option>
                                                                            <%}}}else{%>
                                                                            <option value="<%=ano%>"><%=ano%></option>
                                                                            <%}}%>
                          </select>                      </td>
                      <td class="blackText1" align="left">&nbsp;</td>
                      <td class="blackText1" align="left"><select id="mes" name="mes"   onchange="calcular_edad() , obtieneDias();" tabindex="4">
                                                                            <%
                                                                                for(int i=0; i<=12; i++){
                                                                                   String mes = ""; 
                                                                                   String nombreMes = "";
                                                                                   switch (i) {
                                                                                    case 1:  nombreMes = "Enero"; break;
                                                                                    case 2:  nombreMes = "Febrero"; break;
                                                                                    case 3:  nombreMes = "Marzo"; break;
                                                                                    case 4:  nombreMes = "Abril"; break;
                                                                                    case 5:  nombreMes = "Mayo"; break;
                                                                                    case 6:  nombreMes = "Junio"; break;
                                                                                    case 7:  nombreMes = "Julio"; break;
                                                                                    case 8:  nombreMes = "Agosto"; break;
                                                                                    case 9:  nombreMes = "Septiembre"; break;
                                                                                    case 10: nombreMes = "Octubre"; break;
                                                                                    case 11: nombreMes = "Noviembre"; break;
                                                                                    case 12: nombreMes = "Diciembre"; break;
                                                                                    default: nombreMes = "-Mes-";break;
                                                                                   }
                                                                                   
                                                                                   if(i<10){
                                                                                   
                                                                                       mes = "0" + i;
                                                                                   }else{
                                                                                   
                                                                                       mes = Integer.toString(i);
                                                                                   }
                                                                                   
                                                                                    if(cli != null){
                                                                                      if(fecha[0] != ""){
                                                                                          if(mes.trim().equals(fecha[1].trim())){
                                                                                           System.out.println("mes guardado: " + fecha[1] + " mes del cliclo: " + mes + " " + nombreMes);
                                                                            %>
                                                                            <option value="<%=mes%>" selected><%=nombreMes%></option>
                                                                            <%}else{%>
                                                                            <option value="<%=mes%>"><%=nombreMes%></option>
                                                                            <%}}}else{%>
                                                                            <option value="<%=mes%>"><%=nombreMes%></option>
                                                                            <%}}%>

                                                                        </select>                       </td>
                      <td class="blackText1" align="left">&nbsp;</td>
                      <td class="blackText1" align="left"> <select id="dia" name="dia"   onchange="calcular_edad() , generarRfc();" tabindex="5">
                                                                            <%
                                                                            if(cli != null){
                                                                            %>
                                                                            <option value="<%=fecha[2].trim()%>"><%=fecha[2].trim()%></option>
                                                                            <%}else{%>
                                                                            <option value="-1">-D&iacute;a-</option>
                                                                            <%}%>
                                                                        </select>                        </td>
                      <td class="blackText1" align="left">&nbsp;</td>
                      <td class="blackText1" align="left"> 
                          <%if(cli != null){%>
                          <input id="edad" name="edad" type="text" size="5"  value="<%=cli.getCliEdad()%>" readonly tabindex="-3" />
                          <%}else{%>
                          <input id="edad" name="edad" type="text" size="5" readonly tabindex="-3" />
                          <%}%>                      </td>
                    </tr>
                    </table>
                  </fieldset>               </td>
              </tr>
              <tr>
                <td colspan="8"><fieldset style="width:98%">
                  <legend class="blackText1" style="font-weight:bold">Domicilio</legend>
                  <table border="0" align="left" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="144" align="left" class="blackText1">Calle</td>
                      <td width="6" align="left" class="blackText1">&nbsp;</td>
                      <td width="67" align="left" class="blackText1">No.Exterior  </td>
                     
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td width="61" align="left" class="blackText1">No.Interior</td>
                      <td width="6" align="left" class="blackText1">&nbsp;</td>
                      <td width="147" align="left" class="blackText1">Colonia</td>
                 
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td width="90" align="left" class="blackText1">C&oacute;digo Postal</td>
                      
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td width="144" align="left" class="blackText1">Estado</td>
                      <td width="6" align="left" class="blackText1">&nbsp;</td>
                      <td width="155" align="left" class="blackText1">Delegaci&oacute;n/ Municipio</td>
                    </tr>
                    <tr>
                        <%
                        if(cli != null){
                        %>
                        <td align="left" class="blackText1"><input type="text" name="calle" id="calle" value="<%=cli.getCliDomCal()%>" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)" tabindex="6" />                        </td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"><input name="noExterior" id="noExterior" type="text" size="8" value="<%=cli.getCliDomNumExt()%>" onkeypress="return UtileriasUrbi.capturarSoloNumerosTextoConvertirMayusculas(event)" maxlength="5" tabindex="7" />                        </td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"><input name="noInterior" id="noInterior" type="text" size="5" value="<%=cli.getCliDomNumInt()%>" onkeypress="return UtileriasUrbi.capturarSoloNumerosTextoConvertirMayusculas(event)" tabindex="8" />                        </td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"><input name="colonia" id="colonia" type="text" value="<%=cli.getCliDomCol()%>" onkeypress="return UtileriasUrbi.capturarSoloNumerosTextoConvertirMayusculas(event)" tabindex="9" />                        </td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"><input name="codigoPostal" id="codigoPostal" type="text" value="<%=cli.getCodPosId()%>" size="6" onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)"
							onblur="UtileriasUrbi.cargarCodigoPostal('codigoPostal'); UtileriasUrbi.validarDigitosCodigoPostal('codigoPostal')" maxlength="5" tabindex="10"/></td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"><input type="text" name="estado" id="estado" disabled="disabled" tabindex="-4" />                        </td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"><input type="text" name="delegacionMunicipio" id="delegacion" disabled="disabled" tabindex="-5" />                        </td>
                    </tr>
                      <%}else{%>
                      <tr><td align="left" class="blackText1"><input type="text" name="calle" id="calle" onkeypress="return UtileriasUrbi.capturarSoloTextoConvertirMayusculas(event)"  tabindex="6"/>                        </td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"><input name="noExterior" id="noExterior" type="text" size="8" onkeypress="return UtileriasUrbi.capturarSoloNumerosTextoConvertirMayusculas(event)" maxlength="5" tabindex="7" />                        </td>
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"><input name="noInterior" id="noInterior" type="text" size="5" onkeypress="return UtileriasUrbi.capturarSoloNumerosTextoConvertirMayusculas(event)" tabindex="8" /></td>
                      <td align="left" class="blackText1">&nbsp;</td>
					  <td align="left" class="blackText1"><input name="colonia" id="colonia" type="text" onkeypress="return UtileriasUrbi.capturarSoloNumerosTextoConvertirMayusculas(event)" tabindex="9" /></td>
					  <td align="left" class="blackText1">&nbsp;</td>
					  <td align="left" class="blackText1"><input name="codigoPostal" id="codigoPostal" type="text" size="6" onkeypress="return UtileriasUrbi.capturarSoloNumerosTextoConvertirMayusculas(event)"
							 onblur="UtileriasUrbi.cargarCodigoPostal('codigoPostal'); UtileriasUrbi.validarDigitosCodigoPostal('codigoPostal')" maxlength="5" tabindex="10" /></td>
					   
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"><input type="text" name="estado2" id="estado" disabled="disabled" tabindex="-5" /></td>
					  
                      <td align="left" class="blackText1">&nbsp;</td>
                      <td align="left" class="blackText1"><input type="text" name="delegacionMunicipio2" id="delegacion" disabled="disabled" tabindex="-6" /></td>
					   

                      <%}%>
                      </tr>
                      <tr><td height="1"></td><td></td><td></td>
                        <td></td>
                        <td></td><td></td><td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td width="4"></td><td ></td><td></td></tr>
                    </table>
                </fieldset></td>
              </tr>
              <tr>
                <td colspan="8">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="8"><fieldset>
                  <table border="0" cellspacing="0" cellpadding="0" align="left">
                    <tr>
                      <td class="blackText1" align="left">&iquest;Cu&aacute;l es su religi&oacute;n?</td>
                      <td class="blackText1" align="left" width="15">&nbsp;</td>
                      <td class="blackText1" align="left">&iquest;Cu&aacute;l es su sexo? </td>
                      <td class="blackText1" align="left" width="15">&nbsp;</td>
                      <td class="blackText1" align="left">&iquest;Cu&aacute;l es su estado civil? </td>
                      <td class="blackText1" align="left" width="15">&nbsp;</td>
                      <td class="blackText1" align="left">&iquest;Hasta qu&eacute; grado estudi&oacute;?</td>
                      <td class="blackText1" align="left" width="15">&nbsp;</td>
                      <td class="blackText1" align="left">La casa donde vive actualmente es:</td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left"><select name="religion" id="religion" class="anchoEstandardSelect" tabindex="11">
                        <option>-Seleccione-</option>
                        <%
                            Session s = null;
                            Iterator it = null;
                            //Transaction tx = null;
                            Query q = null;

                            try{
                                s = HibernateUtil2.currentSession();
                                //tx = s.beginTransaction();
                            q = s.createQuery("from Rel as rel where rel.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                Rel r = (Rel) it.next();
                                if(cliMta != null){
                                    if(r.getRelId().intValue() == cliMta.getRelId()){
                        %>
                        <option title="<%=r.getRelDes()%>" value="<%=r.getRelId()%>" selected><%=r.getRelDes()%></option>
                        <%}else{%>
                        <option title="<%=r.getRelDes()%>" value="<%=r.getRelId()%>"><%=r.getRelDes()%></option>
                        <%}}else{%>
                        <option title="<%=r.getRelDes()%>" value="<%=r.getRelId()%>"><%=r.getRelDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                          </select></td>
                      <td class="blackText1" align="left" width="15">&nbsp;</td>
                      <td class="blackText1" align="left"><select name="sex" id="sexo" class="anchoEstandardSelect" tabindex="12">
                        <option>-Seleccione-</option>
                        <%
                            try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                            //tx = s.beginTransaction();
                            q = s.createQuery("from Sex as sex where sex.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                Sex sex = (Sex) it.next();
                                if(cliMta != null){
                                    if(sex.getSexId().intValue() == cliMta.getSexId()){
                        %>
                        <option title="<%=sex.getSexDes()%>" value="<%=sex.getSexId()%>" selected><%=sex.getSexDes()%></option>
                        <%}else{%>
                        <option title="<%=sex.getSexDes()%>" value="<%=sex.getSexId()%>"><%=sex.getSexDes()%></option>
                        <%}}else{%>
                        <option title="<%=sex.getSexDes()%>" value="<%=sex.getSexId()%>"><%=sex.getSexDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                        </select>                        </td>
                      <td class="blackText1" align="left" width="15">&nbsp;</td>
                      <td class="blackText1" align="left"><select name="estadoCivil" id="estadoCivil" class="anchoEstandardSelect" tabindex="13">
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                           // tx = s.beginTransaction();
                            q = s.createQuery("from EdoCvl as ec where ec.cal.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                EdoCvl ec = (EdoCvl) it.next();
                                 if(cliMta != null){
                                     if(ec.getEdoCvlId().intValue() == cliMta.getEdoCvlId()){
                        %>
                        <option title="<%=ec.getEdoCvlDes()%>" value="<%=ec.getEdoCvlId()%>" selected><%=ec.getEdoCvlDes()%></option>
                        <%}else{%>
                        <option title="<%=ec.getEdoCvlDes()%>" value="<%=ec.getEdoCvlId()%>"><%=ec.getEdoCvlDes()%></option>
                        <%}}else{%>
                        <option title="<%=ec.getEdoCvlDes()%>" value="<%=ec.getEdoCvlId()%>"><%=ec.getEdoCvlDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                        </select>                        </td>
                      <td class="blackText1" align="left" width="15">&nbsp;</td>
                      <td class="blackText1" align="left"><select name="nEstdio" id="nEstdio" class="anchoEstandardSelect" tabindex="14">
                        <option>-Seleccione-</option>
                        <% try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                            //tx = s.beginTransaction();
                            q = s.createQuery("from NivEst as ne where ne.cal.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                NivEst ne = (NivEst) it.next();
                                if(cliMta != null){
                                    if(ne.getNivEstId().intValue() == cliMta.getNivEstId()){
                        %>
                        <option title="<%=ne.getNivEstDes()%>" value="<%=ne.getNivEstId()%>" selected><%=ne.getNivEstDes()%></option>
                        <%}else{%>
                        <option title="<%=ne.getNivEstDes()%>" value="<%=ne.getNivEstId()%>"><%=ne.getNivEstDes()%></option>
                        <%}}else{%>
                        <option title="<%=ne.getNivEstDes()%>" value="<%=ne.getNivEstId()%>"><%=ne.getNivEstDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                      </select></td>
                      <td class="blackText1" align="left" width="15">&nbsp;</td>
                      <td class="blackText1" align="left"><select name="tipoRes" id="tipoRes" class="anchoEstandardSelect" tabindex="15">
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                            //tx = s.beginTransaction();
                            q = s.createQuery("from TipRes as tr where tr.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                TipRes tr = (TipRes) it.next();
                                if(cliMta != null){
                                    System.out.println("tipRes: " + cliMta.getTipResId());
                                    if(tr.getTipResId().intValue() == cliMta.getTipResId()){
                        %>
                        <option title="<%=tr.getTipResDes()%>" value="<%=tr.getTipResId()%>" selected><%=tr.getTipResDes()%></option>
                        <%}else{%>
                        <option title="<%=tr.getTipResDes()%>" value="<%=tr.getTipResId()%>"><%=tr.getTipResDes()%></option>
                        <%}}else{%>
                        <option title="<%=tr.getTipResDes()%>" value="<%=tr.getTipResId()%>"><%=tr.getTipResDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                      </select></td>
                    </tr>
                    </table>
                </fieldset></td>
              </tr>
              <tr>
                <td colspan="8">&nbsp;</td>
              </tr>
              <tr>
                <td width="160" valign="top"><fieldset>
                <legend class="blackText1" style="font-weight:bold">Arraigo</legend>
                <table border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                </table>
                <table width="160" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td class="blackText1" align="left">&iquest;Hace cu&aacute;nto habita<br />
                      en su vivienda actual?</td>
                  </tr>
                  <tr>
                     <%if(cliMta != null){%>
                     <td class="blackText1" align="left"><input name="tiempoVivienda" id="tiempoVivienda" type="text" size="8" value="<%=(int)(cliMta.getCliAntRes()).doubleValue()%>" maxlength="2" onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)" tabindex="16"  onblur="validarArraigoViviendaActual(this)"  />
                      &nbsp;A&ntilde;os </td>
                      <%}else{%>
                      <td class="blackText1" align="left"><input name="tiempoVivienda" id="tiempoVivienda" type="text" size="8" maxlength="2" onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)" tabindex="16" onblur="validarArraigoViviendaActual(this)" />
                      &nbsp;A&ntilde;os </td>
                      <%}%>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left">&iquest;Hace cu&aacute;nto labora <br />
                      en su empleo actual?</td>
                  </tr>
                  <tr>
                      <%if(cliMta != null){%>
                    <td class="blackText1" align="left"><input name="tiempoEmpleo" id="tiempoEmpleo" type="text" size="8" value="<%=cliMta.getTipEmpId()%>" maxlength="2"onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)" tabindex="17" onblur="validarArraigoEmpleoActual(this)" />
                      &nbsp;A&ntilde;os </td>
                      <%}else{%>
                      <td class="blackText1" align="left"><input name="tiempoEmpleo" id="tiempoEmpleo" type="text" size="8" maxlength="2"onkeypress="return UtileriasUrbi.capturarSoloNumerosEnteros(event)" tabindex="17" onblur="validarArraigoEmpleoActual(this)" />
                      &nbsp;A&ntilde;os </td>
                      <%}%>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left">En los  &uacute;ltimos 5 a&ntilde;os<br />
                      ha vivido en </td>
                  </tr>
                  <tr>
                    <td class="blackText1" align="left"><select name="mov" id="mov" tabindex="18">
                        <option>-Seleccione-</option>
                          <%
                          try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                           // tx = s.beginTransaction();
                            q = s.createQuery("from Mov as mov where mov.cal.calId = '2'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                Mov mov = (Mov) it.next();

                                if(cliMta != null){
                                    if(mov.getMovId().intValue() == cliMta.getMigId()){
                        %>
                        <option title="<%=mov.getMovDes()%>" value="<%=mov.getMovId()%>" selected><%=mov.getMovDes()%></option>
                        <%}else{%>
                        <option value="<%=mov.getMovId()%>"><%=mov.getMovDes()%></option>
                        <%}}else{%>
                        <option value="<%=mov.getMovId()%>"><%=mov.getMovDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                          
                      </select>                    </td>
                  </tr>
                </table>
                </fieldset></td>
                <td width="4"  valign="top">&nbsp;</td>
                <td width="250" height="383" valign="top"><fieldset>
                  <legend class="blackText1" style="font-weight:bold">Aspectos Diferenciadores</legend>
                  <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td>&nbsp;</td>
                    </tr>
                    </table>
                  <table width="250" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td class="blackText1" align="left"><p>&iquest;A qui&eacute;n recurres cuando <br />
					  			necesitas un prestamo  ?</p>
                        </td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left"><select name="prestamo" id="prestamo" class="anchoEstandardSelect" tabindex="19">
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                           // tx = s.beginTransaction();
                            q = s.createQuery("from Ptm as ptm where ptm.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                Ptm ptm = (Ptm) it.next();
                                if(cliMta != null){
                                    if(ptm.getPtmId().intValue() == cliMta.getPtmId()){
                        %>
                        <option title="<%=ptm.getPtmDes()%>" value="<%=ptm.getPtmId()%>" selected><%=ptm.getPtmDes()%></option>
                        <%}else{%>
                        <option title="<%=ptm.getPtmDes()%>" value="<%=ptm.getPtmId()%>"><%=ptm.getPtmDes()%></option>
                        <%}}else{%>
                        <option title="<%=ptm.getPtmDes()%>" value="<%=ptm.getPtmId()%>"><%=ptm.getPtmDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                        </select>                        </td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left">&nbsp;</td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left">De los  partidos pol&iacute;ticos, <br />
                        &iquest;cu&aacute;l crees que sea el mejor?</td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left"><select name="mejorPartido" id="mejorPartido" class="anchoEstandardSelect" tabindex="20" >
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                           // tx = s.beginTransaction();
                            q = s.createQuery("from ParPlt as mp where mp.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                ParPlt mp = (ParPlt) it.next();

                                if(cliMta != null){
                                    if(mp.getParPltId().intValue() == cliMta.getParPltId()){
                        %>
                        <option title="<%=mp.getParPltDes()%>" value="<%=mp.getParPltId()%>" selected><%=mp.getParPltDes()%></option>
                        <%}else{%>
                        <option title="<%=mp.getParPltDes()%>" value="<%=mp.getParPltId()%>"><%=mp.getParPltDes()%></option>
                        <%}}else{%>
                        <option title="<%=mp.getParPltDes()%>" value="<%=mp.getParPltId()%>"><%=mp.getParPltDes()%></option>
                        <%}}}catch(Exception ex){
                            ex.printStackTrace();
                        }%>
                      </select></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left">&iquest;C&oacute;mo afecta su religi&oacute;n<br />
                        en su toma de decisiones?</td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left"><select name="relAfe" id="relAfe" class="anchoEstandardSelect" tabindex="21" >
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                           // tx = s.beginTransaction();
                            q = s.createQuery("from RelAfe as ra where ra.calId = '2'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                RelAfe ra = (RelAfe) it.next();

                                if(cliMta != null){

                                    if(ra.getRelAfeId().intValue() == cliMta.getRldId()){
                        %>
                        <option title="<%=ra.getRelAfeDes()%>" value="<%=ra.getRelAfeId()%>" selected><%=ra.getRelAfeDes()%></option>
                        <%}else{%>
                        <option title="<%=ra.getRelAfeDes()%>" value="<%=ra.getRelAfeId()%>"><%=ra.getRelAfeDes()%></option>
                        <%}}else{%>
                        <option title="<%=ra.getRelAfeDes()%>" value="<%=ra.getRelAfeId()%>"><%=ra.getRelAfeDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                        </select>                        </td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left">&nbsp;</td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left">&iquest;Qu&eacute; opina de las asociaciones <br />
                        que apoyan a deudores?</td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left"><select name="opinionApoDe" id="opinionApoDe" class="anchoEstandardSelect" tabindex="22">
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                           // tx = s.beginTransaction();
                            q = s.createQuery("from OpnBar as ob where ob.cal.calId = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                OpnBar ob = (OpnBar) it.next();
                                if(cliMta != null){
                                    if(ob.getOpnBarId().intValue() == cliMta.getOpnBarId()){
                        %>
                        <option title="<%=ob.getOpnBarDes()%>" value="<%=ob.getOpnBarId()%>" selected><%=ob.getOpnBarDes()%></option>
                        <%}else{%>
                        <option title="<%=ob.getOpnBarDes()%>" value="<%=ob.getOpnBarId()%>"><%=ob.getOpnBarDes()%></option>
                        <%}}else{%>
                        <option title="<%=ob.getOpnBarDes()%>" value="<%=ob.getOpnBarId()%>"><%=ob.getOpnBarDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                        </select></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left">&iquest;En qui&eacute;n crees mas, Partidos Politicos <br />
                        o Asociaciones que apoyan a deudores
                        ?</td>
                    </tr>
                    <tr>
                      <td class="blackText1" align="left"><select name="partAsoc" id="partAsoc" class="anchoEstandardSelect" tabindex="23" >
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                          //  tx = s.beginTransaction();
                            q = s.createQuery("from ParAso as pa where pa.calId = '2'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                ParAso pa = (ParAso) it.next();

                                if(cliMta != null){
                                    if(pa.getParAsoId().intValue() == cliMta.getAsoParId()){
                        %>
                        <option title="<%=pa.getParAsoDes()%>" value="<%=pa.getParAsoId()%>" selected><%=pa.getParAsoDes()%></option>
                        <%}else{%>
                        <option title="<%=pa.getParAsoDes()%>" value="<%=pa.getParAsoId()%>"><%=pa.getParAsoDes()%></option>
                        <%}}else{%>
                        <option title="<%=pa.getParAsoDes()%>" value="<%=pa.getParAsoId()%>"><%=pa.getParAsoDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                        </select>                        </td>
                    </tr>
                    </table>
                  </fieldset>               </td>
                <td width="4" valign="top">&nbsp;</td>
                <td colspan="4" valign="top"><fieldset>
                  <legend class="blackText1" style="font-weight:bold">Comportamiento de Pago</legend>
                  <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td>&nbsp;</td>
                    </tr>
                    </table>
                  <table height="440" border="0" align="left" cellpadding="0" cellspacing="0">
                    <tr>
                      <td height="36" colspan="3" align="left" valign="top" class="blackText1">&iquest;Cu&aacute;ntas personas son sus <br />
                        dependientes econ&oacute;micos?</td>
                      <td rowspan="14" valign="top"><table width="100%" height="181" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="100%" valign="top"><fieldset width="97%">
                            <table border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td colspan="2" align="left" class="blackText1"><div align="right">&iquest;Tienes tarjeta de cr&eacute;dito bancaria 
                                  o de alguna tienda comercial?</div></td>
                                  <td colspan="2" align="right" valign="middle" class="blackText1"><table width="84" border="0" align="right" cellpadding="0" cellspacing="0">
                                      <%
                                          if(cliMta != null){
                                              if(cliMta.getBanCmpId() != 0){

                                              %>

                                      <tr>
                                      <td width="83"  ><label>
                                              <input name="rdgTC" id ="rdgTC" type="radio" value="true" checked="checked"  onclick="activaCombos();" tabindex="29"/>
                                         Si   </label>
                                        <br />
                                         <input name="rdgTC" type="radio" id ="rdgTC" value="false" onclick="activaCombos();" tabindex="30"/>
                                        <label> No   </label></td>
                                        </tr>
                                      <%
                                      }else{
                                      %>
                                       <tr>
                                      <td width="83"  ><label>
                                              <input name="rdgTC" id ="rdgTC" type="radio" value="true" onclick="activaCombos();" tabindex="29"/>
                                         Si   </label>
                                        <br />
                                         <input name="rdgTC" type="radio" id ="rdgTC" value="false" checked="checked" onclick="activaCombos();" tabindex="30"/>
                                        <label> No   </label></td>
                                        </tr>
                                       <%}}else{%>
                                        <tr>
                                      <td width="83"  ><label>
                                              <input name="rdgTC" id ="rdgTC" type="radio" value="true" onclick="activaCombos();" tabindex="29"/>
                                         Si   </label>
                                        <br />
                                         <input name="rdgTC" type="radio" id ="rdgTC" value="false" checked="checked" onclick="activaCombos();" tabindex="30"/>
                                        <label> No   </label></td>
                                        </tr>
                                        <%}%>
                                  </table></td>
                                  </tr>
                                   
                              <tr>
                                <td width="67">&nbsp;</td>
                                  <td width="106">&nbsp;</td>
                                  <td width="20">&nbsp;</td>
                                  <td width="133">&nbsp;</td>
                                </tr>
                              <tr>
                                <td colspan="2" align="left" class="blackText1"><div align="right">&iquest;Tiene alg&uacute;n<br />
                                  mes vencido?</div></td>
                                  <td valign="middle" class="blackText1" align="left">&nbsp;</td>
                                  <td valign="middle" class="blackText1" align="left"><div>
                                          <select name="mesVencido" id="mesVencido" class="anchoEstandardSelectColumnaDerecha" disabled tabindex="31" >
                                      <option selected="selected"></option>
                                      <%
                                      try{
                                            s = HibernateUtil2.currentSession();
                                            it = null;
                                           // tx = s.beginTransaction();
                                            q = s.createQuery("from BanCmp as bc where bc.cal.calId = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BanCmp bc = (BanCmp) it.next();
                                            if(cliMta != null){
                                                if(bc.getBanCmpId().intValue() == cliMta.getBanCmpId()){
                                        %>
                                        <option value="<%=bc.getBanCmpId()%>" selected><%=bc.getBanCmpDes()%></option>
                                      <%}else{%>
                                      <option value="<%=bc.getBanCmpId()%>"><%=bc.getBanCmpDes()%></option>
                                      <%}}else{%>
                                      <option value="<%=bc.getBanCmpId()%>"><%=bc.getBanCmpDes()%></option>
                                      <%}}}catch(Exception e){
                                           e.printStackTrace();
                                        }finally{
                                            HibernateUtil2.closeSession();
                                        }%>
                                      </select>
                                    </div></td>
                                </tr>
                              <tr>
                                <td class="blackText1">&nbsp;</td>
                                  <td class="blackText1">&nbsp;</td>
                                  <td class="blackText1">&nbsp;</td>
                                  <td class="blackText1">&nbsp;</td>
                                </tr>
                              <tr>
                                <td colspan="2" class="blackText1"><div align="right">% de uso:</div></td>
                                  <td class="blackText1">&nbsp;</td>
                                  <td class="blackText1">% de pago:</td>
                                </tr>
                              <tr>
                                  <td colspan="2" align="right" class="blackText1"><select name="pcuso" id="pcuso" class="anchoEstandardSelectColumnaDerecha" disabled tabindex="32">
                                  <option>-%-</option>
                                  <%
                                  try{
                                            s = HibernateUtil2.currentSession();
                                            it = null;
                                            //tx = s.beginTransaction();
                                            q = s.createQuery("from BanPorUso as bp where bp.cal.calId = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BanPorUso bp = (BanPorUso) it.next();
                                            if(cliMta != null){
                                                if(bp.getBanPorUsoId().intValue() == cliMta.getBanPorUsoId()){
                                        %>
                                        <option value="<%=bp.getBanPorUsoId()%>" selected><%=bp.getBanPorUsoDes()%></option>
                                  <%}else{%>
                                  <option value="<%=bp.getBanPorUsoId()%>"><%=bp.getBanPorUsoDes()%></option>
                                  <%}}else{%>
                                  <option value="<%=bp.getBanPorUsoId()%>"><%=bp.getBanPorUsoDes()%></option>
                                  <%}}}catch(Exception e){
                                       e.printStackTrace();
                                    }finally{
                                        HibernateUtil2.closeSession();
                                    }%>
                                  </select></td>
                                  <td class="blackText1" align="left">&nbsp;</td>
                                  <td class="blackText1" align="left"><select name="pcPago" id="pcPago" class="anchoEstandardSelectColumnaDerecha" disabled tabindex="33">
                                    <option>-%-</option>
                                    <%
                                    try{
                                            s = HibernateUtil2.currentSession();
                                            it = null;
                                            //tx = s.beginTransaction();
                                            q = s.createQuery("from BanPorPag as bpp where bpp.cal.calId = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BanPorPag bpp = (BanPorPag) it.next();
                                            if(cliMta != null){
                                                if(bpp.getBanPorPagId().intValue() == cliMta.getBanPorPagId()){
                                        %>
                                        <option value="<%=bpp.getBanPorPagId()%>" selected><%=bpp.getBanPorPagDes()%></option>
                                    <%}else{%>
                                    <option value="<%=bpp.getBanPorPagId()%>"><%=bpp.getBanPorPagDes()%></option>
                                    <%}}else{%>
                                    <option value="<%=bpp.getBanPorPagId()%>"><%=bpp.getBanPorPagDes()%></option>
                                    <%}}}catch(Exception e){
                                       e.printStackTrace();
                                    }finally{
                                        HibernateUtil2.closeSession();
                                    }%>
                                  </select></td>
                                </tr>
                              </table>
                              </fieldset></td>
                          </tr>
                        <tr>
						<tr><td class="blackText1">&nbsp;</td></tr>
						<tr><td class="blackText1">&nbsp;</td></tr>
                          <td valign="top"><fieldset>
                            <table border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td colspan="11" align="left" valign="top" class="blackText1"><div align="right">En su historial crediticio,<br />
                                  &iquest;sabe si ha existido problema con
                                  el bur&oacute; de cr&eacute;dito?</div></td>
                                <td align="left" valign="middle"class="blackText1" >&nbsp;</td>
                                <td align="left" valign="middle"class="blackText1" ><table width="84" border="0" align="right" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td width="63"><input name="rdgProblemaB" id="rdgProblemaB" type="radio" value="true" disabled tabindex="34" />
                                          <label>Si</label>
                                          <br/>
                                          <input name="rdgProblemaB"  type="radio" id="rdgProblemaB" value="false" checked="checked" disabled tabindex="35" />
                                          <label>No</label></td>
                                    </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td colspan="11" align="right" valign="middle" class="blackText1"><label>Act:</label>
                                    <br />
                                    <select name="buroAct" id="buroAct" class="anchoEstandardSelectColumnaDerecha" disabled tabindex="36">
                                      <%
                                      try{
                                            s = HibernateUtil2.currentSession();
                                            it = null;
                                           // tx = s.beginTransaction();
                                            q = s.createQuery("from BurAct as ba where ba.cal = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BurAct ba = (BurAct) it.next();
                                            if(cliMta != null){
                                                if(ba.getBurActId().intValue() == cliMta.getBurActId()){
                                        %>
                                        <option value="<%=ba.getBurActId()%>" selected><%=ba.getBurActDes()%></option>

                                      <%}else{%>
                                      <option value="<%=ba.getBurActId()%>"><%=ba.getBurActDes()%></option>
                                      <%}}else{%>
                                      <option value="<%=ba.getBurActId()%>"><%=ba.getBurActDes()%></option>
                                      <%}}}catch(Exception e){
                                           e.printStackTrace();
                                        }finally{
                                            HibernateUtil2.closeSession();
                                        }%>
                                    </select>
                                    <label></label></td>
                                <td>&nbsp;</td>
                                <td><span class="blackText1">
                                  <label>% de uso:</label>
                                  <br />
                                  <select name="buroUso" id="buroUso" class="anchoEstandardSelectColumnaDerecha" disabled tabindex="37">
                                    <option>-%-</option>
                                    <%
                                    try{
                                            s = HibernateUtil2.currentSession();
                                            it = null;
                                           // tx = s.beginTransaction();
                                            q = s.createQuery("from BurUso as bu where bu.cal = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BurUso bu = (BurUso) it.next();
                                            if(cliMta != null){
                                                if(bu.getBurUsoId().intValue() == cliMta.getBurUsoId()){
                                        %>
                                        <option value="<%=bu.getBurUsoId()%>" selected><%=bu.getBurUsoDes()%></option>
                                    <%}else{%>
                                    <option value="<%=bu.getBurUsoId()%>"><%=bu.getBurUsoDes()%></option>
                                    <%}}else{%>
                                    <option value="<%=bu.getBurUsoId()%>"><%=bu.getBurUsoDes()%></option>
                                    <%}}}catch(Exception e){
                                       e.printStackTrace();
                                    }finally{
                                        HibernateUtil2.closeSession();
                                    }%>
                                  </select>
                                </span></td>
                              </tr>
                              <tr>
                                <td colspan="11" align="right" valign="middle" class="blackText1"><label>Hist:</label>
                                    <br />
                                    <select name="buroHist" id="buroHist" class="anchoEstandardSelectColumnaDerecha" disabled tabindex="38" >
                                      <%
                                      try{
                                            s = HibernateUtil2.currentSession();
                                            it = null;
                                           // tx = s.beginTransaction();
                                            q = s.createQuery("from BurHis as bh where bh.cal.calId = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BurHis bh = (BurHis) it.next();
                                            if(cliMta != null){
                                                if(bh.getBurHisId().intValue() == cliMta.getBurHisId()){
                                        %>
                                        <option value="<%=bh.getBurHisId()%>" selected><%=bh.getBurHisDes()%></option>
                                      <%}else{%>
                                      <option value="<%=bh.getBurHisId()%>"><%=bh.getBurHisDes()%></option>
                                      <%}}else{%>
                                      <option value="<%=bh.getBurHisId()%>"><%=bh.getBurHisDes()%></option>
                                      <%}}}catch(Exception e){
                                       e.printStackTrace();
                                    }finally{
                                        HibernateUtil2.closeSession();
                                    }%>
                                    </select>
                                    <label></label></td>
                                <td>&nbsp;</td>
                                <td><span class="blackText1">
                                  <label>% de pago:<br />
                                  </label>
                                        <select name="buroPago" id="buroPago" class="anchoEstandardSelectColumnaDerecha" disabled tabindex="39" >
                                    <option>-%-</option>
                                    <%
                                    try{
                                            s = HibernateUtil2.currentSession();
                                            it = null;
                                            //tx = s.beginTransaction();
                                            q = s.createQuery("from BurPag as bp where bp.cal = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BurPag bp = (BurPag) it.next();
                                            if(cliMta != null){
                                                if(bp.getBurPagId().intValue() == cliMta.getBurPagId()){
                                        %>
                                        <option value="<%=bp.getBurPagId()%>" selected><%=bp.getBurPagDes()%></option>
                                    <%}else{%>
                                    <option value="<%=bp.getBurPagId()%>"><%=bp.getBurPagDes()%></option>
                                    <%}}else{%>
                                    <option value="<%=bp.getBurPagId()%>"><%=bp.getBurPagDes()%></option>
                                    <%}}}catch(Exception e){
                                       e.printStackTrace();
                                    }finally{
                                        HibernateUtil2.closeSession();
                                    }%>
                                  </select>
                                </span></td>
                              </tr>
                              <tr>
                                <td colspan="11" align="right" valign="middle" class="blackText1"><label>Ant:</label>
                                    <br />
                                    <select name="buroAnt" id="buroAnt" class="anchoEstandardSelectColumnaDerecha" disabled tabindex="40">
                                      <%
                                      try{
                                            s = HibernateUtil2.currentSession();
                                            it = null;
                                            //tx = s.beginTransaction();
                                            q = s.createQuery("from BurAnt as ba where ba.cal = '4'");
                                            it = (Iterator) q.iterate();
                                            while (it.hasNext()) {
                                            BurAnt ba = (BurAnt) it.next();
                                            if(cliMta != null){
                                                if(ba.getBurAntId().intValue() == cliMta.getBurAntId()){
                                        %>
                                        <option value="<%=ba.getBurAntId()%>" selected><%=ba.getBurAntDes()%></option>
                                      <%}else{%>
                                      <option value="<%=ba.getBurAntId()%>"><%=ba.getBurAntDes()%></option>
                                      <%}}else{%>
                                      <option value="<%=ba.getBurAntId()%>"><%=ba.getBurAntDes()%></option>
                                      <%}}}catch(Exception e){
                                       e.printStackTrace();
                                    }finally{
                                        HibernateUtil2.closeSession();
                                    }%>
                                    </select>                                </td>
                                <td></td>
                                <td></td>
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
                      <td align="left" valign="top" class="blackText1"><select name="dependenciaEco" id="dependenciaEco" class="anchoEstandardSelect" tabindex="24" >
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                           // tx = s.beginTransaction();
                            q = s.createQuery("from DepEco as de where de.cal = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                DepEco de = (DepEco) it.next();
                                if(cliMta != null){
                                    if(de.getDepEcoId().intValue() == cliMta.getDepEcoId()){
                        %>
                        <option title="<%=de.getDepEcoDes()%>" value="<%=de.getDepEcoId()%>" selected><%=de.getDepEcoDes()%></option>
                        <%}else{%>
                        <option title="<%=de.getDepEcoDes()%>" value="<%=de.getDepEcoId()%>"><%=de.getDepEcoDes()%></option>
                        <%}}else{%>
                        <option title="<%=de.getDepEcoDes()%>" value="<%=de.getDepEcoId()%>"><%=de.getDepEcoDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                        </select>                        </td>
                      <td align="left" valign="top" class="blackText1">&nbsp;</td>
                      <td align="left" valign="top" class="blackText1">&nbsp;</td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="3" align="left" valign="top" class="blackText1">&iquest;Realizas alguna otra actividad <br />
                        en la que ganes dinero extra
                        ?</td>
                      </tr>
                    <tr>
                      <td class="blackText1" align="left" valign="top"><select name="actividadExt" id="actividadExt" class="anchoEstandardSelect" tabindex="25" >
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                           // tx = s.beginTransaction();
                            q = s.createQuery("from ActExt as ae where ae.cal = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                ActExt ae = (ActExt) it.next();
                                if(cliMta != null){
                                    if(ae.getActExtId().intValue() == cliMta.getActExtId()){
                        %>
                        <option title="<%=ae.getActExtDes()%>" value="<%=ae.getActExtId()%>" selected><%=ae.getActExtDes()%></option>
                        <%}else{%>
                        <option title="<%=ae.getActExtDes()%>" value="<%=ae.getActExtId()%>"><%=ae.getActExtDes()%></option>
                        <%}}else{%>
                        <option title="<%=ae.getActExtDes()%>" value="<%=ae.getActExtId()%>"><%=ae.getActExtDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                        </select>                        </td>
                      <td class="blackText1" align="left" valign="top">&nbsp;</td>
                      <td class="blackText1" align="left" valign="top">&nbsp;</td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="3" align="left" valign="top" class="blackText1">Si ganaras dinero extra,<br/>
                         &iquest;en que lo usar&iacute;as?</td>
                      </tr>
                    <tr>
                      <td class="blackText1" align="left" valign="top"><select name="DineroExt" id="DineroExt" class="anchoEstandardSelect" tabindex="26" >
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                           // tx = s.beginTransaction();
                            q = s.createQuery("from DinExt as de where de.cal = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                DinExt de = (DinExt) it.next();
                                if(cliMta != null){
                                    if(de.getDinExtId().intValue() == cliMta.getDinExtId()){
                        %>
                        <option title="<%=de.getDinExtDes()%>" value="<%=de.getDinExtId()%>" selected><%=de.getDinExtDes()%></option>
                        <%}else{%>
                        <option title="<%=de.getDinExtDes()%>" value="<%=de.getDinExtId()%>"><%=de.getDinExtDes()%></option>
                        <%}}else{%>
                        <option title="<%=de.getDinExtDes()%>" value="<%=de.getDinExtId()%>"><%=de.getDinExtDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                        </select></td>
                      <td class="blackText1" align="left" valign="top">&nbsp;</td>
                      <td class="blackText1" align="left" valign="top">&nbsp;</td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                    </tr>	  		
                    <tr>
                      <td colspan="3" align="left" valign="top" class="blackText1">&iquest;Qu&eacute; gasto  importante tiene planeado para el pr&oacute;ximo a&ntilde;o?</td>
                      </tr>
                    <tr>
                      <td class="blackText1" align="left" valign="top"><select name="gastoImp" id="gastoImp" class="anchoEstandardSelect" tabindex="27" >
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                            //tx = s.beginTransaction();
                            q = s.createQuery("from GtoImp as gi where gi.cal = '5'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                GtoImp gi = (GtoImp) it.next();
                                if(cliMta != null){
                                    if(gi.getGtoImpId().intValue() == cliMta.getProAnoGtoId()){
                        %>
                        <option title="<%=gi.getGtoImpDes()%>" value="<%=gi.getGtoImpId()%>" selected><%=gi.getGtoImpDes()%></option>
                        <%}else{%>
                        <option title="<%=gi.getGtoImpDes()%>" value="<%=gi.getGtoImpId()%>"><%=gi.getGtoImpDes()%></option>
                        <%}}else{%>
                        <option title="<%=gi.getGtoImpDes()%>" value="<%=gi.getGtoImpId()%>"><%=gi.getGtoImpDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                        </select>                        </td>
                      <td class="blackText1" align="left" valign="top">&nbsp;</td>
                      <td class="blackText1" align="left" valign="top">&nbsp;</td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="3" align="left" valign="top" class="blackText1">En promedio, &iquest;cu&aacute;l es tu<br />
                         ingreso mensual?</td>
                      </tr>
                    <tr>
                      <td class="blackText1" align="left" valign="top"><select name="ingMens" id="ingMens" class="anchoEstandardSelect" tabindex="28" >
                        <option>-Seleccione-</option>
                        <%
                        try{
                            s = HibernateUtil2.currentSession();
                            it = null;
                         //   tx = s.beginTransaction();
                            q = s.createQuery("from Ing as ing where ing.cal = '4'");
                            it = (Iterator) q.iterate();
                            while (it.hasNext()) {
                                Ing ing = (Ing) it.next();
                                if(cliMta != null){
                                    if(ing.getIngId().intValue() == cliMta.getIngId()){
                        %>
                        <option title="<%=ing.getIngDes()%>" value="<%=ing.getIngId()%>" selected><%=ing.getIngDes()%></option>
                        <%}else{%>
                        <option title="<%=ing.getIngDes()%>" value="<%=ing.getIngId()%>"><%=ing.getIngDes()%></option>
                        <%}}else{%>
                        <option title="<%=ing.getIngDes()%>" value="<%=ing.getIngId()%>"><%=ing.getIngDes()%></option>
                        <%}}}catch(Exception e){
                           e.printStackTrace();
                        }finally{
                            HibernateUtil2.closeSession();
                        }%>
                      </select></td>
                      <td class="blackText1" align="left" valign="top">&nbsp;</td>
                      <td class="blackText1" align="left" valign="top">&nbsp;</td>
                    </tr>
                    </table>
                </fieldset>               </td>
              </tr>
              <tr>
                <td valign="top"></td>
                <td valign="top"></td>
                <td valign="top"></td>
                <td valign="top"></td>
                <td width="71" align="left" valign="top" class="blackText1"></td>
                <td width="1" align="left" valign="top" class="blackText1"></td>
              </tr>
              <tr>
                <td height="2" colspan="8"></td>
              </tr>
              </table>
            <p>&nbsp;</p>
      </fieldset></td>
      </tr>
	    
	    <tr>
	      <td width="315">&nbsp;</td>
      <td width="42" align="center"><!--a href="#" ><img src="../images/accesos_down/aplicacion-23_22.png" name="Image20" width="32" height="32" border="0" id="Image20" /></a--></td>
      <td width="8">&nbsp;</td>
      <td width="51" align="center"><!--a href="#" ><img src="../images/accesos_down/aplicacion-23_24.png" name="Image19" width="32" height="32" border="0" id="Image19" /></a--></td>
      <td width="8">&nbsp;</td>
      <td width="47" align="center"><!--a href="#" ><img src="../images/accesos_down/aplicacion-23_26.png" name="Image18" width="31" height="32" border="0" id="Image18" /></a--></td>
      <td width="8">&nbsp;</td>
      <td width="48" align="center">&nbsp;</td>
      <td width="9">&nbsp;</td>
      <td width="44" align="center">&nbsp;</td>
      <td width="8">&nbsp;</td>
      <td width="36" align="center"><!--a href="#" ><img src="../images/accesos_down/aplicacion-23_32.png" name="Image15" width="33" height="32" border="0" id="Image15" /></a--></td>  
      <td  width="52" align="center"><a onclick="disableForm(false);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img src="../images/acceso/inactivos_add.png" name="add" width="33" height="33" border="0" class="button" id="add" /></a></td>
      <td width="34" align="center">&nbsp;</td>
      <td width="19"><a href="javascript:cancelar();" ><img src="../images/accesos_down/aplicacion-23_28.png" name="Image17" width="33" height="32" border="0" id="Image17" /></a><!--a href="#"><img   src="../images/accesos_down/aplicacion-23_30.png" name="Image16" width="33" height="32" border="0" id="imgGuardarAbajo" class="button"/></a--></td>
      <td width="34"><!--a href="#" ><img src="../images/accesos_down/aplicacion-23_36.png" name="izq" width="32" height="32" border="0" id="izq" /></a--></td>
      <td width="39"><a href="javascript:salir();" ><img src="../images/accesos_down/aplicacion-23_34.png" name="salir2" width="32" height="32" border="0" id="salir2" /></a></td>
      <td width="15">&nbsp;</td>
      <td width="52" align="center"><a href="javascript:ClienteMeta.validarCapturaGeneral();" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('right','','../images/acceso/activos_right.png',1)"><img src="../images/acceso/inactivos_right.png" name="right" width="34" height="33" border="0" class="button" id="right" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('exit','','../images/acceso/activos_exit.png',1)"></a></td>
    </tr>
	    <tr>
	      <td>&nbsp;</td>
      <td align="center" class="blueText"><!--Agregar--></td>
      <td>&nbsp;</td>
      <td align="center" class="blueText"><!--Modificar--></td>
      <td>&nbsp;</td>
      <td align="center" class="blueText"><!--Eliminar--></td>
      <td>&nbsp;</td>
      <td align="center" class="blueText">&nbsp;</td>
      <td>&nbsp;</td>
      <td align="center" class="blueText">&nbsp;</td>
      <td>&nbsp;</td>
      <td align="center" class="blueText"><!--Buscar--></td>
      <td><span class="blueText">Agregar</span></td>
      <td align="center" class="blueText">&nbsp;</td>
      <td><span class="blueText">Cancelar</span></td>
      <td class="blueText" align="center"></td>
      <td><span class="blueText">Salir</span></td>
			<td>&nbsp;</td>
      <td align="center" class="blueText">Siguiente</td>
    </tr>
	    <tr>
	      <td colspan="19">&nbsp;</td>
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