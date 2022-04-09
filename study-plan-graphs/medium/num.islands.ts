
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
            if (iteratively(grid, i, j, visited)) {
                count++
            }
        }
    }

    return count;
};

const iteratively = (grid: string[][], r: number, c: number, visited: any) => {
    const pos = r + ',' + c;
    if (visited.has(pos)) return false;

    visited.add(pos)

    // water is not interesting for us
    if (grid[r][c] === "0") return false;

    const stack = [pos];

    while (stack.length != 0) {
        const current = stack.pop();

        if (current == undefined) {
            break;
        }

        const row = Number(current.split(",")[0]);
        const col = Number(current.split(",")[1]);
        visited.add(row + "," + col);
        addConnectedNodes(grid, row, col, visited, stack)
    }

    return true;
}

const addConnectedNodes = (grid: string[][], r: number, c: number, visited: any, stack: string[]) => {
    const leftPos = r + "," + (c - 1);
    const rigthPos = r + "," + (c + 1);
    const bottomPos = (r - 1) + "," + c;
    const topPos = (r + 1) + "," + c;

    if (c - 1 >= 0 && grid[r][c - 1] === "1" && !visited.has(leftPos))
        stack.push(leftPos)

    if (c + 1 < grid[0].length && grid[r][c + 1] === "1" && !visited.has(rigthPos))
        stack.push(rigthPos)

    if (r - 1 >= 0 && grid[r - 1][c] === "1" && !visited.has(bottomPos))
        stack.push(bottomPos)

    if (r + 1 < grid.length && grid[r + 1][c] === "1" && !visited.has(topPos))
        stack.push(topPos)
}

const recursively = (grid: string[][], r: number, c: number, visited: any) => {
    const rowValid = 0 <= r && r < grid.length;
    const colValid = 0 <= c && c < grid[0].length;

    // out of bounce for our map
    if (!rowValid || !colValid) return false;

    // water is not interesting for us
    if (grid[r][c] === "0") return false;

    const pos = r + ',' + c;
    if (visited.has(pos)) return false;
    visited.add(pos);

    recursively(grid, r - 1, c, visited);
    recursively(grid, r + 1, c, visited);
    recursively(grid, r, c - 1, visited);
    recursively(grid, r, c + 1, visited);

    return true;
}

