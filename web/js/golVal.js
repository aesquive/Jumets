function pagina1Val(evento, forma, tipo) {
	var bandera = 0;
	// apellido paterno
	if (document.getElementById("apellidoPaterno").value == "") {
		document.getElementById("apellidoPaterno").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("apellidoPaterno").style.backgroundColor = "white";

	// apellido materno
	if (document.getElementById("apellidoMaterno").value == "") {
		document.getElementById("apellidoMaterno").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("apellidoMaterno").style.backgroundColor = "white";

	// nombre
	if (document.getElementById("nombre").value == "") {
		document.getElementById("nombre").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("nombre").style.backgroundColor = "white";

	// anio
	if (document.getElementById("anio").value == "-1") {
		document.getElementById("anio").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("anio").style.backgroundColor = "white";

	// mes
	if (document.getElementById("mes").value == "-1") {
		document.getElementById("mes").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("mes").style.backgroundColor = "white";

	// dia
	if (document.getElementById("dia").value == "-1") {
		document.getElementById("dia").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("dia").style.backgroundColor = "white";

	// calle
	if (document.getElementById("calle").value == "") {
		document.getElementById("calle").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("calle").style.backgroundColor = "white";

	// noExterior
	if (document.getElementById("noExterior").value == "") {
		document.getElementById("noExterior").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("noExterior").style.backgroundColor = "white";

	// noInterior
	if (document.getElementById("noInterior").value == "") {
		document.getElementById("noInterior").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("noInterior").style.backgroundColor = "white";

	// colonia
	if (document.getElementById("colonia").value == "") {
		document.getElementById("colonia").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("colonia").style.backgroundColor = "white";

	// cp
	if (document.getElementById("cp").value == "") {
		document.getElementById("cp").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("cp").style.backgroundColor = "white";

	// sexo
	if (document.getElementById("sexo").value == "-1") {
		document.getElementById("sexo").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("sexo").style.backgroundColor = "white";

	// edoCivil
	if (document.getElementById("edoCivil").value == "-1") {
		document.getElementById("edoCivil").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("edoCivil").style.backgroundColor = "white";

	// comercioIndispensable
	if (document.getElementById("comercioIndispensable").value == "-1") {
		document.getElementById("comercioIndispensable").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("comercioIndispensable").style.backgroundColor = "white";

	// comercioIndispensable
	if (document.getElementById("problemaHoy").value == "-1") {
		document.getElementById("problemaHoy").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("problemaHoy").style.backgroundColor = "white";

	// pqSituacionPAnio
	if (document.getElementById("pqSituacionPAnio").value == "") {
		document.getElementById("pqSituacionPAnio").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("pqSituacionPAnio").style.backgroundColor = "white";

	// situacionActual
	if (document.getElementById("situacionActual").value == "-1") {
		document.getElementById("situacionActual").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("situacionActual").style.backgroundColor = "white";

	// situacionPAnio
	if (document.getElementById("situacionPAnio").value == "-1") {
		document.getElementById("situacionPAnio").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("situacionPAnio").style.backgroundColor = "white";

	// deudaPreocupa
	if (document.getElementById("deudaPreocupa").value == "") {
		document.getElementById("deudaPreocupa").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("deudaPreocupa").style.backgroundColor = "white";

	// apoyoInstitucion
	if (document.getElementById("apoyoInstitucion").value == "-1") {
		document.getElementById("apoyoInstitucion").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("apoyoInstitucion").style.backgroundColor = "white";

	// dineroExtra
	if (document.getElementById("dineroExtra").value == "-1") {
		document.getElementById("dineroExtra").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("dineroExtra").style.backgroundColor = "white";

	// gastosAlimentos
	if (document.getElementById("gastosAlimentos").value == "-1") {
		document.getElementById("gastosAlimentos").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("gastosAlimentos").style.backgroundColor = "white";

	// gastosPersonales
	if (document.getElementById("gastosPersonales").value == "-1") {
		document.getElementById("gastosPersonales").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("gastosPersonales").style.backgroundColor = "white";

	// gastosDeudas
	if (document.getElementById("gastosDeudas").value == "-1") {
		document.getElementById("gastosDeudas").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("gastosDeudas").style.backgroundColor = "white";

	// gastosOtros
	if (document.getElementById("gastosOtros").value != "") {
		// gastosOtroCual
		if (document.getElementById("gastosOtroCual").value == "-1") {
			document.getElementById("gastosOtroCual").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("gastosOtroCual").style.backgroundColor = "white";
	}

	if (bandera == 1) {
		SetErrorMessage(1,
				"Todos los campos son requeridos, complete y reintente.");
		return false;
	} else {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}
}

function pagina2Val(evento, forma, tipo) {
	var bandera = 0;

	if (tipo == 2) {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}

	// religionFamilia
	if (document.getElementById("religionFamilia").value == "-1") {
		document.getElementById("religionFamilia").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("religionFamilia").style.backgroundColor = "white";

	// religionFrecuencia
	if (document.getElementById("religionFrecuencia").value == "-1") {
		document.getElementById("religionFrecuencia").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("religionFrecuencia").style.backgroundColor = "white";

	// religionMia
	if (document.getElementById("religionMia").value == "-1") {
		document.getElementById("religionMia").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("religionMia").style.backgroundColor = "white";

	// religionDecision
	if (document.getElementById("religionDecision").value == "") {
		document.getElementById("religionDecision").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("religionDecision").style.backgroundColor = "white";

	// razoncambio
	if (document.getElementById("razoncambio").value == "") {
		document.getElementById("razoncambio").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("razoncambio").style.backgroundColor = "white";

	// motivacion
	if (document.getElementById("motivacion").value == "") {
		document.getElementById("motivacion").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("motivacion").style.backgroundColor = "white";

	// tipoActividad
	if (document.getElementById("tipoActividad").value == "-1") {
		document.getElementById("tipoActividad").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("tipoActividad").style.backgroundColor = "white";

	if (document.getElementById("tipoActividad").value == "1"
			|| document.getElementById("tipoActividad").value == "2") {

		// sector
		if (document.getElementById("sector").value == "-1") {
			document.getElementById("sector").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("sector").style.backgroundColor = "white";

		// subsector
		if (document.getElementById("subSector").value == "-1") {
			document.getElementById("subSector").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("subSector").style.backgroundColor = "white";

		// rol
		if (document.getElementById("rol").value == "-1") {
			document.getElementById("rol").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("rol").style.backgroundColor = "white";

		// descripcionOcupacion
		if (document.getElementById("descripcionOcupacion").value == "") {
			document.getElementById("descripcionOcupacion").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("descripcionOcupacion").style.backgroundColor = "white";

		// tiempoLaborando
		if (document.getElementById("tiempoLaborando").value == "") {
			document.getElementById("tiempoLaborando").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("tiempoLaborando").style.backgroundColor = "white";

	} else if (document.getElementById("tipoActividad").value == "3") {

		// rol
		if (document.getElementById("rol").value == "-1") {
			document.getElementById("rol").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("rol").style.backgroundColor = "white";

		// descripcionOcupacion
		if (document.getElementById("descripcionOcupacion").value == "") {
			document.getElementById("descripcionOcupacion").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("descripcionOcupacion").style.backgroundColor = "white";

		// tiempoLaborando
		if (document.getElementById("tiempoLaborando").value == "") {
			document.getElementById("tiempoLaborando").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("tiempoLaborando").style.backgroundColor = "white";

	}

	// estudiaActual
	if (document.getElementById("estudiaActual").value == "-1") {
		document.getElementById("estudiaActual").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("estudiaActual").style.backgroundColor = "white";

	// gradoE
	if (document.getElementById("gradoE").value == "-1") {
		document.getElementById("gradoE").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("gradoE").style.backgroundColor = "white";

	// gradoEAnio
	if (document.getElementById("gradoEAnio").value == "") {
		document.getElementById("gradoEAnio").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("gradoEAnio").style.backgroundColor = "white";

	// gradoEPapa
	if (document.getElementById("gradoEPapa").value == "-1") {
		document.getElementById("gradoEPapa").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("gradoEPapa").style.backgroundColor = "white";

	// gradoEPAnio
	if (document.getElementById("gradoEPAnio").value == "") {
		document.getElementById("gradoEPAnio").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("gradoEPAnio").style.backgroundColor = "white";

	// gradoEMama
	if (document.getElementById("gradoEMama").value == "-1") {
		document.getElementById("gradoEMama").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("gradoEMama").style.backgroundColor = "white";

	// gradoEMAnio
	if (document.getElementById("gradoEMAnio").value == "") {
		document.getElementById("gradoEMAnio").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("gradoEMAnio").style.backgroundColor = "white";

	// tiempoViviendo
	if (document.getElementById("tiempoViviendo").value == "-1") {
		document.getElementById("tiempoViviendo").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("tiempoViviendo").style.backgroundColor = "white";

	// actividadPrincipal
	if (document.getElementById("actividadPrincipal").value == "-1") {
		document.getElementById("actividadPrincipal").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("actividadPrincipal").style.backgroundColor = "white";

	if (bandera == 1) {
		SetErrorMessage(1,
				"Todos los campos son requeridos, complete y reintente.");
		return false;
	} else {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}
}

function pagina3Val(evento, forma, tipo) {
	var bandera = 0;

	if (tipo == 2) {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}
	// gastoPlaneado
	if (document.getElementById("gastoPlaneado").value == "-1") {
		document.getElementById("gastoPlaneado").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("gastoPlaneado").style.backgroundColor = "white";

	// viveActual
	if (document.getElementById("viveActual").value == "-1") {
		document.getElementById("viveActual").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("viveActual").style.backgroundColor = "white";

	// personasDep
	if (document.getElementById("personasDep").value == "") {
		document.getElementById("personasDep").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("personasDep").style.backgroundColor = "white";

	// respCrisis
	if (document.getElementById("respCrisis").value == "") {
		document.getElementById("respCrisis").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("respCrisis").style.backgroundColor = "white";

	// lugarVivienda
	if (document.getElementById("lugarVivienda").value == "-1") {
		document.getElementById("lugarVivienda").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("lugarVivienda").style.backgroundColor = "white";

	// ingresoMensual
	if (document.getElementById("ingresoMensual").value == "") {
		document.getElementById("ingresoMensual").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("ingresoMensual").style.backgroundColor = "white";

	// ingresoDestino
	if (document.getElementById("ingresoDestino").value == "") {
		document.getElementById("ingresoDestino").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("ingresoDestino").style.backgroundColor = "white";

	// alimentos
	if (document.getElementById("alimentos").value == "-1") {
		document.getElementById("alimentos").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("alimentos").style.backgroundColor = "white";

	// educacion
	if (document.getElementById("educacion").value == "-1") {
		document.getElementById("educacion").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("educacion").style.backgroundColor = "white";

	// vestido
	if (document.getElementById("vestido").value == "-1") {
		document.getElementById("vestido").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("vestido").style.backgroundColor = "white";

	// diversiones
	if (document.getElementById("diversiones").value == "-1") {
		document.getElementById("diversiones").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("diversiones").style.backgroundColor = "white";

	// serviciosV
	if (document.getElementById("serviciosV").value == "-1") {
		document.getElementById("serviciosV").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("serviciosV").style.backgroundColor = "white";

	// pagoDeudas
	if (document.getElementById("pagoDeudas").value == "-1") {
		document.getElementById("pagoDeudas").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("pagoDeudas").style.backgroundColor = "white";

	// limpieza
	if (document.getElementById("limpieza").value == "-1") {
		document.getElementById("limpieza").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("limpieza").style.backgroundColor = "white";

	// renta
	if (document.getElementById("renta").value == "-1") {
		document.getElementById("renta").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("renta").style.backgroundColor = "white";

	// salud
	if (document.getElementById("salud").value == "-1") {
		document.getElementById("salud").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("salud").style.backgroundColor = "white";

	// transporte
	if (document.getElementById("transporte").value == "-1") {
		document.getElementById("transporte").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("transporte").style.backgroundColor = "white";

	// otroGastos
	if (document.getElementById("otroGastos").value != "") {
		// transporte
		if (document.getElementById("cuantogasta").value == "-1") {
			document.getElementById("cuantogasta").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("cuantogasta").style.backgroundColor = "white";
	}

	if (document.getElementById("conyuge").checked == true) {
		// imc
		if (document.getElementById("imc").value == "") {
			document.getElementById("imc").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("imc").style.backgroundColor = "white";

		// ac
		if (document.getElementById("ac").value == "-1") {
			document.getElementById("ac").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("ac").style.backgroundColor = "white";
	} else {
		document.getElementById("imc").style.backgroundColor = "white";
		document.getElementById("ac").style.backgroundColor = "white";
	}

	if (document.getElementById("hijos").checked == true) {
		// imh
		if (document.getElementById("imh").value == "") {
			document.getElementById("imh").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("imh").style.backgroundColor = "white";

		// ac
		if (document.getElementById("ah").value == "-1") {
			document.getElementById("ah").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("ah").style.backgroundColor = "white";
	} else {
		document.getElementById("imh").style.backgroundColor = "white";
		document.getElementById("ah").style.backgroundColor = "white";
	}

	if (document.getElementById("padres").checked == true) {
		// imh
		if (document.getElementById("imp").value == "") {
			document.getElementById("imp").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("imp").style.backgroundColor = "white";

		// ac
		if (document.getElementById("ap").value == "-1") {
			document.getElementById("ap").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("ap").style.backgroundColor = "white";
	} else {
		document.getElementById("imp").style.backgroundColor = "white";
		document.getElementById("ap").style.backgroundColor = "white";
	}

	if (document.getElementById("otros").checked == true) {
		// imh
		if (document.getElementById("imo").value == "") {
			document.getElementById("imo").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("imo").style.backgroundColor = "white";

		// ac
		if (document.getElementById("ao").value == "-1") {
			document.getElementById("ao").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("ao").style.backgroundColor = "white";
	} else {
		document.getElementById("imo").style.backgroundColor = "white";
		document.getElementById("ao").style.backgroundColor = "white";
	}

	if (bandera == 1) {
		SetErrorMessage(1,
				"Todos los campos son requeridos, complete y reintente.");
		return false;
	} else {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}
}

function pagina4Val(evento, forma, tipo) {
	var bandera = 0;

	if (tipo == 2) {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}

	// dineroExtraR
	if (document.getElementById("dineroExtraR").value == "1") {
		// dineroConcepto
		if (document.getElementById("dineroConcepto").value == "") {
			document.getElementById("dineroConcepto").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("dineroConcepto").style.backgroundColor = "white";

		// dineroECuanto
		if (document.getElementById("dineroECuanto").value == "") {
			document.getElementById("dineroECuanto").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("dineroECuanto").style.backgroundColor = "white";

		// dineroFrec
		if (document.getElementById("dineroFrec").value == "-1") {
			document.getElementById("dineroFrec").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("dineroFrec").style.backgroundColor = "white";
	}

	// pagaRenta
	if (document.getElementById("pagaRenta").value == "1") {
		// pagaRCuanto
		if (document.getElementById("pagaRCuanto").value == "") {
			document.getElementById("pagaRCuanto").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("pagaRCuanto").style.backgroundColor = "white";
	}

	// actividadAdicional
	if (document.getElementById("actividadAdicional").value == "") {
		document.getElementById("actividadAdicional").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("actividadAdicional").style.backgroundColor = "white";

	// solicitudCredito
	if (document.getElementById("solicitudCredito").value == "-1") {
		document.getElementById("solicitudCredito").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("solicitudCredito").style.backgroundColor = "white";

	// solicitadoCredito
	if (document.getElementById("solicitadoCredito").value == "-1") {
		document.getElementById("solicitadoCredito").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("solicitadoCredito").style.backgroundColor = "white";

	if (document.getElementById("solicitadoCredito").value == "1") {
		// creditoAnio
		if (document.getElementById("creditoAnio").value == "-1") {
			document.getElementById("creditoAnio").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("creditoAnio").style.backgroundColor = "white";

		// creditoMes
		if (document.getElementById("creditoMes").value == "-1") {
			document.getElementById("creditoMes").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("creditoMes").style.backgroundColor = "white";

		// tipoCredito
		if (document.getElementById("tipoCredito").value == "-1") {
			document.getElementById("tipoCredito").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("tipoCredito").style.backgroundColor = "white";

		// tardoAnio
		if (document.getElementById("tardoAnio").value == "") {
			document.getElementById("tardoAnio").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("tardoAnio").style.backgroundColor = "white";

		// tardoMes
		if (document.getElementById("tardoMes").value == "") {
			document.getElementById("tardoMes").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("tardoMes").style.backgroundColor = "white";
	} else {
		document.getElementById("creditoAnio").style.backgroundColor = "white";
		document.getElementById("creditoMes").style.backgroundColor = "white";
		document.getElementById("tipoCredito").style.backgroundColor = "white";
		document.getElementById("tardoAnio").style.backgroundColor = "white";
		document.getElementById("tardoMes").style.backgroundColor = "white";
	}

	// totalTarjetas
	if (document.getElementById("tc1").checked == true) {
		if (document.getElementById("totalTarjetas").value == "") {
			document.getElementById("totalTarjetas").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("totalTarjetas").style.backgroundColor = "white";
	}

	// cual?
	if (document.getElementById("otro1").checked == true) {
		if (document.getElementById("cualCredito").value == "") {
			document.getElementById("cualCredito").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("cualCredito").style.backgroundColor = "white";
	}

	if (bandera == 1) {
		SetErrorMessage(1,
				"Todos los campos son requeridos, complete y reintente.");
		return false;
	} else {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}
}

function pagina5Val(evento, forma, tipo) {
	var bandera = 0;
	
	if (tipo == 2) {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}

	if (!checkRadio("sico", "pregunta1")) {
		document.getElementById("tdP1").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP1").style.backgroundColor = "white";
	
	if (!checkRadio("sico", "pregunta2")) {
		document.getElementById("tdP2").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP2").style.backgroundColor = "white";
	
	if (!checkRadio("sico", "pregunta3")) {
		document.getElementById("tdP3").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP3").style.backgroundColor = "white";
	
	if (!checkRadio("sico", "pregunta4")) {
		document.getElementById("tdP4").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP4").style.backgroundColor = "white";
	
	if (!checkRadio("sico", "pregunta5")) {
		document.getElementById("tdP5").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP5").style.backgroundColor = "white";
	
	if (!checkRadio("sico", "pregunta6")) {
		document.getElementById("tdP6").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP6").style.backgroundColor = "white";
	
	if (!checkRadio("sico", "pregunta7")) {
		document.getElementById("tdP7").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP7").style.backgroundColor = "white";
	
	if (!checkRadio("sico", "pregunta8")) {
		document.getElementById("tdP8").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP8").style.backgroundColor = "white";
	
	if (!checkRadio("sico", "pregunta9")) {
		document.getElementById("tdP9").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP9").style.backgroundColor = "white";
	
	if (!checkRadio("sico", "pregunta10")) {
		document.getElementById("tdP10").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP10").style.backgroundColor = "white";
	
	if (!checkRadio("sico", "pregunta11")) {
		document.getElementById("tdP11").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP11").style.backgroundColor = "white";
	
	if (!checkRadio("sico", "pregunta12")) {
		document.getElementById("tdP12").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP12").style.backgroundColor = "white";

	if (bandera == 1) {
		SetErrorMessage(1,
				"Todos los campos son requeridos, complete y reintente.");
		return false;
	} else {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}
}
function pagina6Val(evento, forma, tipo) {
	var bandera = 0;
	
	if (tipo == 2) {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}
	
	if (!checkRadio("sico2", "pregunta13")) {
		document.getElementById("tdP13").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP13").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta14")) {
		document.getElementById("tdP14").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP14").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta15")) {
		document.getElementById("tdP15").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP15").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta16")) {
		document.getElementById("tdP16").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP16").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta17")) {
		document.getElementById("tdP17").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP17").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta18")) {
		document.getElementById("tdP18").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP18").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta19")) {
		document.getElementById("tdP19").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP19").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta20")) {
		document.getElementById("tdP20").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP20").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta21")) {
		document.getElementById("tdP21").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP21").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta22")) {
		document.getElementById("tdP22").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP22").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta23")) {
		document.getElementById("tdP23").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP23").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta24")) {
		document.getElementById("tdP24").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP24").style.backgroundColor = "white";
	
	if (!checkRadio("sico2", "pregunta25")) {
		document.getElementById("tdP25").style.backgroundColor = "#FFD700";
		bandera = 1;
	}else
		document.getElementById("tdP25").style.backgroundColor = "white";

	if (bandera == 1) {
		SetErrorMessage(1,
				"Todos los campos son requeridos, complete y reintente.");
		return false;
	} else {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}
}

function pagina7Val(evento, forma, tipo) {
	var bandera = 0;

	if (tipo == 2) {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}
	// mensualidad
	if (document.getElementById("mensualidad").value == "") {
		document.getElementById("mensualidad").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("mensualidad").style.backgroundColor = "white";

	// valorVivienda
	if (document.getElementById("valorVivienda").value == "") {
		document.getElementById("valorVivienda").style.backgroundColor = "#FFD700";
		bandera = 1;
	} else
		document.getElementById("valorVivienda").style.backgroundColor = "white";

	if (document.getElementById("buroCredito1").checked == true) {
		// ant
		if (document.getElementById("ant").value == "-1") {
			document.getElementById("ant").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("ant").style.backgroundColor = "white";

		// act
		if (document.getElementById("act").value == "-1") {
			document.getElementById("act").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("act").style.backgroundColor = "white";

		// hist
		if (document.getElementById("hist").value == "-1") {
			document.getElementById("hist").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("hist").style.backgroundColor = "white";

		// uso
		if (document.getElementById("uso").value == "-1") {
			document.getElementById("uso").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("uso").style.backgroundColor = "white";

		// pago
		if (document.getElementById("pago").value == "-1") {
			document.getElementById("pago").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("pago").style.backgroundColor = "white";

		// pago
		if (document.getElementById("mop").value == "") {
			document.getElementById("mop").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("mop").style.backgroundColor = "white";

		// cuentasA
		if (document.getElementById("cuentasA").value == "-1") {
			document.getElementById("cuentasA").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("cuentasA").style.backgroundColor = "white";

		// maximaA
		if (document.getElementById("maximaA").value == "") {
			document.getElementById("maximaA").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("maximaA").style.backgroundColor = "white";

		// montoA
		if (document.getElementById("montoA").value == "") {
			document.getElementById("montoA").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("montoA").style.backgroundColor = "white";

		// limiteA
		if (document.getElementById("limiteA").value == "") {
			document.getElementById("limiteA").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("limiteA").style.backgroundColor = "white";

		// saldoA
		if (document.getElementById("saldoA").value == "") {
			document.getElementById("saldoA").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("saldoA").style.backgroundColor = "white";

		// cuentasC
		if (document.getElementById("cuentasC").value == "") {
			document.getElementById("cuentasC").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("cuentasC").style.backgroundColor = "white";

		// maximaC
		if (document.getElementById("maximaC").value == "") {
			document.getElementById("maximaC").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("maximaC").style.backgroundColor = "white";

		// montoC
		if (document.getElementById("montoC").value == "") {
			document.getElementById("montoC").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("montoC").style.backgroundColor = "white";

		// limiteC
		if (document.getElementById("limiteC").value == "") {
			document.getElementById("limiteC").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("limiteC").style.backgroundColor = "white";

		// saldoC
		if (document.getElementById("saldoC").value == "") {
			document.getElementById("saldoC").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("saldoC").style.backgroundColor = "white";

		// saldoC
		if (document.getElementById("importeMop").value == "") {
			document.getElementById("importeMop").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("importeMop").style.backgroundColor = "white";

		// tipoCreditoMop
		if (document.getElementById("tipoCreditoMop").value == "") {
			document.getElementById("tipoCreditoMop").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("tipoCreditoMop").style.backgroundColor = "white";

		// pagoRealizar
		if (document.getElementById("pagoRealizar").value == "") {
			document.getElementById("pagoRealizar").style.backgroundColor = "#FFD700";
			bandera = 1;
		} else
			document.getElementById("pagoRealizar").style.backgroundColor = "white";
	}

	if (bandera == 1) {
		SetErrorMessage(1,
				"Todos los campos son requeridos, complete y reintente.");
		return false;
	} else {
		document.getElementById("command").value = evento;
		document.getElementById(forma).submit();
	}
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