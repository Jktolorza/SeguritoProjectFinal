package cl.awake.psegurito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.awake.psegurito.model.DetalleFactura;
import cl.awake.psegurito.model.Factura;
import cl.awake.psegurito.services.DetalleFacturaService;
import cl.awake.psegurito.services.FacturaService;


@Controller
public class DetalleFacturaController {
	
	@Autowired
    FacturaService fs;
	
	@Autowired
    DetalleFacturaService dfs;
    
    @RequestMapping("/listarDetalleFactura")
    public ModelAndView listarDetalleFactura() {
             List<DetalleFactura> lista = dfs.getAll();
            return new ModelAndView("listaDetalleFactura","lista", lista); 
            
    }
    @RequestMapping("/mostrarDetalleFactura/{id_factura}")
    public ModelAndView mostrarDetalleFactura(@PathVariable int id_factura) {
		List<DetalleFactura> df = dfs.findAllByIdFactura(id_factura);
		  Map<String, Object> model = new HashMap<String, Object>();
	        model.put("lista", df);
	        model.put("id_factura", id_factura);
        return new ModelAndView("muestraDetalleFactura","model", model);          
    }
    
    @RequestMapping("/editarDetalleFactura/{id}")
    public ModelAndView editarDetalleFactura(@PathVariable int id) {
    	DetalleFactura df = dfs.getById(id);
    	List<Factura> listaf = fs.getAll();
    	Map<String, Object> model = new HashMap<String, Object>();
        model.put("df", df);
        model.put("listaf", listaf);
        return new ModelAndView("editaDetalleFactura","model", model); 
    }
    
    @RequestMapping(value="/guardarEditDetalleFactura", method = RequestMethod.POST)
	public ModelAndView guardarEditDetalleFactura(DetalleFactura df, RedirectAttributes redirectAttrs) {
		dfs.edit(df);
		
		//modificar factura tb
		 Factura f = new Factura();
		f=fs.getById(df.getFactura().getId_factura());
		f.setItems(dfs.findAllByIdFactura(df.getFactura().getId_factura()));
		f.setImpuestos((int)f.calcularIVA());
    	f.setSubtotal((int)f.calcularSubtotal());
    	f.setTotal((int)f.calcularTotal());
    	fs.edit(f);
		
		
		redirectAttrs.addAttribute("id_factura", df.getFactura().getId_factura());
		return new ModelAndView("redirect:/mostrarDetalleFactura/{id_factura}.do");
	}
    
    @RequestMapping("/eliminarDetalleFactura/{id}/{id_factura}")
    public ModelAndView eliminarDetalleFactura(@PathVariable int id, @PathVariable int id_factura, RedirectAttributes redirectAttrs) {
    	dfs.delete(id);
    	
		//modificar factura tb
		 Factura f = new Factura();
		f=fs.getById(id_factura);
		f.setItems(dfs.findAllByIdFactura(id_factura));
		f.setImpuestos((int)f.calcularIVA());
     	f.setSubtotal((int)f.calcularSubtotal());
     	f.setTotal((int)f.calcularTotal());
     	fs.edit(f);
    	
    	redirectAttrs.addAttribute("id_factura", id_factura);
    	return new ModelAndView("redirect:/mostrarDetalleFactura/{id_factura}.do");
    }
    
    @RequestMapping("/crearDetalleFactura/{id_factura}")
    public ModelAndView crearDetalleFactura(@PathVariable int id_factura) {

    	DetalleFactura df = new DetalleFactura();
//    	List<Factura> listaf = fs.getAll();
    	
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("df", df);
        model.put("id_factura", id_factura);
        
        return new ModelAndView("creaDetalleFactura","model", model); 
        
    }
    
    @RequestMapping(value="/guardarDetalleFactura", method = RequestMethod.POST)
	public ModelAndView guardarDetalleFactura(DetalleFactura df, RedirectAttributes redirectAttrs) {
		dfs.add(df);
		
		//modificar factura tb
		 Factura f = new Factura();
		f=fs.getById(df.getFactura().getId_factura());
		f.setItems(dfs.findAllByIdFactura(df.getFactura().getId_factura()));
		f.setImpuestos((int)f.calcularIVA());
      	f.setSubtotal((int)f.calcularSubtotal());
      	f.setTotal((int)f.calcularTotal());
      	fs.edit(f);
      	
		redirectAttrs.addAttribute("id_factura", df.getFactura().getId_factura());
    	return new ModelAndView("redirect:/mostrarDetalleFactura/{id_factura}.do");
	}
}
