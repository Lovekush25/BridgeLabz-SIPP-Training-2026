import java.util.*;

class Solution {
    public int[] nextBusierDay(int[] visitors) {

        int n = visitors.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && visitors[i] > visitors[stack.peek()]) {
                ans[stack.pop()] = visitors[i];
            }

            stack.push(i);
        }

        return ans;
    }
}