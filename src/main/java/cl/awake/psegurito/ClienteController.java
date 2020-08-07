package cl.awake.psegurito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.model.Usuario;
import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.UsuarioService;

/**
 * Controlador Cliente
 * 
 * @author Desarrolladores PSegurito
 */

@Controller
public class ClienteController {
    static final Logger log = LogManager.getLogger(ClienteController.class);
    @Autowired
    ClienteService cs;

    @Autowired
    UsuarioService us;

    /**
     * Muestra el listado de clientes según los permisos del {@link Profesional}
     * {@link Administrador} autenticado
     * 
     * @param cs injeccion de ClienteService
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Mostrar lista de clientes
     * @see List
     */

    @RequestMapping("/listarCliente")
    public ModelAndView listarCliente() {
        List<Cliente> lista = cs.getAll();
        log.info("holiwi");
        return new ModelAndView("listaCliente", "lista", lista);

    }

    @RequestMapping("/mostrarCliente/{id}")
    public ModelAndView mostrarCliente(@PathVariable int id) {
        Cliente c = cs.getById(id);
        return new ModelAndView("muestraCliente", "c", c);

    }

    /**
     * Muestra el listado de clientes según los permisos del {@link Administrador}
     * autenticado
     * 
     * @param id     identificador numerico de {@link Cliente}
     * 
     * @param c      listado de cliente
     *
     * @param listac Listado de {@link Cliente}
     *
     * @see List
     * @see put
     * @see map
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Editar lista de clientes
     */

    @RequestMapping("/editarCliente/{id}")
    public ModelAndView editarCliente(@PathVariable int id) {
        Cliente c = cs.getById(id);
        // Usuario u = us.getByNickname(c.getUsuario().getNickname());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("c", c);
        // model.put("u", u);

        return new ModelAndView("editaCliente", "model", model);
    }

    @RequestMapping(value = "/guardarEditCliente", method = RequestMethod.POST)
    public ModelAndView guardarEditCliente(Cliente c) {

        // c.setUsuario(u);
        // System.out.println(u.toString());
        cs.edit(c);
//        	System.out.println(c.toString());

//        	//encriptando el nuevo password
//        	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
//        	String password = u.getPassword();
//        	u.setPassword(passwordEncoder.encode(password));

//        	us.editUserByIdAndNickname(u.getNickname(), u.getPassword(), u.getRol(), u.getId_usuario());

        return new ModelAndView("redirect:/listarCliente");
    }

    @RequestMapping("/eliminarCliente/{id}")
    public ModelAndView eliminarCliente(@PathVariable int id) {
        Cliente c = cs.getById(id);
        Usuario u = us.getByNickname(c.getUsuario().getNickname());
        System.out.println(u.toString());
        cs.delete(id);
        us.delete(u);
        return new ModelAndView("redirect:/listarCliente");
    }

    /**
     * Muestra el listado de clientes según los permisos del {@link Administrador}
     * autenticado
     * 
     * Se crea y se verifica si existe usuario.
     *
     *
     * @param c  Listado de {@link Cliente}
     *
     * @param u  Listado de {@link Usuario}
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud, Crear
     *         cliente
     */

    @RequestMapping("/crearCliente/{message}")
    public ModelAndView crearCliente(@PathVariable String message) {
        Cliente c = new Cliente();
        Usuario u = new Usuario();

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("c", c);
        model.put("u", u);
        model.put("message", message);
        return new ModelAndView("creaCliente", "model", model);
    }

    @RequestMapping(value = "/guardarCliente", method = RequestMethod.POST)
    public ModelAndView guardarCliente(Cliente c, Usuario u, RedirectAttributes redirectAttrs) {
        // validar si el nuevo nick no esta duplicado
        if (us.countByNickname(u.getNickname()) == 0) {

            // encriptando el nuevo password
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password = u.getPassword();
            u.setPassword(passwordEncoder.encode(password));

            us.add(u);
            Usuario u1 = us.getByNickname(u.getNickname());
            c.setUsuario(u1);
//        	System.out.println(c.toString());
            cs.add(c);
            return new ModelAndView("redirect:/listarCliente");
        } else {
            String mensaje = "el nickname ya existe en la base de datos";
            redirectAttrs.addAttribute("message", mensaje);
            return new ModelAndView("redirect:/crearCliente/{message}.do");
        }
    }
}