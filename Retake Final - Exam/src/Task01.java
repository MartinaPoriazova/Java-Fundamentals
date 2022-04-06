import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append(email);

        while (!email.equals("Valid")) {
            String[] inputArray = email.split("\\s+");
            String command = inputArray[0];

            switch (command) {
                case "Upper":
                    int index = Integer.parseInt(inputArray[1]);
                    String result = inputBuilder.toString().toUpperCase();
                    String result1 = inputBuilder.toString().replace(inputBuilder.charAt(index), result.charAt(index));
                    inputBuilder = new StringBuilder(result1);
                    System.out.println(inputBuilder);
                    break;
                case "Lower":
                    int index1 = Integer.parseInt(inputArray[1]);
                    String result2 = inputBuilder.toString().toLowerCase();
                    String result3 = inputBuilder.toString()
                            .replace(inputBuilder.charAt(index1), result2.charAt(index1));
                    inputBuilder = new StringBuilder(result3);
                    System.out.println(inputBuilder);
                    break;
                case "Insert":
                    int index2 = Integer.parseInt(inputArray[1]);
                    String insertChar = inputArray[2];
                    inputBuilder = inputBuilder.insert(index2, insertChar);
                    System.out.println(inputBuilder);
                    break;
                case "Change":
                    String stringChar = inputArray[1];
                    char char2 = stringChar.charAt(0);
                    int value = Integer.parseInt(inputArray[2]);
                    int valueSum = value + (int) char2;
                    char char3 = (char) valueSum;
                    String replacement = Character.toString(char3);

                    if (inputBuilder.toString().contains(stringChar)) {
                        String result4 = inputBuilder.toString().replaceAll(stringChar, replacement);
                        inputBuilder = new StringBuilder(result4);
                    }
                    System.out.println(inputBuilder);
                    break;
                case "Validation":
                    if (inputBuilder.length() < 6) {
                        System.out.println("Email must consist at least one digit!");
                    }
                    int symbolsCounter = 0;
                    for (int i = 0; i < inputBuilder.length(); i++) {
                        char[] charArray = inputBuilder.toString().toCharArray();
                        if (Character.isLetterOrDigit(charArray[i]) || charArray[i] == '@') {
                            symbolsCounter++;
                        }
                    }
                    if (symbolsCounter == 0) {
                        System.out.println("Email must consist only of letters, digits and @!");
                    }
                    int counterUpper = 0;
                    for (int i = 0; i < inputBuilder.length(); i++) {
                        char[] charArray = inputBuilder.toString().toCharArray();
                        if (Character.isUpperCase(charArray[i])) {
                            counterUpper++;
                        }
                    }
                    if (counterUpper == 0) {
                        System.out.println("Email must consist at least one uppercase letter!");
                    }
                    int counterLower = 0;
                    for (int i = 0; i < inputBuilder.length(); i++) {
                        char[] charArray = inputBuilder.toString().toCharArray();
                        if (Character.isLowerCase(charArray[i])) {
                            counterLower++;
                        }
                    }
                    if (counterLower == 0) {
                        System.out.println("Email must consist at least one lowercase letter!");
                    }
                    int isDidit = 0;
                    for (int i = 0; i < inputBuilder.length(); i++) {
                        char[] charArray = inputBuilder.toString().toCharArray();
                        if (Character.isDigit(charArray[i])) {
                            isDidit++;
                        }
                    }
                    if (isDidit == 0) {
                        System.out.println("Email must consist at least one digit!");
                    }
                    break;
            }
            email = scanner.nextLine();
        }
    }
}
