package com.homework._2015_03_18;


/**
 * Created by Alexandr Kozlov on 19.03.2015.
 */
public class BankCard {
    private volatile int balance;

    /**
     * Set the starting balance
     * @param startBalance
     */
    public BankCard(int startBalance) {
        balance = startBalance;
    }

    /**
     * Returns the balance of the card
     * @return balance
     */
    public int getBalance(){
        return balance;
    }

    /**
     * Operation withdraw money from the card
     * @param withdraw
     */
    public void withdraw (int withdraw) {

        this.balance = this.balance - withdraw;
        System.out.println("Withdraw $ " + withdraw + ", on bank card $ " + this.getBalance() + ".");
    }

    /**
     * Operation deposit money from the card
     * @param deposit
     */
    public void deposit (int deposit) {

        this.balance = this.balance + deposit;
        System.out.println("Deposit $ " + deposit + ", on bank card $ " + this.getBalance() + ".");
    }

    /**
     * Check balance on the boundary conditions.
     */
    public void validateBankCardBalance(){
        ATMService.isStopped = true;
        if (ATMService.isStopped) {
            if (this.getBalance() < 0) {
                System.out.println("Don't have enough money to withdraw. " +
                        "The balance went into overdraft $ " + this.getBalance() + ".");
            }
            if (this.getBalance() > 1000) {
                System.out.println("Too much money on bank card." +
                        " Balance on a credit card is $ " + this.getBalance() + ".");
            }
        }
    }

}
