class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            // First element is always 1
            row.add(1);

            // Calculate middle elements
            if (i > 0) {
                List<Integer> previous = ans.get(i - 1);

                for (int j = 1; j < i; j++) {
                    row.add(previous.get(j - 1) + previous.get(j));
                }

                // Last element is always 1
                row.add(1);
            }

            ans.add(row);
        }

        return ans;
    }
}