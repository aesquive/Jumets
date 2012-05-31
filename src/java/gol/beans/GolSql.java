/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gol.beans;

import com.meve.util.db.ConnectionManager;

import com.meve.util.db.ConnectionUtil;

import com.urbi.db.ConexionDS;
import com.urbi.db.DateFormatter;
import com.urbi.prima.PrimaBean;
import com.urbi.prima.PrimaUtil;
import com.urbi.util.GenerateRfc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Rodrigo
 */
public class GolSql {

	public static Connection getConexion() {
		return ConnectionManager.getConexion();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static String getSexo(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT SEX_ID, SEX_DES FROM SEX WHERE CAL_ID='3'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getEdoCivil(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = ConnectionManager.getConexion();
		try {
			final String sql = "SELECT EDO_CVL_ID, EDO_CVL_DES FROM EDO_CVL WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getServicios(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT SRV_ID, SRV_DES FROM SRV WHERE CAL_ID='5'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getProblemas(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT PBM_ID, PBM_DES FROM PBM WHERE CAL_ID='5'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getSituacionActual(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT SIT_ACT_ID, SIT_ACT_DES FROM SIT_ACT WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getSituacionProx(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT SIT_PRX_AN_ID, SIT_PRX_AN_DES FROM SIT_PRX_AN WHERE CAL_ID='3'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getDineroExtra(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT DIN_EXT_ID, DIN_EXT_DES FROM DIN_EXT WHERE CAL_ID='5'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getReligion(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT REL_FAM_ID, REL_FAM_DES FROM REL_FAM WHERE CAL_ID='5'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getFreReligion(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT FRE_REL_ID, FRE_REL_DES FROM FRE_REL WHERE CAL_ID='3'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getNE(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT NIV_EST_ID, NIV_EST_DES FROM NIV_EST WHERE CAL_ID='5'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getNEP(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT NIV_EST_PAP_ID, NIV_EST_PAP_DES FROM NIV_EST_PAP WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getNEM(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT NIV_EST_MAM_ID, NIV_EST_MAM_DES FROM NIV_EST_MAM WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getActUlt(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT ACT_ULT_ID, ACT_ULT_DES FROM ACT_ULT WHERE CAL_ID='5'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getGastoPlaneado(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT GTO_IMP_ID, GTO_IMP_DES FROM GTO_IMP WHERE CAL_ID='5'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getViveActual(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT VIV_ACT_ID, VIV_ACT_DES FROM VIV_ACT WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getLugarVivienda(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT MOV_ID, MOV_DES FROM MOV WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getApo1(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT APO_CON_ID, APO_CON_DES FROM APO_CON WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getApo2(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT APO_HIJ_ID, APO_HIJ_DES FROM APO_HIJ WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getApo3(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT APO_PAD_ID, APO_PAD_DES FROM APO_PAD WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getApo4(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT APO_OTR_ID, APO_OTR_DES FROM APO_OTR WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getBurUsu(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT BUR_USO_ID, BUR_USO_DES FROM BUR_USO WHERE CAL_ID='3'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static String getVestido(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT GTO_VES_ID, GTO_VES_DES FROM GTO_VES WHERE CAL_ID='5'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getSolicitudCredito(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT PTM_ID, PTM_DES FROM PTM WHERE CAL_ID='5'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public synchronized static int insertaGol(GolBean gol, int idPrima) {
		PreparedStatement p = null;
		Connection conn = getConexion();
		String idGol = "";
		try {
			final long id = ConexionDS.getMaxId(conn, "CLI_GOL", "CLI_GOL_ID");
			if (id >= 0) {
				idGol = String.valueOf((id + 1));
				p = conn.prepareStatement(insertGol());
				p.setLong(1, id + 1);
				// Pantalla 1
				p.setString(2, gol.getComercioIndispensable());// SERV_IND_ID
				p.setString(3, gol.getProblemaHoy());// PBM_ID
				p.setString(4, gol.getSituacionActual());// SIT_ACT_ID
				p.setString(5, gol.getSituacionPAnio());// SIT_PRX_AN_ID
				p.setString(6, gol.getPqSituacionPAnio().toUpperCase());// CLI_GOL_SIT_POR
				p.setString(7, gol.getDeudaPreocupa().toUpperCase());// CLI_GOL_DEU_PRE
				p.setString(8, gol.getApoyoInstitucion());// APY_ECO_ID
				p.setString(9, gol.getDineroExtra());// DIN_EXT_ID

				// Pantalla 2
				p.setString(10, gol.getGastosAlimentos());// GTO_ALM_ID
				p.setString(11, gol.getGastosPersonales());// GTO_PER_ID
				p.setString(12, gol.getGastosDeudas());// GTO_DEU_ID
				p.setString(13, gol.getGastosOtroCual());// GTO_OTR_ID

				p.setString(14, gol.getReligionFamilia());// REL_FAM_ID
				p.setString(15, gol.getReligioOtra());// CLI_GOL_REL_FAM_OTR
				p.setString(16, gol.getReligionMia());// REL_ID
				p.setString(17, gol.getReligionMiaOtra());// CLI_GOL_REL_OTR
				p.setString(18, gol.getReligionFrecuencia());// FRE_REL_ID
				p.setString(19, gol.getReligionDecision().toString());// CLI_GOL_REL_DEC
				p.setString(20, gol.getRazoncambio().toUpperCase());// CLI_GOL_MOT_CAS
				p.setString(21, gol.getMotivacion().toUpperCase());// CLI_GOL_MOT_CAM
				p.setInt(22, gol.getTiempoViviendo());// CLI_GOL_RES_ACT
				p.setString(23, gol.getActividadPrincipal());// ACT_ULT_ID
				p.setString(24, gol.getNoTrabaja());// CLI_GOL_ACT_POR
				p.setString(25, gol.getTipoActividad());// TIP_EMP_ID
				p.setString(26, gol.getSector());// SRV_ID
				p.setString(27, gol.getSubsector());// OCP_ID
				p.setString(28, gol.getDescripcionOcupacion());// CLI_GOL_OCU_ACT
				p.setString(29, gol.getRol());// ROL_ID
				p.setString(30, gol.getTiempoLaborando());// CLI_GOL_EMP_ACT

				p.setString(31, gol.getEstudiaActual());// EST_ID
				p.setString(32, gol.getGradoE());// NIV_EST_ID
				p.setString(33, gol.getGradoEAnio());// CLI_GOL_EST_CLI
				p.setString(34, gol.getGradoEPapa());// NIV_EST_PAP_ID
				p.setString(35, gol.getGradoEPAnio());// CLI_GOL_EST_PAD
				p.setString(36, gol.getGradoEMama());// NIV_EST_MAM_ID
				p.setString(37, gol.getGradoEMAnio());// CLI_GOL_EST_MAD

				// Pagina 3
				p.setString(38, gol.getRespCrisis());// CLI_GOL_RES_CRI
				p.setString(39, gol.getLugarVivienda());// MOV_ID
				p.setString(40, gol.getGastoPlaneado());// PRO_ANO_GTO_ID
				p.setString(41, gol.getViveActual());// VIV_ACT_ID
				p.setString(42, gol.getPersonasDep());// CLI_GOL_NUM_DEP

				p.setString(43, gol.getIngresoMensual());// CLI_GOL_DES_ING

				p.setInt(44, Integer.parseInt((gol.getAc() == null) ? "-1"
						: gol.getAc()));// APO_CON_ID
				p.setInt(45, Integer.parseInt((gol.getAh() == null) ? "-1"
						: gol.getAh()));// APO_HIJ_ID
				p.setInt(46, Integer.parseInt((gol.getAp() == null) ? "-1"
						: gol.getAp()));// APO_PAD_ID
				p.setInt(47, Integer.parseInt((gol.getAo() == null) ? "-1"
						: gol.getAo()));// APO_OTR_ID

				p.setString(48, gol.getAlimentos());// GTO_ALM_H_ID
				p.setString(49, gol.getVestido());// GTO_VES_ID
				p.setString(50, gol.getServiciosV());// GTO_SRV_VIV_ID
				p.setString(51, gol.getLimpieza());// GTO_LIM_ID
				p.setString(52, gol.getSalud());// GTO_SLD_ID
				p.setString(53, gol.getTransporte());// GTO_TRN_ID
				p.setString(54, gol.getEducacion());// GTO_EDU_ID
				p.setString(55, gol.getDiversiones());// GTO_DIV_ID
				p.setString(56, gol.getPagoDeudas());// GTO_DEU_H_ID
				p.setString(57, gol.getRenta());// GTO_REN_H_ID
				p.setString(58, gol.getOtroGastos());// CLI_GOL_GAS_GAS
				p.setString(59, gol.getCuantogasta());// GTO_OTR_H_ID

				// pagina 4
				System.out.println("gol.getDineroExtraR()="
						+ gol.getDineroExtraR());
				p.setString(60, gol.getSolicitudCredito());// PTM_ID
				p.setString(61, gol.getSolicitadoCredito());// SOL_CRE_ID
				p.setString(62, gol.getTipoCredito());// TIP_CRE_ID
				p.setString(63, gol.getCreditoAnio());// CLI_GOL_ANO_CRE
				p.setString(64, gol.getCreditoMes());// CLI_GOL_MES_CRE
				p.setString(65, gol.getTardoAnio());// CLI_GOL_PAG_ANO
				p.setString(66, gol.getTardoMes());// CLI_GOL_PAG_MES
				p.setString(67, gol.getDineroECuanto());// DIN_EXT_H_ID
				p.setString(68, gol.getDineroExtraR());// CLI_GOL_DIN_EXT
				p.setString(69, gol.getDineroFrec());// FRE_DIN_ID
				p.setString(70, gol.getPagaRenta());// PAG_RNT_ID
				System.out.println("gol.getSolicitudCredito()="
						+ gol.getSolicitudCredito());

				p.setString(71, gol.getTarjetaC());// CLI_GOL_TAR_CRE
				p.setString(72, gol.getTotalTarjetas());// CLI_GOL_NUM_TAR
				p.setString(73, gol.getTarjetaD());// CLI_GOL_TAR_DEB
				p.setString(74, gol.getCuentaCheque());// CLI_GOL_CTA_CHE
				p.setString(75, gol.getCreditoPersonal());// CLI_GOL_CRE_PER
				p.setString(76, gol.getCreditoAuto());// CLI_GOL_CRE_AUT
				p.setString(77, gol.getCreditoHipo());// CLI_GOL_CRE_HIP
				p.setString(78, gol.getSeguroVida());// CLI_GOL_SEG_VID
				p.setString(79, gol.getSeguroMedico());// CLI_GOL_SEG_GMM
				System.out.println("gol.getOtroCredito()="
						+ gol.getOtroCredito());
				p.setString(80, gol.getOtroCredito());// CLI_GOL_OTR_CRE
				p.setString(81, gol.getCualCredito());// CLI_GOL_DES_CRE

				p.setInt(82, idPrima);
				p.setString(83, gol.getSexo());// SEX_ID
				p.setInt(84, gol.getBuroCredito());// BUR_USO

				p.setString(85, gol.getPregunta1());
				p.setString(86, gol.getPregunta2());
				p.setString(87, gol.getPregunta3());
				p.setString(88, gol.getPregunta4());
				p.setString(89, gol.getPregunta5());
				p.setString(90, gol.getPregunta6());
				p.setString(91, gol.getPregunta7());
				p.setString(92, gol.getPregunta8());
				p.setString(93, gol.getPregunta9());
				p.setString(94, gol.getPregunta10());

				p.setString(95, gol.getPregunta12());
				p.setString(96, gol.getPregunta12());
				p.setString(97, gol.getPregunta13());
				p.setString(98, gol.getPregunta14());
				p.setString(99, gol.getPregunta15());
				p.setString(100, gol.getPregunta16());
				p.setString(101, gol.getPregunta17());
				p.setString(102, gol.getPregunta18());
				p.setString(103, gol.getPregunta19());
				p.setString(104, gol.getPregunta20());

				p.setString(105, gol.getPregunta21());
				p.setString(106, gol.getPregunta22());
				p.setString(107, gol.getPregunta23());
				p.setString(108, gol.getPregunta24());
				p.setString(109, gol.getPagaRCuanto());
				p.setString(110, gol.getPregunta25());
				p.setString(111, gol.getGastosOtros());// CLI_GTO_OTRO
				p.setString(112, gol.getIngresoDestino());// CLI_GOL_DET_ING
				p.setString(113, gol.getActividadAdicional());// CLI_GOL_ACT_ADI

				p.setString(114, gol.getImc());// CLI_GOL_PAR_CON
				p.setString(115, gol.getImh());// CLI_GOL_PAR_HIJ
				p.setString(116, gol.getImp());// CLI_GOL_PAR_PAD
				p.setString(117, gol.getImo());// CLI_GOL_PAR_OTR

				p.setInt(118, gol.getConyuge());// CLI_GOL_APO_CON
				p.setInt(119, gol.getHijos());// CLI_GOL_APO_HIJ
				p.setInt(120, gol.getPadres());// CLI_GOL_APO_PAD
				p.setInt(121, gol.getOtros());// CLI_GOL_APO_OTR
				p.setString(122, gol.getDineroConcepto());
				p.execute();
			} else
				return -1;
		} catch (final SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, p, conn);
		}
		return Integer.parseInt(idGol);
	}

	public synchronized static void updateGol(GolBean gol) {
		PreparedStatement p = null;
		Connection conn = getConexion();
		try {
			p = conn
					.prepareStatement(updateGol(String.valueOf(gol.getIdGol())));
			// Pantalla 1
			p.setString(1, gol.getComercioIndispensable());// SERV_IND_ID
			p.setString(2, gol.getProblemaHoy());// PBM_ID
			p.setString(3, gol.getSituacionActual());// SIT_ACT_ID
			p.setString(4, gol.getSituacionPAnio());// SIT_PRX_AN_ID
			p.setString(5, gol.getPqSituacionPAnio());// CLI_GOL_SIT_POR
			p.setString(6, gol.getDeudaPreocupa());// CLI_GOL_DEU_PRE
			p.setString(7, gol.getApoyoInstitucion());// APY_ECO_ID
			p.setString(8, gol.getDineroExtra());// DIN_EXT_ID

			// Pantalla 2
			p.setString(9, gol.getGastosAlimentos());// GTO_ALM_ID
			p.setString(10, gol.getGastosPersonales());// GTO_PER_ID
			p.setString(11, gol.getGastosDeudas());// GTO_DEU_ID
			p.setString(12, gol.getGastosOtroCual());// GTO_OTR_ID

			p.setString(13, gol.getReligionFamilia());// REL_FAM_ID
			p.setString(14, gol.getReligioOtra());// CLI_GOL_REL_FAM_OTR
			p.setString(15, gol.getReligionMia());// REL_ID
			p.setString(16, gol.getReligionMiaOtra());// CLI_GOL_REL_OTR
			p.setString(17, gol.getReligionFrecuencia());// FRE_REL_ID
			p.setString(18, gol.getReligionDecision());// CLI_GOL_REL_DEC
			p.setString(19, gol.getRazoncambio());// CLI_GOL_MOT_CAS
			p.setString(20, gol.getMotivacion());// CLI_GOL_MOT_CAM
			p.setInt(21, gol.getTiempoViviendo());// CLI_GOL_RES_ACT
			p.setString(22, gol.getActividadPrincipal());// ACT_ULT_ID
			p.setString(23, gol.getNoTrabaja());// CLI_GOL_ACT_POR
			p.setString(24, gol.getTipoActividad());// TIP_EMP_ID
			p.setString(25, gol.getSector());// SRV_ID
			p.setString(26, gol.getSubsector());// OCP_ID
			p.setString(27, gol.getDescripcionOcupacion());// CLI_GOL_OCU_ACT
			p.setString(28, gol.getRol());// ROL_ID
			p.setString(29, gol.getTiempoLaborando());// CLI_GOL_EMP_ACT

			p.setString(30, gol.getEstudiaActual());// EST_ID
			p.setString(31, gol.getGradoE());// NIV_EST_ID
			p.setString(32, gol.getGradoEAnio());// CLI_GOL_EST_CLI
			p.setString(33, gol.getGradoEPapa());// NIV_EST_PAP_ID
			p.setString(34, gol.getGradoEPAnio());// CLI_GOL_EST_PAD
			p.setString(35, gol.getGradoEMama());// NIV_EST_MAM_ID
			p.setString(36, gol.getGradoEMAnio());// CLI_GOL_EST_MAD

			// Pagina 3
			p.setString(37, gol.getRespCrisis());// CLI_GOL_RES_CRI
			p.setString(38, gol.getLugarVivienda());// MOV_ID
			p.setString(39, gol.getGastoPlaneado());// PRO_ANO_GTO_ID
			p.setString(40, gol.getViveActual());// VIV_ACT_ID
			p.setString(41, gol.getPersonasDep());// CLI_GOL_NUM_DEP

			p.setString(42, gol.getIngresoMensual());// CLI_GOL_DES_ING

			p.setInt(43, Integer.parseInt((gol.getAc() == null) ? "-1" : gol
					.getAc()));// APO_CON_ID
			p.setInt(44, Integer.parseInt((gol.getAh() == null) ? "-1" : gol
					.getAh()));// APO_HIJ_ID
			p.setInt(45, Integer.parseInt((gol.getAp() == null) ? "-1" : gol
					.getAp()));// APO_PAD_ID
			p.setInt(46, Integer.parseInt((gol.getAo() == null) ? "-1" : gol
					.getAo()));// APO_OTR_ID

			p.setString(47, gol.getAlimentos());// GTO_ALM_H_ID
			p.setString(48, gol.getVestido());// GTO_VES_ID
			p.setString(49, gol.getServiciosV());// GTO_SRV_VIV_ID
			p.setString(50, gol.getLimpieza());// GTO_LIM_ID
			p.setString(51, gol.getSalud());// GTO_SLD_ID
			p.setString(52, gol.getTransporte());// GTO_TRN_ID
			p.setString(53, gol.getEducacion());// GTO_EDU_ID
			p.setString(54, gol.getDiversiones());// GTO_DIV_ID
			p.setString(55, gol.getPagoDeudas());// GTO_DEU_H_ID
			p.setString(56, gol.getRenta());// GTO_REN_H_ID
			p.setString(57, gol.getOtroGastos());// CLI_GOL_GAS_GAS
			p.setString(58, gol.getCuantogasta());// GTO_OTR_H_ID

			// pagina 4
			p.setString(59, gol.getSolicitudCredito());// PTM_ID
			p.setString(60, gol.getSolicitadoCredito());// SOL_CRE_ID
			p.setString(61, gol.getTipoCredito());// TIP_CRE_ID
			p.setString(62, gol.getCreditoAnio());// CLI_GOL_ANO_CRE
			p.setString(63, gol.getCreditoMes());// CLI_GOL_MES_CRE
			p.setString(64, gol.getTardoAnio());// CLI_GOL_PAG_ANO
			p.setString(65, gol.getTardoMes());// CLI_GOL_PAG_MES
			p.setString(66, gol.getDineroECuanto());// DIN_EXT_H_ID
			p.setString(67, gol.getDineroExtraR());// CLI_GOL_DIN_EXT
			p.setString(68, gol.getDineroFrec());// FRE_DIN_ID
			p.setString(69, gol.getPagaRenta());// PAG_RNT_ID

			p.setString(70, gol.getTarjetaC());// CLI_GOL_TAR_CRE
			p.setString(71, gol.getTotalTarjetas());// CLI_GOL_NUM_TAR
			p.setString(72, gol.getTarjetaD());// CLI_GOL_TAR_DEB
			p.setString(73, gol.getCuentaCheque());// CLI_GOL_CTA_CHE
			p.setString(74, gol.getCreditoPersonal());// CLI_GOL_CRE_PER
			p.setString(75, gol.getCreditoAuto());// CLI_GOL_CRE_AUT
			p.setString(76, gol.getCreditoHipo());// CLI_GOL_CRE_HIP
			p.setString(77, gol.getSeguroVida());// CLI_GOL_SEG_VID
			p.setString(78, gol.getSeguroMedico());// CLI_GOL_SEG_GMM
			p.setString(79, gol.getOtroCredito());// CLI_GOL_OTR_CRE
			p.setString(80, gol.getCualCredito());// CLI_GOL_DES_CRE

			p.setString(81, gol.getSexo());// SEX_ID
			p.setInt(82, gol.getBuroCredito());// BUR_USO

			p.setString(83, gol.getPregunta1());
			p.setString(84, gol.getPregunta2());
			p.setString(85, gol.getPregunta3());
			p.setString(86, gol.getPregunta4());
			p.setString(87, gol.getPregunta5());
			p.setString(88, gol.getPregunta6());
			p.setString(89, gol.getPregunta7());
			p.setString(90, gol.getPregunta8());
			p.setString(91, gol.getPregunta9());
			p.setString(92, gol.getPregunta10());

			p.setString(93, gol.getPregunta12());
			p.setString(94, gol.getPregunta12());
			p.setString(95, gol.getPregunta13());
			p.setString(96, gol.getPregunta14());
			p.setString(97, gol.getPregunta15());
			p.setString(98, gol.getPregunta16());
			p.setString(99, gol.getPregunta17());
			p.setString(100, gol.getPregunta18());
			p.setString(101, gol.getPregunta19());
			p.setString(102, gol.getPregunta20());

			p.setString(103, gol.getPregunta21());
			p.setString(104, gol.getPregunta22());
			p.setString(105, gol.getPregunta23());
			p.setString(106, gol.getPregunta24());
			p.setString(107, gol.getPagaRCuanto());
			p.setString(108, gol.getPregunta25());
			p.setString(109, gol.getGastosOtros());// CLI_GTO_OTRO
			p.setString(110, gol.getIngresoDestino());// CLI_GOL_DET_ING
			p.setString(111, gol.getActividadAdicional());// CLI_GOL_ACT_ADI

			p.setString(112, gol.getImc());// CLI_GOL_PAR_CON
			p.setString(113, gol.getImh());// CLI_GOL_PAR_HIJ
			p.setString(114, gol.getImp());// CLI_GOL_PAR_PAD
			p.setString(115, gol.getImo());// CLI_GOL_PAR_OTR

			p.setInt(116, gol.getConyuge());// CLI_GOL_APO_CON
			p.setInt(117, gol.getHijos());// CLI_GOL_APO_HIJ
			p.setInt(118, gol.getPadres());// CLI_GOL_APO_PAD
			p.setInt(119, gol.getOtros());// CLI_GOL_APO_OTR
                        p.setString(120, gol.getDineroConcepto());

                
			p.execute();
		} catch (final SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, p, conn);
		}
	}

	public static String insertGol() {
		String sql = "INSERT INTO CLI_GOL ";
		sql += "(CLI_GOL_ID, SERV_IND_ID, PBM_ID, ";// 3
		sql += "SIT_ACT_ID, SIT_PRX_AN_ID, ";// 5
		sql += "CLI_GOL_SIT_POR, CLI_GOL_DEU_PRE, APY_ECO_ID, ";// 8
		sql += "DIN_EXT_ID, GTO_ALM_ID, GTO_PER_ID, GTO_DEU_ID, GTO_OTR_ID,";// 13
		sql += "REL_FAM_ID, CLI_GOL_REL_FAM_OTR, REL_ID, ";// 9
		sql += "CLI_GOL_REL_OTR, FRE_REL_ID, CLI_GOL_REL_DEC, ";// 19
		sql += "CLI_GOL_MOT_CAS, CLI_GOL_MOT_CAM, CLI_GOL_RES_ACT, ACT_ULT_ID, CLI_GOL_ACT_POR, TIP_EMP_ID, SRV_ID, ";// 32
		sql += "OCP_ID, CLI_GOL_OCU_ACT, ROL_ID, ";// 9
		sql += "CLI_GOL_EMP_ACT, EST_ID, NIV_EST_ID, ";// 8
		sql += "CLI_GOL_EST_CLI, NIV_EST_PAP_ID, CLI_GOL_EST_PAD, ";// 6
		sql += "NIV_EST_MAM_ID, CLI_GOL_EST_MAD, CLI_GOL_RES_CRI, ";// 7
		sql += "MOV_ID, PRO_ANO_GTO_ID, VIV_ACT_ID, ";// 8
		sql += "CLI_GOL_NUM_DEP, CLI_GOL_DES_ING, APO_CON_ID, ";// 9
		sql += "APO_HIJ_ID, APO_PAD_ID, APO_OTR_ID, ";// 10
		sql += "GTO_ALM_H_ID, GTO_VES_ID, GTO_SRV_VIV_ID, ";// 11
		sql += "GTO_LIM_ID, GTO_SLD_ID, GTO_TRN_ID, ";// 12
		sql += "GTO_EDU_ID, GTO_DIV_ID, GTO_DEU_H_ID, ";// 13
		sql += "GTO_REN_H_ID, CLI_GOL_GAS_GAS, GTO_OTR_H_ID, ";// 14
		sql += "PTM_ID, SOL_CRE_ID, TIP_CRE_ID, ";// 15
		sql += "CLI_GOL_ANO_CRE, CLI_GOL_MES_CRE, CLI_GOL_PAG_ANO, ";// 16
		sql += "CLI_GOL_PAG_MES, DIN_EXT_H_ID, CLI_GOL_DIN_EXT, ";// 16
		sql += "FRE_DIN_ID, PAG_RNT_ID, CLI_GOL_TAR_CRE, ";// 16
		sql += "CLI_GOL_NUM_TAR, CLI_GOL_TAR_DEB, CLI_GOL_CTA_CHE, ";// 16
		sql += "CLI_GOL_CRE_PER, CLI_GOL_CRE_AUT, CLI_GOL_CRE_HIP, ";// 16
		sql += "CLI_GOL_SEG_VID, CLI_GOL_SEG_GMM, CLI_GOL_OTR_CRE, ";// 16
		sql += "CLI_GOL_DES_CRE, CLI_ID,SEX_ID,BUR_USO, ";
		// PREGUNTAS
		sql += "CLI_GOL_P1, CLI_GOL_P2,CLI_GOL_P3,CLI_GOL_P4, ";
		sql += "CLI_GOL_P5, CLI_GOL_P6,CLI_GOL_P7,CLI_GOL_P8, ";
		sql += "CLI_GOL_P9, CLI_GOL_P10,CLI_GOL_P11,CLI_GOL_P12, ";
		sql += "CLI_GOL_P13, CLI_GOL_P14,CLI_GOL_P15,CLI_GOL_P16, ";
		sql += "CLI_GOL_P17, CLI_GOL_P18,CLI_GOL_P19,CLI_GOL_P20, ";
		sql += "CLI_GOL_P21, CLI_GOL_P22,CLI_GOL_P23,CLI_GOL_P24, CLI_PAGA_RENTA, ";
		sql += "CLI_GOL_P25, CLI_GTO_OTRO, CLI_GOL_DET_ING, CLI_GOL_ACT_ADI, ";
		sql += "CLI_GOL_PAR_CON, CLI_GOL_PAR_HIJ, CLI_GOL_PAR_PAD, CLI_GOL_PAR_OTR, ";
		sql += "CLI_GOL_APO_CON, CLI_GOL_APO_HIJ, CLI_GOL_APO_PAD, CLI_GOL_APO_OTR, CLI_GOL_DES_ADI) ";
		sql += "VALUES(?,?,?,?,?,?,?,?,?,?,";
		sql += "?,?,?,?,?,?,?,?,?,?,";
		sql += "?,?,?,?,?,?,?,?,?,?,";
		sql += "?,?,?,?,?,?,?,?,?,?,";
		sql += "?,?,?,?,?,?,?,?,?,?,";
		sql += "?,?,?,?,?,?,?,?,?,?,";
		sql += "?,?,?,?,?,?,?,?,?,?,";
		sql += "?,?,?,?,?,?,?,?,?,?,";
		sql += "?,?,?,?,?,?,?,?,?,?,";
		sql += "?,?,?,?,?,?,?,?,?,?,";
		sql += "?,?,?,?,?,?,?,?,?,?,";
		sql += "?,?,?,?,?,?,?,?,?,?,?,?)";
		return sql;
	}

	public static String ver(String id) {
		String sql = "SELECT ";
		sql += "CLI_GOL_ID, SERV_IND_ID, PBM_ID, ";// 3
		sql += "SIT_ACT_ID, SIT_PRX_AN_ID, ";// 5
		sql += "CLI_GOL_SIT_POR, CLI_GOL_DEU_PRE, APY_ECO_ID, ";// 8
		sql += "DIN_EXT_ID, GTO_ALM_ID, GTO_PER_ID, GTO_DEU_ID, GTO_OTR_ID,";// 13
		sql += "REL_FAM_ID, CLI_GOL_REL_FAM_OTR, REL_ID, ";// 9
		sql += "CLI_GOL_REL_OTR, FRE_REL_ID, CLI_GOL_REL_DEC, ";// 19
		sql += "CLI_GOL_MOT_CAS, CLI_GOL_MOT_CAM, CLI_GOL_RES_ACT, ACT_ULT_ID, CLI_GOL_ACT_POR, TIP_EMP_ID, SRV_ID, ";// 32
		sql += "OCP_ID, CLI_GOL_OCU_ACT, ROL_ID, ";// 9
		sql += "CLI_GOL_EMP_ACT, EST_ID, NIV_EST_ID, ";// 8
		sql += "CLI_GOL_EST_CLI, NIV_EST_PAP_ID, CLI_GOL_EST_PAD, ";// 6
		sql += "NIV_EST_MAM_ID, CLI_GOL_EST_MAD, CLI_GOL_RES_CRI, ";// 7
		sql += "MOV_ID, PRO_ANO_GTO_ID, VIV_ACT_ID, ";// 8
		sql += "CLI_GOL_NUM_DEP, CLI_GOL_DES_ING, APO_CON_ID, ";// 9
		sql += "APO_HIJ_ID, APO_PAD_ID, APO_OTR_ID, ";// 10
		sql += "GTO_ALM_H_ID, GTO_VES_ID, GTO_SRV_VIV_ID, ";// 11
		sql += "GTO_LIM_ID, GTO_SLD_ID, GTO_TRN_ID, ";// 12
		sql += "GTO_EDU_ID, GTO_DIV_ID, GTO_DEU_H_ID, ";// 13
		sql += "GTO_REN_H_ID, CLI_GOL_GAS_GAS, GTO_OTR_H_ID, ";// 14
		sql += "PTM_ID, SOL_CRE_ID, TIP_CRE_ID, ";// 15
		sql += "CLI_GOL_ANO_CRE, CLI_GOL_MES_CRE, CLI_GOL_PAG_ANO, ";// 16
		sql += "CLI_GOL_PAG_MES, DIN_EXT_H_ID, CLI_GOL_DIN_EXT, ";// 16
		sql += "FRE_DIN_ID, PAG_RNT_ID, CLI_GOL_TAR_CRE, ";// 16
		sql += "CLI_GOL_NUM_TAR, CLI_GOL_TAR_DEB, CLI_GOL_CTA_CHE, ";// 16
		sql += "CLI_GOL_CRE_PER, CLI_GOL_CRE_AUT, CLI_GOL_CRE_HIP, ";// 16
		sql += "CLI_GOL_SEG_VID, CLI_GOL_SEG_GMM, CLI_GOL_OTR_CRE, ";// 16
		sql += "CLI_GOL_DES_CRE, CLI_ID,SEX_ID,BUR_USO, ";
		sql += "CLI_GOL_P1, CLI_GOL_P2,CLI_GOL_P3,CLI_GOL_P4, ";
		sql += "CLI_GOL_P5, CLI_GOL_P6,CLI_GOL_P7,CLI_GOL_P8, ";
		sql += "CLI_GOL_P9, CLI_GOL_P10,CLI_GOL_P11,CLI_GOL_P12, ";
		sql += "CLI_GOL_P13, CLI_GOL_P14,CLI_GOL_P15,CLI_GOL_P16, ";
		sql += "CLI_GOL_P17, CLI_GOL_P18,CLI_GOL_P19,CLI_GOL_P20, ";
		sql += "CLI_GOL_P21, CLI_GOL_P22,CLI_GOL_P23,CLI_GOL_P24,  ";
		sql += "CLI_GOL_P25, CLI_PAGA_RENTA, CLI_GTO_OTRO, CLI_GOL_DET_ING, CLI_GOL_ACT_ADI, ";
		sql += "CLI_GOL_PAR_CON, CLI_GOL_PAR_HIJ, CLI_GOL_PAR_PAD, CLI_GOL_PAR_OTR, ";
		sql += "CLI_GOL_APO_CON, CLI_GOL_APO_HIJ, CLI_GOL_APO_PAD, CLI_GOL_APO_OTR, CLI_GOL_DES_ADI ";
		sql += "FROM CLI_GOL WHERE CLI_GOL_ID=" + id;

		return sql;
	}

	public static String updateGol(String id) {
		String sql = "UPDATE CLI_GOL SET ";
		sql += "SERV_IND_ID=?, PBM_ID=?, ";// 3
		sql += "SIT_ACT_ID=?, SIT_PRX_AN_ID=?, ";// 5
		sql += "CLI_GOL_SIT_POR=?, CLI_GOL_DEU_PRE=?, APY_ECO_ID=?, ";// 8
		sql += "DIN_EXT_ID=?, GTO_ALM_ID=?, GTO_PER_ID=?, GTO_DEU_ID=?, GTO_OTR_ID=?,";// 13
		sql += "REL_FAM_ID=?, CLI_GOL_REL_FAM_OTR=?, REL_ID=?, ";// 9
		sql += "CLI_GOL_REL_OTR=?, FRE_REL_ID=?, CLI_GOL_REL_DEC=?, ";// 19
		sql += "CLI_GOL_MOT_CAS=?, CLI_GOL_MOT_CAM=?, CLI_GOL_RES_ACT=?, ACT_ULT_ID=?, CLI_GOL_ACT_POR=?, TIP_EMP_ID=?, SRV_ID=?, ";// 32
		sql += "OCP_ID=?, CLI_GOL_OCU_ACT=?, ROL_ID=?, ";// 9
		sql += "CLI_GOL_EMP_ACT=?, EST_ID=?, NIV_EST_ID=?, ";// 8
		sql += "CLI_GOL_EST_CLI=?, NIV_EST_PAP_ID=?, CLI_GOL_EST_PAD=?, ";// 6
		sql += "NIV_EST_MAM_ID=?, CLI_GOL_EST_MAD=?, CLI_GOL_RES_CRI=?, ";// 7
		sql += "MOV_ID=?, PRO_ANO_GTO_ID=?, VIV_ACT_ID=?, ";// 8
		sql += "CLI_GOL_NUM_DEP=?, CLI_GOL_DES_ING=?, APO_CON_ID=?, ";// 9
		sql += "APO_HIJ_ID=?, APO_PAD_ID=?, APO_OTR_ID=?, ";// 10
		sql += "GTO_ALM_H_ID=?, GTO_VES_ID=?, GTO_SRV_VIV_ID=?, ";// 11
		sql += "GTO_LIM_ID=?, GTO_SLD_ID=?, GTO_TRN_ID=?, ";// 12
		sql += "GTO_EDU_ID=?, GTO_DIV_ID=?, GTO_DEU_H_ID=?, ";// 13
		sql += "GTO_REN_H_ID=?, CLI_GOL_GAS_GAS=?, GTO_OTR_H_ID=?, ";// 14
		sql += "PTM_ID=?, SOL_CRE_ID=?, TIP_CRE_ID=?, ";// 15
		sql += "CLI_GOL_ANO_CRE=?, CLI_GOL_MES_CRE=?, CLI_GOL_PAG_ANO=?, ";// 16
		sql += "CLI_GOL_PAG_MES=?, DIN_EXT_H_ID=?, CLI_GOL_DIN_EXT=?, ";// 16
		sql += "FRE_DIN_ID=?, PAG_RNT_ID=?, CLI_GOL_TAR_CRE=?, ";// 16
		sql += "CLI_GOL_NUM_TAR=?, CLI_GOL_TAR_DEB=?, CLI_GOL_CTA_CHE=?, ";// 16
		sql += "CLI_GOL_CRE_PER=?, CLI_GOL_CRE_AUT=?, CLI_GOL_CRE_HIP=?, ";// 16
		sql += "CLI_GOL_SEG_VID=?, CLI_GOL_SEG_GMM=?, CLI_GOL_OTR_CRE=?, ";// 16
		sql += "CLI_GOL_DES_CRE=?, SEX_ID=?,BUR_USO=?, ";
		// PREGUNTAS
		sql += "CLI_GOL_P1=?, CLI_GOL_P2=?,CLI_GOL_P3=?,CLI_GOL_P4=?, ";
		sql += "CLI_GOL_P5=?, CLI_GOL_P6=?,CLI_GOL_P7=?,CLI_GOL_P8=?, ";
		sql += "CLI_GOL_P9=?, CLI_GOL_P10=?,CLI_GOL_P11=?,CLI_GOL_P12=?, ";
		sql += "CLI_GOL_P13=?, CLI_GOL_P14=?,CLI_GOL_P15=?,CLI_GOL_P16=?, ";
		sql += "CLI_GOL_P17=?, CLI_GOL_P18=?,CLI_GOL_P19=?,CLI_GOL_P20=?, ";
		sql += "CLI_GOL_P21=?, CLI_GOL_P22=?,CLI_GOL_P23=?,CLI_GOL_P24=?, CLI_PAGA_RENTA=?, ";
		sql += "CLI_GOL_P25=?, CLI_GTO_OTRO=?, CLI_GOL_DET_ING=?, CLI_GOL_ACT_ADI=?, ";

		sql += "CLI_GOL_PAR_CON=?, CLI_GOL_PAR_HIJ=?, CLI_GOL_PAR_PAD=?, CLI_GOL_PAR_OTR=?, ";
		sql += "CLI_GOL_APO_CON=?, CLI_GOL_APO_HIJ=?, CLI_GOL_APO_PAD=?, CLI_GOL_APO_OTR=?, CLI_GOL_DES_ADI=? WHERE CLI_GOL_ID= "
				+ id;
		return sql;
	}

	/**
	 * 
	 * @param gol
	 * @return
	 */
	public synchronized static int insertaPrima(PrimaBean gol) {
		PreparedStatement pstmt = null;
		String idPrima = "";
		Connection conn = getConexion();
		try {
			final long id = ConexionDS.getMaxId(conn, "CLI", "CLI_ID");
			if (id >= 0) {
				idPrima = String.valueOf((id + 1));
				pstmt = conn.prepareStatement(insertCli());
				pstmt.setLong(1, id + 1);
				pstmt.setString(2, gol.getApellidoPaterno().toUpperCase());
				pstmt.setString(3, gol.getApellidoMaterno().toUpperCase());
				pstmt.setString(4, gol.getNombre().toUpperCase());
				pstmt.setDate(5, DateFormatter.getFechaSQL(((gol.getDia()
						.length() == 1) ? "0" + gol.getDia() : gol.getDia())
						+ "/"
						+ ((gol.getMes().length() == 1) ? "0" + gol.getMes()
								: gol.getMes()) + "/" + gol.getAnio(),
						DateFormatter.FORMATO_DDMMYYYY));
				pstmt.setString(6, gol.getCalle().toUpperCase());
				pstmt.setString(7, gol.getNoExterior());
				pstmt.setString(8, gol.getNoInterior());
				pstmt.setString(9, gol.getColonia().toUpperCase());
				pstmt.setString(10, gol.getCp());
				pstmt.setInt(11, 4);
				pstmt.setString(12, gol.getEdad());
				pstmt.setString(13, "");
				pstmt.setString(14, "");
				pstmt.setString(15, gol.getEdoCivil());
				GenerateRfc rfc = new GenerateRfc();
				String rfcP = rfc.generaRFC(gol.getNombre(), gol
						.getApellidoPaterno(), gol.getApellidoMaterno(), gol
						.getDia()
						+ "/" + gol.getMes() + "/" + gol.getAnio() + "");
				pstmt.setString(16, rfcP);

				pstmt.setString(17, "");
				pstmt.setString(18, gol.getIngresoMensual());
				pstmt.setString(19, gol.getTipoActividad());
				pstmt.setString(20, gol.getSector());
				pstmt.setString(21, gol.getSubSector());
				pstmt.setString(22, gol.getDescripcionOcupacion());
				pstmt.setString(23, gol.getRol());
				pstmt.setString(24, "");
				pstmt.setString(25, "");
				pstmt.setString(26, gol.getValorVivienda());
				pstmt.setString(27, gol.getMensualidad());
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

	/**
	 * 
	 * @param rfc
	 * @param persona
	 * @param tipo
	 * @return
	 */
	public static String getListaGol(String rfc, String persona, int tipo) {
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		String sql = "";
		try {
			if (tipo == 0)
				sql = "SELECT A.CLI_ID, CLI_GOL_ID, CLI_NOM, CLI_APE_PAT, CLI_APE_MAT FROM CLI A, CLI_GOL B "
						+ "WHERE A.CLI_ID=B.CLI_ID ORDER BY 1";
			else {
				sql = "SELECT A.CLI_ID, CLI_GOL_ID, CLI_NOM, CLI_APE_PAT, CLI_APE_MAT FROM CLI A, CLI_GOL B WHERE "
						+ "A.CLI_ID=B.CLI_ID AND ";
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
								+ resultado[i][3] + " " + resultado[i][4]
								+ "' value=\"" + resultado[i][0] + "|"
								+ resultado[i][1] + "\">" + resultado[i][3]
								+ " " + resultado[i][4] + " " + resultado[i][2]
								+ "</option>");
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

	/**
	 * 
	 * @param gol
	 * @return
	 */
	public synchronized static int insertaBuro(GolBean gol, int idPrima) {
		PreparedStatement pstmt = null;
		String idBuro = "";
		Connection conn = getConexion();
		try {
			final long id = ConexionDS.getMaxId(conn, "CLI_BUR", "CLI_BUR_ID");
			if (id >= 0) {
				idBuro = String.valueOf((id + 1));
				pstmt = conn.prepareStatement(insertBuro());
				pstmt.setLong(1, id + 1);
				pstmt.setInt(2, idPrima);
				pstmt.setInt(3, gol.getAnt());
				pstmt.setInt(4, gol.getAct());
				pstmt.setInt(5, gol.getHist());
				pstmt.setInt(6, gol.getUso());
				pstmt.setInt(7, gol.getPago());

				pstmt.setString(8, gol.getImporteMop());// CLI_BUR_IMP_MOP
				pstmt.setString(9, gol.getTipoCreditoMop());// CLI_BUR_TPO_MOP
				pstmt.setString(10, gol.getPagoRealizar());// CLI_BUR_PAG_MOP

				pstmt.setString(11, gol.getCuentasA());// CLI_BUR_NUM_ABI
				pstmt.setString(12, gol.getMaximaA());// CLI_BUR_MAX_ABI
				pstmt.setString(13, gol.getMontoA());// CLI_BUR_MON_ABI
				pstmt.setString(14, gol.getLimiteA());// CLI_BUR_LIM_ABI
				pstmt.setString(15, gol.getSaldoA());// CLI_BUR_SAL_ABI

				pstmt.setString(16, gol.getCuentasC());// CLI_BUR_NUM_CER
				pstmt.setString(17, gol.getMaximaC());// CLI_BUR_MAX_CER
				pstmt.setString(18, gol.getMontoC());// CLI_BUR_MON_CER
				pstmt.setString(19, gol.getLimiteC());// CLI_BUR_LIM_CER
				pstmt.setString(20, gol.getSaldoC());// CLI_BUR_SAL_CER
                                pstmt.setInt(21,gol.getMop()); //CLI_BUR_MOP
				pstmt.execute();
			} else
				return -1;
		} catch (final SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, conn);
		}
		return Integer.parseInt(idBuro);
	}

	/**
	 * 
	 * @param gol
	 * @return
	 */
	public synchronized static void updateBuro(GolBean gol) {
		PreparedStatement pstmt = null;
		Connection conn = getConexion();
		try {
			pstmt = conn.prepareStatement(updateBuro(String.valueOf(gol
					.getIdPrima())));
			pstmt.setInt(1, gol.getAnt());
			pstmt.setInt(2, gol.getAct());
			pstmt.setInt(3, gol.getHist());
			pstmt.setInt(4, gol.getUso());
			pstmt.setInt(5, gol.getPago());

			pstmt.setString(6, gol.getImporteMop());// CLI_BUR_IMP_MOP
			pstmt.setString(7, gol.getTipoCreditoMop());// CLI_BUR_TPO_MOP
			pstmt.setString(8, gol.getPagoRealizar());// CLI_BUR_PAG_MOP

			pstmt.setString(9, gol.getCuentasA());// CLI_BUR_NUM_ABI
			pstmt.setString(10, gol.getMaximaA());// CLI_BUR_MAX_ABI
			pstmt.setString(11, gol.getMontoA());// CLI_BUR_MON_ABI
			pstmt.setString(12, gol.getLimiteA());// CLI_BUR_LIM_ABI
			pstmt.setString(13, gol.getSaldoA());// CLI_BUR_SAL_ABI

			pstmt.setString(14, gol.getCuentasC());// CLI_BUR_NUM_CER
			pstmt.setString(15, gol.getMaximaC());// CLI_BUR_MAX_CER
			pstmt.setString(16, gol.getMontoC());// CLI_BUR_MON_CER
			pstmt.setString(17, gol.getLimiteC());// CLI_BUR_LIM_CER
			pstmt.setString(18, gol.getSaldoC());// CLI_BUR_SAL_CER
                        pstmt.setInt(19, gol.getMop()); //CLI_BUR_MOP
		pstmt.execute();

		} catch (final SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, conn);
		}
	}

	public static String insertBuro() {
		String sql = "INSERT INTO CLI_BUR ";
		sql += "(CLI_BUR_ID, CLI_ID, BUR_ANT_ID, ";// 4
		sql += "BUR_ACT_ID, BUR_HIS_ID, ";// 6
		sql += "BUR_USO_ID, BURO_PAG_ID, CLI_BUR_IMP_MOP, ";// 9
		sql += "CLI_BUR_TPO_MOP, CLI_BUR_PAG_MOP, CLI_BUR_NUM_ABI, CLI_BUR_MAX_ABI, CLI_BUR_MON_ABI, CLI_BUR_LIM_ABI, ";
		sql += "CLI_BUR_SAL_ABI, CLI_BUR_NUM_CER, CLI_BUR_MAX_CER, ";
		sql += "CLI_BUR_MON_CER, CLI_BUR_LIM_CER, CLI_BUR_SAL_CER, CLI_BUR_MOP) ";
		sql += "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return sql;
	}

	public static String updateBuro(String id) {
		String sql = "UPDATE CLI_BUR SET ";
		sql += "BUR_ANT_ID=?, ";// 4
		sql += "BUR_ACT_ID=?, BUR_HIS_ID=?, ";// 6
		sql += "BUR_USO_ID=?, BURO_PAG_ID=?, CLI_BUR_IMP_MOP=?, ";// 9
		sql += "CLI_BUR_TPO_MOP=?, CLI_BUR_PAG_MOP=?, CLI_BUR_NUM_ABI=?, CLI_BUR_MAX_ABI=?, CLI_BUR_MON_ABI=?, CLI_BUR_LIM_ABI=?, ";
		sql += "CLI_BUR_SAL_ABI=?, CLI_BUR_NUM_CER=?, CLI_BUR_MAX_CER=?, ";
		sql += "CLI_BUR_MON_CER=?, CLI_BUR_LIM_CER=?, CLI_BUR_SAL_CER=?, CLI_BUR_MOP=? WHERE CLI_ID="
				+ id;
		return sql;
	}

	public static String getBuro(int idPrima) {
		String sql = "SELECT ";
		sql += "CLI_BUR_ID, CLI_ID, BUR_ANT_ID, ";// 4
		sql += "BUR_ACT_ID, BUR_HIS_ID, ";// 6
		sql += "BUR_USO_ID, BURO_PAG_ID, CLI_BUR_IMP_MOP, ";// 9
		sql += "CLI_BUR_TPO_MOP, CLI_BUR_PAG_MOP, CLI_BUR_NUM_ABI, CLI_BUR_MAX_ABI, CLI_BUR_MON_ABI, CLI_BUR_LIM_ABI, ";
		sql += "CLI_BUR_SAL_ABI, CLI_BUR_NUM_CER, CLI_BUR_MAX_CER, ";
		sql += "CLI_BUR_MON_CER, CLI_BUR_LIM_CER, CLI_BUR_SAL_CER, CLI_BUR_MOP FROM CLI_BUR WHERE CLI_ID="
				+ idPrima;
		return sql;
	}

	public static String getExisteBuro(int idPrima) {
		String sql = "SELECT COUNT(*) FROM CLI_BUR WHERE CLI_ID=" + idPrima;
		return sql;
	}

	public static GolBean getVer(String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		GolBean gol = new GolBean();
		try {
			ps = con.prepareStatement(ver(id));
			rs = ps.executeQuery();
			while (rs.next()) {
				gol.setIdGol(rs.getInt("CLI_GOL_ID"));
				// Pantalla 1
				gol.setComercioIndispensable(rs.getString("SERV_IND_ID"));
				gol.setProblemaHoy(rs.getString("PBM_ID"));
				gol.setSituacionActual(rs.getString("SIT_ACT_ID"));// 
				gol.setSituacionPAnio(rs.getString("SIT_PRX_AN_ID"));// 
				gol.setPqSituacionPAnio(rs.getString("CLI_GOL_SIT_POR"));// 
				gol.setDeudaPreocupa(rs.getString("CLI_GOL_DEU_PRE"));// 
				gol.setApoyoInstitucion(rs.getString("APY_ECO_ID"));// 
				gol.setDineroExtra(rs.getString("DIN_EXT_ID"));// 

				gol.setReligionFamilia(rs.getString("REL_FAM_ID"));// 
				gol.setReligioOtra(rs.getString("CLI_GOL_REL_FAM_OTR"));// 
				gol.setReligionMia(rs.getString("REL_ID"));// 
				gol.setReligionMiaOtra(rs.getString("CLI_GOL_REL_OTR"));// 
				gol.setReligionFrecuencia(rs.getString("FRE_REL_ID"));// 
				gol.setReligionDecision(rs.getString("CLI_GOL_REL_DEC"));// 
				gol.setRazoncambio(rs.getString("CLI_GOL_MOT_CAS"));// 
				gol.setMotivacion(rs.getString("CLI_GOL_MOT_CAM"));// 
				gol.setTiempoViviendo(rs.getInt("CLI_GOL_RES_ACT"));// 
				gol.setActividadPrincipal(rs.getString("ACT_ULT_ID"));// 
				gol.setNoTrabaja(rs.getString("CLI_GOL_ACT_POR"));// 
				gol.setTipoActividad(rs.getString("TIP_EMP_ID"));// 
				gol.setSector(rs.getString("SRV_ID"));// 
				gol.setSubsector(rs.getString("OCP_ID"));// 
				gol.setDescripcionOcupacion(rs.getString("CLI_GOL_OCU_ACT"));// 
				gol.setRol(rs.getString("ROL_ID"));// 
				gol.setTiempoLaborando(rs.getString("CLI_GOL_EMP_ACT"));// 

				gol.setEstudiaActual(rs.getString("EST_ID"));// 
				gol.setGradoE(rs.getString("NIV_EST_ID"));// 
				gol.setGradoEAnio(rs.getString("CLI_GOL_EST_CLI"));// 
				gol.setGradoEPapa(rs.getString("NIV_EST_PAP_ID"));// 
				gol.setGradoEPAnio(rs.getString("CLI_GOL_EST_PAD"));// 
				gol.setGradoEMama(rs.getString("NIV_EST_MAM_ID"));// 
				gol.setGradoEMAnio(rs.getString("CLI_GOL_EST_MAD"));// 

				// Pagina 3
				gol.setRespCrisis(rs.getString("CLI_GOL_RES_CRI"));// 
				gol.setLugarVivienda(rs.getString("MOV_ID"));// 
				gol.setGastoPlaneado(rs.getString("PRO_ANO_GTO_ID"));// 
				gol.setViveActual(rs.getString("VIV_ACT_ID"));//
				gol.setPersonasDep(rs.getString("CLI_GOL_NUM_DEP"));// 
				gol.setIngresoMensual(rs.getString("CLI_GOL_DES_ING"));// 

				gol.setAc(rs.getString("APO_CON_ID"));
				gol.setAh(rs.getString("APO_HIJ_ID"));
				gol.setAp(rs.getString("APO_PAD_ID"));
				gol.setAo(rs.getString("APO_OTR_ID"));

				gol.setAlimentos(rs.getString("GTO_ALM_H_ID"));// 
				gol.setVestido(rs.getString("GTO_VES_ID"));// 
				gol.setServiciosV(rs.getString("GTO_SRV_VIV_ID"));// 
				gol.setLimpieza(rs.getString("GTO_LIM_ID"));// 
				gol.setSalud(rs.getString("GTO_SLD_ID"));// 
				gol.setTransporte(rs.getString("GTO_TRN_ID"));// 
				gol.setEducacion(rs.getString("GTO_EDU_ID"));// 
				gol.setDiversiones(rs.getString("GTO_DIV_ID"));// 
				gol.setPagoDeudas(rs.getString("GTO_DEU_H_ID"));// 
				gol.setRenta(rs.getString("GTO_REN_H_ID"));// 
				gol.setOtroGastos(rs.getString("CLI_GOL_GAS_GAS"));// 
				gol.setCuantogasta(rs.getString("GTO_OTR_H_ID"));// 

				// pagina 4
				gol.setDineroExtraR(rs.getString("CLI_GOL_DIN_EXT"));// 
				gol.setDineroECuanto(rs.getString("DIN_EXT_H_ID"));// 
				gol.setDineroFrec(rs.getString("FRE_DIN_ID"));// 
				gol.setPagaRenta(rs.getString("PAG_RNT_ID"));//
                                gol.setDineroConcepto(rs.getString("CLI_GOL_DES_ADI"));
				gol.setSolicitudCredito(rs.getString("PTM_ID"));// 
				gol.setSolicitadoCredito(rs.getString("SOL_CRE_ID"));// 
				gol.setTipoCredito(rs.getString("TIP_CRE_ID"));// 

				gol.setCreditoAnio(rs.getString("CLI_GOL_ANO_CRE"));// 
				gol.setCreditoMes(rs.getString("CLI_GOL_MES_CRE"));//

				gol.setTardoAnio(rs.getString("CLI_GOL_PAG_ANO"));// 
				gol.setTardoMes(rs.getString("CLI_GOL_PAG_MES"));// 

				gol.setTarjetaC(rs.getString("CLI_GOL_TAR_CRE"));// 
				gol.setTarjetaD(rs.getString("CLI_GOL_TAR_DEB"));// 
				gol.setCuentaCheque(rs.getString("CLI_GOL_CTA_CHE"));// 
				gol.setCreditoPersonal(rs.getString("CLI_GOL_CRE_PER"));// 
				gol.setCreditoAuto(rs.getString("CLI_GOL_CRE_AUT"));// 
				gol.setCreditoHipo(rs.getString("CLI_GOL_CRE_HIP"));// 
				gol.setSeguroVida(rs.getString("CLI_GOL_SEG_VID"));// 
				gol.setSeguroMedico(rs.getString("CLI_GOL_SEG_GMM"));// 
				gol.setOtroCredito(rs.getString("CLI_GOL_OTR_CRE"));// 
				gol.setCualCredito(rs.getString("CLI_GOL_DES_CRE"));// 
				gol.setTotalTarjetas(rs.getString("CLI_GOL_NUM_TAR"));// 
				gol.setSexo(rs.getString("SEX_ID"));// 
				gol.setBuroCredito(rs.getInt("BUR_USO"));// 

				gol.setPregunta1(rs.getString("CLI_GOL_P1"));
				gol.setPregunta2(rs.getString("CLI_GOL_P2"));
				gol.setPregunta3(rs.getString("CLI_GOL_P3"));
				gol.setPregunta4(rs.getString("CLI_GOL_P4"));
				gol.setPregunta5(rs.getString("CLI_GOL_P5"));
				gol.setPregunta6(rs.getString("CLI_GOL_P6"));
				gol.setPregunta7(rs.getString("CLI_GOL_P7"));
				gol.setPregunta8(rs.getString("CLI_GOL_P8"));
				gol.setPregunta9(rs.getString("CLI_GOL_P9"));
				gol.setPregunta10(rs.getString("CLI_GOL_P10"));

				gol.setPregunta11(rs.getString("CLI_GOL_P11"));
				gol.setPregunta12(rs.getString("CLI_GOL_P12"));
				gol.setPregunta13(rs.getString("CLI_GOL_P13"));
				gol.setPregunta14(rs.getString("CLI_GOL_P14"));
				gol.setPregunta15(rs.getString("CLI_GOL_P15"));
				gol.setPregunta16(rs.getString("CLI_GOL_P16"));
				gol.setPregunta17(rs.getString("CLI_GOL_P17"));
				gol.setPregunta18(rs.getString("CLI_GOL_P18"));
				gol.setPregunta19(rs.getString("CLI_GOL_P19"));
				gol.setPregunta20(rs.getString("CLI_GOL_P20"));

				gol.setPregunta21(rs.getString("CLI_GOL_P21"));
				gol.setPregunta22(rs.getString("CLI_GOL_P22"));
				gol.setPregunta23(rs.getString("CLI_GOL_P23"));
				gol.setPregunta24(rs.getString("CLI_GOL_P24"));
				gol.setPregunta25(rs.getString("CLI_GOL_P25"));

				gol.setPagaRCuanto(rs.getString("CLI_PAGA_RENTA"));

				gol.setGastosAlimentos(rs.getString("GTO_ALM_ID"));
				gol.setGastosPersonales(rs.getString("GTO_PER_ID"));
				gol.setGastosDeudas(rs.getString("GTO_DEU_ID"));
				gol.setGastosOtroCual(rs.getString("GTO_OTR_ID"));
				gol.setGastosOtros(rs.getString("CLI_GTO_OTRO"));

				gol.setIngresoDestino(rs.getString("CLI_GOL_DET_ING"));
				gol.setActividadAdicional(rs.getString("CLI_GOL_ACT_ADI"));

				gol.setImc(rs.getString("CLI_GOL_PAR_CON"));
				gol.setImh(rs.getString("CLI_GOL_PAR_HIJ"));
				gol.setImp(rs.getString("CLI_GOL_PAR_PAD"));
				gol.setImo(rs.getString("CLI_GOL_PAR_OTR"));

				gol.setConyuge(rs.getInt("CLI_GOL_APO_CON"));
				gol.setHijos(rs.getInt("CLI_GOL_APO_HIJ"));
				gol.setPadres(rs.getInt("CLI_GOL_APO_PAD"));
				gol.setOtros(rs.getInt("CLI_GOL_APO_OTR"));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, con);
		}
		return gol;
	}

	/**
	 * 
	 * @param gol
	 * @param idPrima
	 * @return
	 */
	public static GolBean getBuro(GolBean gol, int idPrima) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		try {
			ps = con.prepareStatement(getBuro(idPrima));
			rs = ps.executeQuery();
			while (rs.next()) {
				gol.setAnt(rs.getInt("BUR_ANT_ID"));
				gol.setAct(rs.getInt("BUR_ACT_ID"));
				gol.setHist(rs.getInt("BUR_HIS_ID"));
				gol.setUso(rs.getInt("BUR_USO_ID"));
				gol.setPago(rs.getInt("BURO_PAG_ID"));
				gol.setImporteMop(rs.getString("CLI_BUR_IMP_MOP"));
				gol.setTipoCreditoMop(rs.getString("CLI_BUR_TPO_MOP"));
				gol.setPagoRealizar(rs.getString("CLI_BUR_PAG_MOP"));
				gol.setCuentasA(rs.getString("CLI_BUR_NUM_ABI"));
				gol.setMaximaA(rs.getString("CLI_BUR_MAX_ABI"));
				gol.setMontoA(rs.getString("CLI_BUR_MON_ABI"));
				gol.setLimiteA(rs.getString("CLI_BUR_LIM_ABI"));
				gol.setSaldoA(rs.getString("CLI_BUR_SAL_ABI"));
				gol.setCuentasC(rs.getString("CLI_BUR_NUM_CER"));
				gol.setMaximaC(rs.getString("CLI_BUR_MAX_CER"));
				gol.setMontoC(rs.getString("CLI_BUR_MON_CER"));
				gol.setLimiteC(rs.getString("CLI_BUR_LIM_CER"));
				gol.setSaldoC(rs.getString("CLI_BUR_SAL_CER"));
                                gol.setMop(rs.getInt("CLI_BUR_MOP"));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, con);
		}
		return gol;
	}

	public static String getGastosAlimentos(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT GTO_ALM_ID, GTO_ALM_DES FROM GTO_ALM WHERE CAL_ID='5'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	/**
	 * 
	 * @param idPrima
	 * @return
	 */
	public static boolean getExisteBuroUI(int idPrima) {
		Connection conn = getConexion();
		boolean bExiste = false;
		try {
			String[][] resultado = ConexionDS.ejecutarSQL(
					getExisteBuro(idPrima), conn);
			if (resultado != null && resultado.length > 0)
				bExiste = ("1".equals(resultado[0][0])) ? true : false;
			else
				bExiste = false;
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return false;
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return bExiste;
	}

	public static String getGastosPersonales(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT GTO_PER_ID, GTO_PER_DES FROM GTO_PER WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getGastosDeuda(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT GTO_DEU_ID, GTO_DEU_DES FROM GTO_DEU WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

	public static String getGastosOtros(String id) {
		if (id == null)
			id = "";
		StringBuffer html = new StringBuffer();
		Connection conn = getConexion();
		try {
			final String sql = "SELECT GTO_OTR_ID, GTO_OTR_DES FROM GTO_OTR WHERE CAL_ID='2'";
			String[][] resultado = ConexionDS.ejecutarSQL(sql, conn);
			if (resultado != null && resultado.length > 0) {
				for (int i = 0; i < resultado.length; i++)
					html.append("<option title='" + resultado[i][1]
							+ "' value=\"" + resultado[i][0] + "\" "
							+ ((id.equals(resultado[i][0])) ? "selected" : "")
							+ ">" + resultado[i][1] + "</option>");
			} else
				return "";
		} catch (final SQLException sqle) {
			sqle.printStackTrace();
			return "";
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return html.toString();
	}

        public static void main(String[] args) {

            GolSql sql = new GolSql();
            //sql.getEdoCivil("1");
            GolSql.getEdoCivil("12");
    }
}
