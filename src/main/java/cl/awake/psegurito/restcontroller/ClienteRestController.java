package cl.awake.psegurito.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.services.ClienteService;



@RestController
public class ClienteRestController {
	
	@Autowired
	ClienteService cs;

	@RequestMapping(value = "/clilist", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Cliente> getClientes() {
		List<Cliente> listaclientesrest = cs.getAll();
		return listaclientesrest;
	}

	@RequestMapping(value = "/clilist", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCliente(@RequestBody Cliente cliente) {
		cs.add(cliente);
	}

	@RequestMapping(value = "/clilist", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCliente(@RequestBody Cliente cliente) {
		cs.edit(cliente);
	}

	@RequestMapping(value = "/clidetalle/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Cliente getClientePorId(@PathVariable int id) {
		return cs.getById(id);
	}

	@RequestMapping(value = "/clidetalle/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCliente(@PathVariable("id") int id) {
		cs.delete(id);
	}

}
