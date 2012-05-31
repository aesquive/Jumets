function activarCamposUsu(valor, supervisor){
	document.getElementById("clave").disabled = valor;
	document.getElementById("nombre").disabled = valor;
	document.getElementById("password").disabled = valor;
	document.getElementById("passwordV").disabled = valor;
	document.getElementById("sup").disabled = valor;
	document.getElementById("admon").disabled = valor;
	document.getElementById("ven").disabled = valor;
	if(valor==false)
		document.getElementById("clave").focus();
	if(supervisor==true)
		document.getElementById("admon").disabled = true;
}
function checkRadio(frmName, rbGroupName) {
	var radios = document[frmName].elements[rbGroupName];
	for ( var i = 0; i < radios.length; i++) {
		if (radios[i].checked) {
			return true;
		}
	}
	return false;
}
function guardar() {
	var bandera = 0;
	// clave
	if (document.getElementById("clave").value == "") {
		document.getElementById("clave").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("clave").style.backgroundColor = "white";

	// nombre
	if (document.getElementById("nombre").value == "") {
		document.getElementById("nombre").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("nombre").style.backgroundColor = "white";

	// password
	if (document.getElementById("password").value == "") {
		document.getElementById("password").style.backgroundColor = "#FFD700";
		document.getElementById("passwordV").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else{
		document.getElementById("password").style.backgroundColor = "white";
		document.getElementById("passwordV").style.backgroundColor = "white";
	}
	
	if (!checkRadio("usuarioForm", "perfil")) {
		document.getElementById("perfilTD").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("perfilTD").style.backgroundColor = "white";
	
	if (bandera == 1) {
		SetErrorMessage(1,
				"Todos los campos son requeridos, complete y reintente.");
		return false;
	} else {
		var idTempo = document.getElementById("id").value;
		var nombre = "";
		if(idTempo=="")
			nombre = "Agregar el Usuario?";
		else
			nombre = "Actualizar el Usuario?";
		if (confirm("Esta seguro que desea "+nombre)) {
			document.getElementById("accion").value = "guardar";
			document.getElementById("usuarioForm").submit();
		}else
			return false;
	}
}
function SelUsuIndex() {
	var listaUsu = document.getElementById("listaU");
	var idSel = listaUsu.options[listaUsu.selectedIndex].value;

	document.getElementById("id").value = idSel;
	document.getElementById("accion").value = "modificar";
	document.getElementById("usuarioForm").submit();
}
function msgLogin(valor){
	if(valor!="")
		SetErrorMessage(1,valor);
	else
		return false;
}
function loginUrbi(){
	var bandera = 0;
	var user  = document.getElementById("user").value;
	var pass  = document.getElementById("pass").value;
	if(user==""){
		var bandera = 1;
		SetErrorMessage(1,"Favor de capturar tu usuario.");
		return false;
	}
	if(pass==""){
		var bandera = 1;
		SetErrorMessage(1,"Favor de capturar tu password.");
		return false;
	}
	if(bandera==0){
		document.getElementById("accion").value = "autentificar";
		document.getElementById("form1").submit();
	}
}
function enabledEnterKeyLogin(e){
	doc = document.form1;
	valida = 0;
	msg="";	
   	var key;
   	if(window.event)
   	    key = window.event.keyCode;     //IE
   	else
   	    key = e.which;     //firefox
   	if(key == 13)
   		loginUrbi();
   	else
   		return true;
}
function eliminarUsuario() {
	var id = document.getElementById("id").value;
	if (id == "") {
		alert("No ha seleccionado un registro para Eliminar.");
	} else {
		if (confirm("Esta seguro que desea eliminar el usuario?")) {
			document.getElementById("accion").value = "eliminar";
			document.getElementById("usuarioForm").submit();
		}else
			return false;
	}
}