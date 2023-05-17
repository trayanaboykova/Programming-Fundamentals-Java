package Module02_Fundamentals.Course02_DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class P01_DataTypeFinder2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")){
            String type = "";
            //проверка за типовете
            //boolean
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")){
                type = "boolean";
            }
            //character
            else if (input.length() == 1){
                //символ
                char symbol = input.charAt(0);
                if (symbol < 47 || symbol > 58){
                    type = "character";
                }
                //едноцифрено цяло число
                else {
                    type = "integer";
                }
            }
            else {
                boolean isString = false;
                boolean isFloat = false;
                for (int i = 0; i < input.length(); i++) {
                    char currentSymbol = input.charAt(i);
                    //проверка дали е символ
                    if (currentSymbol < 45 || currentSymbol > 57){
                        isString = true;
                    }
                    if (currentSymbol == 46){
                        isFloat = true;
                    }
                }
                if (isString) {
                    type = "string";
                }
                else {
                    //число
                    if (isFloat){
                        type = "floating point";
                    } else {
                        type = "integer";
                    }
                }
            }
            System.out.printf("%s is %s type", input, type);
            System.out.println();
            input = scanner.nextLine();
        }

    }
}
