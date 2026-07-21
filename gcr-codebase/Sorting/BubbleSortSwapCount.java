import java.util.Arrays;

public class BubbleSortSwapCount {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 1};

        int swapCount = 0;

        // Bubble Sort
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 0; j < nums.length - 1 - i; j++) {

                if (nums[j] > nums[j + 1]) {

                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    swapCount++;
                }
            }
        }

        System.out.println("Sorted Array: " + Arrays.toString(nums));
        System.out.println("Total Swaps = " + swapCount);
    }
}