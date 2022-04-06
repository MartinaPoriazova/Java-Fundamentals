import java.util.Scanner;

public class SumOfChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesNumber = Integer.parseInt(scanner.nextLine());
        // за всеки символ сумиране Аски стойността му
        int sum = 0;
        for (int count = 0; count < linesNumber; count++) {
            char symbol = scanner.nextLine().charAt(0);
            sum += (int) symbol;
        }
        System.out.println("The sum equals: " + sum);
    }
}
