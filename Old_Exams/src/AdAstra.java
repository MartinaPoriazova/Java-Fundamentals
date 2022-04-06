import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<separator>[#||])(?<food>[A-Za-z\\s]*)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<cal>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        //2000kcal a day
        int totalCal = 0;
        List<String> foodInfo = new ArrayList<>();
        String food = "";
        String date = "";
        int cals = 0;
//        if (!matcher.find()) {
//            System.out.println("You have food to last you for: 0 days!");
//        }

        while (matcher.find()) {
            food = matcher.group("food");
            date = matcher.group("date");
            cals = Integer.parseInt(matcher.group("cal"));
            foodInfo.add(String.format("Item: %s, Best before: %s, Nutrition: %d", food, date, cals));
            totalCal += cals;
        }
        if (food == "") {
            System.out.println("You have food to last you for: 0 days!");
        }
        int daysLeft = totalCal / 2000;
        if (daysLeft > 0) {
            System.out.printf("You have food to last you for: %d days!\n", daysLeft);
        }

        //Item: {item name}, Best before: {expiration date}, Nutrition: {calories}"
       //System.out.println(foodInfo.toString().replaceAll("[\\[\\],]", ""));
        for (String element:foodInfo) {
            System.out.println(element);
        }

    }
}
