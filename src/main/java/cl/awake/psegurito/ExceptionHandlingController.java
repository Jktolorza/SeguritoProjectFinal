package cl.awake.psegurito;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlingController {

	// Specify name of a specific view that will be used to display the error:
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView handleIntegrityViolation(DataIntegrityViolationException divex) {

		ModelAndView model = new ModelAndView("databaseError");
		model.addObject("errMsg", "Error de integridad estas tratando de eliminar una tupla con campos hijos asociados");
		//model.addObject("errCode", divex.getMessage());
		//model.addObject("stackTrace", divex.getStackTrace());
		return model;
	}

	// Specify name of a specific view that will be used to display the error:
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("databaseError");
		model.addObject("errCode", ex.getMessage());
		model.addObject("errMsg", "this is Exception.class");

		return model;
	}

}