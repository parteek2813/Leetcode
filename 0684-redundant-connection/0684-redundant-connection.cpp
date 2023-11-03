class Solution {
public:
    
    int * parent;
    
    // finding the parent 
    int find(int x){
        if(parent[x] == x) return x;
        
        return find(parent[x]);
    }
    
    
    void union_ (int a, int b){
        
        // find is giving us the representative 
        a = find(a);
        b = find(b);
        
        parent[a] = b;
        
        
    }
    
    vector<int> findRedundantConnection(vector<vector<int>>& e) {
        
        int n = e.size(); // e.size() because there are extra edges
        
        parent = new int[n+1];
        
        for(int i =1; i<=n; i++){
            parent[i] = i;
        }
        
        // traversing our edge list 
        for(auto a: e)
        {
            if(find(a[0]) == find(a[1])) return a;
            
            union_(a[0], a[1]);   
        }
        return {};
    }
};