import java.util.Scanner;

public class RageExpenses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        // общо разходи = сума за слушалки + сума за мишка + сума за клавиатура + сума за дисплей
        // = бр. слушалки * цена слушалки + бр. мишки * цена мишка + бр....
        // търсим броят на всеки един вид счупени артикули
        int countHeadsets = lostGames / 2;
        int countMousses = lostGames / 3;
        int countKeyboards = lostGames / 6;
        int countDisplays = lostGames / 12;

        double sumAllExpenses =
                countHeadsets * headsetPrice + countMousses * mousePrice + countKeyboards * keyboardPrice
                        + countDisplays * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", sumAllExpenses);
    }
}
