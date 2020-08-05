package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.Moroso;
import cl.awake.psegurito.model.MorosoRepository;

@Service
public class MorosoServiceImpl implements MorosoService {

	@Autowired
	MorosoRepository pr;
	
	@Override
	public Moroso getById(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).orElse(null);
	}

	@Override
	public List<Moroso> getAll() {
		// TODO Auto-generated method stub
		return (List<Moroso>) pr.findAll();
	}

	@Override
	public void add(Moroso p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public void edit(Moroso p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public void delete(Moroso p) {
		// TODO Auto-generated method stub
		pr.delete(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
        pr.deleteById(id);
	}
	@Override
	public List<Moroso> getmoroso() {
		return pr.getMoroso();
	}

}