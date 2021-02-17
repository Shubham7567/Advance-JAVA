package MoviesXML;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
    DVD dvd = new DVD();
    List movieList = new ArrayList<>();
    Movie movie = null;
    String content = null;

    public void startElement(String namespaceURI,String localName,String qName,Attributes attributes)
    {
        if(qName.equals("dvd")){
            String dvdName = attributes.getValue("name");
            dvd.setName(dvdName);
        }else if(qName.equals("movie"))
        {
            movie = new Movie();
        }
    }
    public void endElement(String namespaceURI,String localName,String qName)
    {
        switch(qName){
            case "movie" :  movieList.add(movie); break;
            case "name" : movie.setName(content); break;
            case "director" : movie.setDirector(content); break;
            case "realeased" : movie.setReleased(Integer.parseInt(content)); break;
            case "runtime" : movie.setRunTime(Integer.parseInt(content)); break;
            case "cast" : movie.setCast(content); break;
            case "dvd" : dvd.setMovies(movieList);break;
        }
    }
    public void characters(char []ch,int start, int length)
    {
        content = new String(ch, start, length);
    }
    public DVD getDVD()
    {
        return dvd;
    }
}
