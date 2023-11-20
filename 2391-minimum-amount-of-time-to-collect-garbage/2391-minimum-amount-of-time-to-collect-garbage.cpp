class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        int ans=0;
        travel.insert(travel.begin(),0);
        for(int i=1;i<travel.size();i++){
            travel[i]+=travel[i-1];
        }
        int p,m,g;
        p=m=g=0;
        for(int i=0;i<garbage.size();i++){
            for(char j:garbage[i]){
                if(j=='P'){
                    ans+=(travel[i]-travel[p]);
                    p=i;
                }
                else if(j=='G'){
                   ans+=(travel[i]-travel[g]);
                   g=i;
                }
                else{
                   ans+=(travel[i]-travel[m]);
                   m=i;
                }
                ans++;
            }

        }


        return ans;
    }

};