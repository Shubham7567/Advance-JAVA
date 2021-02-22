package MamsXML;

public class Movie {

	private String name;
	private String directors;
	private int runtime;
	private int released;
	private String cast;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public String getDirectors() {
		return directors;
	}
	public void setDirectors(String directors) {
		this.directors = directors;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public int getReleased() {
		return released;
	}
	public void setReleased(int released) {
		this.released = released;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}

	@Override
	public String toString() {
		/*return "Movie [name=" + name + ", directors=" + directors
				+ ", runtime=" + runtime + ", released=" + released + ", cast="
				+ cast + "]";*/
				
				return "Movie:: [name=" + name + " , directors=" + directors 
				+ ",  runtime=" + runtime + ", released=" + released + ",  cast=" + cast + "]";

					
				/*return "Employee:: ID="+this.id+" Name=" + this.name + " Age=" + this.age + " Gender=" + this.gender +
                " Role=" + this.role; */

}
}