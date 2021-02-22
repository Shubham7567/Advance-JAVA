package MamsXML;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXTest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();	
		SAXParser parser = parserFactor.newSAXParser();
	    SAXHandler handler = new SAXHandler();	  
	    //Path path = Paths.get("src/resources", "movies.xml");
		Path path = Paths.get("./MamsXML","movie.xml");
	    
		parser.parse(path.toFile(),handler);

	    DVD dvd=handler.getDVD();

        List<Movie> movies = dvd.getMovies();
        System.out.println("DVD Name : "+ dvd.getName());
        for(Movie m : movies){
        	System.out.println(m);
      }
	}
}