package com.dy.thread;


public class Printer {
    private volatile boolean isOdd;

    synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = false;
        notify();
    }

    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notify();
    }
    
    public static void main(String... args) {
        Printer print = new Printer();
        Thread oddThread = new Thread(new TaskEvenOdd(print, 10, false),"Odd");
        Thread evenThread = new Thread(new TaskEvenOdd(print, 10, true),"Even");
        evenThread.start();
        oddThread.start();
    }
}

class TaskEvenOdd implements Runnable {
    private int max;
    private Printer print;
    private boolean isEvenNumber;

    // standard constructors

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }

	public TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
		super();
		this.max = max;
		this.print = print;
		this.isEvenNumber = isEvenNumber;
	}
}
