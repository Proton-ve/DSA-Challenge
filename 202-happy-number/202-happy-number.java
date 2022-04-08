class Solution {
    public boolean isHappy(int n) {
     
        int fast =  sumOfDigitSquares(sumOfDigitSquares(n));
        int slow = sumOfDigitSquares(n);
        
        while(slow!=fast){
        
            slow = sumOfDigitSquares(slow);
            fast = sumOfDigitSquares(sumOfDigitSquares(fast));
            
        }
        
        if(slow==1)return true;
        
        return false;
    }
    
    public int sumOfDigitSquares(int n){
        
        int sum = 0;
        
        while(n>0){
            
            int temp = n%10;
            n/=10;
            
            sum+= temp*temp;
        
        }
        
      return sum;  
    }
    
}