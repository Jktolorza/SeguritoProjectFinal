package cl.awake.psegurito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.model.ReporteAccidente;
import cl.awake.psegurito.model.ReporteAccidenteRepository;



@Service
public class ReporteAccidenteServiceImpl implements ReporteAccidenteService {

        @Autowired
        ReporteAccidenteRepository repr;
        
        @Override
        public ReporteAccidente getById(int id) {
                // TODO Auto-generated method stub
                return repr.findOne(id);
        }

        @Override
        public List<ReporteAccidente> getAll() {
                // TODO Auto-generated method stub
                return (List<ReporteAccidente>) repr.findAll();
        }

        @Override
        public void add(ReporteAccidente rep) {
                // TODO Auto-generated method stub
                repr.save(rep);
        }

        @Override
        public void edit(ReporteAccidente rep) {
                // TODO Auto-generated method stub
                repr.save(rep);
        }

        @Override
        public void delete(ReporteAccidente rep) {
                // TODO Auto-generated method stub
                repr.delete(rep);
        }

        @Override
        public void delete(int id) {
                // TODO Auto-generated method stub
                repr.delete(id);
        }

}

