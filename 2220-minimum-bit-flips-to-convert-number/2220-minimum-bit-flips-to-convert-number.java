class Solution {
    public int minBitFlips(int start, int goal) {
     
        int count = 0;
        
        while(goal>0 || start>0){
        
            int lbit1 = start&1;
            int lbit2 = goal&1;
            
            if(lbit1==lbit2){
                
                start>>=1;
                goal>>=1;

            }else{

                start = start^1;
                start>>=1;
                goal>>=1;    
                count++;

            }
        }
               
        return count;
    }
}