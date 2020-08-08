package cl.awake.psegurito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.model.Factura;
import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.DetalleFacturaService;
import cl.awake.psegurito.services.FacturaService;

/**
 * Controlador Factura
 * 
 * @author Desarrolladores PSegurito
 */

@Controller
public class FacturaController {

    @Autowired
    ClienteService cs;

    @Autowired
    FacturaService fs;

    @Autowired
    DetalleFacturaService dfs;

    /**
     * Muestra el listado facturas
     * 
     * @param fs injeccion de FacturaService
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Mostrar lista de facturas
     * @see List
     */

    @RequestMapping("/listarFactura")
    public ModelAndView listarFactura() {
        List<Factura> lista = fs.getAll();
        return new ModelAndView("listaFactura", "lista", lista);

    }

    @RequestMapping("/mostrarFactura/{id}")
    public ModelAndView mostrarFactura(@PathVariable int id) {
        Factura f = fs.getById(id);
        return new ModelAndView("muestraFactura", "f", f);

    }

    /**
     * Muestra el listado de facturas
     * 
     * @param id identificador numerico de {@link Factura}
     * 
     * @param f  listado de factura
     * 
     * @see List
     * @see put
     * @see map
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud,
     *         Editar factura
     */

    @RequestMapping("/editarFactura/{id}")
    public ModelAndView editarFactura(@PathVariable int id) {
        Factura f = fs.getById(id);
        List<Cliente> listac = cs.getAll();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("f", f);
        model.put("listac", listac);
        return new ModelAndView("editaFactura", "model", model);
    }

    @RequestMapping(value = "/guardarEditFactura", method = RequestMethod.POST)
    public ModelAndView guardarEditFactura(Factura f) {

        // actualizando el iva de la factura recien creada por el extras
        f.setItems(dfs.findAllByIdFactura(f.getId_factura()));
        f.setImpuestos((int) f.calcularIVA());
        f.setSubtotal((int) f.calcularSubtotal());
        f.setTotal((int) f.calcularTotal());

        fs.edit(f);
        return new ModelAndView("redirect:/listarFactura");
    }

    @RequestMapping("/eliminarFactura/{id}")
    public ModelAndView eliminarFactura(@PathVariable int id) {
        fs.delete(id);
        return new ModelAndView("redirect:/listarFactura");
    }

    /**
     * Muestra el listado de factura
     *
     * @param f listado de detalle de factura
     *
     * @return un objeto {@link ModelAndView} con la respuesta a la solicitud, Crear
     *         factura
     */

    @RequestMapping("/crearFactura")
    public ModelAndView crearFactura() {

        Factura f = new Factura();
        List<Cliente> listac = cs.getAll();

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("f", f);
        model.put("listac", listac);
        return new ModelAndView("creaFactura", "model", model);

    }

    @RequestMapping(value = "/guardarFactura", method = RequestMethod.POST)
    public ModelAndView guardarFactura(Factura f) {

        // actualizando el iva de la factura recien creada por el extras
        f.setItems(dfs.findAllByIdFactura(f.getId_factura()));
        f.setImpuestos((int) f.calcularIVA());
        f.setSubtotal((int) f.calcularSubtotal());
        f.setTotal((int) f.calcularTotal());

        fs.add(f);
        return new ModelAndView("redirect:/listarFactura");
    }
}