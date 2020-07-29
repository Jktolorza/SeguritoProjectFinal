package cl.awake.psegurito.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="ID_ADMINISTRADOR_SEQ", allocationSize=1)
	private int id_administrador;
	private String nombre;
	@JoinColumn(name="usuario_nickname")
    @ManyToOne
	private Usuario usuario;
	
	public Administrador() {
		super();
	}

	public Administrador(int id_administrador) {
		super();
		this.id_administrador = id_administrador;
	}

	public Administrador(int id_administrador, String nombre, Usuario usuario) {
		super();
		this.id_administrador = id_administrador;
		this.nombre = nombre;
		this.usuario = usuario;
	}

	public Administrador(String nombre, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
	}

	public int getId_administrador() {
		return id_administrador;
	}

	public void setId_administrador(int id_administrador) {
		this.id_administrador = id_administrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Administrador [id_administrador=" + id_administrador + ", nombre=" + nombre + ", usuario="
				+ usuario + "]";
	}
	
}
