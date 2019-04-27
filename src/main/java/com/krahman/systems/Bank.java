package com.krahman.systems;

import java.util.Collection;

public interface Bank {
    Collection<Account> getAccounts();
    void setAccouts(Collection<Account> accounts);
}
