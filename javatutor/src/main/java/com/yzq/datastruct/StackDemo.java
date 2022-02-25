package com.yzq.datastruct;

import java.util.EmptyStackException;
import java.util.Stack;
 
public class StackDemo {
    /**
     * 栈是Vector的一个子类，它实现了一个标准的后进先出的栈。
     * @param st
     * @param a
     */
    static void showpush(Stack<Integer> st, int a) {
        st.push(a);
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }
 
    static void showpop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }
 
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        System.out.println("stack: " + st);
        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
        showpop(st);
        showpop(st);
        showpop(st);
        try {
            showpop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }
}