class Solution {
public:
    int countHomogenous(string s) {
        // Using sliding window
        const int mod = 1e9+7;
        int i = 0,j = 0;
        int n = s.size();
        int ans = 0;
        //sliding window
        while(j<n)
        {
            
            while(s[i] != s[j])
            {
                i++;
            }
            
            if(s[i] == s[j])
            {
                ans =  (ans + (j-i+1))%mod;
            }
            
            j++;
        }
        
        return ans;
    }
};