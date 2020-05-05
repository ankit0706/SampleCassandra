package com.sample.demo;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Movies {
	@PrimaryKey
	String name;
	String director;
	double imdb;
	int release_year;
	int rottent_tomatoes;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public double getImdb() {
		return imdb;
	}
	public void setImdb(double imdb) {
		this.imdb = imdb;
	}
	public int getRelease_year() {
		return release_year;
	}
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	public int getRottent_tomatoes() {
		return rottent_tomatoes;
	}
	public void setRottent_tomatoes(int rottent_tomatoes) {
		this.rottent_tomatoes = rottent_tomatoes;
	}
}
