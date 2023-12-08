package com.codigo.edwar_moran.service.impl;

import com.codigo.edwar_moran.entity.AutorEntity;
import com.codigo.edwar_moran.repository.AutorRepository;
import com.codigo.edwar_moran.service.IAutorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutorServiceImpl implements IAutorService {

    private AutorRepository autorRepository;

    @Override
    public AutorEntity create(AutorEntity request) {
        return autorRepository.save(request);
    }

    @Override
    public AutorEntity update(AutorEntity request, Long id) {
        AutorEntity autorEntity = autorRepository.findById(id).orElse(null);
        if (autorEntity != null){
            autorEntity.setEstado(request.getEstado());
            autorEntity.setNombre(request.getNombre());
            return autorRepository.save(autorEntity);
        }
        return null;
    }

    @Override
    public AutorEntity findByID(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    @Override
    public List<AutorEntity> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        autorRepository.deleteById(id);
    }
}
