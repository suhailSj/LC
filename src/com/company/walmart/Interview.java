package com.company.walmart;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * created by suhail.jahangir on 03/12/20
 */
//array [1,2,0,4,6,0,5] ----> [1,2,0,0,6,0,0]
    //[1,2,3,4,0,0]
    //[1,0,2,0,3,0,4,5,6,7] --- >[1,0,0,2,0,0,3,0,0,4]
public class Interview {
    public static void main(String[] args) {
        //int[] arr =

    }

    public void processArray(int[] arr){
        int zeroCounter = 0;
        for(int i =0; i< arr.length; i++){
            if(arr[i] == 0){
                zeroCounter++;
                continue;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< arr.length; i++){
            if(arr[i] == 0){
                zeroCounter++;
                continue;
            } else{
                if(zeroCounter > 0){
                    queue.add(arr[i]);
                    arr[i] = 0;
                } else {

                }

            }
        }

    }
}

//sorted array
//find majority element
// 1 3 3 3 3 3 3 3 3 3 3 3  3 3
class Second {
    public static void main(String[] args) {

    }

    public int process (int[] arr){
        if(arr == null || arr.length ==0){
            return -1;
        }
        int major = arr[0];
        int count =1;
        for(int i=1; i< arr.length; i++){
            if(major == arr[i]){
                count++;
                if(count >= arr.length/2){
                    return arr[i];
                }
            } else{
                major = arr[i];
                count =0;
            }
        }
        return -1;
    }

    public int processOptimized(int[] arr, int start, int end) {
        if(arr == null || arr.length ==0){
            return -1;
        }

        int majority = arr[start + (end-start)/2];
        int left = binarySearch(arr, majority, start, start + (end-start)/2);
        int right = binarySearch(arr, majority, start + (end-start)/2,end);
        if(left != -1 && right != -1){
            int diff = right -left;
            if(diff > arr.length/2){
                return start + (end-start)/2;
            } else{
                int temp =  processOptimized(arr, start, left ) ;
                int temp2 = processOptimized(arr, right, end);
                if( temp ==-1 && temp2 ==-1){
                    return -1;
                }
                if(temp != -1 && temp2 != -1){
                    return temp2- temp;
                } else{
                    if(temp < 0){
                        return  temp2 - left;
                    } else{
                        return right - temp;
                    }
                }
            }
        } else{
            return  -1;
        }

    }

    public int binarySearch(int[] arr, int element, int start, int end){

        int mid = 0;
        while(start <= end){
            mid = start+ (end -start)/2;
            if(arr[mid] == element){
                return  mid;
            } else if( arr[mid] > element){
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return -1;
    }

}
