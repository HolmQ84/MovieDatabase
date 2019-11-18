package moviedatabase.movies.Controllers;

import moviedatabase.movies.Models.*;
import moviedatabase.movies.Services.MovieService;
import moviedatabase.movies.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController {

    private final Logger log = Logger.getLogger(Logger.class.getName());

    @Autowired
    MovieService movieService;
    @Autowired
    UserService userService;

    @GetMapping("/home/{id}")
    public String home(@PathVariable int id, Model model) throws FileNotFoundException {
        log.info("Kører Controller-metoden 'home'. ("+getClass()+")");
        User current = userService.findById(id);
        model.addAttribute("user",current);
        List<Movie> movies = movieService.getMovieList();
        model.addAttribute("movies",movies);
        Rating rating = new Rating();
        model.addAttribute("currentRating", rating);
        Search search = new Search();
        model.addAttribute(search);
        log.info("'home' metoden korrekt udført. ("+getClass()+")");
        return "home";
    }

    @PostMapping("/home/{id}")
    public String search(Model model, @PathVariable int id, @ModelAttribute Search search) {
        log.info("Kører Controller-metoden 'search'. ("+getClass()+")");
        model.addAttribute("user", userService.findById(id));
        log.info("'search' metoden korrekt udført. ("+getClass()+")");
        return "redirect:/home/search/"+id+"/"+search.getOption()+"/"+search.getText();
    }

    @GetMapping("/home/search/{id}/{option}/{text}")
    public String searchList(@PathVariable int id, @PathVariable int option, @PathVariable String text, Model model) {
        log.info("Kører Controller-metoden 'searchList'. ("+getClass()+")");
        model.addAttribute("user", userService.findById(id));
        List<Movie> movies = movieService.searchMovies(text, option);
        model.addAttribute("movies", movies);
        Rating rating = new Rating();
        model.addAttribute("currentRating",rating);
        Search search = new Search();
        model.addAttribute("search",search);
        log.info("'searchList' metoden korrekt udført. ("+getClass()+")");
        return "searchList";
    }

    @PostMapping("/home/search/{id}/{movieId}/{option}/{text}")
    public String searchRate(@PathVariable int id, @PathVariable int movieId,@PathVariable int option, @PathVariable String text, Model model, @ModelAttribute Rating rating) {
        log.info("Kører Controller-metoden 'searchRate'. ("+getClass()+")");
        model.addAttribute("user", userService.findById(id));
        movieService.findById(movieId).setRating(id, rating.getRating());
        log.info("'searchRate' metoden korrekt udført. ("+getClass()+")");
        return "redirect:/home/search/{id}/{option}/{text}";
    }

    @PostMapping("/home/{movieId}/{id}")
    public String homeRate(@PathVariable int movieId, @PathVariable int id, Model model, @ModelAttribute Rating rating) {
        log.info("Kører Controller-metoden 'homeRate'. ("+getClass()+")");
        model.addAttribute("user", userService.findById(id));
        movieService.findById(movieId).setRating(id, rating.getRating());
        log.info("'homeRate' metoden korrekt udført. ("+getClass()+")");
        return "redirect:/home/{id}";
    }

    @PostMapping("/home/sorted/{id}")
    public String sortBy(@ModelAttribute Search search, @PathVariable int id, Model model) {
        log.info("Kører Controller-metoden 'sortBy'. ("+getClass()+")");
        model.addAttribute("user",userService.findById(id));
        movieService.sortMovies(search.getOption());
        log.info("'sortBy' metoden korrekt udført. ("+getClass()+")");
        return "redirect:/home/{id}";
    }

    @PostMapping("/home/sortedSearch/{id}/{option}/{text}")
    public String searchSort(@ModelAttribute Search search, @PathVariable int id, @PathVariable int option, @PathVariable String text, Model model) {
        log.info("Kører Controller-metoden 'searchSort'. ("+getClass()+")");
        model.addAttribute("user", userService.findById(id));
        movieService.sortMovies(search.getOption());
        log.info("'searchSort' metoden korrekt udført. ("+getClass()+")");
        return "redirect:/home/search/{id}/{option}/{text}";
    }
}