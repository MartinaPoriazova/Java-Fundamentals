import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> cityPopulation = new TreeMap<>();
        Map<String, Integer> cityGold = new TreeMap<>();

        while (!input.equals("Sail")) {
            String[] inputArray = input.split("\\|\\|");
            String city = inputArray[0];
            int population = Integer.parseInt(inputArray[1]);
            int gold = Integer.parseInt(inputArray[2]);
            if (!cityPopulation.containsKey(city)) {
                cityPopulation.put(city, population);
                cityGold.put(city, gold);
            } else {
                cityPopulation.put(city, (cityPopulation.get(city) + population));
                cityGold.put(city, (cityGold.get(city) + gold));
            }
            input = scanner.nextLine();
        }
        String commands = scanner.nextLine();
        while (!commands.equals("End")) {
            String[] commandArray = commands.split("=>");
            String command = commandArray[0];
            String town = commandArray[1];

            switch (command) {
                case "Plunder": // •	"Plunder=>{town}=>{people}=>{gold}"
                    int population = Integer.parseInt(commandArray[2]);
                    int gold = Integer.parseInt(commandArray[3]);
                    cityPopulation.put(town, cityPopulation.get(town) - population);
                    cityGold.put(town, cityGold.get(town) - gold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", town, gold, population);
                    if (cityGold.get(town) <= 0 || cityPopulation.get(town) <= 0) {
                        cityPopulation.remove(town);
                        cityGold.remove(town);
                        System.out.printf("%s has been wiped off the map!\n", town);
                    }
                    break;
                case "Prosper": // •	"Prosper=>{town}=>{gold}"
                    int gold2 = Integer.parseInt(commandArray[2]);
                    if (gold2 < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    } else {
                        cityGold.put(town, (cityGold.get(town) + gold2));
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n", gold2, town, cityGold.get(town));
                    }
                    break;
            }
            commands = scanner.nextLine();
        }
        if ((long) cityGold.entrySet().size() > 0) { //cityGold.entrySet().stream().count()
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", (long) cityGold.entrySet().size());
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
        cityGold.entrySet()
                .stream()
                .sorted((e1,e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(Entry -> //{town1} -> Population: {people} citizens, Gold: {gold} kg
                                System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",
                                        Entry.getKey(), cityPopulation.get(Entry.getKey()), Entry.getValue())
                        );
    }
}
