import java.math.BigDecimal;
import java.util.Scanner;

public class SumDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        //спирам да сумирам, когато нямам цифри (число = 0)
        //продължавам => число != 0
        //взимам последната цифра
        //добавям я към сумата
        //премахвам последната цифра

        int sum = 0; //сума на цифрите
        while (number != 0) {
            int lastDigit = number % 10; //последната цифра
            sum += lastDigit;
            number /= 10;
        }
        System.out.println(sum);
    }
}
