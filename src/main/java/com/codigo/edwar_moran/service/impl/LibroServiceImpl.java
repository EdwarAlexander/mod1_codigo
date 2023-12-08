package com.codigo.edwar_moran.service.impl;

import com.codigo.edwar_moran.entity.EditorEntity;
import com.codigo.edwar_moran.entity.LibroEntity;
import com.codigo.edwar_moran.repository.LibroRepository;
import com.codigo.edwar_moran.service.ILibroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibroServiceImpl implements ILibroService {

    private LibroRepository libroRepository;
    @Override
    public LibroEntity create(LibroEntity request) {
        return libroRepository.save(request);
    }

    @Override
    public LibroEntity update(LibroEntity request, Long id) {
        LibroEntity libroEntity = libroRepository.findById(id).orElse(null);
        if (libroEntity != null){
            libroEntity.setEstado(request.getEstado());
            libroEntity.setTitulo(request.getTitulo());
            libroEntity.setCategorias(request.getCategorias());
            libroEntity.setAutores(request.getAutores());
            libroEntity.setEditor(request.getEditor());
            return libroRepository.save(libroEntity);
        }
        return null;
    }

    @Override
    public LibroEntity findByID(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public List<LibroEntity> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        libroRepository.deleteById(id);
    }
}
