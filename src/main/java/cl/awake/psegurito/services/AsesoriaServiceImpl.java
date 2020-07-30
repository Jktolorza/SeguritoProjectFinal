package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.Asesoria;
import cl.awake.psegurito.model.AsesoriaRepository;

@Service
public class AsesoriaServiceImpl implements AsesoriaService {
	
	@Autowired
    AsesoriaRepository asr;
	 
	@Override
	public Asesoria getById(int id) {
		// TODO Auto-generated method stub
		return asr.findOne(id);
	}

	@Override
	public List<Asesoria> getAll() {
		// TODO Auto-generated method stub
		return (List<Asesoria>) asr.findAll();
	}

	@Override
	public void add(Asesoria as) {
		// TODO Auto-generated method stub
		asr.save(as);
	}

	@Override
	public void edit(Asesoria as) {
		// TODO Auto-generated method stub
		asr.save(as);
	}

	@Override
	public void delete(Asesoria as) {
		// TODO Auto-generated method stub
		 asr.delete(as);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		asr.delete(id);
	}

}
