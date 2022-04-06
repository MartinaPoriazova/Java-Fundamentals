import java.math.BigInteger;
import java.util.Scanner;

public class BigFactoriel {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int factorial = Integer.parseInt(scan.nextLine()); // 5

        BigInteger bigInteger = new BigInteger("1");
        for (int i = 1; i <= factorial; i++) {
            bigInteger = bigInteger.multiply(new BigInteger("" + i)); //String.valueOf(i);
        }

        System.out.println(bigInteger);
    }
}
 