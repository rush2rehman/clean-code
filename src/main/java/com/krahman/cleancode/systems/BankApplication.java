package com.krahman.cleancode.systems;

import java.lang.reflect.Proxy;

public class BankApplication {
    public static void main(String[] s)
    {
        Bank bank = (Bank) Proxy.newProxyInstance(
                Bank.class.getClassLoader(),
                new Class[]{Bank.class},
                new BankProxyHandler(new BankImpl())
        );
        System.out.println(bank.getAccounts());
    }
}
