class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] phone = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", phone, ans);

        return ans;
    }

    void backtrack(String digits, int index, String current,
                   String[] phone, List<String> ans) {

        // We have selected one letter for every digit
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        // Get letters corresponding to current digit
        String letters = phone[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {

            // Choose
            current += letters.charAt(i);

            // Explore
            backtrack(digits, index + 1, current, phone, ans);

            // Undo
            current = current.substring(0, current.length() - 1);
        }
    }
}