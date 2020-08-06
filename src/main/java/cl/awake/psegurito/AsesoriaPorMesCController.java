package cl.awake.psegurito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.awake.psegurito.model.AsesoriaPorMesC;
import cl.awake.psegurito.services.AsesoriaPorMesCService;

@Controller
public class AsesoriaPorMesCController {
	
	@Autowired
	AsesoriaPorMesCService aspms;
	
	@RequestMapping("/asesoriapormesc")
	public ModelAndView entregarasesoriapormesc() {
		List<AsesoriaPorMesC> lista = aspms.getAsesoriaPorMesC();
		String[] nombre = new String[lista.size()];
		int[] asesoria = new int [lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			nombre[i] = lista.get(i).getNombre();
			asesoria[i] = lista.get(i).getAsesorias();
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("lista", lista);
		model.put("nombre", new JSONArray(nombre));
		model.put("asesoria", new JSONArray(asesoria));
		return new ModelAndView("VistaAsesoriaPorMesC","model",model);
	}
	

}
