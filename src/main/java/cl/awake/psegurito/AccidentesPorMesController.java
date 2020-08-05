package cl.awake.psegurito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.awake.psegurito.model.AccidentesPorMes;
import cl.awake.psegurito.services.AccidentesPorMesService;



@Controller
public class AccidentesPorMesController {
	@Autowired
	AccidentesPorMesService apm; 
	
    @RequestMapping("/accidentespormes")
	public ModelAndView entregaraccidentespormes() {
    	List<AccidentesPorMes> lista = apm.getAccidentesPorMes();
    	return new ModelAndView("VistaAccidentesPorMes","lista", lista);  

	}

}
