
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always perform binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {

            // Partition positions
            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            // Left and right values of both arrays
            int left1 = (cut1 == 0)
                    ? Integer.MIN_VALUE : nums1[cut1 - 1];

            int right1 = (cut1 == m)
                    ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0)
                    ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right2 = (cut2 == n)
                    ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition found
            if (left1 <= right2 && left2 <= right1) {

                // Odd number of elements
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even number of elements
                return (Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2.0;
            }

            // Move binary search to the left
            else if (left1 > right2) {
                high = cut1 - 1;
            }

            // Move binary search to the right
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}
