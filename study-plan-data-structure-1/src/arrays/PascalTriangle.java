package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 1 ms, faster than 32.41% of Java online submissions for Pascal's Triangle.
 * Memory Usage: 38.8 MB, less than 7.30% of Java online submissions for Pascal's Triangle.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> currentRaw = new ArrayList<>();

        currentRaw.add(1);
        triangle.add(currentRaw);

        for (int i = 0; i < numRows - 1; i++) {
            currentRaw = generateRow(currentRaw);
            triangle.add(currentRaw);
        }

        return triangle;
    }

    private  List<Integer> generateRow(List<Integer> previousRow) {
        List<Integer> newRow = new ArrayList<>();
        newRow.add(0, previousRow.get(0));

        for (int i = 1; i < previousRow.size(); i++) {
            newRow.add(previousRow.get(i - 1) + previousRow.get(i));
        }

        newRow.add(previousRow.get(previousRow.size() - 1));
        return newRow;
    }
}
