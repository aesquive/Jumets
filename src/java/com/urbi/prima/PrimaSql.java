/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.prima;

import com.urbi.db.ConexionDS;

import com.urbi.db.DateFormatter;
import com.urbi.util.GenerateRfc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.meve.util.db.ConnectionManager;
import com.meve.util.db.ConnectionUtil;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Rodrigo
 */
public class PrimaSql {

	public static Connection getConexion() {
		return ConnectionManager.getConexion();
	}

	public static String insertCli() {
		String sql = "INSERT INTO CLI ";
		sql += "(CLI_ID, CLI_APE_PAT, CLI_APE_MAT, ";// 4
		sql += "CLI_NOM, CLI_FEC_NAC, ";// 6
		sql += "CLI_DOM_CAL, CLI_DOM_NUM_EXT, CLI_DOM_NUM_INT, ";// 9
		sql += "CLI_DOM_COL, COD_POS_ID, CAL_ID, CLI_EDAD, CLI_EDO, CLI_MUN, CLI_EDOCIVIL, CLI_RFC, ";
		sql += "CLI_DEPENDIENTES, CLI_INGRESO, CLI_TIPO_ACT, ";
		sql += "CLI_SECTOR, CLI_SUBSECTOR, CLI_OCUPACION, ";
		sql += "CLI_ROL, CLI_UBICACION, CLI_DESARROLLO, ";
		sql += "CLI_VALOR, CLI_MENSUALIDAD) ";
		sql += "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return sql;
	}

	public static String updateCli() {
		String sql = "UPDATE CLI SET ";
		sql += "CLI_APE_PAT=?, CLI_APE_MAT=?, ";// 4
		sql += "CLI_NOM=?, CLI_FEC_NAC=?, ";// 6
		sql += "CLI_DOM_CAL=?, CLI_DOM_NUM_EXT=?, CLI_DOM_NUM_INT=?, ";// 9
		sql += "CLI_DOM_COL=?, COD_POS_ID=?, CLI_EDAD=?, CLI_EDO=?, CLI_MUN=?, CLI_EDOCIVIL=?, CLI_RFC=?, ";
		sql += "CLI_DEPENDIENTES=?, CLI_INGRESO=?, CLI_TIPO_ACT=?, ";
		sql += "CLI_SECTOR=?, CLI_SUBSECTOR=?, CLI_OCUPACION=?, ";
		sql += "CLI_ROL=?, CLI_UBICACION=?, CLI_DESARROLLO=?, ";
		sql += "CLI_VALOR=?, CLI_MENSUALIDAD=? ";
		sql += "WHERE CLI_ID=?";
		return sql;
	}

	public synchronized static int insertaPrima(PrimaBean prima) {
		PreparedStatement pstmt = null;
		String idPrima = "";
		Connection conn = getConexion();
		try {
			final long id = ConexionDS.getMaxId(conn, "CLI", "CLI_ID");
			if (id >= 0) {
				idPrima = String.valueOf((id + 1));
				pstmt = conn.prepareStatement(insertCli());
				pstmt.setLong(1, id + 1);
				pstmt.setString(2, prima.getApellidoPaterno().toUpperCase());
				pstmt.setString(3, prima.getApellidoMaterno().toUpperCase());
				pstmt.setString(4, prima.getNombre().toUpperCase());
				pstmt.setDate(5, DateFormatter.getFechaSQL(
						((prima.getDia().length() == 1) ? "0" + prima.getDia()
								: prima.getDia())
								+ "/"
								+ ((prima.getMes().length() == 1) ? "0"
										+ prima.getMes() : prima.getMes())
								+ "/" + prima.getAnio(),
						DateFormatter.FORMATO_DDMMYYYY));
				pstmt.setString(6, prima.getCalle().toUpperCase());
				pstmt.setString(7, prima.getNoExterior());
				pstmt.setString(8, prima.getNoInterior());
				pstmt.setString(9, prima.getColonia().toUpperCase());
				pstmt.setString(10, prima.getCp());
				pstmt.setInt(11, 4);
				pstmt.setString(12, prima.getEdad());
				pstmt.setString(13, prima.getEdo());
				pstmt.setString(14, prima.getMunicipio());
				pstmt.setString(15, prima.getEdoCivil());
				GenerateRfc rfc = new GenerateRfc();
				String rfcP = rfc.generaRFC(prima.getNombre(), prima
						.getApellidoPaterno(), prima.getApellidoMaterno(),
						prima.getDia() + "/" + prima.getMes() + "/"
								+ prima.getAnio() + "");
				pstmt.setString(16, rfcP);

				pstmt.setString(17, prima.getDependientes());
				pstmt.setString(18, prima.getIngresoMensual());
				pstmt.setString(19, prima.getTipoActividad());
				pstmt.setString(20, prima.getSector());
				pstmt.setString(21, prima.getSubSector());
				pstmt.setString(22, prima.getDescripcionOcupacion()
						.toUpperCase());
				pstmt.setString(23, prima.getRol());
				pstmt.setString(24, prima.getUbicacionVivienda());
				pstmt.setString(25, prima.getDesarrollo());
				pstmt.setString(26, prima.getValorVivienda());
				pstmt.setString(27, prima.getMensualidad());
				pstmt.execute();
			} else
				return -1;
		} catch (final SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, conn);
		}
		return Integer.parseInt(idPrima);
	}

	/**
	 * 
	 * @param prima
	 */
	public synchronized static void updatePrima(PrimaBean prima) {
		PreparedStatement pstmt = null;
		Connection conn = getConexion();
		try {
			pstmt = conn.prepareStatement(updateCli());
			pstmt.setString(1, prima.getApellidoPaterno());
			pstmt.setString(2, prima.getApellidoMaterno());
			pstmt.setString(3, prima.getNombre());
			pstmt.setDate(4, DateFormatter.getFechaSQL(prima.getDia() + "/"
					+ prima.getMes() + "/" + prima.getAnio(),
					DateFormatter.FORMATO_DDMMYYYY));
			pstmt.setString(5, prima.getCalle());
			pstmt.setString(6, prima.getNoExterior());
			pstmt.setString(7, prima.getNoInterior());
			pstmt.setString(8, prima.getColonia());
			pstmt.setString(9, prima.getCp());
			pstmt.setString(10, prima.getEdad());
			pstmt.setString(11, prima.getEdo());
			pstmt.setString(12, prima.getMunicipio());
			pstmt.setString(13, prima.getEdoCivil());
			GenerateRfc rfc = new GenerateRfc();
			String rfcP = rfc.generaRFC(prima.getNombre(), prima
					.getApellidoPaterno(), prima.getApellidoMaterno(), prima
					.getDia()
					+ "/" + prima.getMes() + "/" + prima.getAnio() + "");
			pstmt.setString(14, rfcP);

			pstmt.setString(15, prima.getDependientes());
			pstmt.setString(16, prima.getIngresoMensual());
			pstmt.setString(17, prima.getTipoActividad());
			pstmt.setString(18, prima.getSector());
			pstmt.setString(19, prima.getSubSector());
			pstmt.setString(20, prima.getDescripcionOcupacion());
			pstmt.setString(21, prima.getRol());
			pstmt.setString(22, prima.getUbicacionVivienda());
			pstmt.setString(23, prima.getDesarrollo());
			System.out.println("prima.getValorVivienda()="
					+ prima.getValorVivienda());
			pstmt.setString(24, prima.getValorVivienda());
			System.out.println("prima.getMensualidad()="
					+ prima.getMensualidad());
			pstmt.setString(25, prima.getMensualidad());
			pstmt.setString(26, prima.getIdPrima());
			pstmt.executeUpdate();
		} catch (final SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, conn);
		}
	}

	public static String insertCliPpr() {
		String sql = "INSERT INTO CLI_PPR ";
		sql += "(CLI_MTA_ID, CLI_ID, CAL_ID, ";// 4
		sql += "CLI_FEC_NAC, CLI_EDA_ID, ";// 6
		sql += "COD_POS_ID, OCP_ID, EDO_ID, ";// 9
		sql += "CLI_PPR_MES) ";// 32
		sql += "VALUES(?,?,?,?,?,?,?,?,?)";
		return sql;
	}

	public synchronized static int insertaPrimaPPR(PrimaBean prima) {
		PreparedStatement pstmt = null;
		String idPrima = "";
		Connection conn = getConexion();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		java.util.Date f = new java.util.Date();
		String mes = sdf.format(f);
		try {
			final long id = ConexionDS.getMaxId(conn, "CLI_PPR", "CLI_MTA_ID");
			if (id >= 0) {
				idPrima = String.valueOf((id + 1));
				pstmt = conn.prepareStatement(insertCliPpr());
				pstmt.setLong(1, id + 1);
				pstmt.setString(2, prima.getIdPrima());
				pstmt.setInt(3, 4);
				pstmt.setDate(4, DateFormatter.getFechaSQL(prima.getDia() + "/"
						+ prima.getMes() + "/" + prima.getAnio(),
						DateFormatter.FORMATO_DDMMYYYY));
				pstmt.setString(5, getEdadCal(prima.getEdad()));// CALCULAR EDAD
				pstmt.setString(6, prima.getCp());//
				pstmt.setInt(7, Integer.parseInt(prima.getSubSector()));
				pstmt.setInt(8, Integer.parseInt(prima.getUbicacionVivienda()));
				pstmt.setString(9, getMes(mes));// MES EN LETRA
				pstmt.execute();
			} else
				return -1;
		} catch (final SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, conn);
		}
		return Integer.parseInt(idPrima);
	}

	public static PrimaBean getVer(String id, int bandera) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		PrimaBean p = new PrimaBean();
		try {
			ps = con.prepareStatement((bandera == 0) ? getPrima(id)
					: getPrimaSolo(id));
			rs = ps.executeQuery();
			while (rs.next()) {
				p.setApellidoPaterno(rs.getString("CLI_APE_PAT"));
				p.setApellidoMaterno(rs.getString("CLI_APE_MAT"));
				p.setNombre(rs.getString("CLI_NOM"));
				p.setEdad(rs.getString("CLI_EDAD"));
				p.setEdo(rs.getString("CLI_EDO"));
				p.setMunicipio(rs.getString("CLI_MUN"));
				p.setCalle(rs.getString("CLI_DOM_CAL"));
				p.setNoExterior(rs.getString("CLI_DOM_NUM_EXT"));
				p.setNoInterior(rs.getString("CLI_DOM_NUM_INT"));
				p.setColonia(rs.getString("CLI_DOM_COL"));
				p.setCp(rs.getString("COD_POS_ID"));
				p.setIdPrima(rs.getString("CLI_ID"));
				p.setIdCal(rs.getString("CAL_ID"));
				p.setEdoCivil(rs.getString("CLI_EDOCIVIL"));
				p.setDependientes(rs.getString("CLI_DEPENDIENTES"));
				p.setIngresoMensual(rs.getString("CLI_INGRESO"));
				p.setTipoActividad(rs.getString("CLI_TIPO_ACT"));
				p.setSector(rs.getString("CLI_SECTOR"));
				p.setSubSector(rs.getString("CLI_SUBSECTOR"));
				p.setDescripcionOcupacion(rs.getString("CLI_OCUPACION"));
				p.setRol(rs.getString("CLI_ROL"));
				p.setUbicacionVivienda(rs.getString("CLI_UBICACION"));
				p.setDesarrollo(rs.getString("CLI_DESARROLLO"));
				p.setValorVivienda(rs.getString("CLI_VALOR"));
				p.setMensualidad(rs.getString("CLI_MENSUALIDAD"));

				/*String fechaNac = DateFormatter.getFecha(rs
						.getTimestamp("CLI_FEC_NAC"),
						DateFormatter.FORMATO_DDMMYYYY);
				p.setDia(fechaNac.substring(0, 2));
				p.setMes(fechaNac.substring(3, 5));
				p.setAnio(fechaNac.substring(6, 10));*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, con);
		}
		return p;
	}

	public static String getPrima(String id) {
		String sql = "SELECT * FROM CLI A, CLI_PPR B WHERE A.CLI_ID=B.CLI_ID AND A.CLI_ID="
				+ id;
		return sql;
	}

	public static String getPrimaSolo(String id) {
		String sql = "SELECT * FROM CLI WHERE CLI_ID=" + id;
		return sql;
	}

	public static String getEdad(String edad) {
		String sql = "select rng_eda_id from RNG_EDA where cal_id='4' and rng_eda_lim_inf<="
				+ edad + " and rng_eda_lim_sup>=" + edad;
		return sql;
	}

	public static String getEdadCal(String edad) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		String eda = "";
		try {
			ps = con.prepareStatement(getEdad(edad));
			rs = ps.executeQuery();
			while (rs.next()) {
				eda = rs.getString("rng_eda_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, con);
		}
		return eda;
	}

	public static String getMes(String mes) {
		String nombre = "";
		if ("01".equals(mes))
			nombre = "ENERO";
		else if ("02".equals(mes))
			nombre = "FEBRERO";
		else if ("03".equals(mes))
			nombre = "MARZO";
		else if ("04".equals(mes))
			nombre = "ABRIL";
		else if ("05".equals(mes))
			nombre = "MAYO";
		else if ("06".equals(mes))
			nombre = "JUNIO";
		else if ("07".equals(mes))
			nombre = "JULIO";
		else if ("08".equals(mes))
			nombre = "AGOSTO";
		else if ("09".equals(mes))
			nombre = "SEPTIEMBRE";
		else if ("10".equals(mes))
			nombre = "OCTUBRE";
		else if ("11".equals(mes))
			nombre = "NOVIEMBRE";
		else if ("12".equals(mes))
			nombre = "DICIEMBRE";
		return nombre;
	}

	/**
	 * Metodo combo sector
	 * 
	 * @param idCal
	 * @param idActual
	 * @return
	 */
	public static String getTipoActividad(String idCal, String idActual) {
		Connection conn = getConexion();
		StringBuffer html = new StringBuffer();
		try {
			final String sql = "SELECT TIP_EMP_ID, TIP_EMP_DES FROM TIP_EMP WHERE CAL_ID="
					+ idCal;
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++) {
					html
							.append("<option title='"
									+ resultado[i][1]
									+ "' value=\""
									+ resultado[i][0]
									+ "\" "
									+ ((idActual.equals(resultado[i][0])) ? "selected"
											: "") + ">" + resultado[i][1]
									+ "</option>");
				}
			}
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConnectionUtil.endConnection(conn);
		}
		return html.toString();
	}

	/**
	 * 
	 * @param idCal
	 * @param idActual
	 * @return
	 */
	public static String[][] getSector(String idCal, String idActual,
			String idTA) {
		Connection conn = getConexion();
		try {
			final String sql = "SELECT SRV_ID, SRV_DES FROM SRV WHERE CAL_ID="
					+ idCal + " AND TIP_EMP_ID=" + idTA;
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0)
				return resultado;
			return new String[0][0];
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return new String[0][0];
		} finally {
			ConnectionUtil.endConnection(conn);
		}
	}

	/**
	 * 
	 * @param idCal
	 * @param idActual
	 * @param idSector
	 * @return
	 */
	public static String[][] getSubsector(String idCal, String idActual,
			String idSector) {
		Connection conn = getConexion();
		try {
			final String sql = "SELECT OCP_ID, OCP_DES FROM OCP WHERE CAL_ID="
					+ idCal + " AND SRV_ID=" + idSector;
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0)
				return resultado;
			return new String[0][0];
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return new String[0][0];
		} finally {
			ConnectionUtil.endConnection(conn);
		}
	}

	public static String[][] getEdoMunCP(String cp) {
		Connection conn = getConexion();
		try {
			final String sql = "SELECT EDO_DES, COD_POS_NOM_MUN FROM COD_POS A, EDO B WHERE A.EDO_ID=B.EDO_ID AND COD_POS_ID="
					+ cp;
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0)
				return resultado;
			return new String[0][0];
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return new String[0][0];
		} finally {
			ConnectionUtil.endConnection(conn);
		}
	}

	/**
	 */
	public static String getEdoVivienda(String idCal, String idActual) {
		Connection conn = getConexion();
		StringBuffer html = new StringBuffer();
		try {
			final String sql = "SELECT EDO_ID, EDO_DES FROM EDO WHERE CAL_ID="
					+ idCal;
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++) {
					html
							.append("<option title='"
									+ resultado[i][1]
									+ "' value=\""
									+ resultado[i][0]
									+ "\" "
									+ ((idActual.equals(resultado[i][0])) ? "selected"
											: "") + ">" + resultado[i][1]
									+ "</option>");
				}
			}
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConnectionUtil.endConnection(conn);
		}
		return html.toString();
	}

	/**
	 * 
	 * @param idCal
	 * @param idEdo
	 * @return
	 */
	public static String[][] getDesarollo(String idCal, String idEdo) {
		Connection conn = getConexion();
		try {
			final String sql = "SELECT DES_ID, DES_DES FROM DES WHERE CAL_ID="
					+ idCal + " AND EDO_ID=" + idEdo;
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0)
				return resultado;
			return new String[0][0];
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return new String[0][0];
		} finally {
			ConnectionUtil.endConnection(conn);
		}
	}

	/**
	 * 
	 * @return
	 */
	public static String getListaPrima(String rfc, String persona, int tipo) {
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		String sql = "";
		try {
			if (tipo == 0)
				sql = "SELECT A.CLI_ID, CLI_NOM, CLI_APE_PAT, CLI_APE_MAT "
						+ "FROM CLI A, CLI_PPR B WHERE A.CLI_ID=B.CLI_ID ORDER BY 1";
			else {
				sql = "SELECT A.CLI_ID, CLI_NOM, CLI_APE_PAT, CLI_APE_MAT "
						+ "FROM CLI A, CLI_PPR B WHERE A.CLI_ID=B.CLI_ID AND ";
				if (persona.length() > 0) {
					sql += "(" + PrimaUtil.getReplaceString("CLI_NOM", persona);
					sql += " OR ";
					sql += PrimaUtil.getReplaceString("CLI_APE_PAT", persona);
					sql += " OR ";
					sql += PrimaUtil.getReplaceString("CLI_APE_MAT", persona)
							+ ") ";
				}
				if (rfc.length() > 0) {
					if (persona.length() > 0)
						sql += " OR ";
					sql += "(" + PrimaUtil.getReplaceString("CLI_RFC", rfc)
							+ ") ";
				}
				sql += "ORDER BY 1";
			}

			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				if (resultado != null && resultado.length > 0) {
					for (int i = 0; i < resultado.length; i++) {
						html.append("<option title='" + resultado[i][2] + " "
								+ resultado[i][3] + " " + resultado[i][1]
								+ "' value=\"" + resultado[i][0] + "\">"
								+ resultado[i][2] + " " + resultado[i][3] + " "
								+ resultado[i][1] + "</option>");
					}
				}
			}
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			ConnectionUtil.endConnection(conn);
		}
		return html.toString();
	}

	public static void eliminarPrima(String id) {
		Connection conn = getConexion();
		try {
			final String sql = "DELETE FROM CLI_PPR WHERE CLI_ID=" + id;
			final String sql1 = "DELETE FROM CLI WHERE CLI_ID=" + id;
			ConexionDS.ejecutarActualizacion(sql, conn);
			ConexionDS.ejecutarActualizacion(sql1, conn);
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			ConnectionUtil.endConnection(conn);
		}
	}
}