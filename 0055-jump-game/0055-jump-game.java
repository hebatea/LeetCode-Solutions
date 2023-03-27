class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;

        for(int i = 0; i < nums.length; i++){
            if(reachable < i) return false;
            reachable = Math.max(reachable, i+nums[i]);
        }
        return true;
    }
}

/*
 0 1 2 3 4
[2,3,1,1,4]

reachable = 8

 0 1 2 3 4         
[3,2,1,0,4]

reachable = 3

 */