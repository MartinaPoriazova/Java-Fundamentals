import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int field = Integer.parseInt(scanner.nextLine());
        String allLadybugs = scanner.nextLine();
        int[] ladybugSpots = Arrays.stream(allLadybugs.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] ladybugsOnField = new int[field];

        //поставяне на калинките на места само на полето
        for (int ladybugs : ladybugSpots) {
            if (ladybugs >= 0 && ladybugs < field) {
                ladybugsOnField[ladybugs] = 1;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            //назначаване на аргументите на командата за преместване
            String[] commandToMove = input.split(" ");
            int position = Integer.parseInt(commandToMove[0]);
            String directionToMove = commandToMove[1];
            int positionsToMove = Integer.parseInt(commandToMove[2]);

            //проверка дали е валиден входа за мястото на калинката
            if (position >= field || 0 > position || ladybugsOnField[position] == 0) {
                input = scanner.nextLine();
                continue; //ако не е, приема следваща команда и връща в началото на цикъла
            }

            //премахване на калинката от мястото
            ladybugsOnField[position] = 0;

            //слагане на правилния знак на преместване според посоката
            if (directionToMove.equals("left")) {
                positionsToMove = -positionsToMove;
            }

            //преместване на калинка докато не кацне на свободно място или извън полето
            do {
                position += positionsToMove;
                if (0 > position || position >= field) {
                    break;
                }
            } while (ladybugsOnField[position] == 1);

            //поставяне на калинка на свободното място, ако не е излязла от полето
            if (position < field && 0 <= position) {
                ladybugsOnField[position] = 1;
            }

            input = scanner.nextLine();
        }

        //принт на резултата
        for (int i = 0; i < field; i++) {
            System.out.print(ladybugsOnField[i] + " ");
        }
    }
}