package cl.awake.psegurito.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="profesional")
public class Profesional {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_PROFESIONAL_SEQ", allocationSize=1)
    private int id_profesional;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String cargo;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumns({
        @JoinColumn(name="usuario_id_usuario"),
        @JoinColumn(name="usuario_nickname"),
    })
    private Usuario usuario;
    
	public Profesional() {
		super();
	}

	public Profesional(int id_profesional) {
		super();
		this.id_profesional = id_profesional;
	}

	public Profesional(String nombre, String apellido, String correo, String telefono, String cargo, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.cargo = cargo;
		this.usuario = usuario;
	}

	public Profesional(int id_profesional, String nombre, String apellido, String correo, String telefono, String cargo,
			Usuario usuario) {
		super();
		this.id_profesional = id_profesional;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.cargo = cargo;
		this.usuario = usuario;
	}

	public Profesional(String nombre, String apellido, String correo, String telefono, String cargo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.cargo = cargo;
	}

	public int getId_profesional() {
		return id_profesional;
	}

	public void setId_profesional(int id_profesional) {
		this.id_profesional = id_profesional;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
    
	
    
    
}
 