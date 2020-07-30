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

import cl.awake.psegurito.model.Checklist;
import cl.awake.psegurito.model.DetalleChecklist;
import cl.awake.psegurito.services.ChecklistService;
import cl.awake.psegurito.services.DetalleChecklistService;

@Controller
public class DetalleChecklistController {

	@Autowired
	ChecklistService chs;
	
	@Autowired
	DetalleChecklistService dchs;
	
	
	@RequestMapping("/listarDetalleChecklist")
	public ModelAndView listarDetalleChecklist() {
		List<DetalleChecklist> lista = dchs.getAll();
		return new ModelAndView("listarDetalleChecklist","lista",lista);
	}
	
	
	@RequestMapping("/mostrarDetalleChecklist/{id_checklist}")
	public ModelAndView mostrarDetalleChecklist(@PathVariable int id_checklist) {
		List<DetalleChecklist> dch = dchs.findAllByIdChecklist(id_checklist);
		 Map<String, Object> model = new HashMap<String, Object>();
	        model.put("lista", dch);
	        model.put("id_checklist", id_checklist);
     return new ModelAndView("muestraDetalleChecklist","model", model);  
	}
	
	 @RequestMapping("/editarDetalleChecklist/{id}")
	    public ModelAndView editarDetalleChecklist(@PathVariable int id) {
	    	DetalleChecklist dch = dchs.getById(id);
	    	List<Checklist> listach = chs.getAll();
	    	Map<String, Object> model = new HashMap<String, Object>();
	        model.put("dch", dch);
	        model.put("listach", listach);
	        return new ModelAndView("editaDetalleChecklist","model", model); 
	    }
	
	  @RequestMapping(value="/guardarEditDetalleChecklist", method = RequestMethod.POST)
		public ModelAndView guardarEditDetalleChecklist(DetalleChecklist dch, RedirectAttributes redirectAttrs) {
			dchs.edit(dch);
			
			//modificar factura tb
			Checklist ch = new Checklist();
			ch=chs.getById(dch.getChecklist().getId_checklist());
			ch.setItems(dchs.findAllByIdChecklist(dch.getChecklist().getId_checklist()));
	    	chs.edit(ch);
			
			
			redirectAttrs.addAttribute("id_checklist", dch.getChecklist().getId_checklist());
			return new ModelAndView("redirect:/mostrarDetalleChecklist/{id_checklist}.do");
		}
	  
	  
	  @RequestMapping("/eliminarDetalleChecklist/{id}/{id_checklist}")
	    public ModelAndView eliminarDetalleChecklist(@PathVariable int id, @PathVariable int id_checklist, RedirectAttributes redirectAttrs) {
	    	dchs.delete(id);
	    	
			//modificar factura tb
	    	Checklist ch = new Checklist();
			ch=chs.getById(id_checklist);
			ch.setItems(dchs.findAllByIdChecklist(id_checklist));
	     	chs.edit(ch);
	    	
	    	redirectAttrs.addAttribute("id_checklist", id_checklist);
	    	return new ModelAndView("redirect:/mostrarDetalleChecklist/{id_checklist}.do");
	    }
	
	  @RequestMapping("/crearDetalleChecklist/{id_checklist}")
	    public ModelAndView crearDetalleChecklist(@PathVariable int id_checklist) {

	    	DetalleChecklist dch = new DetalleChecklist();
	    	
	        Map<String, Object> model = new HashMap<String, Object>();
	        model.put("dch", dch);
	        model.put("id_checklist", id_checklist);
	        
	        return new ModelAndView("creaDetalleChecklist","model", model); 
	        
	    }
	
	   @RequestMapping(value="/guardarDetalleChecklist", method = RequestMethod.POST)
		public ModelAndView guardarDetalleChecklist(DetalleChecklist dch, RedirectAttributes redirectAttrs) {
			dchs.add(dch);
			
			//modificar factura tb
			Checklist ch = new Checklist();
			ch=chs.getById(dch.getChecklist().getId_checklist());
			ch.setItems(dchs.findAllByIdChecklist(dch.getChecklist().getId_checklist()));
	      	chs.edit(ch);
	      	
			redirectAttrs.addAttribute("id_checklist", dch.getChecklist().getId_checklist());
	    	return new ModelAndView("redirect:/mostrarDetalleChecklist/{id_checklist}.do");
		}
	
	  
}
