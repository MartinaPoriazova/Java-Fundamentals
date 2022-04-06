import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeEfficiency1 = Integer.parseInt(scanner.nextLine()); // pre hour
        int employeeEfficiency2 = Integer.parseInt(scanner.nextLine());
        int employeeEfficiency3 = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int hourCount = 0;
        int efficiencyPerHourTotal = employeeEfficiency1 + employeeEfficiency2 + employeeEfficiency3;

       while (studentsCount > 0) {
           hourCount++;
           if (hourCount % 4 == 0) {
               continue;
           }
           studentsCount -= efficiencyPerHourTotal;
        }
        System.out.printf("Time needed: %dh.", hourCount);
    }
}
