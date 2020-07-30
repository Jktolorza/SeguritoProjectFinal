package cl.awake.psegurito.model;

import java.io.Serializable;

public class UsuarioId implements Serializable {
    private int id_usuario;
    private String nickname;
 
    // default constructor
 
    public UsuarioId(int id_usuario, String nickname) {
        this.id_usuario = id_usuario;
        this.nickname = nickname;
    }

	public UsuarioId() {
		super();
	}
 
    // equals() and hashCode()
}
