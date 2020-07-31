package cl.awake.psegurito.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetalleChecklistRepository extends JpaRepository<DetalleChecklist, Integer> {
	@Query(value="Select * from detallechecklist dch where dch.checklist_id_checklist=?1", nativeQuery=true)
	List<DetalleChecklist> findByIdChecklist(int checklist_id_checklist);

}
