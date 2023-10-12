/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    
    public static int bsInLeft(int s, int e ,int target, MountainArray mountainArr){
        
        int n = mountainArr.length();
        
        while(s<=e){
              int mid = s + (e - s) / 2;
              int midVal = mountainArr.get(mid);
            
            if(midVal == target){
                return mid;
            }else if(midVal < target){
                s = mid+1;
            }else{
                e = mid-1;
            }
           
        }
         return -1;
        
    }
    
    public static int bsInRight(int s, int e ,int target, MountainArray mountainArr){
        while(s <= e){
            int mid = s + (e - s) / 2;
            int midVal = mountainArr.get(mid);
            if(midVal == target) {
                return mid;
            } else if(midVal < target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
    
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0;
        int right = n - 1;
        
        // find the mountainIndex first 
        while(left < right){
            int mid = left + (right - left) / 2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        int peekIndex = left;
        int leftIndex = bsInLeft(0, peekIndex, target, mountainArr);
        
        // if found in left index , just return this
        if(leftIndex != -1){
            return leftIndex;
        }
        
        // otherwise try in right one too
        
        int rightIndex = bsInRight(peekIndex, n - 1,target, mountainArr);
        return rightIndex;
        
        
        
    }
}