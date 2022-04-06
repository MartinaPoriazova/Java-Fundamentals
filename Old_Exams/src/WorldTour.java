import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder inputResult = new StringBuilder();
        inputResult.append(input);

        while (!input.equals("Travel")) {
            String[] inputArray = input.split(":");
            String command = inputArray[0];

            switch (command) {
                //Add Stop:{index}:{string}
                case "Add Stop":
                    int index = Integer.parseInt(inputArray[1]);
                    String destination = inputArray[2];
                    if (index >= 0 && index < input.length()) {
                        inputResult.insert(index, destination);
                        System.out.println(inputResult);
                    }

                    break;
                //{start_index}:{end_index}
                case "Remove Stop":
                    int indexStart = Integer.parseInt(inputArray[1]);
                    int indexEnd = Integer.parseInt(inputArray[2]);
                    if ((indexStart >= 0 && indexStart <= input.length() - 1) && (indexEnd >= 0 && indexEnd <= input.length() - 1)) {
                            inputResult.delete(indexStart, indexEnd +1);
                            //input = inputResult.replace(indexStart, indexEnd, "").toString();
                        System.out.println(inputResult);
                    }

                    break;
                //{old_string}:{new_string}
                case "Switch":
                    String oldDestination = inputArray[1];
                    String newDestination = inputArray[2];
                    String result = inputResult.toString().replaceAll(oldDestination, newDestination);
                    inputResult = new StringBuilder(result);
                    System.out.println(inputResult);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", inputResult);
    }
}
//ackage com.softuni;
//
//import java.util.Scanner;
//
//public class WorldTour {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder initialDestination = new StringBuilder(scanner.nextLine());
//
//        String command = scanner.nextLine();
//        while (!command.equals("Travel")) {
//            String[] commandParts = command.split(":");
//            String commandName = commandParts[0];
//            switch (commandName) {
//                case "Add Stop":
//                    int insertIndex = Integer.parseInt(commandParts[1]);
//                    String textToInsert = commandParts[2];
//                    if (indexIsValid(insertIndex, initialDestination.toString())) {
//                        initialDestination.insert(insertIndex, textToInsert);
//                        System.out.println(initialDestination);
//                    }
//                    break;
//                case "Remove Stop":
//                    int removeBeginIndex = Integer.parseInt(commandParts[1]);
//                    int removeEndIndex = Integer.parseInt(commandParts[2]);
//                    if (indexIsValid(removeBeginIndex, initialDestination.toString())
//                            && indexIsValid(removeEndIndex, initialDestination.toString())) {
//                        initialDestination.delete(removeBeginIndex, removeEndIndex + 1);
//                    }
//                    System.out.println(initialDestination);
//                    break;
//                case "Switch":
//                    String oldString = commandParts[1];
//                    String newString = commandParts[2];
//                    String destinationAsString = initialDestination.toString();
//                    destinationAsString = destinationAsString.replaceAll(oldString, newString);
//                    initialDestination = new StringBuilder(destinationAsString);
//                    System.out.println(initialDestination);
//                    break;
//            }
//
//            command = scanner.nextLine();
//        }
//
//        System.out.printf("Ready for world tour! Planned stops: %s",  initialDestination);
//    }
//
//    public static boolean indexIsValid(int index, String text) {
//        return index >= 0 && index < text.length();
//    }
//}