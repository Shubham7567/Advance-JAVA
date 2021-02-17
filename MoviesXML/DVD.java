package MoviesXML;

import java.util.List;

public class DVD {
    private String name;
    private List movies;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public List getMovies()
    {
        return movies;
    }
    public void setMovies(List movies)
    {
        this.movies = movies;
    }
}
