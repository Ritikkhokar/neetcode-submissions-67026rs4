class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = 1;
        int b = 1;
        int g = 1;
        double sum = 0;
        while(a<=nums1.length || b<=nums2.length){
          if(a<=nums1.length && b<=nums2.length){
            if(nums1[a-1]<=nums2[b-1]){
              
            if((nums1.length + nums2.length)%2 == 0){
               if(g == (nums1.length + nums2.length)/2 || 
               g == (((nums1.length + nums2.length)/2)+1)){
                sum += nums1[a-1];
               }   
            }else{
                if(g == (((nums1.length + nums2.length)/2)+1)){
                    sum += nums1[a-1];
                }
            }
            a++;
            }else{
                
                if((nums1.length + nums2.length)%2 == 0){
               if(g == (nums1.length + nums2.length)/2 || 
               g == (((nums1.length + nums2.length)/2)+1)){
                sum += nums2[b-1];
               }   
            }else{
                if(g == (((nums1.length + nums2.length)/2)+1)){
                    sum += nums2[b-1];
                }
            }
            b++;
            }
          }else if(a<=nums1.length){
          
           if((nums1.length + nums2.length)%2 == 0){
               if(g == (nums1.length + nums2.length)/2 || 
               g == (((nums1.length + nums2.length)/2)+1)){
                sum += nums1[a-1];
               }   
            }else{
                if(g == (((nums1.length + nums2.length)/2)+1)){
                    sum += nums1[a-1];
                }
            }
             a++;
          }else if(b<=nums2.length){
           
           if((nums1.length + nums2.length)%2 == 0){
               if(g == (nums1.length + nums2.length)/2 || 
               g == (((nums1.length + nums2.length)/2)+1)){
                sum += nums2[b-1];
               }   
            }else{
                if(g == (((nums1.length + nums2.length)/2)+1)){
                    sum += nums2[b-1];
                }
            }
            b++;
          }
          g++;
        }
        if((nums1.length + nums2.length)%2 == 0){
            return sum/2;
        }else{
            return sum;
        }
    }
}
