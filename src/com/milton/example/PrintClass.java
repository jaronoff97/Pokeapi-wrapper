package com.milton.example;

import java.lang.reflect.Field;

public class PrintClass implements PokeAPIData{
	public TypeOfCall type=TypeOfCall.NONE;
	public String url="";
	public int id;

	public PrintClass() {
		// TODO Auto-generated constructor stub
	}
	public int getId(){
		if(url!=""){
			return Integer.parseInt(url.substring(url
					.indexOf(this.getClass().getSimpleName().toLowerCase()))
					.replace(this.getClass().getSimpleName().toLowerCase(), "")
					.replace("/", ""));
		}
		else{
			return id;
		}
	}
	public String toString() {
		  StringBuilder result = new StringBuilder();
		  String newLine = System.getProperty("line.separator");

		  result.append( this.getClass().getName() );
		  result.append( " Object {" );
		  result.append(newLine);

		  //determine fields declared in this class only (no fields of superclass)
		  Field[] fields = this.getClass().getDeclaredFields();

		  //print field names paired with their values
		  for ( Field field : fields  ) {
		    result.append("  ");
		    try {
		      result.append( field.getName() );
		      result.append(": ");
		      //requires access to private field:
		      result.append( field.get(this) );
		    } catch ( IllegalAccessException ex ) {
		      System.out.println(ex);
		    }
		    result.append(newLine);
		  }
		  result.append("}");

		  return result.toString();
		}

}
