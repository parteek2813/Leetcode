class Solution {
public:
    vector<int> result; // for storing the final result
    
    
    void dfs(int u, int prev, unordered_map<int,vector<int>> &adj){
        
        // starting node daaldo pehle
        result.push_back(u);

        for(int &v : adj[u]){ // traverse over each u ka neighbour
            if(v != prev){
                dfs(v, u, adj);
            }
        }
        
        
    }
    
    vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
         unordered_map<int,vector<int>> adj;
        
        for(vector<int>& vec : adjacentPairs){
            
            int u = vec[0];
            int v = vec[1];
            
            
            // make adjacency list
            adj[u].push_back(v);
            adj[v].push_back(u);
        };
        
        
        // start point nikalo
        int startPoint = -1;
        for(auto &it: adj){
            
            // find the starting point by checking the count
            if(it.second.size() == 1){
                startPoint = it.first;
            }
        };
        
        
        dfs(startPoint, INT_MIN, adj);
        
        return result;
    }
};