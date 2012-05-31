/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.service.dispatchService;

import com.urbi.business.impl.CustomerImpl;
import com.urbi.business.impl.CustomerMetaImpl;
import com.urbi.business.interfaces.Customer;
import com.urbi.business.interfaces.CustomerMeta;
import com.urbi.dao.impl.CustomerMetaDAOImpl;
import com.urbi.dao.interfaces.CustomerMetaDAO;
import com.urbi.utils.valueobject.CustomerMetaValueObject;
import com.urbi.utils.valueobject.CustomerValueObject;
import com.urbi.utils.valueobject.ProcessValueObject;
import objetos.Cli;
import objetos.CliMta2;

/**
 *
 * @author JuCMuro
 */
public class CalculatorLocatorService {

    private CalculatorLocatorService(){
    }
    public  static CalculatorLocatorService getInstance(){
        return new CalculatorLocatorService();
    }
    private Customer customer;

    public Customer getCustomerService() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    private CustomerMeta customerMeta;

    public CustomerMeta getCustomerMeta() {
        return customerMeta;
    }

    public void setCustomerMetaService(CustomerMeta customerMeta) {
        this.customerMeta = customerMeta;
    }

    //test

     public ProcessValueObject addOnlyCustomerTest(CustomerValueObject customerVO){

         ProcessValueObject processVOCustomer=null;
        ProcessValueObject processVOCustomerMeta=null;
        //Add Customer
        try{
            processVOCustomer=null;//this.getCustomerService().addCustomer(customerVO);
        }catch(Exception e){
            processVOCustomer.setAddError(ProcessValueObject.genericError,e.toString());
        }

        //Add Cliente Meta
        try{
            if(!processVOCustomer.isError()){
                //Add the persisted Object


               // processVOCustomer=this.getCustomerMeta().addCustomerMeta(customerMetaVO);
            }

        }catch(Exception e){
            processVOCustomer.setAddError(ProcessValueObject.genericError,e.toString());
        }


        return processVOCustomer;



     }


    //Cliente Meta Service
    public ProcessValueObject addCustomerMeta(CustomerValueObject customerVO,CustomerMetaValueObject customerMetaVO) throws Exception{
        ProcessValueObject processVOCustomer=null;
        ProcessValueObject processVOCustomerMeta=null;
        Cli clienteInsertado = null;
        //Add Customer
        try{
            if(customerVO != null){

                Customer customerService = new CustomerImpl();
                clienteInsertado = customerService.addCustomer(customerVO);

               // clienteInsertado =(Cli)processVOCustomer.getInfoResult().get("object");

                System.out.println("se guardo el customer");
                System.out.println("cliente insertado con el id: " + clienteInsertado.getCliId());
            }else System.out.println("el customer es nulo");
            

        }catch(Exception e){
            //processVOCustomer.setAddError(ProcessValueObject.genericError,e.toString());
            System.out.println("error al insertar customer: ");
            e.printStackTrace();
            
        }

        //Add Cliente Meta
        try{
            //if(!processVOCustomer.isError()){
                //Add the persisted Object
                if(customerMetaVO != null){

                    CustomerMeta customerMetaService = new CustomerMetaImpl();
                    processVOCustomerMeta=customerMetaService.addCustomerMeta(customerMetaVO, clienteInsertado);
                    System.out.println("se guardo el customer meta");

                }else System.out.println("el customer meta es nulo");
                
            //}
            
        }catch(Exception e){
            //processVOCustomer.setAddError(ProcessValueObject.genericError,e.toString());
            System.out.println("error al insertar customer meta: " + e.toString());

            e.printStackTrace();
            
        }
        
        
        return processVOCustomerMeta;
    }

    public ProcessValueObject actualizarMeta(CliMta2 cliMta2){

        CustomerMetaDAO dao = new CustomerMetaDAOImpl();

        return dao.actualizaCustomerMeta(cliMta2);

    }
}
