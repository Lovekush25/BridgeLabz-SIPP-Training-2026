import java.util.List;

public class GenericUtility {

    public static <T extends Comparable<T>> T findMax(T[] array) {

        T max = array[0];

        for (T value : array) {

            if (value.compareTo(max) > 0) {
                max = value;
            }

        }

        return max;
    }

    public static void print(List<?> list) {

        for (Object obj : list) {
            System.out.println(obj);
        }

    }
}