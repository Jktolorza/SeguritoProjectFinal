package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.Capacitacion;



public interface CapacitacionService {
        
         Capacitacion getById(int id);
     List<Capacitacion> getAll();
     void add(Capacitacion cap);
     void edit(Capacitacion cap);
     void delete(Capacitacion cap);
     void delete(int id);
        
}
