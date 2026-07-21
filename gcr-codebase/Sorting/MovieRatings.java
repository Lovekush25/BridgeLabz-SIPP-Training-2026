import java.util.Arrays;

public class MovieRatings {

    public static void main(String[] args) {

        int[] ratings = {8, 5, 9, 7, 6, 10};

        // Selection Sort
        for (int i = 0; i < ratings.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < ratings.length; j++) {

                if (ratings[j] < ratings[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = ratings[i];
            ratings[i] = ratings[minIndex];
            ratings[minIndex] = temp;
        }

        System.out.println(Arrays.toString(ratings));
    }
}