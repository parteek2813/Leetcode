class Solution {
public:
    
    // In worst case, the union finder algorithm runs for O(N)
    // Where N is the Number of Nodes 
    
    int * parent;
    int * rank;
    
    
    // finding the parent 
    int find(int x){
        if(parent[x] == x) return x;
        
        return find(parent[x]);
    }
    
    
    void union_ (int a, int b){
        
        // find is giving us the representative 
        a = find(a);
        b = find(b);
        
        
        
        // make a choice whether a should be the parent of b or vice-versa
        
        if(rank[a] > rank[b]){
            parent[b] = a;
            rank[a] += rank[b]; // now the element under the group b will come under the group A 
        }
        else{
            parent[a] = b;
            rank[b] += rank[a];
            
        }
    }
    
    vector<int> findRedundantConnection(vector<vector<int>>& e) {
        
        int n = e.size(); // e.size() because there are extra edges
        
        parent = new int[n+1];
        
        // initialize the rank
        
        rank = new int[n+1];
        
        for(int i =1; i<=n; i++){
            parent[i] = i, rank[i] = 1;
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