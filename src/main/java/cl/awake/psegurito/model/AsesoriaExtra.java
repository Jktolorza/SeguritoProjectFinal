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

//Atributos

@Entity
@Table(name="asesoriaextra")
public class AsesoriaExtra {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_ASESORIAEXTRA_SEQ", allocationSize=1)
	private int id_asesoriaextra; 
	
	//Fecha convertida a fecha en formato de la BD
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
	
	//Contructor Vacio 
	public AsesoriaExtra() {
		
	}

	//Contructor con todos los parametros
	public AsesoriaExtra(int id_asesoriaextra, Date fechayhora, String motivo, String detalle, Cliente cliente,Profesional profesional) {
		this.id_asesoriaextra = id_asesoriaextra;
		this.fechayhora = fechayhora;
		this.motivo = motivo;
		this.detalle = detalle;
		this.cliente = cliente;
		this.profesional = profesional;
	}
	//Getter And Setter

	public int getId_asesoriaextra() {
		return id_asesoriaextra;
	}

	public void setId_asesoriaextra(int id_asesoriaextra) {
		this.id_asesoriaextra = id_asesoriaextra;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
		

}
