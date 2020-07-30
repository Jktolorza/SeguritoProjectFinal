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

import cl.awake.psegurito.model.Asesoria;
import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.services.AsesoriaService;
import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.ProfesionalService;



@Controller
public class AsesoriaController {
	
	@Autowired
    ClienteService cs;
	
	 @Autowired
     ProfesionalService ps;
	
	@Autowired
    AsesoriaService ass;
    
    @RequestMapping("/listarAsesoria")
    public ModelAndView listarAsesoria() {
            List<Asesoria> lista = ass.getAll();
            return new ModelAndView("listarAsesoria","lista", lista); 
            
    }
    @RequestMapping("/mostrarAsesoria/{id}")
    public ModelAndView mostrarAsesoria(@PathVariable int id) {
    		Asesoria as = ass.getById(id);
            return new ModelAndView("muestraAsesoria","as", as);
            
    }
    
    @RequestMapping("/editarAsesoria/{id}")
    public ModelAndView editarAsesoria(@PathVariable int id) {
    	Asesoria as = ass.getById(id);
    	List<Profesional> listap = ps.getAll();
    	List<Cliente> listac = cs.getAll();
    	Map<String, Object> model = new HashMap<String, Object>();
        model.put("as", as);
        model.put("listap", listap);
        model.put("listac", listac);
        return new ModelAndView("editaAsesoria","model", model); 
    }
    
    @RequestMapping(value="/guardarEditAsesoria", method = RequestMethod.POST)
	public ModelAndView guardarEditAsesoria(Asesoria as) {
		ass.edit(as);
		return new ModelAndView("redirect:/listarAsesoria");
	}
    
    @RequestMapping("/eliminarAsesoria/{id}")
    public ModelAndView eliminarAsesoria(@PathVariable int id) {
    	ass.delete(id);
    	return new ModelAndView("redirect:/listarAsesoria");
    }
    
    @RequestMapping("/crearAsesoria")
    public ModelAndView crearAsesoria() {

    	Asesoria as = new Asesoria();
    	List<Profesional> listap = ps.getAll();
    	List<Cliente> listac = cs.getAll();
    	
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("as", as);
        model.put("listap", listap);
        model.put("listac", listac);
        
        return new ModelAndView("creaAsesoria","model", model); 
        
    }
    
    @RequestMapping(value="/guardarAsesoria", method = RequestMethod.POST)
	public ModelAndView guardarAsesoria(Asesoria as) {
		ass.add(as);
		return new ModelAndView("redirect:/listarAsesoria");
	}
}
