import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double journeyCosts = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double sumOfSavedMOney = 0;
        double monthSavedMoney = journeyCosts * 0.25;

        for (int i = 1; i <= months; i++) {

            for (int j = 2; j <= months; j++) {
                if (months % 2 != 0) {
                    sumOfSavedMOney = sumOfSavedMOney - sumOfSavedMOney * 0.16;
                }
            }
            if (months % 4 == 0) {
                sumOfSavedMOney += sumOfSavedMOney * 0.25;
            }
            sumOfSavedMOney += monthSavedMoney;
        }
        if (sumOfSavedMOney >= journeyCosts) {
            double sumLeftForSouvenirs = sumOfSavedMOney - journeyCosts;
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.",
                    sumLeftForSouvenirs);
        } else {
            double needMoney = journeyCosts - sumOfSavedMOney;
            System.out.printf("Sorry. You need %.2flv. more.", needMoney);
        }
    }
}
