class Solution {
    public int longestContinuousSubstring(String s) {
        
        int i=0, j=1, n = s.length(), count=1, ans=1;
        
        while(j<n){
            
            if((char)(s.charAt(j)-1) == (char)(s.charAt(j-1)+0)){
                while(j<n && (char)(s.charAt(j)-1) == (char)(s.charAt(j-1)+0)){
                    j++;
                    count++;
                }
            }else{
                
                ans = Math.max(ans,count);
                count=1;
                
                while(j<n && (char)(s.charAt(j)-1) != (char)(s.charAt(j-1)+0))
                    j++;
            }
            
        }
            
//             char c = s.charAt(j);

//             System.out.print(" "+j);
            
//             if((char)(c-1) == (char)(s.charAt(j-1)+0)){
//                 count++;
//             }else{
//                 ans = Math.max(ans,count);
//                 count=0;
//             }
//             j++;
        // }
        
        return Math.max(ans,count);
    }
}