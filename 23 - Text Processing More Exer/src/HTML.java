import java.util.Scanner;

public class HTML {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String content = scanner.nextLine();
        String comment = scanner.nextLine();
        String regexTitle = "<title>([^<>]*)<\\/title>";
        String regexContent = "<body>.*<\\/body>";
        String regexComment = ">([^><]*)<";

        while (!comment.equals("end of comments")) {

            comment = scanner.nextLine();
        }
    }
}
