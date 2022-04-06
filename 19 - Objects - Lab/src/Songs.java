import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("_");
            String type = tokens[0];
            String name = tokens[1];
            String time = tokens[2];

            Song song = new Song(type, name, time);
            songs.add(song);
        }

        String type = scan.nextLine();
        if ("all".equals(type)) {
            for (Song song : songs) {
                System.out.println(song);
            }
        } else {
            for (Song song : songs) {
                if (song.getType().equals(type)) {
                    System.out.println(song);
                }
            }
        }
    }

    public static class Song {

        private String type;
        private String name;
        private String time;

        public Song(String type, String name, String time) {
            this.type = type;
            this.name = name;
            this.time = time;
        }

        public String getType() {
            return this.type;
        }

        public String toString() {
            return this.name;
        }
    }
}
 