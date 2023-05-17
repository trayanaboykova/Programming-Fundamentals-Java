package Module02_Fundamentals.ExamsExercises.OtherExams.E02_RegularExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String regex = "([\\S]+)(>)(?<group1>[0-9]{3})\\|(?<group2>[a-z]{3})\\|(?<group3>[A-Z]{3})\\|(?<group4>[\\S^> <]{3})(<)\\1";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            StringBuilder encrypted = new StringBuilder();
            if (matcher.find()){
                String group1 = matcher.group("group1");
                String group2 = matcher.group("group2");
                String group3 = matcher.group("group3");
                String group4 = matcher.group("group4");
                encrypted.append(group1);
                encrypted.append(group2);
                encrypted.append(group3);
                encrypted.append(group4);
                System.out.println("Password: " + encrypted);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
