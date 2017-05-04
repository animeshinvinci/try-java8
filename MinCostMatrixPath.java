package io.algo.dp;

/**
 * Created by animesh on 4/8/17.
 */
public class MinCostMatrixPath {

    public static int count(int [][] arr,int row,int col){
        if (row == 0 || col == 0){
            return arr[row][col];
        }
        else {
            return arr[row][col] + min(count(arr, row - 1, col), count(arr, row, col - 1));
        }
    }

    public static int countItr(int [][] arr,int row,int col){
        int sum = arr[row][col];
        for(int i=row;i>0;i--){
            for(int j=col;j>0;j--){
                sum +=   min(arr[i-1][j],arr[i][j-1]);
            }
        }

        return sum;

    }


    public static  int min(int x,int y){
        if (x > y){
            return y;
        }
        else {
            return x;
        }
    }

    public static int[][] countDP(int[][] A) {
        int[][] solution = new int[A.length][A.length];

        solution[0][0] = A[0][0];

        // fill the first row
        for (int i = 1; i < A.length; i++) {
            solution[0][i] = A[0][i] + solution[0][i - 1];
        }

        // fill the first column
        for (int i = 1; i < A.length; i++) {
            solution[i][0] = A[i][0] + solution[i - 1][0];
        }

        // path will be either from top or left, choose which ever is minimum
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A.length; j++) {
                solution[i][j] = A[i][j]
                        + Math.min(solution[i - 1][j], solution[i][j - 1]);
            }
        }
        return solution;

    }

    public static void main(String[] args) {
        int [] [] arrA = {{1,0,0,},{1,1,1},{0,0,1}};
        //System.out.println(MinCostMatrixPath.count(arrA,2,2));
        int [][] sol = MinCostMatrixPath.countDP(arrA);
        System.out.println(sol[2][2]);


        System.out.println(sol[0][0]);

        for (int i = 0; i < sol.length - 1; i++) {
            for(int j= 0;j < sol.length - 1;j++) {
                        if(sol[i + 1][j] > sol[i][j + 1]){
                            System.out.println(sol[i][j + 1]);
                            j++;
                        }
                    else{
                            System.out.println(sol[i+1][j]);
                            i++;

                        }

            }

        }

    }
}
