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
import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.model.Visita;
import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.ProfesionalService;
import cl.awake.psegurito.services.VisitaService;

/**
 * Controlador Visita
 * 
 * @author Desarrolladores PSegurito
 */
@Controller
public class VisitaController {

    @Autowired
    ClienteService cs;

    @Autowired
    ProfesionalService ps;

    @Autowired
    VisitaService vs;

    /**
     * Muestra el listado de visitas según los permisos del {@link Profesional}
     * autenticado
     * 
     * @param vs injeccion de VisitaService
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Mostrar lista de visitas
     * @see List
     */

    @RequestMapping("/listarVisita")
    public ModelAndView listarVisita() {
        List<Visita> lista = vs.getAll();
        return new ModelAndView("listarVisita", "lista", lista);

    }

    @RequestMapping("/mostrarVisita/{id}")
    public ModelAndView mostrarVisita(@PathVariable int id) {
        Visita vis = vs.getById(id);
        return new ModelAndView("muestraVisita", "vis", vis);

    }

    /**
     * Muestra el listado de visitas según los permisos del {@link Profesional}
     * autenticado
     * 
     * @param id     identificador numerico de {@link visita}
     * 
     * @param vis    listado de visitas
     * 
     * @param listap Listado de {@link Profesionales}
     *
     * @param listac Listado de {@link Cliente}
     *
     * @see List
     * @see put
     * @see map
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Editar visitas
     */

    @RequestMapping("/editarVisita/{id}")
    public ModelAndView editarVisita(@PathVariable int id) {
        Visita vis = vs.getById(id);
        List<Profesional> listap = ps.getAll();
        List<Cliente> listac = cs.getAll();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("vis", vis);
        model.put("listap", listap);
        model.put("listac", listac);
        return new ModelAndView("editaVisita", "model", model);
    }

    @RequestMapping(value = "/guardarEditVisita", method = RequestMethod.POST)
    public ModelAndView guardarEditVisita(Visita vis) {
        vs.edit(vis);
        return new ModelAndView("redirect:/listarVisita");
    }

    @RequestMapping("/eliminarVisita/{id}")
    public ModelAndView eliminarVisita(@PathVariable int id) {
        vs.delete(id);
        return new ModelAndView("redirect:/listarVisita");
    }

    /**
     * Muestra el listado de visitas según los permisos del {@link Profesional}
     * autenticado
     *
     * @param vis    listado de visitas
     *
     * @param listap Listado de {@link Profesionales}
     *
     * @param listac Listado de {@link Cliente}
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud, Crear
     *         visitas
     */

    @RequestMapping("/crearVisita")
    public ModelAndView crearVisita() {

        Visita vis = new Visita();
        List<Profesional> listap = ps.getAll();
        List<Cliente> listac = cs.getAll();

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("vis", vis);
        model.put("listap", listap);
        model.put("listac", listac);

        return new ModelAndView("creaVisita", "model", model);

    }

    @RequestMapping(value = "/guardarVisita", method = RequestMethod.POST)
    public ModelAndView guardarVisita(Visita vis) {
        vs.add(vis);
        return new ModelAndView("redirect:/listarVisita");
    }
}
