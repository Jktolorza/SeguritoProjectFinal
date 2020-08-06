package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.AsesoriaPorMesC;
import cl.awake.psegurito.model.AsesoriaPorMesCRepository;

@Service
public class AsesoriaPorMesCServiceImpl implements AsesoriaPorMesCService{
	@Autowired
	AsesoriaPorMesCRepository aspmr;
	
	@Override
	public AsesoriaPorMesC getById(int id) {
		// TODO Auto-generated method stub
		return aspmr.findOne(id);
	}

	@Override
	public List<AsesoriaPorMesC> getAll() {
		// TODO Auto-generated method stub
		return (List<AsesoriaPorMesC>) aspmr.findAll();
	}

	@Override
	public void add(AsesoriaPorMesC apc) {
		// TODO Auto-generated method stub
		aspmr.save(apc);
	}

	@Override
	public void edit(AsesoriaPorMesC apc) {
		// TODO Auto-generated method stub
		aspmr.save(apc);
	}

	@Override
	public void delete(AsesoriaPorMesC apc) {
		// TODO Auto-generated method stub
		aspmr.delete(apc);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		aspmr.delete(id);
	}

	@Override
	public List<AsesoriaPorMesC> getAsesoriaPorMesC() {
		// TODO Auto-generated method stub
		return aspmr.getAsesoriaPorMesC();
	}
}
