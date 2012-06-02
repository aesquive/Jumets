/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbitreadores.verificador;

import arbitreadores.base.DaoNuevoGol;
import arbitreadores.objetos.ArbMta;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alberto
 */
public class VerificadorArbitrajeMeta {

    ArbMta arbitraje;
    private final int  diferenciaDias=60;
    private final static double AVERAGE_MILLIS_PER_MONTH = 365.24 * 24 * 60 * 60 * 1000 / 12;
    
    public VerificadorArbitrajeMeta(ArbMta arbitraje){
        this.arbitraje=arbitraje;
    }
    
    public void guardarVerificar(){
        DaoNuevoGol dao=new DaoNuevoGol();
        List<ArbMta> arbitreados=new LinkedList<ArbMta>();
        List<ArbMta> tabla = dao.getTabla(ArbMta.class);
        for(ArbMta arb:tabla){
            if(arb.getCve().equals(arbitraje.getCve())  && calcularDias(arb.getFec(),arbitraje.getFec())<diferenciaDias){
                arbitreados.add(arb);
            }
        }
        dao.guardar(arbitraje);
        arbitreados.add(arbitraje);
        if(arbitreados.size()>1){
            mandarCorreo(arbitreados);
        }
        dao.cerrarSesion();
    }
    
    public int calcularDias(Date anterior , Date ultima){
        double dif= (ultima.getTime() - anterior.getTime()) / AVERAGE_MILLIS_PER_MONTH;
        return ((Double)dif).intValue();
    }
    
    

    private void mandarCorreo(List<ArbMta> arbitreados) {
        System.out.println("mando el correo de meta");
    }
    
}
