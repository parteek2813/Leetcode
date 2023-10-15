class Solution { 
public: 
    vector<int> findIndices(vector<int>& nums, int indexDifference, int valueDifference) { 
        vector<int>ans; 
        
        int iD = indexDifference;
        int vD = valueDifference;
         
        int n = nums.size(); 
         
        int mx = nums[0], idx1 = 0; 
        int mn = nums[0], idx2 = 0; 
         
         
        for(int i=iD; i<n; i++){ 
            if(nums[i-iD] > mx){ 
                mx = nums[i-iD]; 
                idx1 = i-iD; 
            } 
            if(nums[i-iD] < mn){ 
                mn = nums[i-iD]; 
                idx2 = i-iD; 
            } 
             
            if(abs(nums[i] - mx) >= vD){ 
                return {idx1, i}; 
            } 
             
            if(abs(nums[i] - mn) >= vD){ 
                return {idx2, i}; 
            } 
        } 
        return {-1,-1}; 
    } 
};