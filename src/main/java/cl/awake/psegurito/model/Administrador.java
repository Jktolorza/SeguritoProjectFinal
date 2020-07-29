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
	private String usuario_nickname;
	
	public Administrador() {
		super();
	}

	public Administrador(int id_administrador) {
		super();
		this.id_administrador = id_administrador;
	}

	public Administrador(int id_administrador, String nombre, String usuario_nickname) {
		super();
		this.id_administrador = id_administrador;
		this.nombre = nombre;
		this.usuario_nickname = usuario_nickname;
	}

	public Administrador(String nombre, String usuario_nickname) {
		super();
		this.nombre = nombre;
		this.usuario_nickname = usuario_nickname;
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

	public String getUsuario_nickname() {
		return usuario_nickname;
	}

	public void setUsuario_nickname(String usuario_nickname) {
		this.usuario_nickname = usuario_nickname;
	}

	@Override
	public String toString() {
		return "Administrador [id_administrador=" + id_administrador + ", nombre=" + nombre + ", usuario_nickname="
				+ usuario_nickname + "]";
	}
	
}
