/**
 * Runtime: 70 ms, faster than 75.66% of TypeScript online submissions for First Bad Version.
 * Memory Usage: 43.3 MB, less than 23.27% of TypeScript online submissions for First Bad Version.
 * 
 * The knows API is defined in the parent class Relation.
 * isBadVersion(version: number): boolean {
 *     ...
 * };
 */

var solution = function (isBadVersion: any) {

    return function (n: number): number {
        let first = 1;

        if (n == 1) {
            return 1;
        }

        while (first <= n) {
            let median = Math.floor(first + (n - first) / 2);
            if (isBadVersion(median)) {
                if (!isBadVersion(median - 1))
                    return median;
                n = median;
            }
            else
                first = median + 1;
        }
        return n;

    }
};