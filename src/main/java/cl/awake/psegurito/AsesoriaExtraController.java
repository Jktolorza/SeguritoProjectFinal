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


import cl.awake.psegurito.model.AsesoriaExtra;
import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.services.AsesoriaExtraService;
import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.ProfesionalService;

@Controller
public class AsesoriaExtraController {
	
	@Autowired
    ClienteService cs;
	
	@Autowired
	AsesoriaExtraService asex; 
	
	 @Autowired
    ProfesionalService ps;

    @RequestMapping("/listarAsesoriaExtra")
    public ModelAndView listarAsesoriaExtra() {
            List<AsesoriaExtra> lista = asex.getAll();
            return new ModelAndView("listarAsesoriaExtra","lista", lista); 
            
    }
    @RequestMapping("/mostrarAsesoriaExtra/{id}")
    public ModelAndView mostrarAsesoriaExtra(@PathVariable int id) {
    	AsesoriaExtra ase = asex.getById(id);
            return new ModelAndView("muestraAsesoriaExtra","ase", ase);
            
    }
    
    @RequestMapping("/editarAsesoriaExtra/{id}")
    public ModelAndView editarAsesoriaExtra(@PathVariable int id) {
    	AsesoriaExtra ase = asex.getById(id); 
    	List<Profesional> listap = ps.getAll();
    	List<Cliente> listac = cs.getAll();
    	Map<String, Object> model = new HashMap<String, Object>();
        model.put("ase", ase);   
        model.put("listap", listap);
        model.put("listac", listac);
        return new ModelAndView("editaAsesoriaExtra","model", model); 
    }
    
    @RequestMapping(value="/guardarEditAsesoriaExtra", method = RequestMethod.POST)
	public ModelAndView guardarEditAsesoriaExtra(AsesoriaExtra ase) {
		asex.edit(ase);
		return new ModelAndView("redirect:/listarAsesoriaExtra");
	}
    
    @RequestMapping("/eliminarAsesoriaExtra/{id}")
    public ModelAndView eliminarAsesoriaExtra(@PathVariable int id) {
    	asex.delete(id);
    	return new ModelAndView("redirect:/listarAsesoriaExtra");
    }
    
    @RequestMapping("/crearAsesoriaExtra")
    public ModelAndView crearAsesoriaExtra() {

    	AsesoriaExtra ase = new AsesoriaExtra();    	
    	List<Cliente> listac = cs.getAll();
    	List<Profesional> listap = ps.getAll();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ase", ase);
        model.put("listap", listap);
        model.put("listac", listac);
        
        return new ModelAndView("creaAsesoriaExtra","model", model); 
        
    }
    
    @RequestMapping(value="/guardarAsesoriaExtra", method = RequestMethod.POST)
	public ModelAndView guardarAsesoriaExtra(AsesoriaExtra ase) {
		asex.add(ase);
		return new ModelAndView("redirect:/listarAsesoriaExtra");
	}
}
