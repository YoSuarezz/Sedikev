package com.sedikev.infrastructure.rest.controller;

import com.sedikev.application.dto.LoteDTO;
import com.sedikev.application.mapper.LoteMapper;
import com.sedikev.domain.model.LoteDomain;
import com.sedikev.domain.service.LoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
public class LoteController {

    @Autowired
    private LoteService loteService;

    @Autowired
    private LoteMapper loteMapper;

    @PostMapping(path = "lote")
    public ResponseEntity<LoteDTO> create(@Valid @RequestBody LoteDTO loteDTO) {
        LoteDomain loteDomain = loteMapper.toDomain(loteDTO);
        LoteDomain loteSaved = loteService.save(loteDomain);
        LoteDTO responseDTO = loteMapper.toDTO(loteSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(path = "lote")
    public ResponseEntity<LoteDTO> update(@Valid @RequestBody LoteDTO loteDTO) {
        LoteDomain loteDomain = loteMapper.toDomain(loteDTO);
        LoteDomain loteSaved = loteService.save(loteDomain);
        LoteDTO responseDTO = loteMapper.toDTO(loteSaved);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping(path = "lote/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        loteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "lote/{id}")
    public ResponseEntity<LoteDTO> findById(@PathVariable Long id) {
        LoteDomain loteDomain = loteService.findById(id);
        if (loteDomain == null) {
            return ResponseEntity.notFound().build();
        }
        LoteDTO responseDTO = loteMapper.toDTO(loteDomain);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(path = "lotes")
    public ResponseEntity<List<LoteDTO>> findAll() {
        List<LoteDomain> loteDomains = loteService.findAll();
        List<LoteDTO> responseDTOs = loteDomains.stream()
                .map(loteMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }
}