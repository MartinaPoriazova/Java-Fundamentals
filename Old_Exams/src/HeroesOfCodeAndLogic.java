import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> heroMP = new TreeMap<>();
        Map<String, Integer> heroHP = new TreeMap<>();
        //maximum of 100 HP and 200 MP

        for (int i = 1; i <= number ; i++) {
            String[] heroesInfo = scanner.nextLine().split("\\s+");
            String heroName = heroesInfo[0];
            int hitPoints = Integer.parseInt(heroesInfo[1]);
            int mana = Integer.parseInt(heroesInfo[2]);

            if (hitPoints <= 100) {
                heroHP.put(heroName, hitPoints);
            }
            if (mana <= 200) {
                heroMP.put(heroName, mana);
            }
        }
        String commandsLine = scanner.nextLine();
        while (!commandsLine.equals("End")) {
            String[] commandArray = commandsLine.split(" - ");
            String command = commandArray[0];
            String hero = commandArray[1];

            switch (command) {
                case "CastSpell": //CastSpell – {hero name} – {MP needed} – {spell name}
                    int manaNeeded = Integer.parseInt(commandArray[2]);
                    String spell = commandArray[3];
                    if (heroMP.get(hero) >= manaNeeded) {
                        heroMP.put(hero, heroMP.get(hero) - manaNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n", hero, spell, heroMP.get(hero));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!\n", hero, spell);
                    }
                    break;
                case "TakeDamage": //TakeDamage – {hero name} – {damage} – {attacker}
                    int damage = Integer.parseInt(commandArray[2]);
                    String attacker = commandArray[3];
                    heroHP.put(hero, heroHP.get(hero) - damage);
                    if (heroHP.get(hero) > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", hero, damage, attacker, heroHP.get(hero));
                    } else {
                        heroHP.remove(hero);
                        heroMP.remove(hero);
                        System.out.printf("%s has been killed by %s!\n", hero, attacker);
                    }
                    break;
                case "Recharge": //Recharge – {hero name} – {amount}
                    int amount = Integer.parseInt(commandArray[2]);
                    int currentMana = heroMP.get(hero);
                    int increasedMana = currentMana + amount;
                    if (increasedMana > 200) {
                        increasedMana = 200;
                    }
                    heroMP.put(hero, increasedMana);
                    System.out.printf("%s recharged for %d MP!\n", hero, increasedMana - currentMana);
                    break;
                case "Heal": //Heal – {hero name} – {amount}
                    int amount2 = Integer.parseInt(commandArray[2]);
                    int currentHP = heroHP.get(hero);
                    int increasedHP = currentHP + amount2;
                    if (increasedHP > 100) {
                        increasedHP = 100;
                    }
                    heroHP.put(hero, increasedHP);
                    System.out.printf("%s healed for %d HP!\n", hero, increasedHP - currentHP);
                    break;
            }
            commandsLine = scanner.nextLine();
        }
        heroHP.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(heroEntry -> {
            String hero = heroEntry.getKey();
                    System.out.println(hero);
                    System.out.println("  HP: " + heroEntry.getValue());
                    System.out.println("  MP: " + heroMP.get(hero));
        });
    }
}
