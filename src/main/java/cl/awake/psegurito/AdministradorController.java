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

import cl.awake.psegurito.model.Administrador;
import cl.awake.psegurito.model.Usuario;
import cl.awake.psegurito.services.AdministradorService;
import cl.awake.psegurito.services.UsuarioService;

@Controller
public class AdministradorController {

	@Autowired
	AdministradorService as;

	@Autowired
	UsuarioService us;

	@RequestMapping("/listarAdministrador")
	public ModelAndView listarAdministrador() {
		List<Administrador> lista = as.getAll();
		return new ModelAndView("listaAdministrador", "lista", lista);
	}

	@RequestMapping("/mostrarAdministrador/{id}")
	public ModelAndView mostrarAdministrador(@PathVariable int id) {
		Administrador a = as.getById(id);
		return new ModelAndView("muestraAdministrador", "a", a);
	}

	@RequestMapping("/editarAdministrador/{id}")
	public ModelAndView editarAdministrador(@PathVariable int id) {
		Administrador a = as.getById(id);
//    	Usuario u = us.getByNickname(p.getUsuario().getNickname());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("a", a);
//        model.put("u", u);
		return new ModelAndView("editaAdministrador", "model", model);
	}

	@RequestMapping(value = "/guardarEditAdministrador", method = RequestMethod.POST)
	public ModelAndView guardarEditAdministrador(Administrador a) {
//    	p.setUsuario(u);
		as.edit(a);
		// Usuario u = us.getByNickname(p.getUsuario().getNickname());

// 		us.editUserByIdAndNickname(u.getNickname(), u.getPassword(), u.getRol(), u.getId_usuario());
		return new ModelAndView("redirect:/listarAdministrador");
	}

	@RequestMapping("/eliminarAdministrador/{id}")
	public ModelAndView eliminarAdministrador(@PathVariable int id) {
		Administrador a = as.getById(id);
		Usuario u = us.getByNickname(a.getUsuario().getNickname());
		as.delete(id);
		us.delete(u);
		return new ModelAndView("redirect:/listarAdministrador");
	}

	@RequestMapping("/crearAdministrador/{message}")
	public ModelAndView crearAdministrador(@PathVariable String message) {
		Administrador a = new Administrador();
		Usuario u = new Usuario();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("a", a);
		model.put("u", u);
		model.put("message", message);
		return new ModelAndView("creaAdministrador", "model", model);
	}

	@RequestMapping(value = "/guardarAdministrador", method = RequestMethod.POST)
	public ModelAndView guardarAdministrador(Administrador a, Usuario u, RedirectAttributes redirectAttrs) {
		// validar si el nuevo nick no esta duplicado
		if (us.countByNickname(u.getNickname()) == 0) {

			// encriptando el nuevo password
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String password = u.getPassword();
			u.setPassword(passwordEncoder.encode(password));

			us.add(u);
			Usuario u1 = us.getByNickname(u.getNickname());
			a.setUsuario(u1);
			// System.out.println(p.toString());
			as.add(a);
			return new ModelAndView("redirect:/listarAdministrador");
		} else {
			String mensaje = "el nickname ya existe en la base de datos";
			redirectAttrs.addAttribute("message", mensaje);
			return new ModelAndView("redirect:/crearAdministrador/{message}.do");
		}
	}
}