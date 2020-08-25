package com.mosherhcode.RecipeAppServer.daos;

import java.util.List;

import com.mosherhcode.RecipeAppServer.models.Ingredient;

public interface IngredientDao {
	public List<Ingredient> getIngredientsByRecipeId(String recipeId);
	
	public Ingredient getIngredientByIngredientId(String ingredientId);
	
	public Ingredient addIngredientToRecipe(String recipeId, Ingredient ingredient);
	
	
}
