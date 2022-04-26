/**
 * 35. Search Insert Position
 * 
 * Runtime: 89 ms, faster than 48.77% of TypeScript online submissions for Search Insert Position.
 * Memory Usage: 44.8 MB, less than 27.38% of TypeScript online submissions for Search Insert Position.
 */
function searchInsert(nums: number[], target: number): number {
    let res = -1;

    let bottom = 0;
    let top = nums.length - 1;
    let medium;

    while (bottom <= top) {
        medium = Math.floor((top + bottom) / 2);

        console.log(`bottom = ${bottom}, top = ${top}, mid = ${medium}`);
        if (nums[medium] < target) {
            // moving right
            bottom = medium + 1;
        } else if (nums[medium] > target) {
            // moving left
            top = medium - 1;
        } else {
            return nums[medium];
        }

        if (bottom > top) {
            return bottom;
        }
    }

    return res;
};

searchInsert([1, 3, 5, 6], 2)