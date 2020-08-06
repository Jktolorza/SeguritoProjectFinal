package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.AccidentesPorMes;
import cl.awake.psegurito.model.AccidentesPorMesRepository;


@Service
public class AccidentesPorMesServiceImpl implements AccidentesPorMesService {

	@Autowired
	AccidentesPorMesRepository apm;

	@Override
	public AccidentesPorMes getById(int id) {
		// TODO Auto-generated method stub
		return apm.findOne(id);
	}

	@Override
	public List<AccidentesPorMes> getAll() {
		// TODO Auto-generated method stub
		return (List<AccidentesPorMes>) apm.findAll();
	}

	@Override
	public void add(AccidentesPorMes p) {
		// TODO Auto-generated method stub
		apm.save(p);
	}

	@Override
	public void edit(AccidentesPorMes p) {
		// TODO Auto-generated method stub
		apm.save(p);
	}

	@Override
	public void delete(AccidentesPorMes p) {
		// TODO Auto-generated method stub
		apm.delete(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		apm.delete(id);
	}
	@Override
	public List<AccidentesPorMes> getAccidentesPorMes() {
		return apm.getAccidentesPorMes();
	}



}