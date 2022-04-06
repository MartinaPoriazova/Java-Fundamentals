import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<separator>[\\/=])(?<destination>[A-Z][A-Za-z]{2,})\\1";
                //"(?<match>=[A-Z][A-Z,a-z]{2,}=|/[A-Z][A-Z,a-z]{2,}/)";
        //"(?<separator>[\\/=])(?<destination>[A-Z][A-Za-z]{2,})\\1"
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> destinations = new ArrayList<>();
        int travelPoints = 0;

        while(matcher.find()) {
            destinations.add(matcher.group("destination"));
        }
        travelPoints = destinations.stream().mapToInt(String::length).sum();//destination->destinations.length()
        String resultText = String.join(", ", destinations); //toString.replaceAll(...)

        System.out.printf("Destinations: %s%n", resultText);
        System.out.printf("Travel Points: %d", travelPoints);

//        while (matcher.find()) {
//            String location = matcher.group("match");
//            location = location.replaceAll("=","");
//            location = location.replaceAll("/","");
//            listOfPlaces.add(location);
//            travelPoints += location.length();
//        }
//        System.out.println("Destinations: " + String.join(", " , listOfPlaces));
//        System.out.println("Travel Points: " + travelPoints);
    }
}
