class Solution {
    
    static String[] letters = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
        if(digits.isEmpty()) return new ArrayList();
        
        List<String> result = letterCombin(digits,"");
        
        return result;
    }
    
    public static List<String> letterCombin(String in, String out) {
    
        if(in.isEmpty()){
            List<String> ans = new ArrayList<>();
            ans.add(out);
            return ans;
        }

        char c = in.charAt(0);
        int n = c-'0'-1;
        
        String keys = letters[n];
        
        List<String> combinations = new ArrayList<>();

        for(int i=0; i<keys.length(); i++){
            char letter = keys.charAt(i);
            combinations.addAll(letterCombin(in.substring(1), out+letter));
        }

        return combinations;

    }
    
}