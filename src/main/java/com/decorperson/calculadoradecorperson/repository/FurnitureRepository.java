package com.decorperson.calculadoradecorperson.repository;

import com.decorperson.calculadoradecorperson.entities.Furniture;
import com.decorperson.calculadoradecorperson.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {

    @Query("SELECT obj FROM Furniture obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Furniture> searchByName(String name, Pageable pageable);

}

