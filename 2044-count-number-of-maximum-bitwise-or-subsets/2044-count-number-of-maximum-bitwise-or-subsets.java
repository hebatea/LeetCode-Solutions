class Solution {
    int max = 0;
    int maxCount = 0;
    public int countMaxOrSubsets(int[] nums) {
        backtrack(0, nums, 0);
        return maxCount;
    }

    private void backtrack(int start, int[] nums, int or){
        if(or > max){
            max = Math.max(max, or);
            maxCount = 1;    
        }else if(or == max){
            maxCount++;
        }
        for(int i = start; i < nums.length; i++){
            backtrack(i+1, nums, or | nums[i]);
        }
    }
}