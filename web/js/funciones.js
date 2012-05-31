function MM_swapImgRestore() { // v3.0
	var i, x, a = document.MM_sr;
	for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++)
		x.src = x.oSrc;
}

function MM_preloadImages() { // v3.0
	var d = document;
	if (d.images) {
		if (!d.MM_p)
			d.MM_p = new Array();
		var i, j = d.MM_p.length, a = MM_preloadImages.arguments;
		for (i = 0; i < a.length; i++)
			if (a[i].indexOf("#") != 0) {
				d.MM_p[j] = new Image;
				d.MM_p[j++].src = a[i];
			}
	}
}

function MM_findObj(n, d) { // v4.01
	var p, i, x;
	if (!d)
		d = document;
	if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
		d = parent.frames[n.substring(p + 1)].document;
		n = n.substring(0, p);
	}
	if (!(x = d[n]) && d.all)
		x = d.all[n];
	for (i = 0; !x && i < d.forms.length; i++)
		x = d.forms[i][n];
	for (i = 0; !x && d.layers && i < d.layers.length; i++)
		x = MM_findObj(n, d.layers[i].document);
	if (!x && d.getElementById)
		x = d.getElementById(n);
	return x;
}

function MM_swapImage() { // v3.0
	var i, j = 0, x, a = MM_swapImage.arguments;
	document.MM_sr = new Array;
	for (i = 0; i < (a.length - 2); i += 3)
		if ((x = MM_findObj(a[i])) != null) {
			document.MM_sr[j++] = x;
			if (!x.oSrc)
				x.oSrc = x.src;
			x.src = a[i + 2];
		}
}

function setCommandValue(formReference, actionValue) {
	var frm = document.forms[formReference];
	frm.elements["command"].value = actionValue;
}
function submitForm(formReference, actionValue) {
	setCommandValue(formReference, actionValue);
	formReference.submit();
}
function SetErrorMessage(set, text) {
	document.getElementById('tblError').style.display = (set == 1 ? '' : 'none');
	document.getElementById('errorMessage').innerHTML = (set == 1 ? text : '');
	return false;
}

function AceptaAlfanumericoYPunto() {
	var flag;
	if ((event.keyCode >= 65 && event.keyCode <= 90)
			|| (event.keyCode >= 97 && event.keyCode <= 122))
		event.returnValue = true;
	else if ((event.keyCode == 46 || event.keyCode == 32) && !flag) {
		flag = true;
		event.returnValue = true;
	} else
		event.returnValue = false;
}
function AceptaNumerico() {
	if (event.keyCode >= 48 && event.keyCode <= 57)
		event.returnValue = true;
	else
		event.returnValue = false;

}
function muestraDias() {
	var mes;
	mes = parseInt(formatoDiasMes(document.getElementById("mes").value));
	if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10
			|| mes == 12) {
		if (document.forms["PrimaMant"]["dia"].length == 29) {

		} else if (document.forms["PrimaMant"]["dia"].length == 31) {

		}
	} else if (mes == 2) {
		if (document.forms["PrimaMant"]["dia"].length == 32) {
			var aBorrar = document.forms["PrimaMant"]["dia"].options[31];
			var aBorrar1 = document.forms["PrimaMant"]["dia"].options[30];
			var aBorrar2 = document.forms["PrimaMant"]["dia"].options[29];
			aBorrar.parentNode.removeChild(aBorrar);
			aBorrar1.parentNode.removeChild(aBorrar1);
			aBorrar2.parentNode.removeChild(aBorrar2);
		}

		alert(document.forms["PrimaMant"]["dia"].length);
	} else {
		if (document.forms["PrimaMant"]["dia"].length == 32) {
			var aBorrar = document.forms["PrimaMant"]["dia"].options[31];
			aBorrar.parentNode.removeChild(aBorrar);
			alert(document.forms["PrimaMant"]["dia"].length);
		}
	}
}
function calcular_edad() {
	hoy = new Date();
	var ano;
	ano = parseInt(document.getElementById("anio").value);
	if (ano == -1) {
		return false;
	}
	var mes;
	mes = parseInt(formatoDiasMes(document.getElementById("mes").value));
	if (mes == -1) {
		return false;
	}
	var dia;
	dia = parseInt(formatoDiasMes(document.getElementById("dia").value));
	if (dia == -1) {
		return false;
	}
	edad = hoy.getYear() - ano - 1;

	if (hoy.getMonth() + 1 - mes < 0) {
		if (edad < 18) {
			document.getElementById("edad").value = "";
			alert("Error en la Edad, debe tener entre 18 y 65 a�os.");
			return false;
		} else {
			document.getElementById("edad").value = edad;
			return false;
		}
	}
	if (hoy.getMonth() + 1 - mes > 0) {
		if (edad < 18) {
			document.getElementById("edad").value = "";
			alert("Error en la Edad, debe tener entre 18 y 65 a�os.");
			return false;
		} else {
			document.getElementById("edad").value = edad + 1;
			return false;
		}
	}
	if (hoy.getUTCDate() - dia >= 0) {
		if (edad < 18) {
			document.getElementById("edad").value = "";
			alert("Error en la Edad, debe tener entre 18 y 65 a�os.");
			return false;
		} else {
			document.getElementById("edad").value = edad + 1;
			return false;
		}
	} else {
		if (edad < 18) {
			document.getElementById("edad").value = "";
			alert("Error en la Edad, debe tener entre 18 y 65 a�os.");
			return false;
		} else {
			document.getElementById("edad").value = edad;
			return false;
		}
	}
	return false;
}
function formatoDiasMes(valor) {
	var numero;
	if (valor == "01")
		numero = "1";
	else if (valor == "02")
		numero = "2";
	else if (valor == "03")
		numero = "3";
	else if (valor == "04")
		numero = "4";
	else if (valor == "05")
		numero = "5";
	else if (valor == "06")
		numero = "6";
	else if (valor == "07")
		numero = "7";
	else if (valor == "08")
		numero = "8";
	else if (valor == "09")
		numero = "9";
	else
		numero = valor;
	return numero;
}
function bloqueaBackHistory() {
	if (history.length > 0) {
		history.go(+1);
	}
}