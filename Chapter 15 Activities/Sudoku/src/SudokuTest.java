import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuTest {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuTest(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        // create the list of sets for each row (this.rows)
        // each row will be its own set
        // AN ARRAY LIST LIST OF NINE SETS OF INTEGERS
        for (int j = 0; j < grid.length; j++)
        {
            Set<Integer> numset = new HashSet<Integer>();
            this.rows = new ArrayList<Set<Integer>>();

            for (int i = 0; i < 9; i++)
            {
                numset.add(grid[j][i]);
            }

            this.rows.add(numset);
        }
        System.out.println("Rows: " + this.rows);

        // create the list of sets for each col (this.cols)
        // ...
        for (int j = 0; j < grid.length; j++)
        {
            Set<Integer> numset = new HashSet<Integer>();
            this.cols = new ArrayList<Set<Integer>>();

            for (int i = 0; i < 9; i++)
            {
                numset.add(grid[i][j]);
            }

            this.cols.add(numset);
        }
        System.out.println("Columns: " + this.cols);

        
        // create the list of sets for each square (this.squares)
        // go through each row and column to make a set of all the squares
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        for (int a = 0; a < 9; a+=3) // does this 9 times
        {
            int rows, cols;
            for (int b = 0; b < 9; b+=3)
            {
                Set<Integer> numset = new HashSet<Integer>();
                this.squares = new ArrayList<Set<Integer>>();
                for (rows = a; rows < a+3; rows++)
                {
                    for (cols = a; cols < a+3; cols++)
                    {
                        numset.add(grid[rows][cols]);
                    }
                }
                this.squares.add(numset);
                System.out.println("Square: " + numset);
            }
        }
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities\\Sudoku\\src\\puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}
}