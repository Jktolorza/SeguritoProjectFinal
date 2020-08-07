package cl.awake.psegurito;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import cl.awake.psegurito.model.AccidentabilidadPorMes;

/**
 * Controlador Accidentabilidad
 * 
 * @author Desarrolladores PSegurito
 */
@SuppressWarnings("deprecation")
@Controller
public class AccidentabilidadController {

    /**
     * Muestra el listado accidentabilidad y cada nuevo accidente es agregado
     * 
     * 
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Mostrar accidentabilidad
     * 
     * @see List
     * @see addAttribute
     *
     */

    @RequestMapping(value = "/listadoaccidentabilidad", method = RequestMethod.GET)
    public ModelAndView getAllPostJSON(Model model, HttpServletRequest request) {
        int port = request.getLocalPort();
        // System.out.println(port);
        final String uri = "http://localhost:" + port + "/psegurito/accidentabilidadpormes";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("cliente", "cliente"));
        ResponseEntity<List<AccidentabilidadPorMes>> postResponse = restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<AccidentabilidadPorMes>>() {
                });
        List<AccidentabilidadPorMes> posts = postResponse.getBody();
        model.addAttribute("listadoaccidentabilidad", posts);
        System.out.println("Cantidad: " + posts.size());

        String[] profesional = new String[posts.size()];
        float[] accidentabilidad = new float[posts.size()];

        for (int i = 0; i < posts.size(); i++) {
            profesional[i] = posts.get(i).getProfesional();
            accidentabilidad[i] = posts.get(i).getIndiceAccidentabilidad();
        }

        // model.addAttribute("lista", posts);
        model.addAttribute("profesionales", new JSONArray(profesional));
        model.addAttribute("accidentabilidad", new JSONArray(accidentabilidad));
        return new ModelAndView("VistaAccidentabilidad", "model", model);
    }

    @RequestMapping(value = "/listadoaccidentabilidadhistorica", method = RequestMethod.GET)
    public ModelAndView getAllhPostJSON(Model model, HttpServletRequest request) {
        int port = request.getLocalPort();
        // System.out.println(port);
        final String uri = "http://localhost:" + port + "/psegurito/accidentabilidadhistorica";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("cliente", "cliente"));
        ResponseEntity<List<AccidentabilidadPorMes>> postResponse = restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<AccidentabilidadPorMes>>() {
                });
        List<AccidentabilidadPorMes> posts = postResponse.getBody();
        model.addAttribute("listadoaccidentabilidadhistorica", posts);
        System.out.println("Cantidad: " + posts.size());

        String[] profesional = new String[posts.size()];
        float[] accidentabilidad = new float[posts.size()];
        int[] periodo = new int[posts.size()];

        for (int i = 0; i < posts.size(); i++) {
            profesional[i] = posts.get(i).getProfesional();
            accidentabilidad[i] = posts.get(i).getIndiceAccidentabilidad();
            periodo[i] = posts.get(i).getPeriodo();
        }

        // model.addAttribute("lista", posts);
        model.addAttribute("profesionales", new JSONArray(profesional));
        model.addAttribute("periodo", new JSONArray(periodo));
        model.addAttribute("accidentabilidadhistorica", new JSONArray(accidentabilidad));
        return new ModelAndView("VistaAccidentabilidadHistorica", "model", model);
    }

}
