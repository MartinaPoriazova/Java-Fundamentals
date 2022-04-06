import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double pricesWithOutTaxes = 0;

        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println( "Invalid price!");
            } else {
                pricesWithOutTaxes += price;
            }
            input = scanner.nextLine();
        }
        double taxesSum = pricesWithOutTaxes * 0.20;
        double priceWithTaxes = pricesWithOutTaxes + taxesSum;
        if (input.equals("special")) {
            priceWithTaxes -= priceWithTaxes * 0.10;
        }
        if (priceWithTaxes == 0) {
            System.out.println("Invalid order!\n");
            return;
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", pricesWithOutTaxes);
            System.out.printf("Taxes: %.2f$\n", taxesSum);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", priceWithTaxes);
        }
    }
}
