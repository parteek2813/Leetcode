class Solution {
    public int majorityElement(int[] nums) {
    
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int c=0;
        int d =0;
        int max =0;
        int f=0;
        int n = nums.length;
        
        //Storing the Hashmap set 
        
        for(int i =0; i<n; i++){
            if(map.containsKey(nums[i])){
                c= map.get(nums[i]); //give count
                c++;
                map.replace(nums[i],c);
            }else{
                map.put(nums[i],1);
            }
        }
        
        
        
        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            d=e.getValue();
            f = e.getKey();
            if(d>(nums.length/2)){
                max=f;
                
            }
        }
        return max;
            
        }
    }
