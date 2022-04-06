import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append(input);


        while (!input.equals("Reveal")) {
            String[] commandArray = input.split(":\\|:");
            String command = commandArray[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandArray[1]);
                    inputBuilder.insert(index, " ");
                    System.out.println(inputBuilder);
                    break;
                case "Reverse":
                    String substring = commandArray[1];
                    String result = "";
                    if (inputBuilder.toString().contains(substring)) {
                        StringBuilder reversedSubstring = new StringBuilder();
                        reversedSubstring.append(substring);
                        reversedSubstring.reverse();
                        inputBuilder.append(reversedSubstring);
                        result = inputBuilder.toString().replace(substring, "");
                        inputBuilder = new StringBuilder(result);
                        System.out.println(inputBuilder);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substringSecond = commandArray[1];
                    String replacementString = commandArray[2];
                    String result2 = "";

                    if (inputBuilder.toString().contains(substringSecond)) {
                        result2 = inputBuilder.toString().replaceAll(substringSecond, replacementString);
                        inputBuilder = new StringBuilder(result2);
                    }
                    System.out.println(inputBuilder);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", inputBuilder);
    }
}
