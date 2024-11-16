class Solution {
    public int[] resultsArray(int[] nums, int k) {
         int n = nums.length;
        int[] results = new int[n - k + 1];
        
        // Iterate over each subarray of size k
        for (int i = 0; i <= n - k; i++) {
            boolean isValid = true;
            int maxElement = nums[i];
            
            // Check if the subarray is consecutive and sorted
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] != nums[j - 1] + 1) {
                    isValid = false;
                    break;
                }
                maxElement = Math.max(maxElement, nums[j]);
            }
            
            // Set the result based on whether the subarray is valid or not
            if (isValid) {
                results[i] = maxElement;
            } else {
                results[i] = -1;
            }
        }
        
        return results;
    }
}
