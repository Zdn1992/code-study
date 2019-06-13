package com.zdn.java8;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * from JavaGuide
 */
public class DateApi {

    public static void main(String[] args) {
        /*Clock 类提供了访问当前日期和时间的方法，Clock 是时区敏感的，
        可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。
        某一个特定的时间点也可以使用 Instant 类来表示，Instant 类也
        可以用来创建旧版本的java.util.Date 对象。*/
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        Instant instant = clock.instant();
        System.out.println(instant);
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);


        /*Timezones 在新API中时区使用 ZoneId 来表示。时区可以很方便的使用
        静态方法of来获取到。 抽象类ZoneId（在java.time包中）表示一个区域
        标识符。 它有一个名为getAvailableZoneIds的静态方法，它返回所有区域
        标识符。*/

        //输出所有区域标识符
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        /*LocalTime 定义了一个没有时区信息的时间，例如 晚上10点或者 17:30:15。
        下面的例子使用前面代码创建的时区创建了两个本地时间。之后比较时间并以小时
        和分钟为单位计算两个时间的时间差：*/
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));  // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);       // -3
        System.out.println(minutesBetween);

        // LocalTime 提供了多种工厂方法来简化对象的创建，包括解析时间字符串.
        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);       // 23:59:59
        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);   // 13:37
    }
}
