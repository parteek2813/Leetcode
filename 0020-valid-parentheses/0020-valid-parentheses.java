class Solution {
    public boolean isValid(String s) {
        
        HashMap<Character,Character> hm = new HashMap<Character,Character>();
       
        // Here just store the brackets pairs
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');
        
        
        // Create a stack
        Stack<Character> stack = new Stack<Character>();
        
        // Traverse string of inouts
        for( int i=0; i<s.length(); i++){
            
            // if open brackets , put it in stack
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
                continue;
            }
            
            if(stack.size() ==0 || hm.get(s.charAt(i)) != stack.pop()){
                return false;
            }
        
        }
        
        //if stack empty return true
        if(stack.size() == 0){
            return true;
        }
        
        return false;
        
    }
}