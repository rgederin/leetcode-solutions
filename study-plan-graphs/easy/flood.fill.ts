
/**
 * 733. Flood Fill
 * 
 * Runtime: 76 ms, faster than 94.08% of TypeScript online submissions for Flood Fill. 
 * Memory Usage: 45.3 MB, less than 47.74% of TypeScript online submissions for Flood Fill.
 */

function floodFill(image: number[][], sr: number, sc: number, newColor: number): number[][] {

    // init stack with root pixel
    const stack = [{ sr, sc }]
    const initialColor = image[sr][sc]

    while (stack.length > 0) {
        const current = stack.pop();

        if (current == undefined) {
            break;
        }

        // if pixel is already with a new color - skip
        if (image[current.sr][current.sc] == newColor) {
            continue;
        }

        //replace color if needed
        if (image[current.sr][current.sc] == initialColor) {
            image[current.sr][current.sc] = newColor;
        } else {
            continue;
        }

        // add left 
        if (current.sc - 1 >= 0) {
            stack.push({ sr: current.sr, sc: current.sc - 1 })
        }

        // add right 
        if (current.sc + 1 < image[current.sr].length) {
            stack.push({ sr: current.sr, sc: current.sc + 1 })
        }

        // add top
        if (current.sr - 1 >= 0) {
            stack.push({ sr: current.sr - 1, sc: current.sc })
        }

        // add bottom
        if (current.sr + 1 < image.length) {
            stack.push({ sr: current.sr + 1, sc: current.sc })
        }
    }

    return image
};

const test = [[1, 1, 1], [1, 1, 0], [1, 0, 1]];
const test2 = [[0, 0, 0], [0, 1, 1]];
const sc = 1;
const sr = 1;

console.log(floodFill(test2, 1, 1, 1)) 