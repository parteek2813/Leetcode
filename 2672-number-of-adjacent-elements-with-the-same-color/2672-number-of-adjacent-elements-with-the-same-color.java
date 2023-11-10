class Solution {
    public int[] colorTheArray(int n, int[][] query) {
        int []a = new int [query.length];
        int []nums = new int[n];
        int answer=0;
        for (int i=0;i<query.length;i++)
        {
            int preadjacency=0;
            int curradjacency=0;

            int index=query[i][0];
            int colornow= query[i][1];
            int colorpre=nums[index];

            if (nums[index]!=0)
            {
                int left=0;
                int right=0;
                if (index-1>=0)
                left= (nums[index-1]==nums[index])? 1:0;
                if (index+1<nums.length)
                right= (nums[index+1]==nums[index])? 1:0;

                preadjacency=left+right;
            }
            nums[index]=colornow;
            int l=0;
            int r=0;
            if (index-1>=0)
            l = (nums[index-1]==nums[index])? 1:0;
            if (index+1<nums.length)
            r= (nums[index+1]==nums[index])? 1:0;
            curradjacency=l+r;

            answer+= curradjacency-preadjacency;
            a[i]=answer;
        }
        return a;
    }
}