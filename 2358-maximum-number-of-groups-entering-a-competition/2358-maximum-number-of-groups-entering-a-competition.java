class Solution {
    public int maximumGroups(int[] grades) {

        int n=grades.length;
        
        return (int)(Math.sqrt(2*n+0.25)-0.5);
        
        
        
//         int n=grades.length;
//         Arrays.sort(grades);
        
//         if(n==1)return n;
        
//         for(int i=n/2; i>0; i--){
//             long nSum = (i*(i+1))/2;
//             if(nSum>0 && nSum<=n)
//                 return i;
//         }
    
//         return 1;
    }
}