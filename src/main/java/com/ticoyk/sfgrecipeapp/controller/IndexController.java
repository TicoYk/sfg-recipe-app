package com.ticoyk.sfgrecipeapp.controller;

import java.util.Optional;

import com.ticoyk.sfgrecipeapp.domain.Category;
import com.ticoyk.sfgrecipeapp.domain.UnitOfMeasure;
import com.ticoyk.sfgrecipeapp.repository.CategoryRepository;
import com.ticoyk.sfgrecipeapp.repository.UnitOfMeasureRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String index(Model model){
        
        Optional<Category> categoryOptional = this.categoryRepository.findByDescription("American");
        
        return "index";
    }
    
}
