package cl.awake.psegurito;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import cl.awake.psegurito.model.PostCliente;

@Controller
public class PostClienteController {

	@RequestMapping(value = "/listadoclientespost", method = RequestMethod.GET)
	public String getAllPostJSON(Model model) {
		final String uri = "http://localhost:8080/psegurito/clilist";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<PostCliente>> postResponse = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PostCliente>>() {
				});
		List<PostCliente> posts = postResponse.getBody();
		model.addAttribute("listadoposts", posts);
		System.out.println("Cantidad: " + posts.size());

		return "postlclientes";
	}

	@RequestMapping(value = "/detalleclientepost/{id}", method = RequestMethod.GET)
	public String getDetallePostJSON(@PathVariable int id, Model model) {
		final String uri = "http://localhost:8080/psegurito/clidetalle/" + id;
		RestTemplate restTemplate = new RestTemplate();
		PostCliente listaposts = restTemplate.getForObject(uri, PostCliente.class);
		model.addAttribute("ps", listaposts);
		return "postver";
	}

}
