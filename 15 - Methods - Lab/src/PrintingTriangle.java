import java.util.Scanner;

public class PrintingTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());
        printPyramid(height);
    }

    public static void printPyramid(int height) {
        printTopHalf(height);
        printBottomHalf(height);
    }

    public static void printTopHalf(int height) {
        for (int i = 1; i <= height; i++) {
            printSingeLine(i);
        }
    }

    public static void printSingeLine(int length) { //length e i
        for (int i = 1; i <= length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printBottomHalf(int height) {
        for (int i = height - 1; i >= 1; i--) {
            printSingeLine(i);
        }
    }


}
