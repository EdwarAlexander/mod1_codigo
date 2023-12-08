package com.codigo.edwar_moran.controller;

import com.codigo.edwar_moran.entity.AutorEntity;
import com.codigo.edwar_moran.entity.LibroEntity;
import com.codigo.edwar_moran.service.ILibroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libro")
@AllArgsConstructor
public class LibroController {

    private ILibroService libroService;

    @PostMapping
    public ResponseEntity<LibroEntity> create(@RequestBody LibroEntity entity){
        LibroEntity entityResponse = libroService.create(entity);
        return new ResponseEntity<>(entityResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroEntity> update(@PathVariable("id") Long id, @RequestBody LibroEntity entity){
        LibroEntity entityResponse = libroService.update(entity,id);
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroEntity> findById(@PathVariable("id") Long id){
        LibroEntity entityResponse = libroService.findByID(id);
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<LibroEntity>> findAll(){
        List<LibroEntity> entityResponse = libroService.findAll();
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }
}
