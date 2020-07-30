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

import cl.awake.psegurito.model.Capacitacion;
import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.services.CapacitacionService;
import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.ProfesionalService;



@Controller
public class CapacitacionController {
        
        @Autowired
    ClienteService cs;
        
         @Autowired
     ProfesionalService ps;
        
        @Autowired
    CapacitacionService caps;
    
    @RequestMapping("/listarCapacitacion")
    public ModelAndView listarCapacitacion() {
            List<Capacitacion> lista = caps.getAll();
            return new ModelAndView("listarCapacitacion","lista", lista); 
            
    }
    @RequestMapping("/mostrarCapacitacion/{id}")
    public ModelAndView mostrarCapacitacion(@PathVariable int id) {
                Capacitacion cap = caps.getById(id);
            return new ModelAndView("muestraCapacitacion","cap", cap);
            
    }
    
    @RequestMapping("/editarCapacitacion/{id}")
    public ModelAndView editarCapacitacion(@PathVariable int id) {
        Capacitacion cap = caps.getById(id);
        List<Profesional> listap = ps.getAll();
        List<Cliente> listac = cs.getAll();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("cap", cap);
        model.put("listap", listap);
        model.put("listac", listac);
        return new ModelAndView("editaCapacitacion","model", model); 
    }
    
    @RequestMapping(value="/guardarEditCapacitacion", method = RequestMethod.POST)
        public ModelAndView guardarEditCapacitacion(Capacitacion cap) {
                caps.edit(cap);
                return new ModelAndView("redirect:/listarCapacitacion");
        }
    
    @RequestMapping("/eliminarCapacitacion/{id}")
    public ModelAndView eliminarCapacitacion(@PathVariable int id) {
        caps.delete(id);
        return new ModelAndView("redirect:/listarCapacitacion");
    }
    
    @RequestMapping("/crearCapacitacion")
    public ModelAndView crearCapacitacion() {

        Capacitacion cap = new Capacitacion();
        List<Profesional> listap = ps.getAll();
        List<Cliente> listac = cs.getAll();
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("cap", cap);
        model.put("listap", listap);
        model.put("listac", listac);
        
        return new ModelAndView("creaCapacitacion","model", model); 
        
    }
    
    @RequestMapping(value="/guardarCapacitacion", method = RequestMethod.POST)
        public ModelAndView guardarCapacitacion(Capacitacion cap) {
                caps.add(cap);
                return new ModelAndView("redirect:/listarCapacitacion");
        }
}

