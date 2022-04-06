import java.util.Scanner;
public class SinoTheWalker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] timeLeaves = input.split(":");
        int hours = Integer.parseInt(timeLeaves[0]);
        int minutes = Integer.parseInt(timeLeaves[1]);
        int seconds = Integer.parseInt(timeLeaves[2]);
        int numberOfSteps = Integer.parseInt(scanner.nextLine());
        int timeForEachStep = Integer.parseInt(scanner.nextLine());
        int timeInSecondsLeaves = hours * 3600 + minutes * 60 + seconds;
        int timeForMove = numberOfSteps * timeForEachStep;
        int timeToGoHome = timeInSecondsLeaves + timeForMove;
        hours = timeToGoHome / 3600;
        if (hours > 24) {
            hours -= 24;
        }
        minutes = (timeToGoHome % 3600) / 60;
        seconds = timeToGoHome % 60;
        System.out.printf("Time Arrival: %02d:%02d:%02d", hours, minutes, seconds);
    }
}
