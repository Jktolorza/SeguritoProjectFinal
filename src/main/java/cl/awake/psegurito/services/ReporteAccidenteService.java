package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.ReporteAccidente;

public interface ReporteAccidenteService {

    ReporteAccidente getById(int id);
    List <ReporteAccidente>getAll();
    void add(ReporteAccidente rep);
    void edit(ReporteAccidente rep);
    void delete(ReporteAccidente rep);
    void delete(int id);
    
    
}
