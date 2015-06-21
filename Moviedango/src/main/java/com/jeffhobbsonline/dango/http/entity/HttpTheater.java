package com.jeffhobbsonline.dango.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jeffhobbsonline.dango.entity.Theater;

/**
 * Select fields we want exposed to the REST layer. Separation from business/data layer. 
 * 
 * Note "XML" annotation. The resteasy-jettison implementation converts these to JSON depending on
 * the Accept media type
 * 
 * @author jeff
 *
 */
@XmlRootElement(name = "theater")
public class HttpTheater {
	@XmlElement
	public int id;
		
	@XmlElement
	public String theaterName;
		
	@XmlElement
	public String theaterAddress;
		
	@XmlElement
	public String theaterPhone;
	
	@XmlElement
	public int numberOfScreens;	
	
	//required by framework
	protected HttpTheater() {}

	public HttpTheater(Theater theater) {
		this.id = theater.getTheaterID();
		this.theaterName = theater.getTheaterName();
		this.theaterAddress = theater.getTheaterAddress();
		this.theaterPhone = theater.getTheaterPhone();
		this.numberOfScreens = theater.getNumberOfTheaters();
	}
}