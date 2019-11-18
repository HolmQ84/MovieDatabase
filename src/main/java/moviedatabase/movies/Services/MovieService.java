package moviedatabase.movies.Services;

import moviedatabase.movies.Models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    void addNewMovie(String title, String genre, String description, int year, int duration, String pictureURL, String videoURL);
    void editMovie(Movie movie, String title, String genre, String description, int year, int duration, String pictureURL, String videoURL);
    void deleteMovie(Movie movie);
    Movie findById(int id);
    List<Movie> searchMovies(String text, int option);
    void sortMovies(int option);
    List<Movie> getMovieList();

}
