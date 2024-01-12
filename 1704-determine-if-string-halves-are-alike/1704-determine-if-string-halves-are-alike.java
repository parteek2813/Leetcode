class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String str = "";
        String str2 ="";
        int count1=0;
        int count2=0;
        char ch;
        for(int i=0;i<n;i++)
        {
            if(i<n/2)
            {
                ch =s.charAt(i);
                if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='o'||ch=='i'||ch=='u')
                count1++;
            }
            else
            {
                ch =s.charAt(i);
                if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='o'||ch=='i'||ch=='u')
                count2++;
            }
            
        }
        if(count1==count2)
        return true;
        return false;

        
    }
}