class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return 0;
        }

        int[] left_slopes = new int[n];
        int[] right_slopes = new int[n];
        
        // Initialize all slope lengths to 1 (a single element is a slope of length 1)
        for (int i = 0; i < n; i++) {
            left_slopes[i] = 1;
            right_slopes[i] = 1;
        }

        // Pass 1: Calculate increasing slopes from left to right
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                left_slopes[i] = left_slopes[i - 1] + 1;
            }
        }

        // Pass 2: Calculate decreasing slopes from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                right_slopes[i] = right_slopes[i + 1] + 1;
            }
        }

        int maxLength = 0;

        // Pass 3: Find the longest mountain
        for (int i = 0; i < n; i++) {
            // A valid mountain must have both an increasing part and a decreasing part
            if (left_slopes[i] > 1 && right_slopes[i] > 1) {
                int currentMountainLength = left_slopes[i] + right_slopes[i] - 1;
                maxLength = Math.max(maxLength, currentMountainLength);
            }
        }

        return maxLength;
    }
}