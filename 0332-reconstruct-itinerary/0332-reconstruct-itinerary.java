class Solution {
//     public List<String> findItinerary(List<List<String>> tickets) {
//         Map<String, PriorityQueue<String>> mapEdges = new HashMap<>();
        
//         for(List<String> ticket : tickets) {
//             PriorityQueue<String> q = mapEdges.getOrDefault(ticket.get(0), new PriorityQueue<String>( (s1, s2) -> s1.compareTo(s2) )) ;
//             q.offer(ticket.get(1));
//             mapEdges.put(ticket.get(0), q);
//         }
        
        
//         Stack<String>  s = new Stack<>();
//         s.push("JFK"); // Starting point is JFK
        
//         List<String> finalIternary = new ArrayList<>();
//         while(!s.isEmpty()) {

//             String source = s.peek();
//             PriorityQueue<String> q = mapEdges.get(source);
            
//             if(q == null || q.isEmpty()) {
//                 finalIternary.add(s.pop());
//             } else {
//                 s.push(q.poll());
//             }
//         }
        
//         Collections.reverse(finalIternary);      
//         return finalIternary;
//     }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int n = tickets.size();
        
        // Make graph
        for (int i = 0; i < n; ++i) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }
        
        Stack<String> mystack = new Stack<>();
        mystack.push("JFK"); // JFK is our fixed starting point
        
        while (!mystack.isEmpty()) {
            String src = mystack.peek();
            if (adj.containsKey(src) && !adj.get(src).isEmpty()) {
                String dst = adj.get(src).poll();
                mystack.push(dst);
            } else {
                ans.add(0, src);
                mystack.pop();
            }
        }
        
        return ans;
    }
}