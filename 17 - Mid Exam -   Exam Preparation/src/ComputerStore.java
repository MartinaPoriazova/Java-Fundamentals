import java.util.Scanner;

public class ComputerStore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalWithoutTaxes = 0;

        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);

            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                totalWithoutTaxes += price;
            }

            input = scanner.nextLine();
        }

        if (totalWithoutTaxes == 0) {
            System.out.println("Invalid order!");
            return;
        }

        double taxes = totalWithoutTaxes * 0.2;
        double finalPrice = totalWithoutTaxes + taxes;

        if (input.equals("special")) {
            finalPrice = finalPrice - 0.1 * finalPrice; // = finalPrice * 0.9
        }

        printReceipt(taxes, finalPrice, totalWithoutTaxes);
    }

    private static void printReceipt(double taxes, double finalPrice, double totalWithoutTaxes) {
        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$\n", totalWithoutTaxes);
        System.out.printf("Taxes: %.2f$\n", taxes);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$", finalPrice);
    }
}
