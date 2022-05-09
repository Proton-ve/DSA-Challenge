class Solution {
    
    static String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()<1)return new ArrayList();
        
        return combinations(digits,"");
        
    }
    
    public static List<String> combinations(String in, String out){
        
        if(in.isEmpty()){
            
            ArrayList<String> ans = new ArrayList();
            ans.add(out);
            return ans;           
        }
        
        int c = in.charAt(0) - '0';        
        String letter = letters[c];
        ArrayList<String> letterCombs = new ArrayList();
        
        for(int i=0;i<letter.length();i++){
            
            letterCombs.addAll(combinations(in.substring(1),out+letter.charAt(i)));
        }
        
        
        return letterCombs;
    }
    
    
}