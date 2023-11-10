//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
  
    bool isCycleDFS(vector<int> adj[], int u, vector<bool>& visited, vector<bool>& inRecursion){
        
        visited[u] = true;
        
        inRecursion[u] = true;
        
        for(int &v: adj[u]){
            if(!visited[v] && isCycleDFS(adj, v , visited, inRecursion)){
                return true;
            }else if(visited[v] && inRecursion[v] == true){
                return true;
            }
        }
        inRecursion[u] = false;
        return false;
        
    }
    // Function to detect cycle in a directed graph.
    bool isCyclic(int V, vector<int> adj[]) {
        
        vector<bool> visited(V, false);
        vector<bool> inRecursion(V, false);
        
        
        for(int i =0; i<V; i++){
            if(!visited[i] && isCycleDFS(adj, i, visited, inRecursion)){
                return true;
            }
        }
        
        
        return false;
        
    }
};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;

        vector<int> adj[V];

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
        }

        Solution obj;
        cout << obj.isCyclic(V, adj) << "\n";
    }

    return 0;
}

// } Driver Code Ends