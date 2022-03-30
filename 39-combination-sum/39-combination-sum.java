class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     
        List<List<Integer>> result = new ArrayList();
        List<Integer> out = new ArrayList();
        combinations(candidates, 0, target, out, result);
        
        return result;       
        
    }
    
    
    public void combinations(int[]num, int i, int target, List<Integer> out, List<List<Integer>> result){
        
        
        if(i==num.length)return;            
                  
        if(target==0){
            List<Integer> temp = new ArrayList(out);
            result.add(temp);
            return;
        }
        
        if(target<0)return;
        
        combinations(num, i+1, target, out, result);
        
        if(target>0){
            out.add(num[i]);
            combinations(num, i, target-num[i], out, result);
            out.remove(out.size()-1);
        }
        
    }
    
    
    
}