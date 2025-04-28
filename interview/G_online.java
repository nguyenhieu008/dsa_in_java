package interview;

import java.util.Arrays;
import java.util.Stack;

public class G_online {
    public class Solution {
        /**
         * Note: The class, method and parameter have been specified. Please do not modify
         *
         *
         *
         * @param nums Integer One-dimensional Array
         * @return Integer
         */
        public int minimumMountainRemovals(int[] nums) {
            int n = nums.length;
            Stack<Integer> increasingIdx = new Stack<>();
            int[] leftRemoved = new int[n];
            int[] rightRemoved = new int[n];
            boolean[] canBePeak = new boolean[n];

            Arrays.fill(canBePeak, true);
//            Arrays.fill(leftRemoved, -1);
//            Arrays.fill(rightRemoved, -1);

            // Beware the case -1 when cannot be the peak
            for (int i = 0; i < n; i++) {
                int removeCount = increasingIdx.isEmpty() ? 0 : leftRemoved[increasingIdx.peek()];
                while (!increasingIdx.isEmpty() && nums[increasingIdx.peek()] >= nums[i]) {
                    removeCount++;
                    increasingIdx.pop();
                }
                if (increasingIdx.isEmpty()) {
                    canBePeak[i] = false;
                }
                leftRemoved[i] = removeCount;
                increasingIdx.push(i);
                System.out.println("left stack = " + increasingIdx);
                System.out.println("left removed = " + Arrays.toString(leftRemoved));
                System.out.println("canBePeak = " + Arrays.toString(canBePeak));
            }

            increasingIdx.clear();
            for (int i = n - 1; i >= 0; i--) {
                int removeCount = increasingIdx.isEmpty() ? 0 : rightRemoved[increasingIdx.peek()];
                while (!increasingIdx.isEmpty() && nums[increasingIdx.peek()] >= nums[i]) {
                    removeCount++;
                    increasingIdx.pop();
                }
                if (increasingIdx.isEmpty()) {
                    canBePeak[i] = false;
                }
                rightRemoved[i] = removeCount;
                increasingIdx.push(i);

                System.out.println("right stack = " + increasingIdx);
                System.out.println("right removed = " + Arrays.toString(rightRemoved));
                System.out.println("canBePeak = " + Arrays.toString(canBePeak));
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (canBePeak[i]) {
                    res = Math.min(res, leftRemoved[i] + rightRemoved[i]);
                }
            }

            return res;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new G_online().new Solution();
        int[] nums = {1, 2, 3, 4, 5, 1, 2, 3, 6,1, 2,3,1};
        int res = solution.minimumMountainRemovals(nums);
        System.out.println("res = " + res);
    }
}
