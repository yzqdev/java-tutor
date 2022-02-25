package com.yzq.tutor.exceptiontest;// 文件名称 CheckingAccount.java

//此类模拟银行账户
public class CheckingAccount {
    //balance为余额，number为卡号
    private double balance;
    /**
     * 数量
     */
    private int number;

    public CheckingAccount(int number) {
        this.number = number;
    }

    /**
     *   方法：存钱
     */

    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * 方法：取钱
     * @param amount
     * @throws InsufficientFundsException
     */
    public void withdraw(double amount) throws
            InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            double needs = amount - balance;
            throw new InsufficientFundsException(needs);
        }
    }

    /**
     * 方法：返回余额
     * @return
     */
    public double getBalance() {
        return balance;
    }

    //方法：返回卡号
    public int getNumber() {
        return number;
    }
}