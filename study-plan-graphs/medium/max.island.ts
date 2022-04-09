/**
 * 695. Max Area of Island
 * Runtime: 114 ms, faster than 69.59% of TypeScript online submissions for Max Area of Island.
 * Memory Usage: 49.3 MB, less than 40.72% of TypeScript online submissions for Max Area of Island.
 */

function maxAreaOfIsland(grid: number[][]): number {
    let max = 0;
    let count = 0;
    const visited = new Set();

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            count = run(grid, i, j, visited);
            if (count > max) max = count;
        }
    }

    return max;
};

const run = (grid: number[][], r: number, c: number, visited: any): number => {
    const rowValid = 0 <= r && r < grid.length;
    const colValid = 0 <= c && c < grid[0].length;

    // out of bounce for our map
    if (!rowValid || !colValid) return 0;

    // water is not interesting for us
    if (grid[r][c] === 0) return 0;

    const pos = r + ',' + c;
    if (visited.has(pos)) return 0;
    visited.add(pos);


    return 1 + run(grid, r - 1, c, visited) +
        run(grid, r + 1, c, visited) +
        run(grid, r, c - 1, visited) +
        run(grid, r, c + 1, visited);
}

const grid = [
    [0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
    [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
    [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]
]

const res = maxAreaOfIsland(grid)ж