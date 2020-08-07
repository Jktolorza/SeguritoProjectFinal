package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.Checklist;
import cl.awake.psegurito.model.ChecklistRepository;

@Service
public class ChecklistServiceImpl implements ChecklistService {

	@Autowired
	ChecklistRepository chr;
	
	@Override
	public Checklist getById(int id) {
		// TODO Auto-generated method stub
		return chr.findOne(id);
	}

	@Override
	public List<Checklist> getAll() {
		// TODO Auto-generated method stub
		return (List<Checklist>) chr.findAll();
	}

	@Override
	public void add(Checklist ch) {
		// TODO Auto-generated method stub
		chr.save(ch);
	}

	@Override
	public void edit(Checklist ch) {
		// TODO Auto-generated method stub
		chr.save(ch);
	}

	@Override
	public void delete(Checklist ch) {
		// TODO Auto-generated method stub
		chr.delete(ch);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		chr.delete(id);
	}
	
	@Override
	public List<Checklist> findByIdVisita(int visita_id_visita) {
		return chr.findByIdVisita(visita_id_visita);
	}

}
