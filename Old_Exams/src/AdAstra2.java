import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String foodRegEx = "([#|])(?<itemname>[A-Za-z\\s]+)\\1(?<expirationdate>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,5}+)\\1";
        Pattern pattern = Pattern.compile(foodRegEx);
        Matcher matcher = pattern.matcher(input);
        List<String> items = new ArrayList<>();
        String nameOfItems = "";
        String dateOfExpire = "";
        int calories = 0;
        int sumOfCalories = 0;

        while (matcher.find()) {

            nameOfItems = matcher.group("itemname");
            dateOfExpire = matcher.group("expirationdate");
            calories = Integer.parseInt(matcher.group("calories"));

            sumOfCalories += calories;

            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d", nameOfItems, dateOfExpire, calories));

        }
        int daysForFoodToLast = sumOfCalories / 2000;

        if (daysForFoodToLast > 0) {
            System.out.printf("You have food to last you for: %d days!%n", daysForFoodToLast);
            items.forEach(System.out::println);
        } else {
            System.out.println("You have food to last you for: 0 days!");
        }
    }
}