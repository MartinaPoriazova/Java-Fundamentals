import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeEfficiency1 = Integer.parseInt(scanner.nextLine()); // pre hour
        int employeeEfficiency2 = Integer.parseInt(scanner.nextLine());
        int employeeEfficiency3 = Integer.parseInt(scanner.nextLine());
        int peopleCount = Integer.parseInt(scanner.nextLine());
        int hourCount = 0;
        int efficiencyPerHour = employeeEfficiency1 + employeeEfficiency2 + employeeEfficiency3;

        while (peopleCount > 0) {
            hourCount++;
            if (hourCount % 4 == 0) {
                continue;
            }
            peopleCount -= efficiencyPerHour;
        }
        System.out.printf("Time needed: %dh.", hourCount);
    }
}
