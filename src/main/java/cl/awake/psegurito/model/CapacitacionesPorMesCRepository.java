package cl.awake.psegurito.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CapacitacionesPorMesCRepository extends CrudRepository<CapacitacionesPorMesC, Integer> {	
	
	@Query(value="select cliente.id_cliente AS id, cliente.nombreEmpresa AS nombre, count(capacitacion.id_capacitacion) as capacitaciones\r\n" + 
			"from capacitacion\r\n" + 
			"inner join cliente\r\n" + 
			"on cliente.id_cliente=capacitacion.cliente_id_cliente\r\n" + 
			"where fechayhora between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)\r\n" + 
			"group by cliente.id_cliente, cliente.nombreEmpresa", nativeQuery=true)
	List<CapacitacionesPorMesC>getCapacitacionesPorMesC();  
}
