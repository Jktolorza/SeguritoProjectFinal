package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.AsesoriaPorMesP;

public interface AsesoriaPorMesPService {

	AsesoriaPorMesP getById(int id);
	List<AsesoriaPorMesP> getAll();
	void add(AsesoriaPorMesP app);
	void edit(AsesoriaPorMesP app);
	void delete (AsesoriaPorMesP app);
	void delete (int id);
	List<AsesoriaPorMesP> getAsesoriaPorMesP();
}
