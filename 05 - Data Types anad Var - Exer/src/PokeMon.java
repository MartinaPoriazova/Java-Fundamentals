import java.util.Scanner;

public class PokeMon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int powerN = Integer.parseInt(scanner.nextLine());
        int distanceM = Integer.parseInt(scanner.nextLine());
        int exhaustionFactorY = Integer.parseInt(scanner.nextLine());
        int temporaryPower = powerN;
        int targets = 0;

        while (temporaryPower >= distanceM) {
            temporaryPower -= distanceM;
            targets++;

            if (temporaryPower == powerN * 0.50 && exhaustionFactorY != 0) {
                int division = temporaryPower / exhaustionFactorY;
                if (division != 0) {
                    temporaryPower = division;
                }
            }
        }

        System.out.println(temporaryPower);
        System.out.println(targets);
    }
}
