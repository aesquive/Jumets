/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.dao.interfaces;

import com.urbi.utils.valueobject.CustomerMetaValueObject;
import com.urbi.utils.valueobject.ProcessValueObject;
import java.util.List;
import objetos.Cli;
import objetos.CliMta2;
import objetos.Des;
import objetos.Ocp;
import objetos.Srv;

/**
 *
 * @author JuCMuro
 */
public interface CustomerMetaDAO {


    public ProcessValueObject addCustomerMeta(CustomerMetaValueObject customerMetaValueObject, Cli cli);

     public ProcessValueObject actualizaCustomerMeta(CliMta2 cliMta);

     public CliMta2 getCustomerMetaByID(int idMeta);

     public List<Srv> obtieneSectores(int tipoActividad);

     public List<Ocp> obtineSubsectores(int sector);

     public List<Des> obtenerDesarollosXEdo(int estado);
}
