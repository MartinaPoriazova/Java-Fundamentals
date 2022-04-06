import java.util.*;
import java.util.stream.Collectors;

public class TheLift {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        String[] userInput = scanner.nextLine().split(" ");
        // List <Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
        //         .map(Integer::parseInt).collect(Collectors.toList());
        int capacity = 4;

        int[] lifCabins = Arrays.stream(userInput).mapToInt(Integer::parseInt).toArray();
        //List <Integer> liftCabinList = Arrays.stream(userInput).mapToInt(Integer::parseInt).collect(Collectors.toList();

        for (int i = 0; i < lifCabins.length; i++) {
            // влизат хора в опашката
            int peopleInCabin = lifCabins[i];
            int freeSpace = capacity - peopleInCabin;

            if (peopleInCabin == 4) {
                continue;
            }

            if (freeSpace >= peopleWaiting) {
                lifCabins[i] = lifCabins[i] + peopleWaiting;
                peopleWaiting = 0;
                break;
            }

            lifCabins[i] = 4;
            peopleWaiting = peopleWaiting - freeSpace;

        }
        boolean hasEmptySeats = false;
        for (int peopleInCabin : lifCabins) {
            if (peopleInCabin < 4) {
                hasEmptySeats = true;
                break;
            }
        }
        if (hasEmptySeats) {
            System.out.println("The lift has empty spots!");
        } else if (!hasEmptySeats && peopleWaiting != 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        }
        // нямаме свободни места, но и хората в опашката са свършили
        Arrays.stream(lifCabins).forEach(e -> System.out.print(e + " "));

//        if (peopleWaiting == 0) {
//            System.out.println("The lift has empty spots!");
//        } else {
//            System.out.printf("There isn't enough space! %d people in a queue!\n", peopleWaiting);
//        }
//        Arrays.stream(lifCabins).forEach(e-> System.out.print(e + " "));
////       // for (int liftCabin: lifCabins) {
////            System.out.println(liftCabin + " ");
////
////        }
    }
}
