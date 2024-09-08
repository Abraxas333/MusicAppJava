import java.util.List;
import java.util.Scanner;

public class Manager {

    public static String validateInput(String sc) {
        Scanner scanner = new Scanner(System.in);
        String returnValue = "";
        while (!sc.matches("^[a-zA-Z\\s]+$")) {
            System.out.println("Invalid input detected, Please use only letters.");
            sc = scanner.nextLine();
        }
        returnValue = sc;
        return returnValue;
    }

    public static String validateDuration(String sc) {
        Scanner scanner = new Scanner(System.in);
        String returnValue = "";
        while (!sc.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$")) {
            System.out.println("Invalid input detected. Please input duration in the format hh:mm:ss:");
            sc = scanner.nextLine();
        }
        returnValue = sc;
        return returnValue;
    }

    public static void listAlbums(List<Album> albums) {
        for (Album v : albums) {
            System.out.println("ID: " + v.getId() + ", Title: " + v.getTitle() + ", Interpret: " + v.getInterpret() + ", Duration: " + v.getDuration() + ", Genre: " + v.getGenre());
        }
    }

    public static void editAlbum() {

    }
}