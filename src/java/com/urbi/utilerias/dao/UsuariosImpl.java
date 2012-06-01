package com.urbi.utilerias.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meve.util.db.ConnectionManager;
import com.meve.util.db.ConnectionUtil;
import com.urbi.dao.impl.Dao;
import com.urbi.db.ConexionDS;
import objetos.Usu;

/**
 *
 * @author Rodrigo Soto Chavarria @mail rodrigo.soto.ch@gmail.com
 */
public class UsuariosImpl implements UsuariosDao {

    public static Connection getConexion() {
        return ConnectionManager.getConexion();
    }

    public void actualizaRegistro(Usuarios usu) {
        String sql = "UPDATE USU SET USU_CLAVE=?, USU_NOMBRE=?, "
                + "USU_PASSWORD=?, USU_PERFIL=? WHERE USU_ID=?";
        PreparedStatement pstmt = null;
        Connection conn = getConexion();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usu.getClave());
            pstmt.setString(2, usu.getNombre());
            pstmt.setString(3, usu.getPassword());
            pstmt.setString(4, usu.getPerfil());
            pstmt.setString(5, usu.getId());
            pstmt.execute();

        } catch (final SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            ConexionDS.endConnection(null, pstmt, conn);
        }
    }

    public List<Usuarios> busquedaRegistros(int tipoCriterio, String criterio) {
        return null;
    }

    public void eliminarRegistro(String id) {
        String sql = "DELETE FROM USU WHERE USU_ID=" + id;
        Connection conn = getConexion();
        try {
            ConexionDS.ejecutarActualizacion(sql, conn);
        } catch (final SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(conn);
        }
    }

    /**
     *
     */
    public Usuarios getRegistroConsulta(int idRegistro) {
        Connection conn = getConexion();
        String sql = "SELECT USU_ID, USU_CLAVE, USU_NOMBRE, USU_PASSWORD, USU_PERFIL "
                + "FROM USU WHERE USU_ID=" + idRegistro;
        Usuarios usuario = new Usuarios();
        try {
            String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
            if (resultado != null && resultado.length > 0) {
                for (int i = 0; i < resultado.length; i++) {
                    usuario.setId(resultado[i][0]);
                    usuario.setClave(resultado[i][1]);
                    usuario.setNombre(resultado[i][2]);
                    usuario.setPassword(resultado[i][3]);
                    usuario.setPerfil(resultado[i][4]);
                }
            }
        } catch (final SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(conn);
        }
        return usuario;
    }

    public int insertaRegistro(Usuarios usu) {
        String sql = "INSERT INTO USU (USU_ID, USU_CLAVE, USU_NOMBRE, "
                + "USU_PASSWORD, USU_PERFIL) VALUES(?,?,?,?,?)";
        PreparedStatement pstmt = null;
        String idUsuario = "";
        Connection conn = getConexion();
        try {
            final long id = ConexionDS.getMaxId(conn, "USU", "USU_ID");
            if (id >= 0) {
                idUsuario = String.valueOf((id + 1));
                pstmt = conn.prepareStatement(sql);
                pstmt.setLong(1, id + 1);
                pstmt.setString(2, usu.getClave());
                pstmt.setString(3, usu.getNombre());
                pstmt.setString(4, usu.getPassword());
                pstmt.setString(5, usu.getPerfil());
                pstmt.execute();
            } else {
                return -1;
            }
        } catch (final SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            ConexionDS.endConnection(null, pstmt, conn);
        }
        return Integer.parseInt(idUsuario);
    }

    /**
     *
     */
    public List<Usuarios> mostrarRegistros(boolean supervisor) {
        Connection conn = getConexion();
        String sql = "SELECT USU_ID, USU_NOMBRE FROM USU ";
        if (supervisor) {
            sql += "WHERE USU_PERFIL IN(0,2)";
        }
        List<Usuarios> lista = new ArrayList<Usuarios>();
        try {
            String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
            if (resultado != null && resultado.length > 0) {
                for (int i = 0; i < resultado.length; i++) {
                    Usuarios usuario = new Usuarios();
                    usuario.setId(resultado[i][0]);
                    usuario.setNombre(resultado[i][1]);
                    lista.add(usuario);
                }
            }
        } catch (final SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(conn);
        }
        return lista;
    }

    /**
     *
     * @param user
     * @param pass
     * @return
     */
    public static Usu autentificacion(String user, String pass) {
        
        Dao dao = new Dao();
        Usu usu = dao.getUsu(user, pass);
        
        return usu;

    }


    /**
     *
     * @param user
     * @return
     */
    public static Usuarios usuarioUrbi(Usu usu) {
        Usuarios usuario = new Usuarios();
        
                    usuario.setId(usu.getUsuId().toString());
                    usuario.setClave(usu.getUsuClave());
                    usuario.setNombre(usu.getUsuClave());
                    String perfil = usu.getUsuPerfil().trim();
                    usuario.setPerfil(perfil);
                    if ("0".equals(perfil)) {
                        usuario.setSupervisor(true);
                    }
                    if ("1".equals(perfil)) {
                        usuario.setAdministrador(true);
                    }
                    if ("2".equals(perfil)) {
                        usuario.setVendedor(true);
                
                    }
        return usuario;
    }
}
