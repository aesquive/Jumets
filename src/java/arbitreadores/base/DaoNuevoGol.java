package arbitreadores.base;

import arbitreadores.objetos.ArbGolAu;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author alberto
 */
public class DaoNuevoGol {

    private Session sesion;
    
    public DaoNuevoGol(){
        sesion= sesion==null ? HibernateUtilNuevoGol.getSessionFactory().openSession() : sesion  ;
    }
    
    
    public void cerrarSesion(){
        sesion.close();
    }
    
    public void guardar(Object o){
        Transaction tran=sesion.beginTransaction();
        sesion.save(o);
        tran.commit();
    }

    public List getTabla(Class aClass) {
        return sesion.createCriteria(aClass).list();
    }
    
    public static void main(String[] args) {
        DaoNuevoGol dao=new DaoNuevoGol();
    }
}
