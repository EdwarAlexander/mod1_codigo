package com.codigo.edwar_moran.service.impl;

import com.codigo.edwar_moran.entity.CategoriaEntity;
import com.codigo.edwar_moran.entity.EditorEntity;
import com.codigo.edwar_moran.repository.EditorRepository;
import com.codigo.edwar_moran.service.IEditorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EditorServiceImpl implements IEditorService {

    private EditorRepository editorRepository;
    @Override
    public EditorEntity create(EditorEntity request) {
        return editorRepository.save(request);
    }

    @Override
    public EditorEntity update(EditorEntity request, Long id) {
        EditorEntity editorEntity = editorRepository.findById(id).orElse(null);
        if (editorEntity != null){
            editorEntity.setEstado(request.getEstado());
            editorEntity.setNombre(request.getNombre());
            return editorRepository.save(editorEntity);
        }
        return null;
    }

    @Override
    public EditorEntity findByID(Long id) {
        return editorRepository.findById(id).orElse(null);
    }

    @Override
    public List<EditorEntity> findAll() {
        return editorRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        editorRepository.deleteById(id);
    }
}
