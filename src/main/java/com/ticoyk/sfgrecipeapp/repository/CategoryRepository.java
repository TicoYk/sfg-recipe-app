package com.ticoyk.sfgrecipeapp.repository;

import com.ticoyk.sfgrecipeapp.domain.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>{
    
}
