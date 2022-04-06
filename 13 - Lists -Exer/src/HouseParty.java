import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HouseParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandsCounter = Integer.parseInt(scanner.nextLine());
        List<String> guestList = new ArrayList<>();

        for (int i = 1; i <= commandsCounter; i++) {
            String command = scanner.nextLine();
            // String[] command = input.split("\\s+");
            String name = command.split("\\s+")[0];
            String inOut = command.split("\\s+")[2];

            switch (inOut) {
                case "going!":
                    if (guestList.contains(name)) {
                        System.out.println(name + " is already in the list!");
                    } else {
                        guestList.add(name);
                    }
                    break;
                case "not":
                    if (guestList.contains(name)) {
                        guestList.remove(name);
                    } else {
                        System.out.println(name + " is not in the list!");
                    }
                    break;
            }
        }

        for (String nameInTheList : guestList) {
            System.out.println(nameInTheList);
        }
    }
}
