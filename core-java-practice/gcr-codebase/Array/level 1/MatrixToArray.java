import java.util.Scanner;

public class MatrixToArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Rows: ");
        int rows = sc.nextInt();

        System.out.print("Columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[] array = new int[rows * cols];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[index++] = matrix[i][j];
            }
        }

        System.out.println("1D Array:");

        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}