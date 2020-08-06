package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.ActividadMejoraPorMesP;
import cl.awake.psegurito.model.ActividadMejoraPorMesPRepository;

@Service
public class ActividaMejoraPorMesPServiceImpl implements ActividadMejoraPorMesPService{

	@Autowired
	ActividadMejoraPorMesPRepository apmpr;
	
	@Override
	public ActividadMejoraPorMesP getById(int id) {
		// TODO Auto-generated method stub
		return apmpr.findOne(id);
	}

	@Override
	public List<ActividadMejoraPorMesP> getAll() {
		// TODO Auto-generated method stub
		return (List<ActividadMejoraPorMesP>) apmpr.findAll() ;
	}

	@Override
	public void add(ActividadMejoraPorMesP acpp) {
		// TODO Auto-generated method stub
		apmpr.save(acpp);
	}

	@Override
	public void edit(ActividadMejoraPorMesP acpp) {
		// TODO Auto-generated method stub
		apmpr.save(acpp);
	}

	@Override
	public void delete(ActividadMejoraPorMesP acpp) {
		// TODO Auto-generated method stub
		apmpr.delete(acpp);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		apmpr.delete(id);

	}

	@Override
	public List<ActividadMejoraPorMesP> getActividadMejoraPorMesP() {
		// TODO Auto-generated method stub
		return apmpr.getActividadMejoraPorMesP();
	}

}
