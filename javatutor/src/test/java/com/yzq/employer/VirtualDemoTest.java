package com.yzq.employer;

import org.junit.jupiter.api.Test;

/**
 * 虚拟演示
 *
 * @author yanni
 * @date 2022/01/06
 */
  class VirtualDemoTest {
   @Test
  void testExtend(){
      Salary s = new Salary("员工 A", "北京", 3, 3600.00);
      //上转型
      Employee e = new Salary("员工 B", "上海", 2, 2400.00);
      System.out.println("使用 Salary 的引用调用 mailCheck -- ");
      s.mailCheck();
      System.out.println("\n使用 Employee 的引用调用 mailCheck--");
      e.mailCheck();
    }
}