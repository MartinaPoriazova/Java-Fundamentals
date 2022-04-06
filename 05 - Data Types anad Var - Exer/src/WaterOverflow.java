import java.util.Scanner;

public class WaterOverflow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int volume = 0;

        for (int time = 1; time <= lines; time++) {
            int temporaryVolume = Integer.parseInt(scanner.nextLine());
            volume += temporaryVolume;
            if (volume > capacity) {
                System.out.println("Insufficient capacity!");
                volume -= temporaryVolume;
            }

        }
        System.out.println(volume);
    }
}
