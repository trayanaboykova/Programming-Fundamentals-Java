package Module02_Fundamentals.Course03_Arrays;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        //методи за масиви
        Scanner scanner = new Scanner(System.in);

       int[] targets = nextIntArray(scanner);

        System.out.printf("Something");
        printArray(targets," ");
    }

    //извикване на масив
    private static int[] nextIntArray(Scanner scanner) {
        String [] intaAsString = scanner.nextLine().split("\\s+");
        int [] array = new int [intaAsString.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(intaAsString[i]);

        }
        return array;
    }

    //принтиране на масив, когато примерно накрая
    //може да има запетая или нещо друго
    private static void printArray (int[] array, String separator){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1){
                System.out.print(separator);
            }
        }
    }
}
