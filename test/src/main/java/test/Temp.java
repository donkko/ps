package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Temp {
    public static void main(String[] args) {
    }
}

class Foo {
    private AtomicInteger printed = new AtomicInteger(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (printed.get() != 1) {
            if (printed.get() == 0) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                printed.set(1);
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (printed.get() != 2) {
            if (printed.get() == 1) {
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                printed.set(2);
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (printed.get() != 3) {
            if (printed.get() == 2) {
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                printed.set(3);
            }
        }
    }
}