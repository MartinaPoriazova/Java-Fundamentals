import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, Double> productsPrice = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> productsQuantity = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] product = input.split(" ");
            String productName = product[0];
            double singlePrice = Double.parseDouble(product[1]);
            int quantity = Integer.parseInt(product[2]);
            productsPrice.put(productName, singlePrice);

            if (productsQuantity.containsKey(productName)) {
                productsQuantity.put(productName, productsQuantity.get(productName) + quantity);
            } else {
                productsQuantity.putIfAbsent(productName, quantity);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : productsPrice.entrySet()) {
            //key (име на продукта) -> value (цена)
            //цена * количеството
            String productName = entry.getKey();
            double finalSum = entry.getValue() * productsQuantity.get(productName);
            System.out.printf("%s -> %.2f%n", productName, finalSum);
        }
    }
}
