package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.awake.psegurito.model.ActividadMejora;
import cl.awake.psegurito.model.ActividadMejoraRepository;

public class ActividadMejoraServicelmpl implements ActividadMejoraService {

	@Autowired
	ActividadMejoraRepository acr;
	
	@Override
	public ActividadMejora getById(int id) {
		// TODO Auto-generated method stub
		return acr.findOne(id);
	}

	@Override
	public List<ActividadMejora> getAll() {
		// TODO Auto-generated method stub
		return (List<ActividadMejora>) acr.findAll();
	}

	@Override
	public void add(ActividadMejora ac) {
		// TODO Auto-generated method stub
		acr.save(ac);
	}

	@Override
	public void edit(ActividadMejora ac) {
		// TODO Auto-generated method stub
		acr.save(ac);
	}

	@Override
	public void delete(ActividadMejora ac) {
		// TODO Auto-generated method stub
		acr.delete(ac);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		acr.delete(id);
	}

}
