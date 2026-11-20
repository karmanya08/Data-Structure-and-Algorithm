class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Add the current subset to the result
        result.add(new ArrayList<>(current));

        // Explore remaining elements
        for (int i = start; i < nums.length; i++) {

            // Choose the current element
            current.add(nums[i]);

            // Explore the next elements
            backtrack(nums, i + 1, current, result);

            // Backtrack: remove the last element
            current.remove(current.size() - 1);
        }
    }
}
