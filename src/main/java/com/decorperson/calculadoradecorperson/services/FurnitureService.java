package com.decorperson.calculadoradecorperson.services;

import com.decorperson.calculadoradecorperson.dto.FurnitureDTO;
import com.decorperson.calculadoradecorperson.entities.DatabaseException;
import com.decorperson.calculadoradecorperson.entities.Furniture;
import com.decorperson.calculadoradecorperson.repository.FurnitureRepository;
import com.decorperson.calculadoradecorperson.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FurnitureService {

    @Autowired
    private FurnitureRepository repository;

    @Transactional(readOnly = true)
    public FurnitureDTO findById(Long id) {
        Furniture furniture = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
                return new FurnitureDTO(furniture);
    }

    @Transactional(readOnly = true)
    public Page<FurnitureDTO> findAll(String name, Pageable pageable) {
        Page<Furniture> result = repository.searchByName(name, pageable);
        return result.map(x -> new FurnitureDTO(x));
    }

    @Transactional()
    public FurnitureDTO insert (FurnitureDTO dto) {
        Furniture entity = new Furniture();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);

        return new FurnitureDTO(entity);

    }
    @Transactional()
    public FurnitureDTO update (Long id, FurnitureDTO dto) {
        try {
            Furniture entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new FurnitureDTO(entity);
        }
        catch(DatabaseException e) {
            throw new ResourceNotFoundException("Recurso Nao encontrado");
        }

    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso nao encontrado");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Erro em integridade Referencial");
        }
    }


    private void copyDtoToEntity(FurnitureDTO dto, Furniture entity) {
        entity.setName(dto.getName());
        entity.setLength(dto.getLength());
        entity.setHeight(dto.getHeight());
        entity.setWidth(dto.getWidth());
        entity.setImgUrl(dto.getImgUrl());
    }
}
