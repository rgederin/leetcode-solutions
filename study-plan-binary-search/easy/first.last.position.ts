/**
 * 34. Find First and Last Position of Element in Sorted Array
 * 
 * Runtime: 79 ms, faster than 66.07% of TypeScript online submissions for Find First and Last Position of Element in Sorted Array.
 * Memory Usage: 44.6 MB, less than 53.27% of TypeScript online submissions for Find First and Last Position of Element in Sorted Array.
 */
function searchRange(nums: number[], target: number): number[] {
    let bottom = 0;
    let top = nums.length - 1;
    let medium = -1;
    let first = -1;
    let last = -1;

    while (bottom <= top) {
        medium = Math.floor(bottom + (top - bottom) / 2);

        if (target < nums[medium]) {
            top = medium - 1;
        } else if (target > nums[medium]) {
            bottom = medium + 1;
        } else {
            break;
        }
    }

    if (medium == -1) {
        return [-1, -1];
    }

    for (let i = medium; i >= 0; i--) {
        if (nums[i] == target) {
            first = i;
        } else {
            break;
        }
    }

    for (let i = medium; i <= top; i++) {
        if (nums[i] == target) {
            last = i;
        } else {
            break;
        }
    }

    return [first, last];
};