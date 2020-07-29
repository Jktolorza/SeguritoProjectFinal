package cl.awake.psegurito.services;
import java.util.List;

import cl.awake.psegurito.model.ActividadMejora;

public interface ActividadMejoraService {
	
	ActividadMejora getById(int id);
	List<ActividadMejora> getAll();
	void add(ActividadMejora ac);
    void edit(ActividadMejora ac);
    void delete(ActividadMejora ac);
    void delete(int id);

	
	
}
