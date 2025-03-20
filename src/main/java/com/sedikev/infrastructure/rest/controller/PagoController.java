package com.sedikev.infrastructure.rest.controller;

import com.sedikev.application.dto.PagoDTO;
import com.sedikev.application.mapper.PagoMapper;
import com.sedikev.domain.model.PagoDomain;
import com.sedikev.domain.service.PagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;
    private final PagoMapper pagoMapper;

    @PostMapping(path = "pago")
    public ResponseEntity<PagoDTO> create(@RequestBody PagoDTO pagoDTO) {
        PagoDomain pagoDomain = pagoMapper.toDomain(pagoDTO);
        PagoDomain pagoSaved = pagoService.save(pagoDomain);
        PagoDTO responseDTO = pagoMapper.toDTO(pagoSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(path = "pago")
    public ResponseEntity<PagoDTO> update(@RequestBody PagoDTO pagoDTO) {
        PagoDomain pagoDomain = pagoMapper.toDomain(pagoDTO);
        PagoDomain pagoSaved = pagoService.save(pagoDomain);
        PagoDTO responseDTO = pagoMapper.toDTO(pagoSaved);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping(path = "pago/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "pago/{id}")
    public ResponseEntity<PagoDTO> findById(@PathVariable Long id) {
        PagoDomain pagoDomain = pagoService.findById(id);
        if (pagoDomain == null) {
            return ResponseEntity.notFound().build();
        }
        PagoDTO responseDTO = pagoMapper.toDTO(pagoDomain);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(path = "pagos")
    public ResponseEntity<List<PagoDTO>> findAll() {
        List<PagoDomain> pagoDomains = pagoService.findAll();
        List<PagoDTO> responseDTOs = pagoDomains.stream()
                .map(pagoMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }
}
