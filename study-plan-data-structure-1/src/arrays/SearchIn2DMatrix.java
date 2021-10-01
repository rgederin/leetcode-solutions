package arrays;

/**
 * Runtime: 1 ms, faster than 18.54% of Java online submissions for Search a 2D Matrix.
 * Memory Usage: 39.4 MB, less than 28.58% of Java online submissions for Search a 2D Matrix.
 */
public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i<matrix.length; i++){
            if (matrix[i][matrix[i].length - 1] < target){
                continue;
            }

            if (search(matrix[i], target) != -1){
                return true;
            }
        }

        return false;
    }

    private int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
