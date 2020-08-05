package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.Administrador;
import cl.awake.psegurito.model.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService {

	@Autowired
	AdministradorRepository ar;
	
	@Override
	public Administrador getById(int id) {
		// TODO Auto-generated method stub
		return ar.findById(id).orElse(null);
	}

	@Override
	public List<Administrador> getAll() {
		// TODO Auto-generated method stub
		return (List<Administrador>) ar.findAll();
	}

	@Override
	public void add(Administrador a) {
		// TODO Auto-generated method stub
		ar.save(a);
	}

	@Override
	public void edit(Administrador a) {
		// TODO Auto-generated method stub
		ar.save(a);
	}

	@Override
	public void delete(Administrador a) {
		// TODO Auto-generated method stub
		ar.delete(a);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
        ar.deleteById(id);
	}

}
