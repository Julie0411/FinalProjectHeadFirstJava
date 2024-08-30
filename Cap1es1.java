import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cap1es1 { //1

    public static void main(String[] args) { //2

        int a = 6; //3
        long b = 3; //4
        long c = a + b; //5
        boolean d = a > b; //6
        Integer a2 = 5; //7
        a = a2; //8

        int[] arr = new int[10]; //9
        System.out.println(Arrays.toString(arr)); //9

        for (int i = 0; i < arr.length; i++) { //11
            arr[i] = (int) Math.pow(i, 2);
        }

        System.out.println(Arrays.toString(arr)); //12

        int sum = 0; //13
        for (int i : arr) {
            sum += i;
        }
        System.out.println(sum);

        int i = 0; //14
        sum = 0;
        while (i < arr.length) {
            sum += arr[i];
            i++;
        }
        System.out.println(sum);

        if (sum > 20) { //15
            System.out.println("Sum is greater than 20");
        } else if (sum == 20) {
            System.out.println("Sum is 20");
        } else {
            System.out.println("Sum is smaller than 20");
        }

        List<String> list; //16
        list = new ArrayList<>();

        long start = System.currentTimeMillis();
        for (int j = 0; j <= 1000000; j++) {
            String number = String.valueOf(j);
            list.add(number);
        }
        long stop = System.currentTimeMillis();
        long elapsed = stop-start;
        System.out.println(elapsed + " millisecond");

        int[][] matrix = new int[3][5]; //18
        for (int j = 0; j < matrix.length; j++) { //19
            for (int k = 0; k < matrix[0].length; k++) {
                matrix[j][k] = 1;
            }
        }

        printMatrix(matrix);

        System.out.println("----------");

        int[][] matrix2 = new int[8][8]; //21
        for (int j = 0; j < matrix2.length; j++) { //22

            for (int k = 0; k < matrix2[0].length; k++) {

                if (k <= j) {
                    matrix2[j][k] = 1;
                }

            }

        }

        printMatrix(matrix2);

    }

    private static void printMatrix(int[][] arr) {

        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr[0].length; k++) {
                System.out.print(arr[j][k] + " ");
            }
            System.out.println();
        }

    }

}
