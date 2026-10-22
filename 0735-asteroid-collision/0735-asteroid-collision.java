
import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            // Collision occurs only when the previous asteroid
            // moves right and the current asteroid moves left
            while (alive && asteroid < 0 && !stack.isEmpty()
                    && stack.peek() > 0) {

                if (stack.peek() < -asteroid) {
                    // Stack asteroid is smaller, so it explodes
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    // Both asteroids explode
                    stack.pop();
                    alive = false;
                } else {
                    // Current asteroid is smaller, so it explodes
                    alive = false;
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}
