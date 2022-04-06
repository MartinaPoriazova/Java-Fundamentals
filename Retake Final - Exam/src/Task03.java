import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> petFood = new TreeMap<>();
        int sellCounter = 0;

        while (!input.equals("Complete")) {
            String[] inputArray = input.split("\\s+");
            String command = inputArray[0];
            int quantity = Integer.parseInt(inputArray[1]);
            String food = inputArray[2];

            switch (command) {
                case "Receive":
                    if (quantity <= 0) {
                        continue;
                    }
                    if (!petFood.containsKey(food)) {
                        petFood.put(food, quantity);
                    } else {
                        petFood.put(food, petFood.get(food) + quantity);
                    }
                    break;
                case "Sell":
                    if (!petFood.containsKey(food)) {
                        System.out.printf("You do not have any %s.\n", food);
                        break;
                    }
                    if (petFood.get(food) < quantity) {
                        sellCounter = sellCounter + Math.abs(petFood.get(food) - quantity);
                        petFood.remove(food);
                        System.out.printf("There aren't enough %S. You sold the last %d of them.\n", food,
                                Math.abs(petFood.get(food) - quantity));
                    } else {
                        int newQuantity = petFood.get(food) - quantity;
                        petFood.put(food, newQuantity);
                        sellCounter = sellCounter + Math.abs(quantity);
                        if (newQuantity == 0) {
                            petFood.remove(food);

                        }
                        System.out.printf("You sold %d %s.\n", quantity, food);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        petFood.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
        System.out.printf("All sold: %d goods", sellCounter);
    }
}
