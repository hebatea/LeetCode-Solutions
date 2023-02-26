class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        backtrack(0, result, new ArrayList<Integer>(), nums);
        return result;
    }

    private void backtrack(int start, List<List<Integer>> result, List<Integer> temp, int[] nums){
        result.add(new ArrayList<Integer>(temp));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1] )continue;
            temp.add(nums[i]);
            backtrack(i+1, result, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}