package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.AsesoriaExtra;



public interface AsesoriaExtraService {
	 AsesoriaExtra getById(int id);
     List<AsesoriaExtra> getAll();
     void add(AsesoriaExtra ase);
     void edit(AsesoriaExtra ase);
     void delete(AsesoriaExtra ase);
     void delete(int id);
	

}
