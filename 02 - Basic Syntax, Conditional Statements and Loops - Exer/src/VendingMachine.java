import java.util.Scanner;

public class VendingMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sumEnteredCoins = 0.0;

        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1.0 || coin == 2.0) {
                sumEnteredCoins += coin;
            } else {
                System.out.printf("Cannot accept %.2f\n", coin);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        double price = 0.0;
        boolean invalidProduct = false;
        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    invalidProduct = true;
                    break;
            }
            sumEnteredCoins = sumEnteredCoins - price;

            if (invalidProduct) {
                System.out.println("Invalid product");
            } else if (sumEnteredCoins >= 0) {
                System.out.printf("Purchased %s\n", input);
            } else {
                sumEnteredCoins = sumEnteredCoins + price;
                System.out.println("Sorry, not enough money");
            }

            input = scanner.nextLine();
            invalidProduct = false;
        }

        System.out.printf("Change: %.2f", sumEnteredCoins);
    }
}
