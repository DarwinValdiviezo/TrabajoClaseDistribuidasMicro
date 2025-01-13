package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entity.Reclamo;
import com.espe.micro_cursos.repositories.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamoServiceImpl implements com.espe.micro_cursos.services.ReclamoService {

    @Autowired
    private ReclamoRepository repository;

    @Override
    public List<Reclamo> findAll() {
        return (List<Reclamo>) repository.findAll();
    }

    @Override
    public Optional<Reclamo> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Reclamo save(Reclamo reclamo) {
        return repository.save(reclamo);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
