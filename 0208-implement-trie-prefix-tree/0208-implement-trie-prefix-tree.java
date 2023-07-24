class Node{
    char data;
    boolean isTerminal;
    HashMap<Character,Node> hm;
    
    // constructor
    Node(char d){
        this.data = d;
        this.isTerminal = false;
        this.hm = new HashMap<>();
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node('0');
    }
    
    public void insert(String word) {
        Node temp = root;
        for(char s : word.toCharArray()){
            if(!temp.hm.containsKey(s)){
                Node n = new Node(s);
                temp.hm.put(s, n); // char and address store in hashmap
            }
            temp = temp.hm.get(s);
            
        }
        temp.isTerminal = true; // finishd all chars in word and reached at last node
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(char ch: word.toCharArray()){
            if(temp.hm.containsKey(ch)){
                temp = temp.hm.get(ch); // move on to next node by taking address from hm
                continue;
            }
            return false;
        }
        return temp.isTerminal;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(char ch: prefix.toCharArray()){
            if(!temp.hm.containsKey(ch)){
                return false;
            }
            temp = temp.hm.get(ch);
        }
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */