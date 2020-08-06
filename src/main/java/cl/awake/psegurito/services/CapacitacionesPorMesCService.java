package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.CapacitacionesPorMesC;



public interface CapacitacionesPorMesCService {
	
	CapacitacionesPorMesC getById(int id);
	    List<CapacitacionesPorMesC> getAll();
	    void add(CapacitacionesPorMesC p);
	    void edit(CapacitacionesPorMesC p);
	    void delete(CapacitacionesPorMesC p);
	    void delete(int id);
	    List<CapacitacionesPorMesC> getCapacitacionesPorMesC();

}
