package cl.awake.psegurito.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ActividadMejoraPorMesP {

	
	@Id
	private int id;
	private String nombre;
	private int actividadmejora;
	
	public ActividadMejoraPorMesP() {
		super();
	}

	public ActividadMejoraPorMesP(int id, String nombre, int actividadmejora) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.actividadmejora = actividadmejora;
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

	public int getActividadmejora() {
		return actividadmejora;
	}

	public void setActividadmejora(int actividadmejora) {
		this.actividadmejora = actividadmejora;
	}

	@Override
	public String toString() {
		return "ActividadMejoraPorMesP [id=" + id + ", nombre=" + nombre + ", apellido=" + ", actividadmejora=" + actividadmejora + "]";
	}
	
	
}
