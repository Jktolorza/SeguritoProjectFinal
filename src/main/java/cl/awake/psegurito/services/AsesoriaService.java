package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.Asesoria;

public interface AsesoriaService {
	 Asesoria getById(int id);
     List<Asesoria> getAll();
     void add(Asesoria as);
     void edit(Asesoria as);
     void delete(Asesoria as);
     void delete(int id);
	

}
