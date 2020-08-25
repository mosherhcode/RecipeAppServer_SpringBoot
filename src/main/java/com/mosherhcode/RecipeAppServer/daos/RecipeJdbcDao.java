package com.mosherhcode.RecipeAppServer.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.mosherhcode.RecipeAppServer.models.Recipe;

@Component
public class RecipeJdbcDao implements RecipeDao {

	private JdbcTemplate jdbcTemplate;
	
	public RecipeJdbcDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Recipe> getRecipesByUserId(String userId){
		return null;
	}
	
	public List<Recipe> getAllRecipes(){
		String sqlQuery = "SELECT * FROM recipe ORDER BY recipe_name";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery);
		List<Recipe> recipeList = new ArrayList<Recipe>(0);
		while (results.next()) {
			recipeList.add(mapRowToRecipe(results));
		}
		
		
		return recipeList;
	}
	
	public Recipe getRecipeByRecipeId(String recipeId) {
		String sqlQuery = "SELECT * FROM recipe WHERE recipe_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, UUID.fromString(recipeId));
		if (results.next()) {
			return mapRowToRecipe(results);
		}
		return null;
	}
	
	public Recipe addRecipe(Recipe recipe) {
		String sqlUpdate = "INSERT INTO recipe (recipe_name, description, minutes_to_create, num_servings) "
							+ "VALUES (?,?,?,?) RETURNING recipe_id";
		
		String recipeId = jdbcTemplate.queryForObject(sqlUpdate, UUID.class, 
				recipe.getRecipeName(), 
				recipe.getDescription(), 
				recipe.getMinutesToCreate(), 
				recipe.getNumServings())
				.toString();
		
		
		return getRecipeByRecipeId(recipeId);
	}

	private Recipe mapRowToRecipe(SqlRowSet results) {
		Recipe theRecipe = new Recipe();
		theRecipe.setRecipeId(results.getString("recipe_id"));
		theRecipe.setRecipeName(results.getString("recipe_name"));
		theRecipe.setDescription(results.getString("description"));
		theRecipe.setMinutesToCreate(results.getInt("minutes_to_create"));
		theRecipe.setNumServings(results.getDouble("num_servings"));
		theRecipe.setDateCreated(results.getTimestamp("date_created").toLocalDateTime());
		theRecipe.setDateLastEdited(results.getTimestamp("date_last_edited").toLocalDateTime());
		
		InstructionDao instructionDao = new InstructionJdbcDao(this.jdbcTemplate);
		theRecipe.setInstructions(instructionDao.getInstructionsByRecipeId(theRecipe.getRecipeId()));
		
		return theRecipe;
	}
	
	
}
