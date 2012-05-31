/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.dao.interfaces;

import com.urbi.utils.valueobject.CustomerValueObject;
import com.urbi.utils.valueobject.ProcessValueObject;
import java.util.List;
import objetos.Cli;

/**
 *
 * @author JuCMuro
 */
public interface CustomerDAO {
    public Cli addCustomer(CustomerValueObject CustomerVO );
    public Cli getCustomerByID(CustomerValueObject CustomerVO );
    public ProcessValueObject buscarMetaFiltrado(String cadenaWhere);
    public ProcessValueObject actualizaCustomer(Cli cli);
}
