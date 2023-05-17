package Course09_RegularExpressions.MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(?=.{20}).*?(?=(?<character>[@#$^]))(?<match>\\k<character>{6,}).*(?<=.{10})\\k<match>.*");
        Pattern separator = Pattern.compile("\\s*,\\s*");

        String[] ticketsList = separator.split(scanner.nextLine().trim());

        for (String ticket : ticketsList) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                Matcher matcher = pattern.matcher(ticket);
                if (matcher.matches()) {
                    String match = matcher.group("match");
                    System.out.printf("ticket \"%s\" - %d%s%s\n", ticket, match.length(), match.charAt(0),
                            (match.length() == 10) ? " Jackpot!" : "");
                } else {
                    System.out.printf("ticket \"%s\" - no match\n", ticket);
                }
            }
        }
    }
}

