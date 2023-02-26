class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        backtrack(nums, result, new ArrayList(), 0);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int start){
        result.add(new ArrayList<Integer>(temp));

        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(nums, result, temp, i+1);
            temp.remove(temp.size()-1);
        }

    }

}