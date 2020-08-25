package com.mosherhcode.RecipeAppServer.daos;

import java.util.List;

import com.mosherhcode.RecipeAppServer.models.Recipe;

public interface RecipeDao {
	
	public List<Recipe> getRecipesByUserId(String userId);
	public List<Recipe> getAllRecipes();
	
	public Recipe addRecipe(Recipe recipe);
}
