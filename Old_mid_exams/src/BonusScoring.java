import java.util.Scanner;

public class BonusScoring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        int maxBonus = Integer.MIN_VALUE;
        int maxAtt = Integer.MIN_VALUE;

        //{total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})
        for (int i = 1; i <= studentsCount; i++) {
           int attendancesCount = Integer.parseInt(scanner.nextLine());
           double totalBonus = Math.round(attendancesCount * 1.0 / lecturesCount * (5 + additionalBonus));
            if (totalBonus > maxBonus) {
                maxBonus = (int)totalBonus;
                maxAtt = attendancesCount;
            }
        }
        System.out.println("Max Bonus: " + maxBonus + ".");
        System.out.printf("The student has attended %d lectures.", maxAtt);
    }
}
