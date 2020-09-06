package company.amazon;

import java.util.*;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        List<String> num = new ArrayList<>();
        List<Dummy> alpha = new ArrayList<>();

        for(String str : logLines) {
            String s = str.split(" ")[1];
            if(s.toCharArray()[0] < 65) {
                num.add(str);
            } else{
                String id = str.split(" ")[0];
                String other = str.substring(str.indexOf(" "), str.length());
                alpha.add(new Dummy(id, other));
            }
        }
        Collections.sort(alpha, new Comparator<Dummy>() {
            @Override
            public int compare(Dummy o1, Dummy o2) {
                if(o1.other.compareTo(o2.other) == 0) {
                    return o1.iden.compareTo(o2.iden);
                }
                return o1.other.compareTo(o2.other);
            }
        });
        List<String> result = new ArrayList<>();
        for(Dummy d : alpha) {
            result.add(d.iden+d.other);
        }
        result.addAll(num);
        return result;

    }
    public static class Dummy{
        public String iden;
        public String other;
        public Dummy(String id, String other) {
            this.iden = id;
            this.other = other;
        }
    }
    // METHOD SIGNATURE ENDS
}