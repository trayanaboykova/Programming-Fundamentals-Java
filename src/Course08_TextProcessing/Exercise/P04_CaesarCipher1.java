package Course08_TextProcessing.Exercise;

import java.util.Scanner;

public class P04_CaesarCipher1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine(); //първоначалния текст: "Programming is cool!"
        StringBuilder encryptedText = new StringBuilder(); //криптиран текст

        for (char symbol : text.toCharArray()) {
            char encryptSymbol = (char)(symbol + 3); //криптирания символ
            encryptedText.append(encryptSymbol);
        }

        System.out.println(encryptedText);
    }
}


