package cl.awake.psegurito.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer>{
	 @Query(value="Select * from detallefactura df where df.factura_id_factura=?1", nativeQuery=true)
	 List<DetalleFactura> findByIdFactura(int factura_id_factura);

}
