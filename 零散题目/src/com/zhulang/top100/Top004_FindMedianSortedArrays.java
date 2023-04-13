package com.zhulang.top100;

/**
 * @Author zhulang
 * @Date 2023-04-09
 **/
public class Top004_FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] sumArr = new int[n];
        int l1 = 0;
        int l2 = 0;
        int i = 0;
        while (l1 < nums1.length && l2 < nums2.length){
            sumArr[i++] = nums1[l1] < nums2[l2] ? nums1[l1++] : nums2[l2++];
        }
        while (l1 < nums1.length){
            sumArr[i++] = nums1[l1++];
        }
        while (l2 < nums2.length){
            sumArr[i++] = nums2[l2++];
        }
        if (n % 2 == 1){
            return (double) sumArr[(n - 1) / 2];
        } else {
            return (double) (sumArr[(n - 1) / 2] + sumArr[(n - 1) / 2 + 1]) / 2;
        }
    }
}
