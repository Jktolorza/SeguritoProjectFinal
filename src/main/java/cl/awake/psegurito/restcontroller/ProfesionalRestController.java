package cl.awake.psegurito.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.services.ProfesionalService;


@RestController
public class ProfesionalRestController {
	
	@Autowired
	ProfesionalService ps;

	@RequestMapping(value = "/prolist", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Profesional> getProfesionals() {
		List<Profesional> listaprofesionalrest = ps.getAll();
		return listaprofesionalrest;
	}

	@RequestMapping(value = "/prolist", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCliente(@RequestBody Profesional profesional) { 
		ps.add(profesional);
	}

	@RequestMapping(value = "/prolist", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCliente(@RequestBody Profesional profesional) {
		ps.edit(profesional);
	}

	@RequestMapping(value = "/prodetalle/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Profesional getClientePorId(@PathVariable int id) {
		return ps.getById(id);
	}

	@RequestMapping(value = "/prodetalle/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCliente(@PathVariable("id") int id) {
		ps.delete(id);
	}

}
