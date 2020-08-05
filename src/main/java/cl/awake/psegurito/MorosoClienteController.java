package cl.awake.psegurito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.awake.psegurito.model.Moroso;
import cl.awake.psegurito.services.MorosoService;


@Controller
public class MorosoClienteController {

	
	
	@Autowired
	MorosoService rcr;
	
    @RequestMapping("/listarmorosos")
	public ModelAndView entregarmoroso() {
		
	   	List<Moroso> lista = rcr.getmoroso();
    	return new ModelAndView("VistaMoroso","lista", lista);  
		
	}

}
