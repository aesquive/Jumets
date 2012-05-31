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
     <%@page import="java.util.*" %>
    <%@page import="objetos.*" %>
     <%@page import="org.hibernate.*" %>
      <%@page import="com.urbi.util.HibernateUtil2" %>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Cliente Meta</title>

<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<!--<link href="../css/formulario.css" rel="stylesheet" type="text/css" />-->
<script language="javascript" src="../js/funciones.js"></script>
<script language="javascript">

    function validate_form(thisform){
		//if (validate_required(instanceName)==false){
		if(true){
                    SetErrorMessage(1,"Hola Yandy, esto es un error");
                    return false;
		}
		return true;
	}

    function ejecutar(boton, thisform){
                var frm = document.forms[thisform];
                frm.elements["command"].value = boton;

                if(boton == "Modificar"){

                    valor = document.BuscaMeta.clientes.selectedIndex;
                     if( valor == -1){
                         alert("Debe selecionar un cliente para poder continuar");
                         return;
                     }
                     
                      frm.elements["id"].value = document.BuscaMeta.clientes[document.BuscaMeta.clientes.selectedIndex].value;
                    
                }
                document.forms[thisform].submit();
	}

        function habInhabCampo(){

           // alert(document.forms[1].porPersona.cheched);
            if(document.forms[1].porPersona.checked){
                document.forms[1].persona.disabled=false;
            }else{
                document.forms[1].persona.disabled=true;
            }

            if(document.forms[1].porNumero.checked){
                document.forms[1].numero.disabled=false;
            }else{
                document.forms[1].numero.disabled=true;
            }

            if(document.forms[1].porFecha.checked){
                document.forms[1].ano.disabled=false;
                document.forms[1].mes.disabled=false;
            }else{
                document.forms[1].ano.disabled=true;
                document.forms[1].mes.disabled=true;
            }

        }

        function validaCampos(){
            if(document.forms[1].porPersona.checked){
                if(document.forms[1].persona.value ==""){
                    return alert("Debe completar el filtro por persona para continuar con la busqueda");
                }
            }

            if(document.forms[1].porNumero.checked){
                if(document.forms[1].numero.value ==""){
                    return alert("Debe completar el filtro por n�mro para continuar con la busqueda");
                }
            }

            if(document.forms[1].porFecha.checked){
                if(document.forms[1].ano.value ==0){
                    return alert("Debe completar el filtro por persona para continuar con la busqueda");
                }

                if(document.forms[1].mes.value ==0){
                    return alert("Debe completar el filtro por persona para continuar con la busqueda");
                }

                if(!document.forms[1].porFecha.checked &&
                    !document.forms[1].porNumero.checked &&
                    !document.forms[1].porPersona.checked){

                    return alert("Es necesario habilitar al menos un filtro para continuar con la busqueda");

                }
            }

            document.forms[1].submit();

        }
</script>



</head>
<body onload="MM_preloadImages('../images/acceso/activos_add.png','../images/acceso/activos_mas.png','../images/acceso/activos_mod.png','../images/acceso/activos_sup.png','../images/acceso/activo-calc.png','../images/acceso/activos_exit.png','../images/acceso/activo-cal.png','../images/buscar_activo.png','../images/todo_activo.png','../images/acceso/activo-blanco_salir.png')" >
<form name="MetaIndex" method="post" action="../MetaClienteServlet" onsubmit="return validate_form(this)">
    <input type="hidden" name="command" value=""></input>
    <input type="hidden" name="form" value="MetaIndex"></input>
    <input type="hidden" name="id"></input>
</form>
 <form name="BuscaMeta" method="post" action="../BuscarMetaServlet">
<center>
<div id="contenedor">
  <div id="encabezado">
    <div id="borde_iz"></div>
	<div id="logo"></div>
	<div id="relleno">
	<div id="capa_enc">

	 <table width="321" border="0" valign="right" cellpadding="0" cellspacing="0" class="whiteSubtitle">
	   <tr>
	     <td colspan="9" align="center" class="blueSubtitle">&nbsp;</td>
         </tr>
	   <tr>
	     <td colspan="9" align="center" class="blueSubtitle">Cliente Meta</td>
          </tr>
	   <tr>
	     <td colspan="9" align="center" class="whiteSubtitle">Mantenimiento a Personas</td>
          </tr>
	   <tr>
	     <td colspan="9" align="center" class="whiteSubtitle">&nbsp;</td>
         </tr>
	   <tr>
	     <td width="33" align="center">&nbsp;</td>
           <td width="15">&nbsp;</td>
           <td width="35" align="center"><a onclick="ejecutar('Agregar', 'MetaIndex')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('add','','../images/acceso/activos_add.png',1)"><img src="../images/acceso/inactivos_add.png" name="add" width="33" height="33" border="0" class="button" id="add" /></a></td>
           <td width="15">&nbsp;</td>
           <td width="42" align="center"><!--<a onclick="ejecutar('Eliminar', 'MetaIndex')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('delete','','../images/acceso/activos_sup.png',1)"><img src="../images/acceso/inactivos_sup.png" name="delete" width="33" height="33" border="0" class="button" id="delete" /></a>-->
             <a onclick="ejecutar('Modificar', 'MetaIndex')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('mod','','../images/acceso/activos_mod.png',1)"><img src="../images/acceso/inactivos_mod.png" name="mod" width="35" height="33" border="0" class="button" id="mod" /></a></td>
           <td width="15">&nbsp;</td>
           <td width="32" align="center"><a onclick="ejecutar('Calcular', 'MetaIndex')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('calc','','../images/acceso/activo-calc.png',1)"><img src="../images/acceso/inactivo-calc.png" name="calc" width="32" height="32" border="0" class="button" id="calc" /></a></td>
           <td width="15">&nbsp;</td>
            <td width="32" align="center"><a href="masivometa.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('mas','','../images/acceso/activos_mas.png',1)"><img src="../images/acceso/inactivos_mas.png" name="mas" width="32" height="32" border="0" class="button" id="mas" /></a></td>
           <td width="15">&nbsp;</td>
           <td width="33" align="center"><a href="../index_autent.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('salir','','../images/acceso/activos_salir.png',1)"><img src="../images/acceso/inactivos_salir.png" name="salir" width="32" height="33" border="0" class="button" id="salir" /></a></td>
         </tr>
	   <tr>
	     <td class="whiteText" align="center">&nbsp;</td>
           <td class="whiteTitle"></td>
           <td class="whiteText" align="center">Agregar</td>
           <td class="whiteTitle"></td>
           <td class="whiteText" align="center">Modificar</td>
           <td class="whiteTitle"></td>
           <td class="whiteText" align="center">Calcular</td>
           <td class="whiteTitle"></td>
           <td class="whiteText" align="center">Masivo</td>
           <td class="whiteTitle"></td>
           <td class="whiteText" align="center">Salir</td>
         </tr>
	   </table>

	 <p><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('calc','','../images/acceso/activo-cal.png',1)"></a></p>
	</div>
	</div>	
	<div id="borde_der"></div>
	<div id="contenido">
	
	<p>
	  
	<table width="888" border="0" align="center" cellpadding="0" cellspacing="0">
	    <tr>
	      <td width="207" rowspan="15" align="left" valign="top"><select name="clientes" multiple="multiple" size="20" class="lista_200">
	        <%

                Session s = null;
                //Transaction tx = null;

                try{

                            List q = new ArrayList();
                            if(request.getSession().getAttribute("clientes") == null){

                                 s = HibernateUtil2.currentSession();
                               //)  tx = s.beginTransaction();
                                q = s.createQuery("select c from Cli as c, CliMta2 mta where mta.cli.cliId = c.cliId order by c.cliId desc").list();
                                System.out.println("no hay filtro activo");

                            }else{
                                
                                q = (List) request.getSession().getAttribute("clientes");
                                request.getSession().removeAttribute("clientes");
                            }
                            
                            Iterator it = (Iterator) q.iterator();
                            while (it.hasNext()) {
                                Cli c= (Cli) it.next();
                        %>
	        <option value="<%=c.getCliId()%>"><%=c.getCliApePat() + " " + c.getCliApeMat() + " " + c.getCliNom()%></option>
	        <%}}catch(Exception e){
                   e.printStackTrace();
                }finally{
                    HibernateUtil2.closeSession();
                }%>
	        </select></td>
          <td width="17" rowspan="14">&nbsp;</td>
          <td colspan="6" valign="top">&nbsp;</td>
        </tr>
	    <!--tr>
	      <td colspan="6" valign="top"><div align="justify">
	        <input name="textfield" type="text" size="105"/>
	        </div></td>
        </tr-->
	    <tr>
	      <td colspan="6" valign="top">&nbsp;</td>
        </tr>
	    <tr>
	      <td colspan="6" valign="top" class="blackSubtitle" align="left">Criterios de b&uacute;squeda para Persona </td>
        </tr>
	    <tr>
	      <td colspan="6" valign="top">&nbsp;</td>
        </tr>
	    
	    <tr>
	      <td width="20" align="left" valign="middle" class="blackText1">
                  <input type="checkbox" onchange="habInhabCampo();" name="porNumero" id="porNumero" value="1" /></td>
          <td width="131" align="left" valign="middle" class="blackText1">por N&uacute;mero</td>
          <td colspan="4" align="" valign="top"><div align="justify">
                  <input name="numero" id="numero" type="text" size="80" disabled/>
            </div></td>
        </tr>
	    <tr>
	      <td colspan="2" align="left" valign="top">&nbsp;</td>
          <td colspan="4" align="" valign="top">&nbsp;</td>
        </tr>
	    <tr>
	      <td align="left" valign="middle" class="blackText1">
	        <input type="checkbox" onchange="habInhabCampo();" name="porPersona" id="porPersona" value="2" /></td>
          <td align="left" valign="middle" class="blackText1">por Persona</td>
          <td colspan="4" align="" valign="top"><div align="justify">
                  <input name="persona" id="persona" type="text" size="80" disabled />
            </div></td>
        </tr>
	    <tr>
	      <td colspan="2" align="left" valign="top">&nbsp;</td>
          <td colspan="4" align="" valign="top">&nbsp;</td>
        </tr>
	    <!--tr>
	      <td align="left" valign="middle" class="blackText1">
	        <input type="checkbox" name="porUsuario" id="porUsuario" value="3" /></td>
          <td align="left" valign="middle" class="blackText1">por Usuario</td>
          <td colspan="4" align="" valign="top"><div align="justify">
            <select name="usuario" id="usuario" size="1">
                <option value="">-Seleccione-</option>
              </select>
            </div></td>
        </tr>
	    <tr>
	      <td colspan="2" align="left" valign="top">&nbsp;</td>
          <td colspan="4" align="" valign="top">&nbsp;</td>
        </tr-->
	    <tr>
	      <td align="left" valign="middle" class="blackText1">
	        <input type="checkbox" onchange="habInhabCampo();" name="porFecha" id="porFecha" value="4" /></td>
          <td align="left" valign="middle" class="blackText1">por Fecha</td>
          <td align="" valign="top"><div align="justify">
                  <select name="ano" id="ano" disabled>
                <option value="0">-A&ntilde;o-</option>
                <%
                for(int i=1;i<50;i++){
                   int ano = 1945 +i;

                %>
                <option value="<%=ano%>"><%=ano%></option><%}%>
              </select>
              <select name="mes" id="mes" disabled>
                <option value="0">-Mes-</option>
              <option VALUE="01">Enero</option>
              <option VALUE="02">Febrero</option>
              <option VALUE="03">Marzo</option>
              <option VALUE="04">Abril</option>
              <option VALUE="05">Mayo</option>
              <option VALUE="06">Junio</option>
              <option VALUE="07">Julio</option>
              <option VALUE="08">Agosto</option>
              <option VALUE="09">Septiembre</option>
              <option VALUE="10">Octubre</option>
              <option VALUE="11">Noviembre</option>
              <option VALUE="12">Diciembre</option>
              </select>
            </div></td>
          <td align="" valign="top"><div align="center"><a href="javascript:validaCampos();" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('buscar','','../images/buscar_activo.png',1)"><img src="../images/buscar_inactivo.png" name="buscar" width="32" height="32" border="0" class="textarea" id="buscar" /></a></div></td>
          <td align="" valign="top">&nbsp;</td>
          <td align="" valign="top"><div align="center"><a href="javascript:location.reload(true);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('todo','','../images/todo_activo.png',1)"><img src="../images/todo_inactivo.png" name="todo" width="32" height="32" border="0" class="textarea" id="todo" /></a></div></td>
        </tr>
	    <tr>
	      <td colspan="2" align="left" valign="top">&nbsp;</td>
          <td width="368" valign="top">&nbsp;</td>
          <td width="59" valign="top"><div align="right"><span class="blueSubtitle">Buscar</span></div></td>
          <td width="15" valign="top">&nbsp;</td>
          <td width="71" valign="top"><div align="right"><span class="blueSubtitle">Ver Todos</span></div></td>
        </tr>
	    <tr>
	      <td colspan="2" align="left" valign="top">&nbsp;</td>
          <td valign="top" class="blueSubtitle">&nbsp;</td>
          <td valign="top" class="blueSubtitle">&nbsp;</td>
          <td valign="top" class="blueSubtitle">&nbsp;</td>
          <td valign="top" class="blueSubtitle">&nbsp;</td>
        </tr>
	    </table>
	</p>
	</div>
	<div id="pie_pag"></div>
</div>
</div>
</center>
</form>
</body>
</html>
