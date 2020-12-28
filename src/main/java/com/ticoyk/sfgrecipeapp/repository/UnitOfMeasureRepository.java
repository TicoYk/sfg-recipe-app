package com.ticoyk.sfgrecipeapp.repository;

import java.util.Optional;

import com.ticoyk.sfgrecipeapp.domain.UnitOfMeasure;

import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
    Optional<UnitOfMeasure> findByDescription(String description);
}
