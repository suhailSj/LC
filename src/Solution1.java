import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution1 {
    static class Activity{
        public int start;
        public int end;
        public int position;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Activity> list = new ArrayList<>();
            for(int j=0; j<n; j++) {
                Activity activity = new Activity();
                activity.start = in.nextInt();
                activity.end = in.nextInt();
                activity.position = j;
                list.add(activity);
            }
            Collections.sort(list, (o1, o2) -> {
                if(o1.start > o2.start) {
                    return 1;
                }
                if(o1.start < o2.start){
                    return  -1;
                } else{
                    return 0;
                }
            });
            int cTime = 0;
            int jTime = 0;
            char[] output = new char[n];
            boolean caseImposible = false;
            for(Activity session : list) {
                if(session.start >= cTime) {
                    output[session.position] = 'C';
                    cTime = session.end;
                } else if(session.start >= jTime) {
                    output[session.position] = 'J';
                    jTime = session.end;
                } else {
                    caseImposible = true;
                    break;
                }
            }
            if(caseImposible) {
                sb.append("Case #"+i+": IMPOSSIBLE \n");
            } else {
                sb.append("Case #"+i+": "+new String(output)+"\n");
            }

        }
        System.out.println(sb.toString());
    }






    public boolean process(int[] nums) {
        long largest = Long.MIN_VALUE;
        long sum=0;
        for(int i=0; i< nums.length; i++) {
            sum +=nums[i];
            if(largest < nums[i]) {
                largest = nums[i];
            }
        }
        return (sum - largest) == largest;
    }


    public boolean proces1(int[] nums) {
       int start = Math.max(nums[0], nums[2]);
       int end = Math.min(nums[1], nums[3]);
       return (end-start+1) == nums[4];

    }
}