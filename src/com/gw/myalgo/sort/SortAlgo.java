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


    public static void main(String[] args) {
        int[] sortedArr = new int[]{1,3,1,2,8,4,6,2};
        //bubbleSort(sortedArr);
        //selectSort(sortedArr);
        insertSort(sortedArr);

        StringBuilder sb = new StringBuilder();
        for(int value : sortedArr){
            sb.append(value + ",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
