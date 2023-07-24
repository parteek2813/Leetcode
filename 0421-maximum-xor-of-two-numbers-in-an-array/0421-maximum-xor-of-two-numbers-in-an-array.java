class Node{
    
    Node left;
    Node right;
    
    Node(){
        this.left = null;
        this.right = null;    
    }
}

 
class Trie{
     Node root;
    
    public Trie(){
        root = new Node();
    }
    
    
    // creating a bit trie
      public void insert(int n){
        
        Node temp = root;
        // extract the bits and insert into trie
        for(int j =31; j>=0; j--){
            int bit = (n>>j) & 1; //  getJthBit 0 or 1
            if(bit == 0){
               if(temp.left == null){
                   temp.left = new Node(); // if not present , create Node
                   
               }
                temp = temp.left; // if present go to that node 
            }
            else{
                // right bit 1
                if(temp.right == null){
                    temp.right = new Node();
                    
                }
                
                // go to child node
                temp = temp.right;
                
            }
            
        }
        
    }
    
    public int findCurrentMaxXOr(int x){
        Node temp = root;
        int currentAns =0;
        
        for(int j =31; j>=0; j--){
            int bit = (x>>j)&1;
            
            // next step?
            if(bit ==0){
                if(temp.right != null){
                    temp = temp.right;
                    // update the ans
                    currentAns = currentAns + (1<<j); // ans ince by 2^j;
                }else{
                    temp = temp.left; // no change in ans
                }
            }
            
            // bit is 1
            else{
                if(temp.left != null){
                    temp = temp.left; // go to that node
                    currentAns = currentAns + (1<<j);
                    
                }else{
                    temp = temp.right;
                    // no change in ans majburi me lena pad rha
                    
                }
            }
        }
        return currentAns;
    }
    
}


class Solution {
    
    
    
    
    
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        
        // all numbers are inserted into array
        for(int x : nums){
            t.insert(x);
        }
        
        // for every number find out the other number using trie which maximize the xor
        int currentMax=0;
        int ans =0;
        
        for(int x: nums){
            currentMax = t.findCurrentMaxXOr(x);
            ans = Math.max(ans, currentMax);
        }
        return ans;
    
    }
}