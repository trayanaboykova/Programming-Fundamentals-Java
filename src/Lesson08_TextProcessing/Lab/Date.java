package Lesson08_TextProcessing.Lab;

public class Date {
    public static void main(String[] args) {
        System.out.println(new java.util.Date());

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            text.append("a");
        }
        System.out.println(new java.util.Date());
    }
}
