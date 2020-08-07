package cl.awake.psegurito.model;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ChecklistRepository extends CrudRepository<Checklist, Integer> {
	@Query(value="Select * from checklist ch where ch.visita_id_visita=?1", nativeQuery=true)
	List<Checklist> findByIdVisita(int visita_id_visita);
}
