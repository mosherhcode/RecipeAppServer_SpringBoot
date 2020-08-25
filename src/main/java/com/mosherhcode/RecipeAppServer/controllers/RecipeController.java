package com.mosherhcode.RecipeAppServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mosherhcode.RecipeAppServer.daos.RecipeDao;
import com.mosherhcode.RecipeAppServer.models.Recipe;

@RequestMapping(path = "/recipes")
@RestController
public class RecipeController {

	@Autowired
	RecipeDao rDao;
	
	
	@RequestMapping(path = "/{userId}", method = RequestMethod.GET)
	public List<Recipe> getAllRecipesByUserId(@PathVariable String userId){
		return null;
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<Recipe> getAllRecipes(){
		return rDao.getAllRecipes();
	}
	
	@RequestMapping(path = "/{userId}", method = RequestMethod.POST)
	public Recipe addRecipeForUser(@PathVariable String userId, @RequestBody Recipe recipe) {
		return null;
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public Recipe addRecipe(@RequestBody Recipe recipe) {
		return rDao.addRecipe(recipe);
	}
	
	@RequestMapping(path = "", method = RequestMethod.PUT)
	public Recipe updateRecipe(@RequestBody Recipe recipe) {
		return null;
	}
	
	@RequestMapping(path = "/delete/{recipeId}", method = RequestMethod.DELETE)
	public void deleteRecipe(@PathVariable String recipeId) {
		
	}
	
}
