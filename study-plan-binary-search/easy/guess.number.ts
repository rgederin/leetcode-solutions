/**
 * 374. Guess Number Higher or Lower
 * 
 * Runtime: 67 ms, faster than 80.38% of TypeScript online submissions for Guess Number Higher or Lower.
 * Memory Usage: 43.1 MB, less than 46.20% of TypeScript online submissions for Guess Number Higher or Lower.
 */

function guessNumber(n: number): number {
    let low = 1;
    let hi = n;
    let mid;

    while (low <= hi) {
        mid = Math.floor((low + hi) / 2);

        if (guess(mid) == 1) {
            low = mid + 1;
        } else if (guess(mid) == -1) {
            hi = mid - 1;
        } else {
            return mid
        }
    }

    return -1;
};
