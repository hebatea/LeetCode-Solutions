class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];

        List<List<Integer>> result = new ArrayList();
        
        backtrack(result, new ArrayList<Integer>(), nums, used);
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == nums.length){
            result.add(new ArrayList<Integer>(temp));
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            temp.add(nums[i]);

            backtrack(result, temp, nums, used);

            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}