package com.ticoyk.sfgrecipeapp.repository;

import com.ticoyk.sfgrecipeapp.domain.Recipe;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    
}
