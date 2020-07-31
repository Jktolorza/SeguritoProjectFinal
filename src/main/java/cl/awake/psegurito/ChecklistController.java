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

import cl.awake.psegurito.model.Checklist;
import cl.awake.psegurito.model.Visita;
import cl.awake.psegurito.services.ChecklistService;
import cl.awake.psegurito.services.VisitaService;

@Controller
public class ChecklistController {

	@Autowired
	VisitaService vs;
	
	@Autowired
	ChecklistService chs;
	
	
	@RequestMapping("/listarChecklist")
	public ModelAndView listarChecklist() {
		List<Checklist> lista = chs.getAll();
		//System.out.println(lista.get(0).toString());
		return new ModelAndView("listaChecklist","lista",lista);
	}
	
	@RequestMapping("/mostrarChecklist/{id}")
	public ModelAndView mostrarChecklist(@PathVariable int id) {
		Checklist ch = chs.getById(id);
		return new ModelAndView("muestraChecklist", "ch",ch);
	}
	
	@RequestMapping("/editarChecklist/{id}")
	public ModelAndView editarChecklist(@PathVariable int id) {
		Checklist ch = chs.getById(id);
		List<Visita> listav = vs.getAll();
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("ch", ch);
        model.put("listav", listav);
        return new ModelAndView("editaChecklist","model", model); 
	}
	
	@RequestMapping(value = "/guardarEditChecklist", method = RequestMethod.POST)
	public ModelAndView guardarEditChecklist(Checklist ch) {
		chs.edit(ch);
		return new ModelAndView("redirect:/listarChecklist");
	}
	
	@RequestMapping("/elimarChecklist/{id}")
	public ModelAndView eliminarChecklist(@PathVariable int id) {
		chs.delete(id);
		return new ModelAndView("redirect:/listarChecklist");
	}
	
	@RequestMapping("/crearChecklist")
	public ModelAndView crearChecklist() {
		Checklist ch = new Checklist();
		List<Visita> listav = vs.getAll();
		
		 Map<String, Object> model = new HashMap<String, Object>();
	     model.put("ch", ch);
	     model.put("listav", listav);    
	     return new ModelAndView("creaChecklist","model", model); 
	}
	
	@RequestMapping(value = "/guardarChecklist", method = RequestMethod.POST)
	public ModelAndView guardarChecklist(Checklist ch) {
		chs.add(ch);
		return new ModelAndView("redirect:/listarChecklist");
	}
	
	
}
