package moviedatabase.movies.Controllers;

import moviedatabase.movies.Models.Movie;
import moviedatabase.movies.Models.Rating;
import moviedatabase.movies.Services.MovieService;
import moviedatabase.movies.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@Controller
public class MovieController {

    private final Logger log = Logger.getLogger(Logger.class.getName());

    @Autowired
    MovieService movieService;
    @Autowired
    UserService userService;

    @GetMapping("/movies/{movieId}/{userId}")
    public String movieInfo(@PathVariable int movieId, @PathVariable int userId, Model model) {
        log.info("Kører Controller-metoden 'movieInfo'. ("+getClass()+")");
        model.addAttribute("currentMovie",movieService.findById(movieId));
        model.addAttribute("currentUser",userService.findById(userId));
        Rating rating = new Rating();
        model.addAttribute("currentRating",rating);
        log.info("'movieInfo' metoden korrekt udført. ("+getClass()+")");
        return "movies";
    }

    @PostMapping("/movies/{movieId}/{userId}")
    public String moviePost(@PathVariable int movieId, @PathVariable int userId, Model model, @ModelAttribute Rating rating) {
        log.info("Kører Controller-metoden 'moviePost'. ("+getClass()+")");
        model.addAttribute("user",userService.findById(userId));
        movieService.findById(movieId).setRating(userId, rating.getRating());
        log.info("'moviePost' metoden korrekt udført. ("+getClass()+")");
        return "redirect:/movies/{movieId}/{userId}";
    }

    @GetMapping("/movies/newMovie/{userId}")
    public String newMovie(Model model, @PathVariable int userId) {
        log.info("Kører Controller-metoden 'newMovie'. ("+getClass()+")");
        Movie movie = new Movie();
        model.addAttribute("newMovie",movie);
        model.addAttribute("user", userService.findById(userId));
        log.info("'newMovie' metoden korrekt udført. ("+getClass()+")");
        return "newMovie";
    }

    @PostMapping("/movies/newMovie/{userId}")
    public String createMovie(Model model, @ModelAttribute Movie newMovie, @PathVariable int userId) {
        log.info("Kører Controller-metoden 'createMovie'. ("+getClass()+")");
        model.addAttribute("user", userService.findById(userId));
        movieService.addNewMovie(newMovie.getTitle(),newMovie.getGenre(),newMovie.getDescription(),newMovie.getYear(),newMovie.getDuration(),newMovie.getPictureURL(),newMovie.getVideoURL());
        log.info("'createMovie' metoden korrekt udført. ("+getClass()+")");
        return "redirect:/home/{userId}";
    }

    @GetMapping("/movies/editMovie/{movieId}/{userId}")
    public String editMovie(Model model, @PathVariable int movieId, @PathVariable int userId) {
        Movie movie = movieService.findById(movieId);
        model.addAttribute("movie", movie);
        model.addAttribute("user", userService.findById(userId));
        return "editMovie";
    }

    @PostMapping("/movies/editMovie/{userId}")
    public String updateMovie(Model model, @ModelAttribute Movie movie, @PathVariable int userId) {
        log.info("Kører Controller-metoden 'updateMovie'. ("+getClass()+")");
        model.addAttribute("user", userService.findById(userId));
        movieService.editMovie(movieService.findById(movie.getMovieId()), movie.getTitle(), movie.getGenre(), movie.getDescription(), movie.getYear(), movie.getDuration(), movie.getPictureURL(),movie.getVideoURL());
        log.info("'updateMovie' metoden korrekt udført. ("+getClass()+")");
        return "redirect:/home/{userId}";
    }

    @GetMapping("/movies/deleteMovie/{movieId}/{userId}")
    public String deleteRequest(Model model, @PathVariable int movieId, @PathVariable int userId) {
        log.info("Kører Controller-metoden 'deleteRequest'. ("+getClass()+")");
        model.addAttribute("user",userService.findById(userId));
        model.addAttribute("movie",movieService.findById(movieId));
        log.info("'deleteRequest' metoden korrekt udført. ("+getClass()+")");
        return "deleteMovie";
    }

    @PostMapping("/movies/deleteMovie/{userId}")
    public String deleteMovie(@ModelAttribute Movie movie, @PathVariable int userId) {
        log.info("Kører Controller-metoden 'deleteMovie'. ("+getClass()+")");
        movieService.deleteMovie(movieService.findById(movie.getMovieId()));
        log.info("'deleteMovie' metoden korrekt udført. ("+getClass()+")");
        return "redirect:/home/{userId}";
    }
}
