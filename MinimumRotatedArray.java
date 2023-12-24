// Time Complexity : O(log n) (binary search approach) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: To find the minimum required array, we need to look for the pivot around 'mid' in binary search approach. If left side is sorted, pivot is at the right and vice-versa.
class Solution {
    public int findMin(int[] nums) {
        int low=0, high, mid;
        int n = nums.length;
        high = n - 1;

        //binary search implementation
        while(low <= high){

        //look for the already sorted arrayt
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            
            mid = low + (high - low) / 2;
            //check for the mid is minimum element by comparing neighbours
            if((mid==0 || nums[mid] < nums[mid -1]) && (mid == n - 1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            //left side is sorted
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            //right side is sorted
            else{
                high = mid - 1;
            }
        }
        return high;
    }
    }
