class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        backtracking(candidates,target,new ArrayList<Integer>(),0);
        return result;
    }

    private void backtracking(int[] candidates, int remTarget,List<Integer> currentCombination,int currIndex){
        if(remTarget==0){
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        else if(remTarget<0){
            return;
        }

        for(int i = currIndex ; i< candidates.length; i++){
            currentCombination.add(candidates[i]);
            backtracking(candidates,remTarget - candidates[i],currentCombination,i);
            currentCombination.remove(currentCombination.size()-1);
        }
    }
}