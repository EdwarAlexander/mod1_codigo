package com.codigo.edwar_moran.controller;

import com.codigo.edwar_moran.entity.AutorEntity;
import com.codigo.edwar_moran.entity.EditorEntity;
import com.codigo.edwar_moran.repository.EditorRepository;
import com.codigo.edwar_moran.service.IEditorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/editor")
@AllArgsConstructor
public class EditorController {

    private IEditorService editorService;

    @PostMapping
    public ResponseEntity<EditorEntity> create(@RequestBody EditorEntity entity){
        EditorEntity entityResponse = editorService.create(entity);
        return new ResponseEntity<>(entityResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditorEntity> update(@PathVariable("id") Long id, @RequestBody EditorEntity entity){
        EditorEntity entityResponse = editorService.update(entity,id);
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        editorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorEntity> findById(@PathVariable("id") Long id){
        EditorEntity entityResponse = editorService.findByID(id);
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<EditorEntity>> findAll(){
        List<EditorEntity> entityResponse = editorService.findAll();
        return new ResponseEntity<>(entityResponse, HttpStatus.OK);
    }
}
