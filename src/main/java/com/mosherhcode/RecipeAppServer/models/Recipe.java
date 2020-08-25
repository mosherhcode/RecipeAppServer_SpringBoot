package com.mosherhcode.RecipeAppServer.models;

import java.time.LocalDateTime;
import java.util.List;

public class Recipe {
	private String recipeId;
	private String recipeName;
	private String description;
	private int minutesToCreate;
	private double numServings;
	private LocalDateTime dateCreated;
	private LocalDateTime dateLastEdited;
	private List<Category> categories;
	private List<Group> groups;
	private List<Instruction> instructions;
	private List<Ingredient> ingredients;
	
	public String getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(String recipe_id) {
		this.recipeId = recipe_id;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipe_name) {
		this.recipeName = recipe_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMinutesToCreate() {
		return minutesToCreate;
	}
	public void setMinutesToCreate(int minutesToCreate) {
		this.minutesToCreate = minutesToCreate;
	}
	public double getNumServings() {
		return numServings;
	}
	public void setNumServings(double numServings) {
		this.numServings = numServings;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getDateLastEdited() {
		return dateLastEdited;
	}
	public void setDateLastEdited(LocalDateTime dateLastEdited) {
		this.dateLastEdited = dateLastEdited;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public List<Instruction> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
