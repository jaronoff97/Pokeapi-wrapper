package com.milton.example;

public enum TypeOfCall {
	ABILITY("ability/"), MOVE("move/"), POKEMON("pokemon/"), TYPE("type/"), NONE("");
	public String api_call;
	private TypeOfCall(String s){
		this.api_call = s;
	}
}
