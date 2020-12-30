package com.ticoyk.sfgrecipeapp.service;

import java.util.HashSet;
import java.util.Set;

import com.ticoyk.sfgrecipeapp.domain.Recipe;
import com.ticoyk.sfgrecipeapp.repository.RecipeRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RecipeServiceImp implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImp(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    
    

}
