package cl.awake.psegurito.services;

import java.util.List;

import cl.awake.psegurito.model.Administrador;

public interface AdministradorService {
	
    Administrador getById(int id);
    List<Administrador> getAll();
    void add(Administrador a);
    void edit(Administrador a);
    void delete(Administrador a);
    void delete(int id);

}
