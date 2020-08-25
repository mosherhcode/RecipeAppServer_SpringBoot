package com.mosherhcode.RecipeAppServer.daos;

import java.util.List;

import com.mosherhcode.RecipeAppServer.models.Instruction;

public interface InstructionDao {

	
	public List<Instruction> getInstructionsByRecipeId(String recipeId);
}
