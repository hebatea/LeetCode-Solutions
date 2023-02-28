class Solution {
    int result = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(0, nums, 0);
        return result;
    }

    private void backtrack(int start, int[] nums, int xor){
        result += xor;

        for(int i = start; i < nums.length; i++){
            backtrack(i+1, nums, xor ^ nums[i]);
        }
    }
}