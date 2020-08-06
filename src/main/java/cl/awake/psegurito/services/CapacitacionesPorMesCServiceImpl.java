package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.CapacitacionesPorMesC;
import cl.awake.psegurito.model.CapacitacionesPorMesCRepository;

@Service
public class CapacitacionesPorMesCServiceImpl implements CapacitacionesPorMesCService {

	@Autowired
	CapacitacionesPorMesCRepository cpmr;


	@Override
	public CapacitacionesPorMesC getById(int id) {
		// TODO Auto-generated method stub
		return cpmr.findOne(id);
	}

	@Override
	public List<CapacitacionesPorMesC> getAll() {
		// TODO Auto-generated method stub
		return (List<CapacitacionesPorMesC>) cpmr.findAll();
	}

	@Override
	public void add(CapacitacionesPorMesC p) {
		// TODO Auto-generated method stub
		cpmr.save(p);
	}

	@Override
	public void edit(CapacitacionesPorMesC p) {
		// TODO Auto-generated method stub
		cpmr.save(p);
	}

	@Override
	public void delete(CapacitacionesPorMesC p) {
		// TODO Auto-generated method stub
		cpmr.delete(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cpmr.delete(id);
	}
	@Override
	public List<CapacitacionesPorMesC> getCapacitacionesPorMesC() {
		return cpmr.getCapacitacionesPorMesC();
	}



}