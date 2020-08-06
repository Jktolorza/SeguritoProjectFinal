package cl.awake.psegurito.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.awake.psegurito.model.AccidentabilidadPorMes;
import cl.awake.psegurito.services.AccidentabilidadPorMesService;


@RestController
public class AccidentabilidadPorMesController {
	@Autowired
	AccidentabilidadPorMesService accpms; 

    @RequestMapping(value = "/accidentabilidadpormes", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<AccidentabilidadPorMes> entregaraccidentabilidadpormes() {
    	List<AccidentabilidadPorMes> lista = accpms.getAccidentabilidadPorMes();
    	return lista;  

	}
}
