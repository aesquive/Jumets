/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.dao.impl;

import com.urbi.business.interfaces.Customer;
import com.urbi.dao.interfaces.CustomerDAO;
import com.urbi.util.HibernateUtil2;
import com.urbi.utils.valueobject.CustomerValueObject;
import com.urbi.utils.valueobject.ProcessValueObject;
import java.util.ArrayList;
import java.util.List;
import objetos.Cal;
import objetos.Cli;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JuCMuro
 */
public class CustomerDAOImpl implements CustomerDAO {
 
    public Cli addCustomer(CustomerValueObject customerVO) {

        ProcessValueObject processVO=new ProcessValueObject();
        Session s=null;
        Transaction tx=null;
        Cli customer=new Cli();

        try{
          //s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
          s = HibernateUtil2.currentSession();
          tx = s.beginTransaction();
          //tx.begin();
          System.out.println("customer en el dao: " + customerVO.toString());
          this.fillCustomerValues(customer, customerVO);
          s.saveOrUpdate(customer);
          tx.commit();
          //processVO.setInfoResult("Object",customer);

          System.out.println("se guardo con exito el cliente: " + customer.getCliId());
        }catch(HibernateException ex){
            tx.rollback();
            processVO.setAddError("HibernateError", ex.getMessage());
        }catch(Exception e){
           processVO.setAddError(ProcessValueObject.genericError, e.getMessage());
            tx.rollback();
        }finally{
          HibernateUtil2.closeSession();
        }
        return customer;
    }

    private void fillCustomerValues(Cli customer,CustomerValueObject customerVO){
        //Cal cal = new Cal();
        //cal.setCalId(customerVO.getCalId());
        if(customerVO.getCliId() != 0){

            customer.setCliId(customerVO.getCliId());
        }
        //customer.setCal(cal);
        customer.setCliApeMat(customerVO.getCliApeMat());
        customer.setCliApePat(customerVO.getCliApePat());
        customer.setCliDomCal(customerVO.getCliDomCal());
        customer.setCliDomCol(customerVO.getCliDomCol());
        customer.setCliDomNumExt(customerVO.getCliDomNumExt());
        customer.setCliDomNumInt(customerVO.getCliDomNumInt());
        customer.setCliFecNac(customerVO.getCliFecNac());
        customer.setCliNom(customerVO.getCliNom());
        customer.setCodPosId(customerVO.getCodPosId());
        customer.setCliRFC(customerVO.getCliRFC());
        customer.setCliEdad(customerVO.getCliEdad());
        customer.setCalId(customerVO.getCalId());
        //customer.setCalId(customerVO.getCalId());

    }


/*    public CustomerValueObject getCustomerByID(int IdCustomer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }*/

    public Cli getCustomerByID(CustomerValueObject CustomerVO) {
        
        Session s=null;
        //Transaction tx=null;
        Cli customer=null;

        try{
          //s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
          s = HibernateUtil2.currentSession();
          //tx = s.beginTransaction();

          customer = (Cli) s.createQuery("from Cli c where c.cliId=" + CustomerVO.getCliId()).uniqueResult();

          if(customer == null){
            customer = new Cli();
          }

        }catch(HibernateException ex){
           ex.printStackTrace();
        }catch(Exception e){
           e.printStackTrace();
        }finally{
            HibernateUtil2.closeSession();
        }

        return customer;
    }

    public ProcessValueObject buscarMetaFiltrado(String cadenaWhere) {

        ProcessValueObject processVO=new ProcessValueObject();
        Session s=null;
       // Transaction tx=null;
        List<Cli> clientes = new ArrayList<Cli>();

        try{
          //s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
          s = HibernateUtil2.currentSession();
         // tx = s.beginTransaction();

          clientes = s.createQuery("from Cli c " + cadenaWhere).list();

          System.out.println("esta vacia la lista en el dao: " + clientes.isEmpty());

          processVO.setInfoResult("clientes", clientes);
          
        }catch(HibernateException ex){
            processVO.setAddError("HibernateError", ex.getMessage());
            ex.printStackTrace();
        }catch(Exception e){
           processVO.setAddError(ProcessValueObject.genericError, e.getMessage());
            e.printStackTrace();
        }finally{
            HibernateUtil2.closeSession();
        }

        return processVO;
    }

    public ProcessValueObject actualizaCustomer(Cli cli) {

        ProcessValueObject processVO=new ProcessValueObject();
        Session s=null;
        Transaction tx=null;
         System.out.println("entrando en actualizar customer ");


        try{
          //s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
          s = HibernateUtil2.currentSession();
          tx = s.beginTransaction();
          tx.begin();

          System.out.println("cliente meta: " + cli.getCliId());
          s.update(cli);
          tx.commit();

          System.out.println("Se actualizo el cliente exitosamente: " + cli.getCliId());
          processVO.setInfoResult("Object",cli);

        }catch(HibernateException ex){
            tx.rollback();
            processVO.setAddError("HibernateError", ex.getMessage());
        }catch(Exception e){
           processVO.setAddError(ProcessValueObject.genericError, e.getMessage());
           System.out.println("Error al actualizar el cliente: " + e.getMessage());
           tx.rollback();
        }finally{
          HibernateUtil2.closeSession();
        }
        return processVO;
    }

}
