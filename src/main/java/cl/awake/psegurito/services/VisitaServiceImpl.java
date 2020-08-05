package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.Visita;
import cl.awake.psegurito.model.VisitaRepository;


@Service
public class VisitaServiceImpl implements VisitaService{

    @Autowired
    VisitaRepository visit;
    
    @Override
    public Visita getById(int id) {
            // TODO Auto-generated method stub
            return visit.findById(id).orElse(null);
}
    @Override
    public List<Visita> getAll() {
            // TODO Auto-generated method stub
            return (List<Visita>) visit.findAll();
    }
    
    @Override
    public void add(Visita vis) {
            // TODO Auto-generated method stub
            visit.save(vis);
    }
    
    @Override
    public void edit(Visita vis) {
            // TODO Auto-generated method stub
            visit.save(vis);
    }
    
    @Override
    public void delete(Visita vis) {
            // TODO Auto-generated method stub
             visit.delete(vis);
    }
    
    @Override
    public void delete(int id) {
            // TODO Auto-generated method stub
            visit.deleteById(id);
    }
 
}
    
