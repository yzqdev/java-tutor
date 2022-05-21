package com.yzq.java17down;

import org.junit.jupiter.api.Test;

/**
 * <pre>
 *      class Range {
 *
 *     private final int min;
 *     private final int max;
 *
 *      Range(int min, int max) {
 *         this.min = min;
 *         this.max = max;
 *     }
 *
 *      int getMin() {
 *         return min;
 *     }
 *
 *      int getMax() {
 *         return max;
 *     }
 *
 *      boolean equals(Object o) {
 *         if (this == o) return true;
 *         if (o == null || getClass() != o.getClass()) return false;
 *         Range range = (Range) o;
 *         return min == range.min && max == range.max;
 *     }
 *
 *      int hashCode() {
 *         return Objects.hash(min, max);
 *     }
 *
 *      String toString() {
 *         return "Range{" +
 *           "min=" + min +
 *           ", max=" + max +
 *           '}';
 *     }
 * }
 * </pre>
 * @see java.lang.Record
 * @author yanni
 * @date time 2021/10/12 22:09
 * @modified By:
 * @since jdk16
 */
class Tags {
    Tags(int min,int max){

    }

    @Override
    public String toString() {
        return "Tags{}";
    }
}

record Range(int min, int max) {
}

 class RecordTypeTest {
    @Test
     void getRecord(){
        Range range=new Range(1,10);
        System.out.println(range);
        Tags tags=new Tags(1,20);
        System.out.println(tags);
    }
}
