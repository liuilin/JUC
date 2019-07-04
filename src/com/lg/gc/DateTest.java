package com.lg.gc;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * java8 Date类测试
 *
 * @author Daniel Liu 2019/6/22 8:32
 */
public class DateTest {
    public static void main(String[] args) {

        /*//查看当前的时区
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println(defaultZone); //Asia/Shanghai

        //查看美国纽约当前的时间
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime shanghaiTime = LocalDateTime.now();
        LocalDateTime americaDateTime = LocalDateTime.now(america);
        System.out.println(shanghaiTime); //2016-11-06T15:20:27.996
        System.out.println(americaDateTime); //2016-11-06T02:20:27.996 ，可以看到美国与北京时间差了13小时

        //带有时区的时间
        ZonedDateTime americaZoneDateTime = ZonedDateTime.now(america);
        System.out.println(americaZoneDateTime); //2016-11-06T02:23:44.863-05:00[America/New_York]*/

        String specifyDate = "20151011";
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate formatted = LocalDate.parse(specifyDate, formatter);
        System.out.println(formatted);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY/MM/dd hh:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));



        //Date与Instant的相互转化
        Instant instant = Instant.now();
        Date date = Date.from(instant);
        Instant instant2 = date.toInstant();
        System.out.println(instant2);

        //Date转为LocalDateTime
        Date date2 = new Date();
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(date2.toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime2);

        //LocalDateTime转Date
        LocalDateTime localDateTime3 = LocalDateTime.now();
        Instant instant3 = localDateTime3.atZone(ZoneId.systemDefault()).toInstant();
        Date date3 = Date.from(instant);
        System.out.println(date3);

        //LocalDate转Date
        //因为LocalDate不包含时间，所以转Date时，会默认转为当天的起始时间，00:00:00
        LocalDate localDate4 = LocalDate.now();
        Instant instant4 = localDate4.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date date4 = Date.from(instant);
        System.out.println(date4);

    }


}