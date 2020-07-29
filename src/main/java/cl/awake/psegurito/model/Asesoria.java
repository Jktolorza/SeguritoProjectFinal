package cl.awake.psegurito.model;

import java.util.Date;

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
@Table(name="asesorias")
public class Asesoria {
	 //Variables//
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_ASESORIA_SEQ", allocationSize=1)
	private int id_asesoria;
    
    //Ojo con el date
    @Temporal(value=TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date fechayhora;
	private String motivo;
	private String detalle;
	
	
	@JoinColumn(name="profesional_id_profesional")
	@ManyToOne
	private Profesional profesional;
	
	
	@JoinColumn(name="cliente_id_cliente")
	@ManyToOne
	private Cliente cliente;
	
	public Asesoria() {
		
	}
	
	public Asesoria(int id_asesoria, Date fechayhora, String motivo, String detalle,
			Profesional profesional, Cliente cliente) {
		this.id_asesoria = id_asesoria;
		this.fechayhora = fechayhora;
		this.motivo = motivo;
		this.detalle = detalle;
		this.profesional = profesional;
		this.cliente = cliente;
	}

	public int getId_asesoria() {
		return id_asesoria;
	}

	public void setId_asesoria(int id_asesoria) {
		this.id_asesoria = id_asesoria;
	}

	public Date getFechayhora() {
		return fechayhora;
	}

	public void setFechayhora(Date fechayhora) {
		this.fechayhora = fechayhora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
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
	

}
