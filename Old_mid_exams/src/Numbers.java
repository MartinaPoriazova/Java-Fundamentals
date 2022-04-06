import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> averageNumbers = input.stream()
                .filter(e -> e > input.stream()
                .mapToDouble(Integer::doubleValue).average().orElse(0.0))
                .sorted(Comparator.reverseOrder()).limit(5)
                .collect(Collectors.toList());
        if (averageNumbers.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.print(Arrays.toString(new List[]{averageNumbers})
                    .replaceAll("[\\[\\]]", "").replaceAll(", ", " "));
        }
//        List <Integer> sequence = Arrays.stream(scanner.nextLine()
//                .split(" "))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        double avr = 0;
//        calculateAverage(sequence);
//        List <Integer> newList = new ArrayList<>();
//        for (int i = 0; i < sequence.size(); i++) {
//            if (sequence.size() == 1) {
//                System.out.println("No");
//                break;
//            } else if (avr < sequence.get(i)) {
//                newList.add(sequence.get(i));
//            }
//        }
//        Collections.sort(newList);
//        Collections.reverse(newList);
//        int count = 0;
//        for (Integer integer : newList) {
//            System.out.print(integer + " ");
//            count++;
//            if (count == 5) {
//                break;
//            }
//        }
//
//
//
//
//    }
//    private static double calculateAverage(List<Integer> sequence) {
//        return sequence.stream()
//                .mapToDouble(d -> d)
//                .average()
//                .orElse(0.0);
    }
}
