package com.codigo.edwar_moran.controller;

import com.codigo.edwar_moran.entity.AutorEntity;
import com.codigo.edwar_moran.entity.CategoriaEntity;
import com.codigo.edwar_moran.service.ICategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
@AllArgsConstructor
public class CategoriaController {

    private ICategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaEntity> create(@RequestBody CategoriaEntity entity){
        CategoriaEntity entityResponse = categoriaService.create(entity);
        return new ResponseEntity<>(entityResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaEntity> update(@PathVariable("id") Long id, @RequestBody CategoriaEntity entity){
        CategoriaEntity entityResponse = categoriaService.update(entity,id);
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEntity> findById(@PathVariable("id") Long id){
        CategoriaEntity entityResponse = categoriaService.findByID(id);
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CategoriaEntity>> findAll(){
        List<CategoriaEntity> entityResponse = categoriaService.findAll();
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }
}
