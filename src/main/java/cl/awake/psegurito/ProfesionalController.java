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

import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.model.Usuario;
import cl.awake.psegurito.services.ProfesionalService;
import cl.awake.psegurito.services.UsuarioService;

@Controller
public class ProfesionalController {
	
	@Autowired
	ProfesionalService ps;
	
	@Autowired
	UsuarioService us;
	
	@RequestMapping("/listarProfesional")
	public ModelAndView listarProfesional() {
		List<Profesional> lista = ps.getAll();
		return new ModelAndView("listaProfesional", "lista", lista);
	}
	
    @RequestMapping("/mostrarProfesional/{id}")
    public ModelAndView mostrarProfesional(@PathVariable int id) {
    	Profesional p = ps.getById(id);
    	return new ModelAndView("muestraProfesional", "p", p);
    }
    
    @RequestMapping("/editarProfesional/{id}")
    public ModelAndView editarProfesional(@PathVariable int id) {
    	 Profesional p = ps.getById(id);
    	 Usuario u = us.getByNickname(p.getUsuario().getNickname());
         Map<String, Object> model = new HashMap<String, Object>();
         model.put("p", p);
         model.put("u", u);
         return new ModelAndView("editaProfesional","model", model);
    }
    
    @RequestMapping(value="/guardarEditProfesional", method = RequestMethod.POST)
 	public ModelAndView guardarEditProfesional(Profesional p) {
 		ps.edit(p);
     	Usuario u = us.getByNickname(p.getUsuario().getNickname());
 		return new ModelAndView("redirect:/listaProfesional");
 	}
     
    @RequestMapping("/eliminarProfesional/{id}")
    public ModelAndView eliminarProfesional(@PathVariable int id) {
    	Profesional p = ps.getById(id);
    	Usuario u= us.getByNickname(p.getUsuario().getNickname());
    	ps.delete(id);
    	us.delete(u);
    	return new ModelAndView("redirect:/listaProfesional");
    }
    
    @RequestMapping("/crearProfesional")
    public ModelAndView crearProfesional() {
    	 Profesional p = new Profesional();
    	 Usuario u = new Usuario();
         Map<String, Object> model = new HashMap<String, Object>();
         model.put("p", p);
         model.put("u", u);
    	 return new ModelAndView("creaProfesional","model", model);
    }
    
    @RequestMapping(value="/guardarProfesional", method = RequestMethod.POST)
	public ModelAndView guardarProfesional(Profesional p, Usuario u) { 
    	ps.add(p);
    	us.add(u);
		return new ModelAndView("redirect:/listaProfesional");
	}
}
