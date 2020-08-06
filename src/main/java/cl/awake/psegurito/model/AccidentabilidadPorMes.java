package cl.awake.psegurito.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccidentabilidadPorMes {
	
	@Id
	private int id; 
	private String profesional; 
	private float indiceAccidentabilidad;
	
	public AccidentabilidadPorMes() {
		
	}
	
	public AccidentabilidadPorMes(int id, String profesional, float indiceAccidentabilidad) {
		this.id = id;
		this.profesional = profesional;
		this.indiceAccidentabilidad = indiceAccidentabilidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProfesional() {
		return profesional;
	}
	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}
	public float getIndiceAccidentabilidad() {
		return indiceAccidentabilidad;
	}
	public void setIndiceAccidentabilidad(float indiceAccidentabilidad) {
		this.indiceAccidentabilidad = indiceAccidentabilidad;
	}

	@Override
	public String toString() {
		return "AccidentesPorMes [id=" + id + ", profesional=" + profesional + ", indiceAccidentabilidad=" + indiceAccidentabilidad + "]";
	} 
	
	

}