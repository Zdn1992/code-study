package com.zdn.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zdn
 * @version 1.0
 * @description: 冒泡排序实现及口诀：n个数字来比较，外层循环N-1，内层循环N-1-i，两两相比大/小靠前。
 * @createDate 2019/6/18
 */
@Slf4j
public class BuddleSort {

    /**
     * 由小到大排序
     *
     * @param arr
     */
    private void smallToBig(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换顺序
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 由大到小排序
     * @param arr
     */
    private void bigToSmall(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BuddleSort buddleSort = new BuddleSort();
        int[] arr = new int[]{4345, 64, 576, 8, 5, 34, 98, 2, 457, 6};
        /*buddleSort.bigToSmall(arr);
        log.info("由大到小:{}",arr);*/
        buddleSort.smallToBig(arr);
        log.info("由小到大:{}", arr);
    }

    /*一个数组[50,40,30,20,10] 进行冒泡排序的推演过程

     第一层
      第1次比较   ( 50，40,)39,20,10
      第2次比较    40，(50,39,)20,10
      第3次比较  40，39,(50,20,)10
      第4次比较  40，39,20(,50,10)
      展现结果 40，39,20,10,(50)确定了50最大
            
      第二层
        第1次比较 (40，39,)20,10,50
        第2次比较  39，(40,20,)10,50
        第3次比较  39，20,(40，10,)50
        展现结果 39，20,10,(40,50)确定了2个
 
      第三层
         第1次比较(39，20,)10,40,50
         第2次比较 20，(39,10,)40，50
         展现结果 20,10,(39,40,50)确定了3个
 
      第四层
          第1次比较(20,10,)39,40,50
          展现结果10,(20,39,40,50)确定了4个，结束

      归纳:
      一、二、三、四、五为外层循环
     每一层中的比较为内层循环
     */

}
