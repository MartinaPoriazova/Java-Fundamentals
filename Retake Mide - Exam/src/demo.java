import java.util.Scanner;

public class demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double jorneyCost = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double savedForAMonth = jorneyCost * 0.25;
        double finalSum = 0;

        for (int i = 1; i <= months; i++) {
            if (i != 1) {
                if (i % 2 != 0) {
                    finalSum = finalSum - finalSum * 0.16;
                }
            }
            if (i % 4 == 0) {
                finalSum = finalSum + finalSum * 0.25;
            }
            finalSum += savedForAMonth;
        }
        if (finalSum >= jorneyCost) {
            double sumForSouvenirs = finalSum - jorneyCost;
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.",
                    sumForSouvenirs);
        } else {
            double needMoney = jorneyCost - finalSum;
            System.out.printf("Sorry. You need %.2flv. more.", needMoney);
        }

    }
}
