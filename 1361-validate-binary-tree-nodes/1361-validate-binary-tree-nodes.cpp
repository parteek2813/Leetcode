class Solution {
public:
    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        // TIME COMPLEXITY =====> O(N) 
        
        unordered_map<int, vector<int>> adj; // for the traversal
        unordered_map<int, int> child_to_parent; // child to parent ka map
        
        
        for(int i =0; i<n; i++){
            
            int node = i;
            int leftC = leftChild[i];
            int rightC = rightChild[i];
            
            
            if(leftC != -1){
                adj[node].push_back(leftC);
                
                
                // if in map of child_to_parent , leftC present tha
                // to uske to root jo jayenge , to return false
                
                if(child_to_parent.find(leftC) != child_to_parent.end()){
                    return false;
                }
                
                // otherwise assign kardenge map me
    
                child_to_parent[leftC] = i;
            }
            
            if(rightC != -1){
                adj[node].push_back(rightC);
                
                
                // if in map of child_to_parent , rightC present tha
                // to uske to root jo jayenge , to return false
                
                if(child_to_parent.find(rightC) != child_to_parent.end()){
                    return false;
                }
                
                // otherwise assign kardenge map me
                child_to_parent[rightC] = node;
            }
        }
        
        
        // ab check karo ki root kon hein actual me 
        int root = -1;
        for(int i =0; i<n; i++){
            
            // agr child_to_parent me hume kiska value nahi mila to wo root ho sakta hein
            
            if(child_to_parent.find(i) == child_to_parent.end()){
                if(root != -1){
                    return false;
                
                }
                root = i;
            }
        }
        
        
        
        // agr root mila hi nahi
        if(root == -1){
            return false;
        }
        
        // normal BFS/DFS traversal karo using adjacency matrix
        
        int count = 0;
        queue<int> que;
        vector<bool> visited(n, false); // starting me unvisited to false marked
        
        
        que.push(root);
        count = 1;
        visited[root] = true;
        
        
        while(!que.empty()){
            int node = que.front();
            que.pop();
            
            for( int &v: adj[node]){
                
                // ek binary tree mein visited node me aa hi nahi skte dubara
                // if(visited[v] == true){
                //     return false;
                // }
                
                
                // agr visited nahi hein to visited mark karo
                if(!visited[v]){
                    visited[v] = true;
                    count++;
                    que.push(v);
                }
            }
        }
        
        return count == n;
    }
};