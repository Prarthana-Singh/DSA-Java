class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0, dp[] = new int[1 << 17];
        dp[0] = 1;
        for (int a : nums) {
            for (int i = max; i >= 0; --i)
                dp[i | a] += dp[i];
            max |= a;
        }
        return dp[max];
    }
}
