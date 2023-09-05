class Solution {
    public int minimumOperations(String num){
        boolean zerofound = false;
        boolean fivefound = false;
        for (int i =num.length()-1; i >=0;i--){ 
            if (zerofound && num.charAt(i)=='0') return num.length()-2-i;
            if (zerofound && num.charAt(i)=='5') return num.length()-2-i;
            if (fivefound && num.charAt(i)=='2') return num.length()-2-i;
            if (fivefound && num.charAt(i)=='7') return num.length()-2-i;
            if (num.charAt(i)=='5') fivefound = true;
            if (num.charAt(i)=='0') zerofound = true;   
        }
        if (zerofound) return num.length()-1;
        return num.length();
    }
}