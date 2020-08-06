package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.ActividadMejoraPorMesC;

public interface ActividadMejoraPorMesCService {

	ActividadMejoraPorMesC getById(int id);
	List<ActividadMejoraPorMesC> getAll();
	void add(ActividadMejoraPorMesC acp);
	void edit(ActividadMejoraPorMesC acp);
	void delete (ActividadMejoraPorMesC acp);
	void delete (int id);
	List<ActividadMejoraPorMesC> getActividadMejoraPorMesC();
}
