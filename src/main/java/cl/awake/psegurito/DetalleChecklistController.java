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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.awake.psegurito.model.Checklist;

import cl.awake.psegurito.model.DetalleChecklist;
import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.services.ChecklistService;
import cl.awake.psegurito.services.DetalleChecklistService;

/**
 * Controlador Detalle Checklist
 * 
 * @author Desarrolladores PSegurito
 */
@Controller
public class DetalleChecklistController {

    @Autowired
    ChecklistService chs;

    @Autowired
    DetalleChecklistService dchs;

    /**
     * Muestra el listado de detalle checklist según los permisos del
     * {@link Profesional} autenticado
     * 
     * @param dchs injeccion de DetalleCheklistService
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Mostrar lista de detalle checklist
     * @see List
     */

    @RequestMapping("/listarDetalleChecklist")
    public ModelAndView listarDetalleChecklist() {
        List<DetalleChecklist> lista = dchs.getAll();
        return new ModelAndView("listarDetalleChecklist", "lista", lista);
    }

    @RequestMapping("/mostrarDetalleChecklist/{id_checklist}")
    public ModelAndView mostrarDetalleChecklist(@PathVariable int id_checklist) {
        List<DetalleChecklist> dch = dchs.findAllByIdChecklist(id_checklist);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("lista", dch);
        model.put("id_checklist", id_checklist);
        return new ModelAndView("muestraDetalleChecklist", "model", model);
    }

    /**
     * Muestra el listado de actividades según los permisos del {@link Profesional}
     * autenticado
     * 
     * @param id      identificador numerico de {@link DetalleChecklist}
     * 
     * @param dch     listado de Detalle Checklist
     *
     * @param listach Listado de {@link Checklist}
     *
     * @see List
     * @see put
     * @see map
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Editar lista de detalle checklist
     */

    @RequestMapping("/editarDetalleChecklist/{id}")
    public ModelAndView editarDetalleChecklist(@PathVariable int id) {
        DetalleChecklist dch = dchs.getById(id);
        List<Checklist> listach = chs.getAll();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("dch", dch);
        model.put("listach", listach);
        return new ModelAndView("editaDetalleChecklist", "model", model);
    }

    @RequestMapping(value = "/guardarEditDetalleChecklist", method = RequestMethod.POST)
    public ModelAndView guardarEditDetalleChecklist(DetalleChecklist dch, RedirectAttributes redirectAttrs) {
        dchs.edit(dch);

//			//modificar factura tb
//			Checklist ch = new Checklist();
//			ch=chs.getById(dch.getChecklist().getId_checklist());
//			ch.setItems(dchs.findAllByIdChecklist(dch.getChecklist().getId_checklist()));
//	    	chs.edit(ch);

        redirectAttrs.addAttribute("id_checklist", dch.getChecklist().getId_checklist());
        return new ModelAndView("redirect:/mostrarDetalleChecklist/{id_checklist}.do");
    }

    @RequestMapping("/eliminarDetalleChecklist/{id}/{id_checklist}")
    public ModelAndView eliminarDetalleChecklist(@PathVariable int id, @PathVariable int id_checklist,
            RedirectAttributes redirectAttrs) {
        dchs.delete(id);

//	    	Checklist ch = new Checklist();
////			ch=chs.getById(id_checklist);
////			ch.setItems(dchs.findAllByIdChecklist(id_checklist));
//	     	chs.edit(ch);

        redirectAttrs.addAttribute("id_checklist", id_checklist);
        return new ModelAndView("redirect:/mostrarDetalleChecklist/{id_checklist}.do");
    }

    /**
     * Muestra el listado de detalle checklist según los permisos del
     * {@link Profesional} autenticado
     *
     * @param dch          listado de detalle checklist
     *
     * @param id_checklist Listado de {@link Checklist}
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud, Crear
     *         detalle checklist
     */

    @RequestMapping("/crearDetalleChecklist/{id_checklist}")
    public ModelAndView crearDetalleChecklist(@PathVariable int id_checklist) {

        DetalleChecklist dch = new DetalleChecklist();

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("dch", dch);
        model.put("id_checklist", id_checklist);

        return new ModelAndView("creaDetalleChecklist", "model", model);

    }

    @RequestMapping(value = "/guardarDetalleChecklist", method = RequestMethod.POST)
    public ModelAndView guardarDetalleChecklist(DetalleChecklist dch, RedirectAttributes redirectAttrs) {
        dchs.add(dch);

//			Checklist ch = new Checklist();
////			ch=chs.getById(dch.getChecklist().getId_checklist());
////			ch.setItems(dchs.findAllByIdChecklist(dch.getChecklist().getId_checklist()));
//	      	chs.edit(ch);

        redirectAttrs.addAttribute("id_checklist", dch.getChecklist().getId_checklist());
        return new ModelAndView("redirect:/mostrarDetalleChecklist/{id_checklist}.do");
    }

}
