import java.util.Scanner;

public class Calculations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                add(number1, number2);
                break;
            case "multiply":
                multiply(number1, number2);
                break;
            case "subtract":
                subtract(number1, number2);
                break;
            case "divide":
                divide(number1, number2);
                break;
        }
    }

    public static void add(int number1, int number2) {
        System.out.println(number1 + number2);
    }

    public static void multiply(int number1, int number2) {
        System.out.println(number1 * number2);
    }

    public static void subtract(int number1, int number2) {
        System.out.println(number1 - number2);
    }

    public static void divide(int number1, int number2) {
        System.out.println(number1 / number2);
    }
}
