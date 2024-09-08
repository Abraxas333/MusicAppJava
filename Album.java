import java.util.HashMap;
import java.util.Scanner;

public class Album {
    private static int instanceCount = 0;
    private int id;
    private String title;
    private String interpret;
    private static HashMap<Integer, Track> tracks;
    private String duration;
    private String genre;

    public Album(String title, String interpret, HashMap<Integer, Track> tracks, String duration, String genre) {
        this.title = title;
        this.interpret = interpret;
        this.tracks = tracks;
        this.duration = duration;
        this.genre = genre;
        instanceCount++;
        this.id = instanceCount;

    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    public static Album addAlbum() {
        Scanner sc = new Scanner(System.in);
        // Album values
        String title;
        String interpret;
        String duration;
        String genre;
        HashMap<Integer, Track> tracks = new HashMap<Integer, Track>();

        System.out.println("Please input album title:");
        String input = sc.nextLine();
        title = Manager.validateInput(input);

        System.out.println("Please input album interpret:");
        input = sc.nextLine();
        interpret = Manager.validateInput(input);

        System.out.println("Please input album duration in the format hh:mm:ss:");
        input = sc.nextLine();
        duration = Manager.validateDuration(input);

        System.out.println("Please input album genre:");
        input = sc.nextLine();
        genre = Manager.validateInput(input);

        boolean finished = false;
        int trackCount = 1;
        while (!finished) {
            Track track = Track.addTrack();
            tracks.put(trackCount, track);
            trackCount++;
            System.out.println("For adding another track input 0, for exiting the add track menu input 1:");

            switch (sc.nextInt()) {
                case 0:
                    continue;
                case 1:
                    finished = true;
                    break;
            }

        }
        return new Album(title, interpret, tracks, duration, genre);
    }

    public static void main(String[] args) {
        Album album = Album.addAlbum();
    }

    public static void retrieveAlbum(Album album) {
        System.out.println("Album id: " + album.getId());
        System.out.println("Album title: " + album.getTitle());
        System.out.println("Album interpret: " + album.getInterpret());
        System.out.println("Album duration: " + album.getDuration());
        System.out.println("Album genre: " + album.getGenre());
        for (Track i : tracks.values()) {
            System.out.println(i.title);
            System.out.println(i.duration);
            System.out.println(i.mp3name);
        }
    }

    public void editAlbum() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Current title: " + this.title + ". Enter new title or press enter to keep current:");
        String newTitle = sc.nextLine();
        if (!newTitle.isEmpty()) {
            this.title = newTitle;
        }

        System.out.println("Current interpret: " + this.interpret + ". Enter new interpret or press enter to keep current:");
        String newInterpret = sc.nextLine();
        if (!newInterpret.isEmpty()) {
            this.interpret = newInterpret;
        }

        System.out.println("Current duration: " + this.duration + ". Enter new duration (hh:mm:ss) or press enter to keep current:");
        String newDuration = sc.nextLine();
        if (!newDuration.isEmpty()) {
            this.duration = Manager.validateDuration(newDuration);
        }

        System.out.println("Current genre: " + this.genre + ". Enter new genre or press enter to keep current:");
        String newGenre = sc.nextLine();
        if (!newGenre.isEmpty()) {
            this.genre = newGenre;
        }

        System.out.println("Album updated successfully!");
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret){
        this.interpret = interpret;
    }

    public HashMap<Integer, Track> getTracks() {
        return tracks;
    }

    public void setTracks(HashMap<Integer, Track> tracks){
        Album.tracks = tracks;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public int getId() {
        return id;
    }


}
