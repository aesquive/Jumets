/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webservice;

import java.util.List;

/**
 *
 * @author ydt
 */
public class Cliente {
    private int cliId;
    private int cliSap;
    private int edad;
    private int estado ;
    private int ocupacion;

    private int fecha;

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

    public void setMensualidad(double mensualidad) {
        this.mensualidad = mensualidad;
    }

    public void setValor_vivienda(double valor_vivienda) {
        this.valor_vivienda = valor_vivienda;
    }
    private double ingresos;
    private double mensualidad;
    private double valor_vivienda;
    private List numero;
    private List pago;


   private String clasificacion1;
    private String clasificacion2;
    private String clasificacion3;
    private String clasificacion4;
    private String accion;
    private String accion2;



    public Cliente(int aCliId, int aCliSap,int aEdad,int aEstado,int AOcupacion,int aFecha,double aIngresos,
            double aMensualidad,double aValor_vivienda,List aNumero,List aPago)
    {
        cliId = aCliId;
        cliSap = aCliSap;
        edad = aEdad;
        estado = aEstado;
        ocupacion = AOcupacion;
        fecha = aFecha;
        ingresos  = aIngresos;
        mensualidad  = aMensualidad;
        valor_vivienda = aValor_vivienda;
        numero = aNumero;
        pago = aPago;
    }


    public int getcliSap() {
        return this.cliSap;
    }

    public int getcliId() {
        return this.cliId;
    }

    public int getEstado() {
            return this.estado;
    }
    public int getOcupacion() {
        return this.ocupacion;
    }

   public int getEdad() {
        return this.edad;
    }

    public int getFecha() {
        return this.fecha;
    }

    public double getIngresos() {
        return this.ingresos;
    }

   public double getMensualidad() {
        return this.mensualidad;
    }

    public double getValorVienda() {
        return this.valor_vivienda;

    }

    public List getNumero() {
            return this.numero;
    }

   public List getPago() {
            return this.pago;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getAccion2() {
        return accion2;
    }

    public void setAccion2(String accion2) {
        this.accion2 = accion2;
    }

    public String getClasificacion1() {
        return clasificacion1;
    }

    public void setClasificacion1(String clasificacion1) {
        this.clasificacion1 = clasificacion1;
    }

    public String getClasificacion2() {
        return clasificacion2;
    }

    public void setClasificacion2(String clasificacion2) {
        this.clasificacion2 = clasificacion2;
    }

    public String getClasificacion3() {
        return clasificacion3;
    }

    public void setClasificacion3(String clasificacion3) {
        this.clasificacion3 = clasificacion3;
    }

    public String getClasificacion4() {
        return clasificacion4;
    }

    public void setClasificacion4(String clasificacion4) {
        this.clasificacion4 = clasificacion4;
    }












}
