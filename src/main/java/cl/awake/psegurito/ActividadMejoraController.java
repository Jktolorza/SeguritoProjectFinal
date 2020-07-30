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

import cl.awake.psegurito.model.ActividadMejora;
import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.services.ActividadMejoraService;
import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.ProfesionalService;



@Controller
public class ActividadMejoraController {
	
	@Autowired
	ProfesionalService ps;
	
	@Autowired
    ClienteService cs;
	
	@Autowired
	ActividadMejoraService acs;
	
	
	@RequestMapping("/listarActividadMejora")
	public ModelAndView listarActividadMejora() {
		List<ActividadMejora> lista = acs.getAll();
		return new ModelAndView("listarActividadMejora","lista",lista);
	}
	
	@RequestMapping("/mostrarActividadMejora/{id}")
	public ModelAndView mostrarActividadMejora(@PathVariable int id) {
		ActividadMejora ac = acs.getById(id);
		return new ModelAndView("muestraActividadMejora","ac",ac);
	}
	
	@RequestMapping("/editarActividadMejora/{id}")
	public ModelAndView editarActividadMejora(@PathVariable int id) {
		ActividadMejora ac = acs.getById(id);
		List<Profesional> listap = ps.getAll();
    	List<Cliente> listac = cs.getAll();
    	Map<String, Object> model = new HashMap<String, Object>();
        model.put("ac", ac);
        model.put("listap", listap);
        model.put("listac", listac);
        return new ModelAndView("editaActividadMejora","model", model);
	}
	
	@RequestMapping(value ="/guardarEditActividadMejora", method = RequestMethod.POST)
	public ModelAndView guardarEditActividadMejora(ActividadMejora ac) {
		acs.edit(ac);
		return new ModelAndView("redirect:/listarActividadMejora");
	}
	
	@RequestMapping("/eliminarActividadMejora/{id}")
	public ModelAndView eliminarActividadMejora(@PathVariable int id) {
		acs.delete(id);
		return new ModelAndView("redirect:/listarActividadMejora");
	}
	
	@RequestMapping("/crearActividadMejora")
	public ModelAndView crearActividadMejora() {
		ActividadMejora ac = new ActividadMejora();
		List<Profesional> listap = ps.getAll();
    	List<Cliente> listac = cs.getAll();
    	
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ac", ac);
        model.put("listap", listap);
        model.put("listac", listac);
        
        return new ModelAndView("creaActividadMejora", "model", model);
	}
	
	@RequestMapping(value="/guardarActividadMejora", method = RequestMethod.POST)
	public ModelAndView guardarActividadMejora(ActividadMejora ac) {
		acs.add(ac);
		return new ModelAndView("redirect:/listarActividadMejora");
	}
	
}
