package cl.awake.psegurito.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccidentabilidadPorMesRepository extends CrudRepository<AccidentabilidadPorMes, Integer> {

	@Query(value="select profesional.id_profesional as id, profesional.nombre || ' ' || profesional.apellido as profesional, COALESCE(NULLIF(count(distinct reporteaccidente.id_reporteaccidente)/count(distinct capacitacion.id_capacitacion),0), 0) as indiceAccidentabilidad \r\n" + 
			"from reporteaccidente\r\n" + 
			"inner join cliente\r\n" + 
			"on cliente.id_cliente=reporteaccidente.cliente_id_cliente\r\n" + 
			"inner join profesional\r\n" + 
			"on reporteaccidente.profesional_id_profesional=profesional.id_profesional\r\n" + 
			"inner join capacitacion\r\n" + 
			"on capacitacion.profesional_id_profesional=profesional.id_profesional and capacitacion.cliente_id_cliente=cliente.id_cliente\r\n" + 
			"where reporteaccidente.fecha between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)\r\n" + 
			"and capacitacion.fechayhora between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)\r\n" + 
			"group by  profesional.id_profesional, profesional.nombre || ' ' || profesional.apellido", nativeQuery=true)
	List<AccidentabilidadPorMes> getAccidentabilidadPorMes();
	
}