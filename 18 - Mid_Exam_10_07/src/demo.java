import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> priceRatings = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        int entryPoint = Integer.parseInt(scanner.nextLine());
        String typeOfItems = scanner.nextLine();
        int valueOfEntryPointElement = priceRatings.get(entryPoint);
        int breakLeftSum = 0;
        int breakRightSum = 0;
        switch (typeOfItems) {
            case "cheap":
                for (int index = 0; index < entryPoint; index++) {
                    if (checkCheaperItem(valueOfEntryPointElement, priceRatings.get(index))) {
                        breakLeftSum += priceRatings.get(index);
                    }
                }
                for (int index = entryPoint + 1; index < priceRatings.size() ; index++) {
                    if (checkCheaperItem(valueOfEntryPointElement, priceRatings.get(index))) {
                        breakRightSum += priceRatings.get(index);
                    }
                }

                break;
            case "expensive":
                for (int index = 0; index < entryPoint; index++) {
                    if (!checkCheaperItem(valueOfEntryPointElement, priceRatings.get(index))) {
                        breakLeftSum += priceRatings.get(index);
                    }
                }
                for (int index = entryPoint + 1; index < priceRatings.size() ; index++) {
                    if (!checkCheaperItem(valueOfEntryPointElement, priceRatings.get(index))) {
                        breakRightSum += priceRatings.get(index);
                    }
                }
        }
        if (breakLeftSum > breakRightSum) {
            System.out.printf("Left - %d", breakLeftSum);
        } else if (breakLeftSum < breakRightSum) {
            System.out.printf("Right - %d", breakLeftSum);
        } else {
            System.out.printf("Left - %d", breakLeftSum);
        }


    }

    private static boolean checkCheaperItem(int valueOfEntryPointElement, Integer integer) {
        return integer < valueOfEntryPointElement;
    }




}