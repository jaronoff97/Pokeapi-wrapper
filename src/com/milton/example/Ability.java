package com.milton.example;

import org.json.JSONObject;

public class Ability extends PrintClass{
	public String name;
	public String url;

	public Ability(JSONObject json) {
		super();
		JSONObject temp = (JSONObject) json.get("ability");
		name=temp.getString("name");
		url=temp.getString("url");
		
		
		type = TypeOfCall.ABILITY;//Variable from PrintClass
		id=getId();//Variable from PrintClass
		// TODO Auto-generated constructor stub
	}

}
