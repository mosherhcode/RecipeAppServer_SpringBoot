package com.mosherhcode.RecipeAppServer.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.mosherhcode.RecipeAppServer.models.Ingredient;
import com.mosherhcode.RecipeAppServer.models.Instruction;

public class IngredientJdbcDao implements IngredientDao {

private JdbcTemplate jdbcTemplate;
	
	public IngredientJdbcDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public List<Ingredient> getIngredientsByRecipeId(String recipeId){
		String sqlQuery = "SELECT * FROM ingredient WHERE recipe_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, UUID.fromString(recipeId));
		List<Ingredient> ingredientList = new ArrayList<Ingredient>(0);
		while (results.next()) {
			ingredientList.add(mapRowToIngredient(results));
			
		}
		return ingredientList;
	}
	
	public Ingredient getIngredientByIngredientId(String ingredientId) {
		String sqlQuery = "SELECT * FROM ingredient WHERE ingredient_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, UUID.fromString(ingredientId));
		
		if(results.next()) {
			return mapRowToIngredient(results);
			
		}
		return null;
	}
	
	public Ingredient addIngredientToRecipe(String recipeId, Ingredient ingredient) {
		String sql = "INSERT INTO ingredient (recipe_id, ingredient_name, amount, unit) "
				+ "VALUES (?, ?, ?, ?) RETURNING ingredient_id";
		
		String ingredientId = jdbcTemplate.queryForObject(sql, UUID.class, 
				UUID.fromString(recipeId), 
				ingredient.getIngredientName(), 
				ingredient.getAmount(), 
				ingredient.getUnit()).toString();
		
		return getIngredientByIngredientId(ingredientId);
	}


	private Ingredient mapRowToIngredient(SqlRowSet results) {
		Ingredient theIngredient = new Ingredient(
				results.getString("ingredient_id"), 
				results.getString("ingredient_name"), 
				results.getDouble("amount"), 
				results.getString("unit"));
		
		return theIngredient;
	}
	
}
