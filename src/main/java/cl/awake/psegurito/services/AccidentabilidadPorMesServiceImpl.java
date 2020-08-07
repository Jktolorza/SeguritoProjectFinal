package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.AccidentabilidadPorMes;
import cl.awake.psegurito.model.AccidentabilidadPorMesRepository;

@Service
public class AccidentabilidadPorMesServiceImpl implements AccidentabilidadPorMesService {

	@Autowired
	AccidentabilidadPorMesRepository accpmr;

	@Override
	public AccidentabilidadPorMes getById(int id) {
		// TODO Auto-generated method stub
		return accpmr.findOne(id);
	}

	@Override
	public List<AccidentabilidadPorMes> getAll() {
		// TODO Auto-generated method stub
		return (List<AccidentabilidadPorMes>) accpmr.findAll();
	}

	@Override
	public void add(AccidentabilidadPorMes accpm) {
		// TODO Auto-generated method stub
		accpmr.save(accpm);
	}

	@Override
	public void edit(AccidentabilidadPorMes accpm) {
		// TODO Auto-generated method stub
		accpmr.save(accpm);
	}

	@Override
	public void delete(AccidentabilidadPorMes accpm) {
		// TODO Auto-generated method stub
		accpmr.delete(accpm);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		accpmr.delete(id);
	}

	@Override
	public List<AccidentabilidadPorMes> getAccidentabilidadPorMes() {
		return accpmr.getAccidentabilidadPorMes();
	}
	
	@Override
	public List<AccidentabilidadPorMes> getAccidentabilidadHistorica() {
		return accpmr.getAccidentabilidadHistorica();
	}
}
