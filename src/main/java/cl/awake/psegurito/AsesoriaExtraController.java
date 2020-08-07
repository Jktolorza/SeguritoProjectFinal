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

import cl.awake.psegurito.model.AsesoriaExtra;
import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.services.AsesoriaExtraService;
import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.ProfesionalService;

/**
 * Controlador Asesoria Extra
 * 
 * @author Desarrolladores PSegurito
 */
@Controller
public class AsesoriaExtraController {

    @Autowired
    ClienteService cs;

    @Autowired
    AsesoriaExtraService asex;

    @Autowired
    ProfesionalService ps;

    /**
     * Muestra el listado de asesorias extras según los permisos del
     * {@link Profesional} autenticado
     * 
     * @param asex injeccion de AsesoriaExtraService
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Mostrar lista de asesorias extras
     * @see List
     */

    @RequestMapping("/listarAsesoriaExtra")
    public ModelAndView listarAsesoriaExtra() {
        List<AsesoriaExtra> lista = asex.getAll();
        return new ModelAndView("listarAsesoriaExtra", "lista", lista);

    }

    @RequestMapping("/mostrarAsesoriaExtra/{id}")
    public ModelAndView mostrarAsesoriaExtra(@PathVariable int id) {
        AsesoriaExtra ase = asex.getById(id);
        return new ModelAndView("muestraAsesoriaExtra", "ase", ase);

    }

    /**
     * Muestra el listado de asesorias extras según los permisos del
     * {@link Profesional} autenticado
     * 
     * @param id     identificador numerico de {@link AsesoriaExtra}
     * 
     * @param ase    listado de asesorias extras
     * 
     * @param listap Listado de {@link Profesionales}
     *
     * @param listac Listado de {@link Cliente}
     *
     * @see List
     * @see put
     * @see map
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Editar lista de asesorias extras
     */

    @RequestMapping("/editarAsesoriaExtra/{id}")
    public ModelAndView editarAsesoriaExtra(@PathVariable int id) {
        AsesoriaExtra ase = asex.getById(id);
        List<Profesional> listap = ps.getAll();
        List<Cliente> listac = cs.getAll();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ase", ase);
        model.put("listap", listap);
        model.put("listac", listac);
        return new ModelAndView("editaAsesoriaExtra", "model", model);
    }

    @RequestMapping(value = "/guardarEditAsesoriaExtra", method = RequestMethod.POST)
    public ModelAndView guardarEditAsesoriaExtra(AsesoriaExtra ase) {
        asex.edit(ase);
        return new ModelAndView("redirect:/listarAsesoriaExtra");
    }

    @RequestMapping("/eliminarAsesoriaExtra/{id}")
    public ModelAndView eliminarAsesoriaExtra(@PathVariable int id) {
        asex.delete(id);
        return new ModelAndView("redirect:/listarAsesoriaExtra");
    }

    /**
     * Muestra el listado de asesorias extras según los permisos del
     * {@link Profesional} autenticado
     *
     * @param ase    listado de asesoria extra
     *
     * @param listap Listado de {@link Profesionales}
     *
     * @param listac Listado de {@link Cliente}
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud, Crear
     *         asesoria extra
     */

    @RequestMapping("/crearAsesoriaExtra")
    public ModelAndView crearAsesoriaExtra() {

        AsesoriaExtra ase = new AsesoriaExtra();
        List<Cliente> listac = cs.getAll();
        List<Profesional> listap = ps.getAll();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ase", ase);
        model.put("listap", listap);
        model.put("listac", listac);

        return new ModelAndView("creaAsesoriaExtra", "model", model);

    }

    @RequestMapping(value = "/guardarAsesoriaExtra", method = RequestMethod.POST)
    public ModelAndView guardarAsesoriaExtra(AsesoriaExtra ase) {
        asex.add(ase);
        return new ModelAndView("redirect:/listarAsesoriaExtra");
    }
}
