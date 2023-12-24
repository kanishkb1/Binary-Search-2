// Time Complexity : O(log n) (binary search approach) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: We are using two binary search algorithm. First will find the first position of occurence. Then we used the second binary search, which will ranges from first position to last.

class Solution {

        //lOOK FOR BINARY SEARCH LEFT
        private int binarySearchLeft(int [] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low) /2;
            if(nums[mid] == target){

                if(mid==0 || nums[mid] > nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
                else if(nums[mid] > target){
                     high = mid - 1;   
                }else{
                    low = mid + 1;
                }

            }
            return -1;
        }
            //Look for 2nd binary search from range first element to last element
         private int binarySearchRight(int [] nums, int low, int high, int target){
             while(low<=high){
            int mid = low + (high - low) /2;
            if(nums[mid] == target){

                if(mid==nums.length -1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid+ 1;
                }
            }
                else if(nums[mid] > target){
                     high = mid - 1;   
                }else{
                    low = mid + 1;
                }

            }
            return -1;
        }
 public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length ==0){
            return new int[]{-1,-1};
        }
        int n = nums.length;
        int left = binarySearchLeft(nums,0,n-1,target);
        if(left==-1){
            return new int []{-1,-1};
        }

        int right = binarySearchRight(nums,left,n-1,target);
        return new int []{left,right};
    }
}