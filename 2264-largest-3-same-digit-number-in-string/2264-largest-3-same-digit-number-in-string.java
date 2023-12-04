class Solution {
    public String largestGoodInteger(String num) {
        String[] arr = {"000","111","222","333","444","555","666","777","888","999"};
        int max=-1;
        for( int i=9;i>-1;i--){
            if(num.contains(arr[i])){
                max=i;
                break;
            }
        }
        if(max==-1)
        return "";
        return arr[max];
        
        
    }
}