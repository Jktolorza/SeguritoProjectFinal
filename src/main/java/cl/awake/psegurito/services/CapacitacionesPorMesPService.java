package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.CapacitacionesPorMesP;

public interface CapacitacionesPorMesPService {
	
		CapacitacionesPorMesP getById(int id);
	    List<CapacitacionesPorMesP> getAll();
	    void add(CapacitacionesPorMesP p);
	    void edit(CapacitacionesPorMesP p);
	    void delete(CapacitacionesPorMesP p);
	    void delete(int id);
	    List<CapacitacionesPorMesP> getCapacitacionesPorMesP();

}
