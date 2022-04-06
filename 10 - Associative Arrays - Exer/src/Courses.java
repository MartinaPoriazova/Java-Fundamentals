import java.util.*;

public class Courses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!input.equals("end")) {
            // име на курс : име на студент - > input.split(" : ")
            String courseName = input.split(" : ")[0];
            String personName = input.split(" : ")[1];

            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
            }
            //ако курсът е нов -> връща празен списък
            //ако курсът е стар -> връща моментния списък с хора
            courses.get(courseName).add(personName);

            input = scanner.nextLine();
        }
        // courses - > List <String>
        courses.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                //сортира курсовете(ключовете) по брой хора (descending order / намаляващ ред)
                .forEach(entry -> {
                    //key: име на курса
                    //value: списък с хората
                    //име на курса -> бр. хората
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                    List<String> students = entry.getValue();
                    students.stream().sorted().forEach(student -> System.out.println("-- " + student));
                    // entry.getValue().stream().sorted().forEach(studentName -> System.out.println("-- " + studentName));
                    // ascending order / нарастващ ред
                });
    }
}
