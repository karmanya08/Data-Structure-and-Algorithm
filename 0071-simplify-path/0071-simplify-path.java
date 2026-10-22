
import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                // Ignore empty parts and current directory
                continue;
            } 
            else if (part.equals("..")) {
                // Move to parent directory if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            else {
                // Add a valid directory name
                stack.push(part);
            }
        }

        // Build the canonical path
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}
