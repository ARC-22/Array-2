// Time Complexity : O(m)
// Space Complexity : O(1) // since only updating return array
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// since array consist on 1-N numbers, use element as index to tag element. 
// Traverse throgh array to find non-taged numbers, those will missing numbers  
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length ==0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1; // ignore previous -ve done in folloeing steps
            if(nums[index]>0) // make it -ve only for fisrt time
            {
                nums[index] *= -1;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                result.add(i+1); // missing element is the Index +1 
            }
        }

        return result;

        
    }
}