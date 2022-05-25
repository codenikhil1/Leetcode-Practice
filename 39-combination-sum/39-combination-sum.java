class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generateCombination(candidates,0,target,new ArrayList<>(),ans);
        return ans;
    }
    
    private void generateCombination(int[] nums,int currentIndex,int target,List<Integer> currentList,List<List<Integer>> ans){
        
        if(target == 0){
            ans.add(new ArrayList<>(currentList));
            return;
        }
        if(currentIndex >= nums.length)
            return;
        
        if(nums[currentIndex] <= target){
            currentList.add(nums[currentIndex]);
            generateCombination(nums,currentIndex,target-nums[currentIndex],currentList,ans); 
            currentList.remove(currentList.size()-1);
        }
         generateCombination(nums,currentIndex+1,target,currentList,ans);
    }
    
    
}