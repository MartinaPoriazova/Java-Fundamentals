import java.util.Scanner;

public class CharsInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char char1 = scanner.nextLine().charAt(0);
        char char2 = scanner.nextLine().charAt(0);
        getAllTheCharsBetween(char1, char2);
    }

    public static void getAllTheCharsBetween(char char1, char char2) {
        // проверка за символа с по - малка аски стойност - минимум от 2 стойности
        // проверката може да се направи и с if кой символ е по - голям if(char1>char2)
        int newFirstChar = Math.min(char1, char2);
        int newSecondChar = Math.max(char1, char2);

        for (char i = (char) (newFirstChar + 1); i < newSecondChar; i++) {
            System.out.print(i + " ");
        }
    }
}

// public - публичен - във всички класове може да го извикаме
// private - само в настоящия клас може да го ползваме
// public, типа метод после - void - статичен, не връща отговор или тип да данните + име на метода