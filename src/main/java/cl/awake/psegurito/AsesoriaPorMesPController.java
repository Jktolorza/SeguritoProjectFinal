package cl.awake.psegurito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.awake.psegurito.model.AsesoriaPorMesP;
import cl.awake.psegurito.services.AsesoriaPorMesPService;

/**
 * Controlador Asesorias Por Mes Profesional
 * 
 * @author Desarrolladores PSegurito
 */
@Controller
public class AsesoriaPorMesPController {

    @Autowired
    AsesoriaPorMesPService aspmps;

    /**
     * Muestra el listado de asesorias por mes de cada profesional y cada nueva
     * asesoria es agregada
     * 
     * 
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Mostrar asesorias por mes de cada profesional
     * 
     * @see List
     * @see put
     * @see map
     */

    @RequestMapping("/asesoriapormesp")
    public ModelAndView entregarasesoriapormesp() {
        List<AsesoriaPorMesP> lista = aspmps.getAsesoriaPorMesP();
        String[] nombre = new String[lista.size()];
        int[] asesoria = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            nombre[i] = lista.get(i).getNombre();
            asesoria[i] = lista.get(i).getAsesorias();
        }
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("lista", lista);
        model.put("nombre", new JSONArray(nombre));
        model.put("asesoria", new JSONArray(asesoria));
        return new ModelAndView("VistaAsesoriaPorMesP", "model", model);
    }
}
