package com.zdn.algorithm;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 有序数组的二分查找
     *
     * @return 返回目标值的下标
     */
    public static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            // 获取中位数
            int mid = start + (end - start) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target > array[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i;
        }
        System.out.println("target_index: " + binarySearch(array, 220));
    }
}
