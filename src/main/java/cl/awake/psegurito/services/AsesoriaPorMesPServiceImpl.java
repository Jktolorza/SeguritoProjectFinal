package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.AsesoriaPorMesP;
import cl.awake.psegurito.model.AsesoriaPorMesPRepository;

@Service
public class AsesoriaPorMesPServiceImpl implements AsesoriaPorMesPService {
	
	@Autowired
	AsesoriaPorMesPRepository aspmpr;
	
	@Override
	public AsesoriaPorMesP getById(int id) {
		// TODO Auto-generated method stub
		return aspmpr.findOne(id);
	}

	@Override
	public List<AsesoriaPorMesP> getAll() {
		// TODO Auto-generated method stub
		return (List<AsesoriaPorMesP>) aspmpr.findAll();
	}

	@Override
	public void add(AsesoriaPorMesP app) {
		// TODO Auto-generated method stub
		aspmpr.save(app);
	}

	@Override
	public void edit(AsesoriaPorMesP app) {
		// TODO Auto-generated method stub
		aspmpr.save(app);
	}

	@Override
	public void delete(AsesoriaPorMesP app) {
		// TODO Auto-generated method stub
		aspmpr.delete(app);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		aspmpr.delete(id);
	}

	@Override
	public List<AsesoriaPorMesP> getAsesoriaPorMesP() {
		// TODO Auto-generated method stub
		return aspmpr.getAsesoriaPorMesP();
	}

}
