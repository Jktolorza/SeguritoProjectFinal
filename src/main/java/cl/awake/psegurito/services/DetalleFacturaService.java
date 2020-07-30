package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.DetalleFactura;

public interface DetalleFacturaService {
	 DetalleFactura getById(int id);
    List<DetalleFactura> getAll();
    void add(DetalleFactura df);
    void edit(DetalleFactura df);
    void delete(DetalleFactura df);
    void delete(int id);
   List<DetalleFactura> findAllByIdFactura(int id_factura);
}
