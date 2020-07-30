package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.AsesoriaExtra;



public interface AsesoriaExtraService {
	 AsesoriaExtra getById(int id);
     List<AsesoriaExtra> getAll();
     void add(AsesoriaExtra asex);
     void edit(AsesoriaExtra asex);
     void delete(AsesoriaExtra asex);
     void delete(int id);
	

}
