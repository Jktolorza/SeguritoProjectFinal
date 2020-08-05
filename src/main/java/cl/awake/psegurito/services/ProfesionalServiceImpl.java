package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.model.ProfesionalRepository;

@Service
public class ProfesionalServiceImpl implements ProfesionalService {

	@Autowired
	ProfesionalRepository pr;
	
	@Override
	public Profesional getById(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).orElse(null);
	}

	@Override
	public List<Profesional> getAll() {
		// TODO Auto-generated method stub
		return (List<Profesional>) pr.findAll();
	}

	@Override
	public void add(Profesional p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public void edit(Profesional p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public void delete(Profesional p) {
		// TODO Auto-generated method stub
		pr.delete(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
        pr.deleteById(id);
	}

}
