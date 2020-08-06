package cl.awake.psegurito.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccidentesPorMesPRepository extends CrudRepository<AccidentesPorMesP, Integer> {

	@Query(value="select profesional.id_profesional AS id, profesional.nombre || ' ' || profesional.apellido as nombre, count(reporteaccidente.id_reporteaccidente) as accidentes\r\n" + 
			"from reporteaccidente\r\n" + 
			"inner join profesional\r\n" + 
			"on profesional.id_profesional=reporteaccidente.profesional_id_profesional\r\n" + 
			"where fecha between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)\r\n" + 
			"group by profesional.id_profesional , profesional.nombre, profesional.apellido", nativeQuery=true)
	List<AccidentesPorMesP> getAccidentesPorMesP();
	
	
}
