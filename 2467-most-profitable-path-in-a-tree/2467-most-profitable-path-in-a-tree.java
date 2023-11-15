class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=edges.length+1;
        adj=new ArrayList[n];
    for (int i=0;i<n;i++)
    adj[i]=new ArrayList<>();
for (int[]edge:edges)
{
    int u=edge[0];
    int v=edge[1];
    adj[u].add(v);
    adj[v].add(u);
}

dis_bob=new int[n];
Arrays.fill(dis_bob,-1);
vis=new boolean[n];
dfs1(bob,0);
vis=new boolean[n];
res=(int)-1e18;
        dfs2(0,0,amount,-1,0);
        return res;
    }
static ArrayList<Integer>[]adj;
static int[]dis_bob;
static boolean dfs1(int n,int depth)
{

    vis[n]=true;
    if (n==0)
    {
        dis_bob[n]=depth;
        return true;
    }
    boolean ans=false;
for (int child:adj[n])
{
    if (!vis[child])
        ans|=dfs1(child,depth+1);
}
if (ans)
    dis_bob[n]=depth;
return ans;
}
static boolean[]vis;
 static int res;
    static void dfs2(int n,int depth,int[]amount,int p,int score)
    {
        if (depth<dis_bob[n]||dis_bob[n]==-1)
            score+=amount[n];
        else if (depth==dis_bob[n])
            score+=(amount[n]/2);
        if (adj[n].size()==1&&adj[n].get(0)==p)
            res=Math.max(res,score);
        vis[n]=true;

        for (int child:adj[n])
        {
            if (!vis[child])
           dfs2(child,depth+1,amount,n,score);
        }

    }
    
    
}