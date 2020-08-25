package com.mosherhcode.RecipeAppServer.models;

public class Instruction {
	private String instructionId;
	private int instructionNumber;
	private String instructionText;
	
	public Instruction(String instructionId, int instructionNumber, String instructionText) {
		this.instructionId = instructionId;
		this.instructionNumber = instructionNumber;
		this.instructionText = instructionText;
	}
	
	public String getInstructionId() {
		return instructionId;
	}
	public void setInstructionId(String instructionId) {
		this.instructionId = instructionId;
	}
	public int getInstructionNumber() {
		return instructionNumber;
	}
	public void setInstructionNumber(int instructionNumber) {
		this.instructionNumber = instructionNumber;
	}
	public String getInstructionText() {
		return instructionText;
	}
	public void setInstructionText(String instructionText) {
		this.instructionText = instructionText;
	}
	
}
