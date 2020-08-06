package cl.awake.psegurito.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AsesoriaPorMesPRepository extends CrudRepository<AsesoriaPorMesP, Integer>{
	
	@Query(value="select profesional.id_profesional AS id, profesional.nombre || ' ' || profesional.apellido AS nombre, count(asesoria.id_asesoria) as asesorias\r\n" + 
			"from asesoria\r\n" + 
			"inner join profesional\r\n" + 
			"on profesional.id_profesional=asesoria.profesional_id_profesional\r\n" + 
			"where fechayhora between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)\r\n" + 
			"group by profesional.id_profesional , profesional.nombre, profesional.apellido", nativeQuery = true)
	List<AsesoriaPorMesP>getAsesoriaPorMesP();

}
