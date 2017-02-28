package com.rest.krish.moviepick;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class is intended to hold Movie related attributes
 * 
 * @author Krishma N A <br>
 * 		Spring 2017
 *
 */
@XmlRootElement
public class Movie {

	public Integer id;
	
	public String movieName;
	
	public Float rating;
	
	public String genre;
	
	public String theaters;
	
	public String description;
	
	public Movie(Integer id, String movieName, Float rating, String genre, String theaters, String description) {
		this.id = id;
		this.movieName = movieName;
		this.rating = rating;
		this.genre = genre;
		this.theaters = theaters;
		this.description = description;
	}

	@XmlElement(required=true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement(required=true)
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@XmlElement(required=true)
	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	@XmlElement(required=true)
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@XmlElement(required=true)
	public String getTheaters() {
		return theaters;
	}

	public void setTheaters(String theaters) {
		this.theaters = theaters;
	}

	@XmlElement(required=true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		

}
