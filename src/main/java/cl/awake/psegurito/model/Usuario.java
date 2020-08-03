package cl.awake.psegurito.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
@IdClass(UsuarioId.class)
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="ID_USUARIO_SEQ", allocationSize=1)
	private int id_usuario;
	@Id
	@Column(unique=true)
	private String nickname;
	private String password;
	private String rol;
	
	public Usuario() {
		super();
	}

	public Usuario(int id_usuario) {
		super();
		this.id_usuario = id_usuario;
	}

	public Usuario(int id_usuario, String nickname, String password, String rol) {
		super();
		this.id_usuario = id_usuario;
		this.nickname = nickname;
		this.password = password;
		this.rol = rol;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nickname=" + nickname + ", password=" + password + ", rol="
				+ rol + "]";
	}


	

}
