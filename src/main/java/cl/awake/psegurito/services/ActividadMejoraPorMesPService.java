package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.ActividadMejoraPorMesP;

public interface ActividadMejoraPorMesPService {
	
	ActividadMejoraPorMesP getById(int id);
	List<ActividadMejoraPorMesP> getAll();
	void add(ActividadMejoraPorMesP acpp);
	void edit(ActividadMejoraPorMesP acpp);
	void delete(ActividadMejoraPorMesP acpp);
	void delete(int id);
	List<ActividadMejoraPorMesP> getActividadMejoraPorMesP();
}
