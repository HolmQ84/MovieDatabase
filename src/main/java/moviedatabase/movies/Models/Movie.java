package moviedatabase.movies.Models;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private String description;
    private int year;
    private List<Rating> ratings = new ArrayList<>();
    private int ratingCounter = 0;
    private int duration;
    private String pictureURL;
    private String videoURL;

    public Movie(String title, String genre, String description, int year, int duration, String pictureURL, String videoURL) {
        Random random = new Random();
        this.movieId = random.nextInt(89999998)+10000001;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.year = year;
        this.duration = duration;
        this.pictureURL = pictureURL;
        this.videoURL = videoURL;
    }

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        double total = 0.0;
        for (Rating current: ratings) {
            total += current.getRating();
        }
        double finalTotal = total;
        finalTotal /= ratings.size();
        return Math.round(finalTotal*10)/10.0;
    }

    public void setRating(int userId, int newRating) {
        boolean ratingFromUserExists = false;
        for (Rating current : ratings) {
            if (current.getUserId() == userId) {
                current.setRating(newRating);
                ratingFromUserExists = true;
                break;
            }
        }
        if (!ratingFromUserExists) {
            ratings.add(new Rating(userId, newRating));
            ratingCounter++;
        }
    }

    public int getRatingCounter() {
        return ratingCounter;
    }

    public int getNumberOfRatings() {
        return ratings.size();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}