import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        List<Album> albums = new ArrayList<>();

        while (!exit) {
            System.out.println("For creating a new Album input 1, for editing an existing Album input 2, for deleting Albums or tracks of Albums input 3, for exiting the program type 4:");

            try {
                int input = sc.nextInt();
                sc.nextLine();

                switch (input) {
                    case 1:
                        addAlbum(albums);
                        break;
                    case 2:
                        editAlbum(albums, sc);
                        break;
                    case 3:
                        deleteAlbumOrTrack(albums, sc);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a valid number.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                sc.next();
            }
        }
        sc.close();
    }

    // Method to add an album
    public static void addAlbum(List<Album> albums) {
        Album album = Album.addAlbum();
        albums.add(album);
        System.out.println("Album added successfully");
    }

    // Method to edit an album
    public static void editAlbum(List<Album> albums, Scanner sc) {
        if (albums.isEmpty()) {
            System.out.println("No albums to edit.");
            return;
        }

        Manager.listAlbums(albums);
        System.out.println("Please input the Album ID to edit:");
        int albumId = sc.nextInt();
        sc.nextLine();

        Album albumToEdit = findAlbumById(albums, albumId);
        if (albumToEdit != null) {
            albumToEdit.editAlbum();
        } else {
            System.out.println("Album not found.");
        }
    }

    // Method to delete an album or track
    public static void deleteAlbumOrTrack(List<Album> albums, Scanner sc) {
        if (albums.isEmpty()) {
            System.out.println("No albums to delete.");
            return;
        }

        System.out.println("Input 1 for deleting a whole Album, input 2 for deleting single tracks of an Album:");
        int input = sc.nextInt();
        sc.nextLine();

        switch (input) {
            case 1:
                Manager.listAlbums(albums);
                System.out.println("Input Album ID of Album to delete:");
                int albumId = sc.nextInt();
                sc.nextLine();
                Album albumToRemove = findAlbumById(albums, albumId);

                if (albumToRemove != null) {
                    albums.remove(albumToRemove);
                    System.out.println("Album removed successfully.");
                } else {
                    System.out.println("Album not found.");
                }
                break;

            case 2:
                Manager.listAlbums(albums);
                System.out.println("Input Album ID to delete tracks from:");
                albumId = sc.nextInt();
                sc.nextLine();
                Album albumToUpdate = findAlbumById(albums, albumId);

                if (albumToUpdate != null) {
                    System.out.println("Input track ID to remove:");
                    int trackId = sc.nextInt();
                    sc.nextLine();

                    if (albumToUpdate.getTracks().remove(trackId) != null) {
                        System.out.println("Track removed successfully.");
                    } else {
                        System.out.println("Track not found.");
                    }
                } else {
                    System.out.println("Album not found.");
                }
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }
    }


    public static Album findAlbumById(List<Album> albums, int id) {
        for (Album album : albums) {
            if (album.getId() == id) {
                return album;
            }
        }
        return null;
    }
}
