import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append(input);


        while (!input.equals("Done")) {
            String[] inputArray = input.split("\\s+");
            String command = inputArray[0];

            switch (command) {
                case "TakeOdd":
                    StringBuilder inputWork = new StringBuilder();
                    for (int i = 0; i < inputBuilder.length(); i++) {
                        if (i % 2 != 0) {
                            inputWork.append(inputBuilder.charAt(i));
                        }
                    }
                    inputBuilder = inputWork;
                    System.out.println(inputBuilder);
                    break;
                case "Cut":
                    int index = Integer.parseInt(inputArray[1]);
                    int length = Integer.parseInt(inputArray[2]);
                    StringBuilder substring = new StringBuilder();
                    for (int i = index; i < index + length; i++) {
                        substring.append(inputBuilder.toString().charAt(i));
                    }
                    String result = inputBuilder.toString().replace(substring, "");
                    inputBuilder = new StringBuilder(result);
                    System.out.println(inputBuilder);
                    break;
                case "Substitute":
                    String substring2 = inputArray[1];
                    String substitute = inputArray[2];
                    String result2 = "";
                    if (inputBuilder.toString().contains(substring2)) {
                       result2 = inputBuilder.toString().replaceAll(substring2, substitute);
                        inputBuilder = new StringBuilder(result2);
                        System.out.println(inputBuilder);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", inputBuilder);
    }
}
