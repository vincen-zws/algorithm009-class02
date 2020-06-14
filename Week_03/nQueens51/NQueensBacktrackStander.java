package nQueens51;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class NQueensBacktrackStander {
        List<List<String>> result = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] borad = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                borad[i][j] = false;
            }
        }
        backtrack(0,n,borad);
        return result;
    }

    private void backtrack(int row, int n, boolean[][] borad) {
        if (row >= n) {
            result.add(addSolution(borad));

        }

        for (int col = 0; col < n; col++) {
            if (!isVaild(borad, row, col)) continue;
            borad[row][col] = true;
            backtrack(row+1,n,borad);
            borad[row][col] = false;
        }
    }

    private List<String> addSolution(boolean[][] borad) {
        List<String> solv = new ArrayList(borad.length);
        for (boolean[] bs : borad) {
        StringBuilder sb = new StringBuilder();
            for (boolean b : bs) {
                sb.append(b ? 'Q' : '.');
            }
            solv.add(sb.toString());
        }
        return solv;
    }

    private boolean isVaild(boolean[][] borad, int row, int col) {
        for (int i = 0; i < row; i++) {
            if(borad[i][col]) return  false;
        }
        for (int i = row - 1 , j = col -1; i >= 0 && j >= 0 ; --i ,--j) {
            if(borad[i][j]) return  false;
        }
        for (int i = row - 1 , j = col + 1; i >= 0 && j < borad[0].length ; --i ,++j) {
            if(borad[i][j]) return  false;
        }
        return true;
    }


    private boolean isVaild2(boolean[][] borad, int row, int col) {
        for (int i = 1; i <= row; i++) { //仅为控制次数 ，最多次数不超过row
            if(borad[row - i][col]) return false; //检测同列
            if(col - i >= 0 && borad[row - i][col - i] ) return false;  //检测左上
            if(col + i <= borad.length && borad[row - i][col + i] ) return  false; //检测右上
        }
        return true;
    }

    private boolean isVaild3(boolean[][] borad, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < borad.length; j++) {
                if(borad[i][j] && ( i - j == row - col || i + j == col + row || col == j )) return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensBacktrackStander nQueensBacktrackStander = new NQueensBacktrackStander();
        List<List<String>> a = nQueensBacktrackStander.solveNQueens(4);
        for (List<String > ls : a) {
            for(String s : ls) {
                System.out.println(s);
            }
        }
    }
}
