class Solution {
public:
    
    int n;
    
    void DFS(unordered_map<int, vector<int>>& adj, int u, vector<bool>& visited){
        
        
        visited[u] = true;
        
        for(int &v: adj[u]){
            if(!visited[v]){
                DFS(adj, v, visited);
            }
        }
    }
    
    int findCircleNum(vector<vector<int>>& isConnected) {
        
        n = isConnected.size();
        
        vector<bool> visited(n, false);
        
        
        // make a graph adj
        
        unordered_map<int, vector<int>> adj;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                if(isConnected[i][j] == 1){
                    
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        };
        
        
        // DFS CODE
        
        int count = 0;
        for(int i =0; i<n; i++){
            if(!visited[i]){
                DFS(adj, i, visited);
                count++;
            }
        }
        return count;
    }
};