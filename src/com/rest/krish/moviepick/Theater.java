package com.rest.krish.moviepick;

/**
 * This class is intended to hold Theater related attributes
 * 
 * @author Krishma N A <br>
 * 		Spring 2017
 *
 */
public class Theater {
	
	public Integer id;
	
	public String theaterName;
	
	public String showtimes;
	
	public String address;
	
	public String movieList;

	public Theater(Integer id, String theaterName, String showtimes, String address, String movieList) {
		this.id = id;
		this.theaterName = theaterName;
		this.showtimes = showtimes;
		this.address = address;
		this.movieList = movieList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(String showtimes) {
		this.showtimes = showtimes;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMovieList() {
		return movieList;
	}

	public void setMovieList(String movieList) {
		this.movieList = movieList;
	}

}
