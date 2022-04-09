
/**
 * 200. Number of Islands
 * Runtime: 184 ms, faster than 26.51% of TypeScript online submissions for Number of Islands.
 * Memory Usage: 54.9 MB, less than 27.58% of TypeScript online submissions for Number of Islands.
 */
function numIslands(grid: string[][]): number {

    let count = 0;
    const visited = new Set();

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if (explore(grid, i, j, visited)) {
                count++
            }
        }
    }

    return count;
};

const explore = (grid: string[][], r: number, c: number, visited: any) => {
    const rowValid = 0 <= r && r < grid.length;
    const colValid = 0 <= c && c < grid[0].length;

    // out of bounce for our map
    if (!rowValid || !colValid) return false;

    // water is not interesting for us
    if (grid[r][c] === "0") return false;

    const pos = r + ',' + c;
    if (visited.has(pos)) return false;
    visited.add(pos);

    explore(grid, r - 1, c, visited);
    explore(grid, r + 1, c, visited);
    explore(grid, r, c - 1, visited);
    explore(grid, r, c + 1, visited);

    return true;
}

