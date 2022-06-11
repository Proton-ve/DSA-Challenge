class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     
        List<List<Integer>> result = new ArrayList();
        List<Integer> out = new ArrayList();
        combinations(candidates, 0, target, out, result);
        
        return result;       
        
    }
    
    
    public void combinations(int[]num, int i, int target, List<Integer> out, List<List<Integer>> result){
        
        
        if(i==num.length){          
            if(target==0){
                result.add(new ArrayList(out));
            }
            return;
        }
        
        // if(target<0)return;
        
        
        if(num[i]<=target){
            out.add(num[i]);
            combinations(num, i, target-num[i], out, result);
            out.remove(out.size()-1);
        }
        
    
        combinations(num, i+1, target, out, result);

        
    }
    
    
    
}