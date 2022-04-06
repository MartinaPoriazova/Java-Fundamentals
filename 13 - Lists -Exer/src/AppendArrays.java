import java.util.List;
import java.util.Scanner;

public class AppendArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arrays = input.split("\\|");
        for (int index = arrays.length - 1; index >= 0; index--) {
            String elements = arrays[index].trim(); // всеки път взимаме съответния вече сплитнат масив като текст
            if ((elements.equals(" ")) || (elements.equals(""))) {
                continue;
            }
            String[] numbers = elements
                    .split("\\s+"); // записваме го като текстови масив сплитнат по 1 или повече спейсове
            System.out.print(String.join(" ", numbers));
            System.out.print(" ");
        }
    }
}
