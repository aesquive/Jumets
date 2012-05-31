/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function validar(){

    campo=document.getElementById("pass").value;

    if(campo=="quants123"){
        alert("contraseña correcta");
        llamadoServlet();
    }
    else{
        alert("contraseña incorrecta");
        return;
    }

}

function llamadoServlet(){


    location.assign('ReportadorServlet');
    
}