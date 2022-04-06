import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean isTrue = true;
        int openBracketCounter = 0;
        int closingBracketCounter = 0;

        for (int i = 1; i <= n; i++) {
            String line = scanner.nextLine();

            if (line.equals("(")) {
                openBracketCounter++;
            }
            if (line.equals(")")) {
                closingBracketCounter++;
            }
        }
        if (closingBracketCounter == openBracketCounter) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
//package Fundamentals;
//
//import java.util.Scanner;
//
//public class FundamentalsDataTypesMore {
//    public static void main(String[] args) {
//
//
//        //06. Balanced Brackets
//
//        Scanner scan = new Scanner(System.in);
//        int numLines = Integer.parseInt(scan.nextLine());
//        int openBrackets = 0;
//        int closingBrackets = 0;
//        int consecutive = 0;
//
//        for (int i = 0; i < numLines; i++) {
//            String input = scan.nextLine();
//            if (input.equals("(")) {
//                openBrackets++;
//                consecutive++;
//                if (consecutive > 1) {
//                    break;
//                }
//
//            }
//            if (input.equals(")")) {
//                closingBrackets++;
//                if (consecutive == 0) {
//                    break;
//                }
//                consecutive--;
//            }
//        }
//        if (openBrackets - closingBrackets != 0 || consecutive > 1) {
//            System.out.println("UNBALANCED");
//        } else {
//            System.out.println("BALANCED");
//        }
//
//
//
//
//    }
//}