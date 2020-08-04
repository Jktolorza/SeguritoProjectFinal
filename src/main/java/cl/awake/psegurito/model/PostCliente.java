package cl.awake.psegurito.model;

import java.util.Date;

public class PostCliente {

	private int id_cliente;
	private String nombreEmpresa;
	private String rut;
	private Date fechaRegistro;
	private Usuario usuario;

	public PostCliente() {
		super();
	}

	/** Contructor vcon solo un id de {@link Cliente} */
	public PostCliente(int id_cliente) {
		super();
		this.id_cliente = id_cliente;
	}

	/** Contructor con todos los atributos menos el id de {@link Cliente} */
	public PostCliente(String nombreEmpresa, String rut, Date fechaRegistro, Usuario usuario) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.rut = rut;
		this.fechaRegistro = fechaRegistro;
		this.usuario = usuario;
	}

	/** Contructor con todos los atributos {@link Cliente} */
	public PostCliente(int id_cliente, String nombreEmpresa, String rut, Date fechaRegistro, Usuario usuario) {
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
