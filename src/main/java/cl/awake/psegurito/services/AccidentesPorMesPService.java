package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.AccidentesPorMesP;

public interface AccidentesPorMesPService {

    AccidentesPorMesP getById(int id);
    List<AccidentesPorMesP> getAll();
    void add(AccidentesPorMesP p);
    void edit(AccidentesPorMesP p);
    void delete(AccidentesPorMesP p);
    void delete(int id);
    List<AccidentesPorMesP> getAccidentesPorMesP();

}
