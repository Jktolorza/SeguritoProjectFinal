package cl.awake.psegurito.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ActividadMejoraPorMesCRepository extends CrudRepository<ActividadMejoraPorMesC, Integer> {

	@Query(value="select cliente.id_cliente AS id, cliente.nombreEmpresa AS nombre, count(actividadmejora.id_actividadmejora) as actividadmejora\r\n" + 
			"from actividadmejora\r\n" + 
			"inner join cliente\r\n" + 
			"on cliente.id_cliente=actividadmejora.cliente_id_cliente\r\n" + 
			"where fechainicio between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)\r\n" + 
			"group by cliente.id_cliente, cliente.nombreEmpresa", nativeQuery = true)
			List<ActividadMejoraPorMesC>getActividadMejoraPorMesC();
	
}
