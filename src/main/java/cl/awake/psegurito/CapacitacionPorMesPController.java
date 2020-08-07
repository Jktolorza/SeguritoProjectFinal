package cl.awake.psegurito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.awake.psegurito.model.CapacitacionesPorMesP;
import cl.awake.psegurito.services.CapacitacionesPorMesPService;

/**
 * Controlador Capacitaciones Por Mes
 * 
 * @author Desarrolladores PSegurito
 */

@Controller
public class CapacitacionPorMesPController {

    @Autowired
    CapacitacionesPorMesPService cpms;

    /**
     * Muestra el listado de capacitaciones por mes de cada profesional y cada nueva
     * capacitacion es agregada
     * 
     * 
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Mostrar capacitaciones por mes de cada profesional
     * 
     * @see List
     * @see put
     * @see map
     */

    @RequestMapping("/capacitacionespromesp")
    public ModelAndView entregarcapacitacionespormesc() {
        List<CapacitacionesPorMesP> lista = cpms.getCapacitacionesPorMesP();
        String[] nombre = new String[lista.size()];
        int[] capacitaciones = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            nombre[i] = lista.get(i).getNombre();
            capacitaciones[i] = lista.get(i).getCapacitaciones();
        }
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("lista", lista);
        model.put("empresas", new JSONArray(nombre));
        model.put("capacitaciones", new JSONArray(capacitaciones));
        return new ModelAndView("VistaCapacitacionesPorMesP", "model", model);
    }

}
