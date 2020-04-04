package com.zdn.java8;

import java.util.Optional;

public class OptionalTest {

  public static void main(String[] args) {
    Optional<String> optional = Optional.ofNullable(null);
//    System.out.println("optional = " + optional.isPresent());
    optional.ifPresent(par -> {
      System.out.println("par = " + par);

    });
    System.out.println(optional.orElse("orElse"));

  }
}
