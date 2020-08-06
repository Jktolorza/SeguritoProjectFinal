package cl.awake.psegurito.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ActividadMejoraPorMesPRepository extends CrudRepository<ActividadMejoraPorMesP, Integer>{
	
	@Query(value = "select profesional.id_profesional AS id, profesional.nombre || ' ' || profesional.apellido AS nombre, count(actividadmejora.id_actividadmejora) as actividadmejora\r\n" + 
			"from actividadmejora\r\n" + 
			"inner join profesional\r\n" + 
			"on profesional.id_profesional=actividadmejora.profesional_id_profesional\r\n" + 
			"where fechainicio between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)\r\n" + 
			"group by profesional.id_profesional , profesional.nombre, profesional.apellido", nativeQuery = true)
	List<ActividadMejoraPorMesP>getActividadMejoraPorMesP();
}
