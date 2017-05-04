package io.algo.dp;

/**
 * Created by animesh on 5/4/17.
 * To cal­cu­late the solu­tion for any ele­ment at index “i” has two options

 EITHER added to the solu­tion found till “i-1“th index
 OR start a new sum from the index “i”
 */
public class MaximumSubArrayDP {

    public int solve(int [] a){
        int [] solution = new int[a.length+1];
        solution[0] = 0;

        for (int j = 1; j <solution.length ; j++) {
            solution[j] = Math.max(solution[j-1]+a[j-1],a[j-1]);
        }

        //this will print the solution matrix
        //System.out.println(Arrays.toString(solution));
        //now return the maximum in the solution array

        int result = solution[0];
        for (int j = 1; j <solution.length ; j++) {
            if(result<solution[j])
                result = solution[j];
        }

        return result;
    }

    public static void main(String[] args) {
        int arrA[] = { 1, 2, -3, -4, 2, 7, -2, 3 };
        MaximumSubArrayDP i = new MaximumSubArrayDP();
        System.out.println("Maximum subarray is  " + i.solve(arrA));
    }

}
