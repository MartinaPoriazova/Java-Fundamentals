import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = Double.parseDouble(scanner.nextLine());
        String game = scanner.nextLine();
        double gamePrice = 0;
        double moneySpent = 0;
        boolean validGame = true;

        while (!game.equals("Game Time")) {
            switch (game) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    validGame = true;
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    validGame = true;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    validGame = true;
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    validGame = true;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    validGame = true;
                    break;
                default:
                    System.out.println("Not Found");
                    validGame = false;
                    break;
            }
            if (balance < gamePrice) {
                System.out.println("Too Expensive");
            } else if (balance >= gamePrice && validGame) {
                balance -= gamePrice;
                moneySpent += gamePrice;
                System.out.printf("Bought %s\n", game);
            }
            if (balance == 0) {
                System.out.println("Out of money!");
                return;
            }
            game = scanner.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", moneySpent, balance);
    }
}
