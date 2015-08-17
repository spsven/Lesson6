package com.homework._2015_03_18;

import java.util.Random;

/**
 * Created by Alexandr Kozlov on 19.03.2015.
 */
public class MoneyProducer implements Runnable {
    BankCard bankCard;

    public MoneyProducer(BankCard bankCard) {
        this.bankCard = bankCard;
    }


    @Override
    public void run() {
        while (!ATMService.isStopped) {
            if (bankCard.getBalance() < 0 || bankCard.getBalance() > 1000) {

                bankCard.validateBankCardBalance();
                Thread.currentThread().interrupt();

            } else {
                Random random = new Random();
                //The amount of the deposit
                int temp = Integer.parseInt(String.valueOf(random.nextInt(10) + 5));
                // time to sleep
                int timeToSleep = Integer.parseInt(String.valueOf(random.nextInt(3) + 2));

                bankCard.deposit(temp);

                try {
                    Thread.sleep(timeToSleep * 1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
