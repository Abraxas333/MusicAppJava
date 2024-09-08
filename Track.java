import java.util.Scanner;

public class Track {
    public String title;
    public String mp3name;
    public String duration;
    public String id;
    public int instanceCount = 0;

    public Track(String title, String mp3name, String duration) {
        this.title = title;
        this.mp3name = mp3name;
        this.duration = duration;
        this.id = String.valueOf(instanceCount+1);
        instanceCount++;
    }

    public static Track addTrack() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please add track title:");
        String title;
        String mp3name;
        String duration;

        // Track Title Validation
        title = Manager.validateInput(sc.nextLine());

        mp3name = title + ".mp3";

        System.out.println("Please input track duration");
        duration = Manager.validateDuration(sc.nextLine());

        return new Track(title, mp3name, duration);
    }

}
