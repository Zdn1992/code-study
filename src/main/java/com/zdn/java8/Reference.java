package com.zdn.java8;

import com.zdn.java8.function.Converter;
import lombok.extern.slf4j.Slf4j;

/**
 * java8方法和构造函数引用
 */
@Slf4j
public class Reference {

    public static void main(String[] args) {
        // Java 8允许您通过::关键字传递方法或构造函数的引用
        // 静态方法的使用
        Converter<String,Integer> converter = Integer::parseInt;
        log.info("::关键字,静态方法的使用->{}",converter.convert("9527"));
        // 实例方法的使用
        InstantMethod instant = new InstantMethod();
        Converter<String,String> strConverter = instant::startWith;
        log.info("::关键字,实例方法的使用->{}",strConverter.convert("Os"));
    }

}

class InstantMethod{

    public String startWith(String str){
        if (str == null){
            str = "null";
        }
        return String.valueOf(str.charAt(0));
    }
}

class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}