package com.sedikev.domain.repository;

import com.sedikev.infrastructure.adapter.entity.LoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoteRepository extends JpaRepository<LoteEntity, Long> {

    LoteEntity save(LoteEntity loteEntity);

    Optional<LoteEntity> findById(Long id);

    void deleteById(Long id);

    List<LoteEntity> findAll();
}
