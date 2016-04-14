package com.milton.example;

import java.util.ArrayList;

import org.json.JSONObject;

public class Pokemon extends PrintClass{
	public String name;
	public int base_experience;
	public int height;
	public int weight;
	public int order;
	public int id;
	public ArrayList<Ability> abilities = new ArrayList<>();
	public ArrayList<Move> moves = new ArrayList<>();


	public Pokemon(JSONObject json) {
		// TODO Auto-generated constructor stub
		super();
		makeBaseData(json);
		makeAbilities(json);
		makeMoves(json);
	}
	private void makeBaseData(JSONObject json) {
		name = (String) (json.get("name"));
		base_experience = (int)(json.get("base_experience"));
		height = (int)(json.get("height"));
		weight = (int)(json.get("weight"));
		order = (int)(json.get("order"));
		
		
		type = TypeOfCall.POKEMON;//Variable from PrintClass
		id = (int)(json.get("id"));////Variable NOT from PrintClass, this object has no URL
	}
	private void makeAbilities(JSONObject json) {
		for(Object tempA: json.getJSONArray("abilities")){
			Ability tempAb = new Ability((JSONObject) tempA);
			abilities.add(tempAb);
		}
	}
	private void makeMoves(JSONObject json) {
		for(Object tempM: json.getJSONArray("moves")){
			Move tempMove = new Move((JSONObject) tempM);
			moves.add(tempMove);
		}
	}


}
