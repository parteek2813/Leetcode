class Solution {
    public int lengthOfLastWord(String s) {
        int len =0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            
            if(s.charAt(i) != ' '){
                len++;
            }else{
                
                // this will run only if length become more than 0 which means first if condition 
                // ran already
                if(len>0){
                    return len;
                }
            }
            
            
        }
        return len;
    }
}
