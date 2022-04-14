class Solution {
    public static String[] findWords(String[] words) {
        
        
        ArrayList<String> ans = new ArrayList<>();
        
        String row1 = "qwertyuiopQWERTYUIOP", row2 = "asdfghjklASDFGHJKL", row3 = "zxcvbnmZXCVBNM";
        
        for(String e : words){
                        
            char temp =  (e.charAt(0)); 
            
            String currentRow = "";
            boolean flag = true;
                
            if(row1.indexOf(temp)!=-1) currentRow = row1;
            else if(row2.indexOf(temp)!=-1) currentRow = row2;
            else if(row3.indexOf(temp)!=-1) currentRow = row3;
            
            for(int i=1;i<e.length();i++){
                
                
                if(currentRow.indexOf(e.charAt(i))==-1) flag = false;
                    
                                
            }

            if(flag){
                ans.add(e);
                }    
        }

            String[] temp = new String[ans.size()];

            for (int i=0;i<ans.size();i++) {
                temp[i] = ans.get(i);
            }

        return temp;

        }
}