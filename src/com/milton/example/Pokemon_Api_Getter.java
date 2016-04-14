package com.milton.example;

import java.net.*;
import java.io.*;
import org.json.*;

public class Pokemon_Api_Getter {
	private final String BASE_URL="http://pokeapi.co/api/v2/";
	private int id_to_get=1;
	private String most_recent_data="";
	public TypeOfCall currentType = TypeOfCall.NONE;
	
	public Pokemon_Api_Getter(TypeOfCall nextType) {
		currentType = nextType;
		changeURL();
	}
	public PokeAPIData getDataForType(){
		PokeAPIData toReturn = null;
		switch(currentType){
		case POKEMON:{
			toReturn = makePokemon();
			break;
		}
		case ABILITY:{

			break;	
		}
		case MOVE:{

			break;	
		}
		case TYPE:{

			break;	
		}
		default:{

			break;
		}
		}
		return toReturn;
	}
	private Pokemon makePokemon(){
		JSONObject obj = new JSONObject(most_recent_data);
		Pokemon temp = new Pokemon(obj);
		System.out.println(temp.toString());
		return temp;
	}
	public void setId(int id_to_get) {
		this.id_to_get = id_to_get;
		changeURL();
	}
	private void changeURL(){
		try {
			getAllData(BASE_URL+currentType.api_call+id_to_get);
		} catch(MalformedURLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private String getAllData(String url) throws MalformedURLException, IOException{
		String toReturn="";
		URL url_to_connect = new URL(url);
		URLConnection yc = url_to_connect.openConnection();
		yc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		yc.connect();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
                    toReturn+=inputLine;
                }
        in.close();
        most_recent_data=toReturn;
        return toReturn;
	}
}
