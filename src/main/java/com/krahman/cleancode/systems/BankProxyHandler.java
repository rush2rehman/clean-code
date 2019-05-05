package com.krahman.cleancode.systems;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BankProxyHandler implements InvocationHandler {

    private Bank bank;

    public BankProxyHandler(BankImpl bankImpl){
        this.bank = bankImpl;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if(methodName.equals("getAccounts")){
            bank.setAccouts(getAccountsFromDatabase());
            return bank.getAccounts();
        }
        else if(methodName.equals("setAccounts")){
            bank.setAccouts((Collection<Account>)args[0]);
            setAccountToDataBase(bank.getAccounts());
            return null;
        }
        else{
            return null;
        }
    }

    private void setAccountToDataBase(Collection<Account> accounts) {

    }

    private Collection<Account> getAccountsFromDatabase() {
        List<Account> list = new ArrayList<>();
        list.add(new Account());
        return list;
    }

}
