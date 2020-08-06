package cl.awake.psegurito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.awake.psegurito.model.ActividadMejoraPorMesP;
import cl.awake.psegurito.services.ActividadMejoraPorMesPService;

@Controller
public class ActividadMejoraPorMesPController {
	
	@Autowired
	ActividadMejoraPorMesPService apmps;
	
	@RequestMapping("/actividadpormesp")
	public ModelAndView entregaractividadmejorapormesp() {
		List<ActividadMejoraPorMesP> lista = apmps.getActividadMejoraPorMesP();
		String[] nombre = new String[lista.size()];
		int[] actividadmejora = new int [lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			nombre[i] = lista.get(i).getNombre();
			actividadmejora[i] = lista.get(i).getActividadmejora();
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("lista", lista);
		model.put("nombre", new JSONArray(nombre));
		model.put("actividadmejora", new JSONArray(actividadmejora));
		return new ModelAndView("VistaActividadMejoraPorMesP","model",model);
	}
}
