package com.zdn.java8.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class StreamTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");

        stringList
                .stream()
                // filter 中间操作 返回一个stream对象
                .filter((s) -> s.startsWith("a"))
                // forEach 是为 Lambda 而设计的，保持了最紧凑的风格,是一个最终操作
                .forEach((s) -> log.info("s:{}", s));

        stringList
                .stream()
                // 映射,中间操作 map 会将元素根据指定的 Function 接口来依次将元素转成另外的对象。
                .map(String::toUpperCase)
                // 排序,中间操作
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        boolean allStartForA = stringList
                .stream()
//                .filter((s -> s.startsWith("a")))
                // Match(匹配) 所有的匹配操作都是 最终操作,并返回一个 boolean 类型的值。
                .allMatch((s) -> s.startsWith("a"));
        log.info("allStartForA:{}",allStartForA);


        long count = stringList
                .stream()
                .filter((s) -> s.contains("a"))
                // 计数是一个 最终操作，返回Stream中元素的个数，返回值类型是 long。
                .count();
        log.info("count:{}",count);



    }
}
