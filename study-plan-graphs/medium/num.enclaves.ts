/**
 * 1020. Number of Enclaves
 * Runtime: 252 ms, faster than 21.62% of TypeScript online submissions for Number of Enclaves.
 * Memory Usage: 69.7 MB, less than 8.11% of TypeScript online submissions for Number of Enclaves. 
 */

function numEnclaves(grid: number[][]): number {
    let count = 0;

    const visited = new Set();
    const islandNodes = new Set();

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            // check every land node
            if (grid[i][j] === 1) {
                islandNodes.clear();
                if (!isBorderConnected(grid, i, j, visited, islandNodes)) {
                    count += islandNodes.size;
                }
            }
        }
    }


    return count;
}

const isBorderConnected = (grid: number[][], r: number, c: number, visited: any, islandNodes: any) => {
    const rowValid = 0 <= r && r < grid.length;
    const colValid = 0 <= c && c < grid[0].length;

    // out of bounce for our map
    if (!rowValid || !colValid) return true;

    // water is not interesting for us
    if (grid[r][c] === 0) return false;

    const pos = r + ',' + c;
    if (visited.has(pos)) return false;

    visited.add(pos);

    islandNodes.add(pos);
    const top = isBorderConnected(grid, r - 1, c, visited, islandNodes);
    const bottom = isBorderConnected(grid, r + 1, c, visited, islandNodes);
    const left = isBorderConnected(grid, r, c - 1, visited, islandNodes);
    const right = isBorderConnected(grid, r, c + 1, visited, islandNodes);

    if (top || bottom || left || right === true) {
        return true;
    } else {
        return false;
    }
}

const g = [[0, 0, 0, 0], [1, 0, 1, 0], [0, 1, 1, 0], [0, 0, 0, 0]];

console.log(numEnclaves(g))