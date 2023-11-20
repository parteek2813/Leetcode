class Solution {

    public static int count;
    public static int cAfull;
    public static int cBfull;

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {

        count = 0;
        cAfull = capacityA;
        cBfull = capacityB;

        helper(plants, capacityA, capacityB, 0, plants.length-1);

        return count;
        
    }

    public static void helper(int plants[], int cA, int cB, int i, int j){

// Base Condition

        if(i > j){
            return;
        }

// If both of them reach at a single plant position.

        if(i == j){
            if(cA >= cB && cA < plants[i] || cA < cB && cB < plants[j]){
                count++;
            }
            return;
        }

// Checking Alice capacity

        if(plants[i] > cA){
            count++;
            cA = cAfull;
        }

//Checking Bob capacity

        if(plants[j] > cB){
            count++;
            cB = cBfull;
        }

        cB -= plants[j];
        cA -= plants[i];

        helper(plants, cA, cB, i+1, j-1);
    }
}