import java.util.Scanner;

public class ConvertMetersKilom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meters = Integer.parseInt(scanner.nextLine());

        double convertedKilometers = meters / 1000.0;
        System.out.printf("%.2f", convertedKilometers);
    }
}
