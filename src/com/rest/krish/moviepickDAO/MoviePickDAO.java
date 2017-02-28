package com.rest.krish.moviepickDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rest.krish.moviepick.Movie;
import com.rest.krish.moviepick.Theater;

public class MoviePickDAO {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://<url>";

	// Database credentials
	static final String USER = "username";
	static final String PASS = "password";

	public List<Movie> getAllMovies() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Movie> allMovieList = new ArrayList<Movie>();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select MovieID, MovieName, Rating, Genre, Theatres, Description from movie";
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int MovieID = rs.getInt("MovieID");
				String MovieName = rs.getString("MovieName");
				float Rating = rs.getFloat("Rating");
				String Genre = rs.getString("Genre");
				String Theatres = rs.getString("Theatres");
				String Description = rs.getString("Description");
				System.out.println("MovieID:" + MovieID + "MovieName+" + MovieName + "Rating+" + Rating + "Genre"
						+ Genre + "Theatres:" + Theatres + "Description" + Description);

				Movie movie = new Movie(MovieID, MovieName, Rating, Genre, Theatres, Description);
				allMovieList.add(movie);
			}
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allMovieList;
	}

	public List<Theater> getAllTheaters() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Theater> allTheaterList = new ArrayList<Theater>();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select * from theatre";
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int TheatreID = rs.getInt("TheatreID");
				String TheatreName = rs.getString("TheatreName");
				String Showtimes = rs.getString("Showtimes");
				String Address = rs.getString("Address");
				String Movie = rs.getString("Movie");
				System.out.println("TheatreName" + TheatreName);

				Theater theater = new Theater(TheatreID, TheatreName, Showtimes, Address, Movie);
				allTheaterList.add(theater);
			}

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allTheaterList;
	}

	public List<Movie> getAllMoviesByRating(float rating) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Movie> allMoviesByRating = new ArrayList<Movie>();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select * from movie where Rating = " + rating;
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int MovieID = rs.getInt("MovieID");
				String MovieName = rs.getString("MovieName");
				float Rating = rs.getFloat("Rating");
				String Genre = rs.getString("Genre");
				String Theatres = rs.getString("Theatres");
				String Description = rs.getString("Description");
				// System.out.println("MovieID:" +MovieID+ "MovieName+"
				// +MovieName+ "Rating+" +Rating+ "Genre" +Genre+ "Theatres:"
				// +Theatres+ "Description" +Description);

				System.out.println("MovieName+" + MovieName + "Rating+" + Rating);

				Movie movie = new Movie(MovieID, MovieName, Rating, Genre, Theatres, Description);
				allMoviesByRating.add(movie);
			}

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allMoviesByRating;
	}

	public boolean updateMoviesByRating(float rating, String movieName) {
		Connection conn = null;
		Statement stmt = null;
		int rs = 0;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "update movie set Rating = " + rating + " where MovieName = \'" + movieName + "\'";
			System.out.println("Executing update...");
			rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				System.out.println("Update successful...");
				return true;
			}

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<Movie> getAllMoviesbyGenre(String genre) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Movie> allMovieList = new ArrayList<Movie>();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select MovieID, MovieName, Rating, Genre, Theatres, Description from movie";
			if (genre != null && genre.length() > 0) {
				sql = sql + " where Genre like \'%" + genre + "%\'";
			}
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name

				int MovieID = rs.getInt("MovieID");
				String MovieName = rs.getString("MovieName");
				float Rating = rs.getFloat("Rating");
				String Genre = rs.getString("Genre");
				String Theatres = rs.getString("Theatres");
				String Description = rs.getString("Description");
				System.out.println("MovieID:" + MovieID + "MovieName+" + MovieName + "Rating+" + Rating + "Genre"
						+ Genre + "Theatres:" + Theatres + "Description" + Description);

				Movie movie = new Movie(MovieID, MovieName, Rating, Genre, Theatres, Description);
				allMovieList.add(movie);
			}
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allMovieList;
	}

	public Movie getMovieById(int movieId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Movie movie = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select MovieID, MovieName, Rating, Genre, Theatres , Description from movie where MovieID = " + movieId;
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			 rs.next(); 
			// Retrieve by column name
			int MovieID = rs.getInt("MovieID");
			String MovieName = rs.getString("MovieName");
			float Rating = rs.getFloat("Rating");
			String Genre = rs.getString("Genre");
			String Theatres = rs.getString("Theatres");
			String Description = rs.getString("Description");
			System.out.println("MovieID:" + MovieID + "MovieName+" + MovieName + "Rating+" + Rating + "Genre"
					+ Genre + "Theatres:" + Theatres + "Description" + Description);

			movie = new Movie(MovieID, MovieName, Rating, Genre, Theatres, Description);
			
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movie;
	}

	public Theater getTheaterById(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Theater theater = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select * from theatre where TheatreID = " + id;
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			 rs.next(); 
			// Retrieve by column name
			int TheatreID = rs.getInt("TheatreID");
			String TheatreName = rs.getString("TheatreName");
			String Showtimes = rs.getString("Showtimes");
			String Address = rs.getString("Address");
			String Movie = rs.getString("Movie");
			System.out.println("TheatreID:" + TheatreID + "TheatreName+" + TheatreName + "Showtimes+" + Showtimes + "Address"
					+ Address + "Movie:" + Movie);

			theater = new Theater(TheatreID, TheatreName, Showtimes, Address, Movie);
			
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return theater;
	}
	
	public List<Movie> getMovieByName(String movieName) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Movie> allMovieList = new ArrayList<Movie>();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select MovieID, MovieName, Rating, Genre, Theatres, Description from movie";
			if (movieName != null && movieName.length() > 0) {
				sql = sql + " where movieName = \'" + movieName + "\'";
			}
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int MovieID = rs.getInt("MovieID");
				String MovieName = rs.getString("MovieName");
				float Rating = rs.getFloat("Rating");
				String Genre = rs.getString("Genre");
				String Theatres = rs.getString("Theatres");
				String Description = rs.getString("Description");
				System.out.println("MovieName:" + MovieName + "Rating:" + Rating + "Genre:" + Genre + "Theatres:"
						+ Theatres + "Description:" + Description);

				Movie movie = new Movie(MovieID, MovieName, Rating, Genre, Theatres, Description);
				allMovieList.add(movie);
			}
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allMovieList;
	}

	public List<String> getTheatreByMovieName(String movie) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> theatreList = new ArrayList<String>();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select TheatreName from theatre";
			if (movie != null && movie.length() > 0) {
				sql = sql + " where Movie = \'" + movie + "\'";
			}

			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String theatreName = rs.getString("theatreName");
				System.out.println("Theatre:" + theatreName);

				String movietheatre = new String(theatreName);
				theatreList.add(movietheatre);
			}

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return theatreList;
	}

	public String getDescriptionByMovieName(String movieName) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String moviedesc = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select Description from movie";
			if (movieName != null && movieName.length() > 0) {
				sql = sql + " where MovieName = \'" + movieName + "\'";
			}

			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			rs.next();
			// Retrieve by column name

			moviedesc = rs.getString("Description");
			System.out.println("Description:" + moviedesc);


		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return moviedesc;
	}

	public List<String> getAllMoviesByTheatreName(String theatreName) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> movieList = new ArrayList<String>();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select Movie from theatre";
			if (theatreName != null && theatreName.length() > 0) {
				sql = sql + " where theatreName = \'" + theatreName + "\'";
			}

			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name

				String Movie = rs.getString("Movie");
				System.out.println("Movie:" + Movie);

				String movietheatre = new String(Movie);
				movieList.add(movietheatre);
			}

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}
	
	public void deleteMovie(int id) {
		Connection conn = null;
		Statement stmt = null;
		int rs = 0;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "delete from movie where MovieID =" + id;
			System.out.println("Deleting...");
			rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				System.out.println("Delete successful...");
			}

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
