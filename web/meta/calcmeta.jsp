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
<%@page import="de.laures.cewolf.DatasetProducer"%>
<%@page import="com.urbi.prima.Bean3dChart"%>
<%@page import="com.urbi.util.HibernateUtil2" %>
<%@taglib uri="cewolf" prefix="cewolf"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Cliente Meta</title>
<script language="javascript" src="js/funciones.js"></script>

<link href="../css/main2.css" rel="stylesheet" type="text/css" />
<link href="../css/textos.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/funciones.js"></script>

<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">
<!--

function calcula(){

    id=document.forms[0].clientes.options[document.forms[0].clientes.selectedIndex].value;
    //alert(id);
    document.forms[0].idCliente.value=id;
    document.forms[0].submit();
}


function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->

//ERROL 27/04/2010
function redondearValorEntero(number){  
  return Math.round(  // round to nearest integer 
    Number(number)    // type cast your input 
  );  
};

function convertirValorDecimalToFixed(number){
		try{
		
		//respuesta = respuesta.replace("<PRE>", "");
		
		var strNumber= new String (number);
		strNumber = strNumber.replace("$","");
		strNumber = parseFloat(strNumber);
		
		strNumber= strNumber.toFixed(2);
		
		return strNumber
		
			
		
			 
		
		}catch (e){
		}
		

}

function asignarValorCampo(strId,valor){
 document.getElementById(strId).value=valor
 
}

function obtenerValorCampo(strId){
	return document.getElementById(strId).value
}

function onLoadOnCalcMeta(){
	

	asignarValorCampo ("comportamientoPago", redondearValorEntero(obtenerValorCampo("comportamientoPago")));
	
	asignarValorCampo ("generoClase", redondearValorEntero(obtenerValorCampo("generoClase")));
	
	//arraigo
	asignarValorCampo ("arraigo", redondearValorEntero(obtenerValorCampo("arraigo")));
	
	//aspectosDiferenciadores 
	asignarValorCampo ("aspectosDiferenciadores", redondearValorEntero(obtenerValorCampo("aspectosDiferenciadores")));

//convertirValorDecimalToFixed

//cuotaPuraRiesgo
	//asignarValorCampo ("cuotaPuraRiesgo", convertirValorDecimalToFixed(obtenerValorCampo("cuotaPuraRiesgo")));
	
	//cuotaPuraRiesgoRecargaEstado
	//asignarValorCampo ("cuotaPuraRiesgoRecargaEstado", convertirValorDecimalToFixed(obtenerValorCampo("cuotaPuraRiesgoRecargaEstado")));
	
	//primaPuraRiesgo
	//asignarValorCampo ("primaPuraRiesgo", "$ "+convertirValorDecimalToFixed(obtenerValorCampo("primaPuraRiesgo")));
	
	//primaPuraRiesgoRecargoEstado
	//asignarValorCampo ("primaPuraRiesgoRecargoEstado", "$ "+convertirValorDecimalToFixed(obtenerValorCampo("primaPuraRiesgoRecargoEstado")));
	
	
}

</script>

<link href="../css/formulario.css" rel="stylesheet" type="text/css" />
</head>
<%
	String GENERO = "0";
	String COMPORTAMIENTO_PAGO = "0";
	String ARRAIGO = "0";
	String ASPECTOS_DIF = "0";
        String GENERO_TEXTO1 = "0";
        String GENERO_TEXTO2 = "0";
        String COMP_TEXTO1 = "0";
        String COMP_TEXTO2 = "0";
        String ARRAIGO_TEXTO1 = "0";
        String ARRAIGO_TEXTO2 = "0";
        String ASP_DIF_TEXTO1 = "0";
        String ASP_DIF_TEXTO2 = "0";
        String CUOTA_PURA = "0";
        String CUOTA_RECAR = "0";
        String PRIMA_PURA = "0";
        String PRIMA_RECAR = "0";
        String ID_CLI = "0";
        String RESULTADO ="";

        if(request.getSession().getAttribute("genero") != null){
            GENERO = (String) request.getSession().getAttribute("genero");
            request.getSession().removeAttribute("genero");
        }

        if(request.getSession().getAttribute("comportamiento") != null){
            COMPORTAMIENTO_PAGO = (String) request.getSession().getAttribute("comportamiento");
            request.getSession().removeAttribute("comportamiento");
        }

       if(request.getSession().getAttribute("arraigo") != null){
            ARRAIGO = (String) request.getSession().getAttribute("arraigo");
            request.getSession().removeAttribute("arraigo");
        }

       if(request.getSession().getAttribute("aspDif") != null){
            ASPECTOS_DIF = (String) request.getSession().getAttribute("aspDif");
            request.getSession().removeAttribute("aspDif");
        }

        if(request.getSession().getAttribute("generoTexto1") != null){
            GENERO_TEXTO1 = (String) request.getSession().getAttribute("generoTexto1");
            request.getSession().removeAttribute("generoTexto1");
        }
        if(request.getSession().getAttribute("generoTexto2") != null){
            GENERO_TEXTO2 = (String) request.getSession().getAttribute("generoTexto2");
            request.getSession().removeAttribute("generoTexto2");
        }
        if(request.getSession().getAttribute("compTexto1") != null){
            COMP_TEXTO1 = (String) request.getSession().getAttribute("compTexto1");
            request.getSession().removeAttribute("compTexto1");
        }
        if(request.getSession().getAttribute("compTexto2") != null){
            COMP_TEXTO2 = (String) request.getSession().getAttribute("compTexto2");
            request.getSession().removeAttribute("compTexto2");
        }
        if(request.getSession().getAttribute("arraigoTexto1") != null){
            ARRAIGO_TEXTO1 = (String) request.getSession().getAttribute("arraigoTexto1");
            request.getSession().removeAttribute("arraigoTexto1");
        }
        if(request.getSession().getAttribute("arraigoTexto2") != null){
            ARRAIGO_TEXTO2 = (String) request.getSession().getAttribute("arraigoTexto2");
            request.getSession().removeAttribute("arraigoTexto2");
        }
        if(request.getSession().getAttribute("aspDifTexto1") != null){
            ASP_DIF_TEXTO1 = (String) request.getSession().getAttribute("aspDifTexto1");
            request.getSession().removeAttribute("aspDifTexto1");
        }
        if(request.getSession().getAttribute("aspDifTexto2") != null){
            ASP_DIF_TEXTO2 = (String) request.getSession().getAttribute("aspDifTexto2");
            request.getSession().removeAttribute("aspDifTexto2");
        }
  /*      if(request.getSession().getAttribute("cuotaPura") != null){
            CUOTA_PURA = (String) request.getSession().getAttribute("cuotaPura");
            request.getSession().removeAttribute("cuotaPura");
        }
        if(request.getSession().getAttribute("cuotaRecar") != null){
            CUOTA_RECAR = (String) request.getSession().getAttribute("cuotaRecar");
            request.getSession().removeAttribute("cuotaRecar");
        }
        if(request.getSession().getAttribute("primaPura") != null){
            PRIMA_PURA = (String) request.getSession().getAttribute("primaPura");
            request.getSession().removeAttribute("primaPura");
        }

        if(request.getSession().getAttribute("primaPuraRec") != null){
            PRIMA_RECAR = (String) request.getSession().getAttribute("primaPuraRec");
            request.getSession().removeAttribute("primaPuraRec");
        }
*/
        if(request.getSession().getAttribute("idCli") != null){
            ID_CLI = (String) request.getSession().getAttribute("idCli");
            request.getSession().removeAttribute("idCli");
        }

        if(request.getSession().getAttribute("resultado") != null){
            RESULTADO = (String) request.getSession().getAttribute("resultado");
            request.getSession().removeAttribute("resultado");
        }


		DatasetProducer categoryData = new Bean3dChart(Double.parseDouble(COMPORTAMIENTO_PAGO),Double.parseDouble(GENERO),Double.parseDouble(ARRAIGO),Double.parseDouble(ASPECTOS_DIF), "Tipos de Documentos");
		pageContext.setAttribute("categoryDataChar", categoryData);
	
%>
<body onload="MM_preloadImages('../images/acceso/activo-blanco_salir.png'); onLoadOnCalcMeta()" >
    <form method="post" action="../CalculaMetaServlet" name="calculaMeta">
        <input type="hidden" name="idCliente" id="idCliente"></input>
<center>
<div id="contenedor">
  <div id="encabezado">
    <div id="borde_iz"></div>
	<div id="logo"></div>
	<div id="relleno">
	<div id="capa_enc">
		
	  <table width="321" border="0" valign="right" cellpadding="0" cellspacing="0" class="whiteSubtitle">
	    <tr>
	      <td width="226" colspan="9" align="center" class="blueSubtitle">&nbsp;</td>
        </tr>
	    <tr>
	      <td colspan="9" align="center" class="blueSubtitle">Cliente Meta</td>
        </tr>
	    <tr>
	      <td colspan="9" align="center" class="whiteSubtitle">Calcular Cliente Meta </td>
        </tr>
	    <tr>
	      <td colspan="9" align="center" class="whiteSubtitle">&nbsp;</td>
        </tr>
		<TR>      <td colspan="9" rowspan="2" align="left" valign="bottom" class="blackSmallText"><div align="right"><a href="metaindex.jsp" ><img src="../images/acceso/inactivos_salir.png" name="salir" width="32" height="33" border="0" class="button" id="salir" /></a><a href="metaindex.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('salir','','../images/acceso/activo-blanco_salir.png',1)"></a><br />
        <span class="whiteText" style="text-align:right">Salir&nbsp;&nbsp;</span></div></td></TR>
       </table>
    	</div>
	</div>	
	<div id="borde_der"></div>
	<div id="contenido">
	
	  <table width="822" border="0" align="center" cellpadding="0" cellspacing="0">  
	    <tr>
	      <td align="left" valign="top">&nbsp;</td>
      </tr>
	    <tr>
	      <td width="207" rowspan="22" align="left" valign="top">
                  <select name="clientes" multiple="multiple" size="20" class="lista_200" onchange="calcula();">
	        <%
                 Session s = null;
                 //Transaction tx =null;
                try{

                            List q = new ArrayList();
                            if(request.getSession().getAttribute("clientes") == null){

                                s = HibernateUtil2.currentSession();
                                //tx = s.beginTransaction();
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
	        </select> <br>
                    <span style="color:red; font-size:15px;"><%=RESULTADO%></span>    </td>
      </tr>
	    
	    <tr>
	      <td width="3" height="27" rowspan="16" align="left" valign="top"></td>
        <td height="27" colspan="11" rowspan="16" align="left" valign="top"><fieldset>
          <table width="443" height="277" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="15" valign="top">&nbsp;</td>
            </tr>
            <tr>
                <td height="16" valign="top">
                    <%
                    Session ses = null;
                    //Transaction trans = null;
                    try{
                        Cli cliente = new Cli();
                        if(!ID_CLI.equals("0")){
                            ses = HibernateUtil2.currentSession();
                            //trans = ses.beginTransaction();
                            cliente = (Cli) ses.createQuery("from Cli as cli where cli.cliId=" + ID_CLI).uniqueResult();
                    %>
                    <input name="textfield" type="text" size="65" readonly value="<%=cliente.getCliNom() + " " + cliente.getCliApePat() + " " + cliente.getCliApeMat()%>" />
                    <%}else{%>
                    <input name="textfield" type="text" size="65" readonly/>
                    <%}}catch(Exception e){
                    e.printStackTrace();
                }finally{
                    HibernateUtil2.closeSession();
                }%>
                    </td>

            </tr>
            <tr>
              <td height="2" valign="top">&nbsp;</td>
            </tr>
            <tr>
              <td valign="top"><fieldset>
                <table width="435" height="221" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="293" rowspan="13" valign="top"><!--img src="../images/tabla.png" width="286" height="230" /-->

                        <!-- GRAFICA -->
                            <cewolf:chart 	id="horizontalBarChart3D"
                                                            title="Gráfica Meta" type="horizontalBar3D"
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
                    </td>
                    
                    <td width="10" class="blackText1" style="font-weight:bold" align="center">&nbsp;</td>
                    <td width="149" class="blackText1" style="font-weight:bold" align="center">Composici&oacute;n</td>
                  </tr>
                  <tr>
                    <td align="justify" class="blackSmallText">&nbsp;</td>
                    <td align="justify" class="blackSmallText">Comportamiento de Pago:</td>
                  </tr>
                  <tr>
                    <td align="justify" class="blackSmallText">&nbsp;</td>
                    <td align="justify" class="blackSmallText"><img src="../images/colores_02.png" width="18" height="18" align="absbottom" />
                        <input name="textfield532" type="text" class="textarea" size="12" readonly value="<%=COMPORTAMIENTO_PAGO%>" id="comportamientoPago" />                </td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td align="justify" class="blackSmallText">&nbsp;</td>
                    <td align="justify" class="blackSmallText">G&eacute;nero y Clase:</td>
                  </tr>
                  <tr>
                    <td align="justify" class="blackSmallText">&nbsp;</td>
                    <td align="justify" class="blackSmallText"><img src="../images/colores_10.png" width="18" height="18" align="absbottom" />
                        <input name="textfield5322" id="generoClase" type="text" class="textarea" size="12" value="<%=GENERO%>" readonly />                </td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td align="justify" class="blackSmallText">&nbsp;</td>
                    <td align="justify" class="blackSmallText">Arraigo:</td>
                  </tr>
                  <tr>
                    <td align="justify" class="blackSmallText">&nbsp;</td>
                    <td align="justify" class="blackSmallText"><img src="../images/colores_08.png" width="18" height="18" align="absbottom" />
                        <input name="textfield53222" id="arraigo" type="text" class="textarea" size="12" value="<%=ARRAIGO%>" readonly/>                </td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td align="justify" class="blackSmallText">&nbsp;</td>
                    <td align="justify" class="blackSmallText">Aspectos Diferenciadores:</td>
                  </tr>
                  <tr>
                    <td align="justify" class="blackSmallText">&nbsp;</td>
                    <td align="justify" class="blackSmallText"><img src="../images/colores_06.png" width="18" height="18" align="absbottom" />
                        <input name="textfield532222" id="aspectosDiferenciadores" type="text" class="textarea" size="12" value="<%=ASPECTOS_DIF%>" readonly/>                </td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                </table>
              </fieldset> </td>
            </tr>
          </table>
          </fieldset></td>
                            <td width="166" align="justify" valign="top"><input name="textfield5" readonly type="text" class="textarea" size="25" value="<%=GENERO_TEXTO1%>" /></td>
      </tr>
	    <tr>
	      <td align="justify" valign="top">&nbsp;</td>
      </tr>
	    <tr>
                <td align="justify" valign="top"><input readonly name="textfield52" type="text" class="textarea" size="25" value="<%=GENERO_TEXTO2%>" /></td>
      </tr>
	    <tr>
	      <td align="justify" valign="top">&nbsp;</td>
      </tr>
	    <tr>
                <td align="justify" valign="top"><input readonly name="textfield58" type="text" class="textarea" size="25" value="<%=COMP_TEXTO1%>" /></td>
      </tr>
	    <tr>
	      <td align="justify" valign="top">&nbsp;</td>
      </tr>
	    <tr>
                <td align="justify" valign="top"><input readonly name="textfield53" type="text" class="textarea" size="25" value="<%=COMP_TEXTO2%>" /></td>
      </tr>
	    <tr>
	      <td align="justify" valign="top">&nbsp;</td>
      </tr>
	    <tr>
                <td align="justify" valign="top"><input readonly name="textfield54" type="text" class="textarea" size="25" value="<%=ARRAIGO_TEXTO1%>" /></td>
      </tr>
	    <tr>
	      <td align="justify" valign="top">&nbsp;</td>
      </tr>
	    <tr>
                <td align="justify" valign="top"><input readonly name="textfield55" type="text" class="textarea" size="25" value="<%=ARRAIGO_TEXTO2%>" /></td>
      </tr>
	    <tr>
	      <td align="justify" valign="top">&nbsp;</td>
      </tr>
	    <tr>
                <td align="justify" valign="top"><input readonly name="textfield56" type="text" class="textarea" size="25" value="<%=ASP_DIF_TEXTO1%>" /></td>
      </tr>
	    <tr>
	      <td align="justify" valign="top">&nbsp;</td>
      </tr>
	    <tr>
                <td align="justify" valign="top"><input readonly name="textfield57" type="text" class="textarea" size="25" value="<%=ASP_DIF_TEXTO2%>" /></td>
      </tr>
	    <tr>
	      <td height="14" align="justify" valign="top">&nbsp;</td>
      </tr>
	    <tr>
	      <td height="14" colspan="13" valign="top" align="center">&nbsp;</td>
      </tr>
	    <tr>
	      <td colspan="2" rowspan="2" align="left" valign="top" class="blackSmallText">&nbsp;</td>
      <td width="119" rowspan="2" align="left" valign="top" class="blackSmallText"><!--div align="left">Cuota Pura de Riesgo:</div--></td>
      <td width="90" align="left" valign="top" class="blackSmallText">
        <div align="right">
            <!--input readonly style="width: 100px;" id="cuotaPuraRiesgo" name="textfield5323" type="text" size="12" align="top" value="<%//=CUOTA_PURA%>"/-->
          </div></td>
      <td width="4" align="left" valign="top">&nbsp;</td>
      <td width="152" align="right" valign="top"><!--div align="right"><span class="blackSmallText">Cuota Pura de Riesgo <br />
        con recargo por estado:</span></div--></td>
      <td width="4" align="right" valign="top">&nbsp;</td>
      <td width="72" align="left" valign="top"><span class="blackSmallText">
              <!--input readonly id="cuotaPuraRiesgoRecargaEstado" style="width: 100px;" name="textfield53233" type="text" size="12" align="top" value="<%//=CUOTA_RECAR%>"/-->
        </span></td>
      <td height="2" colspan="5" align="left" valign="bottom" class="blackSmallText">&nbsp;</td>
      </tr>
	    <tr>
	      <td colspan="4" align="left" valign="top">&nbsp;</td>
      <td width="72" align="left" valign="top">&nbsp;</td>
      <td colspan="5" align="left" valign="top" class="blackSmallText">&nbsp;</td>
    </tr>
	    
	    <tr>
	      <td colspan="2" rowspan="2" align="left" valign="top" class="blackSmallText">&nbsp;</td>
      <td rowspan="2" align="left" valign="top" class="blackSmallText"><!--div align="left">Prima Pura de Riesgo:</div--></td>
      <td align="left" valign="top"><div align="right"><span class="blackSmallText">
                  <!--input readonly style="width: 100px;" id="primaPuraRiesgo" name="textfield53232" type="text" size="12" align="top" value="<%//=PRIMA_PURA%>" /-->
        </span></div></td>
      <td align="left" valign="top">&nbsp;</td>
      <td align="right" valign="top"><!--div align="right"><span class="blackSmallText">Prima Pura de Riesgo <br />
        con recargo por estado:</span></div--></td>
      <td align="right" valign="top">&nbsp;</td>
      <td width="72" align="left" valign="top"><span class="blackSmallText">
              <!--input readonly style="width: 100px;" id="primaPuraRiesgoRecargoEstado" name="textfield532332" type="text" size="12" value="<%//=PRIMA_RECAR%>" /-->
        </span></td>
      <td colspan="5" rowspan="2" align="left" valign="bottom" class="blackSmallText"><div align="right"><a href="metaindex.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('salir','','../images/acceso/activo-blanco_salir.png',1)"><img src="../images/acceso/inactivo-blanco_salir.png" name="salir" width="30" height="30" border="0" id="salir" /></a><br />
        <span class="blueSubtitle">Salir</span></div></td>
    </tr>
	    
	    
	    
	    <tr>
	      <td colspan="4" align="left" valign="top">&nbsp;</td>
      <td width="72" align="left" valign="top">&nbsp;</td>
      </tr>
      </table>    
	</div>
	<div id="pie_pag"></div>
</div>
</form>
</body>

</html>
