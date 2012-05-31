package com.urbi.utilerias.dao;

import java.util.List;

public interface UsuariosDao {

	/**
	 * M�todo que va a mostrar todos los registros del catalogo
	 * 
	 * @return
	 */
	public List<Usuarios> mostrarRegistros(boolean supervisor);

	/**
	 * Metodo que mostrara la lista de los registros por busquedas
	 * 
	 * @param tipoCriterio
	 * @param criterio
	 * @return
	 */
	public List<Usuarios> busquedaRegistros(int tipoCriterio, String criterio);

	/**
	 * Metodo para mostrar un registro especifico de un catalogo
	 * 
	 * @param idRegistro
	 * @return
	 */
	public Usuarios getRegistroConsulta(int idRegistro);

	/**
	 * Metodo para insertar un registro de un catalogo
	 * 
	 * @return
	 */
	public int insertaRegistro(Usuarios usu);

	/**
	 * Metodo para actualizar un registro de un catalogo
	 * 
	 * @param idRegistro
	 * @return
	 */
	public void actualizaRegistro(Usuarios usu);

	/**
	 * Metodo para eliminar registros
	 * 
	 * @param idRegistro
	 */
	public void eliminarRegistro(String id);
}
