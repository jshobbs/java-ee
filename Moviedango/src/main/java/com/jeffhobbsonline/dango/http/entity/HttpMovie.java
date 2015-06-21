package com.jeffhobbsonline.dango.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jeffhobbsonline.dango.entity.Movie;

/**
 * Select fields we want exposed to the REST layer. Separation from business/data layer. 
 * 
 * Note "XML" annotation. The resteasy-jettison implementation converts these to JSON depending on
 * the Accept media type
 * 
 * @author jeff
 *
 */
@XmlRootElement(name = "movie")
public class HttpMovie {
		
	@XmlElement
	public int id;
		
	@XmlElement
	public String movieName;
		
	@XmlElement
	public int playLength;
		
	@XmlElement
	public String description;
		
	@XmlElement
	public String studio;
	
	@XmlElement
	public String category;
	
	//required by framework
	protected HttpMovie() {}

	public HttpMovie(Movie movie) {
		this.id = movie.getMovieID();
		this.movieName = movie.getMovieName();
		this.playLength = movie.getMoviePlayLength();
		this.description = movie.getMovieDescription();
		this.studio = movie.getMovieStudio();
		this.category = movie.getMovieCategory();
	}
}