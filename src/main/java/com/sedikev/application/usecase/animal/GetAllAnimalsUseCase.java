package com.sedikev.application.usecase.animal;

import com.sedikev.application.mapper.AnimalMapper;
import com.sedikev.domain.model.AnimalDomain;
import com.sedikev.domain.repository.AnimalRepository;
import com.sedikev.application.usecase.UseCaseWithReturn;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GetAllAnimalsUseCase implements UseCaseWithReturn<Void, List<AnimalDomain>> {

    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Override
    public List<AnimalDomain> ejecutar(Void unused) {
        // Obtener todos los animales
        return animalRepository.findAll().stream()
                .map(animalMapper::toDomain)
                .collect(Collectors.toList());
    }
}
