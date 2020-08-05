package cl.awake.psegurito.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MorosoRepository  extends CrudRepository<Moroso, Integer> {
	@Query(value="select cliente.id_cliente AS id, cliente.nombreEmpresa AS nombre, factura.fechavencimiento AS fechaVencimiento from factura\r\n" + 
			"inner join cliente\r\n" + 
			"on cliente.id_cliente = factura.cliente_id_cliente\r\n" + 
			"where  sysdate > fechavencimiento\r\n" + 
			"and extract(month from fechavencimiento) =(select to_char(sysdate,'mm') from dual)", nativeQuery=true)
	List<Moroso> getMoroso();

}
