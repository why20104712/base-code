package com.example.java.date;

import org.junit.Test;

import java.time.*;
import java.util.Date;

public class LocalDateTimeTest {


    @Test
    public void test1() {

        LocalDateTime localDateTime = LocalDateTime.now();

        localDateTime = LocalDateTime.of(2018, 7, 20, 23, 29, 29);

        //2018-07-23T18:10:04.081
        System.out.println(localDateTime);
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
        System.out.println(localDateTime.getNano());

        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());

        System.out.println(localDateTime.toEpochSecond(ZoneOffset.UTC));


        System.out.println(localDateTime.plusYears(1));
        System.out.println(localDateTime.plusMonths(2));
        System.out.println(localDateTime.plusDays(3));
        System.out.println(localDateTime.plusHours(4));
        System.out.println(localDateTime.plusMinutes(5));
        System.out.println(localDateTime.plusSeconds(6));
        System.out.println(localDateTime.plusNanos(7));
        System.out.println(localDateTime.plusWeeks(8));

        System.out.println(localDateTime.minusYears(1));
        System.out.println(localDateTime.minusMonths(2));
        System.out.println(localDateTime.minusDays(3));
        System.out.println(localDateTime.minusHours(4));
        System.out.println(localDateTime.minusMinutes(5));
        System.out.println(localDateTime.minusSeconds(6));
        System.out.println(localDateTime.minusNanos(7));
        System.out.println(localDateTime.minusWeeks(8));


    }

    @Test
    public void test2() {
        Instant instant = Instant.now();
        //2018-07-23T10:09:14.857Z
        System.out.println(instant);
        //秒值
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());
        //毫秒值
        System.out.println(instant.toEpochMilli());
        System.out.println(System.currentTimeMillis());
        System.out.println(instant.plusSeconds(1));
        System.out.println(instant.plusMillis(2));
        System.out.println(instant.plusNanos(3));
    }

    @Test
    public void test3() throws InterruptedException {

        Instant instant1 = Instant.now();
        Thread.sleep(1000);
        Instant instant2 = Instant.now();

        Duration duration = Duration.between(instant1, instant2);
        System.out.println(duration);
        System.out.println(duration.getSeconds());
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());
    }


    @Test
    public void test4() throws InterruptedException {

        LocalDate localDate1 = LocalDate.now();
        Thread.sleep(1000);
        LocalDate localDate2 = LocalDate.now();

        Period period = Period.between(localDate1, localDate2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(period.getChronology());
        System.out.println(period.getUnits());
    }

    /**
     * date转instant
     */
    @Test
    public void test5() {
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println(instant.toEpochMilli());
    }


    /**
     * date转localDate
     */
    @Test
    public void test6() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println(localDate.toString());
        System.out.println(date);
    }


    /**
     * localDate转date
     */
    @Test
    public void test7() {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zonedDateTime.toInstant());
        System.out.println(date);
        System.out.println(new Date());
    }



    /**
     * date转localDateTime
     */
    @Test
    public void test8() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        System.out.println(localDateTime.toString());
        System.out.println(date);
    }

    /**
     * localDateTime转date
     */
    @Test
    public void test9() {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        Date date = Date.from(zonedDateTime.toInstant());
        System.out.println(date);
        System.out.println(new Date());
    }



}
