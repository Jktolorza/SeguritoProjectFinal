package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.ActividadMejoraPorMesC;
import cl.awake.psegurito.model.ActividadMejoraPorMesCRepository;

@Service
public class ActividadMejoraPorMesCServiceImpl implements ActividadMejoraPorMesCService {

	@Autowired
	ActividadMejoraPorMesCRepository apmr;
	
	@Override
	public ActividadMejoraPorMesC getById(int id) {
		// TODO Auto-generated method stub
		return apmr.findOne(id);
	}

	@Override
	public List<ActividadMejoraPorMesC> getAll() {
		// TODO Auto-generated method stub
		return (List<ActividadMejoraPorMesC>) apmr.findAll();
	}

	@Override
	public void add(ActividadMejoraPorMesC acp) {
		// TODO Auto-generated method stub
		apmr.save(acp);
	}

	@Override
	public void edit(ActividadMejoraPorMesC acp) {
		// TODO Auto-generated method stub
		apmr.save(acp);
	}

	@Override
	public void delete(ActividadMejoraPorMesC acp) {
		// TODO Auto-generated method stub
		apmr.delete(acp);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		apmr.delete(id);
	}

	@Override
	public List<ActividadMejoraPorMesC> getActividadMejoraPorMesC() {
		// TODO Auto-generated method stub
		return apmr.getActividadMejoraPorMesC();
	}
	

}
