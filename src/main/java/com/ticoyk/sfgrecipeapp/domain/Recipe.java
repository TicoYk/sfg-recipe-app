package com.ticoyk.sfgrecipeapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(exclude={"notes", "ingredients", "categories"})
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer pretTime;
    private Integer cookTime;
    private Integer servings;
    private String sources;
    private String url;
    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Notes notes;

    @ManyToMany
    @JoinTable(
        name = "recipe_category",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
    
    public Recipe(){}
    public Recipe(String description, Integer pretTime, Integer cookTime, Integer servings, String sources, String url,
            String directions, Difficulty difficulty, Set<Ingredient> ingredients, Byte[] image, Notes notes,
            Set<Category> categories) {
        this.description = description;
        this.pretTime = pretTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.sources = sources;
        this.url = url;
        this.directions = directions;
        this.difficulty = difficulty;
        this.ingredients = ingredients;
        this.image = image;
        this.notes = notes;
        this.categories = categories;
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    public Recipe addNotes(Notes notes){
        notes.setRecipe(this);
        this.setNotes(notes);
        return this;
    }
    
}
