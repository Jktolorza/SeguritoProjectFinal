package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.awake.psegurito.model.AsesoriaExtra;
import cl.awake.psegurito.model.AsesoriaExtraRepository;


@Service
public class AsesoriaExtraServiceImpl implements AsesoriaExtraService {
	

	@Autowired
	AsesoriaExtraRepository asex;
	 

	@Override
	public AsesoriaExtra getById(int id) {
		// TODO Auto-generated method stub
		return asex.findOne(id);
	}

	@Override
	public List<AsesoriaExtra> getAll() {
		// TODO Auto-generated method stub
		return (List<AsesoriaExtra>) asex.findAll();
	}

	@Override
	public void add(AsesoriaExtra ase) {
		// TODO Auto-generated method stub
		asex.save(ase);
	}

	@Override
	public void edit(AsesoriaExtra ase) {
		// TODO Auto-generated method stub
		asex.save(ase);
		
	}

	@Override
	public void delete(AsesoriaExtra ase) {
		// TODO Auto-generated method stub
		 asex.delete(ase);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		asex.delete(id);
		
	}

}
