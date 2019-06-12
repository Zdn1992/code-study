package com.zdn.java8.lambda;

import com.zdn.java8.function.Converter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * lambdaTest
 */
@Slf4j
public class LambdaTest {

    public static void sort(){
        List<String> list = Arrays.asList("peter", "anna", "mike", "xenia");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        log.info(list.toString());
        list.sort(String::compareTo);
    }

    /**
     * 函数式接口Test
     * @param from
     * @return
     */
    protected static int parseStrToInt(int from){
        Converter<Integer,Integer> converter = (Integer p1) -> {
            if (p1%2 == 0){
                // 偶数
                p1 = p1 / 2;
            }else {
                p1 = p1 * 2;
            }
            return p1;
        };

        return converter.convert(from);
    }

    public static void main(String[] args) {
        // 函数式接口
        log.info("函数式接口计算:{}",parseStrToInt((int) (Math.random() * 100)));
    }
}
