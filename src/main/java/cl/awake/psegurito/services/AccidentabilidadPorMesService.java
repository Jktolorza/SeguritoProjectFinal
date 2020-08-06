package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.AccidentabilidadPorMes;

public interface AccidentabilidadPorMesService {

    AccidentabilidadPorMes getById(int id);
    List<AccidentabilidadPorMes> getAll();
    void add(AccidentabilidadPorMes p);
    void edit(AccidentabilidadPorMes p);
    void delete(AccidentabilidadPorMes p);
    void delete(int id);
    List<AccidentabilidadPorMes> getAccidentabilidadPorMes();

}
