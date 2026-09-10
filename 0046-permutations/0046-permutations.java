class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), ans);

        return ans;
    }

    void backtrack(int[] nums, boolean[] used,
                   List<Integer> current,
                   List<List<Integer>> ans) {

        // One complete permutation
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            // Choose
            current.add(nums[i]);
            used[i] = true;

            // Explore
            backtrack(nums, used, current, ans);

            // Undo choice
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}