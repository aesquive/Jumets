/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var UtileriasUrbi = { 
	
	STR_URL_INICIO_URBI:"/URBI/",
	
	STR_URL_INICIO_URBI_ENDEUDAMIENTO:"/URBI/endeudamiento/entradadeuda.jsp",
	
	redireccionarInicioEndeudamiento:function(){
		
		window.location=UtileriasUrbi.STR_URL_INICIO_URBI_ENDEUDAMIENTO
		
		
	},
	
	redireccionarInicioURBI:function(){
		
		var strMsj = "¿Esta seguro de querer Salir?";
		
		var boolConfirmSalir = confirm(strMsj);
		
		if (boolConfirmSalir){
		
			window.location=UtileriasUrbi.STR_URL_INICIO_URBI;
			
		} else {
			
		}
		
		
		
	},
	
	XmlHttpObj:null,
	
	 CreateXmlHttpObj:function() {
	/*try {
		UtileriasUrbi.XmlHttpObj = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (exception) {
		try {
			UtileriasUrbi.XmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (oc) {
			UtileriasUrbi.XmlHttpObj = null;
		}
	}
	if (!UtileriasUrbi.XmlHttpObj && typeof XMLHttpRequest != "undefined") {
		UtileriasUrbi.XmlHttpObj = new XMLHttpRequest();
	}*/
	
	 // Create the XMLHttpRequest
   var xHRObject = false;
   if (window.XMLHttpRequest)
   {
       UtileriasUrbi.XmlHttpObj = new XMLHttpRequest();
   }
   else if (window.ActiveXObject)
   {
       UtileriasUrbi.XmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
   }
	
	
},
	
	validarDigitosCodigoPostal:function(strIDCP){
		
		if(document.getElementById(strIDCP).value.length<5){
		//alert("El código postal debe tener 5 dígitos numéricos.");
		document.getElementById(strIDCP).value="";
		document.getElementById(strIDCP).focus();
		return false
	}
		
	},
	
	strIDCP:null,
	
	cargarCodigoPostal:function(strIDCP){
		
	UtileriasUrbi.strIDCP = 	strIDCP;
	
	//alert(UtileriasUrbi.strIDCP)
		
	var cp = document.getElementById(strIDCP).value;
	if (cp.length < 5)
		return false;
	tipoGlobal = 3;
	var requestUrl;
	requestUrl = "../PrimaAjax?idCal=" + cp + "&tipo=3";
	// Crea el objeto XMLHTTP
	UtileriasUrbi.CreateXmlHttpObj();
	if (UtileriasUrbi.XmlHttpObj) {
		UtileriasUrbi.XmlHttpObj.open("GET", requestUrl, true);
		UtileriasUrbi.XmlHttpObj.onreadystatechange = UtileriasUrbi.cargaChangeHandler;
		UtileriasUrbi.XmlHttpObj.send(null);
	}
		
		
	},
	
	cargaChangeHandler: function(){
		if (UtileriasUrbi.XmlHttpObj.readyState == 4) {
			if (UtileriasUrbi.XmlHttpObj.status == 200) {
		 
				UtileriasUrbi.cargaXml(UtileriasUrbi.XmlHttpObj.responseXML.documentElement);
			}
			else {
				alert("No se cargo correctamente el combo!");
			}
		}
	},
	
	cargaXml: function(localidadNode){
	 
	var archivadoLista = UtileriasUrbi.XmlHttpObj.responseXML
			.getElementsByTagName("catalogo")[0];
	var nodo = archivadoLista.getElementsByTagName('prima');
	
	 
			for ( var y = 0; y < nodo.length; y++) {
			var id = nodo(y).getAttribute("id");
			var nombre = nodo(y).text;
			
 
			UtileriasUrbi.definirEstadoInicialContenedorTablaError(false);
			
			document.getElementById("estado").value = id;
			document.getElementById("delegacion").value = nombre;
		 
		 	//	document.getElementById("sexo").focus();
			
			
			
			
		}
		if (nodo.length == 0){
			UtileriasUrbi.SetErrorMessage(1,"Codigo Postal No Valido.");
			document.getElementById("estado").value = "";
			document.getElementById("delegacion").value = "";
			
			 
			
			document.getElementById(UtileriasUrbi.strIDCP).focus();
		}
	//	}    
	},
	
	SetErrorMessage: function (set,text){ 
	
			//alert(set+" "+text);
	
			UtileriasUrbi.definirEstadoInicialContenedorTablaError(true,set,text);
	
	/*
	document.getElementById('tblError').style.display=(set==1?'':'none');
	
	document.getElementById('errorMessage').innerHTML=(set==1?text:'');
	*/
	return false;
	
	},
	
	deshabilitarEnterKeySubmiForm:function (e)
{
     var key;

     if(window.event)
          key = window.event.keyCode;     //IE
     else
          key = e.which;     //firefox

     if(key == 13)
          return false;
     else
          return true;
},
	
	
	
	definirEstadoInicialContenedorTablaError:function(boolEstado,set,text){
		
		//divContenedorTablaError
		
		if (boolEstado==true) {
			
			document.getElementById('divContenedorTablaError').style.display="block"
			document.getElementById('errorMessage').innerHTML=text;
			
		
		//document.getElementById('').innerHTML=""
		
		} else {
		
			document.getElementById('divContenedorTablaError').style.display="none"
			
		}
		
		
		
		
		
	},
	
	
	

    init:function(){
		
		UtileriasUrbi.definirValorInicialIngresoTasaPeriodoPago();
                UtileriasUrbi.definirValorInicialBuro();
		UtileriasUrbi.definirEstadoInicialContenedorTablaError(false);
		

    },
	
	definirValorInicialIngresoTasaPeriodoPago:function(){
		
		document.getElementById('ingreso').value="0.0";
		document.getElementById('tasa').value="0.01";
		document.getElementById('periodoPago').value="1";
		
		
		
		
	},




        definirValorInicialBuro:function(){

            document.getElementById('cuantoMensualidad').value="0.0";
            document.getElementById('cuantoBuro').value="0.0";

        },
	
	capturarSoloNumerosTextoConvertirMayusculas:function(event){
		//[A-Z0-9\.]
		if (UtileriasUrbi.deshabilitarEnterKeySubmiForm(e) == true) {
		
		var code;
if (!e) var e = window.event;
if (e.keyCode) code = e.keyCode;
else if (e.which) code = e.which;
var character = String.fromCharCode(code);
//alert('Character was ' + character);
    //alert(code);
    //if (code == 8) return true;
    //    /[A-Z0-9\.]*/
	
	//old
	//var AllowRegex  = /^[\ba-zA-Z\s-]$/;
	
	var AllowRegex  = /^[\ba-zA-Z0-9\s-]$/;
	
	
    if (AllowRegex.test(character)) {
        key = code;
        if ((key > 0x60) && (key < 0x7B))
        window.event.keyCode = key-0x20;
        return true;
    }
    
     else {
        return false;
    }
		
		
		} else {
			
			return false;
			
		}		
		
		
	},

    capturarSoloTextoConvertirMayusculas:function (e){
		
		if (UtileriasUrbi.deshabilitarEnterKeySubmiForm(e) == true) {
		
		var code;
if (!e) var e = window.event;
if (e.keyCode) code = e.keyCode;
else if (e.which) code = e.which;
var character = String.fromCharCode(code);
//alert('Character was ' + character);
    //alert(code);
    //if (code == 8) return true;
    var AllowRegex  = /^[\ba-zA-Z\s-]$/;
    if (AllowRegex.test(character)) {
        key = code;
        if ((key > 0x60) && (key < 0x7B))
        window.event.keyCode = key-0x20;
        return true;
    }
    
     else {
        return false;
    }
		
		
		} else {
			
			return false;
			
		}
		

        

}
,




capturarSoloNumerosEnteros:function(evt){
	
	if (UtileriasUrbi.deshabilitarEnterKeySubmiForm(evt) == true) {
		
		//evt = event || e;
		
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 48 || charCode > 57))
           {
               return false;
           }

         return true;
		
	
	} else {
		
		return false;
		
	}
	
	  	
		
      },

 capturarSoloNumerosEnterosTasa:function(evt){
 	
	if (UtileriasUrbi.deshabilitarEnterKeySubmiForm(evt) == true) {
		if (!(evt.keyCode == 46 || (evt.keyCode >= 48 && evt.keyCode <= 57))) return false;
    var parts = evt.srcElement.value.split('.');
    if (parts.length > 2) return false;
    if (evt.keyCode == 46) return (parts.length == 1);
    if (parts[0].length >= 14) return false;
    if (parts.length == 2 && parts[1].length >= 2) return false;
	
	} else { 
	
		return false;
		
	}
	

      

 },
 
 capturarSoloNumerosDecimalesIngreso:function(evt){

	if (UtileriasUrbi.deshabilitarEnterKeySubmiForm(evt)==true){
	
	if (!(evt.keyCode == 46 || (evt.keyCode >= 48 && evt.keyCode <= 57))) return false;
    var parts = evt.srcElement.value.split('.');
    if (parts.length > 2) return false;
    if (evt.keyCode == 46) return (parts.length == 1);
    if (parts[0].length >= 14) return false;
    if (parts.length == 2 && parts[1].length >= 2) return false;
		
	} else {
		return false;
	}

    

 },

 validarValorIngreso:function(obj){

	 //alert((parseFloat(obj.value)));

     if (
	 		(parseFloat(obj.value))<= (parseFloat("0.0")) ||
			isNaN((parseFloat(obj.value)))
			
			
		){

         	alert("Por favor verifique el valor del ingreso.");

        	obj.value="0.00";

        	obj.focus();

         	return;

     }
	
	

	//obj.focus();
    
	//obj.value=parseFloat(obj.value).toFixed(2);
	//return;
 },

	asignarFocoPrevioTasaNivelIngreso:function(obj,strIdingreso){
		
		objPrevio = document.getElementById('ingreso');
		
		if(parseFloat(objPrevio.value)<=0){
			objPrevio.focus();
			return;	
		} 
		
	},


 validarValorTasa:function(obj){

     if (parseFloat(obj.value)>=parseFloat(100) || parseFloat(obj.value)<=parseFloat(0.0)  ){

        alert("Por favor verifique el valor de la tasa");

        obj.value="0.01";

        obj.focus();
		
		return;

     }

 },
 
 validarPeriodoPago:function(obj){
 	
	if(parseInt(obj.value) >360 || parseInt(obj.value) ==0 ){
		
		alert("Por favor verifique el valor del periodo de pago, debe de ser mayor a cero y menor a 360");
		
		obj.value=1;
		obj.focus();
		
		return;	
		
	}
	
 },
 validarCuantoTiempo:function(obj){

     /*if (parseInt(obj.value)  ){

        alert("Por favor verifique el valor de la tasa");

        obj.value=0.0;

        obj.focus();

     }

     obj.value=parseFloat(obj.value).toFixed(2);*/
     
 },

 ejecutarValidacionFormaEndeudamiento:function(){
    
    if (UtileriasUrbi.validarFormaNivelEndeudamiento() == true){

        document.getElementById("sbmtBtnFrmEntradaDeuda").click();
    } else {
        return;
    }

 },

 validarFormaNivelEndeudamiento:function(){

    var boolValida = true;

/*   'estado',
   'delegacion',*/

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
   'ingreso',
   'tasa',
   'periodoPago',
   'habitaViviendaActual',
   'laboraEmpleoActual',
   'gastoImp',
   'DineroExt',
   'conoceMtoBuro',
   'cuantoBuro',
   'cuantoMensualidad'
   ];


var arrInvalidos = [];
var strVal="";

   for (var contador = 0; contador<arrCampos.length; contador++){

//alert(arrCampos[contador]);

 strVal = document.getElementById(''+arrCampos[contador]+'').value

       if(
         (strVal  == "" ) ||
        (strVal  == - 1 ) ||
        (strVal  == - 1 ) == null)
        
         {
            arrInvalidos.push(''+document.getElementById(arrCampos[contador])+'');
            boolValida = false
       } 

   }

   if(arrInvalidos.length > 0){
       alert("Favor de capturar todos los campos de la pantalla");
       boolValida = false;
   }

return boolValida;

 }





}


