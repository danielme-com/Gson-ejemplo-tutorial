package com.danielme.blog.gson;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author danielme.com
 * 
 */
public class Main
{
	
	
	public static void main(String[] args) 
	{	
		Actor tomhanks = new Actor("Tom Hanks", new GregorianCalendar(1956, 8, 9));
		Actor halleberry = new Actor("Halle Berry", new GregorianCalendar(1966, 7, 14));
		List<Actor> actores1 = new LinkedList<Actor>();
		actores1.add(tomhanks);
		actores1.add(halleberry);
		Pelicula pelicula1 = new Pelicula("El atlas de las nubes", (short) 2012, "Lana Wachowski, Tom Tykwer, Andy Wachowski", (short) 172, actores1);
		
		Actor jesse = new Actor("Jesse Eisenberg", new GregorianCalendar(1983, 9, 5));
		Actor andrew = new Actor("Andrew Garfield", new GregorianCalendar(1983, 7, 20));
		List<Actor> actores2 = new LinkedList<Actor>();
		actores2.add(jesse);
		actores2.add(andrew);
		Pelicula pelicula2 = new Pelicula("La red social", (short) 2010, "David Fincher", (short) 120, actores2);
		
		List<Pelicula> peliculas = new LinkedList<Pelicula>();
		peliculas.add(pelicula1);
		peliculas.add(pelicula2);
		
		GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls().setPrettyPrinting();
		gsonBuilder.registerTypeAdapter(GregorianCalendar.class, new CalendarJsonSerializer());
		gsonBuilder.registerTypeAdapter(Calendar.class, new CalendarJsonSerializer());
		Gson gson = gsonBuilder.create();
		
		String jsonString = gson.toJson(peliculas);
		System.out.println(jsonString);
		 
	    Pelicula[] peliculasJSON = gson.fromJson(jsonString, Pelicula[].class);	    
	    
	    for(Pelicula pelicula: peliculasJSON)
	    {
	    	System.out.println(pelicula.toString());
	    }		
  		
	}	

}