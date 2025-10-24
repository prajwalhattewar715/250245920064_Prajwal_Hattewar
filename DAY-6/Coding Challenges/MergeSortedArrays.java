//You are given two sorted arrays nums1 and nums2. Your task is to merge them into a single array sorted in non-decreasing order.

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};

        int[] merged = mergeSortedArrays(nums1, nums2);

        System.out.println("Merged Array: " + Arrays.toString(merged));
    }

    public static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] merged = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        // Compare and merge
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Copy remaining elements (if any)
        while (i < n1) {
            merged[k++] = nums1[i++];
        }

        while (j < n2) {
            merged[k++] = nums2[j++];
        }

        return merged;
    }
}
