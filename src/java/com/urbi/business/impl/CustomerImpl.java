/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.business.impl;

import com.urbi.business.interfaces.Customer;
import com.urbi.dao.impl.CustomerDAOImpl;
import com.urbi.dao.interfaces.CustomerDAO;
import com.urbi.utils.valueobject.CustomerValueObject;
import com.urbi.utils.valueobject.ProcessValueObject;
import java.util.List;
import objetos.Cli;
import org.hibernate.Transaction;
import org.hibernate.transaction.CMTTransaction;
import org.hibernate.transaction.JTATransaction;

/**
 *
 * @author JuCMuro
 */
public class CustomerImpl implements Customer{

/*    private CustomerDAO customerDAO;

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
*/

    public Cli addCustomer(CustomerValueObject customerVO) {

        System.out.println("valor del customer en el service: " + customerVO.toString());
        CustomerDAO customerDAO = new CustomerDAOImpl();
        Cli cli  =   customerDAO.addCustomer(customerVO);
        System.out.println("el resultado en el service: " + cli);
       
        return cli;
    }

    public Cli getCustomerByID(int IdCustomer) {
        CustomerDAO dao = new CustomerDAOImpl();

        CustomerValueObject CustomerValueObject = new CustomerValueObject();
        CustomerValueObject.setCliId(IdCustomer);

        return dao.getCustomerByID(CustomerValueObject);
    }

    public ProcessValueObject filtarMeta(String cadenaWhere) {

        CustomerDAO dao = new CustomerDAOImpl();

        return dao.buscarMetaFiltrado(cadenaWhere);
    }

}
