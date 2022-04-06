import java.util.Scanner;

public class BeerKegs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countKegs = Integer.parseInt(scanner.nextLine());
        double maxVolume = Double.MIN_VALUE;
        String maxModel = "";

        for (int keg = 1; keg <= countKegs; keg++) {
            String model = scanner.nextLine(); // model
            double radius = Double.parseDouble(scanner.nextLine()); // radius
            int height = Integer.parseInt(scanner.nextLine()); // height

            double volume = Math.PI * Math.pow(radius, 2) * height;
            // проверка дали всеки от обемите е максимален
            if (volume > maxVolume) {
                maxVolume = volume;
                maxModel = model;
            }
        }
        System.out.println(maxModel);
    }
}
