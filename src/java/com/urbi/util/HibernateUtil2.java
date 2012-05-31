package com.urbi.util;

import com.mchange.v2.c3p0.DataSources;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ResourceBundle;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * TODO:Describa aqui todo lo que modela a esta clase
 * <br/>Paquete Original: com.urbi.util
 * <br/>Nombre  Original: HibernateUtil2
 * <br/><a href="HibernateUtil.java.html"><i>Ver C�digo Fuente</i> </a>
 *
 * @author <a href="mailto:miguel.rovir@gmail.com">Miguel Angel Islas Rovira</a>
 */
public class HibernateUtil2 {

    public static  SessionFactory sessions;
    static Connection conn;
    static Statement st;
    private static Logger log = Logger.getLogger(HibernateUtil2.class);

    public static final ThreadLocal session = new ThreadLocal();

    public static Session currentSession() throws HibernateException {
        //SessionFactory sessions;
        Session s = (Session) session.get();
        // Se abre una nueva session si no se ha abierto anteriormente en la transaccion
        if (s == null ) {

            log.debug("Se crea la nueva Session a la BD");

            if (sessions == null || sessions.isClosed()) {

                //Configuration conf = getConfiguration(esquema, user, pwd);
                sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            }

            s = sessions.openSession();


            // se guarda en la variable local de la transaccion
            session.set(s);
        }
        return s;
    }


    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        if (s != null){

            log.debug("se cierra la session actual a BD");
            s.close();
        }

        session.set(null);
        //sessions.close();
    }

    public static void closeSessionFactory() throws HibernateException {

        if(sessions != null){

            if (!sessions.isClosed()) {

                log.debug("se cierra el session factory para abrir un nuevo pool");
                sessions.close();
            }
        }

    }



  public static void checkData(String sql) {
    try {
      HibernateUtil2.outputResultSet(st
          .executeQuery(sql));
//      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

    public static void outputResultSet(ResultSet rs) throws Exception{
    ResultSetMetaData metadata = rs.getMetaData();

    int numcols = metadata.getColumnCount();
    String[] labels = new String[numcols];
    int[] colwidths = new int[numcols];
    int[] colpos = new int[numcols];
    int linewidth;

      for (int i = 0; i < numcols; i++) {
        labels[i] = metadata.getColumnLabel(i + 1);
        log.debug(labels[i]+"  ");
    }
      log.debug("------------------------");

    while (rs.next()) {
        for (int i = 0; i < numcols; i++) {
        Object value = rs.getObject(i + 1);
        if(value == null){
            log.debug("       ");
        }else{
            log.debug(value.toString().trim()+"   ");
        }

      }
        log.debug("       ");
    }
    }


    private static Configuration getConfiguration(){
        Configuration configuration = new Configuration();
        String defaultUser = "";
        String defaultUrl = "";
        String defaultPwd = "";

        //todo:agregar usuario, pas y url de la bd

        configuration.setProperty("hibernate.connection.username", defaultUser);
        configuration.setProperty("hibernate.connection.password", defaultPwd);
        configuration.setProperty("hibernate.connection.url",defaultUrl);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        configuration.setProperty("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
        configuration.setProperty("hibernate.show_sql","true");
        configuration.setProperty("hibernate.connection.autocommit","false");
        configuration.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
        //configuration.setProperty("hibernate.query.factory_class", "org.hibernate.hql.classic.ClassicQueryTranslatorFactory");
        configuration.setProperty("hibernate.connection.statement_cache.size", "10");
        configuration.setProperty("hibernate.cglib.use_reflection_optimizer", "true");
        configuration.setProperty("hibernate.bytecode.use_reflection_optimizer", "false");

        //Configuracion para el pool de conecciones con C3P0
        configuration.setProperty("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
        configuration.setProperty("hibernate.c3p0.acquire_increment","1");
        configuration.setProperty("hibernate.c3p0.idle_test_period","300");
        configuration.setProperty("hibernate.c3p0.max_size","100");
        configuration.setProperty("hibernate.c3p0.max_statements","100");
        configuration.setProperty("hibernate.c3p0.min_size","0");
        configuration.setProperty("hibernate.c3p0.timeout","5000");

        /*configuration.addFile("com/pbgmx/dndcatalogos/model/Catalogo.hbm.xml");
        configuration.addFile("com/pbgmx/dndcatalogos/model/SessionBean.hbm.xml");
        configuration.addFile("com/pbgmx/dndcatalogos/model/ListaPrecios.hbm.xml");
        configuration.addFile("com/pbgmx/dndcatalogos/model/ProductosListPrec.hbm.xml");
         */
       

        return configuration;
    }


    public static void reConfigureSessionFactory()throws HibernateException{

        Configuration configuration = getConfiguration();
        sessions = configuration.configure().buildSessionFactory();

    }


    private java.sql.Connection getConection(String url, String username, String password){
        java.sql.Connection conn;
        DataSource unpooledDs;

        try {
            //Se crea el datasource con respecto al usuario logueado
            unpooledDs = DataSources.unpooledDataSource(url,username,password);

            //Se crea datasorce con la configuracion del pool de c3p0
            DataSource pooledDs = DataSources.pooledDataSource(unpooledDs);
            conn = pooledDs.getConnection();

        } catch (SQLException e) {

            String error = "error al crear el data source";
            log.error(error + e);
            throw new HibernateException(error,e);
        }

        return conn;
    }


    public static SessionFactory getSessions() throws Exception{
        return sessions;
    }

}
