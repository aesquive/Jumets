package com.urbi.utilerias.dao;

import java.io.Serializable;

/**
 * 
 * @author Rodrigo Soto Chavarria
 * @mail rodrigo.soto.ch@gmail.com
 */
public class Usuarios implements Serializable {

	private static final long serialVersionUID = -857939465567244557L;
	private String id;
	private String clave;
	private String nombre;
	private String password;
	private String perfil;
	private boolean administrador;
	private boolean supervisor;
	private boolean vendedor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public boolean isSupervisor() {
		return supervisor;
	}

	public void setSupervisor(boolean supervisor) {
		this.supervisor = supervisor;
	}

	public boolean isVendedor() {
		return vendedor;
	}

	public void setVendedor(boolean vendedor) {
		this.vendedor = vendedor;
	}
}
