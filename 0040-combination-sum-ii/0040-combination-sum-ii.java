class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList();
        Arrays.sort(candidates);
        backtrack(0, results, new ArrayList<Integer>(), candidates, target);
        return results;
    }

    private void backtrack(int start, List<List<Integer>> results, List<Integer> temp,int[] nums, int target){
        if(target < 0) return;
        if(target == 0){
            results.add(new ArrayList(temp));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(i+1, results, temp, nums, target - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }
}