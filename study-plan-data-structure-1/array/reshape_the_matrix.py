from typing import List


class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        if len(mat) * len(mat[0]) != r * c:
            return mat

        result_matrix = [[0] * r] * c
        rows, cols = 0, 0

        for i in range(len(mat)):
            for j in range(len(mat[0])):
                result_matrix[rows][cols] = mat[i][j]
                cols += 1

                if cols == c:
                    rows += 1
                    cols = 0

        return result_matrix




