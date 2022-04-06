import java.util.Scanner;

public class Task_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double foodKilo = Double.parseDouble(scanner.nextLine());
        double hayKilo = Double.parseDouble(scanner.nextLine());
        double coverKilo = Double.parseDouble(scanner.nextLine());
        double weightKilo = Double.parseDouble(scanner.nextLine());
        //kilos, per month

        double food = foodKilo * 1000;
        double hay = hayKilo * 1000;
        double cover = coverKilo * 1000;
        double weight = weightKilo * 1000;
        // every 2 day - hay = 0.05 * restFood
        // every 3 day - cover = weight / 3

        for (int i = 1; i <= 30; i++) {
            food -= 300;
            if (i % 2 == 0) {
                hay -= 0.05 * food;
            }
            if (i % 3 == 0) {
                cover -= weight / 3;
            }
            if (food <= 0 || hay <= 0 || cover <= 0) {
                System.out.println("Merry must go to the pet store!");
                return;
            }
        }
        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                food / 1000, hay / 1000, cover / 1000);
    }
}
