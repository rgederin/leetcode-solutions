/**
 * 1905. Count Sub Islands
 * Runtime: 690 ms, faster than 16.67% of TypeScript online submissions for Count Sub Islands.
 * Memory Usage: 99.2 MB, less than 27.78% of TypeScript online submissions for Count Sub Island
 */

function countSubIslands(grid1: number[][], grid2: number[][]): number {
    let count = 0;
    const visited = new Set();

    for (let r = 0; r < grid2.length; r++) {
        for (let c = 0; c < grid2[r].length; c++) {
            if (grid2[r][c] === 1 && !visited.has(r + ',' + c)) {
                if (findSubIslands(grid1, grid2, r, c, visited)) {
                    count++;
                }
            }
        }
    }

    return count;
};

const findSubIslands = (grid1: number[][], grid2: number[][], r: number, c: number, visited: any): boolean => {
    const rowValid = 0 <= r && r < grid2.length;
    const colValid = 0 <= c && c < grid2[0].length;

    // out of bounce for our map
    if (!rowValid || !colValid) return true;

    // water is not interesting for us
    if (grid2[r][c] === 0) return true;

    const pos = r + ',' + c;
    if (visited.has(pos)) return true;
    visited.add(pos);

    let result = true;

    if (grid1[r][c] === 0) result = false;

    result = findSubIslands(grid1, grid2, r - 1, c, visited) && result;
    result = findSubIslands(grid1, grid2, r + 1, c, visited) && result;
    result = findSubIslands(grid1, grid2, r, c - 1, visited) && result;
    result = findSubIslands(grid1, grid2, r, c + 1, visited) && result;

    return result;
}

