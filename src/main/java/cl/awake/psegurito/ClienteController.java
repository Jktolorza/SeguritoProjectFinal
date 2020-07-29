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

import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.model.Usuario;
import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.UsuarioService;


@Controller
public class ClienteController {

        @Autowired
        ClienteService cs;
        
        @Autowired
        UsuarioService us;
        
        @RequestMapping("/listarCliente")
        public ModelAndView listarCliente() {
                List<Cliente> lista = cs.getAll();
                
                return new ModelAndView("listaCliente","lista", lista); 
                
        }
        @RequestMapping("/mostrarCliente/{id}")
        public ModelAndView mostrarCliente(@PathVariable int id) {
                Cliente c = cs.getById(id);
                return new ModelAndView("muestraCliente","c", c);
                
        }
        
        @RequestMapping("/editarCliente/{id}")
        public ModelAndView editarCliente(@PathVariable int id) {
        	 Cliente c = cs.getById(id);
        	 Usuario u = us.getByNickname(c.getUsuario().getNickname());
        	 
             Map<String, Object> model = new HashMap<String, Object>();
             model.put("c", c);
             model.put("u", u);
        	 
             return new ModelAndView("editaCliente","model", model);
        }
        
        @RequestMapping(value="/guardarEditCliente", method = RequestMethod.POST)
    	public ModelAndView guardarEditCliente(Cliente c) {
    		cs.edit(c);
        	Usuario u= us.getByNickname(c.getUsuario().getNickname());

    		return new ModelAndView("redirect:/listarCliente");
    	}
        
        @RequestMapping("/eliminarCliente/{id}")
        public ModelAndView eliminarCliente(@PathVariable int id) {
        	Cliente c = cs.getById(id);
        	Usuario u= us.getByNickname(c.getUsuario().getNickname());
        	cs.delete(id);
        	us.delete(u);
        	return new ModelAndView("redirect:/listarCliente");
        }
        
        @RequestMapping("/crearCliente")
        public ModelAndView crearCliente() {
        	 Cliente c = new Cliente();
        	 Usuario u = new Usuario();
        	 
             Map<String, Object> model = new HashMap<String, Object>();
             model.put("c", c);
             model.put("u", u);
        	 return new ModelAndView("creaCliente","model", model);
        }
        
        @RequestMapping(value="/guardarCliente", method = RequestMethod.POST)
    	public ModelAndView guardarCliente(Cliente c, Usuario u) { 
        	us.add(u);
        	cs.add(c);
    		return new ModelAndView("redirect:/listarCliente");
    	}
}