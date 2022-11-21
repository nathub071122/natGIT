package com.day1;
//**Inside the synchronize block, if the buffer is full here, then we are going to park this thread, releasing the lock. So lock. wait here. This wait method throws an interrupted exception so let us catch it like this. And once we've added some data in our buffer, we need to notify the threads that are waiting by calling the notify method. And we are going to do the same for the consumer so instead of a while here, we are executing an if. If the buffer is empty, then I need to wait for a producer to add some data in it. Let us handle the exception properly and notify once we have consumed a data. Let us run this code again and this time, the data left in the buffer is indeed zero, which shows that our system is working properly. We can modify it a little by, for instance, consuming only 45 items. Let us run it again. Indeed, there are five items left in the buffer, which is the expected result.**
public class ProducerConsumer {
    private static Object lock = new Object();
    private static int[] buffer;
    private static int count;
    static class Producer {
        void produce() {
            synchronized (lock) {
                if (isFull(buffer)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[count++] = 1;
                lock.notify();
            }
        }
    }
    static class Consumer {
        void consume() {
            synchronized (lock) {
                if (isEmpty(buffer)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[--count] = 0;
                lock.notify();
            }
        }
    }
    static boolean isEmpty(int[] buffer) {
        return count == 0;
    }
    static boolean isFull(int[] buffer) {
        return count == buffer.length;
    }
//    The "Three Dots" in java is called the Variable Arguments or varargs. It allows the method to accept zero or multiple arguments. Varargs are very helpful if you don't know how many arguments you will have to pass in the method
    public static void main(String... strings) throws InterruptedException {
        buffer = new int[10];
        count = 0;
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Runnable produceTask = () -> {
            for (int i = 0; i < 50; i++) {
                producer.produce();
            }
            System.out.println("Done producing");
        };
        Runnable consumeTask = () -> {
            for (int i = 0; i < 45; i++) {
                consumer.consume();
            }
            System.out.println("Done consuming");
        };
        Thread consumerThread = new Thread(consumeTask);
        Thread producerThread = new Thread(produceTask);
        consumerThread.start();
        producerThread.start();
        consumerThread.join();
        producerThread.join();
        System.out.println("Data in the buffer: " + count);
    }
}
