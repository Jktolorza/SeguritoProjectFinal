package cl.awake.psegurito.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="actividadmejora")
public class ActividadMejora {

	/** Identificador numerico  {@link Actividad Mejora} */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_ACTIVIDADMEJORA_SEQ", allocationSize=1)
	private int id_actividadmejora;
	
	/** Nombre descritivo de la mejora  {@link Actividad Mejora} */
	@Column( nullable = false)
	private String nombre;
	
	/** Fecha de inicio de la mejora {@link Actividad Mejora} */
	@Column( nullable = false)
	@Temporal(value=TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;
	
	/** Fecha de termino de la mejora {@link Actividad Mejora} */
	@Column( nullable = false)
	@Temporal(value=TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaTermino;
	
	/** Estado de la mejora(activa, terminada, entre otras){@link Actividad Mejora} */
	@Column( nullable = false)
	private String estado;
	
	@Column( nullable = false)
	private String detalle;
	
	@JoinColumn(name="profesional_id_profesional")
	@ManyToOne
	private Profesional profesional;
	
	
	@JoinColumn(name="cliente_id_cliente")
	@ManyToOne
	private Cliente cliente;


	public ActividadMejora() {
		super();
	}


	public ActividadMejora(int id_actividadmejora, String nombre, Date fechaInicio, Date fechaTermino, String estado,
			String detalle, Profesional profesional, Cliente cliente) {
		super();
		this.id_actividadmejora = id_actividadmejora;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.estado = estado;
		this.detalle = detalle;
		this.profesional = profesional;
		this.cliente = cliente;
	}


	public int getIdactividadmejora() {
		return id_actividadmejora;
	}


	public void setIdactividadmejora(int id_actividadmejora) {
		this.id_actividadmejora = id_actividadmejora;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaTermino() {
		return fechaTermino;
	}


	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public Profesional getProfesional() {
		return profesional;
	}


	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "ActividadMejora [id_actividadmejora=" + id_actividadmejora + ", nombre=" + nombre + ", fechaInicio="
				+ fechaInicio + ", fechaTermino=" + fechaTermino + ", estado=" + estado + ", detalle=" + detalle
				+ ", profesional=" + profesional + ", cliente=" + cliente + "]";
	}
	
	
	
}
