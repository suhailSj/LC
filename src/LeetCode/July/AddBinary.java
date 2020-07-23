package LeetCode.July;

public class AddBinary {
    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(sol.addBinary("11","111"));
    }

    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int alen = a.length();
            int blen = b.length();
            if(alen>blen){
                String s = b;
                b=a;
                a=s;
            }
            int i = a.length()-1;
            int j = b.length()-1;
            int[] tmpArr = new int[]{0,0};
            int tmp=0;
            while(i>=0 && j>=0){
                tmp = process(a.charAt(i)-'0',tmp);
                tmp= process(b.charAt(j)-'0',tmp);
                if(tmp > 1){
                    sb.append(tmp%10);
                    tmp = tmp/10;
                } else{
                    sb.append(tmp);
                    tmp =0;
                }

                i --;
                j --;
            }
            // if(tmpArr[0] != 0)
            // sb.append(tmpArr[0]);
            if(i==-1 && j==-1){
                if(tmp != 0)
                    sb.append(tmp);
                return sb.reverse().toString();
            }
            if(i==-1){
                while(j>=0){
                    tmp= process(b.charAt(j)-'0',tmp);
                    if(tmp > 1){
                        sb.append(tmp%10);
                        tmp = tmp/10;
                    } else{
                        sb.append(tmp);
                        tmp =0;
                    }
                    j--;
                }
                if(tmp != 0)
                    sb.append(tmp);
                return sb.reverse().toString();
            } else {
                while(i>=0){
                    tmp= process(a.charAt(i) -'0', tmp);
                    if(tmp > 1){
                        sb.append(tmp%10);
                        tmp = tmp/10;
                    } else{
                        sb.append(tmp);
                        tmp =0;
                    }
                    i--;
                }
                if(tmp!= 0)
                    sb.append(tmp);
                return sb.reverse().toString();
            }
        }

        public int process(int a, int b){
            if(a==1 && b==1){
                return 10;
            }
            if(b==10 && a==1){
                return 11;
            }
            if(a==1 || b==1){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
