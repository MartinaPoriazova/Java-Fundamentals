import java.util.Scanner;

public class CalculateRectangleArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());

        double area = getRectangelArea(height, length);
        System.out.printf("%.0f", area);
    }

    private static double getRectangelArea(double height, double length) {
        double rectAngelArea = height * length;
        return rectAngelArea;
    }
}
