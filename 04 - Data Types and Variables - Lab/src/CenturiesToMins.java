import java.util.Scanner;

public class CenturiesToMins {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double centures = Double.parseDouble(scanner.nextLine());
        double years = centures * 100;
        double days = (double) (years * 365.2422);
        double hours = days * 24;
        double minutes = hours * 60;

        System.out.printf("%.0f centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes",
                centures, years, days, hours, minutes);
    }
}
