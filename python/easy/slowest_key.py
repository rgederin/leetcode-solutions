from typing import List


class Solution:
    def slowestKey(self, releaseTimes: List[int], keysPressed: str) -> str:

        slowest_time = releaseTimes[0]
        slowest_key = keysPressed[0]

        for i in range(len(releaseTimes)):
            current_time = releaseTimes[i] - releaseTimes[i - 1]
            if current_time > slowest_time:
                slowest_time = current_time
                slowest_key = keysPressed[i]

            if current_time == slowest_time:
                if keysPressed[i] > slowest_key:
                    slowest_key = keysPressed[i]

        return slowest_key


solution = Solution()
solution.slowestKey([9, 29, 49, 50], "cbcd")
