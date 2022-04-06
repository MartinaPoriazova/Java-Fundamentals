import java.util.*;

public class StudentAcademy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> dataBase = new LinkedHashMap<>();

        for (int i = 1; i <= number; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!dataBase.containsKey(studentName)) {
                dataBase.put(studentName, new ArrayList<>());
            }
            dataBase.get(studentName).add(grade);
        }

//        dataBase.entrySet().stream()
//                .map(e -> { //change the elements from Map.Entry<String, List<Double>> to Pair<String, Double>
//                    Double averageGrade = e.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
//                    return new Pair<>(e.getKey(), averageGrade);
//                }).filter(e -> e.getValue() >= 4.5) //remove all elements, which do NOT meet this criteria
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) //sort descending
//                .forEach(e -> System.out.println(String.format("%s -> %.2f", e.getKey(), e.getValue()))); //print

        Map<String, Double> averageGrade = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> kvp : dataBase.entrySet()) {
            double average = kvp.getValue().stream().mapToDouble(x -> x).average().getAsDouble();

            if (average >= 4.50) {
                averageGrade.put(kvp.getKey(), average);
            }
        }

        averageGrade.entrySet()
                .stream()
                .sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
                .forEach(grade -> {
                    System.out.println(String.format("%s -> %.2f", grade.getKey(), grade.getValue()));
                });
    }
}
