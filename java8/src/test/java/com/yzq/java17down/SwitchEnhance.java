package com.yzq.java17down;

import org.junit.jupiter.api.Test;

/**
 * @author yanni
 * @date time 2021/10/12 22:03
 * @modified By:
 */
enum WeekEnum {
    /**
     * 周一、周二……以此类推
     */
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

 class SwitchEnhance {
@Test
     void newSwitch(){
    WeekEnum weekDay = WeekEnum.SUNDAY;
    switch (weekDay) {
        case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("工作日");
        case SATURDAY, SUNDAY -> System.out.println("节假日");
        default -> System.out.println("参数错误");
    }
}
}
