import java.util.*;

public class Dragon2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, TreeSet<String>> listDragon = new LinkedHashMap<>();
        TreeMap<String, int[]> listTypeDragon = new TreeMap<>();

        int round = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < round; i++) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String nameDragon = input[1];
            int damage = Integer.parseInt(healthIn(input[2], 1));
            int health = Integer.parseInt(healthIn(input[3], 2));
            int armor = Integer.parseInt(healthIn(input[4], 3));

            listDragon.putIfAbsent(type, new TreeSet<>());
            listDragon.get(type).add(nameDragon);
            listTypeDragon.put(nameDragon, new int[3]);
            int[] currentInteger = new int[]{damage, health, armor};
            listTypeDragon.replace(nameDragon, currentInteger);
        }

//damage: %d, health: %d, armor: %d Red::(160.00/2350.00/30.00)
        listDragon.entrySet()
                .stream()
                .forEach(e -> {
                    double damageAvr = 0;
                    double healthAvr = 0;
                    double armorAvr = 0;

                    String[] name = e.getValue().toArray(new String[0]);
                    for (int i = 0; i < name.length; i++) {
                        String nameDragon = name[i];
                        damageAvr += listTypeDragon.get(nameDragon)[0];
                        healthAvr += listTypeDragon.get(nameDragon)[1];
                        armorAvr += listTypeDragon.get(nameDragon)[2];

                    }
                    damageAvr = damageAvr / name.length;
                    healthAvr = healthAvr / name.length;
                    armorAvr = armorAvr / name.length;

                    System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",
                            e.getKey(), damageAvr, healthAvr, armorAvr));

                    for (int i = 0; i < e.getValue().size(); i++) {
                        String current = (String) e.getValue().toArray()[i];
                        int damage = listTypeDragon.get(current)[0];
                        int health = listTypeDragon.get(current)[1];
                        int armor = listTypeDragon.get(current)[2];
                        System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d",
                                current, damage, health, armor));
                    }
                });
    }

    private static String healthIn(String s, int number) {
        switch (number) {
            case 1:
                if (s.equals("null")) {
                    s = "45";
                }
                break;
            case 2:
                if (s.equals("null")) {
                    s = "250";
                }
                break;

            case 3:
                if (s.equals("null")) {
                    s = "10";
                }
                break;
        }
        return s;
    }
}