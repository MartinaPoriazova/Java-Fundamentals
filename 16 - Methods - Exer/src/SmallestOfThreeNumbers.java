import java.util.Scanner;

public class SmallestOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        System.out.println(getSmallestNumber(num1, num2, num3));
    }

    public static int getSmallestNumber(int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }
}
// друг вариант - принтирам в метода, той нищо не връща и е войд
// проверка с if(num 1 < num2 && num1 < num3)
// sout (num1)