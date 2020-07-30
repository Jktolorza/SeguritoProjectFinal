package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.DetalleChecklist;

public interface DetalleChecklistService {
	
	DetalleChecklist getById(int id);
	List<DetalleChecklist> getAll();
	void add (DetalleChecklist dch);
	void edit (DetalleChecklist dch);
	void delete (DetalleChecklist dch);
	void delete (int id);
	List<DetalleChecklist> findAllByIdChecklist(int id_checklist);
}
