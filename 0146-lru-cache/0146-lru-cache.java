
// node class
class Node{
    int key;
    int value;
    Node pre;
    Node next;
    
    public Node(int key, int value){
    this.key = key;
    this.value = value;
}
    
}


class LRUCache {
    
    HashMap<Integer, Node> map;
    int capacity, count;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0); // key and value both are 0,0
        tail = new Node(0,0);
        count = 0;
        head.next = tail; 
        tail.pre = head; // connecting both the head and tail on both sides
        head.pre = null;
        tail.next = null;
        
        
        
    }
    
    public void deleteNode(Node node) {
	node.pre.next = node.next;
	node.next.pre = node.pre;
    }
    
    public void addToHead(Node node){
        node.next = head.next;
        node.next.pre =node;
        node.pre = head;
        head.next = node;
            
    }
    
    public int get(int key) {
        if(map.get(key) != null){ // if found 
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node); // delete that node too
            addToHead(node); //retrieve at first node too
            return result;
        }
        return -1; // if not found
        
    }
    
    public void put(int key, int value) {
        if(map.get(key) != null){
            Node node = map.get(key);
            node.value = value; /// if already presenet then simply updates its index with value;
            deleteNode(node);
            addToHead(node);
        }else{
            Node node = new Node(key, value);
            map.put(key, node); // put in hashmap first to register that it came
            if(count < capacity){
                count++;
                addToHead(node); // it means there is some space
                
            }else{
                map.remove(tail.pre.key); // remove the tail address from hashmap
                deleteNode(tail.pre); // remove from linkedlist here
                addToHead(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */