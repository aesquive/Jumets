/**
 * @author alvarerr  
 */

 var ClienteMeta = {
 	
	validarClienteMeta : function (objForm){
		
		return true;
		
		
	},
	
	validarArraigoViviendaActual:function(obj){
		
		//alert(obj)
		

		var str="El valor de la vivienda actual no puede ser mayor a la edad";
		
		var strMsgDefault = "Para validar el valor del Arraigo de la vivienda es necesario capturar la edad";
		
		var valEdad = parseInt(document.getElementById("edad").value);
		
		if(!isNaN(valEdad)){
	
			if(valEdad>obj.value ){
				
				alert(strMsgDefault); 
				
				//obj.focus();
				
				return false;
				
			} 
						
		} else {
			alert(strMsgDefault);
			return false;
		}
		
		return true;
		
	/*	if ( parseInt(obj.value)> ){
			
		}*/
		
		
	},
	
	validarArraigoEmpleoActual:function(obj){
		//alert(obj)

		var str="El valor del empleo actual no puede ser mayor a la edad";
		
		var strMsgDefault = "Para validar el valor del Arraigo del Empleo es necesario capturar la edad";
		
		var valEdad = parseInt(document.getElementById("edad").value);
		
		if(!isNaN(valEdad)){
	
			if(valEdad>obj.value ){
				
				alert(strMsgDefault); 
				
				//obj.focus();
				
				return false;
				
			}  
						
		} else {
			alert(strMsgDefault);
			//obj.focus();
			return false;
		}
		
		return true;

		
	/*	if ( parseInt(obj.value)> ){
			
		}*/		
		
		
	
	},

	definirEstiloCampoValidado:function(strId,boolValido){
		
		if (boolValido == true ){
			
			document.getElementById(strId).style.backgroundColor="white";
			
		} else {
			
			document.getElementById(strId).style.backgroundColor="#FFD700";
			
			
		}
		
	},
	

 arrElementos : [
			'rfc',
			'apellidoPaterno',
			'apellidoMaterno',
			'Nombre',
			'anio',
			'mes',
			'dia',
			'edad',
			'calle',
			'noExterior',
			'noInterior',
			'colonia',
			'codigoPostal',
			'religion',
			'sexo',
			'estadoCivil',
			'nEstdio',
			'tipoRes',
			'tiempoVivienda',
			'tiempoEmpleo',
			'mov',
			'prestamo',
			'mejorPartido',
			'relAfe',
			'opinionApoDe',
			'partAsoc',
			'dependenciaEco',
			'actividadExt',
			'DineroExt',
			'gastoImp',
			'ingMens',
			'rdgTC'
		
		],
		
		//,	'rdgProblemaB'
		
		arrRdgTC : [
				'mesVencido',
				'pcuso',
				'pcPago'
			]
		,
		
		arrRdgProblemaB : [
			'buroAct',
			'buroUso',
			'buroHist',
			'buroPago',
			'buroAnt'
		],	
	
	habilitarDeshabilitarCamposClienteMeta:function(boolHabilitar){
	
		var arrElementoslength = ClienteMeta.arrElementos.length;
	
			try {
			
				for (var contador = 0; contador < arrElementoslength; contador++) {
				
					document.getElementById('' + ClienteMeta.arrElementos[contador] + '').disabled = boolHabilitar;
					
				}
			} catch(e){
				
			}	
		 
	},
	
	habilitarDeshabilitarCamposClienteMetaRdgTC:function(boolHabilitar){
	
		var arrElementosRdgTClength = ClienteMeta.arrElementos.length;
	
			try {
			
				/*for (var contador = 0; contador < arrElementosRdgTClength; contador++) {
				
					document.getElementById('' + ClienteMeta.arrElementos[contador] + '').disabled = boolHabilitar;
					
				}*/
			
				//document.getElementById('' + ClienteMeta.arrElementos[contador] + '').disabled = boolHabilitar;
				
				document.getElementsByName("rdgTC")[0].disabled = boolHabilitar;
		
				document.getElementsByName("rdgTC")[1].disabled = boolHabilitar;
		
			} catch(e){
				
			}	
		 
	},	
	
	onSubmitOnFrmClienteMeta:function(){
		
	 
		
		if (ClienteMeta.validarClienteMeta()==true){
		
			ClienteMeta.obtenerId("frmClienteMeta").submit();
			
		} else {
			
		}
		
		
		
	},
 	
	/*
	apellidoPaterno
	apellidoMaterno
	Nombre
	anno
	mes
	dia
	edad
	calle
	noExterior
	noInterior
	colonia
	codigoPostal
	estado
	delegacionMunicipio
	religion
	sex
	estadoCivil
	nEstdio
	tipoRes
	tiempoVivienda
	tiempoEmpleo
	mov
	prestamo
	mejorPartido
	relAfe
	opinionApoDe
	partAsoc
	dependenciaEco
	actividadExt
	DineroExt
	gastoImp
	ingMens
	rdgTC

		'mesVencido',
				'pcuso',
				'pcPago'



	rdgProblemaB
		buroAct
		buroUso
		buroHist
		buroPago
		buroAnt
	*/
	
	//Problema TC
	
	ObtenerIdRdgTC :function(){return ClienteMeta.obtenerId('rdgTC') },
	
	
		ObtenerIdMesVencido:function(){return ClienteMeta.obtenerId('mesVencido') },
		
		ObtenerIdPcuso:function(){return ClienteMeta.obtenerId('pcuso') },
		
		ObtenerIdPcPago:function(){return ClienteMeta.obtenerId('pcPago') },
		
	
	//Problema BC 
	ObtenerIdRdgProblemaB:function(){return ClienteMeta.obtenerId('rdgProblemaB') },

		ObtenerIdBuroAct: function(){return ClienteMeta.obtenerId('buroAct')},
	
		ObtenerIdBuroUso:function(){return ClienteMeta.obtenerId('buroUso')},
	
		ObtenerIdBuroHist:function(){return ClienteMeta.obtenerId('buroHist')},
	
		ObtenerIdBuroPago:function(){return ClienteMeta.obtenerId('buroPago')},
	
		ObtenerIdBuroAnt:function(){return ClienteMeta.obtenerId('buroAnt')},	
	
	current:null, 
	
	init:function(){
		
		//alert(navigator.appName);
		 
		 //document.getElementById('rfc').value="AAA";
		 
		
		try {
			
			document.getElementById("imgGuardarArriba").attachEvent("onclick", ClienteMeta.validarCapturaGeneral);
			//imgGuardarAbajo
			document.getElementById("imgGuardarAbajo").attachEvent("onclick", ClienteMeta.validarCapturaGeneral);

                       // document.getElementById("tiempoEmpleo").attachEvent("onblur","ClienteMeta.validarArraigoEmpleoActual(this)")

                       // document.getElementById("tiempoVivienda").attachEvent("onblur","ClienteMeta.validarArraigoViviendaActual(this)")


			
		} catch(e){
			
		}
		
		//ClienteMeta.adjuntarEventos();
		
		//ClienteMeta.habilitarRDGsTCBC(false)
		
	},
	
	habilitarRDGsTCBC:function(boolValue){

            try{

		ClienteMeta.habilitarDeshabilitarElementosRDGTarjetaCredito(boolValue);
		
		ClienteMeta.habilitarDeshabilitarElementosRDGBuroDeCredito(boolValue);
           }
		catch (e) {

			//document.getElementById("imgGuardarArriba").addEventListener("click", ClienteMeta.validarCapturaGeneral);

		}
	},
	
	adjuntarEventos:function(){
		try {
			
			document.getElementById("imgGuardarArriba").attachEvent("onclick", ClienteMeta.validarCapturaGeneral);
		
		
		document.getElementsByName("rdgProblemaB")[0].attachEvent("onclick", ClienteMeta.obtenerValorRdgProblemaB);
		
		document.getElementsByName("rdgProblemaB")[1].attachEvent("onclick", ClienteMeta.obtenerValorRdgProblemaB);
		
		document.getElementsByName("rdgTC")[0].attachEvent("onclick", ClienteMeta.obtenerValorRdgTarjetaCredito);
		
		document.getElementsByName("rdgTC")[1].attachEvent("onclick", ClienteMeta.obtenerValorRdgTarjetaCredito);
		}
		catch (e) {

			//document.getElementById("imgGuardarArriba").addEventListener("click", ClienteMeta.validarCapturaGeneral);

		}

		
	},
	
	obtenerValorRdgProblemaB:function(){ 
		
		 for( var contador = 0; contador < document.getElementsByName("rdgProblemaB").length; contador++ ){
 
 			if( document.getElementsByName("rdgProblemaB")[contador].checked == true )
 	
				val = document.getElementsByName("rdgProblemaB")[contador].value;
				
				ClienteMeta.habilitarDeshabilitarElementosRDGBuroDeCredito(val)
 			
			}
 		
	},
	
	obtenerValorRdgTarjetaCredito:function(){ 
	

		
		 for( var contador = 0; contador < document.getElementsByName("rdgTC").length; contador++ ){
 
 			if (document.getElementsByName("rdgTC")[contador].checked == true) {
			
				val = document.getElementsByName("rdgTC")[contador].value;
			}
				
				ClienteMeta.habilitarDeshabilitarElementosRDGTarjetaCredito(val)
 			
			}
 		
	},
	
	habilitarDeshabilitarElementosRDGTarjetaCredito:function(boolValue){
		
		if(eval(boolValue)){
			
			ClienteMeta.ObtenerIdMesVencido().disabled=false;
		
			ClienteMeta.ObtenerIdPcuso().disabled=false;
		
			ClienteMeta.ObtenerIdPcPago().disabled=false;
			
		} else {
			
			ClienteMeta.ObtenerIdMesVencido().disabled=true;
		
			ClienteMeta.ObtenerIdPcuso().disabled=true;
		
			ClienteMeta.ObtenerIdPcPago().disabled=true;
			
		}
		
	},
	
	habilitarDeshabilitarElementosRDGBuroDeCredito:function(boolValue){
		
		if(eval(boolValue)){
			
		ClienteMeta.ObtenerIdBuroAct().disabled=false;
	
		ClienteMeta.ObtenerIdBuroUso().disabled=false;
	
		ClienteMeta.ObtenerIdBuroHist().disabled=false;
	
		ClienteMeta.ObtenerIdBuroPago().disabled=false;
	
		ClienteMeta.ObtenerIdBuroAnt().disabled=false;
				
		} else {
			
			ClienteMeta.ObtenerIdBuroAct().disabled=true;
	
			ClienteMeta.ObtenerIdBuroUso().disabled=true;
		
			ClienteMeta.ObtenerIdBuroHist().disabled=true;
	
			ClienteMeta.ObtenerIdBuroPago().disabled=true;
	
			ClienteMeta.ObtenerIdBuroAnt().disabled=true;
		}
	},
	
	validarBrowser:function(){ 
	
	nav=navigator.appName;
		
		//TODO 
		
		var ie_ver=5.5;
		nav=navigator.appName;
		ver=navigator.userAgent;
		accept='';
		sfr=ver.indexOf('Safari');
		
		if(nav=='Microsoft Internet Explorer'){
			
			var a_Ver=ver.substr(
			ver.indexOf('MSIE'),
			
			ver.substr(ver.indexOf('MSIE')).indexOf(';'))
			
			app_ver=parseFloat(a_Ver.substr(a_Ver.indexOf(' ')));
			
			if(app_ver>=ie_ver)
			{
				accept='ie';
				}
		}
		
		else if(sfr>-1){
			accept='sf'}
			else{
				accept='ff';
				}
				
		
		
	},
	
	obtenerId:function(strId){

		var objId = null;

		if (strId != null) {
			objId = document.getElementById(strId)
		}
		
		return objId
	},
	
	//Generico
	obtenerValor:function(strId){
		
		var valor =ClienteMeta.obtenerId(strId).value;
		
		return valor;
		
	},
	
	
	obtenerValorTxt:function(strId){
		
		var valorTxt =ClienteMeta.obtenerId(strId).value;
		
		return valorTxt;
		
	},
	
	validarValorGeneral:function(strId){
		
		var boolVal = false;
		
		if (
			ClienteMeta.obtenerValor(strId) == null || 
			ClienteMeta.obtenerValor(strId) == "" ||
			ClienteMeta.obtenerValor(strId).length == 0 ){
		
			boolVal = false
		
		} else { 
		
		boolVal = true;
		
		}
		
		return boolVal;
		
	},
	
	desplegarAlertaCamposInvalidos:function(arrCamposInvalidos){
		
		var strMensajesInvalidos ="Los siguientes campos son requeridos por el sistema: \n";
		
		var strMensajesInvalidos ="Los campos son requeridos por el sistema. \n";
		
		for (var contador = 0 ; contador < arrCamposInvalidos.length ; contador++ ){
			
			strMensajesInvalidos +="\n - "+ arrCamposInvalidos[contador] +" -"
			
		}
		
		//alert(strMensajesInvalidos);
		
		return strMensajesInvalidos;
		
		
	},
	
	
	
	strMsjError:"Todos los campos son requeridos, complete y reintente.",
	
	validarCapturaGeneral:function(){ 
	//alert(89); return;
			
		//ClienteMeta.obtenerId("frmClienteMeta").submit();
		
		//ClienteMeta.obtenerId("btnSubmit").click()
		
		// return true;
		
	 
		
		var arrElementos = [
			'rfc',
			'apellidoPaterno',
			'apellidoMaterno',
			'Nombre',
			'anio',
			'mes',
			'dia',
			'edad',
			'calle',
			'noExterior',
			'noInterior',
			'colonia',
			'codigoPostal',
			'religion',
			'sexo',
			'estadoCivil',
			'nEstdio',
			'tipoRes',
			'tiempoVivienda',
			'tiempoEmpleo',
			'mov',
			'prestamo',
			'mejorPartido',
			'relAfe',
			'opinionApoDe',
			'partAsoc',
			'dependenciaEco',
			'actividadExt',
			'DineroExt',
			'gastoImp',
			'ingMens',
			'rdgTC'
		
		];
		
		//,	'rdgProblemaB'
		
		var arrRdgTC = [
				'mesVencido',
				'pcuso',
				'pcPago'
			]
		
		var arrRdgProblemaB = [
			'buroAct',
			'buroUso',
			'buroHist',
			'buroPago',
			'buroAnt'
		]
		
		var arrCamposInvalidos = [];
		
		var boolCamposInvalidos = false;
		
		for (var contador=0; contador<arrElementos.length; contador++){
			
			//validarGeneralPruebas
			try {
				if (!(eval(ClienteMeta.validarValorGeneral(arrElementos[contador])))) {
				
					arrCamposInvalidos.push(arrElementos[contador])
					
					boolCamposInvalidos = true;
					
					ClienteMeta.definirEstiloCampoValidado(arrElementos[contador],false);
					
					
					
				} else {
					 
					ClienteMeta.definirEstiloCampoValidado(arrElementos[contador],true);
					 
				}
			  
			} catch(e) {
				
			}
				
		} //end for 
		
		//>>>
		
		
		
		//alert("->>>>>>>>>>>>>"+ClienteMeta.obtenerValorRdgTarjetaCredito());
		
		 for (var contador = 0; contador < document.getElementsByName("rdgTC").length; contador++) {
		 
		 	if (document.getElementsByName("rdgTC")[contador].checked == true) {
		 	
		 		val = document.getElementsByName("rdgTC")[contador].value;
		 	}
		 }
		
	//	alert(val)
		
		
		
						
				for( var contador = 0; contador<ClienteMeta.arrRdgTC.length; contador++){
					
				try {
					
					if (val == "false" || val == false ) {
						
						ClienteMeta.definirEstiloCampoValidado(ClienteMeta.arrRdgTC[contador],true);
		
					} else {
						
						if (!(eval(ClienteMeta.validarValorGeneral(ClienteMeta.arrRdgTC[contador])))) {
				
						//arrCamposInvalidos.push(arrElementos[contador])
					
						boolCamposInvalidos = true;
					
						ClienteMeta.definirEstiloCampoValidado(ClienteMeta.arrRdgTC[contador],false);
					 
					} else {
						
						ClienteMeta.definirEstiloCampoValidado(ClienteMeta.arrRdgTC[contador],true);
						
					}
		
		}
			 			 
			  
			} catch(e) {
				
			}
				
					
									
				}
						
		
		
		//<<<
		
		
		
		
		
		if (eval(boolCamposInvalidos)){
			
			//ClienteMeta.desplegarAlertaCamposInvalidos(arrCamposInvalidos)		
			
			UtileriasUrbi.definirEstadoInicialContenedorTablaError(true,'',ClienteMeta.strMsjError);
			
			return;
			
		} else {
			
			boolCamposInvalidos = false;
			
			UtileriasUrbi.definirEstadoInicialContenedorTablaError(false,'','');
			
			
                        
                            document.getElementById("frmClienteMeta").submit();
                       
                            return;
                        
			
		}
			
		
		//	
			
		//return boolCamposInvalidos;
	}
 }
 
 
 
 /////>>>>><
 
 
 
 // [dFilter] - A Numerical Input Mask for JavaScript
// Written By Dwayne Forehand - March 27th, 2003
// Please reuse & redistribute while keeping this notice.

//review later

var dFilterStep

function dFilterStrip (dFilterTemp, dFilterMask)
{
    dFilterMask = replace(dFilterMask,'#','');
    for (dFilterStep = 0; dFilterStep < dFilterMask.length++; dFilterStep++)
		{
		    dFilterTemp = replace(dFilterTemp,dFilterMask.substring(dFilterStep,dFilterStep+1),'');
		}
		return dFilterTemp;
}

function dFilterMax (dFilterMask)
{
 		dFilterTemp = dFilterMask;
    for (dFilterStep = 0; dFilterStep < (dFilterMask.length+1); dFilterStep++)
		{
		 		if (dFilterMask.charAt(dFilterStep)!='#')
				{
		        dFilterTemp = replace(dFilterTemp,dFilterMask.charAt(dFilterStep),'');
				}
		}
		return dFilterTemp.length;
}

function dFilter (key, textbox, dFilterMask)
{
		dFilterNum = dFilterStrip(textbox.value, dFilterMask);
		
		if (key==9)
		{
		    return true;
		}
		else if (key==8&&dFilterNum.length!=0)
		{
		 	 	dFilterNum = dFilterNum.substring(0,dFilterNum.length-1);
		}
 	  else if ( ((key>47&&key<58)||(key>95&&key<106)) && dFilterNum.length<dFilterMax(dFilterMask) )
		{
        dFilterNum=dFilterNum+String.fromCharCode(key);
		}

		var dFilterFinal='';
    for (dFilterStep = 0; dFilterStep < dFilterMask.length; dFilterStep++)
		{
        if (dFilterMask.charAt(dFilterStep)=='#')
				{
					  if (dFilterNum.length!=0)
					  {
				        dFilterFinal = dFilterFinal + dFilterNum.charAt(0);
					      dFilterNum = dFilterNum.substring(1,dFilterNum.length);
					  }
				    else
				    {
				        dFilterFinal = dFilterFinal + "";
				    }
				}
		 		else if (dFilterMask.charAt(dFilterStep)!='#')
				{
				    dFilterFinal = dFilterFinal + dFilterMask.charAt(dFilterStep); 			
				}
//		    dFilterTemp = replace(dFilterTemp,dFilterMask.substring(dFilterStep,dFilterStep+1),'');
		}


		textbox.value = dFilterFinal;
    return false;
}

function replace(fullString,text,by) {
// Replaces text with by in string
    var strLength = fullString.length, txtLength = text.length;
    if ((strLength == 0) || (txtLength == 0)) return fullString;

    var i = fullString.indexOf(text);
    if ((!i) && (text != fullString.substring(0,txtLength))) return fullString;
    if (i == -1) return fullString;

    var newstr = fullString.substring(0,i) + by;

    if (i+txtLength < strLength)
        newstr += replace(fullString.substring(i+txtLength,strLength),text,by);

    return newstr;
}

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Submit


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
		
		alert(" submit : function(f, c) ")

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
			
				
			}
//funciones de los demas jsp


            function validate_form(thisform){
                //if (validate_required(instanceName)==false){
                if(false){
                    SetErrorMessage(1,"Hola Yandy, esto es un error");
                    return false;
                }
                return true;
            }

          function ejecutar(boton, thisform){
		  		//alert("hola!!!");
                var frm = document.forms[thisform];
                frm.elements["command"].value = boton;
                document.forms[thisform].submit();
	 }

         function activaCombos(){
             var a
             for (i=0;i<document.forms[1].rdgTC.length;i++){
                 
              if (document.forms[1].rdgTC[i].checked){
                 a=i;
                  
              }
                     
             }
      
             if(a==1){

                 document.forms[1].mesVencido.disabled=true;
                 document.forms[1].pcuso.disabled=true;
                 document.forms[1].pcPago.disabled=true;
				 
				 //EAAR ADD: Se reinician valores de los selects
				 try {
				 	document.getElementById('mesVencido').selectedIndex = 0;
				 	document.getElementById('pcuso').selectedIndex = 0;
				 	document.getElementById('pcPago').selectedIndex = 0;
				 	
				 	document.getElementById('mesVencido').style.backgroundColor = "white";
				 	document.getElementById('pcuso').style.backgroundColor = "white";
				 	document.getElementById('pcPago').style.backgroundColor = "white";
				 } catch(e) {
				 	
				 }
				 

             }else{

				try {
					document.forms[1].mesVencido.disabled = false;
					document.forms[1].pcuso.disabled = false;
					document.forms[1].pcPago.disabled = false;
					
					//EAAR ADD: Se reinician valores de los selects
					document.getElementById('mesVencido').selectedIndex = 0;
					document.getElementById('pcuso').selectedIndex = 0;
					document.getElementById('pcPago').selectedIndex = 0;
					
					//EAAR ADD: Se reinician valores de los selects
					document.getElementById('mesVencido').style.backgroundColor = "white";
					document.getElementById('pcuso').style.backgroundColor = "white";
					document.getElementById('pcPago').style.backgroundColor = "white";
				} catch(e){
					
				}
				 
             }

         }

         


//>>>>>>>
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

function MM_swapImage() {

//v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//<<<<<<

function vv (){alert(889)}
