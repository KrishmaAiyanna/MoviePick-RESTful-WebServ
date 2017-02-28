package operations;
// This client is using the new JAX-RS 2.0 client interface

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import java.net.MalformedURLException;
import java.net.URI;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Link;

import javax.ws.rs.client.Entity;

import org.xml.sax.InputSource;

import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;


// This client is using the new JAX-RS 2.0 client interface
//
public class Client 
{

    public static void main( String[] args )
    {
	BufferedReader br = null;
	String         output = null;

	try {


	    // === Retrieve list of movies using GET request and JSON representation ===
	    // ===============================================================================
		
		ResteasyClient client = new ResteasyClientBuilder().build();
	    ResteasyWebTarget target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/movies" );
		
	    System.out.println( "Retrieving person (JSON representation) from: http://localhost:8080/MoviePick/rest/MoviePick/movies" );
	   
	    Response response = target.request( MediaType.APPLICATION_JSON ).get();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "GET Request failed: HTTP code: " + response.getStatus() );
            }
	    else {
		System.out.println( "OK: Retrieved list of movies" );

		String p = response.readEntity( String.class );
		System.out.println(  p  );
		//System.out.println( prettyPrintJSON( p ) );
	    }
	    response.close();
	    
	 // === Retrieve movie by id using GET request and JSON representation ===
	    // ===============================================================================
	    
	    System.out.println();
		
	    target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/movies/1" );
		
	    System.out.println( "Retrieving movie (JSON representation) from: http://localhost:8080/MoviePick/rest/MoviePick/movies/1" );
	   
	    response = target.request( MediaType.APPLICATION_JSON ).get();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "GET Request failed: HTTP code: " + response.getStatus() );
            }
	    else {
		System.out.println( "OK: Retrieved movie with id 1" );

		String p = response.readEntity( String.class );
		System.out.println(  p  );
		System.out.println( prettyPrintJSON( p ) );
	    }
	    response.close();
	   
	    
	    // === Update movie rating using a PUT request and JSON representation ===
	    // =============================================================================
	    System.out.println();
	    System.out.println( "Updating movie rating: http://localhost:8080/MoviePick/rest/MoviePick/movies/rating?rating=4&movieName=Rings : (JSON): " + null );

	    // create a new target
            target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/movies/rating?rating=4&movieName=Rings" );
            response = target.request().put( Entity.entity( null, MediaType.APPLICATION_JSON ) );

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "PUT Request failed: HTTP code: " + response.getStatus() );
            }
	    else
		System.out.println( "OK: Updated rating=4 for movieName=Rings" );
	    response.close();
	    
	    // === Retrieve movie by id using GET request and JSON representation ===
	    // ===============================================================================
	    
	    System.out.println();
		
	    target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/movies/1" );
		
	    System.out.println( "Retrieving movie (JSON representation) from: http://localhost:8080/MoviePick/rest/MoviePick/movies/1" );
	   
	    response = target.request( MediaType.APPLICATION_JSON ).get();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "GET Request failed: HTTP code: " + response.getStatus() );
            }
	    else {
		System.out.println( "OK: Retrieved movie with id 1" );

		String p = response.readEntity( String.class );
		System.out.println(  p  );
		System.out.println( prettyPrintJSON( p ) );
	    }
	    response.close();
	    
	    
	    // === Delete the movie by id using DELETE request and JSON representation ===
	    // ===============================================================================
	    
	/*    System.out.println();
	    System.out.println( "deleting movie rating: http://localhost:8080/MoviePick/rest/MoviePick/movies/delete/21 : (JSON): " + null );

	    // create a new target
            target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/movies/delete/21" );
            response = target.request().delete();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "DELETE Request failed: HTTP code: " + response.getStatus() );
            }
	    else
		System.out.println( "OK: deleted rating=4 for movieName=Rings" );
	    response.close();
	    */
	    
	    // === Retrieve list of theaters using GET request and JSON representation ===
	    // ===============================================================================
	    
	    System.out.println();
		
	    target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/theaters" );
		
	    System.out.println( "Retrieving movie (JSON representation) from: http://localhost:8080/MoviePick/rest/MoviePick/theaters" );
	   
	    response = target.request( MediaType.APPLICATION_JSON ).get();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "GET Request failed: HTTP code: " + response.getStatus() );
            }
	    else {
		System.out.println( "OK: Retrieved list of theatres" );

		String p = response.readEntity( String.class );
		System.out.println(  p  );
		//System.out.println( prettyPrintJSON( p ) );
	    }
	    response.close();
	    
	    // === Retrieve theater by id using GET request and JSON representation ===
	    // ===============================================================================
	    
	    System.out.println();
		
	    target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/theaters/1" );
		
	    System.out.println( "Retrieving movie (JSON representation) from: http://localhost:8080/MoviePick/rest/MoviePick/theaters/1" );
	   
	    response = target.request( MediaType.APPLICATION_JSON ).get();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "GET Request failed: HTTP code: " + response.getStatus() );
            }
	    else {
		System.out.println( "OK: Retrieved list of theatres" );

		String p = response.readEntity( String.class );
		System.out.println(  p  );
		//System.out.println( prettyPrintJSON( p ) );
	    }
	    response.close();
	    
	    
	    // === Retrieve list of movies of rating 4 using GET request and JSON representation ===
	    // ===============================================================================
	    
	    System.out.println();
		
	    target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/movies/rating/4" );
		
	    System.out.println( "Retrieving movie (JSON representation) from: http://localhost:8080/MoviePick/rest/MoviePick/movies/rating/4" );
	   
	    response = target.request( MediaType.APPLICATION_JSON ).get();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "GET Request failed: HTTP code: " + response.getStatus() );
            }
	    else {
		System.out.println( "OK: Retrieved list of movies of rating 4" );

		String p = response.readEntity( String.class );
		System.out.println(  p  );
		//System.out.println( prettyPrintJSON( p ) );
	    }
	    response.close();

	    
	    // === Retrieve movies of a specific genre using GET request and JSON representation ===
	    // ===============================================================================
	    
	    System.out.println();
		
	    target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/movies/genre?genre=Drama" );
		
	    System.out.println( "Retrieving movie (JSON representation) from: http://localhost:8080/MoviePick/rest/MoviePick/movies/genre?genre=Drama" );
	   
	    response = target.request( MediaType.APPLICATION_JSON ).get();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "GET Request failed: HTTP code: " + response.getStatus() );
            }
	    else {
		System.out.println( "OK: Retrieved movie with genre of drama" );

		String p = response.readEntity( String.class );
		System.out.println(  p  );
		//System.out.println( prettyPrintJSON( p ) );
	    }
	    response.close();
	
	    
	    // === Retrieve details of a specific movie using GET request and JSON representation ===
	    // ===============================================================================
	    
	    System.out.println();
		
	    target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/movies/movieName?movieName=Rings" );
		
	    System.out.println( "Retrieving movie (JSON representation) from: http://localhost:8080/MoviePick/rest/MoviePick/movies/movieName?movieName=Rings" );
	   
	    response = target.request( MediaType.APPLICATION_JSON ).get();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "GET Request failed: HTTP code: " + response.getStatus() );
            }
	    else {
		System.out.println( "OK: Retrieved details of a movie" );

		String p = response.readEntity( String.class );
		System.out.println(  p  );
		//System.out.println( prettyPrintJSON( p ) );
	    }
	    response.close();
	 
	    
	    // === Retrieve list of movies in a theater using GET request and JSON representation ===
	    // ===============================================================================
	    
	    System.out.println();
		
	    target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/movies/theatername?theaterName=Cine" );
		
	    System.out.println( "Retrieving movie (JSON representation) from: http://localhost:8080/MoviePick/rest/MoviePick/movies/theatername?theaterName=Cine" );
	   
	    response = target.request( MediaType.APPLICATION_JSON ).get();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "GET Request failed: HTTP code: " + response.getStatus() );
            }
	    else {
		System.out.println( "OK: Retrieved list of moves in a theater" );

		String p = response.readEntity( String.class );
		System.out.println(  p  );
		//System.out.println( prettyPrintJSON( p ) );
	    }
	    response.close();
	    
	 // === Retrieve list of theaters playing a specific movie using GET request and JSON representation ===
	    // ===============================================================================
	    
	    System.out.println();
		
	    target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/theaters/moviename?movieName=Rings" );
		
	    System.out.println( "Retrieving movie (JSON representation) from: http://localhost:8080/MoviePick/rest/MoviePick/theaters/moviename?movieName=Rings" );
	   
	    response = target.request( MediaType.APPLICATION_JSON ).get();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "GET Request failed: HTTP code: " + response.getStatus() );
            }
	    else {
		System.out.println( "OK: Retrieved list of theaters playing a specific movie" );

		String p = response.readEntity( String.class );
		System.out.println(  p  );
		//System.out.println( prettyPrintJSON( p ) );
	    }
	    response.close();
	    
	    // === Retrieve description of a specific movie using GET request and JSON representation ===
	    // ===============================================================================
	    
	    System.out.println();
		
	    target = client.target( "http://localhost:8080/MoviePick/rest/MoviePick/movies/description?movieName=Rings" );
		
	    System.out.println( "Retrieving movie (JSON representation) from: http://localhost:8080/MoviePick/rest/MoviePick/movies/description?movieName=Rings" );
	   
	    response = target.request( MediaType.APPLICATION_JSON ).get();

            if( response.getStatus() != 200 ) {
                throw new RuntimeException( "GET Request failed: HTTP code: " + response.getStatus() );
            }
	    else {
		System.out.println( "OK: Retrieved description of a specific movie" );

		String p = response.readEntity( String.class );
		System.out.println(  p  );
		//System.out.println( prettyPrintJSON( p ) );
	    }
	    response.close();
	    
	} 
	catch( Exception e ) {
	    System.out.println( e );
	    e.printStackTrace();
	}
    }

    

    public static String prettyPrintJSON(String input)
    {
	JsonObject obj = new JsonParser().parse( input ).getAsJsonObject();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	return gson.toJson( obj );
    }
}
