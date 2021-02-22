package MamsXML;

import java.util.ArrayList;
import java.util.List;

//import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler{

	DVD dvd=new DVD();
	//private ArrayList movieList=new ArrayList();
	
	List movieList= new ArrayList<>();
	//List movieList=new ArrayList();
	
	//private List<Employee> empList = null;
	
	
	Movie movie=null;
	String content =null;	

	public void startElement(String namespaceURI,String localName,String qname,Attributes attributes) throws SAXException {				
		if(qname.equals("dvd")){
			String dvdName=attributes.getValue("name");
			dvd.setName(dvdName);
		}else if(qname.equals("movie")){
			movie=new Movie();
		}
	}
@Override
	public void endElement(String namespaceURI,String localName,String qname) throws SAXException {

		switch(qname){
		   case "movie":      movieList.add(movie);
		                       break;
		   case "name" :      movie.setName(content);
		                       break;
		   case "directors" : movie.setDirectors(content);
		                       break;
		   case "released"  : movie.setReleased(Integer.parseInt(content));   
		                       break;
		   case "runtime"   : movie.setRuntime(Integer.parseInt(content));
		                       break;
		   case "cast"      : movie.setCast(content);
		                       break;
		   case "dvd" : dvd.setMovies(movieList);
		                break;

		}

	}	
	public void characters(char[] ch,int start,int length){		
		content=new String(ch, start, length);
	}
	public DVD getDVD(){
		return dvd;
	}	
}