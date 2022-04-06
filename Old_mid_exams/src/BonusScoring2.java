import java.util.Scanner;

public class BonusScoring2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double studentsCount = Double.parseDouble(scan.nextLine());
        double lecturesCount = Double.parseDouble(scan.nextLine());
        double initialBonus = Double.parseDouble(scan.nextLine());

        double attendances = 0;
        double currentBonus = 0;
        double maxBonus = Double.MIN_VALUE;
        double totalBonus = 0;

        for (int i = 0; i < studentsCount; i++) {
            attendances = Double.parseDouble(scan.nextLine());;
            currentBonus = attendances;
            if (currentBonus > maxBonus) {
                maxBonus = currentBonus;
                totalBonus = Math.ceil(attendances / lecturesCount * (5 + initialBonus));
            }
        }
        System.out.printf("Max Bonus: %.0f.\n", totalBonus);
        System.out.printf("The student has attended %.0f lectures.", maxBonus);
    }
}