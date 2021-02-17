package MoviesXML;

public class Movie {
    private String name;
    private String director;
    private int runtime;
    private int released;
    private String cast;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getDirector()
    {
        return director;
    }
    public void setDirector(String director)
    {
        this.director = director;
    }
    public int getRunTime()
    {
        return runtime;
    }
    public void setRunTime(int runTime)
    {
        runtime = runTime;
    }
    public int getReleased()
    {
        return released;
    }
    public void setReleased(int released)
    {
        this.released = released;
    }
    public String getCast()
    {
        return cast;
    }
    public void setCast(String cast)
    {
        this.cast = cast;
    }
    @Override
    public String toString()
    {
        return String.format("Name - %s\nDirector - %s \nCast - %s \nRunTime - %d \nReleased - %d", name,director,cast,runtime,released);
    }
}
