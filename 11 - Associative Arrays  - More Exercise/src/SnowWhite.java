import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SnowWhite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> dwarfs = new LinkedHashMap<>();
        Map<String, Integer> color = new LinkedHashMap<>();

        while (!input.equals("Once upon a time")) {
            String[] inputArray = input.split(" <:> ");
            //{dwarfName} <:> {dwarfHatColor} <:> {dwarfPhysics}
            String dwarfName = inputArray[0];
            String hatColor = inputArray[1];
            int physics = Integer.parseInt(inputArray[2]);

            dwarfs.putIfAbsent(dwarfName, color);

            if (!dwarfs.get(dwarfName).containsKey(hatColor)) {
                dwarfs.get(dwarfName).put(hatColor, physics);
            }

            if (dwarfs.containsKey(dwarfName) && !dwarfs.get(dwarfName).containsKey(hatColor)) {
                dwarfs.put(dwarfName, color);
                dwarfs.get(dwarfName).put(hatColor, physics);
            }

            if (dwarfs.containsKey(dwarfName) && dwarfs.get(dwarfName).containsKey(hatColor)) {
                if (dwarfs.get(dwarfName).get(hatColor) < physics) {
                    dwarfs.put(dwarfName, color);
                    dwarfs.get(dwarfName).put(hatColor, physics);
                }
            }

            input = scanner.nextLine();
        }

//        dwarfs.entrySet().stream().sorted((pair1,pair2)-> {
//        int sort = Integer.compare(pair2.getValue(), pair1.getValue());
//        if (sort == 0) {
//
//            String[] color1 = pair1.getKey().split(" ");
//            String[] color2 = pair2.getKey().split(" ");
//
//            int size1 = dwarfCountByColor.get(color1[0]);
//            int size2 = dwarfCountByColor.get(color2[0]);
//            sort = Integer.compare(size2, size1);
//        }
//        return sort;
//    }).forEach(pair -> {
//        String[] print = pair.getKey().split(" ");
//        System.out.printf("(%s) %s <-> %d\n", print[0], print[1], pair.getValue());
//    });

    }
}