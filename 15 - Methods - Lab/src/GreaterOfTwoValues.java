import java.util.Scanner;

public class GreaterOfTwoValues {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                getMax(firstNum, secondNum);
                System.out.println(getMax(firstNum, secondNum));
                break;
            case "char":
                char first = scanner.nextLine().charAt(0);
                char second = scanner.nextLine().charAt(0);
                getMax(first, second);
                System.out.println(getMax(first, second));
                break;
            case "string":
                String firstName = scanner.nextLine();
                String secondName = scanner.nextLine();
                getMax(firstName, secondName);
                System.out.println(getMax(firstName, secondName));
                break;
        }
    }

    public static int getMax(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            return firstNum;
        } else {
            return secondNum;
        }
        //return Math.Max(first, second);
    }

    public static char getMax(char first, char second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
        //return (char) Math.Max(first, second);
    }

    public static String getMax(String firstName, String secondName) {
        if (firstName.compareTo(secondName) >= 0) {
            return firstName;
        } else {
            return secondName;
        }
    }
}
