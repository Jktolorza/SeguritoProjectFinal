package cl.awake.psegurito;

import cl.awake.psegurito.model.ActividadMejora;
import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.services.ActividadMejoraService;
import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.ProfesionalService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador Actividad Mejora
 * 
 * @author Desarrolladores PSegurito
 */

@Controller
public class ActividadMejoraController {

    @Autowired
    ProfesionalService ps;

    @Autowired
    ClienteService cs;

    @Autowired
    ActividadMejoraService acs;

    /**
     * Muestra el listado de actividades según los permisos del
     * {@link Administrador} autenticado
     * 
     * @param acs injeccion de actividadMejoraService
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Mostrar lista de actividad mejoras
     * @see List
     */

    // Buscar informacion de actividades
    @RequestMapping("/listarActividadMejora")
    public ModelAndView listarActividadMejora() {
        // Crea una arreglo de actividad a mejorar y luego le injecto el crud acs con el
        // metodo obtener todo
        List<ActividadMejora> lista = acs.getAll();
        // Retorno la lista de actividades a mejorar
        return new ModelAndView("listarActividadesMejora", "lista", lista);
    }

    // Mostrar Actividades de mejora
    @RequestMapping("/mostrarActividadMejora/{id}")
    public ModelAndView mostrarActividadMejora(@PathVariable int id) {
        ActividadMejora ac = acs.getById(id);
        return new ModelAndView("muestraActividadesMejora", "ac", ac);
    }

    /**
     * Muestra el listado de actividades según los permisos del {@link Profesional}
     * autenticado
     * 
     * @param id     identificador numerico de {@link ActividadMejora}
     * 
     * @param ac     listado de actividades de mejora
     * 
     * @param listap Listado de {@link Profesionales}
     *
     * @param listac Listado de {@link Cliente}
     *
     * @see List
     * @see put
     * @see map
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Editar lista de mejoras
     */
    // Edita Actividades de mejora
    @RequestMapping("/editarActividadMejora/{id}")
    public ModelAndView editarActividadMejora(@PathVariable int id) {
        // creamos un objeto de actividad mejora
        ActividadMejora ac = acs.getById(id);
        // Listamos los datos de profesional y cliente para poder trabajar con ellos
        List<Profesional> listap = ps.getAll();
        List<Cliente> listac = cs.getAll();
        // Listamos ambas listas para modificar los datos
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ac", ac);
        model.put("listap", listap);
        model.put("listac", listac);
        // retornamos la respuesta de editar mejora
        return new ModelAndView("editaActividadMejora", "model", model);
    }

    // metodo guardar
    @RequestMapping(value = "/guardarEditActividadMejora", method = RequestMethod.POST)
    public ModelAndView guardarEditActividadMejora(ActividadMejora ac) {
        acs.edit(ac);
        return new ModelAndView("redirect:/listarActividadMejora");
    }

    // metodo Eliminar
    @RequestMapping("/eliminarActividadMejora/{id}")
    public ModelAndView eliminarActividadMejora(@PathVariable int id) {
        acs.delete(id);
        return new ModelAndView("redirect:/listarActividadMejora");
    }

    /**
     * Muestra el listado de actividades según los permisos del {@link Profesional}
     * autenticado
     *
     * @param ac     listado de actividades de mejora
     *
     * @param listap Listado de {@link Profesionales}
     *
     * @param listac Listado de {@link Cliente}
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud, Crear
     *         mejoras
     */

    // metodo Crear el formulario de activdad a mejorar
    @RequestMapping("/crearActividadMejora")
    public ModelAndView crearActividadMejora() {
        ActividadMejora ac = new ActividadMejora();
        List<Profesional> listap = ps.getAll();
        List<Cliente> listac = cs.getAll();

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ac", ac);
        model.put("listap", listap);
        model.put("listac", listac);

        return new ModelAndView("creaActividadMejora", "model", model);
    }

    // guardamos la respuesta del formulario
    @RequestMapping(value = "/guardarActividadMejora", method = RequestMethod.POST)
    public ModelAndView guardarActividadMejora(ActividadMejora ac) {
        acs.add(ac);
        return new ModelAndView("redirect:/listarActividadMejora");
    }

}
