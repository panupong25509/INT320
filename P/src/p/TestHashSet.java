/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author INT303
 */
public class TestHashSet {

    public static void main(String[] args) {
        testHashCode();
//        Set<String> set = new HashSet();
//        set.add("Cat");
//        set.add("Cat");
//        set.add("Cat");
//        set.add("Cat");
//        set.add("Cat");
//        set.add("Cat");
//        set.add("Cat");
//        System.out.println(set);
//        System.out.println("Cat".hashCode());
//        System.out.println("Cau".hashCode());
//        System.out.println("Cav".hashCode());
//        System.out.println("set has Cat? \n"+(set.contains("Cat")?"Yes":"No"));
    }

    public static void testHashCode() {
        Set<BankAccount> baSet = new HashSet();
        baSet.add(new BankAccount(6070, "Panupong", 30000));
        baSet.add(new BankAccount(6071, "Panu", 300));
        baSet.add(new BankAccount(6072, "Pong", 5000));
        baSet.add(new BankAccount(6073, "Panong", 10000));
        baSet.add(new BankAccount(6074, "Anupong", 25000));
        
        BankAccount ba1 = new BankAccount(6071, "Panu", 3700);
        BankAccount ba2 = new BankAccount(6073, "Panong", 10000);
        
        System.out.println(baSet);
        System.out.println(baSet.contains(ba1));
        System.out.println(baSet.contains(ba2));
    }
    

}

class BankAccount{

    private int accountId;
    private String name;
    private double balance;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.accountId;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankAccount other = (BankAccount) obj;
        return true;
    }

    public BankAccount(int accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "accountId=" + accountId + ", name=" + name + ", balance=" + balance + '}';
    }

}
