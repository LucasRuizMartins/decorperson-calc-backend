package com.decorperson.calculadoradecorperson.controllers;
import com.decorperson.calculadoradecorperson.dto.BudgetDTO;
import com.decorperson.calculadoradecorperson.dto.FurnitureDTO;
import com.decorperson.calculadoradecorperson.services.BudgetService;
import com.decorperson.calculadoradecorperson.services.FurnitureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/budgets")
@CrossOrigin(origins = "http://localhost:3000")
public class BudgetController {

            @Autowired
            private BudgetService service;

            @GetMapping(value = "/{id}")
            public ResponseEntity<BudgetDTO> findById (@PathVariable Long id) {
                BudgetDTO dto = service.findById(id);
                return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<BudgetDTO>> findAll(
            @RequestParam(name = "name", defaultValue = "") String name,
            Pageable pageable) {
        Page<BudgetDTO> dto = service.findAll(name, pageable);
        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BudgetDTO> update(@PathVariable Long id, @Valid @RequestBody BudgetDTO dto) {
        dto = service.update(id,dto);
        return  ResponseEntity.ok(dto);
    }
    @PostMapping
    public ResponseEntity<BudgetDTO> insert (@Valid @RequestBody BudgetDTO dto) {
                dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return  ResponseEntity.created(uri).body(dto);

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
