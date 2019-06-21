package com.zdn.algorithm;

/**
 * @author zdn
 * @version 1.0
 * @description: 直接插入排序
 * @createDate 2019/6/21
 */
public class InsertSort {


    /**
     * 交换次数较多的排序 从小到大
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                // 未排序的元素和上一个已排序的元素比较,如果比它大,直接退出循环
                // 未排序元素arr[j] 已排序的元素arr[j - 1]
                if (arr[j - 1] <= arr[j]) {
                    break;
                }
                // 交换顺序
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    /**
     * 插入排序 另一个版本 更好记忆
     * 1. 从第一个元素开始，该元素可以认为已经被排序
     * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5. 将新元素插入到该位置后
     * 6. 重复步骤2~5
     *
     * @param arr 待排序数组
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            // 取出下一个元素，在已经排序的元素序列中从后向前扫描
            int temp = arr[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && arr[j - 1] > temp) {
                    // 就把j-1号位的元素往后移一个位置
                    arr[j] = arr[j - 1];
                }else {
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{32, 43, 5, 6, 82, 9, 8, 33, 4, 65, 42, 23, 2};
//        insertSort(arr);
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
