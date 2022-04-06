import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        Map<String, Integer> junkMaterials = new TreeMap<>();
        boolean isNotEnoughMaterial = true;

        while (isNotEnoughMaterial) {
            String[] input = scanner.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < input.length - 1; i += 2) {
                String resource = input[i + 1];
                int quantity = Integer.parseInt(input[i]);

                if (keyMaterials.containsKey(resource)) {
                    keyMaterials.put(resource, keyMaterials.get(resource) + quantity);

                    if (keyMaterials.get("shards") >= 250) {
                        keyMaterials.put(resource, keyMaterials.get(resource) - 250);
                        isNotEnoughMaterial = false;
                        System.out.println("Shadowmourne obtained!");
                        break;

                    } else if (keyMaterials.get("motes") >= 250) {
                        keyMaterials.put(resource, keyMaterials.get(resource) - 250);
                        isNotEnoughMaterial = false;
                        System.out.println("Dragonwrath obtained!");
                        break;

                    } else if (keyMaterials.get("fragments") >= 250) {
                        keyMaterials.put(resource, keyMaterials.get(resource) - 250);
                        isNotEnoughMaterial = false;
                        System.out.println("Valanyr obtained!");
                        break;
                    }
                } else {
                    junkMaterials.putIfAbsent(resource, 0);
                    junkMaterials.put(resource, junkMaterials.get(resource) + quantity);
                }
            }
        }

        keyMaterials.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        junkMaterials.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
