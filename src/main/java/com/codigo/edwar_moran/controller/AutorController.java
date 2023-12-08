package com.codigo.edwar_moran.controller;

import com.codigo.edwar_moran.entity.AutorEntity;
import com.codigo.edwar_moran.service.IAutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autor")
@AllArgsConstructor
public class AutorController {

    private IAutorService autorService;

    @PostMapping
    public ResponseEntity<AutorEntity> create(@RequestBody AutorEntity entity){
        AutorEntity entityResponse = autorService.create(entity);
        return new ResponseEntity<>(entityResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorEntity> update(@PathVariable("id") Long id, @RequestBody AutorEntity entity){
        AutorEntity entityResponse = autorService.update(entity,id);
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        autorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorEntity> findById(@PathVariable("id") Long id){
        AutorEntity entityResponse = autorService.findByID(id);
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<AutorEntity>> findAll(){
        List<AutorEntity> entityResponse = autorService.findAll();
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }
}
