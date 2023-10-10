import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<Pair> pairs = new Stack<>();

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        int count = 1;
        Pair first = new Pair(row, column);
        pairs.push(first);

        while(pairs.size() > 0) {
            Pair p = pairs.pop();
            if (pixels[p.getRow()][p.getColumn()] == 0){
                pixels[p.getRow()][p.getColumn()] = count;
                count++;
            }
        

        if(p.getRow() - 1 > -1 && pixels[p.getRow() - 1][p.getCol()] == 0)
        {
            pairs.push(new pair(p.getRow() - 1, p.getCol())); // up

        }

        if (p.getRow() + 1 < 10 && pixels[p.getRow() + 1][p.getCol()] == 0)
        {
            pairs.push(new pair(p.getRow() + 1, p.getCol())); // down
        }

        if (p.getCol() - 1 > -1 && pixels[p.getRow()][p.getCol() - 1] == 0)
        {
            pairs.push(new pair(p.getRow(), p.getCol() - 1)); // left
        }

        if (p.getCol() + 1 < 10 && pixels[p.getRow()][p.getCol() + 1] == 0)
        {
            pairs.push(new pair(p.getRow(), p.getCol() + 1)); // right
        }
    }
}

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
