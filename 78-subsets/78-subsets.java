class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> results = new ArrayList();
        List<Integer> out = new ArrayList<Integer>();  
        worker(nums, results, out, 0);
        
        return results;
    }
    
    public void worker(int[] in, List<List<Integer>> results, List<Integer> out, int ind){
        
        if(ind==in.length){
        
            ArrayList<Integer> temp = new ArrayList<>(out);
            results.add(temp);
            return;
        }
        
        out.add(in[ind++]);      
        worker(in, results, out, ind);
        
        out.remove(out.size()-1);
        worker(in, results, out, ind);
               
        return;
    }
    
    
}