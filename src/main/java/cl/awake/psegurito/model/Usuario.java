package cl.awake.psegurito.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	private String nickname;
	private String password;
	private String rol;
	
	public Usuario() {
		super();
	}

	public Usuario(String nickname) {
		super();
		this.nickname = nickname;
	}

	public Usuario(String nickname, String password, String rol) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.rol = rol;
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
		return "Usuario [nickname=" + nickname + ", password=" + password + ", rol=" + rol + "]";
	}
	
}
