package leetcode;

import java.util.HashMap;

public class SolutionSumProblem_1 {
    public int[] twoSum(int[] nums, int target) {
        // hint 2
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            int current = target - nums[i];
            if (hashMap.containsKey(current)) {
                return new int[]{i, hashMap.get(current)};
            }
            hashMap.put(nums[i], i);
        }

        return null;
    }
}
