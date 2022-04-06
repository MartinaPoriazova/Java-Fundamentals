import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append(input);

        while (!input.equals("Done")) {
            String[] inputArray = input.split("\\s+");
            String command = inputArray[0];

            switch (command) {
                case "Change": //Change {char} {replacement}"
                    String char1 = inputArray[1];
                    String replacement = inputArray[2];
                    String result = "";

                    if (inputBuilder.toString().contains(char1)) {
                        result = inputBuilder.toString().replaceAll(char1, replacement);
                        inputBuilder = new StringBuilder(result);
                    }
                    System.out.println(inputBuilder);
                    break;
                case "Includes":
                    String otherString = inputArray[1];
                    if (inputBuilder.toString().contains(otherString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String otherString2 = inputArray[1];
                    if (inputBuilder.toString().endsWith(otherString2)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    String result2 = inputBuilder.toString().toUpperCase();
                    inputBuilder = new StringBuilder(result2);
                    System.out.println(inputBuilder);
                    break;
                case "FindIndex":
                    String char2 = inputArray[1];
                    int indexFirst = inputBuilder.toString().indexOf(char2);
                    System.out.println(indexFirst);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(inputArray[1]);
                    int length = Integer.parseInt(inputArray[2]);

                    String substring = inputBuilder.substring(startIndex, length + startIndex);
                    inputBuilder = new StringBuilder(substring);
                    System.out.println(inputBuilder);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
