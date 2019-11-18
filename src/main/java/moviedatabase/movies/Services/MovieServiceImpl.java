package moviedatabase.movies.Services;

import moviedatabase.movies.Models.Movie;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    private List<Movie> movieList = new ArrayList<>();

    public MovieServiceImpl() {
        generateMovies();
    }

    public void addNewMovie(String title, String genre, String description, int year, int duration, String pictureURL, String videoURL) {
        movieList.add(new Movie(title,genre,description,year,duration,pictureURL, videoURL));
    }

    public void editMovie(Movie movie, String title, String genre, String description, int year, int duration, String pictureURL, String videoURL) {
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setDescription(description);
        movie.setYear(year);
        movie.setDuration(duration);
        movie.setPictureURL(pictureURL);
        movie.setVideoURL(videoURL);
    }

    public void deleteMovie(Movie movie) {
        movieList.remove(movie);
    }

    public Movie findById(int id) {
        for (Movie current: movieList) {
            if (current.getMovieId() == id) {
                return current;
            }
        }
        return null;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    private void generateMovies() {
        movieList.add(new Movie("Titanic","Drama, Romantik","A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic. Together they fight to survive, when the ship suddenly hits an iceberg.",1997,194,"https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SY1000_CR0,0,671,1000_AL_.jpg", "https://www.youtube.com/embed/2e-eXJ6HgkQ"));
        movieList.add(new Movie("Die Hard","Action, Thriller","An NYPD officer tries to save his wife and several others taken hostage by German terrorists during a Christmas party at the Nakatomi Plaza in Los Angeles.",1988,132,"https://m.media-amazon.com/images/M/MV5BZjRlNDUxZjAtOGQ4OC00OTNlLTgxNmQtYTBmMDgwZmNmNjkxXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX182_CR0,0,182,268_AL_.jpg", "https://www.youtube.com/embed/jaJuwKCmJbY"));
        movieList.add(new Movie("Anchorman","Komedie","Ron Burgundy is San Diego's top-rated newsman in the male-dominated broadcasting of the 1970s, but that's all about to change for Ron and his cronies when an ambitious woman is hired as a new anchor.",2004,94,"https://m.media-amazon.com/images/M/MV5BMTQ2MzYwMzk5Ml5BMl5BanBnXkFtZTcwOTI4NzUyMw@@._V1_UX182_CR0,0,182,268_AL_.jpg", "https://www.youtube.com/embed/-T3wnP91OnI"));
        movieList.add(new Movie("Toy Story 4","Animation, Eventyr, Komedie","When a new toy called Forky joins Woody and the gang, a road trip alongside old and new friends reveals how big the world can be for a toy. They meet many new acquaintances and face a new enemy.",2019,100,"https://m.media-amazon.com/images/M/MV5BMTYzMDM4NzkxOV5BMl5BanBnXkFtZTgwNzM1Mzg2NzM@._V1_UX182_CR0,0,182,268_AL_.jpg", "https://www.youtube.com/embed/wmiIUN-7qhE"));
        movieList.add(new Movie("Zombieland","Eventyr, Komedie, Gyser","A shy student trying to reach his family in Ohio, a gun-toting tough guy trying to find the last Twinkie, and a pair of sisters trying to get to an amusement park join forces to travel across a zombie-filled America.",2004,88,"https://m.media-amazon.com/images/M/MV5BMTU5MDg0NTQ1N15BMl5BanBnXkFtZTcwMjA4Mjg3Mg@@._V1_UY268_CR5,0,182,268_AL_.jpg", "https://www.youtube.com/embed/8m9EVP8X7N8"));
        movieList.add(new Movie("Joker","Krimi, Drama, Thriller","A mentally-troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of bloody crime. This path brings him face-to-face with his alter-ego: The Joker.",2019,122,"https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg", "https://www.youtube.com/embed/-_DJEzZk2pc"));
        movieList.add(new Movie("Inglourious Basterds","Eventyr, Drama, Krig","In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owner's vengeful plans for the same.",2009,153,"https://m.media-amazon.com/images/M/MV5BOTJiNDEzOWYtMTVjOC00ZjlmLWE0NGMtZmE1OWVmZDQ2OWJhXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SY1000_SX675_AL_.jpg", "https://www.youtube.com/embed/KnrRy6kSFF0"));
        movieList.add(new Movie("Snatch","Komedie, Krimi","Unscrupulous boxing promoters, violent bookmakers, a Russian gangster, incompetent amateur robbers and supposedly Jewish jewelers fight to track down a priceless stolen diamond.",2000,104,"https://m.media-amazon.com/images/M/MV5BMTA2NDYxOGYtYjU1Mi00Y2QzLTgxMTQtMWI1MGI0ZGQ5MmU4XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SY1000_SX684_AL_.jpg", "https://www.youtube.com/embed/ni4tEtuTccc"));
        movieList.add(new Movie("Inception","Action, Eventyr, Sci-Fi","A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",2010,148,"https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg", "https://www.youtube.com/embed/YoHD9XEInc0"));
        movieList.add(new Movie("The Wolf of Wall Street","Biografi, Krimi, Drama","Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.",2013,180,"https://m.media-amazon.com/images/M/MV5BMjIxMjgxNTk0MF5BMl5BanBnXkFtZTgwNjIyOTg2MDE@._V1_SY1000_CR0,0,674,1000_AL_.jpg", "https://www.youtube.com/embed/iszwuX1AK6A"));
        movieList.add(new Movie("Sharknado","Action, Eventyr, Komedie","When a freak hurricane swamps Los Angeles, nature's deadliest killer rules sea, land, and air as thousands of sharks terrorize the waterlogged populace.",2013,86,"https://m.media-amazon.com/images/M/MV5BODcwZWFiNTEtNDgzMC00ZmE2LWExMzYtNzZhZDgzNDc5NDkyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,654,1000_AL_.jpg", "https://www.youtube.com/embed/M-pXDoe5a0E"));
        movieList.add(new Movie("Edward Scissorhands","Drama, Fantasy, Romantik","An artificial man, who was incompletely constructed and has scissors for hands, leads a solitary life. Then one day, a suburban lady meets him and introduces him to her world.",1990,105,"https://m.media-amazon.com/images/M/MV5BNDUxN2I5NDUtZjdlMC00NjlmLTg0OTQtNjk0NjAxZjFmZTUzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,675,1000_AL_.jpg", "https://www.youtube.com/embed/M94yyfWy-KI"));
        movieList.add(new Movie("Despicable Me","Animation, Komedie, Familie","When a criminal mastermind uses a trio of orphan girls as pawns for a grand scheme, he finds their love is profoundly changing him for the better.",2010,95,"https://m.media-amazon.com/images/M/MV5BMTY3NjY0MTQ0Nl5BMl5BanBnXkFtZTcwMzQ2MTc0Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg", "https://www.youtube.com/embed/sUkZFetWYY0"));
        movieList.add(new Movie("Batman Begins","Action, Eventyr","After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from corruption.",2005,140,"https://m.media-amazon.com/images/M/MV5BZmUwNGU2ZmItMmRiNC00MjhlLTg5YWUtODMyNzkxODYzMmZlXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SY1000_SX750_AL_.jpg", "https://www.youtube.com/embed/neY2xVmOfUM"));
        movieList.add(new Movie("City Of God","Drama, Krimi","In the slums of Rio, two kids' paths diverge as one struggles to become a photographer and the other a kingpin.",2002,130,"https://m.media-amazon.com/images/M/MV5BMGU5OWEwZDItNmNkMC00NzZmLTk1YTctNzVhZTJjM2NlZTVmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SY1000_CR0,0,677,1000_AL_.jpg", "https://www.youtube.com/embed/dcUOO4Itgmw"));
        movieList.get(0).setRating(47586948, 7); movieList.get(0).setRating(64546747, 5);
        movieList.get(1).setRating(43657686, 8); movieList.get(1).setRating(54645234, 5);
        movieList.get(2).setRating(12354533, 6); movieList.get(2).setRating(65454334, 8);
        movieList.get(3).setRating(45342322, 9); movieList.get(3).setRating(97765454, 7);
        movieList.get(4).setRating(64534323, 6); movieList.get(4).setRating(74354625, 7); movieList.get(4).setRating(23232543, 8); movieList.get(4).setRating(86575645, 6);
        movieList.get(5).setRating(65657574, 7);
        movieList.get(6).setRating(34565744, 6); movieList.get(6).setRating(57856432, 9); movieList.get(6).setRating(28452314, 6);
        movieList.get(7).setRating(36576854, 8); movieList.get(7).setRating(83536456, 7);
        movieList.get(8).setRating(95435234, 7); movieList.get(8).setRating(86453243, 6); movieList.get(8).setRating(53423423, 7);
        movieList.get(9).setRating(43423423, 7); movieList.get(9).setRating(24364533, 8); movieList.get(9).setRating(27454535, 7);
        movieList.get(10).setRating(37574554, 3); movieList.get(10).setRating(75433421, 2); movieList.get(10).setRating(53434244, 3); movieList.get(10).setRating(53423434, 1);
        movieList.get(11).setRating(23432424, 6); movieList.get(11).setRating(34352355, 7);
        movieList.get(12).setRating(45435345, 7); movieList.get(12).setRating(86756345, 6); movieList.get(12).setRating(85464333, 7);
        movieList.get(13).setRating(53434532, 5); movieList.get(13).setRating(64534234, 6); movieList.get(13).setRating(24334253, 8);
        movieList.get(14).setRating(34353252, 7); movieList.get(14).setRating(35235452, 6);
    }

    public List<Movie> searchMovies(String text, int option) {
        List<Movie> tempMovieList = new ArrayList<>();
        switch (option) {
            // Search by title
            case 1:
                for (Movie current : movieList) {
                    if (current.getTitle().toLowerCase().contains(text.toLowerCase())) {
                        tempMovieList.add(current);
                    }
                }
                break;
            // Search by genre
            case 2:
                for (Movie current : movieList) {
                    if (current.getGenre().toLowerCase().contains(text.toLowerCase())) {
                        tempMovieList.add(current);
                    }
                }
                break;
            // Search by year
            case 3:
                for (Movie current : movieList) {
                    if (current.getYear() == Integer.parseInt(text)) {
                        tempMovieList.add(current);
                    }
                }
                break;
        }
        return tempMovieList;
    }

    public void sortMovies(int option) {
        switch (option) {
            // Sort by title
            case 1:
                for (int i = 0;i<movieList.size();i++) {
                    for (int j = 0;j<movieList.size();j++) {
                        if (movieList.get(i).getTitle().compareTo(movieList.get(j).getTitle()) < 0) {
                            Movie temp = movieList.get(i);
                            movieList.set(i, movieList.get(j));
                            movieList.set(j, temp);
                        }
                    }
                }
                break;
            // Sort by year
            case 2:
                for (int i = 0;i<movieList.size();i++) {
                    for (int j = 0;j<movieList.size();j++) {
                        if (movieList.get(i).getYear() > movieList.get(j).getYear()) {
                            Movie temp = movieList.get(i);
                            movieList.set(i, movieList.get(j));
                            movieList.set(j, temp);
                        }
                    }
                }
                break;
            // Sort by rating
            case 3:
                for (int i = 0;i<movieList.size();i++) {
                    for (int j = 0;j<movieList.size();j++) {
                        if (movieList.get(i).getRating() > movieList.get(j).getRating()) {
                            Movie temp = movieList.get(i);
                            movieList.set(i, movieList.get(j));
                            movieList.set(j, temp);
                        }
                    }
                }
                break;
                // Sort by duration.
            case 4:
                for (int i = 0;i<movieList.size();i++) {
                    for (int j = 0;j<movieList.size();j++) {
                        if (movieList.get(i).getDuration() > movieList.get(j).getDuration()) {
                            Movie temp = movieList.get(i);
                            movieList.set(i, movieList.get(j));
                            movieList.set(j, temp);
                        }
                    }
                }
                break;
        }
    }
}
