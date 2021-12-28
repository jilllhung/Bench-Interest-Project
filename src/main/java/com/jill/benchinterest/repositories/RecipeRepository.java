package com.jill.benchinterest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jill.benchinterest.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
