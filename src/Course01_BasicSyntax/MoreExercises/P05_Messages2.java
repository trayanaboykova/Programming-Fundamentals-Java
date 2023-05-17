package Course01_BasicSyntax.MoreExercises;

import java.util.Scanner;

public class P05_Messages2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        while (lines > 0) {
            String input= scanner.nextLine();
            int keyboardNumber=Integer.parseInt(""+input.charAt(0));
            int offset = (keyboardNumber - 2) * 3;
            if (keyboardNumber == 8 || keyboardNumber == 9) {
                offset++;
            }
            int letterIndex = offset + input.length() - 1;
            if(keyboardNumber==0){
                System.out.print(" ");
            }else{
                System.out.print((char)(letterIndex + 'a'));
            }

            lines--;
        }
    }
}

