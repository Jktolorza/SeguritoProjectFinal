package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.Moroso;

public interface MorosoService {
    Moroso getById(int id);
    List<Moroso> getAll();
    void add(Moroso p);
    void edit(Moroso p);
    void delete(Moroso p);
    void delete(int id);
    List<Moroso> getmoroso();
}
