//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//
//public class Messaging {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        List<Integer> numbers = Arrays.stream(scanner.nextLine()
//                .split(" "))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        List<String> message = Arrays.stream(scanner.nextLine()
//                .split(" "))
//                .collect(Collectors.toList());
//
//        for (int i = 0; i < numbers.size(); i++) {
//            int currentNumber = numbers.get(i);
//            int index = CalculateIndex(currentNumber);
//
//            char currentChar = GetCharFromMessage(index, message);
//            System.out.println(currentChar);
//
//            int realIndex = GetCharFromMessage(index, message);
//            String newMessage = message.remove(realIndex);
//            message = newMessage;
//        }
//        System.out.println();
//    }
//    private static int CalculateIndex(int number) {
//        int index = 0;
//        while (number > 0) {
//            int currentNumber = number % 10;
//            index += currentNumber;
//            number = number / 10;
//        }
//        return index;
//    }
//    private static char GetCharFromMessage(int index, String message) {
//        int countIndex = 0;
//        for (int i = 0; i < index; i++) {
//            countIndex++;
//            if (countIndex == message.length()) {
//                countIndex = 0;
//            }
//        }
//        char currentChar = message[countIndex];
//        return currentChar;
//
//    }
//}
