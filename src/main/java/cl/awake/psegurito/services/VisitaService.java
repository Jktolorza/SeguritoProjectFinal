package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.Visita;

public interface VisitaService {

    Visita getById(int id);
    List<Visita> getAll();
    void add(Visita vis);
    void edit(Visita vis);
    void delete(Visita vis);
    void delete(int id);
       
}
