package cl.awake.psegurito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
//    	Usuario u = us.getByNickname(p.getUsuario().getNickname());
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("p", p);
//        model.put("u", u);
        return new ModelAndView("editaProfesional","model", model);
    }
    
    @RequestMapping(value="/guardarEditProfesional", method = RequestMethod.POST)
 	public ModelAndView guardarEditProfesional(Profesional p) {
//    	p.setUsuario(u);
 		ps.edit(p);
     	//Usuario u = us.getByNickname(p.getUsuario().getNickname());
 		
// 		us.editUserByIdAndNickname(u.getNickname(), u.getPassword(), u.getRol(), u.getId_usuario());
 		return new ModelAndView("redirect:/listarProfesional");
 	}
     
    @RequestMapping("/eliminarProfesional/{id}")
    public ModelAndView eliminarProfesional(@PathVariable int id) {
    	Profesional p = ps.getById(id);
    	Usuario u= us.getByNickname(p.getUsuario().getNickname());
    	ps.delete(id);
    	us.delete(u);
    	return new ModelAndView("redirect:/listarProfesional");
    }
    
    @RequestMapping("/crearProfesional/{message}")
    public ModelAndView crearProfesional(@PathVariable String message) {
    	Profesional p = new Profesional();
    	Usuario u = new Usuario();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("p", p);
        model.put("u", u);
        model.put("message", message);
    	return new ModelAndView("creaProfesional","model", model);
    }
    
    @RequestMapping(value="/guardarProfesional", method = RequestMethod.POST)
	public ModelAndView guardarProfesional(Profesional p, Usuario u, RedirectAttributes redirectAttrs) { 
		// validar si el nuevo nick no esta duplicado
		if (us.countByNickname(u.getNickname()) == 0) {
			

 		//encriptando el nuevo password
    	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
    	String password = u.getPassword();
    	u.setPassword(passwordEncoder.encode(password));
    	
    	us.add(u);
    	Usuario u1 = us.getByNickname(u.getNickname());
    	p.setUsuario(u1);
    	//System.out.println(p.toString());
    	ps.add(p);
		return new ModelAndView("redirect:/listarProfesional");
		} else {
			String mensaje = "el nickname ya existe en la base de datos";
			redirectAttrs.addAttribute("message", mensaje);
			return new ModelAndView("redirect:/crearProfesional/{message}.do");
		}
	}
}