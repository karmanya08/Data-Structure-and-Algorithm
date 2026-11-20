
import java.util.*;

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Sort to place duplicates together
        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, boolean[] used,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // If permutation contains all elements
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip an already-used element
            if (used[i]) {
                continue;
            }

            // Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Choose the element
            used[i] = true;
            current.add(nums[i]);

            // Explore next position
            backtrack(nums, used, current, result);

            // Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
