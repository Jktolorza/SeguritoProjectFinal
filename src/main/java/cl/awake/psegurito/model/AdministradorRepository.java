package cl.awake.psegurito.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
@Service
public interface AdministradorRepository extends CrudRepository<Administrador, Integer>{

}
