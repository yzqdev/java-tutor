package com.yzq.java17down;

import org.junit.jupiter.api.Test;

/**
 * <pre>
 *     public class Range {
 *
 *     private final int min;
 *     private final int max;
 *
 *     public Range(int min, int max) {
 *         this.min = min;
 *         this.max = max;
 *     }
 *
 *     public int getMin() {
 *         return min;
 *     }
 *
 *     public int getMax() {
 *         return max;
 *     }
 *
 *     public boolean equals(Object o) {
 *         if (this == o) return true;
 *         if (o == null || getClass() != o.getClass()) return false;
 *         Range range = (Range) o;
 *         return min == range.min && max == range.max;
 *     }
 *
 *     public int hashCode() {
 *         return Objects.hash(min, max);
 *     }
 *
 *     public String toString() {
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

public class RecordType {
    @Test
    public void getRecord(){
        Range range=new Range(1,10);
        System.out.println(range);
        Tags tags=new Tags(1,20);
        System.out.println(tags);
    }
}
