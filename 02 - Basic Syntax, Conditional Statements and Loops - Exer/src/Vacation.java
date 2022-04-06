import java.util.Scanner;

public class Vacation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        String group = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        double totalPrice = 0;

        switch (day) {
            case "Friday":
                switch (group) {
                    case "Students":
                        price = 8.45;
                        totalPrice = people * price;
                        if (people >= 30) {
                            totalPrice -= totalPrice * 0.15;
                        }
                        break;
                    case "Business":
                        price = 10.90;
                        if (people >= 100) {
                            totalPrice = (people - 10) * price;
                        } else {
                            totalPrice = people * price;
                        }
                        break;
                    case "Regular":
                        price = 15.0;
                        totalPrice = people * price;
                        if (people >= 10 && people <= 20) {
                            totalPrice -= totalPrice * 0.05;
                        }
                        break;
                }
                break;
            case "Saturday":
                switch (group) {
                    case "Students":
                        price = 9.80;
                        totalPrice = people * price;
                        if (people >= 30) {
                            totalPrice -= totalPrice * 0.15;
                        }
                        break;
                    case "Business":
                        price = 15.60;
                        if (people >= 100) {
                            totalPrice = (people - 10) * price;
                        } else {
                            totalPrice = people * price;
                        }
                        break;
                    case "Regular":
                        price = 20.0;
                        totalPrice = people * price;
                        if (people >= 10 && people <= 20) {
                            totalPrice -= totalPrice * 0.05;
                        }
                        break;
                }
                break;
            case "Sunday":
                switch (group) {
                    case "Students":
                        price = 10.46;
                        totalPrice = people * price;
                        if (people >= 30) {
                            totalPrice -= totalPrice * 0.15;
                        }
                        break;
                    case "Business":
                        price = 16.0;
                        if (people >= 100) {
                            totalPrice = (people - 10) * price;
                        } else {
                            totalPrice = people * price;
                        }
                        break;
                    case "Regular":
                        price = 22.50;
                        totalPrice = people * price;
                        if (people >= 10 && people <= 20) {
                            totalPrice -= totalPrice * 0.05;
                        }
                        break;
                }
                break;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
