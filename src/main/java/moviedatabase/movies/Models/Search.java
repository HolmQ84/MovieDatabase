package moviedatabase.movies.Models;

public class Search {
    private int option;
    private String text;

    public Search(int option, String text) {
        this.option = option;
        this.text = text;
    }

    public Search() {
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
