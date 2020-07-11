package sol1;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RandomNumber {

    public static void main(String... a) {

        for(int i=0;i<1000; i++) {
            int rand = (int)Math.random();
            int val = rand%3;
        }

        long time = System.currentTimeMillis();
        System.out.println(LongStream.range(1, 100000001)
//                .parallel()
                .map(e -> (int) (Math.random()*10))
                .map(e -> e%3+1)
                .mapToObj(Long::valueOf)
                .collect(Collectors.groupingBy(Function.identity() , Collectors.counting())));
        long time2 = System.currentTimeMillis();;
        System.out.println(time2-time);
    }
}
