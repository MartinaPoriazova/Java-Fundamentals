import java.util.Scanner;

public class SpiceMustFlow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int yield = 0;

        while (startingYield >= 100) {
            days++;
            yield += startingYield - 26;
            startingYield -= 10;
        }

        System.out.println(days);

        if (days == 0) {
            System.out.println(yield);
        } else {
            System.out.println(yield - 26);
        }
//        int startingYield = Integer.parseInt(sc.nextLine());
//        int extractedSpice = 0;
//        int days = 0;
//
//        for (int currentYield = startingYield; currentYield >= 100 ; currentYield-=10) {
//            extractedSpice += currentYield;
//            extractedSpice -= 26;
//            if (extractedSpice < 0) {
//                extractedSpice = 0;
//            }
//            days++;
//        }
//
//        extractedSpice -= 26;
//        if (extractedSpice < 0) {
//            extractedSpice = 0;
//        }
//
//        System.out.println(days);
//        System.out.println(extractedSpice);
//    }
//}
    }
}