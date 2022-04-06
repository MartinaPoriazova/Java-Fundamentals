import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        //{car}|{mileage}|{fuel}
        Map<String, Integer> carMileage = new TreeMap<>();
        Map<String, Integer> carFuel = new TreeMap<>();

        for (int i = 1; i <= numberOfCars ; i++) {
            String[] carsInfo = scanner.nextLine().split("\\|");
            String carName = carsInfo[0];
            int mileage = Integer.parseInt(carsInfo[1]);
            int fuel = Integer.parseInt(carsInfo[2]);
            carMileage.put(carName, mileage);
            carFuel.put(carName, fuel);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] inputArray = input.split(" : ");
            String command = inputArray[0];
            String car = inputArray[1];
            int currentFuel = carFuel.get(car);
            int currentMileage = carMileage.get(car);

            switch (command) {
                case "Drive": // •	Drive : {car} : {distance} : {fuel}
                    int distance = Integer.parseInt(inputArray[2]);
                    int fuel = Integer.parseInt(inputArray[3]);

                    if (currentFuel < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carMileage.put(car, currentMileage + distance);
                        carFuel.put(car, currentFuel - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n", car, distance, fuel);
                    }
                    if (carMileage.get(car) >= 100000) {
                        carMileage.remove(car);
                        carFuel.remove(car);
                        System.out.printf("Time to sell the %s!\n", car);
                    }
                    break;
                case "Refuel": //•	Refuel : {car} : {fuel}
                    int fuel2 = Integer.parseInt(inputArray[2]);
                    int increasedFuel = fuel2 + currentFuel;
                    if ((increasedFuel) > 75) {
                        increasedFuel = 75;
                    }
                    carFuel.put(car, increasedFuel);
                    System.out.printf("%s refueled with %d liters\n", car, increasedFuel - currentFuel);
                    break;
                case "Revert": //•	Revert : {car} : {kilometers}
                    int kilometers = Integer.parseInt(inputArray[2]);
                    int decreasedMileage = currentMileage - kilometers;

                    if (decreasedMileage < 10000) {
                        decreasedMileage = 10000;
                        carMileage.put(car, decreasedMileage);
                        break;
                    }
                    carMileage.put(car, decreasedMileage);
                    System.out.printf("%s mileage decreased by %d kilometers\n", car, kilometers);
                    break;
            }
            input = scanner.nextLine();
        }
        // "{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."
        carMileage.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(Entry ->
                        System.out.printf("%s -> Mileage: %s kms, Fuel in the tank: %d lt.\n",
                                Entry.getKey(), Entry.getValue(), carFuel.get(Entry.getKey()))
                );
    }
}
