import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder rawCode = new StringBuilder();
        rawCode.append(text);

        String input = scanner.nextLine();
        while (!input.equals("Generate")) {
            String[] inputArray = input.split(">>>");
            String command = inputArray[0];

            switch (command) {
                case "Contains":
                    String substring = inputArray[1];
                    if (text.contains(substring)) {
                        System.out.printf("%s contains %s\n", text, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String Case = inputArray[1];
                    int startIndex = Integer.parseInt(inputArray[2]);
                    int endIndex = Integer.parseInt(inputArray[3]);
                    String toChange = text.substring(startIndex, endIndex);

                        if (Case.equals("Upper")) {
                            toChange = toChange.toUpperCase();
                            rawCode.replace(startIndex, endIndex, toChange);
                            text = rawCode.toString();
                        } else if (Case.equals("Lower")) {
                            toChange = toChange.toLowerCase();
                            rawCode.replace(startIndex, endIndex, toChange);
                            text = rawCode.toString();
                        }
                    System.out.println(text);
                    break;
                case "Slice":
                    int startIndex2 = Integer.parseInt(inputArray[1]);
                    int endIndex2 = Integer.parseInt(inputArray[2]);
                    //String toDel = input.substring(startIndex2, endIndex2);
                    rawCode.delete(startIndex2, endIndex2);
                    text = rawCode.toString();
                    System.out.println(text);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + text);
    }
}
