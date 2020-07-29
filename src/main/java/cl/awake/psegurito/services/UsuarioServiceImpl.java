package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.awake.psegurito.model.Usuario;
import cl.awake.psegurito.model.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository ur;
	
	@Override
	public Usuario getById(int id) {
		// TODO Auto-generated method stub
		return ur.findOne(id);
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) ur.findAll();
	}

	@Override
	public void add(Usuario u) {
		// TODO Auto-generated method stub
		ur.save(u);
	}

	@Override
	public void edit(Usuario u) {
		// TODO Auto-generated method stub
		ur.save(u);
	}

	@Override
	public void delete(Usuario u) {
		// TODO Auto-generated method stub
		ur.delete(u);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
        ur.delete(id);
	}

}
