import java.util.Scanner;

public class Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String drinkName = scanner.nextLine();
        int drinks = Integer.parseInt(scanner.nextLine());
        double singlePrice = 0.0;

        switch (drinkName) {
            case "coffee":
                coffeeTotalPrice(drinks, singlePrice);
                break;
            case "water":
                waterTotalPrice(drinks, singlePrice);
                break;
            case "coke":
                cokeTotalPrice(drinks, singlePrice);
                break;
            case "snacks":
                snacksTotalPrice(drinks, singlePrice);
                break;
        }
    }

    public static void coffeeTotalPrice(int drinks, double singelPrice) {
        singelPrice = 1.50;
        System.out.printf("%.2f", drinks * singelPrice);
    }

    public static void waterTotalPrice(int drinks, double singelPrice) {
        singelPrice = 1.00;
        System.out.printf("%.2f", drinks * singelPrice);
    }

    public static void cokeTotalPrice(int drinks, double singelPrice) {
        singelPrice = 1.40;
        System.out.printf("%.2f", drinks * singelPrice);
    }

    public static void snacksTotalPrice(int drinks, double singelPrice) {
        singelPrice = 2.00;
        System.out.printf("%.2f", drinks * singelPrice);
    }
}
