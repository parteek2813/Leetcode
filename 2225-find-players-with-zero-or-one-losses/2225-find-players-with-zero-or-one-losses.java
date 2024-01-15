class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
       //To find the number of matches lost by the player
       Map<Integer, Integer> loss = new HashMap<>();
       for(int i = 0; i < matches.length; i++) {
           int winner = matches[i][0];
           int loser = matches[i][1];

           loss.put(loser, loss.getOrDefault(loser, 0) + 1);

           //To find players who have not lost a single match
           loss.putIfAbsent(winner, 0);
       } 

       //To store the result
       List<List<Integer>> winners = new ArrayList<>();
       List<Integer> noLoss = new ArrayList<>();
       List<Integer> oneLoss = new ArrayList<>();

       for(Integer player : loss.keySet()) {

           //Players who won all the match
           if(loss.get(player) == 0) {
               noLoss.add(player);
           }

           //Players who lost one match
           else if(loss.get(player) == 1) {
               oneLoss.add(player);
           }
       }
       //Sorting & adding the lists to the result
       Collections.sort(noLoss);
       Collections.sort(oneLoss);
       winners.add(noLoss);
       winners.add(oneLoss);
       return winners;
    }
}