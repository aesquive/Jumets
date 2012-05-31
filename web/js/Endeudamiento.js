/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 * 
 * 
 * 
 */

var Endeudamiento = {
	
    onClickOnBtnAgregar:function(){
		
        Endeudamiento.habilitarDeshabilitarCampos(true);
	
    },
	
    habilitarDeshabilitarCampos:function(boolHabilitar){

        var arrCampos =  ['apellidoPaterno',
        'apellidoMaterno',
        'nombre',
        'anio',
        'mes',
        'dia',
        'edad',
        'calle',
        'noExterior',
        'noInterior',
        'colonia',
        'codigoPostal',
        'sexo',
        'estadoCivil',
        'tasa',
        'periodoPago',
        'habitaViviendaActual',
        'laboraEmpleoActual',
        'gastoImp',
        'DineroExt',
        'rdgBr',
        'rdgIn'];
                       
        var arrInvalidos = [];
        var strVal="";
			
        if(boolHabilitar == true){
			 
            for (var contador = 0; contador < arrCampos.length; contador++) {
                //alert(arrCampos[contador]);
                try {
                    strVal = document.getElementById('' + arrCampos[contador] + '').disabled = false;
								
                }
                catch (e) {
                }
            }
						
            document.getElementById("apellidoPaterno").focus();

        } else {
		
		
		 

            for (var contador = 0; contador < arrCampos.length; contador++) {
                //alert(arrCampos[contador]);
                try {
                    strVal = document.getElementById('' + arrCampos[contador] + '').disabled = true;
								
                }
                catch (e) {
                }
            }
			
			
			
			
		
		
        }
		
		
    },
	
    onClickOnBtnCancelar:function(){
		
        var strConfirmar= "Esta seguro de cancelar el cálculo del Nivel Máximo de Endeudamiento?";
		
        var boolConfirmar = confirm (strConfirmar)
		
        if(boolConfirmar){
		
            UtileriasUrbi.redireccionarInicioEndeudamiento();
			
        } else {
		
            try {
                document.getElementById("apellidoPaterno").focus();
            } catch (exception){
				 
            }
			 
        }
		
		
		
		
    },
	
	

    init:function(){
		
        Endeudamiento.habilitarDeshabilitarCampos(false);

    // UtileriasUrbi.init();

    /*$(document).ready(function(){
	//Script goes here

        alert("JQUERY LOADED");

        $("#sbmtBtnFrmEntradaDeuda").click(function(){
		return false;
	}); 


}); */

        

    },

    aplicarFormatoMonetario:function(nStr){
        nStr += '';
        x = nStr.split('.');
        x1 = x[0];
        x2 = x.length > 1 ? '.' + x[1] : '';
        var rgx = /(\d+)(\d{3})/;
        while (rgx.test(x1)) {
            x1 = x1.replace(rgx, '$1' + ',' + '$2');
        }
        return "$ "+x1 + x2;
    },

    definirValorTDResultadosCalcularNivelMaximoEndeudamiento:function(strIdTd,strValue){

        var strValue = parseFloat(strValue);

        strValue = Endeudamiento.aplicarFormatoMonetario(strValue.toFixed(2));

        document.getElementById(strIdTd).innerText=strValue;

    },
    
    definirValorTDResultadosCalcularNivelMaximoEndeudamientoPorcentaje:function(strIdTd,strValue){

        var strValue = parseFloat(strValue);

        strValue = (strValue)*parseFloat(100);
  
        strValue = strValue.toFixed(2)

        document.getElementById(strIdTd).innerText=strValue+" %";

    }



    ,

    jsonResultadoCalcularNivelMaximoEndeudamiento:null,

    definirResultadoCalcularNivelMaximoEndeudamiento :function(strXML){

        // respuesta = respuesta.replace("<?xml version='1.0' encoding='UTF-8' standalone='no'?>","");

        respuesta = strXML;

        respuesta = respuesta.replace("<PRE>", "");
        respuesta = respuesta.replace("<pre>", "");
        respuesta = respuesta.replace("</PRE>", "");
        respuesta = respuesta.replace("</pre>", "");
        respuesta = respuesta.replace("'\n'", "");


        var jsonXmlStringParsed = MX.XML.ToJSON(parseXml(respuesta));

    //  Endeudamiento.jsonResultadoCalcularNivelMaximoEndeudamiento = jsonXmlStringParsed;

    //alert(json.SALIDACALCULADORANE.CLI_ID.$value);

    //alert(JSON.stringify(jsonXmlStringParsed, "", ""));

    },

    obtenerResultadoCalcularNivelMaximoEndeudamiento:function(){

        return Endeudamiento.jsonResultadoCalcularNivelMaximoEndeudamiento;

    }

   




}



AIM = {

    frame : function(c)
    {

        var n = 'f' + Math.floor(Math.random() * 99999);
        //alert(n);
        var d = document.createElement('DIV');
        d.innerHTML = '<iframe style="display:none" src="about:blank" id="'+n+'" name="'+n+'" onload="AIM.loaded(\''+n+'\')"></iframe>';
        document.body.appendChild(d);



        var i = document.getElementById(n);
        if (c && typeof(c.onComplete) == 'function')
        {
            i.onComplete = c.onComplete;
        }
        return n;
    },

    form : function(f, name)
    {
        f.setAttribute('target', name);
    },

    submit : function(f, c)
    {

        AIM.form(f, AIM.frame(c));
        if (c && typeof(c.onStart) == 'function')
        {
            return c.onStart();
        }
        else
        {
            return true;
        }
    },

    loaded : function(id)
    {
        var i = document.getElementById(id);
        if (i.contentDocument)
        {
            var d = i.contentDocument;
        }
        else if (i.contentWindow)
        {
            var d = i.contentWindow.document;
        }
        else
        {
            var d = window.frames[id].document;
        }

        if (d.location.href == "about:blank")
        {
            return;
        }

        if (typeof(i.onComplete) == 'function')
        {
            i.onComplete(d.body.innerHTML);
        }
    }
} //end AIM





function startCallback()
{

    return true;
}

function completeCallback(response)
{
    //todo barrer respuesta a json        var respuesta =   response.toLowerCase()  ;

    respuesta = response;

    respuesta = respuesta.replace("<?xml version='1.0' encoding='UTF-8' standalone='no'?>","");
    respuesta = respuesta.replace("<PRE>", "");
    respuesta = respuesta.replace("<pre>", "");
    respuesta = respuesta.replace("</PRE>", "");
    respuesta = respuesta.replace("</pre>", "");
    respuesta = respuesta.replace("'\n'", "");

    jsonXmlStringParsed =xml2json.parser(respuesta);

    var jsonDatosSalidaCalculadoraNE = {
        'SalidaCalculadoraNE': {
            'CLI_ID':jsonXmlStringParsed.salidacalculadorane.cli_id,
            'CLI_SAP':jsonXmlStringParsed.salidacalculadorane.cli_sap,
            'NE_ESPERADO_0y10':jsonXmlStringParsed.salidacalculadorane.ne_esperado_0y10,
            'NE_ESPERADO_1y10':jsonXmlStringParsed.salidacalculadorane.ne_esperado_1y10,
            'NE_ESPERADO_2y10':jsonXmlStringParsed.salidacalculadorane.ne_esperado_2y10,
            'NE_ESPERADO_3y10':jsonXmlStringParsed.salidacalculadorane.ne_esperado_3y10,
            'E_MAX_ESP_10':jsonXmlStringParsed.salidacalculadorane.e_max_esp_10,
            'PC_MAX_10':jsonXmlStringParsed.salidacalculadorane.pc_max_10,
            'NE_ESPERADO_0y15':jsonXmlStringParsed.salidacalculadorane.ne_esperado_0y15,
            'NE_ESPERADO_1y15':jsonXmlStringParsed.salidacalculadorane.ne_esperado_1y15,
            'NE_ESPERADO_2y15':jsonXmlStringParsed.salidacalculadorane.ne_esperado_2y15,
            'NE_ESPERADO_3y15':jsonXmlStringParsed.salidacalculadorane.ne_esperado_3y15,
            'E_MAX_ESP_15':jsonXmlStringParsed.salidacalculadorane.e_max_esp_15,
            'PC_MAX_15':jsonXmlStringParsed.salidacalculadorane.pc_max_15,
            'NE_ESPERADO_0y20':jsonXmlStringParsed.salidacalculadorane.ne_esperado_0y20,
            'NE_ESPERADO_1y20':jsonXmlStringParsed.salidacalculadorane.ne_esperado_1y20,
            'NE_ESPERADO_2y20':jsonXmlStringParsed.salidacalculadorane.ne_esperado_2y20,
            'NE_ESPERADO_3y20':jsonXmlStringParsed.salidacalculadorane.ne_esperado_3y20,
            'E_MAX_ESP_20':jsonXmlStringParsed.salidacalculadorane.e_max_esp_20,
            'PC_MAX_20':jsonXmlStringParsed.salidacalculadorane.pc_max_20
        }
    }



    var strParamJsonDatosSalidaCalculadoraNE = JSON.stringify(jsonDatosSalidaCalculadoraNE);

    //window.location="/URBI/endeudamiento/salidadeuda.jsp?jsonParams="+strParamJsonDatosSalidaCalculadoraNE+"";

    window.location="/URBI/endeudamiento/salidadeuda.jsp";
 
}


function parseXml(xml) {
    var dom = null;
    if (window.DOMParser) {
        try {
            dom = (new DOMParser()).parseFromString(xml, "text/xml");
        }
        catch (e) {
            dom = null;
        }
    }
    else if (window.ActiveXObject) {
        try {
            dom = new ActiveXObject('Microsoft.XMLDOM');
            dom.async = false;
            if (!dom.loadXML(xml)) // parse error ..

                window.alert(dom.parseError.reason + dom.parseError.srcText);
        }
        catch (e) {
            dom = null;
        }
    }
    else
        alert("cannot parse xml string!");
    return dom;
}


/**
 * Convert XML to JSON Object
 * @param {Object} XML DOM Document
 */
/*xml2Json = function(xml) {
 var obj = {};

 if (xml.nodeType == 1) { // element
  // do attributes
  if (xml.attributes.length > 0) {
   obj['@attributes'] = {};
   for (var j = 0; j < xml.attributes.length; j++) {
    obj['@attributes'][xml.attributes[j].nodeName] = xml.attributes[j].nodeValue;
   }
  }

 } else if (xml.nodeType == 3) { // text
  obj = xml.nodeValue;
 }

 // do children
 if (xml.hasChildNodes()) {
  for(var i = 0; i < xml.childNodes.length; i++) {
   if (typeof(obj[xml.childNodes[i].nodeName]) == 'undefined') {
    obj[xml.childNodes[i].nodeName] = xml2Json(xml.childNodes[i]);
   } else {
    if (typeof(obj[xml.childNodes[i].nodeName].length) == 'undefined') {
     var old = obj[xml.childNodes[i].nodeName];
     obj[xml.childNodes[i].nodeName] = [];
     obj[xml.childNodes[i].nodeName].push(old);
    }
    obj[xml.childNodes[i].nodeName].push(xml2Json(xml.childNodes[i]));
   }

  }
 }

 return obj;
};*/

function activaCombos(){
    if (document.frmEntradaDeuda.rdgIn[1].checked == true)
    {

        document.getElementById('cuantoBuro').disabled = true;
        document.getElementById('cuantoMensualidad').disabled = false;
        document.getElementById('ingreso').disabled = true;
        document.getElementById('ingreso').style.backgroundColor = "Gainsboro";
    }
    else
    {
        document.getElementById('cuantoBuro').disabled = true;
        document.getElementById('cuantoMensualidad').disabled = false;
        document.getElementById('ingreso').disabled = false;
        document.getElementById('ingreso').style.backgroundColor = "white";
        document.getElementById('cuantoBuro').style.backgroundColor = "Gainsboro";
        document.getElementById('cuantoMensualidad').style.backgroundColor = "white";
    }

}





function activarCombosBr() {
    if (document.frmEntradaDeuda.rdgBr[1].checked  == true)
    {
        document.getElementById('cuantoBuro').disabled = true;
        document.getElementById('cuantoMensualidad').disabled = false;
        document.getElementById('cuantoBuro').style.backgroundColor = "Gainsboro";
        document.getElementById('cuantoMensualidad').style.backgroundColor = "white";
    }
    else
    {
        document.getElementById('cuantoBuro').disabled = false;
        document.getElementById('cuantoMensualidad').disabled = true;
        document.getElementById('cuantoBuro').style.backgroundColor = "white";
        document.getElementById('cuantoMensualidad').style.backgroundColor = "Gainsboro";

    }

}











jsonParams={
    "SalidaCalculadoraNE":{
        "CLI_ID":0,
        "CLI_SAP":0,
        "NE_ESPERADO_0y10":0,
        "NE_ESPERADO_1y10":0,
        "NE_ESPERADO_2y10":0,
        "NE_ESPERADO_3y10":0,
        "E_MAX_ESP_10":0,
        "PC_MAX_10":0,
        "NE_ESPERADO_0y15":0,
        "NE_ESPERADO_1y15":0,
        "NE_ESPERADO_2y15":0,
        "NE_ESPERADO_3y15":0,
        "E_MAX_ESP_15":0,
        "PC_MAX_15":0,
        "NE_ESPERADO_0y20":0,
        "NE_ESPERADO_1y20":0,
        "NE_ESPERADO_2y20":0,
        "NE_ESPERADO_3y20":0,
        "E_MAX_ESP_20":0,
        "PC_MAX_20":0
    }
}