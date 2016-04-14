package com.milton.example;

import org.json.JSONObject;

public class Move extends PrintClass{
	public String name;
	public String url;
	public int level_learned;
	
	public Move(JSONObject json) {
		super();
		// TODO Auto-generated constructor stub
		JSONObject temp = (JSONObject) json.get("move");
		name=temp.getString("name");
		url=temp.getString("url");
		
		
		type = TypeOfCall.MOVE;//Variable from PrintClass
		id=getId();//Variable from PrintClass
		//Add in getter for level_learned!!!
	}
}
