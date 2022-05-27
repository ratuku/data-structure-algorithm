package others;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> output = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        dfSubset(new ArrayList<>(), 0, nums);
        return output;
    }

    public void dfSubset(List<Integer> current , int i , int[] nums ) {
        if (i>= nums.length) {
            output.add(current);
            return;
        }
        // remember in every position oh for every length of the subset, we have two choices
        // add ith element to this array
        current.add(nums[i]);
        dfSubset(current, i+1, nums);

        // remove this  ith element from this array
        current.remove(nums[i]);
        dfSubset(current, i+1,nums);
    }
}
