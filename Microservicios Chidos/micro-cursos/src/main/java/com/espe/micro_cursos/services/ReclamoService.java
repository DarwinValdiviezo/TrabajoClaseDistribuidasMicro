package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entity.Reclamo;

import java.util.List;
import java.util.Optional;

public interface ReclamoService {
    List<Reclamo> findAll();
    Optional<Reclamo> findById(int id);
    Reclamo save(Reclamo reclamo);
    void deleteById(int id);
}
