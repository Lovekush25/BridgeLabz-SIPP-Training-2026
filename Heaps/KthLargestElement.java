import java.util.PriorityQueue;

public class Main {

    static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {

            if (minHeap.size() < k) {
                minHeap.offer(num);
            }
            else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 5, 6, 4};

        System.out.println(findKthLargest(arr, 2));
    }
}