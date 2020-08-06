package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.AccidentesPorMes;





public interface AccidentesPorMesService {

    AccidentesPorMes getById(int id);
    List<AccidentesPorMes> getAll();
    void add(AccidentesPorMes p);
    void edit(AccidentesPorMes p);
    void delete(AccidentesPorMes p);
    void delete(int id);
    List<AccidentesPorMes> getAccidentesPorMes();

}
