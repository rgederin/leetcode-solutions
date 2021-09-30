from typing import List


class Solution:
    # Runtime: 44 ms, faster than 89.20% of Python3 online submissions for Intersection of Two Arrays II.
    # Memory Usage: 14.2 MB, less than 97.40% of Python3 online submissions for Intersection of Two Arrays II.
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        check_dict = {}

        for num in nums1:
            if num in check_dict:
                check_dict[num] += 1
            else:
                check_dict[num] = 1

        for num in nums2:
            if num in check_dict and check_dict[num] != 0:
                res.append(num)
                check_dict[num] -= 1

        return res

