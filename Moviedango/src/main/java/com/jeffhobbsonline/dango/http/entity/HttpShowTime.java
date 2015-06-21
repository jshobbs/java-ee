package com.jeffhobbsonline.dango.http.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jeffhobbsonline.dango.entity.ShowTime;
import com.jeffhobbsonline.dango.entity.impl.MovieImpl;
import com.jeffhobbsonline.dango.entity.impl.TheaterImpl;

/**
 * Select fields we want exposed to the REST layer. Separation from business/data layer. 
 * 
 * Note "XML" annotation. The resteasy-jettison implementation converts these to JSON depending on
 * the Accept media type
 * 
 * @author jeff
 *
 */
@XmlRootElement(name = "showtime")
public class HttpShowTime {
		
	@XmlElement
	public int id;
		
	@XmlElement
	public Date showTime;
		
	@XmlElement
	public TheaterImpl theater;
		
	@XmlElement
	public MovieImpl movie;
		
	//required by framework
	protected HttpShowTime() {}

	public HttpShowTime(ShowTime showtime) {
		this.id = showtime.getShowTimeID();
		this.showTime = showtime.getShowTime();
		this.theater = (TheaterImpl) showtime.getTheater();
		this.movie = (MovieImpl) showtime.getMovie();
	}
}