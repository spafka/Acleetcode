package io.github.spafka.leetcode.sort;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

@Slf4j
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = generateRandInt(10);

        int[] clone1 = ArrayUtils.clone(arr);

        int[] clone2 = ArrayUtils.clone(arr);

        int[] clone3 = ArrayUtils.clone(arr);

        int[] clone = ArrayUtils.clone(arr);

        maoPaoSort(arr);
        Arrays.sort(clone1);
        log.info("冒泡排序 equals :{}  {} ", Arrays.equals(arr, clone1), ArrayUtils.toString(arr));


        insertSort(clone2);
        log.info("插入排序 equals :{}  {} ", Arrays.equals(arr, clone2), ArrayUtils.toString(arr));


        mergeSort(clone3,0,clone3.length-1);
        Arrays.sort(clone);
        log.info("merge排序 equals :{}  {} ", Arrays.equals(clone, clone2), ArrayUtils.toString(arr));


    }


    public static int[] generateRandInt(int count) {
        int[] ints = new int[count];
        for (int i = 0; i < ints.length; i++) {

            ints[i] = new Random().nextInt(count);
        }
        return ints;
    }


    public static int[] maoPaoSort(int[] arr) {

        if (null == arr || arr.length < 2) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }


    public static int[] insertSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            // 1-n次
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }

        return arr;
    }


    /***
     * @see {https://blog.csdn.net/sementicweb/article/details/82256469}
     */
    // tail
    private static void mergeSort(int[] arr, int l, int r) {

        log.debug(">> arr={} l={},r={}",Arrays.copyOfRange(arr,l,r+1),l,r);
        if (arr.length < 2) {
            return;
        }
        if (l >= r) {
            return;
        }
        int m = (l - r >> 1) + r;

        log.debug("merge left before  arr={} l={},r={}",Arrays.copyOfRange(arr,l,m+1),l,m);

        mergeSort(arr, l, m);

        log.debug("merge right before  arr={} l={},r={}",Arrays.copyOfRange(arr,m+1,r+1),m+1,r);

        mergeSort(arr, m+1, r); // +1


        merge(arr,l,m,r);
        log.debug("merge all after  arr={} l={},r={} \n",Arrays.copyOfRange(arr,l,r+1),l,r);


    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] tmp=new int[r-l+1];

        int lp=l;
        int rp=m+1;
        int i=0;

        while (lp<=m && rp<=r){
            if (arr[lp]<arr[rp]){
                tmp[i++]=arr[lp++];
            }else {
                tmp[i++]=arr[rp++];
            }
        }

        while (lp<=m){
            tmp[i++]=arr[lp++];
        }

        while (rp<=r){
            tmp[i++]=arr[rp++];
        }

        for (int j = 0; j < tmp.length; j++) {
            arr[l+j]=tmp[j];
        }

    }

    public static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[j] ^ a[i];
    }
}
