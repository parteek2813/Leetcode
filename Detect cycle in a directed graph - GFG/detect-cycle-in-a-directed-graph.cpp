//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
  
    // bool isCycleDFS(vector<int> adj[], int u, vector<bool>& visited, vector<bool>& inRecursion){
        
    //     visited[u] = true;
        
    //     inRecursion[u] = true;
        
    //     for(int &v: adj[u]){
    //         if(!visited[v] && isCycleDFS(adj, v , visited, inRecursion)){
    //             return true;
    //         }else if(visited[v] && inRecursion[v] == true){
    //             return true;
    //         }
    //     }
    //     inRecursion[u] = false;
    //     return false;
        
    // }
    
    
    
    // Function to detect cycle in a directed graph.
    // bool isCyclic(int V, vector<int> adj[]) {
        
    //     vector<bool> visited(V, false);
    //     vector<bool> inRecursion(V, false);
        
        
    //     for(int i =0; i<V; i++){
    //         if(!visited[i] && isCycleDFS(adj, i, visited, inRecursion)){
    //             return true;
    //         }
    //     }   
    //     return false; 
    // }
    
    bool isCyclic(int N, vector<int> adj[]) {
        
        
        
        vector<int> indegree(N, 0);
        queue<int> que;
        
        vector<int> result;
        
        
        // 1. Store the indegree element 
        for( int u =0; u< N; u++){
            
            for(int &v : adj[u]){
                
                indegree[v]++;
                
            }
        };
        
        
        // 2. fill the queue where indegree is 0
        for(int i =0; i<N; i++){
            if(indegree[i] == 0){
                que.push(i);
            }
        }
        
        // 3. while queue empty nahi hein
        
        while(!que.empty()){
            int u = que.front();
            
            result.push_back(u);
            
            que.pop();
            
            for(int &v: adj[u]){
                indegree[v]--;
                
                
                if(indegree[v] == 0){
                    que.push(v);
                }
            }
        }
        
        
        // calculate the count
        int count = result.size();
        
        if(count == N){
            return false;
        };
        
        return true;
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