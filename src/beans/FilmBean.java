package beans;

import model.Film;

public class FilmBean {
    private int id;
    private String title;
    private int rating;

    public FilmBean(Film film){
        id = film.getId();
        title = film.getTitle();
        rating = film.getRating();
    }

    public int getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }
}
