class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, lo = 0, hi = n1 - 1, min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        while(true){
            int mid = (int)Math.floor((lo + hi) / 2.0), mid2 = (n1 + n2 + 1) / 2 - mid - 2;
            int x1 = (mid >= 0 && mid < n1 ? nums1[mid] : (mid >= n1 ? max : min));
            int y1 = (mid < n1 - 1 && mid > -2 ? nums1[mid + 1] : (mid < -1 ? min : max));
            int x2 = (mid2 >= 0 && mid2 < n2 ? nums2[mid2] : (mid2 >= n2 ? max : min));
            int y2 = (mid2 < n2 - 1 && mid2 > -2 ? nums2[mid2 + 1] : (mid2 < -1 ? min : max));
            if(x1 <= y2 && x2 <= y1){
                if(((n1 + n2) & 1) == 1)
                    return Math.max(x1, x2);
                else
                    return (Math.max(x1, x2) + Math.min(y1, y2)) / 2.0;
            } else if(x1 > y2){
                hi = mid - 1;
            } else if(x2 > y1){
                lo = mid + 1;
            }
        }
    }
}
