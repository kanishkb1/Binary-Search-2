// Time Complexity : O(log n) (binary search approach) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: We are looking for the peak element in a way where we can discard the left or right part of given arrayt


class PeakElement {
    public int findPeakElement(int[] nums) {

        //Initialize the pointers
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid;

        //binary search implementation
        while(low <=high){

            
            mid = low + (high - low) / 2;
            
            //check for the middle index as peak element
            if((mid== n - 1 || nums[mid]>nums[mid+1]) && (mid ==0 && nums[mid] > nums[mid - 1])){
                return mid;
            }

             // If the element to the left of mid is greater, search in the left half
            else if(mid > 0 && nums[mid] < nums[mid-1]){
                high = mid - 1;
            }
            // If the element to the right of mid is greater or equal, search in the right half
            else{
                low = mid + 1;    
            }
        }

        //If no element is found after the while loop, return the highest index found
        return high;
    }
}