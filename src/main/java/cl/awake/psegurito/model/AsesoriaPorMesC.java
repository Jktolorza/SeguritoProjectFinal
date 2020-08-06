package cl.awake.psegurito.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AsesoriaPorMesC {
	
	@Id
	private int id;
	private String nombre;
	private int asesorias;
	
	public AsesoriaPorMesC() {
		super();
	}

	public AsesoriaPorMesC(int id, String nombre, int asesorias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.asesorias = asesorias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAsesorias() {
		return asesorias;
	}

	public void setAsesorias(int asesorias) {
		this.asesorias = asesorias;
	}

	@Override
	public String toString() {
		return "AsesoriaPorMesC [id=" + id + ", nombre=" + nombre + ", asesorias=" + asesorias + "]";
	}
	
}
