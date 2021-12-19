package io.github.spafka.leetcode.sort;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

import static io.github.spafka.leetcode.sort.MergeSort.generateRandInt;

@Slf4j
public class QuickSort {

    /***
     * @see {https://blog.csdn.net/shujuelin/article/details/82423852}
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }

        int inedx = partiton(arr, low, high);
        //递归调用左半数组
        quickSort(arr, low, inedx - 1);
        //递归调用右半数组
        quickSort(arr, inedx + 1, high);
    }


    public static int partiton(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        //pivot
        int pivot = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (pivot <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (pivot >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                MergeSort.swap(arr, i, j);
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = pivot;
        return low;
    }


    public static void main(String[] args) {
        int[] arr = generateRandInt(10);

        int[] clone1 = ArrayUtils.clone(arr);


        quickSort(arr, 0, arr.length-1);
        Arrays.sort(clone1);
        log.info("quick equals :{}  {} ", Arrays.equals(arr, clone1), ArrayUtils.toString(arr));


    }


}
