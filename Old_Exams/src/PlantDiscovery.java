import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plants = new HashMap<>();
        Map<String, List<Double>> ratings = new HashMap<>();

        for (int i = 1; i <= number; i++) {
            String[] input = scanner.nextLine().split("<->");
            String plantName = input[0];
            int rarity = Integer.parseInt(input[1]);
            //plants.put(plantName, rarity);
            plants.compute(plantName, (k, v) -> rarity);
            ratings.putIfAbsent(plantName, new ArrayList<>());
        }
        String input = scanner.nextLine();;
        while (!input.equals("Exhibition")) {
            String[] inputArray = input.split(": ");
            String command = inputArray[0];
            String[] plantInfo = inputArray[1].split(" - ");
            String plantName = plantInfo[0];

            if (!plants.containsKey(plantName)) {
                System.out.println("error");
                continue;
            }

            switch (command) {
                case "Rate":
                    //•	Rate: {plant} - {rating}
                    double rating = Double.parseDouble(plantInfo[1]);
                    ratings.get(plantName).add(rating);
                    break;
                case "Update":
                    //•	Update: {plant} - {new_rarity}
                    int rarity = Integer.parseInt(plantInfo[1]);
                    //plants.replace(plantName, rarity);
                    plants.compute(plantName, (k, v) -> rarity);
                    break;
                case "Reset":
                    //•	Reset: {plant}
                    ratings.get(plantName).clear();
                    break;
                default:
                    System.out.println("error");
            }
        }
//{plant_name}; Rarity: {rarity}; Rating: {average_rating formatted to the 2nd digit}
        System.out.println("Plants for the exhibition:");
        plants.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparingDouble(x -> ratings.get(x.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0))
                        .reversed())
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(), e.getValue(),
                        ratings.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
    }
}
