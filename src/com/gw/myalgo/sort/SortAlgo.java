package com.gw.myalgo.sort;


import org.apache.commons.lang3.StringUtils;

/**
 * @author hsden
 */
public class SortAlgo {

    /**
     * Bubble sort
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if(null == arr || 0 == arr.length){
            return ;
        }

        int i, j, tmp;
        for(i = 0; i < arr.length - 1; i++){
            for(j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

    }

    /**
     * Select sort
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if(null == arr || 1 >= arr.length){
            return;
        }


        for(int i = 0; i < arr.length -1; i++){
            int smallestIdx = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[smallestIdx] > arr[j]) {
                   smallestIdx  = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[smallestIdx];
            arr[smallestIdx] = tmp;
        }
    }

    /**
     * 2-way select sort
     * @param arr
     */
    public static void selectSortUpdate(int[] arr) {
        if(null == arr || 1 >= arr.length){
            return;
        }

        for(int i = 0; i <= arr.length/2 ; i++){
            int minIdx = i, maxIdx = i;
            for(int j = i + 1; j < arr.length - i; j++) {
                if(arr[minIdx] >= arr[j]) {
                    minIdx  = j;
                }

                if(arr[maxIdx] <= arr[j]) {
                    maxIdx = j;
                }
            }

            if(minIdx != i) {
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
                if(maxIdx == i){
                    maxIdx = minIdx;
                }
            }

            int n = arr.length -i -1;
            if(maxIdx != n) {
                int tmp = arr[n];
                arr[n] = arr[maxIdx];
                arr[maxIdx] = tmp;
            }

            printArr(arr);
        }
    }


    /**
     * Insert sort
     * @param arr
     */
    public static void insertSort(int[] arr){
        if(null == arr || 1 >= arr.length){
            return;
        }

        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] > arr[i]) {
                int j, tmp=arr[i];
                for (j = i - 1; j >= 0; j--) {
                    if (arr[j] < tmp) {
                        break;
                    } else {
                        arr[j + 1] = arr[j];
                    }
                }

                arr[j + 1] = tmp;
            }
        }

    }


    /**
     * Shell sort
     * @param arr
     */
    public static void shellSortMain(int[] arr){

        if(null == arr || 1 >= arr.length){
            return;
        }

        int segment = arr.length/2;
        while(segment >= 1){
            shellInsertSort(arr,segment);
            segment = segment/2;
        }
    }

    public static void shellInsertSort(int[] arr, int dk){
            if(null == arr || 1 >= arr.length || 0 >= dk){
                return;
            }

            for(int i=dk;  i < arr.length; ++i) {
                if(arr[i] < arr[i -dk]) {
                    int j = i -dk, x=arr[i];
                    arr[i]=arr[j];
                    while(j >= 0 && x < arr[j]){
                        arr[j+dk] = arr[j];
                        j -= dk;
                    }
                    arr[j+dk] = x;
                }
            }
    }

    public static void printArr(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int value : arr){
            sb.append(value + ",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    public static void main(String[] args) {
        //5,7,9,10,2,32,4,4,3
        int[] sortedArr = new int[]{5,7,9,10,2,32,4,4,3};
        printArr(sortedArr);
        //bubbleSort(sortedArr);
        //selectSort(sortedArr);
        selectSortUpdate(sortedArr);
        //insertSort(sortedArr);
        //shellSortMain(sortedArr);

        printArr(sortedArr);
    }
}
