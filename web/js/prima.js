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
function loading(){
    document.getElementById("carga").innerHTML = " Cargando... ";
}
function loadingFin() {
    document.getElementById("carga").innerHTML = "";
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
    }else if (tipo == 4) {
        id1 = document.getElementById("ubicacionVivienda").value;
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
        frm.elements["sector"].selectedIndex = 0;
        frm.elements["subSector"].selectedIndex = 0;
        frm.elements["rol"].selectedIndex = 0;
        return false;
    }

    var requestUrl;
    requestUrl = "../PrimaAjax?idCal=" + idCal + "&tipo=" + tipo + "&id1="
    + id1 + "&id2=" + id2;
    // Crea el objeto XMLHTTP
    CreateXmlHttpObj();
    if (XmlHttpObj) {
        XmlHttpObj.open("GET", requestUrl, true);
        XmlHttpObj.onreadystatechange = cargaChangeHandler;
        XmlHttpObj.send(null);
    }
}
function cargaChangeHandler() {
    aler("entro al change handler aca")
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
    alert(nodo.length);
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
            var id = nodo(y).getAttribute("id");
            var nombre = nodo(y).text;
			
            var select = false;
            if (id == globalSelected)
                select = true;
			
            optionItem = new Option(nombre, id, false, select);
            listaSubfondo.options[listaSubfondo.length] = optionItem;
        }
        if (nodo.length == 0)
            document.getElementById(campoModificar).disabled = true;
        else
            document.getElementById(campoModificar).disabled = false;
    }else{
        for ( var y = 0; y < nodo.length; y++) {
            var id = nodo[y].getAttribute("id");
            var nombre = nodo[y].getAttribute("mun");
            document.getElementById("edo").value = id;
            document.getElementById("mun").value = nombre;
            document.getElementById("edoCivil").focus();
        }
        if (nodo.length == 0){
            SetErrorMessage(1,"Codigo Postal No Valido.");
            document.getElementById("edo").value = "";
            document.getElementById("mun").value = "";
            document.getElementById("cp").focus();
        }
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
    if (boton == "Guardar") {
        guardar('PrimaMant');
        return false;
    }
    frm.elements["command"].value = boton;
    document.forms[thisform].submit();
}
function agregarMod(){
    location.assign('mantprima.jsp');
}

function activarControles(estado) {
    MM_preloadImages('../images/acceso/activos_add.png',
        '../images/acceso/activos_mod.png',
        '../images/acceso/activos_sup.png',
        '../images/acceso/activos_exit.png',
        '../images/acceso/activos_guardar.png',
        '../images/buscar_activo.png',
        '../images/acceso/activos_buscar.png',
        '../images/acceso/activos_salir.png',
        '../images/acceso/inactivo-blanco_salir.png',
        '../images/acceso/activos_left.png',
        '../images/acceso/activos_right.png');
    var frm = document.forms["PrimaMant"];
    frm.elements["apellidoMaterno"].disabled = estado;
    frm.elements["apellidoPaterno"].disabled = estado;
    frm.elements["nombre"].disabled = estado;
    frm.elements["anio"].disabled = estado;
    frm.elements["mes"].disabled = estado;
    frm.elements["dia"].disabled = estado;
    frm.elements["calle"].disabled = estado;
    frm.elements["noExterior"].disabled = estado;
    frm.elements["noInterior"].disabled = estado;
    frm.elements["colonia"].disabled = estado;
    frm.elements["cp"].disabled = estado;
    frm.elements["edoCivil"].disabled = estado;
    frm.elements["dependientes"].disabled = estado;
    frm.elements["ingresoMensual"].disabled = estado;
    frm.elements["tipoActividad"].disabled = estado;
    if (estado == false) {
        frm.elements["sector"].disabled = true;
        frm.elements["subSector"].disabled = true;
        frm.elements["rol"].disabled = true;
        frm.elements["descripcionOcupacion"].disabled = true;
    } else {
        frm.elements["sector"].disabled = estado;
        frm.elements["subSector"].disabled = estado;
        frm.elements["rol"].disabled = estado;
        frm.elements["descripcionOcupacion"].disabled = estado;
    }
    // frm.elements["descripcion"].disabled = estado;
    frm.elements["ubicacionVivienda"].disabled = estado;
    if (estado == false)
        frm.elements["desarrollo"].disabled = true;
    else
        frm.elements["desarrollo"].disabled = estado;
    frm.elements["valorVivienda"].disabled = estado;
    frm.elements["mensualidad"].disabled = estado;
}

function BorrarControles() {
    if (confirm("Seguro de cancelar los Datos entrados.")) {
        ResetearControles();
        activarControles(true);
    }
}
function salirPrima(){
    if (confirm("Esta seguro de salir.")) {
        location.assign('primaindex.jsp');
    }
}

function ResetearControles() {
    var frm = document.forms["PrimaMant"];
    frm.elements["apellidoMaterno"].value = "";
    frm.elements["apellidoPaterno"].value = "";
    frm.elements["nombre"].value = "";
    frm.elements["anio"].selectedIndex = 0;
    frm.elements["mes"].selectedIndex = 0;
    frm.elements["dia"].selectedIndex = 0;
    frm.elements["calle"].value = "";
    frm.elements["noExterior"].value = "";
    frm.elements["noInterior"].value = "";
    frm.elements["colonia"].value = "";
    frm.elements["cp"].value = "";
    frm.elements["edo"].value = "";
    frm.elements["mun"].value = "";
    frm.elements["edoCivil"].selectedIndex = 0;
    frm.elements["dependientes"].selectedIndex = 0;
    frm.elements["ingresoMensual"].selectedIndex = 0;
    frm.elements["tipoActividad"].selectedIndex = 0;
    frm.elements["sector"].selectedIndex = 0;
    frm.elements["subSector"].selectedIndex = 0;
    frm.elements["descripcionOcupacion"].value = "";
    frm.elements["rol"].selectedIndex = 0;
    frm.elements["ubicacionVivienda"].selectedIndex = 0;
    frm.elements["desarrollo"].selectedIndex = 0;
    frm.elements["valorVivienda"].value = "";
    frm.elements["mensualidad"].value = "";
}

function nuevoAgregar() {
    activarControles(false);
    ResetearControles();
}
function modificarPrima1() {
    activarControles(false);
}

function onChangeCodigoPostal() {
    SetErrorMessage(2, "");
    var frm = document.forms["PrimaMant"];
    var textCP = frm.elements["cp"].value;
        javascript: llamarasincrono(
            '../jspServlet/codigoPostalChangeEstado.jsp?codigoPostal=' + textCP,
            'estadoDiv');
        javascript: llamarasincrono(
            '../jspServlet/codigoPostalChangeMunicipio.jsp?codigoPostal=' + textCP,
            'municipioDiv');
// if(frm.elements["mun"].value=="")
// SetErrorMessage(1,"Codigo Postal No Valido.");
}
function onChangeActividad() {
    var frm = document.forms["PrimaMant"];
    var idAct = frm.elements["tipoActividad"].selectedIndex;
    // alert(idAct);
    if (idAct == 1 || idAct == 2) {
        javascript: llamarasincrono(
            '../jspServlet/actividadChangeSector.jsp?tipoActividad=' + idAct,
            'sectorDiv');
    frm.elements["sector"].disabled = false;
    frm.elements["rol"].disabled = false;
    frm.elements["subSector"].disabled = true;
    frm.elements["descripcionOcupacion"].disabled = false;
    } else if (idAct == 3) {
        // alert(idAct);
        // javascript:llamarasincrono('../jspServlet/actividadChangeSector.jsp?tipoActividad='+idAct,
        // 'sectorDiv');
        frm.elements["sector"].disabled = true;
        frm.elements["rol"].disabled = false;
        frm.elements["subSector"].disabled = true;
        frm.elements["descripcionOcupacion"].disabled = false;
    } else {
        frm.elements["sector"].disabled = true;
        frm.elements["subSector"].disabled = true;
        frm.elements["rol"].disabled = true;
        frm.elements["descripcionOcupacion"].disabled = true;
        frm.elements["sector"].selectedIndex = 0;
        frm.elements["subSector"].selectedIndex = 0;
        frm.elements["rol"].selectedIndex = 0;
    }
    return false;
}

function onChangeSector() {
    var frm = document.forms["PrimaMant"];
    var idSector = frm.elements["sector"].selectedIndex;
    var idAct = frm.elements["tipoActividad"].selectedIndex;
    if (idSector > 0) {
        javascript: llamarasincrono(
            '../jspServlet/sectorChangeSubsector.jsp?sector=' + idSector
            + "&actividad=" + idAct, 'subsectorDiv');
    if (frm.elements["subSector"].length > 1)
        frm.elements["subSector"].disabled = false;
    } else {
        frm.elements["subSector"].disabled = true;
        frm.elements["subSector"].selectedIndex = 0;
    }

}
function onChangeEstado(idDes) {
    var frm = document.forms["PrimaMant"];
    var idE = frm.elements["ubicacionVivienda"].value;
    if (idE > 0) {
        javascript: llamarasincrono(
            '../jspServlet/estadoChangeDesarrollo.jsp?idDes='+idDes+'&estado=' + idE,
            'desarrolloDiv');
    var paso = frm.elements["desarrollo"].length;
    if (paso > 1)
        frm.elements["desarrollo"].disabled = false;
    else
        frm.elements["desarrollo"].disabled = true;
    } else {
        frm.elements["desarrollo"].disabled = true;
        frm.elements["desarrollo"].selectedIndex = 0;
    }
}
function guardar(thisform) {
    var bandera = 0;
    var frm = document.forms["PrimaMant"];
    if (frm.elements["apellidoMaterno"].value == "") {
        frm.elements["apellidoMaterno"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["apellidoMaterno"].style.backgroundColor = "white";
    }
    if (frm.elements["apellidoPaterno"].value == "") {
        frm.elements["apellidoPaterno"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["apellidoPaterno"].style.backgroundColor = "white";
    }
    if (frm.elements["nombre"].value == "") {
        frm.elements["nombre"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["nombre"].style.backgroundColor = "white";
    }
    if (frm.elements["anio"].value == "-1") {
        frm.elements["anio"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["anio"].style.backgroundColor = "white";
    }
    if (frm.elements["mes"].value == "-1") {
        frm.elements["mes"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["mes"].style.backgroundColor = "white";
    }
    if (frm.elements["dia"].value == "-1") {
        frm.elements["dia"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["dia"].style.backgroundColor = "white";
    }
    if (frm.elements["calle"].value == "") {
        frm.elements["calle"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["calle"].style.backgroundColor = "white";
    }
    if (frm.elements["noExterior"].value == "") {
        frm.elements["noExterior"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["noExterior"].style.backgroundColor = "white";
    }
    if (frm.elements["noInterior"].value == "") {
        frm.elements["noInterior"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["noInterior"].style.backgroundColor = "white";
    }
    if (frm.elements["colonia"].value == "") {
        frm.elements["colonia"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["colonia"].style.backgroundColor = "white";
    }
    if (frm.elements["cp"].value == "") {
        frm.elements["cp"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["cp"].style.backgroundColor = "white";
    }
    if (frm.elements["edoCivil"].value == "-1") {
        frm.elements["edoCivil"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["edoCivil"].style.backgroundColor = "white";
    }
    if (frm.elements["dependientes"].value == "-1") {
        frm.elements["dependientes"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["dependientes"].style.backgroundColor = "white";
    }
    if (frm.elements["ingresoMensual"].value == "-1") {
        frm.elements["ingresoMensual"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["ingresoMensual"].style.backgroundColor = "white";
    }
    if (frm.elements["tipoActividad"].value == "-1") {
        frm.elements["tipoActividad"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["tipoActividad"].style.backgroundColor = "white";
        var idAct = frm.elements["tipoActividad"].selectedIndex;
        if (idAct == 1 || idAct == 2) {
            if (frm.elements["sector"].value == "-1") {
                frm.elements["sector"].style.backgroundColor = "#FFD700";
                bandera = 1;
            } else {
                frm.elements["sector"].style.backgroundColor = "white";
                if (frm.elements["subSector"].length > 1) {
                    if (frm.elements["subSector"].value == "-1") {
                        frm.elements["subSector"].style.backgroundColor = "#FFD700";
                        bandera = 1;
                    } else {
                        frm.elements["subSector"].style.backgroundColor = "white";
                    }
                }
            }
            if (frm.elements["rol"].value == "-1") {
                frm.elements["rol"].style.backgroundColor = "#FFD700";
                bandera = 1;
            } else {
                frm.elements["rol"].style.backgroundColor = "white";
            }
            if (frm.elements["descripcionOcupacion"].value == "") {
                frm.elements["descripcionOcupacion"].style.backgroundColor = "#FFD700";
                bandera = 1;
            } else {
                frm.elements["descripcionOcupacion"].style.backgroundColor = "white";
            }
        } else if (idAct == 3) {
            if (frm.elements["rol"].value == "-1") {
                frm.elements["rol"].style.backgroundColor = "#FFD700";
                bandera = 1;
            } else {
                frm.elements["rol"].style.backgroundColor = "white";
            }
            if (frm.elements["descripcionOcupacion"].value == "") {
                frm.elements["descripcionOcupacion"].style.backgroundColor = "#FFD700";
                bandera = 1;
            } else {
                frm.elements["descripcionOcupacion"].style.backgroundColor = "white";
            }
        }
    }
    if (frm.elements["ubicacionVivienda"].value == "-1") {
        frm.elements["ubicacionVivienda"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["ubicacionVivienda"].style.backgroundColor = "white";
        if (frm.elements["desarrollo"].length > 1) {
            if (frm.elements["desarrollo"].value == "-1") {
                frm.elements["desarrollo"].style.backgroundColor = "#FFD700";
                bandera = 1;
            } else {
                frm.elements["desarrollo"].style.backgroundColor = "white";
            }
        }
    }
    if (frm.elements["valorVivienda"].value == "") {
        frm.elements["valorVivienda"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["valorVivienda"].style.backgroundColor = "white";
    }
    if (frm.elements["mensualidad"].value == "") {
        frm.elements["mensualidad"].style.backgroundColor = "#FFD700";
        bandera = 1;
    } else {
        frm.elements["mensualidad"].style.backgroundColor = "white";
    }
    if (bandera == 1) {
        SetErrorMessage(1,"Todos los campos son requeridos, complete y reintente.");
        return false;
    } else {
        if (confirm("Esta seguro que desea guardar?")){
            if(document.getElementById("idPrima").value==""){
                frm.elements["command"].value = "guardar";
            }else{
                frm.elements["command"].value = "modificar";
            }
            document.forms[thisform].submit();
        }else
            return false;
    }
}
function conMayusculas(campo){
    document.getElementById(campo).value = document.getElementById(campo).value.toUpperCase();
}

function cpValidacion(){
    if(document.getElementById("cp").value.length<5){
        alert("El codigo postal debe tener 5 digitos numericos.");
        document.getElementById("cp").value="";
        document.getElementById("cp").focus();
        return false
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
function activarFechas(){
    if(document.getElementById('cFecha').checked == true){
        document.getElementById('anio').disabled=false;
        document.getElementById('mes').disabled=false;
        document.getElementById('anio').focus();
    }else{
        document.getElementById('anio').disabled=true;
        document.getElementById('mes').disabled=true;
    }
}
function buscarTodos(){
    document.getElementById('command').value = "BuscarT";
    document.getElementById('PrimaIndex').submit();	
}
function SelPrimaIndex(){
    var listaPrim = document.getElementById("listaP");
    var idSel = listaPrim.options[listaPrim.selectedIndex].value;
    document.getElementById("idPrima").value = idSel;
}
function SelPrima(){
    var listaPrim = document.getElementById("listaP");
    var idSel = listaPrim.options[listaPrim.selectedIndex].value;
    document.getElementById("idPrima").value = idSel;
    calcularPrima();
}
function modificarPrima(){
    var idP = document.getElementById("idPrima").value;
    if(idP==""){
        alert("No ha seleccionado un registro para modificar.");
    }else{
        location.assign('../PrimaMantServlet?command=ver&id='+idP);
    }
}
function calcularPrima(){
    var idP = document.getElementById("idPrima").value;
    if(idP==""){
        alert("No ha seleccionado un registro para calcular.");
    }else{
        location.assign('../PrimaMantServlet?command=calcular&id='+idP);
    }
}
function calcularPrimaInicio(){
    location.assign('../PrimaMantServlet?command=calcularinicio');
}
function eliminarPrima(){
    var idP = document.getElementById("idPrima").value;
    if(idP==""){
        alert("No ha seleccionado un registro para Eliminar.");
    }else{
        if (confirm("Esta seguro que desea continuar?")){
            location.assign('../PrimaMantServlet?command=eliminar&id='+idP);
        }else
            location.assign('primaindex.jsp');
    }
}