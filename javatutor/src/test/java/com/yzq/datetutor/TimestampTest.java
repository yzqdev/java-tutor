package com.yzq.datetutor;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author yanni
 * @date time 2022/1/21 21:39
 * @modified By:
 */
 class TimestampTest {
    @Test
     void timestampToLocal() {

        Timestamp time = Timestamp.from(Instant.now());
        LocalDateTime localDateTime = time.toLocalDateTime();
        System.out.println(localDateTime);
    }
    @Test
     void timestampToLocalDateTime(){
        long timestamp = System.currentTimeMillis();
        LocalDate localDate = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        LocalDateTime localDateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }
    @Test
     void localDateTimeToTimestamp() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Timestamp time = Timestamp.valueOf(LocalDateTime.now().format(dtf));
        System.out.println(time);

    }

    @Test
     void localDateToDate() {
        LocalDate nowLocalDate = LocalDate.now();
        Date date = Date.from(nowLocalDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
        System.out.println(date);
    }

    @Test
     void LocalTimeToDate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
         Date date = Date.from(instant);
    }
    @Test
     void localDateToTimestamp(){
        LocalDate localDate = LocalDate.now();
        long timestamp = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

}
