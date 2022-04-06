import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "@#+(?<productName>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            //проверка дали е валиден
            Matcher matcher = pattern.matcher(barcode);
            //валиден -> търсим product group -> печатаме
            if (matcher.find()) {
                String productName = matcher.group("productName");
                StringBuilder productNumber = new StringBuilder();//"" -> всички цифри от името на продукта
                for (int j = 0; j < productName.length(); j++) {
                    char currentSymbol = productName.charAt(j);
                    //проверка дали е цифра
                    if (Character.isDigit(currentSymbol)) {
                        productNumber.append(currentSymbol);
                    }
                }
                //отпечатваме productNumber
                //ако нямаме цифри
                if (productNumber.toString().equals("")) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", productNumber);
                }
            }
            else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
