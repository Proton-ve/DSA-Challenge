class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length>nums2.length)return findMedianSortedArrays(nums2,nums1);
        
        // System.out.println(nums1[0]);
        
        int n1 = nums1.length, n2 = nums2.length;
        int subLen = (n1+n2+1)/2;
        int s = 0, e = n1;
        int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        
        while(s<=e){
            
            int cut1 = s+(e-s)/2;
            int cut2 = subLen - cut1;
            
            
//             @TODO - handle edge case (cut1=0orn1)
            l1 = cut1>0 ? nums1[cut1-1] : Integer.MIN_VALUE;
            l2 = cut2>0 ? nums2[cut2-1] : Integer.MIN_VALUE;
            r1 = cut1<n1 ? nums1[cut1] : Integer.MAX_VALUE;
            r2 = cut2<n2 ? nums2[cut2] : Integer.MAX_VALUE;
            
            // System.out.println("l1 = "+l1 +"  l2  = "+l2+" r1 = "+r1+" r2 = "+r2); 

            
            if(l1>r2)
                e = cut1-1;
            else if(l2>r1)
                s = cut1+1;
            else
                break;
            
        }
        

        
        double median = 0;
        
        
        
        if((n1+n2)%2==0){
            median = (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            // System.out.println("med is "+median+" se l1 "+Math.max(l1,l2)+" l2 "+Math.min(r1,r2));
        }
        else
            median = Math.max(l1,l2);
        
        
        return median;
    }
    
//     public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        
//         System.out.println(nums1[0]);
        
//         int n1 = nums1.length, n2 = nums2.length;
//         int subLen = (n1+n2+1)/2;
//         int s = 0, e = n1-1;
//         int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        
//         while(s<e){
            
//             int cut1 = s+(e-s)/2;
//             int cut2 = subLen - cut1;
            
//            System.out.println("cut2 = "+cut2); 
            
// //             @TODO - handle edge case (cut1=0orn1)
//             l1 = cut1>0 ? nums1[cut1-1] : Integer.MIN_VALUE;
//             l2 = cut2>0 ? nums2[cut2-1] : Integer.MIN_VALUE;
//             r1 = cut1<n1 ? nums1[cut1] : Integer.MAX_VALUE;
//             r2 = cut2<n2 ? nums2[cut2] : Integer.MAX_VALUE;
            
//             if(l1>r2)
//                 e = cut1-1;
//             else if(l2>r1)
//                 s = cut1+1;
//             else
//                 break;
            
//         }
        
//         double median = 0;
        
//         if((n1+n2)%2==0)
//             median = (Math.max(l1,l2)+Math.min(r1,r2))/2;
//         else
//             median = Math.max(l1,l2)/2;
        
        
//         return median;
        
//     }
    
}