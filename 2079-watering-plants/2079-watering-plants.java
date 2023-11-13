class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        
        int n = plants.length;
        int capL = capacity;
        
        int ans = 0;
        
        for(int i =0; i<n; i++){
            
            if(plants[i] <= capL){
                capL = capL - plants[i];
                ans++;
                
                
            }else if(plants[i] > capL){
                
                capL = capacity;
                ans = ans + i + (i+1);
                capL = capL - plants[i];
                
            }
        }
        
        return ans;
    }
}