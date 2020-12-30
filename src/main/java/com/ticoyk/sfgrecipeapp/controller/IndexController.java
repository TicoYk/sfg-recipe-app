package com.ticoyk.sfgrecipeapp.controller;

import com.ticoyk.sfgrecipeapp.service.RecipeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
    
    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService= recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String index(Model model){
        log.debug("Generating index page");
        model.addAttribute("recipes", recipeService.getRecipes());
        
        return "index";
    }
    
}
