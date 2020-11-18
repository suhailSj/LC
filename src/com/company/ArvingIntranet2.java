package com.company;

public class ArvingIntranet2 {

    public static void main(String... a){

        ArvingIntranet2 arb = new ArvingIntranet2();
        System.out.println(arb.getMaxSum(new int[] {100,200,30,-20,5,2,75,300}));
        System.out.println(arb.getMaxSum(new int[] {1,-2,-1,4,31,3}));

    }       //200   200  205
//100 200   30   -20   5    2   75 300
//505
//-1  4, 31, 3
//Answer: 31
    public int getMaxSum(int[] arr) {
        if(arr.length == 0){
            return  0;
        }
        if(arr.length == 1){
            return arr[0];
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1], dp[0]);
        for(int i=2; i<arr.length; i++) {
            dp[i] = Math.max(Math.max(dp[i-2]+arr[i], arr[i]), dp[i-1]);
        }
        return dp[arr.length-1];
    }


    public <T> void printObject(T object) {
        System.out.println(object.getClass());
        System.out.println(object.toString());
    }

//    static class Student
//    {
//        public String name;
//
//        public String getName(){
//            return this.name;
//        }
//    }
//
//
//    public Map<String, Student> foo(List<Student> list)
//    {
//        //return distinct student n
//
//        return list.stream()
//                .collect(Collectors.toMap(student ->student.name, Function.identity()));
//    }
//
//    Class Abc {
//
//        void method1() {
//            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//                method2()
//            }, excutor);
//            CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> method3());
//
//           return future.thenCombine((future2, (res, res2)) ->  return response);
//        }
//
//
//
//    }

}
