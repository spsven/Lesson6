package com.homework._2015_03_18;

/**
 * Created by Alexnadr Kozlov on 19.03.2015.
 */
public class ATMService {

    public static volatile boolean isStopped;

    public static void main(String[] args) throws InterruptedException {

        BankCard bankCard = new BankCard(500);

        MoneyConsumer moneyConsumer = new MoneyConsumer(bankCard);
        MoneyProducer moneyProducer = new MoneyProducer(bankCard);

        // the creation of new threads
        Thread moneyProducerAtm = new Thread(moneyProducer);
        Thread moneyConsumerAtm = new Thread(moneyConsumer);
        Thread moneyProducerAtm1 = new Thread(moneyProducer);
        Thread moneyConsumerAtm1 = new Thread(moneyConsumer);
        Thread moneyProducerAtm2 = new Thread(moneyProducer);
        Thread moneyConsumerAtm2 = new Thread(moneyConsumer);
        Thread moneyProducerAtm3 = new Thread(moneyProducer);
        Thread moneyConsumerAtm3 = new Thread(moneyConsumer);

        // start threads
        moneyConsumerAtm.start();
        moneyProducerAtm.start();
        moneyConsumerAtm1.start();
        moneyProducerAtm1.start();
        moneyConsumerAtm2.start();
        moneyProducerAtm2.start();
        moneyConsumerAtm3.start();
        moneyProducerAtm3.start();

    }
}
