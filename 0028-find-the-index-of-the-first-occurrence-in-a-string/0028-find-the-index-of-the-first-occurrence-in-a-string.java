class Solution {
    public int strStr(String haystack, String needle) {
        int hayLen = haystack.length();
        int needlelen =needle.length();

//If haylen is less , just return -1
        if(hayLen < needlelen){
            return -1;
        }

       
        for(int i=0; i<=hayLen - needlelen; i++){
             int j =0;
             while(j<needlelen && haystack.charAt(i+j) == needle.charAt(j))
             j++;
             if(j == needle.length()){
                 return i;
             }
        }
        return -1;

    }
}