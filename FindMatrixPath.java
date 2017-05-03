package io.algo.dp;

/**
 * Created by animesh on 4/8/17.
 */
public class FindMatrixPath {

    public static int count(int [][] arrA, int row,int col){

        if(row == 1 || col == 1){
            return 1;
        }
        return count(arrA, row - 1, col) + count(arrA, row, col-1);
    }

    public static int countDP(int m,int n){
        int[][] result = new int[m][n];

        for(int i=0;i<m;i++){
            result[i][0] = 1;

        }
        for(int j=0;j<n;j++){
            result[0][j] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }

        return result[m-1][n-1];

    }



    public static void main(String[] args) {
        int [] [] arrA = {{1,2,3,4},{4,5,6,4}};
        System.out.println(FindMatrixPath.count(arrA,2,4));
        System.out.println(FindMatrixPath.countDP(2,4));

    }


}
