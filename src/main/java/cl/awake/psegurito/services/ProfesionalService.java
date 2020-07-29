package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.Profesional;

public interface ProfesionalService {

    Profesional getById(int id);
    List<Profesional> getAll();
    void add(Profesional p);
    void edit(Profesional p);
    void delete(Profesional p);
    void delete(int id);
    
}
