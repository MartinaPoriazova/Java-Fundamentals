import java.util.Scanner;

public class PasswordReset2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String command = scanner.nextLine();
        //"TakeOdd" -> split(" ") -> ["TakeOdd"]
        //"Cut {index} {length}" -> split(" ") -> ["Cut", "{index}", "{length}"]
        //"Substitute {substring} {substitute}" -> split(" ") -> ["Substitute", "{substring}", "{substitute}"]
        while(!command.equals("Done")) {
            String [] commandParts = command.split("\\s+");
            String commandName = commandParts[0];
            //"Take Odd"
            //"Cut"
            //"Substitute"
            switch(commandName) {
                case "TakeOdd":
                    password = getOddIndexes(password);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandParts[1]); //15
                    int length = Integer.parseInt(commandParts[2]); //3
                    String substringToRemove = password.substring(index, index + length); //текстът, който трябва да премахна
                    password = password.replaceFirst(substringToRemove, "");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = commandParts[1];
                    String substitute = commandParts[2];
                    //проверка дали substring го има в паролата
                    if(password.contains(substring)) {
                        //заменям всички substring с substitute
                        password = password.replaceAll(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Your password is: %s", password);
    }

    private static String getOddIndexes(String password) {
        StringBuilder newPassword = new StringBuilder(); //построим нова парола
        //всички символи на нечетни индекси
        //1, 3 ,5, 7, 9....
       /* Вариант 1:
       for (int index = 0; index <= password.length() - 1; index++) {
            if(index % 2 == 1) {
                char currentSymbol = password.charAt(index);
                newPassword.append(currentSymbol);
            }
        }*/
        //Вариант 2:
        for (int index = 1; index < password.length(); index += 2) {
            char currentSymbol = password.charAt(index);
            newPassword.append(currentSymbol);
        }

        return newPassword.toString();
    }
}