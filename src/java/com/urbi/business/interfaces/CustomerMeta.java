/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.business.interfaces;

import com.urbi.utils.valueobject.CustomerMetaValueObject;
import com.urbi.utils.valueobject.ProcessValueObject;
import objetos.Cli;
import objetos.CliMta2;

/**
 *
 * @author JuCMuro
 */
public interface CustomerMeta {

    
    public ProcessValueObject addCustomerMeta(CustomerMetaValueObject customerMetaVO, Cli cli);
    public CliMta2 getCustomerMeta(int idCustomerMeta);

}
