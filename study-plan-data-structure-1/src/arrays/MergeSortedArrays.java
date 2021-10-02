package arrays;

/**
 * 88. Merge Sorted Array (easy)
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArrays {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
     * Memory Usage: 39.4 MB, less than 34.48% of Java online submissions for Merge Sorted Array.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int commonIndex = m + n - 1;
        int mIndex = m - 1;
        int nIndex = n - 1;

        for (int i = commonIndex; i >= 0; i--) {
            if (mIndex >= 0 && nIndex >= 0) {
                if (nums1[mIndex] > nums2[nIndex]) {
                    nums1[i] = nums1[mIndex--];
                } else {
                    nums1[i] = nums2[nIndex--];
                }

                continue;
            }

            if (mIndex >= 0) {
                nums1[i] = nums1[mIndex--];
            }

            if (nIndex >= 0) {
                nums1[i] = nums2[nIndex--];
            }
        }
    }
}

