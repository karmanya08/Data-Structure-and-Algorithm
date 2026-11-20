
import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        HashMap<Integer, String> map = new HashMap<>();

        // Store height and name
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        // Sort heights in descending order
        Arrays.sort(heights);

        String[] result = new String[names.length];

        int index = 0;

        // Traverse from largest to smallest
        for (int i = heights.length - 1; i >= 0; i--) {

            result[index] = map.get(heights[i]);
            index++;
        }

        return result;
    }
}
