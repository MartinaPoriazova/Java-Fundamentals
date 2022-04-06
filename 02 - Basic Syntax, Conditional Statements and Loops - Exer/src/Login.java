import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = "";

        for (int position = username.length() - 1; position >= 0; position--) {
            // взимам символа на текущата позиция
            char currentSymbol = username.charAt(position);
            // добавям го към празната променлива Парола
            password += currentSymbol;
        }

        // повтаряме въвеждане на парола
        // спирам да повтаряме, когато въведената парола == password
        // спираме, когато въведената парола != password
        String enteredPassword = scanner.nextLine();
        int countFailedAttempts = 0;

        while (!enteredPassword.equals(password)) {
            // грешна парола:
            countFailedAttempts++;

            // проверка за макс пъти 4
            if (countFailedAttempts >= 4) {
                System.out.printf("User %s blocked!", username);
                return; // или прекратяваме с break и иф при последния принт
            }

            System.out.println("Incorrect password. Try again.");
            enteredPassword = scanner.nextLine();
        }

        // въведената == търсената парола
        System.out.printf("User %s logged in.", username);
    }
}
