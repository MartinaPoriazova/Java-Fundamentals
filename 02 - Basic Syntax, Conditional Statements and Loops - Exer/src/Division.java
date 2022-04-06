import java.util.Scanner;

public class Division {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int divider = 0;

        // проверка дали числото се дели от най - голямото към най - малкото, ако не се дели, дане проверява надолу
        if (number % 10 == 0) {
            divider = 10;
        } else if (number % 7 == 0) {
            divider = 7;
        } else if (number % 6 == 0) {
            divider = 6;
        } else if (number % 3 == 0) {
            divider = 3;
        } else if (number % 2 == 0) {
            divider = 2;
        }

        //ако нямаме делител
        if (divider == 0) {
            System.out.println("Not divisible");
        } else { //divider != 0
            System.out.println("The number is divisible by " + divider);
        }
    }
}
