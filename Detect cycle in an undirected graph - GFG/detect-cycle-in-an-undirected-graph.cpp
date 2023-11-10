//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
  
  
//   bool isCycleDFS(vector<int> adj[], int u, vector<bool>& visited, int parent){
      
//       visited[u] = true;
      
//       for(int &v : adj[u]){
//           if(v == parent) continue;
          
          
          
//           if(visited[v]){
//               return true;
//           }
          
//           if(isCycleDFS(adj, v, visited, u)){
//               return true;
//           }
          
//       }
//       return false;
//   }
    // Function to detect cycle in an undirected graph.
    // bool isCycle(int V, vector<int> adj[]) {
        
    //     vector<bool> visited(V, false);
        
    //     for(int i =0; i<V; i++){
    //         if(!visited[i] && isCycleDFS(adj, i, visited, -1)){
    //             return true;
    //         }
    //     }
        
    //     return false;
    // }
    
    
    bool isCycleBFS(vector<int> adj[], int u, vector<bool>& visited){
        
            queue<pair<int,int>> que;
            
            // push starting index first
            que.push({u, -1});
            
            visited[u] = true;
            
            while(!que.empty()){
                
                pair<int, int> P = que.front();
                que.pop();
                
                int source = P.first;
                int parent = P.second;
                
                
                // iss source se kaha kaha jaa sakte
                
                for(int &v: adj[source]){
                    if(visited[v] == false){
                        visited[v] = true;
                        
                        que.push({v, source});
                        
                        
                    }else if (v != parent){
                        return true;
                    }
                }
            }
            
           return false; 
        
    }
    
    bool isCycle(int V, vector<int> adj[]) {
        
        vector<bool> visited(V, false);
        
        for(int i =0; i<V; i++){
            if(!visited[i] && isCycleBFS(adj, i, visited)){
                return true;
            }
        }
        
        return false;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >> E;
        vector<int> adj[V];
        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        Solution obj;
        bool ans = obj.isCycle(V, adj);
        if (ans)
            cout << "1\n";
        else
            cout << "0\n";
    }
    return 0;
}
// } Driver Code Ends