package java_class;

/**
 * Created by shafiz on 3/27/2017.
 */

public class Movie {
    //Creating some string private variable
    private String title, genre, year;
    public Movie(){
    }
    public Movie(String title, String genre, String year){
        this.title=title;
        this.genre=genre;
        this.year=year;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }
    public String getGenre(){
        return genre;
    }
    public void setYear(String year){
        this.year=year;
    }
    public String getYear(){
        return year;
    }
}
