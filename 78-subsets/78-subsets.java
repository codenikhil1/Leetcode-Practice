class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
        generateList(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    
    public void generateList(int[] nums,int currentIndex,ArrayList<Integer> currentList,List<List<Integer>> ans){
        
        if(currentIndex >= nums.length){
            ans.add(new ArrayList<>(currentList));
            return;
        }
        
        currentList.add(nums[currentIndex]);
        
        generateList(nums,currentIndex+1,currentList,ans);
        
        currentList.remove(currentList.size()-1);
        
        generateList(nums,currentIndex+1,currentList,ans);
        
        return;
    }
}