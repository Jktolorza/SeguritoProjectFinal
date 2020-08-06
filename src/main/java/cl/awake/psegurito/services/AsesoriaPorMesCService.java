package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.AsesoriaPorMesC;

public interface AsesoriaPorMesCService {

	AsesoriaPorMesC getById(int id);
	List<AsesoriaPorMesC> getAll();
	void add(AsesoriaPorMesC apc);
	void edit(AsesoriaPorMesC apc);
	void delete (AsesoriaPorMesC apc);
	void delete (int id);
	List<AsesoriaPorMesC> getAsesoriaPorMesC();
	
	
}
