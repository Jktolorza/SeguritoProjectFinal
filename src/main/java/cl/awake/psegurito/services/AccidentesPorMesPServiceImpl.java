package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.awake.psegurito.model.AccidentesPorMesP;
import cl.awake.psegurito.model.AccidentesPorMesPRepository;




@Service
public class AccidentesPorMesPServiceImpl implements AccidentesPorMesPService {

	@Autowired
	AccidentesPorMesPRepository appm;

	@Override
	public AccidentesPorMesP getById(int id) {
		// TODO Auto-generated method stub
		return appm.findOne(id);
	}

	@Override
	public List<AccidentesPorMesP> getAll() {
		// TODO Auto-generated method stub
		return (List<AccidentesPorMesP>) appm.findAll();
	}

	@Override
	public void add(AccidentesPorMesP p) {
		// TODO Auto-generated method stub
		appm.save(p);
	}

	@Override
	public void edit(AccidentesPorMesP p) {
		// TODO Auto-generated method stub
		appm.save(p);
	}

	@Override
	public void delete(AccidentesPorMesP p) {
		// TODO Auto-generated method stub
		appm.delete(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		appm.delete(id);
	}
	@Override
	public List<AccidentesPorMesP> getAccidentesPorMesP() {
		return appm.getAccidentesPorMesP();
	}



}