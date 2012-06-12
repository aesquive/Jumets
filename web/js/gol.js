var XmlHttpObj;
var campoModificar;
var tipoGlobal;
var globalSelected;
function CreateXmlHttpObj() {
	try {
		XmlHttpObj = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			XmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (oc) {
			XmlHttpObj = null;
		}
	}
	if (!XmlHttpObj && typeof XMLHttpRequest != "undefined") {
		XmlHttpObj = new XMLHttpRequest();
	}
}

function cargaCP() {
	var cp = document.getElementById("cp").value;
	if (cp.length < 5)
		return false;
	tipoGlobal = 3;
	var requestUrl;
	requestUrl = "../GolAjax?idCal=" + cp + "&tipo=3";
	// Crea el objeto XMLHTTP
	CreateXmlHttpObj();
	if (XmlHttpObj) {
		XmlHttpObj.open("GET", requestUrl, true);
		XmlHttpObj.onreadystatechange = cargaChangeHandler;
		XmlHttpObj.send(null);
	}
}
function carga(campo, campoMod, tipo, idCal, idSelected) {
	var frm = document.forms["PrimaMant"];
	campoModificar = campoMod;
	tipoGlobal = tipo;
	globalSelected = idSelected;
	var listaUas = document.getElementById(campo);
	var fondoSelect = listaUas.options[listaUas.selectedIndex].value;
	if (fondoSelect == -1)
		return false;

	var id1 = -1;
	var id2 = -1;
	if (tipo == 1)
		id1 = document.getElementById("tipoActividad").value;
	else if (tipo == 2) {
		id1 = document.getElementById("tipoActividad").value;
		id2 = document.getElementById("sector").value;
	}

	if ((fondoSelect == 1 || fondoSelect == 2) && tipo == 1) {
		document.getElementById("sector").disabled = false;
		document.getElementById("rol").disabled = false;
		document.getElementById("subSector").disabled = true;
		document.getElementById("descripcionOcupacion").disabled = false;
	} else if (fondoSelect == 3 && tipo == 1) {
		document.getElementById("sector").disabled = true;
		document.getElementById("rol").disabled = false;
		document.getElementById("subSector").disabled = true;
		document.getElementById("descripcionOcupacion").disabled = false;
	} else if (fondoSelect == 4 && tipo == 1) {
		document.getElementById("sector").disabled = true;
		document.getElementById("rol").disabled = true;
		document.getElementById("subSector").disabled = true;
		document.getElementById("descripcionOcupacion").disabled = true;
		return false;
	}

	var requestUrl;
	requestUrl = "../GolAjax?idCal=" + idCal + "&tipo=" + tipo + "&id1=" + id1
			+ "&id2=" + id2;
	// Crea el objeto XMLHTTP
	CreateXmlHttpObj();
	if (XmlHttpObj) {
		XmlHttpObj.open("GET", requestUrl, true);
		XmlHttpObj.onreadystatechange = cargaChangeHandler;
		XmlHttpObj.send(null);
	}
}
function cargaChangeHandler() {
	if (XmlHttpObj.readyState == 4) {
		if (XmlHttpObj.status == 200) {
			cargaXml(XmlHttpObj.responseXML.documentElement);
		} else {
			alert("No se cargo correctamente el combo!");
		}
	}
}
function cargaXml(localidadNode) {
	// Lee el objeto xml
	var archivadoLista = XmlHttpObj.responseXML
			.getElementsByTagName("catalogo")[0];
	var nodo = archivadoLista.getElementsByTagName('gol');
	if (tipoGlobal != 3) {
		var textValue;
		var optionItem;
		var at;
		var ac;
		var listaSubfondo = document.getElementById(campoModificar);
		for ( var count = listaSubfondo.options.length - 1; count > -1; count--)
			listaSubfondo.options[count] = null;

		optionItem = new Option("-Seleccione-", "-1", false, false);
		listaSubfondo.options[listaSubfondo.length] = optionItem;
		for ( var y = 0; y < nodo.length; y++) {
			var id = nodo[y].getAttribute("id");
			var nombre = nodo[y].getAttribute("mun");

			var select = false;
			if (id == globalSelected)
				select = true;

			optionItem = new Option(nombre, id, false, select);
			listaSubfondo.options[listaSubfondo.length] = optionItem;
			listaSubfondo.options[y+1].title = nombre;
		}
		if (nodo.length == 0)
			document.getElementById(campoModificar).disabled = true;
		else
			document.getElementById(campoModificar).disabled = false;
	} else {
		for ( var y = 0; y < nodo.length; y++) {
			var id = nodo[y].getAttribute("id");
			var nombre = nodo[y].getAttribute("mun");
                	document.getElementById("edo").value = id;
			document.getElementById("mun").value = nombre;
			document.getElementById("sexo").focus();
		}
		if (nodo.length == 0) {
			SetErrorMessage(1, "Codigo Postal No Valido.");
			document.getElementById("edo").value = "";
			document.getElementById("mun").value = "";
			document.getElementById("cp").focus();
		}else
			SetErrorMessage(1, "");
	}
}
function validate_form(thisform) {
	if (false) {
		SetErrorMessage(1, "Hola Yandy, esto es un error");
		return false;
	}
	return true;
}
function ejecutar(boton, thisform) {
	var frm = document.forms[thisform];
	frm.elements["command"].value = boton;
	document.forms[thisform].submit();
}
function cpValidacion() {
	if (document.getElementById("cp").value.length < 5) {
		alert("El código postal debe tener 5 dígitos numéricos.");
		document.getElementById("cp").value = "";
		document.getElementById("cp").focus();
		return false
	}
}
function conMayusculas(campo) {
	document.getElementById(campo).value = document.getElementById(campo).value
			.toUpperCase();
}
function conMayusculasOtros(campo) {
	document.getElementById(campo).value = document.getElementById(campo).value.toUpperCase();
	document.getElementById("cuantogasta").disabled = false;
}
function conMayusculasGastosOtros(campo) {
	if(campo!=""){
		document.getElementById("gastosOtroCual").disabled = false;
	}else
		document.getElementById("gastosOtroCual").disabled = true;
}
function activarCuantoGasta1() {
	document.getElementById("gastosOtroCual").disabled = false;
}
function activarCuantoGasta() {
	document.getElementById("cuantogasta").disabled = false;
}
function SetErrorMessage(set, text) {
	document.getElementById('tblError').style.display = (set == 1 ? '' : 'none');
	document.getElementById('errorMessage').innerHTML = (set == 1 ? text : '');
	return false;
}

// pagina2
function activarOtra(campoO, campoD) {
	if (document.getElementById(campoO).value == "7") {
		document.getElementById(campoD).disabled = false;
		document.getElementById(campoD).focus();
	} else
		document.getElementById(campoD).disabled = true;
}



function habilitaNT(campoO, campoD) {
	if (document.getElementById(campoO).value == "6") {
		document.getElementById(campoD).disabled = false;
		document.getElementById(campoD).focus();
	} else
		document.getElementById(campoD).disabled = true;
}
// fin pagina2

// pagina3
function validaDendientes() {
	var valor = document.getElementById("personasDep").value;
	var iValor = parseInt(valor);
	if (iValor < 0) {
		alert("El número de personas va de 0 a 15, reintente.");
		document.getElementById("personasDep").value = "";
		document.getElementById("personasDep").focus();
		return false;
	}
	if (iValor > 15) {
		alert("El número de personas va de 0 a 15, reintente.");
		document.getElementById("personasDep").value = "";
		document.getElementById("personasDep").focus();
		return false;
	}
}
function ingMensual(campo) {
	var valor = document.getElementById(campo).value;
	var iValor = parseInt(valor);
	if (iValor < 500) {
		alert("El Ingreso Mensual debe ser entre $500 y $50,000");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
	if (iValor > 50000) {
		alert("El Ingreso Mensual debe ser entre $500 y $50,000");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
}
function checkIng(campo, campo1, campo2) {
	if (document.getElementById(campo).checked == true) {
		document.getElementById(campo1).disabled = false;
		document.getElementById(campo2).disabled = false;
		document.getElementById(campo1).focus();
	} else {
		document.getElementById(campo1).disabled = true;
		document.getElementById(campo2).disabled = true;
	}
}
// fin pagina3

// pagina 4
function dineroExtraChange(){
	if(document.getElementById("dineroExtraR").value=="2"){
		document.getElementById("dineroConcepto").disabled = true;
		document.getElementById("dineroECuanto").disabled = true;
		document.getElementById("dineroFrec").disabled = true;
	}else{
		document.getElementById("dineroConcepto").disabled = false;
		document.getElementById("dineroECuanto").disabled = false;
		document.getElementById("dineroFrec").disabled = false;
	}
}
function valida3(campo) {
	var valor = document.getElementById(campo).value;
	var iValor = parseInt(valor);
	if (iValor < 0) {
		alert("El valor dbe de ser entre 0 y 40.");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
	if (iValor > 40) {
		alert("El valor dbe de ser entre 0 y 40.");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
}
function valida4(campo) {
	var valor = document.getElementById(campo).value;
	var iValor = parseInt(valor);
	if (iValor < 0) {
		alert("El valor dbe de ser entre 0 y 11.");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
	if (iValor > 11) {
		alert("El valor dbe de ser entre 0 y 11.");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
}
function valida5(campo) {
	var valor = document.getElementById(campo).value;
	var iValor = parseInt(valor);
	if (iValor < 0) {
		alert("El valor dbe de ser entre 0 y 20.");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
	if (iValor > 11) {
		alert("El valor dbe de ser entre 0 y 20.");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
}
function activarTD(campo) {
	if (campo == "tc1") {
		if (document.getElementById(campo).checked == true) {
			document.getElementById("totalTarjetas").disabled = false;
			document.getElementById("totalTarjetas").focus();
		}
	} else {
		if (document.getElementById(campo).checked == true) {
			document.getElementById("totalTarjetas").disabled = true;
		}
	}
}
function activarO(campo) {
	if (campo == "otro1") {
		if (document.getElementById(campo).checked == true) {
			document.getElementById("cualCredito").disabled = false;
			document.getElementById("cualCredito").focus();
		}
	} else {
		if (document.getElementById(campo).checked == true) {
			document.getElementById("cualCredito").disabled = true;
		}
	}
}
function pagaRent(){
	var pag = document.getElementById("pagaRenta");
	var idSel1 = pag.options[pag.selectedIndex].value;
	if(idSel1=="2")
		document.getElementById("pagaRCuanto").disabled = true;
	else
		document.getElementById("pagaRCuanto").disabled = false;
}
function solicitudCred(){
	var pag = document.getElementById("solicitadoCredito");
	var idSel1 = pag.options[pag.selectedIndex].value;
	if(idSel1=="2"){
		document.getElementById("creditoAnio").disabled = true;
		document.getElementById("creditoMes").disabled = true;
		document.getElementById("tipoCredito").disabled = true;
		document.getElementById("tardoAnio").disabled = true;
		document.getElementById("tardoMes").disabled = true;
	}else{
		document.getElementById("creditoAnio").disabled = false;
		document.getElementById("creditoMes").disabled = false;
		document.getElementById("tipoCredito").disabled = false;
		document.getElementById("tardoAnio").disabled = false;
		document.getElementById("tardoMes").disabled = false;
	}
}
// fin pagina 4

// pagina 7
function selBuroReg() {
	if (document.getElementById("buroCredito1").checked == true) {
		document.getElementById("ant").disabled = false;
		document.getElementById("act").disabled = false;
		document.getElementById("hist").disabled = false;
		document.getElementById("uso").disabled = false;
		document.getElementById("pago").disabled = false;
		document.getElementById("mop").disabled = false;
		document.getElementById("cuentasA").disabled = false;
		document.getElementById("maximaA").disabled = false;
		document.getElementById("montoA").disabled = false;
		document.getElementById("limiteA").disabled = false;
		document.getElementById("saldoA").disabled = false;
		document.getElementById("cuentasC").disabled = false;
		document.getElementById("maximaC").disabled = false;
		document.getElementById("montoC").disabled = false;
		document.getElementById("limiteC").disabled = false;
		document.getElementById("saldoC").disabled = false;
		document.getElementById("importeMop").disabled = false;
		document.getElementById("tipoCreditoMop").disabled = false;
		document.getElementById("pagoRealizar").disabled = false;
	} else {
		document.getElementById("ant").disabled = true;
		document.getElementById("act").disabled = true;
		document.getElementById("hist").disabled = true;
		document.getElementById("uso").disabled = true;
		document.getElementById("pago").disabled = true;
		document.getElementById("mop").disabled = true;
		document.getElementById("cuentasA").disabled = true;
		document.getElementById("maximaA").disabled = true;
		document.getElementById("montoA").disabled = true;
		document.getElementById("limiteA").disabled = true;
		document.getElementById("saldoA").disabled = true;
		document.getElementById("cuentasC").disabled = true;
		document.getElementById("maximaC").disabled = true;
		document.getElementById("montoC").disabled = true;
		document.getElementById("limiteC").disabled = true;
		document.getElementById("saldoC").disabled = true;
		document.getElementById("importeMop").disabled = true;
		document.getElementById("tipoCreditoMop").disabled = true;
		document.getElementById("pagoRealizar").disabled = true;
	}
}
function cargaBuroReg() {
	document.getElementById("ant").disabled = true;
	document.getElementById("act").disabled = true;
	document.getElementById("hist").disabled = true;
	document.getElementById("uso").disabled = true;
	document.getElementById("pago").disabled = true;
	document.getElementById("mop").disabled = true;
	document.getElementById("cuentasA").disabled = true;
	document.getElementById("maximaA").disabled = true;
	document.getElementById("montoA").disabled = true;
	document.getElementById("limiteA").disabled = true;
	document.getElementById("saldoA").disabled = true;
	document.getElementById("cuentasC").disabled = true;
	document.getElementById("maximaC").disabled = true;
	document.getElementById("montoC").disabled = true;
	document.getElementById("limiteC").disabled = true;
	document.getElementById("saldoC").disabled = true;
	document.getElementById("importeMop").disabled = true;
	document.getElementById("tipoCreditoMop").disabled = true;
	document.getElementById("pagoRealizar").disabled = true;
}
function buroRangos(campo) {
	var valor = document.getElementById(campo).value;
	var iValor = parseInt(valor);
	if (iValor < 0) {
		alert("El valor dbe de ser entre 0 y 99.");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
	if (iValor > 99) {
		alert("El valor dbe de ser entre 0 y 99.");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
}
function valVivienda(){
	var valor = document.getElementById("valorVivienda").value;
	var iValor = parseInt(valor);
	if(iValor<100000){
		alert("El Valor de la Vivienda debe ser entre $100,000 y $3,000,000");
		document.getElementById("valorVivienda").value = "";
		document.getElementById("valorVivienda").focus();
		return false;
	}
	if(iValor>3000000){
		alert("El Valor de la Vivienda debe ser entre $100,000 y $3,000,000");
		document.getElementById("valorVivienda").value = "";
		document.getElementById("valorVivienda").focus();
		return false;
	}
}
function valMensu(){
	var valor = document.getElementById("mensualidad").value;
	var iValor = parseInt(valor);
	if(iValor<500){
		alert("La Mensualidad debe ser entre $500 y $50,000");
		document.getElementById("mensualidad").value = "";
		document.getElementById("mensualidad").focus();
		return false;
	}
	if(iValor>50000){
		alert("La Mensualidad debe ser entre $500 y $50,000");
		document.getElementById("mensualidad").value = "";
		document.getElementById("mensualidad").focus();
		return false;
	}
}
// fin pagina 7

function valPagina1(boton, thisform, tipo) {
	pagina1Val(boton, thisform, tipo);
}
function valPagina2(boton, thisform, tipo) {
	pagina2Val(boton, thisform, tipo);
}
function valPagina3(boton, thisform, tipo) {
	pagina3Val(boton, thisform, tipo);
}
function valPagina4(boton, thisform, tipo) {
	pagina4Val(boton, thisform, tipo);
}

function valPagina5(boton, thisform, tipo) {
	pagina5Val(boton, thisform, tipo);
}

function valPagina6(boton, thisform, tipo) {
	pagina6Val(boton, thisform, tipo);
}

function valPagina7(boton, thisform, tipo) {
	pagina7Val(boton, thisform, tipo);
}
function salirGol() {
	if (confirm("Esta seguro de salir.")) {
		location.assign('../GolServlet?command=salir');
	}
}


function SelGolIndex() {
	var listaPrim = document.getElementById("listaG");
	var idSel = listaPrim.options[listaPrim.selectedIndex].value;

	var idPrim = idSel.substring(0, idSel.indexOf("|"));
	var idG = idSel.substring(idSel.indexOf("|") + 1, idSel.length);
	document.getElementById("idGol").value = idG;
	document.getElementById("idPrima").value = idPrim;
}
function buscarTodos() {
	document.getElementById('command').value = "BuscarT";
	document.getElementById('GolIndex').submit();
}
function modificarGol() {
	var idG = document.getElementById("idGol").value;
	var idP = document.getElementById("idPrima").value;
	if (idP == "") {
		alert("No ha seleccionado un registro para modificar.");
	} else {
		location.assign('../GolServlet?command=ver&idG=' + idG + '&idP=' + idP);
	}
}
function SelGol() {
	var listaGol = document.getElementById("listaG");
	var idSel = listaGol.options[listaGol.selectedIndex].value;

	var idPrim = idSel.substring(0, idSel.indexOf("|"));
	var idG = idSel.substring(idSel.indexOf("|") + 1, idSel.length);
	document.getElementById("idGol").value = idG;
	document.getElementById("idPrima").value = idPrim;
	calcularGol();
}
function calcularGol() {
	var idG = document.getElementById("idGol").value;
	var idP = document.getElementById("idPrima").value;
	if (idP == "") {
		alert("No ha seleccionado un registro para calcular.");
	} else {
		location.assign('../GolServlet?command=calcular&idG=' + idG + '&idP='
				+ idP);
	}
}
function activacionControl(valor) {
	document.getElementById("apellidoPaterno").disabled = valor;
	document.getElementById("apellidoMaterno").disabled = valor;
	document.getElementById("nombre").disabled = valor;
	document.getElementById("anio").disabled = valor;
	document.getElementById("mes").disabled = valor;
	document.getElementById("dia").disabled = valor;
	document.getElementById("calle").disabled = valor;
	document.getElementById("noExterior").disabled = valor;
	document.getElementById("noInterior").disabled = valor;
	document.getElementById("colonia").disabled = valor;
	document.getElementById("cp").disabled = valor;
	document.getElementById("sexo").disabled = valor;
	document.getElementById("edoCivil").disabled = valor;
	document.getElementById("comercioIndispensable").disabled = valor;
	document.getElementById("problemaHoy").disabled = valor;
	document.getElementById("situacionActual").disabled = valor;
	document.getElementById("situacionPAnio").disabled = valor;
	document.getElementById("pqSituacionPAnio").disabled = valor;
	document.getElementById("deudaPreocupa").disabled = valor;
	document.getElementById("apoyoInstitucion").disabled = valor;
	document.getElementById("dineroExtra").disabled = valor;
	document.getElementById("gastosAlimentos").disabled = valor;
	document.getElementById("gastosPersonales").disabled = valor;
	document.getElementById("gastosDeudas").disabled = valor;
	document.getElementById("gastosOtros").disabled = valor;
	document.getElementById("gastosOtros").disabled = valor;
	if(valor==false)
		document.getElementById("apellidoPaterno").focus();
}
function validEdad(campo, edad){
	var valor = parseInt(document.getElementById(campo).value);
	if(valor>edad){
		alert("Es un dato invalido!");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
	}
}
function rentaGto(campo) {
	var valor = document.getElementById(campo).value;
	var iValor = parseInt(valor);
	if (iValor < 500) {
		alert("El monto debe ser entre $500 y $50,000");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
	if (iValor > 50000) {
		alert("El monto debe ser entre $500 y $50,000");
		document.getElementById(campo).value = "";
		document.getElementById(campo).focus();
		return false;
	}
}