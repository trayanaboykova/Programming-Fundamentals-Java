package Lesson08_TextProcessing.MoreExercises;

import java.util.Scanner;

public class P05_HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();
        String comment;

        System.out.printf("<h1>\n\t%s\n</h1>\n", title);
        System.out.printf("<article>\n\t%s\n</article>\n", content);
        while (!(comment = scanner.nextLine()).equals("end of comments")) {

            System.out.printf("<div>\n\t%s\n</div>\n", comment);
        }
    }
}
