class Solution {

  int N, Goal, K;
  
  int mod = (int)1e9+7;
  
  long[][] dp = new long[101][101];
  
  long solve(int usedSong, int currL){
    
    if(currL == Goal)
      return usedSong == N ? 1 : 0;
      
    if(dp[usedSong][currL] != -1) 
      return dp[usedSong][currL];
      
    long usedSongPlay = (solve(usedSong, currL+1) * Math.max(0, usedSong-K)) % mod;
    
    long newSongPlay = (solve(usedSong+1, currL+1) * (N-usedSong)) % mod;
    
    long total = (usedSongPlay + newSongPlay) % mod;
    
    return dp[usedSong][currL] = total;
  }

  public int numMusicPlaylists(int n, int goal, int k) {
    
    this.N = n; 
    this.Goal = goal;
    this.K = k;
    
    for(long[] row: dp)
      Arrays.fill(row, -1);
      
    return (int) solve(0, 0);
  }

}