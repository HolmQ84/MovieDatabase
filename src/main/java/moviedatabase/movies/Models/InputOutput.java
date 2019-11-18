package moviedatabase.movies.Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class InputOutput {


    public void readFromFile(List<User> userlist) throws FileNotFoundException {
        Scanner scan1 = new Scanner(new File("users.txt"));
        String line = scan1.nextLine();
        Scanner scan2 = new Scanner(line);
        do {
            userlist.add(new User(scan2.nextInt(),scan2.next(), scan2.next(), scan2.next(), scan2.next(), scan2.nextBoolean()));
        } while (scan1.hasNextLine());
    }

    public void writeToFile(List<User> userlist) throws FileNotFoundException {
        PrintStream print = new PrintStream(new FileOutputStream(new File("users.txt")));
        for (User current: userlist) {
            print.println(current.toString());
        }
    }


}
