package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.Helper;

import java.util.Arrays;

public class mysort {
    public static void main(String[] args){

        int n = 100000;
        //generating random array
        int []arr_random=gennerateArray(n, 1000);

        //generating sorted array
        int[] arr_sorted = new int[n];
        for(int i = 0; i < n; i++){
            arr_sorted[i] = arr_random[i];
        }
        Arrays.sort(arr_sorted);

        //generating part_sort array
        int[] arr_part = new int[n];
        for(int i = 0; i < n; i++){
            arr_part[i] = arr_random[i];
        }
        part_sort(arr_part, 30000, 70000);

        //generating reversed array
        int[] arr_reversed = new int[n];
        for(int i = 0; i < n; i++){
            arr_reversed[i] = arr_sorted[n-i-1];
        }

        //testing

        Long startTime1 = System.currentTimeMillis();
        part_sort(arr_random, 0, n);
        Long endTime1 = System.currentTimeMillis();
        Long elapsedTime1 = (endTime1 - startTime1);
        System.out.println("time for random array：" + elapsedTime1 + "ms");

        Long startTime2 = System.currentTimeMillis();
        part_sort(arr_sorted, 0, n);
        Long endTime2 = System.currentTimeMillis();
        Long elapsedTime2 = (endTime2 - startTime2);
        System.out.println("time for sorted array：" + elapsedTime2 + "ms");

        Long startTime3 = System.currentTimeMillis();
        part_sort(arr_part, 0, n);
        Long endTime3 = System.currentTimeMillis();
        Long elapsedTime3 = (endTime3 - startTime3);
        System.out.println("time for part sorted array：" + elapsedTime3 + "ms");

        Long startTime4 = System.currentTimeMillis();
        part_sort(arr_reversed, 0, n);
        Long endTime4 = System.currentTimeMillis();
        Long elapsedTime4 = (endTime4 - startTime4);
        System.out.println("time for part sorted array：" + elapsedTime4 + "ms");
    }

    public static int[]  gennerateArray(int len,int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    public static void part_sort(int[] a, int from, int to) {
        int t = 0;
        for (int i = from; i < to; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[j + 1]) {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                } else
                    break;
            }
        }
    }


}
