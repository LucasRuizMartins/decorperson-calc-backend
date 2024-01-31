package com.decorperson.calculadoradecorperson.services;

import com.decorperson.calculadoradecorperson.dto.BudgetDTO;
import com.decorperson.calculadoradecorperson.dto.FurnitureDTO;
import com.decorperson.calculadoradecorperson.entities.Budget;
import com.decorperson.calculadoradecorperson.entities.DatabaseException;
import com.decorperson.calculadoradecorperson.entities.Furniture;
import com.decorperson.calculadoradecorperson.repository.BudgetRepository;
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
public class BudgetService {

    @Autowired
    private BudgetRepository repository;

    @Transactional(readOnly = true)
    public BudgetDTO findById(Long id) {
        Budget budget = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
                return new BudgetDTO(budget);
    }



    @Transactional()
    public BudgetDTO insert (BudgetDTO dto) {
        Budget entity = new Budget();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);

        return new BudgetDTO(entity);

    }
    @Transactional()
    public BudgetDTO update (Long id, BudgetDTO dto) {
        try {
            Budget entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new BudgetDTO(entity);
        }
        catch(DatabaseException e) {
            throw new ResourceNotFoundException("Recurso Nao encontrado");
        }

    }

    @Transactional(readOnly = true)
    public Page<BudgetDTO> findAll(String name, Pageable pageable) {
        Page<Budget> result = repository.searchByName(name, pageable);
        return result.map(x -> new BudgetDTO(x));
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


    private void copyDtoToEntity(BudgetDTO dto, Budget entity) {
        entity.setBudgetName(dto.getBudgetName());
        entity.setDate(dto.getDate());
        entity.setClientFirstName(dto.getClientFirstName());
        entity.setClientName(dto.getClientName());
        entity.setProjectTime(dto.getProjectTime());
        entity.setMonthYear(dto.getMonthYear());
        entity.setTotalPrice(dto.getTotalPrice());

    }
}
