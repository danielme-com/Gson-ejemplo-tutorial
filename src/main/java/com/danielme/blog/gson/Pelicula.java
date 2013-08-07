package com.danielme.blog.gson;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pelicula
{
	@Expose
	@SerializedName("p-titulo")
	private String titulo;
	
	@Expose
	@SerializedName("p-año")
	private short year;
	
	@SerializedName("p-direccion")
	private String directores;
	
	@SerializedName("p-duracion-minutos")
	private short duracion;
	
	private List<Actor> interpretes;
	
	public Pelicula()
	{
		super();
	}

	public Pelicula(String titulo, short year, String directores, short duration, List<Actor> interpretes)
	{
		super();
		this.titulo = titulo;
		this.year = year;
		this.directores = directores;
		this.duracion = duration;
		this.interpretes = interpretes;
	}
	
	@Override
	public String toString()
	{
		String s = titulo +" (" + year + ")" + " de " + directores + ", " + duracion + " minutos. Interpretada por ";
		boolean first = true;
		for (Actor actor : interpretes)
		{
			if (first)
			{
				first = false;
			}
			else
			{
				s+=", ";
			}
			s+=actor.toString();
			
		}
		return s;		
	}
	
}