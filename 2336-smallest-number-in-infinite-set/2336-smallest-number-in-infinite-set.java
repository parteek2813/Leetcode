// class SmallestInfiniteSet {

//      int cur;
//      Set<Integer> s;
        
    
//     public SmallestInfiniteSet() {
      
//             cur = 1;
//             s = new HashSet<>();
//     }
    
//     public int popSmallest() {
//         if(!s.isEmpty()){
//             int res = Collections.min(s); // get the minimum from the hashset s 
//             s.remove(res);
//             return res; 
//         }else{
//             cur++;
//             return cur-1;
//         }
//     }
    
//     public void addBack(int num) {
//         if(cur > num){
//             s.add(num);
//         }
//     }
// }


class SmallestInfiniteSet {

    
    private PriorityQueue<Integer> q;
    private int index;
    
    
    public SmallestInfiniteSet() {
        q = new PriorityQueue<Integer>();
        index = 1;
    }
    
    
    public int popSmallest() {
        if(q.size() > 0){
            return q.poll();
        }
        return index++;
        
    }
    
    private boolean is_in_q(int num){
        for(int i : q){
            if(i==num){
                return true;
            }
           
        }
         return false;
    }
    
    public void addBack(int num) {
       if(num < index && !is_in_q(num)){
           q.add(num);
       }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */