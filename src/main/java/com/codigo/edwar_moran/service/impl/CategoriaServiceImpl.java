package com.codigo.edwar_moran.service.impl;

import com.codigo.edwar_moran.entity.AutorEntity;
import com.codigo.edwar_moran.entity.CategoriaEntity;
import com.codigo.edwar_moran.repository.CategoriaRepository;
import com.codigo.edwar_moran.service.ICategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements ICategoriaService {

    private CategoriaRepository categoriaRepository;
    @Override
    public CategoriaEntity create(CategoriaEntity request) {
        return categoriaRepository.save(request);
    }

    @Override
    public CategoriaEntity update(CategoriaEntity request, Long id) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id).orElse(null);
        if (categoriaEntity != null){
            categoriaEntity.setEstado(request.getEstado());
            categoriaEntity.setNombre(request.getNombre());
            return categoriaRepository.save(categoriaEntity);
        }
        return null;
    }

    @Override
    public CategoriaEntity findByID(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategoriaEntity> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
