package com.urbi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.urbi.db.DateFormatter;
import com.meve.util.db.ConnectionManager;
import com.meve.util.db.ConnectionUtil;

public class ConexionDS {

	public synchronized static Connection getConexion() {
		return ConnectionManager.getConexion();
	}

	public synchronized static Connection getConexionContent() {
		return ConnectionManager.getConexion();
	}

	public static String getValorInsercionNull(String valor) {
		if (valor == null || valor.length() == 0) {
			return "null, ";
		} else {
			return "'" + valor + "', ";
		}
	}

	public static String getValorInsercionNullSinComa(String valor) {
		if (valor == null || valor.length() == 0) {
			return "null ";
		} else {
			return "'" + valor + "' ";
		}
	}

	public static String getValorInsercionNullNumero(String valor) {
		if (valor == null || valor.length() == 0) {
			return "null, ";
		} else {
			return valor + ", ";
		}
	}

	public static String getValorInsercionNullNumeroSinComa(String valor) {
		if (valor == null || valor.length() == 0) {
			return "null ";
		} else {
			return valor + " ";
		}
	}

	public static String getSinValorNumero(String valor) {
		if (valor == null || valor.length() == 0) {
			return "-1, ";
		} else {
			return valor + ", ";
		}
	}

	public static String getValorInsercionNullString(String valor) {
		if (valor == null || valor.length() == 0) {
			return "'null', ";
		} else {
			return "'" + valor + "', ";
		}
	}

	public final static char STRING = 's';

	public final static char DATE = 'f';

	public final static char DOUBLE = 'd';

	public final static char INTEGER = 'i';

	public final static char TIMESTAMP = 't';

	/**
	 * @deprecated
	 * @param strQuery
	 * @return ret
	 * @throws SQLException
	 */
	public static String[][] ejecutarSQL(String strQuery) throws SQLException {
		Connection conn = getConexion();
		try {
			return ejecutarSQL(strQuery, conn);
		} finally {
			ConnectionUtil.endConnection(conn);
		}
	}

	public static String[][] ejecutarSQL(String strQuery, Connection conn)
			throws SQLException {
		return ejecutarSQL(strQuery, new char[] {}, new Object[] {},
				new int[] {}, conn);
	}

	/**
	 * @deprecated
	 * @param strQuery
	 * @param mapa
	 * @param formato
	 * @return ret
	 * @throws SQLException
	 */
	public static String[][] ejecutarSQL(String strQuery, char[] mapa,
			int[] formato) throws SQLException {
		Connection conn = getConexion();
		try {
			return ejecutarSQL(strQuery, mapa, formato, conn);
		} finally {
			ConnectionUtil.endConnection(conn);
		}
	}

	public static String[][] ejecutarSQL(String strQuery, char[] mapa,
			int[] formato, Connection conn) throws SQLException {
		return ejecutarSQL(strQuery, mapa, new Object[] {}, formato, conn);
	}

	/**
	 * @deprecated
	 * @param strQuery
	 * @param mapa
	 * @param values
	 * @param formato
	 * @return ret
	 * @throws SQLException
	 */
	public static String[][] ejecutarSQL(String strQuery, char[] mapa,
			Object[] values, int[] formato) throws SQLException {
		Connection conn = getConexion();
		try {
			return ejecutarSQL(strQuery, mapa, values, formato, conn);
		} finally {
			ConnectionUtil.endConnection(conn);
		}
	}

	public static String[][] ejecutarSQL(String strQuery, char[] mapa,
			Object[] values, int[] formato, Connection con) throws SQLException {
		String strResultado[][] = null;
		List vRegistros = new ArrayList();
		// Connection con = null;
		ResultSet rsConsulta = null;
		int columnas = 0;
		try {
			// con = getConexion();
			rsConsulta = ejecutaSelect(con, strQuery, values);
			final ResultSetMetaData rsmdMeta = rsConsulta.getMetaData();
			columnas = rsmdMeta.getColumnCount();
			while (rsConsulta.next()) {
				String[] strRegistro = new String[columnas];
				for (int i = 0; i < columnas; i++) {
					if (mapa.length != 0 && mapa[i] == DATE) {
						strRegistro[i] = DateFormatter.getFecha(rsConsulta
								.getTimestamp(i + 1), formato[i]);
					} else {
						strRegistro[i] = ConnectionUtil.eliminaNulo(rsConsulta
								.getString(i + 1));
					}
				}
				vRegistros.add(strRegistro);
			}
		} catch (final SQLException sqlEx) {
			throw new SQLException("Error al ejecutar el query: "
					+ sqlEx.toString());
		} catch (final Exception Ex) {
			throw new SQLException("Error General al ejecutar el query: "
					+ Ex.toString());
		} finally {
			ConnectionUtil.endConnection(rsConsulta, null, null);
		}
		strResultado = new String[vRegistros.size()][columnas];
		for (int i = 0; i < vRegistros.size(); i++) {
			strResultado[i] = (String[]) vRegistros.get(i);
		}
		return strResultado;
	}

	/**
	 * @deprecated
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public static int ejecutarActualizacion(String query) throws SQLException {
		Connection conn = getConexion();
		try {
			return ejecutarActualizacion(query, conn);
		} finally {
			ConnectionUtil.endConnection(conn);
		}
	}

	public static int ejecutarActualizacion(String query, Connection con)
			throws SQLException {
		// Connection con = null;
		PreparedStatement pstmt = null;
		int registros = 0;
		try {
			// con = getConexion();
			pstmt = con.prepareStatement(query);
			registros = pstmt.executeUpdate();
		} catch (final SQLException sqlEx) {
			throw new SQLException("Error al ejecutar query de update: "
					+ sqlEx.toString());
		} finally {
			ConnectionUtil.endConnection(null, pstmt, null);
		}
		return registros;
	}

	public static int ejecutaInsertUpdateDelete(String query, Object[] values)
			throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int registros = 0;
		try {
			con = getConexion();
			pstmt = generatePreparedStatement(con, query, values);
			registros = pstmt.executeUpdate();
			// con.commit();
		} catch (final SQLException sqlEx) {
			throw new SQLException("Error al ejecutar query de delete: "
					+ sqlEx.toString());
		} finally {
			ConnectionUtil.endConnection(null, pstmt, con);
		}
		return registros;
	}

	public static ResultSet ejecutaSelect(Connection conn, String query,
			Object[] values) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = generatePreparedStatement(conn, query, values);
			rs = pstmt.executeQuery();
		} catch (final SQLException sqlEx) {
			throw new SQLException("Error al ejecutar query de delete: "
					+ sqlEx.toString());
		}
		return rs;
	}

	private static PreparedStatement generatePreparedStatement(Connection conn,
			String query, Object[] values) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(query);
		for (int i = 0; i < values.length; i++) {
			final Object obj = values[i];
			if (obj.getClass().getName().equals("java.lang.String")) {
				pstmt.setString(i + 1, (String) obj);
			} else if (obj.getClass().getName().equals("java.lang.Integer")) {
				pstmt.setInt(i + 1, ((Integer) obj).intValue());
			} else if (obj.getClass().getName().equals("java.lang.Double")) {
				pstmt.setDouble(i + 1, ((Double) obj).doubleValue());
			} else if (obj.getClass().getName().equals("java.lang.Float")) {
				pstmt.setFloat(i + 1, ((Float) obj).floatValue());
			} else if (obj.getClass().getName().equals("java.sql.Date")) {
				pstmt.setDate(i + 1, (java.sql.Date) obj);
			} else if (obj.getClass().getName().equals("java.util.Date")) {
				pstmt.setDate(i + 1, new java.sql.Date(((java.util.Date) obj)
						.getTime()));
			} else if (obj.getClass().getName().equals("java.sql.Timestamp")) {
				pstmt.setTimestamp(i + 1, new java.sql.Timestamp(
						((java.util.Date) obj).getTime()));
			} else if (obj.getClass().getName().equals("java.lang.Long")) {
				pstmt.setLong(i + 1, ((Long) obj).longValue());
			}
		}
		return pstmt;
	}

	public static long getMaxId(Connection conn, String table, String campo) {
                final String sql = "SELECT MAX(" + campo + ") FROM " + table;
                PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
                        pstmt = conn.prepareStatement(sql);
                        rs = pstmt.executeQuery();
                        while (rs.next()) {
				return rs.getLong(1);
			}
		} catch (final SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			ConnectionUtil.endConnection(rs, pstmt, null);
		}
		return -1;
	}

        public static boolean endConnection(ResultSet rs, PreparedStatement pstmt,
			Connection conn) {
		boolean result = false;
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
				result = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
}