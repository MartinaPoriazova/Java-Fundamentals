import java.util.Scanner;

public class StrongNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // цифра -> факториел -> сумирам
        int number = Integer.parseInt(scanner.nextLine());
        // 1. да принтираме всички цифри на числото
        // взимаме последната цифра -> % 10
        // принтиране
        // махаме я от числото -> / 10
        // спираме, когато числото числото стане равно на 0 number==0
        // continue: number != 0

        int sumFact = 0;
        int startNumber = number; // началната стойност на числото

        while (number != 0) {
            int lastDigit = number % 10;

            // да намерим фактуриела на цифрата
            int fact = 1;
            for (int n = 1; n <= lastDigit; n++) {
                fact = fact * n;
            }

            // да го сумираме
            sumFact += fact;
            number = number / 10; // number /= 10
        }

        if (startNumber == sumFact) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
