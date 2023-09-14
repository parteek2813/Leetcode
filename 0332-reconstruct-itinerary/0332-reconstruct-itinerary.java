class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> mapEdges = new HashMap<>();
        
        for(List<String> ticket : tickets) {
            PriorityQueue<String> q = mapEdges.getOrDefault(ticket.get(0), new PriorityQueue<String>( (s1, s2) -> s1.compareTo(s2) )) ;
            q.offer(ticket.get(1));
            mapEdges.put(ticket.get(0), q);
        }
        
        
        Stack<String> s = new Stack<>();
        s.push("JFK"); // Starting point is JFK
        
        List<String> finalIternary = new ArrayList<>();
        while(!s.isEmpty()) {

            String source = s.peek();
            PriorityQueue<String> q = mapEdges.get(source);
            
            if(q == null || q.isEmpty()) {
                finalIternary.add(s.pop());
            } else {
                s.push(q.poll());
            }
        }
        
        Collections.reverse(finalIternary);      
        return finalIternary;
    }
}