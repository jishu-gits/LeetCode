import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to use the two-pointer approach
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // Iterate through the array, fixing the first element
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Set up the two pointers
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a triplet, add it to the result list
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move pointers and skip duplicates for the second and third numbers
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    // Sum is too small, move left pointer to a larger value
                    left++;
                } else { // sum > 0
                    // Sum is too large, move right pointer to a smaller value
                    right--;
                }
            }
        }
        return result;
    }
}