package com.yzq.java8;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/10/12 20:47
 * @modified By:
 */
@FunctionalInterface
interface Supplier<T> {
    T get();
}

class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
     static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

     static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

     void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

     void repair() {
        System.out.println("Repaired " + this.toString());
    }
}

 class MethodReferenceTest {


    @Test
     void methodReference1() {
        /*
          构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
         */
        final Car car = Car.create(Car::new);
        final List<Car> cars = List.of(car);
        //静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach(Car::collide);
        //特定类的任意对象的方法引用：它的语法是Class::method实例如下：

        cars.forEach(Car::repair);
        //特定对象的方法引用：它的语法是instance::method实例如下：

        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}
