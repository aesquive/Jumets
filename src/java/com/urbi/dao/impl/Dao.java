package com.urbi.dao.impl;

import com.sun.msv.reader.trex.ng.RestrictionChecker;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cli;
import objetos.HibernateUtil;
import objetos.Usu;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ruben G.g
 *
 */
public class Dao {

    private Session sesion = HibernateUtil.getSessionFactory().openSession();

    public Object getCriteria(Class clase, Criterion criterion) {
        return sesion.createCriteria(clase).add(criterion).list().get(0);


    }

    public List get(String tabla) {
        return get(tabla, null);
    }

    public static void main(String[] args) {
        Dao dao = new Dao();
        Cli usu = (Cli) dao.getCriteria(Cli.class, Restrictions.eq("cliId", 40));
    }

    public List get(String tabla, String where) {


        String condicion = where == null ? "" : " where " + where;
        return sesion.createQuery("from " + tabla + " " + condicion).list();

    }

    /**
     * Busca una seccion dependiendo el calid, toma el primero que encuentra
     * toma el maximo id de la tabla cal
     *
     * @param tabla
     * @return
     */
    public List buscaCombo(String tabla) {

        int max = 12;

        for (int i = 0; i <= max; i++) {

            Query q = sesion.createQuery("from " + tabla + " where calId=" + i);

            if (q.list().size() > 0) {
                return q.list();
            }
        }
        return null;
    }

    /**
     * obtiena la lista por el primer calid que encuentra
     *
     * @param tabla
     * @return
     */
    public Object[][] obtenLista(String tabla) {

        List list = buscaCombo(tabla);
        return expande(list);
    }

    /**
     * Separa los resultados en dos arreglos [descripcion1, descripcion2....,
     * descripcionn] y [id1, id2...., id3]
     *
     * @return
     */
    public Object[][] getExp(String tabla, String cond) {
        return expande(get(tabla, cond));
    }

    public Object[][] expande(List pojos) {

        try {

            if (pojos.size() < 1) {
                return null;
            }
            return expande(pojos, -1);

        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Object[][] expande(List pojos, int foo) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        String[] nombre = pojos.get(0).getClass().getName().split("\\.");
        String get = "get" + nombre[nombre.length - 1];

        Method getDes = pojos.get(0).getClass().getMethod(get + "Des", new Class[]{});
        Method getId = pojos.get(0).getClass().getMethod(get + "Id", new Class[]{});

        Object[] llaves = new Object[pojos.size()];
        Object[] vals = new Object[pojos.size()];

        for (int i = 0; i < vals.length; i++) {

            llaves[i] = getDes.invoke(pojos.get(i), new Object[]{});
            vals[i] = getId.invoke(pojos.get(i), new Object[]{});
        }
        return new Object[][]{llaves, vals};
    }

    public void guarda(Object obj) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Object[][] obtenListaSrv(int limInf, int limSup) {

        List lista = obtenerTodoComboConLimites(limInf, limSup);

        return expande(lista);

    }

    public List obtenerTodoComboConLimites(int limInf, int limSup) {

        List<Object> lista = new ArrayList<Object>();

        int max = 12;

        for (int i = 0; i <= max; i++) {

            Query q = sesion.createQuery("from " + "Srv" + " where (calId=" + i + " and (srvId>=" + limInf + " and srvId<=" + limSup + " ))");

            if (q.list().size() > 0) {

                for (Object o : q.list()) {
                    lista.add(o);
                }
            }

        }


        if (lista.size() > 0) {

            return lista;
        }


        return null;
    }

    public Object[][] obtenListaOcp(int limInf, int limSup) {


        List lista = obtenerTodoComboConLimitesOcp(limInf, limSup);

        return expande(lista);

    }

    private List obtenerTodoComboConLimitesOcp(int limInf, int limSup) {

        List<Object> lista = new ArrayList<Object>();

        int max = 12;

        for (int i = 0; i <= max; i++) {

            Query q = sesion.createQuery("from " + "Ocp" + " where (cal.calId=" + i + " and (ocpId>=" + limInf + " and ocpId<=" + limSup + " ))");

            if (q.list().size() > 0) {

                for (Object o : q.list()) {
                    lista.add(o);
                }
            }

        }


        if (lista.size() > 0) {

            return lista;
        }


        return null;
    }

    public Usu getUsu(String user, String pass) {
        List list = sesion.createCriteria(Usu.class).add(Restrictions.eq("usuClave", user)).add(Restrictions.eq("usuPassword", pass)).list();
        if (list.isEmpty()) {
            return null;
        }
        return (Usu) list.get(0);
    }

    public List getTabla(Class clase) {
        return sesion.createCriteria(clase).list();
    }
}
