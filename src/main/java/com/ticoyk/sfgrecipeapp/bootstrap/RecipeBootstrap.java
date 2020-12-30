package com.ticoyk.sfgrecipeapp.bootstrap;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.ticoyk.sfgrecipeapp.domain.Category;
import com.ticoyk.sfgrecipeapp.domain.Difficulty;
import com.ticoyk.sfgrecipeapp.domain.Ingredient;
import com.ticoyk.sfgrecipeapp.domain.Notes;
import com.ticoyk.sfgrecipeapp.domain.Recipe;
import com.ticoyk.sfgrecipeapp.domain.UnitOfMeasure;
import com.ticoyk.sfgrecipeapp.repository.CategoryRepository;
import com.ticoyk.sfgrecipeapp.repository.RecipeRepository;
import com.ticoyk.sfgrecipeapp.repository.UnitOfMeasureRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository,
            UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private Set<Recipe> getRecipes(){
        Set<Recipe> recipes = new HashSet<>();
        
        Optional<Category> categoryA = categoryRepository.findByDescription("American");
        if(!categoryA.isPresent()){
            throw new RuntimeException("Expected American Not Found");
        }

        Optional<Category> categoryI = categoryRepository.findByDescription("Italian");
        if(!categoryI.isPresent()){
            throw new RuntimeException("Expected Italian Not Found");
        }

        Optional<UnitOfMeasure> uomPinch = unitOfMeasureRepository.findByDescription("Pinch");
        if(!uomPinch.isPresent()){
            throw new RuntimeException("Expected Pinch Not Found");
        }


        Optional<UnitOfMeasure> uomOunce = unitOfMeasureRepository.findByDescription("Ounce");
        if(!uomOunce.isPresent()){
            throw new RuntimeException("Expected Ounce Not Found");
        }


        Recipe recipe1 = new Recipe();
        recipe1.setDescription("Not a Pizza");
        recipe1.setPretTime(30);
        recipe1.setServings(8);
        recipe1.setDifficulty(Difficulty.EASY);
        
        recipe1.getCategories().add(categoryA.get());
        recipe1.getCategories().add(categoryI.get());

        recipe1.setNotes(new Notes(recipe1, "Don't let it burn"));

        recipe1.addIngredient(new Ingredient("Farinha", new BigDecimal(10) , uomOunce.get()));
        recipe1.addIngredient(new Ingredient("Molho de Tomate", new BigDecimal(10) , uomPinch.get()));
        recipe1.addIngredient(new Ingredient("Amor", new BigDecimal(100) , uomOunce.get()));

        recipes.add(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setDescription("Second Not a Pizza");
        recipe2.setPretTime(30);
        recipe2.setServings(8);
        recipe2.setDifficulty(Difficulty.HARD);
        
        recipe2.getCategories().add(categoryA.get());

        recipe2.setNotes(new Notes(recipe2, "Don't let it burn again"));

        recipe2.addIngredient(new Ingredient("Farinha 2", new BigDecimal(10) , uomOunce.get()));
        recipe2.addIngredient(new Ingredient("Molho de Tomate 2", new BigDecimal(10) , uomPinch.get()));
        recipe2.addIngredient(new Ingredient("Amor 2", new BigDecimal(100) , uomOunce.get()));

        recipes.add(recipe2);

        return recipes;
    }
    
}
