package com.rest.krish.moviepick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.krish.moviepickDAO.MoviePickDAO;


//list all movies: http://localhost:8080/MoviePick/rest/MoviePick/movies
//list all theaters: http://localhost:8080/MoviePick/rest/MoviePick/theaters


/**
 * 
 * @author Krishma</br>
 *         Spring 2017
 *
 */

/**
 * MoviePick service implementation class The main path is /MoviePick
 */
@Path("/MoviePick")
public class MoviePickResource {

	/**
	 * Retrieve a movie entry and return it as a streaming output, using a JSON
	 * representation
	 * 
	 * @param id
	 *            path parameter identifying the movie entry
	 * @return a movie object requested; it will be converted to JSON using a
	 *         JSON provider
	 */

	// http://localhost:8080/MoviePick/rest/MoviePick/movies
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("movies")
	public List<Movie> getAllMovies() {

		List<Movie> allMovieList = new ArrayList<Movie>();
		MoviePickDAO moviePickDAO = new MoviePickDAO();
		allMovieList = moviePickDAO.getAllMovies();
		if (!allMovieList.isEmpty()) {
			System.out.println("" + allMovieList);
		} else {
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		return allMovieList;

	}
	
	// http://localhost:8080/MoviePick/rest/MoviePick/movies/{id}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("movies/{id}")
	public Movie getAllMoviesById(@PathParam("id") int id) {
		MoviePickDAO moviePickDAO = new MoviePickDAO();
		Movie movie = moviePickDAO.getMovieById(id);
		if (null == movie) {
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		} 
		return movie;
	}
	
	// http://localhost:8080/MoviePick/rest/MoviePick/theaters/{id}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("theaters/{id}")
	public Theater getAllTheatersById(@PathParam("id") int id) {
		MoviePickDAO moviePickDAO = new MoviePickDAO();
		Theater theater = moviePickDAO.getTheaterById(id);
		if (null == theater) {
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		} 
		return theater;
	}

	
	// http://localhost:8080/MoviePick/rest/MoviePick/theaters
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("theaters")
	public List<Theater> getalltheaters() {
		List<Theater> allTheaterList = new ArrayList<Theater>();
		MoviePickDAO moviePickDAO = new MoviePickDAO();
		allTheaterList = moviePickDAO.getAllTheaters();
		if(allTheaterList.isEmpty())
		{
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		return allTheaterList;
	}

	// http://localhost:8080/MoviePick/rest/MoviePick/movies/rating/4
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("movies/rating/{rating}")
	public List<Movie> getallmoviesbyrating(@PathParam("rating") float rating) {
		List<Movie> allMoviesByRating = new ArrayList<Movie>();
		MoviePickDAO moviePickDAO = new MoviePickDAO();
		allMoviesByRating = moviePickDAO.getAllMoviesByRating(rating);
		if(allMoviesByRating.isEmpty())
		{
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		return allMoviesByRating;

	}

	//http://localhost:8080/MoviePick/rest/MoviePick/movies/rating?rating=4&movieName=Rings
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("movies/rating")
	public String updatemoviesbyrating(@QueryParam("rating") float rating, @QueryParam("movieName") String movieName) {
		MoviePickDAO moviePickDAO = new MoviePickDAO();
		String responseString = "fail";
		if (moviePickDAO.updateMoviesByRating(rating, movieName)) {
			responseString = "success";
		}
		return responseString;
	}

	// http://localhost:8080/MoviePick/rest/MoviePick/movies/genre?genre=Drama
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("movies/genre")
	public List<Movie> getallmoviesbygenre(@QueryParam("genre") String genre) {

		List<Movie> allMovieList = new ArrayList<Movie>();
		MoviePickDAO moviePickDAO = new MoviePickDAO();
		allMovieList = moviePickDAO.getAllMoviesbyGenre(genre);
		if (!allMovieList.isEmpty()) {
			System.out.println("" + allMovieList);
		} else {
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		return allMovieList;

	}

	// http://localhost:8080/MoviePick/rest/MoviePick/movies/movieName?movieName=Rings
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("movies/movieName")
	public List<Movie> getallmovieByMovieName(@QueryParam("movieName") String movieName) {
		List<Movie> allMovieList = new ArrayList<Movie>();
		MoviePickDAO moviePickDAO = new MoviePickDAO();
		allMovieList = moviePickDAO.getMovieByName(movieName);
		if (!allMovieList.isEmpty()) {
			System.out.println("" + allMovieList);
		} else {
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		return allMovieList;

	}

	// http://localhost:8080/MoviePick/rest/MoviePick/movies/theatername?theaterName=Cine
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("movies/theatername")
	public List<String> getAllMoviesByTheatreName(@QueryParam("theatreName") String theatreName) {

		List<String> movieByTheatre = new ArrayList<String>();
		MoviePickDAO m = new MoviePickDAO();
		movieByTheatre = (ArrayList<String>) m.getAllMoviesByTheatreName(theatreName);
		if (!movieByTheatre.isEmpty()) {
			System.out.println("" + movieByTheatre);
		} else {
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		return movieByTheatre;
	}

	// http://localhost:8080/MoviePick/rest/MoviePick/theaters/moviename?movieName=Rings
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("theaters/moviename")
	public List<String> getAllTheatreByMovieName(@QueryParam("movieName") String movieName) {

		List<String> theatreByMovie = new ArrayList<String>();
		MoviePickDAO m = new MoviePickDAO();
		theatreByMovie = (ArrayList<String>) m.getTheatreByMovieName(movieName);
		if (!theatreByMovie.isEmpty()) {
			System.out.println("" + theatreByMovie);
		} else {
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		return theatreByMovie;
	}

	// http://localhost:8080/MoviePick/rest/MoviePick/movies/description?movieName=Rings
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("movies/description")
	public Map<String,String> getDescriptionByMovieName(@QueryParam("movieName") String movieName) {
        Map<String,String> response = new HashMap<String,String>();
		MoviePickDAO m = new MoviePickDAO();
		String description =  m.getDescriptionByMovieName(movieName);
		if (null == description) {
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		response.put("description", description);
		return response;

	}
	
	// http://localhost:8080/MoviePick/rest/MoviePick/movies/delete/{id}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("movies/delete/{id}")
	public void delete(@PathParam("id") int id) {
		MoviePickDAO moviePickDAO = new MoviePickDAO();
		moviePickDAO.deleteMovie(id);
	}
	
}
