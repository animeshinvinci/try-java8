import java.util.Arrays;
import java.util.stream.DoubleStream;

/**
 * Created by animesh on 4/8/17.
 */
public class SumList {

    public static void main(String[] args) {
        double[] numbers = {1, 24, 45, 62, 85, 8, 91, 3, 5, 56, 9};
        double tt = DoubleStream.of(numbers).sum();

        double total2 = Arrays.stream(numbers).sum();

        System.out.println(tt);
        System.out.print(total2);

        System.out.print(Arrays.stream(numbers).max());

    }
}
