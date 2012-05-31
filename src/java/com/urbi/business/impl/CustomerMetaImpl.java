/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.business.impl;

import com.urbi.business.interfaces.CustomerMeta;
import com.urbi.dao.impl.CustomerMetaDAOImpl;
import com.urbi.dao.interfaces.CustomerMetaDAO;
import com.urbi.utils.valueobject.CustomerMetaValueObject;
import com.urbi.utils.valueobject.ProcessValueObject;
import objetos.Cli;
import objetos.CliMta2;


/**
 *
 * @author JuCMuro
 */
public class CustomerMetaImpl implements CustomerMeta {

   // private CustomerMetaDAO customerMeta;

    public CustomerMetaDAOImpl getCustomerMetaDAO() {
       
        return new CustomerMetaDAOImpl();
    }

    /*public void setCustomerMeta(CustomerMetaDAO customerMeta) {
        this.customerMeta = customerMeta;
    }*/


    public ProcessValueObject addCustomerMeta(CustomerMetaValueObject customerMetaVO, Cli cli) {

       // ProcessValueObject processVO=null;
            //Add Customer

            //return processVO;

        CustomerMetaDAO customerMetaDAO = new CustomerMetaDAOImpl();
        ProcessValueObject processValueObject = null;

        System.out.println("customer meta service");
        processValueObject = customerMetaDAO.addCustomerMeta(customerMetaVO, cli);
        
        return processValueObject;

    }

    public CliMta2 getCustomerMeta(int idCustomerMeta) {
        CustomerMetaDAO dao = new CustomerMetaDAOImpl();

        return dao.getCustomerMetaByID(idCustomerMeta);
    }

    private void buildCustomer(){

    }
    private void buildCustomerMeta(){

    }



}
