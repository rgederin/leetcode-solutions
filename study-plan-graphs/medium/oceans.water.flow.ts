/**
 *  417. Pacific Atlantic Water Flow
 *  Runtime: 1508 ms, faster than 5.56% of TypeScript online submissions for Pacific Atlantic Water Flow.
 *   Memory Usage: 51.9 MB, less than 71.30% of TypeScript online submissions for Pacific Atlantic Water Flow.
 */
function pacificAtlantic(heights: number[][]): number[][] {
    let lands: number[][] = [];
    const visited = new Set();
    for (let r = 0; r < heights.length; r++) {
        for (let c = 0; c < heights[0].length; c++) {
            visited.clear();
            if (isWaterCanReachAtlanticOcean(heights, r, c, visited)) {
                visited.clear();
                if (isWaterCanReachPacificOcean(heights, r, c, visited)) {
                    lands.push([r, c]);
                }
            }
        }
    }

    return lands;
};

const isWaterCanReachPacificOcean = (heights: number[][], r: number, c: number, visited: any): boolean => {
    const rowValid = 0 <= r && r < heights.length;
    const colValid = 0 <= c && c < heights[0].length;

    const pos = r + ',' + c;
    if (visited.has(pos)) return false;
    visited.add(pos);

    if (isPacificBorder(r, c))  return true;

    let top = false, bottom = false, left = false, right = false;

    if (r > 0 && isWaterCanPass(heights[r][c], heights[r - 1][c])) {
        top = isWaterCanReachPacificOcean(heights, r - 1, c, visited);
    }

    if (r < heights.length - 1 && isWaterCanPass(heights[r][c], heights[r + 1][c])) {
        bottom = isWaterCanReachPacificOcean(heights, r + 1, c, visited);
    }

    if (c > 0 && isWaterCanPass(heights[r][c], heights[r][c - 1])) {
        left = isWaterCanReachPacificOcean(heights, r, c - 1, visited);
    }

    if (c < heights[0].length && isWaterCanPass(heights[r][c], heights[r][c + 1])) {
        right = isWaterCanReachPacificOcean(heights, r, c + 1, visited);
    }

    if (top || bottom || left || right === true) {
        return true;
    } else {
        return false;
    }
}

const isWaterCanReachAtlanticOcean = (heights: number[][], r: number, c: number, visited: any): boolean => {
    const rowValid = 0 <= r && r < heights.length;
    const colValid = 0 <= c && c < heights[0].length;

    const pos = r + ',' + c;
    if (visited.has(pos)) return false;
    visited.add(pos);

    if (isAtlanticBorder(heights, r, c)) return true;

    let top = false, bottom = false, left = false, right = false;

    if (r > 0 && isWaterCanPass(heights[r][c], heights[r - 1][c])) {
        top = isWaterCanReachAtlanticOcean(heights, r - 1, c, visited);
    }

    if (r < heights.length - 1 && isWaterCanPass(heights[r][c], heights[r + 1][c])) {
        bottom = isWaterCanReachAtlanticOcean(heights, r + 1, c, visited);
    }

    if (c > 0 && isWaterCanPass(heights[r][c], heights[r][c - 1])) {
        left = isWaterCanReachAtlanticOcean(heights, r, c - 1, visited);
    }

    if (c < heights[0].length && isWaterCanPass(heights[r][c], heights[r][c + 1])) {
        right = isWaterCanReachAtlanticOcean(heights, r, c + 1, visited);
    }

    if (top || bottom || left || right === true) {
        return true;
    } else {
        return false;
    }
}

const isPacificBorder = (r: number, c: number): boolean => {
    if (r === 0 || c === 0) return true;
    return false;
}

const isAtlanticBorder = (heights: number[][], r: number, c: number): boolean => {
    if (r === heights.length - 1 || c === heights[0].length - 1) return true;
    return false;
}

const isWaterCanPass = (height1: number, height2: number): boolean => {
    return height2 <= height1;
}