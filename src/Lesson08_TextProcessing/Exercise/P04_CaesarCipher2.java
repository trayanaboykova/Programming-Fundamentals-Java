package Lesson08_TextProcessing.Exercise;

import java.util.Scanner;

public class P04_CaesarCipher2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine(); //първоначалния текст: "Programming is cool!"

            for (char symbol : text.toCharArray()) {
                System.out.print((char)(symbol + 3));
            }
        }
    }

