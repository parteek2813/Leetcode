class RecentCounter {
   List<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }
    
    public int ping(int t) {
        list.add(t);
        int index = Collections.binarySearch(list, t - 3000); // search the index of t - 3000.
        if (index < 0) { index = ~index; } // if t - 3000 is not in list, use the index of the ceiling of t - 3000.
        return list.size() - index;
    }
    
}

// class RecentCounter {

//         Queue<Integer> q;
//         int min;
        
//         public  RecentCounter() {
//             q= new LinkedList<Integer>();
//         }
        
    
//         public int ping(int t) {
//         q.offer(t);
//         min = t - 3000;
//             while(min > q.peek()){
//                 q.poll();
//             }
        
//         return q.size();
//         }  
// }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */