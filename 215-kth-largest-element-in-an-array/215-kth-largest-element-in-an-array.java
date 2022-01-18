import java.util.PriorityQueue;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0 ; i < nums.length;i++){
            q.add(nums[i]);
        }
        for(int i = 0 ; i< nums.length-k;i++){
            q.remove();
        }
        return q.peek();
    }
}