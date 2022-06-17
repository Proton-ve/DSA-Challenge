class Solution {
    public boolean strongPasswordCheckerII(String password) {
        
        int n = password.length();
        boolean flag1=false,    //contains at least one lowercase letter.
        flag2=false,            //contains at least one uppercase letter.
        flag3=false,            //contains at least one special character
        flag4=false;            //contains at least one digit.
        
        if(n<8)return false;
        
        for(int i=0;i<n;i++){
            
            char c = password.charAt(i);
            
            if(c>=97 && c<=122)
                flag1=true;
            else if(c>=65 && c<=90)
                flag2 = true;
            else if(containsSpecialChar(c))
                flag3 = true;
            else  if(c>=48 && c<=57)
                flag4 = true;
            
            if(i<n-1){
                if(c==password.charAt(i+1))return false;
            }
                
            
        }
                
        return (flag1 && flag2 && flag3 && flag4);       // if passes all conditions
        
    }
    
    public boolean containsSpecialChar(char a){
        return (a=='!'||a=='@'||a=='#'||a=='$'||a=='%'||a=='^'||a=='&'||a=='*'||a=='('||a==')'||a=='-'||a=='+');
    }
    
}