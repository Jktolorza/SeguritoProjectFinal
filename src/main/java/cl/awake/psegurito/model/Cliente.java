package cl.awake.psegurito.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
// -------------------------------/Atributos/-----------------------------------

@Entity
@Table(name = "cliente")
public class Cliente {
	/** Identificador numérico del {@link Cliente} en base de datos */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE1")
	@SequenceGenerator(name = "SEQUENCE1", sequenceName = "ID_CLIENTE_SEQ", allocationSize = 1)
	private int id_cliente;

	/** Nombre de la empresa {@link Cliente} */
	@Column( nullable = false)
	private String nombreEmpresa;

	/** Rut de la empresa {@link Cliente} */
	
	@Column(name = "rutempresa", nullable = false,length = 15)
	private String rut;

	/** Fecha en que ocurrio� el registro {@link Cliente} */
	@Column( nullable = false)
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaRegistro;

	/** Tranformacion de id {@link Usuario} para entregar el nickname */
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "usuario_id_usuario"), @JoinColumn(name = "usuario_nickname"), })
	// @JoinColumn(name="usuario_id_usuario")
	private Usuario usuario;

	/** Contructor vacio de {@link Cliente} */
	public Cliente() {
		super();
	}

	/** Contructor vcon solo un id de {@link Cliente} */
	public Cliente(int id_cliente) {
		super();
		this.id_cliente = id_cliente;
	}

	/** Contructor con todos los atributos menos el id de {@link Cliente} */
	public Cliente(String nombreEmpresa, String rut, Date fechaRegistro, Usuario usuario) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.rut = rut;
		this.fechaRegistro = fechaRegistro;
		this.usuario = usuario;
	}

	/** Contructor con todos los atributos {@link Cliente} */
	public Cliente(int id_cliente, String nombreEmpresa, String rut, Date fechaRegistro, Usuario usuario) {
		super();
		this.id_cliente = id_cliente;
		this.nombreEmpresa = nombreEmpresa;
		this.rut = rut;
		this.fechaRegistro = fechaRegistro;
		this.usuario = usuario;
	}

	/**
	 * @return identificador numérico
	 */
	public int getId_cliente() {
		return id_cliente;
	}

	/**
	 * @param id_cliente identificador numerico autoincremental
	 */
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	/**
	 * @return Nombre de la empresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * @param nombreEmpresa Nombre de la empresa a registrar
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * @return Rut de la empresa
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * @param rut rut de la empresa a registrar
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}

	/**
	 * @return Fecha del registro de la empresa
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro fecha del registro de empresa a registrar
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return Usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario Usuario viculado a la empresa a registrar
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nombreEmpresa=" + nombreEmpresa + ", rut=" + rut
				+ ", fechaRegistro=" + fechaRegistro + ", usuario=" + usuario + "]";
	}
}
