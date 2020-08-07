package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.Checklist;

public interface ChecklistService {
	
	Checklist getById(int id);
	List<Checklist> getAll();
	void add(Checklist ch);
	void edit(Checklist ch);
	void delete(Checklist ch);
	void delete(int id);
	List<Checklist> findByIdVisita(int visita_id_visita);
}
