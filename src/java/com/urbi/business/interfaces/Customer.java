/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.business.interfaces;

import com.urbi.utils.valueobject.CustomerValueObject;
import com.urbi.utils.valueobject.ProcessValueObject;
import java.util.List;
import objetos.Cli;

/**
 *
 * @author JuCMuro
 */
public interface Customer {
    public Cli addCustomer(CustomerValueObject customerVO);
    public Cli getCustomerByID(int IdCustomer);
    public ProcessValueObject filtarMeta(String cadenaWhere);

}
