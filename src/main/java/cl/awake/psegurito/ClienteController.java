package cl.awake.psegurito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.services.ClienteService;


@Controller
public class ClienteController {

        @Autowired
        ClienteService cs;
        
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
             return new ModelAndView("editaCliente","c", c);
        }
        
        @RequestMapping(value="/guardarEditCliente", method = RequestMethod.POST)
    	public ModelAndView guardarEditCliente(Cliente c) {
    		cs.edit(c);
    		return new ModelAndView("redirect:/listarCliente");
    	}
        
        @RequestMapping("/eliminarCliente/{id}")
        public ModelAndView eliminarCliente(@PathVariable int id) {
        	cs.delete(id);
        	return new ModelAndView("redirect:/listarCliente");
        }
        
        @RequestMapping("/crearCliente")
        public ModelAndView crearCliente() {
        	 Cliente c = new Cliente();
        	 return new ModelAndView("creaCliente","c", c);
        }
        
        @RequestMapping(value="/guardarCliente", method = RequestMethod.POST)
    	public ModelAndView guardarCliente(Cliente c) { 
    		cs.add(c);
    		return new ModelAndView("redirect:/listarCliente");
    	}
}