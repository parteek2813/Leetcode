class Solution {
    
    // define the final result arraylist which is a list of integers
    List<List<Integer>> result;
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(candidates, target, new ArrayList<>(), 0);
       
        //returning the result array
        return result;
        
        
    
    }
    
    public void combinations(int[] arr, int target, List<Integer> list, int i ){
        
        // applying recursion to this code
        // Base case 1
        
        if(target == 0){
            
            // just add this arraylist in the arraylist we taken list
            result.add(new ArrayList<>(list));
            return;
            
        }
        
        // Base case 2
        
        // if i>array lenght or if any array element > target number --> then no point of searching this element
        if(i >= arr.length || arr[i] > target) {
            return;
        }
        
        
        list.add(arr[i]);
        
        combinations(arr, target-arr[i], list, i);
        
        // decrement list size
        list.remove(list.size()-1);
        
        combinations(arr, target, list, i + 1);

    }
}