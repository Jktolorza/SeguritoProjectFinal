package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.CapacitacionesPorMesP;
import cl.awake.psegurito.model.CapacitacionesPorMesPRepository;


@Service
public class CapacitacionesPorMesPServiceImpl implements CapacitacionesPorMesPService {

	@Autowired
	CapacitacionesPorMesPRepository cpmr;


	@Override
	public CapacitacionesPorMesP getById(int id) {
		// TODO Auto-generated method stub
		return cpmr.findOne(id);
	}

	@Override
	public List<CapacitacionesPorMesP> getAll() {
		// TODO Auto-generated method stub
		return (List<CapacitacionesPorMesP>) cpmr.findAll();
	}

	@Override
	public void add(CapacitacionesPorMesP p) {
		// TODO Auto-generated method stub
		cpmr.save(p);
	}

	@Override
	public void edit(CapacitacionesPorMesP p) {
		// TODO Auto-generated method stub
		cpmr.save(p);
	}

	@Override
	public void delete(CapacitacionesPorMesP p) {
		// TODO Auto-generated method stub
		cpmr.delete(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cpmr.delete(id);
	}
	@Override
	public List<CapacitacionesPorMesP> getCapacitacionesPorMesP() {
		return cpmr.getCapacitacionesPorMesP();
	}



}