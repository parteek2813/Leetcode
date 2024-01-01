import java.util.*;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int currentChild = 0;
        int currentCookie = 0;

        while(currentChild < g.length && currentCookie < s.length){
            if(g[currentChild] <= s[currentCookie])
                currentChild++;
            currentCookie++;
        }
        return currentChild;
    }
}