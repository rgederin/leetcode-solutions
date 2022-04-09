/**
 * Runtime: 64 ms, faster than 100.00% of TypeScript online submissions for Number of Closed Islands.
 * Memory Usage: 45.9 MB, less than 43.33% of TypeScript online submissions for Number of Closed Islands.
 */
function closedIsland(grid: number[][]): number {
    let count = 0;
    let closed;
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if (grid[i][j] === 0) {
                closed = isClosed(grid, i, j);
                if (closed) count++;
            }
        }
    }

    return count;
};



const isClosed = (grid: number[][], r: number, c: number): Boolean => {
    const rowValid = 0 <= r && r < grid.length;
    const colValid = 0 <= c && c < grid[0].length;

    // out of bounce for our map
    if (!rowValid || !colValid) return false;

    // Stop traversing this path and return true if we see 1
    if (grid[r][c] === 1) return true;

    // Change the value to 1, so we don't come here again
    grid[r][c] = 1

    const top = isClosed(grid, r - 1, c);
    const bottom = isClosed(grid, r + 1, c);
    const left = isClosed(grid, r, c - 1);
    const right = isClosed(grid, r, c + 1);

    console.log("processed indexes: row: " + r + ", col:" + c + "---" + "top: " + top)
    console.log("processed indexes: row: " + r + ", col:" + c + "---" + "bottom: " + bottom)
    console.log("processed indexes: row: " + r + ", col:" + c + "---" + "left: " + left)
    console.log("processed indexes: row: " + r + ", col:" + c + "---" + "right: " + right)
    console.log("")
    return bottom && top && left && right;
}

const test = [[1, 0], [1, 0]];
console.log(closedIsland(test))