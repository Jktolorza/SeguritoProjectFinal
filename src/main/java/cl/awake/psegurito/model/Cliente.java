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
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_CLIENTE_SEQ", allocationSize=1)
    private int id_cliente;
    private String nombreEmpresa;
    @Column(name="rutempresa")
    private String rut;
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRegistro;
	@JoinColumn(name="usuario_nickname")
    @ManyToOne
	private Usuario nickname;
    
	public Cliente() {
		super();
	}

	public Cliente(int id_cliente) {
		super();
		this.id_cliente = id_cliente;
	}

	public Cliente(String nombreEmpresa, String rut, Date fechaRegistro, Usuario nickname) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.rut = rut;
		this.fechaRegistro = fechaRegistro;
		this.nickname = nickname;
	}

	public Cliente(int id_cliente, String nombreEmpresa, String rut, Date fechaRegistro, Usuario nickname) {
		super();
		this.id_cliente = id_cliente;
		this.nombreEmpresa = nombreEmpresa;
		this.rut = rut;
		this.fechaRegistro = fechaRegistro;
		this.nickname = nickname;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Usuario getNickname() {
		return nickname;
	}

	public void setNickname(Usuario nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nombreEmpresa=" + nombreEmpresa + ", rut=" + rut
				+ ", fechaRegistro=" + fechaRegistro + ", nickname=" + nickname + "]";
	}
	
	
	
}
    
    
    
	