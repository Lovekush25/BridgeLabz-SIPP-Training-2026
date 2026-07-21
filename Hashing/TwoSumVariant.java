import java.util.*;

class Solution {
    public int[] findFraudPair(int[] amounts, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < amounts.length; i++) {
            int complement = target - amounts[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(amounts[i], i);
        }

        return new int[]{-1, -1};
    }
}