package cl.awake.psegurito.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UsuarioId implements Serializable {
    private int id_usuario;
    private String nickname;
 
    // default constructor
 
    public UsuarioId(int id_usuario, String nickname) {
        this.setId_usuario(id_usuario);
        this.setNickname(nickname);
    }

	public UsuarioId() {
		super();
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
	

 
    // equals() and hashCode()
}
