import java.util.Scanner;

public class ArrayRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // стринг, защото с числата няма да правим нищо
        String[] numbers = input.split(" "); // ще сплитне текста на части,разделени от интервала
        int countRotations = Integer.parseInt(scanner.nextLine()); // брой ротации

        for (int rotation = 1; rotation <= countRotations; rotation++) {
            //ротация

            // 1. взимаме 1 елемент
            String firstElement = numbers[0];

            // 2. местим всички елементи с 1 наляво, защото масивът не може да бъде добавян (индекс на ел = индекс -1)
            for (int index = 0; index < numbers.length - 1; index++) {
                numbers[index] = numbers[index + 1];
            }

            // 3. на последния индекс да стои 1 елемент
            numbers[numbers.length - 1] = firstElement;
        }

        System.out.println(String.join(" ", numbers));
//        for (String number:numbers) {
//            System.out.print(number + " ");
//        }
    }
}

