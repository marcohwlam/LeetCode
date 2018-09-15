import java.util.ArrayList;
import java.util.List;

class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<List<Cup>> triangle = new ArrayList<>();
        // First base case; if user requests zero rows, they get zero rows.
        if (query_row == 0) {
            return new Cup((double)poured).contain;
        }
        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(new Cup((double)poured));
        for (int rowNum = 1; rowNum <= query_row; rowNum++) {
            List<Cup> row = new ArrayList<>();
            List<Cup> prevRow = triangle.get(rowNum-1);

            // The first row element is always excess of prevRow first cup
            row.add(new Cup(prevRow.get(0).excess));

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(new Cup(prevRow.get(j-1).excess + prevRow.get(j).excess));
            }

            // The last row element is always excess of prevRow last cup
            row.add(new Cup(prevRow.get(prevRow.size()-1).contain));

            triangle.add(row);
        }

        return triangle.get(query_row ).get(query_glass).contain;
    }
    public class Cup{
        public double excess;
        public double contain;
        public Cup(double poured){
            excess = ((poured - 1) > 0) ? (poured - 1)/2 : 0 ;
            contain = Math.min(poured, 1);
        }
    }
};
