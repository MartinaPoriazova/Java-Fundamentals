import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lettersNum = Integer.parseInt(scan.nextLine());
        int num = Integer.parseInt(scan.nextLine());
        String numm = String.valueOf(num);
        String word = "";
        int mainDigit = num;
        int offset = 0;
        int index = 0;

        for (int i = 0; i < lettersNum; i++) {
            for (int j = 1; j < numm.length(); j++) {
                mainDigit = mainDigit / 10;
            }
            offset = (mainDigit - 2) * 3;
            index = (offset + numm.length() - 1) + 97;
            if (mainDigit == 8 || mainDigit == 9) {
                index += 1;
            }
            if (mainDigit == 0) {
                index = 32;
            }
            char symbol = (char) index;
            word += symbol;

            offset = 0;
            index = 0;
            if (lettersNum - 1 == i) {
                break;
            }
            num = Integer.parseInt(scan.nextLine());
            numm = String.valueOf(num);
            mainDigit = num;
        }
        System.out.println(word);
    }
}
//        int commands = Integer.parseInt(scanner.nextLine());
//
//        int currentNum = 0;
//        int mainDigit = 0;
//        int digitalLength = 0;
//        int offset = 0;
//        int letterIndex = 0;
//
//
//        for (int i = 0; i < commands; i++) {
//            currentNum = Integer.parseInt(scanner.nextLine());
//            while (currentNum != 0) {
//                mainDigit = currentNum % 10;
//                currentNum /= 10;
//                digitalLength++;
//            }
//            offset = (mainDigit - 2) * 3;
//            if (mainDigit == 8 || mainDigit == 9) {
//                offset += 1;
//            }
//            letterIndex = (offset + digitalLength - 1);
//            char symbol = (char) (letterIndex + 97);
//            if (digitalLength == 0) {
//                System.out.print(" ");
//            } else {
//                System.out.print(symbol);
//            }
//            digitalLength = 0;
//        }