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

import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.ProfesionalService;
import cl.awake.psegurito.services.ReporteAccidenteService;
import cl.awake.psegurito.model.ActividadMejora;
import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.model.ReporteAccidente;

/**
 * Controlador Reporte Accidente
 * 
 * @author Desarrolladores PSegurito
 */
@Controller
public class ReporteAccidenteController {

    @Autowired
    ClienteService cs;

    @Autowired
    ReporteAccidenteService reps;

    @Autowired
    ProfesionalService ps;

    /**
     * Muestra el listado de actividades reportes según los permisos del
     * {@link Profesional} autenticado
     * 
     * @param reps injeccion de ReporteAccidenteService
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Mostrar lista de reporte accidentes
     * @see List
     */

    @RequestMapping("/listarReporteAccidente")
    public ModelAndView listarReporteAccidente() {
        List<ReporteAccidente> lista = reps.getAll();
        return new ModelAndView("listarReporteAccidente", "lista", lista);
    }

    @RequestMapping("/mostrarReporteAccidente/{id}")
    public ModelAndView mostrarReporteAccidente(@PathVariable int id) {
        ReporteAccidente rep = reps.getById(id);
        return new ModelAndView("muestraReporteAccidente", "rep", rep);
    }

    /**
     * Muestra el listado de actividades según los permisos del {@link Profesional}
     * autenticado
     * 
     * @param id     identificador numerico de {@link ActividadMejora}
     * 
     * @param rep    listado de reporte accidente
     * 
     * @param listap Listado de {@link Profesionales}
     *
     * @param listac Listado de {@link Cliente}
     *
     * @see List
     * @see put
     * @see map
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Editar lista de reporte accidente
     */
    @RequestMapping("/editarReporteAccidente/{id}")
    public ModelAndView editarReporteAccidente(@PathVariable int id) {
        ReporteAccidente rep = reps.getById(id);
        List<Cliente> listac = cs.getAll();
        List<Profesional> listap = ps.getAll();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("rep", rep);
        model.put("listap", listap);
        model.put("listac", listac);
        return new ModelAndView("editaReporteAccidente", "model", model);
    }

    @RequestMapping(value = "/guardarEditReporteAccidente", method = RequestMethod.POST)
    public ModelAndView guardarEditReporteAccidente(ReporteAccidente rep) {
        reps.edit(rep);
        return new ModelAndView("redirect:/listarReporteAccidente");
    }

    @RequestMapping("/eliminarReporteAccidente/{id}")
    public ModelAndView eliminarReporteAccidente(@PathVariable int id) {
        reps.delete(id);
        return new ModelAndView("redirect:/listarReporteAccidente");
    }

    /**
     * Muestra el listado de reportes según los permisos del {@link Profesional}
     * autenticado
     *
     * @param rep    listado de reporte accidentes
     *
     * @param listap Listado de {@link Profesionales}
     *
     * @param listac Listado de {@link Cliente}
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud, Crear
     *         reporte accidente
     */

    @RequestMapping("/crearReporteAccidente")
    public ModelAndView crearReporteAccidente() {
        ReporteAccidente rep = new ReporteAccidente();
        List<Cliente> listac = cs.getAll();
        List<Profesional> listap = ps.getAll();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("rep", rep);
        model.put("listap", listap);
        model.put("listac", listac);
        return new ModelAndView("creaReporteAccidente", "model", model);

    }

    @RequestMapping(value = "/guardarReporteAccidente", method = RequestMethod.POST)
    public ModelAndView guardarReporteAccidente(ReporteAccidente rep) {
        reps.add(rep);
        return new ModelAndView("redirect:/listarReporteAccidente");
    }

}
