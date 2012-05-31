//si si pertenece obtenemos todo el combo de srv
function llenarComboServicio(campo,inferior,superior){


    if(superior==null && inferior==null){



      inferior=obtenerInferior(campo);

      superior=obtenerSuperior(campo);

    }


    $.ajax({
                  url: '../ComboServicio?limInf='+inferior+"&limSup="+superior+"&nom="+campo.name,
                  dataType: 'json',
                  async:false,
                  success: function(json) {
                        
                        cargaComboServ(campo, json);

                  },
                  cache: true
               });




}



//vamos a cargar el combo dependiendo el nombre de la variable
function cargaComboServ(campo, valores){


    var opciones = campo.options;


    if(opciones!=undefined ){


            $.each(valores, function(ind, val){


               opciones[opciones.length]=new Option(ind,val);

            });


    }


}



function filtrarSector(campo){

    

    //para filtrar srv
    if(campo.name=="tipoActividad"){


        filtrarSrv(campo);

    }
    //para filtrar ocp
    if(campo.name=="sector"){

        filtrarOcp(campo);

    }

}


function filtrarSrv(campo){

  

    var tipEmpSeleccionado=campo.value;

    var srv=document.getElementById("sector");



    bloquearCampo(srv.id, "true");



    var inferior=obtenerInferiorTipEmp(tipEmpSeleccionado);

    var superior=obtenerSuperiorTipEmp(tipEmpSeleccionado);

//VACIAMOS EL COMBO
        borrarCombo(srv);

        //agregamos el option de seleccione
        srv.options[0]=new Option("-Seleccione-","0");

        if(inferior!=-1 && superior!=-1){

            //llenamos el combo por si hubo un cambio de opcion
            llenarComboServicio(srv,inferior,superior);
            bloquearCampo(srv.id, "false");

            return;

        }

    //si se eligio no remunerado o sin ocupacion bloqueamos srv y ocp
    srv.value="0";

    bloquearCampo("subSector", "true");

    document.getElementById("subSector").value="0";


}



function obtenerInferiorTipEmp(tipEmpSeleccionado){

    if(tipEmpSeleccionado=="1"){
        return 35;
    }
    if(tipEmpSeleccionado=="2"){
        return 39;
    }
    //para cuando se elige sin ocupacion o no remunerado
    else{
        return -1;
    }
}

function obtenerSuperiorTipEmp(tipEmpSeleccionado){

    if(tipEmpSeleccionado=="1"){
        return 38;
    }
    if(tipEmpSeleccionado=="2"){
        return 40;
    }
    //para cuando se elige sin ocupacion o no remunerado
    else{
        return -1;
    }
}

function borrarCombo(campo){

    var opciones=campo.options;

    var index=0;

    while(opciones[index]!=null){

    opciones[index]=null;

    }

}




function filtrarOcp(campo){


    var srvSeleccionado=campo.value;


    var ocp=document.getElementById("subSector");

    

    bloquearCampo(ocp.id, "true");


    var inferior=obtenerInferiorOcp(srvSeleccionado);

    var superior=obtenerSuperiorOcp(srvSeleccionado);



   //VACIAMOS EL COMBO
        borrarCombo(ocp);

        //agregamos el option de seleccione
        ocp.options[0]=new Option("-Seleccione-","0");

        if(inferior!=-1 && superior!=-1){

            //llenamos el combo por si hubo un cambio de opcion
            llenarComboServicio(ocp,inferior,superior);
            bloquearCampo(ocp.id, "false");

            return;

        }

    //si se eligio no remunerado o sin ocupacion bloqueamos srv y ocp
    ocp.value="0";

    bloquearCampo("subSector", "true");

    document.getElementById("subSector").value="0";




}


function obtenerInferiorOcp(valorSrv){
    //agricola ganadera
    if(valorSrv==35){
        return 86;
    }
    //comercio
    if(valorSrv==36){
        return 60;
    }
    //servicios
    if(valorSrv==37){
        return 64;
    }
    //profesionista
    if(valorSrv==38){
        return 74;
    }
    //jefes y supervisores
    if(valorSrv==39){
        return 81;
    }
    //coordinadores
    if(valorSrv==40){
        return 84;
    }else{
        return -1;
    }

}



function obtenerSuperiorOcp(valorSrv){

    //agricola ganadera
    if(valorSrv==35){
        return 86;
    }
    //comercio
    if(valorSrv==36){
        return 63;
    }
    //servicios
    if(valorSrv==37){
        return 73;
    }
    //profesionista
    if(valorSrv==38){
        return 80;
    }
    //jefes y supervisores
    if(valorSrv==39){
        return 83;
    }
    //coordinadores
    if(valorSrv==40){
        return 85;
    }else{
        return -1;
    }
}

function bloquearCampo(nombre,valor){

    if(valor=="false"){
        $("#"+nombre).removeAttr("disabled");
        return;
    }

    $("#"+nombre).attr("disabled", valor);
}
