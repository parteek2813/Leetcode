 class TrieNode{
     TrieNode[] children;
     List<String> suggestions;
     
     TrieNode(){
         children = new TrieNode[26];
         suggestions = new ArrayList<>();
     }
 }

class Trie{
    TrieNode root;
    
    Trie(){
        root = new TrieNode();
    }
    
    // insert function
    
    void insert(String word){
        TrieNode node = root;
        
        for(char c: word.toCharArray()){
            int index = c-'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            
            node = node.children[index];
            node.suggestions.add(word);
            node.suggestions.sort(null);
            
            // keep only the top 3 suggestions
            if (node.suggestions.size() > 3) {
                node.suggestions.remove(3); 
            }
        }
    }
    
    List<String> search(String prefix) {
        TrieNode node = root;
        List<String> result = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return result; // Prefix not found, return empty list
            }
            node = node.children[index];
        }
        return node.suggestions;
    }
}

class Solution {
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);
        Trie trie = new Trie();
         
        for (String product : products) {
            trie.insert(product);
        }
        
//          make new arraylist
         List<List<String>> result = new ArrayList<>();
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.search(prefix));
        }
        
        return result;

    }
}