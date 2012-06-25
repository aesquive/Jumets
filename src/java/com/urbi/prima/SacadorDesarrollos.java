/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbi.prima;

import com.urbi.dao.impl.Dao;
import java.util.LinkedList;
import java.util.List;
import objetos.Des;

/**
 *
 * @author alberto
 */
public class SacadorDesarrollos {
    
    private Dao dao;
    
    public SacadorDesarrollos(){
        dao=new Dao();
    }
    
    public  List<Des> obtenerDesarrollos(int idEdo) {
        List<Des> listaDesa=new LinkedList<Des>();
        Dao dao=new Dao();
        List<Des> tabla = dao.getTabla(Des.class);
        for(Des d:tabla){
            if(d.getEdo().getEdoId().intValue()==idEdo){
                System.out.println(d.getDesDes());
                listaDesa.add(d);
            }
        }
        return listaDesa;
    }
}
