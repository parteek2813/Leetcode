class Solution {
    public int numberOfBeams(String[] bank) {
        
        int n = bank.length;
        int prevDeviceCount = 0;
        int result = 0;
        
        for(int i = 0; i<n; i++){
            
            int currentDeviceCount = 0;
            for(char ch: bank[i].toCharArray()){
                if(ch=='1'){
                    currentDeviceCount++;
                }
            }
            
            result += (prevDeviceCount * currentDeviceCount);
            
            if(currentDeviceCount != 0){
                prevDeviceCount = currentDeviceCount;
            }
        }
        return result;
    }
}