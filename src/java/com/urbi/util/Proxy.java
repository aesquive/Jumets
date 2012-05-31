/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.util;

import com.urbi.dao.impl.CustomerMetaDAOImpl;
import com.urbi.dao.interfaces.CustomerMetaDAO;
import java.util.ArrayList;
import java.util.List;
import objetos.Des;
import objetos.Ocp;
import objetos.Srv;

/**
 *
 * @author Quants
 */
public class Proxy {

    public Object[] obtieneSectores(int tipoActividad){

        CustomerMetaDAO dao = new CustomerMetaDAOImpl();

        List<Srv> srvs = dao.obtieneSectores(tipoActividad);
        System.out.println(srvs.get(0));
        if(srvs == null){
            System.out.println("Se setea la lista vacia");
            srvs= new ArrayList<Srv>();
        }

        return srvs.toArray();

    }

    public Object[] obtieneSubsectores(int sector){

        CustomerMetaDAO dao = new CustomerMetaDAOImpl();

        List<Ocp> ocps = dao.obtineSubsectores(sector);

        if(ocps == null){
            System.out.println("Se setea la lista vacia");
            ocps= new ArrayList<Ocp>();
        }

        return ocps.toArray();

    }


    public int[] obtenerDiasMes(int mes){

        int diasLenght = 0;
        int[] arregloDias = new int[0];
        try{
            switch(mes){
                case 1: diasLenght = 31; break;
                case 2: diasLenght = 28; break;
                case 3: diasLenght = 31; break;
                case 4: diasLenght = 30; break;
                case 5: diasLenght = 31; break;
                case 6: diasLenght = 30; break;
                case 7: diasLenght = 31; break;
                case 8: diasLenght = 31; break;
                case 9: diasLenght = 30; break;
                case 10: diasLenght = 31; break;
                case 11: diasLenght = 30; break;
                case 12: diasLenght = 31; break;
                default: diasLenght = 31; break;
            }

            System.out.println("mes seleccionado: " + mes);
            arregloDias = new int[diasLenght];

            for(int i=0;i<diasLenght;i++){
               int dia = i+1;
               arregloDias[i] = dia;

            }

            System.out.println("tamaño del mes: " + diasLenght);

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return arregloDias;

    }


    public Object[] obtenerDesarollos(int estado){

         CustomerMetaDAO dao = new CustomerMetaDAOImpl();

         List<Des> desarrollos = dao.obtenerDesarollosXEdo(estado);

         if(desarrollos == null)
             desarrollos = new ArrayList<Des>();

         return desarrollos.toArray();

    }
 

}
