package cl.awake.psegurito;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
    static final Logger logger = LogManager.getLogger(HomeController.class);
    // private static final Logger logger =
    // LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET)
    public String home(Model model) {
//        logger.info("This Is An Info Log Entry ......!");
//        logger.error("This Is An Error Log Entry ......!");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		System.out.println(auth.getCredentials()); 
//		System.out.println(auth.getName()); 
        System.out.println(auth.getPrincipal());
//		System.out.println(auth.getAuthorities()); 

        model.addAttribute("usuario", auth.getName());
        model.addAttribute("rol", auth.getAuthorities());
//		logger.info("Welcome home! The client locale is {}.", locale);

        return "home";
    }

}
