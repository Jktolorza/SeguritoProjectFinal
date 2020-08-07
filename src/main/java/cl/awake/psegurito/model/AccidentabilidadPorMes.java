package cl.awake.psegurito.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccidentabilidadPorMes {
	
	@Id
	private int id; 
	private String profesional;
	private int periodo;
	private float indiceAccidentabilidad;
	
	public AccidentabilidadPorMes() {
		
	}
	
	public AccidentabilidadPorMes(int id, String profesional, int periodo, float indiceAccidentabilidad) {
		this.id = id;
		this.periodo = periodo;
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

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public float getIndiceAccidentabilidad() {
		return indiceAccidentabilidad;
	}

	public void setIndiceAccidentabilidad(float indiceAccidentabilidad) {
		this.indiceAccidentabilidad = indiceAccidentabilidad;
	}

	@Override
	public String toString() {
		return "AccidentabilidadPorMes [id=" + id + ", profesional=" + profesional + ", periodo=" + periodo
				+ ", indiceAccidentabilidad=" + indiceAccidentabilidad + "]";
	}
	
}