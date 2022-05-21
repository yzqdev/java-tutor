package com.yzq.collection;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Double.parseDouble;

/**
 * 这个类演示了文档注释
 *
 * @author Ayan Amhed
 * @version 1.2
 */
 class SquareNumTest {
    /**
     * This method returns the square of num.
     * This is a multiline description. You can use
     * as many lines as you like.
     *
     * @param num The value to be squared.
     * @return num squared.
     */
     double square(double num) {
        return num * num;
    }

    /**
     * This method inputs a number from the user.
     *
     * @return The value input as a double.
     * @throws IOException On input error.
     * @see IOException
     */
     double getNumber() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader inData = new BufferedReader(isr);
        String str;
        str = inData.readLine();
        return parseDouble(str);
    }

    /**
     * This method demonstrates square().
     *
     * @return Nothing.
     * @throws IOException On input error.
     * @see IOException
     */
    @Test
     void mainMethod() throws IOException {
        SquareNumTest ob = new SquareNumTest();
        double val;
        System.out.println("Enter value to be squared: ");
        val = ob.getNumber();
        val = ob.square(val);
        System.out.println("Squared value is " + val);
    }
}