package com.mosherhcode.RecipeAppServer.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.mosherhcode.RecipeAppServer.models.Instruction;

@Component
public class InstructionJdbcDao implements InstructionDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public InstructionJdbcDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public List<Instruction> getInstructionsByRecipeId(String recipeId){
		String sqlQuery = "SELECT * FROM instruction WHERE recipe_id = ? ORDER BY instruction_number";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, UUID.fromString(recipeId));
		List<Instruction> instructionList = new ArrayList<Instruction>(0);
		while (results.next()) {
			instructionList.add(mapRowToInstruction(results));
			
		}
		return instructionList;
	}
	
	public Instruction addInstructionToRecipe(String recipeId, Instruction newInstruction) {
		String sql = "INSERT INTO instruction (recipe_id, instruction_number, instruction_text) "
				+ "VALUES (?, ?, ?) RETURNING instruction_id";
		
		String instructionId = jdbcTemplate.queryForObject(sql, UUID.class, UUID.fromString(recipeId), newInstruction.getInstructionNumber(), newInstruction.getInstructionText()).toString();
		return getInstructionByInstructionId(instructionId);
	}
	
	public Instruction getInstructionByInstructionId(String instructionId) {
		return null;
	}


	private Instruction mapRowToInstruction(SqlRowSet results) {
		Instruction theInstruction = new Instruction(
				results.getString("instruction_id"), 
				results.getInt("instruction_number"), 
				results.getString("Instruction_text"));
		
		return theInstruction;
	}
	
}
