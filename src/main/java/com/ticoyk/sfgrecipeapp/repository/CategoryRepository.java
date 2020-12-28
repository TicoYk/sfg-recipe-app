package com.ticoyk.sfgrecipeapp.repository;

import java.util.Optional;

import com.ticoyk.sfgrecipeapp.domain.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>{
    Optional<Category> findByDescription(String description);
}
