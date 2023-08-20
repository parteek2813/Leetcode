//  class TrieNode{
//      TrieNode[] children;
//      List<String> suggestions;
     
//      TrieNode(){
//          children = new TrieNode[26];
//          suggestions = new ArrayList<>();
//      }
//  }

// class Trie{
//     TrieNode root;
    
//     Trie(){
//         root = new TrieNode();
//     }
    
//     // insert function
    
//     void insert(String word){
//         TrieNode node = root;
        
//         for(char c: word.toCharArray()){
//             int index = c-'a';
//             if(node.children[index] == null){
//                 node.children[index] = new TrieNode();
//             }
            
//             node = node.children[index];
//             node.suggestions.add(word);
//             node.suggestions.sort(null);
            
//             // keep only the top 3 suggestions
//             if (node.suggestions.size() > 3) {
//                 node.suggestions.remove(3); 
//             }
//         }
//     }
    
//     List<String> search(String prefix) {
//         TrieNode node = root;
//         List<String> result = new ArrayList<>();
//         for (char c : prefix.toCharArray()) {
//             int index = c - 'a';
//             if (node.children[index] == null) {
//                 return result; // Prefix not found, return empty list
//             }
//             node = node.children[index];
//         }
//         return node.suggestions;
//     }
// }

// class Solution {
    
//     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//             Arrays.sort(products);
//         Trie trie = new Trie();
         
//         for (String product : products) {
//             trie.insert(product);
//         }
        
// //          make new arraylist
//          List<List<String>> result = new ArrayList<>();
//         String prefix = "";
//         for (char c : searchWord.toCharArray()) {
//             prefix += c;
//             result.add(trie.search(prefix));
//         }
        
//         return result;

//     }
// }


class Solution {
     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
         List<List<String>> result = new LinkedList<>();
        
         // sorting
         Arrays.sort(products);
         
         for(int i =0;i < searchWord.length(); i++){
             result.add(new LinkedList<>());
         }
         
         int index =0;
         int count=0;
         
         
         while (index < products.length) {
            if (count == searchWord.length()*3) break;
            // find min length 
            int len = Math.min(searchWord.length(),products[index].length());
             for (int i = 0; i < len; i++) {
                if (products[index].charAt(i) == searchWord.charAt(i)) {
                    List<String> list = result.get(i);
                    // check limit
                    if (list.size() < 3) {
                        list.add(products[index]);
                        count++;
                    }
                } else break;
            }
            index++;
        }
         
           return result; 
     }
}