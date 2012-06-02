/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbitreadores.verificador;

import arbitreadores.base.DaoNuevoGol;
import arbitreadores.objetos.ArbGolAu;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alberto
 */
public class VerificadorArbitrajeGol {
    
    ArbGolAu arbitraje;
    private final int  diferenciaDias=60;
    private final static double AVERAGE_MILLIS_PER_MONTH = 365.24 * 24 * 60 * 60 * 1000 / 12;
    
    public VerificadorArbitrajeGol(ArbGolAu arbitraje){
        this.arbitraje=arbitraje;
    }
    
    public void guardarVerificar(){
        DaoNuevoGol dao=new DaoNuevoGol();
        dao.guardar(arbitraje);
        dao.cerrarSesion();
    }
    
    public int calcularDias(Date anterior , Date ultima){
        double dif= (ultima.getTime() - anterior.getTime()) / AVERAGE_MILLIS_PER_MONTH;
        return ((Double)dif).intValue();
    }
    
    

    private void mandarCorreo(List<ArbGolAu> arbitreados) {
        System.out.println("mando el correo de gol");
    }
    
}
