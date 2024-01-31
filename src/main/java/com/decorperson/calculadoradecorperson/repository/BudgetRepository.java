package com.decorperson.calculadoradecorperson.repository;

import com.decorperson.calculadoradecorperson.entities.Budget;
import com.decorperson.calculadoradecorperson.entities.Furniture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

        @Query("SELECT b FROM Budget b WHERE LOWER(b.clientName) LIKE LOWER(CONCAT('%', :name, '%'))")
        Page<Budget> searchByName(@Param("name") String name, Pageable pageable);
    }



