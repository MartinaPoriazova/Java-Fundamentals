import java.util.Scanner;

public class PadawanEquipment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalMoney = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double lightsabersPrice = Math.ceil(studentsCount + (studentsCount * 0.10)) * lightsaberPrice;
        double robesPrice = studentsCount * robePrice;
        double beltsPrice = (studentsCount - (studentsCount / 6.0)) * beltPrice;

        double totalCosts = lightsabersPrice + robesPrice + beltsPrice;

        if (totalCosts <= totalMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalCosts);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalCosts - totalMoney);
        }
    }
}
