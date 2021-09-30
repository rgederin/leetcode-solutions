from typing import List


class Solution:

    # Runtime: 32 ms, faster than 91.79% of Python3 online submissions for Merge Sorted Array.
    # Memory Usage: 14.3 MB, less than 30.23% of Python3 online submissions for Merge Sorted Array.
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        common_index = m + n - 1
        m_index = m - 1
        n_index = n - 1

        for i in range(common_index, -1, -1):
            if m_index >= 0 and n_index >= 0:
                if nums1[m_index] > nums2[n_index]:
                    nums1[i] = nums1[m_index]
                    m_index = m_index - 1
                else:
                    nums1[i] = nums2[n_index]
                    n_index = n_index - 1

                continue

            if m_index >= 0:
                nums1[i] = nums1[m_index]
                m_index = m_index - 1

            if n_index >= 0:
                nums1[i] = nums2[n_index]
                n_index = n_index - 1
