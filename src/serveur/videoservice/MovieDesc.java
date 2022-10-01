package serveur.videoservice;

import java.io.Serializable;

public class MovieDesc implements Serializable {

    private final String movieName;

    private final String isbn;

    private final String synopsis;

    public MovieDesc(String movieName, String isbn, String synopsis) {
        this.movieName = movieName;
        this.isbn = isbn;
        this.synopsis = synopsis;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getSynopsis() {
        return synopsis;
    }

    @Override
    public String toString() {
        return "film: " + movieName + " | synopsis: " + synopsis;
    }
}
