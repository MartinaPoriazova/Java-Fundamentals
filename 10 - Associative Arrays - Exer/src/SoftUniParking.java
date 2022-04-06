import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, String> parkingList = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfCommands; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String username = input[1];

            switch (command) {
                case "register":
                    String licensePlateNumber = input[2];

                    if (parkingList.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s\n", licensePlateNumber);
                    } else {
                        parkingList.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully\n", username, licensePlateNumber);
                    }
                    break;

                case "unregister":
                    if (parkingList.containsKey(username)) {
                        System.out.printf("%s unregistered successfully\n", username);
                        parkingList.remove(username);
                    } else {
                        System.out.printf("ERROR: user %s not found\n", username);
                    }
                    break;
            }
        }

        for (Map.Entry<String, String> entry : parkingList.entrySet()) {
            System.out.printf("%s => %s\n", entry.getKey(), entry.getValue());
        }
    }
}
