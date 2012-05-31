/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webservice;

/**
 *
 * @author gcasillascos
 */
public class Prom_estado {

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getOcurrencia() {
        return ocurrencia;
    }

    public void setOcurrencia(int ocurrencia) {
        this.ocurrencia = ocurrencia;
    }

    private int estado;
    private double cantidad;
    private int ocurrencia;
    private double promedio;

    public double getPromedio() {
        return cantidad/ocurrencia;
    }

    public Prom_estado(int aestado, double acantidad, int aocurrencia)
    {
        estado = aestado;
        cantidad = acantidad;
        ocurrencia = aocurrencia;
    }
}
