import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> racers = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        Map<String, Integer> racersDistances = new LinkedHashMap<>();
        racers.forEach(racer -> racersDistances.put(racer, 0));
        String input = scanner.nextLine();

        String regexLetter = "[A-Za-z]+";
        Pattern patternName = Pattern.compile(regexLetter);
        String regexNumbers = "[0-9]";
        Pattern patternNumbers = Pattern.compile(regexNumbers);

        while (!input.equals("end of race")) {
            // да събере всички букви, които е открило
            StringBuilder nameBuilder = new StringBuilder();
            Matcher matcherName = patternName.matcher(input);
            while (matcherName.find()) {
                nameBuilder.append(matcherName.group());
            }
            // да сумира всички намерени цифри
            int distance = 0;
            Matcher matcherNumber = patternNumbers.matcher(input);
            while (matcherNumber.find()) {
                distance += Integer.parseInt(matcherNumber.group());
            }
            String racerName = nameBuilder.toString();
            if (racersDistances.containsKey(racerName)) {
                int currentDistance = racersDistances.get(racerName);
                racersDistances.put(racerName, distance + currentDistance);
            }

            input = scanner.nextLine();
        }
        // sort by descending distance (value)
        List<String> firstThreeNames = racersDistances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("1st place: " + firstThreeNames.get(0));
        System.out.println("2nd place: " + firstThreeNames.get(1));
        System.out.println("3rd place: " + firstThreeNames.get(2));
    }
}
