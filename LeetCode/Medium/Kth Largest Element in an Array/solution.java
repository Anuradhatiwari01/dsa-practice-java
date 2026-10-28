class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        
        for(int num : nums){
            if(minheap.size() < k){
                minheap.offer(num);
            }
            else if(minheap.peek() < num){
                minheap.poll();
                minheap.offer(num);
            }
        }
        return minheap.peek();
    }
}