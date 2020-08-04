package cl.awake.psegurito;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
    @RequestMapping("/error")
    public String error(ModelMap model)
    {
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping("/login")
    public String login()
    {
        System.out.println("Inside login");
        return "login";
    }
    
    @RequestMapping("/accesoDenegado")
    public String accesodenegado()
    {
        System.out.println("Acceso Denegado");
        return "accesoDenegado";
    }
    
    @RequestMapping("/logout")
    public String logout()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
        SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout"; 
    }
}