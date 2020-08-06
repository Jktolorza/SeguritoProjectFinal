package cl.awake.psegurito.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CapacitacionesPorMesP {
	
	@Id
	private int id; 
	private String nombre; 
	private int capacitaciones;
	
	public CapacitacionesPorMesP() {
		
	}
	
	public CapacitacionesPorMesP(int id, String nombre, int capacitaciones) {
		this.id = id;
		this.nombre = nombre;
		this.capacitaciones = capacitaciones;
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

	public int getCapacitaciones() {
		return capacitaciones;
	}

	public void setCapacitaciones(int capacitaciones) {
		this.capacitaciones = capacitaciones;
	}

	@Override
	public String toString() {
		return "CapacitacionesPorMesP [id=" + id + ", nombre=" + nombre + ", capacitaciones=" + capacitaciones + "]";
	} 

}
