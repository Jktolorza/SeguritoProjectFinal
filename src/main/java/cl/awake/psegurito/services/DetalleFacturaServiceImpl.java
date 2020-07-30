package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.DetalleFactura;
import cl.awake.psegurito.model.DetalleFacturaRepository;


@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {
	 @Autowired
     DetalleFacturaRepository dfr;
	 
	@Override
	public DetalleFactura getById(int id) {
		// TODO Auto-generated method stub
		return dfr.findOne(id);
	}

	@Override
	public List<DetalleFactura> getAll() {
		// TODO Auto-generated method stub
		return (List<DetalleFactura>) dfr.findAll();
	}

	@Override
	public void add(DetalleFactura df) {
		// TODO Auto-generated method stub
		dfr.save(df);
	}

	@Override
	public void edit(DetalleFactura df) {
		// TODO Auto-generated method stub
		dfr.save(df);
	}

	@Override
	public void delete(DetalleFactura df) {
		// TODO Auto-generated method stub
		dfr.delete(df);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dfr.delete(id);
	}

	@Override
	public List<DetalleFactura> findAllByIdFactura(int id_factura) {
		// TODO Auto-generated method stub
		return dfr.findByIdFactura(id_factura);
	}
	
	

}
