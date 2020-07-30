package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.DetalleChecklist;
import cl.awake.psegurito.model.DetalleChecklistRepository;

@Service
public class DetalleChecklistImpl implements DetalleChecklistService{
	
	@Autowired
	DetalleChecklistRepository dchr;

	@Override
	public DetalleChecklist getById(int id) {
		// TODO Auto-generated method stub
		return dchr.findOne(id);
	}

	@Override
	public List<DetalleChecklist> getAll() {
		// TODO Auto-generated method stub
		return (List<DetalleChecklist>) dchr.findAll();
	}

	@Override
	public void add(DetalleChecklist dch) {
		// TODO Auto-generated method stub
		dchr.save(dch);
	}

	@Override
	public void edit(DetalleChecklist dch) {
		// TODO Auto-generated method stub
		dchr.save(dch);
	}

	@Override
	public void delete(DetalleChecklist dch) {
		// TODO Auto-generated method stub
		dchr.delete(dch);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dchr.delete(id);
	}

	@Override
	public List<DetalleChecklist> findAllByIdChecklist(int id_checklist) {
		// TODO Auto-generated method stub
		return dchr.findByIdChecklist(id_checklist);
	}

}
