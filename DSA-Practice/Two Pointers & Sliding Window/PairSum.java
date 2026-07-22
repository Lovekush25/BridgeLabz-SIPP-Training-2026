import java.util.*;

public class PairSum {

    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {
            int sum = transactions[left] + transactions[right];

            if (sum == target) {
                return new int[]{transactions[left], transactions[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] transactions = {1000, 5000, 10000, 15000, 20000};

        int[] ans = findPairSum(transactions, 25000);

        System.out.println(Arrays.toString(ans));
    }
}