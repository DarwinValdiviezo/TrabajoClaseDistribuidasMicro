package com.espe.micro_cursos.controllers;

import com.espe.micro_cursos.model.entity.Reclamo;
import com.espe.micro_cursos.services.ReclamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reclamo")
public class ReclamoController {

    @Autowired
    private ReclamoService service;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Reclamo reclamo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("error: ");
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMessage.append(fieldError.getDefaultMessage()).append(". ");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString().trim());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(reclamo));
    }

    @GetMapping
    public List<Reclamo> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        Optional<Reclamo> reclamoOptional = service.findById(id);
        if (reclamoOptional.isPresent()) {
            return ResponseEntity.ok().body(reclamoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody Reclamo reclamo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("error: ");
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMessage.append(fieldError.getDefaultMessage()).append(". ");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString().trim());
        }
        Optional<Reclamo> reclamoOptional = service.findById(id);
        if (reclamoOptional.isPresent()) {
            Reclamo reclamoDB = reclamoOptional.get();
            reclamoDB.setCliente(reclamo.getCliente());
            reclamoDB.setDescripcion(reclamo.getDescripcion());
            reclamoDB.setPrioridad(reclamo.getPrioridad());
            reclamoDB.setFechaReclamo(reclamo.getFechaReclamo());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(reclamoDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        Optional<Reclamo> reclamoOptional = service.findById(id);
        if (reclamoOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
