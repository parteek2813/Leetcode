class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1="";
        String str2="";

         
        int len1=word1.length;
        int  len2=word2.length;

        for(int i=0;i<len1;i++)
        {
           str1+=word1[i];
        }
        for(int i=0;i<len2;i++)
        {
           str2+=word2[i];
        }
        if(str1.contains(str2) && str2.contains(str1))
        {
            return true;
        }
        return false;

    }
}