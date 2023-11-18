class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n=nums.length;
        int preSum[]=new int[n];

         
         preSum[0]=0;
         for(int i=1;i<n;i++){ 
            preSum[i]=nums[i-1]+preSum[i-1];  
        }

        int maxLen=1;

        for(int i=0;i<n;i++){ 
            
            int st=0,end=i-1;

            while(st<=end){ 
// we are getting area having sum of that area by prefix sum & checking if disance between them(i to mid) * current value of i - sum of that area(by prefix sum) is less than or equal to  k 
                   int mid=(st+end)/2;
                   int dist=i-mid;
                   if(((dist)*nums[i]) - (preSum[i]-preSum[mid])<=k){ 
                       maxLen=Math.max(i-mid+1,maxLen);
                       end=mid-1;
                   }else{ 
                       st=mid+1;
                   }
 
            }


        }



return maxLen;


    }
}