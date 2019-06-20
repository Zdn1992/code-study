package com.zdn.algorithm;

/**
 * @author zdn
 * @version 1.0
 * @description: 快速排序的基本思想：挖坑填数+分治法。
 * @createDate 2019/6/19
 */
public class QuickSort {

    /**
     * 从小到大排序
     *
     * @param arr 需要排序的数组
     * @param low 开始时最左边的索引=0
     * @param high 开始时最右边的索引=arr.length-1
     */
    public static void quickSort(int[] arr, int low, int high) {
        // i,j为左右哨兵.temp为基准.y,z为临时变量
        int i, j, temp, y, z;
        if (low > high) {
            return;
        }
        // 左边哨兵的索引
        i = low;
        // 右边哨兵的索引
        j = high;
        // 设置基准temp 以最左边为  基准位
        temp = arr[low];
        while (i < j) {
            // 从右向左
            /*先从右往左找一个小于 基准位的数
            #当右边的哨兵位置所在的数>基准位的数 时
            #继续从右往左找（同时 j 索引-1）
            #找到后会跳出 while循环*/
            while (temp <= arr[j] && i < j) {
                j--;
            }

            // 在从左向右
            while (temp >= arr[i] && i < j) {
                i++;
            }

            if (i < j) {
                y = arr[i];
                z = arr[j];
                // 左右哨兵 交换数据（互相持有对方的数据）
                arr[i] = z;
                arr[j] = y;
            }
        }

        // 退出循环了,说明i=j,交换基准的位置
        arr[low] = arr[i];
        arr[i] = temp;

        // 递归查找左右两数组
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{21, 34, 67, 7, 898, 6, 3, 42, 65, 89};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    // from https://blog.csdn.net/u014241071/article/details/81565148
}
