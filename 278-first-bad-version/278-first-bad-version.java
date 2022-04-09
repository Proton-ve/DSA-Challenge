/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int s = 0;
        int ans = 0;
        
        while(s<=n){
            
            
            int mid = s+(n-s)/2;
            
            if(isBadVersion(mid)){
                ans = mid;
                n = mid-1;
            }else               
                s = mid+1;
            
        }
        
        return ans;
    }
}