package cl.awake.psegurito.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccidentesPorMes {
	
	@Id
	private int id; 
	private String nombre; 
	private String accidentes;
	
	public AccidentesPorMes() {
		
	}
	
	public AccidentesPorMes(int id, String nombre, String accidentes) {
		this.id = id;
		this.nombre = nombre;
		this.accidentes = accidentes;
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
	public String getAccidentes() {
		return accidentes;
	}
	public void setAccidentes(String accidentes) {
		this.accidentes = accidentes;
	}

	@Override
	public String toString() {
		return "AccidentesPorMes [id=" + id + ", nombre=" + nombre + ", accidentes=" + accidentes + "]";
	} 
	
	

}
